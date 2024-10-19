package com.projectmanagement.spring.infrastructure.input.rest.data.response;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserResponse {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;
}
