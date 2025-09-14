package com.ticketsystem.route.web.rest;

import static com.ticketsystem.route.domain.ProvinceAsserts.*;
import static com.ticketsystem.route.web.rest.TestUtil.createUpdateProxyForBean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketsystem.route.IntegrationTest;
import com.ticketsystem.route.domain.Province;
import com.ticketsystem.route.repository.ProvinceRepository;
import com.ticketsystem.route.service.dto.ProvinceDTO;
import com.ticketsystem.route.service.mapper.ProvinceMapper;
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
 * Integration tests for the {@link ProvinceResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class ProvinceResourceIT {

    private static final String DEFAULT_CODE = "AAAAAAAAAA";
    private static final String UPDATED_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_NAME_EN = "AAAAAAAAAA";
    private static final String UPDATED_NAME_EN = "BBBBBBBBBB";

    private static final String DEFAULT_REGION = "AAAAAAAAAA";
    private static final String UPDATED_REGION = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/provinces";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private ProvinceRepository provinceRepository;

    @Autowired
    private ProvinceMapper provinceMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restProvinceMockMvc;

    private Province province;

    private Province insertedProvince;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Province createEntity() {
        return new Province().code(DEFAULT_CODE).name(DEFAULT_NAME).nameEn(DEFAULT_NAME_EN).region(DEFAULT_REGION);
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Province createUpdatedEntity() {
        return new Province().code(UPDATED_CODE).name(UPDATED_NAME).nameEn(UPDATED_NAME_EN).region(UPDATED_REGION);
    }

    @BeforeEach
    void initTest() {
        province = createEntity();
    }

    @AfterEach
    void cleanup() {
        if (insertedProvince != null) {
            provinceRepository.delete(insertedProvince);
            insertedProvince = null;
        }
    }

    @Test
    @Transactional
    void createProvince() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the Province
        ProvinceDTO provinceDTO = provinceMapper.toDto(province);
        var returnedProvinceDTO = om.readValue(
            restProvinceMockMvc
                .perform(
                    post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(provinceDTO))
                )
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            ProvinceDTO.class
        );

        // Validate the Province in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        var returnedProvince = provinceMapper.toEntity(returnedProvinceDTO);
        assertProvinceUpdatableFieldsEquals(returnedProvince, getPersistedProvince(returnedProvince));

        insertedProvince = returnedProvince;
    }

    @Test
    @Transactional
    void createProvinceWithExistingId() throws Exception {
        // Create the Province with an existing ID
        province.setId(1L);
        ProvinceDTO provinceDTO = provinceMapper.toDto(province);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restProvinceMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(provinceDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Province in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkCodeIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        province.setCode(null);

        // Create the Province, which fails.
        ProvinceDTO provinceDTO = provinceMapper.toDto(province);

        restProvinceMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(provinceDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkNameIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        province.setName(null);

        // Create the Province, which fails.
        ProvinceDTO provinceDTO = provinceMapper.toDto(province);

        restProvinceMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(provinceDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllProvinces() throws Exception {
        // Initialize the database
        insertedProvince = provinceRepository.saveAndFlush(province);

        // Get all the provinceList
        restProvinceMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(province.getId().intValue())))
            .andExpect(jsonPath("$.[*].code").value(hasItem(DEFAULT_CODE)))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
            .andExpect(jsonPath("$.[*].nameEn").value(hasItem(DEFAULT_NAME_EN)))
            .andExpect(jsonPath("$.[*].region").value(hasItem(DEFAULT_REGION)));
    }

    @Test
    @Transactional
    void getProvince() throws Exception {
        // Initialize the database
        insertedProvince = provinceRepository.saveAndFlush(province);

        // Get the province
        restProvinceMockMvc
            .perform(get(ENTITY_API_URL_ID, province.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(province.getId().intValue()))
            .andExpect(jsonPath("$.code").value(DEFAULT_CODE))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME))
            .andExpect(jsonPath("$.nameEn").value(DEFAULT_NAME_EN))
            .andExpect(jsonPath("$.region").value(DEFAULT_REGION));
    }

    @Test
    @Transactional
    void getProvincesByIdFiltering() throws Exception {
        // Initialize the database
        insertedProvince = provinceRepository.saveAndFlush(province);

        Long id = province.getId();

        defaultProvinceFiltering("id.equals=" + id, "id.notEquals=" + id);

        defaultProvinceFiltering("id.greaterThanOrEqual=" + id, "id.greaterThan=" + id);

        defaultProvinceFiltering("id.lessThanOrEqual=" + id, "id.lessThan=" + id);
    }

    @Test
    @Transactional
    void getAllProvincesByCodeIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedProvince = provinceRepository.saveAndFlush(province);

        // Get all the provinceList where code equals to
        defaultProvinceFiltering("code.equals=" + DEFAULT_CODE, "code.equals=" + UPDATED_CODE);
    }

    @Test
    @Transactional
    void getAllProvincesByCodeIsInShouldWork() throws Exception {
        // Initialize the database
        insertedProvince = provinceRepository.saveAndFlush(province);

        // Get all the provinceList where code in
        defaultProvinceFiltering("code.in=" + DEFAULT_CODE + "," + UPDATED_CODE, "code.in=" + UPDATED_CODE);
    }

    @Test
    @Transactional
    void getAllProvincesByCodeIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedProvince = provinceRepository.saveAndFlush(province);

        // Get all the provinceList where code is not null
        defaultProvinceFiltering("code.specified=true", "code.specified=false");
    }

    @Test
    @Transactional
    void getAllProvincesByCodeContainsSomething() throws Exception {
        // Initialize the database
        insertedProvince = provinceRepository.saveAndFlush(province);

        // Get all the provinceList where code contains
        defaultProvinceFiltering("code.contains=" + DEFAULT_CODE, "code.contains=" + UPDATED_CODE);
    }

    @Test
    @Transactional
    void getAllProvincesByCodeNotContainsSomething() throws Exception {
        // Initialize the database
        insertedProvince = provinceRepository.saveAndFlush(province);

        // Get all the provinceList where code does not contain
        defaultProvinceFiltering("code.doesNotContain=" + UPDATED_CODE, "code.doesNotContain=" + DEFAULT_CODE);
    }

    @Test
    @Transactional
    void getAllProvincesByNameIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedProvince = provinceRepository.saveAndFlush(province);

        // Get all the provinceList where name equals to
        defaultProvinceFiltering("name.equals=" + DEFAULT_NAME, "name.equals=" + UPDATED_NAME);
    }

    @Test
    @Transactional
    void getAllProvincesByNameIsInShouldWork() throws Exception {
        // Initialize the database
        insertedProvince = provinceRepository.saveAndFlush(province);

        // Get all the provinceList where name in
        defaultProvinceFiltering("name.in=" + DEFAULT_NAME + "," + UPDATED_NAME, "name.in=" + UPDATED_NAME);
    }

    @Test
    @Transactional
    void getAllProvincesByNameIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedProvince = provinceRepository.saveAndFlush(province);

        // Get all the provinceList where name is not null
        defaultProvinceFiltering("name.specified=true", "name.specified=false");
    }

    @Test
    @Transactional
    void getAllProvincesByNameContainsSomething() throws Exception {
        // Initialize the database
        insertedProvince = provinceRepository.saveAndFlush(province);

        // Get all the provinceList where name contains
        defaultProvinceFiltering("name.contains=" + DEFAULT_NAME, "name.contains=" + UPDATED_NAME);
    }

    @Test
    @Transactional
    void getAllProvincesByNameNotContainsSomething() throws Exception {
        // Initialize the database
        insertedProvince = provinceRepository.saveAndFlush(province);

        // Get all the provinceList where name does not contain
        defaultProvinceFiltering("name.doesNotContain=" + UPDATED_NAME, "name.doesNotContain=" + DEFAULT_NAME);
    }

    @Test
    @Transactional
    void getAllProvincesByNameEnIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedProvince = provinceRepository.saveAndFlush(province);

        // Get all the provinceList where nameEn equals to
        defaultProvinceFiltering("nameEn.equals=" + DEFAULT_NAME_EN, "nameEn.equals=" + UPDATED_NAME_EN);
    }

    @Test
    @Transactional
    void getAllProvincesByNameEnIsInShouldWork() throws Exception {
        // Initialize the database
        insertedProvince = provinceRepository.saveAndFlush(province);

        // Get all the provinceList where nameEn in
        defaultProvinceFiltering("nameEn.in=" + DEFAULT_NAME_EN + "," + UPDATED_NAME_EN, "nameEn.in=" + UPDATED_NAME_EN);
    }

    @Test
    @Transactional
    void getAllProvincesByNameEnIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedProvince = provinceRepository.saveAndFlush(province);

        // Get all the provinceList where nameEn is not null
        defaultProvinceFiltering("nameEn.specified=true", "nameEn.specified=false");
    }

    @Test
    @Transactional
    void getAllProvincesByNameEnContainsSomething() throws Exception {
        // Initialize the database
        insertedProvince = provinceRepository.saveAndFlush(province);

        // Get all the provinceList where nameEn contains
        defaultProvinceFiltering("nameEn.contains=" + DEFAULT_NAME_EN, "nameEn.contains=" + UPDATED_NAME_EN);
    }

    @Test
    @Transactional
    void getAllProvincesByNameEnNotContainsSomething() throws Exception {
        // Initialize the database
        insertedProvince = provinceRepository.saveAndFlush(province);

        // Get all the provinceList where nameEn does not contain
        defaultProvinceFiltering("nameEn.doesNotContain=" + UPDATED_NAME_EN, "nameEn.doesNotContain=" + DEFAULT_NAME_EN);
    }

    @Test
    @Transactional
    void getAllProvincesByRegionIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedProvince = provinceRepository.saveAndFlush(province);

        // Get all the provinceList where region equals to
        defaultProvinceFiltering("region.equals=" + DEFAULT_REGION, "region.equals=" + UPDATED_REGION);
    }

    @Test
    @Transactional
    void getAllProvincesByRegionIsInShouldWork() throws Exception {
        // Initialize the database
        insertedProvince = provinceRepository.saveAndFlush(province);

        // Get all the provinceList where region in
        defaultProvinceFiltering("region.in=" + DEFAULT_REGION + "," + UPDATED_REGION, "region.in=" + UPDATED_REGION);
    }

    @Test
    @Transactional
    void getAllProvincesByRegionIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedProvince = provinceRepository.saveAndFlush(province);

        // Get all the provinceList where region is not null
        defaultProvinceFiltering("region.specified=true", "region.specified=false");
    }

    @Test
    @Transactional
    void getAllProvincesByRegionContainsSomething() throws Exception {
        // Initialize the database
        insertedProvince = provinceRepository.saveAndFlush(province);

        // Get all the provinceList where region contains
        defaultProvinceFiltering("region.contains=" + DEFAULT_REGION, "region.contains=" + UPDATED_REGION);
    }

    @Test
    @Transactional
    void getAllProvincesByRegionNotContainsSomething() throws Exception {
        // Initialize the database
        insertedProvince = provinceRepository.saveAndFlush(province);

        // Get all the provinceList where region does not contain
        defaultProvinceFiltering("region.doesNotContain=" + UPDATED_REGION, "region.doesNotContain=" + DEFAULT_REGION);
    }

    private void defaultProvinceFiltering(String shouldBeFound, String shouldNotBeFound) throws Exception {
        defaultProvinceShouldBeFound(shouldBeFound);
        defaultProvinceShouldNotBeFound(shouldNotBeFound);
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultProvinceShouldBeFound(String filter) throws Exception {
        restProvinceMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(province.getId().intValue())))
            .andExpect(jsonPath("$.[*].code").value(hasItem(DEFAULT_CODE)))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
            .andExpect(jsonPath("$.[*].nameEn").value(hasItem(DEFAULT_NAME_EN)))
            .andExpect(jsonPath("$.[*].region").value(hasItem(DEFAULT_REGION)));

        // Check, that the count call also returns 1
        restProvinceMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("1"));
    }

    /**
     * Executes the search, and checks that the default entity is not returned.
     */
    private void defaultProvinceShouldNotBeFound(String filter) throws Exception {
        restProvinceMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());

        // Check, that the count call also returns 0
        restProvinceMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("0"));
    }

    @Test
    @Transactional
    void getNonExistingProvince() throws Exception {
        // Get the province
        restProvinceMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingProvince() throws Exception {
        // Initialize the database
        insertedProvince = provinceRepository.saveAndFlush(province);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the province
        Province updatedProvince = provinceRepository.findById(province.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedProvince are not directly saved in db
        em.detach(updatedProvince);
        updatedProvince.code(UPDATED_CODE).name(UPDATED_NAME).nameEn(UPDATED_NAME_EN).region(UPDATED_REGION);
        ProvinceDTO provinceDTO = provinceMapper.toDto(updatedProvince);

        restProvinceMockMvc
            .perform(
                put(ENTITY_API_URL_ID, provinceDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(provinceDTO))
            )
            .andExpect(status().isOk());

        // Validate the Province in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedProvinceToMatchAllProperties(updatedProvince);
    }

    @Test
    @Transactional
    void putNonExistingProvince() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        province.setId(longCount.incrementAndGet());

        // Create the Province
        ProvinceDTO provinceDTO = provinceMapper.toDto(province);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restProvinceMockMvc
            .perform(
                put(ENTITY_API_URL_ID, provinceDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(provinceDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Province in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchProvince() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        province.setId(longCount.incrementAndGet());

        // Create the Province
        ProvinceDTO provinceDTO = provinceMapper.toDto(province);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restProvinceMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(provinceDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Province in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamProvince() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        province.setId(longCount.incrementAndGet());

        // Create the Province
        ProvinceDTO provinceDTO = provinceMapper.toDto(province);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restProvinceMockMvc
            .perform(put(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(provinceDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Province in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateProvinceWithPatch() throws Exception {
        // Initialize the database
        insertedProvince = provinceRepository.saveAndFlush(province);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the province using partial update
        Province partialUpdatedProvince = new Province();
        partialUpdatedProvince.setId(province.getId());

        partialUpdatedProvince.code(UPDATED_CODE).region(UPDATED_REGION);

        restProvinceMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedProvince.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedProvince))
            )
            .andExpect(status().isOk());

        // Validate the Province in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertProvinceUpdatableFieldsEquals(createUpdateProxyForBean(partialUpdatedProvince, province), getPersistedProvince(province));
    }

    @Test
    @Transactional
    void fullUpdateProvinceWithPatch() throws Exception {
        // Initialize the database
        insertedProvince = provinceRepository.saveAndFlush(province);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the province using partial update
        Province partialUpdatedProvince = new Province();
        partialUpdatedProvince.setId(province.getId());

        partialUpdatedProvince.code(UPDATED_CODE).name(UPDATED_NAME).nameEn(UPDATED_NAME_EN).region(UPDATED_REGION);

        restProvinceMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedProvince.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedProvince))
            )
            .andExpect(status().isOk());

        // Validate the Province in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertProvinceUpdatableFieldsEquals(partialUpdatedProvince, getPersistedProvince(partialUpdatedProvince));
    }

    @Test
    @Transactional
    void patchNonExistingProvince() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        province.setId(longCount.incrementAndGet());

        // Create the Province
        ProvinceDTO provinceDTO = provinceMapper.toDto(province);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restProvinceMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, provinceDTO.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(provinceDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Province in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchProvince() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        province.setId(longCount.incrementAndGet());

        // Create the Province
        ProvinceDTO provinceDTO = provinceMapper.toDto(province);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restProvinceMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(provinceDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Province in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamProvince() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        province.setId(longCount.incrementAndGet());

        // Create the Province
        ProvinceDTO provinceDTO = provinceMapper.toDto(province);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restProvinceMockMvc
            .perform(
                patch(ENTITY_API_URL).with(csrf()).contentType("application/merge-patch+json").content(om.writeValueAsBytes(provinceDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the Province in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteProvince() throws Exception {
        // Initialize the database
        insertedProvince = provinceRepository.saveAndFlush(province);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the province
        restProvinceMockMvc
            .perform(delete(ENTITY_API_URL_ID, province.getId()).with(csrf()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return provinceRepository.count();
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

    protected Province getPersistedProvince(Province province) {
        return provinceRepository.findById(province.getId()).orElseThrow();
    }

    protected void assertPersistedProvinceToMatchAllProperties(Province expectedProvince) {
        assertProvinceAllPropertiesEquals(expectedProvince, getPersistedProvince(expectedProvince));
    }

    protected void assertPersistedProvinceToMatchUpdatableProperties(Province expectedProvince) {
        assertProvinceAllUpdatablePropertiesEquals(expectedProvince, getPersistedProvince(expectedProvince));
    }
}
