package com.ridehub.route.service.impl;

import com.ridehub.route.domain.Attendant;
import com.ridehub.route.repository.AttendantRepository;
import com.ridehub.route.service.AttendantService;
import com.ridehub.route.service.dto.AttendantDTO;
import com.ridehub.route.service.mapper.AttendantMapper;
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
 * Service Implementation for managing {@link com.ridehub.route.domain.Attendant}.
 */
@Service
@Transactional
public class AttendantServiceImpl implements AttendantService {

    private static final Logger LOG = LoggerFactory.getLogger(AttendantServiceImpl.class);

    private final AttendantRepository attendantRepository;

    private final AttendantMapper attendantMapper;

    public AttendantServiceImpl(AttendantRepository attendantRepository, AttendantMapper attendantMapper) {
        this.attendantRepository = attendantRepository;
        this.attendantMapper = attendantMapper;
    }

    @Override
    public AttendantDTO save(AttendantDTO attendantDTO) {
        LOG.debug("Request to save Attendant : {}", attendantDTO);
        Attendant attendant = attendantMapper.toEntity(attendantDTO);
        attendant = attendantRepository.save(attendant);
        return attendantMapper.toDto(attendant);
    }

    @Override
    public AttendantDTO update(AttendantDTO attendantDTO) {
        LOG.debug("Request to update Attendant : {}", attendantDTO);
        Attendant attendant = attendantMapper.toEntity(attendantDTO);
        attendant = attendantRepository.save(attendant);
        return attendantMapper.toDto(attendant);
    }

    @Override
    public Optional<AttendantDTO> partialUpdate(AttendantDTO attendantDTO) {
        LOG.debug("Request to partially update Attendant : {}", attendantDTO);

        return attendantRepository
            .findById(attendantDTO.getId())
            .map(existingAttendant -> {
                attendantMapper.partialUpdate(existingAttendant, attendantDTO);

                return existingAttendant;
            })
            .map(attendantRepository::save)
            .map(attendantMapper::toDto);
    }

    /**
     *  Get all the attendants where Trip is {@code null}.
     *  @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<AttendantDTO> findAllWhereTripIsNull() {
        LOG.debug("Request to get all attendants where Trip is null");
        return StreamSupport.stream(attendantRepository.findAll().spliterator(), false)
            .filter(attendant -> attendant.getTrip() == null)
            .map(attendantMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<AttendantDTO> findOne(Long id) {
        LOG.debug("Request to get Attendant : {}", id);
        return attendantRepository.findById(id).map(attendantMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete Attendant : {}", id);
        attendantRepository.deleteById(id);
    }
}
