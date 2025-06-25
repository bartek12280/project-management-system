package com.projectmanagement.spring.application.service;

import com.projectmanagement.spring.application.port.output.UserOutputPort;
import com.projectmanagement.spring.domain.exception.UserNotFound;
import com.projectmanagement.spring.domain.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserServiceTest {

    private UserOutputPort userOutputPort;
    private PasswordEncoder passwordEncoder;
    private UserService userService;

    @BeforeEach
    void setUp() {
        userOutputPort = mock(UserOutputPort.class);
        passwordEncoder = mock(PasswordEncoder.class);
        userService = new UserService(userOutputPort, passwordEncoder);
    }

    @Test
    void createUserGeneratesPasswordAndSavesUser() {
        User user = new User(null, "John", "Doe", "john@example.com", null, null, null);
        when(passwordEncoder.encode("0DoeJ")).thenReturn("encoded");
        when(userOutputPort.saveUser(any())).thenAnswer(inv -> inv.getArgument(0));

        User result = userService.createuser(user);

        verify(passwordEncoder).encode("0DoeJ");
        verify(userOutputPort).saveUser(user);
        assertEquals("encoded", result.getPassword());
    }

    @Test
    void getUserByIdReturnsUserWhenPresent() {
        User user = new User(1L, "John", "Doe", "john@example.com", "pwd", null, null);
        when(userOutputPort.getUserById(1L)).thenReturn(Optional.of(user));

        User result = userService.getUserById(1L);

        assertEquals(user, result);
    }

    @Test
    void getUserByIdThrowsWhenMissing() {
        when(userOutputPort.getUserById(1L)).thenReturn(Optional.empty());

        assertThrows(UserNotFound.class, () -> userService.getUserById(1L));
    }
}
