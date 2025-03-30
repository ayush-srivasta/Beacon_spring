package com.example.Beacon.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Sessions session_id;

    private String device_model;
    private Integer battery_level;
    private String os_version;
    private String app_version;

    public Long getDevice_id() {
        return device_id;
    }

    public void setDevice_id(Long device_id) {
        this.device_id = device_id;
    }

    public Users getUser_id() {
        return user_id;
    }

    public void setUser_id(Users user_id) {
        this.user_id = user_id;
    }

    public Sessions getSession_id() {
        return session_id;
    }

    public void setSession_id(Sessions session_id) {
        this.session_id = session_id;
    }

    public String getDevice_model() {
        return device_model;
    }

    public void setDevice_model(String device_model) {
        this.device_model = device_model;
    }

    public Integer getBattery_level() {
        return battery_level;
    }

    public void setBattery_level(Integer battery_level) {
        this.battery_level = battery_level;
    }

    public String getOs_version() {
        return os_version;
    }

    public void setOs_version(String os_version) {
        this.os_version = os_version;
    }

    public String getApp_version() {
        return app_version;
    }

    public void setApp_version(String app_version) {
        this.app_version = app_version;
    }

    @Override
    public String toString() {
        return "DeviceInfo{" +
                "device_id=" + device_id +
                ", user_id=" + user_id +
                ", session_id=" + session_id +
                ", device_model='" + device_model + '\'' +
                ", battery_level=" + battery_level +
                ", os_version='" + os_version + '\'' +
                ", app_version='" + app_version + '\'' +
                '}';
    }
}
