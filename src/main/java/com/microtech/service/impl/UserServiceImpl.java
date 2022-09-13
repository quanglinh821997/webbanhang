package com.microtech.service.impl;

import com.microtech.model.User;
import com.microtech.repository.UserRepo;
import com.microtech.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {

    @Autowired private UserRepo userRepo;

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public void updateUser(User user) {
        userRepo.save(user);
    }

    @Override
    public void removeUserById(int id) {
        userRepo.deleteById(id);
    }

    @Override
    public Optional<User> getUserById(int id) {
        return userRepo.findById(id);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepo.findUserByEmail(email);
    }
}
