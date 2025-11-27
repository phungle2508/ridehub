package com.ridehub.promotion.domain;

import static com.ridehub.promotion.domain.ConditionByDateTestSamples.*;
import static com.ridehub.promotion.domain.ConditionDateItemTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.ridehub.promotion.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ConditionDateItemTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ConditionDateItem.class);
        ConditionDateItem conditionDateItem1 = getConditionDateItemSample1();
        ConditionDateItem conditionDateItem2 = new ConditionDateItem();
        assertThat(conditionDateItem1).isNotEqualTo(conditionDateItem2);

        conditionDateItem2.setId(conditionDateItem1.getId());
        assertThat(conditionDateItem1).isEqualTo(conditionDateItem2);

        conditionDateItem2 = getConditionDateItemSample2();
        assertThat(conditionDateItem1).isNotEqualTo(conditionDateItem2);
    }

    @Test
    void conditionTest() {
        ConditionDateItem conditionDateItem = getConditionDateItemRandomSampleGenerator();
        ConditionByDate conditionByDateBack = getConditionByDateRandomSampleGenerator();

        conditionDateItem.setCondition(conditionByDateBack);
        assertThat(conditionDateItem.getCondition()).isEqualTo(conditionByDateBack);

        conditionDateItem.condition(null);
        assertThat(conditionDateItem.getCondition()).isNull();
    }
}
