    package com.backend.tripmate.reservation;

    import com.backend.tripmate.reservation.application.internal.commandservices.ReservationCommandServiceImpl;
    import com.backend.tripmate.reservation.domain.model.commands.CreateReservationCommand;
    import com.backend.tripmate.reservation.domain.model.queries.GetAllReservationQuery;
    import com.backend.tripmate.reservation.domain.services.ReservationQueryService;
    import com.backend.tripmate.reservation.interfaces.rest.resources.UserResource;
    import com.backend.tripmate.reservation.interfaces.rest.transform.UserResourceFromEntityAssembler;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

    @RestController
    @RequestMapping(value = "/api/v1/user", produces = APPLICATION_JSON_VALUE)
    public class ReservationController {
        private final ReservationQueryService userQueryService;
        private final ReservationCommandServiceImpl reservationCommandServiceImpl;

        public ReservationController(ReservationQueryService userQueryService, ReservationCommandServiceImpl reservationCommandServiceImpl) {
            this.userQueryService = userQueryService;
            this.reservationCommandServiceImpl = reservationCommandServiceImpl;
        }

        @GetMapping
        public ResponseEntity<List<UserResource>> getAllUser() {
            var getAllUserQuery = new GetAllReservationQuery();
            var users = userQueryService.handle(getAllUserQuery);
            var userResources = users.stream().map(UserResourceFromEntityAssembler::toResourceFromEntity).toList();
            return ResponseEntity.ok(userResources);
        }

        @PostMapping
        public ResponseEntity<UserResource> createUser(@RequestBody CreateReservationCommand createUserCommand) {
            reservationCommandServiceImpl.handle(createUserCommand);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }


        public ResponseEntity<List<UserResource>> getAllUsers() {

            //
            var getAllUserQuery = new GetAllReservationQuery();

            //hand
            var users = userQueryService.handle(getAllUserQuery);

            //convert a ActivityResource
            var activityResources = users.stream().map(UserResourceFromEntityAssembler::toResourceFromEntity).toList();

            //return.
            return ResponseEntity.ok(activityResources);
        }
    }
