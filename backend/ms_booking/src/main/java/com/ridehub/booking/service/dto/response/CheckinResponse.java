package com.ridehub.booking.service.dto.response;

public class CheckinResponse {
    private boolean checkedIn;

    public CheckinResponse(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }
}