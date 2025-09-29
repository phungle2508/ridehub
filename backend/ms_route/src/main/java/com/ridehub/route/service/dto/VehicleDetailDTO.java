package com.ridehub.route.service.dto;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class VehicleDetailDTO implements Serializable {
    private VehicleDTO vehicle; // your existing DTO
    private List<FloorDTO> floors; // separate list (not inside SeatMapDTO)
    private Map<Long, List<SeatDTO>> seatsByFloorId; // seats grouped by floor

    public VehicleDetailDTO(VehicleDTO vehicle, List<FloorDTO> floors, Map<Long, List<SeatDTO>> seatsByFloorId) {
        this.vehicle = vehicle;
        this.floors = floors;
        this.seatsByFloorId = seatsByFloorId;
    }

    public VehicleDTO getVehicle() {
        return vehicle;
    }

    public List<FloorDTO> getFloors() {
        return floors;
    }

    public Map<Long, List<SeatDTO>> getSeatsByFloorId() {
        return seatsByFloorId;
    }
}
