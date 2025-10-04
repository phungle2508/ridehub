package com.ridehub.promotion.web.rest;

import com.ridehub.promotion.repository.ConditionDateItemRepository;
import com.ridehub.promotion.service.ConditionDateItemQueryService;
import com.ridehub.promotion.service.ConditionDateItemService;
import com.ridehub.promotion.service.criteria.ConditionDateItemCriteria;
import com.ridehub.promotion.service.dto.ConditionDateItemDTO;
import com.ridehub.promotion.service.dto.ConditionLocationItemDTO;
import com.ridehub.promotion.web.rest.errors.BadRequestAlertException;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
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
 * REST controller for managing
 * {@link com.ridehub.promotion.domain.ConditionDateItem}.
 */
@RestController
@RequestMapping("/api/condition-date-items")
public class ConditionDateItemResource {

    private static final Logger LOG = LoggerFactory.getLogger(ConditionDateItemResource.class);

    private static final String ENTITY_NAME = "msPromotionConditionDateItem";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ConditionDateItemService conditionDateItemService;

    private final ConditionDateItemRepository conditionDateItemRepository;

    private final ConditionDateItemQueryService conditionDateItemQueryService;

    public ConditionDateItemResource(
            ConditionDateItemService conditionDateItemService,
            ConditionDateItemRepository conditionDateItemRepository,
            ConditionDateItemQueryService conditionDateItemQueryService) {
        this.conditionDateItemService = conditionDateItemService;
        this.conditionDateItemRepository = conditionDateItemRepository;
        this.conditionDateItemQueryService = conditionDateItemQueryService;
    }

    /**
     * {@code POST  /condition-date-items} : Create a new conditionDateItem.
     *
     * @param conditionDateItemDTO the conditionDateItemDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with
     *         body the new conditionDateItemDTO, or with status
     *         {@code 400 (Bad Request)} if the conditionDateItem has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<ConditionDateItemDTO> createConditionDateItem(
            @Valid @RequestBody ConditionDateItemDTO conditionDateItemDTO)
            throws URISyntaxException {
        LOG.debug("REST request to save ConditionDateItem : {}", conditionDateItemDTO);
        if (conditionDateItemDTO.getId() != null) {
            throw new BadRequestAlertException("A new conditionDateItem cannot already have an ID", ENTITY_NAME,
                    "idexists");
        }
        conditionDateItemDTO = conditionDateItemService.save(conditionDateItemDTO);
        return ResponseEntity.created(new URI("/api/condition-date-items/" + conditionDateItemDTO.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME,
                        conditionDateItemDTO.getId().toString()))
                .body(conditionDateItemDTO);
    }

    /**
     * {@code PUT  /condition-date-items/:id} : Updates an existing
     * conditionDateItem.
     *
     * @param id                   the id of the conditionDateItemDTO to save.
     * @param conditionDateItemDTO the conditionDateItemDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
     *         the updated conditionDateItemDTO,
     *         or with status {@code 400 (Bad Request)} if the conditionDateItemDTO
     *         is not valid,
     *         or with status {@code 500 (Internal Server Error)} if the
     *         conditionDateItemDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(mediaType = "application/json", schema = @Schema(implementation = ConditionLocationItemDTO.class), examples = @ExampleObject(name = "Update BuyNGetMFree Policy", description = "id must match the path parameter. Leave promotion as an empty object; the server populates it from the URL path. System fields (createdAt, updatedAt, isDeleted, deletedAt, deletedBy) are managed by the system and should not be sent.", value = """
            {
                  "id": 1,
                  "createdAt": "2025-10-04T09:34:29.432Z",
                  "updatedAt": "2025-10-04T09:34:29.432Z",
                  "isDeleted": true,
                  "deletedAt": "2025-10-04T09:34:29.432Z",
                  "deletedBy": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
                  "condition": {"id": 0}
                }
                      """)))
    public ResponseEntity<ConditionDateItemDTO> updateConditionDateItem(
            @PathVariable(value = "id", required = false) final Long id,
            @Valid @RequestBody ConditionDateItemDTO conditionDateItemDTO) throws URISyntaxException {
        LOG.debug("REST request to update ConditionDateItem : {}, {}", id, conditionDateItemDTO);
        if (conditionDateItemDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, conditionDateItemDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!conditionDateItemRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        conditionDateItemDTO = conditionDateItemService.update(conditionDateItemDTO);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME,
                        conditionDateItemDTO.getId().toString()))
                .body(conditionDateItemDTO);
    }

    /**
     * {@code PATCH  /condition-date-items/:id} : Partial updates given fields of an
     * existing conditionDateItem, field will ignore if it is null
     *
     * @param id                   the id of the conditionDateItemDTO to save.
     * @param conditionDateItemDTO the conditionDateItemDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
     *         the updated conditionDateItemDTO,
     *         or with status {@code 400 (Bad Request)} if the conditionDateItemDTO
     *         is not valid,
     *         or with status {@code 404 (Not Found)} if the conditionDateItemDTO is
     *         not found,
     *         or with status {@code 500 (Internal Server Error)} if the
     *         conditionDateItemDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<ConditionDateItemDTO> partialUpdateConditionDateItem(
            @PathVariable(value = "id", required = false) final Long id,
            @NotNull @RequestBody ConditionDateItemDTO conditionDateItemDTO) throws URISyntaxException {
        LOG.debug("REST request to partial update ConditionDateItem partially : {}, {}", id, conditionDateItemDTO);
        if (conditionDateItemDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, conditionDateItemDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!conditionDateItemRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<ConditionDateItemDTO> result = conditionDateItemService.partialUpdate(conditionDateItemDTO);

        return ResponseUtil.wrapOrNotFound(
                result,
                HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME,
                        conditionDateItemDTO.getId().toString()));
    }

    /**
     * {@code GET  /condition-date-items} : get all the conditionDateItems.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list
     *         of conditionDateItems in body.
     */
    @GetMapping("")
    public ResponseEntity<List<ConditionDateItemDTO>> getAllConditionDateItems(ConditionDateItemCriteria criteria) {
        LOG.debug("REST request to get ConditionDateItems by criteria: {}", criteria);

        List<ConditionDateItemDTO> entityList = conditionDateItemQueryService.findByCriteria(criteria);
        return ResponseEntity.ok().body(entityList);
    }

    /**
     * {@code GET  /condition-date-items/count} : count all the conditionDateItems.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count
     *         in body.
     */
    @GetMapping("/count")
    public ResponseEntity<Long> countConditionDateItems(ConditionDateItemCriteria criteria) {
        LOG.debug("REST request to count ConditionDateItems by criteria: {}", criteria);
        return ResponseEntity.ok().body(conditionDateItemQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /condition-date-items/:id} : get the "id" conditionDateItem.
     *
     * @param id the id of the conditionDateItemDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
     *         the conditionDateItemDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ConditionDateItemDTO> getConditionDateItem(@PathVariable("id") Long id) {
        LOG.debug("REST request to get ConditionDateItem : {}", id);
        Optional<ConditionDateItemDTO> conditionDateItemDTO = conditionDateItemService.findOne(id);
        return ResponseUtil.wrapOrNotFound(conditionDateItemDTO);
    }

    /**
     * {@code DELETE  /condition-date-items/:id} : delete the "id"
     * conditionDateItem.
     *
     * @param id the id of the conditionDateItemDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConditionDateItem(@PathVariable("id") Long id) {
        LOG.debug("REST request to delete ConditionDateItem : {}", id);
        conditionDateItemService.delete(id);
        return ResponseEntity.noContent()
                .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
                .build();
    }
}
