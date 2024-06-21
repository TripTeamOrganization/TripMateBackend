package com.backend.tripmate.IAM.application.internal.queryservices;

import com.backend.tripmate.IAM.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    @Autowired
    private JwtUtil jwtUtil;

    public String extractUsernameFromToken(String token) {
        return jwtUtil.extractUsername(token);
    }

    public boolean validateToken(String token) {
        return !jwtUtil.isTokenExpired(token);
    }
}