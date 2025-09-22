package com.ridehub.booking.service.impl;

import com.ridehub.booking.domain.PaymentWebhookLog;
import com.ridehub.booking.repository.PaymentWebhookLogRepository;
import com.ridehub.booking.service.PaymentWebhookLogService;
import com.ridehub.booking.service.dto.PaymentWebhookLogDTO;
import com.ridehub.booking.service.mapper.PaymentWebhookLogMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.ridehub.booking.domain.PaymentWebhookLog}.
 */
@Service
@Transactional
public class PaymentWebhookLogServiceImpl implements PaymentWebhookLogService {

    private static final Logger LOG = LoggerFactory.getLogger(PaymentWebhookLogServiceImpl.class);

    private final PaymentWebhookLogRepository paymentWebhookLogRepository;

    private final PaymentWebhookLogMapper paymentWebhookLogMapper;

    public PaymentWebhookLogServiceImpl(
        PaymentWebhookLogRepository paymentWebhookLogRepository,
        PaymentWebhookLogMapper paymentWebhookLogMapper
    ) {
        this.paymentWebhookLogRepository = paymentWebhookLogRepository;
        this.paymentWebhookLogMapper = paymentWebhookLogMapper;
    }

    @Override
    public PaymentWebhookLogDTO save(PaymentWebhookLogDTO paymentWebhookLogDTO) {
        LOG.debug("Request to save PaymentWebhookLog : {}", paymentWebhookLogDTO);
        PaymentWebhookLog paymentWebhookLog = paymentWebhookLogMapper.toEntity(paymentWebhookLogDTO);
        paymentWebhookLog = paymentWebhookLogRepository.save(paymentWebhookLog);
        return paymentWebhookLogMapper.toDto(paymentWebhookLog);
    }

    @Override
    public PaymentWebhookLogDTO update(PaymentWebhookLogDTO paymentWebhookLogDTO) {
        LOG.debug("Request to update PaymentWebhookLog : {}", paymentWebhookLogDTO);
        PaymentWebhookLog paymentWebhookLog = paymentWebhookLogMapper.toEntity(paymentWebhookLogDTO);
        paymentWebhookLog = paymentWebhookLogRepository.save(paymentWebhookLog);
        return paymentWebhookLogMapper.toDto(paymentWebhookLog);
    }

    @Override
    public Optional<PaymentWebhookLogDTO> partialUpdate(PaymentWebhookLogDTO paymentWebhookLogDTO) {
        LOG.debug("Request to partially update PaymentWebhookLog : {}", paymentWebhookLogDTO);

        return paymentWebhookLogRepository
            .findById(paymentWebhookLogDTO.getId())
            .map(existingPaymentWebhookLog -> {
                paymentWebhookLogMapper.partialUpdate(existingPaymentWebhookLog, paymentWebhookLogDTO);

                return existingPaymentWebhookLog;
            })
            .map(paymentWebhookLogRepository::save)
            .map(paymentWebhookLogMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PaymentWebhookLogDTO> findOne(Long id) {
        LOG.debug("Request to get PaymentWebhookLog : {}", id);
        return paymentWebhookLogRepository.findById(id).map(paymentWebhookLogMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete PaymentWebhookLog : {}", id);
        paymentWebhookLogRepository.deleteById(id);
    }
}
