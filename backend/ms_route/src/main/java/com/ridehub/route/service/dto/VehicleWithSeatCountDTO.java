package com.ridehub.route.service.dto;

import java.io.Serializable;

public class VehicleWithSeatCountDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long seatsCount;
    private VehicleDTO vehicleDTO;

    public VehicleWithSeatCountDTO() {
    }

    public VehicleWithSeatCountDTO(Long seatsCount, VehicleDTO vehicleDTO) {
        this.seatsCount = seatsCount;
        this.vehicleDTO = vehicleDTO;
    }

    public Long getSeatsCount() {
        return seatsCount;
    }

    public void setSeatsCount(Long seatsCount) {
        this.seatsCount = seatsCount;
    }

    public VehicleDTO getVehicleDTO() {
        return vehicleDTO;
    }

    public void setVehicleDTO(VehicleDTO vehicleDTO) {
        this.vehicleDTO = vehicleDTO;
    }
}
