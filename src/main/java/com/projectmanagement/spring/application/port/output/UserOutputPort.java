package com.projectmanagement.spring.application.port.output;

import com.projectmanagement.spring.domain.model.User;

import java.util.Optional;

public interface UserOutputPort {

    User saveUser(User user);
    Optional<User> getUserById(Long id);
}
