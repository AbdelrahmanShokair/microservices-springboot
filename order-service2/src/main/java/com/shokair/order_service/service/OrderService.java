package com.shokair.order_service.service;

import com.shokair.order_service.dto.InventoryResponse;
import com.shokair.order_service.dto.OrderLineItemsDto;
import com.shokair.order_service.dto.OrderRequest;
import com.shokair.order_service.event.OrderPlacedEvent;
import com.shokair.order_service.model.Order;
import com.shokair.order_service.model.OrderLineItems;
import com.shokair.order_service.repository.OrderRepository;
import io.micrometer.tracing.Span;
import io.micrometer.tracing.Tracer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;
//    private final WebClient webClient;
    private final Tracer tracer;
    private final KafkaTemplate<String,OrderPlacedEvent> kafkaTemplate;
    public String placeOrder(OrderRequest orderRequest){
        log.info("Place Order Request Received : {}", orderRequest);
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();

        order.setOrderLineItemsList(orderLineItems);
        log.info("2");
        List<String> skuCodes = order.getOrderLineItemsList().stream()
                .map(OrderLineItems::getSkuCode)
                .toList();

        Span inventoryServiceLookup = tracer.nextSpan().name("InventoryServiceLookup");
        log.info("3");

        try (Tracer.SpanInScope spanInScope = tracer.withSpan(inventoryServiceLookup.start())){
            log.info("in try");

            inventoryServiceLookup.tag("call", "inventory-service");

            InventoryResponse[] inventoryResponsesArray = webClientBuilder.build().get()
                    .uri("http://inventory-service/api/inventory",
                            uriBuilder -> uriBuilder.queryParam("skuCode",skuCodes).build())
                    .retrieve()
                    .bodyToMono(InventoryResponse[].class)
                    .block();
            log.info("in try 2");

            boolean allProductsInStock = Arrays.stream(inventoryResponsesArray)
                    .allMatch(InventoryResponse::isInStock);
            log.info("in try 3");
            if (allProductsInStock){
                log.info("in IF");
                orderRepository.save(order);
                kafkaTemplate.send("notificationTopic",new OrderPlacedEvent(order.getOrderNumber()));
                return "Order Placed Successfully";
            }else {
                throw new IllegalArgumentException("product is not in stock, please try again later");
            }
        }finally {
            log.info("in finally");
            inventoryServiceLookup.end();
        }
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }
}
