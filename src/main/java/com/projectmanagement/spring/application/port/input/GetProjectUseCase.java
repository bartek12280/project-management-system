package com.projectmanagement.spring.application.port.input;

import com.projectmanagement.spring.domain.model.Project;

public interface GetProjectUseCase {
    Project getProjectById(Long id);
}
