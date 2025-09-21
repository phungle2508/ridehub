package com.ridehub.promotion.web.rest;

import static com.ridehub.promotion.domain.ConditionLocationItemAsserts.*;
import static com.ridehub.promotion.web.rest.TestUtil.createUpdateProxyForBean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ridehub.promotion.IntegrationTest;
import com.ridehub.promotion.domain.ConditionByLocation;
import com.ridehub.promotion.domain.ConditionLocationItem;
import com.ridehub.promotion.repository.ConditionLocationItemRepository;
import com.ridehub.promotion.service.dto.ConditionLocationItemDTO;
import com.ridehub.promotion.service.mapper.ConditionLocationItemMapper;
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
 * Integration tests for the {@link ConditionLocationItemResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class ConditionLocationItemResourceIT {

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

    private static final String ENTITY_API_URL = "/api/condition-location-items";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private ConditionLocationItemRepository conditionLocationItemRepository;

    @Autowired
    private ConditionLocationItemMapper conditionLocationItemMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restConditionLocationItemMockMvc;

    private ConditionLocationItem conditionLocationItem;

    private ConditionLocationItem insertedConditionLocationItem;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ConditionLocationItem createEntity(EntityManager em) {
        ConditionLocationItem conditionLocationItem = new ConditionLocationItem()
            .provinceId(DEFAULT_PROVINCE_ID)
            .districtId(DEFAULT_DISTRICT_ID)
            .wardId(DEFAULT_WARD_ID)
            .createdAt(DEFAULT_CREATED_AT)
            .updatedAt(DEFAULT_UPDATED_AT)
            .isDeleted(DEFAULT_IS_DELETED)
            .deletedAt(DEFAULT_DELETED_AT)
            .deletedBy(DEFAULT_DELETED_BY);
        // Add required entity
        ConditionByLocation conditionByLocation;
        if (TestUtil.findAll(em, ConditionByLocation.class).isEmpty()) {
            conditionByLocation = ConditionByLocationResourceIT.createEntity(em);
            em.persist(conditionByLocation);
            em.flush();
        } else {
            conditionByLocation = TestUtil.findAll(em, ConditionByLocation.class).get(0);
        }
        conditionLocationItem.setCondition(conditionByLocation);
        return conditionLocationItem;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ConditionLocationItem createUpdatedEntity(EntityManager em) {
        ConditionLocationItem updatedConditionLocationItem = new ConditionLocationItem()
            .provinceId(UPDATED_PROVINCE_ID)
            .districtId(UPDATED_DISTRICT_ID)
            .wardId(UPDATED_WARD_ID)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);
        // Add required entity
        ConditionByLocation conditionByLocation;
        if (TestUtil.findAll(em, ConditionByLocation.class).isEmpty()) {
            conditionByLocation = ConditionByLocationResourceIT.createUpdatedEntity(em);
            em.persist(conditionByLocation);
            em.flush();
        } else {
            conditionByLocation = TestUtil.findAll(em, ConditionByLocation.class).get(0);
        }
        updatedConditionLocationItem.setCondition(conditionByLocation);
        return updatedConditionLocationItem;
    }

    @BeforeEach
    void initTest() {
        conditionLocationItem = createEntity(em);
    }

    @AfterEach
    void cleanup() {
        if (insertedConditionLocationItem != null) {
            conditionLocationItemRepository.delete(insertedConditionLocationItem);
            insertedConditionLocationItem = null;
        }
    }

    @Test
    @Transactional
    void createConditionLocationItem() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the ConditionLocationItem
        ConditionLocationItemDTO conditionLocationItemDTO = conditionLocationItemMapper.toDto(conditionLocationItem);
        var returnedConditionLocationItemDTO = om.readValue(
            restConditionLocationItemMockMvc
                .perform(
                    post(ENTITY_API_URL)
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsBytes(conditionLocationItemDTO))
                )
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            ConditionLocationItemDTO.class
        );

        // Validate the ConditionLocationItem in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        var returnedConditionLocationItem = conditionLocationItemMapper.toEntity(returnedConditionLocationItemDTO);
        assertConditionLocationItemUpdatableFieldsEquals(
            returnedConditionLocationItem,
            getPersistedConditionLocationItem(returnedConditionLocationItem)
        );

        insertedConditionLocationItem = returnedConditionLocationItem;
    }

    @Test
    @Transactional
    void createConditionLocationItemWithExistingId() throws Exception {
        // Create the ConditionLocationItem with an existing ID
        conditionLocationItem.setId(1L);
        ConditionLocationItemDTO conditionLocationItemDTO = conditionLocationItemMapper.toDto(conditionLocationItem);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restConditionLocationItemMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(conditionLocationItemDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the ConditionLocationItem in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkCreatedAtIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        conditionLocationItem.setCreatedAt(null);

        // Create the ConditionLocationItem, which fails.
        ConditionLocationItemDTO conditionLocationItemDTO = conditionLocationItemMapper.toDto(conditionLocationItem);

        restConditionLocationItemMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(conditionLocationItemDTO))
            )
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllConditionLocationItems() throws Exception {
        // Initialize the database
        insertedConditionLocationItem = conditionLocationItemRepository.saveAndFlush(conditionLocationItem);

        // Get all the conditionLocationItemList
        restConditionLocationItemMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(conditionLocationItem.getId().intValue())))
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
    void getConditionLocationItem() throws Exception {
        // Initialize the database
        insertedConditionLocationItem = conditionLocationItemRepository.saveAndFlush(conditionLocationItem);

        // Get the conditionLocationItem
        restConditionLocationItemMockMvc
            .perform(get(ENTITY_API_URL_ID, conditionLocationItem.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(conditionLocationItem.getId().intValue()))
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
    void getConditionLocationItemsByIdFiltering() throws Exception {
        // Initialize the database
        insertedConditionLocationItem = conditionLocationItemRepository.saveAndFlush(conditionLocationItem);

        Long id = conditionLocationItem.getId();

        defaultConditionLocationItemFiltering("id.equals=" + id, "id.notEquals=" + id);

        defaultConditionLocationItemFiltering("id.greaterThanOrEqual=" + id, "id.greaterThan=" + id);

        defaultConditionLocationItemFiltering("id.lessThanOrEqual=" + id, "id.lessThan=" + id);
    }

    @Test
    @Transactional
    void getAllConditionLocationItemsByProvinceIdIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedConditionLocationItem = conditionLocationItemRepository.saveAndFlush(conditionLocationItem);

        // Get all the conditionLocationItemList where provinceId equals to
        defaultConditionLocationItemFiltering("provinceId.equals=" + DEFAULT_PROVINCE_ID, "provinceId.equals=" + UPDATED_PROVINCE_ID);
    }

    @Test
    @Transactional
    void getAllConditionLocationItemsByProvinceIdIsInShouldWork() throws Exception {
        // Initialize the database
        insertedConditionLocationItem = conditionLocationItemRepository.saveAndFlush(conditionLocationItem);

        // Get all the conditionLocationItemList where provinceId in
        defaultConditionLocationItemFiltering(
            "provinceId.in=" + DEFAULT_PROVINCE_ID + "," + UPDATED_PROVINCE_ID,
            "provinceId.in=" + UPDATED_PROVINCE_ID
        );
    }

    @Test
    @Transactional
    void getAllConditionLocationItemsByProvinceIdIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedConditionLocationItem = conditionLocationItemRepository.saveAndFlush(conditionLocationItem);

        // Get all the conditionLocationItemList where provinceId is not null
        defaultConditionLocationItemFiltering("provinceId.specified=true", "provinceId.specified=false");
    }

    @Test
    @Transactional
    void getAllConditionLocationItemsByDistrictIdIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedConditionLocationItem = conditionLocationItemRepository.saveAndFlush(conditionLocationItem);

        // Get all the conditionLocationItemList where districtId equals to
        defaultConditionLocationItemFiltering("districtId.equals=" + DEFAULT_DISTRICT_ID, "districtId.equals=" + UPDATED_DISTRICT_ID);
    }

    @Test
    @Transactional
    void getAllConditionLocationItemsByDistrictIdIsInShouldWork() throws Exception {
        // Initialize the database
        insertedConditionLocationItem = conditionLocationItemRepository.saveAndFlush(conditionLocationItem);

        // Get all the conditionLocationItemList where districtId in
        defaultConditionLocationItemFiltering(
            "districtId.in=" + DEFAULT_DISTRICT_ID + "," + UPDATED_DISTRICT_ID,
            "districtId.in=" + UPDATED_DISTRICT_ID
        );
    }

    @Test
    @Transactional
    void getAllConditionLocationItemsByDistrictIdIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedConditionLocationItem = conditionLocationItemRepository.saveAndFlush(conditionLocationItem);

        // Get all the conditionLocationItemList where districtId is not null
        defaultConditionLocationItemFiltering("districtId.specified=true", "districtId.specified=false");
    }

    @Test
    @Transactional
    void getAllConditionLocationItemsByWardIdIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedConditionLocationItem = conditionLocationItemRepository.saveAndFlush(conditionLocationItem);

        // Get all the conditionLocationItemList where wardId equals to
        defaultConditionLocationItemFiltering("wardId.equals=" + DEFAULT_WARD_ID, "wardId.equals=" + UPDATED_WARD_ID);
    }

    @Test
    @Transactional
    void getAllConditionLocationItemsByWardIdIsInShouldWork() throws Exception {
        // Initialize the database
        insertedConditionLocationItem = conditionLocationItemRepository.saveAndFlush(conditionLocationItem);

        // Get all the conditionLocationItemList where wardId in
        defaultConditionLocationItemFiltering("wardId.in=" + DEFAULT_WARD_ID + "," + UPDATED_WARD_ID, "wardId.in=" + UPDATED_WARD_ID);
    }

    @Test
    @Transactional
    void getAllConditionLocationItemsByWardIdIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedConditionLocationItem = conditionLocationItemRepository.saveAndFlush(conditionLocationItem);

        // Get all the conditionLocationItemList where wardId is not null
        defaultConditionLocationItemFiltering("wardId.specified=true", "wardId.specified=false");
    }

    @Test
    @Transactional
    void getAllConditionLocationItemsByCreatedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedConditionLocationItem = conditionLocationItemRepository.saveAndFlush(conditionLocationItem);

        // Get all the conditionLocationItemList where createdAt equals to
        defaultConditionLocationItemFiltering("createdAt.equals=" + DEFAULT_CREATED_AT, "createdAt.equals=" + UPDATED_CREATED_AT);
    }

    @Test
    @Transactional
    void getAllConditionLocationItemsByCreatedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedConditionLocationItem = conditionLocationItemRepository.saveAndFlush(conditionLocationItem);

        // Get all the conditionLocationItemList where createdAt in
        defaultConditionLocationItemFiltering(
            "createdAt.in=" + DEFAULT_CREATED_AT + "," + UPDATED_CREATED_AT,
            "createdAt.in=" + UPDATED_CREATED_AT
        );
    }

    @Test
    @Transactional
    void getAllConditionLocationItemsByCreatedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedConditionLocationItem = conditionLocationItemRepository.saveAndFlush(conditionLocationItem);

        // Get all the conditionLocationItemList where createdAt is not null
        defaultConditionLocationItemFiltering("createdAt.specified=true", "createdAt.specified=false");
    }

    @Test
    @Transactional
    void getAllConditionLocationItemsByUpdatedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedConditionLocationItem = conditionLocationItemRepository.saveAndFlush(conditionLocationItem);

        // Get all the conditionLocationItemList where updatedAt equals to
        defaultConditionLocationItemFiltering("updatedAt.equals=" + DEFAULT_UPDATED_AT, "updatedAt.equals=" + UPDATED_UPDATED_AT);
    }

    @Test
    @Transactional
    void getAllConditionLocationItemsByUpdatedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedConditionLocationItem = conditionLocationItemRepository.saveAndFlush(conditionLocationItem);

        // Get all the conditionLocationItemList where updatedAt in
        defaultConditionLocationItemFiltering(
            "updatedAt.in=" + DEFAULT_UPDATED_AT + "," + UPDATED_UPDATED_AT,
            "updatedAt.in=" + UPDATED_UPDATED_AT
        );
    }

    @Test
    @Transactional
    void getAllConditionLocationItemsByUpdatedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedConditionLocationItem = conditionLocationItemRepository.saveAndFlush(conditionLocationItem);

        // Get all the conditionLocationItemList where updatedAt is not null
        defaultConditionLocationItemFiltering("updatedAt.specified=true", "updatedAt.specified=false");
    }

    @Test
    @Transactional
    void getAllConditionLocationItemsByIsDeletedIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedConditionLocationItem = conditionLocationItemRepository.saveAndFlush(conditionLocationItem);

        // Get all the conditionLocationItemList where isDeleted equals to
        defaultConditionLocationItemFiltering("isDeleted.equals=" + DEFAULT_IS_DELETED, "isDeleted.equals=" + UPDATED_IS_DELETED);
    }

    @Test
    @Transactional
    void getAllConditionLocationItemsByIsDeletedIsInShouldWork() throws Exception {
        // Initialize the database
        insertedConditionLocationItem = conditionLocationItemRepository.saveAndFlush(conditionLocationItem);

        // Get all the conditionLocationItemList where isDeleted in
        defaultConditionLocationItemFiltering(
            "isDeleted.in=" + DEFAULT_IS_DELETED + "," + UPDATED_IS_DELETED,
            "isDeleted.in=" + UPDATED_IS_DELETED
        );
    }

    @Test
    @Transactional
    void getAllConditionLocationItemsByIsDeletedIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedConditionLocationItem = conditionLocationItemRepository.saveAndFlush(conditionLocationItem);

        // Get all the conditionLocationItemList where isDeleted is not null
        defaultConditionLocationItemFiltering("isDeleted.specified=true", "isDeleted.specified=false");
    }

    @Test
    @Transactional
    void getAllConditionLocationItemsByDeletedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedConditionLocationItem = conditionLocationItemRepository.saveAndFlush(conditionLocationItem);

        // Get all the conditionLocationItemList where deletedAt equals to
        defaultConditionLocationItemFiltering("deletedAt.equals=" + DEFAULT_DELETED_AT, "deletedAt.equals=" + UPDATED_DELETED_AT);
    }

    @Test
    @Transactional
    void getAllConditionLocationItemsByDeletedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedConditionLocationItem = conditionLocationItemRepository.saveAndFlush(conditionLocationItem);

        // Get all the conditionLocationItemList where deletedAt in
        defaultConditionLocationItemFiltering(
            "deletedAt.in=" + DEFAULT_DELETED_AT + "," + UPDATED_DELETED_AT,
            "deletedAt.in=" + UPDATED_DELETED_AT
        );
    }

    @Test
    @Transactional
    void getAllConditionLocationItemsByDeletedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedConditionLocationItem = conditionLocationItemRepository.saveAndFlush(conditionLocationItem);

        // Get all the conditionLocationItemList where deletedAt is not null
        defaultConditionLocationItemFiltering("deletedAt.specified=true", "deletedAt.specified=false");
    }

    @Test
    @Transactional
    void getAllConditionLocationItemsByDeletedByIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedConditionLocationItem = conditionLocationItemRepository.saveAndFlush(conditionLocationItem);

        // Get all the conditionLocationItemList where deletedBy equals to
        defaultConditionLocationItemFiltering("deletedBy.equals=" + DEFAULT_DELETED_BY, "deletedBy.equals=" + UPDATED_DELETED_BY);
    }

    @Test
    @Transactional
    void getAllConditionLocationItemsByDeletedByIsInShouldWork() throws Exception {
        // Initialize the database
        insertedConditionLocationItem = conditionLocationItemRepository.saveAndFlush(conditionLocationItem);

        // Get all the conditionLocationItemList where deletedBy in
        defaultConditionLocationItemFiltering(
            "deletedBy.in=" + DEFAULT_DELETED_BY + "," + UPDATED_DELETED_BY,
            "deletedBy.in=" + UPDATED_DELETED_BY
        );
    }

    @Test
    @Transactional
    void getAllConditionLocationItemsByDeletedByIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedConditionLocationItem = conditionLocationItemRepository.saveAndFlush(conditionLocationItem);

        // Get all the conditionLocationItemList where deletedBy is not null
        defaultConditionLocationItemFiltering("deletedBy.specified=true", "deletedBy.specified=false");
    }

    @Test
    @Transactional
    void getAllConditionLocationItemsByConditionIsEqualToSomething() throws Exception {
        ConditionByLocation condition;
        if (TestUtil.findAll(em, ConditionByLocation.class).isEmpty()) {
            conditionLocationItemRepository.saveAndFlush(conditionLocationItem);
            condition = ConditionByLocationResourceIT.createEntity(em);
        } else {
            condition = TestUtil.findAll(em, ConditionByLocation.class).get(0);
        }
        em.persist(condition);
        em.flush();
        conditionLocationItem.setCondition(condition);
        conditionLocationItemRepository.saveAndFlush(conditionLocationItem);
        Long conditionId = condition.getId();
        // Get all the conditionLocationItemList where condition equals to conditionId
        defaultConditionLocationItemShouldBeFound("conditionId.equals=" + conditionId);

        // Get all the conditionLocationItemList where condition equals to (conditionId + 1)
        defaultConditionLocationItemShouldNotBeFound("conditionId.equals=" + (conditionId + 1));
    }

    private void defaultConditionLocationItemFiltering(String shouldBeFound, String shouldNotBeFound) throws Exception {
        defaultConditionLocationItemShouldBeFound(shouldBeFound);
        defaultConditionLocationItemShouldNotBeFound(shouldNotBeFound);
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultConditionLocationItemShouldBeFound(String filter) throws Exception {
        restConditionLocationItemMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(conditionLocationItem.getId().intValue())))
            .andExpect(jsonPath("$.[*].provinceId").value(hasItem(DEFAULT_PROVINCE_ID.toString())))
            .andExpect(jsonPath("$.[*].districtId").value(hasItem(DEFAULT_DISTRICT_ID.toString())))
            .andExpect(jsonPath("$.[*].wardId").value(hasItem(DEFAULT_WARD_ID.toString())))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].isDeleted").value(hasItem(DEFAULT_IS_DELETED)))
            .andExpect(jsonPath("$.[*].deletedAt").value(hasItem(DEFAULT_DELETED_AT.toString())))
            .andExpect(jsonPath("$.[*].deletedBy").value(hasItem(DEFAULT_DELETED_BY.toString())));

        // Check, that the count call also returns 1
        restConditionLocationItemMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("1"));
    }

    /**
     * Executes the search, and checks that the default entity is not returned.
     */
    private void defaultConditionLocationItemShouldNotBeFound(String filter) throws Exception {
        restConditionLocationItemMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());

        // Check, that the count call also returns 0
        restConditionLocationItemMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("0"));
    }

    @Test
    @Transactional
    void getNonExistingConditionLocationItem() throws Exception {
        // Get the conditionLocationItem
        restConditionLocationItemMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingConditionLocationItem() throws Exception {
        // Initialize the database
        insertedConditionLocationItem = conditionLocationItemRepository.saveAndFlush(conditionLocationItem);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the conditionLocationItem
        ConditionLocationItem updatedConditionLocationItem = conditionLocationItemRepository
            .findById(conditionLocationItem.getId())
            .orElseThrow();
        // Disconnect from session so that the updates on updatedConditionLocationItem are not directly saved in db
        em.detach(updatedConditionLocationItem);
        updatedConditionLocationItem
            .provinceId(UPDATED_PROVINCE_ID)
            .districtId(UPDATED_DISTRICT_ID)
            .wardId(UPDATED_WARD_ID)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);
        ConditionLocationItemDTO conditionLocationItemDTO = conditionLocationItemMapper.toDto(updatedConditionLocationItem);

        restConditionLocationItemMockMvc
            .perform(
                put(ENTITY_API_URL_ID, conditionLocationItemDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(conditionLocationItemDTO))
            )
            .andExpect(status().isOk());

        // Validate the ConditionLocationItem in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedConditionLocationItemToMatchAllProperties(updatedConditionLocationItem);
    }

    @Test
    @Transactional
    void putNonExistingConditionLocationItem() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        conditionLocationItem.setId(longCount.incrementAndGet());

        // Create the ConditionLocationItem
        ConditionLocationItemDTO conditionLocationItemDTO = conditionLocationItemMapper.toDto(conditionLocationItem);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restConditionLocationItemMockMvc
            .perform(
                put(ENTITY_API_URL_ID, conditionLocationItemDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(conditionLocationItemDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the ConditionLocationItem in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchConditionLocationItem() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        conditionLocationItem.setId(longCount.incrementAndGet());

        // Create the ConditionLocationItem
        ConditionLocationItemDTO conditionLocationItemDTO = conditionLocationItemMapper.toDto(conditionLocationItem);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restConditionLocationItemMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(conditionLocationItemDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the ConditionLocationItem in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamConditionLocationItem() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        conditionLocationItem.setId(longCount.incrementAndGet());

        // Create the ConditionLocationItem
        ConditionLocationItemDTO conditionLocationItemDTO = conditionLocationItemMapper.toDto(conditionLocationItem);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restConditionLocationItemMockMvc
            .perform(
                put(ENTITY_API_URL)
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(conditionLocationItemDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the ConditionLocationItem in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateConditionLocationItemWithPatch() throws Exception {
        // Initialize the database
        insertedConditionLocationItem = conditionLocationItemRepository.saveAndFlush(conditionLocationItem);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the conditionLocationItem using partial update
        ConditionLocationItem partialUpdatedConditionLocationItem = new ConditionLocationItem();
        partialUpdatedConditionLocationItem.setId(conditionLocationItem.getId());

        partialUpdatedConditionLocationItem
            .provinceId(UPDATED_PROVINCE_ID)
            .districtId(UPDATED_DISTRICT_ID)
            .updatedAt(UPDATED_UPDATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);

        restConditionLocationItemMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedConditionLocationItem.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedConditionLocationItem))
            )
            .andExpect(status().isOk());

        // Validate the ConditionLocationItem in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertConditionLocationItemUpdatableFieldsEquals(
            createUpdateProxyForBean(partialUpdatedConditionLocationItem, conditionLocationItem),
            getPersistedConditionLocationItem(conditionLocationItem)
        );
    }

    @Test
    @Transactional
    void fullUpdateConditionLocationItemWithPatch() throws Exception {
        // Initialize the database
        insertedConditionLocationItem = conditionLocationItemRepository.saveAndFlush(conditionLocationItem);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the conditionLocationItem using partial update
        ConditionLocationItem partialUpdatedConditionLocationItem = new ConditionLocationItem();
        partialUpdatedConditionLocationItem.setId(conditionLocationItem.getId());

        partialUpdatedConditionLocationItem
            .provinceId(UPDATED_PROVINCE_ID)
            .districtId(UPDATED_DISTRICT_ID)
            .wardId(UPDATED_WARD_ID)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);

        restConditionLocationItemMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedConditionLocationItem.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedConditionLocationItem))
            )
            .andExpect(status().isOk());

        // Validate the ConditionLocationItem in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertConditionLocationItemUpdatableFieldsEquals(
            partialUpdatedConditionLocationItem,
            getPersistedConditionLocationItem(partialUpdatedConditionLocationItem)
        );
    }

    @Test
    @Transactional
    void patchNonExistingConditionLocationItem() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        conditionLocationItem.setId(longCount.incrementAndGet());

        // Create the ConditionLocationItem
        ConditionLocationItemDTO conditionLocationItemDTO = conditionLocationItemMapper.toDto(conditionLocationItem);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restConditionLocationItemMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, conditionLocationItemDTO.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(conditionLocationItemDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the ConditionLocationItem in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchConditionLocationItem() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        conditionLocationItem.setId(longCount.incrementAndGet());

        // Create the ConditionLocationItem
        ConditionLocationItemDTO conditionLocationItemDTO = conditionLocationItemMapper.toDto(conditionLocationItem);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restConditionLocationItemMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(conditionLocationItemDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the ConditionLocationItem in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamConditionLocationItem() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        conditionLocationItem.setId(longCount.incrementAndGet());

        // Create the ConditionLocationItem
        ConditionLocationItemDTO conditionLocationItemDTO = conditionLocationItemMapper.toDto(conditionLocationItem);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restConditionLocationItemMockMvc
            .perform(
                patch(ENTITY_API_URL)
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(conditionLocationItemDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the ConditionLocationItem in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteConditionLocationItem() throws Exception {
        // Initialize the database
        insertedConditionLocationItem = conditionLocationItemRepository.saveAndFlush(conditionLocationItem);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the conditionLocationItem
        restConditionLocationItemMockMvc
            .perform(delete(ENTITY_API_URL_ID, conditionLocationItem.getId()).with(csrf()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return conditionLocationItemRepository.count();
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

    protected ConditionLocationItem getPersistedConditionLocationItem(ConditionLocationItem conditionLocationItem) {
        return conditionLocationItemRepository.findById(conditionLocationItem.getId()).orElseThrow();
    }

    protected void assertPersistedConditionLocationItemToMatchAllProperties(ConditionLocationItem expectedConditionLocationItem) {
        assertConditionLocationItemAllPropertiesEquals(
            expectedConditionLocationItem,
            getPersistedConditionLocationItem(expectedConditionLocationItem)
        );
    }

    protected void assertPersistedConditionLocationItemToMatchUpdatableProperties(ConditionLocationItem expectedConditionLocationItem) {
        assertConditionLocationItemAllUpdatablePropertiesEquals(
            expectedConditionLocationItem,
            getPersistedConditionLocationItem(expectedConditionLocationItem)
        );
    }
}
