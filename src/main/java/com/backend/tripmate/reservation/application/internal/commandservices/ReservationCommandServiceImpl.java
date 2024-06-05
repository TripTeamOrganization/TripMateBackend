package com.backend.tripmate.reservation.application.internal.commandservices;

import com.backend.tripmate.reservation.domain.model.entities.Reservation;
import com.backend.tripmate.reservation.domain.model.commands.CreateReservationCommand;
import com.backend.tripmate.reservation.infrastructure.persistence.jpa.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservationCommandServiceImpl {
    private final ReservationRepository userRepository;

    public ReservationCommandServiceImpl(ReservationRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void handle(CreateReservationCommand command) {
        Reservation user = new Reservation();
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
