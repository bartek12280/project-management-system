package com.projectmanagement.spring.infrastructure.input.rest.mapper;

import com.projectmanagement.spring.domain.model.Project;
import com.projectmanagement.spring.infrastructure.input.rest.data.request.ProjectRequest;
import com.projectmanagement.spring.infrastructure.input.rest.data.response.ProjectResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {TaskRestMapper.class, UserRestMapper.class})
public interface ProjectRestMapper {


    Project toProject(ProjectRequest projectRequest);

    ProjectResponse toProjectResponse(Project project);
}
