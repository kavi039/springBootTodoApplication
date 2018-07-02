package com.todo.controller;

import com.todo.co.UserCo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/")
    public String login(Model model){
        model.addAttribute("userCo",new UserCo());
        return "login/login";
    }

    @RequestMapping("/register")
    public String register(){
        return "login/register";
    }

    @RequestMapping("/logout")
    public String logout(Model model, HttpSession httpSession){
        httpSession.setAttribute("user",null);
        httpSession.invalidate();
        model.addAttribute("successMessage","You have been successfully logout");
        return "login/login";
    }
}
