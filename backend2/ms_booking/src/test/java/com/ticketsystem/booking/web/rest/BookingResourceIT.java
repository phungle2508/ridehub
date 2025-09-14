package com.ticketsystem.booking.web.rest;

import static com.ticketsystem.booking.domain.BookingAsserts.*;
import static com.ticketsystem.booking.web.rest.TestUtil.createUpdateProxyForBean;
import static com.ticketsystem.booking.web.rest.TestUtil.sameNumber;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketsystem.booking.IntegrationTest;
import com.ticketsystem.booking.domain.Booking;
import com.ticketsystem.booking.domain.enumeration.BookingStatus;
import com.ticketsystem.booking.repository.BookingRepository;
import com.ticketsystem.booking.service.dto.BookingDTO;
import com.ticketsystem.booking.service.mapper.BookingMapper;
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
 * Integration tests for the {@link BookingResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class BookingResourceIT {

    private static final UUID DEFAULT_USER_ID = UUID.randomUUID();
    private static final UUID UPDATED_USER_ID = UUID.randomUUID();

    private static final UUID DEFAULT_TRIP_ID = UUID.randomUUID();
    private static final UUID UPDATED_TRIP_ID = UUID.randomUUID();

    private static final String DEFAULT_BOOKING_REFERENCE = "AAAAAAAAAA";
    private static final String UPDATED_BOOKING_REFERENCE = "BBBBBBBBBB";

    private static final BookingStatus DEFAULT_STATUS = BookingStatus.DRAFT;
    private static final BookingStatus UPDATED_STATUS = BookingStatus.PENDING_PAYMENT;

    private static final BigDecimal DEFAULT_TOTAL_AMOUNT = new BigDecimal(1);
    private static final BigDecimal UPDATED_TOTAL_AMOUNT = new BigDecimal(2);
    private static final BigDecimal SMALLER_TOTAL_AMOUNT = new BigDecimal(1 - 1);

    private static final String DEFAULT_CONTACT_PHONE = "AAAAAAAAAA";
    private static final String UPDATED_CONTACT_PHONE = "BBBBBBBBBB";

    private static final String DEFAULT_CONTACT_EMAIL = "AAAAAAAAAA";
    private static final String UPDATED_CONTACT_EMAIL = "BBBBBBBBBB";

    private static final String DEFAULT_SPECIAL_REQUESTS = "AAAAAAAAAA";
    private static final String UPDATED_SPECIAL_REQUESTS = "BBBBBBBBBB";

    private static final Instant DEFAULT_CREATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_EXPIRES_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_EXPIRES_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String ENTITY_API_URL = "/api/bookings";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private BookingMapper bookingMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restBookingMockMvc;

    private Booking booking;

    private Booking insertedBooking;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Booking createEntity() {
        return new Booking()
            .userId(DEFAULT_USER_ID)
            .tripId(DEFAULT_TRIP_ID)
            .bookingReference(DEFAULT_BOOKING_REFERENCE)
            .status(DEFAULT_STATUS)
            .totalAmount(DEFAULT_TOTAL_AMOUNT)
            .contactPhone(DEFAULT_CONTACT_PHONE)
            .contactEmail(DEFAULT_CONTACT_EMAIL)
            .specialRequests(DEFAULT_SPECIAL_REQUESTS)
            .createdAt(DEFAULT_CREATED_AT)
            .expiresAt(DEFAULT_EXPIRES_AT);
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Booking createUpdatedEntity() {
        return new Booking()
            .userId(UPDATED_USER_ID)
            .tripId(UPDATED_TRIP_ID)
            .bookingReference(UPDATED_BOOKING_REFERENCE)
            .status(UPDATED_STATUS)
            .totalAmount(UPDATED_TOTAL_AMOUNT)
            .contactPhone(UPDATED_CONTACT_PHONE)
            .contactEmail(UPDATED_CONTACT_EMAIL)
            .specialRequests(UPDATED_SPECIAL_REQUESTS)
            .createdAt(UPDATED_CREATED_AT)
            .expiresAt(UPDATED_EXPIRES_AT);
    }

    @BeforeEach
    void initTest() {
        booking = createEntity();
    }

    @AfterEach
    void cleanup() {
        if (insertedBooking != null) {
            bookingRepository.delete(insertedBooking);
            insertedBooking = null;
        }
    }

    @Test
    @Transactional
    void createBooking() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the Booking
        BookingDTO bookingDTO = bookingMapper.toDto(booking);
        var returnedBookingDTO = om.readValue(
            restBookingMockMvc
                .perform(
                    post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(bookingDTO))
                )
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            BookingDTO.class
        );

        // Validate the Booking in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        var returnedBooking = bookingMapper.toEntity(returnedBookingDTO);
        assertBookingUpdatableFieldsEquals(returnedBooking, getPersistedBooking(returnedBooking));

        insertedBooking = returnedBooking;
    }

    @Test
    @Transactional
    void createBookingWithExistingId() throws Exception {
        // Create the Booking with an existing ID
        booking.setId(1L);
        BookingDTO bookingDTO = bookingMapper.toDto(booking);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restBookingMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(bookingDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Booking in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkUserIdIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        booking.setUserId(null);

        // Create the Booking, which fails.
        BookingDTO bookingDTO = bookingMapper.toDto(booking);

        restBookingMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(bookingDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkTripIdIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        booking.setTripId(null);

        // Create the Booking, which fails.
        BookingDTO bookingDTO = bookingMapper.toDto(booking);

        restBookingMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(bookingDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkBookingReferenceIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        booking.setBookingReference(null);

        // Create the Booking, which fails.
        BookingDTO bookingDTO = bookingMapper.toDto(booking);

        restBookingMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(bookingDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkStatusIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        booking.setStatus(null);

        // Create the Booking, which fails.
        BookingDTO bookingDTO = bookingMapper.toDto(booking);

        restBookingMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(bookingDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkTotalAmountIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        booking.setTotalAmount(null);

        // Create the Booking, which fails.
        BookingDTO bookingDTO = bookingMapper.toDto(booking);

        restBookingMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(bookingDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkCreatedAtIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        booking.setCreatedAt(null);

        // Create the Booking, which fails.
        BookingDTO bookingDTO = bookingMapper.toDto(booking);

        restBookingMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(bookingDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllBookings() throws Exception {
        // Initialize the database
        insertedBooking = bookingRepository.saveAndFlush(booking);

        // Get all the bookingList
        restBookingMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(booking.getId().intValue())))
            .andExpect(jsonPath("$.[*].userId").value(hasItem(DEFAULT_USER_ID.toString())))
            .andExpect(jsonPath("$.[*].tripId").value(hasItem(DEFAULT_TRIP_ID.toString())))
            .andExpect(jsonPath("$.[*].bookingReference").value(hasItem(DEFAULT_BOOKING_REFERENCE)))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS.toString())))
            .andExpect(jsonPath("$.[*].totalAmount").value(hasItem(sameNumber(DEFAULT_TOTAL_AMOUNT))))
            .andExpect(jsonPath("$.[*].contactPhone").value(hasItem(DEFAULT_CONTACT_PHONE)))
            .andExpect(jsonPath("$.[*].contactEmail").value(hasItem(DEFAULT_CONTACT_EMAIL)))
            .andExpect(jsonPath("$.[*].specialRequests").value(hasItem(DEFAULT_SPECIAL_REQUESTS)))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].expiresAt").value(hasItem(DEFAULT_EXPIRES_AT.toString())));
    }

    @Test
    @Transactional
    void getBooking() throws Exception {
        // Initialize the database
        insertedBooking = bookingRepository.saveAndFlush(booking);

        // Get the booking
        restBookingMockMvc
            .perform(get(ENTITY_API_URL_ID, booking.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(booking.getId().intValue()))
            .andExpect(jsonPath("$.userId").value(DEFAULT_USER_ID.toString()))
            .andExpect(jsonPath("$.tripId").value(DEFAULT_TRIP_ID.toString()))
            .andExpect(jsonPath("$.bookingReference").value(DEFAULT_BOOKING_REFERENCE))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS.toString()))
            .andExpect(jsonPath("$.totalAmount").value(sameNumber(DEFAULT_TOTAL_AMOUNT)))
            .andExpect(jsonPath("$.contactPhone").value(DEFAULT_CONTACT_PHONE))
            .andExpect(jsonPath("$.contactEmail").value(DEFAULT_CONTACT_EMAIL))
            .andExpect(jsonPath("$.specialRequests").value(DEFAULT_SPECIAL_REQUESTS))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.expiresAt").value(DEFAULT_EXPIRES_AT.toString()));
    }

    @Test
    @Transactional
    void getBookingsByIdFiltering() throws Exception {
        // Initialize the database
        insertedBooking = bookingRepository.saveAndFlush(booking);

        Long id = booking.getId();

        defaultBookingFiltering("id.equals=" + id, "id.notEquals=" + id);

        defaultBookingFiltering("id.greaterThanOrEqual=" + id, "id.greaterThan=" + id);

        defaultBookingFiltering("id.lessThanOrEqual=" + id, "id.lessThan=" + id);
    }

    @Test
    @Transactional
    void getAllBookingsByUserIdIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedBooking = bookingRepository.saveAndFlush(booking);

        // Get all the bookingList where userId equals to
        defaultBookingFiltering("userId.equals=" + DEFAULT_USER_ID, "userId.equals=" + UPDATED_USER_ID);
    }

    @Test
    @Transactional
    void getAllBookingsByUserIdIsInShouldWork() throws Exception {
        // Initialize the database
        insertedBooking = bookingRepository.saveAndFlush(booking);

        // Get all the bookingList where userId in
        defaultBookingFiltering("userId.in=" + DEFAULT_USER_ID + "," + UPDATED_USER_ID, "userId.in=" + UPDATED_USER_ID);
    }

    @Test
    @Transactional
    void getAllBookingsByUserIdIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedBooking = bookingRepository.saveAndFlush(booking);

        // Get all the bookingList where userId is not null
        defaultBookingFiltering("userId.specified=true", "userId.specified=false");
    }

    @Test
    @Transactional
    void getAllBookingsByTripIdIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedBooking = bookingRepository.saveAndFlush(booking);

        // Get all the bookingList where tripId equals to
        defaultBookingFiltering("tripId.equals=" + DEFAULT_TRIP_ID, "tripId.equals=" + UPDATED_TRIP_ID);
    }

    @Test
    @Transactional
    void getAllBookingsByTripIdIsInShouldWork() throws Exception {
        // Initialize the database
        insertedBooking = bookingRepository.saveAndFlush(booking);

        // Get all the bookingList where tripId in
        defaultBookingFiltering("tripId.in=" + DEFAULT_TRIP_ID + "," + UPDATED_TRIP_ID, "tripId.in=" + UPDATED_TRIP_ID);
    }

    @Test
    @Transactional
    void getAllBookingsByTripIdIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedBooking = bookingRepository.saveAndFlush(booking);

        // Get all the bookingList where tripId is not null
        defaultBookingFiltering("tripId.specified=true", "tripId.specified=false");
    }

    @Test
    @Transactional
    void getAllBookingsByBookingReferenceIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedBooking = bookingRepository.saveAndFlush(booking);

        // Get all the bookingList where bookingReference equals to
        defaultBookingFiltering(
            "bookingReference.equals=" + DEFAULT_BOOKING_REFERENCE,
            "bookingReference.equals=" + UPDATED_BOOKING_REFERENCE
        );
    }

    @Test
    @Transactional
    void getAllBookingsByBookingReferenceIsInShouldWork() throws Exception {
        // Initialize the database
        insertedBooking = bookingRepository.saveAndFlush(booking);

        // Get all the bookingList where bookingReference in
        defaultBookingFiltering(
            "bookingReference.in=" + DEFAULT_BOOKING_REFERENCE + "," + UPDATED_BOOKING_REFERENCE,
            "bookingReference.in=" + UPDATED_BOOKING_REFERENCE
        );
    }

    @Test
    @Transactional
    void getAllBookingsByBookingReferenceIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedBooking = bookingRepository.saveAndFlush(booking);

        // Get all the bookingList where bookingReference is not null
        defaultBookingFiltering("bookingReference.specified=true", "bookingReference.specified=false");
    }

    @Test
    @Transactional
    void getAllBookingsByBookingReferenceContainsSomething() throws Exception {
        // Initialize the database
        insertedBooking = bookingRepository.saveAndFlush(booking);

        // Get all the bookingList where bookingReference contains
        defaultBookingFiltering(
            "bookingReference.contains=" + DEFAULT_BOOKING_REFERENCE,
            "bookingReference.contains=" + UPDATED_BOOKING_REFERENCE
        );
    }

    @Test
    @Transactional
    void getAllBookingsByBookingReferenceNotContainsSomething() throws Exception {
        // Initialize the database
        insertedBooking = bookingRepository.saveAndFlush(booking);

        // Get all the bookingList where bookingReference does not contain
        defaultBookingFiltering(
            "bookingReference.doesNotContain=" + UPDATED_BOOKING_REFERENCE,
            "bookingReference.doesNotContain=" + DEFAULT_BOOKING_REFERENCE
        );
    }

    @Test
    @Transactional
    void getAllBookingsByStatusIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedBooking = bookingRepository.saveAndFlush(booking);

        // Get all the bookingList where status equals to
        defaultBookingFiltering("status.equals=" + DEFAULT_STATUS, "status.equals=" + UPDATED_STATUS);
    }

    @Test
    @Transactional
    void getAllBookingsByStatusIsInShouldWork() throws Exception {
        // Initialize the database
        insertedBooking = bookingRepository.saveAndFlush(booking);

        // Get all the bookingList where status in
        defaultBookingFiltering("status.in=" + DEFAULT_STATUS + "," + UPDATED_STATUS, "status.in=" + UPDATED_STATUS);
    }

    @Test
    @Transactional
    void getAllBookingsByStatusIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedBooking = bookingRepository.saveAndFlush(booking);

        // Get all the bookingList where status is not null
        defaultBookingFiltering("status.specified=true", "status.specified=false");
    }

    @Test
    @Transactional
    void getAllBookingsByTotalAmountIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedBooking = bookingRepository.saveAndFlush(booking);

        // Get all the bookingList where totalAmount equals to
        defaultBookingFiltering("totalAmount.equals=" + DEFAULT_TOTAL_AMOUNT, "totalAmount.equals=" + UPDATED_TOTAL_AMOUNT);
    }

    @Test
    @Transactional
    void getAllBookingsByTotalAmountIsInShouldWork() throws Exception {
        // Initialize the database
        insertedBooking = bookingRepository.saveAndFlush(booking);

        // Get all the bookingList where totalAmount in
        defaultBookingFiltering(
            "totalAmount.in=" + DEFAULT_TOTAL_AMOUNT + "," + UPDATED_TOTAL_AMOUNT,
            "totalAmount.in=" + UPDATED_TOTAL_AMOUNT
        );
    }

    @Test
    @Transactional
    void getAllBookingsByTotalAmountIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedBooking = bookingRepository.saveAndFlush(booking);

        // Get all the bookingList where totalAmount is not null
        defaultBookingFiltering("totalAmount.specified=true", "totalAmount.specified=false");
    }

    @Test
    @Transactional
    void getAllBookingsByTotalAmountIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedBooking = bookingRepository.saveAndFlush(booking);

        // Get all the bookingList where totalAmount is greater than or equal to
        defaultBookingFiltering(
            "totalAmount.greaterThanOrEqual=" + DEFAULT_TOTAL_AMOUNT,
            "totalAmount.greaterThanOrEqual=" + UPDATED_TOTAL_AMOUNT
        );
    }

    @Test
    @Transactional
    void getAllBookingsByTotalAmountIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedBooking = bookingRepository.saveAndFlush(booking);

        // Get all the bookingList where totalAmount is less than or equal to
        defaultBookingFiltering(
            "totalAmount.lessThanOrEqual=" + DEFAULT_TOTAL_AMOUNT,
            "totalAmount.lessThanOrEqual=" + SMALLER_TOTAL_AMOUNT
        );
    }

    @Test
    @Transactional
    void getAllBookingsByTotalAmountIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedBooking = bookingRepository.saveAndFlush(booking);

        // Get all the bookingList where totalAmount is less than
        defaultBookingFiltering("totalAmount.lessThan=" + UPDATED_TOTAL_AMOUNT, "totalAmount.lessThan=" + DEFAULT_TOTAL_AMOUNT);
    }

    @Test
    @Transactional
    void getAllBookingsByTotalAmountIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedBooking = bookingRepository.saveAndFlush(booking);

        // Get all the bookingList where totalAmount is greater than
        defaultBookingFiltering("totalAmount.greaterThan=" + SMALLER_TOTAL_AMOUNT, "totalAmount.greaterThan=" + DEFAULT_TOTAL_AMOUNT);
    }

    @Test
    @Transactional
    void getAllBookingsByContactPhoneIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedBooking = bookingRepository.saveAndFlush(booking);

        // Get all the bookingList where contactPhone equals to
        defaultBookingFiltering("contactPhone.equals=" + DEFAULT_CONTACT_PHONE, "contactPhone.equals=" + UPDATED_CONTACT_PHONE);
    }

    @Test
    @Transactional
    void getAllBookingsByContactPhoneIsInShouldWork() throws Exception {
        // Initialize the database
        insertedBooking = bookingRepository.saveAndFlush(booking);

        // Get all the bookingList where contactPhone in
        defaultBookingFiltering(
            "contactPhone.in=" + DEFAULT_CONTACT_PHONE + "," + UPDATED_CONTACT_PHONE,
            "contactPhone.in=" + UPDATED_CONTACT_PHONE
        );
    }

    @Test
    @Transactional
    void getAllBookingsByContactPhoneIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedBooking = bookingRepository.saveAndFlush(booking);

        // Get all the bookingList where contactPhone is not null
        defaultBookingFiltering("contactPhone.specified=true", "contactPhone.specified=false");
    }

    @Test
    @Transactional
    void getAllBookingsByContactPhoneContainsSomething() throws Exception {
        // Initialize the database
        insertedBooking = bookingRepository.saveAndFlush(booking);

        // Get all the bookingList where contactPhone contains
        defaultBookingFiltering("contactPhone.contains=" + DEFAULT_CONTACT_PHONE, "contactPhone.contains=" + UPDATED_CONTACT_PHONE);
    }

    @Test
    @Transactional
    void getAllBookingsByContactPhoneNotContainsSomething() throws Exception {
        // Initialize the database
        insertedBooking = bookingRepository.saveAndFlush(booking);

        // Get all the bookingList where contactPhone does not contain
        defaultBookingFiltering(
            "contactPhone.doesNotContain=" + UPDATED_CONTACT_PHONE,
            "contactPhone.doesNotContain=" + DEFAULT_CONTACT_PHONE
        );
    }

    @Test
    @Transactional
    void getAllBookingsByContactEmailIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedBooking = bookingRepository.saveAndFlush(booking);

        // Get all the bookingList where contactEmail equals to
        defaultBookingFiltering("contactEmail.equals=" + DEFAULT_CONTACT_EMAIL, "contactEmail.equals=" + UPDATED_CONTACT_EMAIL);
    }

    @Test
    @Transactional
    void getAllBookingsByContactEmailIsInShouldWork() throws Exception {
        // Initialize the database
        insertedBooking = bookingRepository.saveAndFlush(booking);

        // Get all the bookingList where contactEmail in
        defaultBookingFiltering(
            "contactEmail.in=" + DEFAULT_CONTACT_EMAIL + "," + UPDATED_CONTACT_EMAIL,
            "contactEmail.in=" + UPDATED_CONTACT_EMAIL
        );
    }

    @Test
    @Transactional
    void getAllBookingsByContactEmailIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedBooking = bookingRepository.saveAndFlush(booking);

        // Get all the bookingList where contactEmail is not null
        defaultBookingFiltering("contactEmail.specified=true", "contactEmail.specified=false");
    }

    @Test
    @Transactional
    void getAllBookingsByContactEmailContainsSomething() throws Exception {
        // Initialize the database
        insertedBooking = bookingRepository.saveAndFlush(booking);

        // Get all the bookingList where contactEmail contains
        defaultBookingFiltering("contactEmail.contains=" + DEFAULT_CONTACT_EMAIL, "contactEmail.contains=" + UPDATED_CONTACT_EMAIL);
    }

    @Test
    @Transactional
    void getAllBookingsByContactEmailNotContainsSomething() throws Exception {
        // Initialize the database
        insertedBooking = bookingRepository.saveAndFlush(booking);

        // Get all the bookingList where contactEmail does not contain
        defaultBookingFiltering(
            "contactEmail.doesNotContain=" + UPDATED_CONTACT_EMAIL,
            "contactEmail.doesNotContain=" + DEFAULT_CONTACT_EMAIL
        );
    }

    @Test
    @Transactional
    void getAllBookingsBySpecialRequestsIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedBooking = bookingRepository.saveAndFlush(booking);

        // Get all the bookingList where specialRequests equals to
        defaultBookingFiltering("specialRequests.equals=" + DEFAULT_SPECIAL_REQUESTS, "specialRequests.equals=" + UPDATED_SPECIAL_REQUESTS);
    }

    @Test
    @Transactional
    void getAllBookingsBySpecialRequestsIsInShouldWork() throws Exception {
        // Initialize the database
        insertedBooking = bookingRepository.saveAndFlush(booking);

        // Get all the bookingList where specialRequests in
        defaultBookingFiltering(
            "specialRequests.in=" + DEFAULT_SPECIAL_REQUESTS + "," + UPDATED_SPECIAL_REQUESTS,
            "specialRequests.in=" + UPDATED_SPECIAL_REQUESTS
        );
    }

    @Test
    @Transactional
    void getAllBookingsBySpecialRequestsIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedBooking = bookingRepository.saveAndFlush(booking);

        // Get all the bookingList where specialRequests is not null
        defaultBookingFiltering("specialRequests.specified=true", "specialRequests.specified=false");
    }

    @Test
    @Transactional
    void getAllBookingsBySpecialRequestsContainsSomething() throws Exception {
        // Initialize the database
        insertedBooking = bookingRepository.saveAndFlush(booking);

        // Get all the bookingList where specialRequests contains
        defaultBookingFiltering(
            "specialRequests.contains=" + DEFAULT_SPECIAL_REQUESTS,
            "specialRequests.contains=" + UPDATED_SPECIAL_REQUESTS
        );
    }

    @Test
    @Transactional
    void getAllBookingsBySpecialRequestsNotContainsSomething() throws Exception {
        // Initialize the database
        insertedBooking = bookingRepository.saveAndFlush(booking);

        // Get all the bookingList where specialRequests does not contain
        defaultBookingFiltering(
            "specialRequests.doesNotContain=" + UPDATED_SPECIAL_REQUESTS,
            "specialRequests.doesNotContain=" + DEFAULT_SPECIAL_REQUESTS
        );
    }

    @Test
    @Transactional
    void getAllBookingsByCreatedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedBooking = bookingRepository.saveAndFlush(booking);

        // Get all the bookingList where createdAt equals to
        defaultBookingFiltering("createdAt.equals=" + DEFAULT_CREATED_AT, "createdAt.equals=" + UPDATED_CREATED_AT);
    }

    @Test
    @Transactional
    void getAllBookingsByCreatedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedBooking = bookingRepository.saveAndFlush(booking);

        // Get all the bookingList where createdAt in
        defaultBookingFiltering("createdAt.in=" + DEFAULT_CREATED_AT + "," + UPDATED_CREATED_AT, "createdAt.in=" + UPDATED_CREATED_AT);
    }

    @Test
    @Transactional
    void getAllBookingsByCreatedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedBooking = bookingRepository.saveAndFlush(booking);

        // Get all the bookingList where createdAt is not null
        defaultBookingFiltering("createdAt.specified=true", "createdAt.specified=false");
    }

    @Test
    @Transactional
    void getAllBookingsByExpiresAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedBooking = bookingRepository.saveAndFlush(booking);

        // Get all the bookingList where expiresAt equals to
        defaultBookingFiltering("expiresAt.equals=" + DEFAULT_EXPIRES_AT, "expiresAt.equals=" + UPDATED_EXPIRES_AT);
    }

    @Test
    @Transactional
    void getAllBookingsByExpiresAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedBooking = bookingRepository.saveAndFlush(booking);

        // Get all the bookingList where expiresAt in
        defaultBookingFiltering("expiresAt.in=" + DEFAULT_EXPIRES_AT + "," + UPDATED_EXPIRES_AT, "expiresAt.in=" + UPDATED_EXPIRES_AT);
    }

    @Test
    @Transactional
    void getAllBookingsByExpiresAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedBooking = bookingRepository.saveAndFlush(booking);

        // Get all the bookingList where expiresAt is not null
        defaultBookingFiltering("expiresAt.specified=true", "expiresAt.specified=false");
    }

    private void defaultBookingFiltering(String shouldBeFound, String shouldNotBeFound) throws Exception {
        defaultBookingShouldBeFound(shouldBeFound);
        defaultBookingShouldNotBeFound(shouldNotBeFound);
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultBookingShouldBeFound(String filter) throws Exception {
        restBookingMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(booking.getId().intValue())))
            .andExpect(jsonPath("$.[*].userId").value(hasItem(DEFAULT_USER_ID.toString())))
            .andExpect(jsonPath("$.[*].tripId").value(hasItem(DEFAULT_TRIP_ID.toString())))
            .andExpect(jsonPath("$.[*].bookingReference").value(hasItem(DEFAULT_BOOKING_REFERENCE)))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS.toString())))
            .andExpect(jsonPath("$.[*].totalAmount").value(hasItem(sameNumber(DEFAULT_TOTAL_AMOUNT))))
            .andExpect(jsonPath("$.[*].contactPhone").value(hasItem(DEFAULT_CONTACT_PHONE)))
            .andExpect(jsonPath("$.[*].contactEmail").value(hasItem(DEFAULT_CONTACT_EMAIL)))
            .andExpect(jsonPath("$.[*].specialRequests").value(hasItem(DEFAULT_SPECIAL_REQUESTS)))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].expiresAt").value(hasItem(DEFAULT_EXPIRES_AT.toString())));

        // Check, that the count call also returns 1
        restBookingMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("1"));
    }

    /**
     * Executes the search, and checks that the default entity is not returned.
     */
    private void defaultBookingShouldNotBeFound(String filter) throws Exception {
        restBookingMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());

        // Check, that the count call also returns 0
        restBookingMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("0"));
    }

    @Test
    @Transactional
    void getNonExistingBooking() throws Exception {
        // Get the booking
        restBookingMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingBooking() throws Exception {
        // Initialize the database
        insertedBooking = bookingRepository.saveAndFlush(booking);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the booking
        Booking updatedBooking = bookingRepository.findById(booking.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedBooking are not directly saved in db
        em.detach(updatedBooking);
        updatedBooking
            .userId(UPDATED_USER_ID)
            .tripId(UPDATED_TRIP_ID)
            .bookingReference(UPDATED_BOOKING_REFERENCE)
            .status(UPDATED_STATUS)
            .totalAmount(UPDATED_TOTAL_AMOUNT)
            .contactPhone(UPDATED_CONTACT_PHONE)
            .contactEmail(UPDATED_CONTACT_EMAIL)
            .specialRequests(UPDATED_SPECIAL_REQUESTS)
            .createdAt(UPDATED_CREATED_AT)
            .expiresAt(UPDATED_EXPIRES_AT);
        BookingDTO bookingDTO = bookingMapper.toDto(updatedBooking);

        restBookingMockMvc
            .perform(
                put(ENTITY_API_URL_ID, bookingDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(bookingDTO))
            )
            .andExpect(status().isOk());

        // Validate the Booking in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedBookingToMatchAllProperties(updatedBooking);
    }

    @Test
    @Transactional
    void putNonExistingBooking() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        booking.setId(longCount.incrementAndGet());

        // Create the Booking
        BookingDTO bookingDTO = bookingMapper.toDto(booking);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restBookingMockMvc
            .perform(
                put(ENTITY_API_URL_ID, bookingDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(bookingDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Booking in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchBooking() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        booking.setId(longCount.incrementAndGet());

        // Create the Booking
        BookingDTO bookingDTO = bookingMapper.toDto(booking);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restBookingMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(bookingDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Booking in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamBooking() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        booking.setId(longCount.incrementAndGet());

        // Create the Booking
        BookingDTO bookingDTO = bookingMapper.toDto(booking);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restBookingMockMvc
            .perform(put(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(bookingDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Booking in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateBookingWithPatch() throws Exception {
        // Initialize the database
        insertedBooking = bookingRepository.saveAndFlush(booking);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the booking using partial update
        Booking partialUpdatedBooking = new Booking();
        partialUpdatedBooking.setId(booking.getId());

        partialUpdatedBooking
            .status(UPDATED_STATUS)
            .contactPhone(UPDATED_CONTACT_PHONE)
            .contactEmail(UPDATED_CONTACT_EMAIL)
            .specialRequests(UPDATED_SPECIAL_REQUESTS);

        restBookingMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedBooking.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedBooking))
            )
            .andExpect(status().isOk());

        // Validate the Booking in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertBookingUpdatableFieldsEquals(createUpdateProxyForBean(partialUpdatedBooking, booking), getPersistedBooking(booking));
    }

    @Test
    @Transactional
    void fullUpdateBookingWithPatch() throws Exception {
        // Initialize the database
        insertedBooking = bookingRepository.saveAndFlush(booking);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the booking using partial update
        Booking partialUpdatedBooking = new Booking();
        partialUpdatedBooking.setId(booking.getId());

        partialUpdatedBooking
            .userId(UPDATED_USER_ID)
            .tripId(UPDATED_TRIP_ID)
            .bookingReference(UPDATED_BOOKING_REFERENCE)
            .status(UPDATED_STATUS)
            .totalAmount(UPDATED_TOTAL_AMOUNT)
            .contactPhone(UPDATED_CONTACT_PHONE)
            .contactEmail(UPDATED_CONTACT_EMAIL)
            .specialRequests(UPDATED_SPECIAL_REQUESTS)
            .createdAt(UPDATED_CREATED_AT)
            .expiresAt(UPDATED_EXPIRES_AT);

        restBookingMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedBooking.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedBooking))
            )
            .andExpect(status().isOk());

        // Validate the Booking in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertBookingUpdatableFieldsEquals(partialUpdatedBooking, getPersistedBooking(partialUpdatedBooking));
    }

    @Test
    @Transactional
    void patchNonExistingBooking() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        booking.setId(longCount.incrementAndGet());

        // Create the Booking
        BookingDTO bookingDTO = bookingMapper.toDto(booking);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restBookingMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, bookingDTO.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(bookingDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Booking in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchBooking() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        booking.setId(longCount.incrementAndGet());

        // Create the Booking
        BookingDTO bookingDTO = bookingMapper.toDto(booking);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restBookingMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(bookingDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Booking in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamBooking() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        booking.setId(longCount.incrementAndGet());

        // Create the Booking
        BookingDTO bookingDTO = bookingMapper.toDto(booking);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restBookingMockMvc
            .perform(
                patch(ENTITY_API_URL).with(csrf()).contentType("application/merge-patch+json").content(om.writeValueAsBytes(bookingDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the Booking in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteBooking() throws Exception {
        // Initialize the database
        insertedBooking = bookingRepository.saveAndFlush(booking);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the booking
        restBookingMockMvc
            .perform(delete(ENTITY_API_URL_ID, booking.getId()).with(csrf()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return bookingRepository.count();
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

    protected Booking getPersistedBooking(Booking booking) {
        return bookingRepository.findById(booking.getId()).orElseThrow();
    }

    protected void assertPersistedBookingToMatchAllProperties(Booking expectedBooking) {
        assertBookingAllPropertiesEquals(expectedBooking, getPersistedBooking(expectedBooking));
    }

    protected void assertPersistedBookingToMatchUpdatableProperties(Booking expectedBooking) {
        assertBookingAllUpdatablePropertiesEquals(expectedBooking, getPersistedBooking(expectedBooking));
    }
}
