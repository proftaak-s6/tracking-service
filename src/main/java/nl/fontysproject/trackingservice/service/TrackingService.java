package nl.fontysproject.trackingservice.service;

import java.util.List;

import nl.fontysproject.trackingservice.model.Step;


public interface TrackingService {
    List<Step> get(long trackerId, int year, int month);
}