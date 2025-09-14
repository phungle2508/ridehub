package com.ticketsystem.route.web.rest;

import static com.ticketsystem.route.domain.ReviewSummaryAsserts.*;
import static com.ticketsystem.route.web.rest.TestUtil.createUpdateProxyForBean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketsystem.route.IntegrationTest;
import com.ticketsystem.route.domain.ReviewSummary;
import com.ticketsystem.route.repository.ReviewSummaryRepository;
import com.ticketsystem.route.service.dto.ReviewSummaryDTO;
import com.ticketsystem.route.service.mapper.ReviewSummaryMapper;
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
 * Integration tests for the {@link ReviewSummaryResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class ReviewSummaryResourceIT {

    private static final Double DEFAULT_AVERAGE_RATING = 1D;
    private static final Double UPDATED_AVERAGE_RATING = 2D;
    private static final Double SMALLER_AVERAGE_RATING = 1D - 1D;

    private static final Integer DEFAULT_TOTAL_REVIEWS = 1;
    private static final Integer UPDATED_TOTAL_REVIEWS = 2;
    private static final Integer SMALLER_TOTAL_REVIEWS = 1 - 1;

    private static final Instant DEFAULT_UPDATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_UPDATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String ENTITY_API_URL = "/api/review-summaries";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private ReviewSummaryRepository reviewSummaryRepository;

    @Autowired
    private ReviewSummaryMapper reviewSummaryMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restReviewSummaryMockMvc;

    private ReviewSummary reviewSummary;

    private ReviewSummary insertedReviewSummary;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ReviewSummary createEntity(EntityManager em) {
        ReviewSummary reviewSummary = new ReviewSummary()
            .averageRating(DEFAULT_AVERAGE_RATING)
            .totalReviews(DEFAULT_TOTAL_REVIEWS)
            .updatedAt(DEFAULT_UPDATED_AT);
        return reviewSummary;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ReviewSummary createUpdatedEntity(EntityManager em) {
        ReviewSummary updatedReviewSummary = new ReviewSummary()
            .averageRating(UPDATED_AVERAGE_RATING)
            .totalReviews(UPDATED_TOTAL_REVIEWS)
            .updatedAt(UPDATED_UPDATED_AT);
        return updatedReviewSummary;
    }

    @BeforeEach
    void initTest() {
        reviewSummary = createEntity(em);
    }

    @AfterEach
    void cleanup() {
        if (insertedReviewSummary != null) {
            reviewSummaryRepository.delete(insertedReviewSummary);
            insertedReviewSummary = null;
        }
    }

    @Test
    @Transactional
    void createReviewSummary() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the ReviewSummary
        ReviewSummaryDTO reviewSummaryDTO = reviewSummaryMapper.toDto(reviewSummary);
        var returnedReviewSummaryDTO = om.readValue(
            restReviewSummaryMockMvc
                .perform(
                    post(ENTITY_API_URL)
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsBytes(reviewSummaryDTO))
                )
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            ReviewSummaryDTO.class
        );

        // Validate the ReviewSummary in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        var returnedReviewSummary = reviewSummaryMapper.toEntity(returnedReviewSummaryDTO);
        assertReviewSummaryUpdatableFieldsEquals(returnedReviewSummary, getPersistedReviewSummary(returnedReviewSummary));

        insertedReviewSummary = returnedReviewSummary;
    }

    @Test
    @Transactional
    void createReviewSummaryWithExistingId() throws Exception {
        // Create the ReviewSummary with an existing ID
        reviewSummary.setId(1L);
        ReviewSummaryDTO reviewSummaryDTO = reviewSummaryMapper.toDto(reviewSummary);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restReviewSummaryMockMvc
            .perform(
                post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(reviewSummaryDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the ReviewSummary in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkUpdatedAtIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        reviewSummary.setUpdatedAt(null);

        // Create the ReviewSummary, which fails.
        ReviewSummaryDTO reviewSummaryDTO = reviewSummaryMapper.toDto(reviewSummary);

        restReviewSummaryMockMvc
            .perform(
                post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(reviewSummaryDTO))
            )
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllReviewSummaries() throws Exception {
        // Initialize the database
        insertedReviewSummary = reviewSummaryRepository.saveAndFlush(reviewSummary);

        // Get all the reviewSummaryList
        restReviewSummaryMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(reviewSummary.getId().intValue())))
            .andExpect(jsonPath("$.[*].averageRating").value(hasItem(DEFAULT_AVERAGE_RATING)))
            .andExpect(jsonPath("$.[*].totalReviews").value(hasItem(DEFAULT_TOTAL_REVIEWS)))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())));
    }

    @Test
    @Transactional
    void getReviewSummary() throws Exception {
        // Initialize the database
        insertedReviewSummary = reviewSummaryRepository.saveAndFlush(reviewSummary);

        // Get the reviewSummary
        restReviewSummaryMockMvc
            .perform(get(ENTITY_API_URL_ID, reviewSummary.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(reviewSummary.getId().intValue()))
            .andExpect(jsonPath("$.averageRating").value(DEFAULT_AVERAGE_RATING))
            .andExpect(jsonPath("$.totalReviews").value(DEFAULT_TOTAL_REVIEWS))
            .andExpect(jsonPath("$.updatedAt").value(DEFAULT_UPDATED_AT.toString()));
    }

    @Test
    @Transactional
    void getReviewSummariesByIdFiltering() throws Exception {
        // Initialize the database
        insertedReviewSummary = reviewSummaryRepository.saveAndFlush(reviewSummary);

        Long id = reviewSummary.getId();

        defaultReviewSummaryFiltering("id.equals=" + id, "id.notEquals=" + id);

        defaultReviewSummaryFiltering("id.greaterThanOrEqual=" + id, "id.greaterThan=" + id);

        defaultReviewSummaryFiltering("id.lessThanOrEqual=" + id, "id.lessThan=" + id);
    }

    @Test
    @Transactional
    void getAllReviewSummariesByAverageRatingIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedReviewSummary = reviewSummaryRepository.saveAndFlush(reviewSummary);

        // Get all the reviewSummaryList where averageRating equals to
        defaultReviewSummaryFiltering("averageRating.equals=" + DEFAULT_AVERAGE_RATING, "averageRating.equals=" + UPDATED_AVERAGE_RATING);
    }

    @Test
    @Transactional
    void getAllReviewSummariesByAverageRatingIsInShouldWork() throws Exception {
        // Initialize the database
        insertedReviewSummary = reviewSummaryRepository.saveAndFlush(reviewSummary);

        // Get all the reviewSummaryList where averageRating in
        defaultReviewSummaryFiltering(
            "averageRating.in=" + DEFAULT_AVERAGE_RATING + "," + UPDATED_AVERAGE_RATING,
            "averageRating.in=" + UPDATED_AVERAGE_RATING
        );
    }

    @Test
    @Transactional
    void getAllReviewSummariesByAverageRatingIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedReviewSummary = reviewSummaryRepository.saveAndFlush(reviewSummary);

        // Get all the reviewSummaryList where averageRating is not null
        defaultReviewSummaryFiltering("averageRating.specified=true", "averageRating.specified=false");
    }

    @Test
    @Transactional
    void getAllReviewSummariesByAverageRatingIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedReviewSummary = reviewSummaryRepository.saveAndFlush(reviewSummary);

        // Get all the reviewSummaryList where averageRating is greater than or equal to
        defaultReviewSummaryFiltering(
            "averageRating.greaterThanOrEqual=" + DEFAULT_AVERAGE_RATING,
            "averageRating.greaterThanOrEqual=" + UPDATED_AVERAGE_RATING
        );
    }

    @Test
    @Transactional
    void getAllReviewSummariesByAverageRatingIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedReviewSummary = reviewSummaryRepository.saveAndFlush(reviewSummary);

        // Get all the reviewSummaryList where averageRating is less than or equal to
        defaultReviewSummaryFiltering(
            "averageRating.lessThanOrEqual=" + DEFAULT_AVERAGE_RATING,
            "averageRating.lessThanOrEqual=" + SMALLER_AVERAGE_RATING
        );
    }

    @Test
    @Transactional
    void getAllReviewSummariesByAverageRatingIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedReviewSummary = reviewSummaryRepository.saveAndFlush(reviewSummary);

        // Get all the reviewSummaryList where averageRating is less than
        defaultReviewSummaryFiltering(
            "averageRating.lessThan=" + UPDATED_AVERAGE_RATING,
            "averageRating.lessThan=" + DEFAULT_AVERAGE_RATING
        );
    }

    @Test
    @Transactional
    void getAllReviewSummariesByAverageRatingIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedReviewSummary = reviewSummaryRepository.saveAndFlush(reviewSummary);

        // Get all the reviewSummaryList where averageRating is greater than
        defaultReviewSummaryFiltering(
            "averageRating.greaterThan=" + SMALLER_AVERAGE_RATING,
            "averageRating.greaterThan=" + DEFAULT_AVERAGE_RATING
        );
    }

    @Test
    @Transactional
    void getAllReviewSummariesByTotalReviewsIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedReviewSummary = reviewSummaryRepository.saveAndFlush(reviewSummary);

        // Get all the reviewSummaryList where totalReviews equals to
        defaultReviewSummaryFiltering("totalReviews.equals=" + DEFAULT_TOTAL_REVIEWS, "totalReviews.equals=" + UPDATED_TOTAL_REVIEWS);
    }

    @Test
    @Transactional
    void getAllReviewSummariesByTotalReviewsIsInShouldWork() throws Exception {
        // Initialize the database
        insertedReviewSummary = reviewSummaryRepository.saveAndFlush(reviewSummary);

        // Get all the reviewSummaryList where totalReviews in
        defaultReviewSummaryFiltering(
            "totalReviews.in=" + DEFAULT_TOTAL_REVIEWS + "," + UPDATED_TOTAL_REVIEWS,
            "totalReviews.in=" + UPDATED_TOTAL_REVIEWS
        );
    }

    @Test
    @Transactional
    void getAllReviewSummariesByTotalReviewsIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedReviewSummary = reviewSummaryRepository.saveAndFlush(reviewSummary);

        // Get all the reviewSummaryList where totalReviews is not null
        defaultReviewSummaryFiltering("totalReviews.specified=true", "totalReviews.specified=false");
    }

    @Test
    @Transactional
    void getAllReviewSummariesByTotalReviewsIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedReviewSummary = reviewSummaryRepository.saveAndFlush(reviewSummary);

        // Get all the reviewSummaryList where totalReviews is greater than or equal to
        defaultReviewSummaryFiltering(
            "totalReviews.greaterThanOrEqual=" + DEFAULT_TOTAL_REVIEWS,
            "totalReviews.greaterThanOrEqual=" + UPDATED_TOTAL_REVIEWS
        );
    }

    @Test
    @Transactional
    void getAllReviewSummariesByTotalReviewsIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedReviewSummary = reviewSummaryRepository.saveAndFlush(reviewSummary);

        // Get all the reviewSummaryList where totalReviews is less than or equal to
        defaultReviewSummaryFiltering(
            "totalReviews.lessThanOrEqual=" + DEFAULT_TOTAL_REVIEWS,
            "totalReviews.lessThanOrEqual=" + SMALLER_TOTAL_REVIEWS
        );
    }

    @Test
    @Transactional
    void getAllReviewSummariesByTotalReviewsIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedReviewSummary = reviewSummaryRepository.saveAndFlush(reviewSummary);

        // Get all the reviewSummaryList where totalReviews is less than
        defaultReviewSummaryFiltering("totalReviews.lessThan=" + UPDATED_TOTAL_REVIEWS, "totalReviews.lessThan=" + DEFAULT_TOTAL_REVIEWS);
    }

    @Test
    @Transactional
    void getAllReviewSummariesByTotalReviewsIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedReviewSummary = reviewSummaryRepository.saveAndFlush(reviewSummary);

        // Get all the reviewSummaryList where totalReviews is greater than
        defaultReviewSummaryFiltering(
            "totalReviews.greaterThan=" + SMALLER_TOTAL_REVIEWS,
            "totalReviews.greaterThan=" + DEFAULT_TOTAL_REVIEWS
        );
    }

    @Test
    @Transactional
    void getAllReviewSummariesByUpdatedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedReviewSummary = reviewSummaryRepository.saveAndFlush(reviewSummary);

        // Get all the reviewSummaryList where updatedAt equals to
        defaultReviewSummaryFiltering("updatedAt.equals=" + DEFAULT_UPDATED_AT, "updatedAt.equals=" + UPDATED_UPDATED_AT);
    }

    @Test
    @Transactional
    void getAllReviewSummariesByUpdatedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedReviewSummary = reviewSummaryRepository.saveAndFlush(reviewSummary);

        // Get all the reviewSummaryList where updatedAt in
        defaultReviewSummaryFiltering(
            "updatedAt.in=" + DEFAULT_UPDATED_AT + "," + UPDATED_UPDATED_AT,
            "updatedAt.in=" + UPDATED_UPDATED_AT
        );
    }

    @Test
    @Transactional
    void getAllReviewSummariesByUpdatedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedReviewSummary = reviewSummaryRepository.saveAndFlush(reviewSummary);

        // Get all the reviewSummaryList where updatedAt is not null
        defaultReviewSummaryFiltering("updatedAt.specified=true", "updatedAt.specified=false");
    }

    private void defaultReviewSummaryFiltering(String shouldBeFound, String shouldNotBeFound) throws Exception {
        defaultReviewSummaryShouldBeFound(shouldBeFound);
        defaultReviewSummaryShouldNotBeFound(shouldNotBeFound);
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultReviewSummaryShouldBeFound(String filter) throws Exception {
        restReviewSummaryMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(reviewSummary.getId().intValue())))
            .andExpect(jsonPath("$.[*].averageRating").value(hasItem(DEFAULT_AVERAGE_RATING)))
            .andExpect(jsonPath("$.[*].totalReviews").value(hasItem(DEFAULT_TOTAL_REVIEWS)))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())));

        // Check, that the count call also returns 1
        restReviewSummaryMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("1"));
    }

    /**
     * Executes the search, and checks that the default entity is not returned.
     */
    private void defaultReviewSummaryShouldNotBeFound(String filter) throws Exception {
        restReviewSummaryMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());

        // Check, that the count call also returns 0
        restReviewSummaryMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("0"));
    }

    @Test
    @Transactional
    void getNonExistingReviewSummary() throws Exception {
        // Get the reviewSummary
        restReviewSummaryMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingReviewSummary() throws Exception {
        // Initialize the database
        insertedReviewSummary = reviewSummaryRepository.saveAndFlush(reviewSummary);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the reviewSummary
        ReviewSummary updatedReviewSummary = reviewSummaryRepository.findById(reviewSummary.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedReviewSummary are not directly saved in db
        em.detach(updatedReviewSummary);
        updatedReviewSummary.averageRating(UPDATED_AVERAGE_RATING).totalReviews(UPDATED_TOTAL_REVIEWS).updatedAt(UPDATED_UPDATED_AT);
        ReviewSummaryDTO reviewSummaryDTO = reviewSummaryMapper.toDto(updatedReviewSummary);

        restReviewSummaryMockMvc
            .perform(
                put(ENTITY_API_URL_ID, reviewSummaryDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(reviewSummaryDTO))
            )
            .andExpect(status().isOk());

        // Validate the ReviewSummary in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedReviewSummaryToMatchAllProperties(updatedReviewSummary);
    }

    @Test
    @Transactional
    void putNonExistingReviewSummary() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        reviewSummary.setId(longCount.incrementAndGet());

        // Create the ReviewSummary
        ReviewSummaryDTO reviewSummaryDTO = reviewSummaryMapper.toDto(reviewSummary);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restReviewSummaryMockMvc
            .perform(
                put(ENTITY_API_URL_ID, reviewSummaryDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(reviewSummaryDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the ReviewSummary in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchReviewSummary() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        reviewSummary.setId(longCount.incrementAndGet());

        // Create the ReviewSummary
        ReviewSummaryDTO reviewSummaryDTO = reviewSummaryMapper.toDto(reviewSummary);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restReviewSummaryMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(reviewSummaryDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the ReviewSummary in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamReviewSummary() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        reviewSummary.setId(longCount.incrementAndGet());

        // Create the ReviewSummary
        ReviewSummaryDTO reviewSummaryDTO = reviewSummaryMapper.toDto(reviewSummary);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restReviewSummaryMockMvc
            .perform(
                put(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(reviewSummaryDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the ReviewSummary in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateReviewSummaryWithPatch() throws Exception {
        // Initialize the database
        insertedReviewSummary = reviewSummaryRepository.saveAndFlush(reviewSummary);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the reviewSummary using partial update
        ReviewSummary partialUpdatedReviewSummary = new ReviewSummary();
        partialUpdatedReviewSummary.setId(reviewSummary.getId());

        partialUpdatedReviewSummary.totalReviews(UPDATED_TOTAL_REVIEWS);

        restReviewSummaryMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedReviewSummary.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedReviewSummary))
            )
            .andExpect(status().isOk());

        // Validate the ReviewSummary in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertReviewSummaryUpdatableFieldsEquals(
            createUpdateProxyForBean(partialUpdatedReviewSummary, reviewSummary),
            getPersistedReviewSummary(reviewSummary)
        );
    }

    @Test
    @Transactional
    void fullUpdateReviewSummaryWithPatch() throws Exception {
        // Initialize the database
        insertedReviewSummary = reviewSummaryRepository.saveAndFlush(reviewSummary);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the reviewSummary using partial update
        ReviewSummary partialUpdatedReviewSummary = new ReviewSummary();
        partialUpdatedReviewSummary.setId(reviewSummary.getId());

        partialUpdatedReviewSummary.averageRating(UPDATED_AVERAGE_RATING).totalReviews(UPDATED_TOTAL_REVIEWS).updatedAt(UPDATED_UPDATED_AT);

        restReviewSummaryMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedReviewSummary.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedReviewSummary))
            )
            .andExpect(status().isOk());

        // Validate the ReviewSummary in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertReviewSummaryUpdatableFieldsEquals(partialUpdatedReviewSummary, getPersistedReviewSummary(partialUpdatedReviewSummary));
    }

    @Test
    @Transactional
    void patchNonExistingReviewSummary() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        reviewSummary.setId(longCount.incrementAndGet());

        // Create the ReviewSummary
        ReviewSummaryDTO reviewSummaryDTO = reviewSummaryMapper.toDto(reviewSummary);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restReviewSummaryMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, reviewSummaryDTO.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(reviewSummaryDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the ReviewSummary in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchReviewSummary() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        reviewSummary.setId(longCount.incrementAndGet());

        // Create the ReviewSummary
        ReviewSummaryDTO reviewSummaryDTO = reviewSummaryMapper.toDto(reviewSummary);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restReviewSummaryMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(reviewSummaryDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the ReviewSummary in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamReviewSummary() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        reviewSummary.setId(longCount.incrementAndGet());

        // Create the ReviewSummary
        ReviewSummaryDTO reviewSummaryDTO = reviewSummaryMapper.toDto(reviewSummary);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restReviewSummaryMockMvc
            .perform(
                patch(ENTITY_API_URL)
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(reviewSummaryDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the ReviewSummary in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteReviewSummary() throws Exception {
        // Initialize the database
        insertedReviewSummary = reviewSummaryRepository.saveAndFlush(reviewSummary);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the reviewSummary
        restReviewSummaryMockMvc
            .perform(delete(ENTITY_API_URL_ID, reviewSummary.getId()).with(csrf()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return reviewSummaryRepository.count();
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

    protected ReviewSummary getPersistedReviewSummary(ReviewSummary reviewSummary) {
        return reviewSummaryRepository.findById(reviewSummary.getId()).orElseThrow();
    }

    protected void assertPersistedReviewSummaryToMatchAllProperties(ReviewSummary expectedReviewSummary) {
        assertReviewSummaryAllPropertiesEquals(expectedReviewSummary, getPersistedReviewSummary(expectedReviewSummary));
    }

    protected void assertPersistedReviewSummaryToMatchUpdatableProperties(ReviewSummary expectedReviewSummary) {
        assertReviewSummaryAllUpdatablePropertiesEquals(expectedReviewSummary, getPersistedReviewSummary(expectedReviewSummary));
    }
}
