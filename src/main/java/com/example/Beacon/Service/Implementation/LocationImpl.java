package com.example.Beacon.Service.Implementation;

import com.example.Beacon.Model.Location;
import com.example.Beacon.Repositery.LocationRepo;
import com.example.Beacon.Service.LocationService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    public String updateLocation(Long id, String lattitude) {
        Location location1 = locationRepo.findById(id).orElseThrow(() -> new RuntimeException("Location not found"));
        location1.setLast_updated(LocalDateTime.now());
        location1.setLatest_location(lattitude);
        List<String> history = location1.getLocation_history();

        history.add(lattitude);
        location1.setLocation_history(history);
        locationRepo.save(location1);
        return lattitude;

    }

    @Override
    public void deleteLocation(Long id) {
        locationRepo.deleteById(id);
    }
}
