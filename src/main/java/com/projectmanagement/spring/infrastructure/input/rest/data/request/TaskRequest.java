package com.projectmanagement.spring.infrastructure.input.rest.data.request;

import com.projectmanagement.spring.infrastructure.output.persistence.entity.PriorityEnum;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class TaskRequest {

    @NotNull(message = "may not be null")
    private String name;

    @NotNull(message = "may not be null")
    private PriorityEnum priority;

    @NotNull(message = "may not be null")
    private String description;

    @NotNull(message = "may not be null")
    private LocalDate startDate;

    @NotNull(message = "may not be null")
    private LocalDate endDate;
}
