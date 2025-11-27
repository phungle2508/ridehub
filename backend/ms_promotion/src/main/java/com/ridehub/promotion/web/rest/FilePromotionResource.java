package com.ridehub.promotion.web.rest;

import com.ridehub.promotion.repository.FilePromotionRepository;
import com.ridehub.promotion.service.FilePromotionQueryService;
import com.ridehub.promotion.service.FilePromotionService;
import com.ridehub.promotion.service.criteria.FilePromotionCriteria;
import com.ridehub.promotion.service.dto.FilePromotionDTO;
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
 * REST controller for managing {@link com.ridehub.promotion.domain.FilePromotion}.
 */
@RestController
@RequestMapping("/api/file-promotions")
public class FilePromotionResource {

    private static final Logger LOG = LoggerFactory.getLogger(FilePromotionResource.class);

    private static final String ENTITY_NAME = "msPromotionFilePromotion";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final FilePromotionService filePromotionService;

    private final FilePromotionRepository filePromotionRepository;

    private final FilePromotionQueryService filePromotionQueryService;

    public FilePromotionResource(
        FilePromotionService filePromotionService,
        FilePromotionRepository filePromotionRepository,
        FilePromotionQueryService filePromotionQueryService
    ) {
        this.filePromotionService = filePromotionService;
        this.filePromotionRepository = filePromotionRepository;
        this.filePromotionQueryService = filePromotionQueryService;
    }

    /**
     * {@code POST  /file-promotions} : Create a new filePromotion.
     *
     * @param filePromotionDTO the filePromotionDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new filePromotionDTO, or with status {@code 400 (Bad Request)} if the filePromotion has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<FilePromotionDTO> createFilePromotion(@Valid @RequestBody FilePromotionDTO filePromotionDTO)
        throws URISyntaxException {
        LOG.debug("REST request to save FilePromotion : {}", filePromotionDTO);
        if (filePromotionDTO.getId() != null) {
            throw new BadRequestAlertException("A new filePromotion cannot already have an ID", ENTITY_NAME, "idexists");
        }
        filePromotionDTO = filePromotionService.save(filePromotionDTO);
        return ResponseEntity.created(new URI("/api/file-promotions/" + filePromotionDTO.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, filePromotionDTO.getId().toString()))
            .body(filePromotionDTO);
    }

    /**
     * {@code PUT  /file-promotions/:id} : Updates an existing filePromotion.
     *
     * @param id the id of the filePromotionDTO to save.
     * @param filePromotionDTO the filePromotionDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated filePromotionDTO,
     * or with status {@code 400 (Bad Request)} if the filePromotionDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the filePromotionDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<FilePromotionDTO> updateFilePromotion(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody FilePromotionDTO filePromotionDTO
    ) throws URISyntaxException {
        LOG.debug("REST request to update FilePromotion : {}, {}", id, filePromotionDTO);
        if (filePromotionDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, filePromotionDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!filePromotionRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        filePromotionDTO = filePromotionService.update(filePromotionDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, filePromotionDTO.getId().toString()))
            .body(filePromotionDTO);
    }

    /**
     * {@code PATCH  /file-promotions/:id} : Partial updates given fields of an existing filePromotion, field will ignore if it is null
     *
     * @param id the id of the filePromotionDTO to save.
     * @param filePromotionDTO the filePromotionDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated filePromotionDTO,
     * or with status {@code 400 (Bad Request)} if the filePromotionDTO is not valid,
     * or with status {@code 404 (Not Found)} if the filePromotionDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the filePromotionDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<FilePromotionDTO> partialUpdateFilePromotion(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody FilePromotionDTO filePromotionDTO
    ) throws URISyntaxException {
        LOG.debug("REST request to partial update FilePromotion partially : {}, {}", id, filePromotionDTO);
        if (filePromotionDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, filePromotionDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!filePromotionRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<FilePromotionDTO> result = filePromotionService.partialUpdate(filePromotionDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, filePromotionDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /file-promotions} : get all the filePromotions.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of filePromotions in body.
     */
    @GetMapping("")
    public ResponseEntity<List<FilePromotionDTO>> getAllFilePromotions(FilePromotionCriteria criteria) {
        LOG.debug("REST request to get FilePromotions by criteria: {}", criteria);

        List<FilePromotionDTO> entityList = filePromotionQueryService.findByCriteria(criteria);
        return ResponseEntity.ok().body(entityList);
    }

    /**
     * {@code GET  /file-promotions/count} : count all the filePromotions.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/count")
    public ResponseEntity<Long> countFilePromotions(FilePromotionCriteria criteria) {
        LOG.debug("REST request to count FilePromotions by criteria: {}", criteria);
        return ResponseEntity.ok().body(filePromotionQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /file-promotions/:id} : get the "id" filePromotion.
     *
     * @param id the id of the filePromotionDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the filePromotionDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<FilePromotionDTO> getFilePromotion(@PathVariable("id") Long id) {
        LOG.debug("REST request to get FilePromotion : {}", id);
        Optional<FilePromotionDTO> filePromotionDTO = filePromotionService.findOne(id);
        return ResponseUtil.wrapOrNotFound(filePromotionDTO);
    }

    /**
     * {@code DELETE  /file-promotions/:id} : delete the "id" filePromotion.
     *
     * @param id the id of the filePromotionDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFilePromotion(@PathVariable("id") Long id) {
        LOG.debug("REST request to delete FilePromotion : {}", id);
        filePromotionService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
