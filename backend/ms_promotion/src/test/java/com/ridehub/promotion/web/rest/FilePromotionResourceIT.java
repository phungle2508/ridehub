package com.ridehub.promotion.web.rest;

import static com.ridehub.promotion.domain.FilePromotionAsserts.*;
import static com.ridehub.promotion.web.rest.TestUtil.createUpdateProxyForBean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ridehub.promotion.IntegrationTest;
import com.ridehub.promotion.domain.FilePromotion;
import com.ridehub.promotion.domain.Promotion;
import com.ridehub.promotion.repository.FilePromotionRepository;
import com.ridehub.promotion.service.dto.FilePromotionDTO;
import com.ridehub.promotion.service.mapper.FilePromotionMapper;
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
 * Integration tests for the {@link FilePromotionResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class FilePromotionResourceIT {

    private static final String DEFAULT_BUCKET = "AAAAAAAAAA";
    private static final String UPDATED_BUCKET = "BBBBBBBBBB";

    private static final String DEFAULT_OBJECT_KEY = "AAAAAAAAAA";
    private static final String UPDATED_OBJECT_KEY = "BBBBBBBBBB";

    private static final String DEFAULT_CONTENT_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_CONTENT_TYPE = "BBBBBBBBBB";

    private static final Long DEFAULT_SIZE = 1L;
    private static final Long UPDATED_SIZE = 2L;
    private static final Long SMALLER_SIZE = 1L - 1L;

    private static final Boolean DEFAULT_IS_BANNER = false;
    private static final Boolean UPDATED_IS_BANNER = true;

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

    private static final String ENTITY_API_URL = "/api/file-promotions";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private FilePromotionRepository filePromotionRepository;

    @Autowired
    private FilePromotionMapper filePromotionMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restFilePromotionMockMvc;

    private FilePromotion filePromotion;

    private FilePromotion insertedFilePromotion;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static FilePromotion createEntity(EntityManager em) {
        FilePromotion filePromotion = new FilePromotion()
            .bucket(DEFAULT_BUCKET)
            .objectKey(DEFAULT_OBJECT_KEY)
            .contentType(DEFAULT_CONTENT_TYPE)
            .size(DEFAULT_SIZE)
            .isBanner(DEFAULT_IS_BANNER)
            .createdAt(DEFAULT_CREATED_AT)
            .updatedAt(DEFAULT_UPDATED_AT)
            .isDeleted(DEFAULT_IS_DELETED)
            .deletedAt(DEFAULT_DELETED_AT)
            .deletedBy(DEFAULT_DELETED_BY);
        // Add required entity
        Promotion promotion;
        if (TestUtil.findAll(em, Promotion.class).isEmpty()) {
            promotion = PromotionResourceIT.createEntity();
            em.persist(promotion);
            em.flush();
        } else {
            promotion = TestUtil.findAll(em, Promotion.class).get(0);
        }
        filePromotion.setPromotion(promotion);
        return filePromotion;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static FilePromotion createUpdatedEntity(EntityManager em) {
        FilePromotion updatedFilePromotion = new FilePromotion()
            .bucket(UPDATED_BUCKET)
            .objectKey(UPDATED_OBJECT_KEY)
            .contentType(UPDATED_CONTENT_TYPE)
            .size(UPDATED_SIZE)
            .isBanner(UPDATED_IS_BANNER)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);
        // Add required entity
        Promotion promotion;
        if (TestUtil.findAll(em, Promotion.class).isEmpty()) {
            promotion = PromotionResourceIT.createUpdatedEntity();
            em.persist(promotion);
            em.flush();
        } else {
            promotion = TestUtil.findAll(em, Promotion.class).get(0);
        }
        updatedFilePromotion.setPromotion(promotion);
        return updatedFilePromotion;
    }

    @BeforeEach
    void initTest() {
        filePromotion = createEntity(em);
    }

    @AfterEach
    void cleanup() {
        if (insertedFilePromotion != null) {
            filePromotionRepository.delete(insertedFilePromotion);
            insertedFilePromotion = null;
        }
    }

    @Test
    @Transactional
    void createFilePromotion() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the FilePromotion
        FilePromotionDTO filePromotionDTO = filePromotionMapper.toDto(filePromotion);
        var returnedFilePromotionDTO = om.readValue(
            restFilePromotionMockMvc
                .perform(
                    post(ENTITY_API_URL)
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsBytes(filePromotionDTO))
                )
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            FilePromotionDTO.class
        );

        // Validate the FilePromotion in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        var returnedFilePromotion = filePromotionMapper.toEntity(returnedFilePromotionDTO);
        assertFilePromotionUpdatableFieldsEquals(returnedFilePromotion, getPersistedFilePromotion(returnedFilePromotion));

        insertedFilePromotion = returnedFilePromotion;
    }

    @Test
    @Transactional
    void createFilePromotionWithExistingId() throws Exception {
        // Create the FilePromotion with an existing ID
        filePromotion.setId(1L);
        FilePromotionDTO filePromotionDTO = filePromotionMapper.toDto(filePromotion);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restFilePromotionMockMvc
            .perform(
                post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(filePromotionDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the FilePromotion in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkBucketIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        filePromotion.setBucket(null);

        // Create the FilePromotion, which fails.
        FilePromotionDTO filePromotionDTO = filePromotionMapper.toDto(filePromotion);

        restFilePromotionMockMvc
            .perform(
                post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(filePromotionDTO))
            )
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkObjectKeyIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        filePromotion.setObjectKey(null);

        // Create the FilePromotion, which fails.
        FilePromotionDTO filePromotionDTO = filePromotionMapper.toDto(filePromotion);

        restFilePromotionMockMvc
            .perform(
                post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(filePromotionDTO))
            )
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkCreatedAtIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        filePromotion.setCreatedAt(null);

        // Create the FilePromotion, which fails.
        FilePromotionDTO filePromotionDTO = filePromotionMapper.toDto(filePromotion);

        restFilePromotionMockMvc
            .perform(
                post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(filePromotionDTO))
            )
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllFilePromotions() throws Exception {
        // Initialize the database
        insertedFilePromotion = filePromotionRepository.saveAndFlush(filePromotion);

        // Get all the filePromotionList
        restFilePromotionMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(filePromotion.getId().intValue())))
            .andExpect(jsonPath("$.[*].bucket").value(hasItem(DEFAULT_BUCKET)))
            .andExpect(jsonPath("$.[*].objectKey").value(hasItem(DEFAULT_OBJECT_KEY)))
            .andExpect(jsonPath("$.[*].contentType").value(hasItem(DEFAULT_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].size").value(hasItem(DEFAULT_SIZE.intValue())))
            .andExpect(jsonPath("$.[*].isBanner").value(hasItem(DEFAULT_IS_BANNER)))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].isDeleted").value(hasItem(DEFAULT_IS_DELETED)))
            .andExpect(jsonPath("$.[*].deletedAt").value(hasItem(DEFAULT_DELETED_AT.toString())))
            .andExpect(jsonPath("$.[*].deletedBy").value(hasItem(DEFAULT_DELETED_BY.toString())));
    }

    @Test
    @Transactional
    void getFilePromotion() throws Exception {
        // Initialize the database
        insertedFilePromotion = filePromotionRepository.saveAndFlush(filePromotion);

        // Get the filePromotion
        restFilePromotionMockMvc
            .perform(get(ENTITY_API_URL_ID, filePromotion.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(filePromotion.getId().intValue()))
            .andExpect(jsonPath("$.bucket").value(DEFAULT_BUCKET))
            .andExpect(jsonPath("$.objectKey").value(DEFAULT_OBJECT_KEY))
            .andExpect(jsonPath("$.contentType").value(DEFAULT_CONTENT_TYPE))
            .andExpect(jsonPath("$.size").value(DEFAULT_SIZE.intValue()))
            .andExpect(jsonPath("$.isBanner").value(DEFAULT_IS_BANNER))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.updatedAt").value(DEFAULT_UPDATED_AT.toString()))
            .andExpect(jsonPath("$.isDeleted").value(DEFAULT_IS_DELETED))
            .andExpect(jsonPath("$.deletedAt").value(DEFAULT_DELETED_AT.toString()))
            .andExpect(jsonPath("$.deletedBy").value(DEFAULT_DELETED_BY.toString()));
    }

    @Test
    @Transactional
    void getFilePromotionsByIdFiltering() throws Exception {
        // Initialize the database
        insertedFilePromotion = filePromotionRepository.saveAndFlush(filePromotion);

        Long id = filePromotion.getId();

        defaultFilePromotionFiltering("id.equals=" + id, "id.notEquals=" + id);

        defaultFilePromotionFiltering("id.greaterThanOrEqual=" + id, "id.greaterThan=" + id);

        defaultFilePromotionFiltering("id.lessThanOrEqual=" + id, "id.lessThan=" + id);
    }

    @Test
    @Transactional
    void getAllFilePromotionsByBucketIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedFilePromotion = filePromotionRepository.saveAndFlush(filePromotion);

        // Get all the filePromotionList where bucket equals to
        defaultFilePromotionFiltering("bucket.equals=" + DEFAULT_BUCKET, "bucket.equals=" + UPDATED_BUCKET);
    }

    @Test
    @Transactional
    void getAllFilePromotionsByBucketIsInShouldWork() throws Exception {
        // Initialize the database
        insertedFilePromotion = filePromotionRepository.saveAndFlush(filePromotion);

        // Get all the filePromotionList where bucket in
        defaultFilePromotionFiltering("bucket.in=" + DEFAULT_BUCKET + "," + UPDATED_BUCKET, "bucket.in=" + UPDATED_BUCKET);
    }

    @Test
    @Transactional
    void getAllFilePromotionsByBucketIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedFilePromotion = filePromotionRepository.saveAndFlush(filePromotion);

        // Get all the filePromotionList where bucket is not null
        defaultFilePromotionFiltering("bucket.specified=true", "bucket.specified=false");
    }

    @Test
    @Transactional
    void getAllFilePromotionsByBucketContainsSomething() throws Exception {
        // Initialize the database
        insertedFilePromotion = filePromotionRepository.saveAndFlush(filePromotion);

        // Get all the filePromotionList where bucket contains
        defaultFilePromotionFiltering("bucket.contains=" + DEFAULT_BUCKET, "bucket.contains=" + UPDATED_BUCKET);
    }

    @Test
    @Transactional
    void getAllFilePromotionsByBucketNotContainsSomething() throws Exception {
        // Initialize the database
        insertedFilePromotion = filePromotionRepository.saveAndFlush(filePromotion);

        // Get all the filePromotionList where bucket does not contain
        defaultFilePromotionFiltering("bucket.doesNotContain=" + UPDATED_BUCKET, "bucket.doesNotContain=" + DEFAULT_BUCKET);
    }

    @Test
    @Transactional
    void getAllFilePromotionsByObjectKeyIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedFilePromotion = filePromotionRepository.saveAndFlush(filePromotion);

        // Get all the filePromotionList where objectKey equals to
        defaultFilePromotionFiltering("objectKey.equals=" + DEFAULT_OBJECT_KEY, "objectKey.equals=" + UPDATED_OBJECT_KEY);
    }

    @Test
    @Transactional
    void getAllFilePromotionsByObjectKeyIsInShouldWork() throws Exception {
        // Initialize the database
        insertedFilePromotion = filePromotionRepository.saveAndFlush(filePromotion);

        // Get all the filePromotionList where objectKey in
        defaultFilePromotionFiltering(
            "objectKey.in=" + DEFAULT_OBJECT_KEY + "," + UPDATED_OBJECT_KEY,
            "objectKey.in=" + UPDATED_OBJECT_KEY
        );
    }

    @Test
    @Transactional
    void getAllFilePromotionsByObjectKeyIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedFilePromotion = filePromotionRepository.saveAndFlush(filePromotion);

        // Get all the filePromotionList where objectKey is not null
        defaultFilePromotionFiltering("objectKey.specified=true", "objectKey.specified=false");
    }

    @Test
    @Transactional
    void getAllFilePromotionsByObjectKeyContainsSomething() throws Exception {
        // Initialize the database
        insertedFilePromotion = filePromotionRepository.saveAndFlush(filePromotion);

        // Get all the filePromotionList where objectKey contains
        defaultFilePromotionFiltering("objectKey.contains=" + DEFAULT_OBJECT_KEY, "objectKey.contains=" + UPDATED_OBJECT_KEY);
    }

    @Test
    @Transactional
    void getAllFilePromotionsByObjectKeyNotContainsSomething() throws Exception {
        // Initialize the database
        insertedFilePromotion = filePromotionRepository.saveAndFlush(filePromotion);

        // Get all the filePromotionList where objectKey does not contain
        defaultFilePromotionFiltering("objectKey.doesNotContain=" + UPDATED_OBJECT_KEY, "objectKey.doesNotContain=" + DEFAULT_OBJECT_KEY);
    }

    @Test
    @Transactional
    void getAllFilePromotionsByContentTypeIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedFilePromotion = filePromotionRepository.saveAndFlush(filePromotion);

        // Get all the filePromotionList where contentType equals to
        defaultFilePromotionFiltering("contentType.equals=" + DEFAULT_CONTENT_TYPE, "contentType.equals=" + UPDATED_CONTENT_TYPE);
    }

    @Test
    @Transactional
    void getAllFilePromotionsByContentTypeIsInShouldWork() throws Exception {
        // Initialize the database
        insertedFilePromotion = filePromotionRepository.saveAndFlush(filePromotion);

        // Get all the filePromotionList where contentType in
        defaultFilePromotionFiltering(
            "contentType.in=" + DEFAULT_CONTENT_TYPE + "," + UPDATED_CONTENT_TYPE,
            "contentType.in=" + UPDATED_CONTENT_TYPE
        );
    }

    @Test
    @Transactional
    void getAllFilePromotionsByContentTypeIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedFilePromotion = filePromotionRepository.saveAndFlush(filePromotion);

        // Get all the filePromotionList where contentType is not null
        defaultFilePromotionFiltering("contentType.specified=true", "contentType.specified=false");
    }

    @Test
    @Transactional
    void getAllFilePromotionsByContentTypeContainsSomething() throws Exception {
        // Initialize the database
        insertedFilePromotion = filePromotionRepository.saveAndFlush(filePromotion);

        // Get all the filePromotionList where contentType contains
        defaultFilePromotionFiltering("contentType.contains=" + DEFAULT_CONTENT_TYPE, "contentType.contains=" + UPDATED_CONTENT_TYPE);
    }

    @Test
    @Transactional
    void getAllFilePromotionsByContentTypeNotContainsSomething() throws Exception {
        // Initialize the database
        insertedFilePromotion = filePromotionRepository.saveAndFlush(filePromotion);

        // Get all the filePromotionList where contentType does not contain
        defaultFilePromotionFiltering(
            "contentType.doesNotContain=" + UPDATED_CONTENT_TYPE,
            "contentType.doesNotContain=" + DEFAULT_CONTENT_TYPE
        );
    }

    @Test
    @Transactional
    void getAllFilePromotionsBySizeIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedFilePromotion = filePromotionRepository.saveAndFlush(filePromotion);

        // Get all the filePromotionList where size equals to
        defaultFilePromotionFiltering("size.equals=" + DEFAULT_SIZE, "size.equals=" + UPDATED_SIZE);
    }

    @Test
    @Transactional
    void getAllFilePromotionsBySizeIsInShouldWork() throws Exception {
        // Initialize the database
        insertedFilePromotion = filePromotionRepository.saveAndFlush(filePromotion);

        // Get all the filePromotionList where size in
        defaultFilePromotionFiltering("size.in=" + DEFAULT_SIZE + "," + UPDATED_SIZE, "size.in=" + UPDATED_SIZE);
    }

    @Test
    @Transactional
    void getAllFilePromotionsBySizeIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedFilePromotion = filePromotionRepository.saveAndFlush(filePromotion);

        // Get all the filePromotionList where size is not null
        defaultFilePromotionFiltering("size.specified=true", "size.specified=false");
    }

    @Test
    @Transactional
    void getAllFilePromotionsBySizeIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedFilePromotion = filePromotionRepository.saveAndFlush(filePromotion);

        // Get all the filePromotionList where size is greater than or equal to
        defaultFilePromotionFiltering("size.greaterThanOrEqual=" + DEFAULT_SIZE, "size.greaterThanOrEqual=" + UPDATED_SIZE);
    }

    @Test
    @Transactional
    void getAllFilePromotionsBySizeIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedFilePromotion = filePromotionRepository.saveAndFlush(filePromotion);

        // Get all the filePromotionList where size is less than or equal to
        defaultFilePromotionFiltering("size.lessThanOrEqual=" + DEFAULT_SIZE, "size.lessThanOrEqual=" + SMALLER_SIZE);
    }

    @Test
    @Transactional
    void getAllFilePromotionsBySizeIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedFilePromotion = filePromotionRepository.saveAndFlush(filePromotion);

        // Get all the filePromotionList where size is less than
        defaultFilePromotionFiltering("size.lessThan=" + UPDATED_SIZE, "size.lessThan=" + DEFAULT_SIZE);
    }

    @Test
    @Transactional
    void getAllFilePromotionsBySizeIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedFilePromotion = filePromotionRepository.saveAndFlush(filePromotion);

        // Get all the filePromotionList where size is greater than
        defaultFilePromotionFiltering("size.greaterThan=" + SMALLER_SIZE, "size.greaterThan=" + DEFAULT_SIZE);
    }

    @Test
    @Transactional
    void getAllFilePromotionsByIsBannerIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedFilePromotion = filePromotionRepository.saveAndFlush(filePromotion);

        // Get all the filePromotionList where isBanner equals to
        defaultFilePromotionFiltering("isBanner.equals=" + DEFAULT_IS_BANNER, "isBanner.equals=" + UPDATED_IS_BANNER);
    }

    @Test
    @Transactional
    void getAllFilePromotionsByIsBannerIsInShouldWork() throws Exception {
        // Initialize the database
        insertedFilePromotion = filePromotionRepository.saveAndFlush(filePromotion);

        // Get all the filePromotionList where isBanner in
        defaultFilePromotionFiltering("isBanner.in=" + DEFAULT_IS_BANNER + "," + UPDATED_IS_BANNER, "isBanner.in=" + UPDATED_IS_BANNER);
    }

    @Test
    @Transactional
    void getAllFilePromotionsByIsBannerIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedFilePromotion = filePromotionRepository.saveAndFlush(filePromotion);

        // Get all the filePromotionList where isBanner is not null
        defaultFilePromotionFiltering("isBanner.specified=true", "isBanner.specified=false");
    }

    @Test
    @Transactional
    void getAllFilePromotionsByCreatedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedFilePromotion = filePromotionRepository.saveAndFlush(filePromotion);

        // Get all the filePromotionList where createdAt equals to
        defaultFilePromotionFiltering("createdAt.equals=" + DEFAULT_CREATED_AT, "createdAt.equals=" + UPDATED_CREATED_AT);
    }

    @Test
    @Transactional
    void getAllFilePromotionsByCreatedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedFilePromotion = filePromotionRepository.saveAndFlush(filePromotion);

        // Get all the filePromotionList where createdAt in
        defaultFilePromotionFiltering(
            "createdAt.in=" + DEFAULT_CREATED_AT + "," + UPDATED_CREATED_AT,
            "createdAt.in=" + UPDATED_CREATED_AT
        );
    }

    @Test
    @Transactional
    void getAllFilePromotionsByCreatedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedFilePromotion = filePromotionRepository.saveAndFlush(filePromotion);

        // Get all the filePromotionList where createdAt is not null
        defaultFilePromotionFiltering("createdAt.specified=true", "createdAt.specified=false");
    }

    @Test
    @Transactional
    void getAllFilePromotionsByUpdatedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedFilePromotion = filePromotionRepository.saveAndFlush(filePromotion);

        // Get all the filePromotionList where updatedAt equals to
        defaultFilePromotionFiltering("updatedAt.equals=" + DEFAULT_UPDATED_AT, "updatedAt.equals=" + UPDATED_UPDATED_AT);
    }

    @Test
    @Transactional
    void getAllFilePromotionsByUpdatedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedFilePromotion = filePromotionRepository.saveAndFlush(filePromotion);

        // Get all the filePromotionList where updatedAt in
        defaultFilePromotionFiltering(
            "updatedAt.in=" + DEFAULT_UPDATED_AT + "," + UPDATED_UPDATED_AT,
            "updatedAt.in=" + UPDATED_UPDATED_AT
        );
    }

    @Test
    @Transactional
    void getAllFilePromotionsByUpdatedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedFilePromotion = filePromotionRepository.saveAndFlush(filePromotion);

        // Get all the filePromotionList where updatedAt is not null
        defaultFilePromotionFiltering("updatedAt.specified=true", "updatedAt.specified=false");
    }

    @Test
    @Transactional
    void getAllFilePromotionsByIsDeletedIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedFilePromotion = filePromotionRepository.saveAndFlush(filePromotion);

        // Get all the filePromotionList where isDeleted equals to
        defaultFilePromotionFiltering("isDeleted.equals=" + DEFAULT_IS_DELETED, "isDeleted.equals=" + UPDATED_IS_DELETED);
    }

    @Test
    @Transactional
    void getAllFilePromotionsByIsDeletedIsInShouldWork() throws Exception {
        // Initialize the database
        insertedFilePromotion = filePromotionRepository.saveAndFlush(filePromotion);

        // Get all the filePromotionList where isDeleted in
        defaultFilePromotionFiltering(
            "isDeleted.in=" + DEFAULT_IS_DELETED + "," + UPDATED_IS_DELETED,
            "isDeleted.in=" + UPDATED_IS_DELETED
        );
    }

    @Test
    @Transactional
    void getAllFilePromotionsByIsDeletedIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedFilePromotion = filePromotionRepository.saveAndFlush(filePromotion);

        // Get all the filePromotionList where isDeleted is not null
        defaultFilePromotionFiltering("isDeleted.specified=true", "isDeleted.specified=false");
    }

    @Test
    @Transactional
    void getAllFilePromotionsByDeletedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedFilePromotion = filePromotionRepository.saveAndFlush(filePromotion);

        // Get all the filePromotionList where deletedAt equals to
        defaultFilePromotionFiltering("deletedAt.equals=" + DEFAULT_DELETED_AT, "deletedAt.equals=" + UPDATED_DELETED_AT);
    }

    @Test
    @Transactional
    void getAllFilePromotionsByDeletedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedFilePromotion = filePromotionRepository.saveAndFlush(filePromotion);

        // Get all the filePromotionList where deletedAt in
        defaultFilePromotionFiltering(
            "deletedAt.in=" + DEFAULT_DELETED_AT + "," + UPDATED_DELETED_AT,
            "deletedAt.in=" + UPDATED_DELETED_AT
        );
    }

    @Test
    @Transactional
    void getAllFilePromotionsByDeletedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedFilePromotion = filePromotionRepository.saveAndFlush(filePromotion);

        // Get all the filePromotionList where deletedAt is not null
        defaultFilePromotionFiltering("deletedAt.specified=true", "deletedAt.specified=false");
    }

    @Test
    @Transactional
    void getAllFilePromotionsByDeletedByIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedFilePromotion = filePromotionRepository.saveAndFlush(filePromotion);

        // Get all the filePromotionList where deletedBy equals to
        defaultFilePromotionFiltering("deletedBy.equals=" + DEFAULT_DELETED_BY, "deletedBy.equals=" + UPDATED_DELETED_BY);
    }

    @Test
    @Transactional
    void getAllFilePromotionsByDeletedByIsInShouldWork() throws Exception {
        // Initialize the database
        insertedFilePromotion = filePromotionRepository.saveAndFlush(filePromotion);

        // Get all the filePromotionList where deletedBy in
        defaultFilePromotionFiltering(
            "deletedBy.in=" + DEFAULT_DELETED_BY + "," + UPDATED_DELETED_BY,
            "deletedBy.in=" + UPDATED_DELETED_BY
        );
    }

    @Test
    @Transactional
    void getAllFilePromotionsByDeletedByIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedFilePromotion = filePromotionRepository.saveAndFlush(filePromotion);

        // Get all the filePromotionList where deletedBy is not null
        defaultFilePromotionFiltering("deletedBy.specified=true", "deletedBy.specified=false");
    }

    @Test
    @Transactional
    void getAllFilePromotionsByPromotionIsEqualToSomething() throws Exception {
        Promotion promotion;
        if (TestUtil.findAll(em, Promotion.class).isEmpty()) {
            filePromotionRepository.saveAndFlush(filePromotion);
            promotion = PromotionResourceIT.createEntity();
        } else {
            promotion = TestUtil.findAll(em, Promotion.class).get(0);
        }
        em.persist(promotion);
        em.flush();
        filePromotion.setPromotion(promotion);
        filePromotionRepository.saveAndFlush(filePromotion);
        Long promotionId = promotion.getId();
        // Get all the filePromotionList where promotion equals to promotionId
        defaultFilePromotionShouldBeFound("promotionId.equals=" + promotionId);

        // Get all the filePromotionList where promotion equals to (promotionId + 1)
        defaultFilePromotionShouldNotBeFound("promotionId.equals=" + (promotionId + 1));
    }

    private void defaultFilePromotionFiltering(String shouldBeFound, String shouldNotBeFound) throws Exception {
        defaultFilePromotionShouldBeFound(shouldBeFound);
        defaultFilePromotionShouldNotBeFound(shouldNotBeFound);
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultFilePromotionShouldBeFound(String filter) throws Exception {
        restFilePromotionMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(filePromotion.getId().intValue())))
            .andExpect(jsonPath("$.[*].bucket").value(hasItem(DEFAULT_BUCKET)))
            .andExpect(jsonPath("$.[*].objectKey").value(hasItem(DEFAULT_OBJECT_KEY)))
            .andExpect(jsonPath("$.[*].contentType").value(hasItem(DEFAULT_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].size").value(hasItem(DEFAULT_SIZE.intValue())))
            .andExpect(jsonPath("$.[*].isBanner").value(hasItem(DEFAULT_IS_BANNER)))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].isDeleted").value(hasItem(DEFAULT_IS_DELETED)))
            .andExpect(jsonPath("$.[*].deletedAt").value(hasItem(DEFAULT_DELETED_AT.toString())))
            .andExpect(jsonPath("$.[*].deletedBy").value(hasItem(DEFAULT_DELETED_BY.toString())));

        // Check, that the count call also returns 1
        restFilePromotionMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("1"));
    }

    /**
     * Executes the search, and checks that the default entity is not returned.
     */
    private void defaultFilePromotionShouldNotBeFound(String filter) throws Exception {
        restFilePromotionMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());

        // Check, that the count call also returns 0
        restFilePromotionMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("0"));
    }

    @Test
    @Transactional
    void getNonExistingFilePromotion() throws Exception {
        // Get the filePromotion
        restFilePromotionMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingFilePromotion() throws Exception {
        // Initialize the database
        insertedFilePromotion = filePromotionRepository.saveAndFlush(filePromotion);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the filePromotion
        FilePromotion updatedFilePromotion = filePromotionRepository.findById(filePromotion.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedFilePromotion are not directly saved in db
        em.detach(updatedFilePromotion);
        updatedFilePromotion
            .bucket(UPDATED_BUCKET)
            .objectKey(UPDATED_OBJECT_KEY)
            .contentType(UPDATED_CONTENT_TYPE)
            .size(UPDATED_SIZE)
            .isBanner(UPDATED_IS_BANNER)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);
        FilePromotionDTO filePromotionDTO = filePromotionMapper.toDto(updatedFilePromotion);

        restFilePromotionMockMvc
            .perform(
                put(ENTITY_API_URL_ID, filePromotionDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(filePromotionDTO))
            )
            .andExpect(status().isOk());

        // Validate the FilePromotion in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedFilePromotionToMatchAllProperties(updatedFilePromotion);
    }

    @Test
    @Transactional
    void putNonExistingFilePromotion() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        filePromotion.setId(longCount.incrementAndGet());

        // Create the FilePromotion
        FilePromotionDTO filePromotionDTO = filePromotionMapper.toDto(filePromotion);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restFilePromotionMockMvc
            .perform(
                put(ENTITY_API_URL_ID, filePromotionDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(filePromotionDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the FilePromotion in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchFilePromotion() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        filePromotion.setId(longCount.incrementAndGet());

        // Create the FilePromotion
        FilePromotionDTO filePromotionDTO = filePromotionMapper.toDto(filePromotion);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restFilePromotionMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(filePromotionDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the FilePromotion in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamFilePromotion() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        filePromotion.setId(longCount.incrementAndGet());

        // Create the FilePromotion
        FilePromotionDTO filePromotionDTO = filePromotionMapper.toDto(filePromotion);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restFilePromotionMockMvc
            .perform(
                put(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(filePromotionDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the FilePromotion in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateFilePromotionWithPatch() throws Exception {
        // Initialize the database
        insertedFilePromotion = filePromotionRepository.saveAndFlush(filePromotion);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the filePromotion using partial update
        FilePromotion partialUpdatedFilePromotion = new FilePromotion();
        partialUpdatedFilePromotion.setId(filePromotion.getId());

        partialUpdatedFilePromotion
            .bucket(UPDATED_BUCKET)
            .objectKey(UPDATED_OBJECT_KEY)
            .contentType(UPDATED_CONTENT_TYPE)
            .isBanner(UPDATED_IS_BANNER)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);

        restFilePromotionMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedFilePromotion.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedFilePromotion))
            )
            .andExpect(status().isOk());

        // Validate the FilePromotion in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertFilePromotionUpdatableFieldsEquals(
            createUpdateProxyForBean(partialUpdatedFilePromotion, filePromotion),
            getPersistedFilePromotion(filePromotion)
        );
    }

    @Test
    @Transactional
    void fullUpdateFilePromotionWithPatch() throws Exception {
        // Initialize the database
        insertedFilePromotion = filePromotionRepository.saveAndFlush(filePromotion);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the filePromotion using partial update
        FilePromotion partialUpdatedFilePromotion = new FilePromotion();
        partialUpdatedFilePromotion.setId(filePromotion.getId());

        partialUpdatedFilePromotion
            .bucket(UPDATED_BUCKET)
            .objectKey(UPDATED_OBJECT_KEY)
            .contentType(UPDATED_CONTENT_TYPE)
            .size(UPDATED_SIZE)
            .isBanner(UPDATED_IS_BANNER)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);

        restFilePromotionMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedFilePromotion.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedFilePromotion))
            )
            .andExpect(status().isOk());

        // Validate the FilePromotion in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertFilePromotionUpdatableFieldsEquals(partialUpdatedFilePromotion, getPersistedFilePromotion(partialUpdatedFilePromotion));
    }

    @Test
    @Transactional
    void patchNonExistingFilePromotion() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        filePromotion.setId(longCount.incrementAndGet());

        // Create the FilePromotion
        FilePromotionDTO filePromotionDTO = filePromotionMapper.toDto(filePromotion);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restFilePromotionMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, filePromotionDTO.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(filePromotionDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the FilePromotion in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchFilePromotion() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        filePromotion.setId(longCount.incrementAndGet());

        // Create the FilePromotion
        FilePromotionDTO filePromotionDTO = filePromotionMapper.toDto(filePromotion);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restFilePromotionMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(filePromotionDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the FilePromotion in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamFilePromotion() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        filePromotion.setId(longCount.incrementAndGet());

        // Create the FilePromotion
        FilePromotionDTO filePromotionDTO = filePromotionMapper.toDto(filePromotion);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restFilePromotionMockMvc
            .perform(
                patch(ENTITY_API_URL)
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(filePromotionDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the FilePromotion in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteFilePromotion() throws Exception {
        // Initialize the database
        insertedFilePromotion = filePromotionRepository.saveAndFlush(filePromotion);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the filePromotion
        restFilePromotionMockMvc
            .perform(delete(ENTITY_API_URL_ID, filePromotion.getId()).with(csrf()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return filePromotionRepository.count();
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

    protected FilePromotion getPersistedFilePromotion(FilePromotion filePromotion) {
        return filePromotionRepository.findById(filePromotion.getId()).orElseThrow();
    }

    protected void assertPersistedFilePromotionToMatchAllProperties(FilePromotion expectedFilePromotion) {
        assertFilePromotionAllPropertiesEquals(expectedFilePromotion, getPersistedFilePromotion(expectedFilePromotion));
    }

    protected void assertPersistedFilePromotionToMatchUpdatableProperties(FilePromotion expectedFilePromotion) {
        assertFilePromotionAllUpdatablePropertiesEquals(expectedFilePromotion, getPersistedFilePromotion(expectedFilePromotion));
    }
}
