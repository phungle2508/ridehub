# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

RideHub is a **Spring Boot microservices-based ride-sharing platform** built with JHipster 8.11.0. It uses a polyglot microservices architecture with service discovery via Consul, OAuth2/OIDC authentication via Keycloak, and event-driven communication via Kafka.

## Architecture

### Microservices
- **gateway** (port 8080) - API Gateway with Angular 19 frontend, handles routing and external requests
- **ms_user** (port 8081) - User management and profiles
- **ms_route** (port 8082) - Pathfinding and route optimization with Elasticsearch
- **ms_booking** (port 8083) - Ride bookings and reservations
- **ms_promotion** (port 8084) - Marketing campaigns and promotions

### Git Submodules
Most components are Git submodules pointing to external repositories:
- `backend/gateway` -> https://github.com/maian3333/ridehub-gateway.git
- `backend/ms_user` -> https://github.com/maian3333/ridehub-ms-user.git
- `backend/ms_route` -> https://github.com/maian3333/ridehub-ms-route.git
- `backend/ms_booking` -> https://github.com/maian3333/ridehub-ms-booking.git
- `backend/ms_promotion` -> https://github.com/maian3333/ridehub-ms-promotion.git
- `infra/ridehub-central-common` -> https://github.com/maian3333/ridehub-central-common.git
- `infra/vps-infra` -> https://github.com/maian3333/vps-infra.git
- `infra/vps-microservices` -> https://github.com/maian3333/vps-microservices.git
- `spi/keycloak-custom-reg` -> https://github.com/maian3333/keycloak-custom-reg.git

When cloning this repo, use `git clone --recursive` or run `git submodule update --init --recursive`.

### Infrastructure Stack
- **Service Discovery**: Consul (http://localhost:8500)
- **Authentication**: Keycloak (http://localhost:9080)
- **Databases**: MySQL (one per microservice)
- **Caching**: Redis (one per microservice)
- **Message Broker**: Kafka
- **Search**: Elasticsearch (ms_route)
- **Monitoring**: Prometheus (http://localhost:9090), Grafana (http://localhost:3000)

## Development Commands

### Start All Services (Docker Compose)
```bash
cd backend/docker-compose
docker compose up -d
```

### Individual Service Development
```bash
# In any microservice directory (gateway, ms_user, etc.)
./mvnw                    # Build and run (dev mode)
./mvnw verify             # Run tests
./npmw start              # For gateway: start Angular dev server
./npmw test               # For gateway: run frontend tests
```

### Production Build
```bash
# Build production JAR
./mvnw -Pprod clean verify

# Build Docker image
npm run java:docker        # Gateway
./mvnw -Pprod jib:dockerBuild  # Microservices
```

### OpenAPI Code Generation

#### Per-Service (for internal API design)
```bash
./mvnw generate-sources    # Generate API client from swagger/api.yml
```

#### Shared Clients (ridehub-central-common)
Run this after modifying API endpoints in any microservice to regenerate all Feign clients:
```bash
cd infra/ridehub-central-common
mvn -Prun-openapi
```

This requires services to be running and registered in Consul.

## Key Configuration Files

- `backend/docker-compose/docker-compose.yml` - Main Docker Compose orchestration
- `backend/pom.xml` - Parent Maven POM
- `backend/gateway/package.json` - Frontend build scripts
- `.gitmodules` - Git submodule definitions
- `backend/docker-compose/central-server-config/` - Consul configuration
- `infra/ridehub-central-common/pom.xml` - Shared library with OpenAPI client generation

## Service Communication

Microservices communicate via:
1. **OpenFeign clients** - Synchronous HTTP communication (generated from OpenAPI specs)
2. **Kafka** - Asynchronous event messaging with Avro serialization

### ridehub-central-common Module

Located at `infra/ridehub-central-common/`, this is the shared library that provides:

- **Auto-generated Feign clients** for inter-service communication (ms_user, ms_booking, ms_route, ms_promotion)
- **Avro schemas** for Kafka message serialization
- **SSH tunneling support** for remote Consul connectivity
- **Feign customizations** for authentication and error handling

#### Generating Clients

The `run-openapi` Maven profile automates client generation:

```bash
cd infra/ridehub-central-common
mvn -Prun-openapi
```

This profile:
1. Fetches a Keycloak access token (`fetch-token.sh`)
2. Downloads OpenAPI specs from Consul-registered services (`consul-download-openapis.sh`)
3. Generates Feign clients using OpenAPI Generator 7.14.0 (`generate-clients.sh`)

Generated clients follow the structure:
```
com/ridehub/feign/{service-name}/
├── api/          # Feign client interfaces
├── model/        # DTOs and request/response models
└── invoker/      # Implementation classes
```

#### Using in Microservices

Add this dependency to your microservice's `pom.xml`:

```xml
<dependency>
    <groupId>com.ridehub.clients</groupId>
    <artifactId>client-open-feign-avro</artifactId>
    <version>1.0.0</version>
</dependency>
```

Then inject and use the Feign clients:

```java
@Autowired private MsUserClientApi msUserClient;
```

#### SSH Tunneling for Remote Consul

When connecting to a remote Consul instance (e.g., production VPS), the module provides automatic SSH tunneling via `ConsulSSHTunnel` and `ConsulSSHTunnelInitializer`. This overrides bootstrap properties to use `localhost:8500` which is tunneled to the remote server.

## OAuth2/OIDC Authentication

Keycloak is configured with:
- **Realm**: jhipster
- **Issuer URI**: http://localhost:9080/realms/jhipster
- **Client IDs**:
  - `web_app` - For gateway (frontend)
  - `internal` - For inter-service communication

## Code Structure

Each microservice follows JHipster conventions:
- `src/main/java/` - Spring Boot application code
- `src/main/resources/` - Configuration files
- `src/main/webapp/` - Frontend code (gateway only)
- `src/test/` - Unit and integration tests
- `.jhipster/` - JHipster entity configurations

## Testing

```bash
# Backend tests (any microservice)
./mvnw verify

# Frontend tests (gateway only)
./npmw test

# E2E tests
./npmw e2e
```

## Working with Submodules

```bash
# Update all submodules to latest remote
git submodule update --remote

# Pull changes in a specific submodule
cd backend/ms_route
git pull origin main

# Commit submodule updates from root
git add backend/ms_route
git commit -m "Update ms_route submodule"
```
