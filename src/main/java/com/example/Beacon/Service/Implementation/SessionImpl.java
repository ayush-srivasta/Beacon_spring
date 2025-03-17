package com.example.Beacon.Service.Implementation;

import com.example.Beacon.Model.Sessions;
import com.example.Beacon.Repositery.SessionRepo;
import com.example.Beacon.Service.SessionService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Data
public class SessionImpl implements SessionService {

    @Autowired
    private SessionRepo sessionRepo;

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
}
