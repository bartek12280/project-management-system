package com.projectmanagement.spring.application.service;

import com.projectmanagement.spring.application.port.output.UserOutputPort;
import com.projectmanagement.spring.infrastructure.config.security.UserSecurityDetails;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserOutputPort userOutputPort;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Object[] result = userOutputPort.findBasicUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new UserSecurityDetails(result[0].toString(),result[1].toString());
    }
}
