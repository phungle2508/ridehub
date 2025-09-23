package com.ridehub.promotion.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.ridehub.promotion.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class FilePromotionDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(FilePromotionDTO.class);
        FilePromotionDTO filePromotionDTO1 = new FilePromotionDTO();
        filePromotionDTO1.setId(1L);
        FilePromotionDTO filePromotionDTO2 = new FilePromotionDTO();
        assertThat(filePromotionDTO1).isNotEqualTo(filePromotionDTO2);
        filePromotionDTO2.setId(filePromotionDTO1.getId());
        assertThat(filePromotionDTO1).isEqualTo(filePromotionDTO2);
        filePromotionDTO2.setId(2L);
        assertThat(filePromotionDTO1).isNotEqualTo(filePromotionDTO2);
        filePromotionDTO1.setId(null);
        assertThat(filePromotionDTO1).isNotEqualTo(filePromotionDTO2);
    }
}
