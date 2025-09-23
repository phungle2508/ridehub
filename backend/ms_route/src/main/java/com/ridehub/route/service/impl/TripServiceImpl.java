package com.ridehub.route.service.impl;

import com.ridehub.route.domain.Trip;
import com.ridehub.route.domain.enumeration.VehicleType;
import com.ridehub.route.repository.TripRepository;
import com.ridehub.route.service.TripService;
import com.ridehub.route.service.dto.RouteListDTO;
import com.ridehub.route.service.dto.TripDTO;
import com.ridehub.route.service.mapper.TripMapper;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.ridehub.route.domain.Trip}.
 */
@Service
@Transactional
public class TripServiceImpl implements TripService {

    private static final Logger LOG = LoggerFactory.getLogger(TripServiceImpl.class);

    private final TripRepository tripRepository;

    private final TripMapper tripMapper;

    public TripServiceImpl(TripRepository tripRepository, TripMapper tripMapper) {
        this.tripRepository = tripRepository;
        this.tripMapper = tripMapper;
    }

    @Override
    public TripDTO save(TripDTO tripDTO) {
        LOG.debug("Request to save Trip : {}", tripDTO);
        Trip trip = tripMapper.toEntity(tripDTO);
        trip = tripRepository.save(trip);
        return tripMapper.toDto(trip);
    }

    @Override
    public TripDTO update(TripDTO tripDTO) {
        LOG.debug("Request to update Trip : {}", tripDTO);
        Trip trip = tripMapper.toEntity(tripDTO);
        trip = tripRepository.save(trip);
        return tripMapper.toDto(trip);
    }

    @Override
    public Optional<TripDTO> partialUpdate(TripDTO tripDTO) {
        LOG.debug("Request to partially update Trip : {}", tripDTO);

        return tripRepository
                .findById(tripDTO.getId())
                .map(existingTrip -> {
                    tripMapper.partialUpdate(existingTrip, tripDTO);

                    return existingTrip;
                })
                .map(tripRepository::save)
                .map(tripMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TripDTO> findOne(Long id) {
        LOG.debug("Request to get Trip : {}", id);
        return tripRepository.findById(id).map(tripMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete Trip : {}", id);
        tripRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<RouteListDTO> getRouteList(Pageable pageable) {
        LOG.debug("Request to get route list with pagination: {}", pageable);

        // Get all trips with their related data
        Page<Trip> trips = tripRepository.findAll(pageable);

        // Convert to RouteListDTO
        List<RouteListDTO> routeListDTOs = trips.getContent().stream()
                .map(this::convertToRouteListDTO)
                .collect(Collectors.toList());

        return new PageImpl<>(routeListDTOs, pageable, trips.getTotalElements());
    }

    private RouteListDTO convertToRouteListDTO(Trip trip) {
        // Extract route information
        String origin = trip.getRoute() != null && trip.getRoute().getOrigin() != null
                ? trip.getRoute().getOrigin().getName()
                : "Unknown";
        String destination = trip.getRoute() != null && trip.getRoute().getDestination() != null
                ? trip.getRoute().getDestination().getName()
                : "Unknown";

        // Since there's no direct relationship between Trip and Vehicle,
        // we'll use mock data for now. You should add this relationship later.
        VehicleType mockVehicleType = VehicleType.LIMOUSINE; // Mock data
        String mockPlateNumber = "29A-12345"; // Mock data
        String mockVehicleBrand = "Mercedes"; // Mock data

        // Extract driver information
        Long driverId = trip.getDriver() != null ? trip.getDriver().getId() : null;
        String driverLicenseClass = trip.getDriver() != null ? trip.getDriver().getLicenseClass() : null;
        Integer driverYearsExperience = trip.getDriver() != null ? trip.getDriver().getYearsExperience() : null;

        return new RouteListDTO(
                trip.getId(),
                trip.getTripCode(),
                trip.getRoute() != null ? trip.getRoute().getRouteCode() : null,
                origin,
                destination,
                trip.getRoute() != null ? trip.getRoute().getDistanceKm() : null,
                trip.getDepartureTime(),
                trip.getArrivalTime(),
                mockVehicleType,
                mockPlateNumber,
                mockVehicleBrand,
                driverId,
                driverLicenseClass,
                driverYearsExperience,
                trip.getBaseFare());
    }
}
