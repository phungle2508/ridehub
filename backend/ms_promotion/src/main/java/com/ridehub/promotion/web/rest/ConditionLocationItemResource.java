package com.ridehub.promotion.web.rest;

import com.ridehub.promotion.repository.ConditionLocationItemRepository;
import com.ridehub.promotion.service.ConditionLocationItemQueryService;
import com.ridehub.promotion.service.ConditionLocationItemService;
import com.ridehub.promotion.service.criteria.ConditionLocationItemCriteria;
import com.ridehub.promotion.service.dto.ConditionLocationItemDTO;
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
 * REST controller for managing {@link com.ridehub.promotion.domain.ConditionLocationItem}.
 */
@RestController
@RequestMapping("/api/condition-location-items")
public class ConditionLocationItemResource {

    private static final Logger LOG = LoggerFactory.getLogger(ConditionLocationItemResource.class);

    private static final String ENTITY_NAME = "msPromotionConditionLocationItem";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ConditionLocationItemService conditionLocationItemService;

    private final ConditionLocationItemRepository conditionLocationItemRepository;

    private final ConditionLocationItemQueryService conditionLocationItemQueryService;

    public ConditionLocationItemResource(
        ConditionLocationItemService conditionLocationItemService,
        ConditionLocationItemRepository conditionLocationItemRepository,
        ConditionLocationItemQueryService conditionLocationItemQueryService
    ) {
        this.conditionLocationItemService = conditionLocationItemService;
        this.conditionLocationItemRepository = conditionLocationItemRepository;
        this.conditionLocationItemQueryService = conditionLocationItemQueryService;
    }

    /**
     * {@code POST  /condition-location-items} : Create a new conditionLocationItem.
     *
     * @param conditionLocationItemDTO the conditionLocationItemDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new conditionLocationItemDTO, or with status {@code 400 (Bad Request)} if the conditionLocationItem has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<ConditionLocationItemDTO> createConditionLocationItem(
        @Valid @RequestBody ConditionLocationItemDTO conditionLocationItemDTO
    ) throws URISyntaxException {
        LOG.debug("REST request to save ConditionLocationItem : {}", conditionLocationItemDTO);
        if (conditionLocationItemDTO.getId() != null) {
            throw new BadRequestAlertException("A new conditionLocationItem cannot already have an ID", ENTITY_NAME, "idexists");
        }
        conditionLocationItemDTO = conditionLocationItemService.save(conditionLocationItemDTO);
        return ResponseEntity.created(new URI("/api/condition-location-items/" + conditionLocationItemDTO.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, conditionLocationItemDTO.getId().toString()))
            .body(conditionLocationItemDTO);
    }

    /**
     * {@code PUT  /condition-location-items/:id} : Updates an existing conditionLocationItem.
     *
     * @param id the id of the conditionLocationItemDTO to save.
     * @param conditionLocationItemDTO the conditionLocationItemDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated conditionLocationItemDTO,
     * or with status {@code 400 (Bad Request)} if the conditionLocationItemDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the conditionLocationItemDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ConditionLocationItemDTO> updateConditionLocationItem(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody ConditionLocationItemDTO conditionLocationItemDTO
    ) throws URISyntaxException {
        LOG.debug("REST request to update ConditionLocationItem : {}, {}", id, conditionLocationItemDTO);
        if (conditionLocationItemDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, conditionLocationItemDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!conditionLocationItemRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        conditionLocationItemDTO = conditionLocationItemService.update(conditionLocationItemDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, conditionLocationItemDTO.getId().toString()))
            .body(conditionLocationItemDTO);
    }

    /**
     * {@code PATCH  /condition-location-items/:id} : Partial updates given fields of an existing conditionLocationItem, field will ignore if it is null
     *
     * @param id the id of the conditionLocationItemDTO to save.
     * @param conditionLocationItemDTO the conditionLocationItemDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated conditionLocationItemDTO,
     * or with status {@code 400 (Bad Request)} if the conditionLocationItemDTO is not valid,
     * or with status {@code 404 (Not Found)} if the conditionLocationItemDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the conditionLocationItemDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<ConditionLocationItemDTO> partialUpdateConditionLocationItem(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody ConditionLocationItemDTO conditionLocationItemDTO
    ) throws URISyntaxException {
        LOG.debug("REST request to partial update ConditionLocationItem partially : {}, {}", id, conditionLocationItemDTO);
        if (conditionLocationItemDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, conditionLocationItemDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!conditionLocationItemRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<ConditionLocationItemDTO> result = conditionLocationItemService.partialUpdate(conditionLocationItemDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, conditionLocationItemDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /condition-location-items} : get all the conditionLocationItems.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of conditionLocationItems in body.
     */
    @GetMapping("")
    public ResponseEntity<List<ConditionLocationItemDTO>> getAllConditionLocationItems(ConditionLocationItemCriteria criteria) {
        LOG.debug("REST request to get ConditionLocationItems by criteria: {}", criteria);

        List<ConditionLocationItemDTO> entityList = conditionLocationItemQueryService.findByCriteria(criteria);
        return ResponseEntity.ok().body(entityList);
    }

    /**
     * {@code GET  /condition-location-items/count} : count all the conditionLocationItems.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/count")
    public ResponseEntity<Long> countConditionLocationItems(ConditionLocationItemCriteria criteria) {
        LOG.debug("REST request to count ConditionLocationItems by criteria: {}", criteria);
        return ResponseEntity.ok().body(conditionLocationItemQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /condition-location-items/:id} : get the "id" conditionLocationItem.
     *
     * @param id the id of the conditionLocationItemDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the conditionLocationItemDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ConditionLocationItemDTO> getConditionLocationItem(@PathVariable("id") Long id) {
        LOG.debug("REST request to get ConditionLocationItem : {}", id);
        Optional<ConditionLocationItemDTO> conditionLocationItemDTO = conditionLocationItemService.findOne(id);
        return ResponseUtil.wrapOrNotFound(conditionLocationItemDTO);
    }

    /**
     * {@code DELETE  /condition-location-items/:id} : delete the "id" conditionLocationItem.
     *
     * @param id the id of the conditionLocationItemDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConditionLocationItem(@PathVariable("id") Long id) {
        LOG.debug("REST request to delete ConditionLocationItem : {}", id);
        conditionLocationItemService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
