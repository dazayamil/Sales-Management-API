package com.dazayamil.salemanagementapi.dto.response;

import com.dazayamil.salemanagementapi.model.enums.Role;

public record UserResponseDTO(
        Long id,
        String username,
        Role role
)
{}
