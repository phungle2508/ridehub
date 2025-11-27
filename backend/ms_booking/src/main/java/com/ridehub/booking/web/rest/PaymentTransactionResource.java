package com.ridehub.booking.web.rest;

import com.ridehub.booking.repository.PaymentTransactionRepository;
import com.ridehub.booking.service.PaymentTransactionQueryService;
import com.ridehub.booking.service.PaymentTransactionService;
import com.ridehub.booking.service.criteria.PaymentTransactionCriteria;
import com.ridehub.booking.service.dto.PaymentTransactionDTO;
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
 * REST controller for managing {@link com.ridehub.booking.domain.PaymentTransaction}.
 */
@RestController
@RequestMapping("/api/payment-transactions")
public class PaymentTransactionResource {

    private static final Logger LOG = LoggerFactory.getLogger(PaymentTransactionResource.class);

    private static final String ENTITY_NAME = "msBookingPaymentTransaction";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final PaymentTransactionService paymentTransactionService;

    private final PaymentTransactionRepository paymentTransactionRepository;

    private final PaymentTransactionQueryService paymentTransactionQueryService;

    public PaymentTransactionResource(
        PaymentTransactionService paymentTransactionService,
        PaymentTransactionRepository paymentTransactionRepository,
        PaymentTransactionQueryService paymentTransactionQueryService
    ) {
        this.paymentTransactionService = paymentTransactionService;
        this.paymentTransactionRepository = paymentTransactionRepository;
        this.paymentTransactionQueryService = paymentTransactionQueryService;
    }

    /**
     * {@code POST  /payment-transactions} : Create a new paymentTransaction.
     *
     * @param paymentTransactionDTO the paymentTransactionDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new paymentTransactionDTO, or with status {@code 400 (Bad Request)} if the paymentTransaction has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<PaymentTransactionDTO> createPaymentTransaction(@Valid @RequestBody PaymentTransactionDTO paymentTransactionDTO)
        throws URISyntaxException {
        LOG.debug("REST request to save PaymentTransaction : {}", paymentTransactionDTO);
        if (paymentTransactionDTO.getId() != null) {
            throw new BadRequestAlertException("A new paymentTransaction cannot already have an ID", ENTITY_NAME, "idexists");
        }
        paymentTransactionDTO = paymentTransactionService.save(paymentTransactionDTO);
        return ResponseEntity.created(new URI("/api/payment-transactions/" + paymentTransactionDTO.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, paymentTransactionDTO.getId().toString()))
            .body(paymentTransactionDTO);
    }

    /**
     * {@code PUT  /payment-transactions/:id} : Updates an existing paymentTransaction.
     *
     * @param id the id of the paymentTransactionDTO to save.
     * @param paymentTransactionDTO the paymentTransactionDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated paymentTransactionDTO,
     * or with status {@code 400 (Bad Request)} if the paymentTransactionDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the paymentTransactionDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<PaymentTransactionDTO> updatePaymentTransaction(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody PaymentTransactionDTO paymentTransactionDTO
    ) throws URISyntaxException {
        LOG.debug("REST request to update PaymentTransaction : {}, {}", id, paymentTransactionDTO);
        if (paymentTransactionDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, paymentTransactionDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!paymentTransactionRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        paymentTransactionDTO = paymentTransactionService.update(paymentTransactionDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, paymentTransactionDTO.getId().toString()))
            .body(paymentTransactionDTO);
    }

    /**
     * {@code PATCH  /payment-transactions/:id} : Partial updates given fields of an existing paymentTransaction, field will ignore if it is null
     *
     * @param id the id of the paymentTransactionDTO to save.
     * @param paymentTransactionDTO the paymentTransactionDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated paymentTransactionDTO,
     * or with status {@code 400 (Bad Request)} if the paymentTransactionDTO is not valid,
     * or with status {@code 404 (Not Found)} if the paymentTransactionDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the paymentTransactionDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<PaymentTransactionDTO> partialUpdatePaymentTransaction(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody PaymentTransactionDTO paymentTransactionDTO
    ) throws URISyntaxException {
        LOG.debug("REST request to partial update PaymentTransaction partially : {}, {}", id, paymentTransactionDTO);
        if (paymentTransactionDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, paymentTransactionDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!paymentTransactionRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<PaymentTransactionDTO> result = paymentTransactionService.partialUpdate(paymentTransactionDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, paymentTransactionDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /payment-transactions} : get all the paymentTransactions.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of paymentTransactions in body.
     */
    @GetMapping("")
    public ResponseEntity<List<PaymentTransactionDTO>> getAllPaymentTransactions(PaymentTransactionCriteria criteria) {
        LOG.debug("REST request to get PaymentTransactions by criteria: {}", criteria);

        List<PaymentTransactionDTO> entityList = paymentTransactionQueryService.findByCriteria(criteria);
        return ResponseEntity.ok().body(entityList);
    }

    /**
     * {@code GET  /payment-transactions/count} : count all the paymentTransactions.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/count")
    public ResponseEntity<Long> countPaymentTransactions(PaymentTransactionCriteria criteria) {
        LOG.debug("REST request to count PaymentTransactions by criteria: {}", criteria);
        return ResponseEntity.ok().body(paymentTransactionQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /payment-transactions/:id} : get the "id" paymentTransaction.
     *
     * @param id the id of the paymentTransactionDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the paymentTransactionDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<PaymentTransactionDTO> getPaymentTransaction(@PathVariable("id") Long id) {
        LOG.debug("REST request to get PaymentTransaction : {}", id);
        Optional<PaymentTransactionDTO> paymentTransactionDTO = paymentTransactionService.findOne(id);
        return ResponseUtil.wrapOrNotFound(paymentTransactionDTO);
    }

    /**
     * {@code DELETE  /payment-transactions/:id} : delete the "id" paymentTransaction.
     *
     * @param id the id of the paymentTransactionDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaymentTransaction(@PathVariable("id") Long id) {
        LOG.debug("REST request to delete PaymentTransaction : {}", id);
        paymentTransactionService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
