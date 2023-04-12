package com.example.test.services;

import com.example.test.entities.RoleEntity;
import com.example.test.enums.RoleName;

import java.util.Optional;

public interface RoleService {
    Optional<RoleEntity> findByRoleName(String roleName);
}
