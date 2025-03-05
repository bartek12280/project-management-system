package com.projectmanagement.spring.infrastructure.output.persistence;

import com.projectmanagement.spring.application.port.output.UserOutputPort;
import com.projectmanagement.spring.domain.model.User;
import com.projectmanagement.spring.infrastructure.output.persistence.entity.UserEntity;
import com.projectmanagement.spring.infrastructure.output.persistence.mapper.UserPersistenceMapper;
import com.projectmanagement.spring.infrastructure.output.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserOutputPort {

    private final UserRepository userRepository;

    private final UserPersistenceMapper userPersistenceMapper;


    @Override
    public User saveUser(User user) {
        UserEntity userEntity = this.userPersistenceMapper.toUserEntity(user);
        this.userRepository.save(userEntity);
        return this.userPersistenceMapper.toUser(userEntity);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        final Optional<UserEntity> userEntity = this.userRepository.findById(id);

        if (userEntity.isEmpty()){
            return Optional.empty();
        }

        User user = this.userPersistenceMapper.toUser(userEntity.get());
        return Optional.of(user);
    }

    @Override
    public Set<User> getAllUsers() {
        return this.userRepository.findAll().stream()
                .map(this.userPersistenceMapper::toUser)
                .collect(Collectors.toSet());
    }

    @Override
    public void deleteUserById(Long id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public void flush() {
        userRepository.flush();
    }
}
