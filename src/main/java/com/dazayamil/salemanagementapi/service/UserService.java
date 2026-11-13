package com.dazayamil.salemanagementapi.service;

import com.dazayamil.salemanagementapi.dto.request.UserRequestDTO;
import com.dazayamil.salemanagementapi.dto.response.UserResponseDTO;

import java.util.List;

public interface UserService {
    UserResponseDTO createUser(UserRequestDTO dto);
    List<UserResponseDTO> getAllUsers();
    UserResponseDTO getUserById(Long id);
    UserResponseDTO updateUser(Long id, UserRequestDTO dto);
    // Soft delete: marca el usuario como inactivo, no lo elimina de la base
    void deleteUser(Long id);
}