package com.example.Beacon.Service;

import com.example.Beacon.Model.Location;

import java.util.List;

public interface LocationService {

    public Location addLocation(Location location);

    public Location getLocationById(Long id);

    public List<Location> getAllLocation();

    public Location updateLocation(Long id, Location location);

    public void deleteLocation(Long id);
}
