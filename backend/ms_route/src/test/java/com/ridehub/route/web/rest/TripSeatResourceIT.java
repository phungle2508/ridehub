package com.ridehub.route.web.rest;

import static com.ridehub.route.domain.TripSeatAsserts.*;
import static com.ridehub.route.web.rest.TestUtil.createUpdateProxyForBean;
import static com.ridehub.route.web.rest.TestUtil.sameNumber;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ridehub.route.IntegrationTest;
import com.ridehub.route.domain.Trip;
import com.ridehub.route.domain.TripSeat;
import com.ridehub.route.repository.TripSeatRepository;
import com.ridehub.route.service.dto.TripSeatDTO;
import com.ridehub.route.service.mapper.TripSeatMapper;
import jakarta.persistence.EntityManager;
import java.math.BigDecimal;
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
 * Integration tests for the {@link TripSeatResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class TripSeatResourceIT {

    private static final String DEFAULT_SEAT_NO = "AAAAAAAAAA";
    private static final String UPDATED_SEAT_NO = "BBBBBBBBBB";

    private static final Integer DEFAULT_FLOOR_NO = 1;
    private static final Integer UPDATED_FLOOR_NO = 2;
    private static final Integer SMALLER_FLOOR_NO = 1 - 1;

    private static final Boolean DEFAULT_BOOKED = false;
    private static final Boolean UPDATED_BOOKED = true;

    private static final BigDecimal DEFAULT_PRICE_FACTOR = new BigDecimal(1);
    private static final BigDecimal UPDATED_PRICE_FACTOR = new BigDecimal(2);
    private static final BigDecimal SMALLER_PRICE_FACTOR = new BigDecimal(1 - 1);

    private static final Instant DEFAULT_CREATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_UPDATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_UPDATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Boolean DEFAULT_IS_DELETED = false;
    private static final Boolean UPDATED_IS_DELETED = true;

    private static final Instant DEFAULT_DELETED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_DELETED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final UUID DEFAULT_DELETED_BY = UUID.randomUUID();
    private static final UUID UPDATED_DELETED_BY = UUID.randomUUID();

    private static final String ENTITY_API_URL = "/api/trip-seats";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private TripSeatRepository tripSeatRepository;

    @Autowired
    private TripSeatMapper tripSeatMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restTripSeatMockMvc;

    private TripSeat tripSeat;

    private TripSeat insertedTripSeat;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static TripSeat createEntity(EntityManager em) {
        TripSeat tripSeat = new TripSeat()
            .seatNo(DEFAULT_SEAT_NO)
            .floorNo(DEFAULT_FLOOR_NO)
            .booked(DEFAULT_BOOKED)
            .priceFactor(DEFAULT_PRICE_FACTOR)
            .createdAt(DEFAULT_CREATED_AT)
            .updatedAt(DEFAULT_UPDATED_AT)
            .isDeleted(DEFAULT_IS_DELETED)
            .deletedAt(DEFAULT_DELETED_AT)
            .deletedBy(DEFAULT_DELETED_BY);
        // Add required entity
        Trip trip;
        if (TestUtil.findAll(em, Trip.class).isEmpty()) {
            trip = TripResourceIT.createEntity(em);
            em.persist(trip);
            em.flush();
        } else {
            trip = TestUtil.findAll(em, Trip.class).get(0);
        }
        tripSeat.setTrip(trip);
        return tripSeat;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static TripSeat createUpdatedEntity(EntityManager em) {
        TripSeat updatedTripSeat = new TripSeat()
            .seatNo(UPDATED_SEAT_NO)
            .floorNo(UPDATED_FLOOR_NO)
            .booked(UPDATED_BOOKED)
            .priceFactor(UPDATED_PRICE_FACTOR)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);
        // Add required entity
        Trip trip;
        if (TestUtil.findAll(em, Trip.class).isEmpty()) {
            trip = TripResourceIT.createUpdatedEntity(em);
            em.persist(trip);
            em.flush();
        } else {
            trip = TestUtil.findAll(em, Trip.class).get(0);
        }
        updatedTripSeat.setTrip(trip);
        return updatedTripSeat;
    }

    @BeforeEach
    void initTest() {
        tripSeat = createEntity(em);
    }

    @AfterEach
    void cleanup() {
        if (insertedTripSeat != null) {
            tripSeatRepository.delete(insertedTripSeat);
            insertedTripSeat = null;
        }
    }

    @Test
    @Transactional
    void createTripSeat() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the TripSeat
        TripSeatDTO tripSeatDTO = tripSeatMapper.toDto(tripSeat);
        var returnedTripSeatDTO = om.readValue(
            restTripSeatMockMvc
                .perform(
                    post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(tripSeatDTO))
                )
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            TripSeatDTO.class
        );

        // Validate the TripSeat in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        var returnedTripSeat = tripSeatMapper.toEntity(returnedTripSeatDTO);
        assertTripSeatUpdatableFieldsEquals(returnedTripSeat, getPersistedTripSeat(returnedTripSeat));

        insertedTripSeat = returnedTripSeat;
    }

    @Test
    @Transactional
    void createTripSeatWithExistingId() throws Exception {
        // Create the TripSeat with an existing ID
        tripSeat.setId(1L);
        TripSeatDTO tripSeatDTO = tripSeatMapper.toDto(tripSeat);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restTripSeatMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(tripSeatDTO)))
            .andExpect(status().isBadRequest());

        // Validate the TripSeat in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkSeatNoIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        tripSeat.setSeatNo(null);

        // Create the TripSeat, which fails.
        TripSeatDTO tripSeatDTO = tripSeatMapper.toDto(tripSeat);

        restTripSeatMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(tripSeatDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkFloorNoIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        tripSeat.setFloorNo(null);

        // Create the TripSeat, which fails.
        TripSeatDTO tripSeatDTO = tripSeatMapper.toDto(tripSeat);

        restTripSeatMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(tripSeatDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkCreatedAtIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        tripSeat.setCreatedAt(null);

        // Create the TripSeat, which fails.
        TripSeatDTO tripSeatDTO = tripSeatMapper.toDto(tripSeat);

        restTripSeatMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(tripSeatDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllTripSeats() throws Exception {
        // Initialize the database
        insertedTripSeat = tripSeatRepository.saveAndFlush(tripSeat);

        // Get all the tripSeatList
        restTripSeatMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(tripSeat.getId().intValue())))
            .andExpect(jsonPath("$.[*].seatNo").value(hasItem(DEFAULT_SEAT_NO)))
            .andExpect(jsonPath("$.[*].floorNo").value(hasItem(DEFAULT_FLOOR_NO)))
            .andExpect(jsonPath("$.[*].booked").value(hasItem(DEFAULT_BOOKED)))
            .andExpect(jsonPath("$.[*].priceFactor").value(hasItem(sameNumber(DEFAULT_PRICE_FACTOR))))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].isDeleted").value(hasItem(DEFAULT_IS_DELETED)))
            .andExpect(jsonPath("$.[*].deletedAt").value(hasItem(DEFAULT_DELETED_AT.toString())))
            .andExpect(jsonPath("$.[*].deletedBy").value(hasItem(DEFAULT_DELETED_BY.toString())));
    }

    @Test
    @Transactional
    void getTripSeat() throws Exception {
        // Initialize the database
        insertedTripSeat = tripSeatRepository.saveAndFlush(tripSeat);

        // Get the tripSeat
        restTripSeatMockMvc
            .perform(get(ENTITY_API_URL_ID, tripSeat.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(tripSeat.getId().intValue()))
            .andExpect(jsonPath("$.seatNo").value(DEFAULT_SEAT_NO))
            .andExpect(jsonPath("$.floorNo").value(DEFAULT_FLOOR_NO))
            .andExpect(jsonPath("$.booked").value(DEFAULT_BOOKED))
            .andExpect(jsonPath("$.priceFactor").value(sameNumber(DEFAULT_PRICE_FACTOR)))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.updatedAt").value(DEFAULT_UPDATED_AT.toString()))
            .andExpect(jsonPath("$.isDeleted").value(DEFAULT_IS_DELETED))
            .andExpect(jsonPath("$.deletedAt").value(DEFAULT_DELETED_AT.toString()))
            .andExpect(jsonPath("$.deletedBy").value(DEFAULT_DELETED_BY.toString()));
    }

    @Test
    @Transactional
    void getTripSeatsByIdFiltering() throws Exception {
        // Initialize the database
        insertedTripSeat = tripSeatRepository.saveAndFlush(tripSeat);

        Long id = tripSeat.getId();

        defaultTripSeatFiltering("id.equals=" + id, "id.notEquals=" + id);

        defaultTripSeatFiltering("id.greaterThanOrEqual=" + id, "id.greaterThan=" + id);

        defaultTripSeatFiltering("id.lessThanOrEqual=" + id, "id.lessThan=" + id);
    }

    @Test
    @Transactional
    void getAllTripSeatsBySeatNoIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedTripSeat = tripSeatRepository.saveAndFlush(tripSeat);

        // Get all the tripSeatList where seatNo equals to
        defaultTripSeatFiltering("seatNo.equals=" + DEFAULT_SEAT_NO, "seatNo.equals=" + UPDATED_SEAT_NO);
    }

    @Test
    @Transactional
    void getAllTripSeatsBySeatNoIsInShouldWork() throws Exception {
        // Initialize the database
        insertedTripSeat = tripSeatRepository.saveAndFlush(tripSeat);

        // Get all the tripSeatList where seatNo in
        defaultTripSeatFiltering("seatNo.in=" + DEFAULT_SEAT_NO + "," + UPDATED_SEAT_NO, "seatNo.in=" + UPDATED_SEAT_NO);
    }

    @Test
    @Transactional
    void getAllTripSeatsBySeatNoIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedTripSeat = tripSeatRepository.saveAndFlush(tripSeat);

        // Get all the tripSeatList where seatNo is not null
        defaultTripSeatFiltering("seatNo.specified=true", "seatNo.specified=false");
    }

    @Test
    @Transactional
    void getAllTripSeatsBySeatNoContainsSomething() throws Exception {
        // Initialize the database
        insertedTripSeat = tripSeatRepository.saveAndFlush(tripSeat);

        // Get all the tripSeatList where seatNo contains
        defaultTripSeatFiltering("seatNo.contains=" + DEFAULT_SEAT_NO, "seatNo.contains=" + UPDATED_SEAT_NO);
    }

    @Test
    @Transactional
    void getAllTripSeatsBySeatNoNotContainsSomething() throws Exception {
        // Initialize the database
        insertedTripSeat = tripSeatRepository.saveAndFlush(tripSeat);

        // Get all the tripSeatList where seatNo does not contain
        defaultTripSeatFiltering("seatNo.doesNotContain=" + UPDATED_SEAT_NO, "seatNo.doesNotContain=" + DEFAULT_SEAT_NO);
    }

    @Test
    @Transactional
    void getAllTripSeatsByFloorNoIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedTripSeat = tripSeatRepository.saveAndFlush(tripSeat);

        // Get all the tripSeatList where floorNo equals to
        defaultTripSeatFiltering("floorNo.equals=" + DEFAULT_FLOOR_NO, "floorNo.equals=" + UPDATED_FLOOR_NO);
    }

    @Test
    @Transactional
    void getAllTripSeatsByFloorNoIsInShouldWork() throws Exception {
        // Initialize the database
        insertedTripSeat = tripSeatRepository.saveAndFlush(tripSeat);

        // Get all the tripSeatList where floorNo in
        defaultTripSeatFiltering("floorNo.in=" + DEFAULT_FLOOR_NO + "," + UPDATED_FLOOR_NO, "floorNo.in=" + UPDATED_FLOOR_NO);
    }

    @Test
    @Transactional
    void getAllTripSeatsByFloorNoIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedTripSeat = tripSeatRepository.saveAndFlush(tripSeat);

        // Get all the tripSeatList where floorNo is not null
        defaultTripSeatFiltering("floorNo.specified=true", "floorNo.specified=false");
    }

    @Test
    @Transactional
    void getAllTripSeatsByFloorNoIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedTripSeat = tripSeatRepository.saveAndFlush(tripSeat);

        // Get all the tripSeatList where floorNo is greater than or equal to
        defaultTripSeatFiltering("floorNo.greaterThanOrEqual=" + DEFAULT_FLOOR_NO, "floorNo.greaterThanOrEqual=" + UPDATED_FLOOR_NO);
    }

    @Test
    @Transactional
    void getAllTripSeatsByFloorNoIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedTripSeat = tripSeatRepository.saveAndFlush(tripSeat);

        // Get all the tripSeatList where floorNo is less than or equal to
        defaultTripSeatFiltering("floorNo.lessThanOrEqual=" + DEFAULT_FLOOR_NO, "floorNo.lessThanOrEqual=" + SMALLER_FLOOR_NO);
    }

    @Test
    @Transactional
    void getAllTripSeatsByFloorNoIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedTripSeat = tripSeatRepository.saveAndFlush(tripSeat);

        // Get all the tripSeatList where floorNo is less than
        defaultTripSeatFiltering("floorNo.lessThan=" + UPDATED_FLOOR_NO, "floorNo.lessThan=" + DEFAULT_FLOOR_NO);
    }

    @Test
    @Transactional
    void getAllTripSeatsByFloorNoIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedTripSeat = tripSeatRepository.saveAndFlush(tripSeat);

        // Get all the tripSeatList where floorNo is greater than
        defaultTripSeatFiltering("floorNo.greaterThan=" + SMALLER_FLOOR_NO, "floorNo.greaterThan=" + DEFAULT_FLOOR_NO);
    }

    @Test
    @Transactional
    void getAllTripSeatsByBookedIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedTripSeat = tripSeatRepository.saveAndFlush(tripSeat);

        // Get all the tripSeatList where booked equals to
        defaultTripSeatFiltering("booked.equals=" + DEFAULT_BOOKED, "booked.equals=" + UPDATED_BOOKED);
    }

    @Test
    @Transactional
    void getAllTripSeatsByBookedIsInShouldWork() throws Exception {
        // Initialize the database
        insertedTripSeat = tripSeatRepository.saveAndFlush(tripSeat);

        // Get all the tripSeatList where booked in
        defaultTripSeatFiltering("booked.in=" + DEFAULT_BOOKED + "," + UPDATED_BOOKED, "booked.in=" + UPDATED_BOOKED);
    }

    @Test
    @Transactional
    void getAllTripSeatsByBookedIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedTripSeat = tripSeatRepository.saveAndFlush(tripSeat);

        // Get all the tripSeatList where booked is not null
        defaultTripSeatFiltering("booked.specified=true", "booked.specified=false");
    }

    @Test
    @Transactional
    void getAllTripSeatsByPriceFactorIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedTripSeat = tripSeatRepository.saveAndFlush(tripSeat);

        // Get all the tripSeatList where priceFactor equals to
        defaultTripSeatFiltering("priceFactor.equals=" + DEFAULT_PRICE_FACTOR, "priceFactor.equals=" + UPDATED_PRICE_FACTOR);
    }

    @Test
    @Transactional
    void getAllTripSeatsByPriceFactorIsInShouldWork() throws Exception {
        // Initialize the database
        insertedTripSeat = tripSeatRepository.saveAndFlush(tripSeat);

        // Get all the tripSeatList where priceFactor in
        defaultTripSeatFiltering(
            "priceFactor.in=" + DEFAULT_PRICE_FACTOR + "," + UPDATED_PRICE_FACTOR,
            "priceFactor.in=" + UPDATED_PRICE_FACTOR
        );
    }

    @Test
    @Transactional
    void getAllTripSeatsByPriceFactorIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedTripSeat = tripSeatRepository.saveAndFlush(tripSeat);

        // Get all the tripSeatList where priceFactor is not null
        defaultTripSeatFiltering("priceFactor.specified=true", "priceFactor.specified=false");
    }

    @Test
    @Transactional
    void getAllTripSeatsByPriceFactorIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedTripSeat = tripSeatRepository.saveAndFlush(tripSeat);

        // Get all the tripSeatList where priceFactor is greater than or equal to
        defaultTripSeatFiltering(
            "priceFactor.greaterThanOrEqual=" + DEFAULT_PRICE_FACTOR,
            "priceFactor.greaterThanOrEqual=" + UPDATED_PRICE_FACTOR
        );
    }

    @Test
    @Transactional
    void getAllTripSeatsByPriceFactorIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedTripSeat = tripSeatRepository.saveAndFlush(tripSeat);

        // Get all the tripSeatList where priceFactor is less than or equal to
        defaultTripSeatFiltering(
            "priceFactor.lessThanOrEqual=" + DEFAULT_PRICE_FACTOR,
            "priceFactor.lessThanOrEqual=" + SMALLER_PRICE_FACTOR
        );
    }

    @Test
    @Transactional
    void getAllTripSeatsByPriceFactorIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedTripSeat = tripSeatRepository.saveAndFlush(tripSeat);

        // Get all the tripSeatList where priceFactor is less than
        defaultTripSeatFiltering("priceFactor.lessThan=" + UPDATED_PRICE_FACTOR, "priceFactor.lessThan=" + DEFAULT_PRICE_FACTOR);
    }

    @Test
    @Transactional
    void getAllTripSeatsByPriceFactorIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedTripSeat = tripSeatRepository.saveAndFlush(tripSeat);

        // Get all the tripSeatList where priceFactor is greater than
        defaultTripSeatFiltering("priceFactor.greaterThan=" + SMALLER_PRICE_FACTOR, "priceFactor.greaterThan=" + DEFAULT_PRICE_FACTOR);
    }

    @Test
    @Transactional
    void getAllTripSeatsByCreatedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedTripSeat = tripSeatRepository.saveAndFlush(tripSeat);

        // Get all the tripSeatList where createdAt equals to
        defaultTripSeatFiltering("createdAt.equals=" + DEFAULT_CREATED_AT, "createdAt.equals=" + UPDATED_CREATED_AT);
    }

    @Test
    @Transactional
    void getAllTripSeatsByCreatedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedTripSeat = tripSeatRepository.saveAndFlush(tripSeat);

        // Get all the tripSeatList where createdAt in
        defaultTripSeatFiltering("createdAt.in=" + DEFAULT_CREATED_AT + "," + UPDATED_CREATED_AT, "createdAt.in=" + UPDATED_CREATED_AT);
    }

    @Test
    @Transactional
    void getAllTripSeatsByCreatedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedTripSeat = tripSeatRepository.saveAndFlush(tripSeat);

        // Get all the tripSeatList where createdAt is not null
        defaultTripSeatFiltering("createdAt.specified=true", "createdAt.specified=false");
    }

    @Test
    @Transactional
    void getAllTripSeatsByUpdatedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedTripSeat = tripSeatRepository.saveAndFlush(tripSeat);

        // Get all the tripSeatList where updatedAt equals to
        defaultTripSeatFiltering("updatedAt.equals=" + DEFAULT_UPDATED_AT, "updatedAt.equals=" + UPDATED_UPDATED_AT);
    }

    @Test
    @Transactional
    void getAllTripSeatsByUpdatedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedTripSeat = tripSeatRepository.saveAndFlush(tripSeat);

        // Get all the tripSeatList where updatedAt in
        defaultTripSeatFiltering("updatedAt.in=" + DEFAULT_UPDATED_AT + "," + UPDATED_UPDATED_AT, "updatedAt.in=" + UPDATED_UPDATED_AT);
    }

    @Test
    @Transactional
    void getAllTripSeatsByUpdatedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedTripSeat = tripSeatRepository.saveAndFlush(tripSeat);

        // Get all the tripSeatList where updatedAt is not null
        defaultTripSeatFiltering("updatedAt.specified=true", "updatedAt.specified=false");
    }

    @Test
    @Transactional
    void getAllTripSeatsByIsDeletedIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedTripSeat = tripSeatRepository.saveAndFlush(tripSeat);

        // Get all the tripSeatList where isDeleted equals to
        defaultTripSeatFiltering("isDeleted.equals=" + DEFAULT_IS_DELETED, "isDeleted.equals=" + UPDATED_IS_DELETED);
    }

    @Test
    @Transactional
    void getAllTripSeatsByIsDeletedIsInShouldWork() throws Exception {
        // Initialize the database
        insertedTripSeat = tripSeatRepository.saveAndFlush(tripSeat);

        // Get all the tripSeatList where isDeleted in
        defaultTripSeatFiltering("isDeleted.in=" + DEFAULT_IS_DELETED + "," + UPDATED_IS_DELETED, "isDeleted.in=" + UPDATED_IS_DELETED);
    }

    @Test
    @Transactional
    void getAllTripSeatsByIsDeletedIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedTripSeat = tripSeatRepository.saveAndFlush(tripSeat);

        // Get all the tripSeatList where isDeleted is not null
        defaultTripSeatFiltering("isDeleted.specified=true", "isDeleted.specified=false");
    }

    @Test
    @Transactional
    void getAllTripSeatsByDeletedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedTripSeat = tripSeatRepository.saveAndFlush(tripSeat);

        // Get all the tripSeatList where deletedAt equals to
        defaultTripSeatFiltering("deletedAt.equals=" + DEFAULT_DELETED_AT, "deletedAt.equals=" + UPDATED_DELETED_AT);
    }

    @Test
    @Transactional
    void getAllTripSeatsByDeletedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedTripSeat = tripSeatRepository.saveAndFlush(tripSeat);

        // Get all the tripSeatList where deletedAt in
        defaultTripSeatFiltering("deletedAt.in=" + DEFAULT_DELETED_AT + "," + UPDATED_DELETED_AT, "deletedAt.in=" + UPDATED_DELETED_AT);
    }

    @Test
    @Transactional
    void getAllTripSeatsByDeletedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedTripSeat = tripSeatRepository.saveAndFlush(tripSeat);

        // Get all the tripSeatList where deletedAt is not null
        defaultTripSeatFiltering("deletedAt.specified=true", "deletedAt.specified=false");
    }

    @Test
    @Transactional
    void getAllTripSeatsByDeletedByIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedTripSeat = tripSeatRepository.saveAndFlush(tripSeat);

        // Get all the tripSeatList where deletedBy equals to
        defaultTripSeatFiltering("deletedBy.equals=" + DEFAULT_DELETED_BY, "deletedBy.equals=" + UPDATED_DELETED_BY);
    }

    @Test
    @Transactional
    void getAllTripSeatsByDeletedByIsInShouldWork() throws Exception {
        // Initialize the database
        insertedTripSeat = tripSeatRepository.saveAndFlush(tripSeat);

        // Get all the tripSeatList where deletedBy in
        defaultTripSeatFiltering("deletedBy.in=" + DEFAULT_DELETED_BY + "," + UPDATED_DELETED_BY, "deletedBy.in=" + UPDATED_DELETED_BY);
    }

    @Test
    @Transactional
    void getAllTripSeatsByDeletedByIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedTripSeat = tripSeatRepository.saveAndFlush(tripSeat);

        // Get all the tripSeatList where deletedBy is not null
        defaultTripSeatFiltering("deletedBy.specified=true", "deletedBy.specified=false");
    }

    @Test
    @Transactional
    void getAllTripSeatsByTripIsEqualToSomething() throws Exception {
        Trip trip;
        if (TestUtil.findAll(em, Trip.class).isEmpty()) {
            tripSeatRepository.saveAndFlush(tripSeat);
            trip = TripResourceIT.createEntity(em);
        } else {
            trip = TestUtil.findAll(em, Trip.class).get(0);
        }
        em.persist(trip);
        em.flush();
        tripSeat.setTrip(trip);
        tripSeatRepository.saveAndFlush(tripSeat);
        Long tripId = trip.getId();
        // Get all the tripSeatList where trip equals to tripId
        defaultTripSeatShouldBeFound("tripId.equals=" + tripId);

        // Get all the tripSeatList where trip equals to (tripId + 1)
        defaultTripSeatShouldNotBeFound("tripId.equals=" + (tripId + 1));
    }

    private void defaultTripSeatFiltering(String shouldBeFound, String shouldNotBeFound) throws Exception {
        defaultTripSeatShouldBeFound(shouldBeFound);
        defaultTripSeatShouldNotBeFound(shouldNotBeFound);
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultTripSeatShouldBeFound(String filter) throws Exception {
        restTripSeatMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(tripSeat.getId().intValue())))
            .andExpect(jsonPath("$.[*].seatNo").value(hasItem(DEFAULT_SEAT_NO)))
            .andExpect(jsonPath("$.[*].floorNo").value(hasItem(DEFAULT_FLOOR_NO)))
            .andExpect(jsonPath("$.[*].booked").value(hasItem(DEFAULT_BOOKED)))
            .andExpect(jsonPath("$.[*].priceFactor").value(hasItem(sameNumber(DEFAULT_PRICE_FACTOR))))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].isDeleted").value(hasItem(DEFAULT_IS_DELETED)))
            .andExpect(jsonPath("$.[*].deletedAt").value(hasItem(DEFAULT_DELETED_AT.toString())))
            .andExpect(jsonPath("$.[*].deletedBy").value(hasItem(DEFAULT_DELETED_BY.toString())));

        // Check, that the count call also returns 1
        restTripSeatMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("1"));
    }

    /**
     * Executes the search, and checks that the default entity is not returned.
     */
    private void defaultTripSeatShouldNotBeFound(String filter) throws Exception {
        restTripSeatMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());

        // Check, that the count call also returns 0
        restTripSeatMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("0"));
    }

    @Test
    @Transactional
    void getNonExistingTripSeat() throws Exception {
        // Get the tripSeat
        restTripSeatMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingTripSeat() throws Exception {
        // Initialize the database
        insertedTripSeat = tripSeatRepository.saveAndFlush(tripSeat);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the tripSeat
        TripSeat updatedTripSeat = tripSeatRepository.findById(tripSeat.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedTripSeat are not directly saved in db
        em.detach(updatedTripSeat);
        updatedTripSeat
            .seatNo(UPDATED_SEAT_NO)
            .floorNo(UPDATED_FLOOR_NO)
            .booked(UPDATED_BOOKED)
            .priceFactor(UPDATED_PRICE_FACTOR)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);
        TripSeatDTO tripSeatDTO = tripSeatMapper.toDto(updatedTripSeat);

        restTripSeatMockMvc
            .perform(
                put(ENTITY_API_URL_ID, tripSeatDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(tripSeatDTO))
            )
            .andExpect(status().isOk());

        // Validate the TripSeat in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedTripSeatToMatchAllProperties(updatedTripSeat);
    }

    @Test
    @Transactional
    void putNonExistingTripSeat() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        tripSeat.setId(longCount.incrementAndGet());

        // Create the TripSeat
        TripSeatDTO tripSeatDTO = tripSeatMapper.toDto(tripSeat);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restTripSeatMockMvc
            .perform(
                put(ENTITY_API_URL_ID, tripSeatDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(tripSeatDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TripSeat in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchTripSeat() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        tripSeat.setId(longCount.incrementAndGet());

        // Create the TripSeat
        TripSeatDTO tripSeatDTO = tripSeatMapper.toDto(tripSeat);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTripSeatMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(tripSeatDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TripSeat in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamTripSeat() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        tripSeat.setId(longCount.incrementAndGet());

        // Create the TripSeat
        TripSeatDTO tripSeatDTO = tripSeatMapper.toDto(tripSeat);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTripSeatMockMvc
            .perform(put(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(tripSeatDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the TripSeat in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateTripSeatWithPatch() throws Exception {
        // Initialize the database
        insertedTripSeat = tripSeatRepository.saveAndFlush(tripSeat);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the tripSeat using partial update
        TripSeat partialUpdatedTripSeat = new TripSeat();
        partialUpdatedTripSeat.setId(tripSeat.getId());

        partialUpdatedTripSeat
            .seatNo(UPDATED_SEAT_NO)
            .floorNo(UPDATED_FLOOR_NO)
            .booked(UPDATED_BOOKED)
            .priceFactor(UPDATED_PRICE_FACTOR)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);

        restTripSeatMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedTripSeat.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedTripSeat))
            )
            .andExpect(status().isOk());

        // Validate the TripSeat in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertTripSeatUpdatableFieldsEquals(createUpdateProxyForBean(partialUpdatedTripSeat, tripSeat), getPersistedTripSeat(tripSeat));
    }

    @Test
    @Transactional
    void fullUpdateTripSeatWithPatch() throws Exception {
        // Initialize the database
        insertedTripSeat = tripSeatRepository.saveAndFlush(tripSeat);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the tripSeat using partial update
        TripSeat partialUpdatedTripSeat = new TripSeat();
        partialUpdatedTripSeat.setId(tripSeat.getId());

        partialUpdatedTripSeat
            .seatNo(UPDATED_SEAT_NO)
            .floorNo(UPDATED_FLOOR_NO)
            .booked(UPDATED_BOOKED)
            .priceFactor(UPDATED_PRICE_FACTOR)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);

        restTripSeatMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedTripSeat.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedTripSeat))
            )
            .andExpect(status().isOk());

        // Validate the TripSeat in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertTripSeatUpdatableFieldsEquals(partialUpdatedTripSeat, getPersistedTripSeat(partialUpdatedTripSeat));
    }

    @Test
    @Transactional
    void patchNonExistingTripSeat() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        tripSeat.setId(longCount.incrementAndGet());

        // Create the TripSeat
        TripSeatDTO tripSeatDTO = tripSeatMapper.toDto(tripSeat);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restTripSeatMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, tripSeatDTO.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(tripSeatDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TripSeat in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchTripSeat() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        tripSeat.setId(longCount.incrementAndGet());

        // Create the TripSeat
        TripSeatDTO tripSeatDTO = tripSeatMapper.toDto(tripSeat);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTripSeatMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(tripSeatDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TripSeat in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamTripSeat() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        tripSeat.setId(longCount.incrementAndGet());

        // Create the TripSeat
        TripSeatDTO tripSeatDTO = tripSeatMapper.toDto(tripSeat);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTripSeatMockMvc
            .perform(
                patch(ENTITY_API_URL).with(csrf()).contentType("application/merge-patch+json").content(om.writeValueAsBytes(tripSeatDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the TripSeat in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteTripSeat() throws Exception {
        // Initialize the database
        insertedTripSeat = tripSeatRepository.saveAndFlush(tripSeat);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the tripSeat
        restTripSeatMockMvc
            .perform(delete(ENTITY_API_URL_ID, tripSeat.getId()).with(csrf()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return tripSeatRepository.count();
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

    protected TripSeat getPersistedTripSeat(TripSeat tripSeat) {
        return tripSeatRepository.findById(tripSeat.getId()).orElseThrow();
    }

    protected void assertPersistedTripSeatToMatchAllProperties(TripSeat expectedTripSeat) {
        assertTripSeatAllPropertiesEquals(expectedTripSeat, getPersistedTripSeat(expectedTripSeat));
    }

    protected void assertPersistedTripSeatToMatchUpdatableProperties(TripSeat expectedTripSeat) {
        assertTripSeatAllUpdatablePropertiesEquals(expectedTripSeat, getPersistedTripSeat(expectedTripSeat));
    }
}
