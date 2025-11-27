package com.ridehub.booking.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.ridehub.booking.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class AppliedPromotionDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(AppliedPromotionDTO.class);
        AppliedPromotionDTO appliedPromotionDTO1 = new AppliedPromotionDTO();
        appliedPromotionDTO1.setId(1L);
        AppliedPromotionDTO appliedPromotionDTO2 = new AppliedPromotionDTO();
        assertThat(appliedPromotionDTO1).isNotEqualTo(appliedPromotionDTO2);
        appliedPromotionDTO2.setId(appliedPromotionDTO1.getId());
        assertThat(appliedPromotionDTO1).isEqualTo(appliedPromotionDTO2);
        appliedPromotionDTO2.setId(2L);
        assertThat(appliedPromotionDTO1).isNotEqualTo(appliedPromotionDTO2);
        appliedPromotionDTO1.setId(null);
        assertThat(appliedPromotionDTO1).isNotEqualTo(appliedPromotionDTO2);
    }
}
