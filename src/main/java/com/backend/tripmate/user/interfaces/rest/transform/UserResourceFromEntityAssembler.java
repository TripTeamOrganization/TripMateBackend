package com.backend.tripmate.user.interfaces.rest.transform;

import com.backend.tripmate.user.domain.model.entities.User;
import com.backend.tripmate.user.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User user) {
        return new UserResource(
            user.getId(),
            user.getName(),
            user.getApellidos(),
            user.getDni(),
            user.getEmail(),
            user.getPassword(),
            user.getTelefono(),
            user.getPlan()
        );
    }
}