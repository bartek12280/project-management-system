package com.projectmanagement.spring.application.port.input;

import com.projectmanagement.spring.domain.model.User;

public interface UserInputPort {
    User getUserById(Long id);
    User createuser(User user);
}
