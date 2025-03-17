package com.example.Beacon.Model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Sessions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long session_id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user_id;
    private String deep_link;
    private Date start_time;
    private Date end_time;
    @OneToOne
    private DeviceInfo deviceInfo;
    @OneToMany(mappedBy = "location_id")
    private List<Location> location_id;

}
