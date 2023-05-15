package com.example.test.modules.group_user.repo;

import com.example.test.modules.group_user.entity.GroupUserEntity;
import com.example.test.modules.group_user.entity.GroupUserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupUserRepository extends JpaRepository<GroupUserEntity, GroupUserId> {
}
