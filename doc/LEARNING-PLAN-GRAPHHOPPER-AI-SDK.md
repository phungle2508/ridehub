# Learning Plan: GraphHopper & AI SDK for RideHub

This document provides a structured learning path for mastering **GraphHopper Routing API** and **ZAI AI SDK** in the context of the RideHub ride-sharing platform.

---

## Overview: How These Technologies Fit in RideHub

| Technology | Service Using It | Primary Purpose | Current Status |
|------------|-----------------|-----------------|----------------|
| **GraphHopper** | ms_route | Route distance calculation, geocoding, route optimization | ✅ Implemented |
| **ZAI AI SDK** | ms_user | AI chatbot, trip recommendations, user queries | ✅ Basic implementation |

### Current Implementation Status

#### GraphHopper (ms_route)
- ✅ REST API client configured
- ✅ Distance calculation between addresses
- ✅ Geocoding (address → coordinates)
- ⚠️ Basic integration only
- ❌ Advanced features not yet implemented

#### ZAI AI SDK (ms_user)
- ✅ Client configuration (`ZaiClient`)
- ✅ Properties management (`ZaiChatbotProperties`)
- ✅ Base URL: `https://api.z.ai/api/paas/v4/`
- ✅ Model: `glm-4.6` (GLM-4 from Zhipu AI)
- ⚠️ Basic chatbot setup
- ❌ Advanced AI features pending

---

## Part 1: GraphHopper API Mastery

### Week 1: GraphHopper Fundamentals

#### Day 1-2: Understanding GraphHopper Architecture

**Topics:**
- GraphHopper vs. self-hosted GraphHopper
- API vs. Open Source version differences
- Routing algorithms (Dijkstra, A*, Contraction Hierarchies)
- OSM (OpenStreetMap) data structure

**RideHub Context:**
- Currently using GraphHopper API (cloud service)
- Configured in `ms_route/src/main/resources/config/application.yml`
- Used for calculating `Route.distanceKm`
- Helps determine `Route.baseFare`

**Exercise:**
```bash
# Test your GraphHopper API key
curl -X GET "https://graphhopper.com/api/1/route?point=21.0285,105.8542&point=16.4637,107.5909&key=YOUR_API_KEY&vehicle=car"

# Expected response: route with distance and time
```

**Study Resources:**
- Official docs: https://docs.graphhopper.com/
- GraphHopper API playground: https://graphhopper.com/maps/
- OSM Vietnam data: https://download.geofabrik.de/asia/vietnam.html

#### Day 3-4: Routing API Deep Dive

**Topics:**
- Route calculation parameters
- Vehicle profiles (car, bike, foot)
- Custom speed profiles
- Turn-by-turn instructions
- Alternative routes
- Route optimization

**RideHub Context:**
Current implementation in `DistanceCalculationService.java`:
```java
public DistanceCalculationResponseDTO calculateDistance(
    DistanceCalculationRequestDTO request
) {
    // Uses points[]=lat,lon&points[]=lat,lon
    // Returns distance in meters and time in milliseconds
}
```

**Exercises:**

1. **Basic Routing:**
```bash
# Route from Hanoi to Hue
curl "https://graphhopper.com/api/1/route?\
point=21.0285,105.8542&\
point=16.4637,107.5909&\
vehicle=car&\
locale=vi&\
key=YOUR_API_KEY"
```

2. **Custom Parameters:**
```bash
# With instructions and elevation
curl "https://graphhopper.com/api/1/route?\
point=21.0285,105.8542&\
point=16.4637,107.5909&\
vehicle=car&\
instructions=true&\
elevation=true&\
points_encoded=false&\
key=YOUR_API_KEY"
```

3. **Multiple waypoints (for bus routes):**
```bash
# Hanoi → Ninh Binh → Hue
curl "https://graphhopper.com/api/1/route?\
point=21.0285,105.8542&\
point=20.2506,105.9745&\
point=16.4637,107.5909&\
vehicle=car&\
key=YOUR_API_KEY"
```

#### Day 5-7: Geocoding API

**Topics:**
- Forward geocoding (address → coordinates)
- Reverse geocoding (coordinates → address)
- Autocomplete/search suggestions
- Bounding box filtering
- Result ranking

