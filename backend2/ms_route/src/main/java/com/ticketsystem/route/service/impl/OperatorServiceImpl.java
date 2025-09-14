package com.ticketsystem.route.service.impl;

import com.ticketsystem.route.domain.Operator;
import com.ticketsystem.route.repository.OperatorRepository;
import com.ticketsystem.route.service.OperatorService;
import com.ticketsystem.route.service.dto.OperatorDTO;
import com.ticketsystem.route.service.mapper.OperatorMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.ticketsystem.route.domain.Operator}.
 */
@Service
@Transactional
public class OperatorServiceImpl implements OperatorService {

    private static final Logger LOG = LoggerFactory.getLogger(OperatorServiceImpl.class);

    private final OperatorRepository operatorRepository;

    private final OperatorMapper operatorMapper;

    public OperatorServiceImpl(OperatorRepository operatorRepository, OperatorMapper operatorMapper) {
        this.operatorRepository = operatorRepository;
        this.operatorMapper = operatorMapper;
    }

    @Override
    public OperatorDTO save(OperatorDTO operatorDTO) {
        LOG.debug("Request to save Operator : {}", operatorDTO);
        Operator operator = operatorMapper.toEntity(operatorDTO);
        operator = operatorRepository.save(operator);
        return operatorMapper.toDto(operator);
    }

    @Override
    public OperatorDTO update(OperatorDTO operatorDTO) {
        LOG.debug("Request to update Operator : {}", operatorDTO);
        Operator operator = operatorMapper.toEntity(operatorDTO);
        operator = operatorRepository.save(operator);
        return operatorMapper.toDto(operator);
    }

    @Override
    public Optional<OperatorDTO> partialUpdate(OperatorDTO operatorDTO) {
        LOG.debug("Request to partially update Operator : {}", operatorDTO);

        return operatorRepository
            .findById(operatorDTO.getId())
            .map(existingOperator -> {
                operatorMapper.partialUpdate(existingOperator, operatorDTO);

                return existingOperator;
            })
            .map(operatorRepository::save)
            .map(operatorMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<OperatorDTO> findOne(Long id) {
        LOG.debug("Request to get Operator : {}", id);
        return operatorRepository.findById(id).map(operatorMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete Operator : {}", id);
        operatorRepository.deleteById(id);
    }
}
