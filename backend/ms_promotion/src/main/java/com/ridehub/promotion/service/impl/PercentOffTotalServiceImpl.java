package com.ridehub.promotion.service.impl;

import com.ridehub.promotion.domain.PercentOffTotal;
import com.ridehub.promotion.repository.PercentOffTotalRepository;
import com.ridehub.promotion.service.PercentOffTotalService;
import com.ridehub.promotion.service.dto.PercentOffTotalDTO;
import com.ridehub.promotion.service.mapper.PercentOffTotalMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.ridehub.promotion.domain.PercentOffTotal}.
 */
@Service
@Transactional
public class PercentOffTotalServiceImpl implements PercentOffTotalService {

    private static final Logger LOG = LoggerFactory.getLogger(PercentOffTotalServiceImpl.class);

    private final PercentOffTotalRepository percentOffTotalRepository;

    private final PercentOffTotalMapper percentOffTotalMapper;

    public PercentOffTotalServiceImpl(PercentOffTotalRepository percentOffTotalRepository, PercentOffTotalMapper percentOffTotalMapper) {
        this.percentOffTotalRepository = percentOffTotalRepository;
        this.percentOffTotalMapper = percentOffTotalMapper;
    }

    @Override
    public PercentOffTotalDTO save(PercentOffTotalDTO percentOffTotalDTO) {
        LOG.debug("Request to save PercentOffTotal : {}", percentOffTotalDTO);
        PercentOffTotal percentOffTotal = percentOffTotalMapper.toEntity(percentOffTotalDTO);
        percentOffTotal = percentOffTotalRepository.save(percentOffTotal);
        return percentOffTotalMapper.toDto(percentOffTotal);
    }

    @Override
    public PercentOffTotalDTO update(PercentOffTotalDTO percentOffTotalDTO) {
        LOG.debug("Request to update PercentOffTotal : {}", percentOffTotalDTO);
        PercentOffTotal percentOffTotal = percentOffTotalMapper.toEntity(percentOffTotalDTO);
        percentOffTotal = percentOffTotalRepository.save(percentOffTotal);
        return percentOffTotalMapper.toDto(percentOffTotal);
    }

    @Override
    public Optional<PercentOffTotalDTO> partialUpdate(PercentOffTotalDTO percentOffTotalDTO) {
        LOG.debug("Request to partially update PercentOffTotal : {}", percentOffTotalDTO);

        return percentOffTotalRepository
            .findById(percentOffTotalDTO.getId())
            .map(existingPercentOffTotal -> {
                percentOffTotalMapper.partialUpdate(existingPercentOffTotal, percentOffTotalDTO);

                return existingPercentOffTotal;
            })
            .map(percentOffTotalRepository::save)
            .map(percentOffTotalMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PercentOffTotalDTO> findOne(Long id) {
        LOG.debug("Request to get PercentOffTotal : {}", id);
        return percentOffTotalRepository.findById(id).map(percentOffTotalMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete PercentOffTotal : {}", id);
        percentOffTotalRepository.deleteById(id);
    }
}
