package com.backend.tripmate.user;

import com.backend.tripmate.user.domain.model.queries.GetAllUserQuery;
import com.backend.tripmate.user.domain.services.UserQueryService;
import com.backend.tripmate.user.interfaces.rest.resources.UserResource;
import com.backend.tripmate.user.interfaces.rest.transform.UserResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
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
        var getAllUserQuery = new GetAllUserQuery();
        var users = userQueryService.handle(getAllUserQuery);
        var userResources = users.stream().map(UserResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(userResources);
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