package nl.fontysproject.trackingservice.web.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import nl.fontysproject.trackingservice.model.Route;
import nl.fontysproject.trackingservice.model.Step;

public class RouteDto {

    @Min(value = 1)
    private int trackerId;

    @NotNull
    @NotEmpty
    @Valid
    private List<StepDto> steps;

    public Route toModel() {
        Route route = new Route();

        route.setTrackerId(trackerId);
        route.setSteps(steps.stream().map(StepDto::toModel).collect(Collectors.toList()));

        for (Step s : route.getSteps()) {
            s.getLocation().setStep(s);
            s.setRoute(route);
        }

        return route;
    }

    public int getTrackerId() {
        return trackerId;
    }

    public List<StepDto> getSteps() {
        return steps;
    }

    public void setSteps(List<StepDto> steps) {
        this.steps = steps;
    }

    public void setTrackerId(int trackerId) {
        this.trackerId = trackerId;
    }
}