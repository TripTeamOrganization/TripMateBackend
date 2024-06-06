package com.backend.tripmate.reservation.application.internal.commandservices;

import com.backend.tripmate.reservation.domain.model.entities.Reservation;
import com.backend.tripmate.reservation.domain.model.commands.CreateReservationCommand;
import com.backend.tripmate.reservation.infrastructure.persistence.jpa.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservationCommandServiceImpl {
    private final ReservationRepository reservationRepository;

    public ReservationCommandServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public void handle(CreateReservationCommand command) {
        Reservation reservation = new Reservation();
        reservationRepository.save(reservation);
    }
}