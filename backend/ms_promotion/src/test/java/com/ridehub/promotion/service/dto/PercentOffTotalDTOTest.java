package com.ridehub.promotion.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.ridehub.promotion.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class PercentOffTotalDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(PercentOffTotalDTO.class);
        PercentOffTotalDTO percentOffTotalDTO1 = new PercentOffTotalDTO();
        percentOffTotalDTO1.setId(1L);
        PercentOffTotalDTO percentOffTotalDTO2 = new PercentOffTotalDTO();
        assertThat(percentOffTotalDTO1).isNotEqualTo(percentOffTotalDTO2);
        percentOffTotalDTO2.setId(percentOffTotalDTO1.getId());
        assertThat(percentOffTotalDTO1).isEqualTo(percentOffTotalDTO2);
        percentOffTotalDTO2.setId(2L);
        assertThat(percentOffTotalDTO1).isNotEqualTo(percentOffTotalDTO2);
        percentOffTotalDTO1.setId(null);
        assertThat(percentOffTotalDTO1).isNotEqualTo(percentOffTotalDTO2);
    }
}
