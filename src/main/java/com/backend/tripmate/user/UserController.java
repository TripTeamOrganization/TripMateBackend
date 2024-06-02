package com.backend.tripmate.user;

import com.backend.tripmate.user.domain.model.queries.GetAllUserQuery;
import com.backend.tripmate.user.domain.services.UserQueryService;
import com.backend.tripmate.user.interfaces.rest.resources.UserResource;
import com.backend.tripmate.user.interfaces.rest.transform.UserResourceFromEntityAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        var getAllActivitiesQuery = new GetAllUserQuery();
        var user = userQueryService.handle(getAllActivitiesQuery);
        var userResources = user.stream().map(UserResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(userResources);
    }

    public ResponseEntity<List<UserResource>> getAllUser() {

        //getquery
        var getAllActivitiesQuery = new GetAllUserQuery();

        //hand
        var user = userQueryService.handle(getAllActivitiesQuery);

        //convert a ActivityResource
        var activityResources = user.stream().map(ActivityResourceFromEntityAssembler::toResourceFromEntity).toList();

        //return.
        return ResponseEntity.ok(activityResources);
    }
}
