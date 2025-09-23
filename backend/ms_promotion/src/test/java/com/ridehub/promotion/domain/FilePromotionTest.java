package com.ridehub.promotion.domain;

import static com.ridehub.promotion.domain.FilePromotionTestSamples.*;
import static com.ridehub.promotion.domain.PromotionTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.ridehub.promotion.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class FilePromotionTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(FilePromotion.class);
        FilePromotion filePromotion1 = getFilePromotionSample1();
        FilePromotion filePromotion2 = new FilePromotion();
        assertThat(filePromotion1).isNotEqualTo(filePromotion2);

        filePromotion2.setId(filePromotion1.getId());
        assertThat(filePromotion1).isEqualTo(filePromotion2);

        filePromotion2 = getFilePromotionSample2();
        assertThat(filePromotion1).isNotEqualTo(filePromotion2);
    }

    @Test
    void promotionTest() {
        FilePromotion filePromotion = getFilePromotionRandomSampleGenerator();
        Promotion promotionBack = getPromotionRandomSampleGenerator();

        filePromotion.setPromotion(promotionBack);
        assertThat(filePromotion.getPromotion()).isEqualTo(promotionBack);
        assertThat(promotionBack.getBannerImg()).isEqualTo(filePromotion);

        filePromotion.promotion(null);
        assertThat(filePromotion.getPromotion()).isNull();
        assertThat(promotionBack.getBannerImg()).isNull();
    }
}
