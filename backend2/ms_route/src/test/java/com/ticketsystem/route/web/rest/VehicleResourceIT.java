package com.ticketsystem.route.web.rest;

import static com.ticketsystem.route.domain.VehicleAsserts.*;
import static com.ticketsystem.route.web.rest.TestUtil.createUpdateProxyForBean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketsystem.route.IntegrationTest;
import com.ticketsystem.route.domain.Operator;
import com.ticketsystem.route.domain.ReviewSummary;
import com.ticketsystem.route.domain.Station;
import com.ticketsystem.route.domain.Vehicle;
import com.ticketsystem.route.repository.VehicleRepository;
import com.ticketsystem.route.service.dto.VehicleDTO;
import com.ticketsystem.route.service.mapper.VehicleMapper;
import jakarta.persistence.EntityManager;
import java.time.LocalDate;
import java.time.ZoneId;
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
 * Integration tests for the {@link VehicleResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class VehicleResourceIT {

    private static final String DEFAULT_PLATE_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_PLATE_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_MODEL = "AAAAAAAAAA";
    private static final String UPDATED_MODEL = "BBBBBBBBBB";

    private static final Integer DEFAULT_CAPACITY = 1;
    private static final Integer UPDATED_CAPACITY = 2;
    private static final Integer SMALLER_CAPACITY = 1 - 1;

    private static final String DEFAULT_SEAT_LAYOUT = "AAAAAAAAAA";
    private static final String UPDATED_SEAT_LAYOUT = "BBBBBBBBBB";

    private static final String DEFAULT_AMENITIES = "AAAAAAAAAA";
    private static final String UPDATED_AMENITIES = "BBBBBBBBBB";

    private static final String DEFAULT_IMAGE_COVER_URL = "AAAAAAAAAA";
    private static final String UPDATED_IMAGE_COVER_URL = "BBBBBBBBBB";

    private static final Double DEFAULT_AVERAGE_RATING = 1D;
    private static final Double UPDATED_AVERAGE_RATING = 2D;
    private static final Double SMALLER_AVERAGE_RATING = 1D - 1D;

    private static final Integer DEFAULT_TOTAL_REVIEWS = 1;
    private static final Integer UPDATED_TOTAL_REVIEWS = 2;
    private static final Integer SMALLER_TOTAL_REVIEWS = 1 - 1;

    private static final Boolean DEFAULT_IS_ACTIVE = false;
    private static final Boolean UPDATED_IS_ACTIVE = true;

    private static final Integer DEFAULT_YEAR_MANUFACTURED = 1;
    private static final Integer UPDATED_YEAR_MANUFACTURED = 2;
    private static final Integer SMALLER_YEAR_MANUFACTURED = 1 - 1;

    private static final LocalDate DEFAULT_LAST_MAINTENANCE_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_LAST_MAINTENANCE_DATE = LocalDate.now(ZoneId.systemDefault());
    private static final LocalDate SMALLER_LAST_MAINTENANCE_DATE = LocalDate.ofEpochDay(-1L);

    private static final String ENTITY_API_URL = "/api/vehicles";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private VehicleMapper vehicleMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restVehicleMockMvc;

    private Vehicle vehicle;

    private Vehicle insertedVehicle;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Vehicle createEntity(EntityManager em) {
        Vehicle vehicle = new Vehicle()
            .plateNumber(DEFAULT_PLATE_NUMBER)
            .model(DEFAULT_MODEL)
            .capacity(DEFAULT_CAPACITY)
            .seatLayout(DEFAULT_SEAT_LAYOUT)
            .amenities(DEFAULT_AMENITIES)
            .imageCoverUrl(DEFAULT_IMAGE_COVER_URL)
            .averageRating(DEFAULT_AVERAGE_RATING)
            .totalReviews(DEFAULT_TOTAL_REVIEWS)
            .isActive(DEFAULT_IS_ACTIVE)
            .yearManufactured(DEFAULT_YEAR_MANUFACTURED)
            .lastMaintenanceDate(DEFAULT_LAST_MAINTENANCE_DATE);
        // Add required entity
        Operator operator;
        if (TestUtil.findAll(em, Operator.class).isEmpty()) {
            operator = OperatorResourceIT.createEntity();
            em.persist(operator);
            em.flush();
        } else {
            operator = TestUtil.findAll(em, Operator.class).get(0);
        }
        vehicle.setOperator(operator);
        return vehicle;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Vehicle createUpdatedEntity(EntityManager em) {
        Vehicle updatedVehicle = new Vehicle()
            .plateNumber(UPDATED_PLATE_NUMBER)
            .model(UPDATED_MODEL)
            .capacity(UPDATED_CAPACITY)
            .seatLayout(UPDATED_SEAT_LAYOUT)
            .amenities(UPDATED_AMENITIES)
            .imageCoverUrl(UPDATED_IMAGE_COVER_URL)
            .averageRating(UPDATED_AVERAGE_RATING)
            .totalReviews(UPDATED_TOTAL_REVIEWS)
            .isActive(UPDATED_IS_ACTIVE)
            .yearManufactured(UPDATED_YEAR_MANUFACTURED)
            .lastMaintenanceDate(UPDATED_LAST_MAINTENANCE_DATE);
        // Add required entity
        Operator operator;
        if (TestUtil.findAll(em, Operator.class).isEmpty()) {
            operator = OperatorResourceIT.createUpdatedEntity();
            em.persist(operator);
            em.flush();
        } else {
            operator = TestUtil.findAll(em, Operator.class).get(0);
        }
        updatedVehicle.setOperator(operator);
        return updatedVehicle;
    }

    @BeforeEach
    void initTest() {
        vehicle = createEntity(em);
    }

    @AfterEach
    void cleanup() {
        if (insertedVehicle != null) {
            vehicleRepository.delete(insertedVehicle);
            insertedVehicle = null;
        }
    }

    @Test
    @Transactional
    void createVehicle() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the Vehicle
        VehicleDTO vehicleDTO = vehicleMapper.toDto(vehicle);
        var returnedVehicleDTO = om.readValue(
            restVehicleMockMvc
                .perform(
                    post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(vehicleDTO))
                )
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            VehicleDTO.class
        );

        // Validate the Vehicle in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        var returnedVehicle = vehicleMapper.toEntity(returnedVehicleDTO);
        assertVehicleUpdatableFieldsEquals(returnedVehicle, getPersistedVehicle(returnedVehicle));

        insertedVehicle = returnedVehicle;
    }

    @Test
    @Transactional
    void createVehicleWithExistingId() throws Exception {
        // Create the Vehicle with an existing ID
        vehicle.setId(1L);
        VehicleDTO vehicleDTO = vehicleMapper.toDto(vehicle);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restVehicleMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(vehicleDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Vehicle in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkPlateNumberIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        vehicle.setPlateNumber(null);

        // Create the Vehicle, which fails.
        VehicleDTO vehicleDTO = vehicleMapper.toDto(vehicle);

        restVehicleMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(vehicleDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkCapacityIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        vehicle.setCapacity(null);

        // Create the Vehicle, which fails.
        VehicleDTO vehicleDTO = vehicleMapper.toDto(vehicle);

        restVehicleMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(vehicleDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkIsActiveIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        vehicle.setIsActive(null);

        // Create the Vehicle, which fails.
        VehicleDTO vehicleDTO = vehicleMapper.toDto(vehicle);

        restVehicleMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(vehicleDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllVehicles() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList
        restVehicleMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(vehicle.getId().intValue())))
            .andExpect(jsonPath("$.[*].plateNumber").value(hasItem(DEFAULT_PLATE_NUMBER)))
            .andExpect(jsonPath("$.[*].model").value(hasItem(DEFAULT_MODEL)))
            .andExpect(jsonPath("$.[*].capacity").value(hasItem(DEFAULT_CAPACITY)))
            .andExpect(jsonPath("$.[*].seatLayout").value(hasItem(DEFAULT_SEAT_LAYOUT)))
            .andExpect(jsonPath("$.[*].amenities").value(hasItem(DEFAULT_AMENITIES)))
            .andExpect(jsonPath("$.[*].imageCoverUrl").value(hasItem(DEFAULT_IMAGE_COVER_URL)))
            .andExpect(jsonPath("$.[*].averageRating").value(hasItem(DEFAULT_AVERAGE_RATING)))
            .andExpect(jsonPath("$.[*].totalReviews").value(hasItem(DEFAULT_TOTAL_REVIEWS)))
            .andExpect(jsonPath("$.[*].isActive").value(hasItem(DEFAULT_IS_ACTIVE)))
            .andExpect(jsonPath("$.[*].yearManufactured").value(hasItem(DEFAULT_YEAR_MANUFACTURED)))
            .andExpect(jsonPath("$.[*].lastMaintenanceDate").value(hasItem(DEFAULT_LAST_MAINTENANCE_DATE.toString())));
    }

    @Test
    @Transactional
    void getVehicle() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get the vehicle
        restVehicleMockMvc
            .perform(get(ENTITY_API_URL_ID, vehicle.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(vehicle.getId().intValue()))
            .andExpect(jsonPath("$.plateNumber").value(DEFAULT_PLATE_NUMBER))
            .andExpect(jsonPath("$.model").value(DEFAULT_MODEL))
            .andExpect(jsonPath("$.capacity").value(DEFAULT_CAPACITY))
            .andExpect(jsonPath("$.seatLayout").value(DEFAULT_SEAT_LAYOUT))
            .andExpect(jsonPath("$.amenities").value(DEFAULT_AMENITIES))
            .andExpect(jsonPath("$.imageCoverUrl").value(DEFAULT_IMAGE_COVER_URL))
            .andExpect(jsonPath("$.averageRating").value(DEFAULT_AVERAGE_RATING))
            .andExpect(jsonPath("$.totalReviews").value(DEFAULT_TOTAL_REVIEWS))
            .andExpect(jsonPath("$.isActive").value(DEFAULT_IS_ACTIVE))
            .andExpect(jsonPath("$.yearManufactured").value(DEFAULT_YEAR_MANUFACTURED))
            .andExpect(jsonPath("$.lastMaintenanceDate").value(DEFAULT_LAST_MAINTENANCE_DATE.toString()));
    }

    @Test
    @Transactional
    void getVehiclesByIdFiltering() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        Long id = vehicle.getId();

        defaultVehicleFiltering("id.equals=" + id, "id.notEquals=" + id);

        defaultVehicleFiltering("id.greaterThanOrEqual=" + id, "id.greaterThan=" + id);

        defaultVehicleFiltering("id.lessThanOrEqual=" + id, "id.lessThan=" + id);
    }

    @Test
    @Transactional
    void getAllVehiclesByPlateNumberIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where plateNumber equals to
        defaultVehicleFiltering("plateNumber.equals=" + DEFAULT_PLATE_NUMBER, "plateNumber.equals=" + UPDATED_PLATE_NUMBER);
    }

    @Test
    @Transactional
    void getAllVehiclesByPlateNumberIsInShouldWork() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where plateNumber in
        defaultVehicleFiltering(
            "plateNumber.in=" + DEFAULT_PLATE_NUMBER + "," + UPDATED_PLATE_NUMBER,
            "plateNumber.in=" + UPDATED_PLATE_NUMBER
        );
    }

    @Test
    @Transactional
    void getAllVehiclesByPlateNumberIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where plateNumber is not null
        defaultVehicleFiltering("plateNumber.specified=true", "plateNumber.specified=false");
    }

    @Test
    @Transactional
    void getAllVehiclesByPlateNumberContainsSomething() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where plateNumber contains
        defaultVehicleFiltering("plateNumber.contains=" + DEFAULT_PLATE_NUMBER, "plateNumber.contains=" + UPDATED_PLATE_NUMBER);
    }

    @Test
    @Transactional
    void getAllVehiclesByPlateNumberNotContainsSomething() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where plateNumber does not contain
        defaultVehicleFiltering("plateNumber.doesNotContain=" + UPDATED_PLATE_NUMBER, "plateNumber.doesNotContain=" + DEFAULT_PLATE_NUMBER);
    }

    @Test
    @Transactional
    void getAllVehiclesByModelIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where model equals to
        defaultVehicleFiltering("model.equals=" + DEFAULT_MODEL, "model.equals=" + UPDATED_MODEL);
    }

    @Test
    @Transactional
    void getAllVehiclesByModelIsInShouldWork() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where model in
        defaultVehicleFiltering("model.in=" + DEFAULT_MODEL + "," + UPDATED_MODEL, "model.in=" + UPDATED_MODEL);
    }

    @Test
    @Transactional
    void getAllVehiclesByModelIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where model is not null
        defaultVehicleFiltering("model.specified=true", "model.specified=false");
    }

    @Test
    @Transactional
    void getAllVehiclesByModelContainsSomething() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where model contains
        defaultVehicleFiltering("model.contains=" + DEFAULT_MODEL, "model.contains=" + UPDATED_MODEL);
    }

    @Test
    @Transactional
    void getAllVehiclesByModelNotContainsSomething() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where model does not contain
        defaultVehicleFiltering("model.doesNotContain=" + UPDATED_MODEL, "model.doesNotContain=" + DEFAULT_MODEL);
    }

    @Test
    @Transactional
    void getAllVehiclesByCapacityIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where capacity equals to
        defaultVehicleFiltering("capacity.equals=" + DEFAULT_CAPACITY, "capacity.equals=" + UPDATED_CAPACITY);
    }

    @Test
    @Transactional
    void getAllVehiclesByCapacityIsInShouldWork() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where capacity in
        defaultVehicleFiltering("capacity.in=" + DEFAULT_CAPACITY + "," + UPDATED_CAPACITY, "capacity.in=" + UPDATED_CAPACITY);
    }

    @Test
    @Transactional
    void getAllVehiclesByCapacityIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where capacity is not null
        defaultVehicleFiltering("capacity.specified=true", "capacity.specified=false");
    }

    @Test
    @Transactional
    void getAllVehiclesByCapacityIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where capacity is greater than or equal to
        defaultVehicleFiltering("capacity.greaterThanOrEqual=" + DEFAULT_CAPACITY, "capacity.greaterThanOrEqual=" + UPDATED_CAPACITY);
    }

    @Test
    @Transactional
    void getAllVehiclesByCapacityIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where capacity is less than or equal to
        defaultVehicleFiltering("capacity.lessThanOrEqual=" + DEFAULT_CAPACITY, "capacity.lessThanOrEqual=" + SMALLER_CAPACITY);
    }

    @Test
    @Transactional
    void getAllVehiclesByCapacityIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where capacity is less than
        defaultVehicleFiltering("capacity.lessThan=" + UPDATED_CAPACITY, "capacity.lessThan=" + DEFAULT_CAPACITY);
    }

    @Test
    @Transactional
    void getAllVehiclesByCapacityIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where capacity is greater than
        defaultVehicleFiltering("capacity.greaterThan=" + SMALLER_CAPACITY, "capacity.greaterThan=" + DEFAULT_CAPACITY);
    }

    @Test
    @Transactional
    void getAllVehiclesBySeatLayoutIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where seatLayout equals to
        defaultVehicleFiltering("seatLayout.equals=" + DEFAULT_SEAT_LAYOUT, "seatLayout.equals=" + UPDATED_SEAT_LAYOUT);
    }

    @Test
    @Transactional
    void getAllVehiclesBySeatLayoutIsInShouldWork() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where seatLayout in
        defaultVehicleFiltering("seatLayout.in=" + DEFAULT_SEAT_LAYOUT + "," + UPDATED_SEAT_LAYOUT, "seatLayout.in=" + UPDATED_SEAT_LAYOUT);
    }

    @Test
    @Transactional
    void getAllVehiclesBySeatLayoutIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where seatLayout is not null
        defaultVehicleFiltering("seatLayout.specified=true", "seatLayout.specified=false");
    }

    @Test
    @Transactional
    void getAllVehiclesBySeatLayoutContainsSomething() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where seatLayout contains
        defaultVehicleFiltering("seatLayout.contains=" + DEFAULT_SEAT_LAYOUT, "seatLayout.contains=" + UPDATED_SEAT_LAYOUT);
    }

    @Test
    @Transactional
    void getAllVehiclesBySeatLayoutNotContainsSomething() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where seatLayout does not contain
        defaultVehicleFiltering("seatLayout.doesNotContain=" + UPDATED_SEAT_LAYOUT, "seatLayout.doesNotContain=" + DEFAULT_SEAT_LAYOUT);
    }

    @Test
    @Transactional
    void getAllVehiclesByAmenitiesIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where amenities equals to
        defaultVehicleFiltering("amenities.equals=" + DEFAULT_AMENITIES, "amenities.equals=" + UPDATED_AMENITIES);
    }

    @Test
    @Transactional
    void getAllVehiclesByAmenitiesIsInShouldWork() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where amenities in
        defaultVehicleFiltering("amenities.in=" + DEFAULT_AMENITIES + "," + UPDATED_AMENITIES, "amenities.in=" + UPDATED_AMENITIES);
    }

    @Test
    @Transactional
    void getAllVehiclesByAmenitiesIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where amenities is not null
        defaultVehicleFiltering("amenities.specified=true", "amenities.specified=false");
    }

    @Test
    @Transactional
    void getAllVehiclesByAmenitiesContainsSomething() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where amenities contains
        defaultVehicleFiltering("amenities.contains=" + DEFAULT_AMENITIES, "amenities.contains=" + UPDATED_AMENITIES);
    }

    @Test
    @Transactional
    void getAllVehiclesByAmenitiesNotContainsSomething() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where amenities does not contain
        defaultVehicleFiltering("amenities.doesNotContain=" + UPDATED_AMENITIES, "amenities.doesNotContain=" + DEFAULT_AMENITIES);
    }

    @Test
    @Transactional
    void getAllVehiclesByImageCoverUrlIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where imageCoverUrl equals to
        defaultVehicleFiltering("imageCoverUrl.equals=" + DEFAULT_IMAGE_COVER_URL, "imageCoverUrl.equals=" + UPDATED_IMAGE_COVER_URL);
    }

    @Test
    @Transactional
    void getAllVehiclesByImageCoverUrlIsInShouldWork() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where imageCoverUrl in
        defaultVehicleFiltering(
            "imageCoverUrl.in=" + DEFAULT_IMAGE_COVER_URL + "," + UPDATED_IMAGE_COVER_URL,
            "imageCoverUrl.in=" + UPDATED_IMAGE_COVER_URL
        );
    }

    @Test
    @Transactional
    void getAllVehiclesByImageCoverUrlIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where imageCoverUrl is not null
        defaultVehicleFiltering("imageCoverUrl.specified=true", "imageCoverUrl.specified=false");
    }

    @Test
    @Transactional
    void getAllVehiclesByImageCoverUrlContainsSomething() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where imageCoverUrl contains
        defaultVehicleFiltering("imageCoverUrl.contains=" + DEFAULT_IMAGE_COVER_URL, "imageCoverUrl.contains=" + UPDATED_IMAGE_COVER_URL);
    }

    @Test
    @Transactional
    void getAllVehiclesByImageCoverUrlNotContainsSomething() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where imageCoverUrl does not contain
        defaultVehicleFiltering(
            "imageCoverUrl.doesNotContain=" + UPDATED_IMAGE_COVER_URL,
            "imageCoverUrl.doesNotContain=" + DEFAULT_IMAGE_COVER_URL
        );
    }

    @Test
    @Transactional
    void getAllVehiclesByAverageRatingIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where averageRating equals to
        defaultVehicleFiltering("averageRating.equals=" + DEFAULT_AVERAGE_RATING, "averageRating.equals=" + UPDATED_AVERAGE_RATING);
    }

    @Test
    @Transactional
    void getAllVehiclesByAverageRatingIsInShouldWork() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where averageRating in
        defaultVehicleFiltering(
            "averageRating.in=" + DEFAULT_AVERAGE_RATING + "," + UPDATED_AVERAGE_RATING,
            "averageRating.in=" + UPDATED_AVERAGE_RATING
        );
    }

    @Test
    @Transactional
    void getAllVehiclesByAverageRatingIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where averageRating is not null
        defaultVehicleFiltering("averageRating.specified=true", "averageRating.specified=false");
    }

    @Test
    @Transactional
    void getAllVehiclesByAverageRatingIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where averageRating is greater than or equal to
        defaultVehicleFiltering(
            "averageRating.greaterThanOrEqual=" + DEFAULT_AVERAGE_RATING,
            "averageRating.greaterThanOrEqual=" + UPDATED_AVERAGE_RATING
        );
    }

    @Test
    @Transactional
    void getAllVehiclesByAverageRatingIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where averageRating is less than or equal to
        defaultVehicleFiltering(
            "averageRating.lessThanOrEqual=" + DEFAULT_AVERAGE_RATING,
            "averageRating.lessThanOrEqual=" + SMALLER_AVERAGE_RATING
        );
    }

    @Test
    @Transactional
    void getAllVehiclesByAverageRatingIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where averageRating is less than
        defaultVehicleFiltering("averageRating.lessThan=" + UPDATED_AVERAGE_RATING, "averageRating.lessThan=" + DEFAULT_AVERAGE_RATING);
    }

    @Test
    @Transactional
    void getAllVehiclesByAverageRatingIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where averageRating is greater than
        defaultVehicleFiltering(
            "averageRating.greaterThan=" + SMALLER_AVERAGE_RATING,
            "averageRating.greaterThan=" + DEFAULT_AVERAGE_RATING
        );
    }

    @Test
    @Transactional
    void getAllVehiclesByTotalReviewsIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where totalReviews equals to
        defaultVehicleFiltering("totalReviews.equals=" + DEFAULT_TOTAL_REVIEWS, "totalReviews.equals=" + UPDATED_TOTAL_REVIEWS);
    }

    @Test
    @Transactional
    void getAllVehiclesByTotalReviewsIsInShouldWork() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where totalReviews in
        defaultVehicleFiltering(
            "totalReviews.in=" + DEFAULT_TOTAL_REVIEWS + "," + UPDATED_TOTAL_REVIEWS,
            "totalReviews.in=" + UPDATED_TOTAL_REVIEWS
        );
    }

    @Test
    @Transactional
    void getAllVehiclesByTotalReviewsIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where totalReviews is not null
        defaultVehicleFiltering("totalReviews.specified=true", "totalReviews.specified=false");
    }

    @Test
    @Transactional
    void getAllVehiclesByTotalReviewsIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where totalReviews is greater than or equal to
        defaultVehicleFiltering(
            "totalReviews.greaterThanOrEqual=" + DEFAULT_TOTAL_REVIEWS,
            "totalReviews.greaterThanOrEqual=" + UPDATED_TOTAL_REVIEWS
        );
    }

    @Test
    @Transactional
    void getAllVehiclesByTotalReviewsIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where totalReviews is less than or equal to
        defaultVehicleFiltering(
            "totalReviews.lessThanOrEqual=" + DEFAULT_TOTAL_REVIEWS,
            "totalReviews.lessThanOrEqual=" + SMALLER_TOTAL_REVIEWS
        );
    }

    @Test
    @Transactional
    void getAllVehiclesByTotalReviewsIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where totalReviews is less than
        defaultVehicleFiltering("totalReviews.lessThan=" + UPDATED_TOTAL_REVIEWS, "totalReviews.lessThan=" + DEFAULT_TOTAL_REVIEWS);
    }

    @Test
    @Transactional
    void getAllVehiclesByTotalReviewsIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where totalReviews is greater than
        defaultVehicleFiltering("totalReviews.greaterThan=" + SMALLER_TOTAL_REVIEWS, "totalReviews.greaterThan=" + DEFAULT_TOTAL_REVIEWS);
    }

    @Test
    @Transactional
    void getAllVehiclesByIsActiveIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where isActive equals to
        defaultVehicleFiltering("isActive.equals=" + DEFAULT_IS_ACTIVE, "isActive.equals=" + UPDATED_IS_ACTIVE);
    }

    @Test
    @Transactional
    void getAllVehiclesByIsActiveIsInShouldWork() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where isActive in
        defaultVehicleFiltering("isActive.in=" + DEFAULT_IS_ACTIVE + "," + UPDATED_IS_ACTIVE, "isActive.in=" + UPDATED_IS_ACTIVE);
    }

    @Test
    @Transactional
    void getAllVehiclesByIsActiveIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where isActive is not null
        defaultVehicleFiltering("isActive.specified=true", "isActive.specified=false");
    }

    @Test
    @Transactional
    void getAllVehiclesByYearManufacturedIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where yearManufactured equals to
        defaultVehicleFiltering(
            "yearManufactured.equals=" + DEFAULT_YEAR_MANUFACTURED,
            "yearManufactured.equals=" + UPDATED_YEAR_MANUFACTURED
        );
    }

    @Test
    @Transactional
    void getAllVehiclesByYearManufacturedIsInShouldWork() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where yearManufactured in
        defaultVehicleFiltering(
            "yearManufactured.in=" + DEFAULT_YEAR_MANUFACTURED + "," + UPDATED_YEAR_MANUFACTURED,
            "yearManufactured.in=" + UPDATED_YEAR_MANUFACTURED
        );
    }

    @Test
    @Transactional
    void getAllVehiclesByYearManufacturedIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where yearManufactured is not null
        defaultVehicleFiltering("yearManufactured.specified=true", "yearManufactured.specified=false");
    }

    @Test
    @Transactional
    void getAllVehiclesByYearManufacturedIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where yearManufactured is greater than or equal to
        defaultVehicleFiltering(
            "yearManufactured.greaterThanOrEqual=" + DEFAULT_YEAR_MANUFACTURED,
            "yearManufactured.greaterThanOrEqual=" + UPDATED_YEAR_MANUFACTURED
        );
    }

    @Test
    @Transactional
    void getAllVehiclesByYearManufacturedIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where yearManufactured is less than or equal to
        defaultVehicleFiltering(
            "yearManufactured.lessThanOrEqual=" + DEFAULT_YEAR_MANUFACTURED,
            "yearManufactured.lessThanOrEqual=" + SMALLER_YEAR_MANUFACTURED
        );
    }

    @Test
    @Transactional
    void getAllVehiclesByYearManufacturedIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where yearManufactured is less than
        defaultVehicleFiltering(
            "yearManufactured.lessThan=" + UPDATED_YEAR_MANUFACTURED,
            "yearManufactured.lessThan=" + DEFAULT_YEAR_MANUFACTURED
        );
    }

    @Test
    @Transactional
    void getAllVehiclesByYearManufacturedIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where yearManufactured is greater than
        defaultVehicleFiltering(
            "yearManufactured.greaterThan=" + SMALLER_YEAR_MANUFACTURED,
            "yearManufactured.greaterThan=" + DEFAULT_YEAR_MANUFACTURED
        );
    }

    @Test
    @Transactional
    void getAllVehiclesByLastMaintenanceDateIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where lastMaintenanceDate equals to
        defaultVehicleFiltering(
            "lastMaintenanceDate.equals=" + DEFAULT_LAST_MAINTENANCE_DATE,
            "lastMaintenanceDate.equals=" + UPDATED_LAST_MAINTENANCE_DATE
        );
    }

    @Test
    @Transactional
    void getAllVehiclesByLastMaintenanceDateIsInShouldWork() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where lastMaintenanceDate in
        defaultVehicleFiltering(
            "lastMaintenanceDate.in=" + DEFAULT_LAST_MAINTENANCE_DATE + "," + UPDATED_LAST_MAINTENANCE_DATE,
            "lastMaintenanceDate.in=" + UPDATED_LAST_MAINTENANCE_DATE
        );
    }

    @Test
    @Transactional
    void getAllVehiclesByLastMaintenanceDateIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where lastMaintenanceDate is not null
        defaultVehicleFiltering("lastMaintenanceDate.specified=true", "lastMaintenanceDate.specified=false");
    }

    @Test
    @Transactional
    void getAllVehiclesByLastMaintenanceDateIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where lastMaintenanceDate is greater than or equal to
        defaultVehicleFiltering(
            "lastMaintenanceDate.greaterThanOrEqual=" + DEFAULT_LAST_MAINTENANCE_DATE,
            "lastMaintenanceDate.greaterThanOrEqual=" + UPDATED_LAST_MAINTENANCE_DATE
        );
    }

    @Test
    @Transactional
    void getAllVehiclesByLastMaintenanceDateIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where lastMaintenanceDate is less than or equal to
        defaultVehicleFiltering(
            "lastMaintenanceDate.lessThanOrEqual=" + DEFAULT_LAST_MAINTENANCE_DATE,
            "lastMaintenanceDate.lessThanOrEqual=" + SMALLER_LAST_MAINTENANCE_DATE
        );
    }

    @Test
    @Transactional
    void getAllVehiclesByLastMaintenanceDateIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where lastMaintenanceDate is less than
        defaultVehicleFiltering(
            "lastMaintenanceDate.lessThan=" + UPDATED_LAST_MAINTENANCE_DATE,
            "lastMaintenanceDate.lessThan=" + DEFAULT_LAST_MAINTENANCE_DATE
        );
    }

    @Test
    @Transactional
    void getAllVehiclesByLastMaintenanceDateIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        // Get all the vehicleList where lastMaintenanceDate is greater than
        defaultVehicleFiltering(
            "lastMaintenanceDate.greaterThan=" + SMALLER_LAST_MAINTENANCE_DATE,
            "lastMaintenanceDate.greaterThan=" + DEFAULT_LAST_MAINTENANCE_DATE
        );
    }

    @Test
    @Transactional
    void getAllVehiclesBySummaryIsEqualToSomething() throws Exception {
        ReviewSummary summary;
        if (TestUtil.findAll(em, ReviewSummary.class).isEmpty()) {
            vehicleRepository.saveAndFlush(vehicle);
            summary = ReviewSummaryResourceIT.createEntity(em);
        } else {
            summary = TestUtil.findAll(em, ReviewSummary.class).get(0);
        }
        em.persist(summary);
        em.flush();
        vehicle.setSummary(summary);
        vehicleRepository.saveAndFlush(vehicle);
        Long summaryId = summary.getId();
        // Get all the vehicleList where summary equals to summaryId
        defaultVehicleShouldBeFound("summaryId.equals=" + summaryId);

        // Get all the vehicleList where summary equals to (summaryId + 1)
        defaultVehicleShouldNotBeFound("summaryId.equals=" + (summaryId + 1));
    }

    @Test
    @Transactional
    void getAllVehiclesByHomeStationIsEqualToSomething() throws Exception {
        Station homeStation;
        if (TestUtil.findAll(em, Station.class).isEmpty()) {
            vehicleRepository.saveAndFlush(vehicle);
            homeStation = StationResourceIT.createEntity();
        } else {
            homeStation = TestUtil.findAll(em, Station.class).get(0);
        }
        em.persist(homeStation);
        em.flush();
        vehicle.setHomeStation(homeStation);
        vehicleRepository.saveAndFlush(vehicle);
        Long homeStationId = homeStation.getId();
        // Get all the vehicleList where homeStation equals to homeStationId
        defaultVehicleShouldBeFound("homeStationId.equals=" + homeStationId);

        // Get all the vehicleList where homeStation equals to (homeStationId + 1)
        defaultVehicleShouldNotBeFound("homeStationId.equals=" + (homeStationId + 1));
    }

    @Test
    @Transactional
    void getAllVehiclesByOperatorIsEqualToSomething() throws Exception {
        Operator operator;
        if (TestUtil.findAll(em, Operator.class).isEmpty()) {
            vehicleRepository.saveAndFlush(vehicle);
            operator = OperatorResourceIT.createEntity();
        } else {
            operator = TestUtil.findAll(em, Operator.class).get(0);
        }
        em.persist(operator);
        em.flush();
        vehicle.setOperator(operator);
        vehicleRepository.saveAndFlush(vehicle);
        Long operatorId = operator.getId();
        // Get all the vehicleList where operator equals to operatorId
        defaultVehicleShouldBeFound("operatorId.equals=" + operatorId);

        // Get all the vehicleList where operator equals to (operatorId + 1)
        defaultVehicleShouldNotBeFound("operatorId.equals=" + (operatorId + 1));
    }

    private void defaultVehicleFiltering(String shouldBeFound, String shouldNotBeFound) throws Exception {
        defaultVehicleShouldBeFound(shouldBeFound);
        defaultVehicleShouldNotBeFound(shouldNotBeFound);
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultVehicleShouldBeFound(String filter) throws Exception {
        restVehicleMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(vehicle.getId().intValue())))
            .andExpect(jsonPath("$.[*].plateNumber").value(hasItem(DEFAULT_PLATE_NUMBER)))
            .andExpect(jsonPath("$.[*].model").value(hasItem(DEFAULT_MODEL)))
            .andExpect(jsonPath("$.[*].capacity").value(hasItem(DEFAULT_CAPACITY)))
            .andExpect(jsonPath("$.[*].seatLayout").value(hasItem(DEFAULT_SEAT_LAYOUT)))
            .andExpect(jsonPath("$.[*].amenities").value(hasItem(DEFAULT_AMENITIES)))
            .andExpect(jsonPath("$.[*].imageCoverUrl").value(hasItem(DEFAULT_IMAGE_COVER_URL)))
            .andExpect(jsonPath("$.[*].averageRating").value(hasItem(DEFAULT_AVERAGE_RATING)))
            .andExpect(jsonPath("$.[*].totalReviews").value(hasItem(DEFAULT_TOTAL_REVIEWS)))
            .andExpect(jsonPath("$.[*].isActive").value(hasItem(DEFAULT_IS_ACTIVE)))
            .andExpect(jsonPath("$.[*].yearManufactured").value(hasItem(DEFAULT_YEAR_MANUFACTURED)))
            .andExpect(jsonPath("$.[*].lastMaintenanceDate").value(hasItem(DEFAULT_LAST_MAINTENANCE_DATE.toString())));

        // Check, that the count call also returns 1
        restVehicleMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("1"));
    }

    /**
     * Executes the search, and checks that the default entity is not returned.
     */
    private void defaultVehicleShouldNotBeFound(String filter) throws Exception {
        restVehicleMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());

        // Check, that the count call also returns 0
        restVehicleMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("0"));
    }

    @Test
    @Transactional
    void getNonExistingVehicle() throws Exception {
        // Get the vehicle
        restVehicleMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingVehicle() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the vehicle
        Vehicle updatedVehicle = vehicleRepository.findById(vehicle.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedVehicle are not directly saved in db
        em.detach(updatedVehicle);
        updatedVehicle
            .plateNumber(UPDATED_PLATE_NUMBER)
            .model(UPDATED_MODEL)
            .capacity(UPDATED_CAPACITY)
            .seatLayout(UPDATED_SEAT_LAYOUT)
            .amenities(UPDATED_AMENITIES)
            .imageCoverUrl(UPDATED_IMAGE_COVER_URL)
            .averageRating(UPDATED_AVERAGE_RATING)
            .totalReviews(UPDATED_TOTAL_REVIEWS)
            .isActive(UPDATED_IS_ACTIVE)
            .yearManufactured(UPDATED_YEAR_MANUFACTURED)
            .lastMaintenanceDate(UPDATED_LAST_MAINTENANCE_DATE);
        VehicleDTO vehicleDTO = vehicleMapper.toDto(updatedVehicle);

        restVehicleMockMvc
            .perform(
                put(ENTITY_API_URL_ID, vehicleDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(vehicleDTO))
            )
            .andExpect(status().isOk());

        // Validate the Vehicle in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedVehicleToMatchAllProperties(updatedVehicle);
    }

    @Test
    @Transactional
    void putNonExistingVehicle() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        vehicle.setId(longCount.incrementAndGet());

        // Create the Vehicle
        VehicleDTO vehicleDTO = vehicleMapper.toDto(vehicle);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restVehicleMockMvc
            .perform(
                put(ENTITY_API_URL_ID, vehicleDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(vehicleDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Vehicle in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchVehicle() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        vehicle.setId(longCount.incrementAndGet());

        // Create the Vehicle
        VehicleDTO vehicleDTO = vehicleMapper.toDto(vehicle);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restVehicleMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(vehicleDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Vehicle in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamVehicle() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        vehicle.setId(longCount.incrementAndGet());

        // Create the Vehicle
        VehicleDTO vehicleDTO = vehicleMapper.toDto(vehicle);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restVehicleMockMvc
            .perform(put(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(vehicleDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Vehicle in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateVehicleWithPatch() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the vehicle using partial update
        Vehicle partialUpdatedVehicle = new Vehicle();
        partialUpdatedVehicle.setId(vehicle.getId());

        partialUpdatedVehicle
            .plateNumber(UPDATED_PLATE_NUMBER)
            .amenities(UPDATED_AMENITIES)
            .imageCoverUrl(UPDATED_IMAGE_COVER_URL)
            .averageRating(UPDATED_AVERAGE_RATING)
            .lastMaintenanceDate(UPDATED_LAST_MAINTENANCE_DATE);

        restVehicleMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedVehicle.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedVehicle))
            )
            .andExpect(status().isOk());

        // Validate the Vehicle in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertVehicleUpdatableFieldsEquals(createUpdateProxyForBean(partialUpdatedVehicle, vehicle), getPersistedVehicle(vehicle));
    }

    @Test
    @Transactional
    void fullUpdateVehicleWithPatch() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the vehicle using partial update
        Vehicle partialUpdatedVehicle = new Vehicle();
        partialUpdatedVehicle.setId(vehicle.getId());

        partialUpdatedVehicle
            .plateNumber(UPDATED_PLATE_NUMBER)
            .model(UPDATED_MODEL)
            .capacity(UPDATED_CAPACITY)
            .seatLayout(UPDATED_SEAT_LAYOUT)
            .amenities(UPDATED_AMENITIES)
            .imageCoverUrl(UPDATED_IMAGE_COVER_URL)
            .averageRating(UPDATED_AVERAGE_RATING)
            .totalReviews(UPDATED_TOTAL_REVIEWS)
            .isActive(UPDATED_IS_ACTIVE)
            .yearManufactured(UPDATED_YEAR_MANUFACTURED)
            .lastMaintenanceDate(UPDATED_LAST_MAINTENANCE_DATE);

        restVehicleMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedVehicle.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedVehicle))
            )
            .andExpect(status().isOk());

        // Validate the Vehicle in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertVehicleUpdatableFieldsEquals(partialUpdatedVehicle, getPersistedVehicle(partialUpdatedVehicle));
    }

    @Test
    @Transactional
    void patchNonExistingVehicle() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        vehicle.setId(longCount.incrementAndGet());

        // Create the Vehicle
        VehicleDTO vehicleDTO = vehicleMapper.toDto(vehicle);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restVehicleMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, vehicleDTO.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(vehicleDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Vehicle in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchVehicle() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        vehicle.setId(longCount.incrementAndGet());

        // Create the Vehicle
        VehicleDTO vehicleDTO = vehicleMapper.toDto(vehicle);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restVehicleMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(vehicleDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Vehicle in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamVehicle() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        vehicle.setId(longCount.incrementAndGet());

        // Create the Vehicle
        VehicleDTO vehicleDTO = vehicleMapper.toDto(vehicle);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restVehicleMockMvc
            .perform(
                patch(ENTITY_API_URL).with(csrf()).contentType("application/merge-patch+json").content(om.writeValueAsBytes(vehicleDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the Vehicle in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteVehicle() throws Exception {
        // Initialize the database
        insertedVehicle = vehicleRepository.saveAndFlush(vehicle);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the vehicle
        restVehicleMockMvc
            .perform(delete(ENTITY_API_URL_ID, vehicle.getId()).with(csrf()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return vehicleRepository.count();
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

    protected Vehicle getPersistedVehicle(Vehicle vehicle) {
        return vehicleRepository.findById(vehicle.getId()).orElseThrow();
    }

    protected void assertPersistedVehicleToMatchAllProperties(Vehicle expectedVehicle) {
        assertVehicleAllPropertiesEquals(expectedVehicle, getPersistedVehicle(expectedVehicle));
    }

    protected void assertPersistedVehicleToMatchUpdatableProperties(Vehicle expectedVehicle) {
        assertVehicleAllUpdatablePropertiesEquals(expectedVehicle, getPersistedVehicle(expectedVehicle));
    }
}
