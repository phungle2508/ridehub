package com.ridehub.promotion.domain;

import static com.ridehub.promotion.domain.ConditionByRouteTestSamples.*;
import static com.ridehub.promotion.domain.ConditionRouteItemTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.ridehub.promotion.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ConditionRouteItemTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ConditionRouteItem.class);
        ConditionRouteItem conditionRouteItem1 = getConditionRouteItemSample1();
        ConditionRouteItem conditionRouteItem2 = new ConditionRouteItem();
        assertThat(conditionRouteItem1).isNotEqualTo(conditionRouteItem2);

        conditionRouteItem2.setId(conditionRouteItem1.getId());
        assertThat(conditionRouteItem1).isEqualTo(conditionRouteItem2);

        conditionRouteItem2 = getConditionRouteItemSample2();
        assertThat(conditionRouteItem1).isNotEqualTo(conditionRouteItem2);
    }

    @Test
    void conditionTest() {
        ConditionRouteItem conditionRouteItem = getConditionRouteItemRandomSampleGenerator();
        ConditionByRoute conditionByRouteBack = getConditionByRouteRandomSampleGenerator();

        conditionRouteItem.setCondition(conditionByRouteBack);
        assertThat(conditionRouteItem.getCondition()).isEqualTo(conditionByRouteBack);

        conditionRouteItem.condition(null);
        assertThat(conditionRouteItem.getCondition()).isNull();
    }
}
