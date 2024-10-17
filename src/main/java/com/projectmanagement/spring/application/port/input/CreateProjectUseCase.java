package com.projectmanagement.spring.application.port.input;

import com.projectmanagement.spring.domain.model.Project;

public interface CreateProjectUseCase {
    Project createProject(Project project);
}
