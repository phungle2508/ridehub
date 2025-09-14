package com.ticketsystem.booking.web.rest;

import com.ticketsystem.booking.repository.BookingHistoryRepository;
import com.ticketsystem.booking.service.BookingHistoryQueryService;
import com.ticketsystem.booking.service.BookingHistoryService;
import com.ticketsystem.booking.service.criteria.BookingHistoryCriteria;
import com.ticketsystem.booking.service.dto.BookingHistoryDTO;
import com.ticketsystem.booking.web.rest.errors.BadRequestAlertException;
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
 * REST controller for managing {@link com.ticketsystem.booking.domain.BookingHistory}.
 */
@RestController
@RequestMapping("/api/booking-histories")
public class BookingHistoryResource {

    private static final Logger LOG = LoggerFactory.getLogger(BookingHistoryResource.class);

    private static final String ENTITY_NAME = "msBookingBookingHistory";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final BookingHistoryService bookingHistoryService;

    private final BookingHistoryRepository bookingHistoryRepository;

    private final BookingHistoryQueryService bookingHistoryQueryService;

    public BookingHistoryResource(
        BookingHistoryService bookingHistoryService,
        BookingHistoryRepository bookingHistoryRepository,
        BookingHistoryQueryService bookingHistoryQueryService
    ) {
        this.bookingHistoryService = bookingHistoryService;
        this.bookingHistoryRepository = bookingHistoryRepository;
        this.bookingHistoryQueryService = bookingHistoryQueryService;
    }

    /**
     * {@code POST  /booking-histories} : Create a new bookingHistory.
     *
     * @param bookingHistoryDTO the bookingHistoryDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new bookingHistoryDTO, or with status {@code 400 (Bad Request)} if the bookingHistory has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<BookingHistoryDTO> createBookingHistory(@Valid @RequestBody BookingHistoryDTO bookingHistoryDTO)
        throws URISyntaxException {
        LOG.debug("REST request to save BookingHistory : {}", bookingHistoryDTO);
        if (bookingHistoryDTO.getId() != null) {
            throw new BadRequestAlertException("A new bookingHistory cannot already have an ID", ENTITY_NAME, "idexists");
        }
        bookingHistoryDTO = bookingHistoryService.save(bookingHistoryDTO);
        return ResponseEntity.created(new URI("/api/booking-histories/" + bookingHistoryDTO.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, bookingHistoryDTO.getId().toString()))
            .body(bookingHistoryDTO);
    }

    /**
     * {@code PUT  /booking-histories/:id} : Updates an existing bookingHistory.
     *
     * @param id the id of the bookingHistoryDTO to save.
     * @param bookingHistoryDTO the bookingHistoryDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated bookingHistoryDTO,
     * or with status {@code 400 (Bad Request)} if the bookingHistoryDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the bookingHistoryDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<BookingHistoryDTO> updateBookingHistory(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody BookingHistoryDTO bookingHistoryDTO
    ) throws URISyntaxException {
        LOG.debug("REST request to update BookingHistory : {}, {}", id, bookingHistoryDTO);
        if (bookingHistoryDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, bookingHistoryDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!bookingHistoryRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        bookingHistoryDTO = bookingHistoryService.update(bookingHistoryDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, bookingHistoryDTO.getId().toString()))
            .body(bookingHistoryDTO);
    }

    /**
     * {@code PATCH  /booking-histories/:id} : Partial updates given fields of an existing bookingHistory, field will ignore if it is null
     *
     * @param id the id of the bookingHistoryDTO to save.
     * @param bookingHistoryDTO the bookingHistoryDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated bookingHistoryDTO,
     * or with status {@code 400 (Bad Request)} if the bookingHistoryDTO is not valid,
     * or with status {@code 404 (Not Found)} if the bookingHistoryDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the bookingHistoryDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<BookingHistoryDTO> partialUpdateBookingHistory(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody BookingHistoryDTO bookingHistoryDTO
    ) throws URISyntaxException {
        LOG.debug("REST request to partial update BookingHistory partially : {}, {}", id, bookingHistoryDTO);
        if (bookingHistoryDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, bookingHistoryDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!bookingHistoryRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<BookingHistoryDTO> result = bookingHistoryService.partialUpdate(bookingHistoryDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, bookingHistoryDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /booking-histories} : get all the bookingHistories.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of bookingHistories in body.
     */
    @GetMapping("")
    public ResponseEntity<List<BookingHistoryDTO>> getAllBookingHistories(BookingHistoryCriteria criteria) {
        LOG.debug("REST request to get BookingHistories by criteria: {}", criteria);

        List<BookingHistoryDTO> entityList = bookingHistoryQueryService.findByCriteria(criteria);
        return ResponseEntity.ok().body(entityList);
    }

    /**
     * {@code GET  /booking-histories/count} : count all the bookingHistories.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/count")
    public ResponseEntity<Long> countBookingHistories(BookingHistoryCriteria criteria) {
        LOG.debug("REST request to count BookingHistories by criteria: {}", criteria);
        return ResponseEntity.ok().body(bookingHistoryQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /booking-histories/:id} : get the "id" bookingHistory.
     *
     * @param id the id of the bookingHistoryDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the bookingHistoryDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<BookingHistoryDTO> getBookingHistory(@PathVariable("id") Long id) {
        LOG.debug("REST request to get BookingHistory : {}", id);
        Optional<BookingHistoryDTO> bookingHistoryDTO = bookingHistoryService.findOne(id);
        return ResponseUtil.wrapOrNotFound(bookingHistoryDTO);
    }

    /**
     * {@code DELETE  /booking-histories/:id} : delete the "id" bookingHistory.
     *
     * @param id the id of the bookingHistoryDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookingHistory(@PathVariable("id") Long id) {
        LOG.debug("REST request to delete BookingHistory : {}", id);
        bookingHistoryService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
