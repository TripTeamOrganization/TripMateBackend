package com.backend.tripmate.restaurants.interfaces.rest;

import com.backend.tripmate.restaurants.domain.model.queries.GetAllRestaurantsQuery;
import com.backend.tripmate.restaurants.domain.services.RestaurantQueryService;
import com.backend.tripmate.restaurants.interfaces.rest.resources.RestaurantResource;
import com.backend.tripmate.restaurants.interfaces.rest.transform.RestaurantResourceFromEntityAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/restaurants", produces = APPLICATION_JSON_VALUE)
public class RestaurantController {

    private final RestaurantQueryService restaurantQueryService;

    private RestaurantController(RestaurantQueryService restaurantQueryService) {
        this.restaurantQueryService = restaurantQueryService;
    }

    @GetMapping
    public ResponseEntity<List<RestaurantResource>> getAllRestaurants() {
        var getAllRestaurantsQuery = new GetAllRestaurantsQuery();
        var restaurants = restaurantQueryService.handle(getAllRestaurantsQuery);
        var restaurantResources = restaurants.stream().map(RestaurantResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(restaurantResources);
    }
}
