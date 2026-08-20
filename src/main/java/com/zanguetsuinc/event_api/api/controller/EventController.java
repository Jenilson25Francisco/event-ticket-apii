package com.zanguetsuinc.event_api.api.controller;

import com.zanguetsuinc.event_api.api.dto.request.CreateEventRequest;
import com.zanguetsuinc.event_api.api.dto.request.EventRequest;
import com.zanguetsuinc.event_api.api.dto.response.EventResponse;
import com.zanguetsuinc.event_api.api.mappers.EventMapper;
import com.zanguetsuinc.event_api.domain.models.Event;
import com.zanguetsuinc.event_api.domain.service.CreateEventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/api/vi/events")
@RequiredArgsConstructor
public class EventController {

    private final EventMapper eventMapper;
    private final CreateEventService eventService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EventResponse createEvent(
            @AuthenticationPrincipal Jwt jwt,
            @Valid @RequestBody EventRequest eventRequest
            ){
        CreateEventRequest createEventRequest = eventMapper.fromRequest(eventRequest);
        UUID userId = UUID.fromString(Objects.requireNonNull(jwt.getSubject()));
        Event createEvent = eventService.createEvent(createEventRequest, userId);
        return eventMapper.toResponse(createEvent);
    }

}
