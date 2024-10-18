package com.projectmanagement.spring.application.port.input;

import com.projectmanagement.spring.domain.model.Project;

public interface ProjectInputPort {
    Project getProjectById(Long id);
    Project createProject(Project project);
}
