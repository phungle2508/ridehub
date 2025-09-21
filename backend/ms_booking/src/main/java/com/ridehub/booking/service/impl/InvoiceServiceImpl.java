package com.ridehub.booking.service.impl;

import com.ridehub.booking.domain.Invoice;
import com.ridehub.booking.repository.InvoiceRepository;
import com.ridehub.booking.service.InvoiceService;
import com.ridehub.booking.service.dto.InvoiceDTO;
import com.ridehub.booking.service.mapper.InvoiceMapper;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.ridehub.booking.domain.Invoice}.
 */
@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {

    private static final Logger LOG = LoggerFactory.getLogger(InvoiceServiceImpl.class);

    private final InvoiceRepository invoiceRepository;

    private final InvoiceMapper invoiceMapper;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
    }

    @Override
    public InvoiceDTO save(InvoiceDTO invoiceDTO) {
        LOG.debug("Request to save Invoice : {}", invoiceDTO);
        Invoice invoice = invoiceMapper.toEntity(invoiceDTO);
        invoice = invoiceRepository.save(invoice);
        return invoiceMapper.toDto(invoice);
    }

    @Override
    public InvoiceDTO update(InvoiceDTO invoiceDTO) {
        LOG.debug("Request to update Invoice : {}", invoiceDTO);
        Invoice invoice = invoiceMapper.toEntity(invoiceDTO);
        invoice = invoiceRepository.save(invoice);
        return invoiceMapper.toDto(invoice);
    }

    @Override
    public Optional<InvoiceDTO> partialUpdate(InvoiceDTO invoiceDTO) {
        LOG.debug("Request to partially update Invoice : {}", invoiceDTO);

        return invoiceRepository
            .findById(invoiceDTO.getId())
            .map(existingInvoice -> {
                invoiceMapper.partialUpdate(existingInvoice, invoiceDTO);

                return existingInvoice;
            })
            .map(invoiceRepository::save)
            .map(invoiceMapper::toDto);
    }

    /**
     *  Get all the invoices where Booking is {@code null}.
     *  @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<InvoiceDTO> findAllWhereBookingIsNull() {
        LOG.debug("Request to get all invoices where Booking is null");
        return StreamSupport.stream(invoiceRepository.findAll().spliterator(), false)
            .filter(invoice -> invoice.getBooking() == null)
            .map(invoiceMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<InvoiceDTO> findOne(Long id) {
        LOG.debug("Request to get Invoice : {}", id);
        return invoiceRepository.findById(id).map(invoiceMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete Invoice : {}", id);
        invoiceRepository.deleteById(id);
    }
}
