package com.ridehub.promotion.web.rest;

import com.ridehub.promotion.repository.PercentOffTotalRepository;
import com.ridehub.promotion.service.PercentOffTotalQueryService;
import com.ridehub.promotion.service.PercentOffTotalService;
import com.ridehub.promotion.service.criteria.PercentOffTotalCriteria;
import com.ridehub.promotion.service.dto.PercentOffTotalDTO;
import com.ridehub.promotion.web.rest.errors.BadRequestAlertException;
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
 * REST controller for managing {@link com.ridehub.promotion.domain.PercentOffTotal}.
 */
@RestController
@RequestMapping("/api/percent-off-totals")
public class PercentOffTotalResource {

    private static final Logger LOG = LoggerFactory.getLogger(PercentOffTotalResource.class);

    private static final String ENTITY_NAME = "msPromotionPercentOffTotal";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final PercentOffTotalService percentOffTotalService;

    private final PercentOffTotalRepository percentOffTotalRepository;

    private final PercentOffTotalQueryService percentOffTotalQueryService;

    public PercentOffTotalResource(
        PercentOffTotalService percentOffTotalService,
        PercentOffTotalRepository percentOffTotalRepository,
        PercentOffTotalQueryService percentOffTotalQueryService
    ) {
        this.percentOffTotalService = percentOffTotalService;
        this.percentOffTotalRepository = percentOffTotalRepository;
        this.percentOffTotalQueryService = percentOffTotalQueryService;
    }

    /**
     * {@code POST  /percent-off-totals} : Create a new percentOffTotal.
     *
     * @param percentOffTotalDTO the percentOffTotalDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new percentOffTotalDTO, or with status {@code 400 (Bad Request)} if the percentOffTotal has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<PercentOffTotalDTO> createPercentOffTotal(@Valid @RequestBody PercentOffTotalDTO percentOffTotalDTO)
        throws URISyntaxException {
        LOG.debug("REST request to save PercentOffTotal : {}", percentOffTotalDTO);
        if (percentOffTotalDTO.getId() != null) {
            throw new BadRequestAlertException("A new percentOffTotal cannot already have an ID", ENTITY_NAME, "idexists");
        }
        percentOffTotalDTO = percentOffTotalService.save(percentOffTotalDTO);
        return ResponseEntity.created(new URI("/api/percent-off-totals/" + percentOffTotalDTO.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, percentOffTotalDTO.getId().toString()))
            .body(percentOffTotalDTO);
    }

    /**
     * {@code PUT  /percent-off-totals/:id} : Updates an existing percentOffTotal.
     *
     * @param id the id of the percentOffTotalDTO to save.
     * @param percentOffTotalDTO the percentOffTotalDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated percentOffTotalDTO,
     * or with status {@code 400 (Bad Request)} if the percentOffTotalDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the percentOffTotalDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<PercentOffTotalDTO> updatePercentOffTotal(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody PercentOffTotalDTO percentOffTotalDTO
    ) throws URISyntaxException {
        LOG.debug("REST request to update PercentOffTotal : {}, {}", id, percentOffTotalDTO);
        if (percentOffTotalDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, percentOffTotalDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!percentOffTotalRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        percentOffTotalDTO = percentOffTotalService.update(percentOffTotalDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, percentOffTotalDTO.getId().toString()))
            .body(percentOffTotalDTO);
    }

    /**
     * {@code PATCH  /percent-off-totals/:id} : Partial updates given fields of an existing percentOffTotal, field will ignore if it is null
     *
     * @param id the id of the percentOffTotalDTO to save.
     * @param percentOffTotalDTO the percentOffTotalDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated percentOffTotalDTO,
     * or with status {@code 400 (Bad Request)} if the percentOffTotalDTO is not valid,
     * or with status {@code 404 (Not Found)} if the percentOffTotalDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the percentOffTotalDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<PercentOffTotalDTO> partialUpdatePercentOffTotal(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody PercentOffTotalDTO percentOffTotalDTO
    ) throws URISyntaxException {
        LOG.debug("REST request to partial update PercentOffTotal partially : {}, {}", id, percentOffTotalDTO);
        if (percentOffTotalDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, percentOffTotalDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!percentOffTotalRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<PercentOffTotalDTO> result = percentOffTotalService.partialUpdate(percentOffTotalDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, percentOffTotalDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /percent-off-totals} : get all the percentOffTotals.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of percentOffTotals in body.
     */
    @GetMapping("")
    public ResponseEntity<List<PercentOffTotalDTO>> getAllPercentOffTotals(PercentOffTotalCriteria criteria) {
        LOG.debug("REST request to get PercentOffTotals by criteria: {}", criteria);

        List<PercentOffTotalDTO> entityList = percentOffTotalQueryService.findByCriteria(criteria);
        return ResponseEntity.ok().body(entityList);
    }

    /**
     * {@code GET  /percent-off-totals/count} : count all the percentOffTotals.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/count")
    public ResponseEntity<Long> countPercentOffTotals(PercentOffTotalCriteria criteria) {
        LOG.debug("REST request to count PercentOffTotals by criteria: {}", criteria);
        return ResponseEntity.ok().body(percentOffTotalQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /percent-off-totals/:id} : get the "id" percentOffTotal.
     *
     * @param id the id of the percentOffTotalDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the percentOffTotalDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<PercentOffTotalDTO> getPercentOffTotal(@PathVariable("id") Long id) {
        LOG.debug("REST request to get PercentOffTotal : {}", id);
        Optional<PercentOffTotalDTO> percentOffTotalDTO = percentOffTotalService.findOne(id);
        return ResponseUtil.wrapOrNotFound(percentOffTotalDTO);
    }

    /**
     * {@code DELETE  /percent-off-totals/:id} : delete the "id" percentOffTotal.
     *
     * @param id the id of the percentOffTotalDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePercentOffTotal(@PathVariable("id") Long id) {
        LOG.debug("REST request to delete PercentOffTotal : {}", id);
        percentOffTotalService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
