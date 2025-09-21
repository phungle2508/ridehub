package com.ridehub.promotion.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.ridehub.promotion.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ConditionLocationItemDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ConditionLocationItemDTO.class);
        ConditionLocationItemDTO conditionLocationItemDTO1 = new ConditionLocationItemDTO();
        conditionLocationItemDTO1.setId(1L);
        ConditionLocationItemDTO conditionLocationItemDTO2 = new ConditionLocationItemDTO();
        assertThat(conditionLocationItemDTO1).isNotEqualTo(conditionLocationItemDTO2);
        conditionLocationItemDTO2.setId(conditionLocationItemDTO1.getId());
        assertThat(conditionLocationItemDTO1).isEqualTo(conditionLocationItemDTO2);
        conditionLocationItemDTO2.setId(2L);
        assertThat(conditionLocationItemDTO1).isNotEqualTo(conditionLocationItemDTO2);
        conditionLocationItemDTO1.setId(null);
        assertThat(conditionLocationItemDTO1).isNotEqualTo(conditionLocationItemDTO2);
    }
}
