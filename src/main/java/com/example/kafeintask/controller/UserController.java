package com.example.kafeintask.controller;

import com.example.kafeintask.dto.UserDto;
import com.example.kafeintask.model.User;
import com.example.kafeintask.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userservice;

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userservice.saveUser(userDto), HttpStatus.CREATED);
    }
}