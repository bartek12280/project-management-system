package com.projectmanagement.spring.infrastructure.input.rest.adapter;

import com.projectmanagement.spring.application.port.input.UserInputPort;
import com.projectmanagement.spring.domain.model.User;
import com.projectmanagement.spring.infrastructure.input.rest.mapper.UserRestMapper;
import com.projectmanagement.spring.infrastructure.input.rest.data.request.UserRequest;
import com.projectmanagement.spring.infrastructure.input.rest.data.response.UserResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserRestAdapter {

    private final UserInputPort userInputPort;

    private final UserRestMapper userRestMapper;


    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id) {
        final User user = userInputPort.getUserById(id);
        UserResponse userResponse = userRestMapper.toUserResponse(user);

        return ResponseEntity.ok(userResponse);
    }

    @GetMapping
    public ResponseEntity<Set<UserResponse>> getUsers() {
        final Set<UserResponse> users = userInputPort.getAllUsers().stream().map(userRestMapper::toUserResponse).collect(Collectors.toSet());
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody @Valid UserRequest userRequest) {
        User user = userRestMapper.toUser(userRequest);
        user = userInputPort.createuser(user);

        return ResponseEntity.ok(this.userRestMapper.toUserResponse(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateProject(@PathVariable Long id, @RequestBody @Valid UserRequest userRequest) {
        User updatedUser = this.userRestMapper.toUser(userRequest);

        updatedUser = this.userInputPort.updateUserById(id,updatedUser);

        return ResponseEntity.ok(this.userRestMapper.toUserResponse(updatedUser));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponse> deleteUser(@PathVariable Long id) {
        this.userInputPort.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
}
