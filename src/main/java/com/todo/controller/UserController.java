package com.todo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.todo.co.UserCo;
import com.todo.dto.ResponseDTO;
import com.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class UserController {
    @Autowired
    UserService userService;


    @PostMapping("/save")
    public ResponseDTO saveUser(@RequestBody UserCo userCo) {
        try {
            userService.addUser(userCo);
        }
        catch (RuntimeException e) {
           return new ResponseDTO(false, "User already exists");
        }
        return new ResponseDTO(true, "User saved successfully");
    }
    @PostMapping("/edit/{id}")
    public ResponseDTO editUser(@PathVariable("id") Long id, @RequestBody UserCo userCo) {
        try {
            userService.updateUser(id,userCo);
        }catch (RuntimeException e){
            return new ResponseDTO(true, "User is not available");
        }
        return new ResponseDTO(true, "Successfully edited profile");
    }
    @PostMapping("/delete/{id}")
    public ResponseDTO deleteUser(@PathVariable("id") Long id) {
        try{
            userService.deleteUser(id);
        }catch (RuntimeException e){
            return new ResponseDTO(false, "Unable to delete the user");
        }
        return new ResponseDTO(true, "user successfully deleted");
    }
}
