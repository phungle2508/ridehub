package com.ridehub.promotion.service.impl;

import com.ridehub.promotion.domain.ConditionByRoute;
import com.ridehub.promotion.repository.ConditionByRouteRepository;
import com.ridehub.promotion.service.ConditionByRouteService;
import com.ridehub.promotion.service.dto.ConditionByRouteDTO;
import com.ridehub.promotion.service.mapper.ConditionByRouteMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.ridehub.promotion.domain.ConditionByRoute}.
 */
@Service
@Transactional
public class ConditionByRouteServiceImpl implements ConditionByRouteService {

    private static final Logger LOG = LoggerFactory.getLogger(ConditionByRouteServiceImpl.class);

    private final ConditionByRouteRepository conditionByRouteRepository;

    private final ConditionByRouteMapper conditionByRouteMapper;

    public ConditionByRouteServiceImpl(
        ConditionByRouteRepository conditionByRouteRepository,
        ConditionByRouteMapper conditionByRouteMapper
    ) {
        this.conditionByRouteRepository = conditionByRouteRepository;
        this.conditionByRouteMapper = conditionByRouteMapper;
    }

    @Override
    public ConditionByRouteDTO save(ConditionByRouteDTO conditionByRouteDTO) {
        LOG.debug("Request to save ConditionByRoute : {}", conditionByRouteDTO);
        ConditionByRoute conditionByRoute = conditionByRouteMapper.toEntity(conditionByRouteDTO);
        conditionByRoute = conditionByRouteRepository.save(conditionByRoute);
        return conditionByRouteMapper.toDto(conditionByRoute);
    }

    @Override
    public ConditionByRouteDTO update(ConditionByRouteDTO conditionByRouteDTO) {
        LOG.debug("Request to update ConditionByRoute : {}", conditionByRouteDTO);
        ConditionByRoute conditionByRoute = conditionByRouteMapper.toEntity(conditionByRouteDTO);
        conditionByRoute = conditionByRouteRepository.save(conditionByRoute);
        return conditionByRouteMapper.toDto(conditionByRoute);
    }

    @Override
    public Optional<ConditionByRouteDTO> partialUpdate(ConditionByRouteDTO conditionByRouteDTO) {
        LOG.debug("Request to partially update ConditionByRoute : {}", conditionByRouteDTO);

        return conditionByRouteRepository
            .findById(conditionByRouteDTO.getId())
            .map(existingConditionByRoute -> {
                conditionByRouteMapper.partialUpdate(existingConditionByRoute, conditionByRouteDTO);

                return existingConditionByRoute;
            })
            .map(conditionByRouteRepository::save)
            .map(conditionByRouteMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ConditionByRouteDTO> findOne(Long id) {
        LOG.debug("Request to get ConditionByRoute : {}", id);
        return conditionByRouteRepository.findById(id).map(conditionByRouteMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete ConditionByRoute : {}", id);
        conditionByRouteRepository.deleteById(id);
    }
}
