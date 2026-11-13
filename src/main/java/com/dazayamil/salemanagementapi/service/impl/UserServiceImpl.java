package com.dazayamil.salemanagementapi.service.impl;

import com.dazayamil.salemanagementapi.dto.request.UserRequestDTO;
import com.dazayamil.salemanagementapi.dto.response.UserResponseDTO;
import com.dazayamil.salemanagementapi.exception.UsernameAlreadyExistsException;
import com.dazayamil.salemanagementapi.mapper.UserMapper;
import com.dazayamil.salemanagementapi.model.entity.User;
import com.dazayamil.salemanagementapi.repository.UserRepository;
import com.dazayamil.salemanagementapi.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserResponseDTO createUser(UserRequestDTO dto) {
        // 1. Primero lo barato: ¿ya existe el username?
        if (userRepository.existsByUsername(dto.username())) {
            throw new UsernameAlreadyExistsException(dto.username());
        }

        // 2. Después lo caro: hashear (BCrypt es lento a propósito)
        String hashedPassword = passwordEncoder.encode(dto.password());

        // 3. Construir con el HASH, nunca con dto.password()
        User user = User.builder()
                .username(dto.username())
                .password(hashedPassword)
                .role(dto.role())
                .build();

        User savedUser = userRepository.save(user);
        return userMapper.toResponseDTO(savedUser);
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
