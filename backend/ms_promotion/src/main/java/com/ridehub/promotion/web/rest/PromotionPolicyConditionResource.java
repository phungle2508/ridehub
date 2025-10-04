package com.ridehub.promotion.web.rest;

import com.ridehub.promotion.repository.PromotionRepository;
import com.ridehub.promotion.service.*;
import com.ridehub.promotion.service.criteria.*;
import com.ridehub.promotion.service.dto.*;
import com.ridehub.promotion.web.rest.errors.BadRequestAlertException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;

/**
 * REST controller for managing promotion policies and conditions by promotion
 * ID.
 * This controller provides unified CRUD operations for all policy and condition
 * types
 * associated with a specific promotion.
 */
@RestController
@RequestMapping("/api/promotions/{promotionId}")
public class PromotionPolicyConditionResource {

        private static final Logger LOG = LoggerFactory.getLogger(PromotionPolicyConditionResource.class);

        @Value("${jhipster.clientApp.name}")
        private String applicationName;

        private final PromotionRepository promotionRepository;
        private final PromotionQueryService promotionQueryService;
        // Policy Services
        private final BuyNGetMFreeService buyNGetMFreeService;
        private final BuyNGetMFreeQueryService buyNGetMFreeQueryService;
        private final PercentOffTotalService percentOffTotalService;
        private final PercentOffTotalQueryService percentOffTotalQueryService;

        // Condition Services
        private final ConditionByDateService conditionByDateService;
        private final ConditionByDateQueryService conditionByDateQueryService;
        private final ConditionByRouteService conditionByRouteService;
        private final ConditionByRouteQueryService conditionByRouteQueryService;
        private final ConditionByLocationService conditionByLocationService;
        private final ConditionByLocationQueryService conditionByLocationQueryService;

        public PromotionPolicyConditionResource(
                        PromotionRepository promotionRepository,
                        BuyNGetMFreeService buyNGetMFreeService,
                        BuyNGetMFreeQueryService buyNGetMFreeQueryService,
                        PercentOffTotalService percentOffTotalService,
                        PercentOffTotalQueryService percentOffTotalQueryService,
                        ConditionByDateService conditionByDateService,
                        ConditionByDateQueryService conditionByDateQueryService,
                        ConditionByRouteService conditionByRouteService,
                        ConditionByRouteQueryService conditionByRouteQueryService,
                        ConditionByLocationService conditionByLocationService,
                        ConditionByLocationQueryService conditionByLocationQueryService,
                        PromotionQueryService promotionQueryService) {
                this.promotionRepository = promotionRepository;
                this.promotionQueryService = promotionQueryService;
                this.buyNGetMFreeService = buyNGetMFreeService;
                this.buyNGetMFreeQueryService = buyNGetMFreeQueryService;
                this.percentOffTotalService = percentOffTotalService;
                this.percentOffTotalQueryService = percentOffTotalQueryService;
                this.conditionByDateService = conditionByDateService;
                this.conditionByDateQueryService = conditionByDateQueryService;
                this.conditionByRouteService = conditionByRouteService;
                this.conditionByRouteQueryService = conditionByRouteQueryService;
                this.conditionByLocationService = conditionByLocationService;
                this.conditionByLocationQueryService = conditionByLocationQueryService;
        }

        // ==================== BUY N GET M FREE POLICIES ====================

