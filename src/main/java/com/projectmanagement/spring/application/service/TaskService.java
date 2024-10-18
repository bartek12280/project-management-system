package com.projectmanagement.spring.application.service;

import com.projectmanagement.spring.application.port.input.TaskInputPort;
import com.projectmanagement.spring.application.port.output.TaskOutputPort;
import com.projectmanagement.spring.domain.exception.TaskNotFound;
import com.projectmanagement.spring.domain.model.Task;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TaskService implements TaskInputPort {

    private final TaskOutputPort taskOutputPort;

    @Override
    public Task getTaskById(Long id) {
        return this.taskOutputPort.getTaskById(id).orElseThrow(() -> new TaskNotFound("Task with id: " + id + " not found"));
    }

    @Override
    public Task createTask(Task task) {
        task = this.taskOutputPort.saveTask(task);
        return task;
    }
}