**RideHub Context:**
Current implementation in `DistanceCalculationService.java`:
```java
private double[] geocode(String address) {
    // Calls GraphHopper Geocoding API
    // Returns [latitude, longitude]
}
```

**Exercises:**

1. **Forward Geocoding:**
```bash
# Find coordinates for "Số 1 Đại Cồ Việt, Hai Bà Trưng, Hà Nội"
curl "https://graphhopper.com/api/1/geocode?\
q=Số 1 Đại Cồ Việt, Hai Bà Trưng, Hà Nội&\
locale=vi&\
key=YOUR_API_KEY"
```

2. **Reverse Geocoding:**
```bash
# Find address from coordinates
curl "https://graphhopper.com/api/1/geocode?\
reverse=true&\
point=21.0285,105.8542&\
locale=vi&\
key=YOUR_API_KEY"
```

3. **Autocomplete:**
```bash
# Search suggestions for "Bến xe"
curl "https://graphhopper.com/api/1/geocode?\
q=Bến xe&\
limit=5&\
locale=vi&\
key=YOUR_API_KEY"
```

### Week 2: Advanced GraphHopper Features

#### Day 8-10: Route Optimization API

**Topics:**
- Vehicle Routing Problem (VRP)
- Traveling Salesman Problem (TSP)
- Multiple vehicles
- Time windows
- Capacity constraints
- Priority handling

**RideHub Use Cases:**
- Optimize multiple route stops for a bus
- Schedule multiple trips efficiently
- Minimize total travel time for all vehicles
- Handle capacity constraints (seat availability)

**Exercise:**
```json
// POST to https://graphhopper.com/api/1/vrp
{
  "vehicles": [
    {
      "vehicle_id": "vehicle1",
      "start_address": {
        "location_id": "hanoi_station",
        "lat": 21.0285,
        "lon": 105.8542
      },
      "type_id": "bus_40_seats"
    }
  ],
  "vehicle_types": [
    {
      "type_id": "bus_40_seats",
      "capacity": [40],
      "profile": "car"
    }
  ],
  "services": [
    {
      "id": "pickup_1",
      "name": "Ninh Binh pickup",
      "address": {
        "location_id": "ninhbinh",
        "lat": 20.2506,
        "lon": 105.9745
      },
      "size": [15],
      "duration": 300
    },
    {
      "id": "pickup_2",
      "name": "Thanh Hoa pickup",
      "address": {
        "location_id": "thanhhoa",
        "lat": 19.8067,
        "lon": 105.7851
      },
      "size": [20],
      "duration": 300
    }
  ]
}
```

#### Day 11-12: Matrix API for Distance/Time Matrices

**Topics:**
- One-to-many distance calculations
- Many-to-many matrices
- Use cases for fare calculation
- Performance optimization

**RideHub Use Cases:**
- Calculate fares for all routes from one station
- Pre-compute distance matrices for popular routes
- Cache results in Redis

**Exercise:**
```bash
# Calculate distances from Hanoi to multiple destinations
curl -X POST "https://graphhopper.com/api/1/matrix?key=YOUR_API_KEY" \
  -H "Content-Type: application/json" \
  -d '{
    "points": [
      [105.8542, 21.0285],
      [105.9745, 20.2506],
      [105.7851, 19.8067],
      [107.5909, 16.4637]
    ],
    "from_points": [0],
    "to_points": [1, 2, 3],
    "out_arrays": ["distances", "times"]
  }'
```

#### Day 13-14: Spring Integration & Caching

**Topics:**
- RestTemplate vs WebClient
- Connection pooling
- Error handling and retries
- Caching strategies with Redis
- Rate limiting

**Implementation:**
```java
// Enhanced DistanceCalculationService
@Service
public class DistanceCalculationService {
    
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    
    @Cacheable(value = "route-distances", key = "#from + ':' + #to")
    public DistanceCalculationResponseDTO calculateDistance(
        String from, String to
    ) {
        // Check cache first
        String cacheKey = "gh:distance:" + from + ":" + to;
        DistanceCalculationResponseDTO cached = 
            (DistanceCalculationResponseDTO) redisTemplate.opsForValue().get(cacheKey);
        
        if (cached != null) {
            return cached;
        }
        
        // Call GraphHopper API
        DistanceCalculationResponseDTO result = callGraphHopperAPI(from, to);
        
        // Cache for 24 hours
        redisTemplate.opsForValue().set(cacheKey, result, 24, TimeUnit.HOURS);
        
        return result;
    }
    
    @Retryable(
        value = { RestClientException.class },
        maxAttempts = 3,
        backoff = @Backoff(delay = 1000)
    )
    private DistanceCalculationResponseDTO callGraphHopperAPI(
        String from, String to
    ) {
        // Actual API call with retry logic
    }
}
```

