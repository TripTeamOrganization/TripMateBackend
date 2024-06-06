package com.backend.tripmate.reservation.application.internal.commandservices;

import com.backend.tripmate.reservation.domain.model.entities.Reservation;
import com.backend.tripmate.reservation.domain.model.queries.GetAllReservationQuery;
import com.backend.tripmate.reservation.domain.services.ReservationQueryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationQueryServiceImpl implements ReservationQueryService {
    private final List<Reservation> reservations = List.of(
    );

    @Override
    public List<Reservation> handle(GetAllReservationQuery query) {
        return reservations;
    }

    @Override
    public Optional<Reservation> findById(Long id) {
        return reservations.stream()
                .filter(reservation -> reservation.getId().equals(id))
                .findFirst();
    }
}
