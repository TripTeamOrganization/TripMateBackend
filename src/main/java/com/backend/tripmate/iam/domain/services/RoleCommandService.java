package com.backend.tripmate.iam.domain.services;

public interface RoleCommandService {
    void handle(SeedRolesCommand command);
}
