package com.projectmanagement.spring.infrastructure.input.rest.data.response;

import com.projectmanagement.spring.domain.model.Task;
import com.projectmanagement.spring.domain.model.User;
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
public class ProjectResponse {

    private Long id;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Set<Task> tasks;
    private Set<User> users;
}
