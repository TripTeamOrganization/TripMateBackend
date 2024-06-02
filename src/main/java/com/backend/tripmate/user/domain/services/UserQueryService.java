package com.backend.tripmate.user.domain.services;

import com.backend.tripmate.user.domain.model.entities.User;
import com.backend.tripmate.user.domain.model.queries.GetAllUserQuery;

import java.util.List;

public interface UserQueryService {
    List<User> handle(GetAllUserQuery query);

}
