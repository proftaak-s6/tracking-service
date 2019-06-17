package nl.fontysproject.trackingservice.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Step {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int distance;

    @OneToOne
    private Location location;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    @JsonBackReference
    private Route route;


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getDistance() {
        return this.distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Route getRoute() {
        return this.route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

}