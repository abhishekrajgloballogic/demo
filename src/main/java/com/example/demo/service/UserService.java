package com.example.demo.service;

import com.example.demo.dao.UserRepo;
import com.example.demo.entity.User;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.util.PropertyFileReader;
import com.example.demo.util.UpdateMapper;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UpdateMapper updateMapper;

    @Autowired
    private PropertyFileReader propertyFileReader;

    @Transactional
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Transactional
    public Optional<User> getById(Long id) {
        Optional<User> user = userRepo.findById(id);
        if (!user.isPresent())
            throw new UserNotFoundException(propertyFileReader.get("user.not.found"), HttpStatus.NOT_FOUND.value());
        return user;
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
