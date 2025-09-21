package com.ridehub.promotion.service.impl;

import com.ridehub.promotion.domain.ConditionRouteItem;
import com.ridehub.promotion.repository.ConditionRouteItemRepository;
import com.ridehub.promotion.service.ConditionRouteItemService;
import com.ridehub.promotion.service.dto.ConditionRouteItemDTO;
import com.ridehub.promotion.service.mapper.ConditionRouteItemMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.ridehub.promotion.domain.ConditionRouteItem}.
 */
@Service
@Transactional
public class ConditionRouteItemServiceImpl implements ConditionRouteItemService {

    private static final Logger LOG = LoggerFactory.getLogger(ConditionRouteItemServiceImpl.class);

    private final ConditionRouteItemRepository conditionRouteItemRepository;

    private final ConditionRouteItemMapper conditionRouteItemMapper;

    public ConditionRouteItemServiceImpl(
        ConditionRouteItemRepository conditionRouteItemRepository,
        ConditionRouteItemMapper conditionRouteItemMapper
    ) {
        this.conditionRouteItemRepository = conditionRouteItemRepository;
        this.conditionRouteItemMapper = conditionRouteItemMapper;
    }

    @Override
    public ConditionRouteItemDTO save(ConditionRouteItemDTO conditionRouteItemDTO) {
        LOG.debug("Request to save ConditionRouteItem : {}", conditionRouteItemDTO);
        ConditionRouteItem conditionRouteItem = conditionRouteItemMapper.toEntity(conditionRouteItemDTO);
        conditionRouteItem = conditionRouteItemRepository.save(conditionRouteItem);
        return conditionRouteItemMapper.toDto(conditionRouteItem);
    }

    @Override
    public ConditionRouteItemDTO update(ConditionRouteItemDTO conditionRouteItemDTO) {
        LOG.debug("Request to update ConditionRouteItem : {}", conditionRouteItemDTO);
        ConditionRouteItem conditionRouteItem = conditionRouteItemMapper.toEntity(conditionRouteItemDTO);
        conditionRouteItem = conditionRouteItemRepository.save(conditionRouteItem);
        return conditionRouteItemMapper.toDto(conditionRouteItem);
    }

    @Override
    public Optional<ConditionRouteItemDTO> partialUpdate(ConditionRouteItemDTO conditionRouteItemDTO) {
        LOG.debug("Request to partially update ConditionRouteItem : {}", conditionRouteItemDTO);

        return conditionRouteItemRepository
            .findById(conditionRouteItemDTO.getId())
            .map(existingConditionRouteItem -> {
                conditionRouteItemMapper.partialUpdate(existingConditionRouteItem, conditionRouteItemDTO);

                return existingConditionRouteItem;
            })
            .map(conditionRouteItemRepository::save)
            .map(conditionRouteItemMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ConditionRouteItemDTO> findOne(Long id) {
        LOG.debug("Request to get ConditionRouteItem : {}", id);
        return conditionRouteItemRepository.findById(id).map(conditionRouteItemMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete ConditionRouteItem : {}", id);
        conditionRouteItemRepository.deleteById(id);
    }
}
