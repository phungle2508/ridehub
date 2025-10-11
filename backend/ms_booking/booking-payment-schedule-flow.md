# Booking Payment Schedule Flow - MS Booking Service

## Overview
This document summarizes the complete booking payment schedule flow in the MS Booking microservice, including the recent fix for the lockGroupId issue and comprehensive flow diagrams.

## Architecture Components

### Core Services
- **BookingServiceImpl**: Main booking creation and management logic
- **BookingScheduler**: Scheduled tasks for expired booking cleanup
- **PaymentServiceImpl**: Payment processing and webhook handling
- **PricingService**: Price calculation and promotion management

### External Dependencies
- **ms-route API**: Seat lock management and trip information
- **Payment Gateways**: VNPay, MoMo, ZaloPay integration
- **Redis**: Session management and caching

## Complete Booking Flow

```mermaid
sequenceDiagram
    participant Client
    participant BookingAPI as Booking API
    participant BookingService as BookingServiceImpl
    participant PricingService as PricingService
    participant RouteAPI as ms-route API
    participant Redis
    participant Database
    participant PaymentGateway as Payment Gateway
    participant Scheduler as BookingScheduler

    Note over Client, Scheduler: 1. Booking Creation Flow
    Client->>BookingAPI: POST /api/bookings/draft
    BookingAPI->>BookingService: createRealBooking(req)
    
    Note right of BookingService: Idempotency Check
    BookingService->>Redis: setIfAbsent(idemKey)
    Redis-->>BookingService: LOCKED/EXISTS
    
    alt Idempotency Pass
        BookingService->>PricingService: computePrice()
        PricingService-->>BookingService: PricingResult
        
        Note right of BookingService: Seat Lock Attempt
        BookingService->>RouteAPI: tryLockSeats(lockRequest)
        RouteAPI-->>BookingService: SeatLockResponse(HELD)
        
        Note right of BookingService: Booking Creation
        BookingService->>Database: save(Booking) with lockGroupId
        Database-->>BookingService: Booking with ID
        
        BookingService->>Redis: store session & seats
        BookingService->>Database: save pricing snapshot
        BookingService->>Database: save applied promotions
        
        Note right of BookingService: Update Seat Lock
        BookingService->>RouteAPI: updateSeatLock(bookingId)
        BookingService->>Database: update status to AWAITING_PAYMENT
        
        BookingService-->>BookingAPI: BookingDraftResultVM
        BookingAPI-->>Client: 201 Created with booking details
    else Idempotency Failed
        BookingService-->>BookingAPI: IllegalStateException
        BookingAPI-->>Client: 409 Conflict
    end

    Note over Client, Scheduler: 2. Payment Processing Flow
    Client->>PaymentGateway: Initiate Payment
    PaymentGateway-->>Client: Payment URL/QR
    
    Note over PaymentGateway, BookingService: Payment Completion
    PaymentGateway->>BookingAPI: Webhook callback
    BookingAPI->>PaymentServiceImpl: processWebhook()
    
    PaymentServiceImpl->>Database: find transaction & booking
    PaymentServiceImpl->>PaymentServiceImpl: validate & process payment
    
    alt Payment Success
        PaymentServiceImpl->>RouteAPI: confirmSeatLocks()
        PaymentServiceImpl->>Database: create tickets
        PaymentServiceImpl->>Database: update booking to CONFIRMED
        PaymentServiceImpl->>Redis: cleanup session
    else Payment Failed
        PaymentServiceImpl->>RouteAPI: cancelSeatLocks()
        PaymentServiceImpl->>Database: update booking to CANCELED
        PaymentServiceImpl->>Redis: cleanup session
    end

    Note over Client, Scheduler: 3. Scheduled Cleanup Flow (Every Minute)
    Scheduler->>Database: findExpiredAwaitingPaymentBookings()
    
    loop For Each Expired Booking
        Note right of Scheduler: Seat Lock Cleanup (Fixed!)
        alt lockGroupId exists (Now works with fix)
            Scheduler->>RouteAPI: cancelSeatLocks()
            Scheduler->>Database: update status to CANCELED
            Scheduler->>Redis: delete session & seat data
        else lockGroupId missing (Before fix)
            Scheduler-->>Scheduler: Skip seat lock cancellation
            Scheduler->>Database: update status to CANCELED
            Scheduler->>Redis: delete session & seat data
            Note right of Scheduler: ⚠️ Seat locks remain locked!
        end
    end
```

## Detailed Component Interactions

### Booking Creation States

```mermaid
stateDiagram-v2
    [*] --> DRAFT: createRealBooking()
    DRAFT --> AWAITING_PAYMENT: seat lock success
    DRAFT --> [*]: seat lock failed
    
    AWAITING_PAYMENT --> CONFIRMED: payment success
    AWAITING_PAYMENT --> CANCELED: payment failed
    AWAITING_PAYMENT --> CANCELED: scheduler timeout
    
    CONFIRMED --> [*]: completion
    CANCELED --> [*]: cleanup
```

### Seat Lock Management Flow

```mermaid
flowchart TD
    A[Booking Request] --> B{Idempotency Check}
    B -->|Pass| C[Lock Seats via ms-route]
    B -->|Fail| D[Return Error]
    
    C --> E{Seat Lock Result}
    E -->|HELD| F[Create Booking with lockGroupId]
    E -->|REJECTED| G[Seat Not Available Error]
    
    F --> H[Store in Database]
    H --> I[Update Seat Lock with Booking ID]
    I --> J[Set Status: AWAITING_PAYMENT]
    J --> K[Store Session in Redis]
    
    K --> L{Payment Result}
    L -->|Success| M[Confirm Seat Locks]
    L -->|Failed/Timeout| N[Cancel Seat Locks]
    
    M --> O[Create Tickets]
    N --> P[Release Seats]
    
    O --> Q[Status: CONFIRMED]
    P --> R[Status: CANCELED]
```

