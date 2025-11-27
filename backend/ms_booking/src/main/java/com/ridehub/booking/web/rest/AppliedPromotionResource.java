package com.ridehub.booking.web.rest;

import com.ridehub.booking.repository.AppliedPromotionRepository;
import com.ridehub.booking.service.AppliedPromotionQueryService;
import com.ridehub.booking.service.AppliedPromotionService;
import com.ridehub.booking.service.criteria.AppliedPromotionCriteria;
import com.ridehub.booking.service.dto.AppliedPromotionDTO;
import com.ridehub.booking.web.rest.errors.BadRequestAlertException;
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
 * REST controller for managing {@link com.ridehub.booking.domain.AppliedPromotion}.
 */
@RestController
@RequestMapping("/api/applied-promotions")
public class AppliedPromotionResource {

    private static final Logger LOG = LoggerFactory.getLogger(AppliedPromotionResource.class);

    private static final String ENTITY_NAME = "msBookingAppliedPromotion";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AppliedPromotionService appliedPromotionService;

    private final AppliedPromotionRepository appliedPromotionRepository;

    private final AppliedPromotionQueryService appliedPromotionQueryService;

    public AppliedPromotionResource(
        AppliedPromotionService appliedPromotionService,
        AppliedPromotionRepository appliedPromotionRepository,
        AppliedPromotionQueryService appliedPromotionQueryService
    ) {
        this.appliedPromotionService = appliedPromotionService;
        this.appliedPromotionRepository = appliedPromotionRepository;
        this.appliedPromotionQueryService = appliedPromotionQueryService;
    }

    /**
     * {@code POST  /applied-promotions} : Create a new appliedPromotion.
     *
     * @param appliedPromotionDTO the appliedPromotionDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new appliedPromotionDTO, or with status {@code 400 (Bad Request)} if the appliedPromotion has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<AppliedPromotionDTO> createAppliedPromotion(@Valid @RequestBody AppliedPromotionDTO appliedPromotionDTO)
        throws URISyntaxException {
        LOG.debug("REST request to save AppliedPromotion : {}", appliedPromotionDTO);
        if (appliedPromotionDTO.getId() != null) {
            throw new BadRequestAlertException("A new appliedPromotion cannot already have an ID", ENTITY_NAME, "idexists");
        }
        appliedPromotionDTO = appliedPromotionService.save(appliedPromotionDTO);
        return ResponseEntity.created(new URI("/api/applied-promotions/" + appliedPromotionDTO.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, appliedPromotionDTO.getId().toString()))
            .body(appliedPromotionDTO);
    }

    /**
     * {@code PUT  /applied-promotions/:id} : Updates an existing appliedPromotion.
     *
     * @param id the id of the appliedPromotionDTO to save.
     * @param appliedPromotionDTO the appliedPromotionDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated appliedPromotionDTO,
     * or with status {@code 400 (Bad Request)} if the appliedPromotionDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the appliedPromotionDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<AppliedPromotionDTO> updateAppliedPromotion(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody AppliedPromotionDTO appliedPromotionDTO
    ) throws URISyntaxException {
        LOG.debug("REST request to update AppliedPromotion : {}, {}", id, appliedPromotionDTO);
        if (appliedPromotionDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, appliedPromotionDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!appliedPromotionRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        appliedPromotionDTO = appliedPromotionService.update(appliedPromotionDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, appliedPromotionDTO.getId().toString()))
            .body(appliedPromotionDTO);
    }

    /**
     * {@code PATCH  /applied-promotions/:id} : Partial updates given fields of an existing appliedPromotion, field will ignore if it is null
     *
     * @param id the id of the appliedPromotionDTO to save.
     * @param appliedPromotionDTO the appliedPromotionDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated appliedPromotionDTO,
     * or with status {@code 400 (Bad Request)} if the appliedPromotionDTO is not valid,
     * or with status {@code 404 (Not Found)} if the appliedPromotionDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the appliedPromotionDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<AppliedPromotionDTO> partialUpdateAppliedPromotion(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody AppliedPromotionDTO appliedPromotionDTO
    ) throws URISyntaxException {
        LOG.debug("REST request to partial update AppliedPromotion partially : {}, {}", id, appliedPromotionDTO);
        if (appliedPromotionDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, appliedPromotionDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!appliedPromotionRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<AppliedPromotionDTO> result = appliedPromotionService.partialUpdate(appliedPromotionDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, appliedPromotionDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /applied-promotions} : get all the appliedPromotions.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of appliedPromotions in body.
     */
    @GetMapping("")
    public ResponseEntity<List<AppliedPromotionDTO>> getAllAppliedPromotions(AppliedPromotionCriteria criteria) {
        LOG.debug("REST request to get AppliedPromotions by criteria: {}", criteria);

        List<AppliedPromotionDTO> entityList = appliedPromotionQueryService.findByCriteria(criteria);
        return ResponseEntity.ok().body(entityList);
    }

    /**
     * {@code GET  /applied-promotions/count} : count all the appliedPromotions.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/count")
    public ResponseEntity<Long> countAppliedPromotions(AppliedPromotionCriteria criteria) {
        LOG.debug("REST request to count AppliedPromotions by criteria: {}", criteria);
        return ResponseEntity.ok().body(appliedPromotionQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /applied-promotions/:id} : get the "id" appliedPromotion.
     *
     * @param id the id of the appliedPromotionDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the appliedPromotionDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<AppliedPromotionDTO> getAppliedPromotion(@PathVariable("id") Long id) {
        LOG.debug("REST request to get AppliedPromotion : {}", id);
        Optional<AppliedPromotionDTO> appliedPromotionDTO = appliedPromotionService.findOne(id);
        return ResponseUtil.wrapOrNotFound(appliedPromotionDTO);
    }

    /**
     * {@code DELETE  /applied-promotions/:id} : delete the "id" appliedPromotion.
     *
     * @param id the id of the appliedPromotionDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppliedPromotion(@PathVariable("id") Long id) {
        LOG.debug("REST request to delete AppliedPromotion : {}", id);
        appliedPromotionService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
