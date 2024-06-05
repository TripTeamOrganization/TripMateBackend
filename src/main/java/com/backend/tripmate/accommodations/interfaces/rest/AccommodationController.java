package com.backend.tripmate.accommodations.interfaces.rest;

import com.backend.tripmate.accommodations.domain.model.queries.GetAllAccommodationsQuery;
import com.backend.tripmate.accommodations.domain.services.AccommodationQueryService;
import com.backend.tripmate.accommodations.infrastructure.persistence.jpa.repositories.AccommodationRepository;
import com.backend.tripmate.accommodations.interfaces.rest.resources.AccommodationResource;
import com.backend.tripmate.accommodations.interfaces.rest.transform.AccommodationResourceFromEntityAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/accommodations", produces = APPLICATION_JSON_VALUE)
public class AccommodationController {

    private final AccommodationQueryService accommodationQueryService;

    public AccommodationController(AccommodationQueryService accommodationQueryService) {
        this.accommodationQueryService = accommodationQueryService;
    }

    @GetMapping
    public ResponseEntity<List<AccommodationResource>> getAllAccommodations() {
        var getAllAccommodationsQuery = new GetAllAccommodationsQuery();

        var accommodations = accommodationQueryService.handle(getAllAccommodationsQuery);

        var accommodationResources = accommodations.stream().map(AccommodationResourceFromEntityAssembler::toResourceFromEntity).toList();

        return ResponseEntity.ok(accommodationResources);
    }
}
