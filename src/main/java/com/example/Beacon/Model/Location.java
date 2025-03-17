package com.example.Beacon.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long location_id;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Sessions session_id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user_id;

    private Date last_updated;
    private String latest_location;
    private String location_history;
}