---

## Part 2: ZAI AI SDK Mastery

### Week 3: ZAI SDK Fundamentals

#### Day 15-17: Understanding ZAI Platform

**Topics:**
- Zhipu AI (智谱AI) platform overview
- GLM models (GLM-4, GLM-4-Air, GLM-4-Flash)
- API authentication and security
- Token management
- Usage and billing

**RideHub Context:**
Current configuration in `ZaiChatbotProperties.java`:
```java
@ConfigurationProperties(prefix = "zai.chatbot")
public class ZaiChatbotProperties {
    private String apiKey;
    private String baseUrl = "https://api.z.ai/api/paas/v4/";
    private String model = "glm-4.6";  // GLM-4 series
    private Float temperature = 1.0f;
    private Integer maxTokens = 1024;
    private Boolean enableTokenCache = true;
    private Long tokenExpire = 3600000L; // 1 hour
}
```

**Resources:**
- Official docs: https://open.bigmodel.cn/dev/api
- Model comparison: GLM-4 (most powerful) vs GLM-4-Air (balanced) vs GLM-4-Flash (fastest)
- Pricing: Check current rates for API calls

**Exercise:**
```java
// Test ZAI client initialization
@SpringBootTest
public class ZaiClientTest {
    
    @Autowired
    private ZaiClient zaiClient;
    
    @Test
    public void testConnection() {
        // Simple completion test
        String response = zaiClient.chat()
            .setModel("glm-4.6")
            .setMessage("Hello, can you help me with RideHub?")
            .execute();
        
        assertNotNull(response);
    }
}
```

#### Day 18-19: Chat Completion API

**Topics:**
- Chat vs Completion endpoints
- Message roles (system, user, assistant)
- Temperature and top_p parameters
- Max tokens control
- Stop sequences
- Streaming responses

**RideHub Use Cases:**
According to the JDL, ms_user has these AI-related entities:
- `ChatSession` - conversation history
- `ChatMessage` - individual messages
- `UserQuery` - user questions
- `TripRecommendation` - AI-generated suggestions

**Implementation:**
```java
@Service
public class ChatbotService {
    
    @Autowired
    private ZaiClient zaiClient;
    
    @Autowired
    private ZaiChatbotProperties properties;
    
    public ChatMessageDTO sendMessage(
        Long userId, 
        Long sessionId, 
        String message
    ) {
        // Fetch chat history
        List<ChatMessage> history = getChatHistory(sessionId);
        
        // Build messages array
        List<Map<String, String>> messages = buildMessages(history, message);
        
        // Call ZAI API
        ZaiChatResponse response = zaiClient.chat()
            .setModel(properties.getModel())
            .setMessages(messages)
            .setTemperature(properties.getTemperature())
            .setMaxTokens(properties.getMaxTokens())
            .execute();
        
        // Save to database
        saveChatMessage(sessionId, "user", message);
        saveChatMessage(sessionId, "assistant", response.getContent());
        
        return mapToDTO(response);
    }
    
    private List<Map<String, String>> buildMessages(
        List<ChatMessage> history, 
        String newMessage
    ) {
        List<Map<String, String>> messages = new ArrayList<>();
        
        // System prompt
        messages.add(Map.of(
            "role", "system",
            "content", """
                You are a helpful assistant for RideHub, a bus booking platform in Vietnam.
                You can help users with:
                - Finding bus routes
                - Checking schedules
                - Booking tickets
                - Answering questions about trips
                Always respond in Vietnamese unless asked otherwise.
                """
        ));
        
        // Add history
        for (ChatMessage msg : history) {
            messages.add(Map.of(
                "role", msg.getRole(),
                "content", msg.getContent()
            ));
        }
        
        // Add new message
        messages.add(Map.of(
            "role", "user",
            "content", newMessage
        ));
        
        return messages;
    }
}
```

