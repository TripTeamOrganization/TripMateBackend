package com.backend.tripmate.reservation;

import com.backend.tripmate.reservation.application.internal.commandservices.ReservationCommandServiceImpl;
import com.backend.tripmate.reservation.domain.exceptions.ReservationNotFoundException;
import com.backend.tripmate.reservation.domain.model.commands.CreateReservationCommand;
import com.backend.tripmate.reservation.domain.model.entities.Reservation;
import com.backend.tripmate.reservation.domain.model.queries.GetAllReservationQuery;
import com.backend.tripmate.reservation.domain.services.ReservationQueryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/reservation", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReservationController {
    private final ReservationCommandServiceImpl reservationCommandService;
    private final ReservationQueryService reservationQueryService;

    public ReservationController(ReservationCommandServiceImpl reservationCommandService, ReservationQueryService reservationQueryService) {
        this.reservationCommandService = reservationCommandService;
        this.reservationQueryService = reservationQueryService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createReservation(@RequestBody CreateReservationCommand command) {
        reservationCommandService.handle(command);
    }

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationQueryService.handle(new GetAllReservationQuery());
    }

    @GetMapping("/{id}")
    public Reservation getReservation(@PathVariable Long id) {
        return reservationQueryService.findById(id)
                .orElseThrow(() -> new ReservationNotFoundException(id));
    }
}
