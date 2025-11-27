package com.ridehub.promotion.web.rest;

import com.ridehub.promotion.repository.ConditionByLocationRepository;
import com.ridehub.promotion.service.ConditionByLocationQueryService;
import com.ridehub.promotion.service.ConditionByLocationService;
import com.ridehub.promotion.service.criteria.ConditionByLocationCriteria;
import com.ridehub.promotion.service.dto.ConditionByLocationDTO;
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
 * REST controller for managing {@link com.ridehub.promotion.domain.ConditionByLocation}.
 */
@RestController
@RequestMapping("/api/condition-by-locations")
public class ConditionByLocationResource {

    private static final Logger LOG = LoggerFactory.getLogger(ConditionByLocationResource.class);

    private static final String ENTITY_NAME = "msPromotionConditionByLocation";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ConditionByLocationService conditionByLocationService;

    private final ConditionByLocationRepository conditionByLocationRepository;

    private final ConditionByLocationQueryService conditionByLocationQueryService;

    public ConditionByLocationResource(
        ConditionByLocationService conditionByLocationService,
        ConditionByLocationRepository conditionByLocationRepository,
        ConditionByLocationQueryService conditionByLocationQueryService
    ) {
        this.conditionByLocationService = conditionByLocationService;
        this.conditionByLocationRepository = conditionByLocationRepository;
        this.conditionByLocationQueryService = conditionByLocationQueryService;
    }

    /**
     * {@code POST  /condition-by-locations} : Create a new conditionByLocation.
     *
     * @param conditionByLocationDTO the conditionByLocationDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new conditionByLocationDTO, or with status {@code 400 (Bad Request)} if the conditionByLocation has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<ConditionByLocationDTO> createConditionByLocation(
        @Valid @RequestBody ConditionByLocationDTO conditionByLocationDTO
    ) throws URISyntaxException {
        LOG.debug("REST request to save ConditionByLocation : {}", conditionByLocationDTO);
        if (conditionByLocationDTO.getId() != null) {
            throw new BadRequestAlertException("A new conditionByLocation cannot already have an ID", ENTITY_NAME, "idexists");
        }
        conditionByLocationDTO = conditionByLocationService.save(conditionByLocationDTO);
        return ResponseEntity.created(new URI("/api/condition-by-locations/" + conditionByLocationDTO.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, conditionByLocationDTO.getId().toString()))
            .body(conditionByLocationDTO);
    }

    /**
     * {@code PUT  /condition-by-locations/:id} : Updates an existing conditionByLocation.
     *
     * @param id the id of the conditionByLocationDTO to save.
     * @param conditionByLocationDTO the conditionByLocationDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated conditionByLocationDTO,
     * or with status {@code 400 (Bad Request)} if the conditionByLocationDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the conditionByLocationDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ConditionByLocationDTO> updateConditionByLocation(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody ConditionByLocationDTO conditionByLocationDTO
    ) throws URISyntaxException {
        LOG.debug("REST request to update ConditionByLocation : {}, {}", id, conditionByLocationDTO);
        if (conditionByLocationDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, conditionByLocationDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!conditionByLocationRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        conditionByLocationDTO = conditionByLocationService.update(conditionByLocationDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, conditionByLocationDTO.getId().toString()))
            .body(conditionByLocationDTO);
    }

    /**
     * {@code PATCH  /condition-by-locations/:id} : Partial updates given fields of an existing conditionByLocation, field will ignore if it is null
     *
     * @param id the id of the conditionByLocationDTO to save.
     * @param conditionByLocationDTO the conditionByLocationDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated conditionByLocationDTO,
     * or with status {@code 400 (Bad Request)} if the conditionByLocationDTO is not valid,
     * or with status {@code 404 (Not Found)} if the conditionByLocationDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the conditionByLocationDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<ConditionByLocationDTO> partialUpdateConditionByLocation(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody ConditionByLocationDTO conditionByLocationDTO
    ) throws URISyntaxException {
        LOG.debug("REST request to partial update ConditionByLocation partially : {}, {}", id, conditionByLocationDTO);
        if (conditionByLocationDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, conditionByLocationDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!conditionByLocationRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<ConditionByLocationDTO> result = conditionByLocationService.partialUpdate(conditionByLocationDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, conditionByLocationDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /condition-by-locations} : get all the conditionByLocations.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of conditionByLocations in body.
     */
    @GetMapping("")
    public ResponseEntity<List<ConditionByLocationDTO>> getAllConditionByLocations(ConditionByLocationCriteria criteria) {
        LOG.debug("REST request to get ConditionByLocations by criteria: {}", criteria);

        List<ConditionByLocationDTO> entityList = conditionByLocationQueryService.findByCriteria(criteria);
        return ResponseEntity.ok().body(entityList);
    }

    /**
     * {@code GET  /condition-by-locations/count} : count all the conditionByLocations.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/count")
    public ResponseEntity<Long> countConditionByLocations(ConditionByLocationCriteria criteria) {
        LOG.debug("REST request to count ConditionByLocations by criteria: {}", criteria);
        return ResponseEntity.ok().body(conditionByLocationQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /condition-by-locations/:id} : get the "id" conditionByLocation.
     *
     * @param id the id of the conditionByLocationDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the conditionByLocationDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ConditionByLocationDTO> getConditionByLocation(@PathVariable("id") Long id) {
        LOG.debug("REST request to get ConditionByLocation : {}", id);
        Optional<ConditionByLocationDTO> conditionByLocationDTO = conditionByLocationService.findOne(id);
        return ResponseUtil.wrapOrNotFound(conditionByLocationDTO);
    }

    /**
     * {@code DELETE  /condition-by-locations/:id} : delete the "id" conditionByLocation.
     *
     * @param id the id of the conditionByLocationDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConditionByLocation(@PathVariable("id") Long id) {
        LOG.debug("REST request to delete ConditionByLocation : {}", id);
        conditionByLocationService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
