
# Spring Boot Microservices Demo

This repository contains a demo microservices project built using Spring Boot and Spring Cloud.
The project demonstrates core microservices concepts such as service discovery, API Gateway,
and shared libraries following industry-aligned practices.

The implementation is intentionally kept simple with one business microservice
to focus on architecture and fundamentals rather than business complexity.

---

## 🎯 Project Objective

The main goals of this project are to:

- Understand microservices architecture using Spring Boot
- Implement service discovery using Eureka Server
- Use API Gateway as a single entry point
- Share common code using a common library
- Follow clean, modular, and scalable project structure
- Build an interview-ready demo project

---

## 🧱 Architecture Overview

Client → API Gateway → User Service  
                     ↘  
                      Eureka Server  

---

## 🛠 Tech Stack

- Java
- Spring Boot
- Spring Cloud Netflix Eureka
- Spring Cloud Gateway
- Spring Data JPA
- Maven
- PostgreSQL
- Git & GitHub

---

## 📦 Project Modules

| Module Name   | Description |
|--------------|------------|
| eureka-server | Service discovery server |
| api-gateway  | Routes requests to microservices |
| user-service | Demo business microservice |
| common-lib   | Shared DTOs and utilities |

---

## 📚 Common Library

The common-lib module contains shared code such as:

- DTOs
- Utility classes
- Common response and exception models

This avoids duplication and keeps services clean.

---

## ⚙️ Configuration

- Each service has its own application.yml
- Local configuration only
- No Config Server (kept simple intentionally)

---

## ▶️ How to Run the Project

### Prerequisites

- Java 17+
- Maven
- PostgreSQL
- Git

---

### Startup Order

1. Eureka Server
2. API Gateway
3. User Service

---

### Run Command

From each service directory:

```bash
mvn spring-boot:run
```

---
##🧪 Design & Best Practices

- Layered architecture (Controller → Service → Repository)

- Clear separation of concerns

- Reusable shared library

- Service-to-service communication via Gateway

- Clean, readable, and interview-friendly codebase

---
##🚀 Future Enhancements

- Add Spring Cloud Config Server

- Add more business microservices

- Integrate Spring Security with JWT

- Dockerize all services (Docker & Docker Compose)

- Add centralized logging and monitoring

- Add API documentation using Swagger/OpenAPI


---

##👨‍💻 Author

###Rupesh Kumar
Backend Developer | Java | Spring Boot | Microservices
GitHub: https://github.com/iamrupeshkumar
