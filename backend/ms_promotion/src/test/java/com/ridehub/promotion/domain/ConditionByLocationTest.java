package com.ridehub.promotion.domain;

import static com.ridehub.promotion.domain.ConditionByLocationTestSamples.*;
import static com.ridehub.promotion.domain.ConditionLocationItemTestSamples.*;
import static com.ridehub.promotion.domain.PromotionTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.ridehub.promotion.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
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
    void itemsTest() {
        ConditionByLocation conditionByLocation = getConditionByLocationRandomSampleGenerator();
        ConditionLocationItem conditionLocationItemBack = getConditionLocationItemRandomSampleGenerator();

        conditionByLocation.addItems(conditionLocationItemBack);
        assertThat(conditionByLocation.getItems()).containsOnly(conditionLocationItemBack);
        assertThat(conditionLocationItemBack.getCondition()).isEqualTo(conditionByLocation);

        conditionByLocation.removeItems(conditionLocationItemBack);
        assertThat(conditionByLocation.getItems()).doesNotContain(conditionLocationItemBack);
        assertThat(conditionLocationItemBack.getCondition()).isNull();

        conditionByLocation.items(new HashSet<>(Set.of(conditionLocationItemBack)));
        assertThat(conditionByLocation.getItems()).containsOnly(conditionLocationItemBack);
        assertThat(conditionLocationItemBack.getCondition()).isEqualTo(conditionByLocation);

        conditionByLocation.setItems(new HashSet<>());
        assertThat(conditionByLocation.getItems()).doesNotContain(conditionLocationItemBack);
        assertThat(conditionLocationItemBack.getCondition()).isNull();
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
