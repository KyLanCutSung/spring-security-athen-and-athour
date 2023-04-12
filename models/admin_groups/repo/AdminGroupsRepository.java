package com.example.test.models.admin_groups.repo;

import com.example.test.models.admin_groups.entity.AdminGroupsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminGroupsRepository extends JpaRepository<AdminGroupsEntity, Long> {
}
