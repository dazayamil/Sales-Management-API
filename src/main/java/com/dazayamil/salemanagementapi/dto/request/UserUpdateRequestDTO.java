package com.dazayamil.salemanagementapi.dto.request;

import com.dazayamil.salemanagementapi.model.enums.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserUpdateRequestDTO (
        @NotBlank(message = "username is required")
        String username,

        @NotNull(message = "role is required")
        Role role
)
{}
