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

import java.util.Set;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectRestAdapter {

    private final ProjectRestMapper projectRestMapper;

    private final ProjectInputPort projectInputPort;

    @GetMapping
    public ResponseEntity<Set<ProjectResponse>> getAllProjects() {
        Set<ProjectResponse> projects = this.projectInputPort.getAllProjects().stream()
                .map(this.projectRestMapper::toProjectResponse)
                .collect(Collectors.toSet());

        return ResponseEntity.ok(projects);
    }

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

    @PutMapping("/{id}")
    public ResponseEntity<ProjectResponse> updateProject(@PathVariable Long id, @RequestBody @Valid ProjectRequest projectRequest) {
        Project updatedProject = projectRestMapper.toProject(projectRequest);

        updatedProject = this.projectInputPort.updateProjectById(id, updatedProject);

        return ResponseEntity.ok(this.projectRestMapper.toProjectResponse(updatedProject));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ProjectResponse> deleteProject(@PathVariable Long id) {
        this.projectInputPort.deleteProjectById(id);
        return ResponseEntity.noContent().build();
    }
}
