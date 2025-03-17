package com.example.Beacon.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long user_id;

    private String user_name;

    private String user_mob;
    private String email;
    //for furthur inhancement
    private boolean verified = false;

    @OneToMany(mappedBy = "session_id")
    private List<Sessions> session_id;

    @OneToMany
    private List<DeviceInfo> deviceInfo;
}
