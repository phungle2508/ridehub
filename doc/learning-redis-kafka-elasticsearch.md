# Redis, Kafka & Elasticsearch Learning Guide
**RideHub Bus Booking System**

This document explains how Redis, Apache Kafka, and Elasticsearch work together in the RideHub microservices architecture.

---

## Table of Contents

1. [Implementation Plan](#implementation-plan)
2. [Redis - In-Memory Data Store](#redis)
3. [Apache Kafka - Event Streaming Platform](#kafka)
4. [Elasticsearch - Search & Analytics Engine](#elasticsearch)
5. [Integration in RideHub](#integration)

---

## Implementation Plan <a name="implementation-plan"></a>

This section outlines a practical implementation plan to add Redis, Kafka, and Elasticsearch features to the RideHub project for learning purposes.

### Overview of Dependencies

Your project already has the necessary dependencies configured:

| Technology | Dependency | Status |
|------------|-----------|--------|
| **Redis** | `spring-boot-starter-data-redis`, `redisson` | ✅ Already in pom.xml |
| **Kafka** | `spring-cloud-starter-stream-kafka` | ✅ Already in pom.xml |
| **Elasticsearch** | `spring-boot-starter-data-elasticsearch` | ✅ Already in pom.xml |

### Phase 1: Redis Features

#### 1.1 Create Redis Service

**Files to create:**
```
ms_route/src/main/java/com/ridehub/route/service/
├── RedisService.java                    (interface)
├── impl/
│   └── RedisServiceImpl.java           (implementation)
└── dto/
    ├── RedisLockResult.java
    └── RouteCacheDTO.java
```

**Features to implement:**

| Feature | Redis Data Type | Method | Learning Goal |
|---------|-----------------|--------|---------------|
| Route Caching | String | `cacheRoute()`, `getCachedRoute()` | Basic SET/GET with TTL |
| Seat Lock Data | Hash | `setSeatLockHash()`, `getSeatLockHash()` | HSET, HGET, HMGET |
| Online Drivers | Set | `addOnlineDriver()`, `isDriverOnline()` | SADD, SISMEMBER |
| Popular Routes | Sorted Set | `incrementRoutePopularity()`, `getTopPopularRoutes()` | ZINCRBY, ZREVRANGE |
| Recent Searches | List | `addRecentSearch()`, `getRecentSearches()` | LPUSH, LRANGE |
| Distributed Lock | Redisson | `tryAcquireSeatLock()`, `releaseSeatLock()` | SET NX EX |
| Rate Limiting | String + INCR | `checkRateLimit()`, `getRateLimitCount()` | INCR, EXPIRE |
| Pub/Sub | Channel | `publishSeatUpdate()` | PUBLISH |

#### 1.2 Create REST Controller for Learning

**File to create:**
```
ms_route/src/main/java/com/ridehub/route/web/rest/
└── RedisLearningController.java
```

**Endpoints:**
```
GET    /api/redis/learn/routes/cache/{id}        - Cache/get route
POST   /api/redis/learn/routes/{id}/cache        - Manually cache route
GET    /api/redis/learn/seatlock/hash/{trip}/{seat} - Get seat lock hash
POST   /api/redis/learn/seatlock/lock/{trip}/{seat} - Acquire distributed lock
DELETE /api/redis/learn/seatlock/lock/{trip}/{seat} - Release lock
GET    /api/redis/learn/drivers/online           - Get online drivers
POST   /api/redis/learn/drivers/{id}/online      - Mark driver online
GET    /api/redis/learn/routes/popular           - Get top popular routes
POST   /api/redis/learn/routes/{code}/popularity - Increment popularity
GET    /api/redis/learn/searches/recent/{userId}  - Get recent searches
POST   /api/redis/learn/searches/{userId}        - Add search
GET    /api/redis/learn/rate-limit/{key}         - Check rate limit
GET    /api/redis/learn/stats                    - Get Redis stats
```

#### 1.3 Integration with Existing SeatLockService

**Modify:** `SeatLockServiceImpl.java`

Add Redis layer to existing seat locking:
```java
// Before: Database only
public SeatHoldResponseDTO tryHold(SeatHoldRequestDTO req) {
    // Check database for conflicts...
}

// After: Redis + Database
public SeatHoldResponseDTO tryHold(SeatHoldRequestDTO req) {
    // 1. Try acquire Redis lock first (fast fail)
    RedisLockResult lockResult = redisService.tryAcquireSeatLock(...);
    if (!lockResult.isAcquired()) {
        return SeatHoldResponseDTO.rejected("Seat locked by another user");
    }

    try {
        // 2. Check database for conflicts
        // 3. Create seat lock record
    } finally {
        // Always clean up Redis lock
    }
}
```

---

### Phase 2: Kafka Features

#### 2.1 Create Kafka Producer

**Files to create:**
```
ms_route/src/main/java/com/ridehub/route/broker/
├── producer/
│   ├── RouteEventProducer.java           (interface)
│   └── impl/
│       └── RouteEventProducerImpl.java   (implementation)
└── event/
    ├── RouteCreatedEvent.java
    ├── TripCompletedEvent.java
    └── SeatLockEvent.java
```

**Configuration needed in `application.yml`:**
```yaml
spring:
  cloud:
    stream:
      kafka:
        binder:
          brokers: localhost:9092
      bindings:
        route-events-out-0:
          destination: route.events
          contentType: application/json
```

**Events to produce:**

| Event | Trigger | Consumer Services |
|-------|---------|-------------------|
| `RouteCreated` | New route created | ms_promotion (for pricing) |
| `TripCompleted` | Trip finished | ms_user (statistics), ms_promotion |
| `SeatLocked` | Seat held | ms_booking (monitor expiry) |
| `SeatReleased` | Seat lock expired | ms_booking (cleanup) |

#### 2.2 Create Kafka Consumer

**Files to create:**
```
ms_route/src/main/java/com/ridehub/route/broker/consumer/
├── RouteEventConsumer.java
└── handler/
    ├── BookingEventHandler.java
    └── PromotionEventHandler.java
```

**Events to consume from other services:**

| Event | Source | Action |
|-------|--------|--------|
| `BookingCreated` | ms_booking | Update trip statistics |
| `BookingCancelled` | ms_booking | Release seat locks |
| `PaymentCompleted` | ms_booking | Confirm seat reservations |
| `PromotionCreated` | ms_promotion | Invalidate route cache |

#### 2.3 Create REST Controller for Learning

**File to create:**
```
ms_route/src/main/java/com/ridehub/route/web/rest/
└── KafkaLearningController.java
```

**Endpoints:**
```
POST   /api/kafka/learn/publish/route      - Publish route event
POST   /api/kafka/learn/publish/trip       - Publish trip event
POST   /api/kafka/learn/publish/custom     - Publish custom event
GET    /api/kafka/learn/topics             - List all topics
GET    /api/kafka/learn/topics/{name}      - Get topic info
GET    /api/kafka/learn/consumers          - List consumer groups
POST   /api/kafka/learn/consumers/{group}/reset - Reset offset
```

---

### Phase 3: Elasticsearch Features

#### 3.1 Create Elasticsearch Documents

**Files to create:**
```
ms_route/src/main/java/com/ridehub/route/repository/search/
├── RouteSearchRepository.java
└── StationSearchRepository.java

ms_route/src/main/java/com/ridehub/route/domain/search/
├── RouteDocument.java
└── StationDocument.java
```

**RouteDocument mapping:**
```java
@Document(indexName = "routes")
public class RouteDocument {
    @Id
    private Long id;

    @Field(type = FieldType.Keyword)
    private String routeCode;

    @Field(type = FieldType.Object)
    private StationInfo origin;

    @Field(type = FieldType.Object)
    private StationInfo destination;

    @Field(type = FieldType.Double)
    private Double distanceKm;

    @Field(type = FieldType.Double)
    private Double baseFare;

    @Field(type = FieldType.Keyword)
    private List<String> vehicleTypes;

    @Field(type = FieldType.Boolean)
    private Boolean active;

    @Field(type = FieldType.Date, format = DateFormat.date_time)
    private Instant createdAt;
}
```

#### 3.2 Create Search Service

**File to create:**
```
ms_route/src/main/java/com/ridehub/route/service/
├── RouteSearchService.java
└── impl/
    └── RouteSearchServiceImpl.java
```

**Search methods to implement:**

| Method | Query Type | Learning Goal |
|--------|-----------|---------------|
| `searchRoutes()` | Bool query (multi-field) | MUST, SHOULD clauses |
| `autocompleteStations()` | Multi-match with fuzziness | Fuzzy search, boosting |
| `findNearbyStations()` | Geo-distance query | Geographic search |
| `getPopularRoutesByBookings()` | Aggregation | Terms aggregation, sorting |
| `searchRoutesByProvinces()` | Filter + query | Context queries |

#### 3.3 Create Indexing Service

**File to create:**
```
ms_route/src/main/java/com/ridehub/route/service/
├── IndexingService.java
└── impl/
    └── IndexingServiceImpl.java
```

**Features:**
- `indexRoute()` - Index single route
- `indexAllRoutes()` - Rebuild entire index
- `deleteRoute()` - Remove from index
- `updateRoute()` - Update existing document

#### 3.4 Create REST Controller for Learning

**File to create:**
```
ms_route/src/main/java/com/ridehub/route/web/rest/
└── SearchLearningController.java
```

**Endpoints:**
```
GET    /api/search/learn/routes               - Full-text search
GET    /api/search/learn/routes/autocomplete  - Autocomplete
GET    /api/search/learn/stations/nearby      - Geo search
GET    /api/search/learn/routes/aggregations  - Aggregation stats
POST   /api/search/learn/index/route/{id}     - Index single route
POST   /api/search/learn/index/rebuild        - Rebuild all indices
DELETE /api/search/learn/index/route/{id}     - Delete from index
GET    /api/search/learn/stats                - ES cluster stats
```

---

### Phase 4: Integration & End-to-End Testing

#### 4.1 Update Configuration

**File:** `ms_route/src/main/resources/config/application.yml`

Add:
```yaml
spring:
  # Redis configuration
  data:
    redis:
      host: localhost
      port: 6379
      timeout: 2000ms
      lettuce:
        pool:
          max-active: 8
          max-idle: 8

  # Kafka configuration
  cloud:
    stream:
      kafka:
        binder:
          brokers: localhost:9092
          auto-create-topics: true
      bindings:
        route-events-out-0:
          destination: route.events
          content-type: application/json

  # Elasticsearch configuration
  elasticsearch:
    uris: http://localhost:9200
    connection-timeout: 5s
    socket-timeout: 30s
```

#### 4.2 Docker Compose for Local Development

**File to create:** `docker-compose-dev.yml`

```yaml
version: '3.8'

services:
  redis:
    image: redis:7-alpine
    ports:
      - "6379:6379"
    volumes:
      - redis_data:/data
    command: redis-server --appendonly yes

  kafka:
    image: confluentinc/cp-kafka:latest
    depends_on:
      - zookeeper
    ports:
      - "9092:9092"
    environment:
      KAFKA_BROKER_ID: 1
      KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
      KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://localhost:9092
      KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR: 1

  zookeeper:
    image: confluentinc/cp-zookeeper:latest
    ports:
      - "2181:2181"
    environment:
      ZOOKEEPER_CLIENT_PORT: 2181

  elasticsearch:
    image: docker.elastic.co/elasticsearch/elasticsearch:8.11.0
    ports:
      - "9200:9200"
    environment:
      - discovery.type=single-node
      - xpack.security.enabled=false
      - "ES_JAVA_OPTS=-Xms512m -Xmx512m"
    volumes:
      - es_data:/usr/share/elasticsearch/data

  kafdrop:
    image: obsidiandynamics/kafdrop:latest
    depends_on:
      - kafka
    ports:
      - "9000:9000"
    environment:
      KAFKA_BROKERCONNECT: kafka:9092

volumes:
  redis_data:
  es_data:
```

#### 4.3 Testing Plan

**Learning exercises:**

1. **Redis Exercises:**
   ```bash
   # Exercise 1: Basic caching
   curl -X POST /api/redis/learn/routes/1/cache
   curl -X GET /api/redis/learn/routes/cache/1

   # Exercise 2: Distributed locking
   # Terminal 1:
   curl -X POST /api/redis/learn/seatlock/lock/trip123/A1
   # Terminal 2 (should fail):
   curl -X POST /api/redis/learn/seatlock/lock/trip123/A1

   # Exercise 3: Rate limiting
   for i in {1..15}; do
     curl -X GET /api/redis/learn/rate-limit/test:$i
   done
   ```

2. **Kafka Exercises:**
   ```bash
   # Exercise 1: Publish events
   curl -X POST /api/kafka/learn/publish/route \
     -H "Content-Type: application/json" \
     -d '{"routeCode": "HAN-SGN", "origin": "Hanoi", "destination": "SGN"}'

   # Exercise 2: Check topics
   curl -X GET /api/kafka/learn/topics

   # Exercise 3: View in Kafdrop
   # Open http://localhost:9000
   ```

3. **Elasticsearch Exercises:**
   ```bash
   # Exercise 1: Index routes
   curl -X POST /api/search/learn/index/rebuild

   # Exercise 2: Search routes
   curl -X GET "/api/search/learn/routes?q=Hanoi"

   # Exercise 3: Geo search
   curl -X GET "/api/search/learn/stations/nearby?lat=21.0&lon=105.8&radius=50"

   # Exercise 4: Aggregations
   curl -X GET "/api/search/learn/routes/aggregations"
   ```

---

### Phase 5: Monitoring & Observability

#### 5.1 Add Metrics Endpoints

**File to create:** `TechLearningController.java`

```java
@RestController
@RequestMapping("/api/tech/learn")
public class TechLearningController {

    @GetMapping("/redis/info")
    public RedisInfo getRedisInfo() {
        // Return memory usage, keys count, connected clients
    }

    @GetMapping("/kafka/info")
    public KafkaInfo getKafkaInfo() {
        // Return broker info, topic list, consumer groups
    }

    @GetMapping("/elasticsearch/info")
    public ESInfo getESInfo() {
        // Return cluster health, indices stats, node info
    }
}
```

---

### Implementation Order (Recommended)

1. **Week 1: Redis**
   - Day 1-2: Create RedisService interface + implementation
   - Day 3: Create RedisLearningController
   - Day 4-5: Integrate with SeatLockService

2. **Week 2: Kafka**
   - Day 1-2: Create event classes and producer
   - Day 3: Create consumer and handlers
   - Day 4-5: Create KafkaLearningController + test

3. **Week 3: Elasticsearch**
   - Day 1-2: Create document classes and repositories
   - Day 3: Create search service
   - Day 4-5: Create SearchLearningController + indexing

4. **Week 4: Integration**
   - Day 1-2: End-to-end testing
   - Day 3: Add monitoring endpoints
   - Day 4-5: Documentation and examples

---

### Success Criteria

You'll successfully learn these technologies when you can:

| Technology | Can Explain | Can Implement | Can Debug |
|------------|-------------|---------------|-----------|
| **Redis** | Data types, TTL, pub/sub | Caching, locking, rate limiting | Memory issues, connection pool |
| **Kafka** | Topics, partitions, offsets | Producers, consumers, groups | Offset lag, consumer rebalance |
| **Elasticsearch** | Index, mapping, shard | Search, aggregations, geo | Slow queries, mapping errors |

---

## Redis <a name="redis"></a>

### What is Redis?

**Redis** (Remote Dictionary Server) is an in-memory key-value data store, used as:
- Database
- Cache
- Message broker
- Session store

### Core Concepts

```
+-------------------+
|   Application     |
+-------------------+
         ↓
+-------------------+       +-------------------+
|   Redis Client    |------|   Redis Server    |
+-------------------+       +-------------------+
                                   ↓
                            +-------------------+
                            |   In-Memory Data  |
                            |   (Key-Value)     |
                            +-------------------+
```

### Data Types

| Type | Description | Use Case in RideHub |
|------|-------------|---------------------|
| **String** | Simple key-value | `user:123:name` → "John" |
| **Hash** | Field-value pairs | `session:abc` → {userId, expiry, data} |
| **List** | Ordered collection | `recent_searches:user123` → [route1, route2] |
| **Set** | Unique elements | `online_users` → {user1, user2, user3} |
| **Sorted Set** | Set with scores | `leaderboard:trips` → {(user1, 100), (user2, 95)} |
| **Bitmap** | Bit operations | `seat_availability:trip123` → 10110010 |

### Common Operations

```bash
# String operations
SET user:1001:email "john@example.com"
GET user:1001:email
EXPIRE user:1001:email 3600  # Expire in 1 hour

# Hash operations
HSET booking:BK001 status "CONFIRMED"
HGET booking:BK001 status
HMGET booking:BK001 status amount customer_id

# List operations
LPUSH recent:routes "HAN-SGN"
LRANGE recent:routes 0 4  # Get first 5

# Set operations
SADD online:drivers driver:123 driver:456
SISMEMBER online:drivers driver:123  # Check if online

# Sorted Set operations
ZADD popular:routes 1000 "HAN-SGN" 500 "HAN-DN"
ZRANGE popular:routes 0 9 WITHSCORES  # Top 10 routes
```

### RideHub Use Cases

#### 1. Caching Frequently Accessed Data
```java
// Cache user sessions
String key = "session:" + jwtToken;
redisTemplate.opsForHash().put(key, "userId", user.getId());
redisTemplate.expire(key, Duration.ofHours(24));

// Cache route availability
String cacheKey = "route:" + routeId + ":availability";
redisTemplate.opsForValue().set(cacheKey, availableSeats, 5, TimeUnit.MINUTES);
```

#### 2. Seat Locking (Distributed Lock)
```java
// Lock seat during booking
String lockKey = "lock:trip:" + tripId + ":seat:" + seatNo;
Boolean acquired = redisTemplate.opsForValue()
    .setIfAbsent(lockKey, bookingId, 15, TimeUnit.MINUTES);

if (Boolean.TRUE.equals(acquired)) {
    try {
        // Process booking
    } finally {
        redisTemplate.delete(lockKey);  // Release lock
    }
}
```

#### 3. Rate Limiting
```java
// Limit booking attempts per user
String rateKey = "rate:booking:" + userId;
Long count = redisTemplate.opsForValue().increment(rateKey);
if (count == 1) {
    redisTemplate.expire(rateKey, 1, TimeUnit.HOURS);
}
if (count > MAX_BOOKING_PER_HOUR) {
    throw new RateLimitExceededException();
}
```

#### 4. Pub/Sub for Real-time Updates
```java
// Publish seat availability change
redisTemplate.convertAndSend("seat:updates", {
    "tripId": 123,
    "seatNo": "A1",
    "status": "LOCKED"
});
```

### Redis Persistence

| Mode | Description | Pros | Cons |
|------|-------------|------|------|
| **RDB** | Snapshot at intervals | Faster restart, smaller file | Data loss since last snapshot |
| **AOF** | Log every write | Better durability | Larger file, slower restart |
| **Hybrid** | Both RDB + AOF | Best of both worlds | More complex |

---

## Apache Kafka <a name="kafka"></a>

### What is Kafka?

**Apache Kafka** is a distributed event streaming platform for:
- Event-driven architectures
- Microservices communication
- Real-time data pipelines
- Log aggregation

### Core Concepts

```
Producer → [Topic] → Consumer
             ↓
          [Broker 1] [Broker 2] [Broker 3]
             ↓
          [Partitions]
             ↓
          [Replicas]
```

| Component | Description |
|-----------|-------------|
| **Producer** | Application that sends events to Kafka |
| **Consumer** | Application that reads events from Kafka |
| **Broker** | A Kafka server in the cluster |
| **Topic** | Logical channel for events (like a queue) |
| **Partition** | Segment of a topic (parallelism) |
| **Offset** | Unique identifier for each message |
| **Consumer Group** | Set of consumers sharing topic load |

### Kafka Architecture

```
┌─────────────────────────────────────────────────────────────────┐
│                         Kafka Cluster                           │
├─────────────────────────────────────────────────────────────────┤
│                                                                 │
│  Topic: booking-events                                          │
│  ┌───────────┬───────────┬───────────┬───────────┐            │
│  │ Partition │ Partition │ Partition │ Partition │            │
│  │     0     │     1     │     2     │     3     │            │
│  └─────┬─────┴─────┬─────┴─────┬─────┴─────┬─────┘            │
│        │           │           │           │                    │
│   Offset 0    Offset 0    Offset 0    Offset 0                 │
│   Offset 1    Offset 1    Offset 1    Offset 1                 │
│   Offset 2    Offset 2    Offset 2    Offset 2                 │
│        │           │           │           │                    │
└────────┼───────────┼───────────┼───────────┼────────────────────┘
         │           │           │           │
    ┌────┼──────┐    │           │      ┌────┼──────┐
    │Consumer 1│    │           │      │Consumer 3│
    │Group: A  │    │           │      │Group: B  │
    └─────────┘    │           │      └──────────┘
    ┌──────────┐   │           │
    │Consumer 2│   │           │
    │Group: A  │   │           │
    └──────────┘   │           │
```

### Message Flow

```
1. Producer sends event
   ms_booking → Kafka → "booking-created" event

2. Kafka stores event in topic partition
   Topic: booking.events
   Partition: 1 (based on bookingId)
   Offset: 4523

3. Consumers read events
   ms_promotion → Process discount
   ms_user → Update user statistics
   ms_route → Update seat availability
```

### RideHub Use Cases

#### 1. Booking Events
```java
// Producer: ms_booking sends booking event
@Producer
public class BookingEventProducer {
    public void sendBookingCreatedEvent(Booking booking) {
        BookingEvent event = BookingEvent.builder()
            .eventId(UUID.randomUUID())
            .bookingId(booking.getId())
            .bookingCode(booking.getBookingCode())
            .customerId(booking.getCustomerId())
            .totalAmount(booking.getTotalAmount())
            .status(booking.getStatus())
            .createdAt(Instant.now())
            .build();

        kafkaTemplate.send("booking.events", event);
    }
}
```

```java
// Consumer: ms_user updates user statistics
@KafkaListener(topics = "booking.events", groupId = "user-service")
public void handleBookingCreated(BookingEvent event) {
    UserStatistics stats = userStatsRepository.findByUserId(
        event.getCustomerId()
    );
    stats.setTotalTrips(stats.getTotalTrips() + 1);
    stats.setTotalSpent(stats.getTotalSpent().add(event.getTotalAmount()));
    userStatsRepository.save(stats);
}
```

#### 2. Seat Lock Events
```java
// Producer: ms_route publishes seat lock event
public void publishSeatLockedEvent(SeatLock lock) {
    SeatLockEvent event = SeatLockEvent.builder()
        .tripId(lock.getTripId())
        .seatNo(lock.getSeatNo())
        .userId(lock.getUserId())
        .lockedAt(Instant.now())
        .build();

    kafkaTemplate.send("seat-lock.events", event);
}

// Consumer: ms_booking monitors lock expiry
@KafkaListener(topics = "seat-lock.events", groupId = "booking-service")
public void monitorSeatLock(SeatLockEvent event) {
    // Schedule check before lock expires
    scheduleLockExpiryCheck(event);
}
```

#### 3. Payment Events
```java
// Payment completed event
@KafkaListener(topics = "payment.completed", groupId = "booking-service")
public void handlePaymentCompleted(PaymentEvent event) {
    if (event.getPaymentGateway().equals("VNPAY")) {
        // Update booking status
        bookingService.confirmBooking(event.getBookingId());

        // Publish booking confirmed event
        bookingEventProducer.publishBookingConfirmed(event.getBookingId());
    }
}
```

#### 4. Trip Statistics Events
```java
// Publish trip completion event
public void publishTripCompleted(Trip trip) {
    TripEvent event = TripEvent.builder()
        .tripId(trip.getId())
        .routeId(trip.getRouteId())
        .vehicleType(trip.getVehicleType())
        .occasionType(trip.getOccasionType())
        .completedAt(Instant.now())
        .build();

    kafkaTemplate.send("trip.completed", event);
}

// Consumer: Update trip statistics
@KafkaListener(topics = "trip.completed", groupId = "statistics-service")
public void updateTripStatistics(TripEvent event) {
    // Aggregate statistics for analytics
    statisticsService.updateTripStats(event);
}
```

### Key Kafka Concepts

#### Ordering Guarantees
```java
// All events for same booking go to same partition
// This guarantees order processing
kafkaTemplate.send(
    "booking.events",
    booking.getId().toString(),  // Partition key
    event
);
```

#### Consumer Groups
```java
// Same group = load balancing (each message processed once)
@KafkaListener(topics = "booking.events", groupId = "notification-group")

// Different groups = each receives all messages
@KafkaListener(topics = "booking.events", groupId = "analytics-group")
@KafkaListener(topics = "booking.events", groupId = "audit-group")
```

#### Backpressure & Retention
```java
// Kafka retains messages for configurable period (default: 7 days)
// Consumers can replay events from any offset
consumer.seekToBeginning(consumer.assignment());
```

---

## Elasticsearch <a name="elasticsearch"></a>

### What is Elasticsearch?

**Elasticsearch** is a distributed, RESTful search and analytics engine built on Apache Lucene:
- Full-text search
- Complex queries & aggregations
- Real-time analytics
- Geographic search

### Core Concepts

```
Index → Type (deprecated) → Document
         ↓
    Mapping (schema)
         ↓
    Fields (properties)
```

| Concept | Description | SQL Equivalent |
|---------|-------------|----------------|
| **Index** | Collection of documents | Database |
| **Document** | JSON record | Row |
| **Field** | Property in document | Column |
| **Mapping** | Schema definition | Schema |
| **Shard** | Split of index | Partition |
| **Replica** | Copy of shard | Replication |

### Document Structure

```json
// Route Document in Elasticsearch
{
  "_index": "routes",
  "_id": "123",
  "_source": {
    "routeCode": "HAN-SGN-001",
    "origin": {
      "stationId": 1,
      "name": "Nuoc Ngam Bus Station",
      "location": {
        "lat": 20.9914,
        "lon": 105.8525
      },
      "province": "Hanoi"
    },
    "destination": {
      "stationId": 2,
      "name": "Mien Dong Bus Station",
      "location": {
        "lat": 10.8231,
        "lon": 106.6297
      },
      "province": "Ho Chi Minh City"
    },
    "distanceKm": 1500,
    "baseFare": 800000,
    "vehicleTypes": ["LIMOUSINE", "STANDARD_BUS_VIP"],
    "active": true,
    "popularStops": ["Da Nang", "Hue", "Quang Ngai"]
  }
}
```

### RideHub Use Cases

#### 1. Route Search
```java
// Search routes by origin, destination, date
@Document(indexName = "routes")
public class RouteDocument {
    @Id
    private Long id;

    @Field(type = FieldType.Keyword)
    private String routeCode;

    @Field(type = FieldType.Object)
    private StationInfo origin;

    @Field(type = FieldType.Object)
    private StationInfo destination;

    @Field(type = FieldType.Double)
    private Double distanceKm;

    @Field(type = FieldType.Keyword)
    private List<String> vehicleTypes;

    @Field(type = FieldType.Boolean)
    private Boolean active;
}
```

```java
// Search query
public List<Route> searchRoutes(String from, String to, LocalDate date) {
    BoolQueryBuilder query = QueryBuilders.boolQuery()
        .must(QueryBuilders.matchQuery("origin.province", from))
        .must(QueryBuilders.matchQuery("destination.province", to))
        .must(QueryBuilders.termQuery("active", true));

    NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
        .withQuery(query)
        .build();

    return elasticsearchTemplate.queryForList(searchQuery, RouteDocument.class);
}
```

#### 2. Station Search
```java
// Autocomplete station search
public List<Station> searchStations(String keyword) {
    QueryBuilder query = QueryBuilders.multiMatchQuery(keyword)
        .field("name", 2.0f)       // Boost name matches
        .field("description", 1.0f)
        .field("province", 1.5f)
        .type(MultiMatchQueryBuilder.Type.BEST_FIELDS)
        .fuzziness(Fuzziness.AUTO);  // Fuzzy matching

    NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
        .withQuery(query)
        .withPageable(PageRequest.of(0, 10))
        .build();

    return elasticsearchTemplate.queryForList(searchQuery, StationDocument.class);
}
```

#### 3. Trip Statistics Analytics
```java
// Aggregation: Average occupancy by route
@Document(indexName = "trip-statistics")
public class TripStatisticsDocument {
    @Id
    private Long id;

    @Field(type = FieldType.Keyword)
    private Long routeId;

    @Field(type = FieldType.Keyword)
    private VehicleType vehicleType;

    @Field(type = FieldType.Keyword)
    private OccasionType occasionType;

    @Field(type = FieldType.Integer)
    private Integer totalBookings;

    @Field(type = FieldType.Double)
    private Double occupancyRate;

    @Field(type = FieldType.Date, format = DateFormat.date)
    private LocalDate validFrom;
}
```

```java
// Aggregation query
public Map<Long, Double> getAverageOccupancyByRoute() {
    AggregationBuilder aggregation = AggregationBuilders
        .terms("by_route")
        .field("routeId")
        .subAggregation(
            AggregationBuilders.avg("avg_occupancy")
                .field("occupancyRate")
        );

    SearchRequest searchRequest = new SearchRequest("trip-statistics");
    SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
    sourceBuilder.aggregation(aggregation);
    searchRequest.source(sourceBuilder);

    // Process results...
}
```

#### 4. Geographic Search
```java
// Find stations within radius
@Document(indexName = "stations")
public class StationDocument {
    // ... other fields

    @Field(type = FieldType.GeoPoint)
    private String location;  // "lat,lon"
}
```

```java
// Geo-distance query
public List<Station> findNearbyStations(double lat, double lon, double radiusKm) {
    QueryBuilder query = QueryBuilders.geoDistanceQuery("location")
        .point(lat, lon)
        .distance(radiusKm, DistanceUnit.KILOMETERS);

    GeoSortBuilder sortByDistance = SortBuilders.geoDistanceSort("location")
        .point(lat, lon)
        .order(SortOrder.ASC);

    NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
        .withQuery(query)
        .withSort(sortByDistance)
        .build();

    return elasticsearchTemplate.queryForList(searchQuery, StationDocument.class);
}
```

### Elasticsearch vs Traditional Database

| Feature | Elasticsearch | MySQL/PostgreSQL |
|---------|---------------|------------------|
| Search relevance | ✅ Built-in scoring | ❌ Complex queries |
| Full-text search | ✅ Optimized | ⚠️ Limited (LIKE %%) |
| Aggregations | ✅ Real-time analytics | ⚠️ Slower for complex |
| Geo queries | ✅ Native support | ⚠️ Requires extensions |
| Transactions | ❌ No ACID | ✅ Full ACID |
| CRUD operations | ⚠️ Not primary use | ✅ Excellent |
| Data freshness | Near real-time | Immediate |

---

## Integration in RideHub <a name="integration"></a>

### Architecture Overview

```
┌─────────────────────────────────────────────────────────────────────┐
│                          RideHub Architecture                       │
├─────────────────────────────────────────────────────────────────────┤
│                                                                     │
│  ┌──────────────┐    ┌──────────────┐    ┌──────────────┐         │
│  │   Gateway    │    │   Keycloak   │    │    Consul    │         │
│  │   :8080      │    │  (AuthN/Z)   │    │ (Discovery)  │         │
│  └──────────────┘    └──────────────┘    └──────────────┘         │
│                                                                     │
│  ┌─────────────────────────────────────────────────────────────┐   │
│  │                     Microservices                            │   │
│  ├────────────┬────────────┬────────────┬─────────────────────┤   │
│  │  ms_user   │ ms_route   │ ms_booking │ ms_promotion        │   │
│  │  :8081     │  :8082     │  :8083     │  :8084              │   │
│  │            │            │            │                     │   │
│  │  Redis     │  Redis     │  Redis     │  Redis              │   │
│  │            │  Kafka     │  Kafka     │  Kafka              │   │
│  │            │  ES        │            │                     │   │
│  └────────────┴────────────┴────────────┴─────────────────────┘   │
│                                                                     │
│  ┌─────────────────────────────────────────────────────────────┐   │
│  │                     Infrastructure                           │   │
│  ├────────────┬────────────┬─────────────────────────────────┤   │
│  │   Redis    │   Kafka    │      Elasticsearch              │   │
│  │  :6379     │  :9092     │  :9200 (HTTP)                   │   │
│  │            │            │  :9300 (Node comms)              │   │
│  └────────────┴────────────┴─────────────────────────────────┘   │
│                                                                     │
└─────────────────────────────────────────────────────────────────────┘
```

### Technology Usage Matrix

| Service | Redis | Kafka | Elasticsearch | MySQL |
|---------|-------|-------|---------------|-------|
| **Gateway** | Rate limiting | - | - | No DB |
| **ms_user** | Sessions | User events | - | ✅ |
| **ms_route** | Route cache, Seat locks | Route/trip events | Routes, Stations, Statistics | ✅ |
| **ms_booking** | Booking cache, Locks | Booking/payment events | - | ✅ |
| **ms_promotion** | Promotion cache | Promotion events | - | ✅ |

### Typical Booking Flow

```
User                    Gateway                ms_booking            ms_route
 │                       │                        │                     │
 │─1. Search routes─────>│                       │                     │
 │                       │─2. Query ES──────────>│                     │
 │                       │<──────Return──────────┤                     │
 │<────────Return────────┤                        │                     │
 │                       │                        │                     │
 │─3. Select trip───────>│                        │                     │
 │                       │───────────────────────>│                     │
 │                       │                        │─4. Check Redis──────>
 │                       │                        │<─Available──────────┤
 │<────────Return────────┤                        │                     │
 │                       │                        │                     │
 │─5. Lock seats────────>│                        │                     │
 │                       │───────────────────────>│                     │
 │                       │                        │─6. SET Redis lock───>
 │                       │                        │<──Success───────────┤
 │                       │                        │─7. Publish Kafka────>
 │                       │                        │      (seat locked)   │
 │<────────Confirm────────┤                        │                     │
 │                       │                        │                     │
 │─8. Complete payment──>│                        │                     │
 │                       │───────────────────────>│                     │
 │                       │                        │─9. Publish Kafka────>
 │                       │                        │    (payment done)    │
 │                       │                        │                     │
 │                       │                        │─10. Update MySQL────>
 │                       │<──────Booking OK──────┤                     │
 │<────────Ticket────────┤                        │                     │
 │                       │                        │                     │
 │                       │─11. Update statistics >│                     │
 │                       │    (Kafka consumer)    │                     │
```

### Docker Compose Snippet

```yaml
version: '3.8'

services:
  redis:
    image: redis:7-alpine
    ports:
      - "6379:6379"
    volumes:
      - redis_data:/data
    command: redis-server --appendonly yes

  kafka:
    image: confluentinc/cp-kafka:latest
    ports:
      - "9092:9092"
    environment:
      KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
      KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://localhost:9092
      KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR: 1

  elasticsearch:
    image: docker.elastic.co/elasticsearch/elasticsearch:8.11.0
    ports:
      - "9200:9200"
    environment:
      - discovery.type=single-node
      - xpack.security.enabled=false
    volumes:
      - es_data:/usr/share/elasticsearch/data

volumes:
  redis_data:
  es_data:
```

---

## Quick Reference Commands

### Redis
```bash
# Start Redis
docker run -d -p 6379:6379 redis:7-alpine

# Connect to CLI
docker exec -it <container> redis-cli

# Common operations
SET key value
GET key
KEYS *pattern*
DEL key
EXPIRE key seconds
FLUSHDB  # Clear current database
```

### Kafka
```bash
# Start Kafka (with Zookeeper)
docker-compose up -d kafka zookeeper

# Create topic
kafka-topics --create --topic booking.events --bootstrap-server localhost:9092

# List topics
kafka-topics --list --bootstrap-server localhost:9092

# Consume messages
kafka-console-consumer --topic booking.events --from-beginning --bootstrap-server localhost:9092

# Produce messages
kafka-console-producer --topic booking.events --bootstrap-server localhost:9092
```

### Elasticsearch
```bash
# Start Elasticsearch
docker run -d -p 9200:9200 -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:8.11.0

# Check health
curl -X GET "localhost:9200/_cluster/health"

# Create index
curl -X PUT "localhost:9200/routes" -H 'Content-Type: application/json' -d'
{
  "mappings": {
    "properties": {
      "routeCode": {"type": "keyword"},
      "origin": {"type": "text"},
      "destination": {"type": "text"}
    }
  }
}
'

# Search
curl -X GET "localhost:9200/routes/_search?q=Hanoi"
```

---

## Summary

| Technology | Primary Role | When to Use |
|------------|-------------|-------------|
| **Redis** | Fast cache & lock store | Session data, rate limiting, distributed locks, hot data |
| **Kafka** | Event streaming | Service communication, async processing, event sourcing |
| **Elasticsearch** | Search & analytics | Full-text search, aggregations, geographic queries |

### Key Takeaways

1. **Redis** = Speed (in-memory, microseconds)
2. **Kafka** = Reliability (durable log, message ordering)
3. **Elasticsearch** = Search power (relevance scoring, aggregations)

### Best Practices

1. **Use Redis for:**
   - Session storage (with TTL)
   - Distributed locks (short-lived)
   - Rate limiting
   - Hot data caching

2. **Use Kafka for:**
   - Cross-service events
   - Audit logging
   - Async processing
   - Data pipelines

3. **Use Elasticsearch for:**
   - User-facing search
   - Analytics dashboards
   - Log aggregation (ELK stack)
   - Geographic queries

---

**Document Version:** 1.0
**Last Updated:** 2024
**Project:** RideHub Bus Booking System
