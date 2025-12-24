# Learning Plan: Elasticsearch, Redis, and Kafka for RideHub

This document provides a structured learning path for mastering Elasticsearch, Redis, and Kafka in the context of the RideHub ride-sharing platform.

---

## Overview: How These Technologies Fit in RideHub

Based on the JDL configuration, here's how each technology is used:

| Technology | Services Using It | Primary Purpose |
|------------|-------------------|-----------------|
| **Elasticsearch** | ms_route | Full-text search on `Route`, `Station`, `TripStatistics` |
| **Redis** | ms_user, ms_route, ms_booking, ms_promotion | Caching, distributed locks (seat locking) |
| **Kafka** | ms_route, ms_booking, ms_promotion | Event-driven communication between services |

---

## Part 1: Redis (Start Here)

### Why Redis First?
- Simplest to learn and set up
- Used by ALL microservices
- Provides immediate performance benefits
- Critical for seat locking functionality (core business logic)

### Week 1: Redis Fundamentals

#### Day 1-2: Core Concepts
**Topics:**
- Data structures: Strings, Hashes, Lists, Sets, Sorted Sets
- Key expiration (TTL)
- Redis CLI basics
- In-memory persistence (RDB vs AOF)

**RideHub Context:**
- Storing user session data (`AppUser` lastLoginAt)
- Caching frequently accessed data like `Route` information

**Exercise:**
```bash
# Start Redis
docker exec -it ridehub-ms_user-redis redis-cli

# Practice basic operations
SET route:101:baseFare 150000
GET route:101:baseFare
EXPIRE route:101:baseFare 3600  # 1 hour TTL
```

#### Day 3-4: Caching Strategies
**Topics:**
- Cache-aside pattern
- Write-through vs write-back caching
- Cache invalidation strategies
- Dealing with cache stampede

**RideHub Context:**
- Caching `Route` data to avoid database hits
- Caching `PricingTemplate` for quick price calculations
- Invalidation when `Route` is updated

**Exercise:**
```java
// Pseudo-code for cache-aside pattern
public Route getRoute(Long routeId) {
    String cacheKey = "route:" + routeId;
    Route route = redisTemplate.opsForValue().get(cacheKey);

    if (route == null) {
        route = routeRepository.findById(routeId);
        if (route != null) {
            redisTemplate.opsForValue().set(cacheKey, route, 1, TimeUnit.HOURS);
        }
    }
    return route;
}
```

#### Day 5-7: Distributed Locks (Critical for RideHub)
**Topics:**
- Why distributed locks are needed
- SET NX (SET if Not Exists) with expiration
- Redlock algorithm
- Handling lock failures and retries

**RideHub Context:**
- `SeatLock` entity prevents double-booking
- When a user selects seats, they must be locked
- Lock expires if booking not completed within timeout

**Exercise:**
```java
// Pseudo-code for seat locking
public boolean lockSeat(Long tripId, String seatNo, Long userId, int timeoutMinutes) {
    String lockKey = "seatlock:" + tripId + ":" + seatNo;
    String lockValue = userId.toString();

    // SET NX EX: Set if Not Exists with Expiration
    Boolean acquired = redisTemplate.opsForValue()
        .setIfAbsent(lockKey, lockValue, timeoutMinutes, TimeUnit.MINUTES);

    if (Boolean.TRUE.equals(acquired)) {
        // Create SeatLock record in database
        saveSeatLock(tripId, seatNo, userId, timeoutMinutes);
        return true;
    }
    return false; // Seat already locked
}

public void releaseSeatLock(Long tripId, String seatNo, Long userId) {
    String lockKey = "seatlock:" + tripId + ":" + seatNo;
    // Only release if you own the lock
    redisTemplate.delete(lockKey);
}
```

### Week 2: Advanced Redis

#### Day 8-10: Redis Pub/Sub and Streams
**Topics:**
- Pub/Sub pattern for real-time updates
- Redis Streams for log-like data
- Consumer groups

**RideHub Context:**
- Notify users when booking status changes
- Real-time seat availability updates

#### Day 11-12: Redis Cluster and Sentinel
**Topics:**
- High availability with Sentinel
- Sharding with Cluster
- Connection pooling

**RideHub Context:**
- Production deployment considerations
- Handling Redis failures

#### Day 13-14: Spring Data Redis Integration
**Topics:**
- `RedisTemplate` configuration
- `@Cacheable` annotations
- Custom serialization
- Redis repository support

**Exercise:**
```java
// Enable caching in Spring Boot
@Configuration
@EnableCaching
public class CacheConfig {
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return template;
    }
}

// Use caching annotations
@Cacheable(value = "routes", key = "#routeId")
public Route getRouteById(Long routeId) {
    return routeRepository.findById(routeId).orElse(null);
}

@CachePut(value = "routes", key = "#route.id")
public Route updateRoute(Route route) {
    return routeRepository.save(route);
}

@CacheEvict(value = "routes", key = "#routeId")
public void deleteRoute(Long routeId) {
    routeRepository.deleteById(routeId);
}
```

