package com.ridehub.promotion.domain;

import static com.ridehub.promotion.domain.ConditionByLocationTestSamples.*;
import static com.ridehub.promotion.domain.PromotionTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.ridehub.promotion.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ConditionByLocationTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ConditionByLocation.class);
        ConditionByLocation conditionByLocation1 = getConditionByLocationSample1();
        ConditionByLocation conditionByLocation2 = new ConditionByLocation();
        assertThat(conditionByLocation1).isNotEqualTo(conditionByLocation2);

        conditionByLocation2.setId(conditionByLocation1.getId());
        assertThat(conditionByLocation1).isEqualTo(conditionByLocation2);

        conditionByLocation2 = getConditionByLocationSample2();
        assertThat(conditionByLocation1).isNotEqualTo(conditionByLocation2);
    }

    @Test
    void promotionTest() {
        ConditionByLocation conditionByLocation = getConditionByLocationRandomSampleGenerator();
        Promotion promotionBack = getPromotionRandomSampleGenerator();

        conditionByLocation.setPromotion(promotionBack);
        assertThat(conditionByLocation.getPromotion()).isEqualTo(promotionBack);

        conditionByLocation.promotion(null);
        assertThat(conditionByLocation.getPromotion()).isNull();
    }
}