#### Day 20-21: Function Calling (Tools)

**Topics:**
- Function/tool definitions
- Auto function calling
- Parallel function calls
- Error handling

**RideHub Use Cases:**
Allow AI to call backend functions:
- Search available routes
- Get trip schedule
- Check seat availability
- Book tickets (with confirmation)
- Get booking status

**Implementation:**
```java
public class ChatbotService {
    
    private List<ToolDefinition> getAvailableTools() {
        return List.of(
            // Search routes
            ToolDefinition.builder()
                .name("search_routes")
                .description("Search for bus routes between two cities")
                .parameters(Map.of(
                    "type", "object",
                    "properties", Map.of(
                        "origin", Map.of(
                            "type", "string",
                            "description", "Origin city name"
                        ),
                        "destination", Map.of(
                            "type", "string",
                            "description", "Destination city name"
                        ),
                        "date", Map.of(
                            "type", "string",
                            "description", "Travel date in YYYY-MM-DD format"
                        )
                    ),
                    "required", List.of("origin", "destination", "date")
                ))
                .build(),
            
            // Get available seats
            ToolDefinition.builder()
                .name("get_available_seats")
                .description("Get available seats for a specific trip")
                .parameters(Map.of(
                    "type", "object",
                    "properties", Map.of(
                        "tripId", Map.of(
                            "type", "integer",
                            "description", "Trip ID"
                        )
                    ),
                    "required", List.of("tripId")
                ))
                .build(),
            
            // Get user bookings
            ToolDefinition.builder()
                .name("get_user_bookings")
                .description("Get user's booking history")
                .parameters(Map.of(
                    "type", "object",
                    "properties", Map.of(
                        "userId", Map.of(
                            "type", "string",
                            "description", "User UUID"
                        ),
                        "status", Map.of(
                            "type", "string",
                            "enum", List.of("CONFIRMED", "PAID", "CANCELED"),
                            "description", "Optional: filter by booking status"
                        )
                    ),
                    "required", List.of("userId")
                ))
                .build()
        );
    }
    
    public ChatMessageDTO sendMessageWithTools(
        Long userId, 
        String message
    ) {
        ZaiChatResponse response = zaiClient.chat()
            .setModel(properties.getModel())
            .setMessages(buildMessages(message))
            .setTools(getAvailableTools())
            .setToolChoice("auto")  // Let AI decide when to use tools
            .execute();
        
        // Check if AI wants to call a function
        if (response.hasToolCalls()) {
            for (ToolCall toolCall : response.getToolCalls()) {
                Object result = executeToolCall(toolCall);
                
                // Send function result back to AI
                messages.add(Map.of(
                    "role", "tool",
                    "tool_call_id", toolCall.getId(),
                    "content", objectMapper.writeValueAsString(result)
                ));
            }
            
            // Get final response from AI
            response = zaiClient.chat()
                .setMessages(messages)
                .execute();
        }
        
        return mapToDTO(response);
    }
    
    private Object executeToolCall(ToolCall toolCall) {
        switch (toolCall.getFunction().getName()) {
            case "search_routes":
                return searchRoutes(toolCall.getFunction().getArguments());
            case "get_available_seats":
                return getAvailableSeats(toolCall.getFunction().getArguments());
            case "get_user_bookings":
                return getUserBookings(toolCall.getFunction().getArguments());
            default:
                throw new IllegalArgumentException("Unknown tool: " + toolCall.getName());
        }
    }
}
```

### Week 4: Advanced AI Features

#### Day 22-24: RAG (Retrieval Augmented Generation)

**Topics:**
- Vector embeddings
- Similarity search
- Knowledge base creation
- Context injection
- Hybrid search (vector + keyword)

**RideHub Use Cases:**
- Search FAQ using semantic search
- Find similar routes based on user query
- Recommend routes based on travel history
- Answer questions about policies

