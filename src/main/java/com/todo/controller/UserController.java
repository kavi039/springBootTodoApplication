package com.todo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.todo.co.UserCo;
import com.todo.dto.ResponseDTO;
import com.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    UserService userService;


    @PostMapping("/save")
    @ResponseBody
    public ResponseDTO saveUser(@RequestBody UserCo userCo) {
        ObjectMapper objectMapper =  new ObjectMapper();
        try {
            userService.addUser(userCo);
        }
        catch (RuntimeException e) {
           return new ResponseDTO(false, "User already exists");
        }
        return new ResponseDTO(true, "User saved successfully");
    }
}
