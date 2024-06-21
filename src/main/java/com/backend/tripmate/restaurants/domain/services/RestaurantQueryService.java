package com.backend.tripmate.restaurants.domain.services;

import com.backend.tripmate.restaurants.domain.model.entities.Restaurant;
import com.backend.tripmate.restaurants.domain.model.queries.GetAllRestaurantsQuery;

import java.util.List;

public interface RestaurantQueryService {
    List<Restaurant> handle(GetAllRestaurantsQuery query);
}
