package com.ticketsystem.route.service.impl;

import com.ticketsystem.route.domain.Schedule;
import com.ticketsystem.route.repository.ScheduleRepository;
import com.ticketsystem.route.repository.search.ScheduleSearchRepository;
import com.ticketsystem.route.service.ScheduleService;
import com.ticketsystem.route.service.dto.ScheduleDTO;
import com.ticketsystem.route.service.mapper.ScheduleMapper;
import java.util.Optional;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.ticketsystem.route.domain.Schedule}.
 */
@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {

    private static final Logger LOG = LoggerFactory.getLogger(ScheduleServiceImpl.class);

    private final ScheduleRepository scheduleRepository;

    private final ScheduleMapper scheduleMapper;

    private final ScheduleSearchRepository scheduleSearchRepository;

    public ScheduleServiceImpl(
        ScheduleRepository scheduleRepository,
        ScheduleMapper scheduleMapper,
        ScheduleSearchRepository scheduleSearchRepository
    ) {
        this.scheduleRepository = scheduleRepository;
        this.scheduleMapper = scheduleMapper;
        this.scheduleSearchRepository = scheduleSearchRepository;
    }

    @Override
    public ScheduleDTO save(ScheduleDTO scheduleDTO) {
        LOG.debug("Request to save Schedule : {}", scheduleDTO);
        Schedule schedule = scheduleMapper.toEntity(scheduleDTO);
        schedule = scheduleRepository.save(schedule);
        scheduleSearchRepository.index(schedule);
        return scheduleMapper.toDto(schedule);
    }

    @Override
    public ScheduleDTO update(ScheduleDTO scheduleDTO) {
        LOG.debug("Request to update Schedule : {}", scheduleDTO);
        Schedule schedule = scheduleMapper.toEntity(scheduleDTO);
        schedule = scheduleRepository.save(schedule);
        scheduleSearchRepository.index(schedule);
        return scheduleMapper.toDto(schedule);
    }

    @Override
    public Optional<ScheduleDTO> partialUpdate(ScheduleDTO scheduleDTO) {
        LOG.debug("Request to partially update Schedule : {}", scheduleDTO);

        return scheduleRepository
            .findById(scheduleDTO.getId())
            .map(existingSchedule -> {
                scheduleMapper.partialUpdate(existingSchedule, scheduleDTO);

                return existingSchedule;
            })
            .map(scheduleRepository::save)
            .map(savedSchedule -> {
                scheduleSearchRepository.index(savedSchedule);
                return savedSchedule;
            })
            .map(scheduleMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ScheduleDTO> findOne(UUID id) {
        LOG.debug("Request to get Schedule : {}", id);
        return scheduleRepository.findById(id).map(scheduleMapper::toDto);
    }

    @Override
    public void delete(UUID id) {
        LOG.debug("Request to delete Schedule : {}", id);
        scheduleRepository.deleteById(id);
        scheduleSearchRepository.deleteFromIndexById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ScheduleDTO> search(String query, Pageable pageable) {
        LOG.debug("Request to search for a page of Schedules for query {}", query);
        return scheduleSearchRepository.search(query, pageable).map(scheduleMapper::toDto);
    }
}
