package com.ridehub.promotion.service.criteria;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

class FilePromotionCriteriaTest {

    @Test
    void newFilePromotionCriteriaHasAllFiltersNullTest() {
        var filePromotionCriteria = new FilePromotionCriteria();
        assertThat(filePromotionCriteria).is(criteriaFiltersAre(Objects::isNull));
    }

    @Test
    void filePromotionCriteriaFluentMethodsCreatesFiltersTest() {
        var filePromotionCriteria = new FilePromotionCriteria();

        setAllFilters(filePromotionCriteria);

        assertThat(filePromotionCriteria).is(criteriaFiltersAre(Objects::nonNull));
    }

    @Test
    void filePromotionCriteriaCopyCreatesNullFilterTest() {
        var filePromotionCriteria = new FilePromotionCriteria();
        var copy = filePromotionCriteria.copy();

        assertThat(filePromotionCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::isNull)),
            criteria -> assertThat(criteria).isEqualTo(filePromotionCriteria)
        );
    }

    @Test
    void filePromotionCriteriaCopyDuplicatesEveryExistingFilterTest() {
        var filePromotionCriteria = new FilePromotionCriteria();
        setAllFilters(filePromotionCriteria);

        var copy = filePromotionCriteria.copy();

        assertThat(filePromotionCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::nonNull)),
            criteria -> assertThat(criteria).isEqualTo(filePromotionCriteria)
        );
    }

    @Test
    void toStringVerifier() {
        var filePromotionCriteria = new FilePromotionCriteria();

        assertThat(filePromotionCriteria).hasToString("FilePromotionCriteria{}");
    }

    private static void setAllFilters(FilePromotionCriteria filePromotionCriteria) {
        filePromotionCriteria.id();
        filePromotionCriteria.bucket();
        filePromotionCriteria.objectKey();
        filePromotionCriteria.contentType();
        filePromotionCriteria.size();
        filePromotionCriteria.isBanner();
        filePromotionCriteria.createdAt();
        filePromotionCriteria.updatedAt();
        filePromotionCriteria.isDeleted();
        filePromotionCriteria.deletedAt();
        filePromotionCriteria.deletedBy();
        filePromotionCriteria.promotionId();
        filePromotionCriteria.distinct();
    }

    private static Condition<FilePromotionCriteria> criteriaFiltersAre(Function<Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId()) &&
                condition.apply(criteria.getBucket()) &&
                condition.apply(criteria.getObjectKey()) &&
                condition.apply(criteria.getContentType()) &&
                condition.apply(criteria.getSize()) &&
                condition.apply(criteria.getIsBanner()) &&
                condition.apply(criteria.getCreatedAt()) &&
                condition.apply(criteria.getUpdatedAt()) &&
                condition.apply(criteria.getIsDeleted()) &&
                condition.apply(criteria.getDeletedAt()) &&
                condition.apply(criteria.getDeletedBy()) &&
                condition.apply(criteria.getPromotionId()) &&
                condition.apply(criteria.getDistinct()),
            "every filter matches"
        );
    }

    private static Condition<FilePromotionCriteria> copyFiltersAre(
        FilePromotionCriteria copy,
        BiFunction<Object, Object, Boolean> condition
    ) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId(), copy.getId()) &&
                condition.apply(criteria.getBucket(), copy.getBucket()) &&
                condition.apply(criteria.getObjectKey(), copy.getObjectKey()) &&
                condition.apply(criteria.getContentType(), copy.getContentType()) &&
                condition.apply(criteria.getSize(), copy.getSize()) &&
                condition.apply(criteria.getIsBanner(), copy.getIsBanner()) &&
                condition.apply(criteria.getCreatedAt(), copy.getCreatedAt()) &&
                condition.apply(criteria.getUpdatedAt(), copy.getUpdatedAt()) &&
                condition.apply(criteria.getIsDeleted(), copy.getIsDeleted()) &&
                condition.apply(criteria.getDeletedAt(), copy.getDeletedAt()) &&
                condition.apply(criteria.getDeletedBy(), copy.getDeletedBy()) &&
                condition.apply(criteria.getPromotionId(), copy.getPromotionId()) &&
                condition.apply(criteria.getDistinct(), copy.getDistinct()),
            "every filter matches"
        );
    }
}
