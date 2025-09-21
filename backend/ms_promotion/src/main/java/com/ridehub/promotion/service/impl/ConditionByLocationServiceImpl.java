package com.ridehub.promotion.service.impl;

import com.ridehub.promotion.domain.ConditionByLocation;
import com.ridehub.promotion.repository.ConditionByLocationRepository;
import com.ridehub.promotion.service.ConditionByLocationService;
import com.ridehub.promotion.service.dto.ConditionByLocationDTO;
import com.ridehub.promotion.service.mapper.ConditionByLocationMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.ridehub.promotion.domain.ConditionByLocation}.
 */
@Service
@Transactional
public class ConditionByLocationServiceImpl implements ConditionByLocationService {

    private static final Logger LOG = LoggerFactory.getLogger(ConditionByLocationServiceImpl.class);

    private final ConditionByLocationRepository conditionByLocationRepository;

    private final ConditionByLocationMapper conditionByLocationMapper;

    public ConditionByLocationServiceImpl(
        ConditionByLocationRepository conditionByLocationRepository,
        ConditionByLocationMapper conditionByLocationMapper
    ) {
        this.conditionByLocationRepository = conditionByLocationRepository;
        this.conditionByLocationMapper = conditionByLocationMapper;
    }

    @Override
    public ConditionByLocationDTO save(ConditionByLocationDTO conditionByLocationDTO) {
        LOG.debug("Request to save ConditionByLocation : {}", conditionByLocationDTO);
        ConditionByLocation conditionByLocation = conditionByLocationMapper.toEntity(conditionByLocationDTO);
        conditionByLocation = conditionByLocationRepository.save(conditionByLocation);
        return conditionByLocationMapper.toDto(conditionByLocation);
    }

    @Override
    public ConditionByLocationDTO update(ConditionByLocationDTO conditionByLocationDTO) {
        LOG.debug("Request to update ConditionByLocation : {}", conditionByLocationDTO);
        ConditionByLocation conditionByLocation = conditionByLocationMapper.toEntity(conditionByLocationDTO);
        conditionByLocation = conditionByLocationRepository.save(conditionByLocation);
        return conditionByLocationMapper.toDto(conditionByLocation);
    }

    @Override
    public Optional<ConditionByLocationDTO> partialUpdate(ConditionByLocationDTO conditionByLocationDTO) {
        LOG.debug("Request to partially update ConditionByLocation : {}", conditionByLocationDTO);

        return conditionByLocationRepository
            .findById(conditionByLocationDTO.getId())
            .map(existingConditionByLocation -> {
                conditionByLocationMapper.partialUpdate(existingConditionByLocation, conditionByLocationDTO);

                return existingConditionByLocation;
            })
            .map(conditionByLocationRepository::save)
            .map(conditionByLocationMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ConditionByLocationDTO> findOne(Long id) {
        LOG.debug("Request to get ConditionByLocation : {}", id);
        return conditionByLocationRepository.findById(id).map(conditionByLocationMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete ConditionByLocation : {}", id);
        conditionByLocationRepository.deleteById(id);
    }
}
