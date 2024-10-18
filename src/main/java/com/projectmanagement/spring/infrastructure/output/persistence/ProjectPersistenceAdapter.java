package com.projectmanagement.spring.infrastructure.output.persistence;

import com.projectmanagement.spring.application.port.output.ProjectOutputPort;
import com.projectmanagement.spring.domain.model.Project;
import com.projectmanagement.spring.infrastructure.output.persistence.entity.ProjectEntity;
import com.projectmanagement.spring.infrastructure.output.persistence.mapper.ProjectPersistenceMapper;
import com.projectmanagement.spring.infrastructure.output.persistence.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class ProjectPersistenceAdapter implements ProjectOutputPort {

    private ProjectRepository projectRepository;

    private ProjectPersistenceMapper projectPersistenceMapper;

    @Override
    public Project saveProject(Project project) {
        ProjectEntity projectEntity = this.projectPersistenceMapper.toProjectEntity(project);
        projectEntity = this.projectRepository.save(projectEntity);
        return this.projectPersistenceMapper.toProject(projectEntity);
    }

    @Override
    public Optional<Project> getProjectById(Long id) {
        return Optional.empty();
    }
}
