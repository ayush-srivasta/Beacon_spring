package com.example.Beacon.Service.Implementation;

import com.example.Beacon.Model.Users;
import com.example.Beacon.Repositery.UserRepo;
import com.example.Beacon.Service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Data
public class UserImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public Users addUsers(Users users) {
        return userRepo.save(users);
    }

    @Override
    public Users getUserById(Long id) {
        return userRepo.findById(id).orElseThrow(() -> new NoSuchElementException("No User Exist with this ID"));
    }

    @Override
    public List<Users> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public Users updateUser(Long id, Users users) {
        Users tempUser = userRepo.findById(id).orElseThrow(() -> new NoSuchElementException("No User Exist with this ID"));
        tempUser = users;
        return userRepo.save(tempUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }
}
