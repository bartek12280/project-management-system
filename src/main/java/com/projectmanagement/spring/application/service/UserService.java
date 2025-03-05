package com.projectmanagement.spring.application.service;

import com.projectmanagement.spring.application.port.input.UserInputPort;
import com.projectmanagement.spring.application.port.output.UserOutputPort;
import com.projectmanagement.spring.domain.exception.UserNotFound;
import com.projectmanagement.spring.domain.model.User;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

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

    @Override
    public Set<User> getAllUsers() {
        return this.userOutputPort.getAllUsers();
    }

    @Transactional
    @Override
    public void deleteUserById(Long id) {
        if (this.userOutputPort.getUserById(id).isEmpty()) {
            throw new UserNotFound("User with id: " + id + " not found");
        }

        userOutputPort.flush();

        this.userOutputPort.deleteUserById(id);
    }

    @Override
    public User updateUserById(Long id, User updatedUser) {
        User user = this.userOutputPort.getUserById(id).orElseThrow(()-> new UserNotFound("User with id: " + id + " not found"));
        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        user.setEmail(updatedUser.getEmail());
        user.setProjects(updatedUser.getProjects());

        return this.userOutputPort.saveUser(user);
    }


}
