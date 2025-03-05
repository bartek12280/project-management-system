package com.projectmanagement.spring.application.port.output;

import com.projectmanagement.spring.domain.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskOutputPort {

    Task saveTask(Task task);
    Optional<Task> getTaskById(Long id);
    List<Task> getAllTasks();
    void deleteTaskById(Long id);
    void flush();
}
