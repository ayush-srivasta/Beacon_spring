package com.example.Beacon.Repositery;

import com.example.Beacon.Model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepo extends JpaRepository<Location, Long> {
}
