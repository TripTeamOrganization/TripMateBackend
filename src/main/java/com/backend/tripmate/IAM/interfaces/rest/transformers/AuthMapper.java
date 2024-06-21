package com.backend.tripmate.IAM.interfaces.rest.transformers;
import com.backend.tripmate.IAM.domain.model.commands.AuthRequest;

import com.backend.tripmate.IAM.interfaces.rest.resources.LoginRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@Mapper
public interface AuthMapper {

    AuthMapper INSTANCE = Mappers.getMapper(AuthMapper.class);

    @Mapping(source = "username", target = "email")
    @Mapping(source = "password", target = "password")
    AuthRequest loginRequestToAuthRequest(LoginRequest loginRequest);

    default String mapRoles(Set<String> roles) {
        if (roles == null || roles.isEmpty()) {
            return "";
        }
        return String.join(",", roles);
    }
}