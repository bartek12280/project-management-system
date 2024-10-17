package com.projectmanagement.spring.domain.model;

import lombok.*;

import java.util.Set;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Set<Task> tasks;
    private Set<Project> projects;
}
