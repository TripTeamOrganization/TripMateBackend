package com.backend.tripmate.activities;

import com.backend.tripmate.activities.interfaces.rest.resources.ActivityResource;
import com.backend.tripmate.activities.domain.model.queries.GetAllActivitiesQuery;
import com.backend.tripmate.activities.domain.services.ActivityQueryService;

import com.backend.tripmate.activities.interfaces.rest.transform.ActivityResourceFromEntityAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//el list de retorno:
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
//import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/api/v1/actividades", produces = APPLICATION_JSON_VALUE)
//@Tag(name = "Activities", description = "Activity Management Endpoints")
public class ActivityController {

    //private final ActivityCommandService activityCommandService;
    private final ActivityQueryService activityQueryService;


    public ActivityController(ActivityQueryService activityQueryService) {
        //this.activityCommandService = activityCommandService;
        this.activityQueryService = activityQueryService;
    }

    //viewModel
    public ResponseEntity<List<ActivityResource>> getAllActivities() {

        //getquery
        var getAllActivitiesQuery = new GetAllActivitiesQuery();

        //hand
        var activities = activityQueryService.handle(getAllActivitiesQuery);

        //convert a ActivityResource
        var activityResources = activities.stream().map(ActivityResourceFromEntityAssembler::toResourceFromEntity).toList();

        //return.
        return ResponseEntity.ok(activityResources);
    }

}
