package com.dazayamil.salemanagementapi.service;

import com.dazayamil.salemanagementapi.dto.request.LoginRequestDTO;
import com.dazayamil.salemanagementapi.dto.response.LoginResponseDTO;

public interface AuthService {
    LoginResponseDTO login(LoginRequestDTO request);
}
