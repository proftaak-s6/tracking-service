package nl.fontysproject.trackingservice.web.consumer;

import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import com.google.gson.Gson;
import com.kumuluz.ee.amqp.common.annotations.AMQPConsumer;

import nl.fontysproject.trackingservice.web.dto.Route;

@ApplicationScoped
public class MessageConsumer {
    private static Logger log = Logger.getLogger(MessageConsumer.class.getName());

    private Gson jsonParser = new Gson();
    private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @AMQPConsumer(host = "rabbitmq", exchange = "trackingExchange", key = "newTrack")
    public void onMessage(String message) {
        try {
            Route route = parseRoute(message);

            Set<ConstraintViolation<Route>> violations = validator.validate(route);

            if (!violations.isEmpty()) {
                log.warning("Parsed route has validation errors.\n" + String
                    .join("\n", violations.stream()
                        .map(v -> v.getPropertyPath() +  ": " + v.getMessage())
                        .collect(Collectors.toList())));
                return;
            }

            log.info("Got route: " + jsonParser.toJson(route));
        } catch (Exception e) {
            log.warning(e.getMessage());
            log.warning("Could not parse Route from JSON: " + message);
        }
    }

    private Route parseRoute(String json) {
        return jsonParser.fromJson(json, Route.class);
    }
}