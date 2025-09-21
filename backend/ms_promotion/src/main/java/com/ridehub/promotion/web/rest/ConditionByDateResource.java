package com.ridehub.promotion.web.rest;

import com.ridehub.promotion.repository.ConditionByDateRepository;
import com.ridehub.promotion.service.ConditionByDateQueryService;
import com.ridehub.promotion.service.ConditionByDateService;
import com.ridehub.promotion.service.criteria.ConditionByDateCriteria;
import com.ridehub.promotion.service.dto.ConditionByDateDTO;
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
 * REST controller for managing {@link com.ridehub.promotion.domain.ConditionByDate}.
 */
@RestController
@RequestMapping("/api/condition-by-dates")
public class ConditionByDateResource {

    private static final Logger LOG = LoggerFactory.getLogger(ConditionByDateResource.class);

    private static final String ENTITY_NAME = "msPromotionConditionByDate";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ConditionByDateService conditionByDateService;

    private final ConditionByDateRepository conditionByDateRepository;

    private final ConditionByDateQueryService conditionByDateQueryService;

    public ConditionByDateResource(
        ConditionByDateService conditionByDateService,
        ConditionByDateRepository conditionByDateRepository,
        ConditionByDateQueryService conditionByDateQueryService
    ) {
        this.conditionByDateService = conditionByDateService;
        this.conditionByDateRepository = conditionByDateRepository;
        this.conditionByDateQueryService = conditionByDateQueryService;
    }

    /**
     * {@code POST  /condition-by-dates} : Create a new conditionByDate.
     *
     * @param conditionByDateDTO the conditionByDateDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new conditionByDateDTO, or with status {@code 400 (Bad Request)} if the conditionByDate has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<ConditionByDateDTO> createConditionByDate(@Valid @RequestBody ConditionByDateDTO conditionByDateDTO)
        throws URISyntaxException {
        LOG.debug("REST request to save ConditionByDate : {}", conditionByDateDTO);
        if (conditionByDateDTO.getId() != null) {
            throw new BadRequestAlertException("A new conditionByDate cannot already have an ID", ENTITY_NAME, "idexists");
        }
        conditionByDateDTO = conditionByDateService.save(conditionByDateDTO);
        return ResponseEntity.created(new URI("/api/condition-by-dates/" + conditionByDateDTO.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, conditionByDateDTO.getId().toString()))
            .body(conditionByDateDTO);
    }

    /**
     * {@code PUT  /condition-by-dates/:id} : Updates an existing conditionByDate.
     *
     * @param id the id of the conditionByDateDTO to save.
     * @param conditionByDateDTO the conditionByDateDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated conditionByDateDTO,
     * or with status {@code 400 (Bad Request)} if the conditionByDateDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the conditionByDateDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ConditionByDateDTO> updateConditionByDate(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody ConditionByDateDTO conditionByDateDTO
    ) throws URISyntaxException {
        LOG.debug("REST request to update ConditionByDate : {}, {}", id, conditionByDateDTO);
        if (conditionByDateDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, conditionByDateDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!conditionByDateRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        conditionByDateDTO = conditionByDateService.update(conditionByDateDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, conditionByDateDTO.getId().toString()))
            .body(conditionByDateDTO);
    }

    /**
     * {@code PATCH  /condition-by-dates/:id} : Partial updates given fields of an existing conditionByDate, field will ignore if it is null
     *
     * @param id the id of the conditionByDateDTO to save.
     * @param conditionByDateDTO the conditionByDateDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated conditionByDateDTO,
     * or with status {@code 400 (Bad Request)} if the conditionByDateDTO is not valid,
     * or with status {@code 404 (Not Found)} if the conditionByDateDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the conditionByDateDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<ConditionByDateDTO> partialUpdateConditionByDate(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody ConditionByDateDTO conditionByDateDTO
    ) throws URISyntaxException {
        LOG.debug("REST request to partial update ConditionByDate partially : {}, {}", id, conditionByDateDTO);
        if (conditionByDateDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, conditionByDateDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!conditionByDateRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<ConditionByDateDTO> result = conditionByDateService.partialUpdate(conditionByDateDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, conditionByDateDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /condition-by-dates} : get all the conditionByDates.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of conditionByDates in body.
     */
    @GetMapping("")
    public ResponseEntity<List<ConditionByDateDTO>> getAllConditionByDates(ConditionByDateCriteria criteria) {
        LOG.debug("REST request to get ConditionByDates by criteria: {}", criteria);

        List<ConditionByDateDTO> entityList = conditionByDateQueryService.findByCriteria(criteria);
        return ResponseEntity.ok().body(entityList);
    }

    /**
     * {@code GET  /condition-by-dates/count} : count all the conditionByDates.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/count")
    public ResponseEntity<Long> countConditionByDates(ConditionByDateCriteria criteria) {
        LOG.debug("REST request to count ConditionByDates by criteria: {}", criteria);
        return ResponseEntity.ok().body(conditionByDateQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /condition-by-dates/:id} : get the "id" conditionByDate.
     *
     * @param id the id of the conditionByDateDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the conditionByDateDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ConditionByDateDTO> getConditionByDate(@PathVariable("id") Long id) {
        LOG.debug("REST request to get ConditionByDate : {}", id);
        Optional<ConditionByDateDTO> conditionByDateDTO = conditionByDateService.findOne(id);
        return ResponseUtil.wrapOrNotFound(conditionByDateDTO);
    }

    /**
     * {@code DELETE  /condition-by-dates/:id} : delete the "id" conditionByDate.
     *
     * @param id the id of the conditionByDateDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConditionByDate(@PathVariable("id") Long id) {
        LOG.debug("REST request to delete ConditionByDate : {}", id);
        conditionByDateService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
