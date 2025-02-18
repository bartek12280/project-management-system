package com.projectmanagement.spring.infrastructure.input.rest.data.request;


import com.projectmanagement.spring.domain.model.Task;
import com.projectmanagement.spring.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProjectRequest {

    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
}
