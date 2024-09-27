# Microservice Architecture with Spring Boot and Netflix OSS

This project demonstrates the implementation of a microservices architecture using **Spring Boot**, **Netflix Eureka (Naming Server)**, **API Gateway**, and Docker for containerization. It is designed as a template to showcase microservices capabilities and the ability to manage communication between different services through service discovery and routing.

## Project Overview

The system consists of the following microservices:

1. **Currency Exchange Service**: A service that provides currency exchange rates between different currencies.
2. **Currency Conversion Service**: A service that consumes the exchange rates and calculates currency conversion based on a given amount.
3. **API Gateway**: The centralized entry point for routing requests to the appropriate microservices.
4. **Eureka Naming Server**: Used for service discovery, enabling each microservice to register and locate other services.

## Technologies

- **Spring Boot**: Used to create standalone microservices.
- **Netflix Eureka**: A naming server that handles service discovery.
- **Spring Cloud Gateway**: Provides routing and filtering capabilities to forward client requests to various services.
- **Docker**: For containerizing the microservices to ensure easy deployment and scaling.

## Services and Endpoints

### Currency Exchange Service

- URL: `http://localhost:8000/currency-exchange/from/{from}/to/{to}`  
  Example: [http://localhost:8000/currency-exchange/from/USD/to/INR](http://localhost:8000/currency-exchange/from/USD/to/INR)

### Currency Conversion Service

- URL: `http://localhost:8100/currency-conversion/from/{from}/to/{to}/quantity/{quantity}`  
  Example: [http://localhost:8100/currency-conversion/from/USD/to/INR/quantity/10](http://localhost:8100/currency-conversion/from/USD/to/INR/quantity/10)
- Feign Client: [http://localhost:8100/currency-conversion-feign/from/USD/to/INR/quantity/10](http://localhost:8100/currency-conversion-feign/from/USD/to/INR/quantity/10)

### Eureka (Naming Server)

- URL: [http://localhost:8761](http://localhost:8761)

### API Gateway

- Currency Exchange: [http://localhost:8765/currency-exchange/from/USD/to/INR](http://localhost:8765/currency-exchange/from/USD/to/INR)
- Currency Conversion:  
  [http://localhost:8765/currency-conversion/from/USD/to/INR/quantity/10](http://localhost:8765/currency-conversion/from/USD/to/INR/quantity/10)

## Docker Setup

To containerize and run the services, Docker images are used. Below are the essential commands:

### Build and Push Docker Images

```bash
docker push your-docker-repo/currency-exchange-service:latest
docker push your-docker-repo/currency-conversion-service:latestin
docker push your-docker-repo/naming-server:latest
docker push your-docker-repo/api-gateway:latest
```

### Running Services with Docker Compose

```bash
docker-compose up
```

## Conclusion

This template illustrates how to design and implement a microservice-based architecture with Spring Boot, Netflix Eureka, and API Gateway, while leveraging Docker for containerization. It can serve as a starting point for more complex microservice systems, enabling scalability and flexibility in service management.
