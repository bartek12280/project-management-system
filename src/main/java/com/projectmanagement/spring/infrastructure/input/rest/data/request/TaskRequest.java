package com.projectmanagement.spring.infrastructure.input.rest.data.request;

import com.projectmanagement.spring.domain.model.Project;
import com.projectmanagement.spring.domain.model.User;
import com.projectmanagement.spring.infrastructure.output.persistence.entity.PriorityEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TaskRequest {

    private Long id;
    private String name;
    private PriorityEnum priorityEnum;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
}
