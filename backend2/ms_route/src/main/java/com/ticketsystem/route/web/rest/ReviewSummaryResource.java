package com.ticketsystem.route.web.rest;

import com.ticketsystem.route.repository.ReviewSummaryRepository;
import com.ticketsystem.route.service.ReviewSummaryQueryService;
import com.ticketsystem.route.service.ReviewSummaryService;
import com.ticketsystem.route.service.criteria.ReviewSummaryCriteria;
import com.ticketsystem.route.service.dto.ReviewSummaryDTO;
import com.ticketsystem.route.web.rest.errors.BadRequestAlertException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.ticketsystem.route.domain.ReviewSummary}.
 */
@RestController
@RequestMapping("/api/review-summaries")
public class ReviewSummaryResource {

    private static final Logger LOG = LoggerFactory.getLogger(ReviewSummaryResource.class);

    private static final String ENTITY_NAME = "msRouteReviewSummary";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ReviewSummaryService reviewSummaryService;

    private final ReviewSummaryRepository reviewSummaryRepository;

    private final ReviewSummaryQueryService reviewSummaryQueryService;

    public ReviewSummaryResource(
        ReviewSummaryService reviewSummaryService,
        ReviewSummaryRepository reviewSummaryRepository,
        ReviewSummaryQueryService reviewSummaryQueryService
    ) {
        this.reviewSummaryService = reviewSummaryService;
        this.reviewSummaryRepository = reviewSummaryRepository;
        this.reviewSummaryQueryService = reviewSummaryQueryService;
    }

    /**
     * {@code POST  /review-summaries} : Create a new reviewSummary.
     *
     * @param reviewSummaryDTO the reviewSummaryDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new reviewSummaryDTO, or with status {@code 400 (Bad Request)} if the reviewSummary has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<ReviewSummaryDTO> createReviewSummary(@Valid @RequestBody ReviewSummaryDTO reviewSummaryDTO)
        throws URISyntaxException {
        LOG.debug("REST request to save ReviewSummary : {}", reviewSummaryDTO);
        if (reviewSummaryDTO.getId() != null) {
            throw new BadRequestAlertException("A new reviewSummary cannot already have an ID", ENTITY_NAME, "idexists");
        }
        reviewSummaryDTO = reviewSummaryService.save(reviewSummaryDTO);
        return ResponseEntity.created(new URI("/api/review-summaries/" + reviewSummaryDTO.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, reviewSummaryDTO.getId().toString()))
            .body(reviewSummaryDTO);
    }

    /**
     * {@code PUT  /review-summaries/:id} : Updates an existing reviewSummary.
     *
     * @param id the id of the reviewSummaryDTO to save.
     * @param reviewSummaryDTO the reviewSummaryDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated reviewSummaryDTO,
     * or with status {@code 400 (Bad Request)} if the reviewSummaryDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the reviewSummaryDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ReviewSummaryDTO> updateReviewSummary(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody ReviewSummaryDTO reviewSummaryDTO
    ) throws URISyntaxException {
        LOG.debug("REST request to update ReviewSummary : {}, {}", id, reviewSummaryDTO);
        if (reviewSummaryDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, reviewSummaryDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!reviewSummaryRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        reviewSummaryDTO = reviewSummaryService.update(reviewSummaryDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, reviewSummaryDTO.getId().toString()))
            .body(reviewSummaryDTO);
    }

    /**
     * {@code PATCH  /review-summaries/:id} : Partial updates given fields of an existing reviewSummary, field will ignore if it is null
     *
     * @param id the id of the reviewSummaryDTO to save.
     * @param reviewSummaryDTO the reviewSummaryDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated reviewSummaryDTO,
     * or with status {@code 400 (Bad Request)} if the reviewSummaryDTO is not valid,
     * or with status {@code 404 (Not Found)} if the reviewSummaryDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the reviewSummaryDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<ReviewSummaryDTO> partialUpdateReviewSummary(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody ReviewSummaryDTO reviewSummaryDTO
    ) throws URISyntaxException {
        LOG.debug("REST request to partial update ReviewSummary partially : {}, {}", id, reviewSummaryDTO);
        if (reviewSummaryDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, reviewSummaryDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!reviewSummaryRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<ReviewSummaryDTO> result = reviewSummaryService.partialUpdate(reviewSummaryDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, reviewSummaryDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /review-summaries} : get all the reviewSummaries.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of reviewSummaries in body.
     */
    @GetMapping("")
    public ResponseEntity<List<ReviewSummaryDTO>> getAllReviewSummaries(ReviewSummaryCriteria criteria) {
        LOG.debug("REST request to get ReviewSummaries by criteria: {}", criteria);

        List<ReviewSummaryDTO> entityList = reviewSummaryQueryService.findByCriteria(criteria);
        return ResponseEntity.ok().body(entityList);
    }

    /**
     * {@code GET  /review-summaries/count} : count all the reviewSummaries.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/count")
    public ResponseEntity<Long> countReviewSummaries(ReviewSummaryCriteria criteria) {
        LOG.debug("REST request to count ReviewSummaries by criteria: {}", criteria);
        return ResponseEntity.ok().body(reviewSummaryQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /review-summaries/:id} : get the "id" reviewSummary.
     *
     * @param id the id of the reviewSummaryDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the reviewSummaryDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ReviewSummaryDTO> getReviewSummary(@PathVariable("id") Long id) {
        LOG.debug("REST request to get ReviewSummary : {}", id);
        Optional<ReviewSummaryDTO> reviewSummaryDTO = reviewSummaryService.findOne(id);
        return ResponseUtil.wrapOrNotFound(reviewSummaryDTO);
    }

    /**
     * {@code DELETE  /review-summaries/:id} : delete the "id" reviewSummary.
     *
     * @param id the id of the reviewSummaryDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReviewSummary(@PathVariable("id") Long id) {
        LOG.debug("REST request to delete ReviewSummary : {}", id);
        reviewSummaryService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
