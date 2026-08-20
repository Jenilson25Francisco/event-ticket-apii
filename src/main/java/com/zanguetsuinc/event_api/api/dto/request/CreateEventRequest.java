package com.zanguetsuinc.event_api.api.dto.request;

import com.zanguetsuinc.event_api.domain.enums.EventStatus;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEventRequest {

    @NotBlank(message = "the name is required")
    private String name;
    private LocalDateTime start;
    private LocalDateTime end;

    @NotBlank(message = "venue information is required")
    private String venue;
    private LocalDateTime saleStart;
    private LocalDateTime saleEnd;

    @NotNull(message = "event status must be provided")
    private EventStatus status;

    @Valid
    @NotEmpty(message = "at leats one ticket type must be provided")
    private List<TicketTypeRequest> ticketTypes;

}
