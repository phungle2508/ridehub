package com.ticketsystem.booking.service.impl;

import com.ticketsystem.booking.domain.Passenger;
import com.ticketsystem.booking.repository.PassengerRepository;
import com.ticketsystem.booking.service.PassengerService;
import com.ticketsystem.booking.service.dto.PassengerDTO;
import com.ticketsystem.booking.service.mapper.PassengerMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.ticketsystem.booking.domain.Passenger}.
 */
@Service
@Transactional
public class PassengerServiceImpl implements PassengerService {

    private static final Logger LOG = LoggerFactory.getLogger(PassengerServiceImpl.class);

    private final PassengerRepository passengerRepository;

    private final PassengerMapper passengerMapper;

    public PassengerServiceImpl(PassengerRepository passengerRepository, PassengerMapper passengerMapper) {
        this.passengerRepository = passengerRepository;
        this.passengerMapper = passengerMapper;
    }

    @Override
    public PassengerDTO save(PassengerDTO passengerDTO) {
        LOG.debug("Request to save Passenger : {}", passengerDTO);
        Passenger passenger = passengerMapper.toEntity(passengerDTO);
        passenger = passengerRepository.save(passenger);
        return passengerMapper.toDto(passenger);
    }

    @Override
    public PassengerDTO update(PassengerDTO passengerDTO) {
        LOG.debug("Request to update Passenger : {}", passengerDTO);
        Passenger passenger = passengerMapper.toEntity(passengerDTO);
        passenger = passengerRepository.save(passenger);
        return passengerMapper.toDto(passenger);
    }

    @Override
    public Optional<PassengerDTO> partialUpdate(PassengerDTO passengerDTO) {
        LOG.debug("Request to partially update Passenger : {}", passengerDTO);

        return passengerRepository
            .findById(passengerDTO.getId())
            .map(existingPassenger -> {
                passengerMapper.partialUpdate(existingPassenger, passengerDTO);

                return existingPassenger;
            })
            .map(passengerRepository::save)
            .map(passengerMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PassengerDTO> findOne(Long id) {
        LOG.debug("Request to get Passenger : {}", id);
        return passengerRepository.findById(id).map(passengerMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete Passenger : {}", id);
        passengerRepository.deleteById(id);
    }
}
