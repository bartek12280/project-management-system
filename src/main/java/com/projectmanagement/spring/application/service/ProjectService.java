package com.projectmanagement.spring.application.service;

import com.projectmanagement.spring.application.port.input.ProjectInputPort;
import com.projectmanagement.spring.application.port.output.ProjectOutputPort;
import com.projectmanagement.spring.domain.exception.ProjectNotFound;
import com.projectmanagement.spring.domain.model.Project;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProjectService implements ProjectInputPort {

    private final ProjectOutputPort projectOutputPort;

    @Override
    public Project getProjectById(Long id) {
        return this.projectOutputPort.getProjectById(id).orElseThrow(() -> new ProjectNotFound("Project with id: " + id + " not found"));
    }

    @Override
    public Project createProject(Project project) {
        project = this.projectOutputPort.saveProject(project);
        return project;
    }
}
