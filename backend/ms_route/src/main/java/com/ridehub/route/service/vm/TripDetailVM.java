package com.ridehub.route.service.vm;

import java.util.List;

import com.ridehub.route.service.dto.TripDTO;
import com.ridehub.route.service.dto.TripSeatDTO;

public class TripDetailVM {

    private TripDTO tripDTO;
    private VehicleDetailVM detailVM;
    private List<TripSeatDTO> tripSeatDTOs;

    public TripDetailVM(TripDTO trip, VehicleDetailVM detailVM,
            List<TripSeatDTO> tripSeatDTOs) {
        this.tripDTO = trip;
        this.detailVM = detailVM;
        this.tripSeatDTOs = tripSeatDTOs;
    }

    public TripDTO getTripDTO() {
        return tripDTO;
    }

    public void setTripDTO(TripDTO tripDTO) {
        this.tripDTO = tripDTO;
    }

    public VehicleDetailVM getDetailVM() {
        return detailVM;
    }

    public void setDetailVM(VehicleDetailVM detailVM) {
        this.detailVM = detailVM;
    }

    public List<TripSeatDTO> getTripSeatDTOs() {
        return tripSeatDTOs;
    }

    public void setTripSeatDTOs(List<TripSeatDTO> tripSeatDTOs) {
        this.tripSeatDTOs = tripSeatDTOs;
    }

}
