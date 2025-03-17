package com.example.Beacon.Service;

import com.example.Beacon.Model.Users;

import java.util.List;

public interface UserService {

    public Users addUsers(Users users);

    public Users getUserById(Long id);

    public List<Users> getAllUser();

    public Users updateUser(Long id, Users users);

    public void deleteUser(Long id);
}
