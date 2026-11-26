package com.system.reservation.service;

import java.util.List;

import com.system.reservation.dto.UserResponse;

import org.springframework.transaction.annotation.Transactional;

public interface UserService {

    @Transactional(readOnly = true)
    List<UserResponse> getAllUsers();
    @Transactional
    UserResponse registerUser(UserResponse userResponse);
    @Transactional
    UserResponse loginUser(UserResponse userResponse);
}
