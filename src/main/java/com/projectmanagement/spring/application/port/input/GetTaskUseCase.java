package com.projectmanagement.spring.application.port.input;

import com.projectmanagement.spring.domain.model.Task;

public interface GetTaskUseCase {
    Task getTaskById(Long id);
}
