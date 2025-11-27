package com.ridehub.promotion.service.impl;

import com.ridehub.promotion.domain.ConditionDateItem;
import com.ridehub.promotion.repository.ConditionDateItemRepository;
import com.ridehub.promotion.service.ConditionDateItemService;
import com.ridehub.promotion.service.dto.ConditionDateItemDTO;
import com.ridehub.promotion.service.mapper.ConditionDateItemMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.ridehub.promotion.domain.ConditionDateItem}.
 */
@Service
@Transactional
public class ConditionDateItemServiceImpl implements ConditionDateItemService {

    private static final Logger LOG = LoggerFactory.getLogger(ConditionDateItemServiceImpl.class);

    private final ConditionDateItemRepository conditionDateItemRepository;

    private final ConditionDateItemMapper conditionDateItemMapper;

    public ConditionDateItemServiceImpl(
        ConditionDateItemRepository conditionDateItemRepository,
        ConditionDateItemMapper conditionDateItemMapper
    ) {
        this.conditionDateItemRepository = conditionDateItemRepository;
        this.conditionDateItemMapper = conditionDateItemMapper;
    }

    @Override
    public ConditionDateItemDTO save(ConditionDateItemDTO conditionDateItemDTO) {
        LOG.debug("Request to save ConditionDateItem : {}", conditionDateItemDTO);
        ConditionDateItem conditionDateItem = conditionDateItemMapper.toEntity(conditionDateItemDTO);
        conditionDateItem = conditionDateItemRepository.save(conditionDateItem);
        return conditionDateItemMapper.toDto(conditionDateItem);
    }

    @Override
    public ConditionDateItemDTO update(ConditionDateItemDTO conditionDateItemDTO) {
        LOG.debug("Request to update ConditionDateItem : {}", conditionDateItemDTO);
        ConditionDateItem conditionDateItem = conditionDateItemMapper.toEntity(conditionDateItemDTO);
        conditionDateItem = conditionDateItemRepository.save(conditionDateItem);
        return conditionDateItemMapper.toDto(conditionDateItem);
    }

    @Override
    public Optional<ConditionDateItemDTO> partialUpdate(ConditionDateItemDTO conditionDateItemDTO) {
        LOG.debug("Request to partially update ConditionDateItem : {}", conditionDateItemDTO);

        return conditionDateItemRepository
            .findById(conditionDateItemDTO.getId())
            .map(existingConditionDateItem -> {
                conditionDateItemMapper.partialUpdate(existingConditionDateItem, conditionDateItemDTO);

                return existingConditionDateItem;
            })
            .map(conditionDateItemRepository::save)
            .map(conditionDateItemMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ConditionDateItemDTO> findOne(Long id) {
        LOG.debug("Request to get ConditionDateItem : {}", id);
        return conditionDateItemRepository.findById(id).map(conditionDateItemMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete ConditionDateItem : {}", id);
        conditionDateItemRepository.deleteById(id);
    }
}
