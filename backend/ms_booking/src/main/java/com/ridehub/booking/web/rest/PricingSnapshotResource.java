package com.ridehub.booking.web.rest;

import com.ridehub.booking.repository.PricingSnapshotRepository;
import com.ridehub.booking.service.PricingSnapshotQueryService;
import com.ridehub.booking.service.PricingSnapshotService;
import com.ridehub.booking.service.criteria.PricingSnapshotCriteria;
import com.ridehub.booking.service.dto.PricingSnapshotDTO;
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
 * REST controller for managing {@link com.ridehub.booking.domain.PricingSnapshot}.
 */
@RestController
@RequestMapping("/api/pricing-snapshots")
public class PricingSnapshotResource {

    private static final Logger LOG = LoggerFactory.getLogger(PricingSnapshotResource.class);

    private static final String ENTITY_NAME = "msBookingPricingSnapshot";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final PricingSnapshotService pricingSnapshotService;

    private final PricingSnapshotRepository pricingSnapshotRepository;

    private final PricingSnapshotQueryService pricingSnapshotQueryService;

    public PricingSnapshotResource(
        PricingSnapshotService pricingSnapshotService,
        PricingSnapshotRepository pricingSnapshotRepository,
        PricingSnapshotQueryService pricingSnapshotQueryService
    ) {
        this.pricingSnapshotService = pricingSnapshotService;
        this.pricingSnapshotRepository = pricingSnapshotRepository;
        this.pricingSnapshotQueryService = pricingSnapshotQueryService;
    }

    /**
     * {@code POST  /pricing-snapshots} : Create a new pricingSnapshot.
     *
     * @param pricingSnapshotDTO the pricingSnapshotDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new pricingSnapshotDTO, or with status {@code 400 (Bad Request)} if the pricingSnapshot has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<PricingSnapshotDTO> createPricingSnapshot(@Valid @RequestBody PricingSnapshotDTO pricingSnapshotDTO)
        throws URISyntaxException {
        LOG.debug("REST request to save PricingSnapshot : {}", pricingSnapshotDTO);
        if (pricingSnapshotDTO.getId() != null) {
            throw new BadRequestAlertException("A new pricingSnapshot cannot already have an ID", ENTITY_NAME, "idexists");
        }
        pricingSnapshotDTO = pricingSnapshotService.save(pricingSnapshotDTO);
        return ResponseEntity.created(new URI("/api/pricing-snapshots/" + pricingSnapshotDTO.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, pricingSnapshotDTO.getId().toString()))
            .body(pricingSnapshotDTO);
    }

    /**
     * {@code PUT  /pricing-snapshots/:id} : Updates an existing pricingSnapshot.
     *
     * @param id the id of the pricingSnapshotDTO to save.
     * @param pricingSnapshotDTO the pricingSnapshotDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated pricingSnapshotDTO,
     * or with status {@code 400 (Bad Request)} if the pricingSnapshotDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the pricingSnapshotDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<PricingSnapshotDTO> updatePricingSnapshot(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody PricingSnapshotDTO pricingSnapshotDTO
    ) throws URISyntaxException {
        LOG.debug("REST request to update PricingSnapshot : {}, {}", id, pricingSnapshotDTO);
        if (pricingSnapshotDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, pricingSnapshotDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!pricingSnapshotRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        pricingSnapshotDTO = pricingSnapshotService.update(pricingSnapshotDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, pricingSnapshotDTO.getId().toString()))
            .body(pricingSnapshotDTO);
    }

    /**
     * {@code PATCH  /pricing-snapshots/:id} : Partial updates given fields of an existing pricingSnapshot, field will ignore if it is null
     *
     * @param id the id of the pricingSnapshotDTO to save.
     * @param pricingSnapshotDTO the pricingSnapshotDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated pricingSnapshotDTO,
     * or with status {@code 400 (Bad Request)} if the pricingSnapshotDTO is not valid,
     * or with status {@code 404 (Not Found)} if the pricingSnapshotDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the pricingSnapshotDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<PricingSnapshotDTO> partialUpdatePricingSnapshot(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody PricingSnapshotDTO pricingSnapshotDTO
    ) throws URISyntaxException {
        LOG.debug("REST request to partial update PricingSnapshot partially : {}, {}", id, pricingSnapshotDTO);
        if (pricingSnapshotDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, pricingSnapshotDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!pricingSnapshotRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<PricingSnapshotDTO> result = pricingSnapshotService.partialUpdate(pricingSnapshotDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, pricingSnapshotDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /pricing-snapshots} : get all the pricingSnapshots.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of pricingSnapshots in body.
     */
    @GetMapping("")
    public ResponseEntity<List<PricingSnapshotDTO>> getAllPricingSnapshots(PricingSnapshotCriteria criteria) {
        LOG.debug("REST request to get PricingSnapshots by criteria: {}", criteria);

        List<PricingSnapshotDTO> entityList = pricingSnapshotQueryService.findByCriteria(criteria);
        return ResponseEntity.ok().body(entityList);
    }

    /**
     * {@code GET  /pricing-snapshots/count} : count all the pricingSnapshots.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/count")
    public ResponseEntity<Long> countPricingSnapshots(PricingSnapshotCriteria criteria) {
        LOG.debug("REST request to count PricingSnapshots by criteria: {}", criteria);
        return ResponseEntity.ok().body(pricingSnapshotQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /pricing-snapshots/:id} : get the "id" pricingSnapshot.
     *
     * @param id the id of the pricingSnapshotDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the pricingSnapshotDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<PricingSnapshotDTO> getPricingSnapshot(@PathVariable("id") Long id) {
        LOG.debug("REST request to get PricingSnapshot : {}", id);
        Optional<PricingSnapshotDTO> pricingSnapshotDTO = pricingSnapshotService.findOne(id);
        return ResponseUtil.wrapOrNotFound(pricingSnapshotDTO);
    }

    /**
     * {@code DELETE  /pricing-snapshots/:id} : delete the "id" pricingSnapshot.
     *
     * @param id the id of the pricingSnapshotDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePricingSnapshot(@PathVariable("id") Long id) {
        LOG.debug("REST request to delete PricingSnapshot : {}", id);
        pricingSnapshotService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
