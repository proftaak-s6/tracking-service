package nl.fontysproject.trackingservice.web.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Route {

    @Min(value = 1)
    private int trackerId;

    @NotNull
    @NotEmpty
    @Valid
    private List<Step> steps;

    public int getTrackerId() {
        return trackerId;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public void setTrackerId(int trackerId) {
        this.trackerId = trackerId;
    }
}