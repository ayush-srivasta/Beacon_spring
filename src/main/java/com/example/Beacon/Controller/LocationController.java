package com.example.Beacon.Controller;

import com.example.Beacon.Model.Location;
import com.example.Beacon.Service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    public List<Location> getAllLocations() {
        return locationService.getAllLocation();
    }

    @GetMapping("/{id}")
    public Location getLocationById(@PathVariable Long id) {
        return locationService.getLocationById(id);
    }

    @PostMapping
    public Location createLocation(@RequestBody Location location) {
        return locationService.addLocation(location);
    }

    @PutMapping("/update")
    public Location udateLocationById(@RequestParam Long id, @RequestBody String location) {
        locationService.updateLocation(id, location);
        return locationService.getLocationById(id);
    }

    @GetMapping("/history")
    public List<String> allCoordinates(@RequestParam Long id) {
        List<String> strings = locationService.getLocationById(id).getLocation_history();
        return strings;
    }

    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable Long id) {
        locationService.deleteLocation(id);
    }
}
