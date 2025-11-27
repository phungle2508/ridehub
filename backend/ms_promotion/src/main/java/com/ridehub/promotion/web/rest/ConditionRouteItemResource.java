package com.ridehub.promotion.web.rest;

import com.ridehub.promotion.repository.ConditionRouteItemRepository;
import com.ridehub.promotion.service.ConditionRouteItemQueryService;
import com.ridehub.promotion.service.ConditionRouteItemService;
import com.ridehub.promotion.service.criteria.ConditionRouteItemCriteria;
import com.ridehub.promotion.service.dto.ConditionRouteItemDTO;
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
 * {@link com.ridehub.promotion.domain.ConditionRouteItem}.
 */
@RestController
@RequestMapping("/api/condition-route-items")
public class ConditionRouteItemResource {

    private static final Logger LOG = LoggerFactory.getLogger(ConditionRouteItemResource.class);

    private static final String ENTITY_NAME = "msPromotionConditionRouteItem";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ConditionRouteItemService conditionRouteItemService;

    private final ConditionRouteItemRepository conditionRouteItemRepository;

    private final ConditionRouteItemQueryService conditionRouteItemQueryService;

    public ConditionRouteItemResource(
            ConditionRouteItemService conditionRouteItemService,
            ConditionRouteItemRepository conditionRouteItemRepository,
            ConditionRouteItemQueryService conditionRouteItemQueryService) {
        this.conditionRouteItemService = conditionRouteItemService;
        this.conditionRouteItemRepository = conditionRouteItemRepository;
        this.conditionRouteItemQueryService = conditionRouteItemQueryService;
    }

