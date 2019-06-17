package nl.fontysproject.trackingservice.service.implementation;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import nl.fontysproject.trackingservice.model.Route;
import nl.fontysproject.trackingservice.model.Step;
import nl.fontysproject.trackingservice.service.TrackingService;

@ApplicationScoped
public class TrackingServiceImpl implements TrackingService {

    @PersistenceContext(name = "PU")
    private EntityManager manager;

    @Override
    public List<Step> get(long trackerId, final int year, final int month) {
        TypedQuery<Step> query = manager.createQuery("SELECT s FROM Step s JOIN s.route JOIN s.location WHERE s.route.trackerId = :trackerId AND MONTH(s.location.date) = :month AND YEAR(s.location.date) = :year", Step.class);
        query.setParameter("trackerId", new Long(trackerId).intValue());
        query.setParameter("year", year);
        query.setParameter("month", month);
        return query.getResultList();
    }

    @Override
    @Transactional
    public long add(Route route){
        manager.merge(route);
        return route.getId();
    }
}