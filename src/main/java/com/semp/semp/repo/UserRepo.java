package com.semp.semp.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.semp.semp.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

    void deleteUserById(int user_id);

    Optional<User>  findUserById(int id);
    
}
