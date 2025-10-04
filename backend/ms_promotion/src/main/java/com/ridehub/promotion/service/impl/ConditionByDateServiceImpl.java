package com.ridehub.promotion.service.impl;

import com.ridehub.promotion.domain.ConditionByDate;
import com.ridehub.promotion.domain.ConditionDateItem;
import com.ridehub.promotion.repository.ConditionByDateRepository;
import com.ridehub.promotion.service.ConditionByDateService;
import com.ridehub.promotion.service.dto.ConditionByDateDTO;
import com.ridehub.promotion.service.mapper.ConditionByDateMapper;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.time.Instant;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing
 * {@link com.ridehub.promotion.domain.ConditionByDate}.
 */
@Service
@Transactional
public class ConditionByDateServiceImpl implements ConditionByDateService {

    private static final Logger LOG = LoggerFactory.getLogger(ConditionByDateServiceImpl.class);

    private final ConditionByDateRepository conditionByDateRepository;

    private final ConditionByDateMapper conditionByDateMapper;
    
    @PersistenceContext
    private EntityManager em;

    public ConditionByDateServiceImpl(ConditionByDateRepository conditionByDateRepository,
            ConditionByDateMapper conditionByDateMapper) {
        this.conditionByDateRepository = conditionByDateRepository;
        this.conditionByDateMapper = conditionByDateMapper;
    }

    @Override
    @Transactional
    public ConditionByDateDTO save(ConditionByDateDTO dto) {
        LOG.debug("Request to save ConditionByDate : {}", dto);

        // 1) Map DTO -> Entity
        ConditionByDate parent = conditionByDateMapper.toEntity(dto);

        // 2) Link back-ref + default timestamps
        if (parent.getItems() != null) {
            for (ConditionDateItem it : parent.getItems()) {
                it.setCondition(parent); // FK
                if (it.getCreatedAt() == null) {
                    it.setCreatedAt(Instant.now());
                }
            }
        }

        // 3) Save parent (no cascade available)
        parent = conditionByDateRepository.saveAndFlush(parent);

        // 4) Manually persist/merge children
        if (parent.getItems() != null) {
            for (ConditionDateItem it : parent.getItems()) {
                it.setCondition(parent); // ensure managed parent FK
                if (it.getId() == null) {
                    em.persist(it); // INSERT
                } else {
                    em.merge(it); // UPDATE
                }
            }
        }
        em.flush();

        // 5) Reload to ensure child IDs are visible
        ConditionByDate reloaded = conditionByDateRepository.findById(parent.getId()).orElse(parent);

        return conditionByDateMapper.toDto(reloaded);
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