## Key Fixes Implemented

### LockGroupId Issue Resolution

**Problem**: The `BookingScheduler.handleExpiredBookings()` method was checking for `booking.getLockGroupId() != null` before canceling seat locks, but `BookingServiceImpl.createRealBooking()` wasn't setting this field.

**Solution**: Modified `createRealBooking()` to set `lockGroupId` using the idempotency key:

```java
// IMPORTANT: Set lockGroupId using idempotency key for proper seat lock management
String lockGroupId = req.getIdemKey();
if (lockGroupId != null && !lockGroupId.trim().isEmpty()) {
    b.setLockGroupId(lockGroupId);
    LOG.debug("Set lockGroupId {} for booking {} using idempotency key", lockGroupId, b.getBookingCode());
}
```

**Impact**: 
- ✅ Expired bookings now properly cancel seat locks
- ✅ Better resource management and cleanup
- ✅ Consistent with admin booking confirmation/cancellation flow

## Redis Key Structure

### Session Management
- `booking:sess:{bookingId}`: Booking session state (AWAITING_LOCK, AWAITING_PAYMENT)
- `booking:seats:{bookingId}`: Comma-separated seat numbers for the booking
- `idem:booking:{idemKey}`: Idempotency lock (60 seconds TTL)

### Payment Processing
- `payment:webhook:{transactionId}`: Webhook processing lock
- `booking:review:{bookingId}`: Manual review flag (7 days TTL)

## Scheduled Tasks

### BookingScheduler (Every Minute)
```java
@Scheduled(fixedRate = 60000) // Every minute
public void handleExpiredBookings() {
    // 1. Find expired AWAITING_PAYMENT bookings
    // 2. Cancel seat locks if lockGroupId exists (FIXED!)
    // 3. Update booking status to CANCELED
    // 4. Cleanup Redis sessions
    // 5. Mark for manual review on failures
}
```

### Reconciliation Task (Every 5 Minutes)
```java
@Scheduled(fixedRate = 300000) // Every 5 minutes
public void reconcileInconsistentStates() {
    // Find and fix inconsistent booking states
    // (Currently placeholder for future implementation)
}
```

## Payment Gateway Integration

### Supported Gateways
- **VNPay**: Vietnamese payment gateway with polling support
- **MoMo**: Mobile wallet integration
- **ZaloPay**: Zalo payment integration

### Webhook Processing Flow
```mermaid
sequenceDiagram
    participant Gateway as Payment Gateway
    participant API as Booking API
    participant Service as PaymentServiceImpl
    participant DB as Database
    participant RouteAPI as ms-route API

    Gateway->>API: POST /api/payments/{gateway}/callback
    API->>Service: processWebhook(gateway, payload, signature)
    
    Service->>DB: findOrCreateWebhookLog()
    alt Already Processed
        Service-->>API: DUPLICATE_PROCESSING
    else New Processing
        Service->>Service: verifyWebhookSignature()
        Service->>Service: extractWebhookData()
        
        Service->>DB: findTransaction()
        alt Transaction in Final State
            Service-->>API: ALREADY_FINAL
        else Process Payment
            Service->>Service: mapGatewayStatus()
            
            alt Payment Success
                Service->>RouteAPI: confirmSeatLocks()
                Service->>DB: createTickets()
                Service->>DB: updateBooking(CONFIRMED)
            else Payment Failed
                Service->>RouteAPI: cancelSeatLocks()
                Service->>DB: updateBooking(CANCELED)
            end
            
            Service->>DB: updateTransactionStatus()
        end
    end
```

## Error Handling & Recovery

### Seat Lock Failures
- **Creation Failure**: Rollback booking creation, cleanup Redis
- **Confirmation Failure**: Mark for manual review, attempt rollback
- **Cancellation Failure**: Log warning, continue with status update

### Payment Processing Failures
- **Webhook Verification Failed**: Return error response
- **Database Errors**: Mark for manual review
- **External API Failures**: Retry with exponential backoff

### Manual Review Process
- Bookings marked for manual review are stored in Redis
- Admin can review via `/api/admin/bookings/{id}/confirm` or `/cancel`
- Review entries expire after 7 days

## Performance Considerations

### Caching Strategy
- Pricing results cached to avoid repeated calculations
- Redis sessions with TTL for automatic cleanup
- Idempotency locks prevent duplicate processing

### Database Optimization
- Indexes on booking status, expiration time, customer ID
- Separate pricing snapshot table for historical data
- Optimized queries for expired booking detection

### External API Management
- Circuit breaker pattern for ms-route API calls
- Timeout configurations for payment gateway calls
- Retry logic with exponential backoff

## Monitoring & Observability

### Key Metrics
- Booking creation success/failure rates
- Payment processing times
- Seat lock cancellation success rates
- Expired booking cleanup performance

### Logging Strategy
- Structured logging with correlation IDs
- Different log levels for different operations
- Error tracking with stack traces for debugging

### Health Checks
- Database connectivity
- Redis connectivity
- External API availability
- Scheduled task execution status

## Security Considerations

### Idempotency
- Client-generated idempotency keys prevent duplicate bookings
- Redis-based locking with TTL prevents race conditions
- Webhook processing with duplicate detection

### Data Validation
- Input validation on all API endpoints
- Payment gateway signature verification
- Seat availability validation before booking

### Access Control
- Role-based access for admin operations
- API rate limiting for public endpoints
- Secure webhook endpoint with signature validation
