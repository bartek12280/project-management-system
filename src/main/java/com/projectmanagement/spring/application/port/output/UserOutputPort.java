package com.projectmanagement.spring.application.port.output;

import com.projectmanagement.spring.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserOutputPort {

    User saveUser(User user);
    Optional<User> getUserById(Long id);
    List<User> getAllUsers();
    void deleteUserById(Long id);
    void flush();
}
