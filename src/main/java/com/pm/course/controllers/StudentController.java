package com.pm.course.controllers;

import com.pm.course.repositories.LessonRepository;
import com.pm.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class StudentController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LessonRepository lessonRepository;

    @GetMapping("/student2")
    public String showLessons(Model model){
        model.addAttribute("lessons",lessonRepository.findAll());
        return "student2";
    }


}
