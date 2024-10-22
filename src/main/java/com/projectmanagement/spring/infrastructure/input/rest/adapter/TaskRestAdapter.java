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

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Tasks")
@RequiredArgsConstructor
public class TaskRestAdapter {

    private final TaskRestMapper taskRestMapper;

    private final TaskInputPort taskInputPort;

    @GetMapping
    public ResponseEntity<List<TaskResponse>> getTasks() {
        List<TaskResponse> tasks = taskInputPort.getAllTasks().stream()
                .map(this.taskRestMapper::toTaskResponse)
                .toList();

        return ResponseEntity.ok(tasks);
    }

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

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponse> updateTask(@PathVariable Long id, @RequestBody @Valid TaskRequest taskRequest){
        Task updatedTask = this.taskRestMapper.toTask(taskRequest);
        this.taskInputPort.updateTaskById(id, updatedTask);

        return ResponseEntity.ok(taskRestMapper.toTaskResponse(updatedTask));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TaskResponse> deleteTask(@PathVariable Long id){
        this.taskInputPort.deleteTaskById(id);
        return ResponseEntity.noContent().build();
    }
}
