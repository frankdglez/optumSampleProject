package com.optum.optumsample.controller;

import com.optum.optumsample.model.User;
import com.optum.optumsample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController implements IController<User> {
    UserService userService;

    @Autowired
    UsersController(UserService userService) {
        this.userService = userService;
    }

    @Override
    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAllUsers();
    }

    @Override
    @GetMapping("/user/{userId}")
    public User getById(@PathVariable("userId") String userId) {
        return userService.getById(userId);
    }

    @Override
    @PostMapping("/save")
    public User save(@RequestBody User user) {
        return userService.saveUser(user);
    }
}
