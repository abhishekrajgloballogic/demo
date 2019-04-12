package com.example.demo;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UpdateMapper updateMapper;

    @Transactional
    public  User saveUser(User user){
        return userRepo.save(user);
    }

    @Transactional
    public User getById(Long id){
        return userRepo.getOne(id);
    }

    @Transactional
    public void deleteUser(Long id){
         userRepo.deleteById(id);
    }

    @Transactional
    public User updateUser(User updateUser, Long id ) throws InvocationTargetException, IllegalAccessException {
        User user =  userRepo.findById(id).get();
        updateMapper.copyProperties(user, updateUser);
        return userRepo.save(user);
    }
}
