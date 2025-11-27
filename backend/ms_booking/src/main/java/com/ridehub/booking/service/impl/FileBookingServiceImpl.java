package com.ridehub.booking.service.impl;

import com.ridehub.booking.domain.FileBooking;
import com.ridehub.booking.repository.FileBookingRepository;
import com.ridehub.booking.service.FileBookingService;
import com.ridehub.booking.service.dto.FileBookingDTO;
import com.ridehub.booking.service.mapper.FileBookingMapper;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.ridehub.booking.domain.FileBooking}.
 */
@Service
@Transactional
public class FileBookingServiceImpl implements FileBookingService {

    private static final Logger LOG = LoggerFactory.getLogger(FileBookingServiceImpl.class);

    private final FileBookingRepository fileBookingRepository;

    private final FileBookingMapper fileBookingMapper;

    public FileBookingServiceImpl(FileBookingRepository fileBookingRepository, FileBookingMapper fileBookingMapper) {
        this.fileBookingRepository = fileBookingRepository;
        this.fileBookingMapper = fileBookingMapper;
    }

    @Override
    public FileBookingDTO save(FileBookingDTO fileBookingDTO) {
        LOG.debug("Request to save FileBooking : {}", fileBookingDTO);
        FileBooking fileBooking = fileBookingMapper.toEntity(fileBookingDTO);
        fileBooking = fileBookingRepository.save(fileBooking);
        return fileBookingMapper.toDto(fileBooking);
    }

    @Override
    public FileBookingDTO update(FileBookingDTO fileBookingDTO) {
        LOG.debug("Request to update FileBooking : {}", fileBookingDTO);
        FileBooking fileBooking = fileBookingMapper.toEntity(fileBookingDTO);
        fileBooking = fileBookingRepository.save(fileBooking);
        return fileBookingMapper.toDto(fileBooking);
    }

    @Override
    public Optional<FileBookingDTO> partialUpdate(FileBookingDTO fileBookingDTO) {
        LOG.debug("Request to partially update FileBooking : {}", fileBookingDTO);

        return fileBookingRepository
            .findById(fileBookingDTO.getId())
            .map(existingFileBooking -> {
                fileBookingMapper.partialUpdate(existingFileBooking, fileBookingDTO);

                return existingFileBooking;
            })
            .map(fileBookingRepository::save)
            .map(fileBookingMapper::toDto);
    }

    /**
     *  Get all the fileBookings where Ticket is {@code null}.
     *  @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<FileBookingDTO> findAllWhereTicketIsNull() {
        LOG.debug("Request to get all fileBookings where Ticket is null");
        return StreamSupport.stream(fileBookingRepository.findAll().spliterator(), false)
            .filter(fileBooking -> fileBooking.getTicket() == null)
            .map(fileBookingMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<FileBookingDTO> findOne(Long id) {
        LOG.debug("Request to get FileBooking : {}", id);
        return fileBookingRepository.findById(id).map(fileBookingMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete FileBooking : {}", id);
        fileBookingRepository.deleteById(id);
    }
}
