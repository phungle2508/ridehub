package com.ticketsystem.route.web.rest;

import static com.ticketsystem.route.domain.WardAsserts.*;
import static com.ticketsystem.route.web.rest.TestUtil.createUpdateProxyForBean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketsystem.route.IntegrationTest;
import com.ticketsystem.route.domain.District;
import com.ticketsystem.route.domain.Ward;
import com.ticketsystem.route.repository.WardRepository;
import com.ticketsystem.route.service.dto.WardDTO;
import com.ticketsystem.route.service.mapper.WardMapper;
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
 * Integration tests for the {@link WardResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class WardResourceIT {

    private static final String DEFAULT_CODE = "AAAAAAAAAA";
    private static final String UPDATED_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_NAME_EN = "AAAAAAAAAA";
    private static final String UPDATED_NAME_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_TYPE = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/wards";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private WardRepository wardRepository;

    @Autowired
    private WardMapper wardMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restWardMockMvc;

    private Ward ward;

    private Ward insertedWard;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Ward createEntity(EntityManager em) {
        Ward ward = new Ward().code(DEFAULT_CODE).name(DEFAULT_NAME).nameEn(DEFAULT_NAME_EN).type(DEFAULT_TYPE);
        // Add required entity
        District district;
        if (TestUtil.findAll(em, District.class).isEmpty()) {
            district = DistrictResourceIT.createEntity(em);
            em.persist(district);
            em.flush();
        } else {
            district = TestUtil.findAll(em, District.class).get(0);
        }
        ward.setDistrict(district);
        return ward;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Ward createUpdatedEntity(EntityManager em) {
        Ward updatedWard = new Ward().code(UPDATED_CODE).name(UPDATED_NAME).nameEn(UPDATED_NAME_EN).type(UPDATED_TYPE);
        // Add required entity
        District district;
        if (TestUtil.findAll(em, District.class).isEmpty()) {
            district = DistrictResourceIT.createUpdatedEntity(em);
            em.persist(district);
            em.flush();
        } else {
            district = TestUtil.findAll(em, District.class).get(0);
        }
        updatedWard.setDistrict(district);
        return updatedWard;
    }

    @BeforeEach
    void initTest() {
        ward = createEntity(em);
    }

    @AfterEach
    void cleanup() {
        if (insertedWard != null) {
            wardRepository.delete(insertedWard);
            insertedWard = null;
        }
    }

    @Test
    @Transactional
    void createWard() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the Ward
        WardDTO wardDTO = wardMapper.toDto(ward);
        var returnedWardDTO = om.readValue(
            restWardMockMvc
                .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(wardDTO)))
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            WardDTO.class
        );

        // Validate the Ward in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        var returnedWard = wardMapper.toEntity(returnedWardDTO);
        assertWardUpdatableFieldsEquals(returnedWard, getPersistedWard(returnedWard));

        insertedWard = returnedWard;
    }

    @Test
    @Transactional
    void createWardWithExistingId() throws Exception {
        // Create the Ward with an existing ID
        ward.setId(1L);
        WardDTO wardDTO = wardMapper.toDto(ward);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restWardMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(wardDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Ward in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkCodeIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        ward.setCode(null);

        // Create the Ward, which fails.
        WardDTO wardDTO = wardMapper.toDto(ward);

        restWardMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(wardDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkNameIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        ward.setName(null);

        // Create the Ward, which fails.
        WardDTO wardDTO = wardMapper.toDto(ward);

        restWardMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(wardDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllWards() throws Exception {
        // Initialize the database
        insertedWard = wardRepository.saveAndFlush(ward);

        // Get all the wardList
        restWardMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(ward.getId().intValue())))
            .andExpect(jsonPath("$.[*].code").value(hasItem(DEFAULT_CODE)))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
            .andExpect(jsonPath("$.[*].nameEn").value(hasItem(DEFAULT_NAME_EN)))
            .andExpect(jsonPath("$.[*].type").value(hasItem(DEFAULT_TYPE)));
    }

    @Test
    @Transactional
    void getWard() throws Exception {
        // Initialize the database
        insertedWard = wardRepository.saveAndFlush(ward);

        // Get the ward
        restWardMockMvc
            .perform(get(ENTITY_API_URL_ID, ward.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(ward.getId().intValue()))
            .andExpect(jsonPath("$.code").value(DEFAULT_CODE))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME))
            .andExpect(jsonPath("$.nameEn").value(DEFAULT_NAME_EN))
            .andExpect(jsonPath("$.type").value(DEFAULT_TYPE));
    }

    @Test
    @Transactional
    void getWardsByIdFiltering() throws Exception {
        // Initialize the database
        insertedWard = wardRepository.saveAndFlush(ward);

        Long id = ward.getId();

        defaultWardFiltering("id.equals=" + id, "id.notEquals=" + id);

        defaultWardFiltering("id.greaterThanOrEqual=" + id, "id.greaterThan=" + id);

        defaultWardFiltering("id.lessThanOrEqual=" + id, "id.lessThan=" + id);
    }

    @Test
    @Transactional
    void getAllWardsByCodeIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedWard = wardRepository.saveAndFlush(ward);

        // Get all the wardList where code equals to
        defaultWardFiltering("code.equals=" + DEFAULT_CODE, "code.equals=" + UPDATED_CODE);
    }

    @Test
    @Transactional
    void getAllWardsByCodeIsInShouldWork() throws Exception {
        // Initialize the database
        insertedWard = wardRepository.saveAndFlush(ward);

        // Get all the wardList where code in
        defaultWardFiltering("code.in=" + DEFAULT_CODE + "," + UPDATED_CODE, "code.in=" + UPDATED_CODE);
    }

    @Test
    @Transactional
    void getAllWardsByCodeIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedWard = wardRepository.saveAndFlush(ward);

        // Get all the wardList where code is not null
        defaultWardFiltering("code.specified=true", "code.specified=false");
    }

    @Test
    @Transactional
    void getAllWardsByCodeContainsSomething() throws Exception {
        // Initialize the database
        insertedWard = wardRepository.saveAndFlush(ward);

        // Get all the wardList where code contains
        defaultWardFiltering("code.contains=" + DEFAULT_CODE, "code.contains=" + UPDATED_CODE);
    }

    @Test
    @Transactional
    void getAllWardsByCodeNotContainsSomething() throws Exception {
        // Initialize the database
        insertedWard = wardRepository.saveAndFlush(ward);

        // Get all the wardList where code does not contain
        defaultWardFiltering("code.doesNotContain=" + UPDATED_CODE, "code.doesNotContain=" + DEFAULT_CODE);
    }

    @Test
    @Transactional
    void getAllWardsByNameIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedWard = wardRepository.saveAndFlush(ward);

        // Get all the wardList where name equals to
        defaultWardFiltering("name.equals=" + DEFAULT_NAME, "name.equals=" + UPDATED_NAME);
    }

    @Test
    @Transactional
    void getAllWardsByNameIsInShouldWork() throws Exception {
        // Initialize the database
        insertedWard = wardRepository.saveAndFlush(ward);

        // Get all the wardList where name in
        defaultWardFiltering("name.in=" + DEFAULT_NAME + "," + UPDATED_NAME, "name.in=" + UPDATED_NAME);
    }

    @Test
    @Transactional
    void getAllWardsByNameIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedWard = wardRepository.saveAndFlush(ward);

        // Get all the wardList where name is not null
        defaultWardFiltering("name.specified=true", "name.specified=false");
    }

    @Test
    @Transactional
    void getAllWardsByNameContainsSomething() throws Exception {
        // Initialize the database
        insertedWard = wardRepository.saveAndFlush(ward);

        // Get all the wardList where name contains
        defaultWardFiltering("name.contains=" + DEFAULT_NAME, "name.contains=" + UPDATED_NAME);
    }

    @Test
    @Transactional
    void getAllWardsByNameNotContainsSomething() throws Exception {
        // Initialize the database
        insertedWard = wardRepository.saveAndFlush(ward);

        // Get all the wardList where name does not contain
        defaultWardFiltering("name.doesNotContain=" + UPDATED_NAME, "name.doesNotContain=" + DEFAULT_NAME);
    }

    @Test
    @Transactional
    void getAllWardsByNameEnIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedWard = wardRepository.saveAndFlush(ward);

        // Get all the wardList where nameEn equals to
        defaultWardFiltering("nameEn.equals=" + DEFAULT_NAME_EN, "nameEn.equals=" + UPDATED_NAME_EN);
    }

    @Test
    @Transactional
    void getAllWardsByNameEnIsInShouldWork() throws Exception {
        // Initialize the database
        insertedWard = wardRepository.saveAndFlush(ward);

        // Get all the wardList where nameEn in
        defaultWardFiltering("nameEn.in=" + DEFAULT_NAME_EN + "," + UPDATED_NAME_EN, "nameEn.in=" + UPDATED_NAME_EN);
    }

    @Test
    @Transactional
    void getAllWardsByNameEnIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedWard = wardRepository.saveAndFlush(ward);

        // Get all the wardList where nameEn is not null
        defaultWardFiltering("nameEn.specified=true", "nameEn.specified=false");
    }

    @Test
    @Transactional
    void getAllWardsByNameEnContainsSomething() throws Exception {
        // Initialize the database
        insertedWard = wardRepository.saveAndFlush(ward);

        // Get all the wardList where nameEn contains
        defaultWardFiltering("nameEn.contains=" + DEFAULT_NAME_EN, "nameEn.contains=" + UPDATED_NAME_EN);
    }

    @Test
    @Transactional
    void getAllWardsByNameEnNotContainsSomething() throws Exception {
        // Initialize the database
        insertedWard = wardRepository.saveAndFlush(ward);

        // Get all the wardList where nameEn does not contain
        defaultWardFiltering("nameEn.doesNotContain=" + UPDATED_NAME_EN, "nameEn.doesNotContain=" + DEFAULT_NAME_EN);
    }

    @Test
    @Transactional
    void getAllWardsByTypeIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedWard = wardRepository.saveAndFlush(ward);

        // Get all the wardList where type equals to
        defaultWardFiltering("type.equals=" + DEFAULT_TYPE, "type.equals=" + UPDATED_TYPE);
    }

    @Test
    @Transactional
    void getAllWardsByTypeIsInShouldWork() throws Exception {
        // Initialize the database
        insertedWard = wardRepository.saveAndFlush(ward);

        // Get all the wardList where type in
        defaultWardFiltering("type.in=" + DEFAULT_TYPE + "," + UPDATED_TYPE, "type.in=" + UPDATED_TYPE);
    }

    @Test
    @Transactional
    void getAllWardsByTypeIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedWard = wardRepository.saveAndFlush(ward);

        // Get all the wardList where type is not null
        defaultWardFiltering("type.specified=true", "type.specified=false");
    }

    @Test
    @Transactional
    void getAllWardsByTypeContainsSomething() throws Exception {
        // Initialize the database
        insertedWard = wardRepository.saveAndFlush(ward);

        // Get all the wardList where type contains
        defaultWardFiltering("type.contains=" + DEFAULT_TYPE, "type.contains=" + UPDATED_TYPE);
    }

    @Test
    @Transactional
    void getAllWardsByTypeNotContainsSomething() throws Exception {
        // Initialize the database
        insertedWard = wardRepository.saveAndFlush(ward);

        // Get all the wardList where type does not contain
        defaultWardFiltering("type.doesNotContain=" + UPDATED_TYPE, "type.doesNotContain=" + DEFAULT_TYPE);
    }

    @Test
    @Transactional
    void getAllWardsByDistrictIsEqualToSomething() throws Exception {
        District district;
        if (TestUtil.findAll(em, District.class).isEmpty()) {
            wardRepository.saveAndFlush(ward);
            district = DistrictResourceIT.createEntity(em);
        } else {
            district = TestUtil.findAll(em, District.class).get(0);
        }
        em.persist(district);
        em.flush();
        ward.setDistrict(district);
        wardRepository.saveAndFlush(ward);
        Long districtId = district.getId();
        // Get all the wardList where district equals to districtId
        defaultWardShouldBeFound("districtId.equals=" + districtId);

        // Get all the wardList where district equals to (districtId + 1)
        defaultWardShouldNotBeFound("districtId.equals=" + (districtId + 1));
    }

    private void defaultWardFiltering(String shouldBeFound, String shouldNotBeFound) throws Exception {
        defaultWardShouldBeFound(shouldBeFound);
        defaultWardShouldNotBeFound(shouldNotBeFound);
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultWardShouldBeFound(String filter) throws Exception {
        restWardMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(ward.getId().intValue())))
            .andExpect(jsonPath("$.[*].code").value(hasItem(DEFAULT_CODE)))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
            .andExpect(jsonPath("$.[*].nameEn").value(hasItem(DEFAULT_NAME_EN)))
            .andExpect(jsonPath("$.[*].type").value(hasItem(DEFAULT_TYPE)));

        // Check, that the count call also returns 1
        restWardMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("1"));
    }

    /**
     * Executes the search, and checks that the default entity is not returned.
     */
    private void defaultWardShouldNotBeFound(String filter) throws Exception {
        restWardMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());

        // Check, that the count call also returns 0
        restWardMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("0"));
    }

    @Test
    @Transactional
    void getNonExistingWard() throws Exception {
        // Get the ward
        restWardMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingWard() throws Exception {
        // Initialize the database
        insertedWard = wardRepository.saveAndFlush(ward);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the ward
        Ward updatedWard = wardRepository.findById(ward.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedWard are not directly saved in db
        em.detach(updatedWard);
        updatedWard.code(UPDATED_CODE).name(UPDATED_NAME).nameEn(UPDATED_NAME_EN).type(UPDATED_TYPE);
        WardDTO wardDTO = wardMapper.toDto(updatedWard);

        restWardMockMvc
            .perform(
                put(ENTITY_API_URL_ID, wardDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(wardDTO))
            )
            .andExpect(status().isOk());

        // Validate the Ward in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedWardToMatchAllProperties(updatedWard);
    }

    @Test
    @Transactional
    void putNonExistingWard() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        ward.setId(longCount.incrementAndGet());

        // Create the Ward
        WardDTO wardDTO = wardMapper.toDto(ward);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restWardMockMvc
            .perform(
                put(ENTITY_API_URL_ID, wardDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(wardDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Ward in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchWard() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        ward.setId(longCount.incrementAndGet());

        // Create the Ward
        WardDTO wardDTO = wardMapper.toDto(ward);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restWardMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(wardDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Ward in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamWard() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        ward.setId(longCount.incrementAndGet());

        // Create the Ward
        WardDTO wardDTO = wardMapper.toDto(ward);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restWardMockMvc
            .perform(put(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(wardDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Ward in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateWardWithPatch() throws Exception {
        // Initialize the database
        insertedWard = wardRepository.saveAndFlush(ward);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the ward using partial update
        Ward partialUpdatedWard = new Ward();
        partialUpdatedWard.setId(ward.getId());

        partialUpdatedWard.code(UPDATED_CODE).name(UPDATED_NAME).type(UPDATED_TYPE);

        restWardMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedWard.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedWard))
            )
            .andExpect(status().isOk());

        // Validate the Ward in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertWardUpdatableFieldsEquals(createUpdateProxyForBean(partialUpdatedWard, ward), getPersistedWard(ward));
    }

    @Test
    @Transactional
    void fullUpdateWardWithPatch() throws Exception {
        // Initialize the database
        insertedWard = wardRepository.saveAndFlush(ward);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the ward using partial update
        Ward partialUpdatedWard = new Ward();
        partialUpdatedWard.setId(ward.getId());

        partialUpdatedWard.code(UPDATED_CODE).name(UPDATED_NAME).nameEn(UPDATED_NAME_EN).type(UPDATED_TYPE);

        restWardMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedWard.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedWard))
            )
            .andExpect(status().isOk());

        // Validate the Ward in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertWardUpdatableFieldsEquals(partialUpdatedWard, getPersistedWard(partialUpdatedWard));
    }

    @Test
    @Transactional
    void patchNonExistingWard() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        ward.setId(longCount.incrementAndGet());

        // Create the Ward
        WardDTO wardDTO = wardMapper.toDto(ward);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restWardMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, wardDTO.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(wardDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Ward in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchWard() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        ward.setId(longCount.incrementAndGet());

        // Create the Ward
        WardDTO wardDTO = wardMapper.toDto(ward);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restWardMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(wardDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Ward in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamWard() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        ward.setId(longCount.incrementAndGet());

        // Create the Ward
        WardDTO wardDTO = wardMapper.toDto(ward);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restWardMockMvc
            .perform(patch(ENTITY_API_URL).with(csrf()).contentType("application/merge-patch+json").content(om.writeValueAsBytes(wardDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Ward in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteWard() throws Exception {
        // Initialize the database
        insertedWard = wardRepository.saveAndFlush(ward);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the ward
        restWardMockMvc
            .perform(delete(ENTITY_API_URL_ID, ward.getId()).with(csrf()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return wardRepository.count();
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

    protected Ward getPersistedWard(Ward ward) {
        return wardRepository.findById(ward.getId()).orElseThrow();
    }

    protected void assertPersistedWardToMatchAllProperties(Ward expectedWard) {
        assertWardAllPropertiesEquals(expectedWard, getPersistedWard(expectedWard));
    }

    protected void assertPersistedWardToMatchUpdatableProperties(Ward expectedWard) {
        assertWardAllUpdatablePropertiesEquals(expectedWard, getPersistedWard(expectedWard));
    }
}
