package com.example.Beacon.Service;

import com.example.Beacon.Model.DeviceInfo;
import com.example.Beacon.Model.Sessions;

import java.util.List;

public interface SessionService {
    public Sessions addSession(Sessions sessions);

    public Sessions getSessionById(Long id);

    public List<Sessions> getAllSession();

    public Sessions updateSession(Long id, Sessions sessions);

    public void deleteSession(Long id);

    public String startNewSession(Long userId, DeviceInfo deviceInfo);

    public String endSession(Long id);
}
