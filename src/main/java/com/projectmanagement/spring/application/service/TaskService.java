package com.projectmanagement.spring.application.service;

import com.projectmanagement.spring.application.port.input.TaskInputPort;
import com.projectmanagement.spring.application.port.output.TaskOutputPort;
import com.projectmanagement.spring.domain.exception.TaskNotFound;
import com.projectmanagement.spring.domain.model.Task;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
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

    @Override
    public List<Task> getAllTasks() {
        return this.taskOutputPort.getAllTasks();
    }

    @Transactional
    @Override
    public void deleteTaskById(Long id) {
        if (this.taskOutputPort.getTaskById(id).isEmpty()) {
            throw new TaskNotFound("Task with id: " + id + " not found");
        }

        taskOutputPort.flush();

        this.taskOutputPort.deleteTaskById(id);
    }

    @Override
    public Task updateTaskById(Long id, Task updatedTask) {
        Task task = this.taskOutputPort.getTaskById(id).orElseThrow(() -> new TaskNotFound("Task with id: " + id + " not found"));
        task.setName(updatedTask.getName());
        task.setDescription(updatedTask.getDescription());
        task.setUsers(task.getUsers());
        task.setStartDate(task.getStartDate());
        task.setEndDate(task.getEndDate());
        task.setPriorityEnum(task.getPriorityEnum());

        return this.taskOutputPort.saveTask(task);
    }
}
