package com.example.Beacon.Controller;


import com.example.Beacon.Model.DeviceInfo;
import com.example.Beacon.Model.Sessions;
import com.example.Beacon.Model.Users;
import com.example.Beacon.Service.SessionService;
import com.example.Beacon.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/session")
public class SessionController {

    @Autowired
    private SessionService sessionService;
    @Autowired
    private UserService userService;

    public List<Sessions> getAllSessionss() {
        return sessionService.getAllSession();
    }

    @GetMapping
    public List<Sessions> getAllSession() {
        return sessionService.getAllSession();
    }

    @GetMapping("/{id}")
    public Sessions getSessionsById(@PathVariable Long id) {
        return sessionService.getSessionById(id);
    }

    @PostMapping
    public Sessions createSessions(@RequestBody Sessions sessions) {
        return sessionService.addSession(sessions);
    }

    @PutMapping("/{id}")
    public Sessions udateSessionsById(@PathVariable Long id, @RequestBody Sessions sessions) {
        return sessionService.updateSession(id, sessions);
    }

    @DeleteMapping("/{id}")
    public void deleteSessions(@PathVariable Long id) {
        sessionService.deleteSession(id);
    }

    @PostMapping("/start")
    public String startSession(@RequestParam Long id, @RequestBody DeviceInfo deviceInfo) {
        return sessionService.startNewSession(id, deviceInfo);
    }

    @PostMapping("/end")
    public String endSession(@RequestParam Long id) {
        return sessionService.endSession(id);
    }

    @GetMapping("/history")
    public List<Sessions> getSessionOfUser(@RequestParam Long id) {
        Users user = userService.getUserById(id);
        List<Sessions> session = user.getSession_id();
        System.out.println(session.size());
        return session;
    }

}
