package com.ridehub.promotion.web.rest;

import static com.ridehub.promotion.domain.ConditionDateItemAsserts.*;
import static com.ridehub.promotion.web.rest.TestUtil.createUpdateProxyForBean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ridehub.promotion.IntegrationTest;
import com.ridehub.promotion.domain.ConditionByDate;
import com.ridehub.promotion.domain.ConditionDateItem;
import com.ridehub.promotion.repository.ConditionDateItemRepository;
import com.ridehub.promotion.service.dto.ConditionDateItemDTO;
import com.ridehub.promotion.service.mapper.ConditionDateItemMapper;
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
 * Integration tests for the {@link ConditionDateItemResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class ConditionDateItemResourceIT {

    private static final LocalDate DEFAULT_SPECIFIC_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_SPECIFIC_DATE = LocalDate.now(ZoneId.systemDefault());
    private static final LocalDate SMALLER_SPECIFIC_DATE = LocalDate.ofEpochDay(-1L);

    private static final Integer DEFAULT_WEEKDAY = 1;
    private static final Integer UPDATED_WEEKDAY = 2;
    private static final Integer SMALLER_WEEKDAY = 1 - 1;

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

    private static final String ENTITY_API_URL = "/api/condition-date-items";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private ConditionDateItemRepository conditionDateItemRepository;

    @Autowired
    private ConditionDateItemMapper conditionDateItemMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restConditionDateItemMockMvc;

    private ConditionDateItem conditionDateItem;

    private ConditionDateItem insertedConditionDateItem;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ConditionDateItem createEntity(EntityManager em) {
        ConditionDateItem conditionDateItem = new ConditionDateItem()
            .specificDate(DEFAULT_SPECIFIC_DATE)
            .weekday(DEFAULT_WEEKDAY)
            .createdAt(DEFAULT_CREATED_AT)
            .updatedAt(DEFAULT_UPDATED_AT)
            .isDeleted(DEFAULT_IS_DELETED)
            .deletedAt(DEFAULT_DELETED_AT)
            .deletedBy(DEFAULT_DELETED_BY);
        // Add required entity
        ConditionByDate conditionByDate;
        if (TestUtil.findAll(em, ConditionByDate.class).isEmpty()) {
            conditionByDate = ConditionByDateResourceIT.createEntity(em);
            em.persist(conditionByDate);
            em.flush();
        } else {
            conditionByDate = TestUtil.findAll(em, ConditionByDate.class).get(0);
        }
        conditionDateItem.setCondition(conditionByDate);
        return conditionDateItem;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ConditionDateItem createUpdatedEntity(EntityManager em) {
        ConditionDateItem updatedConditionDateItem = new ConditionDateItem()
            .specificDate(UPDATED_SPECIFIC_DATE)
            .weekday(UPDATED_WEEKDAY)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);
        // Add required entity
        ConditionByDate conditionByDate;
        if (TestUtil.findAll(em, ConditionByDate.class).isEmpty()) {
            conditionByDate = ConditionByDateResourceIT.createUpdatedEntity(em);
            em.persist(conditionByDate);
            em.flush();
        } else {
            conditionByDate = TestUtil.findAll(em, ConditionByDate.class).get(0);
        }
        updatedConditionDateItem.setCondition(conditionByDate);
        return updatedConditionDateItem;
    }

    @BeforeEach
    void initTest() {
        conditionDateItem = createEntity(em);
    }

    @AfterEach
    void cleanup() {
        if (insertedConditionDateItem != null) {
            conditionDateItemRepository.delete(insertedConditionDateItem);
            insertedConditionDateItem = null;
        }
    }

    @Test
    @Transactional
    void createConditionDateItem() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the ConditionDateItem
        ConditionDateItemDTO conditionDateItemDTO = conditionDateItemMapper.toDto(conditionDateItem);
        var returnedConditionDateItemDTO = om.readValue(
            restConditionDateItemMockMvc
                .perform(
                    post(ENTITY_API_URL)
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsBytes(conditionDateItemDTO))
                )
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            ConditionDateItemDTO.class
        );

        // Validate the ConditionDateItem in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        var returnedConditionDateItem = conditionDateItemMapper.toEntity(returnedConditionDateItemDTO);
        assertConditionDateItemUpdatableFieldsEquals(returnedConditionDateItem, getPersistedConditionDateItem(returnedConditionDateItem));

        insertedConditionDateItem = returnedConditionDateItem;
    }

    @Test
    @Transactional
    void createConditionDateItemWithExistingId() throws Exception {
        // Create the ConditionDateItem with an existing ID
        conditionDateItem.setId(1L);
        ConditionDateItemDTO conditionDateItemDTO = conditionDateItemMapper.toDto(conditionDateItem);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restConditionDateItemMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(conditionDateItemDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the ConditionDateItem in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkCreatedAtIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        conditionDateItem.setCreatedAt(null);

        // Create the ConditionDateItem, which fails.
        ConditionDateItemDTO conditionDateItemDTO = conditionDateItemMapper.toDto(conditionDateItem);

        restConditionDateItemMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(conditionDateItemDTO))
            )
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllConditionDateItems() throws Exception {
        // Initialize the database
        insertedConditionDateItem = conditionDateItemRepository.saveAndFlush(conditionDateItem);

        // Get all the conditionDateItemList
        restConditionDateItemMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(conditionDateItem.getId().intValue())))
            .andExpect(jsonPath("$.[*].specificDate").value(hasItem(DEFAULT_SPECIFIC_DATE.toString())))
            .andExpect(jsonPath("$.[*].weekday").value(hasItem(DEFAULT_WEEKDAY)))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].isDeleted").value(hasItem(DEFAULT_IS_DELETED)))
            .andExpect(jsonPath("$.[*].deletedAt").value(hasItem(DEFAULT_DELETED_AT.toString())))
            .andExpect(jsonPath("$.[*].deletedBy").value(hasItem(DEFAULT_DELETED_BY.toString())));
    }

    @Test
    @Transactional
    void getConditionDateItem() throws Exception {
        // Initialize the database
        insertedConditionDateItem = conditionDateItemRepository.saveAndFlush(conditionDateItem);

        // Get the conditionDateItem
        restConditionDateItemMockMvc
            .perform(get(ENTITY_API_URL_ID, conditionDateItem.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(conditionDateItem.getId().intValue()))
            .andExpect(jsonPath("$.specificDate").value(DEFAULT_SPECIFIC_DATE.toString()))
            .andExpect(jsonPath("$.weekday").value(DEFAULT_WEEKDAY))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.updatedAt").value(DEFAULT_UPDATED_AT.toString()))
            .andExpect(jsonPath("$.isDeleted").value(DEFAULT_IS_DELETED))
            .andExpect(jsonPath("$.deletedAt").value(DEFAULT_DELETED_AT.toString()))
            .andExpect(jsonPath("$.deletedBy").value(DEFAULT_DELETED_BY.toString()));
    }

    @Test
    @Transactional
    void getConditionDateItemsByIdFiltering() throws Exception {
        // Initialize the database
        insertedConditionDateItem = conditionDateItemRepository.saveAndFlush(conditionDateItem);

        Long id = conditionDateItem.getId();

        defaultConditionDateItemFiltering("id.equals=" + id, "id.notEquals=" + id);

        defaultConditionDateItemFiltering("id.greaterThanOrEqual=" + id, "id.greaterThan=" + id);

        defaultConditionDateItemFiltering("id.lessThanOrEqual=" + id, "id.lessThan=" + id);
    }

    @Test
    @Transactional
    void getAllConditionDateItemsBySpecificDateIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedConditionDateItem = conditionDateItemRepository.saveAndFlush(conditionDateItem);

        // Get all the conditionDateItemList where specificDate equals to
        defaultConditionDateItemFiltering("specificDate.equals=" + DEFAULT_SPECIFIC_DATE, "specificDate.equals=" + UPDATED_SPECIFIC_DATE);
    }

    @Test
    @Transactional
    void getAllConditionDateItemsBySpecificDateIsInShouldWork() throws Exception {
        // Initialize the database
        insertedConditionDateItem = conditionDateItemRepository.saveAndFlush(conditionDateItem);

        // Get all the conditionDateItemList where specificDate in
        defaultConditionDateItemFiltering(
            "specificDate.in=" + DEFAULT_SPECIFIC_DATE + "," + UPDATED_SPECIFIC_DATE,
            "specificDate.in=" + UPDATED_SPECIFIC_DATE
        );
    }

    @Test
    @Transactional
    void getAllConditionDateItemsBySpecificDateIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedConditionDateItem = conditionDateItemRepository.saveAndFlush(conditionDateItem);

        // Get all the conditionDateItemList where specificDate is not null
        defaultConditionDateItemFiltering("specificDate.specified=true", "specificDate.specified=false");
    }

    @Test
    @Transactional
    void getAllConditionDateItemsBySpecificDateIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedConditionDateItem = conditionDateItemRepository.saveAndFlush(conditionDateItem);

        // Get all the conditionDateItemList where specificDate is greater than or equal to
        defaultConditionDateItemFiltering(
            "specificDate.greaterThanOrEqual=" + DEFAULT_SPECIFIC_DATE,
            "specificDate.greaterThanOrEqual=" + UPDATED_SPECIFIC_DATE
        );
    }

    @Test
    @Transactional
    void getAllConditionDateItemsBySpecificDateIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedConditionDateItem = conditionDateItemRepository.saveAndFlush(conditionDateItem);

        // Get all the conditionDateItemList where specificDate is less than or equal to
        defaultConditionDateItemFiltering(
            "specificDate.lessThanOrEqual=" + DEFAULT_SPECIFIC_DATE,
            "specificDate.lessThanOrEqual=" + SMALLER_SPECIFIC_DATE
        );
    }

    @Test
    @Transactional
    void getAllConditionDateItemsBySpecificDateIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedConditionDateItem = conditionDateItemRepository.saveAndFlush(conditionDateItem);

        // Get all the conditionDateItemList where specificDate is less than
        defaultConditionDateItemFiltering(
            "specificDate.lessThan=" + UPDATED_SPECIFIC_DATE,
            "specificDate.lessThan=" + DEFAULT_SPECIFIC_DATE
        );
    }

    @Test
    @Transactional
    void getAllConditionDateItemsBySpecificDateIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedConditionDateItem = conditionDateItemRepository.saveAndFlush(conditionDateItem);

        // Get all the conditionDateItemList where specificDate is greater than
        defaultConditionDateItemFiltering(
            "specificDate.greaterThan=" + SMALLER_SPECIFIC_DATE,
            "specificDate.greaterThan=" + DEFAULT_SPECIFIC_DATE
        );
    }

    @Test
    @Transactional
    void getAllConditionDateItemsByWeekdayIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedConditionDateItem = conditionDateItemRepository.saveAndFlush(conditionDateItem);

        // Get all the conditionDateItemList where weekday equals to
        defaultConditionDateItemFiltering("weekday.equals=" + DEFAULT_WEEKDAY, "weekday.equals=" + UPDATED_WEEKDAY);
    }

    @Test
    @Transactional
    void getAllConditionDateItemsByWeekdayIsInShouldWork() throws Exception {
        // Initialize the database
        insertedConditionDateItem = conditionDateItemRepository.saveAndFlush(conditionDateItem);

        // Get all the conditionDateItemList where weekday in
        defaultConditionDateItemFiltering("weekday.in=" + DEFAULT_WEEKDAY + "," + UPDATED_WEEKDAY, "weekday.in=" + UPDATED_WEEKDAY);
    }

    @Test
    @Transactional
    void getAllConditionDateItemsByWeekdayIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedConditionDateItem = conditionDateItemRepository.saveAndFlush(conditionDateItem);

        // Get all the conditionDateItemList where weekday is not null
        defaultConditionDateItemFiltering("weekday.specified=true", "weekday.specified=false");
    }

    @Test
    @Transactional
    void getAllConditionDateItemsByWeekdayIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedConditionDateItem = conditionDateItemRepository.saveAndFlush(conditionDateItem);

        // Get all the conditionDateItemList where weekday is greater than or equal to
        defaultConditionDateItemFiltering("weekday.greaterThanOrEqual=" + DEFAULT_WEEKDAY, "weekday.greaterThanOrEqual=" + UPDATED_WEEKDAY);
    }

    @Test
    @Transactional
    void getAllConditionDateItemsByWeekdayIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedConditionDateItem = conditionDateItemRepository.saveAndFlush(conditionDateItem);

        // Get all the conditionDateItemList where weekday is less than or equal to
        defaultConditionDateItemFiltering("weekday.lessThanOrEqual=" + DEFAULT_WEEKDAY, "weekday.lessThanOrEqual=" + SMALLER_WEEKDAY);
    }

    @Test
    @Transactional
    void getAllConditionDateItemsByWeekdayIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedConditionDateItem = conditionDateItemRepository.saveAndFlush(conditionDateItem);

        // Get all the conditionDateItemList where weekday is less than
        defaultConditionDateItemFiltering("weekday.lessThan=" + UPDATED_WEEKDAY, "weekday.lessThan=" + DEFAULT_WEEKDAY);
    }

    @Test
    @Transactional
    void getAllConditionDateItemsByWeekdayIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedConditionDateItem = conditionDateItemRepository.saveAndFlush(conditionDateItem);

        // Get all the conditionDateItemList where weekday is greater than
        defaultConditionDateItemFiltering("weekday.greaterThan=" + SMALLER_WEEKDAY, "weekday.greaterThan=" + DEFAULT_WEEKDAY);
    }

    @Test
    @Transactional
    void getAllConditionDateItemsByCreatedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedConditionDateItem = conditionDateItemRepository.saveAndFlush(conditionDateItem);

        // Get all the conditionDateItemList where createdAt equals to
        defaultConditionDateItemFiltering("createdAt.equals=" + DEFAULT_CREATED_AT, "createdAt.equals=" + UPDATED_CREATED_AT);
    }

    @Test
    @Transactional
    void getAllConditionDateItemsByCreatedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedConditionDateItem = conditionDateItemRepository.saveAndFlush(conditionDateItem);

        // Get all the conditionDateItemList where createdAt in
        defaultConditionDateItemFiltering(
            "createdAt.in=" + DEFAULT_CREATED_AT + "," + UPDATED_CREATED_AT,
            "createdAt.in=" + UPDATED_CREATED_AT
        );
    }

    @Test
    @Transactional
    void getAllConditionDateItemsByCreatedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedConditionDateItem = conditionDateItemRepository.saveAndFlush(conditionDateItem);

        // Get all the conditionDateItemList where createdAt is not null
        defaultConditionDateItemFiltering("createdAt.specified=true", "createdAt.specified=false");
    }

    @Test
    @Transactional
    void getAllConditionDateItemsByUpdatedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedConditionDateItem = conditionDateItemRepository.saveAndFlush(conditionDateItem);

        // Get all the conditionDateItemList where updatedAt equals to
        defaultConditionDateItemFiltering("updatedAt.equals=" + DEFAULT_UPDATED_AT, "updatedAt.equals=" + UPDATED_UPDATED_AT);
    }

    @Test
    @Transactional
    void getAllConditionDateItemsByUpdatedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedConditionDateItem = conditionDateItemRepository.saveAndFlush(conditionDateItem);

        // Get all the conditionDateItemList where updatedAt in
        defaultConditionDateItemFiltering(
            "updatedAt.in=" + DEFAULT_UPDATED_AT + "," + UPDATED_UPDATED_AT,
            "updatedAt.in=" + UPDATED_UPDATED_AT
        );
    }

    @Test
    @Transactional
    void getAllConditionDateItemsByUpdatedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedConditionDateItem = conditionDateItemRepository.saveAndFlush(conditionDateItem);

        // Get all the conditionDateItemList where updatedAt is not null
        defaultConditionDateItemFiltering("updatedAt.specified=true", "updatedAt.specified=false");
    }

    @Test
    @Transactional
    void getAllConditionDateItemsByIsDeletedIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedConditionDateItem = conditionDateItemRepository.saveAndFlush(conditionDateItem);

        // Get all the conditionDateItemList where isDeleted equals to
        defaultConditionDateItemFiltering("isDeleted.equals=" + DEFAULT_IS_DELETED, "isDeleted.equals=" + UPDATED_IS_DELETED);
    }

    @Test
    @Transactional
    void getAllConditionDateItemsByIsDeletedIsInShouldWork() throws Exception {
        // Initialize the database
        insertedConditionDateItem = conditionDateItemRepository.saveAndFlush(conditionDateItem);

        // Get all the conditionDateItemList where isDeleted in
        defaultConditionDateItemFiltering(
            "isDeleted.in=" + DEFAULT_IS_DELETED + "," + UPDATED_IS_DELETED,
            "isDeleted.in=" + UPDATED_IS_DELETED
        );
    }

    @Test
    @Transactional
    void getAllConditionDateItemsByIsDeletedIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedConditionDateItem = conditionDateItemRepository.saveAndFlush(conditionDateItem);

        // Get all the conditionDateItemList where isDeleted is not null
        defaultConditionDateItemFiltering("isDeleted.specified=true", "isDeleted.specified=false");
    }

    @Test
    @Transactional
    void getAllConditionDateItemsByDeletedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedConditionDateItem = conditionDateItemRepository.saveAndFlush(conditionDateItem);

        // Get all the conditionDateItemList where deletedAt equals to
        defaultConditionDateItemFiltering("deletedAt.equals=" + DEFAULT_DELETED_AT, "deletedAt.equals=" + UPDATED_DELETED_AT);
    }

    @Test
    @Transactional
    void getAllConditionDateItemsByDeletedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedConditionDateItem = conditionDateItemRepository.saveAndFlush(conditionDateItem);

        // Get all the conditionDateItemList where deletedAt in
        defaultConditionDateItemFiltering(
            "deletedAt.in=" + DEFAULT_DELETED_AT + "," + UPDATED_DELETED_AT,
            "deletedAt.in=" + UPDATED_DELETED_AT
        );
    }

    @Test
    @Transactional
    void getAllConditionDateItemsByDeletedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedConditionDateItem = conditionDateItemRepository.saveAndFlush(conditionDateItem);

        // Get all the conditionDateItemList where deletedAt is not null
        defaultConditionDateItemFiltering("deletedAt.specified=true", "deletedAt.specified=false");
    }

    @Test
    @Transactional
    void getAllConditionDateItemsByDeletedByIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedConditionDateItem = conditionDateItemRepository.saveAndFlush(conditionDateItem);

        // Get all the conditionDateItemList where deletedBy equals to
        defaultConditionDateItemFiltering("deletedBy.equals=" + DEFAULT_DELETED_BY, "deletedBy.equals=" + UPDATED_DELETED_BY);
    }

    @Test
    @Transactional
    void getAllConditionDateItemsByDeletedByIsInShouldWork() throws Exception {
        // Initialize the database
        insertedConditionDateItem = conditionDateItemRepository.saveAndFlush(conditionDateItem);

        // Get all the conditionDateItemList where deletedBy in
        defaultConditionDateItemFiltering(
            "deletedBy.in=" + DEFAULT_DELETED_BY + "," + UPDATED_DELETED_BY,
            "deletedBy.in=" + UPDATED_DELETED_BY
        );
    }

    @Test
    @Transactional
    void getAllConditionDateItemsByDeletedByIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedConditionDateItem = conditionDateItemRepository.saveAndFlush(conditionDateItem);

        // Get all the conditionDateItemList where deletedBy is not null
        defaultConditionDateItemFiltering("deletedBy.specified=true", "deletedBy.specified=false");
    }

    @Test
    @Transactional
    void getAllConditionDateItemsByConditionIsEqualToSomething() throws Exception {
        ConditionByDate condition;
        if (TestUtil.findAll(em, ConditionByDate.class).isEmpty()) {
            conditionDateItemRepository.saveAndFlush(conditionDateItem);
            condition = ConditionByDateResourceIT.createEntity(em);
        } else {
            condition = TestUtil.findAll(em, ConditionByDate.class).get(0);
        }
        em.persist(condition);
        em.flush();
        conditionDateItem.setCondition(condition);
        conditionDateItemRepository.saveAndFlush(conditionDateItem);
        Long conditionId = condition.getId();
        // Get all the conditionDateItemList where condition equals to conditionId
        defaultConditionDateItemShouldBeFound("conditionId.equals=" + conditionId);

        // Get all the conditionDateItemList where condition equals to (conditionId + 1)
        defaultConditionDateItemShouldNotBeFound("conditionId.equals=" + (conditionId + 1));
    }

    private void defaultConditionDateItemFiltering(String shouldBeFound, String shouldNotBeFound) throws Exception {
        defaultConditionDateItemShouldBeFound(shouldBeFound);
        defaultConditionDateItemShouldNotBeFound(shouldNotBeFound);
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultConditionDateItemShouldBeFound(String filter) throws Exception {
        restConditionDateItemMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(conditionDateItem.getId().intValue())))
            .andExpect(jsonPath("$.[*].specificDate").value(hasItem(DEFAULT_SPECIFIC_DATE.toString())))
            .andExpect(jsonPath("$.[*].weekday").value(hasItem(DEFAULT_WEEKDAY)))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].isDeleted").value(hasItem(DEFAULT_IS_DELETED)))
            .andExpect(jsonPath("$.[*].deletedAt").value(hasItem(DEFAULT_DELETED_AT.toString())))
            .andExpect(jsonPath("$.[*].deletedBy").value(hasItem(DEFAULT_DELETED_BY.toString())));

        // Check, that the count call also returns 1
        restConditionDateItemMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("1"));
    }

    /**
     * Executes the search, and checks that the default entity is not returned.
     */
    private void defaultConditionDateItemShouldNotBeFound(String filter) throws Exception {
        restConditionDateItemMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());

        // Check, that the count call also returns 0
        restConditionDateItemMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("0"));
    }

    @Test
    @Transactional
    void getNonExistingConditionDateItem() throws Exception {
        // Get the conditionDateItem
        restConditionDateItemMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingConditionDateItem() throws Exception {
        // Initialize the database
        insertedConditionDateItem = conditionDateItemRepository.saveAndFlush(conditionDateItem);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the conditionDateItem
        ConditionDateItem updatedConditionDateItem = conditionDateItemRepository.findById(conditionDateItem.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedConditionDateItem are not directly saved in db
        em.detach(updatedConditionDateItem);
        updatedConditionDateItem
            .specificDate(UPDATED_SPECIFIC_DATE)
            .weekday(UPDATED_WEEKDAY)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);
        ConditionDateItemDTO conditionDateItemDTO = conditionDateItemMapper.toDto(updatedConditionDateItem);

        restConditionDateItemMockMvc
            .perform(
                put(ENTITY_API_URL_ID, conditionDateItemDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(conditionDateItemDTO))
            )
            .andExpect(status().isOk());

        // Validate the ConditionDateItem in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedConditionDateItemToMatchAllProperties(updatedConditionDateItem);
    }

    @Test
    @Transactional
    void putNonExistingConditionDateItem() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        conditionDateItem.setId(longCount.incrementAndGet());

        // Create the ConditionDateItem
        ConditionDateItemDTO conditionDateItemDTO = conditionDateItemMapper.toDto(conditionDateItem);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restConditionDateItemMockMvc
            .perform(
                put(ENTITY_API_URL_ID, conditionDateItemDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(conditionDateItemDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the ConditionDateItem in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchConditionDateItem() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        conditionDateItem.setId(longCount.incrementAndGet());

        // Create the ConditionDateItem
        ConditionDateItemDTO conditionDateItemDTO = conditionDateItemMapper.toDto(conditionDateItem);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restConditionDateItemMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(conditionDateItemDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the ConditionDateItem in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamConditionDateItem() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        conditionDateItem.setId(longCount.incrementAndGet());

        // Create the ConditionDateItem
        ConditionDateItemDTO conditionDateItemDTO = conditionDateItemMapper.toDto(conditionDateItem);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restConditionDateItemMockMvc
            .perform(
                put(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(conditionDateItemDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the ConditionDateItem in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateConditionDateItemWithPatch() throws Exception {
        // Initialize the database
        insertedConditionDateItem = conditionDateItemRepository.saveAndFlush(conditionDateItem);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the conditionDateItem using partial update
        ConditionDateItem partialUpdatedConditionDateItem = new ConditionDateItem();
        partialUpdatedConditionDateItem.setId(conditionDateItem.getId());

        partialUpdatedConditionDateItem
            .specificDate(UPDATED_SPECIFIC_DATE)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT);

        restConditionDateItemMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedConditionDateItem.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedConditionDateItem))
            )
            .andExpect(status().isOk());

        // Validate the ConditionDateItem in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertConditionDateItemUpdatableFieldsEquals(
            createUpdateProxyForBean(partialUpdatedConditionDateItem, conditionDateItem),
            getPersistedConditionDateItem(conditionDateItem)
        );
    }

    @Test
    @Transactional
    void fullUpdateConditionDateItemWithPatch() throws Exception {
        // Initialize the database
        insertedConditionDateItem = conditionDateItemRepository.saveAndFlush(conditionDateItem);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the conditionDateItem using partial update
        ConditionDateItem partialUpdatedConditionDateItem = new ConditionDateItem();
        partialUpdatedConditionDateItem.setId(conditionDateItem.getId());

        partialUpdatedConditionDateItem
            .specificDate(UPDATED_SPECIFIC_DATE)
            .weekday(UPDATED_WEEKDAY)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);

        restConditionDateItemMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedConditionDateItem.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedConditionDateItem))
            )
            .andExpect(status().isOk());

        // Validate the ConditionDateItem in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertConditionDateItemUpdatableFieldsEquals(
            partialUpdatedConditionDateItem,
            getPersistedConditionDateItem(partialUpdatedConditionDateItem)
        );
    }

    @Test
    @Transactional
    void patchNonExistingConditionDateItem() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        conditionDateItem.setId(longCount.incrementAndGet());

        // Create the ConditionDateItem
        ConditionDateItemDTO conditionDateItemDTO = conditionDateItemMapper.toDto(conditionDateItem);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restConditionDateItemMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, conditionDateItemDTO.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(conditionDateItemDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the ConditionDateItem in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchConditionDateItem() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        conditionDateItem.setId(longCount.incrementAndGet());

        // Create the ConditionDateItem
        ConditionDateItemDTO conditionDateItemDTO = conditionDateItemMapper.toDto(conditionDateItem);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restConditionDateItemMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(conditionDateItemDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the ConditionDateItem in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamConditionDateItem() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        conditionDateItem.setId(longCount.incrementAndGet());

        // Create the ConditionDateItem
        ConditionDateItemDTO conditionDateItemDTO = conditionDateItemMapper.toDto(conditionDateItem);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restConditionDateItemMockMvc
            .perform(
                patch(ENTITY_API_URL)
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(conditionDateItemDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the ConditionDateItem in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteConditionDateItem() throws Exception {
        // Initialize the database
        insertedConditionDateItem = conditionDateItemRepository.saveAndFlush(conditionDateItem);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the conditionDateItem
        restConditionDateItemMockMvc
            .perform(delete(ENTITY_API_URL_ID, conditionDateItem.getId()).with(csrf()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return conditionDateItemRepository.count();
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

    protected ConditionDateItem getPersistedConditionDateItem(ConditionDateItem conditionDateItem) {
        return conditionDateItemRepository.findById(conditionDateItem.getId()).orElseThrow();
    }

    protected void assertPersistedConditionDateItemToMatchAllProperties(ConditionDateItem expectedConditionDateItem) {
        assertConditionDateItemAllPropertiesEquals(expectedConditionDateItem, getPersistedConditionDateItem(expectedConditionDateItem));
    }

    protected void assertPersistedConditionDateItemToMatchUpdatableProperties(ConditionDateItem expectedConditionDateItem) {
        assertConditionDateItemAllUpdatablePropertiesEquals(
            expectedConditionDateItem,
            getPersistedConditionDateItem(expectedConditionDateItem)
        );
    }
}
