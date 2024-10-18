package com.projectmanagement.spring.application.port.input;

import com.projectmanagement.spring.domain.model.Task;

public interface TaskInputPort {
    Task getTaskById(Long id);
    Task createTask(Task task);
}
