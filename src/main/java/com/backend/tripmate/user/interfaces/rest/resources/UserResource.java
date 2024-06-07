package com.backend.tripmate.user.interfaces.rest.resources;

public record UserResource(Long id, String name, String apellidos, String dni, String email, String password, String telefono, String plan) {
}