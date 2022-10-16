package com.pm.course.controllers;

import com.pm.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class StudentController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/student2")
    public String showUsers(Model model){
        model.addAttribute("users",userRepository.findAll());
        return "student2";
    }


}
