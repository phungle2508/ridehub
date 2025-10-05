package com.ridehub.booking.service.dto;

/**
 * Response DTO for ticket check-in operation.
 */
public class CheckInResponse {
    
    private boolean checkedIn;
    
    public CheckInResponse() {}
    
    public CheckInResponse(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }
    
    public boolean isCheckedIn() {
        return checkedIn;
    }
    
    public void setCheckedIn(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }
}
