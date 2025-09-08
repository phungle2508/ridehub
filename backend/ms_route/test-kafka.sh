#!/bin/bash

# Test Kafka functionality for ms_route service
echo "🚀 Testing Kafka functionality for ms_route service"
echo "==========================================="

BASE_URL="http://localhost:8082"
API_PATH="/api/ms-route-kafka"

echo "1. Testing Kafka status..."
curl -s "${BASE_URL}${API_PATH}/status" | jq .
echo ""

echo "2. Testing simple message publishing..."
curl -s -X POST "${BASE_URL}${API_PATH}/publish/simple?message=Hello%20Kafka%20from%20ms_route" | jq .
echo ""

echo "3. Testing route event publishing..."
ROUTE_DATA='{
  "id": 1,
  "routeNames": "Test Route",
  "startLocation": "City A",
  "endLocation": "City B",
  "distance": 100.5,
  "estimatedDuration": "2 hours"
}'

echo "Route created event:"
curl -s -X POST "${BASE_URL}${API_PATH}/publish/route-created" \
  -H "Content-Type: application/json" \
  -d "${ROUTE_DATA}" | jq .
echo ""

echo "Route updated event:"
curl -s -X POST "${BASE_URL}${API_PATH}/publish/route-updated" \
  -H "Content-Type: application/json" \
  -d "${ROUTE_DATA}" | jq .
echo ""

echo "Route deleted event:"
curl -s -X DELETE "${BASE_URL}${API_PATH}/publish/route-deleted/1" | jq .
echo ""

echo "4. Testing general connectivity..."
curl -s -X GET "${BASE_URL}${API_PATH}/test" | jq .
echo ""

echo "✅ Kafka test completed!"
echo ""
echo "📝 To monitor SSE events, open another terminal and run:"
echo "   curl -s ${BASE_URL}${API_PATH}/register"
echo ""
echo "📚 Available endpoints:"
echo "   GET  ${BASE_URL}${API_PATH}/status"
echo "   GET  ${BASE_URL}${API_PATH}/test"
echo "   POST ${BASE_URL}${API_PATH}/publish/simple?message=<your_message>"
echo "   POST ${BASE_URL}${API_PATH}/publish/route-created"
echo "   POST ${BASE_URL}${API_PATH}/publish/route-updated"
echo "   DELETE ${BASE_URL}${API_PATH}/publish/route-deleted/{id}"
echo "   GET  ${BASE_URL}${API_PATH}/register (SSE)"
echo "   GET  ${BASE_URL}${API_PATH}/unregister"
