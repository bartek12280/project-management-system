package com.projectmanagement.spring.application.service;

import com.projectmanagement.spring.application.port.output.TaskOutputPort;
import com.projectmanagement.spring.domain.exception.TaskNotFound;
import com.projectmanagement.spring.domain.model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TaskServiceTest {

    private TaskOutputPort taskOutputPort;
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        taskOutputPort = mock(TaskOutputPort.class);
        taskService = new TaskService(taskOutputPort);
    }

    @Test
    void getTaskByIdThrowsWhenMissing() {
        when(taskOutputPort.getTaskById(1L)).thenReturn(Optional.empty());

        assertThrows(TaskNotFound.class, () -> taskService.getTaskById(1L));
    }

    @Test
    void createTaskDelegatesToOutputPort() {
        Task task = new Task(null, "T", null, null, null, null, null, null);
        when(taskOutputPort.saveTask(task)).thenReturn(task);

        Task result = taskService.createTask(task);

        verify(taskOutputPort).saveTask(task);
        assertEquals(task, result);
    }
}
