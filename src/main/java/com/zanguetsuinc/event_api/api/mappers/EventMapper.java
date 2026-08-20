package com.zanguetsuinc.event_api.api.mappers;

import com.zanguetsuinc.event_api.api.dto.request.CreateEventRequest;
import com.zanguetsuinc.event_api.api.dto.request.CreateTicketTypeRequest;
import com.zanguetsuinc.event_api.api.dto.request.EventRequest;
import com.zanguetsuinc.event_api.api.dto.request.TicketTypeRequest;
import com.zanguetsuinc.event_api.api.dto.response.EventResponse;
import com.zanguetsuinc.event_api.domain.models.Event;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring")
public interface EventMapper {

    CreateTicketTypeRequest fromRequest(TicketTypeRequest request);
    CreateEventRequest fromRequest(EventRequest response);

    EventResponse toResponse(Event event);

}
