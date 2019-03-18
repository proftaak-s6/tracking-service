package nl.fontysproject.registration.api.service;

import nl.fontysproject.registration.api.model.Registration;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class JpaRegistrationService implements RegistrationService {

    @PersistenceContext(unitName = "PU")
    private EntityManager manager;

    @Override
    public List<Registration> getAll() {
        return manager.createQuery("SELECT r FROM Registration r", Registration.class).getResultList();
    }
}
