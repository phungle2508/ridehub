package com.ridehub.booking.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.ridehub.booking.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class PricingSnapshotDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(PricingSnapshotDTO.class);
        PricingSnapshotDTO pricingSnapshotDTO1 = new PricingSnapshotDTO();
        pricingSnapshotDTO1.setId(1L);
        PricingSnapshotDTO pricingSnapshotDTO2 = new PricingSnapshotDTO();
        assertThat(pricingSnapshotDTO1).isNotEqualTo(pricingSnapshotDTO2);
        pricingSnapshotDTO2.setId(pricingSnapshotDTO1.getId());
        assertThat(pricingSnapshotDTO1).isEqualTo(pricingSnapshotDTO2);
        pricingSnapshotDTO2.setId(2L);
        assertThat(pricingSnapshotDTO1).isNotEqualTo(pricingSnapshotDTO2);
        pricingSnapshotDTO1.setId(null);
        assertThat(pricingSnapshotDTO1).isNotEqualTo(pricingSnapshotDTO2);
    }
}
