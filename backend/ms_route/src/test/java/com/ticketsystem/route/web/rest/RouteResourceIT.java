package com.ticketsystem.route.web.rest;

import static com.ticketsystem.route.domain.RouteAsserts.*;
import static com.ticketsystem.route.web.rest.TestUtil.createUpdateProxyForBean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.hamcrest.Matchers.hasItem;
import static org.mockito.Mockito.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketsystem.route.IntegrationTest;
import com.ticketsystem.route.domain.Route;
import com.ticketsystem.route.domain.enumeration.TransportType;
import com.ticketsystem.route.repository.RouteRepository;
import com.ticketsystem.route.repository.search.RouteSearchRepository;
import com.ticketsystem.route.service.dto.RouteDTO;
import com.ticketsystem.route.service.mapper.RouteMapper;
import jakarta.persistence.EntityManager;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.assertj.core.util.IterableUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.data.util.Streamable;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link RouteResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class RouteResourceIT {

    private static final String DEFAULT_ROUTE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_ROUTE_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_ORIGIN = "AAAAAAAAAA";
    private static final String UPDATED_ORIGIN = "BBBBBBBBBB";

    private static final String DEFAULT_DESTINATION = "AAAAAAAAAA";
    private static final String UPDATED_DESTINATION = "BBBBBBBBBB";

    private static final Double DEFAULT_DISTANCE = 1D;
    private static final Double UPDATED_DISTANCE = 2D;
    private static final Double SMALLER_DISTANCE = 1D - 1D;

    private static final Integer DEFAULT_ESTIMATED_DURATION = 1;
    private static final Integer UPDATED_ESTIMATED_DURATION = 2;
    private static final Integer SMALLER_ESTIMATED_DURATION = 1 - 1;

    private static final TransportType DEFAULT_TRANSPORT_TYPE = TransportType.TRAIN;
    private static final TransportType UPDATED_TRANSPORT_TYPE = TransportType.BUS;

    private static final Boolean DEFAULT_IS_ACTIVE = false;
    private static final Boolean UPDATED_IS_ACTIVE = true;

    private static final Instant DEFAULT_CREATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_UPDATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_UPDATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String ENTITY_API_URL = "/api/routes";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";
    private static final String ENTITY_SEARCH_API_URL = "/api/routes/_search";

    @Autowired
    private ObjectMapper om;

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private RouteMapper routeMapper;

    @Autowired
    private RouteSearchRepository routeSearchRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restRouteMockMvc;

    private Route route;

    private Route insertedRoute;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Route createEntity() {
        return new Route()
            .routeName(DEFAULT_ROUTE_NAME)
            .origin(DEFAULT_ORIGIN)
            .destination(DEFAULT_DESTINATION)
            .distance(DEFAULT_DISTANCE)
            .estimatedDuration(DEFAULT_ESTIMATED_DURATION)
            .transportType(DEFAULT_TRANSPORT_TYPE)
            .isActive(DEFAULT_IS_ACTIVE)
            .createdAt(DEFAULT_CREATED_AT)
            .updatedAt(DEFAULT_UPDATED_AT);
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Route createUpdatedEntity() {
        return new Route()
            .routeName(UPDATED_ROUTE_NAME)
            .origin(UPDATED_ORIGIN)
            .destination(UPDATED_DESTINATION)
            .distance(UPDATED_DISTANCE)
            .estimatedDuration(UPDATED_ESTIMATED_DURATION)
            .transportType(UPDATED_TRANSPORT_TYPE)
            .isActive(UPDATED_IS_ACTIVE)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT);
    }

    @BeforeEach
    void initTest() {
        route = createEntity();
    }

    @AfterEach
    void cleanup() {
        if (insertedRoute != null) {
            routeRepository.delete(insertedRoute);
            routeSearchRepository.delete(insertedRoute);
            insertedRoute = null;
        }
    }

    @Test
    @Transactional
    void createRoute() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(routeSearchRepository.findAll());
        // Create the Route
        RouteDTO routeDTO = routeMapper.toDto(route);
        var returnedRouteDTO = om.readValue(
            restRouteMockMvc
                .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(routeDTO)))
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            RouteDTO.class
        );

        // Validate the Route in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        var returnedRoute = routeMapper.toEntity(returnedRouteDTO);
        assertRouteUpdatableFieldsEquals(returnedRoute, getPersistedRoute(returnedRoute));

        await()
            .atMost(5, TimeUnit.SECONDS)
            .untilAsserted(() -> {
                int searchDatabaseSizeAfter = IterableUtil.sizeOf(routeSearchRepository.findAll());
                assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore + 1);
            });

        insertedRoute = returnedRoute;
    }

    @Test
    @Transactional
    void createRouteWithExistingId() throws Exception {
        // Create the Route with an existing ID
        insertedRoute = routeRepository.saveAndFlush(route);
        RouteDTO routeDTO = routeMapper.toDto(route);

        long databaseSizeBeforeCreate = getRepositoryCount();
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(routeSearchRepository.findAll());

        // An entity with an existing ID cannot be created, so this API call must fail
        restRouteMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(routeDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Route in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
        int searchDatabaseSizeAfter = IterableUtil.sizeOf(routeSearchRepository.findAll());
        assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore);
    }

    @Test
    @Transactional
    void checkRouteNameIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(routeSearchRepository.findAll());
        // set the field null
        route.setRouteName(null);

        // Create the Route, which fails.
        RouteDTO routeDTO = routeMapper.toDto(route);

        restRouteMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(routeDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);

        int searchDatabaseSizeAfter = IterableUtil.sizeOf(routeSearchRepository.findAll());
        assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore);
    }

    @Test
    @Transactional
    void checkOriginIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(routeSearchRepository.findAll());
        // set the field null
        route.setOrigin(null);

        // Create the Route, which fails.
        RouteDTO routeDTO = routeMapper.toDto(route);

        restRouteMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(routeDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);

        int searchDatabaseSizeAfter = IterableUtil.sizeOf(routeSearchRepository.findAll());
        assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore);
    }

    @Test
    @Transactional
    void checkDestinationIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(routeSearchRepository.findAll());
        // set the field null
        route.setDestination(null);

        // Create the Route, which fails.
        RouteDTO routeDTO = routeMapper.toDto(route);

        restRouteMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(routeDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);

        int searchDatabaseSizeAfter = IterableUtil.sizeOf(routeSearchRepository.findAll());
        assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore);
    }

    @Test
    @Transactional
    void checkDistanceIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(routeSearchRepository.findAll());
        // set the field null
        route.setDistance(null);

        // Create the Route, which fails.
        RouteDTO routeDTO = routeMapper.toDto(route);

        restRouteMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(routeDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);

        int searchDatabaseSizeAfter = IterableUtil.sizeOf(routeSearchRepository.findAll());
        assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore);
    }

    @Test
    @Transactional
    void checkEstimatedDurationIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(routeSearchRepository.findAll());
        // set the field null
        route.setEstimatedDuration(null);

        // Create the Route, which fails.
        RouteDTO routeDTO = routeMapper.toDto(route);

        restRouteMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(routeDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);

        int searchDatabaseSizeAfter = IterableUtil.sizeOf(routeSearchRepository.findAll());
        assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore);
    }

    @Test
    @Transactional
    void checkTransportTypeIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(routeSearchRepository.findAll());
        // set the field null
        route.setTransportType(null);

        // Create the Route, which fails.
        RouteDTO routeDTO = routeMapper.toDto(route);

        restRouteMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(routeDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);

        int searchDatabaseSizeAfter = IterableUtil.sizeOf(routeSearchRepository.findAll());
        assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore);
    }

    @Test
    @Transactional
    void checkIsActiveIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(routeSearchRepository.findAll());
        // set the field null
        route.setIsActive(null);

        // Create the Route, which fails.
        RouteDTO routeDTO = routeMapper.toDto(route);

        restRouteMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(routeDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);

        int searchDatabaseSizeAfter = IterableUtil.sizeOf(routeSearchRepository.findAll());
        assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore);
    }

    @Test
    @Transactional
    void checkCreatedAtIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(routeSearchRepository.findAll());
        // set the field null
        route.setCreatedAt(null);

        // Create the Route, which fails.
        RouteDTO routeDTO = routeMapper.toDto(route);

        restRouteMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(routeDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);

        int searchDatabaseSizeAfter = IterableUtil.sizeOf(routeSearchRepository.findAll());
        assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore);
    }

    @Test
    @Transactional
    void checkUpdatedAtIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(routeSearchRepository.findAll());
        // set the field null
        route.setUpdatedAt(null);

        // Create the Route, which fails.
        RouteDTO routeDTO = routeMapper.toDto(route);

        restRouteMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(routeDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);

        int searchDatabaseSizeAfter = IterableUtil.sizeOf(routeSearchRepository.findAll());
        assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore);
    }

    @Test
    @Transactional
    void getAllRoutes() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get all the routeList
        restRouteMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(route.getId().toString())))
            .andExpect(jsonPath("$.[*].routeName").value(hasItem(DEFAULT_ROUTE_NAME)))
            .andExpect(jsonPath("$.[*].origin").value(hasItem(DEFAULT_ORIGIN)))
            .andExpect(jsonPath("$.[*].destination").value(hasItem(DEFAULT_DESTINATION)))
            .andExpect(jsonPath("$.[*].distance").value(hasItem(DEFAULT_DISTANCE)))
            .andExpect(jsonPath("$.[*].estimatedDuration").value(hasItem(DEFAULT_ESTIMATED_DURATION)))
            .andExpect(jsonPath("$.[*].transportType").value(hasItem(DEFAULT_TRANSPORT_TYPE.toString())))
            .andExpect(jsonPath("$.[*].isActive").value(hasItem(DEFAULT_IS_ACTIVE)))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())));
    }

    @Test
    @Transactional
    void getRoute() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get the route
        restRouteMockMvc
            .perform(get(ENTITY_API_URL_ID, route.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(route.getId().toString()))
            .andExpect(jsonPath("$.routeName").value(DEFAULT_ROUTE_NAME))
            .andExpect(jsonPath("$.origin").value(DEFAULT_ORIGIN))
            .andExpect(jsonPath("$.destination").value(DEFAULT_DESTINATION))
            .andExpect(jsonPath("$.distance").value(DEFAULT_DISTANCE))
            .andExpect(jsonPath("$.estimatedDuration").value(DEFAULT_ESTIMATED_DURATION))
            .andExpect(jsonPath("$.transportType").value(DEFAULT_TRANSPORT_TYPE.toString()))
            .andExpect(jsonPath("$.isActive").value(DEFAULT_IS_ACTIVE))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.updatedAt").value(DEFAULT_UPDATED_AT.toString()));
    }

    @Test
    @Transactional
    void getRoutesByIdFiltering() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        UUID id = route.getId();

        defaultRouteFiltering("id.equals=" + id, "id.notEquals=" + id);
    }

    @Test
    @Transactional
    void getAllRoutesByRouteNameIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get all the routeList where routeName equals to
        defaultRouteFiltering("routeName.equals=" + DEFAULT_ROUTE_NAME, "routeName.equals=" + UPDATED_ROUTE_NAME);
    }

    @Test
    @Transactional
    void getAllRoutesByRouteNameIsInShouldWork() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get all the routeList where routeName in
        defaultRouteFiltering("routeName.in=" + DEFAULT_ROUTE_NAME + "," + UPDATED_ROUTE_NAME, "routeName.in=" + UPDATED_ROUTE_NAME);
    }

    @Test
    @Transactional
    void getAllRoutesByRouteNameIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get all the routeList where routeName is not null
        defaultRouteFiltering("routeName.specified=true", "routeName.specified=false");
    }

    @Test
    @Transactional
    void getAllRoutesByRouteNameContainsSomething() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get all the routeList where routeName contains
        defaultRouteFiltering("routeName.contains=" + DEFAULT_ROUTE_NAME, "routeName.contains=" + UPDATED_ROUTE_NAME);
    }

    @Test
    @Transactional
    void getAllRoutesByRouteNameNotContainsSomething() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get all the routeList where routeName does not contain
        defaultRouteFiltering("routeName.doesNotContain=" + UPDATED_ROUTE_NAME, "routeName.doesNotContain=" + DEFAULT_ROUTE_NAME);
    }

    @Test
    @Transactional
    void getAllRoutesByOriginIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get all the routeList where origin equals to
        defaultRouteFiltering("origin.equals=" + DEFAULT_ORIGIN, "origin.equals=" + UPDATED_ORIGIN);
    }

    @Test
    @Transactional
    void getAllRoutesByOriginIsInShouldWork() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get all the routeList where origin in
        defaultRouteFiltering("origin.in=" + DEFAULT_ORIGIN + "," + UPDATED_ORIGIN, "origin.in=" + UPDATED_ORIGIN);
    }

    @Test
    @Transactional
    void getAllRoutesByOriginIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get all the routeList where origin is not null
        defaultRouteFiltering("origin.specified=true", "origin.specified=false");
    }

    @Test
    @Transactional
    void getAllRoutesByOriginContainsSomething() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get all the routeList where origin contains
        defaultRouteFiltering("origin.contains=" + DEFAULT_ORIGIN, "origin.contains=" + UPDATED_ORIGIN);
    }

    @Test
    @Transactional
    void getAllRoutesByOriginNotContainsSomething() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get all the routeList where origin does not contain
        defaultRouteFiltering("origin.doesNotContain=" + UPDATED_ORIGIN, "origin.doesNotContain=" + DEFAULT_ORIGIN);
    }

    @Test
    @Transactional
    void getAllRoutesByDestinationIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get all the routeList where destination equals to
        defaultRouteFiltering("destination.equals=" + DEFAULT_DESTINATION, "destination.equals=" + UPDATED_DESTINATION);
    }

    @Test
    @Transactional
    void getAllRoutesByDestinationIsInShouldWork() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get all the routeList where destination in
        defaultRouteFiltering("destination.in=" + DEFAULT_DESTINATION + "," + UPDATED_DESTINATION, "destination.in=" + UPDATED_DESTINATION);
    }

    @Test
    @Transactional
    void getAllRoutesByDestinationIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get all the routeList where destination is not null
        defaultRouteFiltering("destination.specified=true", "destination.specified=false");
    }

    @Test
    @Transactional
    void getAllRoutesByDestinationContainsSomething() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get all the routeList where destination contains
        defaultRouteFiltering("destination.contains=" + DEFAULT_DESTINATION, "destination.contains=" + UPDATED_DESTINATION);
    }

    @Test
    @Transactional
    void getAllRoutesByDestinationNotContainsSomething() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get all the routeList where destination does not contain
        defaultRouteFiltering("destination.doesNotContain=" + UPDATED_DESTINATION, "destination.doesNotContain=" + DEFAULT_DESTINATION);
    }

    @Test
    @Transactional
    void getAllRoutesByDistanceIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get all the routeList where distance equals to
        defaultRouteFiltering("distance.equals=" + DEFAULT_DISTANCE, "distance.equals=" + UPDATED_DISTANCE);
    }

    @Test
    @Transactional
    void getAllRoutesByDistanceIsInShouldWork() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get all the routeList where distance in
        defaultRouteFiltering("distance.in=" + DEFAULT_DISTANCE + "," + UPDATED_DISTANCE, "distance.in=" + UPDATED_DISTANCE);
    }

    @Test
    @Transactional
    void getAllRoutesByDistanceIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get all the routeList where distance is not null
        defaultRouteFiltering("distance.specified=true", "distance.specified=false");
    }

    @Test
    @Transactional
    void getAllRoutesByDistanceIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get all the routeList where distance is greater than or equal to
        defaultRouteFiltering("distance.greaterThanOrEqual=" + DEFAULT_DISTANCE, "distance.greaterThanOrEqual=" + UPDATED_DISTANCE);
    }

    @Test
    @Transactional
    void getAllRoutesByDistanceIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get all the routeList where distance is less than or equal to
        defaultRouteFiltering("distance.lessThanOrEqual=" + DEFAULT_DISTANCE, "distance.lessThanOrEqual=" + SMALLER_DISTANCE);
    }

    @Test
    @Transactional
    void getAllRoutesByDistanceIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get all the routeList where distance is less than
        defaultRouteFiltering("distance.lessThan=" + UPDATED_DISTANCE, "distance.lessThan=" + DEFAULT_DISTANCE);
    }

    @Test
    @Transactional
    void getAllRoutesByDistanceIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get all the routeList where distance is greater than
        defaultRouteFiltering("distance.greaterThan=" + SMALLER_DISTANCE, "distance.greaterThan=" + DEFAULT_DISTANCE);
    }

    @Test
    @Transactional
    void getAllRoutesByEstimatedDurationIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get all the routeList where estimatedDuration equals to
        defaultRouteFiltering(
            "estimatedDuration.equals=" + DEFAULT_ESTIMATED_DURATION,
            "estimatedDuration.equals=" + UPDATED_ESTIMATED_DURATION
        );
    }

    @Test
    @Transactional
    void getAllRoutesByEstimatedDurationIsInShouldWork() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get all the routeList where estimatedDuration in
        defaultRouteFiltering(
            "estimatedDuration.in=" + DEFAULT_ESTIMATED_DURATION + "," + UPDATED_ESTIMATED_DURATION,
            "estimatedDuration.in=" + UPDATED_ESTIMATED_DURATION
        );
    }

    @Test
    @Transactional
    void getAllRoutesByEstimatedDurationIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get all the routeList where estimatedDuration is not null
        defaultRouteFiltering("estimatedDuration.specified=true", "estimatedDuration.specified=false");
    }

    @Test
    @Transactional
    void getAllRoutesByEstimatedDurationIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get all the routeList where estimatedDuration is greater than or equal to
        defaultRouteFiltering(
            "estimatedDuration.greaterThanOrEqual=" + DEFAULT_ESTIMATED_DURATION,
            "estimatedDuration.greaterThanOrEqual=" + UPDATED_ESTIMATED_DURATION
        );
    }

    @Test
    @Transactional
    void getAllRoutesByEstimatedDurationIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get all the routeList where estimatedDuration is less than or equal to
        defaultRouteFiltering(
            "estimatedDuration.lessThanOrEqual=" + DEFAULT_ESTIMATED_DURATION,
            "estimatedDuration.lessThanOrEqual=" + SMALLER_ESTIMATED_DURATION
        );
    }

    @Test
    @Transactional
    void getAllRoutesByEstimatedDurationIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get all the routeList where estimatedDuration is less than
        defaultRouteFiltering(
            "estimatedDuration.lessThan=" + UPDATED_ESTIMATED_DURATION,
            "estimatedDuration.lessThan=" + DEFAULT_ESTIMATED_DURATION
        );
    }

    @Test
    @Transactional
    void getAllRoutesByEstimatedDurationIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get all the routeList where estimatedDuration is greater than
        defaultRouteFiltering(
            "estimatedDuration.greaterThan=" + SMALLER_ESTIMATED_DURATION,
            "estimatedDuration.greaterThan=" + DEFAULT_ESTIMATED_DURATION
        );
    }

    @Test
    @Transactional
    void getAllRoutesByTransportTypeIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get all the routeList where transportType equals to
        defaultRouteFiltering("transportType.equals=" + DEFAULT_TRANSPORT_TYPE, "transportType.equals=" + UPDATED_TRANSPORT_TYPE);
    }

    @Test
    @Transactional
    void getAllRoutesByTransportTypeIsInShouldWork() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get all the routeList where transportType in
        defaultRouteFiltering(
            "transportType.in=" + DEFAULT_TRANSPORT_TYPE + "," + UPDATED_TRANSPORT_TYPE,
            "transportType.in=" + UPDATED_TRANSPORT_TYPE
        );
    }

    @Test
    @Transactional
    void getAllRoutesByTransportTypeIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get all the routeList where transportType is not null
        defaultRouteFiltering("transportType.specified=true", "transportType.specified=false");
    }

    @Test
    @Transactional
    void getAllRoutesByIsActiveIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get all the routeList where isActive equals to
        defaultRouteFiltering("isActive.equals=" + DEFAULT_IS_ACTIVE, "isActive.equals=" + UPDATED_IS_ACTIVE);
    }

    @Test
    @Transactional
    void getAllRoutesByIsActiveIsInShouldWork() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get all the routeList where isActive in
        defaultRouteFiltering("isActive.in=" + DEFAULT_IS_ACTIVE + "," + UPDATED_IS_ACTIVE, "isActive.in=" + UPDATED_IS_ACTIVE);
    }

    @Test
    @Transactional
    void getAllRoutesByIsActiveIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get all the routeList where isActive is not null
        defaultRouteFiltering("isActive.specified=true", "isActive.specified=false");
    }

    @Test
    @Transactional
    void getAllRoutesByCreatedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get all the routeList where createdAt equals to
        defaultRouteFiltering("createdAt.equals=" + DEFAULT_CREATED_AT, "createdAt.equals=" + UPDATED_CREATED_AT);
    }

    @Test
    @Transactional
    void getAllRoutesByCreatedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get all the routeList where createdAt in
        defaultRouteFiltering("createdAt.in=" + DEFAULT_CREATED_AT + "," + UPDATED_CREATED_AT, "createdAt.in=" + UPDATED_CREATED_AT);
    }

    @Test
    @Transactional
    void getAllRoutesByCreatedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get all the routeList where createdAt is not null
        defaultRouteFiltering("createdAt.specified=true", "createdAt.specified=false");
    }

    @Test
    @Transactional
    void getAllRoutesByUpdatedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get all the routeList where updatedAt equals to
        defaultRouteFiltering("updatedAt.equals=" + DEFAULT_UPDATED_AT, "updatedAt.equals=" + UPDATED_UPDATED_AT);
    }

    @Test
    @Transactional
    void getAllRoutesByUpdatedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get all the routeList where updatedAt in
        defaultRouteFiltering("updatedAt.in=" + DEFAULT_UPDATED_AT + "," + UPDATED_UPDATED_AT, "updatedAt.in=" + UPDATED_UPDATED_AT);
    }

    @Test
    @Transactional
    void getAllRoutesByUpdatedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get all the routeList where updatedAt is not null
        defaultRouteFiltering("updatedAt.specified=true", "updatedAt.specified=false");
    }

    private void defaultRouteFiltering(String shouldBeFound, String shouldNotBeFound) throws Exception {
        defaultRouteShouldBeFound(shouldBeFound);
        defaultRouteShouldNotBeFound(shouldNotBeFound);
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultRouteShouldBeFound(String filter) throws Exception {
        restRouteMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(route.getId().toString())))
            .andExpect(jsonPath("$.[*].routeName").value(hasItem(DEFAULT_ROUTE_NAME)))
            .andExpect(jsonPath("$.[*].origin").value(hasItem(DEFAULT_ORIGIN)))
            .andExpect(jsonPath("$.[*].destination").value(hasItem(DEFAULT_DESTINATION)))
            .andExpect(jsonPath("$.[*].distance").value(hasItem(DEFAULT_DISTANCE)))
            .andExpect(jsonPath("$.[*].estimatedDuration").value(hasItem(DEFAULT_ESTIMATED_DURATION)))
            .andExpect(jsonPath("$.[*].transportType").value(hasItem(DEFAULT_TRANSPORT_TYPE.toString())))
            .andExpect(jsonPath("$.[*].isActive").value(hasItem(DEFAULT_IS_ACTIVE)))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())));

        // Check, that the count call also returns 1
        restRouteMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("1"));
    }

    /**
     * Executes the search, and checks that the default entity is not returned.
     */
    private void defaultRouteShouldNotBeFound(String filter) throws Exception {
        restRouteMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());

        // Check, that the count call also returns 0
        restRouteMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("0"));
    }

    @Test
    @Transactional
    void getNonExistingRoute() throws Exception {
        // Get the route
        restRouteMockMvc.perform(get(ENTITY_API_URL_ID, UUID.randomUUID().toString())).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingRoute() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        long databaseSizeBeforeUpdate = getRepositoryCount();
        routeSearchRepository.save(route);
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(routeSearchRepository.findAll());

        // Update the route
        Route updatedRoute = routeRepository.findById(route.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedRoute are not directly saved in db
        em.detach(updatedRoute);
        updatedRoute
            .routeName(UPDATED_ROUTE_NAME)
            .origin(UPDATED_ORIGIN)
            .destination(UPDATED_DESTINATION)
            .distance(UPDATED_DISTANCE)
            .estimatedDuration(UPDATED_ESTIMATED_DURATION)
            .transportType(UPDATED_TRANSPORT_TYPE)
            .isActive(UPDATED_IS_ACTIVE)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT);
        RouteDTO routeDTO = routeMapper.toDto(updatedRoute);

        restRouteMockMvc
            .perform(
                put(ENTITY_API_URL_ID, routeDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(routeDTO))
            )
            .andExpect(status().isOk());

        // Validate the Route in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedRouteToMatchAllProperties(updatedRoute);

        await()
            .atMost(5, TimeUnit.SECONDS)
            .untilAsserted(() -> {
                int searchDatabaseSizeAfter = IterableUtil.sizeOf(routeSearchRepository.findAll());
                assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore);
                List<Route> routeSearchList = Streamable.of(routeSearchRepository.findAll()).toList();
                Route testRouteSearch = routeSearchList.get(searchDatabaseSizeAfter - 1);

                assertRouteAllPropertiesEquals(testRouteSearch, updatedRoute);
            });
    }

    @Test
    @Transactional
    void putNonExistingRoute() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(routeSearchRepository.findAll());
        route.setId(UUID.randomUUID());

        // Create the Route
        RouteDTO routeDTO = routeMapper.toDto(route);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restRouteMockMvc
            .perform(
                put(ENTITY_API_URL_ID, routeDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(routeDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Route in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        int searchDatabaseSizeAfter = IterableUtil.sizeOf(routeSearchRepository.findAll());
        assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore);
    }

    @Test
    @Transactional
    void putWithIdMismatchRoute() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(routeSearchRepository.findAll());
        route.setId(UUID.randomUUID());

        // Create the Route
        RouteDTO routeDTO = routeMapper.toDto(route);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restRouteMockMvc
            .perform(
                put(ENTITY_API_URL_ID, UUID.randomUUID())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(routeDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Route in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        int searchDatabaseSizeAfter = IterableUtil.sizeOf(routeSearchRepository.findAll());
        assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamRoute() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(routeSearchRepository.findAll());
        route.setId(UUID.randomUUID());

        // Create the Route
        RouteDTO routeDTO = routeMapper.toDto(route);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restRouteMockMvc
            .perform(put(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(routeDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Route in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        int searchDatabaseSizeAfter = IterableUtil.sizeOf(routeSearchRepository.findAll());
        assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore);
    }

    @Test
    @Transactional
    void partialUpdateRouteWithPatch() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the route using partial update
        Route partialUpdatedRoute = new Route();
        partialUpdatedRoute.setId(route.getId());

        partialUpdatedRoute.routeName(UPDATED_ROUTE_NAME).transportType(UPDATED_TRANSPORT_TYPE).createdAt(UPDATED_CREATED_AT);

        restRouteMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedRoute.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedRoute))
            )
            .andExpect(status().isOk());

        // Validate the Route in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertRouteUpdatableFieldsEquals(createUpdateProxyForBean(partialUpdatedRoute, route), getPersistedRoute(route));
    }

    @Test
    @Transactional
    void fullUpdateRouteWithPatch() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the route using partial update
        Route partialUpdatedRoute = new Route();
        partialUpdatedRoute.setId(route.getId());

        partialUpdatedRoute
            .routeName(UPDATED_ROUTE_NAME)
            .origin(UPDATED_ORIGIN)
            .destination(UPDATED_DESTINATION)
            .distance(UPDATED_DISTANCE)
            .estimatedDuration(UPDATED_ESTIMATED_DURATION)
            .transportType(UPDATED_TRANSPORT_TYPE)
            .isActive(UPDATED_IS_ACTIVE)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT);

        restRouteMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedRoute.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedRoute))
            )
            .andExpect(status().isOk());

        // Validate the Route in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertRouteUpdatableFieldsEquals(partialUpdatedRoute, getPersistedRoute(partialUpdatedRoute));
    }

    @Test
    @Transactional
    void patchNonExistingRoute() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(routeSearchRepository.findAll());
        route.setId(UUID.randomUUID());

        // Create the Route
        RouteDTO routeDTO = routeMapper.toDto(route);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restRouteMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, routeDTO.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(routeDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Route in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        int searchDatabaseSizeAfter = IterableUtil.sizeOf(routeSearchRepository.findAll());
        assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore);
    }

    @Test
    @Transactional
    void patchWithIdMismatchRoute() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(routeSearchRepository.findAll());
        route.setId(UUID.randomUUID());

        // Create the Route
        RouteDTO routeDTO = routeMapper.toDto(route);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restRouteMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, UUID.randomUUID())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(routeDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Route in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        int searchDatabaseSizeAfter = IterableUtil.sizeOf(routeSearchRepository.findAll());
        assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamRoute() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(routeSearchRepository.findAll());
        route.setId(UUID.randomUUID());

        // Create the Route
        RouteDTO routeDTO = routeMapper.toDto(route);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restRouteMockMvc
            .perform(patch(ENTITY_API_URL).with(csrf()).contentType("application/merge-patch+json").content(om.writeValueAsBytes(routeDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Route in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        int searchDatabaseSizeAfter = IterableUtil.sizeOf(routeSearchRepository.findAll());
        assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore);
    }

    @Test
    @Transactional
    void deleteRoute() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);
        routeRepository.save(route);
        routeSearchRepository.save(route);

        long databaseSizeBeforeDelete = getRepositoryCount();
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(routeSearchRepository.findAll());
        assertThat(searchDatabaseSizeBefore).isEqualTo(databaseSizeBeforeDelete);

        // Delete the route
        restRouteMockMvc
            .perform(delete(ENTITY_API_URL_ID, route.getId().toString()).with(csrf()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
        int searchDatabaseSizeAfter = IterableUtil.sizeOf(routeSearchRepository.findAll());
        assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore - 1);
    }

    @Test
    @Transactional
    void searchRoute() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);
        routeSearchRepository.save(route);

        // Search the route
        restRouteMockMvc
            .perform(get(ENTITY_SEARCH_API_URL + "?query=id:" + route.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(route.getId().toString())))
            .andExpect(jsonPath("$.[*].routeName").value(hasItem(DEFAULT_ROUTE_NAME)))
            .andExpect(jsonPath("$.[*].origin").value(hasItem(DEFAULT_ORIGIN)))
            .andExpect(jsonPath("$.[*].destination").value(hasItem(DEFAULT_DESTINATION)))
            .andExpect(jsonPath("$.[*].distance").value(hasItem(DEFAULT_DISTANCE)))
            .andExpect(jsonPath("$.[*].estimatedDuration").value(hasItem(DEFAULT_ESTIMATED_DURATION)))
            .andExpect(jsonPath("$.[*].transportType").value(hasItem(DEFAULT_TRANSPORT_TYPE.toString())))
            .andExpect(jsonPath("$.[*].isActive").value(hasItem(DEFAULT_IS_ACTIVE)))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())));
    }

    protected long getRepositoryCount() {
        return routeRepository.count();
    }

    protected void assertIncrementedRepositoryCount(long countBefore) {
        assertThat(countBefore + 1).isEqualTo(getRepositoryCount());
    }

    protected void assertDecrementedRepositoryCount(long countBefore) {
        assertThat(countBefore - 1).isEqualTo(getRepositoryCount());
    }

    protected void assertSameRepositoryCount(long countBefore) {
        assertThat(countBefore).isEqualTo(getRepositoryCount());
    }

    protected Route getPersistedRoute(Route route) {
        return routeRepository.findById(route.getId()).orElseThrow();
    }

    protected void assertPersistedRouteToMatchAllProperties(Route expectedRoute) {
        assertRouteAllPropertiesEquals(expectedRoute, getPersistedRoute(expectedRoute));
    }

    protected void assertPersistedRouteToMatchUpdatableProperties(Route expectedRoute) {
        assertRouteAllUpdatablePropertiesEquals(expectedRoute, getPersistedRoute(expectedRoute));
    }
}
