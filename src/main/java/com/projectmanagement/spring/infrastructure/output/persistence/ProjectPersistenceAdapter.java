package com.projectmanagement.spring.infrastructure.output.persistence;

import com.projectmanagement.spring.application.port.output.ProjectOutputPort;
import com.projectmanagement.spring.domain.model.Project;
import com.projectmanagement.spring.infrastructure.output.persistence.entity.ProjectEntity;
import com.projectmanagement.spring.infrastructure.output.persistence.mapper.ProjectPersistenceMapper;
import com.projectmanagement.spring.infrastructure.output.persistence.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ProjectPersistenceAdapter implements ProjectOutputPort {

    private final ProjectRepository projectRepository;

    private final ProjectPersistenceMapper projectPersistenceMapper;

    @Override
    public Project saveProject(Project project) {
        ProjectEntity projectEntity = this.projectPersistenceMapper.toProjectEntity(project);
        projectEntity = this.projectRepository.save(projectEntity);
        return this.projectPersistenceMapper.toProject(projectEntity);
    }

    @Override
    public Optional<Project> getProjectById(Long id) {
        final Optional<ProjectEntity> projectEntity = this.projectRepository.findById(id);

        if (projectEntity.isEmpty()) {
            return Optional.empty();
        }

        Project project = this.projectPersistenceMapper.toProject(projectEntity.get());
        return Optional.of(project);
    }

    @Override
    public List<Project> getAllProjects() {
        return this.projectRepository.findAll().stream()
                .map(this.projectPersistenceMapper::toProject)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteProjectById(Long id) {
        this.projectRepository.deleteById(id);
    }
}
