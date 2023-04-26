package com.example.test.models.admin_groups_role.repo;

import com.example.test.models.admin_groups_role.entity.AdminGroupsRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminGroupsRoleRepository extends JpaRepository<AdminGroupsRoleEntity, Long> {
}
