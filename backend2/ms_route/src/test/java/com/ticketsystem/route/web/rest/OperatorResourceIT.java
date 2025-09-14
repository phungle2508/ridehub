package com.ticketsystem.route.web.rest;

import static com.ticketsystem.route.domain.OperatorAsserts.*;
import static com.ticketsystem.route.web.rest.TestUtil.createUpdateProxyForBean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketsystem.route.IntegrationTest;
import com.ticketsystem.route.domain.Operator;
import com.ticketsystem.route.repository.OperatorRepository;
import com.ticketsystem.route.service.dto.OperatorDTO;
import com.ticketsystem.route.service.mapper.OperatorMapper;
import jakarta.persistence.EntityManager;
import java.util.Random;
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
 * Integration tests for the {@link OperatorResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class OperatorResourceIT {

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_BUSINESS_LICENSE = "AAAAAAAAAA";
    private static final String UPDATED_BUSINESS_LICENSE = "BBBBBBBBBB";

    private static final String DEFAULT_LOGO_URL = "AAAAAAAAAA";
    private static final String UPDATED_LOGO_URL = "BBBBBBBBBB";

    private static final Double DEFAULT_RATING = 1D;
    private static final Double UPDATED_RATING = 2D;
    private static final Double SMALLER_RATING = 1D - 1D;

    private static final String DEFAULT_CONTACT_PHONE = "AAAAAAAAAA";
    private static final String UPDATED_CONTACT_PHONE = "BBBBBBBBBB";

    private static final String DEFAULT_CONTACT_EMAIL = "AAAAAAAAAA";
    private static final String UPDATED_CONTACT_EMAIL = "BBBBBBBBBB";

    private static final Boolean DEFAULT_IS_ACTIVE = false;
    private static final Boolean UPDATED_IS_ACTIVE = true;

    private static final String ENTITY_API_URL = "/api/operators";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private OperatorRepository operatorRepository;

    @Autowired
    private OperatorMapper operatorMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restOperatorMockMvc;

    private Operator operator;

    private Operator insertedOperator;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Operator createEntity() {
        return new Operator()
            .name(DEFAULT_NAME)
            .businessLicense(DEFAULT_BUSINESS_LICENSE)
            .logoUrl(DEFAULT_LOGO_URL)
            .rating(DEFAULT_RATING)
            .contactPhone(DEFAULT_CONTACT_PHONE)
            .contactEmail(DEFAULT_CONTACT_EMAIL)
            .isActive(DEFAULT_IS_ACTIVE);
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Operator createUpdatedEntity() {
        return new Operator()
            .name(UPDATED_NAME)
            .businessLicense(UPDATED_BUSINESS_LICENSE)
            .logoUrl(UPDATED_LOGO_URL)
            .rating(UPDATED_RATING)
            .contactPhone(UPDATED_CONTACT_PHONE)
            .contactEmail(UPDATED_CONTACT_EMAIL)
            .isActive(UPDATED_IS_ACTIVE);
    }

    @BeforeEach
    void initTest() {
        operator = createEntity();
    }

    @AfterEach
    void cleanup() {
        if (insertedOperator != null) {
            operatorRepository.delete(insertedOperator);
            insertedOperator = null;
        }
    }

    @Test
    @Transactional
    void createOperator() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the Operator
        OperatorDTO operatorDTO = operatorMapper.toDto(operator);
        var returnedOperatorDTO = om.readValue(
            restOperatorMockMvc
                .perform(
                    post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(operatorDTO))
                )
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            OperatorDTO.class
        );

        // Validate the Operator in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        var returnedOperator = operatorMapper.toEntity(returnedOperatorDTO);
        assertOperatorUpdatableFieldsEquals(returnedOperator, getPersistedOperator(returnedOperator));

        insertedOperator = returnedOperator;
    }

    @Test
    @Transactional
    void createOperatorWithExistingId() throws Exception {
        // Create the Operator with an existing ID
        operator.setId(1L);
        OperatorDTO operatorDTO = operatorMapper.toDto(operator);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restOperatorMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(operatorDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Operator in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkNameIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        operator.setName(null);

        // Create the Operator, which fails.
        OperatorDTO operatorDTO = operatorMapper.toDto(operator);

        restOperatorMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(operatorDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkIsActiveIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        operator.setIsActive(null);

        // Create the Operator, which fails.
        OperatorDTO operatorDTO = operatorMapper.toDto(operator);

        restOperatorMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(operatorDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllOperators() throws Exception {
        // Initialize the database
        insertedOperator = operatorRepository.saveAndFlush(operator);

        // Get all the operatorList
        restOperatorMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(operator.getId().intValue())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
            .andExpect(jsonPath("$.[*].businessLicense").value(hasItem(DEFAULT_BUSINESS_LICENSE)))
            .andExpect(jsonPath("$.[*].logoUrl").value(hasItem(DEFAULT_LOGO_URL)))
            .andExpect(jsonPath("$.[*].rating").value(hasItem(DEFAULT_RATING)))
            .andExpect(jsonPath("$.[*].contactPhone").value(hasItem(DEFAULT_CONTACT_PHONE)))
            .andExpect(jsonPath("$.[*].contactEmail").value(hasItem(DEFAULT_CONTACT_EMAIL)))
            .andExpect(jsonPath("$.[*].isActive").value(hasItem(DEFAULT_IS_ACTIVE)));
    }

    @Test
    @Transactional
    void getOperator() throws Exception {
        // Initialize the database
        insertedOperator = operatorRepository.saveAndFlush(operator);

        // Get the operator
        restOperatorMockMvc
            .perform(get(ENTITY_API_URL_ID, operator.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(operator.getId().intValue()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME))
            .andExpect(jsonPath("$.businessLicense").value(DEFAULT_BUSINESS_LICENSE))
            .andExpect(jsonPath("$.logoUrl").value(DEFAULT_LOGO_URL))
            .andExpect(jsonPath("$.rating").value(DEFAULT_RATING))
            .andExpect(jsonPath("$.contactPhone").value(DEFAULT_CONTACT_PHONE))
            .andExpect(jsonPath("$.contactEmail").value(DEFAULT_CONTACT_EMAIL))
            .andExpect(jsonPath("$.isActive").value(DEFAULT_IS_ACTIVE));
    }

    @Test
    @Transactional
    void getOperatorsByIdFiltering() throws Exception {
        // Initialize the database
        insertedOperator = operatorRepository.saveAndFlush(operator);

        Long id = operator.getId();

        defaultOperatorFiltering("id.equals=" + id, "id.notEquals=" + id);

        defaultOperatorFiltering("id.greaterThanOrEqual=" + id, "id.greaterThan=" + id);

        defaultOperatorFiltering("id.lessThanOrEqual=" + id, "id.lessThan=" + id);
    }

    @Test
    @Transactional
    void getAllOperatorsByNameIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedOperator = operatorRepository.saveAndFlush(operator);

        // Get all the operatorList where name equals to
        defaultOperatorFiltering("name.equals=" + DEFAULT_NAME, "name.equals=" + UPDATED_NAME);
    }

    @Test
    @Transactional
    void getAllOperatorsByNameIsInShouldWork() throws Exception {
        // Initialize the database
        insertedOperator = operatorRepository.saveAndFlush(operator);

        // Get all the operatorList where name in
        defaultOperatorFiltering("name.in=" + DEFAULT_NAME + "," + UPDATED_NAME, "name.in=" + UPDATED_NAME);
    }

    @Test
    @Transactional
    void getAllOperatorsByNameIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedOperator = operatorRepository.saveAndFlush(operator);

        // Get all the operatorList where name is not null
        defaultOperatorFiltering("name.specified=true", "name.specified=false");
    }

    @Test
    @Transactional
    void getAllOperatorsByNameContainsSomething() throws Exception {
        // Initialize the database
        insertedOperator = operatorRepository.saveAndFlush(operator);

        // Get all the operatorList where name contains
        defaultOperatorFiltering("name.contains=" + DEFAULT_NAME, "name.contains=" + UPDATED_NAME);
    }

    @Test
    @Transactional
    void getAllOperatorsByNameNotContainsSomething() throws Exception {
        // Initialize the database
        insertedOperator = operatorRepository.saveAndFlush(operator);

        // Get all the operatorList where name does not contain
        defaultOperatorFiltering("name.doesNotContain=" + UPDATED_NAME, "name.doesNotContain=" + DEFAULT_NAME);
    }

    @Test
    @Transactional
    void getAllOperatorsByBusinessLicenseIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedOperator = operatorRepository.saveAndFlush(operator);

        // Get all the operatorList where businessLicense equals to
        defaultOperatorFiltering(
            "businessLicense.equals=" + DEFAULT_BUSINESS_LICENSE,
            "businessLicense.equals=" + UPDATED_BUSINESS_LICENSE
        );
    }

    @Test
    @Transactional
    void getAllOperatorsByBusinessLicenseIsInShouldWork() throws Exception {
        // Initialize the database
        insertedOperator = operatorRepository.saveAndFlush(operator);

        // Get all the operatorList where businessLicense in
        defaultOperatorFiltering(
            "businessLicense.in=" + DEFAULT_BUSINESS_LICENSE + "," + UPDATED_BUSINESS_LICENSE,
            "businessLicense.in=" + UPDATED_BUSINESS_LICENSE
        );
    }

    @Test
    @Transactional
    void getAllOperatorsByBusinessLicenseIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedOperator = operatorRepository.saveAndFlush(operator);

        // Get all the operatorList where businessLicense is not null
        defaultOperatorFiltering("businessLicense.specified=true", "businessLicense.specified=false");
    }

    @Test
    @Transactional
    void getAllOperatorsByBusinessLicenseContainsSomething() throws Exception {
        // Initialize the database
        insertedOperator = operatorRepository.saveAndFlush(operator);

        // Get all the operatorList where businessLicense contains
        defaultOperatorFiltering(
            "businessLicense.contains=" + DEFAULT_BUSINESS_LICENSE,
            "businessLicense.contains=" + UPDATED_BUSINESS_LICENSE
        );
    }

    @Test
    @Transactional
    void getAllOperatorsByBusinessLicenseNotContainsSomething() throws Exception {
        // Initialize the database
        insertedOperator = operatorRepository.saveAndFlush(operator);

        // Get all the operatorList where businessLicense does not contain
        defaultOperatorFiltering(
            "businessLicense.doesNotContain=" + UPDATED_BUSINESS_LICENSE,
            "businessLicense.doesNotContain=" + DEFAULT_BUSINESS_LICENSE
        );
    }

    @Test
    @Transactional
    void getAllOperatorsByLogoUrlIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedOperator = operatorRepository.saveAndFlush(operator);

        // Get all the operatorList where logoUrl equals to
        defaultOperatorFiltering("logoUrl.equals=" + DEFAULT_LOGO_URL, "logoUrl.equals=" + UPDATED_LOGO_URL);
    }

    @Test
    @Transactional
    void getAllOperatorsByLogoUrlIsInShouldWork() throws Exception {
        // Initialize the database
        insertedOperator = operatorRepository.saveAndFlush(operator);

        // Get all the operatorList where logoUrl in
        defaultOperatorFiltering("logoUrl.in=" + DEFAULT_LOGO_URL + "," + UPDATED_LOGO_URL, "logoUrl.in=" + UPDATED_LOGO_URL);
    }

    @Test
    @Transactional
    void getAllOperatorsByLogoUrlIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedOperator = operatorRepository.saveAndFlush(operator);

        // Get all the operatorList where logoUrl is not null
        defaultOperatorFiltering("logoUrl.specified=true", "logoUrl.specified=false");
    }

    @Test
    @Transactional
    void getAllOperatorsByLogoUrlContainsSomething() throws Exception {
        // Initialize the database
        insertedOperator = operatorRepository.saveAndFlush(operator);

        // Get all the operatorList where logoUrl contains
        defaultOperatorFiltering("logoUrl.contains=" + DEFAULT_LOGO_URL, "logoUrl.contains=" + UPDATED_LOGO_URL);
    }

    @Test
    @Transactional
    void getAllOperatorsByLogoUrlNotContainsSomething() throws Exception {
        // Initialize the database
        insertedOperator = operatorRepository.saveAndFlush(operator);

        // Get all the operatorList where logoUrl does not contain
        defaultOperatorFiltering("logoUrl.doesNotContain=" + UPDATED_LOGO_URL, "logoUrl.doesNotContain=" + DEFAULT_LOGO_URL);
    }

    @Test
    @Transactional
    void getAllOperatorsByRatingIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedOperator = operatorRepository.saveAndFlush(operator);

        // Get all the operatorList where rating equals to
        defaultOperatorFiltering("rating.equals=" + DEFAULT_RATING, "rating.equals=" + UPDATED_RATING);
    }

    @Test
    @Transactional
    void getAllOperatorsByRatingIsInShouldWork() throws Exception {
        // Initialize the database
        insertedOperator = operatorRepository.saveAndFlush(operator);

        // Get all the operatorList where rating in
        defaultOperatorFiltering("rating.in=" + DEFAULT_RATING + "," + UPDATED_RATING, "rating.in=" + UPDATED_RATING);
    }

    @Test
    @Transactional
    void getAllOperatorsByRatingIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedOperator = operatorRepository.saveAndFlush(operator);

        // Get all the operatorList where rating is not null
        defaultOperatorFiltering("rating.specified=true", "rating.specified=false");
    }

    @Test
    @Transactional
    void getAllOperatorsByRatingIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedOperator = operatorRepository.saveAndFlush(operator);

        // Get all the operatorList where rating is greater than or equal to
        defaultOperatorFiltering("rating.greaterThanOrEqual=" + DEFAULT_RATING, "rating.greaterThanOrEqual=" + UPDATED_RATING);
    }

    @Test
    @Transactional
    void getAllOperatorsByRatingIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedOperator = operatorRepository.saveAndFlush(operator);

        // Get all the operatorList where rating is less than or equal to
        defaultOperatorFiltering("rating.lessThanOrEqual=" + DEFAULT_RATING, "rating.lessThanOrEqual=" + SMALLER_RATING);
    }

    @Test
    @Transactional
    void getAllOperatorsByRatingIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedOperator = operatorRepository.saveAndFlush(operator);

        // Get all the operatorList where rating is less than
        defaultOperatorFiltering("rating.lessThan=" + UPDATED_RATING, "rating.lessThan=" + DEFAULT_RATING);
    }

    @Test
    @Transactional
    void getAllOperatorsByRatingIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedOperator = operatorRepository.saveAndFlush(operator);

        // Get all the operatorList where rating is greater than
        defaultOperatorFiltering("rating.greaterThan=" + SMALLER_RATING, "rating.greaterThan=" + DEFAULT_RATING);
    }

    @Test
    @Transactional
    void getAllOperatorsByContactPhoneIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedOperator = operatorRepository.saveAndFlush(operator);

        // Get all the operatorList where contactPhone equals to
        defaultOperatorFiltering("contactPhone.equals=" + DEFAULT_CONTACT_PHONE, "contactPhone.equals=" + UPDATED_CONTACT_PHONE);
    }

    @Test
    @Transactional
    void getAllOperatorsByContactPhoneIsInShouldWork() throws Exception {
        // Initialize the database
        insertedOperator = operatorRepository.saveAndFlush(operator);

        // Get all the operatorList where contactPhone in
        defaultOperatorFiltering(
            "contactPhone.in=" + DEFAULT_CONTACT_PHONE + "," + UPDATED_CONTACT_PHONE,
            "contactPhone.in=" + UPDATED_CONTACT_PHONE
        );
    }

    @Test
    @Transactional
    void getAllOperatorsByContactPhoneIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedOperator = operatorRepository.saveAndFlush(operator);

        // Get all the operatorList where contactPhone is not null
        defaultOperatorFiltering("contactPhone.specified=true", "contactPhone.specified=false");
    }

    @Test
    @Transactional
    void getAllOperatorsByContactPhoneContainsSomething() throws Exception {
        // Initialize the database
        insertedOperator = operatorRepository.saveAndFlush(operator);

        // Get all the operatorList where contactPhone contains
        defaultOperatorFiltering("contactPhone.contains=" + DEFAULT_CONTACT_PHONE, "contactPhone.contains=" + UPDATED_CONTACT_PHONE);
    }

    @Test
    @Transactional
    void getAllOperatorsByContactPhoneNotContainsSomething() throws Exception {
        // Initialize the database
        insertedOperator = operatorRepository.saveAndFlush(operator);

        // Get all the operatorList where contactPhone does not contain
        defaultOperatorFiltering(
            "contactPhone.doesNotContain=" + UPDATED_CONTACT_PHONE,
            "contactPhone.doesNotContain=" + DEFAULT_CONTACT_PHONE
        );
    }

    @Test
    @Transactional
    void getAllOperatorsByContactEmailIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedOperator = operatorRepository.saveAndFlush(operator);

        // Get all the operatorList where contactEmail equals to
        defaultOperatorFiltering("contactEmail.equals=" + DEFAULT_CONTACT_EMAIL, "contactEmail.equals=" + UPDATED_CONTACT_EMAIL);
    }

    @Test
    @Transactional
    void getAllOperatorsByContactEmailIsInShouldWork() throws Exception {
        // Initialize the database
        insertedOperator = operatorRepository.saveAndFlush(operator);

        // Get all the operatorList where contactEmail in
        defaultOperatorFiltering(
            "contactEmail.in=" + DEFAULT_CONTACT_EMAIL + "," + UPDATED_CONTACT_EMAIL,
            "contactEmail.in=" + UPDATED_CONTACT_EMAIL
        );
    }

    @Test
    @Transactional
    void getAllOperatorsByContactEmailIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedOperator = operatorRepository.saveAndFlush(operator);

        // Get all the operatorList where contactEmail is not null
        defaultOperatorFiltering("contactEmail.specified=true", "contactEmail.specified=false");
    }

    @Test
    @Transactional
    void getAllOperatorsByContactEmailContainsSomething() throws Exception {
        // Initialize the database
        insertedOperator = operatorRepository.saveAndFlush(operator);

        // Get all the operatorList where contactEmail contains
        defaultOperatorFiltering("contactEmail.contains=" + DEFAULT_CONTACT_EMAIL, "contactEmail.contains=" + UPDATED_CONTACT_EMAIL);
    }

    @Test
    @Transactional
    void getAllOperatorsByContactEmailNotContainsSomething() throws Exception {
        // Initialize the database
        insertedOperator = operatorRepository.saveAndFlush(operator);

        // Get all the operatorList where contactEmail does not contain
        defaultOperatorFiltering(
            "contactEmail.doesNotContain=" + UPDATED_CONTACT_EMAIL,
            "contactEmail.doesNotContain=" + DEFAULT_CONTACT_EMAIL
        );
    }

    @Test
    @Transactional
    void getAllOperatorsByIsActiveIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedOperator = operatorRepository.saveAndFlush(operator);

        // Get all the operatorList where isActive equals to
        defaultOperatorFiltering("isActive.equals=" + DEFAULT_IS_ACTIVE, "isActive.equals=" + UPDATED_IS_ACTIVE);
    }

    @Test
    @Transactional
    void getAllOperatorsByIsActiveIsInShouldWork() throws Exception {
        // Initialize the database
        insertedOperator = operatorRepository.saveAndFlush(operator);

        // Get all the operatorList where isActive in
        defaultOperatorFiltering("isActive.in=" + DEFAULT_IS_ACTIVE + "," + UPDATED_IS_ACTIVE, "isActive.in=" + UPDATED_IS_ACTIVE);
    }

    @Test
    @Transactional
    void getAllOperatorsByIsActiveIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedOperator = operatorRepository.saveAndFlush(operator);

        // Get all the operatorList where isActive is not null
        defaultOperatorFiltering("isActive.specified=true", "isActive.specified=false");
    }

    private void defaultOperatorFiltering(String shouldBeFound, String shouldNotBeFound) throws Exception {
        defaultOperatorShouldBeFound(shouldBeFound);
        defaultOperatorShouldNotBeFound(shouldNotBeFound);
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultOperatorShouldBeFound(String filter) throws Exception {
        restOperatorMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(operator.getId().intValue())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
            .andExpect(jsonPath("$.[*].businessLicense").value(hasItem(DEFAULT_BUSINESS_LICENSE)))
            .andExpect(jsonPath("$.[*].logoUrl").value(hasItem(DEFAULT_LOGO_URL)))
            .andExpect(jsonPath("$.[*].rating").value(hasItem(DEFAULT_RATING)))
            .andExpect(jsonPath("$.[*].contactPhone").value(hasItem(DEFAULT_CONTACT_PHONE)))
            .andExpect(jsonPath("$.[*].contactEmail").value(hasItem(DEFAULT_CONTACT_EMAIL)))
            .andExpect(jsonPath("$.[*].isActive").value(hasItem(DEFAULT_IS_ACTIVE)));

        // Check, that the count call also returns 1
        restOperatorMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("1"));
    }

    /**
     * Executes the search, and checks that the default entity is not returned.
     */
    private void defaultOperatorShouldNotBeFound(String filter) throws Exception {
        restOperatorMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());

        // Check, that the count call also returns 0
        restOperatorMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("0"));
    }

    @Test
    @Transactional
    void getNonExistingOperator() throws Exception {
        // Get the operator
        restOperatorMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingOperator() throws Exception {
        // Initialize the database
        insertedOperator = operatorRepository.saveAndFlush(operator);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the operator
        Operator updatedOperator = operatorRepository.findById(operator.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedOperator are not directly saved in db
        em.detach(updatedOperator);
        updatedOperator
            .name(UPDATED_NAME)
            .businessLicense(UPDATED_BUSINESS_LICENSE)
            .logoUrl(UPDATED_LOGO_URL)
            .rating(UPDATED_RATING)
            .contactPhone(UPDATED_CONTACT_PHONE)
            .contactEmail(UPDATED_CONTACT_EMAIL)
            .isActive(UPDATED_IS_ACTIVE);
        OperatorDTO operatorDTO = operatorMapper.toDto(updatedOperator);

        restOperatorMockMvc
            .perform(
                put(ENTITY_API_URL_ID, operatorDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(operatorDTO))
            )
            .andExpect(status().isOk());

        // Validate the Operator in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedOperatorToMatchAllProperties(updatedOperator);
    }

    @Test
    @Transactional
    void putNonExistingOperator() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        operator.setId(longCount.incrementAndGet());

        // Create the Operator
        OperatorDTO operatorDTO = operatorMapper.toDto(operator);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restOperatorMockMvc
            .perform(
                put(ENTITY_API_URL_ID, operatorDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(operatorDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Operator in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchOperator() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        operator.setId(longCount.incrementAndGet());

        // Create the Operator
        OperatorDTO operatorDTO = operatorMapper.toDto(operator);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restOperatorMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(operatorDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Operator in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamOperator() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        operator.setId(longCount.incrementAndGet());

        // Create the Operator
        OperatorDTO operatorDTO = operatorMapper.toDto(operator);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restOperatorMockMvc
            .perform(put(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(operatorDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Operator in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateOperatorWithPatch() throws Exception {
        // Initialize the database
        insertedOperator = operatorRepository.saveAndFlush(operator);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the operator using partial update
        Operator partialUpdatedOperator = new Operator();
        partialUpdatedOperator.setId(operator.getId());

        partialUpdatedOperator.businessLicense(UPDATED_BUSINESS_LICENSE).logoUrl(UPDATED_LOGO_URL).rating(UPDATED_RATING);

        restOperatorMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedOperator.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedOperator))
            )
            .andExpect(status().isOk());

        // Validate the Operator in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertOperatorUpdatableFieldsEquals(createUpdateProxyForBean(partialUpdatedOperator, operator), getPersistedOperator(operator));
    }

    @Test
    @Transactional
    void fullUpdateOperatorWithPatch() throws Exception {
        // Initialize the database
        insertedOperator = operatorRepository.saveAndFlush(operator);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the operator using partial update
        Operator partialUpdatedOperator = new Operator();
        partialUpdatedOperator.setId(operator.getId());

        partialUpdatedOperator
            .name(UPDATED_NAME)
            .businessLicense(UPDATED_BUSINESS_LICENSE)
            .logoUrl(UPDATED_LOGO_URL)
            .rating(UPDATED_RATING)
            .contactPhone(UPDATED_CONTACT_PHONE)
            .contactEmail(UPDATED_CONTACT_EMAIL)
            .isActive(UPDATED_IS_ACTIVE);

        restOperatorMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedOperator.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedOperator))
            )
            .andExpect(status().isOk());

        // Validate the Operator in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertOperatorUpdatableFieldsEquals(partialUpdatedOperator, getPersistedOperator(partialUpdatedOperator));
    }

    @Test
    @Transactional
    void patchNonExistingOperator() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        operator.setId(longCount.incrementAndGet());

        // Create the Operator
        OperatorDTO operatorDTO = operatorMapper.toDto(operator);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restOperatorMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, operatorDTO.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(operatorDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Operator in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchOperator() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        operator.setId(longCount.incrementAndGet());

        // Create the Operator
        OperatorDTO operatorDTO = operatorMapper.toDto(operator);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restOperatorMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(operatorDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Operator in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamOperator() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        operator.setId(longCount.incrementAndGet());

        // Create the Operator
        OperatorDTO operatorDTO = operatorMapper.toDto(operator);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restOperatorMockMvc
            .perform(
                patch(ENTITY_API_URL).with(csrf()).contentType("application/merge-patch+json").content(om.writeValueAsBytes(operatorDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the Operator in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteOperator() throws Exception {
        // Initialize the database
        insertedOperator = operatorRepository.saveAndFlush(operator);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the operator
        restOperatorMockMvc
            .perform(delete(ENTITY_API_URL_ID, operator.getId()).with(csrf()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return operatorRepository.count();
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

    protected Operator getPersistedOperator(Operator operator) {
        return operatorRepository.findById(operator.getId()).orElseThrow();
    }

    protected void assertPersistedOperatorToMatchAllProperties(Operator expectedOperator) {
        assertOperatorAllPropertiesEquals(expectedOperator, getPersistedOperator(expectedOperator));
    }

    protected void assertPersistedOperatorToMatchUpdatableProperties(Operator expectedOperator) {
        assertOperatorAllUpdatablePropertiesEquals(expectedOperator, getPersistedOperator(expectedOperator));
    }
}
