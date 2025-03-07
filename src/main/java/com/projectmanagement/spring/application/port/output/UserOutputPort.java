package com.projectmanagement.spring.application.port.output;

import com.projectmanagement.spring.domain.model.User;
import com.projectmanagement.spring.infrastructure.config.security.UserSecurityDetails;
import com.projectmanagement.spring.infrastructure.output.persistence.entity.UserEntity;

import java.util.Optional;
import java.util.Set;

public interface UserOutputPort {

    User saveUser(User user);
    Optional<User> getUserById(Long id);
    Optional<Object[]> findBasicUserByEmail(String email);
    Set<User> getAllUsers();
    void deleteUserById(Long id);
    void flush();
}
