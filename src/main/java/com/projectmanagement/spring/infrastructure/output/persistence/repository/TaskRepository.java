package com.projectmanagement.spring.infrastructure.output.persistence.repository;

import com.projectmanagement.spring.infrastructure.output.persistence.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
}
