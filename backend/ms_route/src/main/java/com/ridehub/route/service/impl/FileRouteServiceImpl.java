package com.ridehub.route.service.impl;

import com.ridehub.route.domain.FileRoute;
import com.ridehub.route.repository.FileRouteRepository;
import com.ridehub.route.service.FileRouteService;
import com.ridehub.route.service.dto.FileRouteDTO;
import com.ridehub.route.service.mapper.FileRouteMapper;
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
 * Service Implementation for managing {@link com.ridehub.route.domain.FileRoute}.
 */
@Service
@Transactional
public class FileRouteServiceImpl implements FileRouteService {

    private static final Logger LOG = LoggerFactory.getLogger(FileRouteServiceImpl.class);

    private final FileRouteRepository fileRouteRepository;

    private final FileRouteMapper fileRouteMapper;

    public FileRouteServiceImpl(FileRouteRepository fileRouteRepository, FileRouteMapper fileRouteMapper) {
        this.fileRouteRepository = fileRouteRepository;
        this.fileRouteMapper = fileRouteMapper;
    }

    @Override
    public FileRouteDTO save(FileRouteDTO fileRouteDTO) {
        LOG.debug("Request to save FileRoute : {}", fileRouteDTO);
        FileRoute fileRoute = fileRouteMapper.toEntity(fileRouteDTO);
        fileRoute = fileRouteRepository.save(fileRoute);
        return fileRouteMapper.toDto(fileRoute);
    }

    @Override
    public FileRouteDTO update(FileRouteDTO fileRouteDTO) {
        LOG.debug("Request to update FileRoute : {}", fileRouteDTO);
        FileRoute fileRoute = fileRouteMapper.toEntity(fileRouteDTO);
        fileRoute = fileRouteRepository.save(fileRoute);
        return fileRouteMapper.toDto(fileRoute);
    }

    @Override
    public Optional<FileRouteDTO> partialUpdate(FileRouteDTO fileRouteDTO) {
        LOG.debug("Request to partially update FileRoute : {}", fileRouteDTO);

        return fileRouteRepository
            .findById(fileRouteDTO.getId())
            .map(existingFileRoute -> {
                fileRouteMapper.partialUpdate(existingFileRoute, fileRouteDTO);

                return existingFileRoute;
            })
            .map(fileRouteRepository::save)
            .map(fileRouteMapper::toDto);
    }

    /**
     *  Get all the fileRoutes where Station is {@code null}.
     *  @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<FileRouteDTO> findAllWhereStationIsNull() {
        LOG.debug("Request to get all fileRoutes where Station is null");
        return StreamSupport.stream(fileRouteRepository.findAll().spliterator(), false)
            .filter(fileRoute -> fileRoute.getStation() == null)
            .map(fileRouteMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     *  Get all the fileRoutes where Vehicle is {@code null}.
     *  @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<FileRouteDTO> findAllWhereVehicleIsNull() {
        LOG.debug("Request to get all fileRoutes where Vehicle is null");
        return StreamSupport.stream(fileRouteRepository.findAll().spliterator(), false)
            .filter(fileRoute -> fileRoute.getVehicle() == null)
            .map(fileRouteMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     *  Get all the fileRoutes where SeatMap is {@code null}.
     *  @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<FileRouteDTO> findAllWhereSeatMapIsNull() {
        LOG.debug("Request to get all fileRoutes where SeatMap is null");
        return StreamSupport.stream(fileRouteRepository.findAll().spliterator(), false)
            .filter(fileRoute -> fileRoute.getSeatMap() == null)
            .map(fileRouteMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<FileRouteDTO> findOne(Long id) {
        LOG.debug("Request to get FileRoute : {}", id);
        return fileRouteRepository.findById(id).map(fileRouteMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete FileRoute : {}", id);
        fileRouteRepository.deleteById(id);
    }
}
