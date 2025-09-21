package com.ridehub.promotion.domain;

import static com.ridehub.promotion.domain.BuyNGetMFreeTestSamples.*;
import static com.ridehub.promotion.domain.PromotionTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.ridehub.promotion.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class BuyNGetMFreeTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(BuyNGetMFree.class);
        BuyNGetMFree buyNGetMFree1 = getBuyNGetMFreeSample1();
        BuyNGetMFree buyNGetMFree2 = new BuyNGetMFree();
        assertThat(buyNGetMFree1).isNotEqualTo(buyNGetMFree2);

        buyNGetMFree2.setId(buyNGetMFree1.getId());
        assertThat(buyNGetMFree1).isEqualTo(buyNGetMFree2);

        buyNGetMFree2 = getBuyNGetMFreeSample2();
        assertThat(buyNGetMFree1).isNotEqualTo(buyNGetMFree2);
    }

    @Test
    void promotionTest() {
        BuyNGetMFree buyNGetMFree = getBuyNGetMFreeRandomSampleGenerator();
        Promotion promotionBack = getPromotionRandomSampleGenerator();

        buyNGetMFree.setPromotion(promotionBack);
        assertThat(buyNGetMFree.getPromotion()).isEqualTo(promotionBack);

        buyNGetMFree.promotion(null);
        assertThat(buyNGetMFree.getPromotion()).isNull();
    }
}
