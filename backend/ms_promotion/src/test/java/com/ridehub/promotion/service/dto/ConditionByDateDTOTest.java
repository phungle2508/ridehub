package com.ridehub.promotion.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.ridehub.promotion.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ConditionByDateDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ConditionByDateDTO.class);
        ConditionByDateDTO conditionByDateDTO1 = new ConditionByDateDTO();
        conditionByDateDTO1.setId(1L);
        ConditionByDateDTO conditionByDateDTO2 = new ConditionByDateDTO();
        assertThat(conditionByDateDTO1).isNotEqualTo(conditionByDateDTO2);
        conditionByDateDTO2.setId(conditionByDateDTO1.getId());
        assertThat(conditionByDateDTO1).isEqualTo(conditionByDateDTO2);
        conditionByDateDTO2.setId(2L);
        assertThat(conditionByDateDTO1).isNotEqualTo(conditionByDateDTO2);
        conditionByDateDTO1.setId(null);
        assertThat(conditionByDateDTO1).isNotEqualTo(conditionByDateDTO2);
    }
}
