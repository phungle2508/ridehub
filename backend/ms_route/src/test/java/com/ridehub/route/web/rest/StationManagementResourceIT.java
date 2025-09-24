package com.ridehub.route.web.rest;

import com.ridehub.route.IntegrationTest;
import com.ridehub.route.service.StationManagementService;
import com.ridehub.route.service.dto.StationFilterDTO;
import com.ridehub.route.service.dto.StationListDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;

import java.time.Instant;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link StationManagementResource} REST controller.
 */
@IntegrationTest
@AutoConfigureWebMvc
@Transactional
class StationManagementResourceIT {

    private static final String DEFAULT_STATION_NAME = "Bến xe Miền Tây";
    private static final String DEFAULT_ADDRESS = "395 Kinh Dương Vương, HCM";
    private static final String DEFAULT_STATION_TYPE = "Dón/Trả";
    private static final String DEFAULT_ROUTE_NAME = "HCM - An Giang";
    private static final String DEFAULT_STATUS = "Hoạt động";

    @Autowired
    private StationManagementService stationManagementService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private Validator validator;

    private MockMvc restStationManagementMockMvc;

    private StationListDTO stationListDTO;

    @BeforeEach
    void setup() {
        StationManagementResource stationManagementResource = new StationManagementResource(stationManagementService);
        this.restStationManagementMockMvc = MockMvcBuilders
            .standaloneSetup(stationManagementResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setMessageConverters(jacksonMessageConverter)
            .setValidator(validator)
            .build();
    }

    /**
     * Create an entity for this test.
     */
    public static StationListDTO createEntity() {
        StationListDTO stationListDTO = new StationListDTO();
        stationListDTO.setStationId(1L);
        stationListDTO.setStationName(DEFAULT_STATION_NAME);
        stationListDTO.setAddress(DEFAULT_ADDRESS);
        stationListDTO.setStationType(DEFAULT_STATION_TYPE);
        stationListDTO.setRouteName(DEFAULT_ROUTE_NAME);
        stationListDTO.setRouteCode("HCM-AG");
        stationListDTO.setOrderInRoute(1);
        stationListDTO.setStatus(DEFAULT_STATUS);
        stationListDTO.setCreatedAt(Instant.now());
        stationListDTO.setPhoneNumber("0123456789");
        stationListDTO.setDescription("Test station");
        stationListDTO.setActive(true);
        return stationListDTO;
    }

    @BeforeEach
    void initTest() {
        stationListDTO = createEntity();
    }

    @Test
    @Transactional
    void getAllStations() throws Exception {
        // Get all the stations
        restStationManagementMockMvc
            .perform(get("/api/station-management/stations"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
    }

    @Test
    @Transactional
    void getStationsByRoute() throws Exception {
        // Get stations by route
        restStationManagementMockMvc
            .perform(get("/api/station-management/stations/route/{routeName}", DEFAULT_ROUTE_NAME))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
    }

    @Test
    @Transactional
    void getStationsByType() throws Exception {
        // Get stations by type
        restStationManagementMockMvc
            .perform(get("/api/station-management/stations/type/{stationType}", DEFAULT_STATION_TYPE))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
    }

    @Test
    @Transactional
    void getStationsByStatus() throws Exception {
        // Get stations by status
        restStationManagementMockMvc
            .perform(get("/api/station-management/stations/status/{status}", DEFAULT_STATUS))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
    }

    @Test
    @Transactional
    void searchStations() throws Exception {
        // Search stations
        restStationManagementMockMvc
            .perform(get("/api/station-management/stations/search?query={query}", DEFAULT_STATION_NAME))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
    }

    @Test
    @Transactional
    void getAvailableStationTypes() throws Exception {
        // Get available station types
        restStationManagementMockMvc
            .perform(get("/api/station-management/stations/types"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$").isArray());
    }

    @Test
    @Transactional
    void getAvailableStatuses() throws Exception {
        // Get available statuses
        restStationManagementMockMvc
            .perform(get("/api/station-management/stations/statuses"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$").isArray());
    }

    @Test
    @Transactional
    void getStationById() throws Exception {
        // Get station by ID
        restStationManagementMockMvc
            .perform(get("/api/station-management/stations/{stationId}", 1L))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
    }
}
