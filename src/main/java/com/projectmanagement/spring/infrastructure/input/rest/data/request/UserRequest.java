package com.projectmanagement.spring.infrastructure.input.rest.data.request;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserRequest {

    @NotNull(message = "may not be null")
    private String firstName;

    @NotNull(message = "may not be null")
    private String lastName;

    @NotNull(message = "may not be null")
    private String email;
}