**Implementation:**
```java
@Service
public class EmbeddingService {
    
    @Autowired
    private ZaiClient zaiClient;
    
    @Autowired
    private ElasticsearchClient esClient;
    
    // Generate embedding for text
    public float[] generateEmbedding(String text) {
        EmbeddingResponse response = zaiClient.embedding()
            .setModel("embedding-2")
            .setInput(text)
            .execute();
        
        return response.getData().get(0).getEmbedding();
    }
    
    // Store route in vector DB
    public void indexRoute(Route route) {
        String description = String.format(
            "Route %s from %s to %s, distance %s km, fare %s VND",
            route.getRouteCode(),
            route.getOrigin().getName(),
            route.getDestination().getName(),
            route.getDistanceKm(),
            route.getBaseFare()
        );
        
        float[] embedding = generateEmbedding(description);
        
        // Store in Elasticsearch with vector field
        RouteDocument doc = RouteDocument.builder()
            .id(route.getId())
            .routeCode(route.getRouteCode())
            .description(description)
            .embedding(embedding)
            .build();
        
        esClient.index(doc);
    }
    
    // Search routes semantically
    public List<Route> semanticSearchRoutes(String query) {
        float[] queryEmbedding = generateEmbedding(query);
        
        // Use Elasticsearch kNN search
        SearchResponse<RouteDocument> response = esClient.search(s -> s
            .index("routes")
            .knn(k -> k
                .field("embedding")
                .queryVector(queryEmbedding)
                .k(5)
                .numCandidates(100)
            ),
            RouteDocument.class
        );
        
        return response.hits().hits().stream()
            .map(hit -> routeRepository.findById(hit.source().getId()))
            .filter(Optional::isPresent)
            .map(Optional::get)
            .collect(Collectors.toList());
    }
}
```

#### Day 25-28: Trip Recommendation System

**Topics:**
- User behavior analysis
- Collaborative filtering
- Content-based filtering
- Hybrid recommendation
- Personalization

**RideHub Use Cases:**
According to JDL entities:
- `UserStatistics` - tracks user preferences
- `TripStatistics` - aggregates trip data
- `TripRecommendation` - AI-generated suggestions

**Implementation:**
```java
@Service
public class TripRecommendationService {
    
    @Autowired
    private ZaiClient zaiClient;
    
    @Autowired
    private UserStatisticsRepository userStatsRepo;
    
    @Autowired
    private TripStatisticsRepository tripStatsRepo;
    
    public List<TripRecommendation> recommendTrips(Long userId) {
        // Get user statistics
        UserStatistics userStats = userStatsRepo.findByUserId(userId);
        
        // Get popular trips
        List<TripStatistics> popularTrips = tripStatsRepo.findTopByOccupancyRate();
        
        // Build prompt for AI
        String prompt = buildRecommendationPrompt(userStats, popularTrips);
        
        // Call AI
        ZaiChatResponse response = zaiClient.chat()
            .setModel("glm-4.6")
            .setMessages(List.of(
                Map.of("role", "system", "content", """
                    You are a trip recommendation expert for RideHub.
                    Analyze user travel patterns and suggest relevant trips.
                    Consider: favorite routes, preferred times, budget, occasion.
                    Return recommendations as JSON array.
                    """),
                Map.of("role", "user", "content", prompt)
            ))
            .setResponseFormat(Map.of("type", "json_object"))
            .execute();
        
        // Parse and save recommendations
        return parseAndSaveRecommendations(userId, response.getContent());
    }
    
    private String buildRecommendationPrompt(
        UserStatistics userStats,
        List<TripStatistics> popularTrips
    ) {
        return String.format("""
            User Profile:
            - Total trips: %d
            - Favorite routes: %s
            - Preferred vehicle types: %s
            - Average trip duration: %d minutes
            - Most frequent origin: %s
            - Most frequent destination: %s
            - Budget range: %s VND
            - Travel frequency: %s
            
            Popular trips this month:
            %s
            
            Recommend 3-5 trips that match this user's preferences.
            """,
            userStats.getTotalTrips(),
            userStats.getFavoriteRoutes(),
            userStats.getPreferredVehicleTypes(),
            userStats.getAverageTripDuration(),
            userStats.getMostFrequentOrigin(),
            userStats.getMostFrequentDestination(),
            calculateBudgetRange(userStats),
            userStats.getBookingFrequency(),
            formatPopularTrips(popularTrips)
        );
    }
}
```

---

## Part 3: Integration Projects

### Week 5-6: Build Real Features

#### Project 1: Smart Route Search (Days 29-33)

**Goal:** Users can search for routes using natural language and get AI-powered suggestions.

