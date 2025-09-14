package com.ticketsystem.route.web.rest;

import static com.ticketsystem.route.domain.StationAsserts.*;
import static com.ticketsystem.route.web.rest.TestUtil.createUpdateProxyForBean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.hamcrest.Matchers.hasItem;
import static org.mockito.Mockito.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketsystem.route.IntegrationTest;
import com.ticketsystem.route.domain.Station;
import com.ticketsystem.route.repository.StationRepository;
import com.ticketsystem.route.repository.search.StationSearchRepository;
import com.ticketsystem.route.service.dto.StationDTO;
import com.ticketsystem.route.service.mapper.StationMapper;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.assertj.core.util.IterableUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.data.util.Streamable;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link StationResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class StationResourceIT {

    private static final String DEFAULT_CODE = "AAAAAAAAAA";
    private static final String UPDATED_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_NAME_EN = "AAAAAAAAAA";
    private static final String UPDATED_NAME_EN = "BBBBBBBBBB";

    private static final UUID DEFAULT_ADDRESS_ID = UUID.randomUUID();
    private static final UUID UPDATED_ADDRESS_ID = UUID.randomUUID();

    private static final String DEFAULT_FACILITIES = "AAAAAAAAAA";
    private static final String UPDATED_FACILITIES = "BBBBBBBBBB";

    private static final String DEFAULT_OPERATING_HOURS = "AAAAAAAAAA";
    private static final String UPDATED_OPERATING_HOURS = "BBBBBBBBBB";

    private static final Boolean DEFAULT_IS_ACTIVE = false;
    private static final Boolean UPDATED_IS_ACTIVE = true;

    private static final String ENTITY_API_URL = "/api/stations";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";
    private static final String ENTITY_SEARCH_API_URL = "/api/stations/_search";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private StationRepository stationRepository;

    @Autowired
    private StationMapper stationMapper;

    @Autowired
    private StationSearchRepository stationSearchRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restStationMockMvc;

    private Station station;

    private Station insertedStation;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Station createEntity() {
        return new Station()
            .code(DEFAULT_CODE)
            .name(DEFAULT_NAME)
            .nameEn(DEFAULT_NAME_EN)
            .addressId(DEFAULT_ADDRESS_ID)
            .facilities(DEFAULT_FACILITIES)
            .operatingHours(DEFAULT_OPERATING_HOURS)
            .isActive(DEFAULT_IS_ACTIVE);
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Station createUpdatedEntity() {
        return new Station()
            .code(UPDATED_CODE)
            .name(UPDATED_NAME)
            .nameEn(UPDATED_NAME_EN)
            .addressId(UPDATED_ADDRESS_ID)
            .facilities(UPDATED_FACILITIES)
            .operatingHours(UPDATED_OPERATING_HOURS)
            .isActive(UPDATED_IS_ACTIVE);
    }

    @BeforeEach
    void initTest() {
        station = createEntity();
    }

    @AfterEach
    void cleanup() {
        if (insertedStation != null) {
            stationRepository.delete(insertedStation);
            stationSearchRepository.delete(insertedStation);
            insertedStation = null;
        }
    }

    @Test
    @Transactional
    void createStation() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(stationSearchRepository.findAll());
        // Create the Station
        StationDTO stationDTO = stationMapper.toDto(station);
        var returnedStationDTO = om.readValue(
            restStationMockMvc
                .perform(
                    post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(stationDTO))
                )
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            StationDTO.class
        );

        // Validate the Station in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        var returnedStation = stationMapper.toEntity(returnedStationDTO);
        assertStationUpdatableFieldsEquals(returnedStation, getPersistedStation(returnedStation));

        await()
            .atMost(5, TimeUnit.SECONDS)
            .untilAsserted(() -> {
                int searchDatabaseSizeAfter = IterableUtil.sizeOf(stationSearchRepository.findAll());
                assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore + 1);
            });

        insertedStation = returnedStation;
    }

    @Test
    @Transactional
    void createStationWithExistingId() throws Exception {
        // Create the Station with an existing ID
        station.setId(1L);
        StationDTO stationDTO = stationMapper.toDto(station);

        long databaseSizeBeforeCreate = getRepositoryCount();
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(stationSearchRepository.findAll());

        // An entity with an existing ID cannot be created, so this API call must fail
        restStationMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(stationDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Station in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
        int searchDatabaseSizeAfter = IterableUtil.sizeOf(stationSearchRepository.findAll());
        assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore);
    }

    @Test
    @Transactional
    void checkCodeIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(stationSearchRepository.findAll());
        // set the field null
        station.setCode(null);

        // Create the Station, which fails.
        StationDTO stationDTO = stationMapper.toDto(station);

        restStationMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(stationDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);

        int searchDatabaseSizeAfter = IterableUtil.sizeOf(stationSearchRepository.findAll());
        assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore);
    }

    @Test
    @Transactional
    void checkNameIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(stationSearchRepository.findAll());
        // set the field null
        station.setName(null);

        // Create the Station, which fails.
        StationDTO stationDTO = stationMapper.toDto(station);

        restStationMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(stationDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);

        int searchDatabaseSizeAfter = IterableUtil.sizeOf(stationSearchRepository.findAll());
        assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore);
    }

    @Test
    @Transactional
    void checkAddressIdIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(stationSearchRepository.findAll());
        // set the field null
        station.setAddressId(null);

        // Create the Station, which fails.
        StationDTO stationDTO = stationMapper.toDto(station);

        restStationMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(stationDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);

        int searchDatabaseSizeAfter = IterableUtil.sizeOf(stationSearchRepository.findAll());
        assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore);
    }

    @Test
    @Transactional
    void checkIsActiveIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(stationSearchRepository.findAll());
        // set the field null
        station.setIsActive(null);

        // Create the Station, which fails.
        StationDTO stationDTO = stationMapper.toDto(station);

        restStationMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(stationDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);

        int searchDatabaseSizeAfter = IterableUtil.sizeOf(stationSearchRepository.findAll());
        assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore);
    }

    @Test
    @Transactional
    void getAllStations() throws Exception {
        // Initialize the database
        insertedStation = stationRepository.saveAndFlush(station);

        // Get all the stationList
        restStationMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(station.getId().intValue())))
            .andExpect(jsonPath("$.[*].code").value(hasItem(DEFAULT_CODE)))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
            .andExpect(jsonPath("$.[*].nameEn").value(hasItem(DEFAULT_NAME_EN)))
            .andExpect(jsonPath("$.[*].addressId").value(hasItem(DEFAULT_ADDRESS_ID.toString())))
            .andExpect(jsonPath("$.[*].facilities").value(hasItem(DEFAULT_FACILITIES)))
            .andExpect(jsonPath("$.[*].operatingHours").value(hasItem(DEFAULT_OPERATING_HOURS)))
            .andExpect(jsonPath("$.[*].isActive").value(hasItem(DEFAULT_IS_ACTIVE)));
    }

    @Test
    @Transactional
    void getStation() throws Exception {
        // Initialize the database
        insertedStation = stationRepository.saveAndFlush(station);

        // Get the station
        restStationMockMvc
            .perform(get(ENTITY_API_URL_ID, station.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(station.getId().intValue()))
            .andExpect(jsonPath("$.code").value(DEFAULT_CODE))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME))
            .andExpect(jsonPath("$.nameEn").value(DEFAULT_NAME_EN))
            .andExpect(jsonPath("$.addressId").value(DEFAULT_ADDRESS_ID.toString()))
            .andExpect(jsonPath("$.facilities").value(DEFAULT_FACILITIES))
            .andExpect(jsonPath("$.operatingHours").value(DEFAULT_OPERATING_HOURS))
            .andExpect(jsonPath("$.isActive").value(DEFAULT_IS_ACTIVE));
    }

    @Test
    @Transactional
    void getStationsByIdFiltering() throws Exception {
        // Initialize the database
        insertedStation = stationRepository.saveAndFlush(station);

        Long id = station.getId();

        defaultStationFiltering("id.equals=" + id, "id.notEquals=" + id);

        defaultStationFiltering("id.greaterThanOrEqual=" + id, "id.greaterThan=" + id);

        defaultStationFiltering("id.lessThanOrEqual=" + id, "id.lessThan=" + id);
    }

    @Test
    @Transactional
    void getAllStationsByCodeIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedStation = stationRepository.saveAndFlush(station);

        // Get all the stationList where code equals to
        defaultStationFiltering("code.equals=" + DEFAULT_CODE, "code.equals=" + UPDATED_CODE);
    }

    @Test
    @Transactional
    void getAllStationsByCodeIsInShouldWork() throws Exception {
        // Initialize the database
        insertedStation = stationRepository.saveAndFlush(station);

        // Get all the stationList where code in
        defaultStationFiltering("code.in=" + DEFAULT_CODE + "," + UPDATED_CODE, "code.in=" + UPDATED_CODE);
    }

    @Test
    @Transactional
    void getAllStationsByCodeIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedStation = stationRepository.saveAndFlush(station);

        // Get all the stationList where code is not null
        defaultStationFiltering("code.specified=true", "code.specified=false");
    }

    @Test
    @Transactional
    void getAllStationsByCodeContainsSomething() throws Exception {
        // Initialize the database
        insertedStation = stationRepository.saveAndFlush(station);

        // Get all the stationList where code contains
        defaultStationFiltering("code.contains=" + DEFAULT_CODE, "code.contains=" + UPDATED_CODE);
    }

    @Test
    @Transactional
    void getAllStationsByCodeNotContainsSomething() throws Exception {
        // Initialize the database
        insertedStation = stationRepository.saveAndFlush(station);

        // Get all the stationList where code does not contain
        defaultStationFiltering("code.doesNotContain=" + UPDATED_CODE, "code.doesNotContain=" + DEFAULT_CODE);
    }

    @Test
    @Transactional
    void getAllStationsByNameIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedStation = stationRepository.saveAndFlush(station);

        // Get all the stationList where name equals to
        defaultStationFiltering("name.equals=" + DEFAULT_NAME, "name.equals=" + UPDATED_NAME);
    }

    @Test
    @Transactional
    void getAllStationsByNameIsInShouldWork() throws Exception {
        // Initialize the database
        insertedStation = stationRepository.saveAndFlush(station);

        // Get all the stationList where name in
        defaultStationFiltering("name.in=" + DEFAULT_NAME + "," + UPDATED_NAME, "name.in=" + UPDATED_NAME);
    }

    @Test
    @Transactional
    void getAllStationsByNameIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedStation = stationRepository.saveAndFlush(station);

        // Get all the stationList where name is not null
        defaultStationFiltering("name.specified=true", "name.specified=false");
    }

    @Test
    @Transactional
    void getAllStationsByNameContainsSomething() throws Exception {
        // Initialize the database
        insertedStation = stationRepository.saveAndFlush(station);

        // Get all the stationList where name contains
        defaultStationFiltering("name.contains=" + DEFAULT_NAME, "name.contains=" + UPDATED_NAME);
    }

    @Test
    @Transactional
    void getAllStationsByNameNotContainsSomething() throws Exception {
        // Initialize the database
        insertedStation = stationRepository.saveAndFlush(station);

        // Get all the stationList where name does not contain
        defaultStationFiltering("name.doesNotContain=" + UPDATED_NAME, "name.doesNotContain=" + DEFAULT_NAME);
    }

    @Test
    @Transactional
    void getAllStationsByNameEnIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedStation = stationRepository.saveAndFlush(station);

        // Get all the stationList where nameEn equals to
        defaultStationFiltering("nameEn.equals=" + DEFAULT_NAME_EN, "nameEn.equals=" + UPDATED_NAME_EN);
    }

    @Test
    @Transactional
    void getAllStationsByNameEnIsInShouldWork() throws Exception {
        // Initialize the database
        insertedStation = stationRepository.saveAndFlush(station);

        // Get all the stationList where nameEn in
        defaultStationFiltering("nameEn.in=" + DEFAULT_NAME_EN + "," + UPDATED_NAME_EN, "nameEn.in=" + UPDATED_NAME_EN);
    }

    @Test
    @Transactional
    void getAllStationsByNameEnIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedStation = stationRepository.saveAndFlush(station);

        // Get all the stationList where nameEn is not null
        defaultStationFiltering("nameEn.specified=true", "nameEn.specified=false");
    }

    @Test
    @Transactional
    void getAllStationsByNameEnContainsSomething() throws Exception {
        // Initialize the database
        insertedStation = stationRepository.saveAndFlush(station);

        // Get all the stationList where nameEn contains
        defaultStationFiltering("nameEn.contains=" + DEFAULT_NAME_EN, "nameEn.contains=" + UPDATED_NAME_EN);
    }

    @Test
    @Transactional
    void getAllStationsByNameEnNotContainsSomething() throws Exception {
        // Initialize the database
        insertedStation = stationRepository.saveAndFlush(station);

        // Get all the stationList where nameEn does not contain
        defaultStationFiltering("nameEn.doesNotContain=" + UPDATED_NAME_EN, "nameEn.doesNotContain=" + DEFAULT_NAME_EN);
    }

    @Test
    @Transactional
    void getAllStationsByAddressIdIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedStation = stationRepository.saveAndFlush(station);

        // Get all the stationList where addressId equals to
        defaultStationFiltering("addressId.equals=" + DEFAULT_ADDRESS_ID, "addressId.equals=" + UPDATED_ADDRESS_ID);
    }

    @Test
    @Transactional
    void getAllStationsByAddressIdIsInShouldWork() throws Exception {
        // Initialize the database
        insertedStation = stationRepository.saveAndFlush(station);

        // Get all the stationList where addressId in
        defaultStationFiltering("addressId.in=" + DEFAULT_ADDRESS_ID + "," + UPDATED_ADDRESS_ID, "addressId.in=" + UPDATED_ADDRESS_ID);
    }

    @Test
    @Transactional
    void getAllStationsByAddressIdIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedStation = stationRepository.saveAndFlush(station);

        // Get all the stationList where addressId is not null
        defaultStationFiltering("addressId.specified=true", "addressId.specified=false");
    }

    @Test
    @Transactional
    void getAllStationsByFacilitiesIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedStation = stationRepository.saveAndFlush(station);

        // Get all the stationList where facilities equals to
        defaultStationFiltering("facilities.equals=" + DEFAULT_FACILITIES, "facilities.equals=" + UPDATED_FACILITIES);
    }

    @Test
    @Transactional
    void getAllStationsByFacilitiesIsInShouldWork() throws Exception {
        // Initialize the database
        insertedStation = stationRepository.saveAndFlush(station);

        // Get all the stationList where facilities in
        defaultStationFiltering("facilities.in=" + DEFAULT_FACILITIES + "," + UPDATED_FACILITIES, "facilities.in=" + UPDATED_FACILITIES);
    }

    @Test
    @Transactional
    void getAllStationsByFacilitiesIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedStation = stationRepository.saveAndFlush(station);

        // Get all the stationList where facilities is not null
        defaultStationFiltering("facilities.specified=true", "facilities.specified=false");
    }

    @Test
    @Transactional
    void getAllStationsByFacilitiesContainsSomething() throws Exception {
        // Initialize the database
        insertedStation = stationRepository.saveAndFlush(station);

        // Get all the stationList where facilities contains
        defaultStationFiltering("facilities.contains=" + DEFAULT_FACILITIES, "facilities.contains=" + UPDATED_FACILITIES);
    }

    @Test
    @Transactional
    void getAllStationsByFacilitiesNotContainsSomething() throws Exception {
        // Initialize the database
        insertedStation = stationRepository.saveAndFlush(station);

        // Get all the stationList where facilities does not contain
        defaultStationFiltering("facilities.doesNotContain=" + UPDATED_FACILITIES, "facilities.doesNotContain=" + DEFAULT_FACILITIES);
    }

    @Test
    @Transactional
    void getAllStationsByOperatingHoursIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedStation = stationRepository.saveAndFlush(station);

        // Get all the stationList where operatingHours equals to
        defaultStationFiltering("operatingHours.equals=" + DEFAULT_OPERATING_HOURS, "operatingHours.equals=" + UPDATED_OPERATING_HOURS);
    }

    @Test
    @Transactional
    void getAllStationsByOperatingHoursIsInShouldWork() throws Exception {
        // Initialize the database
        insertedStation = stationRepository.saveAndFlush(station);

        // Get all the stationList where operatingHours in
        defaultStationFiltering(
            "operatingHours.in=" + DEFAULT_OPERATING_HOURS + "," + UPDATED_OPERATING_HOURS,
            "operatingHours.in=" + UPDATED_OPERATING_HOURS
        );
    }

    @Test
    @Transactional
    void getAllStationsByOperatingHoursIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedStation = stationRepository.saveAndFlush(station);

        // Get all the stationList where operatingHours is not null
        defaultStationFiltering("operatingHours.specified=true", "operatingHours.specified=false");
    }

    @Test
    @Transactional
    void getAllStationsByOperatingHoursContainsSomething() throws Exception {
        // Initialize the database
        insertedStation = stationRepository.saveAndFlush(station);

        // Get all the stationList where operatingHours contains
        defaultStationFiltering("operatingHours.contains=" + DEFAULT_OPERATING_HOURS, "operatingHours.contains=" + UPDATED_OPERATING_HOURS);
    }

    @Test
    @Transactional
    void getAllStationsByOperatingHoursNotContainsSomething() throws Exception {
        // Initialize the database
        insertedStation = stationRepository.saveAndFlush(station);

        // Get all the stationList where operatingHours does not contain
        defaultStationFiltering(
            "operatingHours.doesNotContain=" + UPDATED_OPERATING_HOURS,
            "operatingHours.doesNotContain=" + DEFAULT_OPERATING_HOURS
        );
    }

    @Test
    @Transactional
    void getAllStationsByIsActiveIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedStation = stationRepository.saveAndFlush(station);

        // Get all the stationList where isActive equals to
        defaultStationFiltering("isActive.equals=" + DEFAULT_IS_ACTIVE, "isActive.equals=" + UPDATED_IS_ACTIVE);
    }

    @Test
    @Transactional
    void getAllStationsByIsActiveIsInShouldWork() throws Exception {
        // Initialize the database
        insertedStation = stationRepository.saveAndFlush(station);

        // Get all the stationList where isActive in
        defaultStationFiltering("isActive.in=" + DEFAULT_IS_ACTIVE + "," + UPDATED_IS_ACTIVE, "isActive.in=" + UPDATED_IS_ACTIVE);
    }

    @Test
    @Transactional
    void getAllStationsByIsActiveIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedStation = stationRepository.saveAndFlush(station);

        // Get all the stationList where isActive is not null
        defaultStationFiltering("isActive.specified=true", "isActive.specified=false");
    }

    private void defaultStationFiltering(String shouldBeFound, String shouldNotBeFound) throws Exception {
        defaultStationShouldBeFound(shouldBeFound);
        defaultStationShouldNotBeFound(shouldNotBeFound);
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultStationShouldBeFound(String filter) throws Exception {
        restStationMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(station.getId().intValue())))
            .andExpect(jsonPath("$.[*].code").value(hasItem(DEFAULT_CODE)))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
            .andExpect(jsonPath("$.[*].nameEn").value(hasItem(DEFAULT_NAME_EN)))
            .andExpect(jsonPath("$.[*].addressId").value(hasItem(DEFAULT_ADDRESS_ID.toString())))
            .andExpect(jsonPath("$.[*].facilities").value(hasItem(DEFAULT_FACILITIES)))
            .andExpect(jsonPath("$.[*].operatingHours").value(hasItem(DEFAULT_OPERATING_HOURS)))
            .andExpect(jsonPath("$.[*].isActive").value(hasItem(DEFAULT_IS_ACTIVE)));

        // Check, that the count call also returns 1
        restStationMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("1"));
    }

    /**
     * Executes the search, and checks that the default entity is not returned.
     */
    private void defaultStationShouldNotBeFound(String filter) throws Exception {
        restStationMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());

        // Check, that the count call also returns 0
        restStationMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("0"));
    }

    @Test
    @Transactional
    void getNonExistingStation() throws Exception {
        // Get the station
        restStationMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingStation() throws Exception {
        // Initialize the database
        insertedStation = stationRepository.saveAndFlush(station);

        long databaseSizeBeforeUpdate = getRepositoryCount();
        stationSearchRepository.save(station);
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(stationSearchRepository.findAll());

        // Update the station
        Station updatedStation = stationRepository.findById(station.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedStation are not directly saved in db
        em.detach(updatedStation);
        updatedStation
            .code(UPDATED_CODE)
            .name(UPDATED_NAME)
            .nameEn(UPDATED_NAME_EN)
            .addressId(UPDATED_ADDRESS_ID)
            .facilities(UPDATED_FACILITIES)
            .operatingHours(UPDATED_OPERATING_HOURS)
            .isActive(UPDATED_IS_ACTIVE);
        StationDTO stationDTO = stationMapper.toDto(updatedStation);

        restStationMockMvc
            .perform(
                put(ENTITY_API_URL_ID, stationDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(stationDTO))
            )
            .andExpect(status().isOk());

        // Validate the Station in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedStationToMatchAllProperties(updatedStation);

        await()
            .atMost(5, TimeUnit.SECONDS)
            .untilAsserted(() -> {
                int searchDatabaseSizeAfter = IterableUtil.sizeOf(stationSearchRepository.findAll());
                assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore);
                List<Station> stationSearchList = Streamable.of(stationSearchRepository.findAll()).toList();
                Station testStationSearch = stationSearchList.get(searchDatabaseSizeAfter - 1);

                assertStationAllPropertiesEquals(testStationSearch, updatedStation);
            });
    }

    @Test
    @Transactional
    void putNonExistingStation() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(stationSearchRepository.findAll());
        station.setId(longCount.incrementAndGet());

        // Create the Station
        StationDTO stationDTO = stationMapper.toDto(station);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restStationMockMvc
            .perform(
                put(ENTITY_API_URL_ID, stationDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(stationDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Station in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        int searchDatabaseSizeAfter = IterableUtil.sizeOf(stationSearchRepository.findAll());
        assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore);
    }

    @Test
    @Transactional
    void putWithIdMismatchStation() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(stationSearchRepository.findAll());
        station.setId(longCount.incrementAndGet());

        // Create the Station
        StationDTO stationDTO = stationMapper.toDto(station);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restStationMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(stationDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Station in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        int searchDatabaseSizeAfter = IterableUtil.sizeOf(stationSearchRepository.findAll());
        assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamStation() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(stationSearchRepository.findAll());
        station.setId(longCount.incrementAndGet());

        // Create the Station
        StationDTO stationDTO = stationMapper.toDto(station);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restStationMockMvc
            .perform(put(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(stationDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Station in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        int searchDatabaseSizeAfter = IterableUtil.sizeOf(stationSearchRepository.findAll());
        assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore);
    }

    @Test
    @Transactional
    void partialUpdateStationWithPatch() throws Exception {
        // Initialize the database
        insertedStation = stationRepository.saveAndFlush(station);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the station using partial update
        Station partialUpdatedStation = new Station();
        partialUpdatedStation.setId(station.getId());

        partialUpdatedStation.code(UPDATED_CODE).addressId(UPDATED_ADDRESS_ID).facilities(UPDATED_FACILITIES).isActive(UPDATED_IS_ACTIVE);

        restStationMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedStation.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedStation))
            )
            .andExpect(status().isOk());

        // Validate the Station in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertStationUpdatableFieldsEquals(createUpdateProxyForBean(partialUpdatedStation, station), getPersistedStation(station));
    }

    @Test
    @Transactional
    void fullUpdateStationWithPatch() throws Exception {
        // Initialize the database
        insertedStation = stationRepository.saveAndFlush(station);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the station using partial update
        Station partialUpdatedStation = new Station();
        partialUpdatedStation.setId(station.getId());

        partialUpdatedStation
            .code(UPDATED_CODE)
            .name(UPDATED_NAME)
            .nameEn(UPDATED_NAME_EN)
            .addressId(UPDATED_ADDRESS_ID)
            .facilities(UPDATED_FACILITIES)
            .operatingHours(UPDATED_OPERATING_HOURS)
            .isActive(UPDATED_IS_ACTIVE);

        restStationMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedStation.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedStation))
            )
            .andExpect(status().isOk());

        // Validate the Station in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertStationUpdatableFieldsEquals(partialUpdatedStation, getPersistedStation(partialUpdatedStation));
    }

    @Test
    @Transactional
    void patchNonExistingStation() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(stationSearchRepository.findAll());
        station.setId(longCount.incrementAndGet());

        // Create the Station
        StationDTO stationDTO = stationMapper.toDto(station);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restStationMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, stationDTO.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(stationDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Station in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        int searchDatabaseSizeAfter = IterableUtil.sizeOf(stationSearchRepository.findAll());
        assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore);
    }

    @Test
    @Transactional
    void patchWithIdMismatchStation() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(stationSearchRepository.findAll());
        station.setId(longCount.incrementAndGet());

        // Create the Station
        StationDTO stationDTO = stationMapper.toDto(station);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restStationMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(stationDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Station in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        int searchDatabaseSizeAfter = IterableUtil.sizeOf(stationSearchRepository.findAll());
        assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamStation() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(stationSearchRepository.findAll());
        station.setId(longCount.incrementAndGet());

        // Create the Station
        StationDTO stationDTO = stationMapper.toDto(station);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restStationMockMvc
            .perform(
                patch(ENTITY_API_URL).with(csrf()).contentType("application/merge-patch+json").content(om.writeValueAsBytes(stationDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the Station in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        int searchDatabaseSizeAfter = IterableUtil.sizeOf(stationSearchRepository.findAll());
        assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore);
    }

    @Test
    @Transactional
    void deleteStation() throws Exception {
        // Initialize the database
        insertedStation = stationRepository.saveAndFlush(station);
        stationRepository.save(station);
        stationSearchRepository.save(station);

        long databaseSizeBeforeDelete = getRepositoryCount();
        int searchDatabaseSizeBefore = IterableUtil.sizeOf(stationSearchRepository.findAll());
        assertThat(searchDatabaseSizeBefore).isEqualTo(databaseSizeBeforeDelete);

        // Delete the station
        restStationMockMvc
            .perform(delete(ENTITY_API_URL_ID, station.getId()).with(csrf()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
        int searchDatabaseSizeAfter = IterableUtil.sizeOf(stationSearchRepository.findAll());
        assertThat(searchDatabaseSizeAfter).isEqualTo(searchDatabaseSizeBefore - 1);
    }

    @Test
    @Transactional
    void searchStation() throws Exception {
        // Initialize the database
        insertedStation = stationRepository.saveAndFlush(station);
        stationSearchRepository.save(station);

        // Search the station
        restStationMockMvc
            .perform(get(ENTITY_SEARCH_API_URL + "?query=id:" + station.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(station.getId().intValue())))
            .andExpect(jsonPath("$.[*].code").value(hasItem(DEFAULT_CODE)))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
            .andExpect(jsonPath("$.[*].nameEn").value(hasItem(DEFAULT_NAME_EN)))
            .andExpect(jsonPath("$.[*].addressId").value(hasItem(DEFAULT_ADDRESS_ID.toString())))
            .andExpect(jsonPath("$.[*].facilities").value(hasItem(DEFAULT_FACILITIES)))
            .andExpect(jsonPath("$.[*].operatingHours").value(hasItem(DEFAULT_OPERATING_HOURS)))
            .andExpect(jsonPath("$.[*].isActive").value(hasItem(DEFAULT_IS_ACTIVE)));
    }

    protected long getRepositoryCount() {
        return stationRepository.count();
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

    protected Station getPersistedStation(Station station) {
        return stationRepository.findById(station.getId()).orElseThrow();
    }

    protected void assertPersistedStationToMatchAllProperties(Station expectedStation) {
        assertStationAllPropertiesEquals(expectedStation, getPersistedStation(expectedStation));
    }

    protected void assertPersistedStationToMatchUpdatableProperties(Station expectedStation) {
        assertStationAllUpdatablePropertiesEquals(expectedStation, getPersistedStation(expectedStation));
    }
}
