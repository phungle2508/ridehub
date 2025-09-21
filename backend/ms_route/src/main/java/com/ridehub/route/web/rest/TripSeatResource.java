package com.ridehub.route.web.rest;

import com.ridehub.route.repository.TripSeatRepository;
import com.ridehub.route.service.TripSeatQueryService;
import com.ridehub.route.service.TripSeatService;
import com.ridehub.route.service.criteria.TripSeatCriteria;
import com.ridehub.route.service.dto.TripSeatDTO;
import com.ridehub.route.web.rest.errors.BadRequestAlertException;
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
 * REST controller for managing {@link com.ridehub.route.domain.TripSeat}.
 */
@RestController
@RequestMapping("/api/trip-seats")
public class TripSeatResource {

    private static final Logger LOG = LoggerFactory.getLogger(TripSeatResource.class);

    private static final String ENTITY_NAME = "msRouteTripSeat";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final TripSeatService tripSeatService;

    private final TripSeatRepository tripSeatRepository;

    private final TripSeatQueryService tripSeatQueryService;

    public TripSeatResource(
        TripSeatService tripSeatService,
        TripSeatRepository tripSeatRepository,
        TripSeatQueryService tripSeatQueryService
    ) {
        this.tripSeatService = tripSeatService;
        this.tripSeatRepository = tripSeatRepository;
        this.tripSeatQueryService = tripSeatQueryService;
    }

    /**
     * {@code POST  /trip-seats} : Create a new tripSeat.
     *
     * @param tripSeatDTO the tripSeatDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new tripSeatDTO, or with status {@code 400 (Bad Request)} if the tripSeat has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<TripSeatDTO> createTripSeat(@Valid @RequestBody TripSeatDTO tripSeatDTO) throws URISyntaxException {
        LOG.debug("REST request to save TripSeat : {}", tripSeatDTO);
        if (tripSeatDTO.getId() != null) {
            throw new BadRequestAlertException("A new tripSeat cannot already have an ID", ENTITY_NAME, "idexists");
        }
        tripSeatDTO = tripSeatService.save(tripSeatDTO);
        return ResponseEntity.created(new URI("/api/trip-seats/" + tripSeatDTO.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, tripSeatDTO.getId().toString()))
            .body(tripSeatDTO);
    }

    /**
     * {@code PUT  /trip-seats/:id} : Updates an existing tripSeat.
     *
     * @param id the id of the tripSeatDTO to save.
     * @param tripSeatDTO the tripSeatDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated tripSeatDTO,
     * or with status {@code 400 (Bad Request)} if the tripSeatDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the tripSeatDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<TripSeatDTO> updateTripSeat(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody TripSeatDTO tripSeatDTO
    ) throws URISyntaxException {
        LOG.debug("REST request to update TripSeat : {}, {}", id, tripSeatDTO);
        if (tripSeatDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, tripSeatDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!tripSeatRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        tripSeatDTO = tripSeatService.update(tripSeatDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, tripSeatDTO.getId().toString()))
            .body(tripSeatDTO);
    }

    /**
     * {@code PATCH  /trip-seats/:id} : Partial updates given fields of an existing tripSeat, field will ignore if it is null
     *
     * @param id the id of the tripSeatDTO to save.
     * @param tripSeatDTO the tripSeatDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated tripSeatDTO,
     * or with status {@code 400 (Bad Request)} if the tripSeatDTO is not valid,
     * or with status {@code 404 (Not Found)} if the tripSeatDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the tripSeatDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<TripSeatDTO> partialUpdateTripSeat(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody TripSeatDTO tripSeatDTO
    ) throws URISyntaxException {
        LOG.debug("REST request to partial update TripSeat partially : {}, {}", id, tripSeatDTO);
        if (tripSeatDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, tripSeatDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!tripSeatRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<TripSeatDTO> result = tripSeatService.partialUpdate(tripSeatDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, tripSeatDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /trip-seats} : get all the tripSeats.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of tripSeats in body.
     */
    @GetMapping("")
    public ResponseEntity<List<TripSeatDTO>> getAllTripSeats(TripSeatCriteria criteria) {
        LOG.debug("REST request to get TripSeats by criteria: {}", criteria);

        List<TripSeatDTO> entityList = tripSeatQueryService.findByCriteria(criteria);
        return ResponseEntity.ok().body(entityList);
    }

    /**
     * {@code GET  /trip-seats/count} : count all the tripSeats.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/count")
    public ResponseEntity<Long> countTripSeats(TripSeatCriteria criteria) {
        LOG.debug("REST request to count TripSeats by criteria: {}", criteria);
        return ResponseEntity.ok().body(tripSeatQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /trip-seats/:id} : get the "id" tripSeat.
     *
     * @param id the id of the tripSeatDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the tripSeatDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<TripSeatDTO> getTripSeat(@PathVariable("id") Long id) {
        LOG.debug("REST request to get TripSeat : {}", id);
        Optional<TripSeatDTO> tripSeatDTO = tripSeatService.findOne(id);
        return ResponseUtil.wrapOrNotFound(tripSeatDTO);
    }

    /**
     * {@code DELETE  /trip-seats/:id} : delete the "id" tripSeat.
     *
     * @param id the id of the tripSeatDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTripSeat(@PathVariable("id") Long id) {
        LOG.debug("REST request to delete TripSeat : {}", id);
        tripSeatService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
