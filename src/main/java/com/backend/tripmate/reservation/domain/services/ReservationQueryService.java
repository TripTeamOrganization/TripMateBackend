package com.backend.tripmate.reservation.domain.services;

import com.backend.tripmate.reservation.domain.model.entities.Reservation;
import com.backend.tripmate.reservation.domain.model.queries.GetAllReservationQuery;

import java.util.List;

public interface ReservationQueryService {
    List<Reservation> handle(GetAllReservationQuery query);
}
