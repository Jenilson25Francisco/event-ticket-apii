package com.zanguetsuinc.event_api.api.dto.request;

import com.zanguetsuinc.event_api.domain.enums.EventStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventRequest {

    private String name;
    private LocalDateTime start;
    private LocalDateTime end;
    private String venue;
    private LocalDateTime saleStart;
    private LocalDateTime saleEnd;
    private EventStatus status;
    private List<CreateTicketTypeRequest> ticketTypes;

}
