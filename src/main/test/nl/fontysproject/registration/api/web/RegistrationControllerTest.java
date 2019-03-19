package nl.fontysproject.registration.api.web;

import nl.fontysproject.registration.api.model.Registration;
import nl.fontysproject.registration.api.service.RegistrationService;
import nl.fontysproject.registration.api.web.controller.RegistrationController;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RegistrationControllerTest extends JerseyTest {

    private RegistrationService serviceMock = mock(RegistrationService.class);

    @Override
    protected Application configure() {
        return new ResourceConfig(RegistrationController.class)
                .register(new AbstractBinder() {
                    @Override
                    protected void configure() {
                        bind(serviceMock).to(RegistrationService.class);
                    }
                });
    }

    @Test
    public void getRegistrations_Returns200AndListOfRegistrations() {
        when(serviceMock.getAll()).thenReturn(Arrays.asList(new Registration(), new Registration()));

        Response response = target("/registrations").request().get();

        assertEquals(200, response.getStatus());
        assertEquals(Registration[].class, response.readEntity(Registration[].class).getClass());
    }
}