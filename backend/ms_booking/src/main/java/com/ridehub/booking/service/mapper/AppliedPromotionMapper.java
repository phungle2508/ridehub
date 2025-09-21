package com.ridehub.booking.service.mapper;

import com.ridehub.booking.domain.AppliedPromotion;
import com.ridehub.booking.domain.Booking;
import com.ridehub.booking.service.dto.AppliedPromotionDTO;
import com.ridehub.booking.service.dto.BookingDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link AppliedPromotion} and its DTO {@link AppliedPromotionDTO}.
 */
@Mapper(componentModel = "spring")
public interface AppliedPromotionMapper extends EntityMapper<AppliedPromotionDTO, AppliedPromotion> {
    @Mapping(target = "booking", source = "booking", qualifiedByName = "bookingId")
    AppliedPromotionDTO toDto(AppliedPromotion s);

    @Named("bookingId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    BookingDTO toDtoBookingId(Booking booking);
}
