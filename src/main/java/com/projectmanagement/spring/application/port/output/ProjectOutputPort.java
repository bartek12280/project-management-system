package com.projectmanagement.spring.application.port.output;

import com.projectmanagement.spring.domain.model.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectOutputPort {

    Project saveProject(Project project);
    Optional<Project> getProjectById(Long id);
    List<Project> getAllProjects();
    void deleteProjectById(Long id);
    void flush();
}
