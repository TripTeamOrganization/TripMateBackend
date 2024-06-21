package com.backend.tripmate.IAM.application.internal.commandservices;

import com.backend.tripmate.IAM.JwtUtil;
import com.backend.tripmate.IAM.domain.model.commands.AuthRequest;
import com.backend.tripmate.IAM.domain.model.commands.AuthResponse;
import com.backend.tripmate.user.domain.model.entities.User;
import com.backend.tripmate.user.infrastructure.persistence.jpa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthResponse authenticate(AuthRequest authRequest) {
        Optional<User> userOptional = userRepository.findByEmail(authRequest.getEmail());

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (passwordEncoder.matches(authRequest.getPassword(), user.getPassword())) {
                Authentication authentication = new UsernamePasswordAuthenticationToken(
                        authRequest.getEmail(),
                        authRequest.getPassword(),
                        Collections.emptyList()
                );

                String token = jwtUtil.generateToken(authentication);
                return new AuthResponse(token);
            }
        }
        throw new RuntimeException("Invalid credentials");
    }
}
