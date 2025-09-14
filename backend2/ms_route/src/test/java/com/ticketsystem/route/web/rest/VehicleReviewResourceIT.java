package com.ticketsystem.route.web.rest;

import static com.ticketsystem.route.domain.VehicleReviewAsserts.*;
import static com.ticketsystem.route.web.rest.TestUtil.createUpdateProxyForBean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketsystem.route.IntegrationTest;
import com.ticketsystem.route.domain.Vehicle;
import com.ticketsystem.route.domain.VehicleReview;
import com.ticketsystem.route.repository.VehicleReviewRepository;
import com.ticketsystem.route.service.dto.VehicleReviewDTO;
import com.ticketsystem.route.service.mapper.VehicleReviewMapper;
import jakarta.persistence.EntityManager;
import java.time.Instant;
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
 * Integration tests for the {@link VehicleReviewResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class VehicleReviewResourceIT {

    private static final UUID DEFAULT_USER_ID = UUID.randomUUID();
    private static final UUID UPDATED_USER_ID = UUID.randomUUID();

    private static final UUID DEFAULT_TRIP_ID = UUID.randomUUID();
    private static final UUID UPDATED_TRIP_ID = UUID.randomUUID();

    private static final Integer DEFAULT_RATING = 1;
    private static final Integer UPDATED_RATING = 2;
    private static final Integer SMALLER_RATING = 1 - 1;

    private static final String DEFAULT_COMMENT = "AAAAAAAAAA";
    private static final String UPDATED_COMMENT = "BBBBBBBBBB";

    private static final Integer DEFAULT_CLEANLINESS = 1;
    private static final Integer UPDATED_CLEANLINESS = 2;
    private static final Integer SMALLER_CLEANLINESS = 1 - 1;

    private static final Integer DEFAULT_COMFORT = 1;
    private static final Integer UPDATED_COMFORT = 2;
    private static final Integer SMALLER_COMFORT = 1 - 1;

    private static final Integer DEFAULT_PUNCTUALITY = 1;
    private static final Integer UPDATED_PUNCTUALITY = 2;
    private static final Integer SMALLER_PUNCTUALITY = 1 - 1;

    private static final Integer DEFAULT_STAFF_SERVICE = 1;
    private static final Integer UPDATED_STAFF_SERVICE = 2;
    private static final Integer SMALLER_STAFF_SERVICE = 1 - 1;

    private static final Instant DEFAULT_CREATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Boolean DEFAULT_IS_VERIFIED = false;
    private static final Boolean UPDATED_IS_VERIFIED = true;

    private static final String ENTITY_API_URL = "/api/vehicle-reviews";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private VehicleReviewRepository vehicleReviewRepository;

    @Autowired
    private VehicleReviewMapper vehicleReviewMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restVehicleReviewMockMvc;

    private VehicleReview vehicleReview;

    private VehicleReview insertedVehicleReview;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static VehicleReview createEntity(EntityManager em) {
        VehicleReview vehicleReview = new VehicleReview()
            .userId(DEFAULT_USER_ID)
            .tripId(DEFAULT_TRIP_ID)
            .rating(DEFAULT_RATING)
            .comment(DEFAULT_COMMENT)
            .cleanliness(DEFAULT_CLEANLINESS)
            .comfort(DEFAULT_COMFORT)
            .punctuality(DEFAULT_PUNCTUALITY)
            .staffService(DEFAULT_STAFF_SERVICE)
            .createdAt(DEFAULT_CREATED_AT)
            .isVerified(DEFAULT_IS_VERIFIED);
        // Add required entity
        Vehicle vehicle;
        if (TestUtil.findAll(em, Vehicle.class).isEmpty()) {
            vehicle = VehicleResourceIT.createEntity(em);
            em.persist(vehicle);
            em.flush();
        } else {
            vehicle = TestUtil.findAll(em, Vehicle.class).get(0);
        }
        vehicleReview.setVehicle(vehicle);
        return vehicleReview;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static VehicleReview createUpdatedEntity(EntityManager em) {
        VehicleReview updatedVehicleReview = new VehicleReview()
            .userId(UPDATED_USER_ID)
            .tripId(UPDATED_TRIP_ID)
            .rating(UPDATED_RATING)
            .comment(UPDATED_COMMENT)
            .cleanliness(UPDATED_CLEANLINESS)
            .comfort(UPDATED_COMFORT)
            .punctuality(UPDATED_PUNCTUALITY)
            .staffService(UPDATED_STAFF_SERVICE)
            .createdAt(UPDATED_CREATED_AT)
            .isVerified(UPDATED_IS_VERIFIED);
        // Add required entity
        Vehicle vehicle;
        if (TestUtil.findAll(em, Vehicle.class).isEmpty()) {
            vehicle = VehicleResourceIT.createUpdatedEntity(em);
            em.persist(vehicle);
            em.flush();
        } else {
            vehicle = TestUtil.findAll(em, Vehicle.class).get(0);
        }
        updatedVehicleReview.setVehicle(vehicle);
        return updatedVehicleReview;
    }

    @BeforeEach
    void initTest() {
        vehicleReview = createEntity(em);
    }

    @AfterEach
    void cleanup() {
        if (insertedVehicleReview != null) {
            vehicleReviewRepository.delete(insertedVehicleReview);
            insertedVehicleReview = null;
        }
    }

    @Test
    @Transactional
    void createVehicleReview() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the VehicleReview
        VehicleReviewDTO vehicleReviewDTO = vehicleReviewMapper.toDto(vehicleReview);
        var returnedVehicleReviewDTO = om.readValue(
            restVehicleReviewMockMvc
                .perform(
                    post(ENTITY_API_URL)
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsBytes(vehicleReviewDTO))
                )
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            VehicleReviewDTO.class
        );

        // Validate the VehicleReview in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        var returnedVehicleReview = vehicleReviewMapper.toEntity(returnedVehicleReviewDTO);
        assertVehicleReviewUpdatableFieldsEquals(returnedVehicleReview, getPersistedVehicleReview(returnedVehicleReview));

        insertedVehicleReview = returnedVehicleReview;
    }

    @Test
    @Transactional
    void createVehicleReviewWithExistingId() throws Exception {
        // Create the VehicleReview with an existing ID
        vehicleReview.setId(1L);
        VehicleReviewDTO vehicleReviewDTO = vehicleReviewMapper.toDto(vehicleReview);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restVehicleReviewMockMvc
            .perform(
                post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(vehicleReviewDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the VehicleReview in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkUserIdIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        vehicleReview.setUserId(null);

        // Create the VehicleReview, which fails.
        VehicleReviewDTO vehicleReviewDTO = vehicleReviewMapper.toDto(vehicleReview);

        restVehicleReviewMockMvc
            .perform(
                post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(vehicleReviewDTO))
            )
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkRatingIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        vehicleReview.setRating(null);

        // Create the VehicleReview, which fails.
        VehicleReviewDTO vehicleReviewDTO = vehicleReviewMapper.toDto(vehicleReview);

        restVehicleReviewMockMvc
            .perform(
                post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(vehicleReviewDTO))
            )
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkCreatedAtIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        vehicleReview.setCreatedAt(null);

        // Create the VehicleReview, which fails.
        VehicleReviewDTO vehicleReviewDTO = vehicleReviewMapper.toDto(vehicleReview);

        restVehicleReviewMockMvc
            .perform(
                post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(vehicleReviewDTO))
            )
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllVehicleReviews() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList
        restVehicleReviewMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(vehicleReview.getId().intValue())))
            .andExpect(jsonPath("$.[*].userId").value(hasItem(DEFAULT_USER_ID.toString())))
            .andExpect(jsonPath("$.[*].tripId").value(hasItem(DEFAULT_TRIP_ID.toString())))
            .andExpect(jsonPath("$.[*].rating").value(hasItem(DEFAULT_RATING)))
            .andExpect(jsonPath("$.[*].comment").value(hasItem(DEFAULT_COMMENT)))
            .andExpect(jsonPath("$.[*].cleanliness").value(hasItem(DEFAULT_CLEANLINESS)))
            .andExpect(jsonPath("$.[*].comfort").value(hasItem(DEFAULT_COMFORT)))
            .andExpect(jsonPath("$.[*].punctuality").value(hasItem(DEFAULT_PUNCTUALITY)))
            .andExpect(jsonPath("$.[*].staffService").value(hasItem(DEFAULT_STAFF_SERVICE)))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].isVerified").value(hasItem(DEFAULT_IS_VERIFIED)));
    }

    @Test
    @Transactional
    void getVehicleReview() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get the vehicleReview
        restVehicleReviewMockMvc
            .perform(get(ENTITY_API_URL_ID, vehicleReview.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(vehicleReview.getId().intValue()))
            .andExpect(jsonPath("$.userId").value(DEFAULT_USER_ID.toString()))
            .andExpect(jsonPath("$.tripId").value(DEFAULT_TRIP_ID.toString()))
            .andExpect(jsonPath("$.rating").value(DEFAULT_RATING))
            .andExpect(jsonPath("$.comment").value(DEFAULT_COMMENT))
            .andExpect(jsonPath("$.cleanliness").value(DEFAULT_CLEANLINESS))
            .andExpect(jsonPath("$.comfort").value(DEFAULT_COMFORT))
            .andExpect(jsonPath("$.punctuality").value(DEFAULT_PUNCTUALITY))
            .andExpect(jsonPath("$.staffService").value(DEFAULT_STAFF_SERVICE))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.isVerified").value(DEFAULT_IS_VERIFIED));
    }

    @Test
    @Transactional
    void getVehicleReviewsByIdFiltering() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        Long id = vehicleReview.getId();

        defaultVehicleReviewFiltering("id.equals=" + id, "id.notEquals=" + id);

        defaultVehicleReviewFiltering("id.greaterThanOrEqual=" + id, "id.greaterThan=" + id);

        defaultVehicleReviewFiltering("id.lessThanOrEqual=" + id, "id.lessThan=" + id);
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByUserIdIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where userId equals to
        defaultVehicleReviewFiltering("userId.equals=" + DEFAULT_USER_ID, "userId.equals=" + UPDATED_USER_ID);
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByUserIdIsInShouldWork() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where userId in
        defaultVehicleReviewFiltering("userId.in=" + DEFAULT_USER_ID + "," + UPDATED_USER_ID, "userId.in=" + UPDATED_USER_ID);
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByUserIdIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where userId is not null
        defaultVehicleReviewFiltering("userId.specified=true", "userId.specified=false");
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByTripIdIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where tripId equals to
        defaultVehicleReviewFiltering("tripId.equals=" + DEFAULT_TRIP_ID, "tripId.equals=" + UPDATED_TRIP_ID);
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByTripIdIsInShouldWork() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where tripId in
        defaultVehicleReviewFiltering("tripId.in=" + DEFAULT_TRIP_ID + "," + UPDATED_TRIP_ID, "tripId.in=" + UPDATED_TRIP_ID);
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByTripIdIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where tripId is not null
        defaultVehicleReviewFiltering("tripId.specified=true", "tripId.specified=false");
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByRatingIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where rating equals to
        defaultVehicleReviewFiltering("rating.equals=" + DEFAULT_RATING, "rating.equals=" + UPDATED_RATING);
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByRatingIsInShouldWork() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where rating in
        defaultVehicleReviewFiltering("rating.in=" + DEFAULT_RATING + "," + UPDATED_RATING, "rating.in=" + UPDATED_RATING);
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByRatingIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where rating is not null
        defaultVehicleReviewFiltering("rating.specified=true", "rating.specified=false");
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByRatingIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where rating is greater than or equal to
        defaultVehicleReviewFiltering("rating.greaterThanOrEqual=" + DEFAULT_RATING, "rating.greaterThanOrEqual=" + (DEFAULT_RATING + 1));
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByRatingIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where rating is less than or equal to
        defaultVehicleReviewFiltering("rating.lessThanOrEqual=" + DEFAULT_RATING, "rating.lessThanOrEqual=" + SMALLER_RATING);
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByRatingIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where rating is less than
        defaultVehicleReviewFiltering("rating.lessThan=" + (DEFAULT_RATING + 1), "rating.lessThan=" + DEFAULT_RATING);
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByRatingIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where rating is greater than
        defaultVehicleReviewFiltering("rating.greaterThan=" + SMALLER_RATING, "rating.greaterThan=" + DEFAULT_RATING);
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByCommentIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where comment equals to
        defaultVehicleReviewFiltering("comment.equals=" + DEFAULT_COMMENT, "comment.equals=" + UPDATED_COMMENT);
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByCommentIsInShouldWork() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where comment in
        defaultVehicleReviewFiltering("comment.in=" + DEFAULT_COMMENT + "," + UPDATED_COMMENT, "comment.in=" + UPDATED_COMMENT);
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByCommentIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where comment is not null
        defaultVehicleReviewFiltering("comment.specified=true", "comment.specified=false");
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByCommentContainsSomething() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where comment contains
        defaultVehicleReviewFiltering("comment.contains=" + DEFAULT_COMMENT, "comment.contains=" + UPDATED_COMMENT);
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByCommentNotContainsSomething() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where comment does not contain
        defaultVehicleReviewFiltering("comment.doesNotContain=" + UPDATED_COMMENT, "comment.doesNotContain=" + DEFAULT_COMMENT);
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByCleanlinessIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where cleanliness equals to
        defaultVehicleReviewFiltering("cleanliness.equals=" + DEFAULT_CLEANLINESS, "cleanliness.equals=" + UPDATED_CLEANLINESS);
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByCleanlinessIsInShouldWork() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where cleanliness in
        defaultVehicleReviewFiltering(
            "cleanliness.in=" + DEFAULT_CLEANLINESS + "," + UPDATED_CLEANLINESS,
            "cleanliness.in=" + UPDATED_CLEANLINESS
        );
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByCleanlinessIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where cleanliness is not null
        defaultVehicleReviewFiltering("cleanliness.specified=true", "cleanliness.specified=false");
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByCleanlinessIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where cleanliness is greater than or equal to
        defaultVehicleReviewFiltering(
            "cleanliness.greaterThanOrEqual=" + DEFAULT_CLEANLINESS,
            "cleanliness.greaterThanOrEqual=" + (DEFAULT_CLEANLINESS + 1)
        );
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByCleanlinessIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where cleanliness is less than or equal to
        defaultVehicleReviewFiltering(
            "cleanliness.lessThanOrEqual=" + DEFAULT_CLEANLINESS,
            "cleanliness.lessThanOrEqual=" + SMALLER_CLEANLINESS
        );
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByCleanlinessIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where cleanliness is less than
        defaultVehicleReviewFiltering("cleanliness.lessThan=" + (DEFAULT_CLEANLINESS + 1), "cleanliness.lessThan=" + DEFAULT_CLEANLINESS);
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByCleanlinessIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where cleanliness is greater than
        defaultVehicleReviewFiltering("cleanliness.greaterThan=" + SMALLER_CLEANLINESS, "cleanliness.greaterThan=" + DEFAULT_CLEANLINESS);
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByComfortIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where comfort equals to
        defaultVehicleReviewFiltering("comfort.equals=" + DEFAULT_COMFORT, "comfort.equals=" + UPDATED_COMFORT);
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByComfortIsInShouldWork() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where comfort in
        defaultVehicleReviewFiltering("comfort.in=" + DEFAULT_COMFORT + "," + UPDATED_COMFORT, "comfort.in=" + UPDATED_COMFORT);
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByComfortIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where comfort is not null
        defaultVehicleReviewFiltering("comfort.specified=true", "comfort.specified=false");
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByComfortIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where comfort is greater than or equal to
        defaultVehicleReviewFiltering(
            "comfort.greaterThanOrEqual=" + DEFAULT_COMFORT,
            "comfort.greaterThanOrEqual=" + (DEFAULT_COMFORT + 1)
        );
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByComfortIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where comfort is less than or equal to
        defaultVehicleReviewFiltering("comfort.lessThanOrEqual=" + DEFAULT_COMFORT, "comfort.lessThanOrEqual=" + SMALLER_COMFORT);
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByComfortIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where comfort is less than
        defaultVehicleReviewFiltering("comfort.lessThan=" + (DEFAULT_COMFORT + 1), "comfort.lessThan=" + DEFAULT_COMFORT);
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByComfortIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where comfort is greater than
        defaultVehicleReviewFiltering("comfort.greaterThan=" + SMALLER_COMFORT, "comfort.greaterThan=" + DEFAULT_COMFORT);
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByPunctualityIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where punctuality equals to
        defaultVehicleReviewFiltering("punctuality.equals=" + DEFAULT_PUNCTUALITY, "punctuality.equals=" + UPDATED_PUNCTUALITY);
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByPunctualityIsInShouldWork() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where punctuality in
        defaultVehicleReviewFiltering(
            "punctuality.in=" + DEFAULT_PUNCTUALITY + "," + UPDATED_PUNCTUALITY,
            "punctuality.in=" + UPDATED_PUNCTUALITY
        );
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByPunctualityIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where punctuality is not null
        defaultVehicleReviewFiltering("punctuality.specified=true", "punctuality.specified=false");
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByPunctualityIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where punctuality is greater than or equal to
        defaultVehicleReviewFiltering(
            "punctuality.greaterThanOrEqual=" + DEFAULT_PUNCTUALITY,
            "punctuality.greaterThanOrEqual=" + (DEFAULT_PUNCTUALITY + 1)
        );
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByPunctualityIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where punctuality is less than or equal to
        defaultVehicleReviewFiltering(
            "punctuality.lessThanOrEqual=" + DEFAULT_PUNCTUALITY,
            "punctuality.lessThanOrEqual=" + SMALLER_PUNCTUALITY
        );
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByPunctualityIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where punctuality is less than
        defaultVehicleReviewFiltering("punctuality.lessThan=" + (DEFAULT_PUNCTUALITY + 1), "punctuality.lessThan=" + DEFAULT_PUNCTUALITY);
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByPunctualityIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where punctuality is greater than
        defaultVehicleReviewFiltering("punctuality.greaterThan=" + SMALLER_PUNCTUALITY, "punctuality.greaterThan=" + DEFAULT_PUNCTUALITY);
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByStaffServiceIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where staffService equals to
        defaultVehicleReviewFiltering("staffService.equals=" + DEFAULT_STAFF_SERVICE, "staffService.equals=" + UPDATED_STAFF_SERVICE);
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByStaffServiceIsInShouldWork() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where staffService in
        defaultVehicleReviewFiltering(
            "staffService.in=" + DEFAULT_STAFF_SERVICE + "," + UPDATED_STAFF_SERVICE,
            "staffService.in=" + UPDATED_STAFF_SERVICE
        );
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByStaffServiceIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where staffService is not null
        defaultVehicleReviewFiltering("staffService.specified=true", "staffService.specified=false");
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByStaffServiceIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where staffService is greater than or equal to
        defaultVehicleReviewFiltering(
            "staffService.greaterThanOrEqual=" + DEFAULT_STAFF_SERVICE,
            "staffService.greaterThanOrEqual=" + (DEFAULT_STAFF_SERVICE + 1)
        );
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByStaffServiceIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where staffService is less than or equal to
        defaultVehicleReviewFiltering(
            "staffService.lessThanOrEqual=" + DEFAULT_STAFF_SERVICE,
            "staffService.lessThanOrEqual=" + SMALLER_STAFF_SERVICE
        );
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByStaffServiceIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where staffService is less than
        defaultVehicleReviewFiltering(
            "staffService.lessThan=" + (DEFAULT_STAFF_SERVICE + 1),
            "staffService.lessThan=" + DEFAULT_STAFF_SERVICE
        );
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByStaffServiceIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where staffService is greater than
        defaultVehicleReviewFiltering(
            "staffService.greaterThan=" + SMALLER_STAFF_SERVICE,
            "staffService.greaterThan=" + DEFAULT_STAFF_SERVICE
        );
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByCreatedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where createdAt equals to
        defaultVehicleReviewFiltering("createdAt.equals=" + DEFAULT_CREATED_AT, "createdAt.equals=" + UPDATED_CREATED_AT);
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByCreatedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where createdAt in
        defaultVehicleReviewFiltering(
            "createdAt.in=" + DEFAULT_CREATED_AT + "," + UPDATED_CREATED_AT,
            "createdAt.in=" + UPDATED_CREATED_AT
        );
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByCreatedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where createdAt is not null
        defaultVehicleReviewFiltering("createdAt.specified=true", "createdAt.specified=false");
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByIsVerifiedIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where isVerified equals to
        defaultVehicleReviewFiltering("isVerified.equals=" + DEFAULT_IS_VERIFIED, "isVerified.equals=" + UPDATED_IS_VERIFIED);
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByIsVerifiedIsInShouldWork() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where isVerified in
        defaultVehicleReviewFiltering(
            "isVerified.in=" + DEFAULT_IS_VERIFIED + "," + UPDATED_IS_VERIFIED,
            "isVerified.in=" + UPDATED_IS_VERIFIED
        );
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByIsVerifiedIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        // Get all the vehicleReviewList where isVerified is not null
        defaultVehicleReviewFiltering("isVerified.specified=true", "isVerified.specified=false");
    }

    @Test
    @Transactional
    void getAllVehicleReviewsByVehicleIsEqualToSomething() throws Exception {
        Vehicle vehicle;
        if (TestUtil.findAll(em, Vehicle.class).isEmpty()) {
            vehicleReviewRepository.saveAndFlush(vehicleReview);
            vehicle = VehicleResourceIT.createEntity(em);
        } else {
            vehicle = TestUtil.findAll(em, Vehicle.class).get(0);
        }
        em.persist(vehicle);
        em.flush();
        vehicleReview.setVehicle(vehicle);
        vehicleReviewRepository.saveAndFlush(vehicleReview);
        Long vehicleId = vehicle.getId();
        // Get all the vehicleReviewList where vehicle equals to vehicleId
        defaultVehicleReviewShouldBeFound("vehicleId.equals=" + vehicleId);

        // Get all the vehicleReviewList where vehicle equals to (vehicleId + 1)
        defaultVehicleReviewShouldNotBeFound("vehicleId.equals=" + (vehicleId + 1));
    }

    private void defaultVehicleReviewFiltering(String shouldBeFound, String shouldNotBeFound) throws Exception {
        defaultVehicleReviewShouldBeFound(shouldBeFound);
        defaultVehicleReviewShouldNotBeFound(shouldNotBeFound);
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultVehicleReviewShouldBeFound(String filter) throws Exception {
        restVehicleReviewMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(vehicleReview.getId().intValue())))
            .andExpect(jsonPath("$.[*].userId").value(hasItem(DEFAULT_USER_ID.toString())))
            .andExpect(jsonPath("$.[*].tripId").value(hasItem(DEFAULT_TRIP_ID.toString())))
            .andExpect(jsonPath("$.[*].rating").value(hasItem(DEFAULT_RATING)))
            .andExpect(jsonPath("$.[*].comment").value(hasItem(DEFAULT_COMMENT)))
            .andExpect(jsonPath("$.[*].cleanliness").value(hasItem(DEFAULT_CLEANLINESS)))
            .andExpect(jsonPath("$.[*].comfort").value(hasItem(DEFAULT_COMFORT)))
            .andExpect(jsonPath("$.[*].punctuality").value(hasItem(DEFAULT_PUNCTUALITY)))
            .andExpect(jsonPath("$.[*].staffService").value(hasItem(DEFAULT_STAFF_SERVICE)))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].isVerified").value(hasItem(DEFAULT_IS_VERIFIED)));

        // Check, that the count call also returns 1
        restVehicleReviewMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("1"));
    }

    /**
     * Executes the search, and checks that the default entity is not returned.
     */
    private void defaultVehicleReviewShouldNotBeFound(String filter) throws Exception {
        restVehicleReviewMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());

        // Check, that the count call also returns 0
        restVehicleReviewMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("0"));
    }

    @Test
    @Transactional
    void getNonExistingVehicleReview() throws Exception {
        // Get the vehicleReview
        restVehicleReviewMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingVehicleReview() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the vehicleReview
        VehicleReview updatedVehicleReview = vehicleReviewRepository.findById(vehicleReview.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedVehicleReview are not directly saved in db
        em.detach(updatedVehicleReview);
        updatedVehicleReview
            .userId(UPDATED_USER_ID)
            .tripId(UPDATED_TRIP_ID)
            .rating(UPDATED_RATING)
            .comment(UPDATED_COMMENT)
            .cleanliness(UPDATED_CLEANLINESS)
            .comfort(UPDATED_COMFORT)
            .punctuality(UPDATED_PUNCTUALITY)
            .staffService(UPDATED_STAFF_SERVICE)
            .createdAt(UPDATED_CREATED_AT)
            .isVerified(UPDATED_IS_VERIFIED);
        VehicleReviewDTO vehicleReviewDTO = vehicleReviewMapper.toDto(updatedVehicleReview);

        restVehicleReviewMockMvc
            .perform(
                put(ENTITY_API_URL_ID, vehicleReviewDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(vehicleReviewDTO))
            )
            .andExpect(status().isOk());

        // Validate the VehicleReview in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedVehicleReviewToMatchAllProperties(updatedVehicleReview);
    }

    @Test
    @Transactional
    void putNonExistingVehicleReview() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        vehicleReview.setId(longCount.incrementAndGet());

        // Create the VehicleReview
        VehicleReviewDTO vehicleReviewDTO = vehicleReviewMapper.toDto(vehicleReview);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restVehicleReviewMockMvc
            .perform(
                put(ENTITY_API_URL_ID, vehicleReviewDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(vehicleReviewDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the VehicleReview in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchVehicleReview() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        vehicleReview.setId(longCount.incrementAndGet());

        // Create the VehicleReview
        VehicleReviewDTO vehicleReviewDTO = vehicleReviewMapper.toDto(vehicleReview);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restVehicleReviewMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(vehicleReviewDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the VehicleReview in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamVehicleReview() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        vehicleReview.setId(longCount.incrementAndGet());

        // Create the VehicleReview
        VehicleReviewDTO vehicleReviewDTO = vehicleReviewMapper.toDto(vehicleReview);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restVehicleReviewMockMvc
            .perform(
                put(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(vehicleReviewDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the VehicleReview in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateVehicleReviewWithPatch() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the vehicleReview using partial update
        VehicleReview partialUpdatedVehicleReview = new VehicleReview();
        partialUpdatedVehicleReview.setId(vehicleReview.getId());

        partialUpdatedVehicleReview
            .rating(UPDATED_RATING)
            .comment(UPDATED_COMMENT)
            .cleanliness(UPDATED_CLEANLINESS)
            .createdAt(UPDATED_CREATED_AT)
            .isVerified(UPDATED_IS_VERIFIED);

        restVehicleReviewMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedVehicleReview.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedVehicleReview))
            )
            .andExpect(status().isOk());

        // Validate the VehicleReview in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertVehicleReviewUpdatableFieldsEquals(
            createUpdateProxyForBean(partialUpdatedVehicleReview, vehicleReview),
            getPersistedVehicleReview(vehicleReview)
        );
    }

    @Test
    @Transactional
    void fullUpdateVehicleReviewWithPatch() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the vehicleReview using partial update
        VehicleReview partialUpdatedVehicleReview = new VehicleReview();
        partialUpdatedVehicleReview.setId(vehicleReview.getId());

        partialUpdatedVehicleReview
            .userId(UPDATED_USER_ID)
            .tripId(UPDATED_TRIP_ID)
            .rating(UPDATED_RATING)
            .comment(UPDATED_COMMENT)
            .cleanliness(UPDATED_CLEANLINESS)
            .comfort(UPDATED_COMFORT)
            .punctuality(UPDATED_PUNCTUALITY)
            .staffService(UPDATED_STAFF_SERVICE)
            .createdAt(UPDATED_CREATED_AT)
            .isVerified(UPDATED_IS_VERIFIED);

        restVehicleReviewMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedVehicleReview.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedVehicleReview))
            )
            .andExpect(status().isOk());

        // Validate the VehicleReview in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertVehicleReviewUpdatableFieldsEquals(partialUpdatedVehicleReview, getPersistedVehicleReview(partialUpdatedVehicleReview));
    }

    @Test
    @Transactional
    void patchNonExistingVehicleReview() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        vehicleReview.setId(longCount.incrementAndGet());

        // Create the VehicleReview
        VehicleReviewDTO vehicleReviewDTO = vehicleReviewMapper.toDto(vehicleReview);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restVehicleReviewMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, vehicleReviewDTO.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(vehicleReviewDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the VehicleReview in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchVehicleReview() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        vehicleReview.setId(longCount.incrementAndGet());

        // Create the VehicleReview
        VehicleReviewDTO vehicleReviewDTO = vehicleReviewMapper.toDto(vehicleReview);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restVehicleReviewMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(vehicleReviewDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the VehicleReview in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamVehicleReview() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        vehicleReview.setId(longCount.incrementAndGet());

        // Create the VehicleReview
        VehicleReviewDTO vehicleReviewDTO = vehicleReviewMapper.toDto(vehicleReview);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restVehicleReviewMockMvc
            .perform(
                patch(ENTITY_API_URL)
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(vehicleReviewDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the VehicleReview in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteVehicleReview() throws Exception {
        // Initialize the database
        insertedVehicleReview = vehicleReviewRepository.saveAndFlush(vehicleReview);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the vehicleReview
        restVehicleReviewMockMvc
            .perform(delete(ENTITY_API_URL_ID, vehicleReview.getId()).with(csrf()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return vehicleReviewRepository.count();
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

    protected VehicleReview getPersistedVehicleReview(VehicleReview vehicleReview) {
        return vehicleReviewRepository.findById(vehicleReview.getId()).orElseThrow();
    }

    protected void assertPersistedVehicleReviewToMatchAllProperties(VehicleReview expectedVehicleReview) {
        assertVehicleReviewAllPropertiesEquals(expectedVehicleReview, getPersistedVehicleReview(expectedVehicleReview));
    }

    protected void assertPersistedVehicleReviewToMatchUpdatableProperties(VehicleReview expectedVehicleReview) {
        assertVehicleReviewAllUpdatablePropertiesEquals(expectedVehicleReview, getPersistedVehicleReview(expectedVehicleReview));
    }
}
