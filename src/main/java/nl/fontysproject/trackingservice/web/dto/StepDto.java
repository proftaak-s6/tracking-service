package nl.fontysproject.trackingservice.web.dto;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class StepDto {

    @NotNull
    @Min(1)
    private int distance;

    @Valid
    private LocationDto location;

    public int getDistance() {
        return distance;
    }

    public LocationDto getLocation() {
        return location;
    }

    public void setLocation(LocationDto location) {
        this.location = location;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}