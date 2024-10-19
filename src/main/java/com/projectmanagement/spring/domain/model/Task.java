package com.projectmanagement.spring.domain.model;

import com.projectmanagement.spring.infrastructure.output.persistence.entity.PriorityEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Task {

    private Long id;
    private PriorityEnum priorityEnum;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Project project;
    private Set<User> users;
}
