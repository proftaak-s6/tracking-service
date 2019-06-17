package nl.fontysproject.trackingservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Step {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int distance;
    private Location location;


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
}