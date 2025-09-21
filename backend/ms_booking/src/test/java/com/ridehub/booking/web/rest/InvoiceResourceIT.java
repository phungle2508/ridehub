package com.ridehub.booking.web.rest;

import static com.ridehub.booking.domain.InvoiceAsserts.*;
import static com.ridehub.booking.web.rest.TestUtil.createUpdateProxyForBean;
import static com.ridehub.booking.web.rest.TestUtil.sameNumber;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ridehub.booking.IntegrationTest;
import com.ridehub.booking.domain.Invoice;
import com.ridehub.booking.repository.InvoiceRepository;
import com.ridehub.booking.service.dto.InvoiceDTO;
import com.ridehub.booking.service.mapper.InvoiceMapper;
import jakarta.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link InvoiceResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class InvoiceResourceIT {

    private static final String DEFAULT_INVOICE_NO = "AAAAAAAAAA";
    private static final String UPDATED_INVOICE_NO = "BBBBBBBBBB";

    private static final Instant DEFAULT_ISSUED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_ISSUED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final BigDecimal DEFAULT_GROSS_AMOUNT = new BigDecimal(1);
    private static final BigDecimal UPDATED_GROSS_AMOUNT = new BigDecimal(2);
    private static final BigDecimal SMALLER_GROSS_AMOUNT = new BigDecimal(1 - 1);

    private static final BigDecimal DEFAULT_VAT_AMOUNT = new BigDecimal(1);
    private static final BigDecimal UPDATED_VAT_AMOUNT = new BigDecimal(2);
    private static final BigDecimal SMALLER_VAT_AMOUNT = new BigDecimal(1 - 1);

    private static final BigDecimal DEFAULT_NET_AMOUNT = new BigDecimal(1);
    private static final BigDecimal UPDATED_NET_AMOUNT = new BigDecimal(2);
    private static final BigDecimal SMALLER_NET_AMOUNT = new BigDecimal(1 - 1);

    private static final Instant DEFAULT_CREATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_UPDATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_UPDATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Boolean DEFAULT_IS_DELETED = false;
    private static final Boolean UPDATED_IS_DELETED = true;

    private static final Instant DEFAULT_DELETED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_DELETED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final UUID DEFAULT_DELETED_BY = UUID.randomUUID();
    private static final UUID UPDATED_DELETED_BY = UUID.randomUUID();

    private static final String ENTITY_API_URL = "/api/invoices";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private InvoiceMapper invoiceMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restInvoiceMockMvc;

    private Invoice invoice;

    private Invoice insertedInvoice;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Invoice createEntity(EntityManager em) {
        Invoice invoice = new Invoice()
            .invoiceNo(DEFAULT_INVOICE_NO)
            .issuedAt(DEFAULT_ISSUED_AT)
            .grossAmount(DEFAULT_GROSS_AMOUNT)
            .vatAmount(DEFAULT_VAT_AMOUNT)
            .netAmount(DEFAULT_NET_AMOUNT)
            .createdAt(DEFAULT_CREATED_AT)
            .updatedAt(DEFAULT_UPDATED_AT)
            .isDeleted(DEFAULT_IS_DELETED)
            .deletedAt(DEFAULT_DELETED_AT)
            .deletedBy(DEFAULT_DELETED_BY);
        return invoice;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Invoice createUpdatedEntity(EntityManager em) {
        Invoice updatedInvoice = new Invoice()
            .invoiceNo(UPDATED_INVOICE_NO)
            .issuedAt(UPDATED_ISSUED_AT)
            .grossAmount(UPDATED_GROSS_AMOUNT)
            .vatAmount(UPDATED_VAT_AMOUNT)
            .netAmount(UPDATED_NET_AMOUNT)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);
        return updatedInvoice;
    }

    @BeforeEach
    void initTest() {
        invoice = createEntity(em);
    }

    @AfterEach
    void cleanup() {
        if (insertedInvoice != null) {
            invoiceRepository.delete(insertedInvoice);
            insertedInvoice = null;
        }
    }

    @Test
    @Transactional
    void createInvoice() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the Invoice
        InvoiceDTO invoiceDTO = invoiceMapper.toDto(invoice);
        var returnedInvoiceDTO = om.readValue(
            restInvoiceMockMvc
                .perform(
                    post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(invoiceDTO))
                )
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            InvoiceDTO.class
        );

        // Validate the Invoice in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        var returnedInvoice = invoiceMapper.toEntity(returnedInvoiceDTO);
        assertInvoiceUpdatableFieldsEquals(returnedInvoice, getPersistedInvoice(returnedInvoice));

        insertedInvoice = returnedInvoice;
    }

    @Test
    @Transactional
    void createInvoiceWithExistingId() throws Exception {
        // Create the Invoice with an existing ID
        invoice.setId(1L);
        InvoiceDTO invoiceDTO = invoiceMapper.toDto(invoice);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restInvoiceMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(invoiceDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Invoice in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkInvoiceNoIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        invoice.setInvoiceNo(null);

        // Create the Invoice, which fails.
        InvoiceDTO invoiceDTO = invoiceMapper.toDto(invoice);

        restInvoiceMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(invoiceDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkCreatedAtIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        invoice.setCreatedAt(null);

        // Create the Invoice, which fails.
        InvoiceDTO invoiceDTO = invoiceMapper.toDto(invoice);

        restInvoiceMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(invoiceDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllInvoices() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        // Get all the invoiceList
        restInvoiceMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(invoice.getId().intValue())))
            .andExpect(jsonPath("$.[*].invoiceNo").value(hasItem(DEFAULT_INVOICE_NO)))
            .andExpect(jsonPath("$.[*].issuedAt").value(hasItem(DEFAULT_ISSUED_AT.toString())))
            .andExpect(jsonPath("$.[*].grossAmount").value(hasItem(sameNumber(DEFAULT_GROSS_AMOUNT))))
            .andExpect(jsonPath("$.[*].vatAmount").value(hasItem(sameNumber(DEFAULT_VAT_AMOUNT))))
            .andExpect(jsonPath("$.[*].netAmount").value(hasItem(sameNumber(DEFAULT_NET_AMOUNT))))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].isDeleted").value(hasItem(DEFAULT_IS_DELETED)))
            .andExpect(jsonPath("$.[*].deletedAt").value(hasItem(DEFAULT_DELETED_AT.toString())))
            .andExpect(jsonPath("$.[*].deletedBy").value(hasItem(DEFAULT_DELETED_BY.toString())));
    }

    @Test
    @Transactional
    void getInvoice() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        // Get the invoice
        restInvoiceMockMvc
            .perform(get(ENTITY_API_URL_ID, invoice.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(invoice.getId().intValue()))
            .andExpect(jsonPath("$.invoiceNo").value(DEFAULT_INVOICE_NO))
            .andExpect(jsonPath("$.issuedAt").value(DEFAULT_ISSUED_AT.toString()))
            .andExpect(jsonPath("$.grossAmount").value(sameNumber(DEFAULT_GROSS_AMOUNT)))
            .andExpect(jsonPath("$.vatAmount").value(sameNumber(DEFAULT_VAT_AMOUNT)))
            .andExpect(jsonPath("$.netAmount").value(sameNumber(DEFAULT_NET_AMOUNT)))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.updatedAt").value(DEFAULT_UPDATED_AT.toString()))
            .andExpect(jsonPath("$.isDeleted").value(DEFAULT_IS_DELETED))
            .andExpect(jsonPath("$.deletedAt").value(DEFAULT_DELETED_AT.toString()))
            .andExpect(jsonPath("$.deletedBy").value(DEFAULT_DELETED_BY.toString()));
    }

    @Test
    @Transactional
    void getInvoicesByIdFiltering() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        Long id = invoice.getId();

        defaultInvoiceFiltering("id.equals=" + id, "id.notEquals=" + id);

        defaultInvoiceFiltering("id.greaterThanOrEqual=" + id, "id.greaterThan=" + id);

        defaultInvoiceFiltering("id.lessThanOrEqual=" + id, "id.lessThan=" + id);
    }

    @Test
    @Transactional
    void getAllInvoicesByInvoiceNoIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        // Get all the invoiceList where invoiceNo equals to
        defaultInvoiceFiltering("invoiceNo.equals=" + DEFAULT_INVOICE_NO, "invoiceNo.equals=" + UPDATED_INVOICE_NO);
    }

    @Test
    @Transactional
    void getAllInvoicesByInvoiceNoIsInShouldWork() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        // Get all the invoiceList where invoiceNo in
        defaultInvoiceFiltering("invoiceNo.in=" + DEFAULT_INVOICE_NO + "," + UPDATED_INVOICE_NO, "invoiceNo.in=" + UPDATED_INVOICE_NO);
    }

    @Test
    @Transactional
    void getAllInvoicesByInvoiceNoIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        // Get all the invoiceList where invoiceNo is not null
        defaultInvoiceFiltering("invoiceNo.specified=true", "invoiceNo.specified=false");
    }

    @Test
    @Transactional
    void getAllInvoicesByInvoiceNoContainsSomething() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        // Get all the invoiceList where invoiceNo contains
        defaultInvoiceFiltering("invoiceNo.contains=" + DEFAULT_INVOICE_NO, "invoiceNo.contains=" + UPDATED_INVOICE_NO);
    }

    @Test
    @Transactional
    void getAllInvoicesByInvoiceNoNotContainsSomething() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        // Get all the invoiceList where invoiceNo does not contain
        defaultInvoiceFiltering("invoiceNo.doesNotContain=" + UPDATED_INVOICE_NO, "invoiceNo.doesNotContain=" + DEFAULT_INVOICE_NO);
    }

    @Test
    @Transactional
    void getAllInvoicesByIssuedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        // Get all the invoiceList where issuedAt equals to
        defaultInvoiceFiltering("issuedAt.equals=" + DEFAULT_ISSUED_AT, "issuedAt.equals=" + UPDATED_ISSUED_AT);
    }

    @Test
    @Transactional
    void getAllInvoicesByIssuedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        // Get all the invoiceList where issuedAt in
        defaultInvoiceFiltering("issuedAt.in=" + DEFAULT_ISSUED_AT + "," + UPDATED_ISSUED_AT, "issuedAt.in=" + UPDATED_ISSUED_AT);
    }

    @Test
    @Transactional
    void getAllInvoicesByIssuedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        // Get all the invoiceList where issuedAt is not null
        defaultInvoiceFiltering("issuedAt.specified=true", "issuedAt.specified=false");
    }

    @Test
    @Transactional
    void getAllInvoicesByGrossAmountIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        // Get all the invoiceList where grossAmount equals to
        defaultInvoiceFiltering("grossAmount.equals=" + DEFAULT_GROSS_AMOUNT, "grossAmount.equals=" + UPDATED_GROSS_AMOUNT);
    }

    @Test
    @Transactional
    void getAllInvoicesByGrossAmountIsInShouldWork() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        // Get all the invoiceList where grossAmount in
        defaultInvoiceFiltering(
            "grossAmount.in=" + DEFAULT_GROSS_AMOUNT + "," + UPDATED_GROSS_AMOUNT,
            "grossAmount.in=" + UPDATED_GROSS_AMOUNT
        );
    }

    @Test
    @Transactional
    void getAllInvoicesByGrossAmountIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        // Get all the invoiceList where grossAmount is not null
        defaultInvoiceFiltering("grossAmount.specified=true", "grossAmount.specified=false");
    }

    @Test
    @Transactional
    void getAllInvoicesByGrossAmountIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        // Get all the invoiceList where grossAmount is greater than or equal to
        defaultInvoiceFiltering(
            "grossAmount.greaterThanOrEqual=" + DEFAULT_GROSS_AMOUNT,
            "grossAmount.greaterThanOrEqual=" + UPDATED_GROSS_AMOUNT
        );
    }

    @Test
    @Transactional
    void getAllInvoicesByGrossAmountIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        // Get all the invoiceList where grossAmount is less than or equal to
        defaultInvoiceFiltering(
            "grossAmount.lessThanOrEqual=" + DEFAULT_GROSS_AMOUNT,
            "grossAmount.lessThanOrEqual=" + SMALLER_GROSS_AMOUNT
        );
    }

    @Test
    @Transactional
    void getAllInvoicesByGrossAmountIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        // Get all the invoiceList where grossAmount is less than
        defaultInvoiceFiltering("grossAmount.lessThan=" + UPDATED_GROSS_AMOUNT, "grossAmount.lessThan=" + DEFAULT_GROSS_AMOUNT);
    }

    @Test
    @Transactional
    void getAllInvoicesByGrossAmountIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        // Get all the invoiceList where grossAmount is greater than
        defaultInvoiceFiltering("grossAmount.greaterThan=" + SMALLER_GROSS_AMOUNT, "grossAmount.greaterThan=" + DEFAULT_GROSS_AMOUNT);
    }

    @Test
    @Transactional
    void getAllInvoicesByVatAmountIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        // Get all the invoiceList where vatAmount equals to
        defaultInvoiceFiltering("vatAmount.equals=" + DEFAULT_VAT_AMOUNT, "vatAmount.equals=" + UPDATED_VAT_AMOUNT);
    }

    @Test
    @Transactional
    void getAllInvoicesByVatAmountIsInShouldWork() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        // Get all the invoiceList where vatAmount in
        defaultInvoiceFiltering("vatAmount.in=" + DEFAULT_VAT_AMOUNT + "," + UPDATED_VAT_AMOUNT, "vatAmount.in=" + UPDATED_VAT_AMOUNT);
    }

    @Test
    @Transactional
    void getAllInvoicesByVatAmountIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        // Get all the invoiceList where vatAmount is not null
        defaultInvoiceFiltering("vatAmount.specified=true", "vatAmount.specified=false");
    }

    @Test
    @Transactional
    void getAllInvoicesByVatAmountIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        // Get all the invoiceList where vatAmount is greater than or equal to
        defaultInvoiceFiltering("vatAmount.greaterThanOrEqual=" + DEFAULT_VAT_AMOUNT, "vatAmount.greaterThanOrEqual=" + UPDATED_VAT_AMOUNT);
    }

    @Test
    @Transactional
    void getAllInvoicesByVatAmountIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        // Get all the invoiceList where vatAmount is less than or equal to
        defaultInvoiceFiltering("vatAmount.lessThanOrEqual=" + DEFAULT_VAT_AMOUNT, "vatAmount.lessThanOrEqual=" + SMALLER_VAT_AMOUNT);
    }

    @Test
    @Transactional
    void getAllInvoicesByVatAmountIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        // Get all the invoiceList where vatAmount is less than
        defaultInvoiceFiltering("vatAmount.lessThan=" + UPDATED_VAT_AMOUNT, "vatAmount.lessThan=" + DEFAULT_VAT_AMOUNT);
    }

    @Test
    @Transactional
    void getAllInvoicesByVatAmountIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        // Get all the invoiceList where vatAmount is greater than
        defaultInvoiceFiltering("vatAmount.greaterThan=" + SMALLER_VAT_AMOUNT, "vatAmount.greaterThan=" + DEFAULT_VAT_AMOUNT);
    }

    @Test
    @Transactional
    void getAllInvoicesByNetAmountIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        // Get all the invoiceList where netAmount equals to
        defaultInvoiceFiltering("netAmount.equals=" + DEFAULT_NET_AMOUNT, "netAmount.equals=" + UPDATED_NET_AMOUNT);
    }

    @Test
    @Transactional
    void getAllInvoicesByNetAmountIsInShouldWork() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        // Get all the invoiceList where netAmount in
        defaultInvoiceFiltering("netAmount.in=" + DEFAULT_NET_AMOUNT + "," + UPDATED_NET_AMOUNT, "netAmount.in=" + UPDATED_NET_AMOUNT);
    }

    @Test
    @Transactional
    void getAllInvoicesByNetAmountIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        // Get all the invoiceList where netAmount is not null
        defaultInvoiceFiltering("netAmount.specified=true", "netAmount.specified=false");
    }

    @Test
    @Transactional
    void getAllInvoicesByNetAmountIsGreaterThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        // Get all the invoiceList where netAmount is greater than or equal to
        defaultInvoiceFiltering("netAmount.greaterThanOrEqual=" + DEFAULT_NET_AMOUNT, "netAmount.greaterThanOrEqual=" + UPDATED_NET_AMOUNT);
    }

    @Test
    @Transactional
    void getAllInvoicesByNetAmountIsLessThanOrEqualToSomething() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        // Get all the invoiceList where netAmount is less than or equal to
        defaultInvoiceFiltering("netAmount.lessThanOrEqual=" + DEFAULT_NET_AMOUNT, "netAmount.lessThanOrEqual=" + SMALLER_NET_AMOUNT);
    }

    @Test
    @Transactional
    void getAllInvoicesByNetAmountIsLessThanSomething() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        // Get all the invoiceList where netAmount is less than
        defaultInvoiceFiltering("netAmount.lessThan=" + UPDATED_NET_AMOUNT, "netAmount.lessThan=" + DEFAULT_NET_AMOUNT);
    }

    @Test
    @Transactional
    void getAllInvoicesByNetAmountIsGreaterThanSomething() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        // Get all the invoiceList where netAmount is greater than
        defaultInvoiceFiltering("netAmount.greaterThan=" + SMALLER_NET_AMOUNT, "netAmount.greaterThan=" + DEFAULT_NET_AMOUNT);
    }

    @Test
    @Transactional
    void getAllInvoicesByCreatedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        // Get all the invoiceList where createdAt equals to
        defaultInvoiceFiltering("createdAt.equals=" + DEFAULT_CREATED_AT, "createdAt.equals=" + UPDATED_CREATED_AT);
    }

    @Test
    @Transactional
    void getAllInvoicesByCreatedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        // Get all the invoiceList where createdAt in
        defaultInvoiceFiltering("createdAt.in=" + DEFAULT_CREATED_AT + "," + UPDATED_CREATED_AT, "createdAt.in=" + UPDATED_CREATED_AT);
    }

    @Test
    @Transactional
    void getAllInvoicesByCreatedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        // Get all the invoiceList where createdAt is not null
        defaultInvoiceFiltering("createdAt.specified=true", "createdAt.specified=false");
    }

    @Test
    @Transactional
    void getAllInvoicesByUpdatedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        // Get all the invoiceList where updatedAt equals to
        defaultInvoiceFiltering("updatedAt.equals=" + DEFAULT_UPDATED_AT, "updatedAt.equals=" + UPDATED_UPDATED_AT);
    }

    @Test
    @Transactional
    void getAllInvoicesByUpdatedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        // Get all the invoiceList where updatedAt in
        defaultInvoiceFiltering("updatedAt.in=" + DEFAULT_UPDATED_AT + "," + UPDATED_UPDATED_AT, "updatedAt.in=" + UPDATED_UPDATED_AT);
    }

    @Test
    @Transactional
    void getAllInvoicesByUpdatedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        // Get all the invoiceList where updatedAt is not null
        defaultInvoiceFiltering("updatedAt.specified=true", "updatedAt.specified=false");
    }

    @Test
    @Transactional
    void getAllInvoicesByIsDeletedIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        // Get all the invoiceList where isDeleted equals to
        defaultInvoiceFiltering("isDeleted.equals=" + DEFAULT_IS_DELETED, "isDeleted.equals=" + UPDATED_IS_DELETED);
    }

    @Test
    @Transactional
    void getAllInvoicesByIsDeletedIsInShouldWork() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        // Get all the invoiceList where isDeleted in
        defaultInvoiceFiltering("isDeleted.in=" + DEFAULT_IS_DELETED + "," + UPDATED_IS_DELETED, "isDeleted.in=" + UPDATED_IS_DELETED);
    }

    @Test
    @Transactional
    void getAllInvoicesByIsDeletedIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        // Get all the invoiceList where isDeleted is not null
        defaultInvoiceFiltering("isDeleted.specified=true", "isDeleted.specified=false");
    }

    @Test
    @Transactional
    void getAllInvoicesByDeletedAtIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        // Get all the invoiceList where deletedAt equals to
        defaultInvoiceFiltering("deletedAt.equals=" + DEFAULT_DELETED_AT, "deletedAt.equals=" + UPDATED_DELETED_AT);
    }

    @Test
    @Transactional
    void getAllInvoicesByDeletedAtIsInShouldWork() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        // Get all the invoiceList where deletedAt in
        defaultInvoiceFiltering("deletedAt.in=" + DEFAULT_DELETED_AT + "," + UPDATED_DELETED_AT, "deletedAt.in=" + UPDATED_DELETED_AT);
    }

    @Test
    @Transactional
    void getAllInvoicesByDeletedAtIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        // Get all the invoiceList where deletedAt is not null
        defaultInvoiceFiltering("deletedAt.specified=true", "deletedAt.specified=false");
    }

    @Test
    @Transactional
    void getAllInvoicesByDeletedByIsEqualToSomething() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        // Get all the invoiceList where deletedBy equals to
        defaultInvoiceFiltering("deletedBy.equals=" + DEFAULT_DELETED_BY, "deletedBy.equals=" + UPDATED_DELETED_BY);
    }

    @Test
    @Transactional
    void getAllInvoicesByDeletedByIsInShouldWork() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        // Get all the invoiceList where deletedBy in
        defaultInvoiceFiltering("deletedBy.in=" + DEFAULT_DELETED_BY + "," + UPDATED_DELETED_BY, "deletedBy.in=" + UPDATED_DELETED_BY);
    }

    @Test
    @Transactional
    void getAllInvoicesByDeletedByIsNullOrNotNull() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        // Get all the invoiceList where deletedBy is not null
        defaultInvoiceFiltering("deletedBy.specified=true", "deletedBy.specified=false");
    }

    private void defaultInvoiceFiltering(String shouldBeFound, String shouldNotBeFound) throws Exception {
        defaultInvoiceShouldBeFound(shouldBeFound);
        defaultInvoiceShouldNotBeFound(shouldNotBeFound);
    }

    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultInvoiceShouldBeFound(String filter) throws Exception {
        restInvoiceMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(invoice.getId().intValue())))
            .andExpect(jsonPath("$.[*].invoiceNo").value(hasItem(DEFAULT_INVOICE_NO)))
            .andExpect(jsonPath("$.[*].issuedAt").value(hasItem(DEFAULT_ISSUED_AT.toString())))
            .andExpect(jsonPath("$.[*].grossAmount").value(hasItem(sameNumber(DEFAULT_GROSS_AMOUNT))))
            .andExpect(jsonPath("$.[*].vatAmount").value(hasItem(sameNumber(DEFAULT_VAT_AMOUNT))))
            .andExpect(jsonPath("$.[*].netAmount").value(hasItem(sameNumber(DEFAULT_NET_AMOUNT))))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].isDeleted").value(hasItem(DEFAULT_IS_DELETED)))
            .andExpect(jsonPath("$.[*].deletedAt").value(hasItem(DEFAULT_DELETED_AT.toString())))
            .andExpect(jsonPath("$.[*].deletedBy").value(hasItem(DEFAULT_DELETED_BY.toString())));

        // Check, that the count call also returns 1
        restInvoiceMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("1"));
    }

    /**
     * Executes the search, and checks that the default entity is not returned.
     */
    private void defaultInvoiceShouldNotBeFound(String filter) throws Exception {
        restInvoiceMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());

        // Check, that the count call also returns 0
        restInvoiceMockMvc
            .perform(get(ENTITY_API_URL + "/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().string("0"));
    }

    @Test
    @Transactional
    void getNonExistingInvoice() throws Exception {
        // Get the invoice
        restInvoiceMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingInvoice() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the invoice
        Invoice updatedInvoice = invoiceRepository.findById(invoice.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedInvoice are not directly saved in db
        em.detach(updatedInvoice);
        updatedInvoice
            .invoiceNo(UPDATED_INVOICE_NO)
            .issuedAt(UPDATED_ISSUED_AT)
            .grossAmount(UPDATED_GROSS_AMOUNT)
            .vatAmount(UPDATED_VAT_AMOUNT)
            .netAmount(UPDATED_NET_AMOUNT)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);
        InvoiceDTO invoiceDTO = invoiceMapper.toDto(updatedInvoice);

        restInvoiceMockMvc
            .perform(
                put(ENTITY_API_URL_ID, invoiceDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(invoiceDTO))
            )
            .andExpect(status().isOk());

        // Validate the Invoice in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedInvoiceToMatchAllProperties(updatedInvoice);
    }

    @Test
    @Transactional
    void putNonExistingInvoice() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        invoice.setId(longCount.incrementAndGet());

        // Create the Invoice
        InvoiceDTO invoiceDTO = invoiceMapper.toDto(invoice);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restInvoiceMockMvc
            .perform(
                put(ENTITY_API_URL_ID, invoiceDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(invoiceDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Invoice in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchInvoice() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        invoice.setId(longCount.incrementAndGet());

        // Create the Invoice
        InvoiceDTO invoiceDTO = invoiceMapper.toDto(invoice);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restInvoiceMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(invoiceDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Invoice in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamInvoice() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        invoice.setId(longCount.incrementAndGet());

        // Create the Invoice
        InvoiceDTO invoiceDTO = invoiceMapper.toDto(invoice);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restInvoiceMockMvc
            .perform(put(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(invoiceDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Invoice in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateInvoiceWithPatch() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the invoice using partial update
        Invoice partialUpdatedInvoice = new Invoice();
        partialUpdatedInvoice.setId(invoice.getId());

        partialUpdatedInvoice
            .invoiceNo(UPDATED_INVOICE_NO)
            .grossAmount(UPDATED_GROSS_AMOUNT)
            .netAmount(UPDATED_NET_AMOUNT)
            .updatedAt(UPDATED_UPDATED_AT)
            .deletedAt(UPDATED_DELETED_AT);

        restInvoiceMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedInvoice.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedInvoice))
            )
            .andExpect(status().isOk());

        // Validate the Invoice in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertInvoiceUpdatableFieldsEquals(createUpdateProxyForBean(partialUpdatedInvoice, invoice), getPersistedInvoice(invoice));
    }

    @Test
    @Transactional
    void fullUpdateInvoiceWithPatch() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the invoice using partial update
        Invoice partialUpdatedInvoice = new Invoice();
        partialUpdatedInvoice.setId(invoice.getId());

        partialUpdatedInvoice
            .invoiceNo(UPDATED_INVOICE_NO)
            .issuedAt(UPDATED_ISSUED_AT)
            .grossAmount(UPDATED_GROSS_AMOUNT)
            .vatAmount(UPDATED_VAT_AMOUNT)
            .netAmount(UPDATED_NET_AMOUNT)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT)
            .isDeleted(UPDATED_IS_DELETED)
            .deletedAt(UPDATED_DELETED_AT)
            .deletedBy(UPDATED_DELETED_BY);

        restInvoiceMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedInvoice.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedInvoice))
            )
            .andExpect(status().isOk());

        // Validate the Invoice in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertInvoiceUpdatableFieldsEquals(partialUpdatedInvoice, getPersistedInvoice(partialUpdatedInvoice));
    }

    @Test
    @Transactional
    void patchNonExistingInvoice() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        invoice.setId(longCount.incrementAndGet());

        // Create the Invoice
        InvoiceDTO invoiceDTO = invoiceMapper.toDto(invoice);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restInvoiceMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, invoiceDTO.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(invoiceDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Invoice in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchInvoice() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        invoice.setId(longCount.incrementAndGet());

        // Create the Invoice
        InvoiceDTO invoiceDTO = invoiceMapper.toDto(invoice);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restInvoiceMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(invoiceDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Invoice in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamInvoice() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        invoice.setId(longCount.incrementAndGet());

        // Create the Invoice
        InvoiceDTO invoiceDTO = invoiceMapper.toDto(invoice);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restInvoiceMockMvc
            .perform(
                patch(ENTITY_API_URL).with(csrf()).contentType("application/merge-patch+json").content(om.writeValueAsBytes(invoiceDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the Invoice in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteInvoice() throws Exception {
        // Initialize the database
        insertedInvoice = invoiceRepository.saveAndFlush(invoice);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the invoice
        restInvoiceMockMvc
            .perform(delete(ENTITY_API_URL_ID, invoice.getId()).with(csrf()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return invoiceRepository.count();
    }

    protected void assertIncrementedRepositoryCount(long countBefore) {
        assertThat(countBefore + 1).isEqualTo(getRepositoryCount());
    }

    protected void assertDecrementedRepositoryCount(long countBefore) {
        assertThat(countBefore - 1).isEqualTo(getRepositoryCount());
    }

    protected void assertSameRepositoryCount(long countBefore) {
        assertThat(countBefore).isEqualTo(getRepositoryCount());
    }

    protected Invoice getPersistedInvoice(Invoice invoice) {
        return invoiceRepository.findById(invoice.getId()).orElseThrow();
    }

    protected void assertPersistedInvoiceToMatchAllProperties(Invoice expectedInvoice) {
        assertInvoiceAllPropertiesEquals(expectedInvoice, getPersistedInvoice(expectedInvoice));
    }

    protected void assertPersistedInvoiceToMatchUpdatableProperties(Invoice expectedInvoice) {
        assertInvoiceAllUpdatablePropertiesEquals(expectedInvoice, getPersistedInvoice(expectedInvoice));
    }
}
