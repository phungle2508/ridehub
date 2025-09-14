package com.ticketsystem.route.service.mapper;

import static com.ticketsystem.route.domain.RouteAsserts.*;
import static com.ticketsystem.route.domain.RouteTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RouteMapperTest {

    private RouteMapper routeMapper;

    @BeforeEach
    void setUp() {
        routeMapper = new RouteMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getRouteSample1();
        var actual = routeMapper.toEntity(routeMapper.toDto(expected));
        assertRouteAllPropertiesEquals(expected, actual);
    }
}
