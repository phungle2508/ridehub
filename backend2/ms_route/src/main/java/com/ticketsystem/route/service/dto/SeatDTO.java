package com.ticketsystem.route.service.dto;

import com.ticketsystem.route.domain.enumeration.SeatType;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the {@link com.ticketsystem.route.domain.Seat} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class SeatDTO implements Serializable {

    private Long id;

    @NotNull
    private String seatNumber;

    @NotNull
    private SeatType seatType;

    private String deck;

    private BigDecimal priceModifier;

    @NotNull
    private Boolean isAvailable;

    @NotNull
    private TripDTO trip;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public String getDeck() {
        return deck;
    }

    public void setDeck(String deck) {
        this.deck = deck;
    }

    public BigDecimal getPriceModifier() {
        return priceModifier;
    }

    public void setPriceModifier(BigDecimal priceModifier) {
        this.priceModifier = priceModifier;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public TripDTO getTrip() {
        return trip;
    }

    public void setTrip(TripDTO trip) {
        this.trip = trip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SeatDTO)) {
            return false;
        }

        SeatDTO seatDTO = (SeatDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, seatDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SeatDTO{" +
            "id=" + getId() +
            ", seatNumber='" + getSeatNumber() + "'" +
            ", seatType='" + getSeatType() + "'" +
            ", deck='" + getDeck() + "'" +
            ", priceModifier=" + getPriceModifier() +
            ", isAvailable='" + getIsAvailable() + "'" +
            ", trip=" + getTrip() +
            "}";
    }
}
