package com.backend.tripmate.IAM.domain.repository;

import com.backend.tripmate.IAM.domain.model.entities.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, String> {
    Optional<RefreshToken> findByToken(String token);
}