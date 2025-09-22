---
type: "agent_requested"
description: "ride hub central guideline"
---

# RideHub Development Rules

This document defines the architectural rules and development guidelines for the RideHub microservices platform based on `doc/ridehub.puml`.

## Architecture Overview

RideHub follows a microservices architecture with 4 core services:
- **ms-user**: Identity & Authentication
- **ms-route**: Address, Station, Route, Vehicle, Trip, Seat, Staff, SeatLock
- **ms-booking**: Booking, Ticket, Payment, Invoice, Pricing + Snapshots
- **ms-promotion**: Promotions & Conditions

## Core Architectural Rules

### 1. Database Per Service
- Each microservice owns its database exclusively
- No direct database access between services
- Cross-service data access only via APIs or events
- Use UUIDs as primary keys for all entities

### 2. Base Entity Pattern
All entities MUST extend BaseEntity with:
```
+id: UUID
+createdAt: Instant
+updatedAt: Instant
+isDeleted: boolean
+deletedAt: Instant
+deletedBy: UUID
```

### 3. Soft Delete Strategy
- All entities use soft delete (isDeleted flag)
- Default queries MUST filter `isDeleted = false`
- Physical deletion only for compliance/GDPR requirements
- Track deletion metadata (deletedAt, deletedBy)

### 4. Communication Patterns

#### Synchronous Communication
- API Gateway routes requests to appropriate services
- Use for real-time queries and immediate responses
- Authentication via Keycloak (OIDC/JWT) at `https://keycloak.appf4s.io.vn/`
- Custom Keycloak SPI for RideHub-specific authentication flows

#### Asynchronous Communication
- Single shared Kafka broker for all services
- Use for eventual consistency and decoupling
- Implement Outbox pattern for reliable event publishing

### 5. Caching Strategy
- Single shared Redis instance with namespaced keys:
  - `user:*` - ms-user cache
  - `route:*`, `seat:*` - ms-route cache
  - `booking:*`, `lock:*` - ms-booking cache
  - `promo:*` - ms-promotion cache

## Service-Specific Rules

### MS-USER Rules
- Handles authentication, user management, and profiles
- User types: Customer, Admin
- Profile data linked 1:1 with User
- Publishes UserUpdated events to Kafka

### MS-ROUTE Rules
- Manages Vietnam address hierarchy (Province → District → Ward → Address)
- Vehicle types: StandardBus, Limousine with pricing factors
- SeatMap structure: Vehicle → SeatMap → Floor(1-2) → Seat(≤18 per floor)
- **SeatLock is the source of truth for seat reservations**
- SeatLock rules:
  - Unique constraint on (tripId, seatNo) when status in {HELD, COMMITTED}
  - TTL via expiresAt with background cleanup
  - Idempotency via idempotencyKey
- Staff entities store operational data only (PII in ms-user)

### MS-BOOKING Rules
- Implements Saga pattern for booking flow
- Pricing snapshots prevent price drift after booking
- Promotion snapshots capture applied discounts
- Payment webhook idempotency via PaymentWebhookLog.payloadHash
- Booking states: DRAFT → AWAITING_PAYMENT → PAID → CONFIRMED

#### Booking Saga Flow
1. BookingCreated → ReserveSeats (ms-route)
2. SeatsReserved → proceed payment
3. PaymentSucceeded → ConfirmBooking + TicketIssued
4. PaymentFailed/Timeout → ReleaseSeats

### MS-PROMOTION Rules
- Flexible promotion system with policies and conditions
- Policy types: BuyNGetMFree, PercentOffTotal
- Condition types: ByRoute, ByDate, ByLocation
- Usage tracking with limits and counters

## Data Consistency Rules

### 1. Pricing Consistency
- Snapshot pricing at booking time to prevent drift
- Formula: `Trip.baseFare * Vehicle.typeFactor * Floor.priceFactorFloor * Seat.priceFactor`
- Apply promotions after base calculation
- Store in PricingSnapshot for audit trail

### 2. Seat Reservation Consistency
- ms-route owns SeatLock as source of truth
- ms-booking requests reservations via API
- Use Redis distributed locks for concurrent access
- Implement compensation for failed bookings

### 3. Cross-Service References
- Store foreign service IDs as references (no FK constraints)
- Use eventual consistency for cross-service data
- Implement circuit breakers for service calls

## Event-Driven Architecture Rules

### Event Types
- **ms-route**: SeatsReserved, SeatsReleased
- **ms-booking**: BookingCreated, PaymentSucceeded, TicketIssued
- **ms-promotion**: PromoUpdated
- **ms-user**: UserUpdated

