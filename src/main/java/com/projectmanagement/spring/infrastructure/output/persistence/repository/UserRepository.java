package com.projectmanagement.spring.infrastructure.output.persistence.repository;

import com.projectmanagement.spring.infrastructure.output.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
