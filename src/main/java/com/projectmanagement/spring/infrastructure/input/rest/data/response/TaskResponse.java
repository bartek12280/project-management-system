package com.projectmanagement.spring.infrastructure.input.rest.data.response;

import com.projectmanagement.spring.infrastructure.output.persistence.entity.PriorityEnum;
import java.time.LocalDate;


public class TaskResponse {

    private Long id;

    private String name;

    private PriorityEnum priority;

    private String description;

    private LocalDate startDate;

    private LocalDate endDate;
}

