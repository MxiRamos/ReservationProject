package com.system.reservation.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.reservation.dto.UserResponse;
import com.system.reservation.service.UserService;

@RestController 
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/login")
    public UserResponse loginUser(@RequestBody UserResponse userResponse) {
        return userService.loginUser(userResponse);
    }

    @PostMapping("/register")
    public UserResponse registerUser(@RequestBody UserResponse userResponse) {
        return userService.registerUser(userResponse);
    }
}
