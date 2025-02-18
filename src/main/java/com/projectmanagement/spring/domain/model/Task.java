package com.projectmanagement.spring.domain.model;

import com.projectmanagement.spring.infrastructure.output.persistence.entity.PriorityEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Task {

    private String name;
    private PriorityEnum priorityEnum;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Project project;
    private Set<User> users;
}
