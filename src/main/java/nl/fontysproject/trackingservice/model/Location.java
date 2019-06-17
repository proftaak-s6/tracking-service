package nl.fontysproject.trackingservice.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "step_id", referencedColumnName = "id")
    @JsonBackReference
    private Step step;

    private String name;
    private String date;
    private double lat;
    private double lng;


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Step getStep() {
        return this.step;
    }

    public void setStep(Step step) {
        this.step = step;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getLat() {
        return this.lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return this.lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}