package com.ridehub.promotion.web.rest;

import static com.ridehub.promotion.domain.ConditionRouteItemAsserts.*;
import static com.ridehub.promotion.web.rest.TestUtil.createUpdateProxyForBean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ridehub.promotion.IntegrationTest;
import com.ridehub.promotion.domain.ConditionByRoute;
import com.ridehub.promotion.domain.ConditionRouteItem;
import com.ridehub.promotion.repository.ConditionRouteItemRepository;
import com.ridehub.promotion.service.dto.ConditionRouteItemDTO;
import com.ridehub.promotion.service.mapper.ConditionRouteItemMapper;
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
 * Integration tests for the {@link ConditionRouteItemResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class ConditionRouteItemResourceIT {

    private static final UUID DEFAULT_ROUTE_ID = UUID.randomUUID();
    private static final UUID UPDATED_ROUTE_ID = UUID.randomUUID();

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

    private static final String ENTITY_API_URL = "/api/condition-route-items";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private ConditionRouteItemRepository conditionRouteItemRepository;

    @Autowired
    private ConditionRouteItemMapper conditionRouteItemMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restConditionRouteItemMockMvc;

    private ConditionRouteItem conditionRouteItem;

    private ConditionRouteItem insertedConditionRouteItem;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ConditionRouteItem createEntity(EntityManager em) {
        ConditionRouteItem conditionRouteItem = new ConditionRouteItem()
            .routeId(DEFAULT_ROUTE_ID)
            .createdAt(DEFAULT_CREATED_AT)
            .updatedAt(DEFAULT_UPDATED_AT)
            .isDeleted(DEFAULT_IS_DELETED)
            .deletedAt(DEFAULT_DELETED_AT)
            .deletedBy(DEFAULT_DELETED_BY);
        // Add required entity
        ConditionByRoute conditionByRoute;
        if (TestUtil.findAll(em, ConditionByRoute.class).isEmpty()) {
            conditionByRoute = ConditionByRouteResourceIT.createEntity(em);
            em.persist(conditionByRoute);
            em.flush();
        } else {
            conditionByRoute = TestUtil.findAll(em, ConditionByRoute.class).get(0);
        }
        conditionRouteItem.setCondition(conditionByRoute);
        return conditionRouteItem;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ConditionRouteItem createUpdatedEntity(EntityManager em) {
        ConditionRouteItem updatedConditionRouteItem = new ConditionRouteItem()
            .routeId(UPDATED_ROUTE_ID)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);
        // Add required entity
        ConditionByRoute conditionByRoute;
        if (TestUtil.findAll(em, ConditionByRoute.class).isEmpty()) {
            conditionByRoute = ConditionByRouteResourceIT.createUpdatedEntity(em);
            em.persist(conditionByRoute);
            em.flush();
        } else {
            conditionByRoute = TestUtil.findAll(em, ConditionByRoute.class).get(0);
        }
        updatedConditionRouteItem.setCondition(conditionByRoute);
        return updatedConditionRouteItem;
    }

    @BeforeEach
    void initTest() {
        conditionRouteItem = createEntity(em);
    }

    @AfterEach
    void cleanup() {
        if (insertedConditionRouteItem != null) {
            conditionRouteItemRepository.delete(insertedConditionRouteItem);
            insertedConditionRouteItem = null;
        }
    }

    @Test
    @Transactional
    void createConditionRouteItem() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the ConditionRouteItem
        ConditionRouteItemDTO conditionRouteItemDTO = conditionRouteItemMapper.toDto(conditionRouteItem);
        var returnedConditionRouteItemDTO = om.readValue(
            restConditionRouteItemMockMvc
                .perform(
                    post(ENTITY_API_URL)
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsBytes(conditionRouteItemDTO))
                )
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            ConditionRouteItemDTO.class
        );

        // Validate the ConditionRouteItem in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        var returnedConditionRouteItem = conditionRouteItemMapper.toEntity(returnedConditionRouteItemDTO);
        assertConditionRouteItemUpdatableFieldsEquals(
            returnedConditionRouteItem,
            getPersistedConditionRouteItem(returnedConditionRouteItem)
        );

        insertedConditionRouteItem = returnedConditionRouteItem;
    }

    @Test
    @Transactional
    void createConditionRouteItemWithExistingId() throws Exception {
        // Create the ConditionRouteItem with an existing ID
        conditionRouteItem.setId(1L);
        ConditionRouteItemDTO conditionRouteItemDTO = conditionRouteItemMapper.toDto(conditionRouteItem);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restConditionRouteItemMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(conditionRouteItemDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the ConditionRouteItem in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkRouteIdIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        conditionRouteItem.setRouteId(null);

        // Create the ConditionRouteItem, which fails.
        ConditionRouteItemDTO conditionRouteItemDTO = conditionRouteItemMapper.toDto(conditionRouteItem);

        restConditionRouteItemMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(conditionRouteItemDTO))
            )
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkCreatedAtIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        conditionRouteItem.setCreatedAt(null);

        // Create the ConditionRouteItem, which fails.
        ConditionRouteItemDTO conditionRouteItemDTO = conditionRouteItemMapper.toDto(conditionRouteItem);

        restConditionRouteItemMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(conditionRouteItemDTO))
            )
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllConditionRouteItems() throws Exception {
        // Initialize the database
        insertedConditionRouteItem = conditionRouteItemRepository.saveAndFlush(conditionRouteItem);

        // Get all the conditionRouteItemList
        restConditionRouteItemMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(conditionRouteItem.getId().intValue())))
            .andExpect(jsonPath("$.[*].routeId").value(hasItem(DEFAULT_ROUTE_ID.toString())))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].isDeleted").value(hasItem(DEFAULT_IS_DELETED)))
            .andExpect(jsonPath("$.[*].deletedAt").value(hasItem(DEFAULT_DELETED_AT.toString())))
            .andExpect(jsonPath("$.[*].deletedBy").value(hasItem(DEFAULT_DELETED_BY.toString())));
    }

    @Test
    @Transactional
    void getConditionRouteItem() throws Exception {
        // Initialize the database
        insertedConditionRouteItem = conditionRouteItemRepository.saveAndFlush(conditionRouteItem);

        // Get the conditionRouteItem
        restConditionRouteItemMockMvc
            .perform(get(ENTITY_API_URL_ID, conditionRouteItem.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(conditionRouteItem.getId().intValue()))
            .andExpect(jsonPath("$.routeId").value(DEFAULT_ROUTE_ID.toString()))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.updatedAt").value(DEFAULT_UPDATED_AT.toString()))
            .andExpect(jsonPath("$.isDeleted").value(DEFAULT_IS_DELETED))
            .andExpect(jsonPath("$.deletedAt").value(DEFAULT_DELETED_AT.toString()))
            .andExpect(jsonPath("$.deletedBy").value(DEFAULT_DELETED_BY.toString()));
    }

    @Test
    @Transactional
    void getConditionRouteItemsByIdFiltering() throws Exception {
        // Initialize the database
        insertedConditionRouteItem = conditionRouteItemRepository.saveAndFlush(conditionRouteItem);

        Long id = conditionRouteItem.getId();

        defaultConditionRouteItemFiltering("id.equals=" + id, "id.notEquals=" + id);

        defaultConditionRouteItemFiltering("id.greaterThanOrEqual=" + id, "id.greaterThan=" + id);

        defaultConditionRouteItemFiltering("id.lessThanOrEqual=" + id, "id.lessThan=" + id);
    }

    @Test
    @Transactional
    void getAllConditionRouteItemsByRouteIdIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedConditionRouteItem = conditionRouteItemRepository.saveAndFlush(conditionRouteItem);

        // Get all the conditionRouteItemList where routeId equals to
        defaultConditionRouteItemFiltering("routeId.equals=" + DEFAULT_ROUTE_ID, "routeId.equals=" + UPDATED_ROUTE_ID);
    }

    @Test
    @Transactional
    void getAllConditionRouteItemsByRouteIdIsInShouldWork() throws Exception {
        // Initialize the database
        insertedConditionRouteItem = conditionRouteItemRepository.saveAndFlush(conditionRouteItem);

        // Get all the conditionRouteItemList where routeId in
        defaultConditionRouteItemFiltering("routeId.in=" + DEFAULT_ROUTE_ID + "," + UPDATED_ROUTE_ID, "routeId.in=" + UPDATED_ROUTE_ID);
    }

    @Test
    @Transactional
    void getAllConditionRouteItemsByRouteIdIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedConditionRouteItem = conditionRouteItemRepository.saveAndFlush(conditionRouteItem);

        // Get all the conditionRouteItemList where routeId is not null
        defaultConditionRouteItemFiltering("routeId.specified=true", "routeId.specified=false");
    }

    @Test
    @Transactional
    void getAllConditionRouteItemsByCreatedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedConditionRouteItem = conditionRouteItemRepository.saveAndFlush(conditionRouteItem);

        // Get all the conditionRouteItemList where createdAt equals to
        defaultConditionRouteItemFiltering("createdAt.equals=" + DEFAULT_CREATED_AT, "createdAt.equals=" + UPDATED_CREATED_AT);
    }

    @Test
    @Transactional
    void getAllConditionRouteItemsByCreatedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedConditionRouteItem = conditionRouteItemRepository.saveAndFlush(conditionRouteItem);

        // Get all the conditionRouteItemList where createdAt in
        defaultConditionRouteItemFiltering(
            "createdAt.in=" + DEFAULT_CREATED_AT + "," + UPDATED_CREATED_AT,
            "createdAt.in=" + UPDATED_CREATED_AT
        );
    }

    @Test
    @Transactional
    void getAllConditionRouteItemsByCreatedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedConditionRouteItem = conditionRouteItemRepository.saveAndFlush(conditionRouteItem);

        // Get all the conditionRouteItemList where createdAt is not null
        defaultConditionRouteItemFiltering("createdAt.specified=true", "createdAt.specified=false");
    }

    @Test
    @Transactional
    void getAllConditionRouteItemsByUpdatedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedConditionRouteItem = conditionRouteItemRepository.saveAndFlush(conditionRouteItem);

        // Get all the conditionRouteItemList where updatedAt equals to
        defaultConditionRouteItemFiltering("updatedAt.equals=" + DEFAULT_UPDATED_AT, "updatedAt.equals=" + UPDATED_UPDATED_AT);
    }

    @Test
    @Transactional
    void getAllConditionRouteItemsByUpdatedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedConditionRouteItem = conditionRouteItemRepository.saveAndFlush(conditionRouteItem);

        // Get all the conditionRouteItemList where updatedAt in
        defaultConditionRouteItemFiltering(
            "updatedAt.in=" + DEFAULT_UPDATED_AT + "," + UPDATED_UPDATED_AT,
            "updatedAt.in=" + UPDATED_UPDATED_AT
        );
    }

    @Test
    @Transactional
    void getAllConditionRouteItemsByUpdatedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedConditionRouteItem = conditionRouteItemRepository.saveAndFlush(conditionRouteItem);

        // Get all the conditionRouteItemList where updatedAt is not null
        defaultConditionRouteItemFiltering("updatedAt.specified=true", "updatedAt.specified=false");
    }

    @Test
    @Transactional
    void getAllConditionRouteItemsByIsDeletedIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedConditionRouteItem = conditionRouteItemRepository.saveAndFlush(conditionRouteItem);

        // Get all the conditionRouteItemList where isDeleted equals to
        defaultConditionRouteItemFiltering("isDeleted.equals=" + DEFAULT_IS_DELETED, "isDeleted.equals=" + UPDATED_IS_DELETED);
    }

    @Test
    @Transactional
    void getAllConditionRouteItemsByIsDeletedIsInShouldWork() throws Exception {
        // Initialize the database
        insertedConditionRouteItem = conditionRouteItemRepository.saveAndFlush(conditionRouteItem);

        // Get all the conditionRouteItemList where isDeleted in
        defaultConditionRouteItemFiltering(
            "isDeleted.in=" + DEFAULT_IS_DELETED + "," + UPDATED_IS_DELETED,
            "isDeleted.in=" + UPDATED_IS_DELETED
        );
    }

    @Test
    @Transactional
    void getAllConditionRouteItemsByIsDeletedIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedConditionRouteItem = conditionRouteItemRepository.saveAndFlush(conditionRouteItem);

        // Get all the conditionRouteItemList where isDeleted is not null
        defaultConditionRouteItemFiltering("isDeleted.specified=true", "isDeleted.specified=false");
    }

    @Test
    @Transactional
    void getAllConditionRouteItemsByDeletedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedConditionRouteItem = conditionRouteItemRepository.saveAndFlush(conditionRouteItem);

        // Get all the conditionRouteItemList where deletedAt equals to
        defaultConditionRouteItemFiltering("deletedAt.equals=" + DEFAULT_DELETED_AT, "deletedAt.equals=" + UPDATED_DELETED_AT);
    }

    @Test
    @Transactional
    void getAllConditionRouteItemsByDeletedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedConditionRouteItem = conditionRouteItemRepository.saveAndFlush(conditionRouteItem);

        // Get all the conditionRouteItemList where deletedAt in
        defaultConditionRouteItemFiltering(
            "deletedAt.in=" + DEFAULT_DELETED_AT + "," + UPDATED_DELETED_AT,
            "deletedAt.in=" + UPDATED_DELETED_AT
        );
    }

    @Test
    @Transactional
    void getAllConditionRouteItemsByDeletedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedConditionRouteItem = conditionRouteItemRepository.saveAndFlush(conditionRouteItem);

        // Get all the conditionRouteItemList where deletedAt is not null
        defaultConditionRouteItemFiltering("deletedAt.specified=true", "deletedAt.specified=false");
    }

    @Test
    @Transactional
    void getAllConditionRouteItemsByDeletedByIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedConditionRouteItem = conditionRouteItemRepository.saveAndFlush(conditionRouteItem);

        // Get all the conditionRouteItemList where deletedBy equals to
        defaultConditionRouteItemFiltering("deletedBy.equals=" + DEFAULT_DELETED_BY, "deletedBy.equals=" + UPDATED_DELETED_BY);
    }

    @Test
    @Transactional
    void getAllConditionRouteItemsByDeletedByIsInShouldWork() throws Exception {
        // Initialize the database
        insertedConditionRouteItem = conditionRouteItemRepository.saveAndFlush(conditionRouteItem);

        // Get all the conditionRouteItemList where deletedBy in
        defaultConditionRouteItemFiltering(
            "deletedBy.in=" + DEFAULT_DELETED_BY + "," + UPDATED_DELETED_BY,
            "deletedBy.in=" + UPDATED_DELETED_BY
        );
    }

    @Test
    @Transactional
    void getAllConditionRouteItemsByDeletedByIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedConditionRouteItem = conditionRouteItemRepository.saveAndFlush(conditionRouteItem);

        // Get all the conditionRouteItemList where deletedBy is not null
        defaultConditionRouteItemFiltering("deletedBy.specified=true", "deletedBy.specified=false");
    }

    @Test
    @Transactional
    void getAllConditionRouteItemsByConditionIsEqualToSomething() throws Exception {
        ConditionByRoute condition;
        if (TestUtil.findAll(em, ConditionByRoute.class).isEmpty()) {
            conditionRouteItemRepository.saveAndFlush(conditionRouteItem);
            condition = ConditionByRouteResourceIT.createEntity(em);
        } else {
            condition = TestUtil.findAll(em, ConditionByRoute.class).get(0);
        }
        em.persist(condition);
        em.flush();
        conditionRouteItem.setCondition(condition);
        conditionRouteItemRepository.saveAndFlush(conditionRouteItem);
        Long conditionId = condition.getId();
        // Get all the conditionRouteItemList where condition equals to conditionId
        defaultConditionRouteItemShouldBeFound("conditionId.equals=" + conditionId);

        // Get all the conditionRouteItemList where condition equals to (conditionId + 1)
        defaultConditionRouteItemShouldNotBeFound("conditionId.equals=" + (conditionId + 1));
    }

    private void defaultConditionRouteItemFiltering(String shouldBeFound, String shouldNotBeFound) throws Exception {
        defaultConditionRouteItemShouldBeFound(shouldBeFound);
        defaultConditionRouteItemShouldNotBeFound(shouldNotBeFound);
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultConditionRouteItemShouldBeFound(String filter) throws Exception {
        restConditionRouteItemMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(conditionRouteItem.getId().intValue())))
            .andExpect(jsonPath("$.[*].routeId").value(hasItem(DEFAULT_ROUTE_ID.toString())))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].isDeleted").value(hasItem(DEFAULT_IS_DELETED)))
            .andExpect(jsonPath("$.[*].deletedAt").value(hasItem(DEFAULT_DELETED_AT.toString())))
            .andExpect(jsonPath("$.[*].deletedBy").value(hasItem(DEFAULT_DELETED_BY.toString())));

        // Check, that the count call also returns 1
        restConditionRouteItemMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("1"));
    }

    /**
     * Executes the search, and checks that the default entity is not returned.
     */
    private void defaultConditionRouteItemShouldNotBeFound(String filter) throws Exception {
        restConditionRouteItemMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());

        // Check, that the count call also returns 0
        restConditionRouteItemMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("0"));
    }

    @Test
    @Transactional
    void getNonExistingConditionRouteItem() throws Exception {
        // Get the conditionRouteItem
        restConditionRouteItemMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingConditionRouteItem() throws Exception {
        // Initialize the database
        insertedConditionRouteItem = conditionRouteItemRepository.saveAndFlush(conditionRouteItem);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the conditionRouteItem
        ConditionRouteItem updatedConditionRouteItem = conditionRouteItemRepository.findById(conditionRouteItem.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedConditionRouteItem are not directly saved in db
        em.detach(updatedConditionRouteItem);
        updatedConditionRouteItem
            .routeId(UPDATED_ROUTE_ID)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);
        ConditionRouteItemDTO conditionRouteItemDTO = conditionRouteItemMapper.toDto(updatedConditionRouteItem);

        restConditionRouteItemMockMvc
            .perform(
                put(ENTITY_API_URL_ID, conditionRouteItemDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(conditionRouteItemDTO))
            )
            .andExpect(status().isOk());

        // Validate the ConditionRouteItem in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedConditionRouteItemToMatchAllProperties(updatedConditionRouteItem);
    }

    @Test
    @Transactional
    void putNonExistingConditionRouteItem() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        conditionRouteItem.setId(longCount.incrementAndGet());

        // Create the ConditionRouteItem
        ConditionRouteItemDTO conditionRouteItemDTO = conditionRouteItemMapper.toDto(conditionRouteItem);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restConditionRouteItemMockMvc
            .perform(
                put(ENTITY_API_URL_ID, conditionRouteItemDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(conditionRouteItemDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the ConditionRouteItem in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchConditionRouteItem() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        conditionRouteItem.setId(longCount.incrementAndGet());

        // Create the ConditionRouteItem
        ConditionRouteItemDTO conditionRouteItemDTO = conditionRouteItemMapper.toDto(conditionRouteItem);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restConditionRouteItemMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(conditionRouteItemDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the ConditionRouteItem in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamConditionRouteItem() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        conditionRouteItem.setId(longCount.incrementAndGet());

        // Create the ConditionRouteItem
        ConditionRouteItemDTO conditionRouteItemDTO = conditionRouteItemMapper.toDto(conditionRouteItem);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restConditionRouteItemMockMvc
            .perform(
                put(ENTITY_API_URL)
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(conditionRouteItemDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the ConditionRouteItem in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateConditionRouteItemWithPatch() throws Exception {
        // Initialize the database
        insertedConditionRouteItem = conditionRouteItemRepository.saveAndFlush(conditionRouteItem);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the conditionRouteItem using partial update
        ConditionRouteItem partialUpdatedConditionRouteItem = new ConditionRouteItem();
        partialUpdatedConditionRouteItem.setId(conditionRouteItem.getId());

        partialUpdatedConditionRouteItem.routeId(UPDATED_ROUTE_ID).createdAt(UPDATED_CREATED_AT);

        restConditionRouteItemMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedConditionRouteItem.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedConditionRouteItem))
            )
            .andExpect(status().isOk());

        // Validate the ConditionRouteItem in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertConditionRouteItemUpdatableFieldsEquals(
            createUpdateProxyForBean(partialUpdatedConditionRouteItem, conditionRouteItem),
            getPersistedConditionRouteItem(conditionRouteItem)
        );
    }

    @Test
    @Transactional
    void fullUpdateConditionRouteItemWithPatch() throws Exception {
        // Initialize the database
        insertedConditionRouteItem = conditionRouteItemRepository.saveAndFlush(conditionRouteItem);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the conditionRouteItem using partial update
        ConditionRouteItem partialUpdatedConditionRouteItem = new ConditionRouteItem();
        partialUpdatedConditionRouteItem.setId(conditionRouteItem.getId());

        partialUpdatedConditionRouteItem
            .routeId(UPDATED_ROUTE_ID)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);

        restConditionRouteItemMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedConditionRouteItem.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedConditionRouteItem))
            )
            .andExpect(status().isOk());

        // Validate the ConditionRouteItem in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertConditionRouteItemUpdatableFieldsEquals(
            partialUpdatedConditionRouteItem,
            getPersistedConditionRouteItem(partialUpdatedConditionRouteItem)
        );
    }

    @Test
    @Transactional
    void patchNonExistingConditionRouteItem() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        conditionRouteItem.setId(longCount.incrementAndGet());

        // Create the ConditionRouteItem
        ConditionRouteItemDTO conditionRouteItemDTO = conditionRouteItemMapper.toDto(conditionRouteItem);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restConditionRouteItemMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, conditionRouteItemDTO.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(conditionRouteItemDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the ConditionRouteItem in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchConditionRouteItem() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        conditionRouteItem.setId(longCount.incrementAndGet());

        // Create the ConditionRouteItem
        ConditionRouteItemDTO conditionRouteItemDTO = conditionRouteItemMapper.toDto(conditionRouteItem);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restConditionRouteItemMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(conditionRouteItemDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the ConditionRouteItem in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamConditionRouteItem() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        conditionRouteItem.setId(longCount.incrementAndGet());

        // Create the ConditionRouteItem
        ConditionRouteItemDTO conditionRouteItemDTO = conditionRouteItemMapper.toDto(conditionRouteItem);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restConditionRouteItemMockMvc
            .perform(
                patch(ENTITY_API_URL)
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(conditionRouteItemDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the ConditionRouteItem in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteConditionRouteItem() throws Exception {
        // Initialize the database
        insertedConditionRouteItem = conditionRouteItemRepository.saveAndFlush(conditionRouteItem);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the conditionRouteItem
        restConditionRouteItemMockMvc
            .perform(delete(ENTITY_API_URL_ID, conditionRouteItem.getId()).with(csrf()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return conditionRouteItemRepository.count();
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

    protected ConditionRouteItem getPersistedConditionRouteItem(ConditionRouteItem conditionRouteItem) {
        return conditionRouteItemRepository.findById(conditionRouteItem.getId()).orElseThrow();
    }

    protected void assertPersistedConditionRouteItemToMatchAllProperties(ConditionRouteItem expectedConditionRouteItem) {
        assertConditionRouteItemAllPropertiesEquals(expectedConditionRouteItem, getPersistedConditionRouteItem(expectedConditionRouteItem));
    }

    protected void assertPersistedConditionRouteItemToMatchUpdatableProperties(ConditionRouteItem expectedConditionRouteItem) {
        assertConditionRouteItemAllUpdatablePropertiesEquals(
            expectedConditionRouteItem,
            getPersistedConditionRouteItem(expectedConditionRouteItem)
        );
    }
}
