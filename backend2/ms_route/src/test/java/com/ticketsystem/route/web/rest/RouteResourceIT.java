package com.ticketsystem.route.web.rest;

import static com.ticketsystem.route.domain.RouteAsserts.*;
import static com.ticketsystem.route.web.rest.TestUtil.createUpdateProxyForBean;
import static com.ticketsystem.route.web.rest.TestUtil.sameNumber;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.hamcrest.Matchers.hasItem;
import static org.mockito.Mockito.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketsystem.route.IntegrationTest;
import com.ticketsystem.route.domain.Operator;
import com.ticketsystem.route.domain.Route;
import com.ticketsystem.route.domain.Station;
import com.ticketsystem.route.domain.enumeration.TransportType;
import com.ticketsystem.route.repository.RouteRepository;
import com.ticketsystem.route.repository.search.RouteSearchRepository;
import com.ticketsystem.route.service.dto.RouteDTO;
import com.ticketsystem.route.service.mapper.RouteMapper;
import jakarta.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
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

    private static final TransportType DEFAULT_TRANSPORT_TYPE = TransportType.BUS;
    private static final TransportType UPDATED_TRANSPORT_TYPE = TransportType.TRAIN;

    private static final BigDecimal DEFAULT_DISTANCE = new BigDecimal(1);
    private static final BigDecimal UPDATED_DISTANCE = new BigDecimal(2);
    private static final BigDecimal SMALLER_DISTANCE = new BigDecimal(1 - 1);

    private static final Integer DEFAULT_ESTIMATED_DURATION = 1;
    private static final Integer UPDATED_ESTIMATED_DURATION = 2;
    private static final Integer SMALLER_ESTIMATED_DURATION = 1 - 1;

    private static final BigDecimal DEFAULT_BASE_PRICE = new BigDecimal(1);
    private static final BigDecimal UPDATED_BASE_PRICE = new BigDecimal(2);
    private static final BigDecimal SMALLER_BASE_PRICE = new BigDecimal(1 - 1);

    private static final Boolean DEFAULT_IS_ACTIVE = false;
    private static final Boolean UPDATED_IS_ACTIVE = true;

    private static final String ENTITY_API_URL = "/api/routes";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";
    private static final String ENTITY_SEARCH_API_URL = "/api/routes/_search";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

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
    public static Route createEntity(EntityManager em) {
        Route route = new Route()
            .transportType(DEFAULT_TRANSPORT_TYPE)
            .distance(DEFAULT_DISTANCE)
            .estimatedDuration(DEFAULT_ESTIMATED_DURATION)
            .basePrice(DEFAULT_BASE_PRICE)
            .isActive(DEFAULT_IS_ACTIVE);
        // Add required entity
        Operator operator;
        if (TestUtil.findAll(em, Operator.class).isEmpty()) {
            operator = OperatorResourceIT.createEntity();
            em.persist(operator);
            em.flush();
        } else {
            operator = TestUtil.findAll(em, Operator.class).get(0);
        }
        route.setOperator(operator);
        return route;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Route createUpdatedEntity(EntityManager em) {
        Route updatedRoute = new Route()
            .transportType(UPDATED_TRANSPORT_TYPE)
            .distance(UPDATED_DISTANCE)
            .estimatedDuration(UPDATED_ESTIMATED_DURATION)
            .basePrice(UPDATED_BASE_PRICE)
            .isActive(UPDATED_IS_ACTIVE);
        // Add required entity
        Operator operator;
        if (TestUtil.findAll(em, Operator.class).isEmpty()) {
            operator = OperatorResourceIT.createUpdatedEntity();
            em.persist(operator);
            em.flush();
        } else {
            operator = TestUtil.findAll(em, Operator.class).get(0);
        }
        updatedRoute.setOperator(operator);
        return updatedRoute;
    }

    @BeforeEach
    void initTest() {
        route = createEntity(em);
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
        route.setId(1L);
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
    void checkBasePriceIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(routeSearchRepository.findAll());
        // set the field null
        route.setBasePrice(null);

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
    void getAllRoutes() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get all the routeList
        restRouteMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(route.getId().intValue())))
            .andExpect(jsonPath("$.[*].transportType").value(hasItem(DEFAULT_TRANSPORT_TYPE.toString())))
            .andExpect(jsonPath("$.[*].distance").value(hasItem(sameNumber(DEFAULT_DISTANCE))))
            .andExpect(jsonPath("$.[*].estimatedDuration").value(hasItem(DEFAULT_ESTIMATED_DURATION)))
            .andExpect(jsonPath("$.[*].basePrice").value(hasItem(sameNumber(DEFAULT_BASE_PRICE))))
            .andExpect(jsonPath("$.[*].isActive").value(hasItem(DEFAULT_IS_ACTIVE)));
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
            .andExpect(jsonPath("$.id").value(route.getId().intValue()))
            .andExpect(jsonPath("$.transportType").value(DEFAULT_TRANSPORT_TYPE.toString()))
            .andExpect(jsonPath("$.distance").value(sameNumber(DEFAULT_DISTANCE)))
            .andExpect(jsonPath("$.estimatedDuration").value(DEFAULT_ESTIMATED_DURATION))
            .andExpect(jsonPath("$.basePrice").value(sameNumber(DEFAULT_BASE_PRICE)))
            .andExpect(jsonPath("$.isActive").value(DEFAULT_IS_ACTIVE));
    }

    @Test
    @Transactional
    void getRoutesByIdFiltering() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        Long id = route.getId();

        defaultRouteFiltering("id.equals=" + id, "id.notEquals=" + id);

        defaultRouteFiltering("id.greaterThanOrEqual=" + id, "id.greaterThan=" + id);

        defaultRouteFiltering("id.lessThanOrEqual=" + id, "id.lessThan=" + id);
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
    void getAllRoutesByBasePriceIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get all the routeList where basePrice equals to
        defaultRouteFiltering("basePrice.equals=" + DEFAULT_BASE_PRICE, "basePrice.equals=" + UPDATED_BASE_PRICE);
    }

    @Test
    @Transactional
    void getAllRoutesByBasePriceIsInShouldWork() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get all the routeList where basePrice in
        defaultRouteFiltering("basePrice.in=" + DEFAULT_BASE_PRICE + "," + UPDATED_BASE_PRICE, "basePrice.in=" + UPDATED_BASE_PRICE);
    }

    @Test
    @Transactional
    void getAllRoutesByBasePriceIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get all the routeList where basePrice is not null
        defaultRouteFiltering("basePrice.specified=true", "basePrice.specified=false");
    }

    @Test
    @Transactional
    void getAllRoutesByBasePriceIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get all the routeList where basePrice is greater than or equal to
        defaultRouteFiltering("basePrice.greaterThanOrEqual=" + DEFAULT_BASE_PRICE, "basePrice.greaterThanOrEqual=" + UPDATED_BASE_PRICE);
    }

    @Test
    @Transactional
    void getAllRoutesByBasePriceIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get all the routeList where basePrice is less than or equal to
        defaultRouteFiltering("basePrice.lessThanOrEqual=" + DEFAULT_BASE_PRICE, "basePrice.lessThanOrEqual=" + SMALLER_BASE_PRICE);
    }

    @Test
    @Transactional
    void getAllRoutesByBasePriceIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get all the routeList where basePrice is less than
        defaultRouteFiltering("basePrice.lessThan=" + UPDATED_BASE_PRICE, "basePrice.lessThan=" + DEFAULT_BASE_PRICE);
    }

    @Test
    @Transactional
    void getAllRoutesByBasePriceIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedRoute = routeRepository.saveAndFlush(route);

        // Get all the routeList where basePrice is greater than
        defaultRouteFiltering("basePrice.greaterThan=" + SMALLER_BASE_PRICE, "basePrice.greaterThan=" + DEFAULT_BASE_PRICE);
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
    void getAllRoutesByOriginIsEqualToSomething() throws Exception {
        Station origin;
        if (TestUtil.findAll(em, Station.class).isEmpty()) {
            routeRepository.saveAndFlush(route);
            origin = StationResourceIT.createEntity();
        } else {
            origin = TestUtil.findAll(em, Station.class).get(0);
        }
        em.persist(origin);
        em.flush();
        route.setOrigin(origin);
        routeRepository.saveAndFlush(route);
        Long originId = origin.getId();
        // Get all the routeList where origin equals to originId
        defaultRouteShouldBeFound("originId.equals=" + originId);

        // Get all the routeList where origin equals to (originId + 1)
        defaultRouteShouldNotBeFound("originId.equals=" + (originId + 1));
    }

    @Test
    @Transactional
    void getAllRoutesByDestinationIsEqualToSomething() throws Exception {
        Station destination;
        if (TestUtil.findAll(em, Station.class).isEmpty()) {
            routeRepository.saveAndFlush(route);
            destination = StationResourceIT.createEntity();
        } else {
            destination = TestUtil.findAll(em, Station.class).get(0);
        }
        em.persist(destination);
        em.flush();
        route.setDestination(destination);
        routeRepository.saveAndFlush(route);
        Long destinationId = destination.getId();
        // Get all the routeList where destination equals to destinationId
        defaultRouteShouldBeFound("destinationId.equals=" + destinationId);

        // Get all the routeList where destination equals to (destinationId + 1)
        defaultRouteShouldNotBeFound("destinationId.equals=" + (destinationId + 1));
    }

    @Test
    @Transactional
    void getAllRoutesByOperatorIsEqualToSomething() throws Exception {
        Operator operator;
        if (TestUtil.findAll(em, Operator.class).isEmpty()) {
            routeRepository.saveAndFlush(route);
            operator = OperatorResourceIT.createEntity();
        } else {
            operator = TestUtil.findAll(em, Operator.class).get(0);
        }
        em.persist(operator);
        em.flush();
        route.setOperator(operator);
        routeRepository.saveAndFlush(route);
        Long operatorId = operator.getId();
        // Get all the routeList where operator equals to operatorId
        defaultRouteShouldBeFound("operatorId.equals=" + operatorId);

        // Get all the routeList where operator equals to (operatorId + 1)
        defaultRouteShouldNotBeFound("operatorId.equals=" + (operatorId + 1));
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
            .andExpect(jsonPath("$.[*].id").value(hasItem(route.getId().intValue())))
            .andExpect(jsonPath("$.[*].transportType").value(hasItem(DEFAULT_TRANSPORT_TYPE.toString())))
            .andExpect(jsonPath("$.[*].distance").value(hasItem(sameNumber(DEFAULT_DISTANCE))))
            .andExpect(jsonPath("$.[*].estimatedDuration").value(hasItem(DEFAULT_ESTIMATED_DURATION)))
            .andExpect(jsonPath("$.[*].basePrice").value(hasItem(sameNumber(DEFAULT_BASE_PRICE))))
            .andExpect(jsonPath("$.[*].isActive").value(hasItem(DEFAULT_IS_ACTIVE)));

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
        restRouteMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
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
            .transportType(UPDATED_TRANSPORT_TYPE)
            .distance(UPDATED_DISTANCE)
            .estimatedDuration(UPDATED_ESTIMATED_DURATION)
            .basePrice(UPDATED_BASE_PRICE)
            .isActive(UPDATED_IS_ACTIVE);
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
        route.setId(longCount.incrementAndGet());

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
        route.setId(longCount.incrementAndGet());

        // Create the Route
        RouteDTO routeDTO = routeMapper.toDto(route);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restRouteMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
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
        route.setId(longCount.incrementAndGet());

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

        partialUpdatedRoute.transportType(UPDATED_TRANSPORT_TYPE);

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
            .transportType(UPDATED_TRANSPORT_TYPE)
            .distance(UPDATED_DISTANCE)
            .estimatedDuration(UPDATED_ESTIMATED_DURATION)
            .basePrice(UPDATED_BASE_PRICE)
            .isActive(UPDATED_IS_ACTIVE);

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
        route.setId(longCount.incrementAndGet());

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
        route.setId(longCount.incrementAndGet());

        // Create the Route
        RouteDTO routeDTO = routeMapper.toDto(route);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restRouteMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
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
        route.setId(longCount.incrementAndGet());

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
            .perform(delete(ENTITY_API_URL_ID, route.getId()).with(csrf()).accept(MediaType.APPLICATION_JSON))
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
            .andExpect(jsonPath("$.[*].id").value(hasItem(route.getId().intValue())))
            .andExpect(jsonPath("$.[*].transportType").value(hasItem(DEFAULT_TRANSPORT_TYPE.toString())))
            .andExpect(jsonPath("$.[*].distance").value(hasItem(sameNumber(DEFAULT_DISTANCE))))
            .andExpect(jsonPath("$.[*].estimatedDuration").value(hasItem(DEFAULT_ESTIMATED_DURATION)))
            .andExpect(jsonPath("$.[*].basePrice").value(hasItem(sameNumber(DEFAULT_BASE_PRICE))))
            .andExpect(jsonPath("$.[*].isActive").value(hasItem(DEFAULT_IS_ACTIVE)));
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
