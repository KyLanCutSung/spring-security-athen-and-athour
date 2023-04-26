package com.example.test.services;

import com.example.test.dtos.UserDto;
import com.example.test.entities.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<UserEntity> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    List<UserDto> getAll();
    UserDto findByUserId(Long userId);
}
