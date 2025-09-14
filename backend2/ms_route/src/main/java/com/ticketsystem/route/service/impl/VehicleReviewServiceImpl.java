package com.ticketsystem.route.service.impl;

import com.ticketsystem.route.domain.VehicleReview;
import com.ticketsystem.route.repository.VehicleReviewRepository;
import com.ticketsystem.route.service.VehicleReviewService;
import com.ticketsystem.route.service.dto.VehicleReviewDTO;
import com.ticketsystem.route.service.mapper.VehicleReviewMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.ticketsystem.route.domain.VehicleReview}.
 */
@Service
@Transactional
public class VehicleReviewServiceImpl implements VehicleReviewService {

    private static final Logger LOG = LoggerFactory.getLogger(VehicleReviewServiceImpl.class);

    private final VehicleReviewRepository vehicleReviewRepository;

    private final VehicleReviewMapper vehicleReviewMapper;

    public VehicleReviewServiceImpl(VehicleReviewRepository vehicleReviewRepository, VehicleReviewMapper vehicleReviewMapper) {
        this.vehicleReviewRepository = vehicleReviewRepository;
        this.vehicleReviewMapper = vehicleReviewMapper;
    }

    @Override
    public VehicleReviewDTO save(VehicleReviewDTO vehicleReviewDTO) {
        LOG.debug("Request to save VehicleReview : {}", vehicleReviewDTO);
        VehicleReview vehicleReview = vehicleReviewMapper.toEntity(vehicleReviewDTO);
        vehicleReview = vehicleReviewRepository.save(vehicleReview);
        return vehicleReviewMapper.toDto(vehicleReview);
    }

    @Override
    public VehicleReviewDTO update(VehicleReviewDTO vehicleReviewDTO) {
        LOG.debug("Request to update VehicleReview : {}", vehicleReviewDTO);
        VehicleReview vehicleReview = vehicleReviewMapper.toEntity(vehicleReviewDTO);
        vehicleReview = vehicleReviewRepository.save(vehicleReview);
        return vehicleReviewMapper.toDto(vehicleReview);
    }

    @Override
    public Optional<VehicleReviewDTO> partialUpdate(VehicleReviewDTO vehicleReviewDTO) {
        LOG.debug("Request to partially update VehicleReview : {}", vehicleReviewDTO);

        return vehicleReviewRepository
            .findById(vehicleReviewDTO.getId())
            .map(existingVehicleReview -> {
                vehicleReviewMapper.partialUpdate(existingVehicleReview, vehicleReviewDTO);

                return existingVehicleReview;
            })
            .map(vehicleReviewRepository::save)
            .map(vehicleReviewMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<VehicleReviewDTO> findOne(Long id) {
        LOG.debug("Request to get VehicleReview : {}", id);
        return vehicleReviewRepository.findById(id).map(vehicleReviewMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete VehicleReview : {}", id);
        vehicleReviewRepository.deleteById(id);
    }
}
