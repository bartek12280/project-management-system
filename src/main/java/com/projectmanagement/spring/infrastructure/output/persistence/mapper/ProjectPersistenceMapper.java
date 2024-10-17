package com.projectmanagement.spring.infrastructure.output.persistence.mapper;

import com.projectmanagement.spring.domain.model.Project;
import com.projectmanagement.spring.infrastructure.output.persistence.entity.ProjectEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ProjectPersistenceMapper {

    ProjectEntity toProjectEntity(Project project);

    Project toProject(ProjectEntity projectEntity);
}
