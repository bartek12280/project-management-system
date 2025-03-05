package com.projectmanagement.spring.application.port.output;

import com.projectmanagement.spring.domain.model.Project;

import java.util.Optional;
import java.util.Set;

public interface ProjectOutputPort {

    Project saveProject(Project project);
    Optional<Project> getProjectById(Long id);
    Set<Project> getAllProjects();
    void deleteProjectById(Long id);
    void flush();
}
