package com.ridehub.promotion.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.ridehub.promotion.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ConditionRouteItemDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ConditionRouteItemDTO.class);
        ConditionRouteItemDTO conditionRouteItemDTO1 = new ConditionRouteItemDTO();
        conditionRouteItemDTO1.setId(1L);
        ConditionRouteItemDTO conditionRouteItemDTO2 = new ConditionRouteItemDTO();
        assertThat(conditionRouteItemDTO1).isNotEqualTo(conditionRouteItemDTO2);
        conditionRouteItemDTO2.setId(conditionRouteItemDTO1.getId());
        assertThat(conditionRouteItemDTO1).isEqualTo(conditionRouteItemDTO2);
        conditionRouteItemDTO2.setId(2L);
        assertThat(conditionRouteItemDTO1).isNotEqualTo(conditionRouteItemDTO2);
        conditionRouteItemDTO1.setId(null);
        assertThat(conditionRouteItemDTO1).isNotEqualTo(conditionRouteItemDTO2);
    }
}
