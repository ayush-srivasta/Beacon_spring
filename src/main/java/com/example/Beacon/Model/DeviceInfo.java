package com.example.Beacon.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class DeviceInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long device_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user_id;
    @OneToOne
    private Sessions session_id;
    private String device_model;
    private Integer battery_level;
    private String os_version;
    private String app_version;

}
