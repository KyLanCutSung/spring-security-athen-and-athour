package com.example.test.modules.groups.repo;

import com.example.test.modules.groups.entity.GroupsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupsRepository extends JpaRepository<GroupsEntity,Long> {
}
