package com.ridehub.promotion.web.rest;

import static com.ridehub.promotion.domain.PromotionAsserts.*;
import static com.ridehub.promotion.web.rest.TestUtil.createUpdateProxyForBean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ridehub.promotion.IntegrationTest;
import com.ridehub.promotion.domain.FilePromotion;
import com.ridehub.promotion.domain.Promotion;
import com.ridehub.promotion.repository.PromotionRepository;
import com.ridehub.promotion.service.dto.PromotionDTO;
import com.ridehub.promotion.service.mapper.PromotionMapper;
import jakarta.persistence.EntityManager;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
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
 * Integration tests for the {@link PromotionResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class PromotionResourceIT {

    private static final String DEFAULT_CODE = "AAAAAAAAAA";
    private static final String UPDATED_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_START_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_START_DATE = LocalDate.now(ZoneId.systemDefault());
    private static final LocalDate SMALLER_START_DATE = LocalDate.ofEpochDay(-1L);

    private static final LocalDate DEFAULT_END_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_END_DATE = LocalDate.now(ZoneId.systemDefault());
    private static final LocalDate SMALLER_END_DATE = LocalDate.ofEpochDay(-1L);

    private static final Integer DEFAULT_USAGE_LIMIT = 1;
    private static final Integer UPDATED_USAGE_LIMIT = 2;
    private static final Integer SMALLER_USAGE_LIMIT = 1 - 1;

    private static final Integer DEFAULT_USED_COUNT = 1;
    private static final Integer UPDATED_USED_COUNT = 2;
    private static final Integer SMALLER_USED_COUNT = 1 - 1;

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

    private static final String ENTITY_API_URL = "/api/promotions";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private PromotionRepository promotionRepository;

    @Autowired
    private PromotionMapper promotionMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restPromotionMockMvc;

    private Promotion promotion;

    private Promotion insertedPromotion;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Promotion createEntity() {
        return new Promotion()
            .code(DEFAULT_CODE)
            .description(DEFAULT_DESCRIPTION)
            .startDate(DEFAULT_START_DATE)
            .endDate(DEFAULT_END_DATE)
            .usageLimit(DEFAULT_USAGE_LIMIT)
            .usedCount(DEFAULT_USED_COUNT)
            .createdAt(DEFAULT_CREATED_AT)
            .updatedAt(DEFAULT_UPDATED_AT)
            .isDeleted(DEFAULT_IS_DELETED)
            .deletedAt(DEFAULT_DELETED_AT)
            .deletedBy(DEFAULT_DELETED_BY);
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Promotion createUpdatedEntity() {
        return new Promotion()
            .code(UPDATED_CODE)
            .description(UPDATED_DESCRIPTION)
            .startDate(UPDATED_START_DATE)
            .endDate(UPDATED_END_DATE)
            .usageLimit(UPDATED_USAGE_LIMIT)
            .usedCount(UPDATED_USED_COUNT)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);
    }

    @BeforeEach
    void initTest() {
        promotion = createEntity();
    }

    @AfterEach
    void cleanup() {
        if (insertedPromotion != null) {
            promotionRepository.delete(insertedPromotion);
            insertedPromotion = null;
        }
    }

    @Test
    @Transactional
    void createPromotion() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the Promotion
        PromotionDTO promotionDTO = promotionMapper.toDto(promotion);
        var returnedPromotionDTO = om.readValue(
            restPromotionMockMvc
                .perform(
                    post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(promotionDTO))
                )
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            PromotionDTO.class
        );

        // Validate the Promotion in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        var returnedPromotion = promotionMapper.toEntity(returnedPromotionDTO);
        assertPromotionUpdatableFieldsEquals(returnedPromotion, getPersistedPromotion(returnedPromotion));

        insertedPromotion = returnedPromotion;
    }

    @Test
    @Transactional
    void createPromotionWithExistingId() throws Exception {
        // Create the Promotion with an existing ID
        promotion.setId(1L);
        PromotionDTO promotionDTO = promotionMapper.toDto(promotion);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restPromotionMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(promotionDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Promotion in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkCodeIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        promotion.setCode(null);

        // Create the Promotion, which fails.
        PromotionDTO promotionDTO = promotionMapper.toDto(promotion);

        restPromotionMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(promotionDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkCreatedAtIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        promotion.setCreatedAt(null);

        // Create the Promotion, which fails.
        PromotionDTO promotionDTO = promotionMapper.toDto(promotion);

        restPromotionMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(promotionDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllPromotions() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList
        restPromotionMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(promotion.getId().intValue())))
            .andExpect(jsonPath("$.[*].code").value(hasItem(DEFAULT_CODE)))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION)))
            .andExpect(jsonPath("$.[*].startDate").value(hasItem(DEFAULT_START_DATE.toString())))
            .andExpect(jsonPath("$.[*].endDate").value(hasItem(DEFAULT_END_DATE.toString())))
            .andExpect(jsonPath("$.[*].usageLimit").value(hasItem(DEFAULT_USAGE_LIMIT)))
            .andExpect(jsonPath("$.[*].usedCount").value(hasItem(DEFAULT_USED_COUNT)))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].isDeleted").value(hasItem(DEFAULT_IS_DELETED)))
            .andExpect(jsonPath("$.[*].deletedAt").value(hasItem(DEFAULT_DELETED_AT.toString())))
            .andExpect(jsonPath("$.[*].deletedBy").value(hasItem(DEFAULT_DELETED_BY.toString())));
    }

    @Test
    @Transactional
    void getPromotion() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get the promotion
        restPromotionMockMvc
            .perform(get(ENTITY_API_URL_ID, promotion.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(promotion.getId().intValue()))
            .andExpect(jsonPath("$.code").value(DEFAULT_CODE))
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION))
            .andExpect(jsonPath("$.startDate").value(DEFAULT_START_DATE.toString()))
            .andExpect(jsonPath("$.endDate").value(DEFAULT_END_DATE.toString()))
            .andExpect(jsonPath("$.usageLimit").value(DEFAULT_USAGE_LIMIT))
            .andExpect(jsonPath("$.usedCount").value(DEFAULT_USED_COUNT))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.updatedAt").value(DEFAULT_UPDATED_AT.toString()))
            .andExpect(jsonPath("$.isDeleted").value(DEFAULT_IS_DELETED))
            .andExpect(jsonPath("$.deletedAt").value(DEFAULT_DELETED_AT.toString()))
            .andExpect(jsonPath("$.deletedBy").value(DEFAULT_DELETED_BY.toString()));
    }

    @Test
    @Transactional
    void getPromotionsByIdFiltering() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        Long id = promotion.getId();

        defaultPromotionFiltering("id.equals=" + id, "id.notEquals=" + id);

        defaultPromotionFiltering("id.greaterThanOrEqual=" + id, "id.greaterThan=" + id);

        defaultPromotionFiltering("id.lessThanOrEqual=" + id, "id.lessThan=" + id);
    }

    @Test
    @Transactional
    void getAllPromotionsByCodeIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where code equals to
        defaultPromotionFiltering("code.equals=" + DEFAULT_CODE, "code.equals=" + UPDATED_CODE);
    }

    @Test
    @Transactional
    void getAllPromotionsByCodeIsInShouldWork() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where code in
        defaultPromotionFiltering("code.in=" + DEFAULT_CODE + "," + UPDATED_CODE, "code.in=" + UPDATED_CODE);
    }

    @Test
    @Transactional
    void getAllPromotionsByCodeIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where code is not null
        defaultPromotionFiltering("code.specified=true", "code.specified=false");
    }

    @Test
    @Transactional
    void getAllPromotionsByCodeContainsSomething() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where code contains
        defaultPromotionFiltering("code.contains=" + DEFAULT_CODE, "code.contains=" + UPDATED_CODE);
    }

    @Test
    @Transactional
    void getAllPromotionsByCodeNotContainsSomething() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where code does not contain
        defaultPromotionFiltering("code.doesNotContain=" + UPDATED_CODE, "code.doesNotContain=" + DEFAULT_CODE);
    }

    @Test
    @Transactional
    void getAllPromotionsByDescriptionIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where description equals to
        defaultPromotionFiltering("description.equals=" + DEFAULT_DESCRIPTION, "description.equals=" + UPDATED_DESCRIPTION);
    }

    @Test
    @Transactional
    void getAllPromotionsByDescriptionIsInShouldWork() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where description in
        defaultPromotionFiltering(
            "description.in=" + DEFAULT_DESCRIPTION + "," + UPDATED_DESCRIPTION,
            "description.in=" + UPDATED_DESCRIPTION
        );
    }

    @Test
    @Transactional
    void getAllPromotionsByDescriptionIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where description is not null
        defaultPromotionFiltering("description.specified=true", "description.specified=false");
    }

    @Test
    @Transactional
    void getAllPromotionsByDescriptionContainsSomething() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where description contains
        defaultPromotionFiltering("description.contains=" + DEFAULT_DESCRIPTION, "description.contains=" + UPDATED_DESCRIPTION);
    }

    @Test
    @Transactional
    void getAllPromotionsByDescriptionNotContainsSomething() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where description does not contain
        defaultPromotionFiltering("description.doesNotContain=" + UPDATED_DESCRIPTION, "description.doesNotContain=" + DEFAULT_DESCRIPTION);
    }

    @Test
    @Transactional
    void getAllPromotionsByStartDateIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where startDate equals to
        defaultPromotionFiltering("startDate.equals=" + DEFAULT_START_DATE, "startDate.equals=" + UPDATED_START_DATE);
    }

    @Test
    @Transactional
    void getAllPromotionsByStartDateIsInShouldWork() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where startDate in
        defaultPromotionFiltering("startDate.in=" + DEFAULT_START_DATE + "," + UPDATED_START_DATE, "startDate.in=" + UPDATED_START_DATE);
    }

    @Test
    @Transactional
    void getAllPromotionsByStartDateIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where startDate is not null
        defaultPromotionFiltering("startDate.specified=true", "startDate.specified=false");
    }

    @Test
    @Transactional
    void getAllPromotionsByStartDateIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where startDate is greater than or equal to
        defaultPromotionFiltering(
            "startDate.greaterThanOrEqual=" + DEFAULT_START_DATE,
            "startDate.greaterThanOrEqual=" + UPDATED_START_DATE
        );
    }

    @Test
    @Transactional
    void getAllPromotionsByStartDateIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where startDate is less than or equal to
        defaultPromotionFiltering("startDate.lessThanOrEqual=" + DEFAULT_START_DATE, "startDate.lessThanOrEqual=" + SMALLER_START_DATE);
    }

    @Test
    @Transactional
    void getAllPromotionsByStartDateIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where startDate is less than
        defaultPromotionFiltering("startDate.lessThan=" + UPDATED_START_DATE, "startDate.lessThan=" + DEFAULT_START_DATE);
    }

    @Test
    @Transactional
    void getAllPromotionsByStartDateIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where startDate is greater than
        defaultPromotionFiltering("startDate.greaterThan=" + SMALLER_START_DATE, "startDate.greaterThan=" + DEFAULT_START_DATE);
    }

    @Test
    @Transactional
    void getAllPromotionsByEndDateIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where endDate equals to
        defaultPromotionFiltering("endDate.equals=" + DEFAULT_END_DATE, "endDate.equals=" + UPDATED_END_DATE);
    }

    @Test
    @Transactional
    void getAllPromotionsByEndDateIsInShouldWork() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where endDate in
        defaultPromotionFiltering("endDate.in=" + DEFAULT_END_DATE + "," + UPDATED_END_DATE, "endDate.in=" + UPDATED_END_DATE);
    }

    @Test
    @Transactional
    void getAllPromotionsByEndDateIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where endDate is not null
        defaultPromotionFiltering("endDate.specified=true", "endDate.specified=false");
    }

    @Test
    @Transactional
    void getAllPromotionsByEndDateIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where endDate is greater than or equal to
        defaultPromotionFiltering("endDate.greaterThanOrEqual=" + DEFAULT_END_DATE, "endDate.greaterThanOrEqual=" + UPDATED_END_DATE);
    }

    @Test
    @Transactional
    void getAllPromotionsByEndDateIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where endDate is less than or equal to
        defaultPromotionFiltering("endDate.lessThanOrEqual=" + DEFAULT_END_DATE, "endDate.lessThanOrEqual=" + SMALLER_END_DATE);
    }

    @Test
    @Transactional
    void getAllPromotionsByEndDateIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where endDate is less than
        defaultPromotionFiltering("endDate.lessThan=" + UPDATED_END_DATE, "endDate.lessThan=" + DEFAULT_END_DATE);
    }

    @Test
    @Transactional
    void getAllPromotionsByEndDateIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where endDate is greater than
        defaultPromotionFiltering("endDate.greaterThan=" + SMALLER_END_DATE, "endDate.greaterThan=" + DEFAULT_END_DATE);
    }

    @Test
    @Transactional
    void getAllPromotionsByUsageLimitIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where usageLimit equals to
        defaultPromotionFiltering("usageLimit.equals=" + DEFAULT_USAGE_LIMIT, "usageLimit.equals=" + UPDATED_USAGE_LIMIT);
    }

    @Test
    @Transactional
    void getAllPromotionsByUsageLimitIsInShouldWork() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where usageLimit in
        defaultPromotionFiltering(
            "usageLimit.in=" + DEFAULT_USAGE_LIMIT + "," + UPDATED_USAGE_LIMIT,
            "usageLimit.in=" + UPDATED_USAGE_LIMIT
        );
    }

    @Test
    @Transactional
    void getAllPromotionsByUsageLimitIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where usageLimit is not null
        defaultPromotionFiltering("usageLimit.specified=true", "usageLimit.specified=false");
    }

    @Test
    @Transactional
    void getAllPromotionsByUsageLimitIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where usageLimit is greater than or equal to
        defaultPromotionFiltering(
            "usageLimit.greaterThanOrEqual=" + DEFAULT_USAGE_LIMIT,
            "usageLimit.greaterThanOrEqual=" + UPDATED_USAGE_LIMIT
        );
    }

    @Test
    @Transactional
    void getAllPromotionsByUsageLimitIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where usageLimit is less than or equal to
        defaultPromotionFiltering("usageLimit.lessThanOrEqual=" + DEFAULT_USAGE_LIMIT, "usageLimit.lessThanOrEqual=" + SMALLER_USAGE_LIMIT);
    }

    @Test
    @Transactional
    void getAllPromotionsByUsageLimitIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where usageLimit is less than
        defaultPromotionFiltering("usageLimit.lessThan=" + UPDATED_USAGE_LIMIT, "usageLimit.lessThan=" + DEFAULT_USAGE_LIMIT);
    }

    @Test
    @Transactional
    void getAllPromotionsByUsageLimitIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where usageLimit is greater than
        defaultPromotionFiltering("usageLimit.greaterThan=" + SMALLER_USAGE_LIMIT, "usageLimit.greaterThan=" + DEFAULT_USAGE_LIMIT);
    }

    @Test
    @Transactional
    void getAllPromotionsByUsedCountIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where usedCount equals to
        defaultPromotionFiltering("usedCount.equals=" + DEFAULT_USED_COUNT, "usedCount.equals=" + UPDATED_USED_COUNT);
    }

    @Test
    @Transactional
    void getAllPromotionsByUsedCountIsInShouldWork() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where usedCount in
        defaultPromotionFiltering("usedCount.in=" + DEFAULT_USED_COUNT + "," + UPDATED_USED_COUNT, "usedCount.in=" + UPDATED_USED_COUNT);
    }

    @Test
    @Transactional
    void getAllPromotionsByUsedCountIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where usedCount is not null
        defaultPromotionFiltering("usedCount.specified=true", "usedCount.specified=false");
    }

    @Test
    @Transactional
    void getAllPromotionsByUsedCountIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where usedCount is greater than or equal to
        defaultPromotionFiltering(
            "usedCount.greaterThanOrEqual=" + DEFAULT_USED_COUNT,
            "usedCount.greaterThanOrEqual=" + UPDATED_USED_COUNT
        );
    }

    @Test
    @Transactional
    void getAllPromotionsByUsedCountIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where usedCount is less than or equal to
        defaultPromotionFiltering("usedCount.lessThanOrEqual=" + DEFAULT_USED_COUNT, "usedCount.lessThanOrEqual=" + SMALLER_USED_COUNT);
    }

    @Test
    @Transactional
    void getAllPromotionsByUsedCountIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where usedCount is less than
        defaultPromotionFiltering("usedCount.lessThan=" + UPDATED_USED_COUNT, "usedCount.lessThan=" + DEFAULT_USED_COUNT);
    }

    @Test
    @Transactional
    void getAllPromotionsByUsedCountIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where usedCount is greater than
        defaultPromotionFiltering("usedCount.greaterThan=" + SMALLER_USED_COUNT, "usedCount.greaterThan=" + DEFAULT_USED_COUNT);
    }

    @Test
    @Transactional
    void getAllPromotionsByCreatedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where createdAt equals to
        defaultPromotionFiltering("createdAt.equals=" + DEFAULT_CREATED_AT, "createdAt.equals=" + UPDATED_CREATED_AT);
    }

    @Test
    @Transactional
    void getAllPromotionsByCreatedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where createdAt in
        defaultPromotionFiltering("createdAt.in=" + DEFAULT_CREATED_AT + "," + UPDATED_CREATED_AT, "createdAt.in=" + UPDATED_CREATED_AT);
    }

    @Test
    @Transactional
    void getAllPromotionsByCreatedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where createdAt is not null
        defaultPromotionFiltering("createdAt.specified=true", "createdAt.specified=false");
    }

    @Test
    @Transactional
    void getAllPromotionsByUpdatedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where updatedAt equals to
        defaultPromotionFiltering("updatedAt.equals=" + DEFAULT_UPDATED_AT, "updatedAt.equals=" + UPDATED_UPDATED_AT);
    }

    @Test
    @Transactional
    void getAllPromotionsByUpdatedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where updatedAt in
        defaultPromotionFiltering("updatedAt.in=" + DEFAULT_UPDATED_AT + "," + UPDATED_UPDATED_AT, "updatedAt.in=" + UPDATED_UPDATED_AT);
    }

    @Test
    @Transactional
    void getAllPromotionsByUpdatedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where updatedAt is not null
        defaultPromotionFiltering("updatedAt.specified=true", "updatedAt.specified=false");
    }

    @Test
    @Transactional
    void getAllPromotionsByIsDeletedIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where isDeleted equals to
        defaultPromotionFiltering("isDeleted.equals=" + DEFAULT_IS_DELETED, "isDeleted.equals=" + UPDATED_IS_DELETED);
    }

    @Test
    @Transactional
    void getAllPromotionsByIsDeletedIsInShouldWork() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where isDeleted in
        defaultPromotionFiltering("isDeleted.in=" + DEFAULT_IS_DELETED + "," + UPDATED_IS_DELETED, "isDeleted.in=" + UPDATED_IS_DELETED);
    }

    @Test
    @Transactional
    void getAllPromotionsByIsDeletedIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where isDeleted is not null
        defaultPromotionFiltering("isDeleted.specified=true", "isDeleted.specified=false");
    }

    @Test
    @Transactional
    void getAllPromotionsByDeletedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where deletedAt equals to
        defaultPromotionFiltering("deletedAt.equals=" + DEFAULT_DELETED_AT, "deletedAt.equals=" + UPDATED_DELETED_AT);
    }

    @Test
    @Transactional
    void getAllPromotionsByDeletedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where deletedAt in
        defaultPromotionFiltering("deletedAt.in=" + DEFAULT_DELETED_AT + "," + UPDATED_DELETED_AT, "deletedAt.in=" + UPDATED_DELETED_AT);
    }

    @Test
    @Transactional
    void getAllPromotionsByDeletedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where deletedAt is not null
        defaultPromotionFiltering("deletedAt.specified=true", "deletedAt.specified=false");
    }

    @Test
    @Transactional
    void getAllPromotionsByDeletedByIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where deletedBy equals to
        defaultPromotionFiltering("deletedBy.equals=" + DEFAULT_DELETED_BY, "deletedBy.equals=" + UPDATED_DELETED_BY);
    }

    @Test
    @Transactional
    void getAllPromotionsByDeletedByIsInShouldWork() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where deletedBy in
        defaultPromotionFiltering("deletedBy.in=" + DEFAULT_DELETED_BY + "," + UPDATED_DELETED_BY, "deletedBy.in=" + UPDATED_DELETED_BY);
    }

    @Test
    @Transactional
    void getAllPromotionsByDeletedByIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        // Get all the promotionList where deletedBy is not null
        defaultPromotionFiltering("deletedBy.specified=true", "deletedBy.specified=false");
    }

    @Test
    @Transactional
    void getAllPromotionsByBannerImgIsEqualToSomething() throws Exception {
        FilePromotion bannerImg;
        if (TestUtil.findAll(em, FilePromotion.class).isEmpty()) {
            promotionRepository.saveAndFlush(promotion);
            bannerImg = FilePromotionResourceIT.createEntity();
        } else {
            bannerImg = TestUtil.findAll(em, FilePromotion.class).get(0);
        }
        em.persist(bannerImg);
        em.flush();
        promotion.setBannerImg(bannerImg);
        promotionRepository.saveAndFlush(promotion);
        Long bannerImgId = bannerImg.getId();
        // Get all the promotionList where bannerImg equals to bannerImgId
        defaultPromotionShouldBeFound("bannerImgId.equals=" + bannerImgId);

        // Get all the promotionList where bannerImg equals to (bannerImgId + 1)
        defaultPromotionShouldNotBeFound("bannerImgId.equals=" + (bannerImgId + 1));
    }

    private void defaultPromotionFiltering(String shouldBeFound, String shouldNotBeFound) throws Exception {
        defaultPromotionShouldBeFound(shouldBeFound);
        defaultPromotionShouldNotBeFound(shouldNotBeFound);
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultPromotionShouldBeFound(String filter) throws Exception {
        restPromotionMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(promotion.getId().intValue())))
            .andExpect(jsonPath("$.[*].code").value(hasItem(DEFAULT_CODE)))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION)))
            .andExpect(jsonPath("$.[*].startDate").value(hasItem(DEFAULT_START_DATE.toString())))
            .andExpect(jsonPath("$.[*].endDate").value(hasItem(DEFAULT_END_DATE.toString())))
            .andExpect(jsonPath("$.[*].usageLimit").value(hasItem(DEFAULT_USAGE_LIMIT)))
            .andExpect(jsonPath("$.[*].usedCount").value(hasItem(DEFAULT_USED_COUNT)))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].isDeleted").value(hasItem(DEFAULT_IS_DELETED)))
            .andExpect(jsonPath("$.[*].deletedAt").value(hasItem(DEFAULT_DELETED_AT.toString())))
            .andExpect(jsonPath("$.[*].deletedBy").value(hasItem(DEFAULT_DELETED_BY.toString())));

        // Check, that the count call also returns 1
        restPromotionMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("1"));
    }

    /**
     * Executes the search, and checks that the default entity is not returned.
     */
    private void defaultPromotionShouldNotBeFound(String filter) throws Exception {
        restPromotionMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());

        // Check, that the count call also returns 0
        restPromotionMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("0"));
    }

    @Test
    @Transactional
    void getNonExistingPromotion() throws Exception {
        // Get the promotion
        restPromotionMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingPromotion() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the promotion
        Promotion updatedPromotion = promotionRepository.findById(promotion.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedPromotion are not directly saved in db
        em.detach(updatedPromotion);
        updatedPromotion
            .code(UPDATED_CODE)
            .description(UPDATED_DESCRIPTION)
            .startDate(UPDATED_START_DATE)
            .endDate(UPDATED_END_DATE)
            .usageLimit(UPDATED_USAGE_LIMIT)
            .usedCount(UPDATED_USED_COUNT)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);
        PromotionDTO promotionDTO = promotionMapper.toDto(updatedPromotion);

        restPromotionMockMvc
            .perform(
                put(ENTITY_API_URL_ID, promotionDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(promotionDTO))
            )
            .andExpect(status().isOk());

        // Validate the Promotion in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedPromotionToMatchAllProperties(updatedPromotion);
    }

    @Test
    @Transactional
    void putNonExistingPromotion() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        promotion.setId(longCount.incrementAndGet());

        // Create the Promotion
        PromotionDTO promotionDTO = promotionMapper.toDto(promotion);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restPromotionMockMvc
            .perform(
                put(ENTITY_API_URL_ID, promotionDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(promotionDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Promotion in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchPromotion() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        promotion.setId(longCount.incrementAndGet());

        // Create the Promotion
        PromotionDTO promotionDTO = promotionMapper.toDto(promotion);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restPromotionMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(promotionDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Promotion in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamPromotion() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        promotion.setId(longCount.incrementAndGet());

        // Create the Promotion
        PromotionDTO promotionDTO = promotionMapper.toDto(promotion);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restPromotionMockMvc
            .perform(put(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(promotionDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Promotion in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdatePromotionWithPatch() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the promotion using partial update
        Promotion partialUpdatedPromotion = new Promotion();
        partialUpdatedPromotion.setId(promotion.getId());

        partialUpdatedPromotion
            .code(UPDATED_CODE)
            .description(UPDATED_DESCRIPTION)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedBy(UPDATED_DELETED_BY);

        restPromotionMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedPromotion.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedPromotion))
            )
            .andExpect(status().isOk());

        // Validate the Promotion in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPromotionUpdatableFieldsEquals(
            createUpdateProxyForBean(partialUpdatedPromotion, promotion),
            getPersistedPromotion(promotion)
        );
    }

    @Test
    @Transactional
    void fullUpdatePromotionWithPatch() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the promotion using partial update
        Promotion partialUpdatedPromotion = new Promotion();
        partialUpdatedPromotion.setId(promotion.getId());

        partialUpdatedPromotion
            .code(UPDATED_CODE)
            .description(UPDATED_DESCRIPTION)
            .startDate(UPDATED_START_DATE)
            .endDate(UPDATED_END_DATE)
            .usageLimit(UPDATED_USAGE_LIMIT)
            .usedCount(UPDATED_USED_COUNT)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);

        restPromotionMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedPromotion.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedPromotion))
            )
            .andExpect(status().isOk());

        // Validate the Promotion in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPromotionUpdatableFieldsEquals(partialUpdatedPromotion, getPersistedPromotion(partialUpdatedPromotion));
    }

    @Test
    @Transactional
    void patchNonExistingPromotion() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        promotion.setId(longCount.incrementAndGet());

        // Create the Promotion
        PromotionDTO promotionDTO = promotionMapper.toDto(promotion);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restPromotionMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, promotionDTO.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(promotionDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Promotion in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchPromotion() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        promotion.setId(longCount.incrementAndGet());

        // Create the Promotion
        PromotionDTO promotionDTO = promotionMapper.toDto(promotion);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restPromotionMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(promotionDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Promotion in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamPromotion() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        promotion.setId(longCount.incrementAndGet());

        // Create the Promotion
        PromotionDTO promotionDTO = promotionMapper.toDto(promotion);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restPromotionMockMvc
            .perform(
                patch(ENTITY_API_URL).with(csrf()).contentType("application/merge-patch+json").content(om.writeValueAsBytes(promotionDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the Promotion in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deletePromotion() throws Exception {
        // Initialize the database
        insertedPromotion = promotionRepository.saveAndFlush(promotion);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the promotion
        restPromotionMockMvc
            .perform(delete(ENTITY_API_URL_ID, promotion.getId()).with(csrf()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return promotionRepository.count();
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

    protected Promotion getPersistedPromotion(Promotion promotion) {
        return promotionRepository.findById(promotion.getId()).orElseThrow();
    }

    protected void assertPersistedPromotionToMatchAllProperties(Promotion expectedPromotion) {
        assertPromotionAllPropertiesEquals(expectedPromotion, getPersistedPromotion(expectedPromotion));
    }

    protected void assertPersistedPromotionToMatchUpdatableProperties(Promotion expectedPromotion) {
        assertPromotionAllUpdatablePropertiesEquals(expectedPromotion, getPersistedPromotion(expectedPromotion));
    }
}
