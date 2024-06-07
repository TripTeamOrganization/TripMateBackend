package com.backend.tripmate.user.domain.model.commands;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserCommand {
    @NotEmpty(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotEmpty(message = "Los apellidos no pueden estar vacíos")
    private String apellidos;

    @NotEmpty(message = "El DNI no puede estar vacío")
    private String dni;

    @Email(message = "Debe proporcionar un email válido")
    @NotEmpty(message = "El email no puede estar vacío")
    private String email;

    @NotEmpty(message = "La contraseña no puede estar vacía")
    private String password;

    private String telefono;
    private String plan;
}
