package com.ridehub.promotion.web.rest;

import static com.ridehub.promotion.domain.BuyNGetMFreeAsserts.*;
import static com.ridehub.promotion.web.rest.TestUtil.createUpdateProxyForBean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ridehub.promotion.IntegrationTest;
import com.ridehub.promotion.domain.BuyNGetMFree;
import com.ridehub.promotion.domain.Promotion;
import com.ridehub.promotion.repository.BuyNGetMFreeRepository;
import com.ridehub.promotion.service.dto.BuyNGetMFreeDTO;
import com.ridehub.promotion.service.mapper.BuyNGetMFreeMapper;
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
 * Integration tests for the {@link BuyNGetMFreeResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class BuyNGetMFreeResourceIT {

    private static final Integer DEFAULT_BUY_N = 1;
    private static final Integer UPDATED_BUY_N = 2;
    private static final Integer SMALLER_BUY_N = 1 - 1;

    private static final Integer DEFAULT_GET_M = 1;
    private static final Integer UPDATED_GET_M = 2;
    private static final Integer SMALLER_GET_M = 1 - 1;

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

    private static final String ENTITY_API_URL = "/api/buy-n-get-m-frees";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private BuyNGetMFreeRepository buyNGetMFreeRepository;

    @Autowired
    private BuyNGetMFreeMapper buyNGetMFreeMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restBuyNGetMFreeMockMvc;

    private BuyNGetMFree buyNGetMFree;

    private BuyNGetMFree insertedBuyNGetMFree;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static BuyNGetMFree createEntity(EntityManager em) {
        BuyNGetMFree buyNGetMFree = new BuyNGetMFree()
            .buyN(DEFAULT_BUY_N)
            .getM(DEFAULT_GET_M)
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
        buyNGetMFree.setPromotion(promotion);
        return buyNGetMFree;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static BuyNGetMFree createUpdatedEntity(EntityManager em) {
        BuyNGetMFree updatedBuyNGetMFree = new BuyNGetMFree()
            .buyN(UPDATED_BUY_N)
            .getM(UPDATED_GET_M)
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
        updatedBuyNGetMFree.setPromotion(promotion);
        return updatedBuyNGetMFree;
    }

    @BeforeEach
    void initTest() {
        buyNGetMFree = createEntity(em);
    }

    @AfterEach
    void cleanup() {
        if (insertedBuyNGetMFree != null) {
            buyNGetMFreeRepository.delete(insertedBuyNGetMFree);
            insertedBuyNGetMFree = null;
        }
    }

    @Test
    @Transactional
    void createBuyNGetMFree() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the BuyNGetMFree
        BuyNGetMFreeDTO buyNGetMFreeDTO = buyNGetMFreeMapper.toDto(buyNGetMFree);
        var returnedBuyNGetMFreeDTO = om.readValue(
            restBuyNGetMFreeMockMvc
                .perform(
                    post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(buyNGetMFreeDTO))
                )
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            BuyNGetMFreeDTO.class
        );

        // Validate the BuyNGetMFree in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        var returnedBuyNGetMFree = buyNGetMFreeMapper.toEntity(returnedBuyNGetMFreeDTO);
        assertBuyNGetMFreeUpdatableFieldsEquals(returnedBuyNGetMFree, getPersistedBuyNGetMFree(returnedBuyNGetMFree));

        insertedBuyNGetMFree = returnedBuyNGetMFree;
    }

    @Test
    @Transactional
    void createBuyNGetMFreeWithExistingId() throws Exception {
        // Create the BuyNGetMFree with an existing ID
        buyNGetMFree.setId(1L);
        BuyNGetMFreeDTO buyNGetMFreeDTO = buyNGetMFreeMapper.toDto(buyNGetMFree);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restBuyNGetMFreeMockMvc
            .perform(
                post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(buyNGetMFreeDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the BuyNGetMFree in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkBuyNIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        buyNGetMFree.setBuyN(null);

        // Create the BuyNGetMFree, which fails.
        BuyNGetMFreeDTO buyNGetMFreeDTO = buyNGetMFreeMapper.toDto(buyNGetMFree);

        restBuyNGetMFreeMockMvc
            .perform(
                post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(buyNGetMFreeDTO))
            )
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkGetMIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        buyNGetMFree.setGetM(null);

        // Create the BuyNGetMFree, which fails.
        BuyNGetMFreeDTO buyNGetMFreeDTO = buyNGetMFreeMapper.toDto(buyNGetMFree);

        restBuyNGetMFreeMockMvc
            .perform(
                post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(buyNGetMFreeDTO))
            )
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkCreatedAtIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        buyNGetMFree.setCreatedAt(null);

        // Create the BuyNGetMFree, which fails.
        BuyNGetMFreeDTO buyNGetMFreeDTO = buyNGetMFreeMapper.toDto(buyNGetMFree);

        restBuyNGetMFreeMockMvc
            .perform(
                post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(buyNGetMFreeDTO))
            )
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllBuyNGetMFrees() throws Exception {
        // Initialize the database
        insertedBuyNGetMFree = buyNGetMFreeRepository.saveAndFlush(buyNGetMFree);

        // Get all the buyNGetMFreeList
        restBuyNGetMFreeMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(buyNGetMFree.getId().intValue())))
            .andExpect(jsonPath("$.[*].buyN").value(hasItem(DEFAULT_BUY_N)))
            .andExpect(jsonPath("$.[*].getM").value(hasItem(DEFAULT_GET_M)))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].isDeleted").value(hasItem(DEFAULT_IS_DELETED)))
            .andExpect(jsonPath("$.[*].deletedAt").value(hasItem(DEFAULT_DELETED_AT.toString())))
            .andExpect(jsonPath("$.[*].deletedBy").value(hasItem(DEFAULT_DELETED_BY.toString())));
    }

    @Test
    @Transactional
    void getBuyNGetMFree() throws Exception {
        // Initialize the database
        insertedBuyNGetMFree = buyNGetMFreeRepository.saveAndFlush(buyNGetMFree);

        // Get the buyNGetMFree
        restBuyNGetMFreeMockMvc
            .perform(get(ENTITY_API_URL_ID, buyNGetMFree.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(buyNGetMFree.getId().intValue()))
            .andExpect(jsonPath("$.buyN").value(DEFAULT_BUY_N))
            .andExpect(jsonPath("$.getM").value(DEFAULT_GET_M))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.updatedAt").value(DEFAULT_UPDATED_AT.toString()))
            .andExpect(jsonPath("$.isDeleted").value(DEFAULT_IS_DELETED))
            .andExpect(jsonPath("$.deletedAt").value(DEFAULT_DELETED_AT.toString()))
            .andExpect(jsonPath("$.deletedBy").value(DEFAULT_DELETED_BY.toString()));
    }

    @Test
    @Transactional
    void getBuyNGetMFreesByIdFiltering() throws Exception {
        // Initialize the database
        insertedBuyNGetMFree = buyNGetMFreeRepository.saveAndFlush(buyNGetMFree);

        Long id = buyNGetMFree.getId();

        defaultBuyNGetMFreeFiltering("id.equals=" + id, "id.notEquals=" + id);

        defaultBuyNGetMFreeFiltering("id.greaterThanOrEqual=" + id, "id.greaterThan=" + id);

        defaultBuyNGetMFreeFiltering("id.lessThanOrEqual=" + id, "id.lessThan=" + id);
    }

    @Test
    @Transactional
    void getAllBuyNGetMFreesByBuyNIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedBuyNGetMFree = buyNGetMFreeRepository.saveAndFlush(buyNGetMFree);

        // Get all the buyNGetMFreeList where buyN equals to
        defaultBuyNGetMFreeFiltering("buyN.equals=" + DEFAULT_BUY_N, "buyN.equals=" + UPDATED_BUY_N);
    }

    @Test
    @Transactional
    void getAllBuyNGetMFreesByBuyNIsInShouldWork() throws Exception {
        // Initialize the database
        insertedBuyNGetMFree = buyNGetMFreeRepository.saveAndFlush(buyNGetMFree);

        // Get all the buyNGetMFreeList where buyN in
        defaultBuyNGetMFreeFiltering("buyN.in=" + DEFAULT_BUY_N + "," + UPDATED_BUY_N, "buyN.in=" + UPDATED_BUY_N);
    }

    @Test
    @Transactional
    void getAllBuyNGetMFreesByBuyNIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedBuyNGetMFree = buyNGetMFreeRepository.saveAndFlush(buyNGetMFree);

        // Get all the buyNGetMFreeList where buyN is not null
        defaultBuyNGetMFreeFiltering("buyN.specified=true", "buyN.specified=false");
    }

    @Test
    @Transactional
    void getAllBuyNGetMFreesByBuyNIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedBuyNGetMFree = buyNGetMFreeRepository.saveAndFlush(buyNGetMFree);

        // Get all the buyNGetMFreeList where buyN is greater than or equal to
        defaultBuyNGetMFreeFiltering("buyN.greaterThanOrEqual=" + DEFAULT_BUY_N, "buyN.greaterThanOrEqual=" + UPDATED_BUY_N);
    }

    @Test
    @Transactional
    void getAllBuyNGetMFreesByBuyNIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedBuyNGetMFree = buyNGetMFreeRepository.saveAndFlush(buyNGetMFree);

        // Get all the buyNGetMFreeList where buyN is less than or equal to
        defaultBuyNGetMFreeFiltering("buyN.lessThanOrEqual=" + DEFAULT_BUY_N, "buyN.lessThanOrEqual=" + SMALLER_BUY_N);
    }

    @Test
    @Transactional
    void getAllBuyNGetMFreesByBuyNIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedBuyNGetMFree = buyNGetMFreeRepository.saveAndFlush(buyNGetMFree);

        // Get all the buyNGetMFreeList where buyN is less than
        defaultBuyNGetMFreeFiltering("buyN.lessThan=" + UPDATED_BUY_N, "buyN.lessThan=" + DEFAULT_BUY_N);
    }

    @Test
    @Transactional
    void getAllBuyNGetMFreesByBuyNIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedBuyNGetMFree = buyNGetMFreeRepository.saveAndFlush(buyNGetMFree);

        // Get all the buyNGetMFreeList where buyN is greater than
        defaultBuyNGetMFreeFiltering("buyN.greaterThan=" + SMALLER_BUY_N, "buyN.greaterThan=" + DEFAULT_BUY_N);
    }

    @Test
    @Transactional
    void getAllBuyNGetMFreesByGetMIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedBuyNGetMFree = buyNGetMFreeRepository.saveAndFlush(buyNGetMFree);

        // Get all the buyNGetMFreeList where getM equals to
        defaultBuyNGetMFreeFiltering("getM.equals=" + DEFAULT_GET_M, "getM.equals=" + UPDATED_GET_M);
    }

    @Test
    @Transactional
    void getAllBuyNGetMFreesByGetMIsInShouldWork() throws Exception {
        // Initialize the database
        insertedBuyNGetMFree = buyNGetMFreeRepository.saveAndFlush(buyNGetMFree);

        // Get all the buyNGetMFreeList where getM in
        defaultBuyNGetMFreeFiltering("getM.in=" + DEFAULT_GET_M + "," + UPDATED_GET_M, "getM.in=" + UPDATED_GET_M);
    }

    @Test
    @Transactional
    void getAllBuyNGetMFreesByGetMIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedBuyNGetMFree = buyNGetMFreeRepository.saveAndFlush(buyNGetMFree);

        // Get all the buyNGetMFreeList where getM is not null
        defaultBuyNGetMFreeFiltering("getM.specified=true", "getM.specified=false");
    }

    @Test
    @Transactional
    void getAllBuyNGetMFreesByGetMIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedBuyNGetMFree = buyNGetMFreeRepository.saveAndFlush(buyNGetMFree);

        // Get all the buyNGetMFreeList where getM is greater than or equal to
        defaultBuyNGetMFreeFiltering("getM.greaterThanOrEqual=" + DEFAULT_GET_M, "getM.greaterThanOrEqual=" + UPDATED_GET_M);
    }

    @Test
    @Transactional
    void getAllBuyNGetMFreesByGetMIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedBuyNGetMFree = buyNGetMFreeRepository.saveAndFlush(buyNGetMFree);

        // Get all the buyNGetMFreeList where getM is less than or equal to
        defaultBuyNGetMFreeFiltering("getM.lessThanOrEqual=" + DEFAULT_GET_M, "getM.lessThanOrEqual=" + SMALLER_GET_M);
    }

    @Test
    @Transactional
    void getAllBuyNGetMFreesByGetMIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedBuyNGetMFree = buyNGetMFreeRepository.saveAndFlush(buyNGetMFree);

        // Get all the buyNGetMFreeList where getM is less than
        defaultBuyNGetMFreeFiltering("getM.lessThan=" + UPDATED_GET_M, "getM.lessThan=" + DEFAULT_GET_M);
    }

    @Test
    @Transactional
    void getAllBuyNGetMFreesByGetMIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedBuyNGetMFree = buyNGetMFreeRepository.saveAndFlush(buyNGetMFree);

        // Get all the buyNGetMFreeList where getM is greater than
        defaultBuyNGetMFreeFiltering("getM.greaterThan=" + SMALLER_GET_M, "getM.greaterThan=" + DEFAULT_GET_M);
    }

    @Test
    @Transactional
    void getAllBuyNGetMFreesByCreatedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedBuyNGetMFree = buyNGetMFreeRepository.saveAndFlush(buyNGetMFree);

        // Get all the buyNGetMFreeList where createdAt equals to
        defaultBuyNGetMFreeFiltering("createdAt.equals=" + DEFAULT_CREATED_AT, "createdAt.equals=" + UPDATED_CREATED_AT);
    }

    @Test
    @Transactional
    void getAllBuyNGetMFreesByCreatedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedBuyNGetMFree = buyNGetMFreeRepository.saveAndFlush(buyNGetMFree);

        // Get all the buyNGetMFreeList where createdAt in
        defaultBuyNGetMFreeFiltering("createdAt.in=" + DEFAULT_CREATED_AT + "," + UPDATED_CREATED_AT, "createdAt.in=" + UPDATED_CREATED_AT);
    }

    @Test
    @Transactional
    void getAllBuyNGetMFreesByCreatedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedBuyNGetMFree = buyNGetMFreeRepository.saveAndFlush(buyNGetMFree);

        // Get all the buyNGetMFreeList where createdAt is not null
        defaultBuyNGetMFreeFiltering("createdAt.specified=true", "createdAt.specified=false");
    }

    @Test
    @Transactional
    void getAllBuyNGetMFreesByUpdatedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedBuyNGetMFree = buyNGetMFreeRepository.saveAndFlush(buyNGetMFree);

        // Get all the buyNGetMFreeList where updatedAt equals to
        defaultBuyNGetMFreeFiltering("updatedAt.equals=" + DEFAULT_UPDATED_AT, "updatedAt.equals=" + UPDATED_UPDATED_AT);
    }

    @Test
    @Transactional
    void getAllBuyNGetMFreesByUpdatedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedBuyNGetMFree = buyNGetMFreeRepository.saveAndFlush(buyNGetMFree);

        // Get all the buyNGetMFreeList where updatedAt in
        defaultBuyNGetMFreeFiltering("updatedAt.in=" + DEFAULT_UPDATED_AT + "," + UPDATED_UPDATED_AT, "updatedAt.in=" + UPDATED_UPDATED_AT);
    }

    @Test
    @Transactional
    void getAllBuyNGetMFreesByUpdatedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedBuyNGetMFree = buyNGetMFreeRepository.saveAndFlush(buyNGetMFree);

        // Get all the buyNGetMFreeList where updatedAt is not null
        defaultBuyNGetMFreeFiltering("updatedAt.specified=true", "updatedAt.specified=false");
    }

    @Test
    @Transactional
    void getAllBuyNGetMFreesByIsDeletedIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedBuyNGetMFree = buyNGetMFreeRepository.saveAndFlush(buyNGetMFree);

        // Get all the buyNGetMFreeList where isDeleted equals to
        defaultBuyNGetMFreeFiltering("isDeleted.equals=" + DEFAULT_IS_DELETED, "isDeleted.equals=" + UPDATED_IS_DELETED);
    }

    @Test
    @Transactional
    void getAllBuyNGetMFreesByIsDeletedIsInShouldWork() throws Exception {
        // Initialize the database
        insertedBuyNGetMFree = buyNGetMFreeRepository.saveAndFlush(buyNGetMFree);

        // Get all the buyNGetMFreeList where isDeleted in
        defaultBuyNGetMFreeFiltering("isDeleted.in=" + DEFAULT_IS_DELETED + "," + UPDATED_IS_DELETED, "isDeleted.in=" + UPDATED_IS_DELETED);
    }

    @Test
    @Transactional
    void getAllBuyNGetMFreesByIsDeletedIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedBuyNGetMFree = buyNGetMFreeRepository.saveAndFlush(buyNGetMFree);

        // Get all the buyNGetMFreeList where isDeleted is not null
        defaultBuyNGetMFreeFiltering("isDeleted.specified=true", "isDeleted.specified=false");
    }

    @Test
    @Transactional
    void getAllBuyNGetMFreesByDeletedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedBuyNGetMFree = buyNGetMFreeRepository.saveAndFlush(buyNGetMFree);

        // Get all the buyNGetMFreeList where deletedAt equals to
        defaultBuyNGetMFreeFiltering("deletedAt.equals=" + DEFAULT_DELETED_AT, "deletedAt.equals=" + UPDATED_DELETED_AT);
    }

    @Test
    @Transactional
    void getAllBuyNGetMFreesByDeletedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedBuyNGetMFree = buyNGetMFreeRepository.saveAndFlush(buyNGetMFree);

        // Get all the buyNGetMFreeList where deletedAt in
        defaultBuyNGetMFreeFiltering("deletedAt.in=" + DEFAULT_DELETED_AT + "," + UPDATED_DELETED_AT, "deletedAt.in=" + UPDATED_DELETED_AT);
    }

    @Test
    @Transactional
    void getAllBuyNGetMFreesByDeletedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedBuyNGetMFree = buyNGetMFreeRepository.saveAndFlush(buyNGetMFree);

        // Get all the buyNGetMFreeList where deletedAt is not null
        defaultBuyNGetMFreeFiltering("deletedAt.specified=true", "deletedAt.specified=false");
    }

    @Test
    @Transactional
    void getAllBuyNGetMFreesByDeletedByIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedBuyNGetMFree = buyNGetMFreeRepository.saveAndFlush(buyNGetMFree);

        // Get all the buyNGetMFreeList where deletedBy equals to
        defaultBuyNGetMFreeFiltering("deletedBy.equals=" + DEFAULT_DELETED_BY, "deletedBy.equals=" + UPDATED_DELETED_BY);
    }

    @Test
    @Transactional
    void getAllBuyNGetMFreesByDeletedByIsInShouldWork() throws Exception {
        // Initialize the database
        insertedBuyNGetMFree = buyNGetMFreeRepository.saveAndFlush(buyNGetMFree);

        // Get all the buyNGetMFreeList where deletedBy in
        defaultBuyNGetMFreeFiltering("deletedBy.in=" + DEFAULT_DELETED_BY + "," + UPDATED_DELETED_BY, "deletedBy.in=" + UPDATED_DELETED_BY);
    }

    @Test
    @Transactional
    void getAllBuyNGetMFreesByDeletedByIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedBuyNGetMFree = buyNGetMFreeRepository.saveAndFlush(buyNGetMFree);

        // Get all the buyNGetMFreeList where deletedBy is not null
        defaultBuyNGetMFreeFiltering("deletedBy.specified=true", "deletedBy.specified=false");
    }

    @Test
    @Transactional
    void getAllBuyNGetMFreesByPromotionIsEqualToSomething() throws Exception {
        Promotion promotion;
        if (TestUtil.findAll(em, Promotion.class).isEmpty()) {
            buyNGetMFreeRepository.saveAndFlush(buyNGetMFree);
            promotion = PromotionResourceIT.createEntity();
        } else {
            promotion = TestUtil.findAll(em, Promotion.class).get(0);
        }
        em.persist(promotion);
        em.flush();
        buyNGetMFree.setPromotion(promotion);
        buyNGetMFreeRepository.saveAndFlush(buyNGetMFree);
        Long promotionId = promotion.getId();
        // Get all the buyNGetMFreeList where promotion equals to promotionId
        defaultBuyNGetMFreeShouldBeFound("promotionId.equals=" + promotionId);

        // Get all the buyNGetMFreeList where promotion equals to (promotionId + 1)
        defaultBuyNGetMFreeShouldNotBeFound("promotionId.equals=" + (promotionId + 1));
    }

    private void defaultBuyNGetMFreeFiltering(String shouldBeFound, String shouldNotBeFound) throws Exception {
        defaultBuyNGetMFreeShouldBeFound(shouldBeFound);
        defaultBuyNGetMFreeShouldNotBeFound(shouldNotBeFound);
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultBuyNGetMFreeShouldBeFound(String filter) throws Exception {
        restBuyNGetMFreeMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(buyNGetMFree.getId().intValue())))
            .andExpect(jsonPath("$.[*].buyN").value(hasItem(DEFAULT_BUY_N)))
            .andExpect(jsonPath("$.[*].getM").value(hasItem(DEFAULT_GET_M)))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].isDeleted").value(hasItem(DEFAULT_IS_DELETED)))
            .andExpect(jsonPath("$.[*].deletedAt").value(hasItem(DEFAULT_DELETED_AT.toString())))
            .andExpect(jsonPath("$.[*].deletedBy").value(hasItem(DEFAULT_DELETED_BY.toString())));

        // Check, that the count call also returns 1
        restBuyNGetMFreeMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("1"));
    }

    /**
     * Executes the search, and checks that the default entity is not returned.
     */
    private void defaultBuyNGetMFreeShouldNotBeFound(String filter) throws Exception {
        restBuyNGetMFreeMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());

        // Check, that the count call also returns 0
        restBuyNGetMFreeMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("0"));
    }

    @Test
    @Transactional
    void getNonExistingBuyNGetMFree() throws Exception {
        // Get the buyNGetMFree
        restBuyNGetMFreeMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingBuyNGetMFree() throws Exception {
        // Initialize the database
        insertedBuyNGetMFree = buyNGetMFreeRepository.saveAndFlush(buyNGetMFree);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the buyNGetMFree
        BuyNGetMFree updatedBuyNGetMFree = buyNGetMFreeRepository.findById(buyNGetMFree.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedBuyNGetMFree are not directly saved in db
        em.detach(updatedBuyNGetMFree);
        updatedBuyNGetMFree
            .buyN(UPDATED_BUY_N)
            .getM(UPDATED_GET_M)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);
        BuyNGetMFreeDTO buyNGetMFreeDTO = buyNGetMFreeMapper.toDto(updatedBuyNGetMFree);

        restBuyNGetMFreeMockMvc
            .perform(
                put(ENTITY_API_URL_ID, buyNGetMFreeDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(buyNGetMFreeDTO))
            )
            .andExpect(status().isOk());

        // Validate the BuyNGetMFree in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedBuyNGetMFreeToMatchAllProperties(updatedBuyNGetMFree);
    }

    @Test
    @Transactional
    void putNonExistingBuyNGetMFree() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        buyNGetMFree.setId(longCount.incrementAndGet());

        // Create the BuyNGetMFree
        BuyNGetMFreeDTO buyNGetMFreeDTO = buyNGetMFreeMapper.toDto(buyNGetMFree);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restBuyNGetMFreeMockMvc
            .perform(
                put(ENTITY_API_URL_ID, buyNGetMFreeDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(buyNGetMFreeDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the BuyNGetMFree in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchBuyNGetMFree() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        buyNGetMFree.setId(longCount.incrementAndGet());

        // Create the BuyNGetMFree
        BuyNGetMFreeDTO buyNGetMFreeDTO = buyNGetMFreeMapper.toDto(buyNGetMFree);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restBuyNGetMFreeMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(buyNGetMFreeDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the BuyNGetMFree in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamBuyNGetMFree() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        buyNGetMFree.setId(longCount.incrementAndGet());

        // Create the BuyNGetMFree
        BuyNGetMFreeDTO buyNGetMFreeDTO = buyNGetMFreeMapper.toDto(buyNGetMFree);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restBuyNGetMFreeMockMvc
            .perform(
                put(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(buyNGetMFreeDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the BuyNGetMFree in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateBuyNGetMFreeWithPatch() throws Exception {
        // Initialize the database
        insertedBuyNGetMFree = buyNGetMFreeRepository.saveAndFlush(buyNGetMFree);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the buyNGetMFree using partial update
        BuyNGetMFree partialUpdatedBuyNGetMFree = new BuyNGetMFree();
        partialUpdatedBuyNGetMFree.setId(buyNGetMFree.getId());

        partialUpdatedBuyNGetMFree
            .buyN(UPDATED_BUY_N)
            .getM(UPDATED_GET_M)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedBy(UPDATED_DELETED_BY);

        restBuyNGetMFreeMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedBuyNGetMFree.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedBuyNGetMFree))
            )
            .andExpect(status().isOk());

        // Validate the BuyNGetMFree in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertBuyNGetMFreeUpdatableFieldsEquals(
            createUpdateProxyForBean(partialUpdatedBuyNGetMFree, buyNGetMFree),
            getPersistedBuyNGetMFree(buyNGetMFree)
        );
    }

    @Test
    @Transactional
    void fullUpdateBuyNGetMFreeWithPatch() throws Exception {
        // Initialize the database
        insertedBuyNGetMFree = buyNGetMFreeRepository.saveAndFlush(buyNGetMFree);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the buyNGetMFree using partial update
        BuyNGetMFree partialUpdatedBuyNGetMFree = new BuyNGetMFree();
        partialUpdatedBuyNGetMFree.setId(buyNGetMFree.getId());

        partialUpdatedBuyNGetMFree
            .buyN(UPDATED_BUY_N)
            .getM(UPDATED_GET_M)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);

        restBuyNGetMFreeMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedBuyNGetMFree.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedBuyNGetMFree))
            )
            .andExpect(status().isOk());

        // Validate the BuyNGetMFree in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertBuyNGetMFreeUpdatableFieldsEquals(partialUpdatedBuyNGetMFree, getPersistedBuyNGetMFree(partialUpdatedBuyNGetMFree));
    }

    @Test
    @Transactional
    void patchNonExistingBuyNGetMFree() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        buyNGetMFree.setId(longCount.incrementAndGet());

        // Create the BuyNGetMFree
        BuyNGetMFreeDTO buyNGetMFreeDTO = buyNGetMFreeMapper.toDto(buyNGetMFree);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restBuyNGetMFreeMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, buyNGetMFreeDTO.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(buyNGetMFreeDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the BuyNGetMFree in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchBuyNGetMFree() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        buyNGetMFree.setId(longCount.incrementAndGet());

        // Create the BuyNGetMFree
        BuyNGetMFreeDTO buyNGetMFreeDTO = buyNGetMFreeMapper.toDto(buyNGetMFree);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restBuyNGetMFreeMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(buyNGetMFreeDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the BuyNGetMFree in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamBuyNGetMFree() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        buyNGetMFree.setId(longCount.incrementAndGet());

        // Create the BuyNGetMFree
        BuyNGetMFreeDTO buyNGetMFreeDTO = buyNGetMFreeMapper.toDto(buyNGetMFree);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restBuyNGetMFreeMockMvc
            .perform(
                patch(ENTITY_API_URL)
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(buyNGetMFreeDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the BuyNGetMFree in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteBuyNGetMFree() throws Exception {
        // Initialize the database
        insertedBuyNGetMFree = buyNGetMFreeRepository.saveAndFlush(buyNGetMFree);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the buyNGetMFree
        restBuyNGetMFreeMockMvc
            .perform(delete(ENTITY_API_URL_ID, buyNGetMFree.getId()).with(csrf()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return buyNGetMFreeRepository.count();
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

    protected BuyNGetMFree getPersistedBuyNGetMFree(BuyNGetMFree buyNGetMFree) {
        return buyNGetMFreeRepository.findById(buyNGetMFree.getId()).orElseThrow();
    }

    protected void assertPersistedBuyNGetMFreeToMatchAllProperties(BuyNGetMFree expectedBuyNGetMFree) {
        assertBuyNGetMFreeAllPropertiesEquals(expectedBuyNGetMFree, getPersistedBuyNGetMFree(expectedBuyNGetMFree));
    }

    protected void assertPersistedBuyNGetMFreeToMatchUpdatableProperties(BuyNGetMFree expectedBuyNGetMFree) {
        assertBuyNGetMFreeAllUpdatablePropertiesEquals(expectedBuyNGetMFree, getPersistedBuyNGetMFree(expectedBuyNGetMFree));
    }
}
