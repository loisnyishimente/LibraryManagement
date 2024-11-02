package model;

public class Location {
    private String locationCode;
    private String locationName;
    private String locationType;
    private Integer parentId; // Use Integer to allow null values

    // Constructor for parent location
    public Location(String locationCode, String locationName, String locationType) {
        this.locationCode = locationCode;
        this.locationName = locationName;
        this.locationType = locationType;
        this.parentId = null; // No parent for top-level locations
    }

    // Constructor for child location
    public Location(String locationCode, String locationName, String locationType, Integer parentId) {
        this.locationCode = locationCode;
        this.locationName = locationName;
        this.locationType = locationType;
        this.parentId = parentId;
    }

    // Getters and Setters
    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}
