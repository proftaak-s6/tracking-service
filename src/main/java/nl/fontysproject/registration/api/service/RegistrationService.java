package nl.fontysproject.registration.api.service;

import nl.fontysproject.registration.api.model.Registration;

import java.util.List;

public interface RegistrationService {
    List<Registration> getAll();
}
