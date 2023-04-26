package com.example.test.models.relation.repo;

import com.example.test.models.relation.entity.RelationEntity;
import com.example.test.models.relation.entity.RelationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelationRepository extends JpaRepository<RelationEntity, RelationId> {
}
