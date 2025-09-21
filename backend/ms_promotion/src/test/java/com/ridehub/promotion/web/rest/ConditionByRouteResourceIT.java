package com.ridehub.promotion.web.rest;

import static com.ridehub.promotion.domain.ConditionByRouteAsserts.*;
import static com.ridehub.promotion.web.rest.TestUtil.createUpdateProxyForBean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ridehub.promotion.IntegrationTest;
import com.ridehub.promotion.domain.ConditionByRoute;
import com.ridehub.promotion.domain.Promotion;
import com.ridehub.promotion.repository.ConditionByRouteRepository;
import com.ridehub.promotion.service.dto.ConditionByRouteDTO;
import com.ridehub.promotion.service.mapper.ConditionByRouteMapper;
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
 * Integration tests for the {@link ConditionByRouteResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class ConditionByRouteResourceIT {

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

    private static final String ENTITY_API_URL = "/api/condition-by-routes";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private ConditionByRouteRepository conditionByRouteRepository;

    @Autowired
    private ConditionByRouteMapper conditionByRouteMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restConditionByRouteMockMvc;

    private ConditionByRoute conditionByRoute;

    private ConditionByRoute insertedConditionByRoute;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ConditionByRoute createEntity(EntityManager em) {
        ConditionByRoute conditionByRoute = new ConditionByRoute()
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
        conditionByRoute.setPromotion(promotion);
        return conditionByRoute;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ConditionByRoute createUpdatedEntity(EntityManager em) {
        ConditionByRoute updatedConditionByRoute = new ConditionByRoute()
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
        updatedConditionByRoute.setPromotion(promotion);
        return updatedConditionByRoute;
    }

    @BeforeEach
    void initTest() {
        conditionByRoute = createEntity(em);
    }

    @AfterEach
    void cleanup() {
        if (insertedConditionByRoute != null) {
            conditionByRouteRepository.delete(insertedConditionByRoute);
            insertedConditionByRoute = null;
        }
    }

    @Test
    @Transactional
    void createConditionByRoute() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the ConditionByRoute
        ConditionByRouteDTO conditionByRouteDTO = conditionByRouteMapper.toDto(conditionByRoute);
        var returnedConditionByRouteDTO = om.readValue(
            restConditionByRouteMockMvc
                .perform(
                    post(ENTITY_API_URL)
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsBytes(conditionByRouteDTO))
                )
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            ConditionByRouteDTO.class
        );

        // Validate the ConditionByRoute in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        var returnedConditionByRoute = conditionByRouteMapper.toEntity(returnedConditionByRouteDTO);
        assertConditionByRouteUpdatableFieldsEquals(returnedConditionByRoute, getPersistedConditionByRoute(returnedConditionByRoute));

        insertedConditionByRoute = returnedConditionByRoute;
    }

    @Test
    @Transactional
    void createConditionByRouteWithExistingId() throws Exception {
        // Create the ConditionByRoute with an existing ID
        conditionByRoute.setId(1L);
        ConditionByRouteDTO conditionByRouteDTO = conditionByRouteMapper.toDto(conditionByRoute);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restConditionByRouteMockMvc
            .perform(
                post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(conditionByRouteDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the ConditionByRoute in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkCreatedAtIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        conditionByRoute.setCreatedAt(null);

        // Create the ConditionByRoute, which fails.
        ConditionByRouteDTO conditionByRouteDTO = conditionByRouteMapper.toDto(conditionByRoute);

        restConditionByRouteMockMvc
            .perform(
                post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(conditionByRouteDTO))
            )
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllConditionByRoutes() throws Exception {
        // Initialize the database
        insertedConditionByRoute = conditionByRouteRepository.saveAndFlush(conditionByRoute);

        // Get all the conditionByRouteList
        restConditionByRouteMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(conditionByRoute.getId().intValue())))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].isDeleted").value(hasItem(DEFAULT_IS_DELETED)))
            .andExpect(jsonPath("$.[*].deletedAt").value(hasItem(DEFAULT_DELETED_AT.toString())))
            .andExpect(jsonPath("$.[*].deletedBy").value(hasItem(DEFAULT_DELETED_BY.toString())));
    }

    @Test
    @Transactional
    void getConditionByRoute() throws Exception {
        // Initialize the database
        insertedConditionByRoute = conditionByRouteRepository.saveAndFlush(conditionByRoute);

        // Get the conditionByRoute
        restConditionByRouteMockMvc
            .perform(get(ENTITY_API_URL_ID, conditionByRoute.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(conditionByRoute.getId().intValue()))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.updatedAt").value(DEFAULT_UPDATED_AT.toString()))
            .andExpect(jsonPath("$.isDeleted").value(DEFAULT_IS_DELETED))
            .andExpect(jsonPath("$.deletedAt").value(DEFAULT_DELETED_AT.toString()))
            .andExpect(jsonPath("$.deletedBy").value(DEFAULT_DELETED_BY.toString()));
    }

    @Test
    @Transactional
    void getConditionByRoutesByIdFiltering() throws Exception {
        // Initialize the database
        insertedConditionByRoute = conditionByRouteRepository.saveAndFlush(conditionByRoute);

        Long id = conditionByRoute.getId();

        defaultConditionByRouteFiltering("id.equals=" + id, "id.notEquals=" + id);

        defaultConditionByRouteFiltering("id.greaterThanOrEqual=" + id, "id.greaterThan=" + id);

        defaultConditionByRouteFiltering("id.lessThanOrEqual=" + id, "id.lessThan=" + id);
    }

    @Test
    @Transactional
    void getAllConditionByRoutesByCreatedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedConditionByRoute = conditionByRouteRepository.saveAndFlush(conditionByRoute);

        // Get all the conditionByRouteList where createdAt equals to
        defaultConditionByRouteFiltering("createdAt.equals=" + DEFAULT_CREATED_AT, "createdAt.equals=" + UPDATED_CREATED_AT);
    }

    @Test
    @Transactional
    void getAllConditionByRoutesByCreatedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedConditionByRoute = conditionByRouteRepository.saveAndFlush(conditionByRoute);

        // Get all the conditionByRouteList where createdAt in
        defaultConditionByRouteFiltering(
            "createdAt.in=" + DEFAULT_CREATED_AT + "," + UPDATED_CREATED_AT,
            "createdAt.in=" + UPDATED_CREATED_AT
        );
    }

    @Test
    @Transactional
    void getAllConditionByRoutesByCreatedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedConditionByRoute = conditionByRouteRepository.saveAndFlush(conditionByRoute);

        // Get all the conditionByRouteList where createdAt is not null
        defaultConditionByRouteFiltering("createdAt.specified=true", "createdAt.specified=false");
    }

    @Test
    @Transactional
    void getAllConditionByRoutesByUpdatedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedConditionByRoute = conditionByRouteRepository.saveAndFlush(conditionByRoute);

        // Get all the conditionByRouteList where updatedAt equals to
        defaultConditionByRouteFiltering("updatedAt.equals=" + DEFAULT_UPDATED_AT, "updatedAt.equals=" + UPDATED_UPDATED_AT);
    }

    @Test
    @Transactional
    void getAllConditionByRoutesByUpdatedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedConditionByRoute = conditionByRouteRepository.saveAndFlush(conditionByRoute);

        // Get all the conditionByRouteList where updatedAt in
        defaultConditionByRouteFiltering(
            "updatedAt.in=" + DEFAULT_UPDATED_AT + "," + UPDATED_UPDATED_AT,
            "updatedAt.in=" + UPDATED_UPDATED_AT
        );
    }

    @Test
    @Transactional
    void getAllConditionByRoutesByUpdatedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedConditionByRoute = conditionByRouteRepository.saveAndFlush(conditionByRoute);

        // Get all the conditionByRouteList where updatedAt is not null
        defaultConditionByRouteFiltering("updatedAt.specified=true", "updatedAt.specified=false");
    }

    @Test
    @Transactional
    void getAllConditionByRoutesByIsDeletedIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedConditionByRoute = conditionByRouteRepository.saveAndFlush(conditionByRoute);

        // Get all the conditionByRouteList where isDeleted equals to
        defaultConditionByRouteFiltering("isDeleted.equals=" + DEFAULT_IS_DELETED, "isDeleted.equals=" + UPDATED_IS_DELETED);
    }

    @Test
    @Transactional
    void getAllConditionByRoutesByIsDeletedIsInShouldWork() throws Exception {
        // Initialize the database
        insertedConditionByRoute = conditionByRouteRepository.saveAndFlush(conditionByRoute);

        // Get all the conditionByRouteList where isDeleted in
        defaultConditionByRouteFiltering(
            "isDeleted.in=" + DEFAULT_IS_DELETED + "," + UPDATED_IS_DELETED,
            "isDeleted.in=" + UPDATED_IS_DELETED
        );
    }

    @Test
    @Transactional
    void getAllConditionByRoutesByIsDeletedIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedConditionByRoute = conditionByRouteRepository.saveAndFlush(conditionByRoute);

        // Get all the conditionByRouteList where isDeleted is not null
        defaultConditionByRouteFiltering("isDeleted.specified=true", "isDeleted.specified=false");
    }

    @Test
    @Transactional
    void getAllConditionByRoutesByDeletedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedConditionByRoute = conditionByRouteRepository.saveAndFlush(conditionByRoute);

        // Get all the conditionByRouteList where deletedAt equals to
        defaultConditionByRouteFiltering("deletedAt.equals=" + DEFAULT_DELETED_AT, "deletedAt.equals=" + UPDATED_DELETED_AT);
    }

    @Test
    @Transactional
    void getAllConditionByRoutesByDeletedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedConditionByRoute = conditionByRouteRepository.saveAndFlush(conditionByRoute);

        // Get all the conditionByRouteList where deletedAt in
        defaultConditionByRouteFiltering(
            "deletedAt.in=" + DEFAULT_DELETED_AT + "," + UPDATED_DELETED_AT,
            "deletedAt.in=" + UPDATED_DELETED_AT
        );
    }

    @Test
    @Transactional
    void getAllConditionByRoutesByDeletedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedConditionByRoute = conditionByRouteRepository.saveAndFlush(conditionByRoute);

        // Get all the conditionByRouteList where deletedAt is not null
        defaultConditionByRouteFiltering("deletedAt.specified=true", "deletedAt.specified=false");
    }

    @Test
    @Transactional
    void getAllConditionByRoutesByDeletedByIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedConditionByRoute = conditionByRouteRepository.saveAndFlush(conditionByRoute);

        // Get all the conditionByRouteList where deletedBy equals to
        defaultConditionByRouteFiltering("deletedBy.equals=" + DEFAULT_DELETED_BY, "deletedBy.equals=" + UPDATED_DELETED_BY);
    }

    @Test
    @Transactional
    void getAllConditionByRoutesByDeletedByIsInShouldWork() throws Exception {
        // Initialize the database
        insertedConditionByRoute = conditionByRouteRepository.saveAndFlush(conditionByRoute);

        // Get all the conditionByRouteList where deletedBy in
        defaultConditionByRouteFiltering(
            "deletedBy.in=" + DEFAULT_DELETED_BY + "," + UPDATED_DELETED_BY,
            "deletedBy.in=" + UPDATED_DELETED_BY
        );
    }

    @Test
    @Transactional
    void getAllConditionByRoutesByDeletedByIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedConditionByRoute = conditionByRouteRepository.saveAndFlush(conditionByRoute);

        // Get all the conditionByRouteList where deletedBy is not null
        defaultConditionByRouteFiltering("deletedBy.specified=true", "deletedBy.specified=false");
    }

    @Test
    @Transactional
    void getAllConditionByRoutesByPromotionIsEqualToSomething() throws Exception {
        Promotion promotion;
        if (TestUtil.findAll(em, Promotion.class).isEmpty()) {
            conditionByRouteRepository.saveAndFlush(conditionByRoute);
            promotion = PromotionResourceIT.createEntity();
        } else {
            promotion = TestUtil.findAll(em, Promotion.class).get(0);
        }
        em.persist(promotion);
        em.flush();
        conditionByRoute.setPromotion(promotion);
        conditionByRouteRepository.saveAndFlush(conditionByRoute);
        Long promotionId = promotion.getId();
        // Get all the conditionByRouteList where promotion equals to promotionId
        defaultConditionByRouteShouldBeFound("promotionId.equals=" + promotionId);

        // Get all the conditionByRouteList where promotion equals to (promotionId + 1)
        defaultConditionByRouteShouldNotBeFound("promotionId.equals=" + (promotionId + 1));
    }

    private void defaultConditionByRouteFiltering(String shouldBeFound, String shouldNotBeFound) throws Exception {
        defaultConditionByRouteShouldBeFound(shouldBeFound);
        defaultConditionByRouteShouldNotBeFound(shouldNotBeFound);
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultConditionByRouteShouldBeFound(String filter) throws Exception {
        restConditionByRouteMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(conditionByRoute.getId().intValue())))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].isDeleted").value(hasItem(DEFAULT_IS_DELETED)))
            .andExpect(jsonPath("$.[*].deletedAt").value(hasItem(DEFAULT_DELETED_AT.toString())))
            .andExpect(jsonPath("$.[*].deletedBy").value(hasItem(DEFAULT_DELETED_BY.toString())));

        // Check, that the count call also returns 1
        restConditionByRouteMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("1"));
    }

    /**
     * Executes the search, and checks that the default entity is not returned.
     */
    private void defaultConditionByRouteShouldNotBeFound(String filter) throws Exception {
        restConditionByRouteMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());

        // Check, that the count call also returns 0
        restConditionByRouteMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("0"));
    }

    @Test
    @Transactional
    void getNonExistingConditionByRoute() throws Exception {
        // Get the conditionByRoute
        restConditionByRouteMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingConditionByRoute() throws Exception {
        // Initialize the database
        insertedConditionByRoute = conditionByRouteRepository.saveAndFlush(conditionByRoute);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the conditionByRoute
        ConditionByRoute updatedConditionByRoute = conditionByRouteRepository.findById(conditionByRoute.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedConditionByRoute are not directly saved in db
        em.detach(updatedConditionByRoute);
        updatedConditionByRoute
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);
        ConditionByRouteDTO conditionByRouteDTO = conditionByRouteMapper.toDto(updatedConditionByRoute);

        restConditionByRouteMockMvc
            .perform(
                put(ENTITY_API_URL_ID, conditionByRouteDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(conditionByRouteDTO))
            )
            .andExpect(status().isOk());

        // Validate the ConditionByRoute in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedConditionByRouteToMatchAllProperties(updatedConditionByRoute);
    }

    @Test
    @Transactional
    void putNonExistingConditionByRoute() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        conditionByRoute.setId(longCount.incrementAndGet());

        // Create the ConditionByRoute
        ConditionByRouteDTO conditionByRouteDTO = conditionByRouteMapper.toDto(conditionByRoute);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restConditionByRouteMockMvc
            .perform(
                put(ENTITY_API_URL_ID, conditionByRouteDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(conditionByRouteDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the ConditionByRoute in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchConditionByRoute() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        conditionByRoute.setId(longCount.incrementAndGet());

        // Create the ConditionByRoute
        ConditionByRouteDTO conditionByRouteDTO = conditionByRouteMapper.toDto(conditionByRoute);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restConditionByRouteMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(conditionByRouteDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the ConditionByRoute in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamConditionByRoute() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        conditionByRoute.setId(longCount.incrementAndGet());

        // Create the ConditionByRoute
        ConditionByRouteDTO conditionByRouteDTO = conditionByRouteMapper.toDto(conditionByRoute);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restConditionByRouteMockMvc
            .perform(
                put(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(conditionByRouteDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the ConditionByRoute in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateConditionByRouteWithPatch() throws Exception {
        // Initialize the database
        insertedConditionByRoute = conditionByRouteRepository.saveAndFlush(conditionByRoute);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the conditionByRoute using partial update
        ConditionByRoute partialUpdatedConditionByRoute = new ConditionByRoute();
        partialUpdatedConditionByRoute.setId(conditionByRoute.getId());

        partialUpdatedConditionByRoute.createdAt(UPDATED_CREATED_AT).deletedAt(UPDATED_DELETED_AT);

        restConditionByRouteMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedConditionByRoute.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedConditionByRoute))
            )
            .andExpect(status().isOk());

        // Validate the ConditionByRoute in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertConditionByRouteUpdatableFieldsEquals(
            createUpdateProxyForBean(partialUpdatedConditionByRoute, conditionByRoute),
            getPersistedConditionByRoute(conditionByRoute)
        );
    }

    @Test
    @Transactional
    void fullUpdateConditionByRouteWithPatch() throws Exception {
        // Initialize the database
        insertedConditionByRoute = conditionByRouteRepository.saveAndFlush(conditionByRoute);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the conditionByRoute using partial update
        ConditionByRoute partialUpdatedConditionByRoute = new ConditionByRoute();
        partialUpdatedConditionByRoute.setId(conditionByRoute.getId());

        partialUpdatedConditionByRoute
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);

        restConditionByRouteMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedConditionByRoute.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedConditionByRoute))
            )
            .andExpect(status().isOk());

        // Validate the ConditionByRoute in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertConditionByRouteUpdatableFieldsEquals(
            partialUpdatedConditionByRoute,
            getPersistedConditionByRoute(partialUpdatedConditionByRoute)
        );
    }

    @Test
    @Transactional
    void patchNonExistingConditionByRoute() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        conditionByRoute.setId(longCount.incrementAndGet());

        // Create the ConditionByRoute
        ConditionByRouteDTO conditionByRouteDTO = conditionByRouteMapper.toDto(conditionByRoute);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restConditionByRouteMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, conditionByRouteDTO.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(conditionByRouteDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the ConditionByRoute in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchConditionByRoute() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        conditionByRoute.setId(longCount.incrementAndGet());

        // Create the ConditionByRoute
        ConditionByRouteDTO conditionByRouteDTO = conditionByRouteMapper.toDto(conditionByRoute);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restConditionByRouteMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(conditionByRouteDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the ConditionByRoute in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamConditionByRoute() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        conditionByRoute.setId(longCount.incrementAndGet());

        // Create the ConditionByRoute
        ConditionByRouteDTO conditionByRouteDTO = conditionByRouteMapper.toDto(conditionByRoute);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restConditionByRouteMockMvc
            .perform(
                patch(ENTITY_API_URL)
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(conditionByRouteDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the ConditionByRoute in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteConditionByRoute() throws Exception {
        // Initialize the database
        insertedConditionByRoute = conditionByRouteRepository.saveAndFlush(conditionByRoute);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the conditionByRoute
        restConditionByRouteMockMvc
            .perform(delete(ENTITY_API_URL_ID, conditionByRoute.getId()).with(csrf()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return conditionByRouteRepository.count();
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

    protected ConditionByRoute getPersistedConditionByRoute(ConditionByRoute conditionByRoute) {
        return conditionByRouteRepository.findById(conditionByRoute.getId()).orElseThrow();
    }

    protected void assertPersistedConditionByRouteToMatchAllProperties(ConditionByRoute expectedConditionByRoute) {
        assertConditionByRouteAllPropertiesEquals(expectedConditionByRoute, getPersistedConditionByRoute(expectedConditionByRoute));
    }

    protected void assertPersistedConditionByRouteToMatchUpdatableProperties(ConditionByRoute expectedConditionByRoute) {
        assertConditionByRouteAllUpdatablePropertiesEquals(
            expectedConditionByRoute,
            getPersistedConditionByRoute(expectedConditionByRoute)
        );
    }
}
