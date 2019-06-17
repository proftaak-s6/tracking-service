package nl.fontysproject.trackingservice.web.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class LocationDto {

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String date;

    @NotNull
    private double lat;

    @NotNull
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }
}