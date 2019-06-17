package nl.fontysproject.trackingservice.web.dto;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Step {

    @NotNull
    @Min(1)
    private int distance;

    @Valid
    private Location location;

    public int getDistance() {
        return distance;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}