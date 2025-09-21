package com.ridehub.promotion.web.rest;

import static com.ridehub.promotion.domain.ConditionByLocationAsserts.*;
import static com.ridehub.promotion.web.rest.TestUtil.createUpdateProxyForBean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ridehub.promotion.IntegrationTest;
import com.ridehub.promotion.domain.ConditionByLocation;
import com.ridehub.promotion.domain.Promotion;
import com.ridehub.promotion.repository.ConditionByLocationRepository;
import com.ridehub.promotion.service.dto.ConditionByLocationDTO;
import com.ridehub.promotion.service.mapper.ConditionByLocationMapper;
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
 * Integration tests for the {@link ConditionByLocationResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class ConditionByLocationResourceIT {

    private static final UUID DEFAULT_PROVINCE_ID = UUID.randomUUID();
    private static final UUID UPDATED_PROVINCE_ID = UUID.randomUUID();

    private static final UUID DEFAULT_DISTRICT_ID = UUID.randomUUID();
    private static final UUID UPDATED_DISTRICT_ID = UUID.randomUUID();

    private static final UUID DEFAULT_WARD_ID = UUID.randomUUID();
    private static final UUID UPDATED_WARD_ID = UUID.randomUUID();

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

    private static final String ENTITY_API_URL = "/api/condition-by-locations";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private ConditionByLocationRepository conditionByLocationRepository;

    @Autowired
    private ConditionByLocationMapper conditionByLocationMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restConditionByLocationMockMvc;

    private ConditionByLocation conditionByLocation;

    private ConditionByLocation insertedConditionByLocation;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ConditionByLocation createEntity(EntityManager em) {
        ConditionByLocation conditionByLocation = new ConditionByLocation()
            .provinceId(DEFAULT_PROVINCE_ID)
            .districtId(DEFAULT_DISTRICT_ID)
            .wardId(DEFAULT_WARD_ID)
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
        conditionByLocation.setPromotion(promotion);
        return conditionByLocation;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ConditionByLocation createUpdatedEntity(EntityManager em) {
        ConditionByLocation updatedConditionByLocation = new ConditionByLocation()
            .provinceId(UPDATED_PROVINCE_ID)
            .districtId(UPDATED_DISTRICT_ID)
            .wardId(UPDATED_WARD_ID)
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
        updatedConditionByLocation.setPromotion(promotion);
        return updatedConditionByLocation;
    }

    @BeforeEach
    void initTest() {
        conditionByLocation = createEntity(em);
    }

    @AfterEach
    void cleanup() {
        if (insertedConditionByLocation != null) {
            conditionByLocationRepository.delete(insertedConditionByLocation);
            insertedConditionByLocation = null;
        }
    }

    @Test
    @Transactional
    void createConditionByLocation() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the ConditionByLocation
        ConditionByLocationDTO conditionByLocationDTO = conditionByLocationMapper.toDto(conditionByLocation);
        var returnedConditionByLocationDTO = om.readValue(
            restConditionByLocationMockMvc
                .perform(
                    post(ENTITY_API_URL)
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsBytes(conditionByLocationDTO))
                )
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            ConditionByLocationDTO.class
        );

        // Validate the ConditionByLocation in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        var returnedConditionByLocation = conditionByLocationMapper.toEntity(returnedConditionByLocationDTO);
        assertConditionByLocationUpdatableFieldsEquals(
            returnedConditionByLocation,
            getPersistedConditionByLocation(returnedConditionByLocation)
        );

        insertedConditionByLocation = returnedConditionByLocation;
    }

    @Test
    @Transactional
    void createConditionByLocationWithExistingId() throws Exception {
        // Create the ConditionByLocation with an existing ID
        conditionByLocation.setId(1L);
        ConditionByLocationDTO conditionByLocationDTO = conditionByLocationMapper.toDto(conditionByLocation);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restConditionByLocationMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(conditionByLocationDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the ConditionByLocation in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkCreatedAtIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        conditionByLocation.setCreatedAt(null);

        // Create the ConditionByLocation, which fails.
        ConditionByLocationDTO conditionByLocationDTO = conditionByLocationMapper.toDto(conditionByLocation);

        restConditionByLocationMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(conditionByLocationDTO))
            )
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllConditionByLocations() throws Exception {
        // Initialize the database
        insertedConditionByLocation = conditionByLocationRepository.saveAndFlush(conditionByLocation);

        // Get all the conditionByLocationList
        restConditionByLocationMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(conditionByLocation.getId().intValue())))
            .andExpect(jsonPath("$.[*].provinceId").value(hasItem(DEFAULT_PROVINCE_ID.toString())))
            .andExpect(jsonPath("$.[*].districtId").value(hasItem(DEFAULT_DISTRICT_ID.toString())))
            .andExpect(jsonPath("$.[*].wardId").value(hasItem(DEFAULT_WARD_ID.toString())))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].isDeleted").value(hasItem(DEFAULT_IS_DELETED)))
            .andExpect(jsonPath("$.[*].deletedAt").value(hasItem(DEFAULT_DELETED_AT.toString())))
            .andExpect(jsonPath("$.[*].deletedBy").value(hasItem(DEFAULT_DELETED_BY.toString())));
    }

    @Test
    @Transactional
    void getConditionByLocation() throws Exception {
        // Initialize the database
        insertedConditionByLocation = conditionByLocationRepository.saveAndFlush(conditionByLocation);

        // Get the conditionByLocation
        restConditionByLocationMockMvc
            .perform(get(ENTITY_API_URL_ID, conditionByLocation.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(conditionByLocation.getId().intValue()))
            .andExpect(jsonPath("$.provinceId").value(DEFAULT_PROVINCE_ID.toString()))
            .andExpect(jsonPath("$.districtId").value(DEFAULT_DISTRICT_ID.toString()))
            .andExpect(jsonPath("$.wardId").value(DEFAULT_WARD_ID.toString()))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.updatedAt").value(DEFAULT_UPDATED_AT.toString()))
            .andExpect(jsonPath("$.isDeleted").value(DEFAULT_IS_DELETED))
            .andExpect(jsonPath("$.deletedAt").value(DEFAULT_DELETED_AT.toString()))
            .andExpect(jsonPath("$.deletedBy").value(DEFAULT_DELETED_BY.toString()));
    }

    @Test
    @Transactional
    void getConditionByLocationsByIdFiltering() throws Exception {
        // Initialize the database
        insertedConditionByLocation = conditionByLocationRepository.saveAndFlush(conditionByLocation);

        Long id = conditionByLocation.getId();

        defaultConditionByLocationFiltering("id.equals=" + id, "id.notEquals=" + id);

        defaultConditionByLocationFiltering("id.greaterThanOrEqual=" + id, "id.greaterThan=" + id);

        defaultConditionByLocationFiltering("id.lessThanOrEqual=" + id, "id.lessThan=" + id);
    }

    @Test
    @Transactional
    void getAllConditionByLocationsByProvinceIdIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedConditionByLocation = conditionByLocationRepository.saveAndFlush(conditionByLocation);

        // Get all the conditionByLocationList where provinceId equals to
        defaultConditionByLocationFiltering("provinceId.equals=" + DEFAULT_PROVINCE_ID, "provinceId.equals=" + UPDATED_PROVINCE_ID);
    }

    @Test
    @Transactional
    void getAllConditionByLocationsByProvinceIdIsInShouldWork() throws Exception {
        // Initialize the database
        insertedConditionByLocation = conditionByLocationRepository.saveAndFlush(conditionByLocation);

        // Get all the conditionByLocationList where provinceId in
        defaultConditionByLocationFiltering(
            "provinceId.in=" + DEFAULT_PROVINCE_ID + "," + UPDATED_PROVINCE_ID,
            "provinceId.in=" + UPDATED_PROVINCE_ID
        );
    }

    @Test
    @Transactional
    void getAllConditionByLocationsByProvinceIdIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedConditionByLocation = conditionByLocationRepository.saveAndFlush(conditionByLocation);

        // Get all the conditionByLocationList where provinceId is not null
        defaultConditionByLocationFiltering("provinceId.specified=true", "provinceId.specified=false");
    }

    @Test
    @Transactional
    void getAllConditionByLocationsByDistrictIdIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedConditionByLocation = conditionByLocationRepository.saveAndFlush(conditionByLocation);

        // Get all the conditionByLocationList where districtId equals to
        defaultConditionByLocationFiltering("districtId.equals=" + DEFAULT_DISTRICT_ID, "districtId.equals=" + UPDATED_DISTRICT_ID);
    }

    @Test
    @Transactional
    void getAllConditionByLocationsByDistrictIdIsInShouldWork() throws Exception {
        // Initialize the database
        insertedConditionByLocation = conditionByLocationRepository.saveAndFlush(conditionByLocation);

        // Get all the conditionByLocationList where districtId in
        defaultConditionByLocationFiltering(
            "districtId.in=" + DEFAULT_DISTRICT_ID + "," + UPDATED_DISTRICT_ID,
            "districtId.in=" + UPDATED_DISTRICT_ID
        );
    }

    @Test
    @Transactional
    void getAllConditionByLocationsByDistrictIdIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedConditionByLocation = conditionByLocationRepository.saveAndFlush(conditionByLocation);

        // Get all the conditionByLocationList where districtId is not null
        defaultConditionByLocationFiltering("districtId.specified=true", "districtId.specified=false");
    }

    @Test
    @Transactional
    void getAllConditionByLocationsByWardIdIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedConditionByLocation = conditionByLocationRepository.saveAndFlush(conditionByLocation);

        // Get all the conditionByLocationList where wardId equals to
        defaultConditionByLocationFiltering("wardId.equals=" + DEFAULT_WARD_ID, "wardId.equals=" + UPDATED_WARD_ID);
    }

    @Test
    @Transactional
    void getAllConditionByLocationsByWardIdIsInShouldWork() throws Exception {
        // Initialize the database
        insertedConditionByLocation = conditionByLocationRepository.saveAndFlush(conditionByLocation);

        // Get all the conditionByLocationList where wardId in
        defaultConditionByLocationFiltering("wardId.in=" + DEFAULT_WARD_ID + "," + UPDATED_WARD_ID, "wardId.in=" + UPDATED_WARD_ID);
    }

    @Test
    @Transactional
    void getAllConditionByLocationsByWardIdIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedConditionByLocation = conditionByLocationRepository.saveAndFlush(conditionByLocation);

        // Get all the conditionByLocationList where wardId is not null
        defaultConditionByLocationFiltering("wardId.specified=true", "wardId.specified=false");
    }

    @Test
    @Transactional
    void getAllConditionByLocationsByCreatedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedConditionByLocation = conditionByLocationRepository.saveAndFlush(conditionByLocation);

        // Get all the conditionByLocationList where createdAt equals to
        defaultConditionByLocationFiltering("createdAt.equals=" + DEFAULT_CREATED_AT, "createdAt.equals=" + UPDATED_CREATED_AT);
    }

    @Test
    @Transactional
    void getAllConditionByLocationsByCreatedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedConditionByLocation = conditionByLocationRepository.saveAndFlush(conditionByLocation);

        // Get all the conditionByLocationList where createdAt in
        defaultConditionByLocationFiltering(
            "createdAt.in=" + DEFAULT_CREATED_AT + "," + UPDATED_CREATED_AT,
            "createdAt.in=" + UPDATED_CREATED_AT
        );
    }

    @Test
    @Transactional
    void getAllConditionByLocationsByCreatedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedConditionByLocation = conditionByLocationRepository.saveAndFlush(conditionByLocation);

        // Get all the conditionByLocationList where createdAt is not null
        defaultConditionByLocationFiltering("createdAt.specified=true", "createdAt.specified=false");
    }

    @Test
    @Transactional
    void getAllConditionByLocationsByUpdatedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedConditionByLocation = conditionByLocationRepository.saveAndFlush(conditionByLocation);

        // Get all the conditionByLocationList where updatedAt equals to
        defaultConditionByLocationFiltering("updatedAt.equals=" + DEFAULT_UPDATED_AT, "updatedAt.equals=" + UPDATED_UPDATED_AT);
    }

    @Test
    @Transactional
    void getAllConditionByLocationsByUpdatedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedConditionByLocation = conditionByLocationRepository.saveAndFlush(conditionByLocation);

        // Get all the conditionByLocationList where updatedAt in
        defaultConditionByLocationFiltering(
            "updatedAt.in=" + DEFAULT_UPDATED_AT + "," + UPDATED_UPDATED_AT,
            "updatedAt.in=" + UPDATED_UPDATED_AT
        );
    }

    @Test
    @Transactional
    void getAllConditionByLocationsByUpdatedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedConditionByLocation = conditionByLocationRepository.saveAndFlush(conditionByLocation);

        // Get all the conditionByLocationList where updatedAt is not null
        defaultConditionByLocationFiltering("updatedAt.specified=true", "updatedAt.specified=false");
    }

    @Test
    @Transactional
    void getAllConditionByLocationsByIsDeletedIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedConditionByLocation = conditionByLocationRepository.saveAndFlush(conditionByLocation);

        // Get all the conditionByLocationList where isDeleted equals to
        defaultConditionByLocationFiltering("isDeleted.equals=" + DEFAULT_IS_DELETED, "isDeleted.equals=" + UPDATED_IS_DELETED);
    }

    @Test
    @Transactional
    void getAllConditionByLocationsByIsDeletedIsInShouldWork() throws Exception {
        // Initialize the database
        insertedConditionByLocation = conditionByLocationRepository.saveAndFlush(conditionByLocation);

        // Get all the conditionByLocationList where isDeleted in
        defaultConditionByLocationFiltering(
            "isDeleted.in=" + DEFAULT_IS_DELETED + "," + UPDATED_IS_DELETED,
            "isDeleted.in=" + UPDATED_IS_DELETED
        );
    }

    @Test
    @Transactional
    void getAllConditionByLocationsByIsDeletedIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedConditionByLocation = conditionByLocationRepository.saveAndFlush(conditionByLocation);

        // Get all the conditionByLocationList where isDeleted is not null
        defaultConditionByLocationFiltering("isDeleted.specified=true", "isDeleted.specified=false");
    }

    @Test
    @Transactional
    void getAllConditionByLocationsByDeletedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedConditionByLocation = conditionByLocationRepository.saveAndFlush(conditionByLocation);

        // Get all the conditionByLocationList where deletedAt equals to
        defaultConditionByLocationFiltering("deletedAt.equals=" + DEFAULT_DELETED_AT, "deletedAt.equals=" + UPDATED_DELETED_AT);
    }

    @Test
    @Transactional
    void getAllConditionByLocationsByDeletedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedConditionByLocation = conditionByLocationRepository.saveAndFlush(conditionByLocation);

        // Get all the conditionByLocationList where deletedAt in
        defaultConditionByLocationFiltering(
            "deletedAt.in=" + DEFAULT_DELETED_AT + "," + UPDATED_DELETED_AT,
            "deletedAt.in=" + UPDATED_DELETED_AT
        );
    }

    @Test
    @Transactional
    void getAllConditionByLocationsByDeletedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedConditionByLocation = conditionByLocationRepository.saveAndFlush(conditionByLocation);

        // Get all the conditionByLocationList where deletedAt is not null
        defaultConditionByLocationFiltering("deletedAt.specified=true", "deletedAt.specified=false");
    }

    @Test
    @Transactional
    void getAllConditionByLocationsByDeletedByIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedConditionByLocation = conditionByLocationRepository.saveAndFlush(conditionByLocation);

        // Get all the conditionByLocationList where deletedBy equals to
        defaultConditionByLocationFiltering("deletedBy.equals=" + DEFAULT_DELETED_BY, "deletedBy.equals=" + UPDATED_DELETED_BY);
    }

    @Test
    @Transactional
    void getAllConditionByLocationsByDeletedByIsInShouldWork() throws Exception {
        // Initialize the database
        insertedConditionByLocation = conditionByLocationRepository.saveAndFlush(conditionByLocation);

        // Get all the conditionByLocationList where deletedBy in
        defaultConditionByLocationFiltering(
            "deletedBy.in=" + DEFAULT_DELETED_BY + "," + UPDATED_DELETED_BY,
            "deletedBy.in=" + UPDATED_DELETED_BY
        );
    }

    @Test
    @Transactional
    void getAllConditionByLocationsByDeletedByIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedConditionByLocation = conditionByLocationRepository.saveAndFlush(conditionByLocation);

        // Get all the conditionByLocationList where deletedBy is not null
        defaultConditionByLocationFiltering("deletedBy.specified=true", "deletedBy.specified=false");
    }

    @Test
    @Transactional
    void getAllConditionByLocationsByPromotionIsEqualToSomething() throws Exception {
        Promotion promotion;
        if (TestUtil.findAll(em, Promotion.class).isEmpty()) {
            conditionByLocationRepository.saveAndFlush(conditionByLocation);
            promotion = PromotionResourceIT.createEntity();
        } else {
            promotion = TestUtil.findAll(em, Promotion.class).get(0);
        }
        em.persist(promotion);
        em.flush();
        conditionByLocation.setPromotion(promotion);
        conditionByLocationRepository.saveAndFlush(conditionByLocation);
        Long promotionId = promotion.getId();
        // Get all the conditionByLocationList where promotion equals to promotionId
        defaultConditionByLocationShouldBeFound("promotionId.equals=" + promotionId);

        // Get all the conditionByLocationList where promotion equals to (promotionId + 1)
        defaultConditionByLocationShouldNotBeFound("promotionId.equals=" + (promotionId + 1));
    }

    private void defaultConditionByLocationFiltering(String shouldBeFound, String shouldNotBeFound) throws Exception {
        defaultConditionByLocationShouldBeFound(shouldBeFound);
        defaultConditionByLocationShouldNotBeFound(shouldNotBeFound);
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultConditionByLocationShouldBeFound(String filter) throws Exception {
        restConditionByLocationMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(conditionByLocation.getId().intValue())))
            .andExpect(jsonPath("$.[*].provinceId").value(hasItem(DEFAULT_PROVINCE_ID.toString())))
            .andExpect(jsonPath("$.[*].districtId").value(hasItem(DEFAULT_DISTRICT_ID.toString())))
            .andExpect(jsonPath("$.[*].wardId").value(hasItem(DEFAULT_WARD_ID.toString())))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].isDeleted").value(hasItem(DEFAULT_IS_DELETED)))
            .andExpect(jsonPath("$.[*].deletedAt").value(hasItem(DEFAULT_DELETED_AT.toString())))
            .andExpect(jsonPath("$.[*].deletedBy").value(hasItem(DEFAULT_DELETED_BY.toString())));

        // Check, that the count call also returns 1
        restConditionByLocationMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("1"));
    }

    /**
     * Executes the search, and checks that the default entity is not returned.
     */
    private void defaultConditionByLocationShouldNotBeFound(String filter) throws Exception {
        restConditionByLocationMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());

        // Check, that the count call also returns 0
        restConditionByLocationMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("0"));
    }

    @Test
    @Transactional
    void getNonExistingConditionByLocation() throws Exception {
        // Get the conditionByLocation
        restConditionByLocationMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingConditionByLocation() throws Exception {
        // Initialize the database
        insertedConditionByLocation = conditionByLocationRepository.saveAndFlush(conditionByLocation);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the conditionByLocation
        ConditionByLocation updatedConditionByLocation = conditionByLocationRepository.findById(conditionByLocation.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedConditionByLocation are not directly saved in db
        em.detach(updatedConditionByLocation);
        updatedConditionByLocation
            .provinceId(UPDATED_PROVINCE_ID)
            .districtId(UPDATED_DISTRICT_ID)
            .wardId(UPDATED_WARD_ID)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);
        ConditionByLocationDTO conditionByLocationDTO = conditionByLocationMapper.toDto(updatedConditionByLocation);

        restConditionByLocationMockMvc
            .perform(
                put(ENTITY_API_URL_ID, conditionByLocationDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(conditionByLocationDTO))
            )
            .andExpect(status().isOk());

        // Validate the ConditionByLocation in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedConditionByLocationToMatchAllProperties(updatedConditionByLocation);
    }

    @Test
    @Transactional
    void putNonExistingConditionByLocation() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        conditionByLocation.setId(longCount.incrementAndGet());

        // Create the ConditionByLocation
        ConditionByLocationDTO conditionByLocationDTO = conditionByLocationMapper.toDto(conditionByLocation);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restConditionByLocationMockMvc
            .perform(
                put(ENTITY_API_URL_ID, conditionByLocationDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(conditionByLocationDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the ConditionByLocation in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchConditionByLocation() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        conditionByLocation.setId(longCount.incrementAndGet());

        // Create the ConditionByLocation
        ConditionByLocationDTO conditionByLocationDTO = conditionByLocationMapper.toDto(conditionByLocation);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restConditionByLocationMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(conditionByLocationDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the ConditionByLocation in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamConditionByLocation() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        conditionByLocation.setId(longCount.incrementAndGet());

        // Create the ConditionByLocation
        ConditionByLocationDTO conditionByLocationDTO = conditionByLocationMapper.toDto(conditionByLocation);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restConditionByLocationMockMvc
            .perform(
                put(ENTITY_API_URL)
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(conditionByLocationDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the ConditionByLocation in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateConditionByLocationWithPatch() throws Exception {
        // Initialize the database
        insertedConditionByLocation = conditionByLocationRepository.saveAndFlush(conditionByLocation);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the conditionByLocation using partial update
        ConditionByLocation partialUpdatedConditionByLocation = new ConditionByLocation();
        partialUpdatedConditionByLocation.setId(conditionByLocation.getId());

        partialUpdatedConditionByLocation.districtId(UPDATED_DISTRICT_ID).updatedAt(UPDATED_UPDATED_AT).isDeleted(UPDATED_IS_DELETED);

        restConditionByLocationMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedConditionByLocation.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedConditionByLocation))
            )
            .andExpect(status().isOk());

        // Validate the ConditionByLocation in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertConditionByLocationUpdatableFieldsEquals(
            createUpdateProxyForBean(partialUpdatedConditionByLocation, conditionByLocation),
            getPersistedConditionByLocation(conditionByLocation)
        );
    }

    @Test
    @Transactional
    void fullUpdateConditionByLocationWithPatch() throws Exception {
        // Initialize the database
        insertedConditionByLocation = conditionByLocationRepository.saveAndFlush(conditionByLocation);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the conditionByLocation using partial update
        ConditionByLocation partialUpdatedConditionByLocation = new ConditionByLocation();
        partialUpdatedConditionByLocation.setId(conditionByLocation.getId());

        partialUpdatedConditionByLocation
            .provinceId(UPDATED_PROVINCE_ID)
            .districtId(UPDATED_DISTRICT_ID)
            .wardId(UPDATED_WARD_ID)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);

        restConditionByLocationMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedConditionByLocation.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedConditionByLocation))
            )
            .andExpect(status().isOk());

        // Validate the ConditionByLocation in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertConditionByLocationUpdatableFieldsEquals(
            partialUpdatedConditionByLocation,
            getPersistedConditionByLocation(partialUpdatedConditionByLocation)
        );
    }

    @Test
    @Transactional
    void patchNonExistingConditionByLocation() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        conditionByLocation.setId(longCount.incrementAndGet());

        // Create the ConditionByLocation
        ConditionByLocationDTO conditionByLocationDTO = conditionByLocationMapper.toDto(conditionByLocation);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restConditionByLocationMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, conditionByLocationDTO.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(conditionByLocationDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the ConditionByLocation in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchConditionByLocation() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        conditionByLocation.setId(longCount.incrementAndGet());

        // Create the ConditionByLocation
        ConditionByLocationDTO conditionByLocationDTO = conditionByLocationMapper.toDto(conditionByLocation);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restConditionByLocationMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(conditionByLocationDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the ConditionByLocation in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamConditionByLocation() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        conditionByLocation.setId(longCount.incrementAndGet());

        // Create the ConditionByLocation
        ConditionByLocationDTO conditionByLocationDTO = conditionByLocationMapper.toDto(conditionByLocation);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restConditionByLocationMockMvc
            .perform(
                patch(ENTITY_API_URL)
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(conditionByLocationDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the ConditionByLocation in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteConditionByLocation() throws Exception {
        // Initialize the database
        insertedConditionByLocation = conditionByLocationRepository.saveAndFlush(conditionByLocation);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the conditionByLocation
        restConditionByLocationMockMvc
            .perform(delete(ENTITY_API_URL_ID, conditionByLocation.getId()).with(csrf()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return conditionByLocationRepository.count();
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

    protected ConditionByLocation getPersistedConditionByLocation(ConditionByLocation conditionByLocation) {
        return conditionByLocationRepository.findById(conditionByLocation.getId()).orElseThrow();
    }

    protected void assertPersistedConditionByLocationToMatchAllProperties(ConditionByLocation expectedConditionByLocation) {
        assertConditionByLocationAllPropertiesEquals(
            expectedConditionByLocation,
            getPersistedConditionByLocation(expectedConditionByLocation)
        );
    }

    protected void assertPersistedConditionByLocationToMatchUpdatableProperties(ConditionByLocation expectedConditionByLocation) {
        assertConditionByLocationAllUpdatablePropertiesEquals(
            expectedConditionByLocation,
            getPersistedConditionByLocation(expectedConditionByLocation)
        );
    }
}
