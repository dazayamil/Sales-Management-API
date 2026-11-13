package com.dazayamil.salemanagementapi.dto.request;

import com.dazayamil.salemanagementapi.model.enums.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserRequestDTO (
        @NotBlank(message = "username is required")
        String username,

        @NotBlank(message = "password is required")
        @Size(min = 5, message = "password must be at leat 5 characteres")
        String password,

        @NotNull(message = "role is required")
        Role role
)
{}
