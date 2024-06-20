package com.backend.tripmate.user.application.internal.commandservices;

import com.backend.tripmate.user.domain.model.entities.User;
import com.backend.tripmate.user.domain.model.queries.GetAllUserQuery;
import com.backend.tripmate.user.domain.services.UserQueryService;
import com.backend.tripmate.user.infrastructure.persistence.jpa.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserQueryServiceImpl implements UserQueryService {
    private final UserRepository userRepository;

    public UserQueryServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> handle(GetAllUserQuery query) {
        return userRepository.findAll();
    }
}
