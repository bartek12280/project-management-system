package com.projectmanagement.spring.infrastructure.input.rest.mapper;

import com.projectmanagement.spring.domain.model.User;
import com.projectmanagement.spring.infrastructure.input.rest.data.request.UserRequest;
import com.projectmanagement.spring.infrastructure.input.rest.data.response.UserResponse;
import org.mapstruct.Mapper;

@Mapper
public interface UserRestMapper {

    User toUser(UserRequest userRequest);

    UserResponse toUserResponse(User user);
}
