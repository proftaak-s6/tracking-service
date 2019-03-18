package nl.fontysproject.registration.api.web;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.BeforeClass;

import javax.ws.rs.core.Application;

import static org.junit.Assert.*;

public class RegistrationControllerTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(RegistrationController.class);
    }
}