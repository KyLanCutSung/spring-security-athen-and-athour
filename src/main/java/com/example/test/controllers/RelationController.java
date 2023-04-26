package com.example.test.controllers;

import com.example.test.models.relation.entity.RelationEntity;
import com.example.test.models.relation.entity.RelationId;
import com.example.test.models.relation.service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/relation")
@RestController
public class RelationController {
    @Autowired
    private RelationService relationService;
    @GetMapping("/find-all")
    public ResponseEntity<?> findAll(){
        List<RelationEntity> relationEntityList = relationService.findAll();
        return new ResponseEntity<>(relationEntityList, HttpStatus.OK);
    }
    @PostMapping("/request/friend")
    public ResponseEntity<?> request(@RequestBody RelationId relationId){
        String message = relationService.request(relationId);
            return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