    /**
     * {@code POST  /condition-route-items} : Create a new conditionRouteItem.
     *
     * @param conditionRouteItemDTO the conditionRouteItemDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with
     *         body the new conditionRouteItemDTO, or with status
     *         {@code 400 (Bad Request)} if the conditionRouteItem has already an
     *         ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<ConditionRouteItemDTO> createConditionRouteItem(
            @Valid @RequestBody ConditionRouteItemDTO conditionRouteItemDTO)
            throws URISyntaxException {
        LOG.debug("REST request to save ConditionRouteItem : {}", conditionRouteItemDTO);
        if (conditionRouteItemDTO.getId() != null) {
            throw new BadRequestAlertException("A new conditionRouteItem cannot already have an ID", ENTITY_NAME,
                    "idexists");
        }
        conditionRouteItemDTO = conditionRouteItemService.save(conditionRouteItemDTO);
        return ResponseEntity.created(new URI("/api/condition-route-items/" + conditionRouteItemDTO.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME,
                        conditionRouteItemDTO.getId().toString()))
                .body(conditionRouteItemDTO);
    }

    /**
     * {@code PUT  /condition-route-items/:id} : Updates an existing
     * conditionRouteItem.
     *
     * @param id                    the id of the conditionRouteItemDTO to save.
     * @param conditionRouteItemDTO the conditionRouteItemDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
     *         the updated conditionRouteItemDTO,
     *         or with status {@code 400 (Bad Request)} if the conditionRouteItemDTO
     *         is not valid,
     *         or with status {@code 500 (Internal Server Error)} if the
     *         conditionRouteItemDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(mediaType = "application/json", schema = @Schema(implementation = ConditionRouteItemDTO.class), examples = @ExampleObject(name = "Update BuyNGetMFree Policy", description = "id must match the path parameter. Leave promotion as an empty object; the server populates it from the URL path. System fields (createdAt, updatedAt, isDeleted, deletedAt, deletedBy) are managed by the system and should not be sent.", value = """
            {
                 "id": 0,
                 "routeId": 0,
                 "createdAt": "2025-10-04T09:33:20.375Z",
                 "updatedAt": "2025-10-04T09:33:20.375Z",
                 "isDeleted": true,
                 "deletedAt": "2025-10-04T09:33:20.375Z",
                 "deletedBy": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
                 "condition": {"id": 0}
               }
               """)))
    public ResponseEntity<ConditionRouteItemDTO> updateConditionRouteItem(
            @PathVariable(value = "id", required = false) final Long id,
            @Valid @RequestBody ConditionRouteItemDTO conditionRouteItemDTO) throws URISyntaxException {
        LOG.debug("REST request to update ConditionRouteItem : {}, {}", id, conditionRouteItemDTO);
        if (conditionRouteItemDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, conditionRouteItemDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!conditionRouteItemRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        conditionRouteItemDTO = conditionRouteItemService.update(conditionRouteItemDTO);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME,
                        conditionRouteItemDTO.getId().toString()))
                .body(conditionRouteItemDTO);
    }

    /**
     * {@code PATCH  /condition-route-items/:id} : Partial updates given fields of
     * an existing conditionRouteItem, field will ignore if it is null
     *
     * @param id                    the id of the conditionRouteItemDTO to save.
     * @param conditionRouteItemDTO the conditionRouteItemDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
     *         the updated conditionRouteItemDTO,
     *         or with status {@code 400 (Bad Request)} if the conditionRouteItemDTO
     *         is not valid,
     *         or with status {@code 404 (Not Found)} if the conditionRouteItemDTO
     *         is not found,
     *         or with status {@code 500 (Internal Server Error)} if the
     *         conditionRouteItemDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<ConditionRouteItemDTO> partialUpdateConditionRouteItem(
            @PathVariable(value = "id", required = false) final Long id,
            @NotNull @RequestBody ConditionRouteItemDTO conditionRouteItemDTO) throws URISyntaxException {
        LOG.debug("REST request to partial update ConditionRouteItem partially : {}, {}", id, conditionRouteItemDTO);
        if (conditionRouteItemDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, conditionRouteItemDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!conditionRouteItemRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<ConditionRouteItemDTO> result = conditionRouteItemService.partialUpdate(conditionRouteItemDTO);

        return ResponseUtil.wrapOrNotFound(
                result,
                HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME,
                        conditionRouteItemDTO.getId().toString()));
    }

    /**
     * {@code GET  /condition-route-items} : get all the conditionRouteItems.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list
     *         of conditionRouteItems in body.
     */
    @GetMapping("")
    public ResponseEntity<List<ConditionRouteItemDTO>> getAllConditionRouteItems(ConditionRouteItemCriteria criteria) {
        LOG.debug("REST request to get ConditionRouteItems by criteria: {}", criteria);

        List<ConditionRouteItemDTO> entityList = conditionRouteItemQueryService.findByCriteria(criteria);
        return ResponseEntity.ok().body(entityList);
    }

    /**
     * {@code GET  /condition-route-items/count} : count all the
     * conditionRouteItems.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count
     *         in body.
     */
    @GetMapping("/count")
    public ResponseEntity<Long> countConditionRouteItems(ConditionRouteItemCriteria criteria) {
        LOG.debug("REST request to count ConditionRouteItems by criteria: {}", criteria);
        return ResponseEntity.ok().body(conditionRouteItemQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /condition-route-items/:id} : get the "id" conditionRouteItem.
     *
     * @param id the id of the conditionRouteItemDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
     *         the conditionRouteItemDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ConditionRouteItemDTO> getConditionRouteItem(@PathVariable("id") Long id) {
        LOG.debug("REST request to get ConditionRouteItem : {}", id);
        Optional<ConditionRouteItemDTO> conditionRouteItemDTO = conditionRouteItemService.findOne(id);
        return ResponseUtil.wrapOrNotFound(conditionRouteItemDTO);
    }

    /**
     * {@code DELETE  /condition-route-items/:id} : delete the "id"
     * conditionRouteItem.
     *
     * @param id the id of the conditionRouteItemDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConditionRouteItem(@PathVariable("id") Long id) {
        LOG.debug("REST request to delete ConditionRouteItem : {}", id);
        conditionRouteItemService.delete(id);
        return ResponseEntity.noContent()
                .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
                .build();
    }
}
