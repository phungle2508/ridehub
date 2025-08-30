package com.ticketsystem.route.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.ticketsystem.route.web.rest.TestUtil;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class RouteDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(RouteDTO.class);
        RouteDTO routeDTO1 = new RouteDTO();
        routeDTO1.setId(UUID.randomUUID());
        RouteDTO routeDTO2 = new RouteDTO();
        assertThat(routeDTO1).isNotEqualTo(routeDTO2);
        routeDTO2.setId(routeDTO1.getId());
        assertThat(routeDTO1).isEqualTo(routeDTO2);
        routeDTO2.setId(UUID.randomUUID());
        assertThat(routeDTO1).isNotEqualTo(routeDTO2);
        routeDTO1.setId(null);
        assertThat(routeDTO1).isNotEqualTo(routeDTO2);
    }
}
