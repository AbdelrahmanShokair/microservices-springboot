# ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-Microservices-brightgreen?logo=springboot) Spring Boot Microservices Project

This project demonstrates a microservices architecture using Spring Boot 3, incorporating various tools and frameworks for monitoring, messaging, security, service discovery, tracing, and persistence. The setup includes Docker to containerize the entire system.

## Key Technologies

- ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3-green?logo=springboot) **Spring Boot 3**: Java framework for building production-ready applications.
- ![API Gateway](https://img.shields.io/badge/API%20Gateway-Routing-0088CC?logo=apigateway) **API Gateway**: Centralized entry point for managing and routing requests to different microservices.
- ![Grafana](https://img.shields.io/badge/Grafana-Monitoring-orange?logo=grafana) **Grafana**: Visualization and monitoring tool.
- ![Prometheus](https://img.shields.io/badge/Prometheus-Metrics-orange?logo=prometheus) **Prometheus**: Monitoring and alerting toolkit.
- ![Kafka](https://img.shields.io/badge/Apache%20Kafka-Messaging-000?logo=apachekafka) **Kafka**: Distributed messaging platform.
- ![Eureka](https://img.shields.io/badge/Eureka-Discovery%20Service-9cf?logo=spring) **Eureka**: Service registry for discovering microservices.
- ![Zipkin](https://img.shields.io/badge/Zipkin-Tracing-blue?logo=apache) **Zipkin**: Distributed tracing system.
- ![Keycloak](https://img.shields.io/badge/Keycloak-Identity%20%26%20Access-blue?logo=keycloak) **Keycloak**: Identity and access management for securing the microservices.
- ![MySQL](https://img.shields.io/badge/MySQL-Database-blue?logo=mysql) **MySQL**: Database used by Microservice 1.
- ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-4169E1?logo=postgresql) **PostgreSQL**: Database used by Microservice 2.
- ![MongoDB](https://img.shields.io/badge/MongoDB-NoSQL%20Database-green?logo=mongodb) **MongoDB**: Database used by Microservice 3.
- ![Docker](https://img.shields.io/badge/Docker-Containerization-blue?logo=docker) **Docker**: Containerization platform for running all the services.

---

## ![Architecture](https://img.shields.io/badge/Architecture-Overview-blue?logo=architecture) Architecture

This project consists of multiple microservices that interact with each other through REST APIs, API Gateway, and Kafka for asynchronous messaging. Each service is self-contained and uses Docker to manage its dependencies.

### Core Components:
- ![Eureka](https://img.shields.io/badge/Eureka-Discovery%20Service-9cf?logo=spring) **Eureka Server**: Service registry to manage service discovery.
- ![Spring Config](https://img.shields.io/badge/Spring%20Config-Configuration-6DB33F?logo=spring) **Config Server**: Centralized configuration management.
- ![API Gateway](https://img.shields.io/badge/API%20Gateway-Routing-0088CC?logo=apigateway) **API Gateway**: Centralized routing and access control to microservices.
- **Microservices**: Several services that interact with databases (MySQL/Postgres/MongoDB) and communicate using REST and Kafka.
- ![Kafka](https://img.shields.io/badge/Apache%20Kafka-Messaging-000?logo=apachekafka) **Kafka**: Handles messaging between services.
- ![Prometheus](https://img.shields.io/badge/Prometheus-Metrics-orange?logo=prometheus) & ![Grafana](https://img.shields.io/badge/Grafana-Monitoring-orange?logo=grafana) **Prometheus & Grafana**: Monitors metrics and visualizes data.
- ![Zipkin](https://img.shields.io/badge/Zipkin-Tracing-blue?logo=apache) **Zipkin**: Tracks distributed transactions.
- ![Keycloak](https://img.shields.io/badge/Keycloak-Identity%20%26%20Access-blue?logo=keycloak) **Keycloak**: Manages authentication and authorization.

---

## ![Setup](https://img.shields.io/badge/Setup-Instructions-yellow?logo=gear) Setup Instructions

### Prerequisites

- ![Docker](https://img.shields.io/badge/Docker-Containerization-blue?logo=docker) **Docker** and **Docker Compose** installed.
- ![Java 17](https://img.shields.io/badge/Java-17-orange?logo=java) **Java 17** (required for Spring Boot 3).
- ![Maven](https://img.shields.io/badge/Maven-Build%20Tool-C71A36?logo=apachemaven) **Maven** (or Gradle if your project uses it).

### Steps to Run the Project

1. **Clone the repository**:
    ```bash
    git clone https://github.com/your-repo/microservices-springboot3.git
    cd microservices-springboot3
    ```

2. **Build the services**:
    ```bash
    mvn clean install
    ```

3. **Run the project using Docker Compose**:
    ```bash
    docker-compose up --build
    ```

    This will start all the microservices, databases (MySQL, PostgreSQL, MongoDB), Eureka, Prometheus, Grafana, Kafka, Zipkin, Keycloak, and the API Gateway.

---

## ![Services](https://img.shields.io/badge/Services-Overview-lightgreen?logo=serverfault) Services Overview

| Service         | Port  | Description                             |
|-----------------|-------|-----------------------------------------|
| ![Eureka](https://img.shields.io/badge/Eureka-Discovery%20Service-9cf?logo=spring) Eureka Server   | 8761  | Service discovery server.               |
| ![Spring Config](https://img.shields.io/badge/Spring%20Config-Configuration-6DB33F?logo=spring) Config Server   | 8888  | Centralized configuration.              |
| ![API Gateway](https://img.shields.io/badge/API%20Gateway-Routing-0088CC?logo=apigateway) API Gateway   | 8080  | Centralized routing and access control. |
| ![Microservice](https://img.shields.io/badge/Microservice-1-blue) Microservice 1  | 8081  | Example microservice with MySQL.        |
| ![Microservice](https://img.shields.io/badge/Microservice-2-blue) Microservice 2  | 8082  | Example microservice with PostgreSQL.   |
| ![Microservice](https://img.shields.io/badge/Microservice-3-blue) Microservice 3  | 8083  | Example microservice with MongoDB.      |
| ![Kafka](https://img.shields.io/badge/Apache%20Kafka-Messaging-000?logo=apachekafka) Kafka           | 9092  | Messaging platform.                     |
| ![Zipkin](https://img.shields.io/badge/Zipkin-Tracing-blue?logo=apache) Zipkin          | 9411  | Distributed tracing tool.               |
| ![Prometheus](https://img.shields.io/badge/Prometheus-Metrics-orange?logo=prometheus) Prometheus      | 9090  | Metrics collection tool.                |
| ![Grafana](https://img.shields.io/badge/Grafana-Monitoring-orange?logo=grafana) Grafana         | 3000  | Visualization and monitoring dashboard. |
| ![Keycloak](https://img.shields.io/badge/Keycloak-Identity%20%26%20Access-blue?logo=keycloak) Keycloak        | 8080  | Identity and Access Management.         |

---

## ![Database](https://img.shields.io/badge/Database-Configuration-yellowgreen?logo=database) Database Configuration

### ![MySQL](https://img.shields.io/badge/MySQL-Database-blue?logo=mysql)
- Microservice 1 connects to MySQL.
- Connection URL: `jdbc:mysql://mysql:3306/db_microservice1`
- Configure username and password in `application.properties` or use the centralized config server.

### ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-4169E1?logo=postgresql)
- Microservice 2 connects to PostgreSQL.
- Connection URL: `jdbc:postgresql://postgres:5432/db_microservice2`
- Configure username and password similarly.

### ![MongoDB](https://img.shields.io/badge/MongoDB-NoSQL%20Database-green?logo=mongodb)
- Microservice 3 connects to MongoDB.
- Connection URL: `mongodb://mongo:27017/db_microservice3`
- MongoDB is used for storing NoSQL data and documents.
- Configure username and password in the `application.properties` file or centralized configuration.

---

## ![Security](https://img.shields.io/badge/Security-Keycloak-blue?logo=keycloak) Security (Keycloak)

Keycloak is used to secure microservices via OAuth2 and OpenID Connect. 

- Access the Keycloak admin console at `http://localhost:8080`.
- Default admin credentials: `admin/admin`.
- Create realms, clients, and roles to secure your microservices.

### Keycloak Configuration in Microservices

In each microservice's `application.properties`, configure the Keycloak server:
```properties
keycloak.auth-server-url=http://localhost:8080/auth
keycloak.realm=your-realm
keycloak.resource=your-client-id
keycloak.credentials.secret=your-client-secret
```
## Monitoring and Tracing

### Prometheus
- Access Prometheus at `http://localhost:9090`.
- Prometheus scrapes metrics from the microservices and provides a backend for time-series data.

### Grafana
- Access Grafana at `http://localhost:3000`.
- Add Prometheus as a data source and import pre-built dashboards to visualize metrics.

### Zipkin
- Access Zipkin at `http://localhost:9411`.
- Trace requests between microservices to diagnose latency issues or trace errors.

---

## Running with Docker

This project uses Docker Compose to simplify running all services.

### Docker Compose Commands:

- **Build and Start Services**:
    ```bash
    docker-compose up --build
    ```

- **Stop Services**:
    ```bash
    docker-compose down
    ```

- **Rebuild a Specific Service**:
    ```bash
    docker-compose up --build <service-name>
    ```

