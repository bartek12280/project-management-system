package com.projectmanagement.spring.infrastructure.config;

import com.projectmanagement.spring.application.service.ProjectService;
import com.projectmanagement.spring.application.service.TaskService;
import com.projectmanagement.spring.application.service.UserService;
import com.projectmanagement.spring.infrastructure.output.persistence.ProjectPersistenceAdapter;
import com.projectmanagement.spring.infrastructure.output.persistence.TaskPersistenceAdapter;
import com.projectmanagement.spring.infrastructure.output.persistence.UserPersistenceAdapter;
import com.projectmanagement.spring.infrastructure.output.persistence.mapper.ProjectPersistenceMapper;
import com.projectmanagement.spring.infrastructure.output.persistence.mapper.TaskPersistenceMapper;
import com.projectmanagement.spring.infrastructure.output.persistence.mapper.UserPersistenceMapper;
import com.projectmanagement.spring.infrastructure.output.persistence.repository.ProjectRepository;
import com.projectmanagement.spring.infrastructure.output.persistence.repository.TaskRepository;
import com.projectmanagement.spring.infrastructure.output.persistence.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public UserPersistenceAdapter productPersistenceAdapter(final UserPersistenceMapper userPersistenceMapper, final UserRepository userRepository) {
        return new UserPersistenceAdapter(userRepository, userPersistenceMapper);
    }

    // todo: add actionListener
    @Bean
    public UserService userService(final UserPersistenceAdapter userPersistenceAdapter) {
        return new UserService(userPersistenceAdapter);
    }

    @Bean
    public ProjectPersistenceAdapter projectPersistenceAdapter(final ProjectPersistenceMapper projectPersistenceMapper, final ProjectRepository projectRepository){
        return new ProjectPersistenceAdapter(projectRepository, projectPersistenceMapper);
    }

    //todo: add actionListener
    @Bean
    public ProjectService projectService(final ProjectPersistenceAdapter projectPersistenceAdapter){
        return new ProjectService(projectPersistenceAdapter);
    }

    @Bean
    public TaskPersistenceAdapter taskPersistenceAdapter(final TaskPersistenceMapper taskPersistenceMapper, final TaskRepository taskRepository){
        return new TaskPersistenceAdapter(taskRepository, taskPersistenceMapper);
    }

    // todo: addActionListener
    @Bean
    public TaskService taskService(final TaskPersistenceAdapter taskPersistenceAdapter){
        return new TaskService(taskPersistenceAdapter);
    }
}
