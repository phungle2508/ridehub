package com.ridehub.promotion.service.impl;

import com.ridehub.promotion.domain.ConditionLocationItem;
import com.ridehub.promotion.repository.ConditionLocationItemRepository;
import com.ridehub.promotion.service.ConditionLocationItemService;
import com.ridehub.promotion.service.dto.ConditionLocationItemDTO;
import com.ridehub.promotion.service.mapper.ConditionLocationItemMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.ridehub.promotion.domain.ConditionLocationItem}.
 */
@Service
@Transactional
public class ConditionLocationItemServiceImpl implements ConditionLocationItemService {

    private static final Logger LOG = LoggerFactory.getLogger(ConditionLocationItemServiceImpl.class);

    private final ConditionLocationItemRepository conditionLocationItemRepository;

    private final ConditionLocationItemMapper conditionLocationItemMapper;

    public ConditionLocationItemServiceImpl(
        ConditionLocationItemRepository conditionLocationItemRepository,
        ConditionLocationItemMapper conditionLocationItemMapper
    ) {
        this.conditionLocationItemRepository = conditionLocationItemRepository;
        this.conditionLocationItemMapper = conditionLocationItemMapper;
    }

    @Override
    public ConditionLocationItemDTO save(ConditionLocationItemDTO conditionLocationItemDTO) {
        LOG.debug("Request to save ConditionLocationItem : {}", conditionLocationItemDTO);
        ConditionLocationItem conditionLocationItem = conditionLocationItemMapper.toEntity(conditionLocationItemDTO);
        conditionLocationItem = conditionLocationItemRepository.save(conditionLocationItem);
        return conditionLocationItemMapper.toDto(conditionLocationItem);
    }

    @Override
    public ConditionLocationItemDTO update(ConditionLocationItemDTO conditionLocationItemDTO) {
        LOG.debug("Request to update ConditionLocationItem : {}", conditionLocationItemDTO);
        ConditionLocationItem conditionLocationItem = conditionLocationItemMapper.toEntity(conditionLocationItemDTO);
        conditionLocationItem = conditionLocationItemRepository.save(conditionLocationItem);
        return conditionLocationItemMapper.toDto(conditionLocationItem);
    }

    @Override
    public Optional<ConditionLocationItemDTO> partialUpdate(ConditionLocationItemDTO conditionLocationItemDTO) {
        LOG.debug("Request to partially update ConditionLocationItem : {}", conditionLocationItemDTO);

        return conditionLocationItemRepository
            .findById(conditionLocationItemDTO.getId())
            .map(existingConditionLocationItem -> {
                conditionLocationItemMapper.partialUpdate(existingConditionLocationItem, conditionLocationItemDTO);

                return existingConditionLocationItem;
            })
            .map(conditionLocationItemRepository::save)
            .map(conditionLocationItemMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ConditionLocationItemDTO> findOne(Long id) {
        LOG.debug("Request to get ConditionLocationItem : {}", id);
        return conditionLocationItemRepository.findById(id).map(conditionLocationItemMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete ConditionLocationItem : {}", id);
        conditionLocationItemRepository.deleteById(id);
    }
}
