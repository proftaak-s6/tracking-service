package nl.fontysproject.registration.api.web;

import nl.fontysproject.registration.api.model.Registration;
import nl.fontysproject.registration.api.web.controller.RegistrationController;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import static org.junit.Assert.*;

public class RegistrationControllerTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(RegistrationController.class);
    }

    @Test
    public void getRegistrations_Returns200AndListOfRegistrations() {
        Response response = target("registrations").request().get();

        assertEquals(200, response.getStatus());
        assertEquals(Registration[].class, response.readEntity(Registration[].class).getClass());
    }
}