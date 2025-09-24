package com.ridehub.route.service.impl;

import com.ridehub.route.domain.Station;
import com.ridehub.route.repository.StationRepository;
import com.ridehub.route.repository.RouteRepository;
import com.ridehub.route.service.StationManagementService;
import com.ridehub.route.service.dto.StationFilterDTO;
import com.ridehub.route.service.dto.StationListDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing station list operations.
 */
@Service
@Transactional
public class StationManagementServiceImpl implements StationManagementService {

    private static final Logger LOG = LoggerFactory.getLogger(StationManagementServiceImpl.class);

    private final StationRepository stationRepository;
    private final RouteRepository routeRepository;

    public StationManagementServiceImpl(
            StationRepository stationRepository,
            RouteRepository routeRepository) {
        this.stationRepository = stationRepository;
        this.routeRepository = routeRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<StationListDTO> getAllStations(StationFilterDTO filter, Pageable pageable) {
        LOG.debug("Request to get all stations with filter: {}", filter);

        try {
            // Get stations from database and convert to DTOs
            Page<Station> stations = stationRepository.findAll(pageable);
            List<StationListDTO> stationDTOs = stations.getContent().stream()
                    .map(this::convertToStationListDTO)
                    .collect(Collectors.toList());

            // Apply filters
            List<StationListDTO> filteredStations = applyFilters(stationDTOs, filter);

            // Create paginated result
            int start = (int) pageable.getOffset();
            int end = Math.min(start + pageable.getPageSize(), filteredStations.size());
            List<StationListDTO> pageContent = start < filteredStations.size() ? filteredStations.subList(start, end)
                    : Collections.emptyList();

            return new PageImpl<>(pageContent, pageable, filteredStations.size());
        } catch (Exception e) {
            LOG.error("Error fetching stations", e);
            return new PageImpl<>(Collections.emptyList(), pageable, 0);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<StationListDTO> getStationById(Long stationId) {
        LOG.debug("Request to get station by ID: {}", stationId);

        try {
            return stationRepository.findById(stationId)
                    .map(this::convertToStationListDTO);
        } catch (Exception e) {
            LOG.error("Error fetching station by ID: {}", stationId, e);
            return Optional.empty();
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Page<StationListDTO> getStationsByRoute(String routeName, Pageable pageable) {
        LOG.debug("Request to get stations by route: {}", routeName);

        try {
            // TODO: Implement actual route-station relationship query
            List<StationListDTO> mockStations = createMockStationData().stream()
                    .filter(station -> routeName.equals(station.getRouteName()))
                    .collect(Collectors.toList());

            int start = (int) pageable.getOffset();
            int end = Math.min(start + pageable.getPageSize(), mockStations.size());
            List<StationListDTO> pageContent = mockStations.subList(start, end);

            return new PageImpl<>(pageContent, pageable, mockStations.size());
        } catch (Exception e) {
            LOG.error("Error fetching stations by route: {}", routeName, e);
            return new PageImpl<>(Collections.emptyList(), pageable, 0);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Page<StationListDTO> getStationsByType(String stationType, Pageable pageable) {
        LOG.debug("Request to get stations by type: {}", stationType);

        try {
            List<StationListDTO> typeStations = createMockStationData().stream()
                    .filter(station -> stationType.equals(station.getStationType()))
                    .collect(Collectors.toList());

            int start = (int) pageable.getOffset();
            int end = Math.min(start + pageable.getPageSize(), typeStations.size());
            List<StationListDTO> pageContent = typeStations.subList(start, end);

            return new PageImpl<>(pageContent, pageable, typeStations.size());
        } catch (Exception e) {
            LOG.error("Error fetching stations by type: {}", stationType, e);
            return new PageImpl<>(Collections.emptyList(), pageable, 0);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Page<StationListDTO> getStationsByStatus(String status, Pageable pageable) {
        LOG.debug("Request to get stations by status: {}", status);

        try {
            List<StationListDTO> statusStations = createMockStationData().stream()
                    .filter(station -> status.equals(station.getStatus()))
                    .collect(Collectors.toList());

            int start = (int) pageable.getOffset();
            int end = Math.min(start + pageable.getPageSize(), statusStations.size());
            List<StationListDTO> pageContent = statusStations.subList(start, end);

            return new PageImpl<>(pageContent, pageable, statusStations.size());
        } catch (Exception e) {
            LOG.error("Error fetching stations by status: {}", status, e);
            return new PageImpl<>(Collections.emptyList(), pageable, 0);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Page<StationListDTO> searchStations(String query, Pageable pageable) {
        LOG.debug("Request to search stations with query: {}", query);

        try {
            String lowerQuery = query.toLowerCase();
            List<StationListDTO> searchResults = createMockStationData().stream()
                    .filter(station -> station.getStationName().toLowerCase().contains(lowerQuery) ||
                            station.getAddress().toLowerCase().contains(lowerQuery) ||
                            station.getRouteName().toLowerCase().contains(lowerQuery))
                    .collect(Collectors.toList());

            int start = (int) pageable.getOffset();
            int end = Math.min(start + pageable.getPageSize(), searchResults.size());
            List<StationListDTO> pageContent = searchResults.subList(start, end);

            return new PageImpl<>(pageContent, pageable, searchResults.size());
        } catch (Exception e) {
            LOG.error("Error searching stations with query: {}", query, e);
            return new PageImpl<>(Collections.emptyList(), pageable, 0);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> getAvailableStationTypes() {
        return Arrays.asList("Dón/Trả", "Pickup", "Drop-off", "Transit");
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> getAvailableStatuses() {
        return Arrays.asList("Hoạt động", "Đã ngưng", "Bảo trì", "Tạm dừng");
    }

    @Override
    public Optional<StationListDTO> updateStationStatus(Long stationId, String newStatus) {
        LOG.debug("Request to update station status: {} to {}", stationId, newStatus);

        try {
            return stationRepository.findById(stationId)
                    .map(station -> {
                        // Update station status logic here
                        // For now, just return the converted DTO
                        StationListDTO dto = convertToStationListDTO(station);
                        dto.setStatus(newStatus);
                        return dto;
                    });
        } catch (Exception e) {
            LOG.error("Error updating station status: {}", stationId, e);
            return Optional.empty();
        }
    }

    @Override
    public Optional<StationListDTO> addStationToRoute(Long stationId, String routeName, Integer orderInRoute) {
        LOG.debug("Request to add station {} to route {} at order {}", stationId, routeName, orderInRoute);

        try {
            // TODO: Implement actual route-station relationship management
            return getStationById(stationId)
                    .map(station -> {
                        station.setRouteName(routeName);
                        station.setOrderInRoute(orderInRoute);
                        return station;
                    });
        } catch (Exception e) {
            LOG.error("Error adding station to route: {}", stationId, e);
            return Optional.empty();
        }
    }

    @Override
    public Optional<StationListDTO> removeStationFromRoute(Long stationId, String routeName) {
        LOG.debug("Request to remove station {} from route {}", stationId, routeName);

        try {
            // TODO: Implement actual route-station relationship management
            return getStationById(stationId)
                    .map(station -> {
                        if (routeName.equals(station.getRouteName())) {
                            station.setRouteName(null);
                            station.setOrderInRoute(null);
                        }
                        return station;
                    });
        } catch (Exception e) {
            LOG.error("Error removing station from route: {}", stationId, e);
            return Optional.empty();
        }
    }

    // Helper methods
    private StationListDTO convertToStationListDTO(Station station) {
        StationListDTO dto = new StationListDTO();
        dto.setStationId(station.getId());
        dto.setStationName(station.getName());
        dto.setPhoneNumber(station.getPhoneNumber());
        dto.setDescription(station.getDescription());
        dto.setActive(station.getActive());
        dto.setCreatedAt(station.getCreatedAt());
        dto.setUpdatedAt(station.getUpdatedAt());

        // Set address from station's address relationship
        if (station.getAddress() != null) {
            // Construct full address string
            StringBuilder addressBuilder = new StringBuilder();
            if (station.getAddress().getStreetAddress() != null) {
                addressBuilder.append(station.getAddress().getStreetAddress());
            }
            if (station.getAddress().getWard() != null) {
                if (addressBuilder.length() > 0)
                    addressBuilder.append(", ");
                addressBuilder.append(station.getAddress().getWard().getName());
            }
            if (station.getAddress().getWard().getDistrict() != null) {
                if (addressBuilder.length() > 0)
                    addressBuilder.append(", ");
                addressBuilder.append(station.getAddress().getWard().getDistrict().getName());
            }
            if (station.getAddress().getWard().getDistrict().getProvince() != null) {
                if (addressBuilder.length() > 0)
                    addressBuilder.append(", ");
                addressBuilder.append(station.getAddress().getWard().getDistrict().getProvince().getName());
            }
            dto.setAddress(addressBuilder.toString());
        }

        // Set default values for fields not directly available
        dto.setStationType("Dón/Trả"); // Default type
        dto.setStatus(station.getActive() ? "Hoạt động" : "Đã ngưng");

        // TODO: Set route information from actual route-station relationships
        dto.setRouteName("HCM - An Giang"); // Mock data
        dto.setRouteCode("HCM-AG"); // Mock data
        dto.setOrderInRoute(1); // Mock data

        return dto;
    }

    private List<StationListDTO> applyFilters(List<StationListDTO> stations, StationFilterDTO filter) {
        if (filter == null) {
            return stations;
        }

        return stations.stream()
                .filter(station -> {
                    // Apply search query filter
                    if (filter.getSearchQuery() != null && !filter.getSearchQuery().isEmpty()) {
                        String query = filter.getSearchQuery().toLowerCase();
                        boolean matches = station.getStationName().toLowerCase().contains(query) ||
                                station.getAddress().toLowerCase().contains(query);
                        if (!matches)
                            return false;
                    }

                    // Apply station type filter
                    if (filter.getStationTypes() != null && !filter.getStationTypes().isEmpty()) {
                        if (!filter.getStationTypes().contains(station.getStationType())) {
                            return false;
                        }
                    }

                    // Apply route filter
                    if (filter.getRoutes() != null && !filter.getRoutes().isEmpty()) {
                        if (!filter.getRoutes().contains(station.getRouteName())) {
                            return false;
                        }
                    }

                    // Apply status filter
                    if (filter.getStatuses() != null && !filter.getStatuses().isEmpty()) {
                        if (!filter.getStatuses().contains(station.getStatus())) {
                            return false;
                        }
                    }

                    return true;
                })
                .collect(Collectors.toList());
    }

    private List<StationListDTO> createMockStationData() {
        // TODO: Replace with actual data from database
        List<StationListDTO> mockStations = new ArrayList<>();

        // Mock station 1
        StationListDTO station1 = new StationListDTO();
        station1.setStationId(1L);
        station1.setStationName("Bến xe Miền Tây");
        station1.setAddress("395 Kinh Dương Vương, HCM");
        station1.setStationType("Dón/Trả");
        station1.setRouteName("HCM - An Giang");
        station1.setRouteCode("HCM-AG");
        station1.setOrderInRoute(1);
        station1.setStatus("Hoạt động");
        station1.setCreatedAt(Instant.now());
        mockStations.add(station1);

        // Mock station 2
        StationListDTO station2 = new StationListDTO();
        station2.setStationId(2L);
        station2.setStationName("Văn phòng An Giang");
        station2.setAddress("395 Kinh Dương Vương, HCM");
        station2.setStationType("Dón/Trả");
        station2.setRouteName("HCM - An Giang");
        station2.setRouteCode("HCM-AG");
        station2.setOrderInRoute(2);
        station2.setStatus("Đã ngưng");
        station2.setCreatedAt(Instant.now());
        mockStations.add(station2);

        return mockStations;
    }
}
