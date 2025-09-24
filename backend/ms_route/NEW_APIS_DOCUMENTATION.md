# New APIs Documentation

This document describes the new APIs created for ticket management and station management based on the provided UI mockups.

## Ticket Management APIs

### Base URL: `/api/ticket-management`

#### 1. Get All Tickets
- **Endpoint**: `GET /tickets`
- **Description**: Retrieve all tickets with filtering and pagination
- **Parameters**: 
  - `TicketFilterDTO` (query parameters for filtering)
  - `Pageable` (pagination parameters)
- **Response**: List of `TicketListDTO` with pagination headers

#### 2. Get Ticket by Code
- **Endpoint**: `GET /tickets/{ticketCode}`
- **Description**: Retrieve a specific ticket by its code
- **Parameters**: `ticketCode` (path variable)
- **Response**: `TicketListDTO` or 404 if not found

#### 3. Get Tickets by Customer
- **Endpoint**: `GET /tickets/customer/{customerId}`
- **Description**: Retrieve all tickets for a specific customer
- **Parameters**: 
  - `customerId` (path variable, UUID)
  - `Pageable` (pagination parameters)
- **Response**: List of `TicketListDTO` with pagination headers

#### 4. Get Tickets by Trip
- **Endpoint**: `GET /tickets/trip/{tripId}`
- **Description**: Retrieve all tickets for a specific trip
- **Parameters**: 
  - `tripId` (path variable, Long)
  - `Pageable` (pagination parameters)
- **Response**: List of `TicketListDTO` with pagination headers

#### 5. Get Tickets by Status
- **Endpoint**: `GET /tickets/status/{status}`
- **Description**: Retrieve all tickets with a specific status
- **Parameters**: 
  - `status` (path variable, String)
  - `Pageable` (pagination parameters)
- **Response**: List of `TicketListDTO` with pagination headers

#### 6. Search Tickets
- **Endpoint**: `GET /tickets/search`
- **Description**: Search tickets by query string
- **Parameters**: 
  - `query` (query parameter, String)
  - `Pageable` (pagination parameters)
- **Response**: List of `TicketListDTO` with pagination headers

#### 7. Get Available Statuses
- **Endpoint**: `GET /tickets/statuses`
- **Description**: Get list of available ticket statuses
- **Response**: List of status strings

#### 8. Update Ticket Status
- **Endpoint**: `PUT /tickets/{ticketCode}/status`
- **Description**: Update the status of a specific ticket
- **Parameters**: 
  - `ticketCode` (path variable)
  - `status` (query parameter, new status)
- **Response**: Updated `TicketListDTO` or 404 if not found

#### 9. Export Tickets
- **Endpoint**: `POST /tickets/export`
- **Description**: Export tickets to Excel file
- **Parameters**: `TicketFilterDTO` (request body)
- **Response**: Excel file as byte array

## Station Management APIs

### Base URL: `/api/station-management`

#### 1. Get All Stations
- **Endpoint**: `GET /stations`
- **Description**: Retrieve all stations with filtering and pagination
- **Parameters**: 
  - `StationFilterDTO` (query parameters for filtering)
  - `Pageable` (pagination parameters)
- **Response**: List of `StationListDTO` with pagination headers

#### 2. Get Station by ID
- **Endpoint**: `GET /stations/{stationId}`
- **Description**: Retrieve a specific station by its ID
- **Parameters**: `stationId` (path variable, Long)
- **Response**: `StationListDTO` or 404 if not found

#### 3. Get Stations by Route
- **Endpoint**: `GET /stations/route/{routeName}`
- **Description**: Retrieve all stations for a specific route
- **Parameters**: 
  - `routeName` (path variable, String)
  - `Pageable` (pagination parameters)
- **Response**: List of `StationListDTO` with pagination headers

#### 4. Get Stations by Type
- **Endpoint**: `GET /stations/type/{stationType}`
- **Description**: Retrieve all stations of a specific type
- **Parameters**: 
  - `stationType` (path variable, String)
  - `Pageable` (pagination parameters)
