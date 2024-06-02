package com.backend.tripmate.user.infrastructure.persistence.jpa.repositories;

import com.backend.tripmate.user.domain.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
}
