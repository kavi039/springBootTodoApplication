package com.todo.controller;

import com.todo.co.TodoCo;
import com.todo.domain.Todo;
import com.todo.dto.ResponseDTO;
import com.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
public class TodoController {
    @Autowired
    TodoService todoService;

    @PostMapping("/addList")
    public ResponseDTO addList(@RequestBody TodoCo todoCo) {
        try{
            todoService.addList(todoCo);
        }catch (RuntimeException e) {
            return new ResponseDTO(false, "Unable to save the task");
        }
        return new ResponseDTO(true, "saved successfully");
    }

    @GetMapping("/task")
    public ResponseDTO fetchTasks() {
        return new ResponseDTO(true, todoService.getTodoLists());
    }
}
