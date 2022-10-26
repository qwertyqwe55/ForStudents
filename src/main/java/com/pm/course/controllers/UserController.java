package com.pm.course.controllers;


import com.pm.course.models.User;
import com.pm.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String greeting(Model model){
        model.addAttribute("user", new User());
        return "main";
    }

    @PostMapping("/main")
    public String enter(@ModelAttribute User user) {
        List<User> users = userRepository.findAll();
        for (User user_check : users) {
            if (user_check.getLogin().equals(user.getLogin())
                    && user_check.getPassword().equals(user.getPassword())) {
                if (user_check.getRole().equals("TEACHER")) {
                    return "/main/teacher";
                }
                if (user_check.getRole().equals("STUDENT")){
                    return "/main/student";
                }
                if (user_check.getRole().equals("ADMIN")){
                    return "admin";
                }
            }
        }
        return "error";
    }
}
