package com.projectmanagement.spring.infrastructure.input.rest.adapter;

import com.projectmanagement.spring.application.port.input.ProjectInputPort;
import com.projectmanagement.spring.domain.model.Project;
import com.projectmanagement.spring.infrastructure.input.rest.data.request.ProjectRequest;
import com.projectmanagement.spring.infrastructure.input.rest.data.response.ProjectResponse;
import com.projectmanagement.spring.infrastructure.input.rest.mapper.ProjectRestMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectRestAdapter {

    private final ProjectRestMapper projectRestMapper;

    private final ProjectInputPort projectInputPort;

    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponse> getProject(@PathVariable Long id) {
        final Project project = projectInputPort.getProjectById(id);
        ProjectResponse projectResponse = projectRestMapper.toProjectResponse(project);

        return ResponseEntity.ok(projectResponse);
    }

    @PostMapping
    public ResponseEntity<ProjectResponse> createProject(@RequestBody @Valid ProjectRequest projectRequest) {
        Project project = projectRestMapper.toProject(projectRequest);
        project = projectInputPort.createProject(project);

        return ResponseEntity.ok(this.projectRestMapper.toProjectResponse(project));
    }
}
