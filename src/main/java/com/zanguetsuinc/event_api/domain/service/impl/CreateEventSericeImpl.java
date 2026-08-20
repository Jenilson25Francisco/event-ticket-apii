package com.zanguetsuinc.event_api.domain.service.impl;

import com.zanguetsuinc.event_api.api.dto.request.CreateEventRequest;
import com.zanguetsuinc.event_api.domain.exceptions.NotFoundException;
import com.zanguetsuinc.event_api.domain.models.Event;
import com.zanguetsuinc.event_api.domain.models.TIcketType;
import com.zanguetsuinc.event_api.domain.models.User;
import com.zanguetsuinc.event_api.domain.repository.EventRepository;
import com.zanguetsuinc.event_api.domain.repository.UserRepository;
import com.zanguetsuinc.event_api.domain.service.CreateEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateEventSericeImpl implements CreateEventService {

    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    @Override
    public Event createEvent(CreateEventRequest event, UUID organizerId) {

        User organizer = userRepository.findById(organizerId)
                .orElseThrow(() -> new NotFoundException("User not found"));

        List<TIcketType> tIcketTypes = event.getTicketTypes().stream()
                .map(ticketType -> {
                    TIcketType ticketTypeToCreate = new TIcketType();
                    ticketTypeToCreate.setName(ticketType.getName());
                    ticketTypeToCreate.setDescription(ticketType.getDescription());
                    ticketTypeToCreate.setPrice(ticketType.getPrice());
                    ticketTypeToCreate.setTotalAvailable(ticketType.getTotalAvailable());
                    return ticketTypeToCreate;
                }).toList();

        Event eventToCreate = new Event();
        eventToCreate.setName(event.getName());
        eventToCreate.setStartDate(event.getStart());
        eventToCreate.setEndDate(event.getEnd());
        eventToCreate.setVenue(event.getVenue());
        eventToCreate.setSalesStart(event.getSaleStart());
        eventToCreate.setSalesEnd(event.getSaleEnd());
        eventToCreate.setStatus(event.getStatus());
        eventToCreate.setOrganizer(organizer);
        eventToCreate.setTIcketTypes(tIcketTypes);

        return eventRepository.save(eventToCreate);
    }

}
