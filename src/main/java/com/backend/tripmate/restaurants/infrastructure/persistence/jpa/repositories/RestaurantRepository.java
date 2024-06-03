package com.backend.tripmate.restaurants.infrastructure.persistence.jpa.repositories;

import com.backend.tripmate.restaurants.domain.model.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
