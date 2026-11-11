package com.dazayamil.salemanagementapi.security.handler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;

// Spring Security llama a esta clase cuando llega una request SIN identificación válida
// a un endpoint protegido (sin token, token vencido o token inválido)
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {

        // Acá no hay controller, así que armamos la respuesta a mano
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");

        // Mismo formato que ErrorResponse, escrito como texto JSON.
        // Lo armamos a mano a propósito: así no dependemos de la librería JSON
        // (en Spring Boot 4 cambió de paquete) para algo tan chico.
        String body = String.format(
                "{\"timestamp\":\"%s\",\"status\":401,\"error\":\"Unauthorized\","
                        + "\"message\":\"Authentication required: missing, invalid or expired token\","
                        + "\"path\":\"%s\"}",
                LocalDateTime.now(),
                request.getRequestURI()
        );
        response.getWriter().write(body);
    }
}