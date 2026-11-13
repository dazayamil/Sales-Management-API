package com.dazayamil.salemanagementapi.service.impl;

import com.dazayamil.salemanagementapi.dto.request.UserRequestDTO;
import com.dazayamil.salemanagementapi.dto.response.UserResponseDTO;
import com.dazayamil.salemanagementapi.mapper.UserMapper;
import com.dazayamil.salemanagementapi.repository.UserRepository;
import com.dazayamil.salemanagementapi.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserResponseDTO createUser(UserRequestDTO dto) {
        return null;
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return List.of();
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        return null;
    }

    @Override
    public UserResponseDTO updateUser(Long id, UserRequestDTO dto) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }
}
