package com.ticketsystem.route.web.rest;

import static com.ticketsystem.route.domain.VehicleImageAsserts.*;
import static com.ticketsystem.route.web.rest.TestUtil.createUpdateProxyForBean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketsystem.route.IntegrationTest;
import com.ticketsystem.route.domain.Vehicle;
import com.ticketsystem.route.domain.VehicleImage;
import com.ticketsystem.route.repository.VehicleImageRepository;
import com.ticketsystem.route.service.dto.VehicleImageDTO;
import com.ticketsystem.route.service.mapper.VehicleImageMapper;
import jakarta.persistence.EntityManager;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
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
 * Integration tests for the {@link VehicleImageResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class VehicleImageResourceIT {

    private static final String DEFAULT_IMAGE_URL = "AAAAAAAAAA";
    private static final String UPDATED_IMAGE_URL = "BBBBBBBBBB";

    private static final String DEFAULT_IMAGE_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_IMAGE_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBBBBBBB";

    private static final Boolean DEFAULT_IS_PRIMARY = false;
    private static final Boolean UPDATED_IS_PRIMARY = true;

    private static final Instant DEFAULT_UPLOADED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_UPLOADED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String ENTITY_API_URL = "/api/vehicle-images";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private VehicleImageRepository vehicleImageRepository;

    @Autowired
    private VehicleImageMapper vehicleImageMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restVehicleImageMockMvc;

    private VehicleImage vehicleImage;

    private VehicleImage insertedVehicleImage;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static VehicleImage createEntity(EntityManager em) {
        VehicleImage vehicleImage = new VehicleImage()
            .imageUrl(DEFAULT_IMAGE_URL)
            .imageType(DEFAULT_IMAGE_TYPE)
            .description(DEFAULT_DESCRIPTION)
            .isPrimary(DEFAULT_IS_PRIMARY)
            .uploadedAt(DEFAULT_UPLOADED_AT);
        // Add required entity
        Vehicle vehicle;
        if (TestUtil.findAll(em, Vehicle.class).isEmpty()) {
            vehicle = VehicleResourceIT.createEntity(em);
            em.persist(vehicle);
            em.flush();
        } else {
            vehicle = TestUtil.findAll(em, Vehicle.class).get(0);
        }
        vehicleImage.setVehicle(vehicle);
        return vehicleImage;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static VehicleImage createUpdatedEntity(EntityManager em) {
        VehicleImage updatedVehicleImage = new VehicleImage()
            .imageUrl(UPDATED_IMAGE_URL)
            .imageType(UPDATED_IMAGE_TYPE)
            .description(UPDATED_DESCRIPTION)
            .isPrimary(UPDATED_IS_PRIMARY)
            .uploadedAt(UPDATED_UPLOADED_AT);
        // Add required entity
        Vehicle vehicle;
        if (TestUtil.findAll(em, Vehicle.class).isEmpty()) {
            vehicle = VehicleResourceIT.createUpdatedEntity(em);
            em.persist(vehicle);
            em.flush();
        } else {
            vehicle = TestUtil.findAll(em, Vehicle.class).get(0);
        }
        updatedVehicleImage.setVehicle(vehicle);
        return updatedVehicleImage;
    }

    @BeforeEach
    void initTest() {
        vehicleImage = createEntity(em);
    }

    @AfterEach
    void cleanup() {
        if (insertedVehicleImage != null) {
            vehicleImageRepository.delete(insertedVehicleImage);
            insertedVehicleImage = null;
        }
    }

    @Test
    @Transactional
    void createVehicleImage() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the VehicleImage
        VehicleImageDTO vehicleImageDTO = vehicleImageMapper.toDto(vehicleImage);
        var returnedVehicleImageDTO = om.readValue(
            restVehicleImageMockMvc
                .perform(
                    post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(vehicleImageDTO))
                )
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            VehicleImageDTO.class
        );

        // Validate the VehicleImage in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        var returnedVehicleImage = vehicleImageMapper.toEntity(returnedVehicleImageDTO);
        assertVehicleImageUpdatableFieldsEquals(returnedVehicleImage, getPersistedVehicleImage(returnedVehicleImage));

        insertedVehicleImage = returnedVehicleImage;
    }

    @Test
    @Transactional
    void createVehicleImageWithExistingId() throws Exception {
        // Create the VehicleImage with an existing ID
        vehicleImage.setId(1L);
        VehicleImageDTO vehicleImageDTO = vehicleImageMapper.toDto(vehicleImage);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restVehicleImageMockMvc
            .perform(
                post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(vehicleImageDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the VehicleImage in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkImageUrlIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        vehicleImage.setImageUrl(null);

        // Create the VehicleImage, which fails.
        VehicleImageDTO vehicleImageDTO = vehicleImageMapper.toDto(vehicleImage);

        restVehicleImageMockMvc
            .perform(
                post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(vehicleImageDTO))
            )
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkImageTypeIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        vehicleImage.setImageType(null);

        // Create the VehicleImage, which fails.
        VehicleImageDTO vehicleImageDTO = vehicleImageMapper.toDto(vehicleImage);

        restVehicleImageMockMvc
            .perform(
                post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(vehicleImageDTO))
            )
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkUploadedAtIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        vehicleImage.setUploadedAt(null);

        // Create the VehicleImage, which fails.
        VehicleImageDTO vehicleImageDTO = vehicleImageMapper.toDto(vehicleImage);

        restVehicleImageMockMvc
            .perform(
                post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(vehicleImageDTO))
            )
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllVehicleImages() throws Exception {
        // Initialize the database
        insertedVehicleImage = vehicleImageRepository.saveAndFlush(vehicleImage);

        // Get all the vehicleImageList
        restVehicleImageMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(vehicleImage.getId().intValue())))
            .andExpect(jsonPath("$.[*].imageUrl").value(hasItem(DEFAULT_IMAGE_URL)))
            .andExpect(jsonPath("$.[*].imageType").value(hasItem(DEFAULT_IMAGE_TYPE)))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION)))
            .andExpect(jsonPath("$.[*].isPrimary").value(hasItem(DEFAULT_IS_PRIMARY)))
            .andExpect(jsonPath("$.[*].uploadedAt").value(hasItem(DEFAULT_UPLOADED_AT.toString())));
    }

    @Test
    @Transactional
    void getVehicleImage() throws Exception {
        // Initialize the database
        insertedVehicleImage = vehicleImageRepository.saveAndFlush(vehicleImage);

        // Get the vehicleImage
        restVehicleImageMockMvc
            .perform(get(ENTITY_API_URL_ID, vehicleImage.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(vehicleImage.getId().intValue()))
            .andExpect(jsonPath("$.imageUrl").value(DEFAULT_IMAGE_URL))
            .andExpect(jsonPath("$.imageType").value(DEFAULT_IMAGE_TYPE))
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION))
            .andExpect(jsonPath("$.isPrimary").value(DEFAULT_IS_PRIMARY))
            .andExpect(jsonPath("$.uploadedAt").value(DEFAULT_UPLOADED_AT.toString()));
    }

    @Test
    @Transactional
    void getVehicleImagesByIdFiltering() throws Exception {
        // Initialize the database
        insertedVehicleImage = vehicleImageRepository.saveAndFlush(vehicleImage);

        Long id = vehicleImage.getId();

        defaultVehicleImageFiltering("id.equals=" + id, "id.notEquals=" + id);

        defaultVehicleImageFiltering("id.greaterThanOrEqual=" + id, "id.greaterThan=" + id);

        defaultVehicleImageFiltering("id.lessThanOrEqual=" + id, "id.lessThan=" + id);
    }

    @Test
    @Transactional
    void getAllVehicleImagesByImageUrlIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedVehicleImage = vehicleImageRepository.saveAndFlush(vehicleImage);

        // Get all the vehicleImageList where imageUrl equals to
        defaultVehicleImageFiltering("imageUrl.equals=" + DEFAULT_IMAGE_URL, "imageUrl.equals=" + UPDATED_IMAGE_URL);
    }

    @Test
    @Transactional
    void getAllVehicleImagesByImageUrlIsInShouldWork() throws Exception {
        // Initialize the database
        insertedVehicleImage = vehicleImageRepository.saveAndFlush(vehicleImage);

        // Get all the vehicleImageList where imageUrl in
        defaultVehicleImageFiltering("imageUrl.in=" + DEFAULT_IMAGE_URL + "," + UPDATED_IMAGE_URL, "imageUrl.in=" + UPDATED_IMAGE_URL);
    }

    @Test
    @Transactional
    void getAllVehicleImagesByImageUrlIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedVehicleImage = vehicleImageRepository.saveAndFlush(vehicleImage);

        // Get all the vehicleImageList where imageUrl is not null
        defaultVehicleImageFiltering("imageUrl.specified=true", "imageUrl.specified=false");
    }

    @Test
    @Transactional
    void getAllVehicleImagesByImageUrlContainsSomething() throws Exception {
        // Initialize the database
        insertedVehicleImage = vehicleImageRepository.saveAndFlush(vehicleImage);

        // Get all the vehicleImageList where imageUrl contains
        defaultVehicleImageFiltering("imageUrl.contains=" + DEFAULT_IMAGE_URL, "imageUrl.contains=" + UPDATED_IMAGE_URL);
    }

    @Test
    @Transactional
    void getAllVehicleImagesByImageUrlNotContainsSomething() throws Exception {
        // Initialize the database
        insertedVehicleImage = vehicleImageRepository.saveAndFlush(vehicleImage);

        // Get all the vehicleImageList where imageUrl does not contain
        defaultVehicleImageFiltering("imageUrl.doesNotContain=" + UPDATED_IMAGE_URL, "imageUrl.doesNotContain=" + DEFAULT_IMAGE_URL);
    }

    @Test
    @Transactional
    void getAllVehicleImagesByImageTypeIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedVehicleImage = vehicleImageRepository.saveAndFlush(vehicleImage);

        // Get all the vehicleImageList where imageType equals to
        defaultVehicleImageFiltering("imageType.equals=" + DEFAULT_IMAGE_TYPE, "imageType.equals=" + UPDATED_IMAGE_TYPE);
    }

    @Test
    @Transactional
    void getAllVehicleImagesByImageTypeIsInShouldWork() throws Exception {
        // Initialize the database
        insertedVehicleImage = vehicleImageRepository.saveAndFlush(vehicleImage);

        // Get all the vehicleImageList where imageType in
        defaultVehicleImageFiltering("imageType.in=" + DEFAULT_IMAGE_TYPE + "," + UPDATED_IMAGE_TYPE, "imageType.in=" + UPDATED_IMAGE_TYPE);
    }

    @Test
    @Transactional
    void getAllVehicleImagesByImageTypeIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedVehicleImage = vehicleImageRepository.saveAndFlush(vehicleImage);

        // Get all the vehicleImageList where imageType is not null
        defaultVehicleImageFiltering("imageType.specified=true", "imageType.specified=false");
    }

    @Test
    @Transactional
    void getAllVehicleImagesByImageTypeContainsSomething() throws Exception {
        // Initialize the database
        insertedVehicleImage = vehicleImageRepository.saveAndFlush(vehicleImage);

        // Get all the vehicleImageList where imageType contains
        defaultVehicleImageFiltering("imageType.contains=" + DEFAULT_IMAGE_TYPE, "imageType.contains=" + UPDATED_IMAGE_TYPE);
    }

    @Test
    @Transactional
    void getAllVehicleImagesByImageTypeNotContainsSomething() throws Exception {
        // Initialize the database
        insertedVehicleImage = vehicleImageRepository.saveAndFlush(vehicleImage);

        // Get all the vehicleImageList where imageType does not contain
        defaultVehicleImageFiltering("imageType.doesNotContain=" + UPDATED_IMAGE_TYPE, "imageType.doesNotContain=" + DEFAULT_IMAGE_TYPE);
    }

    @Test
    @Transactional
    void getAllVehicleImagesByDescriptionIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedVehicleImage = vehicleImageRepository.saveAndFlush(vehicleImage);

        // Get all the vehicleImageList where description equals to
        defaultVehicleImageFiltering("description.equals=" + DEFAULT_DESCRIPTION, "description.equals=" + UPDATED_DESCRIPTION);
    }

    @Test
    @Transactional
    void getAllVehicleImagesByDescriptionIsInShouldWork() throws Exception {
        // Initialize the database
        insertedVehicleImage = vehicleImageRepository.saveAndFlush(vehicleImage);

        // Get all the vehicleImageList where description in
        defaultVehicleImageFiltering(
            "description.in=" + DEFAULT_DESCRIPTION + "," + UPDATED_DESCRIPTION,
            "description.in=" + UPDATED_DESCRIPTION
        );
    }

    @Test
    @Transactional
    void getAllVehicleImagesByDescriptionIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedVehicleImage = vehicleImageRepository.saveAndFlush(vehicleImage);

        // Get all the vehicleImageList where description is not null
        defaultVehicleImageFiltering("description.specified=true", "description.specified=false");
    }

    @Test
    @Transactional
    void getAllVehicleImagesByDescriptionContainsSomething() throws Exception {
        // Initialize the database
        insertedVehicleImage = vehicleImageRepository.saveAndFlush(vehicleImage);

        // Get all the vehicleImageList where description contains
        defaultVehicleImageFiltering("description.contains=" + DEFAULT_DESCRIPTION, "description.contains=" + UPDATED_DESCRIPTION);
    }

    @Test
    @Transactional
    void getAllVehicleImagesByDescriptionNotContainsSomething() throws Exception {
        // Initialize the database
        insertedVehicleImage = vehicleImageRepository.saveAndFlush(vehicleImage);

        // Get all the vehicleImageList where description does not contain
        defaultVehicleImageFiltering(
            "description.doesNotContain=" + UPDATED_DESCRIPTION,
            "description.doesNotContain=" + DEFAULT_DESCRIPTION
        );
    }

    @Test
    @Transactional
    void getAllVehicleImagesByIsPrimaryIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedVehicleImage = vehicleImageRepository.saveAndFlush(vehicleImage);

        // Get all the vehicleImageList where isPrimary equals to
        defaultVehicleImageFiltering("isPrimary.equals=" + DEFAULT_IS_PRIMARY, "isPrimary.equals=" + UPDATED_IS_PRIMARY);
    }

    @Test
    @Transactional
    void getAllVehicleImagesByIsPrimaryIsInShouldWork() throws Exception {
        // Initialize the database
        insertedVehicleImage = vehicleImageRepository.saveAndFlush(vehicleImage);

        // Get all the vehicleImageList where isPrimary in
        defaultVehicleImageFiltering("isPrimary.in=" + DEFAULT_IS_PRIMARY + "," + UPDATED_IS_PRIMARY, "isPrimary.in=" + UPDATED_IS_PRIMARY);
    }

    @Test
    @Transactional
    void getAllVehicleImagesByIsPrimaryIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedVehicleImage = vehicleImageRepository.saveAndFlush(vehicleImage);

        // Get all the vehicleImageList where isPrimary is not null
        defaultVehicleImageFiltering("isPrimary.specified=true", "isPrimary.specified=false");
    }

    @Test
    @Transactional
    void getAllVehicleImagesByUploadedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedVehicleImage = vehicleImageRepository.saveAndFlush(vehicleImage);

        // Get all the vehicleImageList where uploadedAt equals to
        defaultVehicleImageFiltering("uploadedAt.equals=" + DEFAULT_UPLOADED_AT, "uploadedAt.equals=" + UPDATED_UPLOADED_AT);
    }

    @Test
    @Transactional
    void getAllVehicleImagesByUploadedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedVehicleImage = vehicleImageRepository.saveAndFlush(vehicleImage);

        // Get all the vehicleImageList where uploadedAt in
        defaultVehicleImageFiltering(
            "uploadedAt.in=" + DEFAULT_UPLOADED_AT + "," + UPDATED_UPLOADED_AT,
            "uploadedAt.in=" + UPDATED_UPLOADED_AT
        );
    }

    @Test
    @Transactional
    void getAllVehicleImagesByUploadedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedVehicleImage = vehicleImageRepository.saveAndFlush(vehicleImage);

        // Get all the vehicleImageList where uploadedAt is not null
        defaultVehicleImageFiltering("uploadedAt.specified=true", "uploadedAt.specified=false");
    }

    @Test
    @Transactional
    void getAllVehicleImagesByVehicleIsEqualToSomething() throws Exception {
        Vehicle vehicle;
        if (TestUtil.findAll(em, Vehicle.class).isEmpty()) {
            vehicleImageRepository.saveAndFlush(vehicleImage);
            vehicle = VehicleResourceIT.createEntity(em);
        } else {
            vehicle = TestUtil.findAll(em, Vehicle.class).get(0);
        }
        em.persist(vehicle);
        em.flush();
        vehicleImage.setVehicle(vehicle);
        vehicleImageRepository.saveAndFlush(vehicleImage);
        Long vehicleId = vehicle.getId();
        // Get all the vehicleImageList where vehicle equals to vehicleId
        defaultVehicleImageShouldBeFound("vehicleId.equals=" + vehicleId);

        // Get all the vehicleImageList where vehicle equals to (vehicleId + 1)
        defaultVehicleImageShouldNotBeFound("vehicleId.equals=" + (vehicleId + 1));
    }

    private void defaultVehicleImageFiltering(String shouldBeFound, String shouldNotBeFound) throws Exception {
        defaultVehicleImageShouldBeFound(shouldBeFound);
        defaultVehicleImageShouldNotBeFound(shouldNotBeFound);
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultVehicleImageShouldBeFound(String filter) throws Exception {
        restVehicleImageMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(vehicleImage.getId().intValue())))
            .andExpect(jsonPath("$.[*].imageUrl").value(hasItem(DEFAULT_IMAGE_URL)))
            .andExpect(jsonPath("$.[*].imageType").value(hasItem(DEFAULT_IMAGE_TYPE)))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION)))
            .andExpect(jsonPath("$.[*].isPrimary").value(hasItem(DEFAULT_IS_PRIMARY)))
            .andExpect(jsonPath("$.[*].uploadedAt").value(hasItem(DEFAULT_UPLOADED_AT.toString())));

        // Check, that the count call also returns 1
        restVehicleImageMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("1"));
    }

    /**
     * Executes the search, and checks that the default entity is not returned.
     */
    private void defaultVehicleImageShouldNotBeFound(String filter) throws Exception {
        restVehicleImageMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());

        // Check, that the count call also returns 0
        restVehicleImageMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("0"));
    }

    @Test
    @Transactional
    void getNonExistingVehicleImage() throws Exception {
        // Get the vehicleImage
        restVehicleImageMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingVehicleImage() throws Exception {
        // Initialize the database
        insertedVehicleImage = vehicleImageRepository.saveAndFlush(vehicleImage);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the vehicleImage
        VehicleImage updatedVehicleImage = vehicleImageRepository.findById(vehicleImage.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedVehicleImage are not directly saved in db
        em.detach(updatedVehicleImage);
        updatedVehicleImage
            .imageUrl(UPDATED_IMAGE_URL)
            .imageType(UPDATED_IMAGE_TYPE)
            .description(UPDATED_DESCRIPTION)
            .isPrimary(UPDATED_IS_PRIMARY)
            .uploadedAt(UPDATED_UPLOADED_AT);
        VehicleImageDTO vehicleImageDTO = vehicleImageMapper.toDto(updatedVehicleImage);

        restVehicleImageMockMvc
            .perform(
                put(ENTITY_API_URL_ID, vehicleImageDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(vehicleImageDTO))
            )
            .andExpect(status().isOk());

        // Validate the VehicleImage in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedVehicleImageToMatchAllProperties(updatedVehicleImage);
    }

    @Test
    @Transactional
    void putNonExistingVehicleImage() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        vehicleImage.setId(longCount.incrementAndGet());

        // Create the VehicleImage
        VehicleImageDTO vehicleImageDTO = vehicleImageMapper.toDto(vehicleImage);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restVehicleImageMockMvc
            .perform(
                put(ENTITY_API_URL_ID, vehicleImageDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(vehicleImageDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the VehicleImage in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchVehicleImage() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        vehicleImage.setId(longCount.incrementAndGet());

        // Create the VehicleImage
        VehicleImageDTO vehicleImageDTO = vehicleImageMapper.toDto(vehicleImage);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restVehicleImageMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(vehicleImageDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the VehicleImage in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamVehicleImage() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        vehicleImage.setId(longCount.incrementAndGet());

        // Create the VehicleImage
        VehicleImageDTO vehicleImageDTO = vehicleImageMapper.toDto(vehicleImage);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restVehicleImageMockMvc
            .perform(
                put(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(vehicleImageDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the VehicleImage in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateVehicleImageWithPatch() throws Exception {
        // Initialize the database
        insertedVehicleImage = vehicleImageRepository.saveAndFlush(vehicleImage);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the vehicleImage using partial update
        VehicleImage partialUpdatedVehicleImage = new VehicleImage();
        partialUpdatedVehicleImage.setId(vehicleImage.getId());

        partialUpdatedVehicleImage.imageUrl(UPDATED_IMAGE_URL).description(UPDATED_DESCRIPTION);

        restVehicleImageMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedVehicleImage.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedVehicleImage))
            )
            .andExpect(status().isOk());

        // Validate the VehicleImage in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertVehicleImageUpdatableFieldsEquals(
            createUpdateProxyForBean(partialUpdatedVehicleImage, vehicleImage),
            getPersistedVehicleImage(vehicleImage)
        );
    }

    @Test
    @Transactional
    void fullUpdateVehicleImageWithPatch() throws Exception {
        // Initialize the database
        insertedVehicleImage = vehicleImageRepository.saveAndFlush(vehicleImage);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the vehicleImage using partial update
        VehicleImage partialUpdatedVehicleImage = new VehicleImage();
        partialUpdatedVehicleImage.setId(vehicleImage.getId());

        partialUpdatedVehicleImage
            .imageUrl(UPDATED_IMAGE_URL)
            .imageType(UPDATED_IMAGE_TYPE)
            .description(UPDATED_DESCRIPTION)
            .isPrimary(UPDATED_IS_PRIMARY)
            .uploadedAt(UPDATED_UPLOADED_AT);

        restVehicleImageMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedVehicleImage.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedVehicleImage))
            )
            .andExpect(status().isOk());

        // Validate the VehicleImage in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertVehicleImageUpdatableFieldsEquals(partialUpdatedVehicleImage, getPersistedVehicleImage(partialUpdatedVehicleImage));
    }

    @Test
    @Transactional
    void patchNonExistingVehicleImage() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        vehicleImage.setId(longCount.incrementAndGet());

        // Create the VehicleImage
        VehicleImageDTO vehicleImageDTO = vehicleImageMapper.toDto(vehicleImage);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restVehicleImageMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, vehicleImageDTO.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(vehicleImageDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the VehicleImage in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchVehicleImage() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        vehicleImage.setId(longCount.incrementAndGet());

        // Create the VehicleImage
        VehicleImageDTO vehicleImageDTO = vehicleImageMapper.toDto(vehicleImage);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restVehicleImageMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(vehicleImageDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the VehicleImage in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamVehicleImage() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        vehicleImage.setId(longCount.incrementAndGet());

        // Create the VehicleImage
        VehicleImageDTO vehicleImageDTO = vehicleImageMapper.toDto(vehicleImage);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restVehicleImageMockMvc
            .perform(
                patch(ENTITY_API_URL)
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(vehicleImageDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the VehicleImage in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteVehicleImage() throws Exception {
        // Initialize the database
        insertedVehicleImage = vehicleImageRepository.saveAndFlush(vehicleImage);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the vehicleImage
        restVehicleImageMockMvc
            .perform(delete(ENTITY_API_URL_ID, vehicleImage.getId()).with(csrf()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return vehicleImageRepository.count();
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

    protected VehicleImage getPersistedVehicleImage(VehicleImage vehicleImage) {
        return vehicleImageRepository.findById(vehicleImage.getId()).orElseThrow();
    }

    protected void assertPersistedVehicleImageToMatchAllProperties(VehicleImage expectedVehicleImage) {
        assertVehicleImageAllPropertiesEquals(expectedVehicleImage, getPersistedVehicleImage(expectedVehicleImage));
    }

    protected void assertPersistedVehicleImageToMatchUpdatableProperties(VehicleImage expectedVehicleImage) {
        assertVehicleImageAllUpdatablePropertiesEquals(expectedVehicleImage, getPersistedVehicleImage(expectedVehicleImage));
    }
}
