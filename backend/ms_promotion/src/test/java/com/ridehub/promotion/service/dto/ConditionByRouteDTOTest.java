package com.ridehub.promotion.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.ridehub.promotion.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ConditionByRouteDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ConditionByRouteDTO.class);
        ConditionByRouteDTO conditionByRouteDTO1 = new ConditionByRouteDTO();
        conditionByRouteDTO1.setId(1L);
        ConditionByRouteDTO conditionByRouteDTO2 = new ConditionByRouteDTO();
        assertThat(conditionByRouteDTO1).isNotEqualTo(conditionByRouteDTO2);
        conditionByRouteDTO2.setId(conditionByRouteDTO1.getId());
        assertThat(conditionByRouteDTO1).isEqualTo(conditionByRouteDTO2);
        conditionByRouteDTO2.setId(2L);
        assertThat(conditionByRouteDTO1).isNotEqualTo(conditionByRouteDTO2);
        conditionByRouteDTO1.setId(null);
        assertThat(conditionByRouteDTO1).isNotEqualTo(conditionByRouteDTO2);
    }
}
