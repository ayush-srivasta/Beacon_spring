package com.example.Beacon.Repositery;

import com.example.Beacon.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users, Long> {
}
