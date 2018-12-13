package com.example.administrator.layouttest001.data;

public class LocationHint {

    private String locationName;
    private String LocationAddress;

    public LocationHint(String locationName, String locationAddress) {
        this.locationName = locationName;
        LocationAddress = locationAddress;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationAddress() {
        return LocationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        LocationAddress = locationAddress;
    }
}
