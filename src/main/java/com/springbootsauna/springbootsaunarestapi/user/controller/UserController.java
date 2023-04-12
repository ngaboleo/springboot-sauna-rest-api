package com.springbootsauna.springbootsaunarestapi.user.controller;

import com.springbootsauna.springbootsaunarestapi.user.dto.UserDto;
import com.springbootsauna.springbootsaunarestapi.user.service.UserService;
import com.springbootsauna.springbootsaunarestapi.util.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "create")
    public ResponseObject createUser(@RequestBody UserDto userDto){
        try {
            return userService.createUser(userDto);
        }catch (Exception exception){
            return new ResponseObject(exception);
        }
    }
}