**Tech Stack:**
- GraphHopper for distance/geocoding
- ZAI AI SDK for natural language understanding
- Elasticsearch for vector search
- Redis for caching

**Features:**
1. Natural language query (e.g., "Tôi muốn đi từ Hà Nội đến Huế vào cuối tuần")
2. AI extracts: origin, destination, date, preferences
3. GraphHopper calculates distances
4. Use vector search to find similar routes
5. AI ranks results based on user preferences

**Implementation Steps:**

```java
@RestController
@RequestMapping("/api/smart-search")
public class SmartSearchResource {
    
    @Autowired
    private ChatbotService chatbotService;
    
    @Autowired
    private GraphHopperService graphHopperService;
    
    @Autowired
    private RouteSearchService routeSearchService;
    
    @PostMapping("/routes")
    public ResponseEntity<SmartSearchResponse> smartSearch(
        @RequestBody SmartSearchRequest request
    ) {
        // 1. Use AI to parse natural language query
        SearchIntent intent = chatbotService.parseSearchIntent(request.getQuery());
        
        // 2. Geocode locations if needed
        if (intent.needsGeocoding()) {
            intent.setOriginCoords(
                graphHopperService.geocode(intent.getOrigin())
            );
            intent.setDestinationCoords(
                graphHopperService.geocode(intent.getDestination())
            );
        }
        
        // 3. Search routes (vector + keyword)
        List<Route> routes = routeSearchService.search(intent);
        
        // 4. Calculate distances and times
        for (Route route : routes) {
            DistanceInfo info = graphHopperService.calculateDistance(
                route.getOrigin().getAddress(),
                route.getDestination().getAddress()
            );
            route.setCalculatedDistance(info.getDistance());
            route.setCalculatedDuration(info.getDuration());
        }
        
        // 5. Use AI to rank and explain results
        RankedResults results = chatbotService.rankAndExplain(
            routes,
            intent,
            request.getUserId()
        );
        
        return ResponseEntity.ok(results);
    }
}
```

#### Project 2: AI Travel Assistant (Days 34-38)

**Goal:** Conversational chatbot that helps users plan trips, book tickets, and get support.

**Features:**
1. Multi-turn conversations with context
2. Function calling to backend APIs
3. Trip planning and recommendations
4. Booking assistance with confirmation
5. FAQ and support

**Implementation:**
```java
@RestController
@RequestMapping("/api/chat")
public class ChatbotResource {
    
    @Autowired
    private ChatbotService chatbotService;
    
    @PostMapping("/sessions/{sessionId}/messages")
    public ResponseEntity<ChatMessageResponse> sendMessage(
        @PathVariable Long sessionId,
        @RequestBody ChatMessageRequest request,
        @AuthenticationPrincipal OAuth2AuthenticatedPrincipal principal
    ) {
        Long userId = getUserId(principal);
        
        ChatMessageResponse response = chatbotService.sendMessageWithTools(
            userId,
            sessionId,
            request.getMessage()
        );
        
        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/sessions")
    public ResponseEntity<ChatSession> createSession(
        @AuthenticationPrincipal OAuth2AuthenticatedPrincipal principal
    ) {
        Long userId = getUserId(principal);
        ChatSession session = chatbotService.createSession(userId);
        return ResponseEntity.ok(session);
    }
    
    @GetMapping("/sessions/{sessionId}/history")
    public ResponseEntity<List<ChatMessage>> getChatHistory(
        @PathVariable Long sessionId,
        @AuthenticationPrincipal OAuth2AuthenticatedPrincipal principal
    ) {
        Long userId = getUserId(principal);
        List<ChatMessage> history = chatbotService.getChatHistory(sessionId, userId);
        return ResponseEntity.ok(history);
    }
}
```

#### Project 3: Intelligent Route Optimization (Days 39-42)

**Goal:** Use GraphHopper's route optimization to suggest optimal bus routes.

**Features:**
1. Multi-stop route planning
2. Time window constraints
3. Vehicle capacity optimization
4. Real-time traffic consideration