---

## Part 2: Elasticsearch

### Week 3: Elasticsearch Fundamentals

#### Day 15-17: Core Concepts
**Topics:**
- Inverted index (how search works)
- Documents and types
- Shards and replicas
- REST API basics

**RideHub Context:**
- `Route` search by origin, destination
- `Station` search by name, location
- `TripStatistics` for analytics

**Exercise:**
```bash
# Connect to Elasticsearch in Docker
docker exec -it ridehub-ms_route-elasticsearch curl -X GET "localhost:9200"

# Create index for routes
curl -X PUT "localhost:9200/routes" -H 'Content-Type: application/json' -d'
{
  "mappings": {
    "properties": {
      "routeCode": {"type": "keyword"},
      "distanceKm": {"type": "double"},
      "baseFare": {"type": "double"},
      "origin": {
        "properties": {
          "name": {"type": "text"},
          "latitude": {"type": "double"},
          "longitude": {"type": "double"}
        }
      },
      "destination": {
        "properties": {
          "name": {"type": "text"},
          "latitude": {"type": "double"},
          "longitude": {"type": "double"}
        }
      }
    }
  }
}
'

# Index a route document
curl -X POST "localhost:9200/routes/_doc/1" -H 'Content-Type: application/json' -d'
{
  "routeCode": "HN-HUE-01",
  "distanceKm": 680.5,
  "baseFare": 350000,
  "origin": {
    "name": "Hà Nội",
    "latitude": 21.0285,
    "longitude": 105.8542
  },
  "destination": {
    "name": "Huế",
    "latitude": 16.4637,
    "longitude": 107.5909
  }
}
'
```

#### Day 18-19: Query DSL
**Topics:**
- Match queries (full-text search)
- Term queries (exact match)
- Range queries
- Boolean queries (must, should, filter)
- Aggregations

**RideHub Context:**
- Search routes by origin/destination names
- Filter by price range
- Find trips within a date range
- Get statistics on popular routes

**Exercise:**
```bash
# Search routes from "Hà Nội" to "Huế"
curl -X GET "localhost:9200/routes/_search" -H 'Content-Type: application/json' -d'
{
  "query": {
    "bool": {
      "must": [
        {"match": {"origin.name": "Hà Nội"}},
        {"match": {"destination.name": "Huế"}}
      ]
    }
  }
}
'

# Filter by fare range (200k - 500k)
curl -X GET "localhost:9200/routes/_search" -H 'Content-Type: application/json' -d'
{
  "query": {
    "bool": {
      "filter": [
        {"range": {"baseFare": {"gte": 200000, "lte": 500000}}}
      ]
    }
  }
}
'

# Aggregate by destination popularity
curl -X GET "localhost:9200/routes/_search" -H 'Content-Type: application/json' -d'
{
  "size": 0,
  "aggs": {
    "popular_destinations": {
      "terms": {
        "field": "destination.name.keyword",
        "size": 10
      }
    }
  }
}
'
```

#### Day 20-21: Geospatial Search
**Topics:**
- Geo-point mapping
- Geo-distance queries
- Geo-bounding box queries

**RideHub Context:**
- Find stations near a location
- Search routes within a radius

**Exercise:**
```bash
# Find stations within 10km of a point
curl -X GET "localhost:9200/stations/_search" -H 'Content-Type: application/json' -d'
{
  "query": {
    "bool": {
      "filter": {
        "geo_distance": {
          "distance": "10km",
          "location": {
            "lat": 21.0285,
            "lon": 105.8542
          }
        }
      }
    }
  }
}
'
```

### Week 4: Spring Data Elasticsearch

#### Day 22-24: Integration with Spring Boot
**Topics:**
- `ElasticsearchRepository` interface
- `@Document` annotations
- Custom queries
- Bulk operations

**RideHub Context:**
- Sync data from MySQL to Elasticsearch
- Implement search for `Route`, `Station`, `TripStatistics`