### Event Publishing Rules
- Use Outbox pattern for reliable event publishing
- Publish events after successful DB transaction
- Include correlation IDs for tracing
- Implement event versioning for schema evolution

## Security Rules

### Authentication & Authorization
- All requests through API Gateway
- JWT tokens from Keycloak for authentication
- **Keycloak URL**: `https://keycloak.appf4s.io.vn/`
- **Custom SPI**: RideHub has custom Keycloak SPI extensions
- Role-based access: ADMIN, CUSTOMER
- Service-to-service communication via service accounts

### Keycloak Configuration
- **Base URL**: `https://keycloak.appf4s.io.vn/`
- **Realm**: Configure RideHub-specific realm
- **Custom SPI Extensions**:
  - Implement custom authentication flows if needed
  - Custom user federation providers
  - Custom protocol mappers for JWT token customization
- **Client Configuration**:
  - API Gateway client for public access
  - Service clients for inter-service communication
  - Mobile/Web app clients with appropriate flows

### Data Protection
- Hash passwords using bcrypt or similar
- Encrypt sensitive data at rest
- Implement audit logging for sensitive operations
- Follow GDPR compliance for user data

## Development Guidelines

### Code Organization
- Domain-driven design within each service
- Separate layers: Controller → Service → Repository
- Use dependency injection for loose coupling
- Implement proper error handling and logging

### Testing Strategy
- Unit tests for business logic
- Integration tests for database operations
- Contract tests for API interfaces
- End-to-end tests for critical user journeys

### Monitoring & Observability
- Distributed tracing across services
- Metrics for business and technical KPIs
- Centralized logging with correlation IDs
- Health checks for all services

## Deployment Rules

### Environment Management
- Separate configurations per environment
- Use environment variables for sensitive data
- Implement blue-green deployments
- Database migrations with rollback capability

### Scaling Considerations
- Stateless service design for horizontal scaling
- Database connection pooling
- Redis clustering for high availability
- Kafka partitioning for parallel processing

## Error Handling Rules

### Service Resilience
- Implement circuit breakers for external calls
- Use retry mechanisms with exponential backoff
- Graceful degradation when services are unavailable
- Timeout configurations for all external calls

### Data Validation
- Validate input at API boundaries
- Use domain validation rules consistently
- Implement idempotency for critical operations
- Handle duplicate requests gracefully

## Keycloak SPI Development Rules

### SPI Implementation Guidelines
- **Environment**: Keycloak instance at `https://keycloak.appf4s.io.vn/`
- **Source Code**: Located in `spi/keycloak-custom-reg/` directory (part of main repository)
- **Development**: Create custom SPI JARs for RideHub-specific functionality
- **Deployment**: Deploy SPI JARs to Keycloak providers directory
- **Testing**: Test SPI functionality in isolated Keycloak realm
- **Build**: Use Maven to build SPI JAR from `spi/keycloak-custom-reg/pom.xml`

### Custom SPI Types for RideHub
- **Authentication SPI**: Custom login flows for mobile/web apps
- **User Storage SPI**: If integrating with external user databases
- **Event Listener SPI**: For audit logging and user activity tracking
- **Protocol Mapper SPI**: Custom JWT token claims for RideHub roles
- **Theme SPI**: Custom login/registration pages with RideHub branding

### SPI Configuration Rules
- Use environment-specific configuration files
- Implement proper error handling and logging in SPI code
- Follow Keycloak SPI lifecycle management
- Ensure SPI compatibility with Keycloak version updates
- Document all custom SPI configurations and dependencies

### SPI Project Structure
```
spi/keycloak-custom-reg/
├── pom.xml                    # Maven build configuration
├── docker-compose.yml        # Local Keycloak development setup
├── .env                       # Environment variables
├── README.md                  # SPI documentation
├── realm-config/              # Keycloak realm configuration
├── src/main/java/             # SPI source code
│   └── com/example/kc/customreg/
│       ├── CustomRegProvider.java
│       ├── CustomRegProviderFactory.java
│       ├── CustomRegResource.java
│       ├── JwtUtil.java
│       ├── OtpRecord.java
│       ├── OtpStore.java
│       ├── SmsGateway.java
│       └── Util.java
└── src/main/resources/META-INF/services/
    └── org.keycloak.services.resource.RealmResourceProviderFactory
```

### Integration with RideHub Services
- SPI should integrate with ms-user service for user data synchronization
- Use Kafka events for user lifecycle notifications from Keycloak
- Implement proper session management and token validation
- Configure CORS and security policies for web/mobile clients
