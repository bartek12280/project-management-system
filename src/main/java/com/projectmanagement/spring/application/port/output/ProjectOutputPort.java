package com.projectmanagement.spring.application.port.output;

import com.projectmanagement.spring.domain.model.Project;

import java.util.Optional;

public interface ProjectOutputPort {

    Project saveProject(Project project);
    Optional<Project> getProjectById(Long id);
}
