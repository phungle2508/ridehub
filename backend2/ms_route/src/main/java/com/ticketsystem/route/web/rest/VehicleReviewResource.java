package com.ticketsystem.route.web.rest;

import com.ticketsystem.route.repository.VehicleReviewRepository;
import com.ticketsystem.route.service.VehicleReviewQueryService;
import com.ticketsystem.route.service.VehicleReviewService;
import com.ticketsystem.route.service.criteria.VehicleReviewCriteria;
import com.ticketsystem.route.service.dto.VehicleReviewDTO;
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
 * REST controller for managing {@link com.ticketsystem.route.domain.VehicleReview}.
 */
@RestController
@RequestMapping("/api/vehicle-reviews")
public class VehicleReviewResource {

    private static final Logger LOG = LoggerFactory.getLogger(VehicleReviewResource.class);

    private static final String ENTITY_NAME = "msRouteVehicleReview";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final VehicleReviewService vehicleReviewService;

    private final VehicleReviewRepository vehicleReviewRepository;

    private final VehicleReviewQueryService vehicleReviewQueryService;

    public VehicleReviewResource(
        VehicleReviewService vehicleReviewService,
        VehicleReviewRepository vehicleReviewRepository,
        VehicleReviewQueryService vehicleReviewQueryService
    ) {
        this.vehicleReviewService = vehicleReviewService;
        this.vehicleReviewRepository = vehicleReviewRepository;
        this.vehicleReviewQueryService = vehicleReviewQueryService;
    }

    /**
     * {@code POST  /vehicle-reviews} : Create a new vehicleReview.
     *
     * @param vehicleReviewDTO the vehicleReviewDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new vehicleReviewDTO, or with status {@code 400 (Bad Request)} if the vehicleReview has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<VehicleReviewDTO> createVehicleReview(@Valid @RequestBody VehicleReviewDTO vehicleReviewDTO)
        throws URISyntaxException {
        LOG.debug("REST request to save VehicleReview : {}", vehicleReviewDTO);
        if (vehicleReviewDTO.getId() != null) {
            throw new BadRequestAlertException("A new vehicleReview cannot already have an ID", ENTITY_NAME, "idexists");
        }
        vehicleReviewDTO = vehicleReviewService.save(vehicleReviewDTO);
        return ResponseEntity.created(new URI("/api/vehicle-reviews/" + vehicleReviewDTO.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, vehicleReviewDTO.getId().toString()))
            .body(vehicleReviewDTO);
    }

    /**
     * {@code PUT  /vehicle-reviews/:id} : Updates an existing vehicleReview.
     *
     * @param id the id of the vehicleReviewDTO to save.
     * @param vehicleReviewDTO the vehicleReviewDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated vehicleReviewDTO,
     * or with status {@code 400 (Bad Request)} if the vehicleReviewDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the vehicleReviewDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<VehicleReviewDTO> updateVehicleReview(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody VehicleReviewDTO vehicleReviewDTO
    ) throws URISyntaxException {
        LOG.debug("REST request to update VehicleReview : {}, {}", id, vehicleReviewDTO);
        if (vehicleReviewDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, vehicleReviewDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!vehicleReviewRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        vehicleReviewDTO = vehicleReviewService.update(vehicleReviewDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, vehicleReviewDTO.getId().toString()))
            .body(vehicleReviewDTO);
    }

    /**
     * {@code PATCH  /vehicle-reviews/:id} : Partial updates given fields of an existing vehicleReview, field will ignore if it is null
     *
     * @param id the id of the vehicleReviewDTO to save.
     * @param vehicleReviewDTO the vehicleReviewDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated vehicleReviewDTO,
     * or with status {@code 400 (Bad Request)} if the vehicleReviewDTO is not valid,
     * or with status {@code 404 (Not Found)} if the vehicleReviewDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the vehicleReviewDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<VehicleReviewDTO> partialUpdateVehicleReview(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody VehicleReviewDTO vehicleReviewDTO
    ) throws URISyntaxException {
        LOG.debug("REST request to partial update VehicleReview partially : {}, {}", id, vehicleReviewDTO);
        if (vehicleReviewDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, vehicleReviewDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!vehicleReviewRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<VehicleReviewDTO> result = vehicleReviewService.partialUpdate(vehicleReviewDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, vehicleReviewDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /vehicle-reviews} : get all the vehicleReviews.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of vehicleReviews in body.
     */
    @GetMapping("")
    public ResponseEntity<List<VehicleReviewDTO>> getAllVehicleReviews(VehicleReviewCriteria criteria) {
        LOG.debug("REST request to get VehicleReviews by criteria: {}", criteria);

        List<VehicleReviewDTO> entityList = vehicleReviewQueryService.findByCriteria(criteria);
        return ResponseEntity.ok().body(entityList);
    }

    /**
     * {@code GET  /vehicle-reviews/count} : count all the vehicleReviews.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/count")
    public ResponseEntity<Long> countVehicleReviews(VehicleReviewCriteria criteria) {
        LOG.debug("REST request to count VehicleReviews by criteria: {}", criteria);
        return ResponseEntity.ok().body(vehicleReviewQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /vehicle-reviews/:id} : get the "id" vehicleReview.
     *
     * @param id the id of the vehicleReviewDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the vehicleReviewDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<VehicleReviewDTO> getVehicleReview(@PathVariable("id") Long id) {
        LOG.debug("REST request to get VehicleReview : {}", id);
        Optional<VehicleReviewDTO> vehicleReviewDTO = vehicleReviewService.findOne(id);
        return ResponseUtil.wrapOrNotFound(vehicleReviewDTO);
    }

    /**
     * {@code DELETE  /vehicle-reviews/:id} : delete the "id" vehicleReview.
     *
     * @param id the id of the vehicleReviewDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicleReview(@PathVariable("id") Long id) {
        LOG.debug("REST request to delete VehicleReview : {}", id);
        vehicleReviewService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
