package com.projectmanagement.spring.infrastructure.input.rest.data.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRequest {

    private String firstName;
    private String lastName;
    private String email;
}
