package com.ridehub.promotion.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.ridehub.promotion.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ConditionByLocationDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ConditionByLocationDTO.class);
        ConditionByLocationDTO conditionByLocationDTO1 = new ConditionByLocationDTO();
        conditionByLocationDTO1.setId(1L);
        ConditionByLocationDTO conditionByLocationDTO2 = new ConditionByLocationDTO();
        assertThat(conditionByLocationDTO1).isNotEqualTo(conditionByLocationDTO2);
        conditionByLocationDTO2.setId(conditionByLocationDTO1.getId());
        assertThat(conditionByLocationDTO1).isEqualTo(conditionByLocationDTO2);
        conditionByLocationDTO2.setId(2L);
        assertThat(conditionByLocationDTO1).isNotEqualTo(conditionByLocationDTO2);
        conditionByLocationDTO1.setId(null);
        assertThat(conditionByLocationDTO1).isNotEqualTo(conditionByLocationDTO2);
    }
}
