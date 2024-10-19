package com.projectmanagement.spring.infrastructure.input.rest.data.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ProjectResponse {

    private Long id;

    private String name;

    private String description;

    private LocalDate startDate;

    private LocalDate endDate;
}
