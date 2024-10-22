package com.projectmanagement.spring.application.port.input;

import com.projectmanagement.spring.domain.model.Project;

import java.util.List;

public interface ProjectInputPort {
    Project getProjectById(Long id);
    Project createProject(Project project);
    List<Project> getAllProjects();
    void deleteProjectById(Long id);
    Project updateProjectById(Long id, Project project);
}
