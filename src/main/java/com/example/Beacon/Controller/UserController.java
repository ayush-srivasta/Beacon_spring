package com.example.Beacon.Controller;

import com.example.Beacon.Model.Users;
import com.example.Beacon.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    public List<Users> getAllUsers() {
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public Users getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public Users createUser(@RequestBody Users users) {
        System.out.println(users.toString());
        return userService.addUsers(users);
    }

    @PutMapping("/{id}")
    public Users udateUserById(@PathVariable Long id, @RequestBody Users users) {
        return userService.updateUser(id, users);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

}
