package com.ridehub.booking.web.rest;

import com.ridehub.booking.repository.FileBookingRepository;
import com.ridehub.booking.service.FileBookingQueryService;
import com.ridehub.booking.service.FileBookingService;
import com.ridehub.booking.service.criteria.FileBookingCriteria;
import com.ridehub.booking.service.dto.FileBookingDTO;
import com.ridehub.booking.web.rest.errors.BadRequestAlertException;
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
 * REST controller for managing {@link com.ridehub.booking.domain.FileBooking}.
 */
@RestController
@RequestMapping("/api/file-bookings")
public class FileBookingResource {

    private static final Logger LOG = LoggerFactory.getLogger(FileBookingResource.class);

    private static final String ENTITY_NAME = "msBookingFileBooking";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final FileBookingService fileBookingService;

    private final FileBookingRepository fileBookingRepository;

    private final FileBookingQueryService fileBookingQueryService;

    public FileBookingResource(
        FileBookingService fileBookingService,
        FileBookingRepository fileBookingRepository,
        FileBookingQueryService fileBookingQueryService
    ) {
        this.fileBookingService = fileBookingService;
        this.fileBookingRepository = fileBookingRepository;
        this.fileBookingQueryService = fileBookingQueryService;
    }

    /**
     * {@code POST  /file-bookings} : Create a new fileBooking.
     *
     * @param fileBookingDTO the fileBookingDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new fileBookingDTO, or with status {@code 400 (Bad Request)} if the fileBooking has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<FileBookingDTO> createFileBooking(@Valid @RequestBody FileBookingDTO fileBookingDTO) throws URISyntaxException {
        LOG.debug("REST request to save FileBooking : {}", fileBookingDTO);
        if (fileBookingDTO.getId() != null) {
            throw new BadRequestAlertException("A new fileBooking cannot already have an ID", ENTITY_NAME, "idexists");
        }
        fileBookingDTO = fileBookingService.save(fileBookingDTO);
        return ResponseEntity.created(new URI("/api/file-bookings/" + fileBookingDTO.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, fileBookingDTO.getId().toString()))
            .body(fileBookingDTO);
    }

    /**
     * {@code PUT  /file-bookings/:id} : Updates an existing fileBooking.
     *
     * @param id the id of the fileBookingDTO to save.
     * @param fileBookingDTO the fileBookingDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated fileBookingDTO,
     * or with status {@code 400 (Bad Request)} if the fileBookingDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the fileBookingDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<FileBookingDTO> updateFileBooking(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody FileBookingDTO fileBookingDTO
    ) throws URISyntaxException {
        LOG.debug("REST request to update FileBooking : {}, {}", id, fileBookingDTO);
        if (fileBookingDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, fileBookingDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!fileBookingRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        fileBookingDTO = fileBookingService.update(fileBookingDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, fileBookingDTO.getId().toString()))
            .body(fileBookingDTO);
    }

    /**
     * {@code PATCH  /file-bookings/:id} : Partial updates given fields of an existing fileBooking, field will ignore if it is null
     *
     * @param id the id of the fileBookingDTO to save.
     * @param fileBookingDTO the fileBookingDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated fileBookingDTO,
     * or with status {@code 400 (Bad Request)} if the fileBookingDTO is not valid,
     * or with status {@code 404 (Not Found)} if the fileBookingDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the fileBookingDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<FileBookingDTO> partialUpdateFileBooking(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody FileBookingDTO fileBookingDTO
    ) throws URISyntaxException {
        LOG.debug("REST request to partial update FileBooking partially : {}, {}", id, fileBookingDTO);
        if (fileBookingDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, fileBookingDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!fileBookingRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<FileBookingDTO> result = fileBookingService.partialUpdate(fileBookingDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, fileBookingDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /file-bookings} : get all the fileBookings.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of fileBookings in body.
     */
    @GetMapping("")
    public ResponseEntity<List<FileBookingDTO>> getAllFileBookings(FileBookingCriteria criteria) {
        LOG.debug("REST request to get FileBookings by criteria: {}", criteria);

        List<FileBookingDTO> entityList = fileBookingQueryService.findByCriteria(criteria);
        return ResponseEntity.ok().body(entityList);
    }

    /**
     * {@code GET  /file-bookings/count} : count all the fileBookings.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/count")
    public ResponseEntity<Long> countFileBookings(FileBookingCriteria criteria) {
        LOG.debug("REST request to count FileBookings by criteria: {}", criteria);
        return ResponseEntity.ok().body(fileBookingQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /file-bookings/:id} : get the "id" fileBooking.
     *
     * @param id the id of the fileBookingDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the fileBookingDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<FileBookingDTO> getFileBooking(@PathVariable("id") Long id) {
        LOG.debug("REST request to get FileBooking : {}", id);
        Optional<FileBookingDTO> fileBookingDTO = fileBookingService.findOne(id);
        return ResponseUtil.wrapOrNotFound(fileBookingDTO);
    }

    /**
     * {@code DELETE  /file-bookings/:id} : delete the "id" fileBooking.
     *
     * @param id the id of the fileBookingDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFileBooking(@PathVariable("id") Long id) {
        LOG.debug("REST request to delete FileBooking : {}", id);
        fileBookingService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
