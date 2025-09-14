package com.ticketsystem.route.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ticketsystem.route.domain.enumeration.SeatType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Seat.
 */
@Entity
@Table(name = "seat")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Seat implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "seat_number", nullable = false)
    private String seatNumber;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "seat_type", nullable = false)
    private SeatType seatType;

    @Column(name = "deck")
    private String deck;

    @Column(name = "price_modifier", precision = 21, scale = 2)
    private BigDecimal priceModifier;

    @NotNull
    @Column(name = "is_available", nullable = false)
    private Boolean isAvailable;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = { "seats", "route" }, allowSetters = true)
    private Trip trip;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Seat id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSeatNumber() {
        return this.seatNumber;
    }

    public Seat seatNumber(String seatNumber) {
        this.setSeatNumber(seatNumber);
        return this;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public SeatType getSeatType() {
        return this.seatType;
    }

    public Seat seatType(SeatType seatType) {
        this.setSeatType(seatType);
        return this;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public String getDeck() {
        return this.deck;
    }

    public Seat deck(String deck) {
        this.setDeck(deck);
        return this;
    }

    public void setDeck(String deck) {
        this.deck = deck;
    }

    public BigDecimal getPriceModifier() {
        return this.priceModifier;
    }

    public Seat priceModifier(BigDecimal priceModifier) {
        this.setPriceModifier(priceModifier);
        return this;
    }

    public void setPriceModifier(BigDecimal priceModifier) {
        this.priceModifier = priceModifier;
    }

    public Boolean getIsAvailable() {
        return this.isAvailable;
    }

    public Seat isAvailable(Boolean isAvailable) {
        this.setIsAvailable(isAvailable);
        return this;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Trip getTrip() {
        return this.trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Seat trip(Trip trip) {
        this.setTrip(trip);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Seat)) {
            return false;
        }
        return getId() != null && getId().equals(((Seat) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Seat{" +
            "id=" + getId() +
            ", seatNumber='" + getSeatNumber() + "'" +
            ", seatType='" + getSeatType() + "'" +
            ", deck='" + getDeck() + "'" +
            ", priceModifier=" + getPriceModifier() +
            ", isAvailable='" + getIsAvailable() + "'" +
            "}";
    }
}
