package com.ticketsystem.route.web.rest;

import static com.ticketsystem.route.domain.DistrictAsserts.*;
import static com.ticketsystem.route.web.rest.TestUtil.createUpdateProxyForBean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketsystem.route.IntegrationTest;
import com.ticketsystem.route.domain.District;
import com.ticketsystem.route.domain.Province;
import com.ticketsystem.route.repository.DistrictRepository;
import com.ticketsystem.route.service.dto.DistrictDTO;
import com.ticketsystem.route.service.mapper.DistrictMapper;
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
 * Integration tests for the {@link DistrictResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class DistrictResourceIT {

    private static final String DEFAULT_CODE = "AAAAAAAAAA";
    private static final String UPDATED_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_NAME_EN = "AAAAAAAAAA";
    private static final String UPDATED_NAME_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_TYPE = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/districts";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private DistrictMapper districtMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restDistrictMockMvc;

    private District district;

    private District insertedDistrict;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static District createEntity(EntityManager em) {
        District district = new District().code(DEFAULT_CODE).name(DEFAULT_NAME).nameEn(DEFAULT_NAME_EN).type(DEFAULT_TYPE);
        // Add required entity
        Province province;
        if (TestUtil.findAll(em, Province.class).isEmpty()) {
            province = ProvinceResourceIT.createEntity();
            em.persist(province);
            em.flush();
        } else {
            province = TestUtil.findAll(em, Province.class).get(0);
        }
        district.setProvince(province);
        return district;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static District createUpdatedEntity(EntityManager em) {
        District updatedDistrict = new District().code(UPDATED_CODE).name(UPDATED_NAME).nameEn(UPDATED_NAME_EN).type(UPDATED_TYPE);
        // Add required entity
        Province province;
        if (TestUtil.findAll(em, Province.class).isEmpty()) {
            province = ProvinceResourceIT.createUpdatedEntity();
            em.persist(province);
            em.flush();
        } else {
            province = TestUtil.findAll(em, Province.class).get(0);
        }
        updatedDistrict.setProvince(province);
        return updatedDistrict;
    }

    @BeforeEach
    void initTest() {
        district = createEntity(em);
    }

    @AfterEach
    void cleanup() {
        if (insertedDistrict != null) {
            districtRepository.delete(insertedDistrict);
            insertedDistrict = null;
        }
    }

    @Test
    @Transactional
    void createDistrict() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the District
        DistrictDTO districtDTO = districtMapper.toDto(district);
        var returnedDistrictDTO = om.readValue(
            restDistrictMockMvc
                .perform(
                    post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(districtDTO))
                )
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            DistrictDTO.class
        );

        // Validate the District in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        var returnedDistrict = districtMapper.toEntity(returnedDistrictDTO);
        assertDistrictUpdatableFieldsEquals(returnedDistrict, getPersistedDistrict(returnedDistrict));

        insertedDistrict = returnedDistrict;
    }

    @Test
    @Transactional
    void createDistrictWithExistingId() throws Exception {
        // Create the District with an existing ID
        district.setId(1L);
        DistrictDTO districtDTO = districtMapper.toDto(district);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restDistrictMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(districtDTO)))
            .andExpect(status().isBadRequest());

        // Validate the District in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkCodeIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        district.setCode(null);

        // Create the District, which fails.
        DistrictDTO districtDTO = districtMapper.toDto(district);

        restDistrictMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(districtDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkNameIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        district.setName(null);

        // Create the District, which fails.
        DistrictDTO districtDTO = districtMapper.toDto(district);

        restDistrictMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(districtDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllDistricts() throws Exception {
        // Initialize the database
        insertedDistrict = districtRepository.saveAndFlush(district);

        // Get all the districtList
        restDistrictMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(district.getId().intValue())))
            .andExpect(jsonPath("$.[*].code").value(hasItem(DEFAULT_CODE)))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
            .andExpect(jsonPath("$.[*].nameEn").value(hasItem(DEFAULT_NAME_EN)))
            .andExpect(jsonPath("$.[*].type").value(hasItem(DEFAULT_TYPE)));
    }

    @Test
    @Transactional
    void getDistrict() throws Exception {
        // Initialize the database
        insertedDistrict = districtRepository.saveAndFlush(district);

        // Get the district
        restDistrictMockMvc
            .perform(get(ENTITY_API_URL_ID, district.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(district.getId().intValue()))
            .andExpect(jsonPath("$.code").value(DEFAULT_CODE))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME))
            .andExpect(jsonPath("$.nameEn").value(DEFAULT_NAME_EN))
            .andExpect(jsonPath("$.type").value(DEFAULT_TYPE));
    }

    @Test
    @Transactional
    void getDistrictsByIdFiltering() throws Exception {
        // Initialize the database
        insertedDistrict = districtRepository.saveAndFlush(district);

        Long id = district.getId();

        defaultDistrictFiltering("id.equals=" + id, "id.notEquals=" + id);

        defaultDistrictFiltering("id.greaterThanOrEqual=" + id, "id.greaterThan=" + id);

        defaultDistrictFiltering("id.lessThanOrEqual=" + id, "id.lessThan=" + id);
    }

    @Test
    @Transactional
    void getAllDistrictsByCodeIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedDistrict = districtRepository.saveAndFlush(district);

        // Get all the districtList where code equals to
        defaultDistrictFiltering("code.equals=" + DEFAULT_CODE, "code.equals=" + UPDATED_CODE);
    }

    @Test
    @Transactional
    void getAllDistrictsByCodeIsInShouldWork() throws Exception {
        // Initialize the database
        insertedDistrict = districtRepository.saveAndFlush(district);

        // Get all the districtList where code in
        defaultDistrictFiltering("code.in=" + DEFAULT_CODE + "," + UPDATED_CODE, "code.in=" + UPDATED_CODE);
    }

    @Test
    @Transactional
    void getAllDistrictsByCodeIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedDistrict = districtRepository.saveAndFlush(district);

        // Get all the districtList where code is not null
        defaultDistrictFiltering("code.specified=true", "code.specified=false");
    }

    @Test
    @Transactional
    void getAllDistrictsByCodeContainsSomething() throws Exception {
        // Initialize the database
        insertedDistrict = districtRepository.saveAndFlush(district);

        // Get all the districtList where code contains
        defaultDistrictFiltering("code.contains=" + DEFAULT_CODE, "code.contains=" + UPDATED_CODE);
    }

    @Test
    @Transactional
    void getAllDistrictsByCodeNotContainsSomething() throws Exception {
        // Initialize the database
        insertedDistrict = districtRepository.saveAndFlush(district);

        // Get all the districtList where code does not contain
        defaultDistrictFiltering("code.doesNotContain=" + UPDATED_CODE, "code.doesNotContain=" + DEFAULT_CODE);
    }

    @Test
    @Transactional
    void getAllDistrictsByNameIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedDistrict = districtRepository.saveAndFlush(district);

        // Get all the districtList where name equals to
        defaultDistrictFiltering("name.equals=" + DEFAULT_NAME, "name.equals=" + UPDATED_NAME);
    }

    @Test
    @Transactional
    void getAllDistrictsByNameIsInShouldWork() throws Exception {
        // Initialize the database
        insertedDistrict = districtRepository.saveAndFlush(district);

        // Get all the districtList where name in
        defaultDistrictFiltering("name.in=" + DEFAULT_NAME + "," + UPDATED_NAME, "name.in=" + UPDATED_NAME);
    }

    @Test
    @Transactional
    void getAllDistrictsByNameIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedDistrict = districtRepository.saveAndFlush(district);

        // Get all the districtList where name is not null
        defaultDistrictFiltering("name.specified=true", "name.specified=false");
    }

    @Test
    @Transactional
    void getAllDistrictsByNameContainsSomething() throws Exception {
        // Initialize the database
        insertedDistrict = districtRepository.saveAndFlush(district);

        // Get all the districtList where name contains
        defaultDistrictFiltering("name.contains=" + DEFAULT_NAME, "name.contains=" + UPDATED_NAME);
    }

    @Test
    @Transactional
    void getAllDistrictsByNameNotContainsSomething() throws Exception {
        // Initialize the database
        insertedDistrict = districtRepository.saveAndFlush(district);

        // Get all the districtList where name does not contain
        defaultDistrictFiltering("name.doesNotContain=" + UPDATED_NAME, "name.doesNotContain=" + DEFAULT_NAME);
    }

    @Test
    @Transactional
    void getAllDistrictsByNameEnIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedDistrict = districtRepository.saveAndFlush(district);

        // Get all the districtList where nameEn equals to
        defaultDistrictFiltering("nameEn.equals=" + DEFAULT_NAME_EN, "nameEn.equals=" + UPDATED_NAME_EN);
    }

    @Test
    @Transactional
    void getAllDistrictsByNameEnIsInShouldWork() throws Exception {
        // Initialize the database
        insertedDistrict = districtRepository.saveAndFlush(district);

        // Get all the districtList where nameEn in
        defaultDistrictFiltering("nameEn.in=" + DEFAULT_NAME_EN + "," + UPDATED_NAME_EN, "nameEn.in=" + UPDATED_NAME_EN);
    }

    @Test
    @Transactional
    void getAllDistrictsByNameEnIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedDistrict = districtRepository.saveAndFlush(district);

        // Get all the districtList where nameEn is not null
        defaultDistrictFiltering("nameEn.specified=true", "nameEn.specified=false");
    }

    @Test
    @Transactional
    void getAllDistrictsByNameEnContainsSomething() throws Exception {
        // Initialize the database
        insertedDistrict = districtRepository.saveAndFlush(district);

        // Get all the districtList where nameEn contains
        defaultDistrictFiltering("nameEn.contains=" + DEFAULT_NAME_EN, "nameEn.contains=" + UPDATED_NAME_EN);
    }

    @Test
    @Transactional
    void getAllDistrictsByNameEnNotContainsSomething() throws Exception {
        // Initialize the database
        insertedDistrict = districtRepository.saveAndFlush(district);

        // Get all the districtList where nameEn does not contain
        defaultDistrictFiltering("nameEn.doesNotContain=" + UPDATED_NAME_EN, "nameEn.doesNotContain=" + DEFAULT_NAME_EN);
    }

    @Test
    @Transactional
    void getAllDistrictsByTypeIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedDistrict = districtRepository.saveAndFlush(district);

        // Get all the districtList where type equals to
        defaultDistrictFiltering("type.equals=" + DEFAULT_TYPE, "type.equals=" + UPDATED_TYPE);
    }

    @Test
    @Transactional
    void getAllDistrictsByTypeIsInShouldWork() throws Exception {
        // Initialize the database
        insertedDistrict = districtRepository.saveAndFlush(district);

        // Get all the districtList where type in
        defaultDistrictFiltering("type.in=" + DEFAULT_TYPE + "," + UPDATED_TYPE, "type.in=" + UPDATED_TYPE);
    }

    @Test
    @Transactional
    void getAllDistrictsByTypeIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedDistrict = districtRepository.saveAndFlush(district);

        // Get all the districtList where type is not null
        defaultDistrictFiltering("type.specified=true", "type.specified=false");
    }

    @Test
    @Transactional
    void getAllDistrictsByTypeContainsSomething() throws Exception {
        // Initialize the database
        insertedDistrict = districtRepository.saveAndFlush(district);

        // Get all the districtList where type contains
        defaultDistrictFiltering("type.contains=" + DEFAULT_TYPE, "type.contains=" + UPDATED_TYPE);
    }

    @Test
    @Transactional
    void getAllDistrictsByTypeNotContainsSomething() throws Exception {
        // Initialize the database
        insertedDistrict = districtRepository.saveAndFlush(district);

        // Get all the districtList where type does not contain
        defaultDistrictFiltering("type.doesNotContain=" + UPDATED_TYPE, "type.doesNotContain=" + DEFAULT_TYPE);
    }

    @Test
    @Transactional
    void getAllDistrictsByProvinceIsEqualToSomething() throws Exception {
        Province province;
        if (TestUtil.findAll(em, Province.class).isEmpty()) {
            districtRepository.saveAndFlush(district);
            province = ProvinceResourceIT.createEntity();
        } else {
            province = TestUtil.findAll(em, Province.class).get(0);
        }
        em.persist(province);
        em.flush();
        district.setProvince(province);
        districtRepository.saveAndFlush(district);
        Long provinceId = province.getId();
        // Get all the districtList where province equals to provinceId
        defaultDistrictShouldBeFound("provinceId.equals=" + provinceId);

        // Get all the districtList where province equals to (provinceId + 1)
        defaultDistrictShouldNotBeFound("provinceId.equals=" + (provinceId + 1));
    }

    private void defaultDistrictFiltering(String shouldBeFound, String shouldNotBeFound) throws Exception {
        defaultDistrictShouldBeFound(shouldBeFound);
        defaultDistrictShouldNotBeFound(shouldNotBeFound);
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultDistrictShouldBeFound(String filter) throws Exception {
        restDistrictMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(district.getId().intValue())))
            .andExpect(jsonPath("$.[*].code").value(hasItem(DEFAULT_CODE)))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
            .andExpect(jsonPath("$.[*].nameEn").value(hasItem(DEFAULT_NAME_EN)))
            .andExpect(jsonPath("$.[*].type").value(hasItem(DEFAULT_TYPE)));

        // Check, that the count call also returns 1
        restDistrictMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("1"));
    }

    /**
     * Executes the search, and checks that the default entity is not returned.
     */
    private void defaultDistrictShouldNotBeFound(String filter) throws Exception {
        restDistrictMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());

        // Check, that the count call also returns 0
        restDistrictMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("0"));
    }

    @Test
    @Transactional
    void getNonExistingDistrict() throws Exception {
        // Get the district
        restDistrictMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingDistrict() throws Exception {
        // Initialize the database
        insertedDistrict = districtRepository.saveAndFlush(district);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the district
        District updatedDistrict = districtRepository.findById(district.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedDistrict are not directly saved in db
        em.detach(updatedDistrict);
        updatedDistrict.code(UPDATED_CODE).name(UPDATED_NAME).nameEn(UPDATED_NAME_EN).type(UPDATED_TYPE);
        DistrictDTO districtDTO = districtMapper.toDto(updatedDistrict);

        restDistrictMockMvc
            .perform(
                put(ENTITY_API_URL_ID, districtDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(districtDTO))
            )
            .andExpect(status().isOk());

        // Validate the District in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedDistrictToMatchAllProperties(updatedDistrict);
    }

    @Test
    @Transactional
    void putNonExistingDistrict() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        district.setId(longCount.incrementAndGet());

        // Create the District
        DistrictDTO districtDTO = districtMapper.toDto(district);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restDistrictMockMvc
            .perform(
                put(ENTITY_API_URL_ID, districtDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(districtDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the District in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchDistrict() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        district.setId(longCount.incrementAndGet());

        // Create the District
        DistrictDTO districtDTO = districtMapper.toDto(district);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restDistrictMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(districtDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the District in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamDistrict() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        district.setId(longCount.incrementAndGet());

        // Create the District
        DistrictDTO districtDTO = districtMapper.toDto(district);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restDistrictMockMvc
            .perform(put(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(districtDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the District in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateDistrictWithPatch() throws Exception {
        // Initialize the database
        insertedDistrict = districtRepository.saveAndFlush(district);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the district using partial update
        District partialUpdatedDistrict = new District();
        partialUpdatedDistrict.setId(district.getId());

        partialUpdatedDistrict.name(UPDATED_NAME);

        restDistrictMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedDistrict.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedDistrict))
            )
            .andExpect(status().isOk());

        // Validate the District in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertDistrictUpdatableFieldsEquals(createUpdateProxyForBean(partialUpdatedDistrict, district), getPersistedDistrict(district));
    }

    @Test
    @Transactional
    void fullUpdateDistrictWithPatch() throws Exception {
        // Initialize the database
        insertedDistrict = districtRepository.saveAndFlush(district);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the district using partial update
        District partialUpdatedDistrict = new District();
        partialUpdatedDistrict.setId(district.getId());

        partialUpdatedDistrict.code(UPDATED_CODE).name(UPDATED_NAME).nameEn(UPDATED_NAME_EN).type(UPDATED_TYPE);

        restDistrictMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedDistrict.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedDistrict))
            )
            .andExpect(status().isOk());

        // Validate the District in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertDistrictUpdatableFieldsEquals(partialUpdatedDistrict, getPersistedDistrict(partialUpdatedDistrict));
    }

    @Test
    @Transactional
    void patchNonExistingDistrict() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        district.setId(longCount.incrementAndGet());

        // Create the District
        DistrictDTO districtDTO = districtMapper.toDto(district);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restDistrictMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, districtDTO.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(districtDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the District in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchDistrict() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        district.setId(longCount.incrementAndGet());

        // Create the District
        DistrictDTO districtDTO = districtMapper.toDto(district);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restDistrictMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(districtDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the District in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamDistrict() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        district.setId(longCount.incrementAndGet());

        // Create the District
        DistrictDTO districtDTO = districtMapper.toDto(district);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restDistrictMockMvc
            .perform(
                patch(ENTITY_API_URL).with(csrf()).contentType("application/merge-patch+json").content(om.writeValueAsBytes(districtDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the District in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteDistrict() throws Exception {
        // Initialize the database
        insertedDistrict = districtRepository.saveAndFlush(district);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the district
        restDistrictMockMvc
            .perform(delete(ENTITY_API_URL_ID, district.getId()).with(csrf()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return districtRepository.count();
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

    protected District getPersistedDistrict(District district) {
        return districtRepository.findById(district.getId()).orElseThrow();
    }

    protected void assertPersistedDistrictToMatchAllProperties(District expectedDistrict) {
        assertDistrictAllPropertiesEquals(expectedDistrict, getPersistedDistrict(expectedDistrict));
    }

    protected void assertPersistedDistrictToMatchUpdatableProperties(District expectedDistrict) {
        assertDistrictAllUpdatablePropertiesEquals(expectedDistrict, getPersistedDistrict(expectedDistrict));
    }
}