**Exercise:**
```java
// Document mapping
@Document(indexName = "routes")
public class RouteDocument {
    @Id
    private Long id;

    @Field(type = FieldType.Keyword)
    private String routeCode;

    @Field(type = FieldType.Double)
    private BigDecimal baseFare;

    @Field(type = FieldType.Object)
    private StationInfo origin;

    @Field(type = FieldType.Object)
    private StationInfo destination;
}

// Repository
public interface RouteSearchRepository extends ElasticsearchRepository<RouteDocument, Long> {
    List<RouteDocument> findByOriginNameContainingOrDestinationNameContaining(String origin, String destination);

    List<RouteDocument> findByBaseFareBetween(BigDecimal min, BigDecimal max);
}

// Service
@Service
public class RouteSearchService {
    @Autowired
    private RouteSearchRepository searchRepository;

    @Autowired
    private RouteRepository routeRepository;

    // Index all routes
    public void indexAllRoutes() {
        List<Route> routes = routeRepository.findAll();
        List<RouteDocument> documents = routes.stream()
            .map(this::toDocument)
            .collect(Collectors.toList());
        searchRepository.saveAll(documents);
    }

    public List<RouteDocument> searchRoutes(String keyword) {
        return searchRepository.findByOriginNameContainingOrDestinationNameContaining(keyword, keyword);
    }
}
```

#### Day 25-28: Advanced Topics
**Topics:**
- Synchronization strategies (Log-based vs CDC)
- Reindexing
- Performance tuning
- Handling search relevancy

---

## Part 3: Kafka

### Week 5: Kafka Fundamentals

#### Day 29-31: Core Concepts
**Topics:**
- Producers, consumers, brokers
- Topics and partitions
- Offsets and consumer groups
- Message ordering and delivery guarantees

**RideHub Context:**
- Booking created event → Update user statistics
- Booking cancelled event → Release seat locks
- Payment completed event → Update invoice

**Exercise:**
```bash
# Connect to Kafka in Docker
docker exec -it ridehub-kafka /opt/bitnami/kafka/bin/kafka-topics.sh --bootstrap-server localhost:9092 --list

# Create a topic for booking events
docker exec -it ridehub-kafka /opt/bitnami/kafka/bin/kafka-topics.sh \
  --create --bootstrap-server localhost:9092 \
  --topic booking-events --partitions 3 --replication-factor 1

# Produce a message
docker exec -i ridehub-kafka /opt/bitnami/kafka/bin/kafka-console-producer.sh \
  --bootstrap-server localhost:9092 --topic booking-events

# Paste this JSON:
{"eventType":"BOOKING_CREATED","bookingId":123,"customerId":"uuid-456","amount":350000}

# Consume messages
docker exec -it ridehub-kafka /opt/bitnami/kafka/bin/kafka-console-consumer.sh \
  --bootstrap-server localhost:9092 --topic booking-events --from-beginning
```

#### Day 32-35: Event-Driven Architecture in RideHub
**Topics:**
- Domain events vs integration events
- Event schemas with Avro
- Event versioning
- Outbox pattern for reliable messaging

**RideHub Context:**
- `Booking` status changes trigger events
- `Ticket` exchanges and refunds emit events
- Cross-service communication via Kafka

**Event Examples (Avro Schema):**
```json
// Booking Created Event
{
  "type": "record",
  "name": "BookingCreatedEvent",
  "namespace": "com.ridehub.booking.events",
  "fields": [
    {"name": "eventId", "type": "string"},
    {"name": "bookingId", "type": "long"},
    {"name": "customerId", "type": "string"},
    {"name": "tripId", "type": "long"},
    {"name": "routeId", "type": "long"},
    {"name": "seatIds", "type": {"type": "array", "items": "long"}},
    {"name": "totalAmount", "type": "double"},
    {"name": "status", "type": "string"},
    {"name": "timestamp", "type": "long"}
  ]
}

// Ticket Status Changed Event
{
  "type": "record",
  "name": "TicketStatusChangedEvent",
  "namespace": "com.ridehub.booking.events",
  "fields": [
    {"name": "ticketId", "type": "long"},
    {"name": "oldStatus", "type": "string"},
    {"name": "newStatus", "type": "string"},
    {"name": "reason", "type": ["null", "string"]},
    {"name": "timestamp", "type": "long"}
  ]
}
```

#### Day 36-37: Spring Cloud Kafka Integration
**Topics:**
- `@KafkaListener` annotations
- `KafkaTemplate` for producing
- Error handling and retries
- Dead letter queues

**Exercise:**
```java
// Producer Service
@Service
public class BookingEventProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void publishBookingCreated(Booking booking) {
        BookingCreatedEvent event = BookingCreatedEvent.builder()
            .eventId(UUID.randomUUID().toString())
            .bookingId(booking.getId())
            .customerId(booking.getCustomerId().toString())
            .tripId(booking.getTripId())
            .build();

        String json = objectMapper.writeValueAsString(event);
        kafkaTemplate.send("booking-events", booking.getBookingCode(), json);
    }
}

// Consumer Service
@Service
public class BookingEventConsumer {
    @Autowired
    private UserStatisticsService statisticsService;

    @KafkaListener(
        topics = "booking-events",
        groupId = "ms_user-group",
        containerFactory = "kafkaListenerContainerFactory"
    )
    public void handleBookingEvent(String message) {
        try {
            JsonNode root = objectMapper.readTree(message);
            String eventType = root.get("eventType").asText();

            switch (eventType) {
                case "BOOKING_CREATED":
                    statisticsService.incrementTotalBookings(root.get("customerId").asText());
                    break;
                case "BOOKING_CANCELLED":
                    statisticsService.incrementCancelledTrips(root.get("customerId").asText());
                    break;
            }
        } catch (Exception e) {
            // Handle error - maybe send to DLQ
            logger.error("Error processing booking event", e);
        }
    }
}
```

