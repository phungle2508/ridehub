package com.ridehub.promotion.web.rest;

import com.ridehub.promotion.repository.ConditionByRouteRepository;
import com.ridehub.promotion.service.ConditionByRouteQueryService;
import com.ridehub.promotion.service.ConditionByRouteService;
import com.ridehub.promotion.service.criteria.ConditionByRouteCriteria;
import com.ridehub.promotion.service.dto.ConditionByRouteDTO;
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
 * REST controller for managing {@link com.ridehub.promotion.domain.ConditionByRoute}.
 */
@RestController
@RequestMapping("/api/condition-by-routes")
public class ConditionByRouteResource {

    private static final Logger LOG = LoggerFactory.getLogger(ConditionByRouteResource.class);

    private static final String ENTITY_NAME = "msPromotionConditionByRoute";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ConditionByRouteService conditionByRouteService;

    private final ConditionByRouteRepository conditionByRouteRepository;

    private final ConditionByRouteQueryService conditionByRouteQueryService;

    public ConditionByRouteResource(
        ConditionByRouteService conditionByRouteService,
        ConditionByRouteRepository conditionByRouteRepository,
        ConditionByRouteQueryService conditionByRouteQueryService
    ) {
        this.conditionByRouteService = conditionByRouteService;
        this.conditionByRouteRepository = conditionByRouteRepository;
        this.conditionByRouteQueryService = conditionByRouteQueryService;
    }

    /**
     * {@code POST  /condition-by-routes} : Create a new conditionByRoute.
     *
     * @param conditionByRouteDTO the conditionByRouteDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new conditionByRouteDTO, or with status {@code 400 (Bad Request)} if the conditionByRoute has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<ConditionByRouteDTO> createConditionByRoute(@Valid @RequestBody ConditionByRouteDTO conditionByRouteDTO)
        throws URISyntaxException {
        LOG.debug("REST request to save ConditionByRoute : {}", conditionByRouteDTO);
        if (conditionByRouteDTO.getId() != null) {
            throw new BadRequestAlertException("A new conditionByRoute cannot already have an ID", ENTITY_NAME, "idexists");
        }
        conditionByRouteDTO = conditionByRouteService.save(conditionByRouteDTO);
        return ResponseEntity.created(new URI("/api/condition-by-routes/" + conditionByRouteDTO.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, conditionByRouteDTO.getId().toString()))
            .body(conditionByRouteDTO);
    }

    /**
     * {@code PUT  /condition-by-routes/:id} : Updates an existing conditionByRoute.
     *
     * @param id the id of the conditionByRouteDTO to save.
     * @param conditionByRouteDTO the conditionByRouteDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated conditionByRouteDTO,
     * or with status {@code 400 (Bad Request)} if the conditionByRouteDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the conditionByRouteDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ConditionByRouteDTO> updateConditionByRoute(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody ConditionByRouteDTO conditionByRouteDTO
    ) throws URISyntaxException {
        LOG.debug("REST request to update ConditionByRoute : {}, {}", id, conditionByRouteDTO);
        if (conditionByRouteDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, conditionByRouteDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!conditionByRouteRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        conditionByRouteDTO = conditionByRouteService.update(conditionByRouteDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, conditionByRouteDTO.getId().toString()))
            .body(conditionByRouteDTO);
    }

    /**
     * {@code PATCH  /condition-by-routes/:id} : Partial updates given fields of an existing conditionByRoute, field will ignore if it is null
     *
     * @param id the id of the conditionByRouteDTO to save.
     * @param conditionByRouteDTO the conditionByRouteDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated conditionByRouteDTO,
     * or with status {@code 400 (Bad Request)} if the conditionByRouteDTO is not valid,
     * or with status {@code 404 (Not Found)} if the conditionByRouteDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the conditionByRouteDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<ConditionByRouteDTO> partialUpdateConditionByRoute(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody ConditionByRouteDTO conditionByRouteDTO
    ) throws URISyntaxException {
        LOG.debug("REST request to partial update ConditionByRoute partially : {}, {}", id, conditionByRouteDTO);
        if (conditionByRouteDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, conditionByRouteDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!conditionByRouteRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<ConditionByRouteDTO> result = conditionByRouteService.partialUpdate(conditionByRouteDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, conditionByRouteDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /condition-by-routes} : get all the conditionByRoutes.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of conditionByRoutes in body.
     */
    @GetMapping("")
    public ResponseEntity<List<ConditionByRouteDTO>> getAllConditionByRoutes(ConditionByRouteCriteria criteria) {
        LOG.debug("REST request to get ConditionByRoutes by criteria: {}", criteria);

        List<ConditionByRouteDTO> entityList = conditionByRouteQueryService.findByCriteria(criteria);
        return ResponseEntity.ok().body(entityList);
    }

    /**
     * {@code GET  /condition-by-routes/count} : count all the conditionByRoutes.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/count")
    public ResponseEntity<Long> countConditionByRoutes(ConditionByRouteCriteria criteria) {
        LOG.debug("REST request to count ConditionByRoutes by criteria: {}", criteria);
        return ResponseEntity.ok().body(conditionByRouteQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /condition-by-routes/:id} : get the "id" conditionByRoute.
     *
     * @param id the id of the conditionByRouteDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the conditionByRouteDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ConditionByRouteDTO> getConditionByRoute(@PathVariable("id") Long id) {
        LOG.debug("REST request to get ConditionByRoute : {}", id);
        Optional<ConditionByRouteDTO> conditionByRouteDTO = conditionByRouteService.findOne(id);
        return ResponseUtil.wrapOrNotFound(conditionByRouteDTO);
    }

    /**
     * {@code DELETE  /condition-by-routes/:id} : delete the "id" conditionByRoute.
     *
     * @param id the id of the conditionByRouteDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConditionByRoute(@PathVariable("id") Long id) {
        LOG.debug("REST request to delete ConditionByRoute : {}", id);
        conditionByRouteService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
