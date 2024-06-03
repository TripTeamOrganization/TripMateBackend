package com.backend.tripmate.accommodations.domain.services;

import com.backend.tripmate.accommodations.domain.model.entities.Accommodation;
import com.backend.tripmate.accommodations.domain.model.queries.GetAllAccommodations;

import java.util.List;

public interface AccommodationQueryService {

    List<Accommodation> handle(GetAllAccommodations query);
}
