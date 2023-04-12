package com.example.test.models.relation.service.impl;

import com.example.test.entities.UserEntity;
import com.example.test.models.relation.entity.RelationEntity;
import com.example.test.models.relation.entity.RelationId;
import com.example.test.models.relation.repo.RelationRepository;
import com.example.test.models.relation.service.RelationService;
import com.example.test.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RelationServiceImpl implements RelationService {
    @Autowired
    private RelationRepository relationRepository;
    @Autowired
    private UserRepository userRepository;
    private ModelMapper modelMapper = new ModelMapper();
    public List<RelationEntity> findAll(){
        List<RelationEntity> relationEntities = relationRepository.findAll();
        return relationEntities;
    }
    @Override
    public String request(RelationId relationId){
        Optional<UserEntity> friendEntity = userRepository.findById(relationId.getFriendId());
        Optional<UserEntity> userEntity = userRepository.findById(relationId.getUserId());
        String message = null;
        if(userEntity.isEmpty() || friendEntity.isEmpty() || userEntity.isEmpty() && friendEntity.isEmpty()){
            message = "Người dùng không tồn tại!";
            return message;
        }
        Optional<RelationEntity> relation = relationRepository.findById(relationId);
        if(!relation.isEmpty()){
            message = "Lời mời kết bạn đã được gửi từ trước!";
            return message;
        }
        RelationEntity relationEntity = new RelationEntity();
            relationEntity.setRelation((long) 0);
            relationEntity.setRelationId(relationId);
            relationEntity.setNotificationFriend(userEntity.get().getName()+" đã gửi cho bạn lời mời kết bạn!");
        relationRepository.save(relationEntity);

        message = "Bạn đã gửi lời mời kết bạn đến " + friendEntity.get().getName();
        return message;
    }

}
