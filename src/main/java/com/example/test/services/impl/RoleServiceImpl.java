package com.example.test.services.impl;

import com.example.test.entities.RoleEntity;
import com.example.test.enums.RoleName;
import com.example.test.repositories.RoleRepository;
import com.example.test.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Optional<RoleEntity> findByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }
}
