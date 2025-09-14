package com.ticketsystem.booking.service.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

/**
 * A DTO for the {@link com.ticketsystem.booking.domain.Passenger} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class PassengerDTO implements Serializable {

    private Long id;

    @NotNull
    private UUID seatId;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private String idNumber;

    private LocalDate dateOfBirth;

    private String nationality;

    private String ticketNumber;

    @NotNull
    private BookingDTO booking;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getSeatId() {
        return seatId;
    }

    public void setSeatId(UUID seatId) {
        this.seatId = seatId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public BookingDTO getBooking() {
        return booking;
    }

    public void setBooking(BookingDTO booking) {
        this.booking = booking;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PassengerDTO)) {
            return false;
        }

        PassengerDTO passengerDTO = (PassengerDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, passengerDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PassengerDTO{" +
            "id=" + getId() +
            ", seatId='" + getSeatId() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", idNumber='" + getIdNumber() + "'" +
            ", dateOfBirth='" + getDateOfBirth() + "'" +
            ", nationality='" + getNationality() + "'" +
            ", ticketNumber='" + getTicketNumber() + "'" +
            ", booking=" + getBooking() +
            "}";
    }
}
