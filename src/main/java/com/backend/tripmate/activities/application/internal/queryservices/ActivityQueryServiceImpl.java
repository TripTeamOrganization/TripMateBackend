package com.backend.tripmate.activities.application.internal.queryservices;

import com.backend.tripmate.activities.domain.model.entities.Activity;
import com.backend.tripmate.activities.domain.model.queries.GetAllActivitiesQuery;
import com.backend.tripmate.activities.domain.services.ActivityQueryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityQueryServiceImpl implements ActivityQueryService {

    @Override
    public List<Activity> handle(GetAllActivitiesQuery query) {
        // Implementation details...
        return null;
    }
}