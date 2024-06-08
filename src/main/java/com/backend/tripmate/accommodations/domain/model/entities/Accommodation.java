package com.backend.tripmate.accommodations.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Accommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 50, nullable = false)
    private String name;

    @Column(name = "imagen", length = 250, nullable = false)
    private String imagePath;

    @Column(name = "descripcion", length = 250, nullable = false)
    private String description;

    @Column(name = "ubicacion", length = 150, nullable = false)
    private String location;

    @Column(name = "precio", length = 50, nullable = false)
    private String price;
}
