package com.example.test.models.relation.service;

import com.example.test.exceptions.NotFoundException;
import com.example.test.models.relation.entity.RelationEntity;
import com.example.test.models.relation.entity.RelationId;

import java.util.List;

public interface RelationService {
    List<RelationEntity> findAll();
    String request(RelationId relationId) throws NotFoundException;
}
