package com.projectmanagement.spring.application.service;

import com.projectmanagement.spring.application.port.input.ProjectInputPort;
import com.projectmanagement.spring.application.port.output.ProjectOutputPort;
import com.projectmanagement.spring.domain.exception.ProjectNotFound;
import com.projectmanagement.spring.domain.model.Project;
import lombok.AllArgsConstructor;

import java.util.List;

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

    @Override
    public List<Project> getAllProjects() {
        return projectOutputPort.getAllProjects();
    }

    @Override
    public void deleteProjectById(Long id) {
        if (!this.projectOutputPort.getProjectById(id).isPresent()) {
            throw new ProjectNotFound("Project with id: " + id + " not found");
        }
        this.projectOutputPort.deleteProjectById(id);
    }

    @Override
    public Project updateProjectById(Long id, Project updatedProject) {
        Project project = this.projectOutputPort.getProjectById(id).orElseThrow(() -> new ProjectNotFound("Project with id: " + id + " not found"));
        project.setDescription(updatedProject.getDescription());
        project.setName(updatedProject.getName());
        project.setStartDate(updatedProject.getStartDate());
        project.setEndDate(updatedProject.getEndDate());
        project.setTasks(updatedProject.getTasks());
        project.setUsers(updatedProject.getUsers());

        return this.projectOutputPort.saveProject(project);
    }
}
