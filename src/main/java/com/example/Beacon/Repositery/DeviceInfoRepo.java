package com.example.Beacon.Repositery;

import com.example.Beacon.Model.DeviceInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceInfoRepo extends JpaRepository<DeviceInfo, Long> {
}
