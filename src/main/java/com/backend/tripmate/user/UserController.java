package com.backend.tripmate.user;

import com.backend.tripmate.user.domain.model.queries.GetAllUserQuery;
import com.backend.tripmate.user.domain.services.UserQueryService;
import com.backend.tripmate.user.interfaces.rest.resources.UserResource;
import com.backend.tripmate.user.interfaces.rest.transform.UserResourceFromEntityAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/user", produces = APPLICATION_JSON_VALUE)
public class UserController {
    private final UserQueryService userQueryService;

    public UserController(UserQueryService userQueryService) {
        this.userQueryService = userQueryService;
    }

    @GetMapping
    public ResponseEntity<List<UserResource>> getAllUser() {
        // Create a new query to get all users
        var getAllUserQuery = new GetAllUserQuery();

        // Handle the query using the service
        var users = userQueryService.handle(getAllUserQuery);

        // Convert users to UserResource
        var userResources = users.stream()
                .map(UserResourceFromEntityAssembler::toResourceFromEntity)
                .toList();

        // Return the response entity with the list of user resources
        return ResponseEntity.ok(userResources);
    }
}
