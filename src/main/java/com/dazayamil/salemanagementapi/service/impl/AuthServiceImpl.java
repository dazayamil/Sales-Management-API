package com.dazayamil.salemanagementapi.service.impl;

import com.dazayamil.salemanagementapi.dto.request.LoginRequestDTO;
import com.dazayamil.salemanagementapi.dto.response.LoginResponseDTO;
import com.dazayamil.salemanagementapi.security.service.JwtService;
import com.dazayamil.salemanagementapi.security.service.UserDetailsServiceImpl;
import com.dazayamil.salemanagementapi.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsServiceImpl userDetailsService;
    private final JwtService jwtService;

    public AuthServiceImpl(AuthenticationManager authenticationManager,
                           UserDetailsServiceImpl userDetailsService,
                           JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtService = jwtService;
    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO request) {
        // verifica username y password contra la base de datos
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.username(),
                        request.password()
                )
        );

        // si llegó acá, las credenciales son correctas
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.username());

        // genera el token JWT
        String token = jwtService.generateToken(userDetails);

        return new LoginResponseDTO(token);
    }
}
