package com.ticketsystem.route.web.rest;

import com.ticketsystem.route.repository.VehicleImageRepository;
import com.ticketsystem.route.service.VehicleImageQueryService;
import com.ticketsystem.route.service.VehicleImageService;
import com.ticketsystem.route.service.criteria.VehicleImageCriteria;
import com.ticketsystem.route.service.dto.VehicleImageDTO;
import com.ticketsystem.route.web.rest.errors.BadRequestAlertException;
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
 * REST controller for managing {@link com.ticketsystem.route.domain.VehicleImage}.
 */
@RestController
@RequestMapping("/api/vehicle-images")
public class VehicleImageResource {

    private static final Logger LOG = LoggerFactory.getLogger(VehicleImageResource.class);

    private static final String ENTITY_NAME = "msRouteVehicleImage";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final VehicleImageService vehicleImageService;

    private final VehicleImageRepository vehicleImageRepository;

    private final VehicleImageQueryService vehicleImageQueryService;

    public VehicleImageResource(
        VehicleImageService vehicleImageService,
        VehicleImageRepository vehicleImageRepository,
        VehicleImageQueryService vehicleImageQueryService
    ) {
        this.vehicleImageService = vehicleImageService;
        this.vehicleImageRepository = vehicleImageRepository;
        this.vehicleImageQueryService = vehicleImageQueryService;
    }

    /**
     * {@code POST  /vehicle-images} : Create a new vehicleImage.
     *
     * @param vehicleImageDTO the vehicleImageDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new vehicleImageDTO, or with status {@code 400 (Bad Request)} if the vehicleImage has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<VehicleImageDTO> createVehicleImage(@Valid @RequestBody VehicleImageDTO vehicleImageDTO)
        throws URISyntaxException {
        LOG.debug("REST request to save VehicleImage : {}", vehicleImageDTO);
        if (vehicleImageDTO.getId() != null) {
            throw new BadRequestAlertException("A new vehicleImage cannot already have an ID", ENTITY_NAME, "idexists");
        }
        vehicleImageDTO = vehicleImageService.save(vehicleImageDTO);
        return ResponseEntity.created(new URI("/api/vehicle-images/" + vehicleImageDTO.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, vehicleImageDTO.getId().toString()))
            .body(vehicleImageDTO);
    }

    /**
     * {@code PUT  /vehicle-images/:id} : Updates an existing vehicleImage.
     *
     * @param id the id of the vehicleImageDTO to save.
     * @param vehicleImageDTO the vehicleImageDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated vehicleImageDTO,
     * or with status {@code 400 (Bad Request)} if the vehicleImageDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the vehicleImageDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<VehicleImageDTO> updateVehicleImage(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody VehicleImageDTO vehicleImageDTO
    ) throws URISyntaxException {
        LOG.debug("REST request to update VehicleImage : {}, {}", id, vehicleImageDTO);
        if (vehicleImageDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, vehicleImageDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!vehicleImageRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        vehicleImageDTO = vehicleImageService.update(vehicleImageDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, vehicleImageDTO.getId().toString()))
            .body(vehicleImageDTO);
    }

    /**
     * {@code PATCH  /vehicle-images/:id} : Partial updates given fields of an existing vehicleImage, field will ignore if it is null
     *
     * @param id the id of the vehicleImageDTO to save.
     * @param vehicleImageDTO the vehicleImageDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated vehicleImageDTO,
     * or with status {@code 400 (Bad Request)} if the vehicleImageDTO is not valid,
     * or with status {@code 404 (Not Found)} if the vehicleImageDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the vehicleImageDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<VehicleImageDTO> partialUpdateVehicleImage(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody VehicleImageDTO vehicleImageDTO
    ) throws URISyntaxException {
        LOG.debug("REST request to partial update VehicleImage partially : {}, {}", id, vehicleImageDTO);
        if (vehicleImageDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, vehicleImageDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!vehicleImageRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<VehicleImageDTO> result = vehicleImageService.partialUpdate(vehicleImageDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, vehicleImageDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /vehicle-images} : get all the vehicleImages.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of vehicleImages in body.
     */
    @GetMapping("")
    public ResponseEntity<List<VehicleImageDTO>> getAllVehicleImages(VehicleImageCriteria criteria) {
        LOG.debug("REST request to get VehicleImages by criteria: {}", criteria);

        List<VehicleImageDTO> entityList = vehicleImageQueryService.findByCriteria(criteria);
        return ResponseEntity.ok().body(entityList);
    }

    /**
     * {@code GET  /vehicle-images/count} : count all the vehicleImages.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/count")
    public ResponseEntity<Long> countVehicleImages(VehicleImageCriteria criteria) {
        LOG.debug("REST request to count VehicleImages by criteria: {}", criteria);
        return ResponseEntity.ok().body(vehicleImageQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /vehicle-images/:id} : get the "id" vehicleImage.
     *
     * @param id the id of the vehicleImageDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the vehicleImageDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<VehicleImageDTO> getVehicleImage(@PathVariable("id") Long id) {
        LOG.debug("REST request to get VehicleImage : {}", id);
        Optional<VehicleImageDTO> vehicleImageDTO = vehicleImageService.findOne(id);
        return ResponseUtil.wrapOrNotFound(vehicleImageDTO);
    }

    /**
     * {@code DELETE  /vehicle-images/:id} : delete the "id" vehicleImage.
     *
     * @param id the id of the vehicleImageDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicleImage(@PathVariable("id") Long id) {
        LOG.debug("REST request to delete VehicleImage : {}", id);
        vehicleImageService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
