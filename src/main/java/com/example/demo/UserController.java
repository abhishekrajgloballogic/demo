package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/user")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping(value = "/user/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getById(id);
    }

    @DeleteMapping(value = "/user/{id}")
    public void deleteUserById(@PathVariable Long id){
         userService.deleteUser(id);
    }

    @PutMapping(value = "/user/{id}")
    public User updateUser(@RequestBody User user, @PathVariable Long id) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
       User updateUser = userService.updateUser(user,id);
       return updateUser;
    }
}
