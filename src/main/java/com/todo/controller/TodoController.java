package com.todo.controller;

import com.todo.co.TodoCo;
import com.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
@RequestMapping("/todo")
public class TodoController {
    @Autowired
    TodoService todoService;

    @RequestMapping("/list")
    public String list(Model model, HttpSession httpSession) {
        Long id = (Long) httpSession.getAttribute("user");
        model.addAttribute("todoList", todoService.getTodoLists());
        return Objects.nonNull(id) ? "dashboard/dashboard" : "redirect:/";
    }

    @RequestMapping("/create")
    public String create(HttpSession httpSession) {
        Long id = (Long) httpSession.getAttribute("user");
        return Objects.nonNull(id) ? "dashboard/create" : "redirect:/";
    }

    @PostMapping("/addList")
    public String addList(Model model, @ModelAttribute("todoCo") TodoCo todoCo) {
        try {
            todoService.addList(todoCo);
        } catch (RuntimeException e) {
            model.addAttribute("errorMessage", "Unable to save the task");
            return "/todo/create";
        }
        return "redirect:/todo/list";
    }

    @RequestMapping("/update")
    public String update(Model model, Long id, String status) {
        Boolean result = todoService.update(id, status);
        return "redirect:/todo/list";
    }
}
