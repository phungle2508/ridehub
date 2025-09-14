package com.ticketsystem.route.service.impl;

import com.ticketsystem.route.domain.VehicleImage;
import com.ticketsystem.route.repository.VehicleImageRepository;
import com.ticketsystem.route.service.VehicleImageService;
import com.ticketsystem.route.service.dto.VehicleImageDTO;
import com.ticketsystem.route.service.mapper.VehicleImageMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.ticketsystem.route.domain.VehicleImage}.
 */
@Service
@Transactional
public class VehicleImageServiceImpl implements VehicleImageService {

    private static final Logger LOG = LoggerFactory.getLogger(VehicleImageServiceImpl.class);

    private final VehicleImageRepository vehicleImageRepository;

    private final VehicleImageMapper vehicleImageMapper;

    public VehicleImageServiceImpl(VehicleImageRepository vehicleImageRepository, VehicleImageMapper vehicleImageMapper) {
        this.vehicleImageRepository = vehicleImageRepository;
        this.vehicleImageMapper = vehicleImageMapper;
    }

    @Override
    public VehicleImageDTO save(VehicleImageDTO vehicleImageDTO) {
        LOG.debug("Request to save VehicleImage : {}", vehicleImageDTO);
        VehicleImage vehicleImage = vehicleImageMapper.toEntity(vehicleImageDTO);
        vehicleImage = vehicleImageRepository.save(vehicleImage);
        return vehicleImageMapper.toDto(vehicleImage);
    }

    @Override
    public VehicleImageDTO update(VehicleImageDTO vehicleImageDTO) {
        LOG.debug("Request to update VehicleImage : {}", vehicleImageDTO);
        VehicleImage vehicleImage = vehicleImageMapper.toEntity(vehicleImageDTO);
        vehicleImage = vehicleImageRepository.save(vehicleImage);
        return vehicleImageMapper.toDto(vehicleImage);
    }

    @Override
    public Optional<VehicleImageDTO> partialUpdate(VehicleImageDTO vehicleImageDTO) {
        LOG.debug("Request to partially update VehicleImage : {}", vehicleImageDTO);

        return vehicleImageRepository
            .findById(vehicleImageDTO.getId())
            .map(existingVehicleImage -> {
                vehicleImageMapper.partialUpdate(existingVehicleImage, vehicleImageDTO);

                return existingVehicleImage;
            })
            .map(vehicleImageRepository::save)
            .map(vehicleImageMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<VehicleImageDTO> findOne(Long id) {
        LOG.debug("Request to get VehicleImage : {}", id);
        return vehicleImageRepository.findById(id).map(vehicleImageMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete VehicleImage : {}", id);
        vehicleImageRepository.deleteById(id);
    }
}
