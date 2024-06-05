package com.backend.tripmate.user.application.internal.commandservices;

import com.backend.tripmate.user.domain.model.entities.User;
import com.backend.tripmate.user.domain.model.commands.CreateUserCommand;
import com.backend.tripmate.user.infrastructure.persistence.jpa.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserCommandServiceImpl {
    private final UserRepository userRepository;

    public UserCommandServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void handle(CreateUserCommand command) {
        User user = new User();
        user.setName(command.getName());
        user.setApellidos(command.getApellidos());
        user.setDni(command.getDni());
        user.setEmail(command.getEmail());
        user.setPassword(command.getPassword());
        user.setTelefono(command.getTelefono());
        user.setPlan(command.getPlan());
        userRepository.save(user);
    }
}
