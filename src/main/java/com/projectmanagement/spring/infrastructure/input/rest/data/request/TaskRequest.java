package com.projectmanagement.spring.infrastructure.input.rest.data.request;

import com.projectmanagement.spring.infrastructure.output.persistence.entity.PriorityEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TaskRequest {

    private String name;
    private PriorityEnum priorityEnum;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
}
