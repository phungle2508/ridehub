package com.ticketsystem.route.web.rest;

import com.ticketsystem.route.repository.VehicleAmenityRepository;
import com.ticketsystem.route.service.VehicleAmenityQueryService;
import com.ticketsystem.route.service.VehicleAmenityService;
import com.ticketsystem.route.service.criteria.VehicleAmenityCriteria;
import com.ticketsystem.route.service.dto.VehicleAmenityDTO;
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
 * REST controller for managing {@link com.ticketsystem.route.domain.VehicleAmenity}.
 */
@RestController
@RequestMapping("/api/vehicle-amenities")
public class VehicleAmenityResource {

    private static final Logger LOG = LoggerFactory.getLogger(VehicleAmenityResource.class);

    private static final String ENTITY_NAME = "msRouteVehicleAmenity";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final VehicleAmenityService vehicleAmenityService;

    private final VehicleAmenityRepository vehicleAmenityRepository;

    private final VehicleAmenityQueryService vehicleAmenityQueryService;

    public VehicleAmenityResource(
        VehicleAmenityService vehicleAmenityService,
        VehicleAmenityRepository vehicleAmenityRepository,
        VehicleAmenityQueryService vehicleAmenityQueryService
    ) {
        this.vehicleAmenityService = vehicleAmenityService;
        this.vehicleAmenityRepository = vehicleAmenityRepository;
        this.vehicleAmenityQueryService = vehicleAmenityQueryService;
    }

    /**
     * {@code POST  /vehicle-amenities} : Create a new vehicleAmenity.
     *
     * @param vehicleAmenityDTO the vehicleAmenityDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new vehicleAmenityDTO, or with status {@code 400 (Bad Request)} if the vehicleAmenity has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<VehicleAmenityDTO> createVehicleAmenity(@Valid @RequestBody VehicleAmenityDTO vehicleAmenityDTO)
        throws URISyntaxException {
        LOG.debug("REST request to save VehicleAmenity : {}", vehicleAmenityDTO);
        if (vehicleAmenityDTO.getId() != null) {
            throw new BadRequestAlertException("A new vehicleAmenity cannot already have an ID", ENTITY_NAME, "idexists");
        }
        vehicleAmenityDTO = vehicleAmenityService.save(vehicleAmenityDTO);
        return ResponseEntity.created(new URI("/api/vehicle-amenities/" + vehicleAmenityDTO.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, vehicleAmenityDTO.getId().toString()))
            .body(vehicleAmenityDTO);
    }

    /**
     * {@code PUT  /vehicle-amenities/:id} : Updates an existing vehicleAmenity.
     *
     * @param id the id of the vehicleAmenityDTO to save.
     * @param vehicleAmenityDTO the vehicleAmenityDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated vehicleAmenityDTO,
     * or with status {@code 400 (Bad Request)} if the vehicleAmenityDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the vehicleAmenityDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<VehicleAmenityDTO> updateVehicleAmenity(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody VehicleAmenityDTO vehicleAmenityDTO
    ) throws URISyntaxException {
        LOG.debug("REST request to update VehicleAmenity : {}, {}", id, vehicleAmenityDTO);
        if (vehicleAmenityDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, vehicleAmenityDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!vehicleAmenityRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        vehicleAmenityDTO = vehicleAmenityService.update(vehicleAmenityDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, vehicleAmenityDTO.getId().toString()))
            .body(vehicleAmenityDTO);
    }

    /**
     * {@code PATCH  /vehicle-amenities/:id} : Partial updates given fields of an existing vehicleAmenity, field will ignore if it is null
     *
     * @param id the id of the vehicleAmenityDTO to save.
     * @param vehicleAmenityDTO the vehicleAmenityDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated vehicleAmenityDTO,
     * or with status {@code 400 (Bad Request)} if the vehicleAmenityDTO is not valid,
     * or with status {@code 404 (Not Found)} if the vehicleAmenityDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the vehicleAmenityDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<VehicleAmenityDTO> partialUpdateVehicleAmenity(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody VehicleAmenityDTO vehicleAmenityDTO
    ) throws URISyntaxException {
        LOG.debug("REST request to partial update VehicleAmenity partially : {}, {}", id, vehicleAmenityDTO);
        if (vehicleAmenityDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, vehicleAmenityDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!vehicleAmenityRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<VehicleAmenityDTO> result = vehicleAmenityService.partialUpdate(vehicleAmenityDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, vehicleAmenityDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /vehicle-amenities} : get all the vehicleAmenities.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of vehicleAmenities in body.
     */
    @GetMapping("")
    public ResponseEntity<List<VehicleAmenityDTO>> getAllVehicleAmenities(VehicleAmenityCriteria criteria) {
        LOG.debug("REST request to get VehicleAmenities by criteria: {}", criteria);

        List<VehicleAmenityDTO> entityList = vehicleAmenityQueryService.findByCriteria(criteria);
        return ResponseEntity.ok().body(entityList);
    }

    /**
     * {@code GET  /vehicle-amenities/count} : count all the vehicleAmenities.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/count")
    public ResponseEntity<Long> countVehicleAmenities(VehicleAmenityCriteria criteria) {
        LOG.debug("REST request to count VehicleAmenities by criteria: {}", criteria);
        return ResponseEntity.ok().body(vehicleAmenityQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /vehicle-amenities/:id} : get the "id" vehicleAmenity.
     *
     * @param id the id of the vehicleAmenityDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the vehicleAmenityDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<VehicleAmenityDTO> getVehicleAmenity(@PathVariable("id") Long id) {
        LOG.debug("REST request to get VehicleAmenity : {}", id);
        Optional<VehicleAmenityDTO> vehicleAmenityDTO = vehicleAmenityService.findOne(id);
        return ResponseUtil.wrapOrNotFound(vehicleAmenityDTO);
    }

    /**
     * {@code DELETE  /vehicle-amenities/:id} : delete the "id" vehicleAmenity.
     *
     * @param id the id of the vehicleAmenityDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicleAmenity(@PathVariable("id") Long id) {
        LOG.debug("REST request to delete VehicleAmenity : {}", id);
        vehicleAmenityService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
