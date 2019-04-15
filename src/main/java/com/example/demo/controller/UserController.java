package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/user")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping(value = "/user/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @DeleteMapping(value = "/user/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PutMapping(value = "/user/{id}")
    public User updateUser(@RequestBody User user, @PathVariable Long id) {
        User updateUser = userService.updateUser(user, id);
        return updateUser;
    }
}
