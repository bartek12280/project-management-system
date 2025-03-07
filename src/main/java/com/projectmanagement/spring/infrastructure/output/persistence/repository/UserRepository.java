package com.projectmanagement.spring.infrastructure.output.persistence.repository;

import com.projectmanagement.spring.infrastructure.config.security.UserSecurityDetails;
import com.projectmanagement.spring.infrastructure.output.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Query("SELECT u.email, u.password FROM UserEntity u WHERE u.email = :email")
    Optional<Object[]> findBasicUserByEmail(@Param("email") String email);

}
