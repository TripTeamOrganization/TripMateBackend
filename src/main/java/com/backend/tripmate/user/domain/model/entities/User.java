package com.backend.tripmate.user.domain.model.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 50, nullable = false)
    private String name;

    @Column(name = "apellidos", length = 50, nullable = false)
    private String apellidos;

    @Column(name = "dni", length = 8, nullable = false)
    private String dni;

    @Column(name = "email", length = 60, nullable = false)
    private String email;

    @Column(name = "password", length = 50, nullable = false)
    private String password;

    @Column(name = "telefono", length = 9, nullable = false)
    private String telefono;

    @Column(name = "plan", length = 15, nullable = false)
    private String plan;
}
