package com.ridehub.booking.web.rest;

import static com.ridehub.booking.domain.PaymentWebhookLogAsserts.*;
import static com.ridehub.booking.web.rest.TestUtil.createUpdateProxyForBean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ridehub.booking.IntegrationTest;
import com.ridehub.booking.domain.PaymentTransaction;
import com.ridehub.booking.domain.PaymentWebhookLog;
import com.ridehub.booking.repository.PaymentWebhookLogRepository;
import com.ridehub.booking.service.dto.PaymentWebhookLogDTO;
import com.ridehub.booking.service.mapper.PaymentWebhookLogMapper;
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
 * Integration tests for the {@link PaymentWebhookLogResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class PaymentWebhookLogResourceIT {

    private static final String DEFAULT_PROVIDER = "AAAAAAAAAA";
    private static final String UPDATED_PROVIDER = "BBBBBBBBBB";

    private static final String DEFAULT_PAYLOAD_HASH = "AAAAAAAAAA";
    private static final String UPDATED_PAYLOAD_HASH = "BBBBBBBBBB";

    private static final Instant DEFAULT_RECEIVED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_RECEIVED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_PROCESSING_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_PROCESSING_STATUS = "BBBBBBBBBB";

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

    private static final String ENTITY_API_URL = "/api/payment-webhook-logs";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private PaymentWebhookLogRepository paymentWebhookLogRepository;

    @Autowired
    private PaymentWebhookLogMapper paymentWebhookLogMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restPaymentWebhookLogMockMvc;

    private PaymentWebhookLog paymentWebhookLog;

    private PaymentWebhookLog insertedPaymentWebhookLog;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static PaymentWebhookLog createEntity(EntityManager em) {
        PaymentWebhookLog paymentWebhookLog = new PaymentWebhookLog()
            .provider(DEFAULT_PROVIDER)
            .payloadHash(DEFAULT_PAYLOAD_HASH)
            .receivedAt(DEFAULT_RECEIVED_AT)
            .processingStatus(DEFAULT_PROCESSING_STATUS)
            .createdAt(DEFAULT_CREATED_AT)
            .updatedAt(DEFAULT_UPDATED_AT)
            .isDeleted(DEFAULT_IS_DELETED)
            .deletedAt(DEFAULT_DELETED_AT)
            .deletedBy(DEFAULT_DELETED_BY);
        // Add required entity
        PaymentTransaction paymentTransaction;
        if (TestUtil.findAll(em, PaymentTransaction.class).isEmpty()) {
            paymentTransaction = PaymentTransactionResourceIT.createEntity();
            em.persist(paymentTransaction);
            em.flush();
        } else {
            paymentTransaction = TestUtil.findAll(em, PaymentTransaction.class).get(0);
        }
        paymentWebhookLog.setPaymentTransaction(paymentTransaction);
        return paymentWebhookLog;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static PaymentWebhookLog createUpdatedEntity(EntityManager em) {
        PaymentWebhookLog updatedPaymentWebhookLog = new PaymentWebhookLog()
            .provider(UPDATED_PROVIDER)
            .payloadHash(UPDATED_PAYLOAD_HASH)
            .receivedAt(UPDATED_RECEIVED_AT)
            .processingStatus(UPDATED_PROCESSING_STATUS)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);
        // Add required entity
        PaymentTransaction paymentTransaction;
        if (TestUtil.findAll(em, PaymentTransaction.class).isEmpty()) {
            paymentTransaction = PaymentTransactionResourceIT.createUpdatedEntity();
            em.persist(paymentTransaction);
            em.flush();
        } else {
            paymentTransaction = TestUtil.findAll(em, PaymentTransaction.class).get(0);
        }
        updatedPaymentWebhookLog.setPaymentTransaction(paymentTransaction);
        return updatedPaymentWebhookLog;
    }

    @BeforeEach
    void initTest() {
        paymentWebhookLog = createEntity(em);
    }

    @AfterEach
    void cleanup() {
        if (insertedPaymentWebhookLog != null) {
            paymentWebhookLogRepository.delete(insertedPaymentWebhookLog);
            insertedPaymentWebhookLog = null;
        }
    }

    @Test
    @Transactional
    void createPaymentWebhookLog() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the PaymentWebhookLog
        PaymentWebhookLogDTO paymentWebhookLogDTO = paymentWebhookLogMapper.toDto(paymentWebhookLog);
        var returnedPaymentWebhookLogDTO = om.readValue(
            restPaymentWebhookLogMockMvc
                .perform(
                    post(ENTITY_API_URL)
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsBytes(paymentWebhookLogDTO))
                )
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            PaymentWebhookLogDTO.class
        );

        // Validate the PaymentWebhookLog in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        var returnedPaymentWebhookLog = paymentWebhookLogMapper.toEntity(returnedPaymentWebhookLogDTO);
        assertPaymentWebhookLogUpdatableFieldsEquals(returnedPaymentWebhookLog, getPersistedPaymentWebhookLog(returnedPaymentWebhookLog));

        insertedPaymentWebhookLog = returnedPaymentWebhookLog;
    }

    @Test
    @Transactional
    void createPaymentWebhookLogWithExistingId() throws Exception {
        // Create the PaymentWebhookLog with an existing ID
        paymentWebhookLog.setId(1L);
        PaymentWebhookLogDTO paymentWebhookLogDTO = paymentWebhookLogMapper.toDto(paymentWebhookLog);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restPaymentWebhookLogMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(paymentWebhookLogDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the PaymentWebhookLog in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkPayloadHashIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        paymentWebhookLog.setPayloadHash(null);

        // Create the PaymentWebhookLog, which fails.
        PaymentWebhookLogDTO paymentWebhookLogDTO = paymentWebhookLogMapper.toDto(paymentWebhookLog);

        restPaymentWebhookLogMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(paymentWebhookLogDTO))
            )
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkReceivedAtIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        paymentWebhookLog.setReceivedAt(null);

        // Create the PaymentWebhookLog, which fails.
        PaymentWebhookLogDTO paymentWebhookLogDTO = paymentWebhookLogMapper.toDto(paymentWebhookLog);

        restPaymentWebhookLogMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(paymentWebhookLogDTO))
            )
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkCreatedAtIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        paymentWebhookLog.setCreatedAt(null);

        // Create the PaymentWebhookLog, which fails.
        PaymentWebhookLogDTO paymentWebhookLogDTO = paymentWebhookLogMapper.toDto(paymentWebhookLog);

        restPaymentWebhookLogMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(paymentWebhookLogDTO))
            )
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllPaymentWebhookLogs() throws Exception {
        // Initialize the database
        insertedPaymentWebhookLog = paymentWebhookLogRepository.saveAndFlush(paymentWebhookLog);

        // Get all the paymentWebhookLogList
        restPaymentWebhookLogMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(paymentWebhookLog.getId().intValue())))
            .andExpect(jsonPath("$.[*].provider").value(hasItem(DEFAULT_PROVIDER)))
            .andExpect(jsonPath("$.[*].payloadHash").value(hasItem(DEFAULT_PAYLOAD_HASH)))
            .andExpect(jsonPath("$.[*].receivedAt").value(hasItem(DEFAULT_RECEIVED_AT.toString())))
            .andExpect(jsonPath("$.[*].processingStatus").value(hasItem(DEFAULT_PROCESSING_STATUS)))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].isDeleted").value(hasItem(DEFAULT_IS_DELETED)))
            .andExpect(jsonPath("$.[*].deletedAt").value(hasItem(DEFAULT_DELETED_AT.toString())))
            .andExpect(jsonPath("$.[*].deletedBy").value(hasItem(DEFAULT_DELETED_BY.toString())));
    }

    @Test
    @Transactional
    void getPaymentWebhookLog() throws Exception {
        // Initialize the database
        insertedPaymentWebhookLog = paymentWebhookLogRepository.saveAndFlush(paymentWebhookLog);

        // Get the paymentWebhookLog
        restPaymentWebhookLogMockMvc
            .perform(get(ENTITY_API_URL_ID, paymentWebhookLog.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(paymentWebhookLog.getId().intValue()))
            .andExpect(jsonPath("$.provider").value(DEFAULT_PROVIDER))
            .andExpect(jsonPath("$.payloadHash").value(DEFAULT_PAYLOAD_HASH))
            .andExpect(jsonPath("$.receivedAt").value(DEFAULT_RECEIVED_AT.toString()))
            .andExpect(jsonPath("$.processingStatus").value(DEFAULT_PROCESSING_STATUS))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.updatedAt").value(DEFAULT_UPDATED_AT.toString()))
            .andExpect(jsonPath("$.isDeleted").value(DEFAULT_IS_DELETED))
            .andExpect(jsonPath("$.deletedAt").value(DEFAULT_DELETED_AT.toString()))
            .andExpect(jsonPath("$.deletedBy").value(DEFAULT_DELETED_BY.toString()));
    }

    @Test
    @Transactional
    void getPaymentWebhookLogsByIdFiltering() throws Exception {
        // Initialize the database
        insertedPaymentWebhookLog = paymentWebhookLogRepository.saveAndFlush(paymentWebhookLog);

        Long id = paymentWebhookLog.getId();

        defaultPaymentWebhookLogFiltering("id.equals=" + id, "id.notEquals=" + id);

        defaultPaymentWebhookLogFiltering("id.greaterThanOrEqual=" + id, "id.greaterThan=" + id);

        defaultPaymentWebhookLogFiltering("id.lessThanOrEqual=" + id, "id.lessThan=" + id);
    }

    @Test
    @Transactional
    void getAllPaymentWebhookLogsByProviderIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedPaymentWebhookLog = paymentWebhookLogRepository.saveAndFlush(paymentWebhookLog);

        // Get all the paymentWebhookLogList where provider equals to
        defaultPaymentWebhookLogFiltering("provider.equals=" + DEFAULT_PROVIDER, "provider.equals=" + UPDATED_PROVIDER);
    }

    @Test
    @Transactional
    void getAllPaymentWebhookLogsByProviderIsInShouldWork() throws Exception {
        // Initialize the database
        insertedPaymentWebhookLog = paymentWebhookLogRepository.saveAndFlush(paymentWebhookLog);

        // Get all the paymentWebhookLogList where provider in
        defaultPaymentWebhookLogFiltering("provider.in=" + DEFAULT_PROVIDER + "," + UPDATED_PROVIDER, "provider.in=" + UPDATED_PROVIDER);
    }

    @Test
    @Transactional
    void getAllPaymentWebhookLogsByProviderIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedPaymentWebhookLog = paymentWebhookLogRepository.saveAndFlush(paymentWebhookLog);

        // Get all the paymentWebhookLogList where provider is not null
        defaultPaymentWebhookLogFiltering("provider.specified=true", "provider.specified=false");
    }

    @Test
    @Transactional
    void getAllPaymentWebhookLogsByProviderContainsSomething() throws Exception {
        // Initialize the database
        insertedPaymentWebhookLog = paymentWebhookLogRepository.saveAndFlush(paymentWebhookLog);

        // Get all the paymentWebhookLogList where provider contains
        defaultPaymentWebhookLogFiltering("provider.contains=" + DEFAULT_PROVIDER, "provider.contains=" + UPDATED_PROVIDER);
    }

    @Test
    @Transactional
    void getAllPaymentWebhookLogsByProviderNotContainsSomething() throws Exception {
        // Initialize the database
        insertedPaymentWebhookLog = paymentWebhookLogRepository.saveAndFlush(paymentWebhookLog);

        // Get all the paymentWebhookLogList where provider does not contain
        defaultPaymentWebhookLogFiltering("provider.doesNotContain=" + UPDATED_PROVIDER, "provider.doesNotContain=" + DEFAULT_PROVIDER);
    }

    @Test
    @Transactional
    void getAllPaymentWebhookLogsByPayloadHashIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedPaymentWebhookLog = paymentWebhookLogRepository.saveAndFlush(paymentWebhookLog);

        // Get all the paymentWebhookLogList where payloadHash equals to
        defaultPaymentWebhookLogFiltering("payloadHash.equals=" + DEFAULT_PAYLOAD_HASH, "payloadHash.equals=" + UPDATED_PAYLOAD_HASH);
    }

    @Test
    @Transactional
    void getAllPaymentWebhookLogsByPayloadHashIsInShouldWork() throws Exception {
        // Initialize the database
        insertedPaymentWebhookLog = paymentWebhookLogRepository.saveAndFlush(paymentWebhookLog);

        // Get all the paymentWebhookLogList where payloadHash in
        defaultPaymentWebhookLogFiltering(
            "payloadHash.in=" + DEFAULT_PAYLOAD_HASH + "," + UPDATED_PAYLOAD_HASH,
            "payloadHash.in=" + UPDATED_PAYLOAD_HASH
        );
    }

    @Test
    @Transactional
    void getAllPaymentWebhookLogsByPayloadHashIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedPaymentWebhookLog = paymentWebhookLogRepository.saveAndFlush(paymentWebhookLog);

        // Get all the paymentWebhookLogList where payloadHash is not null
        defaultPaymentWebhookLogFiltering("payloadHash.specified=true", "payloadHash.specified=false");
    }

    @Test
    @Transactional
    void getAllPaymentWebhookLogsByPayloadHashContainsSomething() throws Exception {
        // Initialize the database
        insertedPaymentWebhookLog = paymentWebhookLogRepository.saveAndFlush(paymentWebhookLog);

        // Get all the paymentWebhookLogList where payloadHash contains
        defaultPaymentWebhookLogFiltering("payloadHash.contains=" + DEFAULT_PAYLOAD_HASH, "payloadHash.contains=" + UPDATED_PAYLOAD_HASH);
    }

    @Test
    @Transactional
    void getAllPaymentWebhookLogsByPayloadHashNotContainsSomething() throws Exception {
        // Initialize the database
        insertedPaymentWebhookLog = paymentWebhookLogRepository.saveAndFlush(paymentWebhookLog);

        // Get all the paymentWebhookLogList where payloadHash does not contain
        defaultPaymentWebhookLogFiltering(
            "payloadHash.doesNotContain=" + UPDATED_PAYLOAD_HASH,
            "payloadHash.doesNotContain=" + DEFAULT_PAYLOAD_HASH
        );
    }

    @Test
    @Transactional
    void getAllPaymentWebhookLogsByReceivedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedPaymentWebhookLog = paymentWebhookLogRepository.saveAndFlush(paymentWebhookLog);

        // Get all the paymentWebhookLogList where receivedAt equals to
        defaultPaymentWebhookLogFiltering("receivedAt.equals=" + DEFAULT_RECEIVED_AT, "receivedAt.equals=" + UPDATED_RECEIVED_AT);
    }

    @Test
    @Transactional
    void getAllPaymentWebhookLogsByReceivedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedPaymentWebhookLog = paymentWebhookLogRepository.saveAndFlush(paymentWebhookLog);

        // Get all the paymentWebhookLogList where receivedAt in
        defaultPaymentWebhookLogFiltering(
            "receivedAt.in=" + DEFAULT_RECEIVED_AT + "," + UPDATED_RECEIVED_AT,
            "receivedAt.in=" + UPDATED_RECEIVED_AT
        );
    }

    @Test
    @Transactional
    void getAllPaymentWebhookLogsByReceivedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedPaymentWebhookLog = paymentWebhookLogRepository.saveAndFlush(paymentWebhookLog);

        // Get all the paymentWebhookLogList where receivedAt is not null
        defaultPaymentWebhookLogFiltering("receivedAt.specified=true", "receivedAt.specified=false");
    }

    @Test
    @Transactional
    void getAllPaymentWebhookLogsByProcessingStatusIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedPaymentWebhookLog = paymentWebhookLogRepository.saveAndFlush(paymentWebhookLog);

        // Get all the paymentWebhookLogList where processingStatus equals to
        defaultPaymentWebhookLogFiltering(
            "processingStatus.equals=" + DEFAULT_PROCESSING_STATUS,
            "processingStatus.equals=" + UPDATED_PROCESSING_STATUS
        );
    }

    @Test
    @Transactional
    void getAllPaymentWebhookLogsByProcessingStatusIsInShouldWork() throws Exception {
        // Initialize the database
        insertedPaymentWebhookLog = paymentWebhookLogRepository.saveAndFlush(paymentWebhookLog);

        // Get all the paymentWebhookLogList where processingStatus in
        defaultPaymentWebhookLogFiltering(
            "processingStatus.in=" + DEFAULT_PROCESSING_STATUS + "," + UPDATED_PROCESSING_STATUS,
            "processingStatus.in=" + UPDATED_PROCESSING_STATUS
        );
    }

    @Test
    @Transactional
    void getAllPaymentWebhookLogsByProcessingStatusIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedPaymentWebhookLog = paymentWebhookLogRepository.saveAndFlush(paymentWebhookLog);

        // Get all the paymentWebhookLogList where processingStatus is not null
        defaultPaymentWebhookLogFiltering("processingStatus.specified=true", "processingStatus.specified=false");
    }

    @Test
    @Transactional
    void getAllPaymentWebhookLogsByProcessingStatusContainsSomething() throws Exception {
        // Initialize the database
        insertedPaymentWebhookLog = paymentWebhookLogRepository.saveAndFlush(paymentWebhookLog);

        // Get all the paymentWebhookLogList where processingStatus contains
        defaultPaymentWebhookLogFiltering(
            "processingStatus.contains=" + DEFAULT_PROCESSING_STATUS,
            "processingStatus.contains=" + UPDATED_PROCESSING_STATUS
        );
    }

    @Test
    @Transactional
    void getAllPaymentWebhookLogsByProcessingStatusNotContainsSomething() throws Exception {
        // Initialize the database
        insertedPaymentWebhookLog = paymentWebhookLogRepository.saveAndFlush(paymentWebhookLog);

        // Get all the paymentWebhookLogList where processingStatus does not contain
        defaultPaymentWebhookLogFiltering(
            "processingStatus.doesNotContain=" + UPDATED_PROCESSING_STATUS,
            "processingStatus.doesNotContain=" + DEFAULT_PROCESSING_STATUS
        );
    }

    @Test
    @Transactional
    void getAllPaymentWebhookLogsByCreatedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedPaymentWebhookLog = paymentWebhookLogRepository.saveAndFlush(paymentWebhookLog);

        // Get all the paymentWebhookLogList where createdAt equals to
        defaultPaymentWebhookLogFiltering("createdAt.equals=" + DEFAULT_CREATED_AT, "createdAt.equals=" + UPDATED_CREATED_AT);
    }

    @Test
    @Transactional
    void getAllPaymentWebhookLogsByCreatedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedPaymentWebhookLog = paymentWebhookLogRepository.saveAndFlush(paymentWebhookLog);

        // Get all the paymentWebhookLogList where createdAt in
        defaultPaymentWebhookLogFiltering(
            "createdAt.in=" + DEFAULT_CREATED_AT + "," + UPDATED_CREATED_AT,
            "createdAt.in=" + UPDATED_CREATED_AT
        );
    }

    @Test
    @Transactional
    void getAllPaymentWebhookLogsByCreatedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedPaymentWebhookLog = paymentWebhookLogRepository.saveAndFlush(paymentWebhookLog);

        // Get all the paymentWebhookLogList where createdAt is not null
        defaultPaymentWebhookLogFiltering("createdAt.specified=true", "createdAt.specified=false");
    }

    @Test
    @Transactional
    void getAllPaymentWebhookLogsByUpdatedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedPaymentWebhookLog = paymentWebhookLogRepository.saveAndFlush(paymentWebhookLog);

        // Get all the paymentWebhookLogList where updatedAt equals to
        defaultPaymentWebhookLogFiltering("updatedAt.equals=" + DEFAULT_UPDATED_AT, "updatedAt.equals=" + UPDATED_UPDATED_AT);
    }

    @Test
    @Transactional
    void getAllPaymentWebhookLogsByUpdatedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedPaymentWebhookLog = paymentWebhookLogRepository.saveAndFlush(paymentWebhookLog);

        // Get all the paymentWebhookLogList where updatedAt in
        defaultPaymentWebhookLogFiltering(
            "updatedAt.in=" + DEFAULT_UPDATED_AT + "," + UPDATED_UPDATED_AT,
            "updatedAt.in=" + UPDATED_UPDATED_AT
        );
    }

    @Test
    @Transactional
    void getAllPaymentWebhookLogsByUpdatedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedPaymentWebhookLog = paymentWebhookLogRepository.saveAndFlush(paymentWebhookLog);

        // Get all the paymentWebhookLogList where updatedAt is not null
        defaultPaymentWebhookLogFiltering("updatedAt.specified=true", "updatedAt.specified=false");
    }

    @Test
    @Transactional
    void getAllPaymentWebhookLogsByIsDeletedIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedPaymentWebhookLog = paymentWebhookLogRepository.saveAndFlush(paymentWebhookLog);

        // Get all the paymentWebhookLogList where isDeleted equals to
        defaultPaymentWebhookLogFiltering("isDeleted.equals=" + DEFAULT_IS_DELETED, "isDeleted.equals=" + UPDATED_IS_DELETED);
    }

    @Test
    @Transactional
    void getAllPaymentWebhookLogsByIsDeletedIsInShouldWork() throws Exception {
        // Initialize the database
        insertedPaymentWebhookLog = paymentWebhookLogRepository.saveAndFlush(paymentWebhookLog);

        // Get all the paymentWebhookLogList where isDeleted in
        defaultPaymentWebhookLogFiltering(
            "isDeleted.in=" + DEFAULT_IS_DELETED + "," + UPDATED_IS_DELETED,
            "isDeleted.in=" + UPDATED_IS_DELETED
        );
    }

    @Test
    @Transactional
    void getAllPaymentWebhookLogsByIsDeletedIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedPaymentWebhookLog = paymentWebhookLogRepository.saveAndFlush(paymentWebhookLog);

        // Get all the paymentWebhookLogList where isDeleted is not null
        defaultPaymentWebhookLogFiltering("isDeleted.specified=true", "isDeleted.specified=false");
    }

    @Test
    @Transactional
    void getAllPaymentWebhookLogsByDeletedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedPaymentWebhookLog = paymentWebhookLogRepository.saveAndFlush(paymentWebhookLog);

        // Get all the paymentWebhookLogList where deletedAt equals to
        defaultPaymentWebhookLogFiltering("deletedAt.equals=" + DEFAULT_DELETED_AT, "deletedAt.equals=" + UPDATED_DELETED_AT);
    }

    @Test
    @Transactional
    void getAllPaymentWebhookLogsByDeletedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedPaymentWebhookLog = paymentWebhookLogRepository.saveAndFlush(paymentWebhookLog);

        // Get all the paymentWebhookLogList where deletedAt in
        defaultPaymentWebhookLogFiltering(
            "deletedAt.in=" + DEFAULT_DELETED_AT + "," + UPDATED_DELETED_AT,
            "deletedAt.in=" + UPDATED_DELETED_AT
        );
    }

    @Test
    @Transactional
    void getAllPaymentWebhookLogsByDeletedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedPaymentWebhookLog = paymentWebhookLogRepository.saveAndFlush(paymentWebhookLog);

        // Get all the paymentWebhookLogList where deletedAt is not null
        defaultPaymentWebhookLogFiltering("deletedAt.specified=true", "deletedAt.specified=false");
    }

    @Test
    @Transactional
    void getAllPaymentWebhookLogsByDeletedByIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedPaymentWebhookLog = paymentWebhookLogRepository.saveAndFlush(paymentWebhookLog);

        // Get all the paymentWebhookLogList where deletedBy equals to
        defaultPaymentWebhookLogFiltering("deletedBy.equals=" + DEFAULT_DELETED_BY, "deletedBy.equals=" + UPDATED_DELETED_BY);
    }

    @Test
    @Transactional
    void getAllPaymentWebhookLogsByDeletedByIsInShouldWork() throws Exception {
        // Initialize the database
        insertedPaymentWebhookLog = paymentWebhookLogRepository.saveAndFlush(paymentWebhookLog);

        // Get all the paymentWebhookLogList where deletedBy in
        defaultPaymentWebhookLogFiltering(
            "deletedBy.in=" + DEFAULT_DELETED_BY + "," + UPDATED_DELETED_BY,
            "deletedBy.in=" + UPDATED_DELETED_BY
        );
    }

    @Test
    @Transactional
    void getAllPaymentWebhookLogsByDeletedByIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedPaymentWebhookLog = paymentWebhookLogRepository.saveAndFlush(paymentWebhookLog);

        // Get all the paymentWebhookLogList where deletedBy is not null
        defaultPaymentWebhookLogFiltering("deletedBy.specified=true", "deletedBy.specified=false");
    }

    @Test
    @Transactional
    void getAllPaymentWebhookLogsByPaymentTransactionIsEqualToSomething() throws Exception {
        PaymentTransaction paymentTransaction;
        if (TestUtil.findAll(em, PaymentTransaction.class).isEmpty()) {
            paymentWebhookLogRepository.saveAndFlush(paymentWebhookLog);
            paymentTransaction = PaymentTransactionResourceIT.createEntity();
        } else {
            paymentTransaction = TestUtil.findAll(em, PaymentTransaction.class).get(0);
        }
        em.persist(paymentTransaction);
        em.flush();
        paymentWebhookLog.setPaymentTransaction(paymentTransaction);
        paymentWebhookLogRepository.saveAndFlush(paymentWebhookLog);
        Long paymentTransactionId = paymentTransaction.getId();
        // Get all the paymentWebhookLogList where paymentTransaction equals to paymentTransactionId
        defaultPaymentWebhookLogShouldBeFound("paymentTransactionId.equals=" + paymentTransactionId);

        // Get all the paymentWebhookLogList where paymentTransaction equals to (paymentTransactionId + 1)
        defaultPaymentWebhookLogShouldNotBeFound("paymentTransactionId.equals=" + (paymentTransactionId + 1));
    }

    private void defaultPaymentWebhookLogFiltering(String shouldBeFound, String shouldNotBeFound) throws Exception {
        defaultPaymentWebhookLogShouldBeFound(shouldBeFound);
        defaultPaymentWebhookLogShouldNotBeFound(shouldNotBeFound);
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultPaymentWebhookLogShouldBeFound(String filter) throws Exception {
        restPaymentWebhookLogMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(paymentWebhookLog.getId().intValue())))
            .andExpect(jsonPath("$.[*].provider").value(hasItem(DEFAULT_PROVIDER)))
            .andExpect(jsonPath("$.[*].payloadHash").value(hasItem(DEFAULT_PAYLOAD_HASH)))
            .andExpect(jsonPath("$.[*].receivedAt").value(hasItem(DEFAULT_RECEIVED_AT.toString())))
            .andExpect(jsonPath("$.[*].processingStatus").value(hasItem(DEFAULT_PROCESSING_STATUS)))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].isDeleted").value(hasItem(DEFAULT_IS_DELETED)))
            .andExpect(jsonPath("$.[*].deletedAt").value(hasItem(DEFAULT_DELETED_AT.toString())))
            .andExpect(jsonPath("$.[*].deletedBy").value(hasItem(DEFAULT_DELETED_BY.toString())));

        // Check, that the count call also returns 1
        restPaymentWebhookLogMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("1"));
    }

    /**
     * Executes the search, and checks that the default entity is not returned.
     */
    private void defaultPaymentWebhookLogShouldNotBeFound(String filter) throws Exception {
        restPaymentWebhookLogMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());

        // Check, that the count call also returns 0
        restPaymentWebhookLogMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("0"));
    }

    @Test
    @Transactional
    void getNonExistingPaymentWebhookLog() throws Exception {
        // Get the paymentWebhookLog
        restPaymentWebhookLogMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingPaymentWebhookLog() throws Exception {
        // Initialize the database
        insertedPaymentWebhookLog = paymentWebhookLogRepository.saveAndFlush(paymentWebhookLog);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the paymentWebhookLog
        PaymentWebhookLog updatedPaymentWebhookLog = paymentWebhookLogRepository.findById(paymentWebhookLog.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedPaymentWebhookLog are not directly saved in db
        em.detach(updatedPaymentWebhookLog);
        updatedPaymentWebhookLog
            .provider(UPDATED_PROVIDER)
            .payloadHash(UPDATED_PAYLOAD_HASH)
            .receivedAt(UPDATED_RECEIVED_AT)
            .processingStatus(UPDATED_PROCESSING_STATUS)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);
        PaymentWebhookLogDTO paymentWebhookLogDTO = paymentWebhookLogMapper.toDto(updatedPaymentWebhookLog);

        restPaymentWebhookLogMockMvc
            .perform(
                put(ENTITY_API_URL_ID, paymentWebhookLogDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(paymentWebhookLogDTO))
            )
            .andExpect(status().isOk());

        // Validate the PaymentWebhookLog in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedPaymentWebhookLogToMatchAllProperties(updatedPaymentWebhookLog);
    }

    @Test
    @Transactional
    void putNonExistingPaymentWebhookLog() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        paymentWebhookLog.setId(longCount.incrementAndGet());

        // Create the PaymentWebhookLog
        PaymentWebhookLogDTO paymentWebhookLogDTO = paymentWebhookLogMapper.toDto(paymentWebhookLog);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restPaymentWebhookLogMockMvc
            .perform(
                put(ENTITY_API_URL_ID, paymentWebhookLogDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(paymentWebhookLogDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the PaymentWebhookLog in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchPaymentWebhookLog() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        paymentWebhookLog.setId(longCount.incrementAndGet());

        // Create the PaymentWebhookLog
        PaymentWebhookLogDTO paymentWebhookLogDTO = paymentWebhookLogMapper.toDto(paymentWebhookLog);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restPaymentWebhookLogMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(paymentWebhookLogDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the PaymentWebhookLog in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamPaymentWebhookLog() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        paymentWebhookLog.setId(longCount.incrementAndGet());

        // Create the PaymentWebhookLog
        PaymentWebhookLogDTO paymentWebhookLogDTO = paymentWebhookLogMapper.toDto(paymentWebhookLog);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restPaymentWebhookLogMockMvc
            .perform(
                put(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(paymentWebhookLogDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the PaymentWebhookLog in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdatePaymentWebhookLogWithPatch() throws Exception {
        // Initialize the database
        insertedPaymentWebhookLog = paymentWebhookLogRepository.saveAndFlush(paymentWebhookLog);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the paymentWebhookLog using partial update
        PaymentWebhookLog partialUpdatedPaymentWebhookLog = new PaymentWebhookLog();
        partialUpdatedPaymentWebhookLog.setId(paymentWebhookLog.getId());

        partialUpdatedPaymentWebhookLog.receivedAt(UPDATED_RECEIVED_AT).isDeleted(UPDATED_IS_DELETED).deletedAt(UPDATED_DELETED_AT);

        restPaymentWebhookLogMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedPaymentWebhookLog.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedPaymentWebhookLog))
            )
            .andExpect(status().isOk());

        // Validate the PaymentWebhookLog in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPaymentWebhookLogUpdatableFieldsEquals(
            createUpdateProxyForBean(partialUpdatedPaymentWebhookLog, paymentWebhookLog),
            getPersistedPaymentWebhookLog(paymentWebhookLog)
        );
    }

    @Test
    @Transactional
    void fullUpdatePaymentWebhookLogWithPatch() throws Exception {
        // Initialize the database
        insertedPaymentWebhookLog = paymentWebhookLogRepository.saveAndFlush(paymentWebhookLog);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the paymentWebhookLog using partial update
        PaymentWebhookLog partialUpdatedPaymentWebhookLog = new PaymentWebhookLog();
        partialUpdatedPaymentWebhookLog.setId(paymentWebhookLog.getId());

        partialUpdatedPaymentWebhookLog
            .provider(UPDATED_PROVIDER)
            .payloadHash(UPDATED_PAYLOAD_HASH)
            .receivedAt(UPDATED_RECEIVED_AT)
            .processingStatus(UPDATED_PROCESSING_STATUS)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);

        restPaymentWebhookLogMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedPaymentWebhookLog.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedPaymentWebhookLog))
            )
            .andExpect(status().isOk());

        // Validate the PaymentWebhookLog in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPaymentWebhookLogUpdatableFieldsEquals(
            partialUpdatedPaymentWebhookLog,
            getPersistedPaymentWebhookLog(partialUpdatedPaymentWebhookLog)
        );
    }

    @Test
    @Transactional
    void patchNonExistingPaymentWebhookLog() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        paymentWebhookLog.setId(longCount.incrementAndGet());

        // Create the PaymentWebhookLog
        PaymentWebhookLogDTO paymentWebhookLogDTO = paymentWebhookLogMapper.toDto(paymentWebhookLog);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restPaymentWebhookLogMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, paymentWebhookLogDTO.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(paymentWebhookLogDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the PaymentWebhookLog in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchPaymentWebhookLog() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        paymentWebhookLog.setId(longCount.incrementAndGet());

        // Create the PaymentWebhookLog
        PaymentWebhookLogDTO paymentWebhookLogDTO = paymentWebhookLogMapper.toDto(paymentWebhookLog);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restPaymentWebhookLogMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(paymentWebhookLogDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the PaymentWebhookLog in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamPaymentWebhookLog() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        paymentWebhookLog.setId(longCount.incrementAndGet());

        // Create the PaymentWebhookLog
        PaymentWebhookLogDTO paymentWebhookLogDTO = paymentWebhookLogMapper.toDto(paymentWebhookLog);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restPaymentWebhookLogMockMvc
            .perform(
                patch(ENTITY_API_URL)
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(paymentWebhookLogDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the PaymentWebhookLog in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deletePaymentWebhookLog() throws Exception {
        // Initialize the database
        insertedPaymentWebhookLog = paymentWebhookLogRepository.saveAndFlush(paymentWebhookLog);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the paymentWebhookLog
        restPaymentWebhookLogMockMvc
            .perform(delete(ENTITY_API_URL_ID, paymentWebhookLog.getId()).with(csrf()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return paymentWebhookLogRepository.count();
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

    protected PaymentWebhookLog getPersistedPaymentWebhookLog(PaymentWebhookLog paymentWebhookLog) {
        return paymentWebhookLogRepository.findById(paymentWebhookLog.getId()).orElseThrow();
    }

    protected void assertPersistedPaymentWebhookLogToMatchAllProperties(PaymentWebhookLog expectedPaymentWebhookLog) {
        assertPaymentWebhookLogAllPropertiesEquals(expectedPaymentWebhookLog, getPersistedPaymentWebhookLog(expectedPaymentWebhookLog));
    }

    protected void assertPersistedPaymentWebhookLogToMatchUpdatableProperties(PaymentWebhookLog expectedPaymentWebhookLog) {
        assertPaymentWebhookLogAllUpdatablePropertiesEquals(
            expectedPaymentWebhookLog,
            getPersistedPaymentWebhookLog(expectedPaymentWebhookLog)
        );
    }
}
