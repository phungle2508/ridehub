package com.ticketsystem.route.web.rest;

import static com.ticketsystem.route.domain.SeatAsserts.*;
import static com.ticketsystem.route.web.rest.TestUtil.createUpdateProxyForBean;
import static com.ticketsystem.route.web.rest.TestUtil.sameNumber;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketsystem.route.IntegrationTest;
import com.ticketsystem.route.domain.Seat;
import com.ticketsystem.route.domain.Trip;
import com.ticketsystem.route.domain.enumeration.SeatType;
import com.ticketsystem.route.repository.SeatRepository;
import com.ticketsystem.route.service.dto.SeatDTO;
import com.ticketsystem.route.service.mapper.SeatMapper;
import jakarta.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Random;
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

    private static final String DEFAULT_SEAT_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_SEAT_NUMBER = "BBBBBBBBBB";

    private static final SeatType DEFAULT_SEAT_TYPE = SeatType.BERTH_LOWER;
    private static final SeatType UPDATED_SEAT_TYPE = SeatType.BERTH_UPPER;

    private static final String DEFAULT_DECK = "AAAAAAAAAA";
    private static final String UPDATED_DECK = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_PRICE_MODIFIER = new BigDecimal(1);
    private static final BigDecimal UPDATED_PRICE_MODIFIER = new BigDecimal(2);
    private static final BigDecimal SMALLER_PRICE_MODIFIER = new BigDecimal(1 - 1);

    private static final Boolean DEFAULT_IS_AVAILABLE = false;
    private static final Boolean UPDATED_IS_AVAILABLE = true;

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
            .seatNumber(DEFAULT_SEAT_NUMBER)
            .seatType(DEFAULT_SEAT_TYPE)
            .deck(DEFAULT_DECK)
            .priceModifier(DEFAULT_PRICE_MODIFIER)
            .isAvailable(DEFAULT_IS_AVAILABLE);
        // Add required entity
        Trip trip;
        if (TestUtil.findAll(em, Trip.class).isEmpty()) {
            trip = TripResourceIT.createEntity(em);
            em.persist(trip);
            em.flush();
        } else {
            trip = TestUtil.findAll(em, Trip.class).get(0);
        }
        seat.setTrip(trip);
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
            .seatNumber(UPDATED_SEAT_NUMBER)
            .seatType(UPDATED_SEAT_TYPE)
            .deck(UPDATED_DECK)
            .priceModifier(UPDATED_PRICE_MODIFIER)
            .isAvailable(UPDATED_IS_AVAILABLE);
        // Add required entity
        Trip trip;
        if (TestUtil.findAll(em, Trip.class).isEmpty()) {
            trip = TripResourceIT.createUpdatedEntity(em);
            em.persist(trip);
            em.flush();
        } else {
            trip = TestUtil.findAll(em, Trip.class).get(0);
        }
        updatedSeat.setTrip(trip);
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
    void checkSeatNumberIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        seat.setSeatNumber(null);

        // Create the Seat, which fails.
        SeatDTO seatDTO = seatMapper.toDto(seat);

        restSeatMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(seatDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkSeatTypeIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        seat.setSeatType(null);

        // Create the Seat, which fails.
        SeatDTO seatDTO = seatMapper.toDto(seat);

        restSeatMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(seatDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkIsAvailableIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        seat.setIsAvailable(null);

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
            .andExpect(jsonPath("$.[*].seatNumber").value(hasItem(DEFAULT_SEAT_NUMBER)))
            .andExpect(jsonPath("$.[*].seatType").value(hasItem(DEFAULT_SEAT_TYPE.toString())))
            .andExpect(jsonPath("$.[*].deck").value(hasItem(DEFAULT_DECK)))
            .andExpect(jsonPath("$.[*].priceModifier").value(hasItem(sameNumber(DEFAULT_PRICE_MODIFIER))))
            .andExpect(jsonPath("$.[*].isAvailable").value(hasItem(DEFAULT_IS_AVAILABLE)));
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
            .andExpect(jsonPath("$.seatNumber").value(DEFAULT_SEAT_NUMBER))
            .andExpect(jsonPath("$.seatType").value(DEFAULT_SEAT_TYPE.toString()))
            .andExpect(jsonPath("$.deck").value(DEFAULT_DECK))
            .andExpect(jsonPath("$.priceModifier").value(sameNumber(DEFAULT_PRICE_MODIFIER)))
            .andExpect(jsonPath("$.isAvailable").value(DEFAULT_IS_AVAILABLE));
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
    void getAllSeatsBySeatNumberIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where seatNumber equals to
        defaultSeatFiltering("seatNumber.equals=" + DEFAULT_SEAT_NUMBER, "seatNumber.equals=" + UPDATED_SEAT_NUMBER);
    }

    @Test
    @Transactional
    void getAllSeatsBySeatNumberIsInShouldWork() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where seatNumber in
        defaultSeatFiltering("seatNumber.in=" + DEFAULT_SEAT_NUMBER + "," + UPDATED_SEAT_NUMBER, "seatNumber.in=" + UPDATED_SEAT_NUMBER);
    }

    @Test
    @Transactional
    void getAllSeatsBySeatNumberIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where seatNumber is not null
        defaultSeatFiltering("seatNumber.specified=true", "seatNumber.specified=false");
    }

    @Test
    @Transactional
    void getAllSeatsBySeatNumberContainsSomething() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where seatNumber contains
        defaultSeatFiltering("seatNumber.contains=" + DEFAULT_SEAT_NUMBER, "seatNumber.contains=" + UPDATED_SEAT_NUMBER);
    }

    @Test
    @Transactional
    void getAllSeatsBySeatNumberNotContainsSomething() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where seatNumber does not contain
        defaultSeatFiltering("seatNumber.doesNotContain=" + UPDATED_SEAT_NUMBER, "seatNumber.doesNotContain=" + DEFAULT_SEAT_NUMBER);
    }

    @Test
    @Transactional
    void getAllSeatsBySeatTypeIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where seatType equals to
        defaultSeatFiltering("seatType.equals=" + DEFAULT_SEAT_TYPE, "seatType.equals=" + UPDATED_SEAT_TYPE);
    }

    @Test
    @Transactional
    void getAllSeatsBySeatTypeIsInShouldWork() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where seatType in
        defaultSeatFiltering("seatType.in=" + DEFAULT_SEAT_TYPE + "," + UPDATED_SEAT_TYPE, "seatType.in=" + UPDATED_SEAT_TYPE);
    }

    @Test
    @Transactional
    void getAllSeatsBySeatTypeIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where seatType is not null
        defaultSeatFiltering("seatType.specified=true", "seatType.specified=false");
    }

    @Test
    @Transactional
    void getAllSeatsByDeckIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where deck equals to
        defaultSeatFiltering("deck.equals=" + DEFAULT_DECK, "deck.equals=" + UPDATED_DECK);
    }

    @Test
    @Transactional
    void getAllSeatsByDeckIsInShouldWork() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where deck in
        defaultSeatFiltering("deck.in=" + DEFAULT_DECK + "," + UPDATED_DECK, "deck.in=" + UPDATED_DECK);
    }

    @Test
    @Transactional
    void getAllSeatsByDeckIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where deck is not null
        defaultSeatFiltering("deck.specified=true", "deck.specified=false");
    }

    @Test
    @Transactional
    void getAllSeatsByDeckContainsSomething() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where deck contains
        defaultSeatFiltering("deck.contains=" + DEFAULT_DECK, "deck.contains=" + UPDATED_DECK);
    }

    @Test
    @Transactional
    void getAllSeatsByDeckNotContainsSomething() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where deck does not contain
        defaultSeatFiltering("deck.doesNotContain=" + UPDATED_DECK, "deck.doesNotContain=" + DEFAULT_DECK);
    }

    @Test
    @Transactional
    void getAllSeatsByPriceModifierIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where priceModifier equals to
        defaultSeatFiltering("priceModifier.equals=" + DEFAULT_PRICE_MODIFIER, "priceModifier.equals=" + UPDATED_PRICE_MODIFIER);
    }

    @Test
    @Transactional
    void getAllSeatsByPriceModifierIsInShouldWork() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where priceModifier in
        defaultSeatFiltering(
            "priceModifier.in=" + DEFAULT_PRICE_MODIFIER + "," + UPDATED_PRICE_MODIFIER,
            "priceModifier.in=" + UPDATED_PRICE_MODIFIER
        );
    }

    @Test
    @Transactional
    void getAllSeatsByPriceModifierIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where priceModifier is not null
        defaultSeatFiltering("priceModifier.specified=true", "priceModifier.specified=false");
    }

    @Test
    @Transactional
    void getAllSeatsByPriceModifierIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where priceModifier is greater than or equal to
        defaultSeatFiltering(
            "priceModifier.greaterThanOrEqual=" + DEFAULT_PRICE_MODIFIER,
            "priceModifier.greaterThanOrEqual=" + UPDATED_PRICE_MODIFIER
        );
    }

    @Test
    @Transactional
    void getAllSeatsByPriceModifierIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where priceModifier is less than or equal to
        defaultSeatFiltering(
            "priceModifier.lessThanOrEqual=" + DEFAULT_PRICE_MODIFIER,
            "priceModifier.lessThanOrEqual=" + SMALLER_PRICE_MODIFIER
        );
    }

    @Test
    @Transactional
    void getAllSeatsByPriceModifierIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where priceModifier is less than
        defaultSeatFiltering("priceModifier.lessThan=" + UPDATED_PRICE_MODIFIER, "priceModifier.lessThan=" + DEFAULT_PRICE_MODIFIER);
    }

    @Test
    @Transactional
    void getAllSeatsByPriceModifierIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where priceModifier is greater than
        defaultSeatFiltering("priceModifier.greaterThan=" + SMALLER_PRICE_MODIFIER, "priceModifier.greaterThan=" + DEFAULT_PRICE_MODIFIER);
    }

    @Test
    @Transactional
    void getAllSeatsByIsAvailableIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where isAvailable equals to
        defaultSeatFiltering("isAvailable.equals=" + DEFAULT_IS_AVAILABLE, "isAvailable.equals=" + UPDATED_IS_AVAILABLE);
    }

    @Test
    @Transactional
    void getAllSeatsByIsAvailableIsInShouldWork() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where isAvailable in
        defaultSeatFiltering(
            "isAvailable.in=" + DEFAULT_IS_AVAILABLE + "," + UPDATED_IS_AVAILABLE,
            "isAvailable.in=" + UPDATED_IS_AVAILABLE
        );
    }

    @Test
    @Transactional
    void getAllSeatsByIsAvailableIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedSeat = seatRepository.saveAndFlush(seat);

        // Get all the seatList where isAvailable is not null
        defaultSeatFiltering("isAvailable.specified=true", "isAvailable.specified=false");
    }

    @Test
    @Transactional
    void getAllSeatsByTripIsEqualToSomething() throws Exception {
        Trip trip;
        if (TestUtil.findAll(em, Trip.class).isEmpty()) {
            seatRepository.saveAndFlush(seat);
            trip = TripResourceIT.createEntity(em);
        } else {
            trip = TestUtil.findAll(em, Trip.class).get(0);
        }
        em.persist(trip);
        em.flush();
        seat.setTrip(trip);
        seatRepository.saveAndFlush(seat);
        Long tripId = trip.getId();
        // Get all the seatList where trip equals to tripId
        defaultSeatShouldBeFound("tripId.equals=" + tripId);

        // Get all the seatList where trip equals to (tripId + 1)
        defaultSeatShouldNotBeFound("tripId.equals=" + (tripId + 1));
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
            .andExpect(jsonPath("$.[*].seatNumber").value(hasItem(DEFAULT_SEAT_NUMBER)))
            .andExpect(jsonPath("$.[*].seatType").value(hasItem(DEFAULT_SEAT_TYPE.toString())))
            .andExpect(jsonPath("$.[*].deck").value(hasItem(DEFAULT_DECK)))
            .andExpect(jsonPath("$.[*].priceModifier").value(hasItem(sameNumber(DEFAULT_PRICE_MODIFIER))))
            .andExpect(jsonPath("$.[*].isAvailable").value(hasItem(DEFAULT_IS_AVAILABLE)));

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
            .seatNumber(UPDATED_SEAT_NUMBER)
            .seatType(UPDATED_SEAT_TYPE)
            .deck(UPDATED_DECK)
            .priceModifier(UPDATED_PRICE_MODIFIER)
            .isAvailable(UPDATED_IS_AVAILABLE);
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

        partialUpdatedSeat.isAvailable(UPDATED_IS_AVAILABLE);

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
            .seatNumber(UPDATED_SEAT_NUMBER)
            .seatType(UPDATED_SEAT_TYPE)
            .deck(UPDATED_DECK)
            .priceModifier(UPDATED_PRICE_MODIFIER)
            .isAvailable(UPDATED_IS_AVAILABLE);

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
