package com.ridehub.promotion.service.impl;

import com.ridehub.promotion.domain.FilePromotion;
import com.ridehub.promotion.repository.FilePromotionRepository;
import com.ridehub.promotion.service.FilePromotionService;
import com.ridehub.promotion.service.dto.FilePromotionDTO;
import com.ridehub.promotion.service.mapper.FilePromotionMapper;
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
 * Service Implementation for managing {@link com.ridehub.promotion.domain.FilePromotion}.
 */
@Service
@Transactional
public class FilePromotionServiceImpl implements FilePromotionService {

    private static final Logger LOG = LoggerFactory.getLogger(FilePromotionServiceImpl.class);

    private final FilePromotionRepository filePromotionRepository;

    private final FilePromotionMapper filePromotionMapper;

    public FilePromotionServiceImpl(FilePromotionRepository filePromotionRepository, FilePromotionMapper filePromotionMapper) {
        this.filePromotionRepository = filePromotionRepository;
        this.filePromotionMapper = filePromotionMapper;
    }

    @Override
    public FilePromotionDTO save(FilePromotionDTO filePromotionDTO) {
        LOG.debug("Request to save FilePromotion : {}", filePromotionDTO);
        FilePromotion filePromotion = filePromotionMapper.toEntity(filePromotionDTO);
        filePromotion = filePromotionRepository.save(filePromotion);
        return filePromotionMapper.toDto(filePromotion);
    }

    @Override
    public FilePromotionDTO update(FilePromotionDTO filePromotionDTO) {
        LOG.debug("Request to update FilePromotion : {}", filePromotionDTO);
        FilePromotion filePromotion = filePromotionMapper.toEntity(filePromotionDTO);
        filePromotion = filePromotionRepository.save(filePromotion);
        return filePromotionMapper.toDto(filePromotion);
    }

    @Override
    public Optional<FilePromotionDTO> partialUpdate(FilePromotionDTO filePromotionDTO) {
        LOG.debug("Request to partially update FilePromotion : {}", filePromotionDTO);

        return filePromotionRepository
            .findById(filePromotionDTO.getId())
            .map(existingFilePromotion -> {
                filePromotionMapper.partialUpdate(existingFilePromotion, filePromotionDTO);

                return existingFilePromotion;
            })
            .map(filePromotionRepository::save)
            .map(filePromotionMapper::toDto);
    }

    /**
     *  Get all the filePromotions where Promotion is {@code null}.
     *  @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<FilePromotionDTO> findAllWherePromotionIsNull() {
        LOG.debug("Request to get all filePromotions where Promotion is null");
        return StreamSupport.stream(filePromotionRepository.findAll().spliterator(), false)
            .filter(filePromotion -> filePromotion.getPromotion() == null)
            .map(filePromotionMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<FilePromotionDTO> findOne(Long id) {
        LOG.debug("Request to get FilePromotion : {}", id);
        return filePromotionRepository.findById(id).map(filePromotionMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete FilePromotion : {}", id);
        filePromotionRepository.deleteById(id);
    }
}
