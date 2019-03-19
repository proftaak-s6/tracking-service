package nl.fontysproject.registration.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Registration {

    @GeneratedValue
    @Id
    private UUID id;

    @Column
    private UUID carTrackerId;

    @Column
    private int sequenceNumber;

    @Column
    private double longtitude;

    @Column
    private double latitude;

    //region getters & setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getCarTrackerId() {
        return carTrackerId;
    }

    public void setCarTrackerId(UUID carTrackerId) {
        this.carTrackerId = carTrackerId;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    //endregion
}
