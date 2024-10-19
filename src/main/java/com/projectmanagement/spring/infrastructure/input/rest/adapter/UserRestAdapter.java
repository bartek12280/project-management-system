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

    @PostMapping()
    public ResponseEntity<UserResponse> createUser(@RequestBody @Valid UserRequest userRequest) {
        User user = userRestMapper.toUser(userRequest);
        user = userInputPort.createuser(user);

        return ResponseEntity.ok(this.userRestMapper.toUserResponse(user));
    }
}
