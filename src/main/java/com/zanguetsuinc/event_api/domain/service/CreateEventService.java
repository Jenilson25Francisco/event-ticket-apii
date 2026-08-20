package com.zanguetsuinc.event_api.domain.service;

import com.zanguetsuinc.event_api.api.dto.request.CreateEventRequest;
import com.zanguetsuinc.event_api.domain.models.Event;

import java.util.UUID;

public interface CreateEventService {

    Event createEvent(CreateEventRequest event, UUID organizerId);

}
