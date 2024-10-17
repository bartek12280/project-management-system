package com.projectmanagement.spring.application.port.input;

import com.projectmanagement.spring.domain.model.User;

public interface CreateUserUseCase {
    User createUser(User user);
}
