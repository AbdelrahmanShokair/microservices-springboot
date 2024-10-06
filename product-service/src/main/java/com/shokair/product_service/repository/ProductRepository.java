package com.shokair.product_service.repository;

import com.shokair.product_service.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.print.DocFlavor;

public interface ProductRepository extends MongoRepository<Product, String> {

}
