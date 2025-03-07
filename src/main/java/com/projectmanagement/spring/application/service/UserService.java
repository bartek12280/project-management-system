package com.projectmanagement.spring.application.service;

import com.projectmanagement.spring.application.port.input.UserInputPort;
import com.projectmanagement.spring.application.port.output.UserOutputPort;
import com.projectmanagement.spring.domain.exception.UserNotFound;
import com.projectmanagement.spring.domain.model.User;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@AllArgsConstructor
public class UserService implements UserInputPort {

    private final UserOutputPort userOutputPort;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User getUserById(Long id) {
        return this.userOutputPort.getUserById(id).orElseThrow(()-> new UserNotFound("User with id: " + id + " not found"));
    }

    @Override
    public User createuser(User user) {
        String defaultPassword = generateDefaultPassword(user.getFirstName(), user.getLastName());
        user.setPassword(passwordEncoder.encode(defaultPassword));
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

    private String generateDefaultPassword(String firstName, String lastName) {
        return "0"+lastName+firstName.charAt(0);
    }


}
