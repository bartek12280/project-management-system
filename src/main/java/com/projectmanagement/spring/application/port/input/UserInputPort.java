package com.projectmanagement.spring.application.port.input;

import com.projectmanagement.spring.domain.model.User;

import java.util.List;

public interface UserInputPort {
    User getUserById(Long id);
    User createuser(User user);
    List<User> getAllUsers();
    void deleteUserById(Long id);
    User updateUserById(Long id, User user);
}
