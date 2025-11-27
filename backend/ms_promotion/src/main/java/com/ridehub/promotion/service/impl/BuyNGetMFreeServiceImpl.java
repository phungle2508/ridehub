package com.ridehub.promotion.service.impl;

import com.ridehub.promotion.domain.BuyNGetMFree;
import com.ridehub.promotion.repository.BuyNGetMFreeRepository;
import com.ridehub.promotion.service.BuyNGetMFreeService;
import com.ridehub.promotion.service.dto.BuyNGetMFreeDTO;
import com.ridehub.promotion.service.mapper.BuyNGetMFreeMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.ridehub.promotion.domain.BuyNGetMFree}.
 */
@Service
@Transactional
public class BuyNGetMFreeServiceImpl implements BuyNGetMFreeService {

    private static final Logger LOG = LoggerFactory.getLogger(BuyNGetMFreeServiceImpl.class);

    private final BuyNGetMFreeRepository buyNGetMFreeRepository;

    private final BuyNGetMFreeMapper buyNGetMFreeMapper;

    public BuyNGetMFreeServiceImpl(BuyNGetMFreeRepository buyNGetMFreeRepository, BuyNGetMFreeMapper buyNGetMFreeMapper) {
        this.buyNGetMFreeRepository = buyNGetMFreeRepository;
        this.buyNGetMFreeMapper = buyNGetMFreeMapper;
    }

    @Override
    public BuyNGetMFreeDTO save(BuyNGetMFreeDTO buyNGetMFreeDTO) {
        LOG.debug("Request to save BuyNGetMFree : {}", buyNGetMFreeDTO);
        BuyNGetMFree buyNGetMFree = buyNGetMFreeMapper.toEntity(buyNGetMFreeDTO);
        buyNGetMFree = buyNGetMFreeRepository.save(buyNGetMFree);
        return buyNGetMFreeMapper.toDto(buyNGetMFree);
    }

    @Override
    public BuyNGetMFreeDTO update(BuyNGetMFreeDTO buyNGetMFreeDTO) {
        LOG.debug("Request to update BuyNGetMFree : {}", buyNGetMFreeDTO);
        BuyNGetMFree buyNGetMFree = buyNGetMFreeMapper.toEntity(buyNGetMFreeDTO);
        buyNGetMFree = buyNGetMFreeRepository.save(buyNGetMFree);
        return buyNGetMFreeMapper.toDto(buyNGetMFree);
    }

    @Override
    public Optional<BuyNGetMFreeDTO> partialUpdate(BuyNGetMFreeDTO buyNGetMFreeDTO) {
        LOG.debug("Request to partially update BuyNGetMFree : {}", buyNGetMFreeDTO);

        return buyNGetMFreeRepository
            .findById(buyNGetMFreeDTO.getId())
            .map(existingBuyNGetMFree -> {
                buyNGetMFreeMapper.partialUpdate(existingBuyNGetMFree, buyNGetMFreeDTO);

                return existingBuyNGetMFree;
            })
            .map(buyNGetMFreeRepository::save)
            .map(buyNGetMFreeMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<BuyNGetMFreeDTO> findOne(Long id) {
        LOG.debug("Request to get BuyNGetMFree : {}", id);
        return buyNGetMFreeRepository.findById(id).map(buyNGetMFreeMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete BuyNGetMFree : {}", id);
        buyNGetMFreeRepository.deleteById(id);
    }
}
