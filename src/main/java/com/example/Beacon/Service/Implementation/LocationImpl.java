package com.example.Beacon.Service.Implementation;

import com.example.Beacon.Model.Location;
import com.example.Beacon.Repositery.LocationRepo;
import com.example.Beacon.Service.LocationService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Data
public class LocationImpl implements LocationService {

    @Autowired
    private LocationRepo locationRepo;


    @Override
    public Location addLocation(Location location) {
        return locationRepo.save(location);
    }

    @Override
    public Location getLocationById(Long id) {
        return locationRepo.findById(id).orElseThrow(() -> new NoSuchElementException("No Such Location Exist"));
    }

    @Override
    public List<Location> getAllLocation() {
        return locationRepo.findAll();
    }

    @Override
    public Location updateLocation(Long id, Location location) {
        Location tempLocation = locationRepo.findById(id).orElseThrow(() -> new NoSuchElementException("No Such Location Exist"));
        tempLocation = location;
        locationRepo.save(tempLocation);
        return locationRepo.findById(id).get();

    }

    @Override
    public void deleteLocation(Long id) {
        locationRepo.deleteById(id);
    }
}