### Week 6: Advanced Kafka

#### Day 38-42: Production Considerations
**Topics:**
- Exactly-once semantics
- Idempotent consumers
- Schema registry (Confluent)
- Monitoring and observability

**RideHub Context:**
- Prevent duplicate bookings
- Ensure payment events are processed exactly once
- Track event delivery status

#### Day 43-45: Saga Pattern for Distributed Transactions
**Topics:**
- Choreography vs orchestration
- Compensating transactions
- Implementing sagas with Kafka

**RideHub Context:**
- Booking flow: Lock seats → Create booking → Process payment → Confirm
- If payment fails: Release locks, cancel booking
- If trip is cancelled: Refund all bookings

**Saga Example:**
```
1. ms_route: SeatLock HELD → Publish "SEAT_LOCKED" event
2. ms_booking: Create Booking → Publish "BOOKING_CREATED" event
3. ms_booking: Process payment → Publish "PAYMENT_COMPLETED" event
4. ms_route: Update SeatLock to COMMITTED
5. ms_booking: Update Booking status to CONFIRMED

[If payment fails at step 3]:
3a. ms_booking: Publish "PAYMENT_FAILED" event
4a. ms_route: Update SeatLock to EXPIRED
5a. ms_booking: Update Booking status to CANCELLED
```

---

## Part 4: Integration Projects

### Week 7-8: Build Real Features

#### Project 1: Real-Time Seat Availability (Days 46-50)
**Goal:** Users see real-time seat availability when searching for trips.

**Tech Stack:**
- Redis for caching available seats
- Kafka for seat lock notifications

**Implementation:**
```
1. When seat lock expires:
   - Publish "SEAT_LOCK_EXPIRED" event to Kafka
   - Remove from Redis cache

2. When booking confirmed:
   - Publish "BOOKING_CONFIRMED" event
   - Update Redis cache to mark seats as BOOKED

3. Gateway subscribes to events and updates frontend via WebSocket
```

#### Project 2: Route Search with Autocomplete (Days 51-55)
**Goal:** Search box suggests routes as user types.

**Tech Stack:**
- Elasticsearch for search
- Redis for query caching

**Implementation:**
```
1. User types "Hà Nội"
2. Query Elasticsearch for routes matching "Hà Nội"
3. Cache results in Redis (5-minute TTL)
4. Return suggestions to frontend
```

#### Project 3: User Statistics Dashboard (Days 56-60)
**Goal:** Show user's travel statistics on dashboard.

**Tech Stack:**
- Kafka for event streaming
- Redis for caching stats
- Elasticsearch for trip history

**Implementation:**
```
1. Subscribe to booking events
2. Update UserStatistics in real-time
3. Cache stats in Redis
4. Query TripStatistics in Elasticsearch for analytics
```

---

## Learning Resources

### Official Documentation
- **Redis:** https://redis.io/docs/
- **Elasticsearch:** https://www.elastic.co/guide/
- **Kafka:** https://kafka.apache.org/documentation/

### Recommended Books
- "Redis in Action" by Josiah L. Carlson
- "Elasticsearch: The Definitive Guide" by Clinton Gormley
- "Kafka: The Definitive Guide" by Neha Narkhede

### Video Courses
- Redis University: https://university.redis.com/
- Elastic Learn: https://www.elastic.co/learn
- Confluent Kafka Courses: https://developer.confluent.io/courses/

---

## Practice Checklist

Track your progress:

### Redis
- [ ] Install and run Redis locally
- [ ] Set/get/delete keys
- [ ] Implement cache-aside pattern
- [ ] Build distributed seat lock system
- [ ] Configure Spring Data Redis

### Elasticsearch
- [ ] Create and delete indices
- [ ] Index documents from MySQL
- [ ] Build search queries
- [ ] Implement geospatial search
- [ ] Sync data with Spring Boot

### Kafka
- [ ] Create topics and produce/consume messages
- [ ] Define Avro schemas for events
- [ ] Implement producers and consumers
- [ ] Build event-driven features
- [ ] Implement outbox pattern

---

## Next Steps After Completing This Plan

1. **Advanced Patterns:** CQRS, Event Sourcing
2. **Performance Tuning:** JVM tuning, connection pooling
3. **Observability:** Distributed tracing with OpenTelemetry
4. **Testing:** Integration testing with Testcontainers