- **Response**: List of `StationListDTO` with pagination headers

#### 5. Get Stations by Status
- **Endpoint**: `GET /stations/status/{status}`
- **Description**: Retrieve all stations with a specific status
- **Parameters**: 
  - `status` (path variable, String)
  - `Pageable` (pagination parameters)
- **Response**: List of `StationListDTO` with pagination headers

#### 6. Search Stations
- **Endpoint**: `GET /stations/search`
- **Description**: Search stations by query string
- **Parameters**: 
  - `query` (query parameter, String)
  - `Pageable` (pagination parameters)
- **Response**: List of `StationListDTO` with pagination headers

#### 7. Get Available Station Types
- **Endpoint**: `GET /stations/types`
- **Description**: Get list of available station types
- **Response**: List of station type strings

#### 8. Get Available Statuses
- **Endpoint**: `GET /stations/statuses`
- **Description**: Get list of available station statuses
- **Response**: List of status strings

#### 9. Update Station Status
- **Endpoint**: `PUT /stations/{stationId}/status`
- **Description**: Update the status of a specific station
- **Parameters**: 
  - `stationId` (path variable, Long)
  - `status` (query parameter, new status)
- **Response**: Updated `StationListDTO` or 404 if not found

#### 10. Add Station to Route
- **Endpoint**: `POST /stations/{stationId}/route`
- **Description**: Add a station to a route
- **Parameters**: 
  - `stationId` (path variable, Long)
  - `routeName` (query parameter, String)
  - `orderInRoute` (query parameter, Integer)
- **Response**: Updated `StationListDTO` or 404 if not found

#### 11. Remove Station from Route
- **Endpoint**: `DELETE /stations/{stationId}/route/{routeName}`
- **Description**: Remove a station from a route
- **Parameters**: 
  - `stationId` (path variable, Long)
  - `routeName` (path variable, String)
- **Response**: Updated `StationListDTO` or 404 if not found

## Data Transfer Objects (DTOs)

### TicketListDTO
Contains ticket information for display in the ticket list interface:
- `ticketCode`: Ticket identifier
- `customerName`: Customer full name
- `customerPhone`: Customer phone number
- `customerAvatar`: Customer avatar URL
- `routeName`: Route name/code
- `originStation`: Origin station name
- `destinationStation`: Destination station name
- `departureTime`: Departure time
- `arrivalTime`: Arrival time
- `seatNumbers`: List of seat numbers
- `ticketStatus`: Current ticket status
- `totalPrice`: Total ticket price
- `bookingId`: Associated booking ID
- `tripId`: Associated trip ID
- `customerId`: Customer ID

### StationListDTO
Contains station information for display in the station list interface:
- `stationId`: Station identifier
- `stationName`: Station name
- `address`: Full address
- `stationType`: Type of station (Dón/Trả, Pickup, Drop-off, etc.)
- `routeName`: Associated route name
- `routeCode`: Associated route code
- `orderInRoute`: Order in the route
- `status`: Current station status
- `createdAt`: Creation timestamp
- `updatedAt`: Last update timestamp
- `phoneNumber`: Station phone number
- `description`: Station description
- `active`: Whether station is active

### Filter DTOs
- `TicketFilterDTO`: For filtering ticket searches
- `StationFilterDTO`: For filtering station searches

## External Service Integration

The APIs integrate with external microservices:
- **msbooking**: For booking and ticket data
- **msuser**: For customer information

The integration is handled through the `ExternalServiceIntegration` service which provides:
- Booking data retrieval
- Customer data retrieval
- Status updates
- Search functionality

## Notes

1. All APIs support pagination using Spring Data's `Pageable` interface
2. The implementation currently uses mock data but is structured to easily integrate with actual external services
3. Error handling is implemented with appropriate HTTP status codes
4. All endpoints are secured and follow RESTful conventions
5. Integration tests are provided for both ticket and station management APIs
