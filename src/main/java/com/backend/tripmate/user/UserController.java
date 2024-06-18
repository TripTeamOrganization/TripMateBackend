    package com.backend.tripmate.user;

    import com.backend.tripmate.user.application.internal.commandservices.UserCommandServiceImpl;
    import com.backend.tripmate.user.domain.model.commands.CreateUserCommand;
    import com.backend.tripmate.user.domain.model.queries.GetAllUserQuery;
    import com.backend.tripmate.user.domain.services.UserQueryService;
    import com.backend.tripmate.user.interfaces.rest.resources.UserResource;
    import com.backend.tripmate.user.interfaces.rest.transform.UserResourceFromEntityAssembler;
    import jakarta.validation.Valid;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

    @RestController
    @RequestMapping(value = "/api/v1/user", produces = APPLICATION_JSON_VALUE)
    public class UserController {
        private final UserQueryService userQueryService;
        private final UserCommandServiceImpl userCommandServiceImpl;

        public UserController(UserQueryService userQueryService, UserCommandServiceImpl userCommandServiceImpl) {
            this.userQueryService = userQueryService;
            this.userCommandServiceImpl = userCommandServiceImpl;
        }

        @GetMapping
        public ResponseEntity<List<UserResource>> getAllUser() {
            var getAllUserQuery = new GetAllUserQuery();
            var users = userQueryService.handle(getAllUserQuery);
            var userResources = users.stream().map(UserResourceFromEntityAssembler::toResourceFromEntity).toList();
            return ResponseEntity.ok(userResources);
        }

        @PostMapping
        public ResponseEntity<String> createUser(@Valid @RequestBody CreateUserCommand createUserCommand) {
            userCommandServiceImpl.handle(createUserCommand);
            return ResponseEntity.ok("Usuario creado exitosamente");
        }


        public ResponseEntity<List<UserResource>> getAllUsers() {

            //
            var getAllUserQuery = new GetAllUserQuery();

            //hand
            var users = userQueryService.handle(getAllUserQuery);

            //convert a ActivityResource
            var activityResources = users.stream().map(UserResourceFromEntityAssembler::toResourceFromEntity).toList();

            //return.
            return ResponseEntity.ok(activityResources);
        }
    }
