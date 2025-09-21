package com.ridehub.promotion.domain;

import static com.ridehub.promotion.domain.PercentOffTotalTestSamples.*;
import static com.ridehub.promotion.domain.PromotionTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.ridehub.promotion.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class PercentOffTotalTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(PercentOffTotal.class);
        PercentOffTotal percentOffTotal1 = getPercentOffTotalSample1();
        PercentOffTotal percentOffTotal2 = new PercentOffTotal();
        assertThat(percentOffTotal1).isNotEqualTo(percentOffTotal2);

        percentOffTotal2.setId(percentOffTotal1.getId());
        assertThat(percentOffTotal1).isEqualTo(percentOffTotal2);

        percentOffTotal2 = getPercentOffTotalSample2();
        assertThat(percentOffTotal1).isNotEqualTo(percentOffTotal2);
    }

    @Test
    void promotionTest() {
        PercentOffTotal percentOffTotal = getPercentOffTotalRandomSampleGenerator();
        Promotion promotionBack = getPromotionRandomSampleGenerator();

        percentOffTotal.setPromotion(promotionBack);
        assertThat(percentOffTotal.getPromotion()).isEqualTo(promotionBack);

        percentOffTotal.promotion(null);
        assertThat(percentOffTotal.getPromotion()).isNull();
    }
}
