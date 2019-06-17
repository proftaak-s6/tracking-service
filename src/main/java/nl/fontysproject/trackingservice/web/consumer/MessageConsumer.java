package nl.fontysproject.trackingservice.web.consumer;

import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import com.google.gson.Gson;
import com.kumuluz.ee.amqp.common.annotations.AMQPConsumer;

import nl.fontysproject.trackingservice.model.Route;
import nl.fontysproject.trackingservice.service.TrackingService;
import nl.fontysproject.trackingservice.web.dto.RouteDto;

@ApplicationScoped
public class MessageConsumer {

    @Inject
    private TrackingService trackingService;

    private static Logger log = Logger.getLogger(MessageConsumer.class.getName());

    private Gson jsonParser = new Gson();
    private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @AMQPConsumer(host = "rabbitmq", exchange = "trackingExchange", key = "newTrack")
    public void onMessage(String message) {
        try {
            RouteDto routeDto = parseRoute(message);

            Set<ConstraintViolation<RouteDto>> violations = validator.validate(routeDto);

            if (!violations.isEmpty()) {
                log.warning("Parsed route has validation errors.\n" + String
                    .join("\n", violations.stream()
                        .map(v -> v.getPropertyPath() +  ": " + v.getMessage())
                        .collect(Collectors.toList())));
                return;
            }

            // Route route = routeDto.toModel();
            // log.info("Entity:\n" + jsonParser.toJson(route));
            long id = trackingService.add(routeDto.toModel());
            log.info("Persisted route with id: " + id);

        } catch (Exception e) {
            log.warning(e.getMessage());
            log.warning("Could not parse Route from JSON: " + message);
        }
    }

    private RouteDto parseRoute(String json) {
        return jsonParser.fromJson(json, RouteDto.class);
    }
}