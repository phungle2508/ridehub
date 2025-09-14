package com.ticketsystem.route.domain;

import static com.ticketsystem.route.domain.AddressTestSamples.*;
import static com.ticketsystem.route.domain.WardTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.ticketsystem.route.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class AddressTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Address.class);
        Address address1 = getAddressSample1();
        Address address2 = new Address();
        assertThat(address1).isNotEqualTo(address2);

        address2.setId(address1.getId());
        assertThat(address1).isEqualTo(address2);

        address2 = getAddressSample2();
        assertThat(address1).isNotEqualTo(address2);
    }

    @Test
    void wardTest() {
        Address address = getAddressRandomSampleGenerator();
        Ward wardBack = getWardRandomSampleGenerator();

        address.setWard(wardBack);
        assertThat(address.getWard()).isEqualTo(wardBack);

        address.ward(null);
        assertThat(address.getWard()).isNull();
    }
}
