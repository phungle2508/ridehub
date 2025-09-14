package com.ticketsystem.booking.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import org.springdoc.core.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.ticketsystem.booking.domain.Passenger} entity. This class is used
 * in {@link com.ticketsystem.booking.web.rest.PassengerResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /passengers?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class PassengerCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private UUIDFilter seatId;

    private StringFilter firstName;

    private StringFilter lastName;

    private StringFilter idNumber;

    private LocalDateFilter dateOfBirth;

    private StringFilter nationality;

    private StringFilter ticketNumber;

    private LongFilter bookingId;

    private Boolean distinct;

    public PassengerCriteria() {}

    public PassengerCriteria(PassengerCriteria other) {
        this.id = other.optionalId().map(LongFilter::copy).orElse(null);
        this.seatId = other.optionalSeatId().map(UUIDFilter::copy).orElse(null);
        this.firstName = other.optionalFirstName().map(StringFilter::copy).orElse(null);
        this.lastName = other.optionalLastName().map(StringFilter::copy).orElse(null);
        this.idNumber = other.optionalIdNumber().map(StringFilter::copy).orElse(null);
        this.dateOfBirth = other.optionalDateOfBirth().map(LocalDateFilter::copy).orElse(null);
        this.nationality = other.optionalNationality().map(StringFilter::copy).orElse(null);
        this.ticketNumber = other.optionalTicketNumber().map(StringFilter::copy).orElse(null);
        this.bookingId = other.optionalBookingId().map(LongFilter::copy).orElse(null);
        this.distinct = other.distinct;
    }

    @Override
    public PassengerCriteria copy() {
        return new PassengerCriteria(this);
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

    public UUIDFilter getSeatId() {
        return seatId;
    }

    public Optional<UUIDFilter> optionalSeatId() {
        return Optional.ofNullable(seatId);
    }

    public UUIDFilter seatId() {
        if (seatId == null) {
            setSeatId(new UUIDFilter());
        }
        return seatId;
    }

    public void setSeatId(UUIDFilter seatId) {
        this.seatId = seatId;
    }

    public StringFilter getFirstName() {
        return firstName;
    }

    public Optional<StringFilter> optionalFirstName() {
        return Optional.ofNullable(firstName);
    }

    public StringFilter firstName() {
        if (firstName == null) {
            setFirstName(new StringFilter());
        }
        return firstName;
    }

    public void setFirstName(StringFilter firstName) {
        this.firstName = firstName;
    }

    public StringFilter getLastName() {
        return lastName;
    }

    public Optional<StringFilter> optionalLastName() {
        return Optional.ofNullable(lastName);
    }

    public StringFilter lastName() {
        if (lastName == null) {
            setLastName(new StringFilter());
        }
        return lastName;
    }

    public void setLastName(StringFilter lastName) {
        this.lastName = lastName;
    }

    public StringFilter getIdNumber() {
        return idNumber;
    }

    public Optional<StringFilter> optionalIdNumber() {
        return Optional.ofNullable(idNumber);
    }

    public StringFilter idNumber() {
        if (idNumber == null) {
            setIdNumber(new StringFilter());
        }
        return idNumber;
    }

    public void setIdNumber(StringFilter idNumber) {
        this.idNumber = idNumber;
    }

    public LocalDateFilter getDateOfBirth() {
        return dateOfBirth;
    }

    public Optional<LocalDateFilter> optionalDateOfBirth() {
        return Optional.ofNullable(dateOfBirth);
    }

    public LocalDateFilter dateOfBirth() {
        if (dateOfBirth == null) {
            setDateOfBirth(new LocalDateFilter());
        }
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateFilter dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public StringFilter getNationality() {
        return nationality;
    }

    public Optional<StringFilter> optionalNationality() {
        return Optional.ofNullable(nationality);
    }

    public StringFilter nationality() {
        if (nationality == null) {
            setNationality(new StringFilter());
        }
        return nationality;
    }

    public void setNationality(StringFilter nationality) {
        this.nationality = nationality;
    }

    public StringFilter getTicketNumber() {
        return ticketNumber;
    }

    public Optional<StringFilter> optionalTicketNumber() {
        return Optional.ofNullable(ticketNumber);
    }

    public StringFilter ticketNumber() {
        if (ticketNumber == null) {
            setTicketNumber(new StringFilter());
        }
        return ticketNumber;
    }

    public void setTicketNumber(StringFilter ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public LongFilter getBookingId() {
        return bookingId;
    }

    public Optional<LongFilter> optionalBookingId() {
        return Optional.ofNullable(bookingId);
    }

    public LongFilter bookingId() {
        if (bookingId == null) {
            setBookingId(new LongFilter());
        }
        return bookingId;
    }

    public void setBookingId(LongFilter bookingId) {
        this.bookingId = bookingId;
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
        final PassengerCriteria that = (PassengerCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(seatId, that.seatId) &&
            Objects.equals(firstName, that.firstName) &&
            Objects.equals(lastName, that.lastName) &&
            Objects.equals(idNumber, that.idNumber) &&
            Objects.equals(dateOfBirth, that.dateOfBirth) &&
            Objects.equals(nationality, that.nationality) &&
            Objects.equals(ticketNumber, that.ticketNumber) &&
            Objects.equals(bookingId, that.bookingId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, seatId, firstName, lastName, idNumber, dateOfBirth, nationality, ticketNumber, bookingId, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PassengerCriteria{" +
            optionalId().map(f -> "id=" + f + ", ").orElse("") +
            optionalSeatId().map(f -> "seatId=" + f + ", ").orElse("") +
            optionalFirstName().map(f -> "firstName=" + f + ", ").orElse("") +
            optionalLastName().map(f -> "lastName=" + f + ", ").orElse("") +
            optionalIdNumber().map(f -> "idNumber=" + f + ", ").orElse("") +
            optionalDateOfBirth().map(f -> "dateOfBirth=" + f + ", ").orElse("") +
            optionalNationality().map(f -> "nationality=" + f + ", ").orElse("") +
            optionalTicketNumber().map(f -> "ticketNumber=" + f + ", ").orElse("") +
            optionalBookingId().map(f -> "bookingId=" + f + ", ").orElse("") +
            optionalDistinct().map(f -> "distinct=" + f + ", ").orElse("") +
        "}";
    }
}
