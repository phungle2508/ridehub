package com.ticketsystem.route.service.impl;

import com.ticketsystem.route.domain.ReviewSummary;
import com.ticketsystem.route.repository.ReviewSummaryRepository;
import com.ticketsystem.route.service.ReviewSummaryService;
import com.ticketsystem.route.service.dto.ReviewSummaryDTO;
import com.ticketsystem.route.service.mapper.ReviewSummaryMapper;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.ticketsystem.route.domain.ReviewSummary}.
 */
@Service
@Transactional
public class ReviewSummaryServiceImpl implements ReviewSummaryService {

    private static final Logger LOG = LoggerFactory.getLogger(ReviewSummaryServiceImpl.class);

    private final ReviewSummaryRepository reviewSummaryRepository;

    private final ReviewSummaryMapper reviewSummaryMapper;

    public ReviewSummaryServiceImpl(ReviewSummaryRepository reviewSummaryRepository, ReviewSummaryMapper reviewSummaryMapper) {
        this.reviewSummaryRepository = reviewSummaryRepository;
        this.reviewSummaryMapper = reviewSummaryMapper;
    }

    @Override
    public ReviewSummaryDTO save(ReviewSummaryDTO reviewSummaryDTO) {
        LOG.debug("Request to save ReviewSummary : {}", reviewSummaryDTO);
        ReviewSummary reviewSummary = reviewSummaryMapper.toEntity(reviewSummaryDTO);
        reviewSummary = reviewSummaryRepository.save(reviewSummary);
        return reviewSummaryMapper.toDto(reviewSummary);
    }

    @Override
    public ReviewSummaryDTO update(ReviewSummaryDTO reviewSummaryDTO) {
        LOG.debug("Request to update ReviewSummary : {}", reviewSummaryDTO);
        ReviewSummary reviewSummary = reviewSummaryMapper.toEntity(reviewSummaryDTO);
        reviewSummary = reviewSummaryRepository.save(reviewSummary);
        return reviewSummaryMapper.toDto(reviewSummary);
    }

    @Override
    public Optional<ReviewSummaryDTO> partialUpdate(ReviewSummaryDTO reviewSummaryDTO) {
        LOG.debug("Request to partially update ReviewSummary : {}", reviewSummaryDTO);

        return reviewSummaryRepository
            .findById(reviewSummaryDTO.getId())
            .map(existingReviewSummary -> {
                reviewSummaryMapper.partialUpdate(existingReviewSummary, reviewSummaryDTO);

                return existingReviewSummary;
            })
            .map(reviewSummaryRepository::save)
            .map(reviewSummaryMapper::toDto);
    }

    /**
     *  Get all the reviewSummaries where Vehicle is {@code null}.
     *  @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<ReviewSummaryDTO> findAllWhereVehicleIsNull() {
        LOG.debug("Request to get all reviewSummaries where Vehicle is null");
        return StreamSupport.stream(reviewSummaryRepository.findAll().spliterator(), false)
            .filter(reviewSummary -> reviewSummary.getVehicle() == null)
            .map(reviewSummaryMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ReviewSummaryDTO> findOne(Long id) {
        LOG.debug("Request to get ReviewSummary : {}", id);
        return reviewSummaryRepository.findById(id).map(reviewSummaryMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete ReviewSummary : {}", id);
        reviewSummaryRepository.deleteById(id);
    }
}
