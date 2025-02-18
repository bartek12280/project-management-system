package com.projectmanagement.spring.infrastructure.input.rest.data.response;

import com.projectmanagement.spring.domain.model.Project;
import com.projectmanagement.spring.domain.model.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Set<Task> tasks;
    private Set<Project> projects;
}
