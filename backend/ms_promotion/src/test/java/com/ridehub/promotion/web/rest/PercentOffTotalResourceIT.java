package com.ridehub.promotion.web.rest;

import static com.ridehub.promotion.domain.PercentOffTotalAsserts.*;
import static com.ridehub.promotion.web.rest.TestUtil.createUpdateProxyForBean;
import static com.ridehub.promotion.web.rest.TestUtil.sameNumber;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ridehub.promotion.IntegrationTest;
import com.ridehub.promotion.domain.PercentOffTotal;
import com.ridehub.promotion.domain.Promotion;
import com.ridehub.promotion.repository.PercentOffTotalRepository;
import com.ridehub.promotion.service.dto.PercentOffTotalDTO;
import com.ridehub.promotion.service.mapper.PercentOffTotalMapper;
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
 * Integration tests for the {@link PercentOffTotalResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class PercentOffTotalResourceIT {

    private static final Integer DEFAULT_PERCENT = 1;
    private static final Integer UPDATED_PERCENT = 2;
    private static final Integer SMALLER_PERCENT = 1 - 1;

    private static final BigDecimal DEFAULT_MAX_OFF = new BigDecimal(1);
    private static final BigDecimal UPDATED_MAX_OFF = new BigDecimal(2);
    private static final BigDecimal SMALLER_MAX_OFF = new BigDecimal(1 - 1);

    private static final BigDecimal DEFAULT_MIN_PRICE = new BigDecimal(1);
    private static final BigDecimal UPDATED_MIN_PRICE = new BigDecimal(2);
    private static final BigDecimal SMALLER_MIN_PRICE = new BigDecimal(1 - 1);

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

    private static final String ENTITY_API_URL = "/api/percent-off-totals";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private PercentOffTotalRepository percentOffTotalRepository;

    @Autowired
    private PercentOffTotalMapper percentOffTotalMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restPercentOffTotalMockMvc;

    private PercentOffTotal percentOffTotal;

    private PercentOffTotal insertedPercentOffTotal;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static PercentOffTotal createEntity(EntityManager em) {
        PercentOffTotal percentOffTotal = new PercentOffTotal()
            .percent(DEFAULT_PERCENT)
            .maxOff(DEFAULT_MAX_OFF)
            .minPrice(DEFAULT_MIN_PRICE)
            .createdAt(DEFAULT_CREATED_AT)
            .updatedAt(DEFAULT_UPDATED_AT)
            .isDeleted(DEFAULT_IS_DELETED)
            .deletedAt(DEFAULT_DELETED_AT)
            .deletedBy(DEFAULT_DELETED_BY);
        // Add required entity
        Promotion promotion;
        if (TestUtil.findAll(em, Promotion.class).isEmpty()) {
            promotion = PromotionResourceIT.createEntity();
            em.persist(promotion);
            em.flush();
        } else {
            promotion = TestUtil.findAll(em, Promotion.class).get(0);
        }
        percentOffTotal.setPromotion(promotion);
        return percentOffTotal;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static PercentOffTotal createUpdatedEntity(EntityManager em) {
        PercentOffTotal updatedPercentOffTotal = new PercentOffTotal()
            .percent(UPDATED_PERCENT)
            .maxOff(UPDATED_MAX_OFF)
            .minPrice(UPDATED_MIN_PRICE)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);
        // Add required entity
        Promotion promotion;
        if (TestUtil.findAll(em, Promotion.class).isEmpty()) {
            promotion = PromotionResourceIT.createUpdatedEntity();
            em.persist(promotion);
            em.flush();
        } else {
            promotion = TestUtil.findAll(em, Promotion.class).get(0);
        }
        updatedPercentOffTotal.setPromotion(promotion);
        return updatedPercentOffTotal;
    }

    @BeforeEach
    void initTest() {
        percentOffTotal = createEntity(em);
    }

    @AfterEach
    void cleanup() {
        if (insertedPercentOffTotal != null) {
            percentOffTotalRepository.delete(insertedPercentOffTotal);
            insertedPercentOffTotal = null;
        }
    }

    @Test
    @Transactional
    void createPercentOffTotal() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the PercentOffTotal
        PercentOffTotalDTO percentOffTotalDTO = percentOffTotalMapper.toDto(percentOffTotal);
        var returnedPercentOffTotalDTO = om.readValue(
            restPercentOffTotalMockMvc
                .perform(
                    post(ENTITY_API_URL)
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsBytes(percentOffTotalDTO))
                )
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            PercentOffTotalDTO.class
        );

        // Validate the PercentOffTotal in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        var returnedPercentOffTotal = percentOffTotalMapper.toEntity(returnedPercentOffTotalDTO);
        assertPercentOffTotalUpdatableFieldsEquals(returnedPercentOffTotal, getPersistedPercentOffTotal(returnedPercentOffTotal));

        insertedPercentOffTotal = returnedPercentOffTotal;
    }

    @Test
    @Transactional
    void createPercentOffTotalWithExistingId() throws Exception {
        // Create the PercentOffTotal with an existing ID
        percentOffTotal.setId(1L);
        PercentOffTotalDTO percentOffTotalDTO = percentOffTotalMapper.toDto(percentOffTotal);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restPercentOffTotalMockMvc
            .perform(
                post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(percentOffTotalDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the PercentOffTotal in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkPercentIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        percentOffTotal.setPercent(null);

        // Create the PercentOffTotal, which fails.
        PercentOffTotalDTO percentOffTotalDTO = percentOffTotalMapper.toDto(percentOffTotal);

        restPercentOffTotalMockMvc
            .perform(
                post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(percentOffTotalDTO))
            )
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkCreatedAtIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        percentOffTotal.setCreatedAt(null);

        // Create the PercentOffTotal, which fails.
        PercentOffTotalDTO percentOffTotalDTO = percentOffTotalMapper.toDto(percentOffTotal);

        restPercentOffTotalMockMvc
            .perform(
                post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(percentOffTotalDTO))
            )
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllPercentOffTotals() throws Exception {
        // Initialize the database
        insertedPercentOffTotal = percentOffTotalRepository.saveAndFlush(percentOffTotal);

        // Get all the percentOffTotalList
        restPercentOffTotalMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(percentOffTotal.getId().intValue())))
            .andExpect(jsonPath("$.[*].percent").value(hasItem(DEFAULT_PERCENT)))
            .andExpect(jsonPath("$.[*].maxOff").value(hasItem(sameNumber(DEFAULT_MAX_OFF))))
            .andExpect(jsonPath("$.[*].minPrice").value(hasItem(sameNumber(DEFAULT_MIN_PRICE))))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].isDeleted").value(hasItem(DEFAULT_IS_DELETED)))
            .andExpect(jsonPath("$.[*].deletedAt").value(hasItem(DEFAULT_DELETED_AT.toString())))
            .andExpect(jsonPath("$.[*].deletedBy").value(hasItem(DEFAULT_DELETED_BY.toString())));
    }

    @Test
    @Transactional
    void getPercentOffTotal() throws Exception {
        // Initialize the database
        insertedPercentOffTotal = percentOffTotalRepository.saveAndFlush(percentOffTotal);

        // Get the percentOffTotal
        restPercentOffTotalMockMvc
            .perform(get(ENTITY_API_URL_ID, percentOffTotal.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(percentOffTotal.getId().intValue()))
            .andExpect(jsonPath("$.percent").value(DEFAULT_PERCENT))
            .andExpect(jsonPath("$.maxOff").value(sameNumber(DEFAULT_MAX_OFF)))
            .andExpect(jsonPath("$.minPrice").value(sameNumber(DEFAULT_MIN_PRICE)))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.updatedAt").value(DEFAULT_UPDATED_AT.toString()))
            .andExpect(jsonPath("$.isDeleted").value(DEFAULT_IS_DELETED))
            .andExpect(jsonPath("$.deletedAt").value(DEFAULT_DELETED_AT.toString()))
            .andExpect(jsonPath("$.deletedBy").value(DEFAULT_DELETED_BY.toString()));
    }

    @Test
    @Transactional
    void getPercentOffTotalsByIdFiltering() throws Exception {
        // Initialize the database
        insertedPercentOffTotal = percentOffTotalRepository.saveAndFlush(percentOffTotal);

        Long id = percentOffTotal.getId();

        defaultPercentOffTotalFiltering("id.equals=" + id, "id.notEquals=" + id);

        defaultPercentOffTotalFiltering("id.greaterThanOrEqual=" + id, "id.greaterThan=" + id);

        defaultPercentOffTotalFiltering("id.lessThanOrEqual=" + id, "id.lessThan=" + id);
    }

    @Test
    @Transactional
    void getAllPercentOffTotalsByPercentIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedPercentOffTotal = percentOffTotalRepository.saveAndFlush(percentOffTotal);

        // Get all the percentOffTotalList where percent equals to
        defaultPercentOffTotalFiltering("percent.equals=" + DEFAULT_PERCENT, "percent.equals=" + UPDATED_PERCENT);
    }

    @Test
    @Transactional
    void getAllPercentOffTotalsByPercentIsInShouldWork() throws Exception {
        // Initialize the database
        insertedPercentOffTotal = percentOffTotalRepository.saveAndFlush(percentOffTotal);

        // Get all the percentOffTotalList where percent in
        defaultPercentOffTotalFiltering("percent.in=" + DEFAULT_PERCENT + "," + UPDATED_PERCENT, "percent.in=" + UPDATED_PERCENT);
    }

    @Test
    @Transactional
    void getAllPercentOffTotalsByPercentIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedPercentOffTotal = percentOffTotalRepository.saveAndFlush(percentOffTotal);

        // Get all the percentOffTotalList where percent is not null
        defaultPercentOffTotalFiltering("percent.specified=true", "percent.specified=false");
    }

    @Test
    @Transactional
    void getAllPercentOffTotalsByPercentIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedPercentOffTotal = percentOffTotalRepository.saveAndFlush(percentOffTotal);

        // Get all the percentOffTotalList where percent is greater than or equal to
        defaultPercentOffTotalFiltering(
            "percent.greaterThanOrEqual=" + DEFAULT_PERCENT,
            "percent.greaterThanOrEqual=" + (DEFAULT_PERCENT + 1)
        );
    }

    @Test
    @Transactional
    void getAllPercentOffTotalsByPercentIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedPercentOffTotal = percentOffTotalRepository.saveAndFlush(percentOffTotal);

        // Get all the percentOffTotalList where percent is less than or equal to
        defaultPercentOffTotalFiltering("percent.lessThanOrEqual=" + DEFAULT_PERCENT, "percent.lessThanOrEqual=" + SMALLER_PERCENT);
    }

    @Test
    @Transactional
    void getAllPercentOffTotalsByPercentIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedPercentOffTotal = percentOffTotalRepository.saveAndFlush(percentOffTotal);

        // Get all the percentOffTotalList where percent is less than
        defaultPercentOffTotalFiltering("percent.lessThan=" + (DEFAULT_PERCENT + 1), "percent.lessThan=" + DEFAULT_PERCENT);
    }

    @Test
    @Transactional
    void getAllPercentOffTotalsByPercentIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedPercentOffTotal = percentOffTotalRepository.saveAndFlush(percentOffTotal);

        // Get all the percentOffTotalList where percent is greater than
        defaultPercentOffTotalFiltering("percent.greaterThan=" + SMALLER_PERCENT, "percent.greaterThan=" + DEFAULT_PERCENT);
    }

    @Test
    @Transactional
    void getAllPercentOffTotalsByMaxOffIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedPercentOffTotal = percentOffTotalRepository.saveAndFlush(percentOffTotal);

        // Get all the percentOffTotalList where maxOff equals to
        defaultPercentOffTotalFiltering("maxOff.equals=" + DEFAULT_MAX_OFF, "maxOff.equals=" + UPDATED_MAX_OFF);
    }

    @Test
    @Transactional
    void getAllPercentOffTotalsByMaxOffIsInShouldWork() throws Exception {
        // Initialize the database
        insertedPercentOffTotal = percentOffTotalRepository.saveAndFlush(percentOffTotal);

        // Get all the percentOffTotalList where maxOff in
        defaultPercentOffTotalFiltering("maxOff.in=" + DEFAULT_MAX_OFF + "," + UPDATED_MAX_OFF, "maxOff.in=" + UPDATED_MAX_OFF);
    }

    @Test
    @Transactional
    void getAllPercentOffTotalsByMaxOffIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedPercentOffTotal = percentOffTotalRepository.saveAndFlush(percentOffTotal);

        // Get all the percentOffTotalList where maxOff is not null
        defaultPercentOffTotalFiltering("maxOff.specified=true", "maxOff.specified=false");
    }

    @Test
    @Transactional
    void getAllPercentOffTotalsByMaxOffIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedPercentOffTotal = percentOffTotalRepository.saveAndFlush(percentOffTotal);

        // Get all the percentOffTotalList where maxOff is greater than or equal to
        defaultPercentOffTotalFiltering("maxOff.greaterThanOrEqual=" + DEFAULT_MAX_OFF, "maxOff.greaterThanOrEqual=" + UPDATED_MAX_OFF);
    }

    @Test
    @Transactional
    void getAllPercentOffTotalsByMaxOffIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedPercentOffTotal = percentOffTotalRepository.saveAndFlush(percentOffTotal);

        // Get all the percentOffTotalList where maxOff is less than or equal to
        defaultPercentOffTotalFiltering("maxOff.lessThanOrEqual=" + DEFAULT_MAX_OFF, "maxOff.lessThanOrEqual=" + SMALLER_MAX_OFF);
    }

    @Test
    @Transactional
    void getAllPercentOffTotalsByMaxOffIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedPercentOffTotal = percentOffTotalRepository.saveAndFlush(percentOffTotal);

        // Get all the percentOffTotalList where maxOff is less than
        defaultPercentOffTotalFiltering("maxOff.lessThan=" + UPDATED_MAX_OFF, "maxOff.lessThan=" + DEFAULT_MAX_OFF);
    }

    @Test
    @Transactional
    void getAllPercentOffTotalsByMaxOffIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedPercentOffTotal = percentOffTotalRepository.saveAndFlush(percentOffTotal);

        // Get all the percentOffTotalList where maxOff is greater than
        defaultPercentOffTotalFiltering("maxOff.greaterThan=" + SMALLER_MAX_OFF, "maxOff.greaterThan=" + DEFAULT_MAX_OFF);
    }

    @Test
    @Transactional
    void getAllPercentOffTotalsByMinPriceIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedPercentOffTotal = percentOffTotalRepository.saveAndFlush(percentOffTotal);

        // Get all the percentOffTotalList where minPrice equals to
        defaultPercentOffTotalFiltering("minPrice.equals=" + DEFAULT_MIN_PRICE, "minPrice.equals=" + UPDATED_MIN_PRICE);
    }

    @Test
    @Transactional
    void getAllPercentOffTotalsByMinPriceIsInShouldWork() throws Exception {
        // Initialize the database
        insertedPercentOffTotal = percentOffTotalRepository.saveAndFlush(percentOffTotal);

        // Get all the percentOffTotalList where minPrice in
        defaultPercentOffTotalFiltering("minPrice.in=" + DEFAULT_MIN_PRICE + "," + UPDATED_MIN_PRICE, "minPrice.in=" + UPDATED_MIN_PRICE);
    }

    @Test
    @Transactional
    void getAllPercentOffTotalsByMinPriceIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedPercentOffTotal = percentOffTotalRepository.saveAndFlush(percentOffTotal);

        // Get all the percentOffTotalList where minPrice is not null
        defaultPercentOffTotalFiltering("minPrice.specified=true", "minPrice.specified=false");
    }

    @Test
    @Transactional
    void getAllPercentOffTotalsByMinPriceIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedPercentOffTotal = percentOffTotalRepository.saveAndFlush(percentOffTotal);

        // Get all the percentOffTotalList where minPrice is greater than or equal to
        defaultPercentOffTotalFiltering(
            "minPrice.greaterThanOrEqual=" + DEFAULT_MIN_PRICE,
            "minPrice.greaterThanOrEqual=" + UPDATED_MIN_PRICE
        );
    }

    @Test
    @Transactional
    void getAllPercentOffTotalsByMinPriceIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedPercentOffTotal = percentOffTotalRepository.saveAndFlush(percentOffTotal);

        // Get all the percentOffTotalList where minPrice is less than or equal to
        defaultPercentOffTotalFiltering("minPrice.lessThanOrEqual=" + DEFAULT_MIN_PRICE, "minPrice.lessThanOrEqual=" + SMALLER_MIN_PRICE);
    }

    @Test
    @Transactional
    void getAllPercentOffTotalsByMinPriceIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedPercentOffTotal = percentOffTotalRepository.saveAndFlush(percentOffTotal);

        // Get all the percentOffTotalList where minPrice is less than
        defaultPercentOffTotalFiltering("minPrice.lessThan=" + UPDATED_MIN_PRICE, "minPrice.lessThan=" + DEFAULT_MIN_PRICE);
    }

    @Test
    @Transactional
    void getAllPercentOffTotalsByMinPriceIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedPercentOffTotal = percentOffTotalRepository.saveAndFlush(percentOffTotal);

        // Get all the percentOffTotalList where minPrice is greater than
        defaultPercentOffTotalFiltering("minPrice.greaterThan=" + SMALLER_MIN_PRICE, "minPrice.greaterThan=" + DEFAULT_MIN_PRICE);
    }

    @Test
    @Transactional
    void getAllPercentOffTotalsByCreatedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedPercentOffTotal = percentOffTotalRepository.saveAndFlush(percentOffTotal);

        // Get all the percentOffTotalList where createdAt equals to
        defaultPercentOffTotalFiltering("createdAt.equals=" + DEFAULT_CREATED_AT, "createdAt.equals=" + UPDATED_CREATED_AT);
    }

    @Test
    @Transactional
    void getAllPercentOffTotalsByCreatedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedPercentOffTotal = percentOffTotalRepository.saveAndFlush(percentOffTotal);

        // Get all the percentOffTotalList where createdAt in
        defaultPercentOffTotalFiltering(
            "createdAt.in=" + DEFAULT_CREATED_AT + "," + UPDATED_CREATED_AT,
            "createdAt.in=" + UPDATED_CREATED_AT
        );
    }

    @Test
    @Transactional
    void getAllPercentOffTotalsByCreatedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedPercentOffTotal = percentOffTotalRepository.saveAndFlush(percentOffTotal);

        // Get all the percentOffTotalList where createdAt is not null
        defaultPercentOffTotalFiltering("createdAt.specified=true", "createdAt.specified=false");
    }

    @Test
    @Transactional
    void getAllPercentOffTotalsByUpdatedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedPercentOffTotal = percentOffTotalRepository.saveAndFlush(percentOffTotal);

        // Get all the percentOffTotalList where updatedAt equals to
        defaultPercentOffTotalFiltering("updatedAt.equals=" + DEFAULT_UPDATED_AT, "updatedAt.equals=" + UPDATED_UPDATED_AT);
    }

    @Test
    @Transactional
    void getAllPercentOffTotalsByUpdatedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedPercentOffTotal = percentOffTotalRepository.saveAndFlush(percentOffTotal);

        // Get all the percentOffTotalList where updatedAt in
        defaultPercentOffTotalFiltering(
            "updatedAt.in=" + DEFAULT_UPDATED_AT + "," + UPDATED_UPDATED_AT,
            "updatedAt.in=" + UPDATED_UPDATED_AT
        );
    }

    @Test
    @Transactional
    void getAllPercentOffTotalsByUpdatedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedPercentOffTotal = percentOffTotalRepository.saveAndFlush(percentOffTotal);

        // Get all the percentOffTotalList where updatedAt is not null
        defaultPercentOffTotalFiltering("updatedAt.specified=true", "updatedAt.specified=false");
    }

    @Test
    @Transactional
    void getAllPercentOffTotalsByIsDeletedIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedPercentOffTotal = percentOffTotalRepository.saveAndFlush(percentOffTotal);

        // Get all the percentOffTotalList where isDeleted equals to
        defaultPercentOffTotalFiltering("isDeleted.equals=" + DEFAULT_IS_DELETED, "isDeleted.equals=" + UPDATED_IS_DELETED);
    }

    @Test
    @Transactional
    void getAllPercentOffTotalsByIsDeletedIsInShouldWork() throws Exception {
        // Initialize the database
        insertedPercentOffTotal = percentOffTotalRepository.saveAndFlush(percentOffTotal);

        // Get all the percentOffTotalList where isDeleted in
        defaultPercentOffTotalFiltering(
            "isDeleted.in=" + DEFAULT_IS_DELETED + "," + UPDATED_IS_DELETED,
            "isDeleted.in=" + UPDATED_IS_DELETED
        );
    }

    @Test
    @Transactional
    void getAllPercentOffTotalsByIsDeletedIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedPercentOffTotal = percentOffTotalRepository.saveAndFlush(percentOffTotal);

        // Get all the percentOffTotalList where isDeleted is not null
        defaultPercentOffTotalFiltering("isDeleted.specified=true", "isDeleted.specified=false");
    }

    @Test
    @Transactional
    void getAllPercentOffTotalsByDeletedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedPercentOffTotal = percentOffTotalRepository.saveAndFlush(percentOffTotal);

        // Get all the percentOffTotalList where deletedAt equals to
        defaultPercentOffTotalFiltering("deletedAt.equals=" + DEFAULT_DELETED_AT, "deletedAt.equals=" + UPDATED_DELETED_AT);
    }

    @Test
    @Transactional
    void getAllPercentOffTotalsByDeletedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedPercentOffTotal = percentOffTotalRepository.saveAndFlush(percentOffTotal);

        // Get all the percentOffTotalList where deletedAt in
        defaultPercentOffTotalFiltering(
            "deletedAt.in=" + DEFAULT_DELETED_AT + "," + UPDATED_DELETED_AT,
            "deletedAt.in=" + UPDATED_DELETED_AT
        );
    }

    @Test
    @Transactional
    void getAllPercentOffTotalsByDeletedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedPercentOffTotal = percentOffTotalRepository.saveAndFlush(percentOffTotal);

        // Get all the percentOffTotalList where deletedAt is not null
        defaultPercentOffTotalFiltering("deletedAt.specified=true", "deletedAt.specified=false");
    }

    @Test
    @Transactional
    void getAllPercentOffTotalsByDeletedByIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedPercentOffTotal = percentOffTotalRepository.saveAndFlush(percentOffTotal);

        // Get all the percentOffTotalList where deletedBy equals to
        defaultPercentOffTotalFiltering("deletedBy.equals=" + DEFAULT_DELETED_BY, "deletedBy.equals=" + UPDATED_DELETED_BY);
    }

    @Test
    @Transactional
    void getAllPercentOffTotalsByDeletedByIsInShouldWork() throws Exception {
        // Initialize the database
        insertedPercentOffTotal = percentOffTotalRepository.saveAndFlush(percentOffTotal);

        // Get all the percentOffTotalList where deletedBy in
        defaultPercentOffTotalFiltering(
            "deletedBy.in=" + DEFAULT_DELETED_BY + "," + UPDATED_DELETED_BY,
            "deletedBy.in=" + UPDATED_DELETED_BY
        );
    }

    @Test
    @Transactional
    void getAllPercentOffTotalsByDeletedByIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedPercentOffTotal = percentOffTotalRepository.saveAndFlush(percentOffTotal);

        // Get all the percentOffTotalList where deletedBy is not null
        defaultPercentOffTotalFiltering("deletedBy.specified=true", "deletedBy.specified=false");
    }

    @Test
    @Transactional
    void getAllPercentOffTotalsByPromotionIsEqualToSomething() throws Exception {
        Promotion promotion;
        if (TestUtil.findAll(em, Promotion.class).isEmpty()) {
            percentOffTotalRepository.saveAndFlush(percentOffTotal);
            promotion = PromotionResourceIT.createEntity();
        } else {
            promotion = TestUtil.findAll(em, Promotion.class).get(0);
        }
        em.persist(promotion);
        em.flush();
        percentOffTotal.setPromotion(promotion);
        percentOffTotalRepository.saveAndFlush(percentOffTotal);
        Long promotionId = promotion.getId();
        // Get all the percentOffTotalList where promotion equals to promotionId
        defaultPercentOffTotalShouldBeFound("promotionId.equals=" + promotionId);

        // Get all the percentOffTotalList where promotion equals to (promotionId + 1)
        defaultPercentOffTotalShouldNotBeFound("promotionId.equals=" + (promotionId + 1));
    }

    private void defaultPercentOffTotalFiltering(String shouldBeFound, String shouldNotBeFound) throws Exception {
        defaultPercentOffTotalShouldBeFound(shouldBeFound);
        defaultPercentOffTotalShouldNotBeFound(shouldNotBeFound);
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultPercentOffTotalShouldBeFound(String filter) throws Exception {
        restPercentOffTotalMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(percentOffTotal.getId().intValue())))
            .andExpect(jsonPath("$.[*].percent").value(hasItem(DEFAULT_PERCENT)))
            .andExpect(jsonPath("$.[*].maxOff").value(hasItem(sameNumber(DEFAULT_MAX_OFF))))
            .andExpect(jsonPath("$.[*].minPrice").value(hasItem(sameNumber(DEFAULT_MIN_PRICE))))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].isDeleted").value(hasItem(DEFAULT_IS_DELETED)))
            .andExpect(jsonPath("$.[*].deletedAt").value(hasItem(DEFAULT_DELETED_AT.toString())))
            .andExpect(jsonPath("$.[*].deletedBy").value(hasItem(DEFAULT_DELETED_BY.toString())));

        // Check, that the count call also returns 1
        restPercentOffTotalMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("1"));
    }

    /**
     * Executes the search, and checks that the default entity is not returned.
     */
    private void defaultPercentOffTotalShouldNotBeFound(String filter) throws Exception {
        restPercentOffTotalMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());

        // Check, that the count call also returns 0
        restPercentOffTotalMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("0"));
    }

    @Test
    @Transactional
    void getNonExistingPercentOffTotal() throws Exception {
        // Get the percentOffTotal
        restPercentOffTotalMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingPercentOffTotal() throws Exception {
        // Initialize the database
        insertedPercentOffTotal = percentOffTotalRepository.saveAndFlush(percentOffTotal);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the percentOffTotal
        PercentOffTotal updatedPercentOffTotal = percentOffTotalRepository.findById(percentOffTotal.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedPercentOffTotal are not directly saved in db
        em.detach(updatedPercentOffTotal);
        updatedPercentOffTotal
            .percent(UPDATED_PERCENT)
            .maxOff(UPDATED_MAX_OFF)
            .minPrice(UPDATED_MIN_PRICE)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);
        PercentOffTotalDTO percentOffTotalDTO = percentOffTotalMapper.toDto(updatedPercentOffTotal);

        restPercentOffTotalMockMvc
            .perform(
                put(ENTITY_API_URL_ID, percentOffTotalDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(percentOffTotalDTO))
            )
            .andExpect(status().isOk());

        // Validate the PercentOffTotal in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedPercentOffTotalToMatchAllProperties(updatedPercentOffTotal);
    }

    @Test
    @Transactional
    void putNonExistingPercentOffTotal() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        percentOffTotal.setId(longCount.incrementAndGet());

        // Create the PercentOffTotal
        PercentOffTotalDTO percentOffTotalDTO = percentOffTotalMapper.toDto(percentOffTotal);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restPercentOffTotalMockMvc
            .perform(
                put(ENTITY_API_URL_ID, percentOffTotalDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(percentOffTotalDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the PercentOffTotal in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchPercentOffTotal() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        percentOffTotal.setId(longCount.incrementAndGet());

        // Create the PercentOffTotal
        PercentOffTotalDTO percentOffTotalDTO = percentOffTotalMapper.toDto(percentOffTotal);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restPercentOffTotalMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(percentOffTotalDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the PercentOffTotal in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamPercentOffTotal() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        percentOffTotal.setId(longCount.incrementAndGet());

        // Create the PercentOffTotal
        PercentOffTotalDTO percentOffTotalDTO = percentOffTotalMapper.toDto(percentOffTotal);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restPercentOffTotalMockMvc
            .perform(
                put(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(percentOffTotalDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the PercentOffTotal in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdatePercentOffTotalWithPatch() throws Exception {
        // Initialize the database
        insertedPercentOffTotal = percentOffTotalRepository.saveAndFlush(percentOffTotal);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the percentOffTotal using partial update
        PercentOffTotal partialUpdatedPercentOffTotal = new PercentOffTotal();
        partialUpdatedPercentOffTotal.setId(percentOffTotal.getId());

        partialUpdatedPercentOffTotal
            .createdAt(UPDATED_CREATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);

        restPercentOffTotalMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedPercentOffTotal.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedPercentOffTotal))
            )
            .andExpect(status().isOk());

        // Validate the PercentOffTotal in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPercentOffTotalUpdatableFieldsEquals(
            createUpdateProxyForBean(partialUpdatedPercentOffTotal, percentOffTotal),
            getPersistedPercentOffTotal(percentOffTotal)
        );
    }

    @Test
    @Transactional
    void fullUpdatePercentOffTotalWithPatch() throws Exception {
        // Initialize the database
        insertedPercentOffTotal = percentOffTotalRepository.saveAndFlush(percentOffTotal);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the percentOffTotal using partial update
        PercentOffTotal partialUpdatedPercentOffTotal = new PercentOffTotal();
        partialUpdatedPercentOffTotal.setId(percentOffTotal.getId());

        partialUpdatedPercentOffTotal
            .percent(UPDATED_PERCENT)
            .maxOff(UPDATED_MAX_OFF)
            .minPrice(UPDATED_MIN_PRICE)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);

        restPercentOffTotalMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedPercentOffTotal.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedPercentOffTotal))
            )
            .andExpect(status().isOk());

        // Validate the PercentOffTotal in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPercentOffTotalUpdatableFieldsEquals(
            partialUpdatedPercentOffTotal,
            getPersistedPercentOffTotal(partialUpdatedPercentOffTotal)
        );
    }

    @Test
    @Transactional
    void patchNonExistingPercentOffTotal() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        percentOffTotal.setId(longCount.incrementAndGet());

        // Create the PercentOffTotal
        PercentOffTotalDTO percentOffTotalDTO = percentOffTotalMapper.toDto(percentOffTotal);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restPercentOffTotalMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, percentOffTotalDTO.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(percentOffTotalDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the PercentOffTotal in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchPercentOffTotal() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        percentOffTotal.setId(longCount.incrementAndGet());

        // Create the PercentOffTotal
        PercentOffTotalDTO percentOffTotalDTO = percentOffTotalMapper.toDto(percentOffTotal);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restPercentOffTotalMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(percentOffTotalDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the PercentOffTotal in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamPercentOffTotal() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        percentOffTotal.setId(longCount.incrementAndGet());

        // Create the PercentOffTotal
        PercentOffTotalDTO percentOffTotalDTO = percentOffTotalMapper.toDto(percentOffTotal);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restPercentOffTotalMockMvc
            .perform(
                patch(ENTITY_API_URL)
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(percentOffTotalDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the PercentOffTotal in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deletePercentOffTotal() throws Exception {
        // Initialize the database
        insertedPercentOffTotal = percentOffTotalRepository.saveAndFlush(percentOffTotal);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the percentOffTotal
        restPercentOffTotalMockMvc
            .perform(delete(ENTITY_API_URL_ID, percentOffTotal.getId()).with(csrf()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return percentOffTotalRepository.count();
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

    protected PercentOffTotal getPersistedPercentOffTotal(PercentOffTotal percentOffTotal) {
        return percentOffTotalRepository.findById(percentOffTotal.getId()).orElseThrow();
    }

    protected void assertPersistedPercentOffTotalToMatchAllProperties(PercentOffTotal expectedPercentOffTotal) {
        assertPercentOffTotalAllPropertiesEquals(expectedPercentOffTotal, getPersistedPercentOffTotal(expectedPercentOffTotal));
    }

    protected void assertPersistedPercentOffTotalToMatchUpdatableProperties(PercentOffTotal expectedPercentOffTotal) {
        assertPercentOffTotalAllUpdatablePropertiesEquals(expectedPercentOffTotal, getPersistedPercentOffTotal(expectedPercentOffTotal));
    }
}
