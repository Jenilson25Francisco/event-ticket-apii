package com.zanguetsuinc.event_api.api.dto.response;

import com.zanguetsuinc.event_api.domain.enums.EventStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventResponse {

    private UUID id;
    private String name;
    private LocalDateTime start;
    private LocalDateTime end;
    private String venue;
    private LocalDateTime salesStart;
    private LocalDateTime salesEnd;
    private EventStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<TicketTypeResponse> ticketTypes;

}
