package com.ticketsystem.booking.web.rest;

import static com.ticketsystem.booking.domain.BookingHistoryAsserts.*;
import static com.ticketsystem.booking.web.rest.TestUtil.createUpdateProxyForBean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketsystem.booking.IntegrationTest;
import com.ticketsystem.booking.domain.Booking;
import com.ticketsystem.booking.domain.BookingHistory;
import com.ticketsystem.booking.domain.enumeration.BookingStatus;
import com.ticketsystem.booking.domain.enumeration.BookingStatus;
import com.ticketsystem.booking.repository.BookingHistoryRepository;
import com.ticketsystem.booking.service.dto.BookingHistoryDTO;
import com.ticketsystem.booking.service.mapper.BookingHistoryMapper;
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
 * Integration tests for the {@link BookingHistoryResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class BookingHistoryResourceIT {

    private static final BookingStatus DEFAULT_PREVIOUS_STATUS = BookingStatus.DRAFT;
    private static final BookingStatus UPDATED_PREVIOUS_STATUS = BookingStatus.PENDING_PAYMENT;

    private static final BookingStatus DEFAULT_NEW_STATUS = BookingStatus.DRAFT;
    private static final BookingStatus UPDATED_NEW_STATUS = BookingStatus.PENDING_PAYMENT;

    private static final String DEFAULT_REASON = "AAAAAAAAAA";
    private static final String UPDATED_REASON = "BBBBBBBBBB";

    private static final UUID DEFAULT_CHANGED_BY = UUID.randomUUID();
    private static final UUID UPDATED_CHANGED_BY = UUID.randomUUID();

    private static final Instant DEFAULT_CHANGED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CHANGED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String ENTITY_API_URL = "/api/booking-histories";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private BookingHistoryRepository bookingHistoryRepository;

    @Autowired
    private BookingHistoryMapper bookingHistoryMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restBookingHistoryMockMvc;

    private BookingHistory bookingHistory;

    private BookingHistory insertedBookingHistory;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static BookingHistory createEntity(EntityManager em) {
        BookingHistory bookingHistory = new BookingHistory()
            .previousStatus(DEFAULT_PREVIOUS_STATUS)
            .newStatus(DEFAULT_NEW_STATUS)
            .reason(DEFAULT_REASON)
            .changedBy(DEFAULT_CHANGED_BY)
            .changedAt(DEFAULT_CHANGED_AT);
        // Add required entity
        Booking booking;
        if (TestUtil.findAll(em, Booking.class).isEmpty()) {
            booking = BookingResourceIT.createEntity();
            em.persist(booking);
            em.flush();
        } else {
            booking = TestUtil.findAll(em, Booking.class).get(0);
        }
        bookingHistory.setBooking(booking);
        return bookingHistory;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static BookingHistory createUpdatedEntity(EntityManager em) {
        BookingHistory updatedBookingHistory = new BookingHistory()
            .previousStatus(UPDATED_PREVIOUS_STATUS)
            .newStatus(UPDATED_NEW_STATUS)
            .reason(UPDATED_REASON)
            .changedBy(UPDATED_CHANGED_BY)
            .changedAt(UPDATED_CHANGED_AT);
        // Add required entity
        Booking booking;
        if (TestUtil.findAll(em, Booking.class).isEmpty()) {
            booking = BookingResourceIT.createUpdatedEntity();
            em.persist(booking);
            em.flush();
        } else {
            booking = TestUtil.findAll(em, Booking.class).get(0);
        }
        updatedBookingHistory.setBooking(booking);
        return updatedBookingHistory;
    }

    @BeforeEach
    void initTest() {
        bookingHistory = createEntity(em);
    }

    @AfterEach
    void cleanup() {
        if (insertedBookingHistory != null) {
            bookingHistoryRepository.delete(insertedBookingHistory);
            insertedBookingHistory = null;
        }
    }

    @Test
    @Transactional
    void createBookingHistory() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the BookingHistory
        BookingHistoryDTO bookingHistoryDTO = bookingHistoryMapper.toDto(bookingHistory);
        var returnedBookingHistoryDTO = om.readValue(
            restBookingHistoryMockMvc
                .perform(
                    post(ENTITY_API_URL)
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsBytes(bookingHistoryDTO))
                )
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            BookingHistoryDTO.class
        );

        // Validate the BookingHistory in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        var returnedBookingHistory = bookingHistoryMapper.toEntity(returnedBookingHistoryDTO);
        assertBookingHistoryUpdatableFieldsEquals(returnedBookingHistory, getPersistedBookingHistory(returnedBookingHistory));

        insertedBookingHistory = returnedBookingHistory;
    }

    @Test
    @Transactional
    void createBookingHistoryWithExistingId() throws Exception {
        // Create the BookingHistory with an existing ID
        bookingHistory.setId(1L);
        BookingHistoryDTO bookingHistoryDTO = bookingHistoryMapper.toDto(bookingHistory);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restBookingHistoryMockMvc
            .perform(
                post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(bookingHistoryDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the BookingHistory in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkPreviousStatusIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        bookingHistory.setPreviousStatus(null);

        // Create the BookingHistory, which fails.
        BookingHistoryDTO bookingHistoryDTO = bookingHistoryMapper.toDto(bookingHistory);

        restBookingHistoryMockMvc
            .perform(
                post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(bookingHistoryDTO))
            )
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkNewStatusIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        bookingHistory.setNewStatus(null);

        // Create the BookingHistory, which fails.
        BookingHistoryDTO bookingHistoryDTO = bookingHistoryMapper.toDto(bookingHistory);

        restBookingHistoryMockMvc
            .perform(
                post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(bookingHistoryDTO))
            )
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkChangedAtIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        bookingHistory.setChangedAt(null);

        // Create the BookingHistory, which fails.
        BookingHistoryDTO bookingHistoryDTO = bookingHistoryMapper.toDto(bookingHistory);

        restBookingHistoryMockMvc
            .perform(
                post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(bookingHistoryDTO))
            )
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllBookingHistories() throws Exception {
        // Initialize the database
        insertedBookingHistory = bookingHistoryRepository.saveAndFlush(bookingHistory);

        // Get all the bookingHistoryList
        restBookingHistoryMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(bookingHistory.getId().intValue())))
            .andExpect(jsonPath("$.[*].previousStatus").value(hasItem(DEFAULT_PREVIOUS_STATUS.toString())))
            .andExpect(jsonPath("$.[*].newStatus").value(hasItem(DEFAULT_NEW_STATUS.toString())))
            .andExpect(jsonPath("$.[*].reason").value(hasItem(DEFAULT_REASON)))
            .andExpect(jsonPath("$.[*].changedBy").value(hasItem(DEFAULT_CHANGED_BY.toString())))
            .andExpect(jsonPath("$.[*].changedAt").value(hasItem(DEFAULT_CHANGED_AT.toString())));
    }

    @Test
    @Transactional
    void getBookingHistory() throws Exception {
        // Initialize the database
        insertedBookingHistory = bookingHistoryRepository.saveAndFlush(bookingHistory);

        // Get the bookingHistory
        restBookingHistoryMockMvc
            .perform(get(ENTITY_API_URL_ID, bookingHistory.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(bookingHistory.getId().intValue()))
            .andExpect(jsonPath("$.previousStatus").value(DEFAULT_PREVIOUS_STATUS.toString()))
            .andExpect(jsonPath("$.newStatus").value(DEFAULT_NEW_STATUS.toString()))
            .andExpect(jsonPath("$.reason").value(DEFAULT_REASON))
            .andExpect(jsonPath("$.changedBy").value(DEFAULT_CHANGED_BY.toString()))
            .andExpect(jsonPath("$.changedAt").value(DEFAULT_CHANGED_AT.toString()));
    }

    @Test
    @Transactional
    void getBookingHistoriesByIdFiltering() throws Exception {
        // Initialize the database
        insertedBookingHistory = bookingHistoryRepository.saveAndFlush(bookingHistory);

        Long id = bookingHistory.getId();

        defaultBookingHistoryFiltering("id.equals=" + id, "id.notEquals=" + id);

        defaultBookingHistoryFiltering("id.greaterThanOrEqual=" + id, "id.greaterThan=" + id);

        defaultBookingHistoryFiltering("id.lessThanOrEqual=" + id, "id.lessThan=" + id);
    }

    @Test
    @Transactional
    void getAllBookingHistoriesByPreviousStatusIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedBookingHistory = bookingHistoryRepository.saveAndFlush(bookingHistory);

        // Get all the bookingHistoryList where previousStatus equals to
        defaultBookingHistoryFiltering(
            "previousStatus.equals=" + DEFAULT_PREVIOUS_STATUS,
            "previousStatus.equals=" + UPDATED_PREVIOUS_STATUS
        );
    }

    @Test
    @Transactional
    void getAllBookingHistoriesByPreviousStatusIsInShouldWork() throws Exception {
        // Initialize the database
        insertedBookingHistory = bookingHistoryRepository.saveAndFlush(bookingHistory);

        // Get all the bookingHistoryList where previousStatus in
        defaultBookingHistoryFiltering(
            "previousStatus.in=" + DEFAULT_PREVIOUS_STATUS + "," + UPDATED_PREVIOUS_STATUS,
            "previousStatus.in=" + UPDATED_PREVIOUS_STATUS
        );
    }

    @Test
    @Transactional
    void getAllBookingHistoriesByPreviousStatusIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedBookingHistory = bookingHistoryRepository.saveAndFlush(bookingHistory);

        // Get all the bookingHistoryList where previousStatus is not null
        defaultBookingHistoryFiltering("previousStatus.specified=true", "previousStatus.specified=false");
    }

    @Test
    @Transactional
    void getAllBookingHistoriesByNewStatusIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedBookingHistory = bookingHistoryRepository.saveAndFlush(bookingHistory);

        // Get all the bookingHistoryList where newStatus equals to
        defaultBookingHistoryFiltering("newStatus.equals=" + DEFAULT_NEW_STATUS, "newStatus.equals=" + UPDATED_NEW_STATUS);
    }

    @Test
    @Transactional
    void getAllBookingHistoriesByNewStatusIsInShouldWork() throws Exception {
        // Initialize the database
        insertedBookingHistory = bookingHistoryRepository.saveAndFlush(bookingHistory);

        // Get all the bookingHistoryList where newStatus in
        defaultBookingHistoryFiltering(
            "newStatus.in=" + DEFAULT_NEW_STATUS + "," + UPDATED_NEW_STATUS,
            "newStatus.in=" + UPDATED_NEW_STATUS
        );
    }

    @Test
    @Transactional
    void getAllBookingHistoriesByNewStatusIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedBookingHistory = bookingHistoryRepository.saveAndFlush(bookingHistory);

        // Get all the bookingHistoryList where newStatus is not null
        defaultBookingHistoryFiltering("newStatus.specified=true", "newStatus.specified=false");
    }

    @Test
    @Transactional
    void getAllBookingHistoriesByReasonIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedBookingHistory = bookingHistoryRepository.saveAndFlush(bookingHistory);

        // Get all the bookingHistoryList where reason equals to
        defaultBookingHistoryFiltering("reason.equals=" + DEFAULT_REASON, "reason.equals=" + UPDATED_REASON);
    }

    @Test
    @Transactional
    void getAllBookingHistoriesByReasonIsInShouldWork() throws Exception {
        // Initialize the database
        insertedBookingHistory = bookingHistoryRepository.saveAndFlush(bookingHistory);

        // Get all the bookingHistoryList where reason in
        defaultBookingHistoryFiltering("reason.in=" + DEFAULT_REASON + "," + UPDATED_REASON, "reason.in=" + UPDATED_REASON);
    }

    @Test
    @Transactional
    void getAllBookingHistoriesByReasonIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedBookingHistory = bookingHistoryRepository.saveAndFlush(bookingHistory);

        // Get all the bookingHistoryList where reason is not null
        defaultBookingHistoryFiltering("reason.specified=true", "reason.specified=false");
    }

    @Test
    @Transactional
    void getAllBookingHistoriesByReasonContainsSomething() throws Exception {
        // Initialize the database
        insertedBookingHistory = bookingHistoryRepository.saveAndFlush(bookingHistory);

        // Get all the bookingHistoryList where reason contains
        defaultBookingHistoryFiltering("reason.contains=" + DEFAULT_REASON, "reason.contains=" + UPDATED_REASON);
    }

    @Test
    @Transactional
    void getAllBookingHistoriesByReasonNotContainsSomething() throws Exception {
        // Initialize the database
        insertedBookingHistory = bookingHistoryRepository.saveAndFlush(bookingHistory);

        // Get all the bookingHistoryList where reason does not contain
        defaultBookingHistoryFiltering("reason.doesNotContain=" + UPDATED_REASON, "reason.doesNotContain=" + DEFAULT_REASON);
    }

    @Test
    @Transactional
    void getAllBookingHistoriesByChangedByIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedBookingHistory = bookingHistoryRepository.saveAndFlush(bookingHistory);

        // Get all the bookingHistoryList where changedBy equals to
        defaultBookingHistoryFiltering("changedBy.equals=" + DEFAULT_CHANGED_BY, "changedBy.equals=" + UPDATED_CHANGED_BY);
    }

    @Test
    @Transactional
    void getAllBookingHistoriesByChangedByIsInShouldWork() throws Exception {
        // Initialize the database
        insertedBookingHistory = bookingHistoryRepository.saveAndFlush(bookingHistory);

        // Get all the bookingHistoryList where changedBy in
        defaultBookingHistoryFiltering(
            "changedBy.in=" + DEFAULT_CHANGED_BY + "," + UPDATED_CHANGED_BY,
            "changedBy.in=" + UPDATED_CHANGED_BY
        );
    }

    @Test
    @Transactional
    void getAllBookingHistoriesByChangedByIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedBookingHistory = bookingHistoryRepository.saveAndFlush(bookingHistory);

        // Get all the bookingHistoryList where changedBy is not null
        defaultBookingHistoryFiltering("changedBy.specified=true", "changedBy.specified=false");
    }

    @Test
    @Transactional
    void getAllBookingHistoriesByChangedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedBookingHistory = bookingHistoryRepository.saveAndFlush(bookingHistory);

        // Get all the bookingHistoryList where changedAt equals to
        defaultBookingHistoryFiltering("changedAt.equals=" + DEFAULT_CHANGED_AT, "changedAt.equals=" + UPDATED_CHANGED_AT);
    }

    @Test
    @Transactional
    void getAllBookingHistoriesByChangedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedBookingHistory = bookingHistoryRepository.saveAndFlush(bookingHistory);

        // Get all the bookingHistoryList where changedAt in
        defaultBookingHistoryFiltering(
            "changedAt.in=" + DEFAULT_CHANGED_AT + "," + UPDATED_CHANGED_AT,
            "changedAt.in=" + UPDATED_CHANGED_AT
        );
    }

    @Test
    @Transactional
    void getAllBookingHistoriesByChangedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedBookingHistory = bookingHistoryRepository.saveAndFlush(bookingHistory);

        // Get all the bookingHistoryList where changedAt is not null
        defaultBookingHistoryFiltering("changedAt.specified=true", "changedAt.specified=false");
    }

    @Test
    @Transactional
    void getAllBookingHistoriesByBookingIsEqualToSomething() throws Exception {
        Booking booking;
        if (TestUtil.findAll(em, Booking.class).isEmpty()) {
            bookingHistoryRepository.saveAndFlush(bookingHistory);
            booking = BookingResourceIT.createEntity();
        } else {
            booking = TestUtil.findAll(em, Booking.class).get(0);
        }
        em.persist(booking);
        em.flush();
        bookingHistory.setBooking(booking);
        bookingHistoryRepository.saveAndFlush(bookingHistory);
        Long bookingId = booking.getId();
        // Get all the bookingHistoryList where booking equals to bookingId
        defaultBookingHistoryShouldBeFound("bookingId.equals=" + bookingId);

        // Get all the bookingHistoryList where booking equals to (bookingId + 1)
        defaultBookingHistoryShouldNotBeFound("bookingId.equals=" + (bookingId + 1));
    }

    private void defaultBookingHistoryFiltering(String shouldBeFound, String shouldNotBeFound) throws Exception {
        defaultBookingHistoryShouldBeFound(shouldBeFound);
        defaultBookingHistoryShouldNotBeFound(shouldNotBeFound);
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultBookingHistoryShouldBeFound(String filter) throws Exception {
        restBookingHistoryMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(bookingHistory.getId().intValue())))
            .andExpect(jsonPath("$.[*].previousStatus").value(hasItem(DEFAULT_PREVIOUS_STATUS.toString())))
            .andExpect(jsonPath("$.[*].newStatus").value(hasItem(DEFAULT_NEW_STATUS.toString())))
            .andExpect(jsonPath("$.[*].reason").value(hasItem(DEFAULT_REASON)))
            .andExpect(jsonPath("$.[*].changedBy").value(hasItem(DEFAULT_CHANGED_BY.toString())))
            .andExpect(jsonPath("$.[*].changedAt").value(hasItem(DEFAULT_CHANGED_AT.toString())));

        // Check, that the count call also returns 1
        restBookingHistoryMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("1"));
    }

    /**
     * Executes the search, and checks that the default entity is not returned.
     */
    private void defaultBookingHistoryShouldNotBeFound(String filter) throws Exception {
        restBookingHistoryMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());

        // Check, that the count call also returns 0
        restBookingHistoryMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("0"));
    }

    @Test
    @Transactional
    void getNonExistingBookingHistory() throws Exception {
        // Get the bookingHistory
        restBookingHistoryMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingBookingHistory() throws Exception {
        // Initialize the database
        insertedBookingHistory = bookingHistoryRepository.saveAndFlush(bookingHistory);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the bookingHistory
        BookingHistory updatedBookingHistory = bookingHistoryRepository.findById(bookingHistory.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedBookingHistory are not directly saved in db
        em.detach(updatedBookingHistory);
        updatedBookingHistory
            .previousStatus(UPDATED_PREVIOUS_STATUS)
            .newStatus(UPDATED_NEW_STATUS)
            .reason(UPDATED_REASON)
            .changedBy(UPDATED_CHANGED_BY)
            .changedAt(UPDATED_CHANGED_AT);
        BookingHistoryDTO bookingHistoryDTO = bookingHistoryMapper.toDto(updatedBookingHistory);

        restBookingHistoryMockMvc
            .perform(
                put(ENTITY_API_URL_ID, bookingHistoryDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(bookingHistoryDTO))
            )
            .andExpect(status().isOk());

        // Validate the BookingHistory in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedBookingHistoryToMatchAllProperties(updatedBookingHistory);
    }

    @Test
    @Transactional
    void putNonExistingBookingHistory() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        bookingHistory.setId(longCount.incrementAndGet());

        // Create the BookingHistory
        BookingHistoryDTO bookingHistoryDTO = bookingHistoryMapper.toDto(bookingHistory);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restBookingHistoryMockMvc
            .perform(
                put(ENTITY_API_URL_ID, bookingHistoryDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(bookingHistoryDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the BookingHistory in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchBookingHistory() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        bookingHistory.setId(longCount.incrementAndGet());

        // Create the BookingHistory
        BookingHistoryDTO bookingHistoryDTO = bookingHistoryMapper.toDto(bookingHistory);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restBookingHistoryMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(bookingHistoryDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the BookingHistory in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamBookingHistory() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        bookingHistory.setId(longCount.incrementAndGet());

        // Create the BookingHistory
        BookingHistoryDTO bookingHistoryDTO = bookingHistoryMapper.toDto(bookingHistory);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restBookingHistoryMockMvc
            .perform(
                put(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(bookingHistoryDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the BookingHistory in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateBookingHistoryWithPatch() throws Exception {
        // Initialize the database
        insertedBookingHistory = bookingHistoryRepository.saveAndFlush(bookingHistory);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the bookingHistory using partial update
        BookingHistory partialUpdatedBookingHistory = new BookingHistory();
        partialUpdatedBookingHistory.setId(bookingHistory.getId());

        partialUpdatedBookingHistory
            .newStatus(UPDATED_NEW_STATUS)
            .reason(UPDATED_REASON)
            .changedBy(UPDATED_CHANGED_BY)
            .changedAt(UPDATED_CHANGED_AT);

        restBookingHistoryMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedBookingHistory.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedBookingHistory))
            )
            .andExpect(status().isOk());

        // Validate the BookingHistory in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertBookingHistoryUpdatableFieldsEquals(
            createUpdateProxyForBean(partialUpdatedBookingHistory, bookingHistory),
            getPersistedBookingHistory(bookingHistory)
        );
    }

    @Test
    @Transactional
    void fullUpdateBookingHistoryWithPatch() throws Exception {
        // Initialize the database
        insertedBookingHistory = bookingHistoryRepository.saveAndFlush(bookingHistory);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the bookingHistory using partial update
        BookingHistory partialUpdatedBookingHistory = new BookingHistory();
        partialUpdatedBookingHistory.setId(bookingHistory.getId());

        partialUpdatedBookingHistory
            .previousStatus(UPDATED_PREVIOUS_STATUS)
            .newStatus(UPDATED_NEW_STATUS)
            .reason(UPDATED_REASON)
            .changedBy(UPDATED_CHANGED_BY)
            .changedAt(UPDATED_CHANGED_AT);

        restBookingHistoryMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedBookingHistory.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedBookingHistory))
            )
            .andExpect(status().isOk());

        // Validate the BookingHistory in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertBookingHistoryUpdatableFieldsEquals(partialUpdatedBookingHistory, getPersistedBookingHistory(partialUpdatedBookingHistory));
    }

    @Test
    @Transactional
    void patchNonExistingBookingHistory() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        bookingHistory.setId(longCount.incrementAndGet());

        // Create the BookingHistory
        BookingHistoryDTO bookingHistoryDTO = bookingHistoryMapper.toDto(bookingHistory);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restBookingHistoryMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, bookingHistoryDTO.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(bookingHistoryDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the BookingHistory in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchBookingHistory() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        bookingHistory.setId(longCount.incrementAndGet());

        // Create the BookingHistory
        BookingHistoryDTO bookingHistoryDTO = bookingHistoryMapper.toDto(bookingHistory);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restBookingHistoryMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(bookingHistoryDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the BookingHistory in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamBookingHistory() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        bookingHistory.setId(longCount.incrementAndGet());

        // Create the BookingHistory
        BookingHistoryDTO bookingHistoryDTO = bookingHistoryMapper.toDto(bookingHistory);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restBookingHistoryMockMvc
            .perform(
                patch(ENTITY_API_URL)
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(bookingHistoryDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the BookingHistory in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteBookingHistory() throws Exception {
        // Initialize the database
        insertedBookingHistory = bookingHistoryRepository.saveAndFlush(bookingHistory);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the bookingHistory
        restBookingHistoryMockMvc
            .perform(delete(ENTITY_API_URL_ID, bookingHistory.getId()).with(csrf()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return bookingHistoryRepository.count();
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

    protected BookingHistory getPersistedBookingHistory(BookingHistory bookingHistory) {
        return bookingHistoryRepository.findById(bookingHistory.getId()).orElseThrow();
    }

    protected void assertPersistedBookingHistoryToMatchAllProperties(BookingHistory expectedBookingHistory) {
        assertBookingHistoryAllPropertiesEquals(expectedBookingHistory, getPersistedBookingHistory(expectedBookingHistory));
    }

    protected void assertPersistedBookingHistoryToMatchUpdatableProperties(BookingHistory expectedBookingHistory) {
        assertBookingHistoryAllUpdatablePropertiesEquals(expectedBookingHistory, getPersistedBookingHistory(expectedBookingHistory));
    }
}
