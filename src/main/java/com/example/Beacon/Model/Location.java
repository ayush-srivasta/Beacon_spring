package com.example.Beacon.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity

public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long location_id;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Sessions session;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user_id;

    private LocalDateTime last_updated;
    private String latest_location;
    @ElementCollection
    private List<String> location_history;

    @Override
    public String toString() {
        return "Location{" +
                "location_id=" + location_id +
                ", session=" + session +
                ", user_id=" + user_id +
                ", last_updated=" + last_updated +
                ", latest_location='" + latest_location + '\'' +
                ", location_history=" + location_history +
                '}';
    }

    public Long getLocation_id() {
        return location_id;
    }

    public void setLocation_id(Long location_id) {
        this.location_id = location_id;
    }

    public Sessions getSession() {
        return session;
    }

    public void setSession(Sessions session) {
        this.session = session;
    }

    public Users getUser_id() {
        return user_id;
    }

    public void setUser_id(Users user_id) {
        this.user_id = user_id;
    }

    public LocalDateTime getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(LocalDateTime last_updated) {
        this.last_updated = last_updated;
    }

    public String getLatest_location() {
        return latest_location;
    }

    public void setLatest_location(String latest_location) {
        this.latest_location = latest_location;
    }

    public List<String> getLocation_history() {
        return location_history;
    }

    public void setLocation_history(List<String> location_history) {
        this.location_history = location_history;
    }
}
