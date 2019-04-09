package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Transactional
    public  User saveUser(User user){
        return userRepo.save(user);
    }

    @Transactional
    public User getById(Long id){
        return userRepo.getOne(id);
    }
}
