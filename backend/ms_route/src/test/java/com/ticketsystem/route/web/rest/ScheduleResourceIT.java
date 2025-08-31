package com.ticketsystem.route.web.rest;

import static com.ticketsystem.route.domain.ScheduleAsserts.*;
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
import com.ticketsystem.route.domain.Route;
import com.ticketsystem.route.domain.Schedule;
import com.ticketsystem.route.repository.ScheduleRepository;
import com.ticketsystem.route.repository.search.ScheduleSearchRepository;
import com.ticketsystem.route.service.dto.ScheduleDTO;
import com.ticketsystem.route.service.mapper.ScheduleMapper;
import jakarta.persistence.EntityManager;
import java.math.BigDecimal;
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
 * Integration tests for the {@link ScheduleResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class ScheduleResourceIT {

    private static final Instant DEFAULT_DEPARTURE_TIME = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_DEPARTURE_TIME = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_ARRIVAL_TIME = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_ARRIVAL_TIME = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Integer DEFAULT_TOTAL_SEATS = 1;
    private static final Integer UPDATED_TOTAL_SEATS = 2;
    private static final Integer SMALLER_TOTAL_SEATS = 1 - 1;

    private static final Integer DEFAULT_AVAILABLE_SEATS = 1;
    private static final Integer UPDATED_AVAILABLE_SEATS = 2;
    private static final Integer SMALLER_AVAILABLE_SEATS = 1 - 1;

    private static final BigDecimal DEFAULT_BASE_PRICE = new BigDecimal(1);
    private static final BigDecimal UPDATED_BASE_PRICE = new BigDecimal(2);
    private static final BigDecimal SMALLER_BASE_PRICE = new BigDecimal(1 - 1);

    private static final Boolean DEFAULT_IS_ACTIVE = false;
    private static final Boolean UPDATED_IS_ACTIVE = true;

    private static final Instant DEFAULT_CREATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_UPDATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_UPDATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String ENTITY_API_URL = "/api/schedules";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";
    private static final String ENTITY_SEARCH_API_URL = "/api/schedules/_search";

    @Autowired
    private ObjectMapper om;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private ScheduleMapper scheduleMapper;

    @Autowired
    private ScheduleSearchRepository scheduleSearchRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restScheduleMockMvc;

    private Schedule schedule;

    private Schedule insertedSchedule;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Schedule createEntity(EntityManager em) {
        Schedule schedule = new Schedule()
            .departureTime(DEFAULT_DEPARTURE_TIME)
            .arrivalTime(DEFAULT_ARRIVAL_TIME)
            .totalSeats(DEFAULT_TOTAL_SEATS)
            .availableSeats(DEFAULT_AVAILABLE_SEATS)
            .basePrice(DEFAULT_BASE_PRICE)
            .isActive(DEFAULT_IS_ACTIVE)
            .createdAt(DEFAULT_CREATED_AT)
            .updatedAt(DEFAULT_UPDATED_AT);
        // Add required entity
        Route route;
        if (TestUtil.findAll(em, Route.class).isEmpty()) {
            route = RouteResourceIT.createEntity();
            em.persist(route);
            em.flush();
        } else {
            route = TestUtil.findAll(em, Route.class).get(0);
        }
        schedule.setRoute(route);
        return schedule;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Schedule createUpdatedEntity(EntityManager em) {
        Schedule updatedSchedule = new Schedule()
            .departureTime(UPDATED_DEPARTURE_TIME)
            .arrivalTime(UPDATED_ARRIVAL_TIME)
            .totalSeats(UPDATED_TOTAL_SEATS)
            .availableSeats(UPDATED_AVAILABLE_SEATS)
            .basePrice(UPDATED_BASE_PRICE)
            .isActive(UPDATED_IS_ACTIVE)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT);
        // Add required entity
        Route route;
        if (TestUtil.findAll(em, Route.class).isEmpty()) {
            route = RouteResourceIT.createUpdatedEntity();
            em.persist(route);
            em.flush();
        } else {
            route = TestUtil.findAll(em, Route.class).get(0);
        }
        updatedSchedule.setRoute(route);
        return updatedSchedule;
    }

    @BeforeEach
    void initTest() {
        schedule = createEntity(em);
    }

    @AfterEach
    void cleanup() {
        if (insertedSchedule != null) {
            scheduleRepository.delete(insertedSchedule);
            scheduleSearchRepository.delete(insertedSchedule);
            insertedSchedule = null;
        }
    }

    @Test
    @Transactional
    void createSchedule() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(scheduleSearchRepository.findAll());
        // Create the Schedule
        ScheduleDTO scheduleDTO = scheduleMapper.toDto(schedule);
        var returnedScheduleDTO = om.readValue(
            restScheduleMockMvc
                .perform(
                    post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(scheduleDTO))
                )
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            ScheduleDTO.class
        );

        // Validate the Schedule in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        var returnedSchedule = scheduleMapper.toEntity(returnedScheduleDTO);
        assertScheduleUpdatableFieldsEquals(returnedSchedule, getPersistedSchedule(returnedSchedule));

        await()
            .atMost(5, TimeUnit.SECONDS)
            .untilAsserted(() -> {
                int searchDatabaseSizeAfter = IterableUtil.sizeOf(scheduleSearchRepository.findAll());
                assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore + 1);
            });

        insertedSchedule = returnedSchedule;
    }

    @Test
    @Transactional
    void createScheduleWithExistingId() throws Exception {
        // Create the Schedule with an existing ID
        insertedSchedule = scheduleRepository.saveAndFlush(schedule);
        ScheduleDTO scheduleDTO = scheduleMapper.toDto(schedule);

        long databaseSizeBeforeCreate = getRepositoryCount();
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(scheduleSearchRepository.findAll());

        // An entity with an existing ID cannot be created, so this API call must fail
        restScheduleMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(scheduleDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Schedule in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
        int searchDatabaseSizeAfter = IterableUtil.sizeOf(scheduleSearchRepository.findAll());
        assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore);
    }

    @Test
    @Transactional
    void checkDepartureTimeIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(scheduleSearchRepository.findAll());
        // set the field null
        schedule.setDepartureTime(null);

        // Create the Schedule, which fails.
        ScheduleDTO scheduleDTO = scheduleMapper.toDto(schedule);

        restScheduleMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(scheduleDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);

        int searchDatabaseSizeAfter = IterableUtil.sizeOf(scheduleSearchRepository.findAll());
        assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore);
    }

    @Test
    @Transactional
    void checkArrivalTimeIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(scheduleSearchRepository.findAll());
        // set the field null
        schedule.setArrivalTime(null);

        // Create the Schedule, which fails.
        ScheduleDTO scheduleDTO = scheduleMapper.toDto(schedule);

        restScheduleMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(scheduleDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);

        int searchDatabaseSizeAfter = IterableUtil.sizeOf(scheduleSearchRepository.findAll());
        assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore);
    }

    @Test
    @Transactional
    void checkTotalSeatsIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(scheduleSearchRepository.findAll());
        // set the field null
        schedule.setTotalSeats(null);

        // Create the Schedule, which fails.
        ScheduleDTO scheduleDTO = scheduleMapper.toDto(schedule);

        restScheduleMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(scheduleDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);

        int searchDatabaseSizeAfter = IterableUtil.sizeOf(scheduleSearchRepository.findAll());
        assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore);
    }

    @Test
    @Transactional
    void checkAvailableSeatsIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(scheduleSearchRepository.findAll());
        // set the field null
        schedule.setAvailableSeats(null);

        // Create the Schedule, which fails.
        ScheduleDTO scheduleDTO = scheduleMapper.toDto(schedule);

        restScheduleMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(scheduleDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);

        int searchDatabaseSizeAfter = IterableUtil.sizeOf(scheduleSearchRepository.findAll());
        assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore);
    }

    @Test
    @Transactional
    void checkBasePriceIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(scheduleSearchRepository.findAll());
        // set the field null
        schedule.setBasePrice(null);

        // Create the Schedule, which fails.
        ScheduleDTO scheduleDTO = scheduleMapper.toDto(schedule);

        restScheduleMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(scheduleDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);

        int searchDatabaseSizeAfter = IterableUtil.sizeOf(scheduleSearchRepository.findAll());
        assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore);
    }

    @Test
    @Transactional
    void checkIsActiveIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(scheduleSearchRepository.findAll());
        // set the field null
        schedule.setIsActive(null);

        // Create the Schedule, which fails.
        ScheduleDTO scheduleDTO = scheduleMapper.toDto(schedule);

        restScheduleMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(scheduleDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);

        int searchDatabaseSizeAfter = IterableUtil.sizeOf(scheduleSearchRepository.findAll());
        assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore);
    }

    @Test
    @Transactional
    void checkCreatedAtIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(scheduleSearchRepository.findAll());
        // set the field null
        schedule.setCreatedAt(null);

        // Create the Schedule, which fails.
        ScheduleDTO scheduleDTO = scheduleMapper.toDto(schedule);

        restScheduleMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(scheduleDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);

        int searchDatabaseSizeAfter = IterableUtil.sizeOf(scheduleSearchRepository.findAll());
        assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore);
    }

    @Test
    @Transactional
    void checkUpdatedAtIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(scheduleSearchRepository.findAll());
        // set the field null
        schedule.setUpdatedAt(null);

        // Create the Schedule, which fails.
        ScheduleDTO scheduleDTO = scheduleMapper.toDto(schedule);

        restScheduleMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(scheduleDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);

        int searchDatabaseSizeAfter = IterableUtil.sizeOf(scheduleSearchRepository.findAll());
        assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore);
    }

    @Test
    @Transactional
    void getAllSchedules() throws Exception {
        // Initialize the database
        insertedSchedule = scheduleRepository.saveAndFlush(schedule);

        // Get all the scheduleList
        restScheduleMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(schedule.getId().toString())))
            .andExpect(jsonPath("$.[*].departureTime").value(hasItem(DEFAULT_DEPARTURE_TIME.toString())))
            .andExpect(jsonPath("$.[*].arrivalTime").value(hasItem(DEFAULT_ARRIVAL_TIME.toString())))
            .andExpect(jsonPath("$.[*].totalSeats").value(hasItem(DEFAULT_TOTAL_SEATS)))
            .andExpect(jsonPath("$.[*].availableSeats").value(hasItem(DEFAULT_AVAILABLE_SEATS)))
            .andExpect(jsonPath("$.[*].basePrice").value(hasItem(sameNumber(DEFAULT_BASE_PRICE))))
            .andExpect(jsonPath("$.[*].isActive").value(hasItem(DEFAULT_IS_ACTIVE)))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())));
    }

    @Test
    @Transactional
    void getSchedule() throws Exception {
        // Initialize the database
        insertedSchedule = scheduleRepository.saveAndFlush(schedule);

        // Get the schedule
        restScheduleMockMvc
            .perform(get(ENTITY_API_URL_ID, schedule.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(schedule.getId().toString()))
            .andExpect(jsonPath("$.departureTime").value(DEFAULT_DEPARTURE_TIME.toString()))
            .andExpect(jsonPath("$.arrivalTime").value(DEFAULT_ARRIVAL_TIME.toString()))
            .andExpect(jsonPath("$.totalSeats").value(DEFAULT_TOTAL_SEATS))
            .andExpect(jsonPath("$.availableSeats").value(DEFAULT_AVAILABLE_SEATS))
            .andExpect(jsonPath("$.basePrice").value(sameNumber(DEFAULT_BASE_PRICE)))
            .andExpect(jsonPath("$.isActive").value(DEFAULT_IS_ACTIVE))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.updatedAt").value(DEFAULT_UPDATED_AT.toString()));
    }

    @Test
    @Transactional
    void getSchedulesByIdFiltering() throws Exception {
        // Initialize the database
        insertedSchedule = scheduleRepository.saveAndFlush(schedule);

        UUID id = schedule.getId();

        defaultScheduleFiltering("id.equals=" + id, "id.notEquals=" + id);
    }

    @Test
    @Transactional
    void getAllSchedulesByDepartureTimeIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedSchedule = scheduleRepository.saveAndFlush(schedule);

        // Get all the scheduleList where departureTime equals to
        defaultScheduleFiltering("departureTime.equals=" + DEFAULT_DEPARTURE_TIME, "departureTime.equals=" + UPDATED_DEPARTURE_TIME);
    }

    @Test
    @Transactional
    void getAllSchedulesByDepartureTimeIsInShouldWork() throws Exception {
        // Initialize the database
        insertedSchedule = scheduleRepository.saveAndFlush(schedule);

        // Get all the scheduleList where departureTime in
        defaultScheduleFiltering(
            "departureTime.in=" + DEFAULT_DEPARTURE_TIME + "," + UPDATED_DEPARTURE_TIME,
            "departureTime.in=" + UPDATED_DEPARTURE_TIME
        );
    }

    @Test
    @Transactional
    void getAllSchedulesByDepartureTimeIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedSchedule = scheduleRepository.saveAndFlush(schedule);

        // Get all the scheduleList where departureTime is not null
        defaultScheduleFiltering("departureTime.specified=true", "departureTime.specified=false");
    }

    @Test
    @Transactional
    void getAllSchedulesByArrivalTimeIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedSchedule = scheduleRepository.saveAndFlush(schedule);

        // Get all the scheduleList where arrivalTime equals to
        defaultScheduleFiltering("arrivalTime.equals=" + DEFAULT_ARRIVAL_TIME, "arrivalTime.equals=" + UPDATED_ARRIVAL_TIME);
    }

    @Test
    @Transactional
    void getAllSchedulesByArrivalTimeIsInShouldWork() throws Exception {
        // Initialize the database
        insertedSchedule = scheduleRepository.saveAndFlush(schedule);

        // Get all the scheduleList where arrivalTime in
        defaultScheduleFiltering(
            "arrivalTime.in=" + DEFAULT_ARRIVAL_TIME + "," + UPDATED_ARRIVAL_TIME,
            "arrivalTime.in=" + UPDATED_ARRIVAL_TIME
        );
    }

    @Test
    @Transactional
    void getAllSchedulesByArrivalTimeIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedSchedule = scheduleRepository.saveAndFlush(schedule);

        // Get all the scheduleList where arrivalTime is not null
        defaultScheduleFiltering("arrivalTime.specified=true", "arrivalTime.specified=false");
    }

    @Test
    @Transactional
    void getAllSchedulesByTotalSeatsIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedSchedule = scheduleRepository.saveAndFlush(schedule);

        // Get all the scheduleList where totalSeats equals to
        defaultScheduleFiltering("totalSeats.equals=" + DEFAULT_TOTAL_SEATS, "totalSeats.equals=" + UPDATED_TOTAL_SEATS);
    }

    @Test
    @Transactional
    void getAllSchedulesByTotalSeatsIsInShouldWork() throws Exception {
        // Initialize the database
        insertedSchedule = scheduleRepository.saveAndFlush(schedule);

        // Get all the scheduleList where totalSeats in
        defaultScheduleFiltering(
            "totalSeats.in=" + DEFAULT_TOTAL_SEATS + "," + UPDATED_TOTAL_SEATS,
            "totalSeats.in=" + UPDATED_TOTAL_SEATS
        );
    }

    @Test
    @Transactional
    void getAllSchedulesByTotalSeatsIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedSchedule = scheduleRepository.saveAndFlush(schedule);

        // Get all the scheduleList where totalSeats is not null
        defaultScheduleFiltering("totalSeats.specified=true", "totalSeats.specified=false");
    }

    @Test
    @Transactional
    void getAllSchedulesByTotalSeatsIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedSchedule = scheduleRepository.saveAndFlush(schedule);

        // Get all the scheduleList where totalSeats is greater than or equal to
        defaultScheduleFiltering(
            "totalSeats.greaterThanOrEqual=" + DEFAULT_TOTAL_SEATS,
            "totalSeats.greaterThanOrEqual=" + UPDATED_TOTAL_SEATS
        );
    }

    @Test
    @Transactional
    void getAllSchedulesByTotalSeatsIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedSchedule = scheduleRepository.saveAndFlush(schedule);

        // Get all the scheduleList where totalSeats is less than or equal to
        defaultScheduleFiltering("totalSeats.lessThanOrEqual=" + DEFAULT_TOTAL_SEATS, "totalSeats.lessThanOrEqual=" + SMALLER_TOTAL_SEATS);
    }

    @Test
    @Transactional
    void getAllSchedulesByTotalSeatsIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedSchedule = scheduleRepository.saveAndFlush(schedule);

        // Get all the scheduleList where totalSeats is less than
        defaultScheduleFiltering("totalSeats.lessThan=" + UPDATED_TOTAL_SEATS, "totalSeats.lessThan=" + DEFAULT_TOTAL_SEATS);
    }

    @Test
    @Transactional
    void getAllSchedulesByTotalSeatsIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedSchedule = scheduleRepository.saveAndFlush(schedule);

        // Get all the scheduleList where totalSeats is greater than
        defaultScheduleFiltering("totalSeats.greaterThan=" + SMALLER_TOTAL_SEATS, "totalSeats.greaterThan=" + DEFAULT_TOTAL_SEATS);
    }

    @Test
    @Transactional
    void getAllSchedulesByAvailableSeatsIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedSchedule = scheduleRepository.saveAndFlush(schedule);

        // Get all the scheduleList where availableSeats equals to
        defaultScheduleFiltering("availableSeats.equals=" + DEFAULT_AVAILABLE_SEATS, "availableSeats.equals=" + UPDATED_AVAILABLE_SEATS);
    }

    @Test
    @Transactional
    void getAllSchedulesByAvailableSeatsIsInShouldWork() throws Exception {
        // Initialize the database
        insertedSchedule = scheduleRepository.saveAndFlush(schedule);

        // Get all the scheduleList where availableSeats in
        defaultScheduleFiltering(
            "availableSeats.in=" + DEFAULT_AVAILABLE_SEATS + "," + UPDATED_AVAILABLE_SEATS,
            "availableSeats.in=" + UPDATED_AVAILABLE_SEATS
        );
    }

    @Test
    @Transactional
    void getAllSchedulesByAvailableSeatsIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedSchedule = scheduleRepository.saveAndFlush(schedule);

        // Get all the scheduleList where availableSeats is not null
        defaultScheduleFiltering("availableSeats.specified=true", "availableSeats.specified=false");
    }

    @Test
    @Transactional
    void getAllSchedulesByAvailableSeatsIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedSchedule = scheduleRepository.saveAndFlush(schedule);

        // Get all the scheduleList where availableSeats is greater than or equal to
        defaultScheduleFiltering(
            "availableSeats.greaterThanOrEqual=" + DEFAULT_AVAILABLE_SEATS,
            "availableSeats.greaterThanOrEqual=" + UPDATED_AVAILABLE_SEATS
        );
    }

    @Test
    @Transactional
    void getAllSchedulesByAvailableSeatsIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedSchedule = scheduleRepository.saveAndFlush(schedule);

        // Get all the scheduleList where availableSeats is less than or equal to
        defaultScheduleFiltering(
            "availableSeats.lessThanOrEqual=" + DEFAULT_AVAILABLE_SEATS,
            "availableSeats.lessThanOrEqual=" + SMALLER_AVAILABLE_SEATS
        );
    }

    @Test
    @Transactional
    void getAllSchedulesByAvailableSeatsIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedSchedule = scheduleRepository.saveAndFlush(schedule);

        // Get all the scheduleList where availableSeats is less than
        defaultScheduleFiltering(
            "availableSeats.lessThan=" + UPDATED_AVAILABLE_SEATS,
            "availableSeats.lessThan=" + DEFAULT_AVAILABLE_SEATS
        );
    }

    @Test
    @Transactional
    void getAllSchedulesByAvailableSeatsIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedSchedule = scheduleRepository.saveAndFlush(schedule);

        // Get all the scheduleList where availableSeats is greater than
        defaultScheduleFiltering(
            "availableSeats.greaterThan=" + SMALLER_AVAILABLE_SEATS,
            "availableSeats.greaterThan=" + DEFAULT_AVAILABLE_SEATS
        );
    }

    @Test
    @Transactional
    void getAllSchedulesByBasePriceIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedSchedule = scheduleRepository.saveAndFlush(schedule);

        // Get all the scheduleList where basePrice equals to
        defaultScheduleFiltering("basePrice.equals=" + DEFAULT_BASE_PRICE, "basePrice.equals=" + UPDATED_BASE_PRICE);
    }

    @Test
    @Transactional
    void getAllSchedulesByBasePriceIsInShouldWork() throws Exception {
        // Initialize the database
        insertedSchedule = scheduleRepository.saveAndFlush(schedule);

        // Get all the scheduleList where basePrice in
        defaultScheduleFiltering("basePrice.in=" + DEFAULT_BASE_PRICE + "," + UPDATED_BASE_PRICE, "basePrice.in=" + UPDATED_BASE_PRICE);
    }

    @Test
    @Transactional
    void getAllSchedulesByBasePriceIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedSchedule = scheduleRepository.saveAndFlush(schedule);

        // Get all the scheduleList where basePrice is not null
        defaultScheduleFiltering("basePrice.specified=true", "basePrice.specified=false");
    }

    @Test
    @Transactional
    void getAllSchedulesByBasePriceIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedSchedule = scheduleRepository.saveAndFlush(schedule);

        // Get all the scheduleList where basePrice is greater than or equal to
        defaultScheduleFiltering(
            "basePrice.greaterThanOrEqual=" + DEFAULT_BASE_PRICE,
            "basePrice.greaterThanOrEqual=" + UPDATED_BASE_PRICE
        );
    }

    @Test
    @Transactional
    void getAllSchedulesByBasePriceIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedSchedule = scheduleRepository.saveAndFlush(schedule);

        // Get all the scheduleList where basePrice is less than or equal to
        defaultScheduleFiltering("basePrice.lessThanOrEqual=" + DEFAULT_BASE_PRICE, "basePrice.lessThanOrEqual=" + SMALLER_BASE_PRICE);
    }

    @Test
    @Transactional
    void getAllSchedulesByBasePriceIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedSchedule = scheduleRepository.saveAndFlush(schedule);

        // Get all the scheduleList where basePrice is less than
        defaultScheduleFiltering("basePrice.lessThan=" + UPDATED_BASE_PRICE, "basePrice.lessThan=" + DEFAULT_BASE_PRICE);
    }

    @Test
    @Transactional
    void getAllSchedulesByBasePriceIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedSchedule = scheduleRepository.saveAndFlush(schedule);

        // Get all the scheduleList where basePrice is greater than
        defaultScheduleFiltering("basePrice.greaterThan=" + SMALLER_BASE_PRICE, "basePrice.greaterThan=" + DEFAULT_BASE_PRICE);
    }

    @Test
    @Transactional
    void getAllSchedulesByIsActiveIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedSchedule = scheduleRepository.saveAndFlush(schedule);

        // Get all the scheduleList where isActive equals to
        defaultScheduleFiltering("isActive.equals=" + DEFAULT_IS_ACTIVE, "isActive.equals=" + UPDATED_IS_ACTIVE);
    }

    @Test
    @Transactional
    void getAllSchedulesByIsActiveIsInShouldWork() throws Exception {
        // Initialize the database
        insertedSchedule = scheduleRepository.saveAndFlush(schedule);

        // Get all the scheduleList where isActive in
        defaultScheduleFiltering("isActive.in=" + DEFAULT_IS_ACTIVE + "," + UPDATED_IS_ACTIVE, "isActive.in=" + UPDATED_IS_ACTIVE);
    }

    @Test
    @Transactional
    void getAllSchedulesByIsActiveIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedSchedule = scheduleRepository.saveAndFlush(schedule);

        // Get all the scheduleList where isActive is not null
        defaultScheduleFiltering("isActive.specified=true", "isActive.specified=false");
    }

    @Test
    @Transactional
    void getAllSchedulesByCreatedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedSchedule = scheduleRepository.saveAndFlush(schedule);

        // Get all the scheduleList where createdAt equals to
        defaultScheduleFiltering("createdAt.equals=" + DEFAULT_CREATED_AT, "createdAt.equals=" + UPDATED_CREATED_AT);
    }

    @Test
    @Transactional
    void getAllSchedulesByCreatedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedSchedule = scheduleRepository.saveAndFlush(schedule);

        // Get all the scheduleList where createdAt in
        defaultScheduleFiltering("createdAt.in=" + DEFAULT_CREATED_AT + "," + UPDATED_CREATED_AT, "createdAt.in=" + UPDATED_CREATED_AT);
    }

    @Test
    @Transactional
    void getAllSchedulesByCreatedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedSchedule = scheduleRepository.saveAndFlush(schedule);

        // Get all the scheduleList where createdAt is not null
        defaultScheduleFiltering("createdAt.specified=true", "createdAt.specified=false");
    }

    @Test
    @Transactional
    void getAllSchedulesByUpdatedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedSchedule = scheduleRepository.saveAndFlush(schedule);

        // Get all the scheduleList where updatedAt equals to
        defaultScheduleFiltering("updatedAt.equals=" + DEFAULT_UPDATED_AT, "updatedAt.equals=" + UPDATED_UPDATED_AT);
    }

    @Test
    @Transactional
    void getAllSchedulesByUpdatedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedSchedule = scheduleRepository.saveAndFlush(schedule);

        // Get all the scheduleList where updatedAt in
        defaultScheduleFiltering("updatedAt.in=" + DEFAULT_UPDATED_AT + "," + UPDATED_UPDATED_AT, "updatedAt.in=" + UPDATED_UPDATED_AT);
    }

    @Test
    @Transactional
    void getAllSchedulesByUpdatedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedSchedule = scheduleRepository.saveAndFlush(schedule);

        // Get all the scheduleList where updatedAt is not null
        defaultScheduleFiltering("updatedAt.specified=true", "updatedAt.specified=false");
    }

    @Test
    @Transactional
    void getAllSchedulesByRouteIsEqualToSomething() throws Exception {
        Route route;
        if (TestUtil.findAll(em, Route.class).isEmpty()) {
            scheduleRepository.saveAndFlush(schedule);
            route = RouteResourceIT.createEntity();
        } else {
            route = TestUtil.findAll(em, Route.class).get(0);
        }
        em.persist(route);
        em.flush();
        schedule.setRoute(route);
        scheduleRepository.saveAndFlush(schedule);
        UUID routeId = route.getId();
        // Get all the scheduleList where route equals to routeId
        defaultScheduleShouldBeFound("routeId.equals=" + routeId);

        // Get all the scheduleList where route equals to UUID.randomUUID()
        defaultScheduleShouldNotBeFound("routeId.equals=" + UUID.randomUUID());
    }

    private void defaultScheduleFiltering(String shouldBeFound, String shouldNotBeFound) throws Exception {
        defaultScheduleShouldBeFound(shouldBeFound);
        defaultScheduleShouldNotBeFound(shouldNotBeFound);
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultScheduleShouldBeFound(String filter) throws Exception {
        restScheduleMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(schedule.getId().toString())))
            .andExpect(jsonPath("$.[*].departureTime").value(hasItem(DEFAULT_DEPARTURE_TIME.toString())))
            .andExpect(jsonPath("$.[*].arrivalTime").value(hasItem(DEFAULT_ARRIVAL_TIME.toString())))
            .andExpect(jsonPath("$.[*].totalSeats").value(hasItem(DEFAULT_TOTAL_SEATS)))
            .andExpect(jsonPath("$.[*].availableSeats").value(hasItem(DEFAULT_AVAILABLE_SEATS)))
            .andExpect(jsonPath("$.[*].basePrice").value(hasItem(sameNumber(DEFAULT_BASE_PRICE))))
            .andExpect(jsonPath("$.[*].isActive").value(hasItem(DEFAULT_IS_ACTIVE)))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())));

        // Check, that the count call also returns 1
        restScheduleMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("1"));
    }

    /**
     * Executes the search, and checks that the default entity is not returned.
     */
    private void defaultScheduleShouldNotBeFound(String filter) throws Exception {
        restScheduleMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());

        // Check, that the count call also returns 0
        restScheduleMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("0"));
    }

    @Test
    @Transactional
    void getNonExistingSchedule() throws Exception {
        // Get the schedule
        restScheduleMockMvc.perform(get(ENTITY_API_URL_ID, UUID.randomUUID().toString())).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingSchedule() throws Exception {
        // Initialize the database
        insertedSchedule = scheduleRepository.saveAndFlush(schedule);

        long databaseSizeBeforeUpdate = getRepositoryCount();
        scheduleSearchRepository.save(schedule);
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(scheduleSearchRepository.findAll());

        // Update the schedule
        Schedule updatedSchedule = scheduleRepository.findById(schedule.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedSchedule are not directly saved in db
        em.detach(updatedSchedule);
        updatedSchedule
            .departureTime(UPDATED_DEPARTURE_TIME)
            .arrivalTime(UPDATED_ARRIVAL_TIME)
            .totalSeats(UPDATED_TOTAL_SEATS)
            .availableSeats(UPDATED_AVAILABLE_SEATS)
            .basePrice(UPDATED_BASE_PRICE)
            .isActive(UPDATED_IS_ACTIVE)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT);
        ScheduleDTO scheduleDTO = scheduleMapper.toDto(updatedSchedule);

        restScheduleMockMvc
            .perform(
                put(ENTITY_API_URL_ID, scheduleDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(scheduleDTO))
            )
            .andExpect(status().isOk());

        // Validate the Schedule in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedScheduleToMatchAllProperties(updatedSchedule);

        await()
            .atMost(5, TimeUnit.SECONDS)
            .untilAsserted(() -> {
                int searchDatabaseSizeAfter = IterableUtil.sizeOf(scheduleSearchRepository.findAll());
                assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore);
                List<Schedule> scheduleSearchList = Streamable.of(scheduleSearchRepository.findAll()).toList();
                Schedule testScheduleSearch = scheduleSearchList.get(searchDatabaseSizeAfter - 1);

                assertScheduleAllPropertiesEquals(testScheduleSearch, updatedSchedule);
            });
    }

    @Test
    @Transactional
    void putNonExistingSchedule() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(scheduleSearchRepository.findAll());
        schedule.setId(UUID.randomUUID());

        // Create the Schedule
        ScheduleDTO scheduleDTO = scheduleMapper.toDto(schedule);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restScheduleMockMvc
            .perform(
                put(ENTITY_API_URL_ID, scheduleDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(scheduleDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Schedule in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        int searchDatabaseSizeAfter = IterableUtil.sizeOf(scheduleSearchRepository.findAll());
        assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore);
    }

    @Test
    @Transactional
    void putWithIdMismatchSchedule() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(scheduleSearchRepository.findAll());
        schedule.setId(UUID.randomUUID());

        // Create the Schedule
        ScheduleDTO scheduleDTO = scheduleMapper.toDto(schedule);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restScheduleMockMvc
            .perform(
                put(ENTITY_API_URL_ID, UUID.randomUUID())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(scheduleDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Schedule in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        int searchDatabaseSizeAfter = IterableUtil.sizeOf(scheduleSearchRepository.findAll());
        assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamSchedule() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(scheduleSearchRepository.findAll());
        schedule.setId(UUID.randomUUID());

        // Create the Schedule
        ScheduleDTO scheduleDTO = scheduleMapper.toDto(schedule);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restScheduleMockMvc
            .perform(put(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(scheduleDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Schedule in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        int searchDatabaseSizeAfter = IterableUtil.sizeOf(scheduleSearchRepository.findAll());
        assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore);
    }

    @Test
    @Transactional
    void partialUpdateScheduleWithPatch() throws Exception {
        // Initialize the database
        insertedSchedule = scheduleRepository.saveAndFlush(schedule);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the schedule using partial update
        Schedule partialUpdatedSchedule = new Schedule();
        partialUpdatedSchedule.setId(schedule.getId());

        partialUpdatedSchedule
            .totalSeats(UPDATED_TOTAL_SEATS)
            .basePrice(UPDATED_BASE_PRICE)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT);

        restScheduleMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedSchedule.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedSchedule))
            )
            .andExpect(status().isOk());

        // Validate the Schedule in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertScheduleUpdatableFieldsEquals(createUpdateProxyForBean(partialUpdatedSchedule, schedule), getPersistedSchedule(schedule));
    }

    @Test
    @Transactional
    void fullUpdateScheduleWithPatch() throws Exception {
        // Initialize the database
        insertedSchedule = scheduleRepository.saveAndFlush(schedule);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the schedule using partial update
        Schedule partialUpdatedSchedule = new Schedule();
        partialUpdatedSchedule.setId(schedule.getId());

        partialUpdatedSchedule
            .departureTime(UPDATED_DEPARTURE_TIME)
            .arrivalTime(UPDATED_ARRIVAL_TIME)
            .totalSeats(UPDATED_TOTAL_SEATS)
            .availableSeats(UPDATED_AVAILABLE_SEATS)
            .basePrice(UPDATED_BASE_PRICE)
            .isActive(UPDATED_IS_ACTIVE)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT);

        restScheduleMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedSchedule.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedSchedule))
            )
            .andExpect(status().isOk());

        // Validate the Schedule in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertScheduleUpdatableFieldsEquals(partialUpdatedSchedule, getPersistedSchedule(partialUpdatedSchedule));
    }

    @Test
    @Transactional
    void patchNonExistingSchedule() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(scheduleSearchRepository.findAll());
        schedule.setId(UUID.randomUUID());

        // Create the Schedule
        ScheduleDTO scheduleDTO = scheduleMapper.toDto(schedule);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restScheduleMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, scheduleDTO.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(scheduleDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Schedule in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        int searchDatabaseSizeAfter = IterableUtil.sizeOf(scheduleSearchRepository.findAll());
        assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore);
    }

    @Test
    @Transactional
    void patchWithIdMismatchSchedule() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(scheduleSearchRepository.findAll());
        schedule.setId(UUID.randomUUID());

        // Create the Schedule
        ScheduleDTO scheduleDTO = scheduleMapper.toDto(schedule);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restScheduleMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, UUID.randomUUID())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(scheduleDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Schedule in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        int searchDatabaseSizeAfter = IterableUtil.sizeOf(scheduleSearchRepository.findAll());
        assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamSchedule() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(scheduleSearchRepository.findAll());
        schedule.setId(UUID.randomUUID());

        // Create the Schedule
        ScheduleDTO scheduleDTO = scheduleMapper.toDto(schedule);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restScheduleMockMvc
            .perform(
                patch(ENTITY_API_URL).with(csrf()).contentType("application/merge-patch+json").content(om.writeValueAsBytes(scheduleDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the Schedule in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        int searchDatabaseSizeAfter = IterableUtil.sizeOf(scheduleSearchRepository.findAll());
        assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore);
    }

    @Test
    @Transactional
    void deleteSchedule() throws Exception {
        // Initialize the database
        insertedSchedule = scheduleRepository.saveAndFlush(schedule);
        scheduleRepository.save(schedule);
        scheduleSearchRepository.save(schedule);

        long databaseSizeBeforeDelete = getRepositoryCount();
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(scheduleSearchRepository.findAll());
        assertThat(searchDatabaseSizeBefore).isEqualTo(databaseSizeBeforeDelete);

        // Delete the schedule
        restScheduleMockMvc
            .perform(delete(ENTITY_API_URL_ID, schedule.getId().toString()).with(csrf()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
        int searchDatabaseSizeAfter = IterableUtil.sizeOf(scheduleSearchRepository.findAll());
        assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore - 1);
    }

    @Test
    @Transactional
    void searchSchedule() throws Exception {
        // Initialize the database
        insertedSchedule = scheduleRepository.saveAndFlush(schedule);
        scheduleSearchRepository.save(schedule);

        // Search the schedule
        restScheduleMockMvc
            .perform(get(ENTITY_SEARCH_API_URL + "?query=id:" + schedule.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(schedule.getId().toString())))
            .andExpect(jsonPath("$.[*].departureTime").value(hasItem(DEFAULT_DEPARTURE_TIME.toString())))
            .andExpect(jsonPath("$.[*].arrivalTime").value(hasItem(DEFAULT_ARRIVAL_TIME.toString())))
            .andExpect(jsonPath("$.[*].totalSeats").value(hasItem(DEFAULT_TOTAL_SEATS)))
            .andExpect(jsonPath("$.[*].availableSeats").value(hasItem(DEFAULT_AVAILABLE_SEATS)))
            .andExpect(jsonPath("$.[*].basePrice").value(hasItem(sameNumber(DEFAULT_BASE_PRICE))))
            .andExpect(jsonPath("$.[*].isActive").value(hasItem(DEFAULT_IS_ACTIVE)))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())));
    }

    protected long getRepositoryCount() {
        return scheduleRepository.count();
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

    protected Schedule getPersistedSchedule(Schedule schedule) {
        return scheduleRepository.findById(schedule.getId()).orElseThrow();
    }

    protected void assertPersistedScheduleToMatchAllProperties(Schedule expectedSchedule) {
        assertScheduleAllPropertiesEquals(expectedSchedule, getPersistedSchedule(expectedSchedule));
    }

    protected void assertPersistedScheduleToMatchUpdatableProperties(Schedule expectedSchedule) {
        assertScheduleAllUpdatablePropertiesEquals(expectedSchedule, getPersistedSchedule(expectedSchedule));
    }
}
