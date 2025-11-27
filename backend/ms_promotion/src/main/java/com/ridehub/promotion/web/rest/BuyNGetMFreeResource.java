package com.ridehub.promotion.web.rest;

import com.ridehub.promotion.repository.BuyNGetMFreeRepository;
import com.ridehub.promotion.service.BuyNGetMFreeQueryService;
import com.ridehub.promotion.service.BuyNGetMFreeService;
import com.ridehub.promotion.service.criteria.BuyNGetMFreeCriteria;
import com.ridehub.promotion.service.dto.BuyNGetMFreeDTO;
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
 * REST controller for managing {@link com.ridehub.promotion.domain.BuyNGetMFree}.
 */
@RestController
@RequestMapping("/api/buy-n-get-m-frees")
public class BuyNGetMFreeResource {

    private static final Logger LOG = LoggerFactory.getLogger(BuyNGetMFreeResource.class);

    private static final String ENTITY_NAME = "msPromotionBuyNGetMFree";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final BuyNGetMFreeService buyNGetMFreeService;

    private final BuyNGetMFreeRepository buyNGetMFreeRepository;

    private final BuyNGetMFreeQueryService buyNGetMFreeQueryService;

    public BuyNGetMFreeResource(
        BuyNGetMFreeService buyNGetMFreeService,
        BuyNGetMFreeRepository buyNGetMFreeRepository,
        BuyNGetMFreeQueryService buyNGetMFreeQueryService
    ) {
        this.buyNGetMFreeService = buyNGetMFreeService;
        this.buyNGetMFreeRepository = buyNGetMFreeRepository;
        this.buyNGetMFreeQueryService = buyNGetMFreeQueryService;
    }

    /**
     * {@code POST  /buy-n-get-m-frees} : Create a new buyNGetMFree.
     *
     * @param buyNGetMFreeDTO the buyNGetMFreeDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new buyNGetMFreeDTO, or with status {@code 400 (Bad Request)} if the buyNGetMFree has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<BuyNGetMFreeDTO> createBuyNGetMFree(@Valid @RequestBody BuyNGetMFreeDTO buyNGetMFreeDTO)
        throws URISyntaxException {
        LOG.debug("REST request to save BuyNGetMFree : {}", buyNGetMFreeDTO);
        if (buyNGetMFreeDTO.getId() != null) {
            throw new BadRequestAlertException("A new buyNGetMFree cannot already have an ID", ENTITY_NAME, "idexists");
        }
        buyNGetMFreeDTO = buyNGetMFreeService.save(buyNGetMFreeDTO);
        return ResponseEntity.created(new URI("/api/buy-n-get-m-frees/" + buyNGetMFreeDTO.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, buyNGetMFreeDTO.getId().toString()))
            .body(buyNGetMFreeDTO);
    }

    /**
     * {@code PUT  /buy-n-get-m-frees/:id} : Updates an existing buyNGetMFree.
     *
     * @param id the id of the buyNGetMFreeDTO to save.
     * @param buyNGetMFreeDTO the buyNGetMFreeDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated buyNGetMFreeDTO,
     * or with status {@code 400 (Bad Request)} if the buyNGetMFreeDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the buyNGetMFreeDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<BuyNGetMFreeDTO> updateBuyNGetMFree(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody BuyNGetMFreeDTO buyNGetMFreeDTO
    ) throws URISyntaxException {
        LOG.debug("REST request to update BuyNGetMFree : {}, {}", id, buyNGetMFreeDTO);
        if (buyNGetMFreeDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, buyNGetMFreeDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!buyNGetMFreeRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        buyNGetMFreeDTO = buyNGetMFreeService.update(buyNGetMFreeDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, buyNGetMFreeDTO.getId().toString()))
            .body(buyNGetMFreeDTO);
    }

    /**
     * {@code PATCH  /buy-n-get-m-frees/:id} : Partial updates given fields of an existing buyNGetMFree, field will ignore if it is null
     *
     * @param id the id of the buyNGetMFreeDTO to save.
     * @param buyNGetMFreeDTO the buyNGetMFreeDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated buyNGetMFreeDTO,
     * or with status {@code 400 (Bad Request)} if the buyNGetMFreeDTO is not valid,
     * or with status {@code 404 (Not Found)} if the buyNGetMFreeDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the buyNGetMFreeDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<BuyNGetMFreeDTO> partialUpdateBuyNGetMFree(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody BuyNGetMFreeDTO buyNGetMFreeDTO
    ) throws URISyntaxException {
        LOG.debug("REST request to partial update BuyNGetMFree partially : {}, {}", id, buyNGetMFreeDTO);
        if (buyNGetMFreeDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, buyNGetMFreeDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!buyNGetMFreeRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<BuyNGetMFreeDTO> result = buyNGetMFreeService.partialUpdate(buyNGetMFreeDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, buyNGetMFreeDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /buy-n-get-m-frees} : get all the buyNGetMFrees.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of buyNGetMFrees in body.
     */
    @GetMapping("")
    public ResponseEntity<List<BuyNGetMFreeDTO>> getAllBuyNGetMFrees(BuyNGetMFreeCriteria criteria) {
        LOG.debug("REST request to get BuyNGetMFrees by criteria: {}", criteria);

        List<BuyNGetMFreeDTO> entityList = buyNGetMFreeQueryService.findByCriteria(criteria);
        return ResponseEntity.ok().body(entityList);
    }

    /**
     * {@code GET  /buy-n-get-m-frees/count} : count all the buyNGetMFrees.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/count")
    public ResponseEntity<Long> countBuyNGetMFrees(BuyNGetMFreeCriteria criteria) {
        LOG.debug("REST request to count BuyNGetMFrees by criteria: {}", criteria);
        return ResponseEntity.ok().body(buyNGetMFreeQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /buy-n-get-m-frees/:id} : get the "id" buyNGetMFree.
     *
     * @param id the id of the buyNGetMFreeDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the buyNGetMFreeDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<BuyNGetMFreeDTO> getBuyNGetMFree(@PathVariable("id") Long id) {
        LOG.debug("REST request to get BuyNGetMFree : {}", id);
        Optional<BuyNGetMFreeDTO> buyNGetMFreeDTO = buyNGetMFreeService.findOne(id);
        return ResponseUtil.wrapOrNotFound(buyNGetMFreeDTO);
    }

    /**
     * {@code DELETE  /buy-n-get-m-frees/:id} : delete the "id" buyNGetMFree.
     *
     * @param id the id of the buyNGetMFreeDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBuyNGetMFree(@PathVariable("id") Long id) {
        LOG.debug("REST request to delete BuyNGetMFree : {}", id);
        buyNGetMFreeService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
