package com.ticketsystem.route.web.rest;

import static com.ticketsystem.route.domain.AddressAsserts.*;
import static com.ticketsystem.route.web.rest.TestUtil.createUpdateProxyForBean;
import static com.ticketsystem.route.web.rest.TestUtil.sameNumber;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketsystem.route.IntegrationTest;
import com.ticketsystem.route.domain.Address;
import com.ticketsystem.route.domain.Ward;
import com.ticketsystem.route.repository.AddressRepository;
import com.ticketsystem.route.service.dto.AddressDTO;
import com.ticketsystem.route.service.mapper.AddressMapper;
import jakarta.persistence.EntityManager;
import java.math.BigDecimal;
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
 * Integration tests for the {@link AddressResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class AddressResourceIT {

    private static final String DEFAULT_WARD_CODE = "AAAAAAAAAA";
    private static final String UPDATED_WARD_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_STREET_ADDRESS = "AAAAAAAAAA";
    private static final String UPDATED_STREET_ADDRESS = "BBBBBBBBBB";

    private static final String DEFAULT_POSTAL_CODE = "AAAAAAAAAA";
    private static final String UPDATED_POSTAL_CODE = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_LATITUDE = new BigDecimal(1);
    private static final BigDecimal UPDATED_LATITUDE = new BigDecimal(2);
    private static final BigDecimal SMALLER_LATITUDE = new BigDecimal(1 - 1);

    private static final BigDecimal DEFAULT_LONGITUDE = new BigDecimal(1);
    private static final BigDecimal UPDATED_LONGITUDE = new BigDecimal(2);
    private static final BigDecimal SMALLER_LONGITUDE = new BigDecimal(1 - 1);

    private static final String DEFAULT_LANDMARK = "AAAAAAAAAA";
    private static final String UPDATED_LANDMARK = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/addresses";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restAddressMockMvc;

    private Address address;

    private Address insertedAddress;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Address createEntity(EntityManager em) {
        Address address = new Address()
            .wardCode(DEFAULT_WARD_CODE)
            .streetAddress(DEFAULT_STREET_ADDRESS)
            .postalCode(DEFAULT_POSTAL_CODE)
            .latitude(DEFAULT_LATITUDE)
            .longitude(DEFAULT_LONGITUDE)
            .landmark(DEFAULT_LANDMARK);
        // Add required entity
        Ward ward;
        if (TestUtil.findAll(em, Ward.class).isEmpty()) {
            ward = WardResourceIT.createEntity(em);
            em.persist(ward);
            em.flush();
        } else {
            ward = TestUtil.findAll(em, Ward.class).get(0);
        }
        address.setWard(ward);
        return address;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Address createUpdatedEntity(EntityManager em) {
        Address updatedAddress = new Address()
            .wardCode(UPDATED_WARD_CODE)
            .streetAddress(UPDATED_STREET_ADDRESS)
            .postalCode(UPDATED_POSTAL_CODE)
            .latitude(UPDATED_LATITUDE)
            .longitude(UPDATED_LONGITUDE)
            .landmark(UPDATED_LANDMARK);
        // Add required entity
        Ward ward;
        if (TestUtil.findAll(em, Ward.class).isEmpty()) {
            ward = WardResourceIT.createUpdatedEntity(em);
            em.persist(ward);
            em.flush();
        } else {
            ward = TestUtil.findAll(em, Ward.class).get(0);
        }
        updatedAddress.setWard(ward);
        return updatedAddress;
    }

    @BeforeEach
    void initTest() {
        address = createEntity(em);
    }

    @AfterEach
    void cleanup() {
        if (insertedAddress != null) {
            addressRepository.delete(insertedAddress);
            insertedAddress = null;
        }
    }

    @Test
    @Transactional
    void createAddress() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the Address
        AddressDTO addressDTO = addressMapper.toDto(address);
        var returnedAddressDTO = om.readValue(
            restAddressMockMvc
                .perform(
                    post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(addressDTO))
                )
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            AddressDTO.class
        );

        // Validate the Address in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        var returnedAddress = addressMapper.toEntity(returnedAddressDTO);
        assertAddressUpdatableFieldsEquals(returnedAddress, getPersistedAddress(returnedAddress));

        insertedAddress = returnedAddress;
    }

    @Test
    @Transactional
    void createAddressWithExistingId() throws Exception {
        // Create the Address with an existing ID
        address.setId(1L);
        AddressDTO addressDTO = addressMapper.toDto(address);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restAddressMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(addressDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Address in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkWardCodeIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        address.setWardCode(null);

        // Create the Address, which fails.
        AddressDTO addressDTO = addressMapper.toDto(address);

        restAddressMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(addressDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkStreetAddressIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        address.setStreetAddress(null);

        // Create the Address, which fails.
        AddressDTO addressDTO = addressMapper.toDto(address);

        restAddressMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(addressDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllAddresses() throws Exception {
        // Initialize the database
        insertedAddress = addressRepository.saveAndFlush(address);

        // Get all the addressList
        restAddressMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(address.getId().intValue())))
            .andExpect(jsonPath("$.[*].wardCode").value(hasItem(DEFAULT_WARD_CODE)))
            .andExpect(jsonPath("$.[*].streetAddress").value(hasItem(DEFAULT_STREET_ADDRESS)))
            .andExpect(jsonPath("$.[*].postalCode").value(hasItem(DEFAULT_POSTAL_CODE)))
            .andExpect(jsonPath("$.[*].latitude").value(hasItem(sameNumber(DEFAULT_LATITUDE))))
            .andExpect(jsonPath("$.[*].longitude").value(hasItem(sameNumber(DEFAULT_LONGITUDE))))
            .andExpect(jsonPath("$.[*].landmark").value(hasItem(DEFAULT_LANDMARK)));
    }

    @Test
    @Transactional
    void getAddress() throws Exception {
        // Initialize the database
        insertedAddress = addressRepository.saveAndFlush(address);

        // Get the address
        restAddressMockMvc
            .perform(get(ENTITY_API_URL_ID, address.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(address.getId().intValue()))
            .andExpect(jsonPath("$.wardCode").value(DEFAULT_WARD_CODE))
            .andExpect(jsonPath("$.streetAddress").value(DEFAULT_STREET_ADDRESS))
            .andExpect(jsonPath("$.postalCode").value(DEFAULT_POSTAL_CODE))
            .andExpect(jsonPath("$.latitude").value(sameNumber(DEFAULT_LATITUDE)))
            .andExpect(jsonPath("$.longitude").value(sameNumber(DEFAULT_LONGITUDE)))
            .andExpect(jsonPath("$.landmark").value(DEFAULT_LANDMARK));
    }

    @Test
    @Transactional
    void getAddressesByIdFiltering() throws Exception {
        // Initialize the database
        insertedAddress = addressRepository.saveAndFlush(address);

        Long id = address.getId();

        defaultAddressFiltering("id.equals=" + id, "id.notEquals=" + id);

        defaultAddressFiltering("id.greaterThanOrEqual=" + id, "id.greaterThan=" + id);

        defaultAddressFiltering("id.lessThanOrEqual=" + id, "id.lessThan=" + id);
    }

    @Test
    @Transactional
    void getAllAddressesByWardCodeIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedAddress = addressRepository.saveAndFlush(address);

        // Get all the addressList where wardCode equals to
        defaultAddressFiltering("wardCode.equals=" + DEFAULT_WARD_CODE, "wardCode.equals=" + UPDATED_WARD_CODE);
    }

    @Test
    @Transactional
    void getAllAddressesByWardCodeIsInShouldWork() throws Exception {
        // Initialize the database
        insertedAddress = addressRepository.saveAndFlush(address);

        // Get all the addressList where wardCode in
        defaultAddressFiltering("wardCode.in=" + DEFAULT_WARD_CODE + "," + UPDATED_WARD_CODE, "wardCode.in=" + UPDATED_WARD_CODE);
    }

    @Test
    @Transactional
    void getAllAddressesByWardCodeIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedAddress = addressRepository.saveAndFlush(address);

        // Get all the addressList where wardCode is not null
        defaultAddressFiltering("wardCode.specified=true", "wardCode.specified=false");
    }

    @Test
    @Transactional
    void getAllAddressesByWardCodeContainsSomething() throws Exception {
        // Initialize the database
        insertedAddress = addressRepository.saveAndFlush(address);

        // Get all the addressList where wardCode contains
        defaultAddressFiltering("wardCode.contains=" + DEFAULT_WARD_CODE, "wardCode.contains=" + UPDATED_WARD_CODE);
    }

    @Test
    @Transactional
    void getAllAddressesByWardCodeNotContainsSomething() throws Exception {
        // Initialize the database
        insertedAddress = addressRepository.saveAndFlush(address);

        // Get all the addressList where wardCode does not contain
        defaultAddressFiltering("wardCode.doesNotContain=" + UPDATED_WARD_CODE, "wardCode.doesNotContain=" + DEFAULT_WARD_CODE);
    }

    @Test
    @Transactional
    void getAllAddressesByStreetAddressIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedAddress = addressRepository.saveAndFlush(address);

        // Get all the addressList where streetAddress equals to
        defaultAddressFiltering("streetAddress.equals=" + DEFAULT_STREET_ADDRESS, "streetAddress.equals=" + UPDATED_STREET_ADDRESS);
    }

    @Test
    @Transactional
    void getAllAddressesByStreetAddressIsInShouldWork() throws Exception {
        // Initialize the database
        insertedAddress = addressRepository.saveAndFlush(address);

        // Get all the addressList where streetAddress in
        defaultAddressFiltering(
            "streetAddress.in=" + DEFAULT_STREET_ADDRESS + "," + UPDATED_STREET_ADDRESS,
            "streetAddress.in=" + UPDATED_STREET_ADDRESS
        );
    }

    @Test
    @Transactional
    void getAllAddressesByStreetAddressIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedAddress = addressRepository.saveAndFlush(address);

        // Get all the addressList where streetAddress is not null
        defaultAddressFiltering("streetAddress.specified=true", "streetAddress.specified=false");
    }

    @Test
    @Transactional
    void getAllAddressesByStreetAddressContainsSomething() throws Exception {
        // Initialize the database
        insertedAddress = addressRepository.saveAndFlush(address);

        // Get all the addressList where streetAddress contains
        defaultAddressFiltering("streetAddress.contains=" + DEFAULT_STREET_ADDRESS, "streetAddress.contains=" + UPDATED_STREET_ADDRESS);
    }

    @Test
    @Transactional
    void getAllAddressesByStreetAddressNotContainsSomething() throws Exception {
        // Initialize the database
        insertedAddress = addressRepository.saveAndFlush(address);

        // Get all the addressList where streetAddress does not contain
        defaultAddressFiltering(
            "streetAddress.doesNotContain=" + UPDATED_STREET_ADDRESS,
            "streetAddress.doesNotContain=" + DEFAULT_STREET_ADDRESS
        );
    }

    @Test
    @Transactional
    void getAllAddressesByPostalCodeIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedAddress = addressRepository.saveAndFlush(address);

        // Get all the addressList where postalCode equals to
        defaultAddressFiltering("postalCode.equals=" + DEFAULT_POSTAL_CODE, "postalCode.equals=" + UPDATED_POSTAL_CODE);
    }

    @Test
    @Transactional
    void getAllAddressesByPostalCodeIsInShouldWork() throws Exception {
        // Initialize the database
        insertedAddress = addressRepository.saveAndFlush(address);

        // Get all the addressList where postalCode in
        defaultAddressFiltering("postalCode.in=" + DEFAULT_POSTAL_CODE + "," + UPDATED_POSTAL_CODE, "postalCode.in=" + UPDATED_POSTAL_CODE);
    }

    @Test
    @Transactional
    void getAllAddressesByPostalCodeIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedAddress = addressRepository.saveAndFlush(address);

        // Get all the addressList where postalCode is not null
        defaultAddressFiltering("postalCode.specified=true", "postalCode.specified=false");
    }

    @Test
    @Transactional
    void getAllAddressesByPostalCodeContainsSomething() throws Exception {
        // Initialize the database
        insertedAddress = addressRepository.saveAndFlush(address);

        // Get all the addressList where postalCode contains
        defaultAddressFiltering("postalCode.contains=" + DEFAULT_POSTAL_CODE, "postalCode.contains=" + UPDATED_POSTAL_CODE);
    }

    @Test
    @Transactional
    void getAllAddressesByPostalCodeNotContainsSomething() throws Exception {
        // Initialize the database
        insertedAddress = addressRepository.saveAndFlush(address);

        // Get all the addressList where postalCode does not contain
        defaultAddressFiltering("postalCode.doesNotContain=" + UPDATED_POSTAL_CODE, "postalCode.doesNotContain=" + DEFAULT_POSTAL_CODE);
    }

    @Test
    @Transactional
    void getAllAddressesByLatitudeIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedAddress = addressRepository.saveAndFlush(address);

        // Get all the addressList where latitude equals to
        defaultAddressFiltering("latitude.equals=" + DEFAULT_LATITUDE, "latitude.equals=" + UPDATED_LATITUDE);
    }

    @Test
    @Transactional
    void getAllAddressesByLatitudeIsInShouldWork() throws Exception {
        // Initialize the database
        insertedAddress = addressRepository.saveAndFlush(address);

        // Get all the addressList where latitude in
        defaultAddressFiltering("latitude.in=" + DEFAULT_LATITUDE + "," + UPDATED_LATITUDE, "latitude.in=" + UPDATED_LATITUDE);
    }

    @Test
    @Transactional
    void getAllAddressesByLatitudeIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedAddress = addressRepository.saveAndFlush(address);

        // Get all the addressList where latitude is not null
        defaultAddressFiltering("latitude.specified=true", "latitude.specified=false");
    }

    @Test
    @Transactional
    void getAllAddressesByLatitudeIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedAddress = addressRepository.saveAndFlush(address);

        // Get all the addressList where latitude is greater than or equal to
        defaultAddressFiltering("latitude.greaterThanOrEqual=" + DEFAULT_LATITUDE, "latitude.greaterThanOrEqual=" + UPDATED_LATITUDE);
    }

    @Test
    @Transactional
    void getAllAddressesByLatitudeIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedAddress = addressRepository.saveAndFlush(address);

        // Get all the addressList where latitude is less than or equal to
        defaultAddressFiltering("latitude.lessThanOrEqual=" + DEFAULT_LATITUDE, "latitude.lessThanOrEqual=" + SMALLER_LATITUDE);
    }

    @Test
    @Transactional
    void getAllAddressesByLatitudeIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedAddress = addressRepository.saveAndFlush(address);

        // Get all the addressList where latitude is less than
        defaultAddressFiltering("latitude.lessThan=" + UPDATED_LATITUDE, "latitude.lessThan=" + DEFAULT_LATITUDE);
    }

    @Test
    @Transactional
    void getAllAddressesByLatitudeIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedAddress = addressRepository.saveAndFlush(address);

        // Get all the addressList where latitude is greater than
        defaultAddressFiltering("latitude.greaterThan=" + SMALLER_LATITUDE, "latitude.greaterThan=" + DEFAULT_LATITUDE);
    }

    @Test
    @Transactional
    void getAllAddressesByLongitudeIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedAddress = addressRepository.saveAndFlush(address);

        // Get all the addressList where longitude equals to
        defaultAddressFiltering("longitude.equals=" + DEFAULT_LONGITUDE, "longitude.equals=" + UPDATED_LONGITUDE);
    }

    @Test
    @Transactional
    void getAllAddressesByLongitudeIsInShouldWork() throws Exception {
        // Initialize the database
        insertedAddress = addressRepository.saveAndFlush(address);

        // Get all the addressList where longitude in
        defaultAddressFiltering("longitude.in=" + DEFAULT_LONGITUDE + "," + UPDATED_LONGITUDE, "longitude.in=" + UPDATED_LONGITUDE);
    }

    @Test
    @Transactional
    void getAllAddressesByLongitudeIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedAddress = addressRepository.saveAndFlush(address);

        // Get all the addressList where longitude is not null
        defaultAddressFiltering("longitude.specified=true", "longitude.specified=false");
    }

    @Test
    @Transactional
    void getAllAddressesByLongitudeIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedAddress = addressRepository.saveAndFlush(address);

        // Get all the addressList where longitude is greater than or equal to
        defaultAddressFiltering("longitude.greaterThanOrEqual=" + DEFAULT_LONGITUDE, "longitude.greaterThanOrEqual=" + UPDATED_LONGITUDE);
    }

    @Test
    @Transactional
    void getAllAddressesByLongitudeIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedAddress = addressRepository.saveAndFlush(address);

        // Get all the addressList where longitude is less than or equal to
        defaultAddressFiltering("longitude.lessThanOrEqual=" + DEFAULT_LONGITUDE, "longitude.lessThanOrEqual=" + SMALLER_LONGITUDE);
    }

    @Test
    @Transactional
    void getAllAddressesByLongitudeIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedAddress = addressRepository.saveAndFlush(address);

        // Get all the addressList where longitude is less than
        defaultAddressFiltering("longitude.lessThan=" + UPDATED_LONGITUDE, "longitude.lessThan=" + DEFAULT_LONGITUDE);
    }

    @Test
    @Transactional
    void getAllAddressesByLongitudeIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedAddress = addressRepository.saveAndFlush(address);

        // Get all the addressList where longitude is greater than
        defaultAddressFiltering("longitude.greaterThan=" + SMALLER_LONGITUDE, "longitude.greaterThan=" + DEFAULT_LONGITUDE);
    }

    @Test
    @Transactional
    void getAllAddressesByLandmarkIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedAddress = addressRepository.saveAndFlush(address);

        // Get all the addressList where landmark equals to
        defaultAddressFiltering("landmark.equals=" + DEFAULT_LANDMARK, "landmark.equals=" + UPDATED_LANDMARK);
    }

    @Test
    @Transactional
    void getAllAddressesByLandmarkIsInShouldWork() throws Exception {
        // Initialize the database
        insertedAddress = addressRepository.saveAndFlush(address);

        // Get all the addressList where landmark in
        defaultAddressFiltering("landmark.in=" + DEFAULT_LANDMARK + "," + UPDATED_LANDMARK, "landmark.in=" + UPDATED_LANDMARK);
    }

    @Test
    @Transactional
    void getAllAddressesByLandmarkIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedAddress = addressRepository.saveAndFlush(address);

        // Get all the addressList where landmark is not null
        defaultAddressFiltering("landmark.specified=true", "landmark.specified=false");
    }

    @Test
    @Transactional
    void getAllAddressesByLandmarkContainsSomething() throws Exception {
        // Initialize the database
        insertedAddress = addressRepository.saveAndFlush(address);

        // Get all the addressList where landmark contains
        defaultAddressFiltering("landmark.contains=" + DEFAULT_LANDMARK, "landmark.contains=" + UPDATED_LANDMARK);
    }

    @Test
    @Transactional
    void getAllAddressesByLandmarkNotContainsSomething() throws Exception {
        // Initialize the database
        insertedAddress = addressRepository.saveAndFlush(address);

        // Get all the addressList where landmark does not contain
        defaultAddressFiltering("landmark.doesNotContain=" + UPDATED_LANDMARK, "landmark.doesNotContain=" + DEFAULT_LANDMARK);
    }

    @Test
    @Transactional
    void getAllAddressesByWardIsEqualToSomething() throws Exception {
        Ward ward;
        if (TestUtil.findAll(em, Ward.class).isEmpty()) {
            addressRepository.saveAndFlush(address);
            ward = WardResourceIT.createEntity(em);
        } else {
            ward = TestUtil.findAll(em, Ward.class).get(0);
        }
        em.persist(ward);
        em.flush();
        address.setWard(ward);
        addressRepository.saveAndFlush(address);
        Long wardId = ward.getId();
        // Get all the addressList where ward equals to wardId
        defaultAddressShouldBeFound("wardId.equals=" + wardId);

        // Get all the addressList where ward equals to (wardId + 1)
        defaultAddressShouldNotBeFound("wardId.equals=" + (wardId + 1));
    }

    private void defaultAddressFiltering(String shouldBeFound, String shouldNotBeFound) throws Exception {
        defaultAddressShouldBeFound(shouldBeFound);
        defaultAddressShouldNotBeFound(shouldNotBeFound);
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultAddressShouldBeFound(String filter) throws Exception {
        restAddressMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(address.getId().intValue())))
            .andExpect(jsonPath("$.[*].wardCode").value(hasItem(DEFAULT_WARD_CODE)))
            .andExpect(jsonPath("$.[*].streetAddress").value(hasItem(DEFAULT_STREET_ADDRESS)))
            .andExpect(jsonPath("$.[*].postalCode").value(hasItem(DEFAULT_POSTAL_CODE)))
            .andExpect(jsonPath("$.[*].latitude").value(hasItem(sameNumber(DEFAULT_LATITUDE))))
            .andExpect(jsonPath("$.[*].longitude").value(hasItem(sameNumber(DEFAULT_LONGITUDE))))
            .andExpect(jsonPath("$.[*].landmark").value(hasItem(DEFAULT_LANDMARK)));

        // Check, that the count call also returns 1
        restAddressMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("1"));
    }

    /**
     * Executes the search, and checks that the default entity is not returned.
     */
    private void defaultAddressShouldNotBeFound(String filter) throws Exception {
        restAddressMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());

        // Check, that the count call also returns 0
        restAddressMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("0"));
    }

    @Test
    @Transactional
    void getNonExistingAddress() throws Exception {
        // Get the address
        restAddressMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingAddress() throws Exception {
        // Initialize the database
        insertedAddress = addressRepository.saveAndFlush(address);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the address
        Address updatedAddress = addressRepository.findById(address.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedAddress are not directly saved in db
        em.detach(updatedAddress);
        updatedAddress
            .wardCode(UPDATED_WARD_CODE)
            .streetAddress(UPDATED_STREET_ADDRESS)
            .postalCode(UPDATED_POSTAL_CODE)
            .latitude(UPDATED_LATITUDE)
            .longitude(UPDATED_LONGITUDE)
            .landmark(UPDATED_LANDMARK);
        AddressDTO addressDTO = addressMapper.toDto(updatedAddress);

        restAddressMockMvc
            .perform(
                put(ENTITY_API_URL_ID, addressDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(addressDTO))
            )
            .andExpect(status().isOk());

        // Validate the Address in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedAddressToMatchAllProperties(updatedAddress);
    }

    @Test
    @Transactional
    void putNonExistingAddress() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        address.setId(longCount.incrementAndGet());

        // Create the Address
        AddressDTO addressDTO = addressMapper.toDto(address);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restAddressMockMvc
            .perform(
                put(ENTITY_API_URL_ID, addressDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(addressDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Address in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchAddress() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        address.setId(longCount.incrementAndGet());

        // Create the Address
        AddressDTO addressDTO = addressMapper.toDto(address);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restAddressMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(addressDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Address in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamAddress() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        address.setId(longCount.incrementAndGet());

        // Create the Address
        AddressDTO addressDTO = addressMapper.toDto(address);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restAddressMockMvc
            .perform(put(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(addressDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Address in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateAddressWithPatch() throws Exception {
        // Initialize the database
        insertedAddress = addressRepository.saveAndFlush(address);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the address using partial update
        Address partialUpdatedAddress = new Address();
        partialUpdatedAddress.setId(address.getId());

        partialUpdatedAddress.wardCode(UPDATED_WARD_CODE).longitude(UPDATED_LONGITUDE).landmark(UPDATED_LANDMARK);

        restAddressMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedAddress.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedAddress))
            )
            .andExpect(status().isOk());

        // Validate the Address in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertAddressUpdatableFieldsEquals(createUpdateProxyForBean(partialUpdatedAddress, address), getPersistedAddress(address));
    }

    @Test
    @Transactional
    void fullUpdateAddressWithPatch() throws Exception {
        // Initialize the database
        insertedAddress = addressRepository.saveAndFlush(address);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the address using partial update
        Address partialUpdatedAddress = new Address();
        partialUpdatedAddress.setId(address.getId());

        partialUpdatedAddress
            .wardCode(UPDATED_WARD_CODE)
            .streetAddress(UPDATED_STREET_ADDRESS)
            .postalCode(UPDATED_POSTAL_CODE)
            .latitude(UPDATED_LATITUDE)
            .longitude(UPDATED_LONGITUDE)
            .landmark(UPDATED_LANDMARK);

        restAddressMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedAddress.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedAddress))
            )
            .andExpect(status().isOk());

        // Validate the Address in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertAddressUpdatableFieldsEquals(partialUpdatedAddress, getPersistedAddress(partialUpdatedAddress));
    }

    @Test
    @Transactional
    void patchNonExistingAddress() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        address.setId(longCount.incrementAndGet());

        // Create the Address
        AddressDTO addressDTO = addressMapper.toDto(address);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restAddressMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, addressDTO.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(addressDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Address in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchAddress() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        address.setId(longCount.incrementAndGet());

        // Create the Address
        AddressDTO addressDTO = addressMapper.toDto(address);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restAddressMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(addressDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Address in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamAddress() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        address.setId(longCount.incrementAndGet());

        // Create the Address
        AddressDTO addressDTO = addressMapper.toDto(address);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restAddressMockMvc
            .perform(
                patch(ENTITY_API_URL).with(csrf()).contentType("application/merge-patch+json").content(om.writeValueAsBytes(addressDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the Address in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteAddress() throws Exception {
        // Initialize the database
        insertedAddress = addressRepository.saveAndFlush(address);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the address
        restAddressMockMvc
            .perform(delete(ENTITY_API_URL_ID, address.getId()).with(csrf()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return addressRepository.count();
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

    protected Address getPersistedAddress(Address address) {
        return addressRepository.findById(address.getId()).orElseThrow();
    }

    protected void assertPersistedAddressToMatchAllProperties(Address expectedAddress) {
        assertAddressAllPropertiesEquals(expectedAddress, getPersistedAddress(expectedAddress));
    }

    protected void assertPersistedAddressToMatchUpdatableProperties(Address expectedAddress) {
        assertAddressAllUpdatablePropertiesEquals(expectedAddress, getPersistedAddress(expectedAddress));
    }
}
