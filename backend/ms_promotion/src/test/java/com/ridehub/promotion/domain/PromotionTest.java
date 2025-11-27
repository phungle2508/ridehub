package com.ridehub.promotion.domain;

import static com.ridehub.promotion.domain.BuyNGetMFreeTestSamples.*;
import static com.ridehub.promotion.domain.ConditionByDateTestSamples.*;
import static com.ridehub.promotion.domain.ConditionByLocationTestSamples.*;
import static com.ridehub.promotion.domain.ConditionByRouteTestSamples.*;
import static com.ridehub.promotion.domain.FilePromotionTestSamples.*;
import static com.ridehub.promotion.domain.PercentOffTotalTestSamples.*;
import static com.ridehub.promotion.domain.PromotionTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.ridehub.promotion.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class PromotionTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Promotion.class);
        Promotion promotion1 = getPromotionSample1();
        Promotion promotion2 = new Promotion();
        assertThat(promotion1).isNotEqualTo(promotion2);

        promotion2.setId(promotion1.getId());
        assertThat(promotion1).isEqualTo(promotion2);

        promotion2 = getPromotionSample2();
        assertThat(promotion1).isNotEqualTo(promotion2);
    }

    @Test
    void filesTest() {
        Promotion promotion = getPromotionRandomSampleGenerator();
        FilePromotion filePromotionBack = getFilePromotionRandomSampleGenerator();

        promotion.addFiles(filePromotionBack);
        assertThat(promotion.getFiles()).containsOnly(filePromotionBack);
        assertThat(filePromotionBack.getPromotion()).isEqualTo(promotion);

        promotion.removeFiles(filePromotionBack);
        assertThat(promotion.getFiles()).doesNotContain(filePromotionBack);
        assertThat(filePromotionBack.getPromotion()).isNull();

        promotion.files(new HashSet<>(Set.of(filePromotionBack)));
        assertThat(promotion.getFiles()).containsOnly(filePromotionBack);
        assertThat(filePromotionBack.getPromotion()).isEqualTo(promotion);

        promotion.setFiles(new HashSet<>());
        assertThat(promotion.getFiles()).doesNotContain(filePromotionBack);
        assertThat(filePromotionBack.getPromotion()).isNull();
    }

    @Test
    void buyNGetMTest() {
        Promotion promotion = getPromotionRandomSampleGenerator();
        BuyNGetMFree buyNGetMFreeBack = getBuyNGetMFreeRandomSampleGenerator();

        promotion.addBuyNGetM(buyNGetMFreeBack);
        assertThat(promotion.getBuyNGetMS()).containsOnly(buyNGetMFreeBack);
        assertThat(buyNGetMFreeBack.getPromotion()).isEqualTo(promotion);

        promotion.removeBuyNGetM(buyNGetMFreeBack);
        assertThat(promotion.getBuyNGetMS()).doesNotContain(buyNGetMFreeBack);
        assertThat(buyNGetMFreeBack.getPromotion()).isNull();

        promotion.buyNGetMS(new HashSet<>(Set.of(buyNGetMFreeBack)));
        assertThat(promotion.getBuyNGetMS()).containsOnly(buyNGetMFreeBack);
        assertThat(buyNGetMFreeBack.getPromotion()).isEqualTo(promotion);

        promotion.setBuyNGetMS(new HashSet<>());
        assertThat(promotion.getBuyNGetMS()).doesNotContain(buyNGetMFreeBack);
        assertThat(buyNGetMFreeBack.getPromotion()).isNull();
    }

    @Test
    void percentOffTest() {
        Promotion promotion = getPromotionRandomSampleGenerator();
        PercentOffTotal percentOffTotalBack = getPercentOffTotalRandomSampleGenerator();

        promotion.addPercentOff(percentOffTotalBack);
        assertThat(promotion.getPercentOffs()).containsOnly(percentOffTotalBack);
        assertThat(percentOffTotalBack.getPromotion()).isEqualTo(promotion);

        promotion.removePercentOff(percentOffTotalBack);
        assertThat(promotion.getPercentOffs()).doesNotContain(percentOffTotalBack);
        assertThat(percentOffTotalBack.getPromotion()).isNull();

        promotion.percentOffs(new HashSet<>(Set.of(percentOffTotalBack)));
        assertThat(promotion.getPercentOffs()).containsOnly(percentOffTotalBack);
        assertThat(percentOffTotalBack.getPromotion()).isEqualTo(promotion);

        promotion.setPercentOffs(new HashSet<>());
        assertThat(promotion.getPercentOffs()).doesNotContain(percentOffTotalBack);
        assertThat(percentOffTotalBack.getPromotion()).isNull();
    }

    @Test
    void conditionsRTest() {
        Promotion promotion = getPromotionRandomSampleGenerator();
        ConditionByRoute conditionByRouteBack = getConditionByRouteRandomSampleGenerator();

        promotion.addConditionsR(conditionByRouteBack);
        assertThat(promotion.getConditionsRS()).containsOnly(conditionByRouteBack);
        assertThat(conditionByRouteBack.getPromotion()).isEqualTo(promotion);

        promotion.removeConditionsR(conditionByRouteBack);
        assertThat(promotion.getConditionsRS()).doesNotContain(conditionByRouteBack);
        assertThat(conditionByRouteBack.getPromotion()).isNull();

        promotion.conditionsRS(new HashSet<>(Set.of(conditionByRouteBack)));
        assertThat(promotion.getConditionsRS()).containsOnly(conditionByRouteBack);
        assertThat(conditionByRouteBack.getPromotion()).isEqualTo(promotion);

        promotion.setConditionsRS(new HashSet<>());
        assertThat(promotion.getConditionsRS()).doesNotContain(conditionByRouteBack);
        assertThat(conditionByRouteBack.getPromotion()).isNull();
    }

    @Test
    void conditionsDTest() {
        Promotion promotion = getPromotionRandomSampleGenerator();
        ConditionByDate conditionByDateBack = getConditionByDateRandomSampleGenerator();

        promotion.addConditionsD(conditionByDateBack);
        assertThat(promotion.getConditionsDS()).containsOnly(conditionByDateBack);
        assertThat(conditionByDateBack.getPromotion()).isEqualTo(promotion);

        promotion.removeConditionsD(conditionByDateBack);
        assertThat(promotion.getConditionsDS()).doesNotContain(conditionByDateBack);
        assertThat(conditionByDateBack.getPromotion()).isNull();

        promotion.conditionsDS(new HashSet<>(Set.of(conditionByDateBack)));
        assertThat(promotion.getConditionsDS()).containsOnly(conditionByDateBack);
        assertThat(conditionByDateBack.getPromotion()).isEqualTo(promotion);

        promotion.setConditionsDS(new HashSet<>());
        assertThat(promotion.getConditionsDS()).doesNotContain(conditionByDateBack);
        assertThat(conditionByDateBack.getPromotion()).isNull();
    }

    @Test
    void conditionsLocTest() {
        Promotion promotion = getPromotionRandomSampleGenerator();
        ConditionByLocation conditionByLocationBack = getConditionByLocationRandomSampleGenerator();

        promotion.addConditionsLoc(conditionByLocationBack);
        assertThat(promotion.getConditionsLocs()).containsOnly(conditionByLocationBack);
        assertThat(conditionByLocationBack.getPromotion()).isEqualTo(promotion);

        promotion.removeConditionsLoc(conditionByLocationBack);
        assertThat(promotion.getConditionsLocs()).doesNotContain(conditionByLocationBack);
        assertThat(conditionByLocationBack.getPromotion()).isNull();

        promotion.conditionsLocs(new HashSet<>(Set.of(conditionByLocationBack)));
        assertThat(promotion.getConditionsLocs()).containsOnly(conditionByLocationBack);
        assertThat(conditionByLocationBack.getPromotion()).isEqualTo(promotion);

        promotion.setConditionsLocs(new HashSet<>());
        assertThat(promotion.getConditionsLocs()).doesNotContain(conditionByLocationBack);
        assertThat(conditionByLocationBack.getPromotion()).isNull();
    }
}
