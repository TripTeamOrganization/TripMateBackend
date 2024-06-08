package com.backend.tripmate.restaurants.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 50, nullable = false)
    private String name;

    @Column(name = "imagen", length = 50, nullable = false)
    private String image;

    @Column(name = "locationCost", length = 50, nullable = false)
    private String locationCost;

    @Column(name = "mustTry", length = 50, nullable = false)
    private String mustTry;
}
