package com.projectmanagement.spring.infrastructure.output.persistence;

import com.projectmanagement.spring.application.port.output.TaskOutputPort;
import com.projectmanagement.spring.domain.model.Task;
import com.projectmanagement.spring.infrastructure.output.persistence.entity.TaskEntity;
import com.projectmanagement.spring.infrastructure.output.persistence.mapper.TaskPersistenceMapper;
import com.projectmanagement.spring.infrastructure.output.persistence.repository.TaskRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class TaskPersistenceAdapter implements TaskOutputPort {

    private final TaskRepository taskRepository;

    private final TaskPersistenceMapper taskPersistenceMapper;

    @Override
    public Task saveTask(Task task) {
        TaskEntity taskEntity = this.taskPersistenceMapper.toTaskEntity(task);
        taskEntity = this.taskRepository.save(taskEntity);
        return this.taskPersistenceMapper.toTask(taskEntity);
    }

    @Override
    public Optional<Task> getTaskById(Long id) {
        Optional<TaskEntity> taskEntity = this.taskRepository.findById(id);

        if (taskEntity.isEmpty()) {
            return Optional.empty();
        }

        Task task = this.taskPersistenceMapper.toTask(taskEntity.get());
        return Optional.of(task);
    }
}
