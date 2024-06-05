package com.backend.tripmate.reservation.application.internal.commandservices;

import com.backend.tripmate.reservation.domain.model.entities.Reservation;
import com.backend.tripmate.reservation.domain.model.queries.GetAllReservationQuery;
import com.backend.tripmate.reservation.domain.services.ReservationQueryService;
import com.backend.tripmate.reservation.infrastructure.persistence.jpa.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationQueryServiceImpl implements ReservationQueryService {
    private final ReservationRepository userRepository;

    public ReservationQueryServiceImpl(ReservationRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<Reservation> handle(GetAllReservationQuery query) {
        return userRepository.findAll();
    }
}
