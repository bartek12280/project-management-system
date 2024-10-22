package com.projectmanagement.spring.application.port.input;

import com.projectmanagement.spring.domain.model.Task;

import java.util.List;

public interface TaskInputPort {
    Task getTaskById(Long id);
    Task createTask(Task task);
    List<Task> getAllTasks();
    void deleteTaskById(Long id);
    Task updateTaskById(Long id, Task task);
}
