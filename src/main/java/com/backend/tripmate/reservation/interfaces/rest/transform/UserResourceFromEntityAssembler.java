package com.backend.tripmate.reservation.interfaces.rest.transform;

import com.backend.tripmate.reservation.domain.model.entities.Reservation;
import com.backend.tripmate.reservation.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(Reservation user) {
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