package com.ticketsystem.booking.web.rest;

import static com.ticketsystem.booking.domain.PassengerAsserts.*;
import static com.ticketsystem.booking.web.rest.TestUtil.createUpdateProxyForBean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketsystem.booking.IntegrationTest;
import com.ticketsystem.booking.domain.Booking;
import com.ticketsystem.booking.domain.Passenger;
import com.ticketsystem.booking.repository.PassengerRepository;
import com.ticketsystem.booking.service.dto.PassengerDTO;
import com.ticketsystem.booking.service.mapper.PassengerMapper;
import jakarta.persistence.EntityManager;
import java.time.LocalDate;
import java.time.ZoneId;
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
 * Integration tests for the {@link PassengerResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class PassengerResourceIT {

    private static final UUID DEFAULT_SEAT_ID = UUID.randomUUID();
    private static final UUID UPDATED_SEAT_ID = UUID.randomUUID();

    private static final String DEFAULT_FIRST_NAME = "AAAAAAAAAA";
    private static final String UPDATED_FIRST_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_LAST_NAME = "AAAAAAAAAA";
    private static final String UPDATED_LAST_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_ID_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_ID_NUMBER = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_DATE_OF_BIRTH = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_OF_BIRTH = LocalDate.now(ZoneId.systemDefault());
    private static final LocalDate SMALLER_DATE_OF_BIRTH = LocalDate.ofEpochDay(-1L);

    private static final String DEFAULT_NATIONALITY = "AAAAAAAAAA";
    private static final String UPDATED_NATIONALITY = "BBBBBBBBBB";

    private static final String DEFAULT_TICKET_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_TICKET_NUMBER = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/passengers";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private PassengerMapper passengerMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restPassengerMockMvc;

    private Passenger passenger;

    private Passenger insertedPassenger;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Passenger createEntity(EntityManager em) {
        Passenger passenger = new Passenger()
            .seatId(DEFAULT_SEAT_ID)
            .firstName(DEFAULT_FIRST_NAME)
            .lastName(DEFAULT_LAST_NAME)
            .idNumber(DEFAULT_ID_NUMBER)
            .dateOfBirth(DEFAULT_DATE_OF_BIRTH)
            .nationality(DEFAULT_NATIONALITY)
            .ticketNumber(DEFAULT_TICKET_NUMBER);
        // Add required entity
        Booking booking;
        if (TestUtil.findAll(em, Booking.class).isEmpty()) {
            booking = BookingResourceIT.createEntity();
            em.persist(booking);
            em.flush();
        } else {
            booking = TestUtil.findAll(em, Booking.class).get(0);
        }
        passenger.setBooking(booking);
        return passenger;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Passenger createUpdatedEntity(EntityManager em) {
        Passenger updatedPassenger = new Passenger()
            .seatId(UPDATED_SEAT_ID)
            .firstName(UPDATED_FIRST_NAME)
            .lastName(UPDATED_LAST_NAME)
            .idNumber(UPDATED_ID_NUMBER)
            .dateOfBirth(UPDATED_DATE_OF_BIRTH)
            .nationality(UPDATED_NATIONALITY)
            .ticketNumber(UPDATED_TICKET_NUMBER);
        // Add required entity
        Booking booking;
        if (TestUtil.findAll(em, Booking.class).isEmpty()) {
            booking = BookingResourceIT.createUpdatedEntity();
            em.persist(booking);
            em.flush();
        } else {
            booking = TestUtil.findAll(em, Booking.class).get(0);
        }
        updatedPassenger.setBooking(booking);
        return updatedPassenger;
    }

    @BeforeEach
    void initTest() {
        passenger = createEntity(em);
    }

    @AfterEach
    void cleanup() {
        if (insertedPassenger != null) {
            passengerRepository.delete(insertedPassenger);
            insertedPassenger = null;
        }
    }

    @Test
    @Transactional
    void createPassenger() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the Passenger
        PassengerDTO passengerDTO = passengerMapper.toDto(passenger);
        var returnedPassengerDTO = om.readValue(
            restPassengerMockMvc
                .perform(
                    post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(passengerDTO))
                )
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            PassengerDTO.class
        );

        // Validate the Passenger in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        var returnedPassenger = passengerMapper.toEntity(returnedPassengerDTO);
        assertPassengerUpdatableFieldsEquals(returnedPassenger, getPersistedPassenger(returnedPassenger));

        insertedPassenger = returnedPassenger;
    }

    @Test
    @Transactional
    void createPassengerWithExistingId() throws Exception {
        // Create the Passenger with an existing ID
        passenger.setId(1L);
        PassengerDTO passengerDTO = passengerMapper.toDto(passenger);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restPassengerMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(passengerDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Passenger in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkSeatIdIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        passenger.setSeatId(null);

        // Create the Passenger, which fails.
        PassengerDTO passengerDTO = passengerMapper.toDto(passenger);

        restPassengerMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(passengerDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkFirstNameIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        passenger.setFirstName(null);

        // Create the Passenger, which fails.
        PassengerDTO passengerDTO = passengerMapper.toDto(passenger);

        restPassengerMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(passengerDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkLastNameIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        passenger.setLastName(null);

        // Create the Passenger, which fails.
        PassengerDTO passengerDTO = passengerMapper.toDto(passenger);

        restPassengerMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(passengerDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllPassengers() throws Exception {
        // Initialize the database
        insertedPassenger = passengerRepository.saveAndFlush(passenger);

        // Get all the passengerList
        restPassengerMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(passenger.getId().intValue())))
            .andExpect(jsonPath("$.[*].seatId").value(hasItem(DEFAULT_SEAT_ID.toString())))
            .andExpect(jsonPath("$.[*].firstName").value(hasItem(DEFAULT_FIRST_NAME)))
            .andExpect(jsonPath("$.[*].lastName").value(hasItem(DEFAULT_LAST_NAME)))
            .andExpect(jsonPath("$.[*].idNumber").value(hasItem(DEFAULT_ID_NUMBER)))
            .andExpect(jsonPath("$.[*].dateOfBirth").value(hasItem(DEFAULT_DATE_OF_BIRTH.toString())))
            .andExpect(jsonPath("$.[*].nationality").value(hasItem(DEFAULT_NATIONALITY)))
            .andExpect(jsonPath("$.[*].ticketNumber").value(hasItem(DEFAULT_TICKET_NUMBER)));
    }

    @Test
    @Transactional
    void getPassenger() throws Exception {
        // Initialize the database
        insertedPassenger = passengerRepository.saveAndFlush(passenger);

        // Get the passenger
        restPassengerMockMvc
            .perform(get(ENTITY_API_URL_ID, passenger.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(passenger.getId().intValue()))
            .andExpect(jsonPath("$.seatId").value(DEFAULT_SEAT_ID.toString()))
            .andExpect(jsonPath("$.firstName").value(DEFAULT_FIRST_NAME))
            .andExpect(jsonPath("$.lastName").value(DEFAULT_LAST_NAME))
            .andExpect(jsonPath("$.idNumber").value(DEFAULT_ID_NUMBER))
            .andExpect(jsonPath("$.dateOfBirth").value(DEFAULT_DATE_OF_BIRTH.toString()))
            .andExpect(jsonPath("$.nationality").value(DEFAULT_NATIONALITY))
            .andExpect(jsonPath("$.ticketNumber").value(DEFAULT_TICKET_NUMBER));
    }

    @Test
    @Transactional
    void getPassengersByIdFiltering() throws Exception {
        // Initialize the database
        insertedPassenger = passengerRepository.saveAndFlush(passenger);

        Long id = passenger.getId();

        defaultPassengerFiltering("id.equals=" + id, "id.notEquals=" + id);

        defaultPassengerFiltering("id.greaterThanOrEqual=" + id, "id.greaterThan=" + id);

        defaultPassengerFiltering("id.lessThanOrEqual=" + id, "id.lessThan=" + id);
    }

    @Test
    @Transactional
    void getAllPassengersBySeatIdIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedPassenger = passengerRepository.saveAndFlush(passenger);

        // Get all the passengerList where seatId equals to
        defaultPassengerFiltering("seatId.equals=" + DEFAULT_SEAT_ID, "seatId.equals=" + UPDATED_SEAT_ID);
    }

    @Test
    @Transactional
    void getAllPassengersBySeatIdIsInShouldWork() throws Exception {
        // Initialize the database
        insertedPassenger = passengerRepository.saveAndFlush(passenger);

        // Get all the passengerList where seatId in
        defaultPassengerFiltering("seatId.in=" + DEFAULT_SEAT_ID + "," + UPDATED_SEAT_ID, "seatId.in=" + UPDATED_SEAT_ID);
    }

    @Test
    @Transactional
    void getAllPassengersBySeatIdIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedPassenger = passengerRepository.saveAndFlush(passenger);

        // Get all the passengerList where seatId is not null
        defaultPassengerFiltering("seatId.specified=true", "seatId.specified=false");
    }

    @Test
    @Transactional
    void getAllPassengersByFirstNameIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedPassenger = passengerRepository.saveAndFlush(passenger);

        // Get all the passengerList where firstName equals to
        defaultPassengerFiltering("firstName.equals=" + DEFAULT_FIRST_NAME, "firstName.equals=" + UPDATED_FIRST_NAME);
    }

    @Test
    @Transactional
    void getAllPassengersByFirstNameIsInShouldWork() throws Exception {
        // Initialize the database
        insertedPassenger = passengerRepository.saveAndFlush(passenger);

        // Get all the passengerList where firstName in
        defaultPassengerFiltering("firstName.in=" + DEFAULT_FIRST_NAME + "," + UPDATED_FIRST_NAME, "firstName.in=" + UPDATED_FIRST_NAME);
    }

    @Test
    @Transactional
    void getAllPassengersByFirstNameIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedPassenger = passengerRepository.saveAndFlush(passenger);

        // Get all the passengerList where firstName is not null
        defaultPassengerFiltering("firstName.specified=true", "firstName.specified=false");
    }

    @Test
    @Transactional
    void getAllPassengersByFirstNameContainsSomething() throws Exception {
        // Initialize the database
        insertedPassenger = passengerRepository.saveAndFlush(passenger);

        // Get all the passengerList where firstName contains
        defaultPassengerFiltering("firstName.contains=" + DEFAULT_FIRST_NAME, "firstName.contains=" + UPDATED_FIRST_NAME);
    }

    @Test
    @Transactional
    void getAllPassengersByFirstNameNotContainsSomething() throws Exception {
        // Initialize the database
        insertedPassenger = passengerRepository.saveAndFlush(passenger);

        // Get all the passengerList where firstName does not contain
        defaultPassengerFiltering("firstName.doesNotContain=" + UPDATED_FIRST_NAME, "firstName.doesNotContain=" + DEFAULT_FIRST_NAME);
    }

    @Test
    @Transactional
    void getAllPassengersByLastNameIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedPassenger = passengerRepository.saveAndFlush(passenger);

        // Get all the passengerList where lastName equals to
        defaultPassengerFiltering("lastName.equals=" + DEFAULT_LAST_NAME, "lastName.equals=" + UPDATED_LAST_NAME);
    }

    @Test
    @Transactional
    void getAllPassengersByLastNameIsInShouldWork() throws Exception {
        // Initialize the database
        insertedPassenger = passengerRepository.saveAndFlush(passenger);

        // Get all the passengerList where lastName in
        defaultPassengerFiltering("lastName.in=" + DEFAULT_LAST_NAME + "," + UPDATED_LAST_NAME, "lastName.in=" + UPDATED_LAST_NAME);
    }

    @Test
    @Transactional
    void getAllPassengersByLastNameIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedPassenger = passengerRepository.saveAndFlush(passenger);

        // Get all the passengerList where lastName is not null
        defaultPassengerFiltering("lastName.specified=true", "lastName.specified=false");
    }

    @Test
    @Transactional
    void getAllPassengersByLastNameContainsSomething() throws Exception {
        // Initialize the database
        insertedPassenger = passengerRepository.saveAndFlush(passenger);

        // Get all the passengerList where lastName contains
        defaultPassengerFiltering("lastName.contains=" + DEFAULT_LAST_NAME, "lastName.contains=" + UPDATED_LAST_NAME);
    }

    @Test
    @Transactional
    void getAllPassengersByLastNameNotContainsSomething() throws Exception {
        // Initialize the database
        insertedPassenger = passengerRepository.saveAndFlush(passenger);

        // Get all the passengerList where lastName does not contain
        defaultPassengerFiltering("lastName.doesNotContain=" + UPDATED_LAST_NAME, "lastName.doesNotContain=" + DEFAULT_LAST_NAME);
    }

    @Test
    @Transactional
    void getAllPassengersByIdNumberIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedPassenger = passengerRepository.saveAndFlush(passenger);

        // Get all the passengerList where idNumber equals to
        defaultPassengerFiltering("idNumber.equals=" + DEFAULT_ID_NUMBER, "idNumber.equals=" + UPDATED_ID_NUMBER);
    }

    @Test
    @Transactional
    void getAllPassengersByIdNumberIsInShouldWork() throws Exception {
        // Initialize the database
        insertedPassenger = passengerRepository.saveAndFlush(passenger);

        // Get all the passengerList where idNumber in
        defaultPassengerFiltering("idNumber.in=" + DEFAULT_ID_NUMBER + "," + UPDATED_ID_NUMBER, "idNumber.in=" + UPDATED_ID_NUMBER);
    }

    @Test
    @Transactional
    void getAllPassengersByIdNumberIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedPassenger = passengerRepository.saveAndFlush(passenger);

        // Get all the passengerList where idNumber is not null
        defaultPassengerFiltering("idNumber.specified=true", "idNumber.specified=false");
    }

    @Test
    @Transactional
    void getAllPassengersByIdNumberContainsSomething() throws Exception {
        // Initialize the database
        insertedPassenger = passengerRepository.saveAndFlush(passenger);

        // Get all the passengerList where idNumber contains
        defaultPassengerFiltering("idNumber.contains=" + DEFAULT_ID_NUMBER, "idNumber.contains=" + UPDATED_ID_NUMBER);
    }

    @Test
    @Transactional
    void getAllPassengersByIdNumberNotContainsSomething() throws Exception {
        // Initialize the database
        insertedPassenger = passengerRepository.saveAndFlush(passenger);

        // Get all the passengerList where idNumber does not contain
        defaultPassengerFiltering("idNumber.doesNotContain=" + UPDATED_ID_NUMBER, "idNumber.doesNotContain=" + DEFAULT_ID_NUMBER);
    }

    @Test
    @Transactional
    void getAllPassengersByDateOfBirthIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedPassenger = passengerRepository.saveAndFlush(passenger);

        // Get all the passengerList where dateOfBirth equals to
        defaultPassengerFiltering("dateOfBirth.equals=" + DEFAULT_DATE_OF_BIRTH, "dateOfBirth.equals=" + UPDATED_DATE_OF_BIRTH);
    }

    @Test
    @Transactional
    void getAllPassengersByDateOfBirthIsInShouldWork() throws Exception {
        // Initialize the database
        insertedPassenger = passengerRepository.saveAndFlush(passenger);

        // Get all the passengerList where dateOfBirth in
        defaultPassengerFiltering(
            "dateOfBirth.in=" + DEFAULT_DATE_OF_BIRTH + "," + UPDATED_DATE_OF_BIRTH,
            "dateOfBirth.in=" + UPDATED_DATE_OF_BIRTH
        );
    }

    @Test
    @Transactional
    void getAllPassengersByDateOfBirthIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedPassenger = passengerRepository.saveAndFlush(passenger);

        // Get all the passengerList where dateOfBirth is not null
        defaultPassengerFiltering("dateOfBirth.specified=true", "dateOfBirth.specified=false");
    }

    @Test
    @Transactional
    void getAllPassengersByDateOfBirthIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedPassenger = passengerRepository.saveAndFlush(passenger);

        // Get all the passengerList where dateOfBirth is greater than or equal to
        defaultPassengerFiltering(
            "dateOfBirth.greaterThanOrEqual=" + DEFAULT_DATE_OF_BIRTH,
            "dateOfBirth.greaterThanOrEqual=" + UPDATED_DATE_OF_BIRTH
        );
    }

    @Test
    @Transactional
    void getAllPassengersByDateOfBirthIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedPassenger = passengerRepository.saveAndFlush(passenger);

        // Get all the passengerList where dateOfBirth is less than or equal to
        defaultPassengerFiltering(
            "dateOfBirth.lessThanOrEqual=" + DEFAULT_DATE_OF_BIRTH,
            "dateOfBirth.lessThanOrEqual=" + SMALLER_DATE_OF_BIRTH
        );
    }

    @Test
    @Transactional
    void getAllPassengersByDateOfBirthIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedPassenger = passengerRepository.saveAndFlush(passenger);

        // Get all the passengerList where dateOfBirth is less than
        defaultPassengerFiltering("dateOfBirth.lessThan=" + UPDATED_DATE_OF_BIRTH, "dateOfBirth.lessThan=" + DEFAULT_DATE_OF_BIRTH);
    }

    @Test
    @Transactional
    void getAllPassengersByDateOfBirthIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedPassenger = passengerRepository.saveAndFlush(passenger);

        // Get all the passengerList where dateOfBirth is greater than
        defaultPassengerFiltering("dateOfBirth.greaterThan=" + SMALLER_DATE_OF_BIRTH, "dateOfBirth.greaterThan=" + DEFAULT_DATE_OF_BIRTH);
    }

    @Test
    @Transactional
    void getAllPassengersByNationalityIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedPassenger = passengerRepository.saveAndFlush(passenger);

        // Get all the passengerList where nationality equals to
        defaultPassengerFiltering("nationality.equals=" + DEFAULT_NATIONALITY, "nationality.equals=" + UPDATED_NATIONALITY);
    }

    @Test
    @Transactional
    void getAllPassengersByNationalityIsInShouldWork() throws Exception {
        // Initialize the database
        insertedPassenger = passengerRepository.saveAndFlush(passenger);

        // Get all the passengerList where nationality in
        defaultPassengerFiltering(
            "nationality.in=" + DEFAULT_NATIONALITY + "," + UPDATED_NATIONALITY,
            "nationality.in=" + UPDATED_NATIONALITY
        );
    }

    @Test
    @Transactional
    void getAllPassengersByNationalityIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedPassenger = passengerRepository.saveAndFlush(passenger);

        // Get all the passengerList where nationality is not null
        defaultPassengerFiltering("nationality.specified=true", "nationality.specified=false");
    }

    @Test
    @Transactional
    void getAllPassengersByNationalityContainsSomething() throws Exception {
        // Initialize the database
        insertedPassenger = passengerRepository.saveAndFlush(passenger);

        // Get all the passengerList where nationality contains
        defaultPassengerFiltering("nationality.contains=" + DEFAULT_NATIONALITY, "nationality.contains=" + UPDATED_NATIONALITY);
    }

    @Test
    @Transactional
    void getAllPassengersByNationalityNotContainsSomething() throws Exception {
        // Initialize the database
        insertedPassenger = passengerRepository.saveAndFlush(passenger);

        // Get all the passengerList where nationality does not contain
        defaultPassengerFiltering("nationality.doesNotContain=" + UPDATED_NATIONALITY, "nationality.doesNotContain=" + DEFAULT_NATIONALITY);
    }

    @Test
    @Transactional
    void getAllPassengersByTicketNumberIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedPassenger = passengerRepository.saveAndFlush(passenger);

        // Get all the passengerList where ticketNumber equals to
        defaultPassengerFiltering("ticketNumber.equals=" + DEFAULT_TICKET_NUMBER, "ticketNumber.equals=" + UPDATED_TICKET_NUMBER);
    }

    @Test
    @Transactional
    void getAllPassengersByTicketNumberIsInShouldWork() throws Exception {
        // Initialize the database
        insertedPassenger = passengerRepository.saveAndFlush(passenger);

        // Get all the passengerList where ticketNumber in
        defaultPassengerFiltering(
            "ticketNumber.in=" + DEFAULT_TICKET_NUMBER + "," + UPDATED_TICKET_NUMBER,
            "ticketNumber.in=" + UPDATED_TICKET_NUMBER
        );
    }

    @Test
    @Transactional
    void getAllPassengersByTicketNumberIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedPassenger = passengerRepository.saveAndFlush(passenger);

        // Get all the passengerList where ticketNumber is not null
        defaultPassengerFiltering("ticketNumber.specified=true", "ticketNumber.specified=false");
    }

    @Test
    @Transactional
    void getAllPassengersByTicketNumberContainsSomething() throws Exception {
        // Initialize the database
        insertedPassenger = passengerRepository.saveAndFlush(passenger);

        // Get all the passengerList where ticketNumber contains
        defaultPassengerFiltering("ticketNumber.contains=" + DEFAULT_TICKET_NUMBER, "ticketNumber.contains=" + UPDATED_TICKET_NUMBER);
    }

    @Test
    @Transactional
    void getAllPassengersByTicketNumberNotContainsSomething() throws Exception {
        // Initialize the database
        insertedPassenger = passengerRepository.saveAndFlush(passenger);

        // Get all the passengerList where ticketNumber does not contain
        defaultPassengerFiltering(
            "ticketNumber.doesNotContain=" + UPDATED_TICKET_NUMBER,
            "ticketNumber.doesNotContain=" + DEFAULT_TICKET_NUMBER
        );
    }

    @Test
    @Transactional
    void getAllPassengersByBookingIsEqualToSomething() throws Exception {
        Booking booking;
        if (TestUtil.findAll(em, Booking.class).isEmpty()) {
            passengerRepository.saveAndFlush(passenger);
            booking = BookingResourceIT.createEntity();
        } else {
            booking = TestUtil.findAll(em, Booking.class).get(0);
        }
        em.persist(booking);
        em.flush();
        passenger.setBooking(booking);
        passengerRepository.saveAndFlush(passenger);
        Long bookingId = booking.getId();
        // Get all the passengerList where booking equals to bookingId
        defaultPassengerShouldBeFound("bookingId.equals=" + bookingId);

        // Get all the passengerList where booking equals to (bookingId + 1)
        defaultPassengerShouldNotBeFound("bookingId.equals=" + (bookingId + 1));
    }

    private void defaultPassengerFiltering(String shouldBeFound, String shouldNotBeFound) throws Exception {
        defaultPassengerShouldBeFound(shouldBeFound);
        defaultPassengerShouldNotBeFound(shouldNotBeFound);
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultPassengerShouldBeFound(String filter) throws Exception {
        restPassengerMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(passenger.getId().intValue())))
            .andExpect(jsonPath("$.[*].seatId").value(hasItem(DEFAULT_SEAT_ID.toString())))
            .andExpect(jsonPath("$.[*].firstName").value(hasItem(DEFAULT_FIRST_NAME)))
            .andExpect(jsonPath("$.[*].lastName").value(hasItem(DEFAULT_LAST_NAME)))
            .andExpect(jsonPath("$.[*].idNumber").value(hasItem(DEFAULT_ID_NUMBER)))
            .andExpect(jsonPath("$.[*].dateOfBirth").value(hasItem(DEFAULT_DATE_OF_BIRTH.toString())))
            .andExpect(jsonPath("$.[*].nationality").value(hasItem(DEFAULT_NATIONALITY)))
            .andExpect(jsonPath("$.[*].ticketNumber").value(hasItem(DEFAULT_TICKET_NUMBER)));

        // Check, that the count call also returns 1
        restPassengerMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("1"));
    }

    /**
     * Executes the search, and checks that the default entity is not returned.
     */
    private void defaultPassengerShouldNotBeFound(String filter) throws Exception {
        restPassengerMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());

        // Check, that the count call also returns 0
        restPassengerMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("0"));
    }

    @Test
    @Transactional
    void getNonExistingPassenger() throws Exception {
        // Get the passenger
        restPassengerMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingPassenger() throws Exception {
        // Initialize the database
        insertedPassenger = passengerRepository.saveAndFlush(passenger);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the passenger
        Passenger updatedPassenger = passengerRepository.findById(passenger.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedPassenger are not directly saved in db
        em.detach(updatedPassenger);
        updatedPassenger
            .seatId(UPDATED_SEAT_ID)
            .firstName(UPDATED_FIRST_NAME)
            .lastName(UPDATED_LAST_NAME)
            .idNumber(UPDATED_ID_NUMBER)
            .dateOfBirth(UPDATED_DATE_OF_BIRTH)
            .nationality(UPDATED_NATIONALITY)
            .ticketNumber(UPDATED_TICKET_NUMBER);
        PassengerDTO passengerDTO = passengerMapper.toDto(updatedPassenger);

        restPassengerMockMvc
            .perform(
                put(ENTITY_API_URL_ID, passengerDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(passengerDTO))
            )
            .andExpect(status().isOk());

        // Validate the Passenger in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedPassengerToMatchAllProperties(updatedPassenger);
    }

    @Test
    @Transactional
    void putNonExistingPassenger() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        passenger.setId(longCount.incrementAndGet());

        // Create the Passenger
        PassengerDTO passengerDTO = passengerMapper.toDto(passenger);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restPassengerMockMvc
            .perform(
                put(ENTITY_API_URL_ID, passengerDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(passengerDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Passenger in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchPassenger() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        passenger.setId(longCount.incrementAndGet());

        // Create the Passenger
        PassengerDTO passengerDTO = passengerMapper.toDto(passenger);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restPassengerMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(passengerDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Passenger in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamPassenger() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        passenger.setId(longCount.incrementAndGet());

        // Create the Passenger
        PassengerDTO passengerDTO = passengerMapper.toDto(passenger);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restPassengerMockMvc
            .perform(put(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(passengerDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Passenger in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdatePassengerWithPatch() throws Exception {
        // Initialize the database
        insertedPassenger = passengerRepository.saveAndFlush(passenger);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the passenger using partial update
        Passenger partialUpdatedPassenger = new Passenger();
        partialUpdatedPassenger.setId(passenger.getId());

        partialUpdatedPassenger
            .firstName(UPDATED_FIRST_NAME)
            .dateOfBirth(UPDATED_DATE_OF_BIRTH)
            .nationality(UPDATED_NATIONALITY)
            .ticketNumber(UPDATED_TICKET_NUMBER);

        restPassengerMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedPassenger.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedPassenger))
            )
            .andExpect(status().isOk());

        // Validate the Passenger in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPassengerUpdatableFieldsEquals(
            createUpdateProxyForBean(partialUpdatedPassenger, passenger),
            getPersistedPassenger(passenger)
        );
    }

    @Test
    @Transactional
    void fullUpdatePassengerWithPatch() throws Exception {
        // Initialize the database
        insertedPassenger = passengerRepository.saveAndFlush(passenger);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the passenger using partial update
        Passenger partialUpdatedPassenger = new Passenger();
        partialUpdatedPassenger.setId(passenger.getId());

        partialUpdatedPassenger
            .seatId(UPDATED_SEAT_ID)
            .firstName(UPDATED_FIRST_NAME)
            .lastName(UPDATED_LAST_NAME)
            .idNumber(UPDATED_ID_NUMBER)
            .dateOfBirth(UPDATED_DATE_OF_BIRTH)
            .nationality(UPDATED_NATIONALITY)
            .ticketNumber(UPDATED_TICKET_NUMBER);

        restPassengerMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedPassenger.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedPassenger))
            )
            .andExpect(status().isOk());

        // Validate the Passenger in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPassengerUpdatableFieldsEquals(partialUpdatedPassenger, getPersistedPassenger(partialUpdatedPassenger));
    }

    @Test
    @Transactional
    void patchNonExistingPassenger() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        passenger.setId(longCount.incrementAndGet());

        // Create the Passenger
        PassengerDTO passengerDTO = passengerMapper.toDto(passenger);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restPassengerMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, passengerDTO.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(passengerDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Passenger in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchPassenger() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        passenger.setId(longCount.incrementAndGet());

        // Create the Passenger
        PassengerDTO passengerDTO = passengerMapper.toDto(passenger);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restPassengerMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(passengerDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Passenger in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamPassenger() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        passenger.setId(longCount.incrementAndGet());

        // Create the Passenger
        PassengerDTO passengerDTO = passengerMapper.toDto(passenger);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restPassengerMockMvc
            .perform(
                patch(ENTITY_API_URL).with(csrf()).contentType("application/merge-patch+json").content(om.writeValueAsBytes(passengerDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the Passenger in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deletePassenger() throws Exception {
        // Initialize the database
        insertedPassenger = passengerRepository.saveAndFlush(passenger);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the passenger
        restPassengerMockMvc
            .perform(delete(ENTITY_API_URL_ID, passenger.getId()).with(csrf()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return passengerRepository.count();
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

    protected Passenger getPersistedPassenger(Passenger passenger) {
        return passengerRepository.findById(passenger.getId()).orElseThrow();
    }

    protected void assertPersistedPassengerToMatchAllProperties(Passenger expectedPassenger) {
        assertPassengerAllPropertiesEquals(expectedPassenger, getPersistedPassenger(expectedPassenger));
    }

    protected void assertPersistedPassengerToMatchUpdatableProperties(Passenger expectedPassenger) {
        assertPassengerAllUpdatablePropertiesEquals(expectedPassenger, getPersistedPassenger(expectedPassenger));
    }
}
