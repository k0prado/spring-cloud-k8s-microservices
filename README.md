# Spring Boot Microservices with Spring Cloud & Kubernetes 🚀

This repository was developed to consolidate and practically demonstrate the knowledge acquired in the Udemy course **"Java Spring Boot Microservices with Spring Cloud, K8s & Docker"**. The project focuses on decomposing a monolithic architecture and building a distributed, resilient, and highly scalable ecosystem.

## 🛠️ Technologies and Tools Used

* **Language & Framework:** Java 17+ / Spring Boot 3
* **Cloud Ecosystem:** Spring Cloud (Eureka Server, Spring Cloud Gateway, OpenFeign)
* **Resilience & Fault Tolerance:** Resilience4j (Circuit Breaker, Retry, Rate Limiter)
* **Databases:** PostgreSQL / MySQL (isolated instances per service)
* **Messaging (Optional/Async):** Apache Kafka / RabbitMQ
* **Containerization:** Docker & Docker Compose
* **Container Orchestration:** Kubernetes (K8s) using objects such as *Deployments*, *Services*, *ConfigMaps*, and *Secrets*.

## 🏗️ Project Architecture

The ecosystem is divided into the following infrastructure and business microservices components:

1.  **Service Discovery (Eureka Server):** Responsible for the dynamic registration and location of all microservice instances.
2.  **API Gateway:** The single entry point for the application, managing request routing, security, and load balancing.
3.  **Business Microservices:** Independent services encapsulating specific domain rules, communicating synchronously (via HTTP/OpenFeign) or asynchronously.
4.  **Centralized Configuration:** Secure management of environment variables separated from the application source code using Kubernetes *ConfigMaps*.

## 🐳 How to Run Locally

### Prerequisites
* JDK 17 or higher installed
* Maven 3.x+
* Docker Desktop with Kubernetes support enabled (or an active Minikube cluster)

### Step 1: Package the applications
Navigate to the root directory of each microservice and execute the command to build the project and generate the `.jar` package:
```bash
./mvnw clean package -DskipTests
