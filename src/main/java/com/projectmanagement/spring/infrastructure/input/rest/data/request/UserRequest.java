package com.projectmanagement.spring.infrastructure.input.rest.data.request;


import com.projectmanagement.spring.domain.model.Project;
import com.projectmanagement.spring.domain.model.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRequest {

    private String firstName;
    private String lastName;
    private String email;
}
