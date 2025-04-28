package com.semp.semp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.semp.semp.exception.UserNotFoundException;
import com.semp.semp.model.User;
import com.semp.semp.repo.UserRepo;

@Service
public class UserService {
    private final UserRepo userRepo;


    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User addUser(User user) {
        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        return userRepo.save(user);
    }

    public List<User> findAllUsers() {
        return userRepo.findAll();
    }

    public User updateUser(User user){
        return userRepo.save(user);
    }

    public void deleteUser(int id){
        userRepo.deleteUserById(id);
    }

    public User findUserById(int id){
        return userRepo.findUserById(id).orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    
}