        /**
         * {@code POST  /promotions/:promotionId/buy-n-get-m-free} : Create a new
         * buyNGetMFree policy for the promotion.
         */
        @PostMapping("/buy-n-get-m-free")
        @Operation(summary = "Create a new buyNGetMFree policy for the promotion", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(mediaType = "application/json", schema = @Schema(implementation = BuyNGetMFreeDTO.class), examples = @ExampleObject(name = "Create BuyNGetMFree Policy", description = """
                        Example request body for creating a new buyNGetMFree policy.
                        Note: promotion field should be an empty object as it will be populated
                        from the URL path parameter. System fields (id, createdAt, updatedAt,
                        isDeleted, deletedAt, deletedBy) are automatically managed.
                        """, value = """
                        {
                          "buyN": 2,
                          "getM": 1,
                          "promotion": {},
                          "createdAt": "2025-09-27T05:24:29.211Z"
                        }
                        """))))
        public ResponseEntity<BuyNGetMFreeDTO> createBuyNGetMFreePolicy(
                        @PathVariable Long promotionId,
                        @Valid @org.springframework.web.bind.annotation.RequestBody BuyNGetMFreeDTO buyNGetMFreeDTO)
                        throws URISyntaxException {

                LOG.debug("REST request to save BuyNGetMFree for promotion : {}, {}", promotionId, buyNGetMFreeDTO);

                if (!promotionRepository.existsById(promotionId)) {
                        throw new BadRequestAlertException("Promotion not found", "promotion", "idnotfound");
                }

                if (buyNGetMFreeDTO.getId() != null) {
                        throw new BadRequestAlertException("A new buyNGetMFree cannot already have an ID",
                                        "buyNGetMFree", "idexists");
                }

                // set promotion id
                PromotionDTO promotionDTO = new PromotionDTO();
                promotionDTO.setId(promotionId);
                buyNGetMFreeDTO.setPromotion(promotionDTO);

                buyNGetMFreeDTO = buyNGetMFreeService.save(buyNGetMFreeDTO);

                return ResponseEntity
                                .created(new URI("/api/promotions/" + promotionId + "/buy-n-get-m-free/"
                                                + buyNGetMFreeDTO.getId()))
                                .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, "buyNGetMFree",
                                                buyNGetMFreeDTO.getId().toString()))
                                .body(buyNGetMFreeDTO);
        }

        /**
         * {@code GET  /promotions/:promotionId/buy-n-get-m-free} : Get all buyNGetMFree
         * policies for the promotion.
         */
        @GetMapping("/buy-n-get-m-free")
        public ResponseEntity<List<BuyNGetMFreeDTO>> getBuyNGetMFreePolicies(@PathVariable Long promotionId) {
                LOG.debug("REST request to get BuyNGetMFree policies for promotion : {}", promotionId);

                BuyNGetMFreeCriteria criteria = new BuyNGetMFreeCriteria();
                criteria.setPromotionId(
                                (tech.jhipster.service.filter.LongFilter) new tech.jhipster.service.filter.LongFilter()
                                                .setEquals(promotionId));

                List<BuyNGetMFreeDTO> policies = buyNGetMFreeQueryService.findByCriteria(criteria);
                return ResponseEntity.ok().body(policies);
        }

        /**
         * {@code PUT  /promotions/:promotionId/buy-n-get-m-free/:id} : Update
         * buyNGetMFree policy.
         */
        @PutMapping("/buy-n-get-m-free/{id}")
        @Operation(summary = "Update buyNGetMFree policy")
        @RequestBody(content = @Content(mediaType = "application/json", schema = @Schema(implementation = BuyNGetMFreeDTO.class), examples = @ExampleObject(name = "Update BuyNGetMFree Policy", description = "Example request body for updating a buyNGetMFree policy. Note: id must match the path parameter, promotion field should be empty object as it will be populated from the URL path parameter. System fields (createdAt, updatedAt, isDeleted, deletedAt, deletedBy) are automatically managed.", value = """
                                        {
                                          "id": {id},
                                          "buyN": 3,
                                          "getM": 2,

                                          "promotion": {},
                        "createdAt": "2025-09-27T05:24:29.211Z"
                                        }
                                        """)))
        public ResponseEntity<BuyNGetMFreeDTO> updateBuyNGetMFreePolicy(
                        @PathVariable Long promotionId,
                        @PathVariable Long id,
                        @Valid @org.springframework.web.bind.annotation.RequestBody BuyNGetMFreeDTO buyNGetMFreeDTO)
                        throws URISyntaxException {
                LOG.debug("REST request to update BuyNGetMFree : {}, {}, {}", promotionId, id, buyNGetMFreeDTO);

                if (buyNGetMFreeDTO.getId() == null) {
                        throw new BadRequestAlertException("Invalid id", "buyNGetMFree", "idnull");
                }
                if (!Objects.equals(id, buyNGetMFreeDTO.getId())) {
                        throw new BadRequestAlertException("Invalid ID", "buyNGetMFree", "idinvalid");
                }

                // Ensure the policy belongs to the specified promotion
                PromotionDTO promotionDTO = new PromotionDTO();
                promotionDTO.setId(promotionId);
                buyNGetMFreeDTO.setPromotion(promotionDTO);

                buyNGetMFreeDTO = buyNGetMFreeService.update(buyNGetMFreeDTO);
                return ResponseEntity.ok()
                                .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, "buyNGetMFree",
                                                buyNGetMFreeDTO.getId().toString()))
                                .body(buyNGetMFreeDTO);
        }

        /**
         * {@code DELETE  /promotions/:promotionId/buy-n-get-m-free/:id} : Delete
         * buyNGetMFree policy.
         */
        @DeleteMapping("/buy-n-get-m-free/{id}")
        @Operation(summary = "Delete buyNGetMFree policy")
        public ResponseEntity<Void> deleteBuyNGetMFreePolicy(@PathVariable Long promotionId, @PathVariable Long id) {
                LOG.debug("REST request to delete BuyNGetMFree : {}, {}", promotionId, id);
                buyNGetMFreeService.delete(id);
                return ResponseEntity.noContent()
                                .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, "buyNGetMFree",
                                                id.toString()))
                                .build();
        }

        // ==================== PERCENT OFF TOTAL POLICIES ====================

        /**
         * {@code POST  /promotions/:promotionId/percent-off-total} : Create a new
         * percentOffTotal policy for the promotion.
         */
        @PostMapping("/percent-off-total")
        @Operation(summary = "Create a new percentOffTotal policy for the promotion")
        @RequestBody(content = @Content(mediaType = "application/json", schema = @Schema(implementation = PercentOffTotalDTO.class), examples = @ExampleObject(name = "Create PercentOffTotal Policy", description = "Example request body for creating a new percentOffTotal policy. Note: promotion field should be empty object as it will be populated from the URL path parameter. System fields (id, createdAt, updatedAt, isDeleted, deletedAt, deletedBy) are automatically managed.", value = """
                                        {
                                          "percent": 15,
                                          "maxOff": 50.00,
                                          "minPrice": 10000,
                                          "promotion": {},
                        "createdAt": "2025-09-27T05:24:29.211Z"
                                        }
                                        """)))
        public ResponseEntity<PercentOffTotalDTO> createPercentOffTotalPolicy(
                        @PathVariable Long promotionId,
                        @Valid @org.springframework.web.bind.annotation.RequestBody PercentOffTotalDTO percentOffTotalDTO)
                        throws URISyntaxException {
                LOG.debug("REST request to save PercentOffTotal for promotion : {}, {}", promotionId,
                                percentOffTotalDTO);

                if (!promotionRepository.existsById(promotionId)) {
                        throw new BadRequestAlertException("Promotion not found", "promotion", "idnotfound");
                }

                if (percentOffTotalDTO.getId() != null) {
                        throw new BadRequestAlertException("A new percentOffTotal cannot already have an ID",
                                        "percentOffTotal",
                                        "idexists");
                }

                // Set the promotion ID
                PromotionDTO promotionDTO = new PromotionDTO();
                promotionDTO.setId(promotionId);
                percentOffTotalDTO.setPromotion(promotionDTO);

                percentOffTotalDTO = percentOffTotalService.save(percentOffTotalDTO);
                return ResponseEntity
                                .created(new URI("/api/promotions/" + promotionId + "/percent-off-total/"
                                                + percentOffTotalDTO.getId()))
                                .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, "percentOffTotal",
                                                percentOffTotalDTO.getId().toString()))
                                .body(percentOffTotalDTO);
        }

        /**
         * {@code GET  /promotions/:promotionId/percent-off-total} : Get all
         * percentOffTotal policies for the promotion.
         */
        @GetMapping("/percent-off-total")
        public ResponseEntity<List<PercentOffTotalDTO>> getPercentOffTotalPolicies(@PathVariable Long promotionId) {
                LOG.debug("REST request to get PercentOffTotal policies for promotion : {}", promotionId);

                PercentOffTotalCriteria criteria = new PercentOffTotalCriteria();
                criteria.setPromotionId(
                                (tech.jhipster.service.filter.LongFilter) new tech.jhipster.service.filter.LongFilter()
                                                .setEquals(promotionId));

                List<PercentOffTotalDTO> policies = percentOffTotalQueryService.findByCriteria(criteria);
                return ResponseEntity.ok().body(policies);
        }

        /**
         * {@code PUT  /promotions/:promotionId/percent-off-total/:id} : Update
         * percentOffTotal policy.
         */
        @PutMapping("/percent-off-total/{id}")
        @Operation(summary = "Update percentOffTotal policy")
        @RequestBody(content = @Content(mediaType = "application/json", schema = @Schema(implementation = PercentOffTotalDTO.class), examples = @ExampleObject(name = "Update PercentOffTotal Policy", description = "Example request body for updating a percentOffTotal policy. Note: id must match the path parameter, promotion field should be empty object as it will be populated from the URL path parameter. System fields (createdAt, updatedAt, isDeleted, deletedAt, deletedBy) are automatically managed.", value = """
                                        {
                                          "id": {id},
                                          "percent": 20,
                                          "maxOff": 100.00,
                                          "minPrice": 10000,
                                          "promotion": {},
                        "createdAt": "2025-09-27T05:24:29.211Z"
                                        }
                                        """)))
        public ResponseEntity<PercentOffTotalDTO> updatePercentOffTotalPolicy(
                        @PathVariable Long promotionId,
                        @PathVariable Long id,
                        @Valid @org.springframework.web.bind.annotation.RequestBody PercentOffTotalDTO percentOffTotalDTO)
                        throws URISyntaxException {
                LOG.debug("REST request to update PercentOffTotal : {}, {}, {}", promotionId, id, percentOffTotalDTO);

                if (percentOffTotalDTO.getId() == null) {
                        throw new BadRequestAlertException("Invalid id", "percentOffTotal", "idnull");
                }
                if (!Objects.equals(id, percentOffTotalDTO.getId())) {
                        throw new BadRequestAlertException("Invalid ID", "percentOffTotal", "idinvalid");
                }

                // Ensure the policy belongs to the specified promotion
                PromotionDTO promotionDTO = new PromotionDTO();
                promotionDTO.setId(promotionId);
                percentOffTotalDTO.setPromotion(promotionDTO);

                percentOffTotalDTO = percentOffTotalService.update(percentOffTotalDTO);
                return ResponseEntity.ok()
                                .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, "percentOffTotal",
                                                percentOffTotalDTO.getId().toString()))
                                .body(percentOffTotalDTO);
        }

        /**
         * {@code DELETE  /promotions/:promotionId/percent-off-total/:id} : Delete
         * percentOffTotal policy.
         */
        @DeleteMapping("/percent-off-total/{id}")
        @Operation(summary = "Delete percentOffTotal policy")
        public ResponseEntity<Void> deletePercentOffTotalPolicy(@PathVariable Long promotionId, @PathVariable Long id) {
                LOG.debug("REST request to delete PercentOffTotal : {}, {}", promotionId, id);
                percentOffTotalService.delete(id);
                return ResponseEntity.noContent()
                                .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, "percentOffTotal",
                                                id.toString()))
                                .build();
        }

        // ==================== CONDITION BY DATE ====================

        /**
         * {@code POST  /promotions/:promotionId/conditions/date} : Create a new date
         * condition for the promotion.
         */
        @PostMapping("/conditions/date")
        @Operation(summary = "Create a new date condition for the promotion")
        @RequestBody(content = @Content(mediaType = "application/json", schema = @Schema(implementation = ConditionByDateDTO.class), examples = @ExampleObject(name = "Create Date Condition", description = "Example request body for creating a new date condition. Note: promotion field should be empty object as it will be populated from the URL path parameter. System fields (id, createdAt, updatedAt, isDeleted, deletedAt, deletedBy) are automatically managed.", value = """
                                        {
                                          "promotion": {},
                        "createdAt": "2025-09-27T05:24:29.211Z",
                                          "items": [
                                            {
                                              "specificDate": "2024-12-25",
                                              "weekday": null
                                            },
                                            {
                                              "specificDate": null,
                                              "weekday": 6
                                            }
                                          ]
                                        }
                                        """)))
        public ResponseEntity<ConditionByDateDTO> createDateCondition(
                        @PathVariable Long promotionId,
                        @Valid @org.springframework.web.bind.annotation.RequestBody ConditionByDateDTO conditionByDateDTO)
                        throws URISyntaxException {
                LOG.debug("REST request to save ConditionByDate for promotion : {}, {}", promotionId,
                                conditionByDateDTO);

                if (!promotionRepository.existsById(promotionId)) {
                        throw new BadRequestAlertException("Promotion not found", "promotion", "idnotfound");
                }

                if (conditionByDateDTO.getId() != null) {
                        throw new BadRequestAlertException("A new conditionByDate cannot already have an ID",
                                        "conditionByDate",
                                        "idexists");
                }

                // Set the promotion ID
                PromotionDTO promotionDTO = new PromotionDTO();
                promotionDTO.setId(promotionId);
                conditionByDateDTO.setPromotion(promotionDTO);

                conditionByDateDTO = conditionByDateService.save(conditionByDateDTO);
                return ResponseEntity
                                .created(new URI("/api/promotions/" + promotionId + "/conditions/date/"
                                                + conditionByDateDTO.getId()))
                                .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, "conditionByDate",
                                                conditionByDateDTO.getId().toString()))
                                .body(conditionByDateDTO);
        }

        /**
         * {@code GET  /promotions/:promotionId/conditions/date} : Get all date
         * conditions for the promotion.
         */
        @GetMapping("/conditions/date")
        public ResponseEntity<List<ConditionByDateDTO>> getDateConditions(@PathVariable Long promotionId) {
                LOG.debug("REST request to get ConditionByDate for promotion : {}", promotionId);

                ConditionByDateCriteria criteria = new ConditionByDateCriteria();
                criteria.setPromotionId(
                                (tech.jhipster.service.filter.LongFilter) new tech.jhipster.service.filter.LongFilter()
                                                .setEquals(promotionId));

                List<ConditionByDateDTO> conditions = conditionByDateQueryService.findByCriteria(criteria);
                return ResponseEntity.ok().body(conditions);
        }

        /**
         * {@code PUT  /promotions/:promotionId/conditions/date/:id} : Update date
         * condition.
         */
        @PutMapping("/conditions/date/{id}")
        @Operation(summary = "Update date condition")
        @RequestBody(content = @Content(mediaType = "application/json", schema = @Schema(implementation = ConditionByDateDTO.class), examples = @ExampleObject(name = "Update Date Condition", description = "Example request body for updating a date condition. Note: id must match the path parameter, promotion field should be empty object as it will be populated from the URL path parameter. System fields (createdAt, updatedAt, isDeleted, deletedAt, deletedBy) are automatically managed.", value = """
                                        {
                                          "id": 1,
                                          "promotion": {},
                        "createdAt": "2025-09-27T05:24:29.211Z",
                                          "items": [
                                            {
                                              "id": 1,
                                              "specificDate": "2024-07-04",
                                              "weekday": null
                                            },
                                            {
                                              "specificDate": null,
                                              "weekday": 1
                                            }
                                          ]
                                        }
                                        """)))
        public ResponseEntity<ConditionByDateDTO> updateDateCondition(
                        @PathVariable Long promotionId,
                        @PathVariable Long id,
                        @Valid @org.springframework.web.bind.annotation.RequestBody ConditionByDateDTO conditionByDateDTO)
                        throws URISyntaxException {
                LOG.debug("REST request to update ConditionByDate : {}, {}, {}", promotionId, id, conditionByDateDTO);

                if (conditionByDateDTO.getId() == null) {
                        throw new BadRequestAlertException("Invalid id", "conditionByDate", "idnull");
                }
                if (!Objects.equals(id, conditionByDateDTO.getId())) {
                        throw new BadRequestAlertException("Invalid ID", "conditionByDate", "idinvalid");
                }

                // Ensure the condition belongs to the specified promotion
                PromotionDTO promotionDTO = new PromotionDTO();
                promotionDTO.setId(promotionId);
                conditionByDateDTO.setPromotion(promotionDTO);

                conditionByDateDTO = conditionByDateService.update(conditionByDateDTO);
                return ResponseEntity.ok()
                                .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, "conditionByDate",
                                                conditionByDateDTO.getId().toString()))
                                .body(conditionByDateDTO);
        }

        /**
         * {@code DELETE  /promotions/:promotionId/conditions/date/:id} : Delete date
         * condition.
         */
        @DeleteMapping("/conditions/date/{id}")
        @Operation(summary = "Delete date condition")
        public ResponseEntity<Void> deleteDateCondition(@PathVariable Long promotionId, @PathVariable Long id) {
                LOG.debug("REST request to delete ConditionByDate : {}, {}", promotionId, id);
                conditionByDateService.delete(id);
                return ResponseEntity.noContent()
                                .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, "conditionByDate",
                                                id.toString()))
                                .build();
        }

        // ==================== CONDITION BY ROUTE ====================

        /**
         * {@code POST  /promotions/:promotionId/conditions/route} : Create a new route
         * condition for the promotion.
         */
        @PostMapping("/conditions/route")
        @Operation(summary = "Create a new route condition for the promotion")
        @RequestBody(content = @Content(mediaType = "application/json", schema = @Schema(implementation = ConditionByRouteDTO.class), examples = @ExampleObject(name = "Create Route Condition", description = "Example request body for creating a new route condition. Note: promotion field should be empty object as it will be populated from the URL path parameter. System fields (id, createdAt, updatedAt, isDeleted, deletedAt, deletedBy) are automatically managed.", value = """
                                        {
                                          "promotion": {},
                        "createdAt": "2025-09-27T05:24:29.211Z",
                                          "items": [
                                            {
                                              "routeId": "550e8400-e29b-41d4-a716-446655440001"
                                            },
                                            {
                                              "routeId": "550e8400-e29b-41d4-a716-446655440002"
                                            }
                                          ]
                                        }
                                        """)))
        public ResponseEntity<ConditionByRouteDTO> createRouteCondition(
                        @PathVariable Long promotionId,
                        @Valid @org.springframework.web.bind.annotation.RequestBody ConditionByRouteDTO conditionByRouteDTO)
                        throws URISyntaxException {
                LOG.debug("REST request to save ConditionByRoute for promotion : {}, {}", promotionId,
                                conditionByRouteDTO);

                if (!promotionRepository.existsById(promotionId)) {
                        throw new BadRequestAlertException("Promotion not found", "promotion", "idnotfound");
                }

                if (conditionByRouteDTO.getId() != null) {
                        throw new BadRequestAlertException("A new conditionByRoute cannot already have an ID",
                                        "conditionByRoute",
                                        "idexists");
                }

                // Set the promotion ID
                PromotionDTO promotionDTO = new PromotionDTO();
                promotionDTO.setId(promotionId);
                conditionByRouteDTO.setPromotion(promotionDTO);

                conditionByRouteDTO = conditionByRouteService.save(conditionByRouteDTO);
                return ResponseEntity
                                .created(new URI("/api/promotions/" + promotionId + "/conditions/route/"
                                                + conditionByRouteDTO.getId()))
                                .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, "conditionByRoute",
                                                conditionByRouteDTO.getId().toString()))
                                .body(conditionByRouteDTO);
        }

        /**
         * {@code GET  /promotions/:promotionId/conditions/route} : Get all route
         * conditions for the promotion.
         */
        @GetMapping("/conditions/route")
        public ResponseEntity<List<ConditionByRouteDTO>> getRouteConditions(@PathVariable Long promotionId) {
                LOG.debug("REST request to get ConditionByRoute for promotion : {}", promotionId);

                ConditionByRouteCriteria criteria = new ConditionByRouteCriteria();
                criteria.setPromotionId(
                                (tech.jhipster.service.filter.LongFilter) new tech.jhipster.service.filter.LongFilter()
                                                .setEquals(promotionId));

                List<ConditionByRouteDTO> conditions = conditionByRouteQueryService.findByCriteria(criteria);
                return ResponseEntity.ok().body(conditions);
        }

        /**
         * {@code PUT  /promotions/:promotionId/conditions/route/:id} : Update route
         * condition.
         */
        @PutMapping("/conditions/route/{id}")
        @Operation(summary = "Update route condition")
        @RequestBody(content = @Content(mediaType = "application/json", schema = @Schema(implementation = ConditionByRouteDTO.class), examples = @ExampleObject(name = "Update Route Condition", description = "Example request body for updating a route condition. Note: id must match the path parameter, promotion field should be empty object as it will be populated from the URL path parameter. System fields (createdAt, updatedAt, isDeleted, deletedAt, deletedBy) are automatically managed.", value = """
                                        {
                                          "id": 1,
                                          "promotion": {},
                        "createdAt": "2025-09-27T05:24:29.211Z",
                                          "items": [
                                            {
                                              "id": 1,
                                              "routeId": "550e8400-e29b-41d4-a716-446655440003"
                                            },
                                            {
                                              "routeId": "550e8400-e29b-41d4-a716-446655440004"
                                            }
                                          ]
                                        }
                                        """)))
        public ResponseEntity<ConditionByRouteDTO> updateRouteCondition(
                        @PathVariable Long promotionId,
                        @PathVariable Long id,
                        @Valid @org.springframework.web.bind.annotation.RequestBody ConditionByRouteDTO conditionByRouteDTO)
                        throws URISyntaxException {
                LOG.debug("REST request to update ConditionByRoute : {}, {}, {}", promotionId, id, conditionByRouteDTO);

                if (conditionByRouteDTO.getId() == null) {
                        throw new BadRequestAlertException("Invalid id", "conditionByRoute", "idnull");
                }
                if (!Objects.equals(id, conditionByRouteDTO.getId())) {
                        throw new BadRequestAlertException("Invalid ID", "conditionByRoute", "idinvalid");
                }

                // Ensure the condition belongs to the specified promotion
                PromotionDTO promotionDTO = new PromotionDTO();
                promotionDTO.setId(promotionId);
                conditionByRouteDTO.setPromotion(promotionDTO);

                conditionByRouteDTO = conditionByRouteService.update(conditionByRouteDTO);
                return ResponseEntity.ok()
                                .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, "conditionByRoute",
                                                conditionByRouteDTO.getId().toString()))
                                .body(conditionByRouteDTO);
        }

        /**
         * {@code DELETE  /promotions/:promotionId/conditions/route/:id} : Delete route
         * condition.
         */
        @DeleteMapping("/conditions/route/{id}")
        @Operation(summary = "Delete route condition")
        public ResponseEntity<Void> deleteRouteCondition(@PathVariable Long promotionId, @PathVariable Long id) {
                LOG.debug("REST request to delete ConditionByRoute : {}, {}", promotionId, id);
                conditionByRouteService.delete(id);
                return ResponseEntity.noContent()
                                .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, "conditionByRoute",
                                                id.toString()))
                                .build();
        }

        // ==================== CONDITION BY LOCATION ====================

        /**
         * {@code POST  /promotions/:promotionId/conditions/location} : Create a new
         * location condition for the promotion.
         */
        @PostMapping("/conditions/location")
        @Operation(summary = "Create a new location condition for the promotion", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(mediaType = "application/json", schema = @Schema(implementation = ConditionByLocationDTO.class), examples = @ExampleObject(name = "Create Location Condition", description = """
                        Example request body for creating a new location condition.
                        Note: the `promotion` field should be an empty object, since it will
                        be populated automatically from the URL path parameter.
                        System fields (id, createdAt, updatedAt, isDeleted, deletedAt, deletedBy)
                        are automatically managed by the system.
                        """, value = """
                        {
                          "promotion": {},
                          "createdAt": "2025-09-27T05:24:29.211Z",
                          "items": [
                            {
                              "provinceId": 1,
                              "districtId": 10,
                              "wardId": null
                            },
                            {
                              "provinceId": 2,
                              "districtId": null,
                              "wardId": null
                            }
                          ]
                        }
                        """))))
        public ResponseEntity<ConditionByLocationDTO> createLocationCondition(
                        @PathVariable Long promotionId,
                        @Valid @org.springframework.web.bind.annotation.RequestBody ConditionByLocationDTO conditionByLocationDTO)
                        throws URISyntaxException {

                LOG.debug("REST request to save ConditionByLocation for promotion : {}, {}", promotionId,
                                conditionByLocationDTO);

                if (!promotionRepository.existsById(promotionId)) {
                        throw new BadRequestAlertException("Promotion not found", "promotion", "idnotfound");
                }

                if (conditionByLocationDTO.getId() != null) {
                        throw new BadRequestAlertException("A new conditionByLocation cannot already have an ID",
                                        "conditionByLocation", "idexists");
                }

                // Set the promotion ID
                PromotionDTO promotionDTO = new PromotionDTO();
                promotionDTO.setId(promotionId);
                conditionByLocationDTO.setPromotion(promotionDTO);

                conditionByLocationDTO = conditionByLocationService.save(conditionByLocationDTO);

                return ResponseEntity
                                .created(new URI("/api/promotions/" + promotionId + "/conditions/location/"
                                                + conditionByLocationDTO.getId()))
                                .headers(HeaderUtil.createEntityCreationAlert(applicationName, true,
                                                "conditionByLocation",
                                                conditionByLocationDTO.getId().toString()))
                                .body(conditionByLocationDTO);
        }

        /**
         * {@code GET  /promotions/:promotionId/conditions/location} : Get all location
         * conditions for the promotion.
         */
        @GetMapping("/conditions/location")
        public ResponseEntity<List<ConditionByLocationDTO>> getLocationConditions(@PathVariable Long promotionId) {
                LOG.debug("REST request to get ConditionByLocation for promotion : {}", promotionId);

                ConditionByLocationCriteria criteria = new ConditionByLocationCriteria();
                criteria.setPromotionId(
                                (tech.jhipster.service.filter.LongFilter) new tech.jhipster.service.filter.LongFilter()
                                                .setEquals(promotionId));

                List<ConditionByLocationDTO> conditions = conditionByLocationQueryService.findByCriteria(criteria);
                return ResponseEntity.ok().body(conditions);
        }

        /**
         * {@code PUT  /promotions/:promotionId/conditions/location/:id} : Update
         * location condition.
         */
        @PutMapping("/conditions/location/{id}")
        @Operation(summary = "Update location condition")
        @RequestBody(content = @Content(mediaType = "application/json", schema = @Schema(implementation = ConditionByLocationDTO.class), examples = @ExampleObject(name = "Update Location Condition", description = """
                        Example request body for updating a location condition.
                        Note: `id` must match the path parameter, and `promotionId` will be
                        automatically populated from the URL path. System fields
                        (createdAt, updatedAt, isDeleted, deletedAt, deletedBy)
                        are automatically managed by the system.
                        """, value = """
                        {
                          "id": 1,
                          "promotionId": 12,
                          "createdAt": "2025-09-27T05:24:29.211Z",
                          "items": [
                            {
                              "id": 1,
                              "provinceId": 1,
                              "districtId": 10,
                              "wardId": 100
                            },
                            {
                              "provinceId": 2,
                              "districtId": null,
                              "wardId": null
                            }
                          ]
                        }
                        """)))

        public ResponseEntity<ConditionByLocationDTO> updateLocationCondition(
                        @PathVariable Long promotionId,
                        @PathVariable Long id,
                        @Valid @org.springframework.web.bind.annotation.RequestBody ConditionByLocationDTO conditionByLocationDTO)
                        throws URISyntaxException {
                LOG.debug("REST request to update ConditionByLocation : {}, {}, {}", promotionId, id,
                                conditionByLocationDTO);

                if (conditionByLocationDTO.getId() == null) {
                        throw new BadRequestAlertException("Invalid id", "conditionByLocation", "idnull");
                }
                if (!Objects.equals(id, conditionByLocationDTO.getId())) {
                        throw new BadRequestAlertException("Invalid ID", "conditionByLocation", "idinvalid");
                }

                // Ensure the condition belongs to the specified promotion
                PromotionDTO promotionDTO = new PromotionDTO();
                promotionDTO.setId(promotionId);
                conditionByLocationDTO.setPromotion(promotionDTO);

                conditionByLocationDTO = conditionByLocationService.update(conditionByLocationDTO);
                return ResponseEntity.ok()
                                .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true,
                                                "conditionByLocation",
                                                conditionByLocationDTO.getId().toString()))
                                .body(conditionByLocationDTO);
        }

        /**
         * {@code DELETE  /promotions/:promotionId/conditions/location/:id} : Delete
         * location condition.
         */
        @DeleteMapping("/conditions/location/{id}")
        @Operation(summary = "Delete location condition")
        public ResponseEntity<Void> deleteLocationCondition(@PathVariable Long promotionId, @PathVariable Long id) {
                LOG.debug("REST request to delete ConditionByLocation : {}, {}", promotionId, id);
                conditionByLocationService.delete(id);
                return ResponseEntity.noContent()
                                .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true,
                                                "conditionByLocation",
                                                id.toString()))
                                .build();
        }

        // ==================== BULK OPERATIONS ====================

        /**
         * {@code GET  /promotions/:promotionId/policies-and-conditions} : Get all
         * policies and conditions for the promotion.
         */
        @GetMapping("/policies-and-conditions")
        public ResponseEntity<PromotionPoliciesAndConditionsDTO> getAllPoliciesAndConditions(
                        @PathVariable Long promotionId) {
                LOG.debug("REST request to get all policies and conditions for promotion : {}", promotionId);

                if (!promotionRepository.existsById(promotionId)) {
                        throw new BadRequestAlertException("Promotion not found", "promotion", "idnotfound");
                }

                PromotionPoliciesAndConditionsDTO result = new PromotionPoliciesAndConditionsDTO();
                result.setPromotionId(promotionId);

                // Get all policies
                BuyNGetMFreeCriteria buyNGetMCriteria = new BuyNGetMFreeCriteria();
                buyNGetMCriteria
                                .setPromotionId((tech.jhipster.service.filter.LongFilter) new tech.jhipster.service.filter.LongFilter()
                                                .setEquals(promotionId));
                result.setBuyNGetMFreePolicies(buyNGetMFreeQueryService.findByCriteria(buyNGetMCriteria));

                PercentOffTotalCriteria percentOffCriteria = new PercentOffTotalCriteria();
                percentOffCriteria
                                .setPromotionId((tech.jhipster.service.filter.LongFilter) new tech.jhipster.service.filter.LongFilter()
                                                .setEquals(promotionId));
                result.setPercentOffTotalPolicies(percentOffTotalQueryService.findByCriteria(percentOffCriteria));

                // Get all conditions
                ConditionByDateCriteria dateCriteria = new ConditionByDateCriteria();
                dateCriteria
                                .setPromotionId((tech.jhipster.service.filter.LongFilter) new tech.jhipster.service.filter.LongFilter()
                                                .setEquals(promotionId));
                result.setDateConditions(conditionByDateQueryService.findByCriteria(dateCriteria));

                ConditionByRouteCriteria routeCriteria = new ConditionByRouteCriteria();
                routeCriteria
                                .setPromotionId((tech.jhipster.service.filter.LongFilter) new tech.jhipster.service.filter.LongFilter()
                                                .setEquals(promotionId));
                result.setRouteConditions(conditionByRouteQueryService.findByCriteria(routeCriteria));

                ConditionByLocationCriteria locationCriteria = new ConditionByLocationCriteria();
                locationCriteria
                                .setPromotionId((tech.jhipster.service.filter.LongFilter) new tech.jhipster.service.filter.LongFilter()
                                                .setEquals(promotionId));
                result.setLocationConditions(conditionByLocationQueryService.findByCriteria(locationCriteria));

                return ResponseEntity.ok().body(result);
        }

        // GET /api/promotions/{promotionId}/detail
        @GetMapping("/detail")
        public ResponseEntity<PromotionDetailDTO> getPromotionDetail(@PathVariable Long promotionId) {
                LOG.debug("REST request to get Promotion detail : {}", promotionId);

                // If your service throws EntityNotFoundException on missing ID:
                try {
                        PromotionDetailDTO dto = promotionQueryService.getDetailById(promotionId);
                        return ResponseEntity.ok(dto);
                } catch (EntityNotFoundException ex) {
                        return ResponseEntity.notFound().build();
                }
        }

}
