package com.ticketsystem.booking.service.impl;

import com.ticketsystem.booking.domain.BookingHistory;
import com.ticketsystem.booking.repository.BookingHistoryRepository;
import com.ticketsystem.booking.service.BookingHistoryService;
import com.ticketsystem.booking.service.dto.BookingHistoryDTO;
import com.ticketsystem.booking.service.mapper.BookingHistoryMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.ticketsystem.booking.domain.BookingHistory}.
 */
@Service
@Transactional
public class BookingHistoryServiceImpl implements BookingHistoryService {

    private static final Logger LOG = LoggerFactory.getLogger(BookingHistoryServiceImpl.class);

    private final BookingHistoryRepository bookingHistoryRepository;

    private final BookingHistoryMapper bookingHistoryMapper;

    public BookingHistoryServiceImpl(BookingHistoryRepository bookingHistoryRepository, BookingHistoryMapper bookingHistoryMapper) {
        this.bookingHistoryRepository = bookingHistoryRepository;
        this.bookingHistoryMapper = bookingHistoryMapper;
    }

    @Override
    public BookingHistoryDTO save(BookingHistoryDTO bookingHistoryDTO) {
        LOG.debug("Request to save BookingHistory : {}", bookingHistoryDTO);
        BookingHistory bookingHistory = bookingHistoryMapper.toEntity(bookingHistoryDTO);
        bookingHistory = bookingHistoryRepository.save(bookingHistory);
        return bookingHistoryMapper.toDto(bookingHistory);
    }

    @Override
    public BookingHistoryDTO update(BookingHistoryDTO bookingHistoryDTO) {
        LOG.debug("Request to update BookingHistory : {}", bookingHistoryDTO);
        BookingHistory bookingHistory = bookingHistoryMapper.toEntity(bookingHistoryDTO);
        bookingHistory = bookingHistoryRepository.save(bookingHistory);
        return bookingHistoryMapper.toDto(bookingHistory);
    }

    @Override
    public Optional<BookingHistoryDTO> partialUpdate(BookingHistoryDTO bookingHistoryDTO) {
        LOG.debug("Request to partially update BookingHistory : {}", bookingHistoryDTO);

        return bookingHistoryRepository
            .findById(bookingHistoryDTO.getId())
            .map(existingBookingHistory -> {
                bookingHistoryMapper.partialUpdate(existingBookingHistory, bookingHistoryDTO);

                return existingBookingHistory;
            })
            .map(bookingHistoryRepository::save)
            .map(bookingHistoryMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<BookingHistoryDTO> findOne(Long id) {
        LOG.debug("Request to get BookingHistory : {}", id);
        return bookingHistoryRepository.findById(id).map(bookingHistoryMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete BookingHistory : {}", id);
        bookingHistoryRepository.deleteById(id);
    }
}
