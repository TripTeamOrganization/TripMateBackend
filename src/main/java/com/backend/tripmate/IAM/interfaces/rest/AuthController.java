package com.backend.tripmate.IAM.interfaces.rest;

import com.backend.tripmate.IAM.application.internal.commandservices.AuthService;
import com.backend.tripmate.IAM.domain.model.commands.AuthRequest;
import com.backend.tripmate.IAM.domain.model.commands.AuthResponse;
import com.backend.tripmate.IAM.interfaces.rest.resources.LoginRequest;
import com.backend.tripmate.IAM.interfaces.rest.transformers.AuthMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;
    private final AuthMapper authMapper;

    @Autowired
    public AuthController(AuthService authService, AuthMapper authMapper) {
        this.authService = authService;
        this.authMapper = authMapper;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
        AuthRequest authRequest = authMapper.loginRequestToAuthRequest(loginRequest);

        AuthResponse authResponse = authService.authenticate(authRequest);

        return ResponseEntity.ok(authResponse);
    }
}