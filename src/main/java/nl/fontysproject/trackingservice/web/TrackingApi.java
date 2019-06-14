package nl.fontysproject.trackingservice.web;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(
        title = "Rekeningrijden | Tracking API",
        version = "0.0.1")
)
@ApplicationPath("")
public class TrackingApi extends Application {

}