package com.projectmanagement.spring.application.port.output;

import com.projectmanagement.spring.domain.model.Task;

import java.util.Optional;
import java.util.Set;

public interface TaskOutputPort {

    Task saveTask(Task task);
    Optional<Task> getTaskById(Long id);
    Set<Task> getAllTasks();
    void deleteTaskById(Long id);
    void flush();
}
