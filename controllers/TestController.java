package com.example.test.controllers;

import com.example.test.dtos.UserDto;
import com.example.test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/test")
@RestController
public class TestController {
    @Autowired
    private UserService userService;

    @GetMapping("/all_user")
    public ResponseEntity<?> getAll(){
        List<UserDto> userDtoList = userService.getAll();
        return new ResponseEntity<>(userDtoList, HttpStatus.OK);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable("userId") Long userId){
        UserDto userDto = userService.findByUserId(userId);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
}
