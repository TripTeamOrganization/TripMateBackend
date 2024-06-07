package com.backend.tripmate.user.application.internal.commandservices;

import com.backend.tripmate.user.infrastructure.persistence.jpa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.tripmate.user.domain.model.commands.CreateUserCommand;
import com.backend.tripmate.user.domain.model.entities.User;

@Service
public class UserCommandServiceImpl {

    @Autowired
    private UserRepository userRepository;

    public void handle(CreateUserCommand createUserCommand) {
        User user = new User();
        user.setNombre(createUserCommand.getNombre());
        user.setApellidos(createUserCommand.getApellidos());
        user.setDni(createUserCommand.getDni());
        user.setEmail(createUserCommand.getEmail());
        user.setPassword(createUserCommand.getPassword());
        user.setTelefono(createUserCommand.getTelefono());
        user.setPlan(createUserCommand.getPlan());

        userRepository.save(user);
    }
}