**Implementation:**
```java
@Service
public class RouteOptimizationService {
    
    @Autowired
    private GraphHopperService graphHopperService;
    
    public OptimizedRoute optimizeRoute(OptimizationRequest request) {
        // Build VRP request
        VRPRequest vrpRequest = VRPRequest.builder()
            .vehicles(List.of(
                Vehicle.builder()
                    .vehicleId(request.getVehicleId())
                    .startAddress(request.getStartStation())
                    .typeId("bus_" + request.getCapacity() + "_seats")
                    .build()
            ))
            .vehicleTypes(List.of(
                VehicleType.builder()
                    .typeId("bus_" + request.getCapacity() + "_seats")
                    .capacity(List.of(request.getCapacity()))
                    .profile("car")
                    .build()
            ))
            .services(buildServices(request.getStops()))
            .build();
        
        // Call GraphHopper Optimization API
        VRPResponse response = graphHopperService.optimizeRoute(vrpRequest);
        
        // Parse and save optimized route
        return parseVRPResponse(response);
    }
}
```

---

## Learning Resources

### GraphHopper Resources
- **Official Documentation:** https://docs.graphhopper.com/
- **API Reference:** https://docs.graphhopper.com/api/1/
- **GitHub:** https://github.com/graphhopper/graphhopper
- **Community Forum:** https://discuss.graphhopper.com/
- **Blog:** https://www.graphhopper.com/blog/

### ZAI (Zhipu AI) Resources
- **Official Platform:** https://open.bigmodel.cn/
- **API Documentation:** https://open.bigmodel.cn/dev/api
- **Model Documentation:** https://open.bigmodel.cn/dev/howuse/model
- **GitHub Examples:** Search for "zhipu ai" or "glm-4" examples
- **Community:** Chinese AI forums and WeChat groups

### General AI/ML Resources
- **LangChain (Python):** https://python.langchain.com/
  - Learn RAG patterns
  - Function calling patterns
  - Agent design
- **Elasticsearch Vector Search:** https://www.elastic.co/guide/en/elasticsearch/reference/current/knn-search.html
- **Spring AI:** https://spring.io/projects/spring-ai (emerging project)

---

## Practice Checklist

Track your progress:

### GraphHopper
- [ ] Set up GraphHopper API key
- [ ] Test basic routing API
- [ ] Implement geocoding service
- [ ] Calculate route matrices
- [ ] Test route optimization API
- [ ] Integrate with Redis caching
- [ ] Handle API errors and retries
- [ ] Implement rate limiting

### ZAI AI SDK
- [ ] Configure ZaiClient
- [ ] Test basic chat completion
- [ ] Implement system prompts
- [ ] Add function/tool calling
- [ ] Build RAG pipeline with embeddings
- [ ] Create trip recommendation engine
- [ ] Implement streaming responses
- [ ] Set up token caching

### Integration
- [ ] Build smart route search
- [ ] Create AI travel assistant chatbot
- [ ] Implement route optimization
- [ ] Add natural language query parsing
- [ ] Build personalized recommendations
- [ ] Test end-to-end user flows

---

## Next Steps After Completing This Plan

1. **Advanced AI Features:**
   - Fine-tuning GLM models for RideHub-specific tasks
   - Multi-modal AI (images for stations, vehicles)
   - Voice interface integration
   - Sentiment analysis for customer feedback

2. **GraphHopper Optimization:**
   - Self-hosted GraphHopper for cost reduction
   - Custom routing profiles for Vietnam roads
   - Real-time traffic integration
   - Historical data analysis

3. **Production Readiness:**
   - Monitoring and observability
   - A/B testing for AI features
   - Cost optimization (caching, batching)
   - Security and data privacy
   - Compliance with Vietnam regulations

4. **Advanced Integrations:**
   - Combine GraphHopper + AI for dynamic pricing
   - Predictive analytics for demand forecasting
   - Automated route planning based on demand
   - Real-time event detection (traffic, weather)

---

## Measurement of Success

### GraphHopper Metrics
- Distance calculation accuracy (compare with actual GPS data)
- API response time < 500ms
- Cache hit rate > 80%
- API cost reduction through caching

### AI Metrics
- User satisfaction with chatbot (4+ stars)
- Booking conversion rate from AI recommendations > 15%
- Query understanding accuracy > 90%
- Function calling success rate > 95%
- Response time < 2s for non-streaming

### Business Impact
- Increase in bookings from AI recommendations: +20%
- Reduction in customer support tickets: -30%
- User engagement with chatbot: 40%+ of users
- Route optimization savings: 10%+ in fuel/time
