package nl.fontysproject.trackingservice.web.dto;

public class Step {
    private int distance;
    private Location location;

    public int getDistance() {
        return distance;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}