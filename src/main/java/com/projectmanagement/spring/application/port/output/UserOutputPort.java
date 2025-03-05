package com.projectmanagement.spring.application.port.output;

import com.projectmanagement.spring.domain.model.User;

import java.util.Optional;
import java.util.Set;

public interface UserOutputPort {

    User saveUser(User user);
    Optional<User> getUserById(Long id);
    Set<User> getAllUsers();
    void deleteUserById(Long id);
    void flush();
}
