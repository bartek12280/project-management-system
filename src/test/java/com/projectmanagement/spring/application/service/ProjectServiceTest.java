package com.projectmanagement.spring.application.service;

import com.projectmanagement.spring.application.port.output.ProjectOutputPort;
import com.projectmanagement.spring.domain.exception.ProjectNotFound;
import com.projectmanagement.spring.domain.model.Project;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProjectServiceTest {

    private ProjectOutputPort projectOutputPort;
    private ProjectService projectService;

    @BeforeEach
    void setUp() {
        projectOutputPort = mock(ProjectOutputPort.class);
        projectService = new ProjectService(projectOutputPort);
    }

    @Test
    void getProjectByIdThrowsWhenMissing() {
        when(projectOutputPort.getProjectById(1L)).thenReturn(Optional.empty());

        assertThrows(ProjectNotFound.class, () -> projectService.getProjectById(1L));
    }

    @Test
    void createProjectDelegatesToOutputPort() {
        Project project = new Project(null, "P", null, null, null, null, null);
        when(projectOutputPort.saveProject(project)).thenReturn(project);

        Project result = projectService.createProject(project);

        verify(projectOutputPort).saveProject(project);
        assertEquals(project, result);
    }
}
