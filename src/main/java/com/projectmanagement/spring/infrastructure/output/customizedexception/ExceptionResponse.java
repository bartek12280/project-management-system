package com.projectmanagement.spring.infrastructure.output.customizedexception;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {

    private LocalDateTime date;

    private String message;

    private List<String> details;
}
