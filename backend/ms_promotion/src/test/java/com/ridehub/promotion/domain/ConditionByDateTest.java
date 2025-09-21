package com.ridehub.promotion.domain;

import static com.ridehub.promotion.domain.ConditionByDateTestSamples.*;
import static com.ridehub.promotion.domain.PromotionTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.ridehub.promotion.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ConditionByDateTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ConditionByDate.class);
        ConditionByDate conditionByDate1 = getConditionByDateSample1();
        ConditionByDate conditionByDate2 = new ConditionByDate();
        assertThat(conditionByDate1).isNotEqualTo(conditionByDate2);

        conditionByDate2.setId(conditionByDate1.getId());
        assertThat(conditionByDate1).isEqualTo(conditionByDate2);

        conditionByDate2 = getConditionByDateSample2();
        assertThat(conditionByDate1).isNotEqualTo(conditionByDate2);
    }

    @Test
    void promotionTest() {
        ConditionByDate conditionByDate = getConditionByDateRandomSampleGenerator();
        Promotion promotionBack = getPromotionRandomSampleGenerator();

        conditionByDate.setPromotion(promotionBack);
        assertThat(conditionByDate.getPromotion()).isEqualTo(promotionBack);

        conditionByDate.promotion(null);
        assertThat(conditionByDate.getPromotion()).isNull();
    }
}
