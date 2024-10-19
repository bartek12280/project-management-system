package com.projectmanagement.spring.infrastructure.input.rest.adapter;

import com.projectmanagement.spring.application.port.input.TaskInputPort;
import com.projectmanagement.spring.domain.model.Task;
import com.projectmanagement.spring.infrastructure.input.rest.data.request.TaskRequest;
import com.projectmanagement.spring.infrastructure.input.rest.data.response.TaskResponse;
import com.projectmanagement.spring.infrastructure.input.rest.mapper.TaskRestMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Tasks")
@RequiredArgsConstructor
public class TaskRestAdapter {

    private final TaskRestMapper taskRestMapper;

    private final TaskInputPort taskInputPort;

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> getTask(@PathVariable Long id){
        Task task = taskInputPort.getTaskById(id);
        TaskResponse taskResponse = taskRestMapper.toTaskResponse(task);
        return ResponseEntity.ok(taskResponse);
    }

    @PostMapping
    public ResponseEntity<TaskResponse> createTask(@RequestBody @Valid TaskRequest taskRequest){
        Task task = taskRestMapper.toTask(taskRequest);
        task = taskInputPort.createTask(task);

        return ResponseEntity.ok(taskRestMapper.toTaskResponse(task));
    }
}
