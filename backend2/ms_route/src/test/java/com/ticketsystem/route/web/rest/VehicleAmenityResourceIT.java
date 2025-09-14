package com.ticketsystem.route.web.rest;

import static com.ticketsystem.route.domain.VehicleAmenityAsserts.*;
import static com.ticketsystem.route.web.rest.TestUtil.createUpdateProxyForBean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketsystem.route.IntegrationTest;
import com.ticketsystem.route.domain.Vehicle;
import com.ticketsystem.route.domain.VehicleAmenity;
import com.ticketsystem.route.repository.VehicleAmenityRepository;
import com.ticketsystem.route.service.dto.VehicleAmenityDTO;
import com.ticketsystem.route.service.mapper.VehicleAmenityMapper;
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
 * Integration tests for the {@link VehicleAmenityResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class VehicleAmenityResourceIT {

    private static final String DEFAULT_AMENITY = "AAAAAAAAAA";
    private static final String UPDATED_AMENITY = "BBBBBBBBBB";

    private static final String DEFAULT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/vehicle-amenities";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private VehicleAmenityRepository vehicleAmenityRepository;

    @Autowired
    private VehicleAmenityMapper vehicleAmenityMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restVehicleAmenityMockMvc;

    private VehicleAmenity vehicleAmenity;

    private VehicleAmenity insertedVehicleAmenity;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static VehicleAmenity createEntity(EntityManager em) {
        VehicleAmenity vehicleAmenity = new VehicleAmenity().amenity(DEFAULT_AMENITY).description(DEFAULT_DESCRIPTION);
        // Add required entity
        Vehicle vehicle;
        if (TestUtil.findAll(em, Vehicle.class).isEmpty()) {
            vehicle = VehicleResourceIT.createEntity(em);
            em.persist(vehicle);
            em.flush();
        } else {
            vehicle = TestUtil.findAll(em, Vehicle.class).get(0);
        }
        vehicleAmenity.setVehicle(vehicle);
        return vehicleAmenity;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static VehicleAmenity createUpdatedEntity(EntityManager em) {
        VehicleAmenity updatedVehicleAmenity = new VehicleAmenity().amenity(UPDATED_AMENITY).description(UPDATED_DESCRIPTION);
        // Add required entity
        Vehicle vehicle;
        if (TestUtil.findAll(em, Vehicle.class).isEmpty()) {
            vehicle = VehicleResourceIT.createUpdatedEntity(em);
            em.persist(vehicle);
            em.flush();
        } else {
            vehicle = TestUtil.findAll(em, Vehicle.class).get(0);
        }
        updatedVehicleAmenity.setVehicle(vehicle);
        return updatedVehicleAmenity;
    }

    @BeforeEach
    void initTest() {
        vehicleAmenity = createEntity(em);
    }

    @AfterEach
    void cleanup() {
        if (insertedVehicleAmenity != null) {
            vehicleAmenityRepository.delete(insertedVehicleAmenity);
            insertedVehicleAmenity = null;
        }
    }

    @Test
    @Transactional
    void createVehicleAmenity() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the VehicleAmenity
        VehicleAmenityDTO vehicleAmenityDTO = vehicleAmenityMapper.toDto(vehicleAmenity);
        var returnedVehicleAmenityDTO = om.readValue(
            restVehicleAmenityMockMvc
                .perform(
                    post(ENTITY_API_URL)
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsBytes(vehicleAmenityDTO))
                )
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            VehicleAmenityDTO.class
        );

        // Validate the VehicleAmenity in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        var returnedVehicleAmenity = vehicleAmenityMapper.toEntity(returnedVehicleAmenityDTO);
        assertVehicleAmenityUpdatableFieldsEquals(returnedVehicleAmenity, getPersistedVehicleAmenity(returnedVehicleAmenity));

        insertedVehicleAmenity = returnedVehicleAmenity;
    }

    @Test
    @Transactional
    void createVehicleAmenityWithExistingId() throws Exception {
        // Create the VehicleAmenity with an existing ID
        vehicleAmenity.setId(1L);
        VehicleAmenityDTO vehicleAmenityDTO = vehicleAmenityMapper.toDto(vehicleAmenity);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restVehicleAmenityMockMvc
            .perform(
                post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(vehicleAmenityDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the VehicleAmenity in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkAmenityIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        vehicleAmenity.setAmenity(null);

        // Create the VehicleAmenity, which fails.
        VehicleAmenityDTO vehicleAmenityDTO = vehicleAmenityMapper.toDto(vehicleAmenity);

        restVehicleAmenityMockMvc
            .perform(
                post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(vehicleAmenityDTO))
            )
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllVehicleAmenities() throws Exception {
        // Initialize the database
        insertedVehicleAmenity = vehicleAmenityRepository.saveAndFlush(vehicleAmenity);

        // Get all the vehicleAmenityList
        restVehicleAmenityMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(vehicleAmenity.getId().intValue())))
            .andExpect(jsonPath("$.[*].amenity").value(hasItem(DEFAULT_AMENITY)))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION)));
    }

    @Test
    @Transactional
    void getVehicleAmenity() throws Exception {
        // Initialize the database
        insertedVehicleAmenity = vehicleAmenityRepository.saveAndFlush(vehicleAmenity);

        // Get the vehicleAmenity
        restVehicleAmenityMockMvc
            .perform(get(ENTITY_API_URL_ID, vehicleAmenity.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(vehicleAmenity.getId().intValue()))
            .andExpect(jsonPath("$.amenity").value(DEFAULT_AMENITY))
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION));
    }

    @Test
    @Transactional
    void getVehicleAmenitiesByIdFiltering() throws Exception {
        // Initialize the database
        insertedVehicleAmenity = vehicleAmenityRepository.saveAndFlush(vehicleAmenity);

        Long id = vehicleAmenity.getId();

        defaultVehicleAmenityFiltering("id.equals=" + id, "id.notEquals=" + id);

        defaultVehicleAmenityFiltering("id.greaterThanOrEqual=" + id, "id.greaterThan=" + id);

        defaultVehicleAmenityFiltering("id.lessThanOrEqual=" + id, "id.lessThan=" + id);
    }

    @Test
    @Transactional
    void getAllVehicleAmenitiesByAmenityIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedVehicleAmenity = vehicleAmenityRepository.saveAndFlush(vehicleAmenity);

        // Get all the vehicleAmenityList where amenity equals to
        defaultVehicleAmenityFiltering("amenity.equals=" + DEFAULT_AMENITY, "amenity.equals=" + UPDATED_AMENITY);
    }

    @Test
    @Transactional
    void getAllVehicleAmenitiesByAmenityIsInShouldWork() throws Exception {
        // Initialize the database
        insertedVehicleAmenity = vehicleAmenityRepository.saveAndFlush(vehicleAmenity);

        // Get all the vehicleAmenityList where amenity in
        defaultVehicleAmenityFiltering("amenity.in=" + DEFAULT_AMENITY + "," + UPDATED_AMENITY, "amenity.in=" + UPDATED_AMENITY);
    }

    @Test
    @Transactional
    void getAllVehicleAmenitiesByAmenityIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedVehicleAmenity = vehicleAmenityRepository.saveAndFlush(vehicleAmenity);

        // Get all the vehicleAmenityList where amenity is not null
        defaultVehicleAmenityFiltering("amenity.specified=true", "amenity.specified=false");
    }

    @Test
    @Transactional
    void getAllVehicleAmenitiesByAmenityContainsSomething() throws Exception {
        // Initialize the database
        insertedVehicleAmenity = vehicleAmenityRepository.saveAndFlush(vehicleAmenity);

        // Get all the vehicleAmenityList where amenity contains
        defaultVehicleAmenityFiltering("amenity.contains=" + DEFAULT_AMENITY, "amenity.contains=" + UPDATED_AMENITY);
    }

    @Test
    @Transactional
    void getAllVehicleAmenitiesByAmenityNotContainsSomething() throws Exception {
        // Initialize the database
        insertedVehicleAmenity = vehicleAmenityRepository.saveAndFlush(vehicleAmenity);

        // Get all the vehicleAmenityList where amenity does not contain
        defaultVehicleAmenityFiltering("amenity.doesNotContain=" + UPDATED_AMENITY, "amenity.doesNotContain=" + DEFAULT_AMENITY);
    }

    @Test
    @Transactional
    void getAllVehicleAmenitiesByDescriptionIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedVehicleAmenity = vehicleAmenityRepository.saveAndFlush(vehicleAmenity);

        // Get all the vehicleAmenityList where description equals to
        defaultVehicleAmenityFiltering("description.equals=" + DEFAULT_DESCRIPTION, "description.equals=" + UPDATED_DESCRIPTION);
    }

    @Test
    @Transactional
    void getAllVehicleAmenitiesByDescriptionIsInShouldWork() throws Exception {
        // Initialize the database
        insertedVehicleAmenity = vehicleAmenityRepository.saveAndFlush(vehicleAmenity);

        // Get all the vehicleAmenityList where description in
        defaultVehicleAmenityFiltering(
            "description.in=" + DEFAULT_DESCRIPTION + "," + UPDATED_DESCRIPTION,
            "description.in=" + UPDATED_DESCRIPTION
        );
    }

    @Test
    @Transactional
    void getAllVehicleAmenitiesByDescriptionIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedVehicleAmenity = vehicleAmenityRepository.saveAndFlush(vehicleAmenity);

        // Get all the vehicleAmenityList where description is not null
        defaultVehicleAmenityFiltering("description.specified=true", "description.specified=false");
    }

    @Test
    @Transactional
    void getAllVehicleAmenitiesByDescriptionContainsSomething() throws Exception {
        // Initialize the database
        insertedVehicleAmenity = vehicleAmenityRepository.saveAndFlush(vehicleAmenity);

        // Get all the vehicleAmenityList where description contains
        defaultVehicleAmenityFiltering("description.contains=" + DEFAULT_DESCRIPTION, "description.contains=" + UPDATED_DESCRIPTION);
    }

    @Test
    @Transactional
    void getAllVehicleAmenitiesByDescriptionNotContainsSomething() throws Exception {
        // Initialize the database
        insertedVehicleAmenity = vehicleAmenityRepository.saveAndFlush(vehicleAmenity);

        // Get all the vehicleAmenityList where description does not contain
        defaultVehicleAmenityFiltering(
            "description.doesNotContain=" + UPDATED_DESCRIPTION,
            "description.doesNotContain=" + DEFAULT_DESCRIPTION
        );
    }

    @Test
    @Transactional
    void getAllVehicleAmenitiesByVehicleIsEqualToSomething() throws Exception {
        Vehicle vehicle;
        if (TestUtil.findAll(em, Vehicle.class).isEmpty()) {
            vehicleAmenityRepository.saveAndFlush(vehicleAmenity);
            vehicle = VehicleResourceIT.createEntity(em);
        } else {
            vehicle = TestUtil.findAll(em, Vehicle.class).get(0);
        }
        em.persist(vehicle);
        em.flush();
        vehicleAmenity.setVehicle(vehicle);
        vehicleAmenityRepository.saveAndFlush(vehicleAmenity);
        Long vehicleId = vehicle.getId();
        // Get all the vehicleAmenityList where vehicle equals to vehicleId
        defaultVehicleAmenityShouldBeFound("vehicleId.equals=" + vehicleId);

        // Get all the vehicleAmenityList where vehicle equals to (vehicleId + 1)
        defaultVehicleAmenityShouldNotBeFound("vehicleId.equals=" + (vehicleId + 1));
    }

    private void defaultVehicleAmenityFiltering(String shouldBeFound, String shouldNotBeFound) throws Exception {
        defaultVehicleAmenityShouldBeFound(shouldBeFound);
        defaultVehicleAmenityShouldNotBeFound(shouldNotBeFound);
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultVehicleAmenityShouldBeFound(String filter) throws Exception {
        restVehicleAmenityMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(vehicleAmenity.getId().intValue())))
            .andExpect(jsonPath("$.[*].amenity").value(hasItem(DEFAULT_AMENITY)))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION)));

        // Check, that the count call also returns 1
        restVehicleAmenityMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("1"));
    }

    /**
     * Executes the search, and checks that the default entity is not returned.
     */
    private void defaultVehicleAmenityShouldNotBeFound(String filter) throws Exception {
        restVehicleAmenityMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());

        // Check, that the count call also returns 0
        restVehicleAmenityMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("0"));
    }

    @Test
    @Transactional
    void getNonExistingVehicleAmenity() throws Exception {
        // Get the vehicleAmenity
        restVehicleAmenityMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingVehicleAmenity() throws Exception {
        // Initialize the database
        insertedVehicleAmenity = vehicleAmenityRepository.saveAndFlush(vehicleAmenity);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the vehicleAmenity
        VehicleAmenity updatedVehicleAmenity = vehicleAmenityRepository.findById(vehicleAmenity.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedVehicleAmenity are not directly saved in db
        em.detach(updatedVehicleAmenity);
        updatedVehicleAmenity.amenity(UPDATED_AMENITY).description(UPDATED_DESCRIPTION);
        VehicleAmenityDTO vehicleAmenityDTO = vehicleAmenityMapper.toDto(updatedVehicleAmenity);

        restVehicleAmenityMockMvc
            .perform(
                put(ENTITY_API_URL_ID, vehicleAmenityDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(vehicleAmenityDTO))
            )
            .andExpect(status().isOk());

        // Validate the VehicleAmenity in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedVehicleAmenityToMatchAllProperties(updatedVehicleAmenity);
    }

    @Test
    @Transactional
    void putNonExistingVehicleAmenity() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        vehicleAmenity.setId(longCount.incrementAndGet());

        // Create the VehicleAmenity
        VehicleAmenityDTO vehicleAmenityDTO = vehicleAmenityMapper.toDto(vehicleAmenity);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restVehicleAmenityMockMvc
            .perform(
                put(ENTITY_API_URL_ID, vehicleAmenityDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(vehicleAmenityDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the VehicleAmenity in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchVehicleAmenity() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        vehicleAmenity.setId(longCount.incrementAndGet());

        // Create the VehicleAmenity
        VehicleAmenityDTO vehicleAmenityDTO = vehicleAmenityMapper.toDto(vehicleAmenity);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restVehicleAmenityMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(vehicleAmenityDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the VehicleAmenity in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamVehicleAmenity() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        vehicleAmenity.setId(longCount.incrementAndGet());

        // Create the VehicleAmenity
        VehicleAmenityDTO vehicleAmenityDTO = vehicleAmenityMapper.toDto(vehicleAmenity);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restVehicleAmenityMockMvc
            .perform(
                put(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(vehicleAmenityDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the VehicleAmenity in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateVehicleAmenityWithPatch() throws Exception {
        // Initialize the database
        insertedVehicleAmenity = vehicleAmenityRepository.saveAndFlush(vehicleAmenity);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the vehicleAmenity using partial update
        VehicleAmenity partialUpdatedVehicleAmenity = new VehicleAmenity();
        partialUpdatedVehicleAmenity.setId(vehicleAmenity.getId());

        restVehicleAmenityMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedVehicleAmenity.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedVehicleAmenity))
            )
            .andExpect(status().isOk());

        // Validate the VehicleAmenity in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertVehicleAmenityUpdatableFieldsEquals(
            createUpdateProxyForBean(partialUpdatedVehicleAmenity, vehicleAmenity),
            getPersistedVehicleAmenity(vehicleAmenity)
        );
    }

    @Test
    @Transactional
    void fullUpdateVehicleAmenityWithPatch() throws Exception {
        // Initialize the database
        insertedVehicleAmenity = vehicleAmenityRepository.saveAndFlush(vehicleAmenity);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the vehicleAmenity using partial update
        VehicleAmenity partialUpdatedVehicleAmenity = new VehicleAmenity();
        partialUpdatedVehicleAmenity.setId(vehicleAmenity.getId());

        partialUpdatedVehicleAmenity.amenity(UPDATED_AMENITY).description(UPDATED_DESCRIPTION);

        restVehicleAmenityMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedVehicleAmenity.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedVehicleAmenity))
            )
            .andExpect(status().isOk());

        // Validate the VehicleAmenity in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertVehicleAmenityUpdatableFieldsEquals(partialUpdatedVehicleAmenity, getPersistedVehicleAmenity(partialUpdatedVehicleAmenity));
    }

    @Test
    @Transactional
    void patchNonExistingVehicleAmenity() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        vehicleAmenity.setId(longCount.incrementAndGet());

        // Create the VehicleAmenity
        VehicleAmenityDTO vehicleAmenityDTO = vehicleAmenityMapper.toDto(vehicleAmenity);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restVehicleAmenityMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, vehicleAmenityDTO.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(vehicleAmenityDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the VehicleAmenity in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchVehicleAmenity() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        vehicleAmenity.setId(longCount.incrementAndGet());

        // Create the VehicleAmenity
        VehicleAmenityDTO vehicleAmenityDTO = vehicleAmenityMapper.toDto(vehicleAmenity);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restVehicleAmenityMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(vehicleAmenityDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the VehicleAmenity in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamVehicleAmenity() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        vehicleAmenity.setId(longCount.incrementAndGet());

        // Create the VehicleAmenity
        VehicleAmenityDTO vehicleAmenityDTO = vehicleAmenityMapper.toDto(vehicleAmenity);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restVehicleAmenityMockMvc
            .perform(
                patch(ENTITY_API_URL)
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(vehicleAmenityDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the VehicleAmenity in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteVehicleAmenity() throws Exception {
        // Initialize the database
        insertedVehicleAmenity = vehicleAmenityRepository.saveAndFlush(vehicleAmenity);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the vehicleAmenity
        restVehicleAmenityMockMvc
            .perform(delete(ENTITY_API_URL_ID, vehicleAmenity.getId()).with(csrf()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return vehicleAmenityRepository.count();
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

    protected VehicleAmenity getPersistedVehicleAmenity(VehicleAmenity vehicleAmenity) {
        return vehicleAmenityRepository.findById(vehicleAmenity.getId()).orElseThrow();
    }

    protected void assertPersistedVehicleAmenityToMatchAllProperties(VehicleAmenity expectedVehicleAmenity) {
        assertVehicleAmenityAllPropertiesEquals(expectedVehicleAmenity, getPersistedVehicleAmenity(expectedVehicleAmenity));
    }

    protected void assertPersistedVehicleAmenityToMatchUpdatableProperties(VehicleAmenity expectedVehicleAmenity) {
        assertVehicleAmenityAllUpdatablePropertiesEquals(expectedVehicleAmenity, getPersistedVehicleAmenity(expectedVehicleAmenity));
    }
}
