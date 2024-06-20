package com.backend.tripmate.activities.domain.services;

import com.backend.tripmate.activities.domain.model.entities.Activity;
import com.backend.tripmate.activities.domain.model.queries.GetAllActivitiesQuery;

import java.util.List;

public interface ActivityQueryService {
    List<Activity> handle(GetAllActivitiesQuery query);
}
