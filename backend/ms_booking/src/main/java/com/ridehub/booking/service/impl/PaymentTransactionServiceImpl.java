package com.ridehub.booking.service.impl;

import com.ridehub.booking.domain.PaymentTransaction;
import com.ridehub.booking.repository.PaymentTransactionRepository;
import com.ridehub.booking.service.PaymentTransactionService;
import com.ridehub.booking.service.dto.PaymentTransactionDTO;
import com.ridehub.booking.service.mapper.PaymentTransactionMapper;
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
 * Service Implementation for managing {@link com.ridehub.booking.domain.PaymentTransaction}.
 */
@Service
@Transactional
public class PaymentTransactionServiceImpl implements PaymentTransactionService {

    private static final Logger LOG = LoggerFactory.getLogger(PaymentTransactionServiceImpl.class);

    private final PaymentTransactionRepository paymentTransactionRepository;

    private final PaymentTransactionMapper paymentTransactionMapper;

    public PaymentTransactionServiceImpl(
        PaymentTransactionRepository paymentTransactionRepository,
        PaymentTransactionMapper paymentTransactionMapper
    ) {
        this.paymentTransactionRepository = paymentTransactionRepository;
        this.paymentTransactionMapper = paymentTransactionMapper;
    }

    @Override
    public PaymentTransactionDTO save(PaymentTransactionDTO paymentTransactionDTO) {
        LOG.debug("Request to save PaymentTransaction : {}", paymentTransactionDTO);
        PaymentTransaction paymentTransaction = paymentTransactionMapper.toEntity(paymentTransactionDTO);
        paymentTransaction = paymentTransactionRepository.save(paymentTransaction);
        return paymentTransactionMapper.toDto(paymentTransaction);
    }

    @Override
    public PaymentTransactionDTO update(PaymentTransactionDTO paymentTransactionDTO) {
        LOG.debug("Request to update PaymentTransaction : {}", paymentTransactionDTO);
        PaymentTransaction paymentTransaction = paymentTransactionMapper.toEntity(paymentTransactionDTO);
        paymentTransaction = paymentTransactionRepository.save(paymentTransaction);
        return paymentTransactionMapper.toDto(paymentTransaction);
    }

    @Override
    public Optional<PaymentTransactionDTO> partialUpdate(PaymentTransactionDTO paymentTransactionDTO) {
        LOG.debug("Request to partially update PaymentTransaction : {}", paymentTransactionDTO);

        return paymentTransactionRepository
            .findById(paymentTransactionDTO.getId())
            .map(existingPaymentTransaction -> {
                paymentTransactionMapper.partialUpdate(existingPaymentTransaction, paymentTransactionDTO);

                return existingPaymentTransaction;
            })
            .map(paymentTransactionRepository::save)
            .map(paymentTransactionMapper::toDto);
    }

    /**
     *  Get all the paymentTransactions where Booking is {@code null}.
     *  @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<PaymentTransactionDTO> findAllWhereBookingIsNull() {
        LOG.debug("Request to get all paymentTransactions where Booking is null");
        return StreamSupport.stream(paymentTransactionRepository.findAll().spliterator(), false)
            .filter(paymentTransaction -> paymentTransaction.getBooking() == null)
            .map(paymentTransactionMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PaymentTransactionDTO> findOne(Long id) {
        LOG.debug("Request to get PaymentTransaction : {}", id);
        return paymentTransactionRepository.findById(id).map(paymentTransactionMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete PaymentTransaction : {}", id);
        paymentTransactionRepository.deleteById(id);
    }
}
