package nl.fontysproject.trackingservice.web.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import nl.fontysproject.trackingservice.model.Step;
import nl.fontysproject.trackingservice.service.TrackingService;

@Path("trackings")
@Produces(MediaType.APPLICATION_JSON)
public class TrackingController {

    @Inject
    private TrackingService service;

    @GET
    @Path("/{trackerId}/{year}/{month}")
    public Response get(@PathParam("trackerId") long trackerId, @PathParam("year") int year, @PathParam("month") int month) {
        List<Step> steps = service.get(trackerId, year, month);

        if (steps == null || steps.isEmpty()) {
            return Response.noContent()
                    .entity("No data for tracker with ID: " + trackerId + " at " + month + "/" + year).build();
        }

        return Response.ok(steps).build();
    }
}