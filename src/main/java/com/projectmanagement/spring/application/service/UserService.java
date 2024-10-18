package com.projectmanagement.spring.application.service;

import com.projectmanagement.spring.application.port.input.UserInputPort;
import com.projectmanagement.spring.application.port.output.UserOutputPort;
import com.projectmanagement.spring.domain.exception.UserNotFound;
import com.projectmanagement.spring.domain.model.User;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserService implements UserInputPort {

    private final UserOutputPort userOutputPort;

    @Override
    public User getUserById(Long id) {
        return this.userOutputPort.getUserById(id).orElseThrow(()-> new UserNotFound("User with id: " + id + " not found"));
    }

    @Override
    public User createuser(User user) {
        user = this.userOutputPort.saveUser(user);
        return user;
    }
}
