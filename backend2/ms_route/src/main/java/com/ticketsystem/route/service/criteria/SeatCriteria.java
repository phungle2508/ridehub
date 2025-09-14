package com.ticketsystem.route.service.criteria;

import com.ticketsystem.route.domain.enumeration.SeatType;
import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import org.springdoc.core.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.ticketsystem.route.domain.Seat} entity. This class is used
 * in {@link com.ticketsystem.route.web.rest.SeatResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /seats?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class SeatCriteria implements Serializable, Criteria {

    /**
     * Class for filtering SeatType
     */
    public static class SeatTypeFilter extends Filter<SeatType> {

        public SeatTypeFilter() {}

        public SeatTypeFilter(SeatTypeFilter filter) {
            super(filter);
        }

        @Override
        public SeatTypeFilter copy() {
            return new SeatTypeFilter(this);
        }
    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter seatNumber;

    private SeatTypeFilter seatType;

    private StringFilter deck;

    private BigDecimalFilter priceModifier;

    private BooleanFilter isAvailable;

    private LongFilter tripId;

    private Boolean distinct;

    public SeatCriteria() {}

    public SeatCriteria(SeatCriteria other) {
        this.id = other.optionalId().map(LongFilter::copy).orElse(null);
        this.seatNumber = other.optionalSeatNumber().map(StringFilter::copy).orElse(null);
        this.seatType = other.optionalSeatType().map(SeatTypeFilter::copy).orElse(null);
        this.deck = other.optionalDeck().map(StringFilter::copy).orElse(null);
        this.priceModifier = other.optionalPriceModifier().map(BigDecimalFilter::copy).orElse(null);
        this.isAvailable = other.optionalIsAvailable().map(BooleanFilter::copy).orElse(null);
        this.tripId = other.optionalTripId().map(LongFilter::copy).orElse(null);
        this.distinct = other.distinct;
    }

    @Override
    public SeatCriteria copy() {
        return new SeatCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public Optional<LongFilter> optionalId() {
        return Optional.ofNullable(id);
    }

    public LongFilter id() {
        if (id == null) {
            setId(new LongFilter());
        }
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getSeatNumber() {
        return seatNumber;
    }

    public Optional<StringFilter> optionalSeatNumber() {
        return Optional.ofNullable(seatNumber);
    }

    public StringFilter seatNumber() {
        if (seatNumber == null) {
            setSeatNumber(new StringFilter());
        }
        return seatNumber;
    }

    public void setSeatNumber(StringFilter seatNumber) {
        this.seatNumber = seatNumber;
    }

    public SeatTypeFilter getSeatType() {
        return seatType;
    }

    public Optional<SeatTypeFilter> optionalSeatType() {
        return Optional.ofNullable(seatType);
    }

    public SeatTypeFilter seatType() {
        if (seatType == null) {
            setSeatType(new SeatTypeFilter());
        }
        return seatType;
    }

    public void setSeatType(SeatTypeFilter seatType) {
        this.seatType = seatType;
    }

    public StringFilter getDeck() {
        return deck;
    }

    public Optional<StringFilter> optionalDeck() {
        return Optional.ofNullable(deck);
    }

    public StringFilter deck() {
        if (deck == null) {
            setDeck(new StringFilter());
        }
        return deck;
    }

    public void setDeck(StringFilter deck) {
        this.deck = deck;
    }

    public BigDecimalFilter getPriceModifier() {
        return priceModifier;
    }

    public Optional<BigDecimalFilter> optionalPriceModifier() {
        return Optional.ofNullable(priceModifier);
    }

    public BigDecimalFilter priceModifier() {
        if (priceModifier == null) {
            setPriceModifier(new BigDecimalFilter());
        }
        return priceModifier;
    }

    public void setPriceModifier(BigDecimalFilter priceModifier) {
        this.priceModifier = priceModifier;
    }

    public BooleanFilter getIsAvailable() {
        return isAvailable;
    }

    public Optional<BooleanFilter> optionalIsAvailable() {
        return Optional.ofNullable(isAvailable);
    }

    public BooleanFilter isAvailable() {
        if (isAvailable == null) {
            setIsAvailable(new BooleanFilter());
        }
        return isAvailable;
    }

    public void setIsAvailable(BooleanFilter isAvailable) {
        this.isAvailable = isAvailable;
    }

    public LongFilter getTripId() {
        return tripId;
    }

    public Optional<LongFilter> optionalTripId() {
        return Optional.ofNullable(tripId);
    }

    public LongFilter tripId() {
        if (tripId == null) {
            setTripId(new LongFilter());
        }
        return tripId;
    }

    public void setTripId(LongFilter tripId) {
        this.tripId = tripId;
    }

    public Boolean getDistinct() {
        return distinct;
    }

    public Optional<Boolean> optionalDistinct() {
        return Optional.ofNullable(distinct);
    }

    public Boolean distinct() {
        if (distinct == null) {
            setDistinct(true);
        }
        return distinct;
    }

    public void setDistinct(Boolean distinct) {
        this.distinct = distinct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final SeatCriteria that = (SeatCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(seatNumber, that.seatNumber) &&
            Objects.equals(seatType, that.seatType) &&
            Objects.equals(deck, that.deck) &&
            Objects.equals(priceModifier, that.priceModifier) &&
            Objects.equals(isAvailable, that.isAvailable) &&
            Objects.equals(tripId, that.tripId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, seatNumber, seatType, deck, priceModifier, isAvailable, tripId, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SeatCriteria{" +
            optionalId().map(f -> "id=" + f + ", ").orElse("") +
            optionalSeatNumber().map(f -> "seatNumber=" + f + ", ").orElse("") +
            optionalSeatType().map(f -> "seatType=" + f + ", ").orElse("") +
            optionalDeck().map(f -> "deck=" + f + ", ").orElse("") +
            optionalPriceModifier().map(f -> "priceModifier=" + f + ", ").orElse("") +
            optionalIsAvailable().map(f -> "isAvailable=" + f + ", ").orElse("") +
            optionalTripId().map(f -> "tripId=" + f + ", ").orElse("") +
            optionalDistinct().map(f -> "distinct=" + f + ", ").orElse("") +
        "}";
    }
}
