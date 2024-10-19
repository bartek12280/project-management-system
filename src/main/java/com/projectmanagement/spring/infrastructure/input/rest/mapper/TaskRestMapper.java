package com.projectmanagement.spring.infrastructure.input.rest.mapper;

import com.projectmanagement.spring.domain.model.Task;
import com.projectmanagement.spring.infrastructure.input.rest.data.request.TaskRequest;
import com.projectmanagement.spring.infrastructure.input.rest.data.response.TaskResponse;
import org.mapstruct.Mapper;

@Mapper
public interface TaskRestMapper {

    Task toTask(TaskRequest taskRequest);

    TaskResponse toTaskResponse(Task task);
}
