package com.ridehub.booking.service.mapper;

import com.ridehub.booking.domain.Booking;
import com.ridehub.booking.domain.Invoice;
import com.ridehub.booking.domain.PaymentTransaction;
import com.ridehub.booking.service.dto.BookingDTO;
import com.ridehub.booking.service.dto.InvoiceDTO;
import com.ridehub.booking.service.dto.PaymentTransactionDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Booking} and its DTO {@link BookingDTO}.
 */
@Mapper(componentModel = "spring")
public interface BookingMapper extends EntityMapper<BookingDTO, Booking> {
    @Mapping(target = "invoice", source = "invoice", qualifiedByName = "invoiceId")
    @Mapping(target = "paymentTransaction", source = "paymentTransaction", qualifiedByName = "paymentTransactionId")
    BookingDTO toDto(Booking s);

    @Named("invoiceId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    InvoiceDTO toDtoInvoiceId(Invoice invoice);

    @Named("paymentTransactionId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    PaymentTransactionDTO toDtoPaymentTransactionId(PaymentTransaction paymentTransaction);
}
