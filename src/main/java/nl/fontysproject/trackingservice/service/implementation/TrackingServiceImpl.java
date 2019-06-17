package nl.fontysproject.trackingservice.service.implementation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import nl.fontysproject.trackingservice.model.Step;
import nl.fontysproject.trackingservice.service.TrackingService;

@ApplicationScoped
public class TrackingServiceImpl implements TrackingService {

    @PersistenceContext(name = "PU")
    private EntityManager manager;

    @Override
    public List<Step> get(long trackerId, final int year, final int month) {
        // if (trackerId == 1) {
        //     return new ArrayList<Step>() {
        //         private static final long serialVersionUID = 1L;

        //         {
        //             add(createStep(234, "Tilburg", year, month));
        //             add(createStep(128, "Dongenseweg", year, month));
        //             add(createStep(4544, "A27", year, month));
        //             add(createStep(2044, "Minister Ruys de Beerenbrouckstraat", year, month));
        //             add(createStep(12344, "N013", year, month));
        //         }
        //     };
        // } else {
        //     return null;
        // }

        TypedQuery<Step> query = manager.createQuery("SELECT s FROM Step s WHERE s.trackerId = :trackerId AND s.year = :year AND s.month = :month", Step.class);
        query.setParameter("trackerId", trackerId);
        query.setParameter("year", year);
        query.setParameter("month", month);
        return query.getResultList();
    }

    private Step createStep(int distance, String locationName, int year, int month) {
        // Step step = new Step();
        // Location location = new Location();

        // location.setName(locationName);
        // LocalDateTime date = LocalDateTime.parse(
        //         year + "-" + month + "-" + ThreadLocalRandom.current().nextInt(1, 27 + 1) + "T00:00:00",
        //         DateTimeFormatter.ofPattern("yyyy-MM-d'T'HH:mm:ss"));
        // location.setDate(date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));

        // step.setDistance(distance);
        // step.setLocation(location);

        return null;
    }
}