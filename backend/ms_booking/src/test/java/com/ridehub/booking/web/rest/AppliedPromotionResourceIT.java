package com.ridehub.booking.web.rest;

import static com.ridehub.booking.domain.AppliedPromotionAsserts.*;
import static com.ridehub.booking.web.rest.TestUtil.createUpdateProxyForBean;
import static com.ridehub.booking.web.rest.TestUtil.sameNumber;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ridehub.booking.IntegrationTest;
import com.ridehub.booking.domain.AppliedPromotion;
import com.ridehub.booking.domain.Booking;
import com.ridehub.booking.repository.AppliedPromotionRepository;
import com.ridehub.booking.service.dto.AppliedPromotionDTO;
import com.ridehub.booking.service.mapper.AppliedPromotionMapper;
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
 * Integration tests for the {@link AppliedPromotionResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class AppliedPromotionResourceIT {

    private static final Long DEFAULT_PROMOTION_ID = 1L;
    private static final Long UPDATED_PROMOTION_ID = 2L;
    private static final Long SMALLER_PROMOTION_ID = 1L - 1L;

    private static final String DEFAULT_PROMOTION_CODE = "AAAAAAAAAA";
    private static final String UPDATED_PROMOTION_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_POLICY_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_POLICY_TYPE = "BBBBBBBBBB";

    private static final Integer DEFAULT_PERCENT = 1;
    private static final Integer UPDATED_PERCENT = 2;
    private static final Integer SMALLER_PERCENT = 1 - 1;

    private static final BigDecimal DEFAULT_MAX_OFF = new BigDecimal(1);
    private static final BigDecimal UPDATED_MAX_OFF = new BigDecimal(2);
    private static final BigDecimal SMALLER_MAX_OFF = new BigDecimal(1 - 1);

    private static final BigDecimal DEFAULT_DISCOUNT_AMOUNT = new BigDecimal(1);
    private static final BigDecimal UPDATED_DISCOUNT_AMOUNT = new BigDecimal(2);
    private static final BigDecimal SMALLER_DISCOUNT_AMOUNT = new BigDecimal(1 - 1);

    private static final Instant DEFAULT_APPLIED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_APPLIED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

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

    private static final String ENTITY_API_URL = "/api/applied-promotions";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private AppliedPromotionRepository appliedPromotionRepository;

    @Autowired
    private AppliedPromotionMapper appliedPromotionMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restAppliedPromotionMockMvc;

    private AppliedPromotion appliedPromotion;

    private AppliedPromotion insertedAppliedPromotion;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static AppliedPromotion createEntity(EntityManager em) {
        AppliedPromotion appliedPromotion = new AppliedPromotion()
            .promotionId(DEFAULT_PROMOTION_ID)
            .promotionCode(DEFAULT_PROMOTION_CODE)
            .policyType(DEFAULT_POLICY_TYPE)
            .percent(DEFAULT_PERCENT)
            .maxOff(DEFAULT_MAX_OFF)
            .discountAmount(DEFAULT_DISCOUNT_AMOUNT)
            .appliedAt(DEFAULT_APPLIED_AT)
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
        appliedPromotion.setBooking(booking);
        return appliedPromotion;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static AppliedPromotion createUpdatedEntity(EntityManager em) {
        AppliedPromotion updatedAppliedPromotion = new AppliedPromotion()
            .promotionId(UPDATED_PROMOTION_ID)
            .promotionCode(UPDATED_PROMOTION_CODE)
            .policyType(UPDATED_POLICY_TYPE)
            .percent(UPDATED_PERCENT)
            .maxOff(UPDATED_MAX_OFF)
            .discountAmount(UPDATED_DISCOUNT_AMOUNT)
            .appliedAt(UPDATED_APPLIED_AT)
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
        updatedAppliedPromotion.setBooking(booking);
        return updatedAppliedPromotion;
    }

    @BeforeEach
    void initTest() {
        appliedPromotion = createEntity(em);
    }

    @AfterEach
    void cleanup() {
        if (insertedAppliedPromotion != null) {
            appliedPromotionRepository.delete(insertedAppliedPromotion);
            insertedAppliedPromotion = null;
        }
    }

    @Test
    @Transactional
    void createAppliedPromotion() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the AppliedPromotion
        AppliedPromotionDTO appliedPromotionDTO = appliedPromotionMapper.toDto(appliedPromotion);
        var returnedAppliedPromotionDTO = om.readValue(
            restAppliedPromotionMockMvc
                .perform(
                    post(ENTITY_API_URL)
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsBytes(appliedPromotionDTO))
                )
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            AppliedPromotionDTO.class
        );

        // Validate the AppliedPromotion in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        var returnedAppliedPromotion = appliedPromotionMapper.toEntity(returnedAppliedPromotionDTO);
        assertAppliedPromotionUpdatableFieldsEquals(returnedAppliedPromotion, getPersistedAppliedPromotion(returnedAppliedPromotion));

        insertedAppliedPromotion = returnedAppliedPromotion;
    }

    @Test
    @Transactional
    void createAppliedPromotionWithExistingId() throws Exception {
        // Create the AppliedPromotion with an existing ID
        appliedPromotion.setId(1L);
        AppliedPromotionDTO appliedPromotionDTO = appliedPromotionMapper.toDto(appliedPromotion);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restAppliedPromotionMockMvc
            .perform(
                post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(appliedPromotionDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the AppliedPromotion in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkPromotionIdIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        appliedPromotion.setPromotionId(null);

        // Create the AppliedPromotion, which fails.
        AppliedPromotionDTO appliedPromotionDTO = appliedPromotionMapper.toDto(appliedPromotion);

        restAppliedPromotionMockMvc
            .perform(
                post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(appliedPromotionDTO))
            )
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkDiscountAmountIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        appliedPromotion.setDiscountAmount(null);

        // Create the AppliedPromotion, which fails.
        AppliedPromotionDTO appliedPromotionDTO = appliedPromotionMapper.toDto(appliedPromotion);

        restAppliedPromotionMockMvc
            .perform(
                post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(appliedPromotionDTO))
            )
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkAppliedAtIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        appliedPromotion.setAppliedAt(null);

        // Create the AppliedPromotion, which fails.
        AppliedPromotionDTO appliedPromotionDTO = appliedPromotionMapper.toDto(appliedPromotion);

        restAppliedPromotionMockMvc
            .perform(
                post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(appliedPromotionDTO))
            )
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkCreatedAtIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        appliedPromotion.setCreatedAt(null);

        // Create the AppliedPromotion, which fails.
        AppliedPromotionDTO appliedPromotionDTO = appliedPromotionMapper.toDto(appliedPromotion);

        restAppliedPromotionMockMvc
            .perform(
                post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(appliedPromotionDTO))
            )
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllAppliedPromotions() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList
        restAppliedPromotionMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(appliedPromotion.getId().intValue())))
            .andExpect(jsonPath("$.[*].promotionId").value(hasItem(DEFAULT_PROMOTION_ID.intValue())))
            .andExpect(jsonPath("$.[*].promotionCode").value(hasItem(DEFAULT_PROMOTION_CODE)))
            .andExpect(jsonPath("$.[*].policyType").value(hasItem(DEFAULT_POLICY_TYPE)))
            .andExpect(jsonPath("$.[*].percent").value(hasItem(DEFAULT_PERCENT)))
            .andExpect(jsonPath("$.[*].maxOff").value(hasItem(sameNumber(DEFAULT_MAX_OFF))))
            .andExpect(jsonPath("$.[*].discountAmount").value(hasItem(sameNumber(DEFAULT_DISCOUNT_AMOUNT))))
            .andExpect(jsonPath("$.[*].appliedAt").value(hasItem(DEFAULT_APPLIED_AT.toString())))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].isDeleted").value(hasItem(DEFAULT_IS_DELETED)))
            .andExpect(jsonPath("$.[*].deletedAt").value(hasItem(DEFAULT_DELETED_AT.toString())))
            .andExpect(jsonPath("$.[*].deletedBy").value(hasItem(DEFAULT_DELETED_BY.toString())));
    }

    @Test
    @Transactional
    void getAppliedPromotion() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get the appliedPromotion
        restAppliedPromotionMockMvc
            .perform(get(ENTITY_API_URL_ID, appliedPromotion.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(appliedPromotion.getId().intValue()))
            .andExpect(jsonPath("$.promotionId").value(DEFAULT_PROMOTION_ID.intValue()))
            .andExpect(jsonPath("$.promotionCode").value(DEFAULT_PROMOTION_CODE))
            .andExpect(jsonPath("$.policyType").value(DEFAULT_POLICY_TYPE))
            .andExpect(jsonPath("$.percent").value(DEFAULT_PERCENT))
            .andExpect(jsonPath("$.maxOff").value(sameNumber(DEFAULT_MAX_OFF)))
            .andExpect(jsonPath("$.discountAmount").value(sameNumber(DEFAULT_DISCOUNT_AMOUNT)))
            .andExpect(jsonPath("$.appliedAt").value(DEFAULT_APPLIED_AT.toString()))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.updatedAt").value(DEFAULT_UPDATED_AT.toString()))
            .andExpect(jsonPath("$.isDeleted").value(DEFAULT_IS_DELETED))
            .andExpect(jsonPath("$.deletedAt").value(DEFAULT_DELETED_AT.toString()))
            .andExpect(jsonPath("$.deletedBy").value(DEFAULT_DELETED_BY.toString()));
    }

    @Test
    @Transactional
    void getAppliedPromotionsByIdFiltering() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        Long id = appliedPromotion.getId();

        defaultAppliedPromotionFiltering("id.equals=" + id, "id.notEquals=" + id);

        defaultAppliedPromotionFiltering("id.greaterThanOrEqual=" + id, "id.greaterThan=" + id);

        defaultAppliedPromotionFiltering("id.lessThanOrEqual=" + id, "id.lessThan=" + id);
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByPromotionIdIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where promotionId equals to
        defaultAppliedPromotionFiltering("promotionId.equals=" + DEFAULT_PROMOTION_ID, "promotionId.equals=" + UPDATED_PROMOTION_ID);
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByPromotionIdIsInShouldWork() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where promotionId in
        defaultAppliedPromotionFiltering(
            "promotionId.in=" + DEFAULT_PROMOTION_ID + "," + UPDATED_PROMOTION_ID,
            "promotionId.in=" + UPDATED_PROMOTION_ID
        );
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByPromotionIdIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where promotionId is not null
        defaultAppliedPromotionFiltering("promotionId.specified=true", "promotionId.specified=false");
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByPromotionIdIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where promotionId is greater than or equal to
        defaultAppliedPromotionFiltering(
            "promotionId.greaterThanOrEqual=" + DEFAULT_PROMOTION_ID,
            "promotionId.greaterThanOrEqual=" + UPDATED_PROMOTION_ID
        );
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByPromotionIdIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where promotionId is less than or equal to
        defaultAppliedPromotionFiltering(
            "promotionId.lessThanOrEqual=" + DEFAULT_PROMOTION_ID,
            "promotionId.lessThanOrEqual=" + SMALLER_PROMOTION_ID
        );
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByPromotionIdIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where promotionId is less than
        defaultAppliedPromotionFiltering("promotionId.lessThan=" + UPDATED_PROMOTION_ID, "promotionId.lessThan=" + DEFAULT_PROMOTION_ID);
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByPromotionIdIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where promotionId is greater than
        defaultAppliedPromotionFiltering(
            "promotionId.greaterThan=" + SMALLER_PROMOTION_ID,
            "promotionId.greaterThan=" + DEFAULT_PROMOTION_ID
        );
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByPromotionCodeIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where promotionCode equals to
        defaultAppliedPromotionFiltering(
            "promotionCode.equals=" + DEFAULT_PROMOTION_CODE,
            "promotionCode.equals=" + UPDATED_PROMOTION_CODE
        );
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByPromotionCodeIsInShouldWork() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where promotionCode in
        defaultAppliedPromotionFiltering(
            "promotionCode.in=" + DEFAULT_PROMOTION_CODE + "," + UPDATED_PROMOTION_CODE,
            "promotionCode.in=" + UPDATED_PROMOTION_CODE
        );
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByPromotionCodeIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where promotionCode is not null
        defaultAppliedPromotionFiltering("promotionCode.specified=true", "promotionCode.specified=false");
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByPromotionCodeContainsSomething() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where promotionCode contains
        defaultAppliedPromotionFiltering(
            "promotionCode.contains=" + DEFAULT_PROMOTION_CODE,
            "promotionCode.contains=" + UPDATED_PROMOTION_CODE
        );
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByPromotionCodeNotContainsSomething() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where promotionCode does not contain
        defaultAppliedPromotionFiltering(
            "promotionCode.doesNotContain=" + UPDATED_PROMOTION_CODE,
            "promotionCode.doesNotContain=" + DEFAULT_PROMOTION_CODE
        );
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByPolicyTypeIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where policyType equals to
        defaultAppliedPromotionFiltering("policyType.equals=" + DEFAULT_POLICY_TYPE, "policyType.equals=" + UPDATED_POLICY_TYPE);
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByPolicyTypeIsInShouldWork() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where policyType in
        defaultAppliedPromotionFiltering(
            "policyType.in=" + DEFAULT_POLICY_TYPE + "," + UPDATED_POLICY_TYPE,
            "policyType.in=" + UPDATED_POLICY_TYPE
        );
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByPolicyTypeIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where policyType is not null
        defaultAppliedPromotionFiltering("policyType.specified=true", "policyType.specified=false");
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByPolicyTypeContainsSomething() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where policyType contains
        defaultAppliedPromotionFiltering("policyType.contains=" + DEFAULT_POLICY_TYPE, "policyType.contains=" + UPDATED_POLICY_TYPE);
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByPolicyTypeNotContainsSomething() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where policyType does not contain
        defaultAppliedPromotionFiltering(
            "policyType.doesNotContain=" + UPDATED_POLICY_TYPE,
            "policyType.doesNotContain=" + DEFAULT_POLICY_TYPE
        );
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByPercentIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where percent equals to
        defaultAppliedPromotionFiltering("percent.equals=" + DEFAULT_PERCENT, "percent.equals=" + UPDATED_PERCENT);
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByPercentIsInShouldWork() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where percent in
        defaultAppliedPromotionFiltering("percent.in=" + DEFAULT_PERCENT + "," + UPDATED_PERCENT, "percent.in=" + UPDATED_PERCENT);
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByPercentIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where percent is not null
        defaultAppliedPromotionFiltering("percent.specified=true", "percent.specified=false");
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByPercentIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where percent is greater than or equal to
        defaultAppliedPromotionFiltering("percent.greaterThanOrEqual=" + DEFAULT_PERCENT, "percent.greaterThanOrEqual=" + UPDATED_PERCENT);
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByPercentIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where percent is less than or equal to
        defaultAppliedPromotionFiltering("percent.lessThanOrEqual=" + DEFAULT_PERCENT, "percent.lessThanOrEqual=" + SMALLER_PERCENT);
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByPercentIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where percent is less than
        defaultAppliedPromotionFiltering("percent.lessThan=" + UPDATED_PERCENT, "percent.lessThan=" + DEFAULT_PERCENT);
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByPercentIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where percent is greater than
        defaultAppliedPromotionFiltering("percent.greaterThan=" + SMALLER_PERCENT, "percent.greaterThan=" + DEFAULT_PERCENT);
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByMaxOffIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where maxOff equals to
        defaultAppliedPromotionFiltering("maxOff.equals=" + DEFAULT_MAX_OFF, "maxOff.equals=" + UPDATED_MAX_OFF);
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByMaxOffIsInShouldWork() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where maxOff in
        defaultAppliedPromotionFiltering("maxOff.in=" + DEFAULT_MAX_OFF + "," + UPDATED_MAX_OFF, "maxOff.in=" + UPDATED_MAX_OFF);
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByMaxOffIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where maxOff is not null
        defaultAppliedPromotionFiltering("maxOff.specified=true", "maxOff.specified=false");
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByMaxOffIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where maxOff is greater than or equal to
        defaultAppliedPromotionFiltering("maxOff.greaterThanOrEqual=" + DEFAULT_MAX_OFF, "maxOff.greaterThanOrEqual=" + UPDATED_MAX_OFF);
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByMaxOffIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where maxOff is less than or equal to
        defaultAppliedPromotionFiltering("maxOff.lessThanOrEqual=" + DEFAULT_MAX_OFF, "maxOff.lessThanOrEqual=" + SMALLER_MAX_OFF);
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByMaxOffIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where maxOff is less than
        defaultAppliedPromotionFiltering("maxOff.lessThan=" + UPDATED_MAX_OFF, "maxOff.lessThan=" + DEFAULT_MAX_OFF);
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByMaxOffIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where maxOff is greater than
        defaultAppliedPromotionFiltering("maxOff.greaterThan=" + SMALLER_MAX_OFF, "maxOff.greaterThan=" + DEFAULT_MAX_OFF);
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByDiscountAmountIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where discountAmount equals to
        defaultAppliedPromotionFiltering(
            "discountAmount.equals=" + DEFAULT_DISCOUNT_AMOUNT,
            "discountAmount.equals=" + UPDATED_DISCOUNT_AMOUNT
        );
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByDiscountAmountIsInShouldWork() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where discountAmount in
        defaultAppliedPromotionFiltering(
            "discountAmount.in=" + DEFAULT_DISCOUNT_AMOUNT + "," + UPDATED_DISCOUNT_AMOUNT,
            "discountAmount.in=" + UPDATED_DISCOUNT_AMOUNT
        );
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByDiscountAmountIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where discountAmount is not null
        defaultAppliedPromotionFiltering("discountAmount.specified=true", "discountAmount.specified=false");
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByDiscountAmountIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where discountAmount is greater than or equal to
        defaultAppliedPromotionFiltering(
            "discountAmount.greaterThanOrEqual=" + DEFAULT_DISCOUNT_AMOUNT,
            "discountAmount.greaterThanOrEqual=" + UPDATED_DISCOUNT_AMOUNT
        );
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByDiscountAmountIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where discountAmount is less than or equal to
        defaultAppliedPromotionFiltering(
            "discountAmount.lessThanOrEqual=" + DEFAULT_DISCOUNT_AMOUNT,
            "discountAmount.lessThanOrEqual=" + SMALLER_DISCOUNT_AMOUNT
        );
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByDiscountAmountIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where discountAmount is less than
        defaultAppliedPromotionFiltering(
            "discountAmount.lessThan=" + UPDATED_DISCOUNT_AMOUNT,
            "discountAmount.lessThan=" + DEFAULT_DISCOUNT_AMOUNT
        );
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByDiscountAmountIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where discountAmount is greater than
        defaultAppliedPromotionFiltering(
            "discountAmount.greaterThan=" + SMALLER_DISCOUNT_AMOUNT,
            "discountAmount.greaterThan=" + DEFAULT_DISCOUNT_AMOUNT
        );
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByAppliedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where appliedAt equals to
        defaultAppliedPromotionFiltering("appliedAt.equals=" + DEFAULT_APPLIED_AT, "appliedAt.equals=" + UPDATED_APPLIED_AT);
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByAppliedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where appliedAt in
        defaultAppliedPromotionFiltering(
            "appliedAt.in=" + DEFAULT_APPLIED_AT + "," + UPDATED_APPLIED_AT,
            "appliedAt.in=" + UPDATED_APPLIED_AT
        );
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByAppliedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where appliedAt is not null
        defaultAppliedPromotionFiltering("appliedAt.specified=true", "appliedAt.specified=false");
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByCreatedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where createdAt equals to
        defaultAppliedPromotionFiltering("createdAt.equals=" + DEFAULT_CREATED_AT, "createdAt.equals=" + UPDATED_CREATED_AT);
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByCreatedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where createdAt in
        defaultAppliedPromotionFiltering(
            "createdAt.in=" + DEFAULT_CREATED_AT + "," + UPDATED_CREATED_AT,
            "createdAt.in=" + UPDATED_CREATED_AT
        );
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByCreatedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where createdAt is not null
        defaultAppliedPromotionFiltering("createdAt.specified=true", "createdAt.specified=false");
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByUpdatedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where updatedAt equals to
        defaultAppliedPromotionFiltering("updatedAt.equals=" + DEFAULT_UPDATED_AT, "updatedAt.equals=" + UPDATED_UPDATED_AT);
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByUpdatedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where updatedAt in
        defaultAppliedPromotionFiltering(
            "updatedAt.in=" + DEFAULT_UPDATED_AT + "," + UPDATED_UPDATED_AT,
            "updatedAt.in=" + UPDATED_UPDATED_AT
        );
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByUpdatedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where updatedAt is not null
        defaultAppliedPromotionFiltering("updatedAt.specified=true", "updatedAt.specified=false");
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByIsDeletedIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where isDeleted equals to
        defaultAppliedPromotionFiltering("isDeleted.equals=" + DEFAULT_IS_DELETED, "isDeleted.equals=" + UPDATED_IS_DELETED);
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByIsDeletedIsInShouldWork() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where isDeleted in
        defaultAppliedPromotionFiltering(
            "isDeleted.in=" + DEFAULT_IS_DELETED + "," + UPDATED_IS_DELETED,
            "isDeleted.in=" + UPDATED_IS_DELETED
        );
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByIsDeletedIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where isDeleted is not null
        defaultAppliedPromotionFiltering("isDeleted.specified=true", "isDeleted.specified=false");
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByDeletedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where deletedAt equals to
        defaultAppliedPromotionFiltering("deletedAt.equals=" + DEFAULT_DELETED_AT, "deletedAt.equals=" + UPDATED_DELETED_AT);
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByDeletedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where deletedAt in
        defaultAppliedPromotionFiltering(
            "deletedAt.in=" + DEFAULT_DELETED_AT + "," + UPDATED_DELETED_AT,
            "deletedAt.in=" + UPDATED_DELETED_AT
        );
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByDeletedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where deletedAt is not null
        defaultAppliedPromotionFiltering("deletedAt.specified=true", "deletedAt.specified=false");
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByDeletedByIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where deletedBy equals to
        defaultAppliedPromotionFiltering("deletedBy.equals=" + DEFAULT_DELETED_BY, "deletedBy.equals=" + UPDATED_DELETED_BY);
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByDeletedByIsInShouldWork() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where deletedBy in
        defaultAppliedPromotionFiltering(
            "deletedBy.in=" + DEFAULT_DELETED_BY + "," + UPDATED_DELETED_BY,
            "deletedBy.in=" + UPDATED_DELETED_BY
        );
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByDeletedByIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        // Get all the appliedPromotionList where deletedBy is not null
        defaultAppliedPromotionFiltering("deletedBy.specified=true", "deletedBy.specified=false");
    }

    @Test
    @Transactional
    void getAllAppliedPromotionsByBookingIsEqualToSomething() throws Exception {
        Booking booking;
        if (TestUtil.findAll(em, Booking.class).isEmpty()) {
            appliedPromotionRepository.saveAndFlush(appliedPromotion);
            booking = BookingResourceIT.createEntity();
        } else {
            booking = TestUtil.findAll(em, Booking.class).get(0);
        }
        em.persist(booking);
        em.flush();
        appliedPromotion.setBooking(booking);
        appliedPromotionRepository.saveAndFlush(appliedPromotion);
        Long bookingId = booking.getId();
        // Get all the appliedPromotionList where booking equals to bookingId
        defaultAppliedPromotionShouldBeFound("bookingId.equals=" + bookingId);

        // Get all the appliedPromotionList where booking equals to (bookingId + 1)
        defaultAppliedPromotionShouldNotBeFound("bookingId.equals=" + (bookingId + 1));
    }

    private void defaultAppliedPromotionFiltering(String shouldBeFound, String shouldNotBeFound) throws Exception {
        defaultAppliedPromotionShouldBeFound(shouldBeFound);
        defaultAppliedPromotionShouldNotBeFound(shouldNotBeFound);
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultAppliedPromotionShouldBeFound(String filter) throws Exception {
        restAppliedPromotionMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(appliedPromotion.getId().intValue())))
            .andExpect(jsonPath("$.[*].promotionId").value(hasItem(DEFAULT_PROMOTION_ID.intValue())))
            .andExpect(jsonPath("$.[*].promotionCode").value(hasItem(DEFAULT_PROMOTION_CODE)))
            .andExpect(jsonPath("$.[*].policyType").value(hasItem(DEFAULT_POLICY_TYPE)))
            .andExpect(jsonPath("$.[*].percent").value(hasItem(DEFAULT_PERCENT)))
            .andExpect(jsonPath("$.[*].maxOff").value(hasItem(sameNumber(DEFAULT_MAX_OFF))))
            .andExpect(jsonPath("$.[*].discountAmount").value(hasItem(sameNumber(DEFAULT_DISCOUNT_AMOUNT))))
            .andExpect(jsonPath("$.[*].appliedAt").value(hasItem(DEFAULT_APPLIED_AT.toString())))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].isDeleted").value(hasItem(DEFAULT_IS_DELETED)))
            .andExpect(jsonPath("$.[*].deletedAt").value(hasItem(DEFAULT_DELETED_AT.toString())))
            .andExpect(jsonPath("$.[*].deletedBy").value(hasItem(DEFAULT_DELETED_BY.toString())));

        // Check, that the count call also returns 1
        restAppliedPromotionMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("1"));
    }

    /**
     * Executes the search, and checks that the default entity is not returned.
     */
    private void defaultAppliedPromotionShouldNotBeFound(String filter) throws Exception {
        restAppliedPromotionMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());

        // Check, that the count call also returns 0
        restAppliedPromotionMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("0"));
    }

    @Test
    @Transactional
    void getNonExistingAppliedPromotion() throws Exception {
        // Get the appliedPromotion
        restAppliedPromotionMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingAppliedPromotion() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the appliedPromotion
        AppliedPromotion updatedAppliedPromotion = appliedPromotionRepository.findById(appliedPromotion.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedAppliedPromotion are not directly saved in db
        em.detach(updatedAppliedPromotion);
        updatedAppliedPromotion
            .promotionId(UPDATED_PROMOTION_ID)
            .promotionCode(UPDATED_PROMOTION_CODE)
            .policyType(UPDATED_POLICY_TYPE)
            .percent(UPDATED_PERCENT)
            .maxOff(UPDATED_MAX_OFF)
            .discountAmount(UPDATED_DISCOUNT_AMOUNT)
            .appliedAt(UPDATED_APPLIED_AT)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);
        AppliedPromotionDTO appliedPromotionDTO = appliedPromotionMapper.toDto(updatedAppliedPromotion);

        restAppliedPromotionMockMvc
            .perform(
                put(ENTITY_API_URL_ID, appliedPromotionDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(appliedPromotionDTO))
            )
            .andExpect(status().isOk());

        // Validate the AppliedPromotion in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedAppliedPromotionToMatchAllProperties(updatedAppliedPromotion);
    }

    @Test
    @Transactional
    void putNonExistingAppliedPromotion() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        appliedPromotion.setId(longCount.incrementAndGet());

        // Create the AppliedPromotion
        AppliedPromotionDTO appliedPromotionDTO = appliedPromotionMapper.toDto(appliedPromotion);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restAppliedPromotionMockMvc
            .perform(
                put(ENTITY_API_URL_ID, appliedPromotionDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(appliedPromotionDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the AppliedPromotion in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchAppliedPromotion() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        appliedPromotion.setId(longCount.incrementAndGet());

        // Create the AppliedPromotion
        AppliedPromotionDTO appliedPromotionDTO = appliedPromotionMapper.toDto(appliedPromotion);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restAppliedPromotionMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(appliedPromotionDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the AppliedPromotion in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamAppliedPromotion() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        appliedPromotion.setId(longCount.incrementAndGet());

        // Create the AppliedPromotion
        AppliedPromotionDTO appliedPromotionDTO = appliedPromotionMapper.toDto(appliedPromotion);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restAppliedPromotionMockMvc
            .perform(
                put(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(appliedPromotionDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the AppliedPromotion in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateAppliedPromotionWithPatch() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the appliedPromotion using partial update
        AppliedPromotion partialUpdatedAppliedPromotion = new AppliedPromotion();
        partialUpdatedAppliedPromotion.setId(appliedPromotion.getId());

        partialUpdatedAppliedPromotion
            .promotionCode(UPDATED_PROMOTION_CODE)
            .policyType(UPDATED_POLICY_TYPE)
            .createdAt(UPDATED_CREATED_AT)
            .deletedAt(UPDATED_DELETED_AT);

        restAppliedPromotionMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedAppliedPromotion.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedAppliedPromotion))
            )
            .andExpect(status().isOk());

        // Validate the AppliedPromotion in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertAppliedPromotionUpdatableFieldsEquals(
            createUpdateProxyForBean(partialUpdatedAppliedPromotion, appliedPromotion),
            getPersistedAppliedPromotion(appliedPromotion)
        );
    }

    @Test
    @Transactional
    void fullUpdateAppliedPromotionWithPatch() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the appliedPromotion using partial update
        AppliedPromotion partialUpdatedAppliedPromotion = new AppliedPromotion();
        partialUpdatedAppliedPromotion.setId(appliedPromotion.getId());

        partialUpdatedAppliedPromotion
            .promotionId(UPDATED_PROMOTION_ID)
            .promotionCode(UPDATED_PROMOTION_CODE)
            .policyType(UPDATED_POLICY_TYPE)
            .percent(UPDATED_PERCENT)
            .maxOff(UPDATED_MAX_OFF)
            .discountAmount(UPDATED_DISCOUNT_AMOUNT)
            .appliedAt(UPDATED_APPLIED_AT)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);

        restAppliedPromotionMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedAppliedPromotion.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedAppliedPromotion))
            )
            .andExpect(status().isOk());

        // Validate the AppliedPromotion in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertAppliedPromotionUpdatableFieldsEquals(
            partialUpdatedAppliedPromotion,
            getPersistedAppliedPromotion(partialUpdatedAppliedPromotion)
        );
    }

    @Test
    @Transactional
    void patchNonExistingAppliedPromotion() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        appliedPromotion.setId(longCount.incrementAndGet());

        // Create the AppliedPromotion
        AppliedPromotionDTO appliedPromotionDTO = appliedPromotionMapper.toDto(appliedPromotion);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restAppliedPromotionMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, appliedPromotionDTO.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(appliedPromotionDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the AppliedPromotion in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchAppliedPromotion() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        appliedPromotion.setId(longCount.incrementAndGet());

        // Create the AppliedPromotion
        AppliedPromotionDTO appliedPromotionDTO = appliedPromotionMapper.toDto(appliedPromotion);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restAppliedPromotionMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(appliedPromotionDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the AppliedPromotion in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamAppliedPromotion() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        appliedPromotion.setId(longCount.incrementAndGet());

        // Create the AppliedPromotion
        AppliedPromotionDTO appliedPromotionDTO = appliedPromotionMapper.toDto(appliedPromotion);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restAppliedPromotionMockMvc
            .perform(
                patch(ENTITY_API_URL)
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(appliedPromotionDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the AppliedPromotion in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteAppliedPromotion() throws Exception {
        // Initialize the database
        insertedAppliedPromotion = appliedPromotionRepository.saveAndFlush(appliedPromotion);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the appliedPromotion
        restAppliedPromotionMockMvc
            .perform(delete(ENTITY_API_URL_ID, appliedPromotion.getId()).with(csrf()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return appliedPromotionRepository.count();
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

    protected AppliedPromotion getPersistedAppliedPromotion(AppliedPromotion appliedPromotion) {
        return appliedPromotionRepository.findById(appliedPromotion.getId()).orElseThrow();
    }

    protected void assertPersistedAppliedPromotionToMatchAllProperties(AppliedPromotion expectedAppliedPromotion) {
        assertAppliedPromotionAllPropertiesEquals(expectedAppliedPromotion, getPersistedAppliedPromotion(expectedAppliedPromotion));
    }

    protected void assertPersistedAppliedPromotionToMatchUpdatableProperties(AppliedPromotion expectedAppliedPromotion) {
        assertAppliedPromotionAllUpdatablePropertiesEquals(
            expectedAppliedPromotion,
            getPersistedAppliedPromotion(expectedAppliedPromotion)
        );
    }
}
