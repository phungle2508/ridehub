package com.ridehub.promotion.domain;

import static com.ridehub.promotion.domain.ConditionByRouteTestSamples.*;
import static com.ridehub.promotion.domain.PromotionTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.ridehub.promotion.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ConditionByRouteTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ConditionByRoute.class);
        ConditionByRoute conditionByRoute1 = getConditionByRouteSample1();
        ConditionByRoute conditionByRoute2 = new ConditionByRoute();
        assertThat(conditionByRoute1).isNotEqualTo(conditionByRoute2);

        conditionByRoute2.setId(conditionByRoute1.getId());
        assertThat(conditionByRoute1).isEqualTo(conditionByRoute2);

        conditionByRoute2 = getConditionByRouteSample2();
        assertThat(conditionByRoute1).isNotEqualTo(conditionByRoute2);
    }

    @Test
    void promotionTest() {
        ConditionByRoute conditionByRoute = getConditionByRouteRandomSampleGenerator();
        Promotion promotionBack = getPromotionRandomSampleGenerator();

        conditionByRoute.setPromotion(promotionBack);
        assertThat(conditionByRoute.getPromotion()).isEqualTo(promotionBack);

        conditionByRoute.promotion(null);
        assertThat(conditionByRoute.getPromotion()).isNull();
    }
}
