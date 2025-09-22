package com.ridehub.booking.service.mapper;

import com.ridehub.booking.domain.Booking;
import com.ridehub.booking.domain.PricingSnapshot;
import com.ridehub.booking.service.dto.BookingDTO;
import com.ridehub.booking.service.dto.PricingSnapshotDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link PricingSnapshot} and its DTO {@link PricingSnapshotDTO}.
 */
@Mapper(componentModel = "spring")
public interface PricingSnapshotMapper extends EntityMapper<PricingSnapshotDTO, PricingSnapshot> {
    @Mapping(target = "booking", source = "booking", qualifiedByName = "bookingId")
    PricingSnapshotDTO toDto(PricingSnapshot s);

    @Named("bookingId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    BookingDTO toDtoBookingId(Booking booking);
}
