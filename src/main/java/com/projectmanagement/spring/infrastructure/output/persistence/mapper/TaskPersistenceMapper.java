package com.projectmanagement.spring.infrastructure.output.persistence.mapper;

import com.projectmanagement.spring.domain.model.Task;
import com.projectmanagement.spring.infrastructure.output.persistence.entity.TaskEntity;
import org.mapstruct.Mapper;

@Mapper
public interface TaskPersistenceMapper {

    TaskEntity toTaskEntity(Task task);

    Task toTask(TaskEntity entity);

}
