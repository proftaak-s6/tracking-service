package nl.fontysproject.registration.api.web.controller;

import nl.fontysproject.registration.api.model.Registration;
import nl.fontysproject.registration.api.service.RegistrationService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.Collections;

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
