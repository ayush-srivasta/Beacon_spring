package com.example.Beacon.Repositery;

import com.example.Beacon.Model.Sessions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepo extends JpaRepository<Sessions, Long> {
}
