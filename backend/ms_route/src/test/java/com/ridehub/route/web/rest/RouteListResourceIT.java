package com.ridehub.route.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.ridehub.route.IntegrationTest;
import com.ridehub.route.domain.*;
import com.ridehub.route.domain.enumeration.VehicleType;
import com.ridehub.route.repository.*;
import com.ridehub.route.service.dto.RouteListDTO;
import jakarta.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the Route List API endpoint.
 */
@IntegrationTest
@WithMockUser
class RouteListResourceIT {

    private static final String DEFAULT_TRIP_CODE = "TRIP001";
    private static final String DEFAULT_ROUTE_CODE = "ROUTE001";
    private static final Instant DEFAULT_DEPARTURE_TIME = Instant.ofEpochMilli(0L);
    private static final Instant DEFAULT_ARRIVAL_TIME = Instant.ofEpochMilli(0L);
    private static final BigDecimal DEFAULT_BASE_FARE = new BigDecimal("100000");
    private static final BigDecimal DEFAULT_DISTANCE_KM = new BigDecimal("220");
    private static final Instant DEFAULT_CREATED_AT = Instant.ofEpochMilli(0L);

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private StationRepository stationRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private WardRepository wardRepository;

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private ProvinceRepository provinceRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restTripMockMvc;

    private Trip trip;
    private Route route;
    private Station originStation;
    private Station destinationStation;

    @BeforeEach
    void initTest() {
        // Create test data
        createTestData();
    }

    private void createTestData() {
        // Create Province
        Province province = new Province();
        province.setName("TP.HCM");
        province.setCreatedAt(DEFAULT_CREATED_AT);
        province = provinceRepository.saveAndFlush(province);

        // Create District
        District district = new District();
        district.setName("Quận 1");
        district.setProvince(province);
        district.setCreatedAt(DEFAULT_CREATED_AT);
        district = districtRepository.saveAndFlush(district);

        // Create Ward
        Ward ward = new Ward();
        ward.setName("Phường Bến Nghé");
        ward.setDistrict(district);
        ward.setCreatedAt(DEFAULT_CREATED_AT);
        ward = wardRepository.saveAndFlush(ward);

        // Create Address for origin
        Address originAddress = new Address();
        originAddress.setWard(ward);
        originAddress.setCreatedAt(DEFAULT_CREATED_AT);
        originAddress = addressRepository.saveAndFlush(originAddress);

        // Create Address for destination
        Address destinationAddress = new Address();
        destinationAddress.setWard(ward);
        destinationAddress.setCreatedAt(DEFAULT_CREATED_AT);
        destinationAddress = addressRepository.saveAndFlush(destinationAddress);

        // Create Origin Station
        originStation = new Station();
        originStation.setName("TP.HCM");
        originStation.setAddress(originAddress);
        originStation.setCreatedAt(DEFAULT_CREATED_AT);
        originStation = stationRepository.saveAndFlush(originStation);

        // Create Destination Station
        destinationStation = new Station();
        destinationStation.setName("An Giang");
        destinationStation.setAddress(destinationAddress);
        destinationStation.setCreatedAt(DEFAULT_CREATED_AT);
        destinationStation = stationRepository.saveAndFlush(destinationStation);

        // Create Route
        route = new Route();
        route.setRouteCode(DEFAULT_ROUTE_CODE);
        route.setOrigin(originStation);
        route.setDestination(destinationStation);
        route.setDistanceKm(DEFAULT_DISTANCE_KM);
        route.setCreatedAt(DEFAULT_CREATED_AT);
        route = routeRepository.saveAndFlush(route);

        // Create Trip
        trip = new Trip();
        trip.setTripCode(DEFAULT_TRIP_CODE);
        trip.setRoute(route);
        trip.setDepartureTime(DEFAULT_DEPARTURE_TIME);
        trip.setArrivalTime(DEFAULT_ARRIVAL_TIME);
        trip.setBaseFare(DEFAULT_BASE_FARE);
        trip.setCreatedAt(DEFAULT_CREATED_AT);
        trip = tripRepository.saveAndFlush(trip);
    }

    @Test
    @Transactional
    void getRouteList() throws Exception {
        // Initialize the database
        tripRepository.saveAndFlush(trip);

        // Get the route list
        restTripMockMvc
                .perform(get("/api/trips/route-list"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].tripCode").value(DEFAULT_TRIP_CODE))
                .andExpect(jsonPath("$[0].routeCode").value(DEFAULT_ROUTE_CODE))
                .andExpect(jsonPath("$[0].origin").value("TP.HCM"))
                .andExpect(jsonPath("$[0].destination").value("An Giang"))
                .andExpect(jsonPath("$[0].routeName").value("TP.HCM - An Giang"))
                .andExpect(jsonPath("$[0].distanceKm").value(DEFAULT_DISTANCE_KM.intValue()))
                .andExpect(jsonPath("$[0].baseFare").value(DEFAULT_BASE_FARE.intValue()))
                .andExpect(jsonPath("$[0].vehicleType").value("LIMOUSINE"))
                .andExpect(jsonPath("$[0].vehiclePlateNumber").value("29A-12345"))
                .andExpect(jsonPath("$[0].status").exists());
    }
}
