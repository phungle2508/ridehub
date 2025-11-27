package com.ridehub.promotion.domain;

import static com.ridehub.promotion.domain.ConditionByRouteTestSamples.*;
import static com.ridehub.promotion.domain.ConditionRouteItemTestSamples.*;
import static com.ridehub.promotion.domain.PromotionTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.ridehub.promotion.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
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
    void itemsTest() {
        ConditionByRoute conditionByRoute = getConditionByRouteRandomSampleGenerator();
        ConditionRouteItem conditionRouteItemBack = getConditionRouteItemRandomSampleGenerator();

        conditionByRoute.addItems(conditionRouteItemBack);
        assertThat(conditionByRoute.getItems()).containsOnly(conditionRouteItemBack);
        assertThat(conditionRouteItemBack.getCondition()).isEqualTo(conditionByRoute);

        conditionByRoute.removeItems(conditionRouteItemBack);
        assertThat(conditionByRoute.getItems()).doesNotContain(conditionRouteItemBack);
        assertThat(conditionRouteItemBack.getCondition()).isNull();

        conditionByRoute.items(new HashSet<>(Set.of(conditionRouteItemBack)));
        assertThat(conditionByRoute.getItems()).containsOnly(conditionRouteItemBack);
        assertThat(conditionRouteItemBack.getCondition()).isEqualTo(conditionByRoute);

        conditionByRoute.setItems(new HashSet<>());
        assertThat(conditionByRoute.getItems()).doesNotContain(conditionRouteItemBack);
        assertThat(conditionRouteItemBack.getCondition()).isNull();
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
