package com.ridehub.route.service.impl;

import com.ridehub.route.domain.TripSeat;
import com.ridehub.route.repository.TripSeatRepository;
import com.ridehub.route.service.TripSeatService;
import com.ridehub.route.service.dto.TripSeatDTO;
import com.ridehub.route.service.mapper.TripSeatMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.ridehub.route.domain.TripSeat}.
 */
@Service
@Transactional
public class TripSeatServiceImpl implements TripSeatService {

    private static final Logger LOG = LoggerFactory.getLogger(TripSeatServiceImpl.class);

    private final TripSeatRepository tripSeatRepository;

    private final TripSeatMapper tripSeatMapper;

    public TripSeatServiceImpl(TripSeatRepository tripSeatRepository, TripSeatMapper tripSeatMapper) {
        this.tripSeatRepository = tripSeatRepository;
        this.tripSeatMapper = tripSeatMapper;
    }

    @Override
    public TripSeatDTO save(TripSeatDTO tripSeatDTO) {
        LOG.debug("Request to save TripSeat : {}", tripSeatDTO);
        TripSeat tripSeat = tripSeatMapper.toEntity(tripSeatDTO);
        tripSeat = tripSeatRepository.save(tripSeat);
        return tripSeatMapper.toDto(tripSeat);
    }

    @Override
    public TripSeatDTO update(TripSeatDTO tripSeatDTO) {
        LOG.debug("Request to update TripSeat : {}", tripSeatDTO);
        TripSeat tripSeat = tripSeatMapper.toEntity(tripSeatDTO);
        tripSeat = tripSeatRepository.save(tripSeat);
        return tripSeatMapper.toDto(tripSeat);
    }

    @Override
    public Optional<TripSeatDTO> partialUpdate(TripSeatDTO tripSeatDTO) {
        LOG.debug("Request to partially update TripSeat : {}", tripSeatDTO);

        return tripSeatRepository
            .findById(tripSeatDTO.getId())
            .map(existingTripSeat -> {
                tripSeatMapper.partialUpdate(existingTripSeat, tripSeatDTO);

                return existingTripSeat;
            })
            .map(tripSeatRepository::save)
            .map(tripSeatMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TripSeatDTO> findOne(Long id) {
        LOG.debug("Request to get TripSeat : {}", id);
        return tripSeatRepository.findById(id).map(tripSeatMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete TripSeat : {}", id);
        tripSeatRepository.deleteById(id);
    }
}
