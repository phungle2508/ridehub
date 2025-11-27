package com.ridehub.booking.web.rest;

import static com.ridehub.booking.domain.FileBookingAsserts.*;
import static com.ridehub.booking.web.rest.TestUtil.createUpdateProxyForBean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ridehub.booking.IntegrationTest;
import com.ridehub.booking.domain.FileBooking;
import com.ridehub.booking.repository.FileBookingRepository;
import com.ridehub.booking.service.dto.FileBookingDTO;
import com.ridehub.booking.service.mapper.FileBookingMapper;
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
 * Integration tests for the {@link FileBookingResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class FileBookingResourceIT {

    private static final String DEFAULT_BUCKET = "AAAAAAAAAA";
    private static final String UPDATED_BUCKET = "BBBBBBBBBB";

    private static final String DEFAULT_OBJECT_KEY = "AAAAAAAAAA";
    private static final String UPDATED_OBJECT_KEY = "BBBBBBBBBB";

    private static final String DEFAULT_CONTENT_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_CONTENT_TYPE = "BBBBBBBBBB";

    private static final Long DEFAULT_SIZE = 1L;
    private static final Long UPDATED_SIZE = 2L;
    private static final Long SMALLER_SIZE = 1L - 1L;

    private static final Instant DEFAULT_CREATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_UPDATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_UPDATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Boolean DEFAULT_IS_DELETED = false;
    private static final Boolean UPDATED_IS_DELETED = true;

    private static final Instant DEFAULT_DELETED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_DELETED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final UUID DEFAULT_DELETED_BY = UUID.randomUUID();
    private static final UUID UPDATED_DELETED_BY = UUID.randomUUID();

    private static final String ENTITY_API_URL = "/api/file-bookings";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private FileBookingRepository fileBookingRepository;

    @Autowired
    private FileBookingMapper fileBookingMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restFileBookingMockMvc;

    private FileBooking fileBooking;

    private FileBooking insertedFileBooking;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static FileBooking createEntity() {
        return new FileBooking()
            .bucket(DEFAULT_BUCKET)
            .objectKey(DEFAULT_OBJECT_KEY)
            .contentType(DEFAULT_CONTENT_TYPE)
            .size(DEFAULT_SIZE)
            .createdAt(DEFAULT_CREATED_AT)
            .updatedAt(DEFAULT_UPDATED_AT)
            .isDeleted(DEFAULT_IS_DELETED)
            .deletedAt(DEFAULT_DELETED_AT)
            .deletedBy(DEFAULT_DELETED_BY);
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static FileBooking createUpdatedEntity() {
        return new FileBooking()
            .bucket(UPDATED_BUCKET)
            .objectKey(UPDATED_OBJECT_KEY)
            .contentType(UPDATED_CONTENT_TYPE)
            .size(UPDATED_SIZE)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);
    }

    @BeforeEach
    void initTest() {
        fileBooking = createEntity();
    }

    @AfterEach
    void cleanup() {
        if (insertedFileBooking != null) {
            fileBookingRepository.delete(insertedFileBooking);
            insertedFileBooking = null;
        }
    }

    @Test
    @Transactional
    void createFileBooking() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the FileBooking
        FileBookingDTO fileBookingDTO = fileBookingMapper.toDto(fileBooking);
        var returnedFileBookingDTO = om.readValue(
            restFileBookingMockMvc
                .perform(
                    post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(fileBookingDTO))
                )
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            FileBookingDTO.class
        );

        // Validate the FileBooking in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        var returnedFileBooking = fileBookingMapper.toEntity(returnedFileBookingDTO);
        assertFileBookingUpdatableFieldsEquals(returnedFileBooking, getPersistedFileBooking(returnedFileBooking));

        insertedFileBooking = returnedFileBooking;
    }

    @Test
    @Transactional
    void createFileBookingWithExistingId() throws Exception {
        // Create the FileBooking with an existing ID
        fileBooking.setId(1L);
        FileBookingDTO fileBookingDTO = fileBookingMapper.toDto(fileBooking);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restFileBookingMockMvc
            .perform(
                post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(fileBookingDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the FileBooking in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkBucketIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        fileBooking.setBucket(null);

        // Create the FileBooking, which fails.
        FileBookingDTO fileBookingDTO = fileBookingMapper.toDto(fileBooking);

        restFileBookingMockMvc
            .perform(
                post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(fileBookingDTO))
            )
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkObjectKeyIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        fileBooking.setObjectKey(null);

        // Create the FileBooking, which fails.
        FileBookingDTO fileBookingDTO = fileBookingMapper.toDto(fileBooking);

        restFileBookingMockMvc
            .perform(
                post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(fileBookingDTO))
            )
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkCreatedAtIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        fileBooking.setCreatedAt(null);

        // Create the FileBooking, which fails.
        FileBookingDTO fileBookingDTO = fileBookingMapper.toDto(fileBooking);

        restFileBookingMockMvc
            .perform(
                post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(fileBookingDTO))
            )
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllFileBookings() throws Exception {
        // Initialize the database
        insertedFileBooking = fileBookingRepository.saveAndFlush(fileBooking);

        // Get all the fileBookingList
        restFileBookingMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(fileBooking.getId().intValue())))
            .andExpect(jsonPath("$.[*].bucket").value(hasItem(DEFAULT_BUCKET)))
            .andExpect(jsonPath("$.[*].objectKey").value(hasItem(DEFAULT_OBJECT_KEY)))
            .andExpect(jsonPath("$.[*].contentType").value(hasItem(DEFAULT_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].size").value(hasItem(DEFAULT_SIZE.intValue())))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].isDeleted").value(hasItem(DEFAULT_IS_DELETED)))
            .andExpect(jsonPath("$.[*].deletedAt").value(hasItem(DEFAULT_DELETED_AT.toString())))
            .andExpect(jsonPath("$.[*].deletedBy").value(hasItem(DEFAULT_DELETED_BY.toString())));
    }

    @Test
    @Transactional
    void getFileBooking() throws Exception {
        // Initialize the database
        insertedFileBooking = fileBookingRepository.saveAndFlush(fileBooking);

        // Get the fileBooking
        restFileBookingMockMvc
            .perform(get(ENTITY_API_URL_ID, fileBooking.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(fileBooking.getId().intValue()))
            .andExpect(jsonPath("$.bucket").value(DEFAULT_BUCKET))
            .andExpect(jsonPath("$.objectKey").value(DEFAULT_OBJECT_KEY))
            .andExpect(jsonPath("$.contentType").value(DEFAULT_CONTENT_TYPE))
            .andExpect(jsonPath("$.size").value(DEFAULT_SIZE.intValue()))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.updatedAt").value(DEFAULT_UPDATED_AT.toString()))
            .andExpect(jsonPath("$.isDeleted").value(DEFAULT_IS_DELETED))
            .andExpect(jsonPath("$.deletedAt").value(DEFAULT_DELETED_AT.toString()))
            .andExpect(jsonPath("$.deletedBy").value(DEFAULT_DELETED_BY.toString()));
    }

    @Test
    @Transactional
    void getFileBookingsByIdFiltering() throws Exception {
        // Initialize the database
        insertedFileBooking = fileBookingRepository.saveAndFlush(fileBooking);

        Long id = fileBooking.getId();

        defaultFileBookingFiltering("id.equals=" + id, "id.notEquals=" + id);

        defaultFileBookingFiltering("id.greaterThanOrEqual=" + id, "id.greaterThan=" + id);

        defaultFileBookingFiltering("id.lessThanOrEqual=" + id, "id.lessThan=" + id);
    }

    @Test
    @Transactional
    void getAllFileBookingsByBucketIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedFileBooking = fileBookingRepository.saveAndFlush(fileBooking);

        // Get all the fileBookingList where bucket equals to
        defaultFileBookingFiltering("bucket.equals=" + DEFAULT_BUCKET, "bucket.equals=" + UPDATED_BUCKET);
    }

    @Test
    @Transactional
    void getAllFileBookingsByBucketIsInShouldWork() throws Exception {
        // Initialize the database
        insertedFileBooking = fileBookingRepository.saveAndFlush(fileBooking);

        // Get all the fileBookingList where bucket in
        defaultFileBookingFiltering("bucket.in=" + DEFAULT_BUCKET + "," + UPDATED_BUCKET, "bucket.in=" + UPDATED_BUCKET);
    }

    @Test
    @Transactional
    void getAllFileBookingsByBucketIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedFileBooking = fileBookingRepository.saveAndFlush(fileBooking);

        // Get all the fileBookingList where bucket is not null
        defaultFileBookingFiltering("bucket.specified=true", "bucket.specified=false");
    }

    @Test
    @Transactional
    void getAllFileBookingsByBucketContainsSomething() throws Exception {
        // Initialize the database
        insertedFileBooking = fileBookingRepository.saveAndFlush(fileBooking);

        // Get all the fileBookingList where bucket contains
        defaultFileBookingFiltering("bucket.contains=" + DEFAULT_BUCKET, "bucket.contains=" + UPDATED_BUCKET);
    }

    @Test
    @Transactional
    void getAllFileBookingsByBucketNotContainsSomething() throws Exception {
        // Initialize the database
        insertedFileBooking = fileBookingRepository.saveAndFlush(fileBooking);

        // Get all the fileBookingList where bucket does not contain
        defaultFileBookingFiltering("bucket.doesNotContain=" + UPDATED_BUCKET, "bucket.doesNotContain=" + DEFAULT_BUCKET);
    }

    @Test
    @Transactional
    void getAllFileBookingsByObjectKeyIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedFileBooking = fileBookingRepository.saveAndFlush(fileBooking);

        // Get all the fileBookingList where objectKey equals to
        defaultFileBookingFiltering("objectKey.equals=" + DEFAULT_OBJECT_KEY, "objectKey.equals=" + UPDATED_OBJECT_KEY);
    }

    @Test
    @Transactional
    void getAllFileBookingsByObjectKeyIsInShouldWork() throws Exception {
        // Initialize the database
        insertedFileBooking = fileBookingRepository.saveAndFlush(fileBooking);

        // Get all the fileBookingList where objectKey in
        defaultFileBookingFiltering("objectKey.in=" + DEFAULT_OBJECT_KEY + "," + UPDATED_OBJECT_KEY, "objectKey.in=" + UPDATED_OBJECT_KEY);
    }

    @Test
    @Transactional
    void getAllFileBookingsByObjectKeyIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedFileBooking = fileBookingRepository.saveAndFlush(fileBooking);

        // Get all the fileBookingList where objectKey is not null
        defaultFileBookingFiltering("objectKey.specified=true", "objectKey.specified=false");
    }

    @Test
    @Transactional
    void getAllFileBookingsByObjectKeyContainsSomething() throws Exception {
        // Initialize the database
        insertedFileBooking = fileBookingRepository.saveAndFlush(fileBooking);

        // Get all the fileBookingList where objectKey contains
        defaultFileBookingFiltering("objectKey.contains=" + DEFAULT_OBJECT_KEY, "objectKey.contains=" + UPDATED_OBJECT_KEY);
    }

    @Test
    @Transactional
    void getAllFileBookingsByObjectKeyNotContainsSomething() throws Exception {
        // Initialize the database
        insertedFileBooking = fileBookingRepository.saveAndFlush(fileBooking);

        // Get all the fileBookingList where objectKey does not contain
        defaultFileBookingFiltering("objectKey.doesNotContain=" + UPDATED_OBJECT_KEY, "objectKey.doesNotContain=" + DEFAULT_OBJECT_KEY);
    }

    @Test
    @Transactional
    void getAllFileBookingsByContentTypeIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedFileBooking = fileBookingRepository.saveAndFlush(fileBooking);

        // Get all the fileBookingList where contentType equals to
        defaultFileBookingFiltering("contentType.equals=" + DEFAULT_CONTENT_TYPE, "contentType.equals=" + UPDATED_CONTENT_TYPE);
    }

    @Test
    @Transactional
    void getAllFileBookingsByContentTypeIsInShouldWork() throws Exception {
        // Initialize the database
        insertedFileBooking = fileBookingRepository.saveAndFlush(fileBooking);

        // Get all the fileBookingList where contentType in
        defaultFileBookingFiltering(
            "contentType.in=" + DEFAULT_CONTENT_TYPE + "," + UPDATED_CONTENT_TYPE,
            "contentType.in=" + UPDATED_CONTENT_TYPE
        );
    }

    @Test
    @Transactional
    void getAllFileBookingsByContentTypeIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedFileBooking = fileBookingRepository.saveAndFlush(fileBooking);

        // Get all the fileBookingList where contentType is not null
        defaultFileBookingFiltering("contentType.specified=true", "contentType.specified=false");
    }

    @Test
    @Transactional
    void getAllFileBookingsByContentTypeContainsSomething() throws Exception {
        // Initialize the database
        insertedFileBooking = fileBookingRepository.saveAndFlush(fileBooking);

        // Get all the fileBookingList where contentType contains
        defaultFileBookingFiltering("contentType.contains=" + DEFAULT_CONTENT_TYPE, "contentType.contains=" + UPDATED_CONTENT_TYPE);
    }

    @Test
    @Transactional
    void getAllFileBookingsByContentTypeNotContainsSomething() throws Exception {
        // Initialize the database
        insertedFileBooking = fileBookingRepository.saveAndFlush(fileBooking);

        // Get all the fileBookingList where contentType does not contain
        defaultFileBookingFiltering(
            "contentType.doesNotContain=" + UPDATED_CONTENT_TYPE,
            "contentType.doesNotContain=" + DEFAULT_CONTENT_TYPE
        );
    }

    @Test
    @Transactional
    void getAllFileBookingsBySizeIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedFileBooking = fileBookingRepository.saveAndFlush(fileBooking);

        // Get all the fileBookingList where size equals to
        defaultFileBookingFiltering("size.equals=" + DEFAULT_SIZE, "size.equals=" + UPDATED_SIZE);
    }

    @Test
    @Transactional
    void getAllFileBookingsBySizeIsInShouldWork() throws Exception {
        // Initialize the database
        insertedFileBooking = fileBookingRepository.saveAndFlush(fileBooking);

        // Get all the fileBookingList where size in
        defaultFileBookingFiltering("size.in=" + DEFAULT_SIZE + "," + UPDATED_SIZE, "size.in=" + UPDATED_SIZE);
    }

    @Test
    @Transactional
    void getAllFileBookingsBySizeIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedFileBooking = fileBookingRepository.saveAndFlush(fileBooking);

        // Get all the fileBookingList where size is not null
        defaultFileBookingFiltering("size.specified=true", "size.specified=false");
    }

    @Test
    @Transactional
    void getAllFileBookingsBySizeIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedFileBooking = fileBookingRepository.saveAndFlush(fileBooking);

        // Get all the fileBookingList where size is greater than or equal to
        defaultFileBookingFiltering("size.greaterThanOrEqual=" + DEFAULT_SIZE, "size.greaterThanOrEqual=" + UPDATED_SIZE);
    }

    @Test
    @Transactional
    void getAllFileBookingsBySizeIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedFileBooking = fileBookingRepository.saveAndFlush(fileBooking);

        // Get all the fileBookingList where size is less than or equal to
        defaultFileBookingFiltering("size.lessThanOrEqual=" + DEFAULT_SIZE, "size.lessThanOrEqual=" + SMALLER_SIZE);
    }

    @Test
    @Transactional
    void getAllFileBookingsBySizeIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedFileBooking = fileBookingRepository.saveAndFlush(fileBooking);

        // Get all the fileBookingList where size is less than
        defaultFileBookingFiltering("size.lessThan=" + UPDATED_SIZE, "size.lessThan=" + DEFAULT_SIZE);
    }

    @Test
    @Transactional
    void getAllFileBookingsBySizeIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedFileBooking = fileBookingRepository.saveAndFlush(fileBooking);

        // Get all the fileBookingList where size is greater than
        defaultFileBookingFiltering("size.greaterThan=" + SMALLER_SIZE, "size.greaterThan=" + DEFAULT_SIZE);
    }

    @Test
    @Transactional
    void getAllFileBookingsByCreatedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedFileBooking = fileBookingRepository.saveAndFlush(fileBooking);

        // Get all the fileBookingList where createdAt equals to
        defaultFileBookingFiltering("createdAt.equals=" + DEFAULT_CREATED_AT, "createdAt.equals=" + UPDATED_CREATED_AT);
    }

    @Test
    @Transactional
    void getAllFileBookingsByCreatedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedFileBooking = fileBookingRepository.saveAndFlush(fileBooking);

        // Get all the fileBookingList where createdAt in
        defaultFileBookingFiltering("createdAt.in=" + DEFAULT_CREATED_AT + "," + UPDATED_CREATED_AT, "createdAt.in=" + UPDATED_CREATED_AT);
    }

    @Test
    @Transactional
    void getAllFileBookingsByCreatedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedFileBooking = fileBookingRepository.saveAndFlush(fileBooking);

        // Get all the fileBookingList where createdAt is not null
        defaultFileBookingFiltering("createdAt.specified=true", "createdAt.specified=false");
    }

    @Test
    @Transactional
    void getAllFileBookingsByUpdatedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedFileBooking = fileBookingRepository.saveAndFlush(fileBooking);

        // Get all the fileBookingList where updatedAt equals to
        defaultFileBookingFiltering("updatedAt.equals=" + DEFAULT_UPDATED_AT, "updatedAt.equals=" + UPDATED_UPDATED_AT);
    }

    @Test
    @Transactional
    void getAllFileBookingsByUpdatedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedFileBooking = fileBookingRepository.saveAndFlush(fileBooking);

        // Get all the fileBookingList where updatedAt in
        defaultFileBookingFiltering("updatedAt.in=" + DEFAULT_UPDATED_AT + "," + UPDATED_UPDATED_AT, "updatedAt.in=" + UPDATED_UPDATED_AT);
    }

    @Test
    @Transactional
    void getAllFileBookingsByUpdatedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedFileBooking = fileBookingRepository.saveAndFlush(fileBooking);

        // Get all the fileBookingList where updatedAt is not null
        defaultFileBookingFiltering("updatedAt.specified=true", "updatedAt.specified=false");
    }

    @Test
    @Transactional
    void getAllFileBookingsByIsDeletedIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedFileBooking = fileBookingRepository.saveAndFlush(fileBooking);

        // Get all the fileBookingList where isDeleted equals to
        defaultFileBookingFiltering("isDeleted.equals=" + DEFAULT_IS_DELETED, "isDeleted.equals=" + UPDATED_IS_DELETED);
    }

    @Test
    @Transactional
    void getAllFileBookingsByIsDeletedIsInShouldWork() throws Exception {
        // Initialize the database
        insertedFileBooking = fileBookingRepository.saveAndFlush(fileBooking);

        // Get all the fileBookingList where isDeleted in
        defaultFileBookingFiltering("isDeleted.in=" + DEFAULT_IS_DELETED + "," + UPDATED_IS_DELETED, "isDeleted.in=" + UPDATED_IS_DELETED);
    }

    @Test
    @Transactional
    void getAllFileBookingsByIsDeletedIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedFileBooking = fileBookingRepository.saveAndFlush(fileBooking);

        // Get all the fileBookingList where isDeleted is not null
        defaultFileBookingFiltering("isDeleted.specified=true", "isDeleted.specified=false");
    }

    @Test
    @Transactional
    void getAllFileBookingsByDeletedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedFileBooking = fileBookingRepository.saveAndFlush(fileBooking);

        // Get all the fileBookingList where deletedAt equals to
        defaultFileBookingFiltering("deletedAt.equals=" + DEFAULT_DELETED_AT, "deletedAt.equals=" + UPDATED_DELETED_AT);
    }

    @Test
    @Transactional
    void getAllFileBookingsByDeletedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedFileBooking = fileBookingRepository.saveAndFlush(fileBooking);

        // Get all the fileBookingList where deletedAt in
        defaultFileBookingFiltering("deletedAt.in=" + DEFAULT_DELETED_AT + "," + UPDATED_DELETED_AT, "deletedAt.in=" + UPDATED_DELETED_AT);
    }

    @Test
    @Transactional
    void getAllFileBookingsByDeletedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedFileBooking = fileBookingRepository.saveAndFlush(fileBooking);

        // Get all the fileBookingList where deletedAt is not null
        defaultFileBookingFiltering("deletedAt.specified=true", "deletedAt.specified=false");
    }

    @Test
    @Transactional
    void getAllFileBookingsByDeletedByIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedFileBooking = fileBookingRepository.saveAndFlush(fileBooking);

        // Get all the fileBookingList where deletedBy equals to
        defaultFileBookingFiltering("deletedBy.equals=" + DEFAULT_DELETED_BY, "deletedBy.equals=" + UPDATED_DELETED_BY);
    }

    @Test
    @Transactional
    void getAllFileBookingsByDeletedByIsInShouldWork() throws Exception {
        // Initialize the database
        insertedFileBooking = fileBookingRepository.saveAndFlush(fileBooking);

        // Get all the fileBookingList where deletedBy in
        defaultFileBookingFiltering("deletedBy.in=" + DEFAULT_DELETED_BY + "," + UPDATED_DELETED_BY, "deletedBy.in=" + UPDATED_DELETED_BY);
    }

    @Test
    @Transactional
    void getAllFileBookingsByDeletedByIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedFileBooking = fileBookingRepository.saveAndFlush(fileBooking);

        // Get all the fileBookingList where deletedBy is not null
        defaultFileBookingFiltering("deletedBy.specified=true", "deletedBy.specified=false");
    }

    private void defaultFileBookingFiltering(String shouldBeFound, String shouldNotBeFound) throws Exception {
        defaultFileBookingShouldBeFound(shouldBeFound);
        defaultFileBookingShouldNotBeFound(shouldNotBeFound);
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultFileBookingShouldBeFound(String filter) throws Exception {
        restFileBookingMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(fileBooking.getId().intValue())))
            .andExpect(jsonPath("$.[*].bucket").value(hasItem(DEFAULT_BUCKET)))
            .andExpect(jsonPath("$.[*].objectKey").value(hasItem(DEFAULT_OBJECT_KEY)))
            .andExpect(jsonPath("$.[*].contentType").value(hasItem(DEFAULT_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].size").value(hasItem(DEFAULT_SIZE.intValue())))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].isDeleted").value(hasItem(DEFAULT_IS_DELETED)))
            .andExpect(jsonPath("$.[*].deletedAt").value(hasItem(DEFAULT_DELETED_AT.toString())))
            .andExpect(jsonPath("$.[*].deletedBy").value(hasItem(DEFAULT_DELETED_BY.toString())));

        // Check, that the count call also returns 1
        restFileBookingMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("1"));
    }

    /**
     * Executes the search, and checks that the default entity is not returned.
     */
    private void defaultFileBookingShouldNotBeFound(String filter) throws Exception {
        restFileBookingMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());

        // Check, that the count call also returns 0
        restFileBookingMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("0"));
    }

    @Test
    @Transactional
    void getNonExistingFileBooking() throws Exception {
        // Get the fileBooking
        restFileBookingMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingFileBooking() throws Exception {
        // Initialize the database
        insertedFileBooking = fileBookingRepository.saveAndFlush(fileBooking);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the fileBooking
        FileBooking updatedFileBooking = fileBookingRepository.findById(fileBooking.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedFileBooking are not directly saved in db
        em.detach(updatedFileBooking);
        updatedFileBooking
            .bucket(UPDATED_BUCKET)
            .objectKey(UPDATED_OBJECT_KEY)
            .contentType(UPDATED_CONTENT_TYPE)
            .size(UPDATED_SIZE)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);
        FileBookingDTO fileBookingDTO = fileBookingMapper.toDto(updatedFileBooking);

        restFileBookingMockMvc
            .perform(
                put(ENTITY_API_URL_ID, fileBookingDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(fileBookingDTO))
            )
            .andExpect(status().isOk());

        // Validate the FileBooking in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedFileBookingToMatchAllProperties(updatedFileBooking);
    }

    @Test
    @Transactional
    void putNonExistingFileBooking() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        fileBooking.setId(longCount.incrementAndGet());

        // Create the FileBooking
        FileBookingDTO fileBookingDTO = fileBookingMapper.toDto(fileBooking);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restFileBookingMockMvc
            .perform(
                put(ENTITY_API_URL_ID, fileBookingDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(fileBookingDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the FileBooking in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchFileBooking() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        fileBooking.setId(longCount.incrementAndGet());

        // Create the FileBooking
        FileBookingDTO fileBookingDTO = fileBookingMapper.toDto(fileBooking);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restFileBookingMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(fileBookingDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the FileBooking in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamFileBooking() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        fileBooking.setId(longCount.incrementAndGet());

        // Create the FileBooking
        FileBookingDTO fileBookingDTO = fileBookingMapper.toDto(fileBooking);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restFileBookingMockMvc
            .perform(put(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(fileBookingDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the FileBooking in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateFileBookingWithPatch() throws Exception {
        // Initialize the database
        insertedFileBooking = fileBookingRepository.saveAndFlush(fileBooking);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the fileBooking using partial update
        FileBooking partialUpdatedFileBooking = new FileBooking();
        partialUpdatedFileBooking.setId(fileBooking.getId());

        partialUpdatedFileBooking
            .bucket(UPDATED_BUCKET)
            .size(UPDATED_SIZE)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);

        restFileBookingMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedFileBooking.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedFileBooking))
            )
            .andExpect(status().isOk());

        // Validate the FileBooking in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertFileBookingUpdatableFieldsEquals(
            createUpdateProxyForBean(partialUpdatedFileBooking, fileBooking),
            getPersistedFileBooking(fileBooking)
        );
    }

    @Test
    @Transactional
    void fullUpdateFileBookingWithPatch() throws Exception {
        // Initialize the database
        insertedFileBooking = fileBookingRepository.saveAndFlush(fileBooking);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the fileBooking using partial update
        FileBooking partialUpdatedFileBooking = new FileBooking();
        partialUpdatedFileBooking.setId(fileBooking.getId());

        partialUpdatedFileBooking
            .bucket(UPDATED_BUCKET)
            .objectKey(UPDATED_OBJECT_KEY)
            .contentType(UPDATED_CONTENT_TYPE)
            .size(UPDATED_SIZE)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);

        restFileBookingMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedFileBooking.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedFileBooking))
            )
            .andExpect(status().isOk());

        // Validate the FileBooking in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertFileBookingUpdatableFieldsEquals(partialUpdatedFileBooking, getPersistedFileBooking(partialUpdatedFileBooking));
    }

    @Test
    @Transactional
    void patchNonExistingFileBooking() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        fileBooking.setId(longCount.incrementAndGet());

        // Create the FileBooking
        FileBookingDTO fileBookingDTO = fileBookingMapper.toDto(fileBooking);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restFileBookingMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, fileBookingDTO.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(fileBookingDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the FileBooking in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchFileBooking() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        fileBooking.setId(longCount.incrementAndGet());

        // Create the FileBooking
        FileBookingDTO fileBookingDTO = fileBookingMapper.toDto(fileBooking);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restFileBookingMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(fileBookingDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the FileBooking in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamFileBooking() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        fileBooking.setId(longCount.incrementAndGet());

        // Create the FileBooking
        FileBookingDTO fileBookingDTO = fileBookingMapper.toDto(fileBooking);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restFileBookingMockMvc
            .perform(
                patch(ENTITY_API_URL).with(csrf()).contentType("application/merge-patch+json").content(om.writeValueAsBytes(fileBookingDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the FileBooking in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteFileBooking() throws Exception {
        // Initialize the database
        insertedFileBooking = fileBookingRepository.saveAndFlush(fileBooking);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the fileBooking
        restFileBookingMockMvc
            .perform(delete(ENTITY_API_URL_ID, fileBooking.getId()).with(csrf()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return fileBookingRepository.count();
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

    protected FileBooking getPersistedFileBooking(FileBooking fileBooking) {
        return fileBookingRepository.findById(fileBooking.getId()).orElseThrow();
    }

    protected void assertPersistedFileBookingToMatchAllProperties(FileBooking expectedFileBooking) {
        assertFileBookingAllPropertiesEquals(expectedFileBooking, getPersistedFileBooking(expectedFileBooking));
    }

    protected void assertPersistedFileBookingToMatchUpdatableProperties(FileBooking expectedFileBooking) {
        assertFileBookingAllUpdatablePropertiesEquals(expectedFileBooking, getPersistedFileBooking(expectedFileBooking));
    }
}
