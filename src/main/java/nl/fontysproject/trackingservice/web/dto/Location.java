package nl.fontysproject.trackingservice.web.dto;

import java.time.LocalDate;

public class Location {
    private String name;
    private LocalDate date;
    private double lat;
    private double lng;

    public String getName() {
        return name;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }
}