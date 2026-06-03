package com.samsung.postprojectshop.rest.controller;

import com.samsung.postprojectshop.domain.User;
import com.samsung.postprojectshop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping(path = "user/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getById(id);
    }

    @GetMapping(path = "user/exists/{username}")
    public boolean userExist(@PathVariable String username){
        return userService.existsByUsername(username);
    }

    @GetMapping(path = "user/byusername/{username}")
    public User getByUsername(@PathVariable String username){
        return userService.findByUsername(username);
    }

    @PostMapping(path = "user")
    public User postUser(@RequestBody User user){
        return userService.create(user);
    }
}
