package com.example.Beacon.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Sessions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long session_id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
    private String deep_link;
    private LocalDateTime start_time;
    private LocalDateTime end_time;
    @OneToOne
    @JoinColumn(name = "device_info_id")
    private DeviceInfo deviceInfo;
    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Location> location;


    public Long getSession_id() {
        return session_id;
    }

    public void setSession_id(Long session_id) {
        this.session_id = session_id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getDeep_link() {
        return deep_link;
    }

    public void setDeep_link(String deep_link) {
        this.deep_link = deep_link;
    }

    public LocalDateTime getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalDateTime start_time) {
        this.start_time = start_time;
    }

    public LocalDateTime getEnd_time() {
        return end_time;
    }

    public void setEnd_time(LocalDateTime end_time) {
        this.end_time = end_time;
    }

    public DeviceInfo getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(DeviceInfo deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public List<Location> getLocation() {
        return location;
    }

    public void setLocation(List<Location> location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Sessions{" +
                "session_id=" + session_id +
                ", user=" + user +
                ", deep_link='" + deep_link + '\'' +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                ", deviceInfo=" + deviceInfo +
                ", location=" + location +
                '}';
    }
}
