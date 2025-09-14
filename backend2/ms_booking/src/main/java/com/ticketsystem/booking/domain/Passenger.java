package com.ticketsystem.booking.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

/**
 * A Passenger.
 */
@Entity
@Table(name = "passenger")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Passenger implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "seat_id", length = 36, nullable = false)
    private UUID seatId;

    @NotNull
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotNull
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "id_number")
    private String idNumber;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "ticket_number")
    private String ticketNumber;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = { "passengers", "histories" }, allowSetters = true)
    private Booking booking;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Passenger id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getSeatId() {
        return this.seatId;
    }

    public Passenger seatId(UUID seatId) {
        this.setSeatId(seatId);
        return this;
    }

    public void setSeatId(UUID seatId) {
        this.seatId = seatId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public Passenger firstName(String firstName) {
        this.setFirstName(firstName);
        return this;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Passenger lastName(String lastName) {
        this.setLastName(lastName);
        return this;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdNumber() {
        return this.idNumber;
    }

    public Passenger idNumber(String idNumber) {
        this.setIdNumber(idNumber);
        return this;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public Passenger dateOfBirth(LocalDate dateOfBirth) {
        this.setDateOfBirth(dateOfBirth);
        return this;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return this.nationality;
    }

    public Passenger nationality(String nationality) {
        this.setNationality(nationality);
        return this;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getTicketNumber() {
        return this.ticketNumber;
    }

    public Passenger ticketNumber(String ticketNumber) {
        this.setTicketNumber(ticketNumber);
        return this;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public Booking getBooking() {
        return this.booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Passenger booking(Booking booking) {
        this.setBooking(booking);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Passenger)) {
            return false;
        }
        return getId() != null && getId().equals(((Passenger) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Passenger{" +
            "id=" + getId() +
            ", seatId='" + getSeatId() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", idNumber='" + getIdNumber() + "'" +
            ", dateOfBirth='" + getDateOfBirth() + "'" +
            ", nationality='" + getNationality() + "'" +
            ", ticketNumber='" + getTicketNumber() + "'" +
            "}";
    }
}
