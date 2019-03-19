package nl.fontysproject.registration.api.web.controller;

import nl.fontysproject.registration.api.service.RegistrationService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/registrations")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RegistrationController {

    @Inject
    private RegistrationService service;

    @GET
    public Response getAll() {
        return Response.ok(service.getAll())
                .build();
    }
}
