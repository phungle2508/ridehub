package com.ridehub.promotion.web.rest;

import static com.ridehub.promotion.domain.ConditionByDateAsserts.*;
import static com.ridehub.promotion.web.rest.TestUtil.createUpdateProxyForBean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ridehub.promotion.IntegrationTest;
import com.ridehub.promotion.domain.ConditionByDate;
import com.ridehub.promotion.domain.Promotion;
import com.ridehub.promotion.repository.ConditionByDateRepository;
import com.ridehub.promotion.service.dto.ConditionByDateDTO;
import com.ridehub.promotion.service.mapper.ConditionByDateMapper;
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
 * Integration tests for the {@link ConditionByDateResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class ConditionByDateResourceIT {

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

    private static final String ENTITY_API_URL = "/api/condition-by-dates";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private ConditionByDateRepository conditionByDateRepository;

    @Autowired
    private ConditionByDateMapper conditionByDateMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restConditionByDateMockMvc;

    private ConditionByDate conditionByDate;

    private ConditionByDate insertedConditionByDate;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ConditionByDate createEntity(EntityManager em) {
        ConditionByDate conditionByDate = new ConditionByDate()
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
        conditionByDate.setPromotion(promotion);
        return conditionByDate;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ConditionByDate createUpdatedEntity(EntityManager em) {
        ConditionByDate updatedConditionByDate = new ConditionByDate()
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
        updatedConditionByDate.setPromotion(promotion);
        return updatedConditionByDate;
    }

    @BeforeEach
    void initTest() {
        conditionByDate = createEntity(em);
    }

    @AfterEach
    void cleanup() {
        if (insertedConditionByDate != null) {
            conditionByDateRepository.delete(insertedConditionByDate);
            insertedConditionByDate = null;
        }
    }

    @Test
    @Transactional
    void createConditionByDate() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the ConditionByDate
        ConditionByDateDTO conditionByDateDTO = conditionByDateMapper.toDto(conditionByDate);
        var returnedConditionByDateDTO = om.readValue(
            restConditionByDateMockMvc
                .perform(
                    post(ENTITY_API_URL)
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsBytes(conditionByDateDTO))
                )
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            ConditionByDateDTO.class
        );

        // Validate the ConditionByDate in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        var returnedConditionByDate = conditionByDateMapper.toEntity(returnedConditionByDateDTO);
        assertConditionByDateUpdatableFieldsEquals(returnedConditionByDate, getPersistedConditionByDate(returnedConditionByDate));

        insertedConditionByDate = returnedConditionByDate;
    }

    @Test
    @Transactional
    void createConditionByDateWithExistingId() throws Exception {
        // Create the ConditionByDate with an existing ID
        conditionByDate.setId(1L);
        ConditionByDateDTO conditionByDateDTO = conditionByDateMapper.toDto(conditionByDate);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restConditionByDateMockMvc
            .perform(
                post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(conditionByDateDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the ConditionByDate in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkCreatedAtIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        conditionByDate.setCreatedAt(null);

        // Create the ConditionByDate, which fails.
        ConditionByDateDTO conditionByDateDTO = conditionByDateMapper.toDto(conditionByDate);

        restConditionByDateMockMvc
            .perform(
                post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(conditionByDateDTO))
            )
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllConditionByDates() throws Exception {
        // Initialize the database
        insertedConditionByDate = conditionByDateRepository.saveAndFlush(conditionByDate);

        // Get all the conditionByDateList
        restConditionByDateMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(conditionByDate.getId().intValue())))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].isDeleted").value(hasItem(DEFAULT_IS_DELETED)))
            .andExpect(jsonPath("$.[*].deletedAt").value(hasItem(DEFAULT_DELETED_AT.toString())))
            .andExpect(jsonPath("$.[*].deletedBy").value(hasItem(DEFAULT_DELETED_BY.toString())));
    }

    @Test
    @Transactional
    void getConditionByDate() throws Exception {
        // Initialize the database
        insertedConditionByDate = conditionByDateRepository.saveAndFlush(conditionByDate);

        // Get the conditionByDate
        restConditionByDateMockMvc
            .perform(get(ENTITY_API_URL_ID, conditionByDate.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(conditionByDate.getId().intValue()))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.updatedAt").value(DEFAULT_UPDATED_AT.toString()))
            .andExpect(jsonPath("$.isDeleted").value(DEFAULT_IS_DELETED))
            .andExpect(jsonPath("$.deletedAt").value(DEFAULT_DELETED_AT.toString()))
            .andExpect(jsonPath("$.deletedBy").value(DEFAULT_DELETED_BY.toString()));
    }

    @Test
    @Transactional
    void getConditionByDatesByIdFiltering() throws Exception {
        // Initialize the database
        insertedConditionByDate = conditionByDateRepository.saveAndFlush(conditionByDate);

        Long id = conditionByDate.getId();

        defaultConditionByDateFiltering("id.equals=" + id, "id.notEquals=" + id);

        defaultConditionByDateFiltering("id.greaterThanOrEqual=" + id, "id.greaterThan=" + id);

        defaultConditionByDateFiltering("id.lessThanOrEqual=" + id, "id.lessThan=" + id);
    }

    @Test
    @Transactional
    void getAllConditionByDatesByCreatedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedConditionByDate = conditionByDateRepository.saveAndFlush(conditionByDate);

        // Get all the conditionByDateList where createdAt equals to
        defaultConditionByDateFiltering("createdAt.equals=" + DEFAULT_CREATED_AT, "createdAt.equals=" + UPDATED_CREATED_AT);
    }

    @Test
    @Transactional
    void getAllConditionByDatesByCreatedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedConditionByDate = conditionByDateRepository.saveAndFlush(conditionByDate);

        // Get all the conditionByDateList where createdAt in
        defaultConditionByDateFiltering(
            "createdAt.in=" + DEFAULT_CREATED_AT + "," + UPDATED_CREATED_AT,
            "createdAt.in=" + UPDATED_CREATED_AT
        );
    }

    @Test
    @Transactional
    void getAllConditionByDatesByCreatedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedConditionByDate = conditionByDateRepository.saveAndFlush(conditionByDate);

        // Get all the conditionByDateList where createdAt is not null
        defaultConditionByDateFiltering("createdAt.specified=true", "createdAt.specified=false");
    }

    @Test
    @Transactional
    void getAllConditionByDatesByUpdatedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedConditionByDate = conditionByDateRepository.saveAndFlush(conditionByDate);

        // Get all the conditionByDateList where updatedAt equals to
        defaultConditionByDateFiltering("updatedAt.equals=" + DEFAULT_UPDATED_AT, "updatedAt.equals=" + UPDATED_UPDATED_AT);
    }

    @Test
    @Transactional
    void getAllConditionByDatesByUpdatedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedConditionByDate = conditionByDateRepository.saveAndFlush(conditionByDate);

        // Get all the conditionByDateList where updatedAt in
        defaultConditionByDateFiltering(
            "updatedAt.in=" + DEFAULT_UPDATED_AT + "," + UPDATED_UPDATED_AT,
            "updatedAt.in=" + UPDATED_UPDATED_AT
        );
    }

    @Test
    @Transactional
    void getAllConditionByDatesByUpdatedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedConditionByDate = conditionByDateRepository.saveAndFlush(conditionByDate);

        // Get all the conditionByDateList where updatedAt is not null
        defaultConditionByDateFiltering("updatedAt.specified=true", "updatedAt.specified=false");
    }

    @Test
    @Transactional
    void getAllConditionByDatesByIsDeletedIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedConditionByDate = conditionByDateRepository.saveAndFlush(conditionByDate);

        // Get all the conditionByDateList where isDeleted equals to
        defaultConditionByDateFiltering("isDeleted.equals=" + DEFAULT_IS_DELETED, "isDeleted.equals=" + UPDATED_IS_DELETED);
    }

    @Test
    @Transactional
    void getAllConditionByDatesByIsDeletedIsInShouldWork() throws Exception {
        // Initialize the database
        insertedConditionByDate = conditionByDateRepository.saveAndFlush(conditionByDate);

        // Get all the conditionByDateList where isDeleted in
        defaultConditionByDateFiltering(
            "isDeleted.in=" + DEFAULT_IS_DELETED + "," + UPDATED_IS_DELETED,
            "isDeleted.in=" + UPDATED_IS_DELETED
        );
    }

    @Test
    @Transactional
    void getAllConditionByDatesByIsDeletedIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedConditionByDate = conditionByDateRepository.saveAndFlush(conditionByDate);

        // Get all the conditionByDateList where isDeleted is not null
        defaultConditionByDateFiltering("isDeleted.specified=true", "isDeleted.specified=false");
    }

    @Test
    @Transactional
    void getAllConditionByDatesByDeletedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedConditionByDate = conditionByDateRepository.saveAndFlush(conditionByDate);

        // Get all the conditionByDateList where deletedAt equals to
        defaultConditionByDateFiltering("deletedAt.equals=" + DEFAULT_DELETED_AT, "deletedAt.equals=" + UPDATED_DELETED_AT);
    }

    @Test
    @Transactional
    void getAllConditionByDatesByDeletedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedConditionByDate = conditionByDateRepository.saveAndFlush(conditionByDate);

        // Get all the conditionByDateList where deletedAt in
        defaultConditionByDateFiltering(
            "deletedAt.in=" + DEFAULT_DELETED_AT + "," + UPDATED_DELETED_AT,
            "deletedAt.in=" + UPDATED_DELETED_AT
        );
    }

    @Test
    @Transactional
    void getAllConditionByDatesByDeletedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedConditionByDate = conditionByDateRepository.saveAndFlush(conditionByDate);

        // Get all the conditionByDateList where deletedAt is not null
        defaultConditionByDateFiltering("deletedAt.specified=true", "deletedAt.specified=false");
    }

    @Test
    @Transactional
    void getAllConditionByDatesByDeletedByIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedConditionByDate = conditionByDateRepository.saveAndFlush(conditionByDate);

        // Get all the conditionByDateList where deletedBy equals to
        defaultConditionByDateFiltering("deletedBy.equals=" + DEFAULT_DELETED_BY, "deletedBy.equals=" + UPDATED_DELETED_BY);
    }

    @Test
    @Transactional
    void getAllConditionByDatesByDeletedByIsInShouldWork() throws Exception {
        // Initialize the database
        insertedConditionByDate = conditionByDateRepository.saveAndFlush(conditionByDate);

        // Get all the conditionByDateList where deletedBy in
        defaultConditionByDateFiltering(
            "deletedBy.in=" + DEFAULT_DELETED_BY + "," + UPDATED_DELETED_BY,
            "deletedBy.in=" + UPDATED_DELETED_BY
        );
    }

    @Test
    @Transactional
    void getAllConditionByDatesByDeletedByIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedConditionByDate = conditionByDateRepository.saveAndFlush(conditionByDate);

        // Get all the conditionByDateList where deletedBy is not null
        defaultConditionByDateFiltering("deletedBy.specified=true", "deletedBy.specified=false");
    }

    @Test
    @Transactional
    void getAllConditionByDatesByPromotionIsEqualToSomething() throws Exception {
        Promotion promotion;
        if (TestUtil.findAll(em, Promotion.class).isEmpty()) {
            conditionByDateRepository.saveAndFlush(conditionByDate);
            promotion = PromotionResourceIT.createEntity();
        } else {
            promotion = TestUtil.findAll(em, Promotion.class).get(0);
        }
        em.persist(promotion);
        em.flush();
        conditionByDate.setPromotion(promotion);
        conditionByDateRepository.saveAndFlush(conditionByDate);
        Long promotionId = promotion.getId();
        // Get all the conditionByDateList where promotion equals to promotionId
        defaultConditionByDateShouldBeFound("promotionId.equals=" + promotionId);

        // Get all the conditionByDateList where promotion equals to (promotionId + 1)
        defaultConditionByDateShouldNotBeFound("promotionId.equals=" + (promotionId + 1));
    }

    private void defaultConditionByDateFiltering(String shouldBeFound, String shouldNotBeFound) throws Exception {
        defaultConditionByDateShouldBeFound(shouldBeFound);
        defaultConditionByDateShouldNotBeFound(shouldNotBeFound);
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultConditionByDateShouldBeFound(String filter) throws Exception {
        restConditionByDateMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(conditionByDate.getId().intValue())))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].isDeleted").value(hasItem(DEFAULT_IS_DELETED)))
            .andExpect(jsonPath("$.[*].deletedAt").value(hasItem(DEFAULT_DELETED_AT.toString())))
            .andExpect(jsonPath("$.[*].deletedBy").value(hasItem(DEFAULT_DELETED_BY.toString())));

        // Check, that the count call also returns 1
        restConditionByDateMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("1"));
    }

    /**
     * Executes the search, and checks that the default entity is not returned.
     */
    private void defaultConditionByDateShouldNotBeFound(String filter) throws Exception {
        restConditionByDateMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());

        // Check, that the count call also returns 0
        restConditionByDateMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("0"));
    }

    @Test
    @Transactional
    void getNonExistingConditionByDate() throws Exception {
        // Get the conditionByDate
        restConditionByDateMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingConditionByDate() throws Exception {
        // Initialize the database
        insertedConditionByDate = conditionByDateRepository.saveAndFlush(conditionByDate);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the conditionByDate
        ConditionByDate updatedConditionByDate = conditionByDateRepository.findById(conditionByDate.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedConditionByDate are not directly saved in db
        em.detach(updatedConditionByDate);
        updatedConditionByDate
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);
        ConditionByDateDTO conditionByDateDTO = conditionByDateMapper.toDto(updatedConditionByDate);

        restConditionByDateMockMvc
            .perform(
                put(ENTITY_API_URL_ID, conditionByDateDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(conditionByDateDTO))
            )
            .andExpect(status().isOk());

        // Validate the ConditionByDate in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedConditionByDateToMatchAllProperties(updatedConditionByDate);
    }

    @Test
    @Transactional
    void putNonExistingConditionByDate() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        conditionByDate.setId(longCount.incrementAndGet());

        // Create the ConditionByDate
        ConditionByDateDTO conditionByDateDTO = conditionByDateMapper.toDto(conditionByDate);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restConditionByDateMockMvc
            .perform(
                put(ENTITY_API_URL_ID, conditionByDateDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(conditionByDateDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the ConditionByDate in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchConditionByDate() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        conditionByDate.setId(longCount.incrementAndGet());

        // Create the ConditionByDate
        ConditionByDateDTO conditionByDateDTO = conditionByDateMapper.toDto(conditionByDate);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restConditionByDateMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(conditionByDateDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the ConditionByDate in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamConditionByDate() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        conditionByDate.setId(longCount.incrementAndGet());

        // Create the ConditionByDate
        ConditionByDateDTO conditionByDateDTO = conditionByDateMapper.toDto(conditionByDate);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restConditionByDateMockMvc
            .perform(
                put(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(conditionByDateDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the ConditionByDate in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateConditionByDateWithPatch() throws Exception {
        // Initialize the database
        insertedConditionByDate = conditionByDateRepository.saveAndFlush(conditionByDate);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the conditionByDate using partial update
        ConditionByDate partialUpdatedConditionByDate = new ConditionByDate();
        partialUpdatedConditionByDate.setId(conditionByDate.getId());

        partialUpdatedConditionByDate.isDeleted(UPDATED_IS_DELETED).deletedAt(UPDATED_DELETED_AT).deletedBy(UPDATED_DELETED_BY);

        restConditionByDateMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedConditionByDate.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedConditionByDate))
            )
            .andExpect(status().isOk());

        // Validate the ConditionByDate in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertConditionByDateUpdatableFieldsEquals(
            createUpdateProxyForBean(partialUpdatedConditionByDate, conditionByDate),
            getPersistedConditionByDate(conditionByDate)
        );
    }

    @Test
    @Transactional
    void fullUpdateConditionByDateWithPatch() throws Exception {
        // Initialize the database
        insertedConditionByDate = conditionByDateRepository.saveAndFlush(conditionByDate);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the conditionByDate using partial update
        ConditionByDate partialUpdatedConditionByDate = new ConditionByDate();
        partialUpdatedConditionByDate.setId(conditionByDate.getId());

        partialUpdatedConditionByDate
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);

        restConditionByDateMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedConditionByDate.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedConditionByDate))
            )
            .andExpect(status().isOk());

        // Validate the ConditionByDate in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertConditionByDateUpdatableFieldsEquals(
            partialUpdatedConditionByDate,
            getPersistedConditionByDate(partialUpdatedConditionByDate)
        );
    }

    @Test
    @Transactional
    void patchNonExistingConditionByDate() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        conditionByDate.setId(longCount.incrementAndGet());

        // Create the ConditionByDate
        ConditionByDateDTO conditionByDateDTO = conditionByDateMapper.toDto(conditionByDate);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restConditionByDateMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, conditionByDateDTO.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(conditionByDateDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the ConditionByDate in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchConditionByDate() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        conditionByDate.setId(longCount.incrementAndGet());

        // Create the ConditionByDate
        ConditionByDateDTO conditionByDateDTO = conditionByDateMapper.toDto(conditionByDate);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restConditionByDateMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(conditionByDateDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the ConditionByDate in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamConditionByDate() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        conditionByDate.setId(longCount.incrementAndGet());

        // Create the ConditionByDate
        ConditionByDateDTO conditionByDateDTO = conditionByDateMapper.toDto(conditionByDate);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restConditionByDateMockMvc
            .perform(
                patch(ENTITY_API_URL)
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(conditionByDateDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the ConditionByDate in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteConditionByDate() throws Exception {
        // Initialize the database
        insertedConditionByDate = conditionByDateRepository.saveAndFlush(conditionByDate);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the conditionByDate
        restConditionByDateMockMvc
            .perform(delete(ENTITY_API_URL_ID, conditionByDate.getId()).with(csrf()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return conditionByDateRepository.count();
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

    protected ConditionByDate getPersistedConditionByDate(ConditionByDate conditionByDate) {
        return conditionByDateRepository.findById(conditionByDate.getId()).orElseThrow();
    }

    protected void assertPersistedConditionByDateToMatchAllProperties(ConditionByDate expectedConditionByDate) {
        assertConditionByDateAllPropertiesEquals(expectedConditionByDate, getPersistedConditionByDate(expectedConditionByDate));
    }

    protected void assertPersistedConditionByDateToMatchUpdatableProperties(ConditionByDate expectedConditionByDate) {
        assertConditionByDateAllUpdatablePropertiesEquals(expectedConditionByDate, getPersistedConditionByDate(expectedConditionByDate));
    }
}
