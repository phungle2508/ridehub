package com.ridehub.booking.service.mapper;

import com.ridehub.booking.domain.PaymentTransaction;
import com.ridehub.booking.domain.PaymentWebhookLog;
import com.ridehub.booking.service.dto.PaymentTransactionDTO;
import com.ridehub.booking.service.dto.PaymentWebhookLogDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link PaymentWebhookLog} and its DTO {@link PaymentWebhookLogDTO}.
 */
@Mapper(componentModel = "spring")
public interface PaymentWebhookLogMapper extends EntityMapper<PaymentWebhookLogDTO, PaymentWebhookLog> {
    @Mapping(target = "paymentTransaction", source = "paymentTransaction", qualifiedByName = "paymentTransactionId")
    PaymentWebhookLogDTO toDto(PaymentWebhookLog s);

    @Named("paymentTransactionId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    PaymentTransactionDTO toDtoPaymentTransactionId(PaymentTransaction paymentTransaction);
}
