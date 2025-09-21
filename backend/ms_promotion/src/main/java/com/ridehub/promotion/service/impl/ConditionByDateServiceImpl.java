package com.ridehub.promotion.service.impl;

import com.ridehub.promotion.domain.ConditionByDate;
import com.ridehub.promotion.repository.ConditionByDateRepository;
import com.ridehub.promotion.service.ConditionByDateService;
import com.ridehub.promotion.service.dto.ConditionByDateDTO;
import com.ridehub.promotion.service.mapper.ConditionByDateMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.ridehub.promotion.domain.ConditionByDate}.
 */
@Service
@Transactional
public class ConditionByDateServiceImpl implements ConditionByDateService {

    private static final Logger LOG = LoggerFactory.getLogger(ConditionByDateServiceImpl.class);

    private final ConditionByDateRepository conditionByDateRepository;

    private final ConditionByDateMapper conditionByDateMapper;

    public ConditionByDateServiceImpl(ConditionByDateRepository conditionByDateRepository, ConditionByDateMapper conditionByDateMapper) {
        this.conditionByDateRepository = conditionByDateRepository;
        this.conditionByDateMapper = conditionByDateMapper;
    }

    @Override
    public ConditionByDateDTO save(ConditionByDateDTO conditionByDateDTO) {
        LOG.debug("Request to save ConditionByDate : {}", conditionByDateDTO);
        ConditionByDate conditionByDate = conditionByDateMapper.toEntity(conditionByDateDTO);
        conditionByDate = conditionByDateRepository.save(conditionByDate);
        return conditionByDateMapper.toDto(conditionByDate);
    }

    @Override
    public ConditionByDateDTO update(ConditionByDateDTO conditionByDateDTO) {
        LOG.debug("Request to update ConditionByDate : {}", conditionByDateDTO);
        ConditionByDate conditionByDate = conditionByDateMapper.toEntity(conditionByDateDTO);
        conditionByDate = conditionByDateRepository.save(conditionByDate);
        return conditionByDateMapper.toDto(conditionByDate);
    }

    @Override
    public Optional<ConditionByDateDTO> partialUpdate(ConditionByDateDTO conditionByDateDTO) {
        LOG.debug("Request to partially update ConditionByDate : {}", conditionByDateDTO);

        return conditionByDateRepository
            .findById(conditionByDateDTO.getId())
            .map(existingConditionByDate -> {
                conditionByDateMapper.partialUpdate(existingConditionByDate, conditionByDateDTO);

                return existingConditionByDate;
            })
            .map(conditionByDateRepository::save)
            .map(conditionByDateMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ConditionByDateDTO> findOne(Long id) {
        LOG.debug("Request to get ConditionByDate : {}", id);
        return conditionByDateRepository.findById(id).map(conditionByDateMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete ConditionByDate : {}", id);
        conditionByDateRepository.deleteById(id);
    }
}
