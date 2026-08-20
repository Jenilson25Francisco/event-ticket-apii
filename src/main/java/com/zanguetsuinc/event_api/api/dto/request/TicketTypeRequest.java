package com.zanguetsuinc.event_api.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketTypeRequest {

    @NotBlank(message = "name is required")
    private String name;
    @NotNull(message = "price is required")
    @PositiveOrZero(message = "price must be zero or greater")
    private Double price;
    private String description;
    private Integer totalAvailable;

}
