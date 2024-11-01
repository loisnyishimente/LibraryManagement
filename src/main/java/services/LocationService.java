package services;

import model.Location;

import java.util.ArrayList;
import java.util.List;

public class LocationService {
    private List<Location> locations = new ArrayList<>();

    public void addLocation(Location location) {
        locations.add(location);
    }

    public String getLocationByProvince(String province) {
        for (Location location : locations) {
            if (location.getProvince().equalsIgnoreCase(province)) {
                return location.getProvince();
            }
        }
        return null;
    }

    public Object saveLocation(Location location) {
        return null;
    }
}
