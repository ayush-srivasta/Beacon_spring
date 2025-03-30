package com.example.Beacon.Service.Implementation;

import com.example.Beacon.Model.DeviceInfo;
import com.example.Beacon.Model.Location;
import com.example.Beacon.Model.Sessions;
import com.example.Beacon.Model.Users;
import com.example.Beacon.Repositery.DeviceInfoRepo;
import com.example.Beacon.Repositery.LocationRepo;
import com.example.Beacon.Repositery.SessionRepo;
import com.example.Beacon.Repositery.UserRepo;
import com.example.Beacon.Service.SessionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service

public class SessionImpl implements SessionService {

    @Autowired
    private SessionRepo sessionRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private LocationRepo locationRepo;
    @Autowired
    private DeviceInfoRepo deviceInfoRepo;

    @Override
    public Sessions addSession(Sessions sessions) {
        return sessionRepo.save(sessions);
    }

    @Override
    public Sessions getSessionById(Long id) {
        return sessionRepo.findById(id).orElseThrow(() -> new NoSuchElementException("No session exist"));
    }

    @Override
    public List<Sessions> getAllSession() {
        return sessionRepo.findAll();
    }

    @Override
    public Sessions updateSession(Long id, Sessions sessions) {
        Sessions tempSession = sessionRepo.findById(id).orElseThrow(() -> new NoSuchElementException("No session exist"));
        tempSession = sessions;
        return sessionRepo.save(tempSession);

    }

    @Override
    public void deleteSession(Long id) {
        sessionRepo.deleteById(id);
    }

    @Override
    @Transactional
    public String startNewSession(Long userId, DeviceInfo deviceInfo) {
        String deepLink = generateDeepLink();
        Users users = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User Not found"));

//        if(deviceInfo!= null && deviceInfo.getDevice_id()==null)
//            deviceInfo=deviceInfoRepo.save(deviceInfo);
        Sessions sessions = new Sessions();
        sessions.setUser(users);
        sessions.setDeep_link(deepLink);
        sessions.setStart_time(LocalDateTime.now());
        sessions.setDeviceInfo(deviceInfo);


        sessionRepo.save(sessions);
        deviceInfo.setSession_id(sessions);
        deviceInfo.setUser_id(users);
        deviceInfoRepo.save(deviceInfo);
        Location location = new Location();
        location.setSession(sessions);
        location.setUser_id(users);
        location.setLast_updated(LocalDateTime.now());
        locationRepo.save(location);
        return deepLink;
    }

    @Override
    @Transactional
    public String endSession(Long id) {
        Sessions sessions = sessionRepo.findById(id).orElseThrow(() -> new RuntimeException("Session not found"));
        sessions.setEnd_time(LocalDateTime.now());
        sessionRepo.save(sessions);
        return "Session ended ";
    }

    private String generateDeepLink() {
        // This is a simple implementation - adjust as needed for your business logic
        return "app://session/" + UUID.randomUUID().toString();
    }

}
