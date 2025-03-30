package com.example.Beacon.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter

public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long user_id;

    private String user_name;

    private String user_mob;
    private String email;
    //for furthur inhancement
    private boolean verified = false;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Sessions> session_id;

    @OneToMany(mappedBy = "user_id")
    @JsonIgnore
    private List<DeviceInfo> deviceInfo;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_mob() {
        return user_mob;
    }

    public void setUser_mob(String user_mob) {
        this.user_mob = user_mob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public List<DeviceInfo> getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(List<DeviceInfo> deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public List<Sessions> getSession_id() {
        return session_id;
    }

    public void setSession_id(List<Sessions> session_id) {
        this.session_id = session_id;
    }

    @Override
    public String toString() {
        return "Users{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_mob='" + user_mob + '\'' +
                ", email='" + email + '\'' +
                ", verified=" + verified +
                ", session_id=" + session_id +
                ", deviceInfo=" + deviceInfo +
                '}';
    }
}
