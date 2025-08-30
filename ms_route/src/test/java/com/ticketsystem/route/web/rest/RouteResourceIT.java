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

    private static final Integer DEFAULT_ESTIMATED_DURATION = 1;
    private static final Integer UPDATED_ESTIMATED_DURATION = 2;

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
