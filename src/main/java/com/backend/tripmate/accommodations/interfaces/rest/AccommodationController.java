package com.backend.tripmate.accommodations.interfaces.rest;

import com.backend.tripmate.accommodations.domain.services.AccommodationQueryService;
import com.backend.tripmate.accommodations.interfaces.rest.resources.AccommodationResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/accommodations", produces = APPLICATION_JSON_VALUE)
public class AccommodationController {

    private final AccommodationQueryService accommodationQueryService;

    public AccommodationController(AccommodationCommandService, AccommodationQueryService accommodationQueryService) {
        this.accommodationQueryService = accommodationQueryService;
    }

    public ResponseEntity<List<AccommodationResource>> getAllAccommodations() {
        var getAllAccommodationsQuery = new GetAllAccommodationsQuery();

        var accommodations = accommodationsQueryService.handle(getAllAccommodationsQuery);

        var accommodationResources = accommodations.stream().map(AccommodationResourceFromEntityAssembler::toResourceFromEntity).collect(toList());

        return ResponseEntity.ok(accommodationResources);
    }
}
