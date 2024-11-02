package services;

import dao.LocationDao;
import model.Location;

public class LocationService {
    private LocationDao locationDao;

    public LocationService(LocationDao locationDao) {
        this.locationDao = locationDao;
    }

    public void registerLocation(Location location) {
    }
}
