package com.projectmanagement.spring.infrastructure.output.persistence.repository;

import com.projectmanagement.spring.infrastructure.output.persistence.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {
}
