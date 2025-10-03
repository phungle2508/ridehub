package com.ridehub.booking.web.rest;

import static com.ridehub.booking.domain.TicketAsserts.*;
import static com.ridehub.booking.web.rest.TestUtil.createUpdateProxyForBean;
import static com.ridehub.booking.web.rest.TestUtil.sameNumber;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ridehub.booking.IntegrationTest;
import com.ridehub.booking.domain.Booking;
import com.ridehub.booking.domain.FileBooking;
import com.ridehub.booking.domain.Ticket;
import com.ridehub.booking.repository.TicketRepository;
import com.ridehub.booking.service.dto.TicketDTO;
import com.ridehub.booking.service.mapper.TicketMapper;
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
 * Integration tests for the {@link TicketResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class TicketResourceIT {

    private static final String DEFAULT_TICKET_CODE = "AAAAAAAAAA";
    private static final String UPDATED_TICKET_CODE = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_PRICE = new BigDecimal(1);
    private static final BigDecimal UPDATED_PRICE = new BigDecimal(2);
    private static final BigDecimal SMALLER_PRICE = new BigDecimal(1 - 1);

    private static final String DEFAULT_QR_CODE = "AAAAAAAAAA";
    private static final String UPDATED_QR_CODE = "BBBBBBBBBB";

    private static final Instant DEFAULT_TIME_FROM = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_TIME_FROM = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_TIME_TO = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_TIME_TO = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Boolean DEFAULT_CHECKED_IN = false;
    private static final Boolean UPDATED_CHECKED_IN = true;

    private static final Long DEFAULT_TRIP_ID = 1L;
    private static final Long UPDATED_TRIP_ID = 2L;
    private static final Long SMALLER_TRIP_ID = 1L - 1L;

    private static final Long DEFAULT_ROUTE_ID = 1L;
    private static final Long UPDATED_ROUTE_ID = 2L;
    private static final Long SMALLER_ROUTE_ID = 1L - 1L;

    private static final Long DEFAULT_SEAT_ID = 1L;
    private static final Long UPDATED_SEAT_ID = 2L;
    private static final Long SMALLER_SEAT_ID = 1L - 1L;

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

    private static final String ENTITY_API_URL = "/api/tickets";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TicketMapper ticketMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restTicketMockMvc;

    private Ticket ticket;

    private Ticket insertedTicket;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Ticket createEntity(EntityManager em) {
        Ticket ticket = new Ticket()
            .ticketCode(DEFAULT_TICKET_CODE)
            .price(DEFAULT_PRICE)
            .qrCode(DEFAULT_QR_CODE)
            .timeFrom(DEFAULT_TIME_FROM)
            .timeTo(DEFAULT_TIME_TO)
            .checkedIn(DEFAULT_CHECKED_IN)
            .tripId(DEFAULT_TRIP_ID)
            .routeId(DEFAULT_ROUTE_ID)
            .seatId(DEFAULT_SEAT_ID)
            .createdAt(DEFAULT_CREATED_AT)
            .updatedAt(DEFAULT_UPDATED_AT)
            .isDeleted(DEFAULT_IS_DELETED)
            .deletedAt(DEFAULT_DELETED_AT)
            .deletedBy(DEFAULT_DELETED_BY);
        // Add required entity
        Booking booking;
        if (TestUtil.findAll(em, Booking.class).isEmpty()) {
            booking = BookingResourceIT.createEntity();
            em.persist(booking);
            em.flush();
        } else {
            booking = TestUtil.findAll(em, Booking.class).get(0);
        }
        ticket.setBooking(booking);
        return ticket;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Ticket createUpdatedEntity(EntityManager em) {
        Ticket updatedTicket = new Ticket()
            .ticketCode(UPDATED_TICKET_CODE)
            .price(UPDATED_PRICE)
            .qrCode(UPDATED_QR_CODE)
            .timeFrom(UPDATED_TIME_FROM)
            .timeTo(UPDATED_TIME_TO)
            .checkedIn(UPDATED_CHECKED_IN)
            .tripId(UPDATED_TRIP_ID)
            .routeId(UPDATED_ROUTE_ID)
            .seatId(UPDATED_SEAT_ID)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);
        // Add required entity
        Booking booking;
        if (TestUtil.findAll(em, Booking.class).isEmpty()) {
            booking = BookingResourceIT.createUpdatedEntity();
            em.persist(booking);
            em.flush();
        } else {
            booking = TestUtil.findAll(em, Booking.class).get(0);
        }
        updatedTicket.setBooking(booking);
        return updatedTicket;
    }

    @BeforeEach
    void initTest() {
        ticket = createEntity(em);
    }

    @AfterEach
    void cleanup() {
        if (insertedTicket != null) {
            ticketRepository.delete(insertedTicket);
            insertedTicket = null;
        }
    }

    @Test
    @Transactional
    void createTicket() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the Ticket
        TicketDTO ticketDTO = ticketMapper.toDto(ticket);
        var returnedTicketDTO = om.readValue(
            restTicketMockMvc
                .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(ticketDTO)))
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            TicketDTO.class
        );

        // Validate the Ticket in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        var returnedTicket = ticketMapper.toEntity(returnedTicketDTO);
        assertTicketUpdatableFieldsEquals(returnedTicket, getPersistedTicket(returnedTicket));

        insertedTicket = returnedTicket;
    }

    @Test
    @Transactional
    void createTicketWithExistingId() throws Exception {
        // Create the Ticket with an existing ID
        ticket.setId(1L);
        TicketDTO ticketDTO = ticketMapper.toDto(ticket);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restTicketMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(ticketDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Ticket in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkTicketCodeIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        ticket.setTicketCode(null);

        // Create the Ticket, which fails.
        TicketDTO ticketDTO = ticketMapper.toDto(ticket);

        restTicketMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(ticketDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPriceIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        ticket.setPrice(null);

        // Create the Ticket, which fails.
        TicketDTO ticketDTO = ticketMapper.toDto(ticket);

        restTicketMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(ticketDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkTripIdIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        ticket.setTripId(null);

        // Create the Ticket, which fails.
        TicketDTO ticketDTO = ticketMapper.toDto(ticket);

        restTicketMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(ticketDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkRouteIdIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        ticket.setRouteId(null);

        // Create the Ticket, which fails.
        TicketDTO ticketDTO = ticketMapper.toDto(ticket);

        restTicketMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(ticketDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkSeatIdIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        ticket.setSeatId(null);

        // Create the Ticket, which fails.
        TicketDTO ticketDTO = ticketMapper.toDto(ticket);

        restTicketMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(ticketDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkCreatedAtIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        ticket.setCreatedAt(null);

        // Create the Ticket, which fails.
        TicketDTO ticketDTO = ticketMapper.toDto(ticket);

        restTicketMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(ticketDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllTickets() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList
        restTicketMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(ticket.getId().intValue())))
            .andExpect(jsonPath("$.[*].ticketCode").value(hasItem(DEFAULT_TICKET_CODE)))
            .andExpect(jsonPath("$.[*].price").value(hasItem(sameNumber(DEFAULT_PRICE))))
            .andExpect(jsonPath("$.[*].qrCode").value(hasItem(DEFAULT_QR_CODE)))
            .andExpect(jsonPath("$.[*].timeFrom").value(hasItem(DEFAULT_TIME_FROM.toString())))
            .andExpect(jsonPath("$.[*].timeTo").value(hasItem(DEFAULT_TIME_TO.toString())))
            .andExpect(jsonPath("$.[*].checkedIn").value(hasItem(DEFAULT_CHECKED_IN)))
            .andExpect(jsonPath("$.[*].tripId").value(hasItem(DEFAULT_TRIP_ID.intValue())))
            .andExpect(jsonPath("$.[*].routeId").value(hasItem(DEFAULT_ROUTE_ID.intValue())))
            .andExpect(jsonPath("$.[*].seatId").value(hasItem(DEFAULT_SEAT_ID.intValue())))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].isDeleted").value(hasItem(DEFAULT_IS_DELETED)))
            .andExpect(jsonPath("$.[*].deletedAt").value(hasItem(DEFAULT_DELETED_AT.toString())))
            .andExpect(jsonPath("$.[*].deletedBy").value(hasItem(DEFAULT_DELETED_BY.toString())));
    }

    @Test
    @Transactional
    void getTicket() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get the ticket
        restTicketMockMvc
            .perform(get(ENTITY_API_URL_ID, ticket.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(ticket.getId().intValue()))
            .andExpect(jsonPath("$.ticketCode").value(DEFAULT_TICKET_CODE))
            .andExpect(jsonPath("$.price").value(sameNumber(DEFAULT_PRICE)))
            .andExpect(jsonPath("$.qrCode").value(DEFAULT_QR_CODE))
            .andExpect(jsonPath("$.timeFrom").value(DEFAULT_TIME_FROM.toString()))
            .andExpect(jsonPath("$.timeTo").value(DEFAULT_TIME_TO.toString()))
            .andExpect(jsonPath("$.checkedIn").value(DEFAULT_CHECKED_IN))
            .andExpect(jsonPath("$.tripId").value(DEFAULT_TRIP_ID.intValue()))
            .andExpect(jsonPath("$.routeId").value(DEFAULT_ROUTE_ID.intValue()))
            .andExpect(jsonPath("$.seatId").value(DEFAULT_SEAT_ID.intValue()))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.updatedAt").value(DEFAULT_UPDATED_AT.toString()))
            .andExpect(jsonPath("$.isDeleted").value(DEFAULT_IS_DELETED))
            .andExpect(jsonPath("$.deletedAt").value(DEFAULT_DELETED_AT.toString()))
            .andExpect(jsonPath("$.deletedBy").value(DEFAULT_DELETED_BY.toString()));
    }

    @Test
    @Transactional
    void getTicketsByIdFiltering() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        Long id = ticket.getId();

        defaultTicketFiltering("id.equals=" + id, "id.notEquals=" + id);

        defaultTicketFiltering("id.greaterThanOrEqual=" + id, "id.greaterThan=" + id);

        defaultTicketFiltering("id.lessThanOrEqual=" + id, "id.lessThan=" + id);
    }

    @Test
    @Transactional
    void getAllTicketsByTicketCodeIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where ticketCode equals to
        defaultTicketFiltering("ticketCode.equals=" + DEFAULT_TICKET_CODE, "ticketCode.equals=" + UPDATED_TICKET_CODE);
    }

    @Test
    @Transactional
    void getAllTicketsByTicketCodeIsInShouldWork() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where ticketCode in
        defaultTicketFiltering("ticketCode.in=" + DEFAULT_TICKET_CODE + "," + UPDATED_TICKET_CODE, "ticketCode.in=" + UPDATED_TICKET_CODE);
    }

    @Test
    @Transactional
    void getAllTicketsByTicketCodeIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where ticketCode is not null
        defaultTicketFiltering("ticketCode.specified=true", "ticketCode.specified=false");
    }

    @Test
    @Transactional
    void getAllTicketsByTicketCodeContainsSomething() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where ticketCode contains
        defaultTicketFiltering("ticketCode.contains=" + DEFAULT_TICKET_CODE, "ticketCode.contains=" + UPDATED_TICKET_CODE);
    }

    @Test
    @Transactional
    void getAllTicketsByTicketCodeNotContainsSomething() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where ticketCode does not contain
        defaultTicketFiltering("ticketCode.doesNotContain=" + UPDATED_TICKET_CODE, "ticketCode.doesNotContain=" + DEFAULT_TICKET_CODE);
    }

    @Test
    @Transactional
    void getAllTicketsByPriceIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where price equals to
        defaultTicketFiltering("price.equals=" + DEFAULT_PRICE, "price.equals=" + UPDATED_PRICE);
    }

    @Test
    @Transactional
    void getAllTicketsByPriceIsInShouldWork() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where price in
        defaultTicketFiltering("price.in=" + DEFAULT_PRICE + "," + UPDATED_PRICE, "price.in=" + UPDATED_PRICE);
    }

    @Test
    @Transactional
    void getAllTicketsByPriceIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where price is not null
        defaultTicketFiltering("price.specified=true", "price.specified=false");
    }

    @Test
    @Transactional
    void getAllTicketsByPriceIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where price is greater than or equal to
        defaultTicketFiltering("price.greaterThanOrEqual=" + DEFAULT_PRICE, "price.greaterThanOrEqual=" + UPDATED_PRICE);
    }

    @Test
    @Transactional
    void getAllTicketsByPriceIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where price is less than or equal to
        defaultTicketFiltering("price.lessThanOrEqual=" + DEFAULT_PRICE, "price.lessThanOrEqual=" + SMALLER_PRICE);
    }

    @Test
    @Transactional
    void getAllTicketsByPriceIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where price is less than
        defaultTicketFiltering("price.lessThan=" + UPDATED_PRICE, "price.lessThan=" + DEFAULT_PRICE);
    }

    @Test
    @Transactional
    void getAllTicketsByPriceIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where price is greater than
        defaultTicketFiltering("price.greaterThan=" + SMALLER_PRICE, "price.greaterThan=" + DEFAULT_PRICE);
    }

    @Test
    @Transactional
    void getAllTicketsByQrCodeIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where qrCode equals to
        defaultTicketFiltering("qrCode.equals=" + DEFAULT_QR_CODE, "qrCode.equals=" + UPDATED_QR_CODE);
    }

    @Test
    @Transactional
    void getAllTicketsByQrCodeIsInShouldWork() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where qrCode in
        defaultTicketFiltering("qrCode.in=" + DEFAULT_QR_CODE + "," + UPDATED_QR_CODE, "qrCode.in=" + UPDATED_QR_CODE);
    }

    @Test
    @Transactional
    void getAllTicketsByQrCodeIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where qrCode is not null
        defaultTicketFiltering("qrCode.specified=true", "qrCode.specified=false");
    }

    @Test
    @Transactional
    void getAllTicketsByQrCodeContainsSomething() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where qrCode contains
        defaultTicketFiltering("qrCode.contains=" + DEFAULT_QR_CODE, "qrCode.contains=" + UPDATED_QR_CODE);
    }

    @Test
    @Transactional
    void getAllTicketsByQrCodeNotContainsSomething() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where qrCode does not contain
        defaultTicketFiltering("qrCode.doesNotContain=" + UPDATED_QR_CODE, "qrCode.doesNotContain=" + DEFAULT_QR_CODE);
    }

    @Test
    @Transactional
    void getAllTicketsByTimeFromIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where timeFrom equals to
        defaultTicketFiltering("timeFrom.equals=" + DEFAULT_TIME_FROM, "timeFrom.equals=" + UPDATED_TIME_FROM);
    }

    @Test
    @Transactional
    void getAllTicketsByTimeFromIsInShouldWork() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where timeFrom in
        defaultTicketFiltering("timeFrom.in=" + DEFAULT_TIME_FROM + "," + UPDATED_TIME_FROM, "timeFrom.in=" + UPDATED_TIME_FROM);
    }

    @Test
    @Transactional
    void getAllTicketsByTimeFromIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where timeFrom is not null
        defaultTicketFiltering("timeFrom.specified=true", "timeFrom.specified=false");
    }

    @Test
    @Transactional
    void getAllTicketsByTimeToIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where timeTo equals to
        defaultTicketFiltering("timeTo.equals=" + DEFAULT_TIME_TO, "timeTo.equals=" + UPDATED_TIME_TO);
    }

    @Test
    @Transactional
    void getAllTicketsByTimeToIsInShouldWork() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where timeTo in
        defaultTicketFiltering("timeTo.in=" + DEFAULT_TIME_TO + "," + UPDATED_TIME_TO, "timeTo.in=" + UPDATED_TIME_TO);
    }

    @Test
    @Transactional
    void getAllTicketsByTimeToIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where timeTo is not null
        defaultTicketFiltering("timeTo.specified=true", "timeTo.specified=false");
    }

    @Test
    @Transactional
    void getAllTicketsByCheckedInIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where checkedIn equals to
        defaultTicketFiltering("checkedIn.equals=" + DEFAULT_CHECKED_IN, "checkedIn.equals=" + UPDATED_CHECKED_IN);
    }

    @Test
    @Transactional
    void getAllTicketsByCheckedInIsInShouldWork() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where checkedIn in
        defaultTicketFiltering("checkedIn.in=" + DEFAULT_CHECKED_IN + "," + UPDATED_CHECKED_IN, "checkedIn.in=" + UPDATED_CHECKED_IN);
    }

    @Test
    @Transactional
    void getAllTicketsByCheckedInIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where checkedIn is not null
        defaultTicketFiltering("checkedIn.specified=true", "checkedIn.specified=false");
    }

    @Test
    @Transactional
    void getAllTicketsByTripIdIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where tripId equals to
        defaultTicketFiltering("tripId.equals=" + DEFAULT_TRIP_ID, "tripId.equals=" + UPDATED_TRIP_ID);
    }

    @Test
    @Transactional
    void getAllTicketsByTripIdIsInShouldWork() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where tripId in
        defaultTicketFiltering("tripId.in=" + DEFAULT_TRIP_ID + "," + UPDATED_TRIP_ID, "tripId.in=" + UPDATED_TRIP_ID);
    }

    @Test
    @Transactional
    void getAllTicketsByTripIdIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where tripId is not null
        defaultTicketFiltering("tripId.specified=true", "tripId.specified=false");
    }

    @Test
    @Transactional
    void getAllTicketsByTripIdIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where tripId is greater than or equal to
        defaultTicketFiltering("tripId.greaterThanOrEqual=" + DEFAULT_TRIP_ID, "tripId.greaterThanOrEqual=" + UPDATED_TRIP_ID);
    }

    @Test
    @Transactional
    void getAllTicketsByTripIdIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where tripId is less than or equal to
        defaultTicketFiltering("tripId.lessThanOrEqual=" + DEFAULT_TRIP_ID, "tripId.lessThanOrEqual=" + SMALLER_TRIP_ID);
    }

    @Test
    @Transactional
    void getAllTicketsByTripIdIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where tripId is less than
        defaultTicketFiltering("tripId.lessThan=" + UPDATED_TRIP_ID, "tripId.lessThan=" + DEFAULT_TRIP_ID);
    }

    @Test
    @Transactional
    void getAllTicketsByTripIdIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where tripId is greater than
        defaultTicketFiltering("tripId.greaterThan=" + SMALLER_TRIP_ID, "tripId.greaterThan=" + DEFAULT_TRIP_ID);
    }

    @Test
    @Transactional
    void getAllTicketsByRouteIdIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where routeId equals to
        defaultTicketFiltering("routeId.equals=" + DEFAULT_ROUTE_ID, "routeId.equals=" + UPDATED_ROUTE_ID);
    }

    @Test
    @Transactional
    void getAllTicketsByRouteIdIsInShouldWork() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where routeId in
        defaultTicketFiltering("routeId.in=" + DEFAULT_ROUTE_ID + "," + UPDATED_ROUTE_ID, "routeId.in=" + UPDATED_ROUTE_ID);
    }

    @Test
    @Transactional
    void getAllTicketsByRouteIdIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where routeId is not null
        defaultTicketFiltering("routeId.specified=true", "routeId.specified=false");
    }

    @Test
    @Transactional
    void getAllTicketsByRouteIdIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where routeId is greater than or equal to
        defaultTicketFiltering("routeId.greaterThanOrEqual=" + DEFAULT_ROUTE_ID, "routeId.greaterThanOrEqual=" + UPDATED_ROUTE_ID);
    }

    @Test
    @Transactional
    void getAllTicketsByRouteIdIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where routeId is less than or equal to
        defaultTicketFiltering("routeId.lessThanOrEqual=" + DEFAULT_ROUTE_ID, "routeId.lessThanOrEqual=" + SMALLER_ROUTE_ID);
    }

    @Test
    @Transactional
    void getAllTicketsByRouteIdIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where routeId is less than
        defaultTicketFiltering("routeId.lessThan=" + UPDATED_ROUTE_ID, "routeId.lessThan=" + DEFAULT_ROUTE_ID);
    }

    @Test
    @Transactional
    void getAllTicketsByRouteIdIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where routeId is greater than
        defaultTicketFiltering("routeId.greaterThan=" + SMALLER_ROUTE_ID, "routeId.greaterThan=" + DEFAULT_ROUTE_ID);
    }

    @Test
    @Transactional
    void getAllTicketsBySeatIdIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where seatId equals to
        defaultTicketFiltering("seatId.equals=" + DEFAULT_SEAT_ID, "seatId.equals=" + UPDATED_SEAT_ID);
    }

    @Test
    @Transactional
    void getAllTicketsBySeatIdIsInShouldWork() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where seatId in
        defaultTicketFiltering("seatId.in=" + DEFAULT_SEAT_ID + "," + UPDATED_SEAT_ID, "seatId.in=" + UPDATED_SEAT_ID);
    }

    @Test
    @Transactional
    void getAllTicketsBySeatIdIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where seatId is not null
        defaultTicketFiltering("seatId.specified=true", "seatId.specified=false");
    }

    @Test
    @Transactional
    void getAllTicketsBySeatIdIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where seatId is greater than or equal to
        defaultTicketFiltering("seatId.greaterThanOrEqual=" + DEFAULT_SEAT_ID, "seatId.greaterThanOrEqual=" + UPDATED_SEAT_ID);
    }

    @Test
    @Transactional
    void getAllTicketsBySeatIdIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where seatId is less than or equal to
        defaultTicketFiltering("seatId.lessThanOrEqual=" + DEFAULT_SEAT_ID, "seatId.lessThanOrEqual=" + SMALLER_SEAT_ID);
    }

    @Test
    @Transactional
    void getAllTicketsBySeatIdIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where seatId is less than
        defaultTicketFiltering("seatId.lessThan=" + UPDATED_SEAT_ID, "seatId.lessThan=" + DEFAULT_SEAT_ID);
    }

    @Test
    @Transactional
    void getAllTicketsBySeatIdIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where seatId is greater than
        defaultTicketFiltering("seatId.greaterThan=" + SMALLER_SEAT_ID, "seatId.greaterThan=" + DEFAULT_SEAT_ID);
    }

    @Test
    @Transactional
    void getAllTicketsByCreatedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where createdAt equals to
        defaultTicketFiltering("createdAt.equals=" + DEFAULT_CREATED_AT, "createdAt.equals=" + UPDATED_CREATED_AT);
    }

    @Test
    @Transactional
    void getAllTicketsByCreatedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where createdAt in
        defaultTicketFiltering("createdAt.in=" + DEFAULT_CREATED_AT + "," + UPDATED_CREATED_AT, "createdAt.in=" + UPDATED_CREATED_AT);
    }

    @Test
    @Transactional
    void getAllTicketsByCreatedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where createdAt is not null
        defaultTicketFiltering("createdAt.specified=true", "createdAt.specified=false");
    }

    @Test
    @Transactional
    void getAllTicketsByUpdatedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where updatedAt equals to
        defaultTicketFiltering("updatedAt.equals=" + DEFAULT_UPDATED_AT, "updatedAt.equals=" + UPDATED_UPDATED_AT);
    }

    @Test
    @Transactional
    void getAllTicketsByUpdatedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where updatedAt in
        defaultTicketFiltering("updatedAt.in=" + DEFAULT_UPDATED_AT + "," + UPDATED_UPDATED_AT, "updatedAt.in=" + UPDATED_UPDATED_AT);
    }

    @Test
    @Transactional
    void getAllTicketsByUpdatedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where updatedAt is not null
        defaultTicketFiltering("updatedAt.specified=true", "updatedAt.specified=false");
    }

    @Test
    @Transactional
    void getAllTicketsByIsDeletedIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where isDeleted equals to
        defaultTicketFiltering("isDeleted.equals=" + DEFAULT_IS_DELETED, "isDeleted.equals=" + UPDATED_IS_DELETED);
    }

    @Test
    @Transactional
    void getAllTicketsByIsDeletedIsInShouldWork() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where isDeleted in
        defaultTicketFiltering("isDeleted.in=" + DEFAULT_IS_DELETED + "," + UPDATED_IS_DELETED, "isDeleted.in=" + UPDATED_IS_DELETED);
    }

    @Test
    @Transactional
    void getAllTicketsByIsDeletedIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where isDeleted is not null
        defaultTicketFiltering("isDeleted.specified=true", "isDeleted.specified=false");
    }

    @Test
    @Transactional
    void getAllTicketsByDeletedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where deletedAt equals to
        defaultTicketFiltering("deletedAt.equals=" + DEFAULT_DELETED_AT, "deletedAt.equals=" + UPDATED_DELETED_AT);
    }

    @Test
    @Transactional
    void getAllTicketsByDeletedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where deletedAt in
        defaultTicketFiltering("deletedAt.in=" + DEFAULT_DELETED_AT + "," + UPDATED_DELETED_AT, "deletedAt.in=" + UPDATED_DELETED_AT);
    }

    @Test
    @Transactional
    void getAllTicketsByDeletedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where deletedAt is not null
        defaultTicketFiltering("deletedAt.specified=true", "deletedAt.specified=false");
    }

    @Test
    @Transactional
    void getAllTicketsByDeletedByIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where deletedBy equals to
        defaultTicketFiltering("deletedBy.equals=" + DEFAULT_DELETED_BY, "deletedBy.equals=" + UPDATED_DELETED_BY);
    }

    @Test
    @Transactional
    void getAllTicketsByDeletedByIsInShouldWork() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where deletedBy in
        defaultTicketFiltering("deletedBy.in=" + DEFAULT_DELETED_BY + "," + UPDATED_DELETED_BY, "deletedBy.in=" + UPDATED_DELETED_BY);
    }

    @Test
    @Transactional
    void getAllTicketsByDeletedByIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList where deletedBy is not null
        defaultTicketFiltering("deletedBy.specified=true", "deletedBy.specified=false");
    }

    @Test
    @Transactional
    void getAllTicketsByQrCodeImgIsEqualToSomething() throws Exception {
        FileBooking qrCodeImg;
        if (TestUtil.findAll(em, FileBooking.class).isEmpty()) {
            ticketRepository.saveAndFlush(ticket);
            qrCodeImg = FileBookingResourceIT.createEntity();
        } else {
            qrCodeImg = TestUtil.findAll(em, FileBooking.class).get(0);
        }
        em.persist(qrCodeImg);
        em.flush();
        ticket.setQrCodeImg(qrCodeImg);
        ticketRepository.saveAndFlush(ticket);
        Long qrCodeImgId = qrCodeImg.getId();
        // Get all the ticketList where qrCodeImg equals to qrCodeImgId
        defaultTicketShouldBeFound("qrCodeImgId.equals=" + qrCodeImgId);

        // Get all the ticketList where qrCodeImg equals to (qrCodeImgId + 1)
        defaultTicketShouldNotBeFound("qrCodeImgId.equals=" + (qrCodeImgId + 1));
    }

    @Test
    @Transactional
    void getAllTicketsByBookingIsEqualToSomething() throws Exception {
        Booking booking;
        if (TestUtil.findAll(em, Booking.class).isEmpty()) {
            ticketRepository.saveAndFlush(ticket);
            booking = BookingResourceIT.createEntity();
        } else {
            booking = TestUtil.findAll(em, Booking.class).get(0);
        }
        em.persist(booking);
        em.flush();
        ticket.setBooking(booking);
        ticketRepository.saveAndFlush(ticket);
        Long bookingId = booking.getId();
        // Get all the ticketList where booking equals to bookingId
        defaultTicketShouldBeFound("bookingId.equals=" + bookingId);

        // Get all the ticketList where booking equals to (bookingId + 1)
        defaultTicketShouldNotBeFound("bookingId.equals=" + (bookingId + 1));
    }

    private void defaultTicketFiltering(String shouldBeFound, String shouldNotBeFound) throws Exception {
        defaultTicketShouldBeFound(shouldBeFound);
        defaultTicketShouldNotBeFound(shouldNotBeFound);
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultTicketShouldBeFound(String filter) throws Exception {
        restTicketMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(ticket.getId().intValue())))
            .andExpect(jsonPath("$.[*].ticketCode").value(hasItem(DEFAULT_TICKET_CODE)))
            .andExpect(jsonPath("$.[*].price").value(hasItem(sameNumber(DEFAULT_PRICE))))
            .andExpect(jsonPath("$.[*].qrCode").value(hasItem(DEFAULT_QR_CODE)))
            .andExpect(jsonPath("$.[*].timeFrom").value(hasItem(DEFAULT_TIME_FROM.toString())))
            .andExpect(jsonPath("$.[*].timeTo").value(hasItem(DEFAULT_TIME_TO.toString())))
            .andExpect(jsonPath("$.[*].checkedIn").value(hasItem(DEFAULT_CHECKED_IN)))
            .andExpect(jsonPath("$.[*].tripId").value(hasItem(DEFAULT_TRIP_ID.intValue())))
            .andExpect(jsonPath("$.[*].routeId").value(hasItem(DEFAULT_ROUTE_ID.intValue())))
            .andExpect(jsonPath("$.[*].seatId").value(hasItem(DEFAULT_SEAT_ID.intValue())))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].isDeleted").value(hasItem(DEFAULT_IS_DELETED)))
            .andExpect(jsonPath("$.[*].deletedAt").value(hasItem(DEFAULT_DELETED_AT.toString())))
            .andExpect(jsonPath("$.[*].deletedBy").value(hasItem(DEFAULT_DELETED_BY.toString())));

        // Check, that the count call also returns 1
        restTicketMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("1"));
    }

    /**
     * Executes the search, and checks that the default entity is not returned.
     */
    private void defaultTicketShouldNotBeFound(String filter) throws Exception {
        restTicketMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());

        // Check, that the count call also returns 0
        restTicketMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("0"));
    }

    @Test
    @Transactional
    void getNonExistingTicket() throws Exception {
        // Get the ticket
        restTicketMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingTicket() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the ticket
        Ticket updatedTicket = ticketRepository.findById(ticket.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedTicket are not directly saved in db
        em.detach(updatedTicket);
        updatedTicket
            .ticketCode(UPDATED_TICKET_CODE)
            .price(UPDATED_PRICE)
            .qrCode(UPDATED_QR_CODE)
            .timeFrom(UPDATED_TIME_FROM)
            .timeTo(UPDATED_TIME_TO)
            .checkedIn(UPDATED_CHECKED_IN)
            .tripId(UPDATED_TRIP_ID)
            .routeId(UPDATED_ROUTE_ID)
            .seatId(UPDATED_SEAT_ID)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);
        TicketDTO ticketDTO = ticketMapper.toDto(updatedTicket);

        restTicketMockMvc
            .perform(
                put(ENTITY_API_URL_ID, ticketDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(ticketDTO))
            )
            .andExpect(status().isOk());

        // Validate the Ticket in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedTicketToMatchAllProperties(updatedTicket);
    }

    @Test
    @Transactional
    void putNonExistingTicket() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        ticket.setId(longCount.incrementAndGet());

        // Create the Ticket
        TicketDTO ticketDTO = ticketMapper.toDto(ticket);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restTicketMockMvc
            .perform(
                put(ENTITY_API_URL_ID, ticketDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(ticketDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Ticket in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchTicket() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        ticket.setId(longCount.incrementAndGet());

        // Create the Ticket
        TicketDTO ticketDTO = ticketMapper.toDto(ticket);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTicketMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(ticketDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Ticket in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamTicket() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        ticket.setId(longCount.incrementAndGet());

        // Create the Ticket
        TicketDTO ticketDTO = ticketMapper.toDto(ticket);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTicketMockMvc
            .perform(put(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(ticketDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Ticket in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateTicketWithPatch() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the ticket using partial update
        Ticket partialUpdatedTicket = new Ticket();
        partialUpdatedTicket.setId(ticket.getId());

        partialUpdatedTicket
            .ticketCode(UPDATED_TICKET_CODE)
            .qrCode(UPDATED_QR_CODE)
            .routeId(UPDATED_ROUTE_ID)
            .seatId(UPDATED_SEAT_ID)
            .deletedAt(UPDATED_DELETED_AT);

        restTicketMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedTicket.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedTicket))
            )
            .andExpect(status().isOk());

        // Validate the Ticket in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertTicketUpdatableFieldsEquals(createUpdateProxyForBean(partialUpdatedTicket, ticket), getPersistedTicket(ticket));
    }

    @Test
    @Transactional
    void fullUpdateTicketWithPatch() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the ticket using partial update
        Ticket partialUpdatedTicket = new Ticket();
        partialUpdatedTicket.setId(ticket.getId());

        partialUpdatedTicket
            .ticketCode(UPDATED_TICKET_CODE)
            .price(UPDATED_PRICE)
            .qrCode(UPDATED_QR_CODE)
            .timeFrom(UPDATED_TIME_FROM)
            .timeTo(UPDATED_TIME_TO)
            .checkedIn(UPDATED_CHECKED_IN)
            .tripId(UPDATED_TRIP_ID)
            .routeId(UPDATED_ROUTE_ID)
            .seatId(UPDATED_SEAT_ID)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);

        restTicketMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedTicket.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedTicket))
            )
            .andExpect(status().isOk());

        // Validate the Ticket in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertTicketUpdatableFieldsEquals(partialUpdatedTicket, getPersistedTicket(partialUpdatedTicket));
    }

    @Test
    @Transactional
    void patchNonExistingTicket() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        ticket.setId(longCount.incrementAndGet());

        // Create the Ticket
        TicketDTO ticketDTO = ticketMapper.toDto(ticket);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restTicketMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, ticketDTO.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(ticketDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Ticket in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchTicket() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        ticket.setId(longCount.incrementAndGet());

        // Create the Ticket
        TicketDTO ticketDTO = ticketMapper.toDto(ticket);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTicketMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(ticketDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Ticket in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamTicket() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        ticket.setId(longCount.incrementAndGet());

        // Create the Ticket
        TicketDTO ticketDTO = ticketMapper.toDto(ticket);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTicketMockMvc
            .perform(
                patch(ENTITY_API_URL).with(csrf()).contentType("application/merge-patch+json").content(om.writeValueAsBytes(ticketDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the Ticket in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteTicket() throws Exception {
        // Initialize the database
        insertedTicket = ticketRepository.saveAndFlush(ticket);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the ticket
        restTicketMockMvc
            .perform(delete(ENTITY_API_URL_ID, ticket.getId()).with(csrf()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return ticketRepository.count();
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

    protected Ticket getPersistedTicket(Ticket ticket) {
        return ticketRepository.findById(ticket.getId()).orElseThrow();
    }

    protected void assertPersistedTicketToMatchAllProperties(Ticket expectedTicket) {
        assertTicketAllPropertiesEquals(expectedTicket, getPersistedTicket(expectedTicket));
    }

    protected void assertPersistedTicketToMatchUpdatableProperties(Ticket expectedTicket) {
        assertTicketAllUpdatablePropertiesEquals(expectedTicket, getPersistedTicket(expectedTicket));
    }
}
