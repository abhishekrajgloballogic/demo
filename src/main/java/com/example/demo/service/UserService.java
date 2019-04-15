package com.example.demo.service;

import com.example.demo.Util.UpdateMapper;
import com.example.demo.dao.UserRepo;
import com.example.demo.entity.User;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UpdateMapper updateMapper;

    @Transactional
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Transactional
    public User getById(Long id) {
        return userRepo.getOne(id);
    }

    @Transactional
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    @Transactional
    public User updateUser(User updateUser, Long id) {
        User user = userRepo.findById(id).get();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        modelMapper.map(updateUser, user);
        return userRepo.save(user);
    }
}
