package com.ridehub.route.service.impl;

import com.ridehub.route.domain.SeatLock;
import com.ridehub.route.repository.SeatLockRepository;
import com.ridehub.route.service.SeatLockService;
import com.ridehub.route.service.dto.SeatLockDTO;
import com.ridehub.route.service.mapper.SeatLockMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.ridehub.route.domain.SeatLock}.
 */
@Service
@Transactional
public class SeatLockServiceImpl implements SeatLockService {

    private static final Logger LOG = LoggerFactory.getLogger(SeatLockServiceImpl.class);

    private final SeatLockRepository seatLockRepository;

    private final SeatLockMapper seatLockMapper;

    public SeatLockServiceImpl(SeatLockRepository seatLockRepository, SeatLockMapper seatLockMapper) {
        this.seatLockRepository = seatLockRepository;
        this.seatLockMapper = seatLockMapper;
    }

    @Override
    public SeatLockDTO save(SeatLockDTO seatLockDTO) {
        LOG.debug("Request to save SeatLock : {}", seatLockDTO);
        SeatLock seatLock = seatLockMapper.toEntity(seatLockDTO);
        seatLock = seatLockRepository.save(seatLock);
        return seatLockMapper.toDto(seatLock);
    }

    @Override
    public SeatLockDTO update(SeatLockDTO seatLockDTO) {
        LOG.debug("Request to update SeatLock : {}", seatLockDTO);
        SeatLock seatLock = seatLockMapper.toEntity(seatLockDTO);
        seatLock = seatLockRepository.save(seatLock);
        return seatLockMapper.toDto(seatLock);
    }

    @Override
    public Optional<SeatLockDTO> partialUpdate(SeatLockDTO seatLockDTO) {
        LOG.debug("Request to partially update SeatLock : {}", seatLockDTO);

        return seatLockRepository
            .findById(seatLockDTO.getId())
            .map(existingSeatLock -> {
                seatLockMapper.partialUpdate(existingSeatLock, seatLockDTO);

                return existingSeatLock;
            })
            .map(seatLockRepository::save)
            .map(seatLockMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<SeatLockDTO> findOne(Long id) {
        LOG.debug("Request to get SeatLock : {}", id);
        return seatLockRepository.findById(id).map(seatLockMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete SeatLock : {}", id);
        seatLockRepository.deleteById(id);
    }
}
