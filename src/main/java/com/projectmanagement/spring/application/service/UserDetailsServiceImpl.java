package com.projectmanagement.spring.application.service;

import com.projectmanagement.spring.application.port.output.UserOutputPort;
import com.projectmanagement.spring.domain.exception.UserNotFound;
import com.projectmanagement.spring.domain.model.User;
import com.projectmanagement.spring.domain.model.UserLogin;
import com.projectmanagement.spring.infrastructure.config.security.UserSecurityDetails;
import com.projectmanagement.spring.infrastructure.output.persistence.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserOutputPort userOutputPort;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
            UserLogin result = userOutputPort.findBasicUserByEmail(email)
                .orElseThrow(() -> new UserNotFound("User not found"));

        return new UserSecurityDetails(result.getEmail(),result.getPassword());
    }
}
