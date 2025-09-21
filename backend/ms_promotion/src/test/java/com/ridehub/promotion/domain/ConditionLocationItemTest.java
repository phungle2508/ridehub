package com.ridehub.promotion.domain;

import static com.ridehub.promotion.domain.ConditionByLocationTestSamples.*;
import static com.ridehub.promotion.domain.ConditionLocationItemTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.ridehub.promotion.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ConditionLocationItemTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ConditionLocationItem.class);
        ConditionLocationItem conditionLocationItem1 = getConditionLocationItemSample1();
        ConditionLocationItem conditionLocationItem2 = new ConditionLocationItem();
        assertThat(conditionLocationItem1).isNotEqualTo(conditionLocationItem2);

        conditionLocationItem2.setId(conditionLocationItem1.getId());
        assertThat(conditionLocationItem1).isEqualTo(conditionLocationItem2);

        conditionLocationItem2 = getConditionLocationItemSample2();
        assertThat(conditionLocationItem1).isNotEqualTo(conditionLocationItem2);
    }

    @Test
    void conditionTest() {
        ConditionLocationItem conditionLocationItem = getConditionLocationItemRandomSampleGenerator();
        ConditionByLocation conditionByLocationBack = getConditionByLocationRandomSampleGenerator();

        conditionLocationItem.setCondition(conditionByLocationBack);
        assertThat(conditionLocationItem.getCondition()).isEqualTo(conditionByLocationBack);

        conditionLocationItem.condition(null);
        assertThat(conditionLocationItem.getCondition()).isNull();
    }
}
