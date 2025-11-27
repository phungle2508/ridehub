package com.ridehub.booking.service.impl;

import com.ridehub.booking.domain.PricingSnapshot;
import com.ridehub.booking.repository.PricingSnapshotRepository;
import com.ridehub.booking.service.PricingSnapshotService;
import com.ridehub.booking.service.dto.PricingSnapshotDTO;
import com.ridehub.booking.service.mapper.PricingSnapshotMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.ridehub.booking.domain.PricingSnapshot}.
 */
@Service
@Transactional
public class PricingSnapshotServiceImpl implements PricingSnapshotService {

    private static final Logger LOG = LoggerFactory.getLogger(PricingSnapshotServiceImpl.class);

    private final PricingSnapshotRepository pricingSnapshotRepository;

    private final PricingSnapshotMapper pricingSnapshotMapper;

    public PricingSnapshotServiceImpl(PricingSnapshotRepository pricingSnapshotRepository, PricingSnapshotMapper pricingSnapshotMapper) {
        this.pricingSnapshotRepository = pricingSnapshotRepository;
        this.pricingSnapshotMapper = pricingSnapshotMapper;
    }

    @Override
    public PricingSnapshotDTO save(PricingSnapshotDTO pricingSnapshotDTO) {
        LOG.debug("Request to save PricingSnapshot : {}", pricingSnapshotDTO);
        PricingSnapshot pricingSnapshot = pricingSnapshotMapper.toEntity(pricingSnapshotDTO);
        pricingSnapshot = pricingSnapshotRepository.save(pricingSnapshot);
        return pricingSnapshotMapper.toDto(pricingSnapshot);
    }

    @Override
    public PricingSnapshotDTO update(PricingSnapshotDTO pricingSnapshotDTO) {
        LOG.debug("Request to update PricingSnapshot : {}", pricingSnapshotDTO);
        PricingSnapshot pricingSnapshot = pricingSnapshotMapper.toEntity(pricingSnapshotDTO);
        pricingSnapshot = pricingSnapshotRepository.save(pricingSnapshot);
        return pricingSnapshotMapper.toDto(pricingSnapshot);
    }

    @Override
    public Optional<PricingSnapshotDTO> partialUpdate(PricingSnapshotDTO pricingSnapshotDTO) {
        LOG.debug("Request to partially update PricingSnapshot : {}", pricingSnapshotDTO);

        return pricingSnapshotRepository
            .findById(pricingSnapshotDTO.getId())
            .map(existingPricingSnapshot -> {
                pricingSnapshotMapper.partialUpdate(existingPricingSnapshot, pricingSnapshotDTO);

                return existingPricingSnapshot;
            })
            .map(pricingSnapshotRepository::save)
            .map(pricingSnapshotMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PricingSnapshotDTO> findOne(Long id) {
        LOG.debug("Request to get PricingSnapshot : {}", id);
        return pricingSnapshotRepository.findById(id).map(pricingSnapshotMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete PricingSnapshot : {}", id);
        pricingSnapshotRepository.deleteById(id);
    }
}
