package com.ticketsystem.route.service.impl;

import com.ticketsystem.route.domain.VehicleAmenity;
import com.ticketsystem.route.repository.VehicleAmenityRepository;
import com.ticketsystem.route.service.VehicleAmenityService;
import com.ticketsystem.route.service.dto.VehicleAmenityDTO;
import com.ticketsystem.route.service.mapper.VehicleAmenityMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.ticketsystem.route.domain.VehicleAmenity}.
 */
@Service
@Transactional
public class VehicleAmenityServiceImpl implements VehicleAmenityService {

    private static final Logger LOG = LoggerFactory.getLogger(VehicleAmenityServiceImpl.class);

    private final VehicleAmenityRepository vehicleAmenityRepository;

    private final VehicleAmenityMapper vehicleAmenityMapper;

    public VehicleAmenityServiceImpl(VehicleAmenityRepository vehicleAmenityRepository, VehicleAmenityMapper vehicleAmenityMapper) {
        this.vehicleAmenityRepository = vehicleAmenityRepository;
        this.vehicleAmenityMapper = vehicleAmenityMapper;
    }

    @Override
    public VehicleAmenityDTO save(VehicleAmenityDTO vehicleAmenityDTO) {
        LOG.debug("Request to save VehicleAmenity : {}", vehicleAmenityDTO);
        VehicleAmenity vehicleAmenity = vehicleAmenityMapper.toEntity(vehicleAmenityDTO);
        vehicleAmenity = vehicleAmenityRepository.save(vehicleAmenity);
        return vehicleAmenityMapper.toDto(vehicleAmenity);
    }

    @Override
    public VehicleAmenityDTO update(VehicleAmenityDTO vehicleAmenityDTO) {
        LOG.debug("Request to update VehicleAmenity : {}", vehicleAmenityDTO);
        VehicleAmenity vehicleAmenity = vehicleAmenityMapper.toEntity(vehicleAmenityDTO);
        vehicleAmenity = vehicleAmenityRepository.save(vehicleAmenity);
        return vehicleAmenityMapper.toDto(vehicleAmenity);
    }

    @Override
    public Optional<VehicleAmenityDTO> partialUpdate(VehicleAmenityDTO vehicleAmenityDTO) {
        LOG.debug("Request to partially update VehicleAmenity : {}", vehicleAmenityDTO);

        return vehicleAmenityRepository
            .findById(vehicleAmenityDTO.getId())
            .map(existingVehicleAmenity -> {
                vehicleAmenityMapper.partialUpdate(existingVehicleAmenity, vehicleAmenityDTO);

                return existingVehicleAmenity;
            })
            .map(vehicleAmenityRepository::save)
            .map(vehicleAmenityMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<VehicleAmenityDTO> findOne(Long id) {
        LOG.debug("Request to get VehicleAmenity : {}", id);
        return vehicleAmenityRepository.findById(id).map(vehicleAmenityMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete VehicleAmenity : {}", id);
        vehicleAmenityRepository.deleteById(id);
    }
}
