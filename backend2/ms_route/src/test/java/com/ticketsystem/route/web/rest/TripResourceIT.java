package com.ticketsystem.route.web.rest;

import static com.ticketsystem.route.domain.TripAsserts.*;
import static com.ticketsystem.route.web.rest.TestUtil.createUpdateProxyForBean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketsystem.route.IntegrationTest;
import com.ticketsystem.route.domain.Route;
import com.ticketsystem.route.domain.Trip;
import com.ticketsystem.route.repository.TripRepository;
import com.ticketsystem.route.service.dto.TripDTO;
import com.ticketsystem.route.service.mapper.TripMapper;
import jakarta.persistence.EntityManager;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link TripResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class TripResourceIT {

    private static final Instant DEFAULT_DEPARTURE_TIME = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_DEPARTURE_TIME = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_ARRIVAL_TIME = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_ARRIVAL_TIME = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Integer DEFAULT_AVAILABLE_SEATS = 1;
    private static final Integer UPDATED_AVAILABLE_SEATS = 2;
    private static final Integer SMALLER_AVAILABLE_SEATS = 1 - 1;

    private static final Integer DEFAULT_TOTAL_SEATS = 1;
    private static final Integer UPDATED_TOTAL_SEATS = 2;
    private static final Integer SMALLER_TOTAL_SEATS = 1 - 1;

    private static final String DEFAULT_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_STATUS = "BBBBBBBBBB";

    private static final UUID DEFAULT_DRIVER_ID = UUID.randomUUID();
    private static final UUID UPDATED_DRIVER_ID = UUID.randomUUID();

    private static final String ENTITY_API_URL = "/api/trips";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private TripMapper tripMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restTripMockMvc;

    private Trip trip;

    private Trip insertedTrip;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Trip createEntity(EntityManager em) {
        Trip trip = new Trip()
            .departureTime(DEFAULT_DEPARTURE_TIME)
            .arrivalTime(DEFAULT_ARRIVAL_TIME)
            .availableSeats(DEFAULT_AVAILABLE_SEATS)
            .totalSeats(DEFAULT_TOTAL_SEATS)
            .status(DEFAULT_STATUS)
            .driverId(DEFAULT_DRIVER_ID);
        // Add required entity
        Route route;
        if (TestUtil.findAll(em, Route.class).isEmpty()) {
            route = RouteResourceIT.createEntity(em);
            em.persist(route);
            em.flush();
        } else {
            route = TestUtil.findAll(em, Route.class).get(0);
        }
        trip.setRoute(route);
        return trip;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Trip createUpdatedEntity(EntityManager em) {
        Trip updatedTrip = new Trip()
            .departureTime(UPDATED_DEPARTURE_TIME)
            .arrivalTime(UPDATED_ARRIVAL_TIME)
            .availableSeats(UPDATED_AVAILABLE_SEATS)
            .totalSeats(UPDATED_TOTAL_SEATS)
            .status(UPDATED_STATUS)
            .driverId(UPDATED_DRIVER_ID);
        // Add required entity
        Route route;
        if (TestUtil.findAll(em, Route.class).isEmpty()) {
            route = RouteResourceIT.createUpdatedEntity(em);
            em.persist(route);
            em.flush();
        } else {
            route = TestUtil.findAll(em, Route.class).get(0);
        }
        updatedTrip.setRoute(route);
        return updatedTrip;
    }

    @BeforeEach
    void initTest() {
        trip = createEntity(em);
    }

    @AfterEach
    void cleanup() {
        if (insertedTrip != null) {
            tripRepository.delete(insertedTrip);
            insertedTrip = null;
        }
    }

    @Test
    @Transactional
    void createTrip() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the Trip
        TripDTO tripDTO = tripMapper.toDto(trip);
        var returnedTripDTO = om.readValue(
            restTripMockMvc
                .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(tripDTO)))
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            TripDTO.class
        );

        // Validate the Trip in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        var returnedTrip = tripMapper.toEntity(returnedTripDTO);
        assertTripUpdatableFieldsEquals(returnedTrip, getPersistedTrip(returnedTrip));

        insertedTrip = returnedTrip;
    }

    @Test
    @Transactional
    void createTripWithExistingId() throws Exception {
        // Create the Trip with an existing ID
        trip.setId(1L);
        TripDTO tripDTO = tripMapper.toDto(trip);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restTripMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(tripDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Trip in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkDepartureTimeIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        trip.setDepartureTime(null);

        // Create the Trip, which fails.
        TripDTO tripDTO = tripMapper.toDto(trip);

        restTripMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(tripDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkArrivalTimeIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        trip.setArrivalTime(null);

        // Create the Trip, which fails.
        TripDTO tripDTO = tripMapper.toDto(trip);

        restTripMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(tripDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkAvailableSeatsIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        trip.setAvailableSeats(null);

        // Create the Trip, which fails.
        TripDTO tripDTO = tripMapper.toDto(trip);

        restTripMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(tripDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkTotalSeatsIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        trip.setTotalSeats(null);

        // Create the Trip, which fails.
        TripDTO tripDTO = tripMapper.toDto(trip);

        restTripMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(tripDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllTrips() throws Exception {
        // Initialize the database
        insertedTrip = tripRepository.saveAndFlush(trip);

        // Get all the tripList
        restTripMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(trip.getId().intValue())))
            .andExpect(jsonPath("$.[*].departureTime").value(hasItem(DEFAULT_DEPARTURE_TIME.toString())))
            .andExpect(jsonPath("$.[*].arrivalTime").value(hasItem(DEFAULT_ARRIVAL_TIME.toString())))
            .andExpect(jsonPath("$.[*].availableSeats").value(hasItem(DEFAULT_AVAILABLE_SEATS)))
            .andExpect(jsonPath("$.[*].totalSeats").value(hasItem(DEFAULT_TOTAL_SEATS)))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS)))
            .andExpect(jsonPath("$.[*].driverId").value(hasItem(DEFAULT_DRIVER_ID.toString())));
    }

    @Test
    @Transactional
    void getTrip() throws Exception {
        // Initialize the database
        insertedTrip = tripRepository.saveAndFlush(trip);

        // Get the trip
        restTripMockMvc
            .perform(get(ENTITY_API_URL_ID, trip.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(trip.getId().intValue()))
            .andExpect(jsonPath("$.departureTime").value(DEFAULT_DEPARTURE_TIME.toString()))
            .andExpect(jsonPath("$.arrivalTime").value(DEFAULT_ARRIVAL_TIME.toString()))
            .andExpect(jsonPath("$.availableSeats").value(DEFAULT_AVAILABLE_SEATS))
            .andExpect(jsonPath("$.totalSeats").value(DEFAULT_TOTAL_SEATS))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS))
            .andExpect(jsonPath("$.driverId").value(DEFAULT_DRIVER_ID.toString()));
    }

    @Test
    @Transactional
    void getTripsByIdFiltering() throws Exception {
        // Initialize the database
        insertedTrip = tripRepository.saveAndFlush(trip);

        Long id = trip.getId();

        defaultTripFiltering("id.equals=" + id, "id.notEquals=" + id);

        defaultTripFiltering("id.greaterThanOrEqual=" + id, "id.greaterThan=" + id);

        defaultTripFiltering("id.lessThanOrEqual=" + id, "id.lessThan=" + id);
    }

    @Test
    @Transactional
    void getAllTripsByDepartureTimeIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedTrip = tripRepository.saveAndFlush(trip);

        // Get all the tripList where departureTime equals to
        defaultTripFiltering("departureTime.equals=" + DEFAULT_DEPARTURE_TIME, "departureTime.equals=" + UPDATED_DEPARTURE_TIME);
    }

    @Test
    @Transactional
    void getAllTripsByDepartureTimeIsInShouldWork() throws Exception {
        // Initialize the database
        insertedTrip = tripRepository.saveAndFlush(trip);

        // Get all the tripList where departureTime in
        defaultTripFiltering(
            "departureTime.in=" + DEFAULT_DEPARTURE_TIME + "," + UPDATED_DEPARTURE_TIME,
            "departureTime.in=" + UPDATED_DEPARTURE_TIME
        );
    }

    @Test
    @Transactional
    void getAllTripsByDepartureTimeIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedTrip = tripRepository.saveAndFlush(trip);

        // Get all the tripList where departureTime is not null
        defaultTripFiltering("departureTime.specified=true", "departureTime.specified=false");
    }

    @Test
    @Transactional
    void getAllTripsByArrivalTimeIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedTrip = tripRepository.saveAndFlush(trip);

        // Get all the tripList where arrivalTime equals to
        defaultTripFiltering("arrivalTime.equals=" + DEFAULT_ARRIVAL_TIME, "arrivalTime.equals=" + UPDATED_ARRIVAL_TIME);
    }

    @Test
    @Transactional
    void getAllTripsByArrivalTimeIsInShouldWork() throws Exception {
        // Initialize the database
        insertedTrip = tripRepository.saveAndFlush(trip);

        // Get all the tripList where arrivalTime in
        defaultTripFiltering(
            "arrivalTime.in=" + DEFAULT_ARRIVAL_TIME + "," + UPDATED_ARRIVAL_TIME,
            "arrivalTime.in=" + UPDATED_ARRIVAL_TIME
        );
    }

    @Test
    @Transactional
    void getAllTripsByArrivalTimeIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedTrip = tripRepository.saveAndFlush(trip);

        // Get all the tripList where arrivalTime is not null
        defaultTripFiltering("arrivalTime.specified=true", "arrivalTime.specified=false");
    }

    @Test
    @Transactional
    void getAllTripsByAvailableSeatsIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedTrip = tripRepository.saveAndFlush(trip);

        // Get all the tripList where availableSeats equals to
        defaultTripFiltering("availableSeats.equals=" + DEFAULT_AVAILABLE_SEATS, "availableSeats.equals=" + UPDATED_AVAILABLE_SEATS);
    }

    @Test
    @Transactional
    void getAllTripsByAvailableSeatsIsInShouldWork() throws Exception {
        // Initialize the database
        insertedTrip = tripRepository.saveAndFlush(trip);

        // Get all the tripList where availableSeats in
        defaultTripFiltering(
            "availableSeats.in=" + DEFAULT_AVAILABLE_SEATS + "," + UPDATED_AVAILABLE_SEATS,
            "availableSeats.in=" + UPDATED_AVAILABLE_SEATS
        );
    }

    @Test
    @Transactional
    void getAllTripsByAvailableSeatsIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedTrip = tripRepository.saveAndFlush(trip);

        // Get all the tripList where availableSeats is not null
        defaultTripFiltering("availableSeats.specified=true", "availableSeats.specified=false");
    }

    @Test
    @Transactional
    void getAllTripsByAvailableSeatsIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedTrip = tripRepository.saveAndFlush(trip);

        // Get all the tripList where availableSeats is greater than or equal to
        defaultTripFiltering(
            "availableSeats.greaterThanOrEqual=" + DEFAULT_AVAILABLE_SEATS,
            "availableSeats.greaterThanOrEqual=" + UPDATED_AVAILABLE_SEATS
        );
    }

    @Test
    @Transactional
    void getAllTripsByAvailableSeatsIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedTrip = tripRepository.saveAndFlush(trip);

        // Get all the tripList where availableSeats is less than or equal to
        defaultTripFiltering(
            "availableSeats.lessThanOrEqual=" + DEFAULT_AVAILABLE_SEATS,
            "availableSeats.lessThanOrEqual=" + SMALLER_AVAILABLE_SEATS
        );
    }

    @Test
    @Transactional
    void getAllTripsByAvailableSeatsIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedTrip = tripRepository.saveAndFlush(trip);

        // Get all the tripList where availableSeats is less than
        defaultTripFiltering("availableSeats.lessThan=" + UPDATED_AVAILABLE_SEATS, "availableSeats.lessThan=" + DEFAULT_AVAILABLE_SEATS);
    }

    @Test
    @Transactional
    void getAllTripsByAvailableSeatsIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedTrip = tripRepository.saveAndFlush(trip);

        // Get all the tripList where availableSeats is greater than
        defaultTripFiltering(
            "availableSeats.greaterThan=" + SMALLER_AVAILABLE_SEATS,
            "availableSeats.greaterThan=" + DEFAULT_AVAILABLE_SEATS
        );
    }

    @Test
    @Transactional
    void getAllTripsByTotalSeatsIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedTrip = tripRepository.saveAndFlush(trip);

        // Get all the tripList where totalSeats equals to
        defaultTripFiltering("totalSeats.equals=" + DEFAULT_TOTAL_SEATS, "totalSeats.equals=" + UPDATED_TOTAL_SEATS);
    }

    @Test
    @Transactional
    void getAllTripsByTotalSeatsIsInShouldWork() throws Exception {
        // Initialize the database
        insertedTrip = tripRepository.saveAndFlush(trip);

        // Get all the tripList where totalSeats in
        defaultTripFiltering("totalSeats.in=" + DEFAULT_TOTAL_SEATS + "," + UPDATED_TOTAL_SEATS, "totalSeats.in=" + UPDATED_TOTAL_SEATS);
    }

    @Test
    @Transactional
    void getAllTripsByTotalSeatsIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedTrip = tripRepository.saveAndFlush(trip);

        // Get all the tripList where totalSeats is not null
        defaultTripFiltering("totalSeats.specified=true", "totalSeats.specified=false");
    }

    @Test
    @Transactional
    void getAllTripsByTotalSeatsIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedTrip = tripRepository.saveAndFlush(trip);

        // Get all the tripList where totalSeats is greater than or equal to
        defaultTripFiltering(
            "totalSeats.greaterThanOrEqual=" + DEFAULT_TOTAL_SEATS,
            "totalSeats.greaterThanOrEqual=" + UPDATED_TOTAL_SEATS
        );
    }

    @Test
    @Transactional
    void getAllTripsByTotalSeatsIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedTrip = tripRepository.saveAndFlush(trip);

        // Get all the tripList where totalSeats is less than or equal to
        defaultTripFiltering("totalSeats.lessThanOrEqual=" + DEFAULT_TOTAL_SEATS, "totalSeats.lessThanOrEqual=" + SMALLER_TOTAL_SEATS);
    }

    @Test
    @Transactional
    void getAllTripsByTotalSeatsIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedTrip = tripRepository.saveAndFlush(trip);

        // Get all the tripList where totalSeats is less than
        defaultTripFiltering("totalSeats.lessThan=" + UPDATED_TOTAL_SEATS, "totalSeats.lessThan=" + DEFAULT_TOTAL_SEATS);
    }

    @Test
    @Transactional
    void getAllTripsByTotalSeatsIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedTrip = tripRepository.saveAndFlush(trip);

        // Get all the tripList where totalSeats is greater than
        defaultTripFiltering("totalSeats.greaterThan=" + SMALLER_TOTAL_SEATS, "totalSeats.greaterThan=" + DEFAULT_TOTAL_SEATS);
    }

    @Test
    @Transactional
    void getAllTripsByStatusIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedTrip = tripRepository.saveAndFlush(trip);

        // Get all the tripList where status equals to
        defaultTripFiltering("status.equals=" + DEFAULT_STATUS, "status.equals=" + UPDATED_STATUS);
    }

    @Test
    @Transactional
    void getAllTripsByStatusIsInShouldWork() throws Exception {
        // Initialize the database
        insertedTrip = tripRepository.saveAndFlush(trip);

        // Get all the tripList where status in
        defaultTripFiltering("status.in=" + DEFAULT_STATUS + "," + UPDATED_STATUS, "status.in=" + UPDATED_STATUS);
    }

    @Test
    @Transactional
    void getAllTripsByStatusIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedTrip = tripRepository.saveAndFlush(trip);

        // Get all the tripList where status is not null
        defaultTripFiltering("status.specified=true", "status.specified=false");
    }

    @Test
    @Transactional
    void getAllTripsByStatusContainsSomething() throws Exception {
        // Initialize the database
        insertedTrip = tripRepository.saveAndFlush(trip);

        // Get all the tripList where status contains
        defaultTripFiltering("status.contains=" + DEFAULT_STATUS, "status.contains=" + UPDATED_STATUS);
    }

    @Test
    @Transactional
    void getAllTripsByStatusNotContainsSomething() throws Exception {
        // Initialize the database
        insertedTrip = tripRepository.saveAndFlush(trip);

        // Get all the tripList where status does not contain
        defaultTripFiltering("status.doesNotContain=" + UPDATED_STATUS, "status.doesNotContain=" + DEFAULT_STATUS);
    }

    @Test
    @Transactional
    void getAllTripsByDriverIdIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedTrip = tripRepository.saveAndFlush(trip);

        // Get all the tripList where driverId equals to
        defaultTripFiltering("driverId.equals=" + DEFAULT_DRIVER_ID, "driverId.equals=" + UPDATED_DRIVER_ID);
    }

    @Test
    @Transactional
    void getAllTripsByDriverIdIsInShouldWork() throws Exception {
        // Initialize the database
        insertedTrip = tripRepository.saveAndFlush(trip);

        // Get all the tripList where driverId in
        defaultTripFiltering("driverId.in=" + DEFAULT_DRIVER_ID + "," + UPDATED_DRIVER_ID, "driverId.in=" + UPDATED_DRIVER_ID);
    }

    @Test
    @Transactional
    void getAllTripsByDriverIdIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedTrip = tripRepository.saveAndFlush(trip);

        // Get all the tripList where driverId is not null
        defaultTripFiltering("driverId.specified=true", "driverId.specified=false");
    }

    @Test
    @Transactional
    void getAllTripsByRouteIsEqualToSomething() throws Exception {
        Route route;
        if (TestUtil.findAll(em, Route.class).isEmpty()) {
            tripRepository.saveAndFlush(trip);
            route = RouteResourceIT.createEntity(em);
        } else {
            route = TestUtil.findAll(em, Route.class).get(0);
        }
        em.persist(route);
        em.flush();
        trip.setRoute(route);
        tripRepository.saveAndFlush(trip);
        Long routeId = route.getId();
        // Get all the tripList where route equals to routeId
        defaultTripShouldBeFound("routeId.equals=" + routeId);

        // Get all the tripList where route equals to (routeId + 1)
        defaultTripShouldNotBeFound("routeId.equals=" + (routeId + 1));
    }

    private void defaultTripFiltering(String shouldBeFound, String shouldNotBeFound) throws Exception {
        defaultTripShouldBeFound(shouldBeFound);
        defaultTripShouldNotBeFound(shouldNotBeFound);
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultTripShouldBeFound(String filter) throws Exception {
        restTripMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(trip.getId().intValue())))
            .andExpect(jsonPath("$.[*].departureTime").value(hasItem(DEFAULT_DEPARTURE_TIME.toString())))
            .andExpect(jsonPath("$.[*].arrivalTime").value(hasItem(DEFAULT_ARRIVAL_TIME.toString())))
            .andExpect(jsonPath("$.[*].availableSeats").value(hasItem(DEFAULT_AVAILABLE_SEATS)))
            .andExpect(jsonPath("$.[*].totalSeats").value(hasItem(DEFAULT_TOTAL_SEATS)))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS)))
            .andExpect(jsonPath("$.[*].driverId").value(hasItem(DEFAULT_DRIVER_ID.toString())));

        // Check, that the count call also returns 1
        restTripMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("1"));
    }

    /**
     * Executes the search, and checks that the default entity is not returned.
     */
    private void defaultTripShouldNotBeFound(String filter) throws Exception {
        restTripMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());

        // Check, that the count call also returns 0
        restTripMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("0"));
    }

    @Test
    @Transactional
    void getNonExistingTrip() throws Exception {
        // Get the trip
        restTripMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingTrip() throws Exception {
        // Initialize the database
        insertedTrip = tripRepository.saveAndFlush(trip);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the trip
        Trip updatedTrip = tripRepository.findById(trip.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedTrip are not directly saved in db
        em.detach(updatedTrip);
        updatedTrip
            .departureTime(UPDATED_DEPARTURE_TIME)
            .arrivalTime(UPDATED_ARRIVAL_TIME)
            .availableSeats(UPDATED_AVAILABLE_SEATS)
            .totalSeats(UPDATED_TOTAL_SEATS)
            .status(UPDATED_STATUS)
            .driverId(UPDATED_DRIVER_ID);
        TripDTO tripDTO = tripMapper.toDto(updatedTrip);

        restTripMockMvc
            .perform(
                put(ENTITY_API_URL_ID, tripDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(tripDTO))
            )
            .andExpect(status().isOk());

        // Validate the Trip in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedTripToMatchAllProperties(updatedTrip);
    }

    @Test
    @Transactional
    void putNonExistingTrip() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        trip.setId(longCount.incrementAndGet());

        // Create the Trip
        TripDTO tripDTO = tripMapper.toDto(trip);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restTripMockMvc
            .perform(
                put(ENTITY_API_URL_ID, tripDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(tripDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Trip in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchTrip() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        trip.setId(longCount.incrementAndGet());

        // Create the Trip
        TripDTO tripDTO = tripMapper.toDto(trip);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTripMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(tripDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Trip in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamTrip() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        trip.setId(longCount.incrementAndGet());

        // Create the Trip
        TripDTO tripDTO = tripMapper.toDto(trip);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTripMockMvc
            .perform(put(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(tripDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Trip in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateTripWithPatch() throws Exception {
        // Initialize the database
        insertedTrip = tripRepository.saveAndFlush(trip);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the trip using partial update
        Trip partialUpdatedTrip = new Trip();
        partialUpdatedTrip.setId(trip.getId());

        restTripMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedTrip.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedTrip))
            )
            .andExpect(status().isOk());

        // Validate the Trip in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertTripUpdatableFieldsEquals(createUpdateProxyForBean(partialUpdatedTrip, trip), getPersistedTrip(trip));
    }

    @Test
    @Transactional
    void fullUpdateTripWithPatch() throws Exception {
        // Initialize the database
        insertedTrip = tripRepository.saveAndFlush(trip);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the trip using partial update
        Trip partialUpdatedTrip = new Trip();
        partialUpdatedTrip.setId(trip.getId());

        partialUpdatedTrip
            .departureTime(UPDATED_DEPARTURE_TIME)
            .arrivalTime(UPDATED_ARRIVAL_TIME)
            .availableSeats(UPDATED_AVAILABLE_SEATS)
            .totalSeats(UPDATED_TOTAL_SEATS)
            .status(UPDATED_STATUS)
            .driverId(UPDATED_DRIVER_ID);

        restTripMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedTrip.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedTrip))
            )
            .andExpect(status().isOk());

        // Validate the Trip in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertTripUpdatableFieldsEquals(partialUpdatedTrip, getPersistedTrip(partialUpdatedTrip));
    }

    @Test
    @Transactional
    void patchNonExistingTrip() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        trip.setId(longCount.incrementAndGet());

        // Create the Trip
        TripDTO tripDTO = tripMapper.toDto(trip);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restTripMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, tripDTO.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(tripDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Trip in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchTrip() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        trip.setId(longCount.incrementAndGet());

        // Create the Trip
        TripDTO tripDTO = tripMapper.toDto(trip);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTripMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(tripDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Trip in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamTrip() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        trip.setId(longCount.incrementAndGet());

        // Create the Trip
        TripDTO tripDTO = tripMapper.toDto(trip);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTripMockMvc
            .perform(patch(ENTITY_API_URL).with(csrf()).contentType("application/merge-patch+json").content(om.writeValueAsBytes(tripDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Trip in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteTrip() throws Exception {
        // Initialize the database
        insertedTrip = tripRepository.saveAndFlush(trip);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the trip
        restTripMockMvc
            .perform(delete(ENTITY_API_URL_ID, trip.getId()).with(csrf()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return tripRepository.count();
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

    protected Trip getPersistedTrip(Trip trip) {
        return tripRepository.findById(trip.getId()).orElseThrow();
    }

    protected void assertPersistedTripToMatchAllProperties(Trip expectedTrip) {
        assertTripAllPropertiesEquals(expectedTrip, getPersistedTrip(expectedTrip));
    }

    protected void assertPersistedTripToMatchUpdatableProperties(Trip expectedTrip) {
        assertTripAllUpdatablePropertiesEquals(expectedTrip, getPersistedTrip(expectedTrip));
    }
}
