package com.projectmanagement.spring.infrastructure.input.rest.data.request;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ProjectRequest {

    @NotNull(message = "may not be null")
    private String name;

    @NotNull(message = "may not be null")
    private String description;

    @NotNull(message = "may not be null")
    private LocalDate startDate;

    @NotNull(message = "may not be null")
    private LocalDate endDate;
}
