package com.system.reservation.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.system.reservation.dto.UserRequest;
import com.system.reservation.dto.UserResponse;
import com.system.reservation.exception.ResourceNotFoundException;
import com.system.reservation.model.User;
import com.system.reservation.repository.UserRepository;
import com.system.reservation.service.UserService;

@Service 
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserResponse> getAllUsers() {
        // Implementation for retrieving all users
        return userRepository.findAll().stream()
                .map(user -> new UserResponse(
                    user.getId(),
                    user.getName(),
                    user.getEmail(),
                    user.getPassword(),
                    user.getRole()))
                .toList();
    }

    // Fix orElseThrow to throw ResourceNotFoundException when user is not found
    @Override 
    public UserResponse registerUser(UserRequest request) {
        // Implementation for registering a new user
        User user = new User(
            request.name(),
            request.email(),
            request.password(),
            request.role()
        );
        User savedUser = userRepository.save(user);
        return new UserResponse(
            savedUser.getId(),
            savedUser.getName(),
            savedUser.getEmail(),
            savedUser.getPassword(),
            savedUser.getRole()
        );
    }

    @Override 
    public UserResponse loginUser(UserRequest userRequest) {
        // Implementation for user login
        User user = userRepository.findByEmail(userRequest.email()).orElseThrow(() -> new ResourceNotFoundException("User not found with email: " + userRequest.email()));
        if (!user.getPassword().equals(userRequest.password())) {
            throw new ResourceNotFoundException("Invalid password");
        }
        return new UserResponse(
            user.getId(),
            user.getName(),
            user.getEmail(),
            user.getPassword(),
            user.getRole()
        );
    }
}
