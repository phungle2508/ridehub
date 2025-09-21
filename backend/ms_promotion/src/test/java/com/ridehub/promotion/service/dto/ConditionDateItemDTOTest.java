package com.ridehub.promotion.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.ridehub.promotion.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ConditionDateItemDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ConditionDateItemDTO.class);
        ConditionDateItemDTO conditionDateItemDTO1 = new ConditionDateItemDTO();
        conditionDateItemDTO1.setId(1L);
        ConditionDateItemDTO conditionDateItemDTO2 = new ConditionDateItemDTO();
        assertThat(conditionDateItemDTO1).isNotEqualTo(conditionDateItemDTO2);
        conditionDateItemDTO2.setId(conditionDateItemDTO1.getId());
        assertThat(conditionDateItemDTO1).isEqualTo(conditionDateItemDTO2);
        conditionDateItemDTO2.setId(2L);
        assertThat(conditionDateItemDTO1).isNotEqualTo(conditionDateItemDTO2);
        conditionDateItemDTO1.setId(null);
        assertThat(conditionDateItemDTO1).isNotEqualTo(conditionDateItemDTO2);
    }
}
