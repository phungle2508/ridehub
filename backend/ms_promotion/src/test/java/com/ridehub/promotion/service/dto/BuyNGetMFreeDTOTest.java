package com.ridehub.promotion.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.ridehub.promotion.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class BuyNGetMFreeDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(BuyNGetMFreeDTO.class);
        BuyNGetMFreeDTO buyNGetMFreeDTO1 = new BuyNGetMFreeDTO();
        buyNGetMFreeDTO1.setId(1L);
        BuyNGetMFreeDTO buyNGetMFreeDTO2 = new BuyNGetMFreeDTO();
        assertThat(buyNGetMFreeDTO1).isNotEqualTo(buyNGetMFreeDTO2);
        buyNGetMFreeDTO2.setId(buyNGetMFreeDTO1.getId());
        assertThat(buyNGetMFreeDTO1).isEqualTo(buyNGetMFreeDTO2);
        buyNGetMFreeDTO2.setId(2L);
        assertThat(buyNGetMFreeDTO1).isNotEqualTo(buyNGetMFreeDTO2);
        buyNGetMFreeDTO1.setId(null);
        assertThat(buyNGetMFreeDTO1).isNotEqualTo(buyNGetMFreeDTO2);
    }
}
