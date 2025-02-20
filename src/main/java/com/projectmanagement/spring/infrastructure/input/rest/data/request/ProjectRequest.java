package com.projectmanagement.spring.infrastructure.input.rest.data.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProjectRequest {

    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
}
