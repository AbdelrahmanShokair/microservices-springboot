# Spring Boot Microservices Project 🚀

## Overview

This project is a collection of Spring Boot microservices designed to demonstrate how to integrate various technologies such as Grafana, Prometheus, Kafka, Keycloak, MySQL, and PostgreSQL. All components are containerized using Docker for easy setup and deployment.

## Table of Contents 📚

- [Technologies Used](#technologies-used) 🛠️
- [Getting Started](#getting-started) ⚡
- [Architecture](#architecture) 🏗️
- [Services](#services) 📦
- [Running the Project](#running-the-project) 🚀
- [Monitoring](#monitoring) 📊
- [Authentication](#authentication) 🔒
- [Database Setup](#database-setup) 🗄️
- [License](#license) 📜

## Technologies Used 🛠️

- **Spring Boot 3**: Framework for building microservices.
- **Prometheus**: Monitoring and alerting toolkit.
- **Grafana**: Data visualization and monitoring tool.
- **Apache Kafka**: Distributed event streaming platform.
- **Keycloak**: Open-source identity and access management.
- **MySQL**: Relational database management system.
- **PostgreSQL**: Advanced relational database management system.
- **Docker**: Container platform for running applications.

## Getting Started ⚡

## Architecture 🏗️

The architecture of the application is designed to be modular and scalable. It includes multiple microservices, each responsible for a specific domain or functionality. Below is a high-level overview of the architecture:

- **Microservices**:
    - Each microservice is built using Spring Boot and communicates with other services through **Apache Kafka**.
    - Services are designed to be independently deployable and scalable.

- **Databases**:
    - **MySQL** is used for transactional data.
    - **PostgreSQL** is used for analytical data and reporting.

- **Monitoring**:
    - **Prometheus** collects metrics from the microservices.
    - **Grafana** visualizes these metrics, providing insights into system performance.

- **Authentication**:
    - **Keycloak** handles user authentication and authorization for the microservices.

- **Containerization**:
    - All components are containerized using **Docker**, allowing for consistent deployment across environments.

## Services 📦

- **Service A**: Description of service A.
- **Service B**: Description of service B.
- **Service C**: Description of service C.

## Running the Project 🚀

### Build and Start Containers

You can run the entire stack using Docker Compose. Make sure you are in the root directory of the project and run:

```bash
docker-compose up --build
This command builds the images and starts the containers.

## Accessing Services 🌐

- **Service A**: [http://localhost:8081](http://localhost:8081) 🔗
- **Service B**: [http://localhost:8082](http://localhost:8082) 🔗
- **Service C**: [http://localhost:8083](http://localhost:8083) 🔗
- **Grafana**: [http://localhost:3000](http://localhost:3000) (Default login: `admin/admin`) 📈
- **Keycloak**: [http://localhost:8084](http://localhost:8084) (Default login: `admin/admin`) 🛡️

## Monitoring 📊

Prometheus is configured to scrape metrics from the microservices. Grafana can be used to visualize these metrics.

1. Open Grafana at `http://localhost:3000`.
2. Add a new data source for Prometheus (URL: `http://prometheus:9090`).
3. Create dashboards to visualize metrics from your microservices.

## Authentication 🔒

Keycloak is used for authentication and authorization. Follow these steps to set up Keycloak:

1. Access Keycloak at `http://localhost:8084`.
2. Create a new realm, client, and users as needed.
3. Configure your microservices to use Keycloak for authentication.

## Database Setup 🗄️

- **MySQL**: Configured to run on `localhost:3306`.
- **PostgreSQL**: Configured to run on `localhost:5432`.

Ensure the databases are initialized with the necessary schemas and data. You can find the SQL scripts in the `sql` directory.


### Prerequisites

- Docker and Docker Compose installed on your machine.

### Clone the Repository

```bash
git clone https://github.com/yourusername/microservices-project.git
cd microservices-project
