package nl.fontysproject.trackingservice.web.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("trackings")
public class TrackingController {

    @GET
    @Path("/{trackerId}/{year}/{month}")
    public Response get() {
       return Response.ok("Hello").build(); 
    }
}