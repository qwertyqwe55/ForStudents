package com.pm.course.controllers;

import com.pm.course.models.User;
import com.pm.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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
    public String createBook(@ModelAttribute User user) {
        List<User> users = userRepository.findAll();
        System.out.println("List: " + users.toString());
        for (User user1 : users) {
            if (user1.getLogin().equals(user.getLogin())
                    && user1.getPassword().equals(user.getPassword())) {
                if (user1.isTeacher()) {
                    return "teacher";
                } else {
                    return "student";
                }
            }

        }
        return "error";
    }
}
