package com.ridehub.route.web.rest;

import static com.ridehub.route.domain.SeatAsserts.*;
import static com.ridehub.route.web.rest.TestUtil.createUpdateProxyForBean;
import static com.ridehub.route.web.rest.TestUtil.sameNumber;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ridehub.route.IntegrationTest;
import com.ridehub.route.domain.Floor;
import com.ridehub.route.domain.Seat;
import com.ridehub.route.repository.SeatRepository;
import com.ridehub.route.service.dto.SeatDTO;
import com.ridehub.route.service.mapper.SeatMapper;
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
 * Integration tests for the {@link SeatResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class SeatResourceIT {

    private static final String DEFAULT_SEAT_NO = "AAAAAAAAAA";
    private static final String UPDATED_SEAT_NO = "BBBBBBBBBB";

    private static final Integer DEFAULT_ROW = 1;
    private static final Integer UPDATED_ROW = 2;
    private static final Integer SMALLER_ROW = 1 - 1;

    private static final Integer DEFAULT_COL = 1;
    private static final Integer UPDATED_COL = 2;
    private static final Integer SMALLER_COL = 1 - 1;

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

    private static final String ENTITY_API_URL = "/api/seats";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private SeatMapper seatMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restSeatMockMvc;

    private Seat seat;

    private Seat insertedSeat;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Seat createEntity(EntityManager em) {
        Seat seat = new Seat()
            .seatNo(DEFAULT_SEAT_NO)
            .row(DEFAULT_ROW)
            .col(DEFAULT_COL)
            .priceFactor(DEFAULT_PRICE_FACTOR)
            .createdAt(DEFAULT_CREATED_AT)
            .updatedAt(DEFAULT_UPDATED_AT)
            .isDeleted(DEFAULT_IS_DELETED)
            .deletedAt(DEFAULT_DELETED_AT)
            .deletedBy(DEFAULT_DELETED_BY);
        // Add required entity
        Floor floor;
        if (TestUtil.findAll(em, Floor.class).isEmpty()) {
            floor = FloorResourceIT.createEntity(em);
            em.persist(floor);
            em.flush();
        } else {
            floor = TestUtil.findAll(em, Floor.class).get(0);
        }
        seat.setFloor(floor);
        return seat;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Seat createUpdatedEntity(EntityManager em) {
        Seat updatedSeat = new Seat()
            .seatNo(UPDATED_SEAT_NO)
            .row(UPDATED_ROW)
            .col(UPDATED_COL)
            .priceFactor(UPDATED_PRICE_FACTOR)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);
        // Add required entity
        Floor floor;
        if (TestUtil.findAll(em, Floor.class).isEmpty()) {
            floor = FloorResourceIT.createUpdatedEntity(em);
            em.persist(floor);
            em.flush();
        } else {
            floor = TestUtil.findAll(em, Floor.class).get(0);
        }
        updatedSeat.setFloor(floor);
        return updatedSeat;
    }

    @BeforeEach
    void initTest() {
        seat = createEntity(em);
    }

    @AfterEach
    void cleanup() {
        if (insertedSeat != null) {
            seatRepository.delete(insertedSeat);
            insertedSeat = null;
        }
    }

    @Test
    @Transactional
    void createSeat() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the Seat
        SeatDTO seatDTO = seatMapper.toDto(seat);
        var returnedSeatDTO = om.readValue(
            restSeatMockMvc
                .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(seatDTO)))
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            SeatDTO.class
        );

        // Validate the Seat in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        var returnedSeat = seatMapper.toEntity(returnedSeatDTO);
        assertSeatUpdatableFieldsEquals(returnedSeat, getPersistedSeat(returnedSeat));

        insertedSeat = returnedSeat;
    }

    @Test
    @Transactional
    void createSeatWithExistingId() throws Exception {
        // Create the Seat with an existing ID
        seat.setId(1L);
        SeatDTO seatDTO = seatMapper.toDto(seat);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restSeatMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(seatDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Seat in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkSeatNoIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        seat.setSeatNo(null);

        // Create the Seat, which fails.
        SeatDTO seatDTO = seatMapper.toDto(seat);

        restSeatMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(seatDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkCreatedAtIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        seat.setCreatedAt(null);

        // Create the Seat, which fails.
        SeatDTO seatDTO = seatMapper.toDto(seat);

        restSeatMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(seatDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllSeats() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList
        restSeatMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(seat.getId().intValue())))
            .andExpect(jsonPath("$.[*].seatNo").value(hasItem(DEFAULT_SEAT_NO)))
            .andExpect(jsonPath("$.[*].row").value(hasItem(DEFAULT_ROW)))
            .andExpect(jsonPath("$.[*].col").value(hasItem(DEFAULT_COL)))
            .andExpect(jsonPath("$.[*].priceFactor").value(hasItem(sameNumber(DEFAULT_PRICE_FACTOR))))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].isDeleted").value(hasItem(DEFAULT_IS_DELETED)))
            .andExpect(jsonPath("$.[*].deletedAt").value(hasItem(DEFAULT_DELETED_AT.toString())))
            .andExpect(jsonPath("$.[*].deletedBy").value(hasItem(DEFAULT_DELETED_BY.toString())));
    }

    @Test
    @Transactional
    void getSeat() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get the seat
        restSeatMockMvc
            .perform(get(ENTITY_API_URL_ID, seat.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(seat.getId().intValue()))
            .andExpect(jsonPath("$.seatNo").value(DEFAULT_SEAT_NO))
            .andExpect(jsonPath("$.row").value(DEFAULT_ROW))
            .andExpect(jsonPath("$.col").value(DEFAULT_COL))
            .andExpect(jsonPath("$.priceFactor").value(sameNumber(DEFAULT_PRICE_FACTOR)))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.updatedAt").value(DEFAULT_UPDATED_AT.toString()))
            .andExpect(jsonPath("$.isDeleted").value(DEFAULT_IS_DELETED))
            .andExpect(jsonPath("$.deletedAt").value(DEFAULT_DELETED_AT.toString()))
            .andExpect(jsonPath("$.deletedBy").value(DEFAULT_DELETED_BY.toString()));
    }

    @Test
    @Transactional
    void getSeatsByIdFiltering() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        Long id = seat.getId();

        defaultSeatFiltering("id.equals=" + id, "id.notEquals=" + id);

        defaultSeatFiltering("id.greaterThanOrEqual=" + id, "id.greaterThan=" + id);

        defaultSeatFiltering("id.lessThanOrEqual=" + id, "id.lessThan=" + id);
    }

    @Test
    @Transactional
    void getAllSeatsBySeatNoIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where seatNo equals to
        defaultSeatFiltering("seatNo.equals=" + DEFAULT_SEAT_NO, "seatNo.equals=" + UPDATED_SEAT_NO);
    }

    @Test
    @Transactional
    void getAllSeatsBySeatNoIsInShouldWork() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where seatNo in
        defaultSeatFiltering("seatNo.in=" + DEFAULT_SEAT_NO + "," + UPDATED_SEAT_NO, "seatNo.in=" + UPDATED_SEAT_NO);
    }

    @Test
    @Transactional
    void getAllSeatsBySeatNoIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where seatNo is not null
        defaultSeatFiltering("seatNo.specified=true", "seatNo.specified=false");
    }

    @Test
    @Transactional
    void getAllSeatsBySeatNoContainsSomething() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where seatNo contains
        defaultSeatFiltering("seatNo.contains=" + DEFAULT_SEAT_NO, "seatNo.contains=" + UPDATED_SEAT_NO);
    }

    @Test
    @Transactional
    void getAllSeatsBySeatNoNotContainsSomething() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where seatNo does not contain
        defaultSeatFiltering("seatNo.doesNotContain=" + UPDATED_SEAT_NO, "seatNo.doesNotContain=" + DEFAULT_SEAT_NO);
    }

    @Test
    @Transactional
    void getAllSeatsByRowIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where row equals to
        defaultSeatFiltering("row.equals=" + DEFAULT_ROW, "row.equals=" + UPDATED_ROW);
    }

    @Test
    @Transactional
    void getAllSeatsByRowIsInShouldWork() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where row in
        defaultSeatFiltering("row.in=" + DEFAULT_ROW + "," + UPDATED_ROW, "row.in=" + UPDATED_ROW);
    }

    @Test
    @Transactional
    void getAllSeatsByRowIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where row is not null
        defaultSeatFiltering("row.specified=true", "row.specified=false");
    }

    @Test
    @Transactional
    void getAllSeatsByRowIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where row is greater than or equal to
        defaultSeatFiltering("row.greaterThanOrEqual=" + DEFAULT_ROW, "row.greaterThanOrEqual=" + UPDATED_ROW);
    }

    @Test
    @Transactional
    void getAllSeatsByRowIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where row is less than or equal to
        defaultSeatFiltering("row.lessThanOrEqual=" + DEFAULT_ROW, "row.lessThanOrEqual=" + SMALLER_ROW);
    }

    @Test
    @Transactional
    void getAllSeatsByRowIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where row is less than
        defaultSeatFiltering("row.lessThan=" + UPDATED_ROW, "row.lessThan=" + DEFAULT_ROW);
    }

    @Test
    @Transactional
    void getAllSeatsByRowIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where row is greater than
        defaultSeatFiltering("row.greaterThan=" + SMALLER_ROW, "row.greaterThan=" + DEFAULT_ROW);
    }

    @Test
    @Transactional
    void getAllSeatsByColIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where col equals to
        defaultSeatFiltering("col.equals=" + DEFAULT_COL, "col.equals=" + UPDATED_COL);
    }

    @Test
    @Transactional
    void getAllSeatsByColIsInShouldWork() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where col in
        defaultSeatFiltering("col.in=" + DEFAULT_COL + "," + UPDATED_COL, "col.in=" + UPDATED_COL);
    }

    @Test
    @Transactional
    void getAllSeatsByColIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where col is not null
        defaultSeatFiltering("col.specified=true", "col.specified=false");
    }

    @Test
    @Transactional
    void getAllSeatsByColIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where col is greater than or equal to
        defaultSeatFiltering("col.greaterThanOrEqual=" + DEFAULT_COL, "col.greaterThanOrEqual=" + UPDATED_COL);
    }

    @Test
    @Transactional
    void getAllSeatsByColIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where col is less than or equal to
        defaultSeatFiltering("col.lessThanOrEqual=" + DEFAULT_COL, "col.lessThanOrEqual=" + SMALLER_COL);
    }

    @Test
    @Transactional
    void getAllSeatsByColIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where col is less than
        defaultSeatFiltering("col.lessThan=" + UPDATED_COL, "col.lessThan=" + DEFAULT_COL);
    }

    @Test
    @Transactional
    void getAllSeatsByColIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where col is greater than
        defaultSeatFiltering("col.greaterThan=" + SMALLER_COL, "col.greaterThan=" + DEFAULT_COL);
    }

    @Test
    @Transactional
    void getAllSeatsByPriceFactorIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where priceFactor equals to
        defaultSeatFiltering("priceFactor.equals=" + DEFAULT_PRICE_FACTOR, "priceFactor.equals=" + UPDATED_PRICE_FACTOR);
    }

    @Test
    @Transactional
    void getAllSeatsByPriceFactorIsInShouldWork() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where priceFactor in
        defaultSeatFiltering(
            "priceFactor.in=" + DEFAULT_PRICE_FACTOR + "," + UPDATED_PRICE_FACTOR,
            "priceFactor.in=" + UPDATED_PRICE_FACTOR
        );
    }

    @Test
    @Transactional
    void getAllSeatsByPriceFactorIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where priceFactor is not null
        defaultSeatFiltering("priceFactor.specified=true", "priceFactor.specified=false");
    }

    @Test
    @Transactional
    void getAllSeatsByPriceFactorIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where priceFactor is greater than or equal to
        defaultSeatFiltering(
            "priceFactor.greaterThanOrEqual=" + DEFAULT_PRICE_FACTOR,
            "priceFactor.greaterThanOrEqual=" + UPDATED_PRICE_FACTOR
        );
    }

    @Test
    @Transactional
    void getAllSeatsByPriceFactorIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where priceFactor is less than or equal to
        defaultSeatFiltering("priceFactor.lessThanOrEqual=" + DEFAULT_PRICE_FACTOR, "priceFactor.lessThanOrEqual=" + SMALLER_PRICE_FACTOR);
    }

    @Test
    @Transactional
    void getAllSeatsByPriceFactorIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where priceFactor is less than
        defaultSeatFiltering("priceFactor.lessThan=" + UPDATED_PRICE_FACTOR, "priceFactor.lessThan=" + DEFAULT_PRICE_FACTOR);
    }

    @Test
    @Transactional
    void getAllSeatsByPriceFactorIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where priceFactor is greater than
        defaultSeatFiltering("priceFactor.greaterThan=" + SMALLER_PRICE_FACTOR, "priceFactor.greaterThan=" + DEFAULT_PRICE_FACTOR);
    }

    @Test
    @Transactional
    void getAllSeatsByCreatedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where createdAt equals to
        defaultSeatFiltering("createdAt.equals=" + DEFAULT_CREATED_AT, "createdAt.equals=" + UPDATED_CREATED_AT);
    }

    @Test
    @Transactional
    void getAllSeatsByCreatedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where createdAt in
        defaultSeatFiltering("createdAt.in=" + DEFAULT_CREATED_AT + "," + UPDATED_CREATED_AT, "createdAt.in=" + UPDATED_CREATED_AT);
    }

    @Test
    @Transactional
    void getAllSeatsByCreatedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where createdAt is not null
        defaultSeatFiltering("createdAt.specified=true", "createdAt.specified=false");
    }

    @Test
    @Transactional
    void getAllSeatsByUpdatedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where updatedAt equals to
        defaultSeatFiltering("updatedAt.equals=" + DEFAULT_UPDATED_AT, "updatedAt.equals=" + UPDATED_UPDATED_AT);
    }

    @Test
    @Transactional
    void getAllSeatsByUpdatedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where updatedAt in
        defaultSeatFiltering("updatedAt.in=" + DEFAULT_UPDATED_AT + "," + UPDATED_UPDATED_AT, "updatedAt.in=" + UPDATED_UPDATED_AT);
    }

    @Test
    @Transactional
    void getAllSeatsByUpdatedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where updatedAt is not null
        defaultSeatFiltering("updatedAt.specified=true", "updatedAt.specified=false");
    }

    @Test
    @Transactional
    void getAllSeatsByIsDeletedIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where isDeleted equals to
        defaultSeatFiltering("isDeleted.equals=" + DEFAULT_IS_DELETED, "isDeleted.equals=" + UPDATED_IS_DELETED);
    }

    @Test
    @Transactional
    void getAllSeatsByIsDeletedIsInShouldWork() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where isDeleted in
        defaultSeatFiltering("isDeleted.in=" + DEFAULT_IS_DELETED + "," + UPDATED_IS_DELETED, "isDeleted.in=" + UPDATED_IS_DELETED);
    }

    @Test
    @Transactional
    void getAllSeatsByIsDeletedIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where isDeleted is not null
        defaultSeatFiltering("isDeleted.specified=true", "isDeleted.specified=false");
    }

    @Test
    @Transactional
    void getAllSeatsByDeletedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where deletedAt equals to
        defaultSeatFiltering("deletedAt.equals=" + DEFAULT_DELETED_AT, "deletedAt.equals=" + UPDATED_DELETED_AT);
    }

    @Test
    @Transactional
    void getAllSeatsByDeletedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where deletedAt in
        defaultSeatFiltering("deletedAt.in=" + DEFAULT_DELETED_AT + "," + UPDATED_DELETED_AT, "deletedAt.in=" + UPDATED_DELETED_AT);
    }

    @Test
    @Transactional
    void getAllSeatsByDeletedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where deletedAt is not null
        defaultSeatFiltering("deletedAt.specified=true", "deletedAt.specified=false");
    }

    @Test
    @Transactional
    void getAllSeatsByDeletedByIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where deletedBy equals to
        defaultSeatFiltering("deletedBy.equals=" + DEFAULT_DELETED_BY, "deletedBy.equals=" + UPDATED_DELETED_BY);
    }

    @Test
    @Transactional
    void getAllSeatsByDeletedByIsInShouldWork() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where deletedBy in
        defaultSeatFiltering("deletedBy.in=" + DEFAULT_DELETED_BY + "," + UPDATED_DELETED_BY, "deletedBy.in=" + UPDATED_DELETED_BY);
    }

    @Test
    @Transactional
    void getAllSeatsByDeletedByIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where deletedBy is not null
        defaultSeatFiltering("deletedBy.specified=true", "deletedBy.specified=false");
    }

    @Test
    @Transactional
    void getAllSeatsByFloorIsEqualToSomething() throws Exception {
        Floor floor;
        if (TestUtil.findAll(em, Floor.class).isEmpty()) {
            seatRepository.saveAndFlush(seat);
            floor = FloorResourceIT.createEntity(em);
        } else {
            floor = TestUtil.findAll(em, Floor.class).get(0);
        }
        em.persist(floor);
        em.flush();
        seat.setFloor(floor);
        seatRepository.saveAndFlush(seat);
        Long floorId = floor.getId();
        // Get all the seatList where floor equals to floorId
        defaultSeatShouldBeFound("floorId.equals=" + floorId);

        // Get all the seatList where floor equals to (floorId + 1)
        defaultSeatShouldNotBeFound("floorId.equals=" + (floorId + 1));
    }

    private void defaultSeatFiltering(String shouldBeFound, String shouldNotBeFound) throws Exception {
        defaultSeatShouldBeFound(shouldBeFound);
        defaultSeatShouldNotBeFound(shouldNotBeFound);
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultSeatShouldBeFound(String filter) throws Exception {
        restSeatMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(seat.getId().intValue())))
            .andExpect(jsonPath("$.[*].seatNo").value(hasItem(DEFAULT_SEAT_NO)))
            .andExpect(jsonPath("$.[*].row").value(hasItem(DEFAULT_ROW)))
            .andExpect(jsonPath("$.[*].col").value(hasItem(DEFAULT_COL)))
            .andExpect(jsonPath("$.[*].priceFactor").value(hasItem(sameNumber(DEFAULT_PRICE_FACTOR))))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].isDeleted").value(hasItem(DEFAULT_IS_DELETED)))
            .andExpect(jsonPath("$.[*].deletedAt").value(hasItem(DEFAULT_DELETED_AT.toString())))
            .andExpect(jsonPath("$.[*].deletedBy").value(hasItem(DEFAULT_DELETED_BY.toString())));

        // Check, that the count call also returns 1
        restSeatMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("1"));
    }

    /**
     * Executes the search, and checks that the default entity is not returned.
     */
    private void defaultSeatShouldNotBeFound(String filter) throws Exception {
        restSeatMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());

        // Check, that the count call also returns 0
        restSeatMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("0"));
    }

    @Test
    @Transactional
    void getNonExistingSeat() throws Exception {
        // Get the seat
        restSeatMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingSeat() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the seat
        Seat updatedSeat = seatRepository.findById(seat.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedSeat are not directly saved in db
        em.detach(updatedSeat);
        updatedSeat
            .seatNo(UPDATED_SEAT_NO)
            .row(UPDATED_ROW)
            .col(UPDATED_COL)
            .priceFactor(UPDATED_PRICE_FACTOR)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);
        SeatDTO seatDTO = seatMapper.toDto(updatedSeat);

        restSeatMockMvc
            .perform(
                put(ENTITY_API_URL_ID, seatDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(seatDTO))
            )
            .andExpect(status().isOk());

        // Validate the Seat in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedSeatToMatchAllProperties(updatedSeat);
    }

    @Test
    @Transactional
    void putNonExistingSeat() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        seat.setId(longCount.incrementAndGet());

        // Create the Seat
        SeatDTO seatDTO = seatMapper.toDto(seat);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSeatMockMvc
            .perform(
                put(ENTITY_API_URL_ID, seatDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(seatDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Seat in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchSeat() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        seat.setId(longCount.incrementAndGet());

        // Create the Seat
        SeatDTO seatDTO = seatMapper.toDto(seat);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restSeatMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(seatDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Seat in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamSeat() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        seat.setId(longCount.incrementAndGet());

        // Create the Seat
        SeatDTO seatDTO = seatMapper.toDto(seat);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restSeatMockMvc
            .perform(put(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(seatDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Seat in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateSeatWithPatch() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the seat using partial update
        Seat partialUpdatedSeat = new Seat();
        partialUpdatedSeat.setId(seat.getId());

        partialUpdatedSeat.createdAt(UPDATED_CREATED_AT).deletedAt(UPDATED_DELETED_AT);

        restSeatMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedSeat.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedSeat))
            )
            .andExpect(status().isOk());

        // Validate the Seat in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertSeatUpdatableFieldsEquals(createUpdateProxyForBean(partialUpdatedSeat, seat), getPersistedSeat(seat));
    }

    @Test
    @Transactional
    void fullUpdateSeatWithPatch() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the seat using partial update
        Seat partialUpdatedSeat = new Seat();
        partialUpdatedSeat.setId(seat.getId());

        partialUpdatedSeat
            .seatNo(UPDATED_SEAT_NO)
            .row(UPDATED_ROW)
            .col(UPDATED_COL)
            .priceFactor(UPDATED_PRICE_FACTOR)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);

        restSeatMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedSeat.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedSeat))
            )
            .andExpect(status().isOk());

        // Validate the Seat in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertSeatUpdatableFieldsEquals(partialUpdatedSeat, getPersistedSeat(partialUpdatedSeat));
    }

    @Test
    @Transactional
    void patchNonExistingSeat() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        seat.setId(longCount.incrementAndGet());

        // Create the Seat
        SeatDTO seatDTO = seatMapper.toDto(seat);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSeatMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, seatDTO.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(seatDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Seat in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchSeat() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        seat.setId(longCount.incrementAndGet());

        // Create the Seat
        SeatDTO seatDTO = seatMapper.toDto(seat);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restSeatMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(seatDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Seat in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamSeat() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        seat.setId(longCount.incrementAndGet());

        // Create the Seat
        SeatDTO seatDTO = seatMapper.toDto(seat);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restSeatMockMvc
            .perform(patch(ENTITY_API_URL).with(csrf()).contentType("application/merge-patch+json").content(om.writeValueAsBytes(seatDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Seat in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteSeat() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the seat
        restSeatMockMvc
            .perform(delete(ENTITY_API_URL_ID, seat.getId()).with(csrf()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return seatRepository.count();
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

    protected Seat getPersistedSeat(Seat seat) {
        return seatRepository.findById(seat.getId()).orElseThrow();
    }

    protected void assertPersistedSeatToMatchAllProperties(Seat expectedSeat) {
        assertSeatAllPropertiesEquals(expectedSeat, getPersistedSeat(expectedSeat));
    }

    protected void assertPersistedSeatToMatchUpdatableProperties(Seat expectedSeat) {
        assertSeatAllUpdatablePropertiesEquals(expectedSeat, getPersistedSeat(expectedSeat));
    }
}
