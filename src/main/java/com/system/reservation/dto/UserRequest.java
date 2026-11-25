package com.system.reservation.dto;

import jakarta.validation.constraints.NotBlank;

public record UserRequest(
    @NotBlank(message = "Name is required")
    String name,
    @NotBlank(message = "Email is required")
    String email,
    @NotBlank(message = "Password is required")
    String password,
    @NotBlank(message = "Role is required")
    String role
) {}