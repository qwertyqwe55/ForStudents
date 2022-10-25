package com.pm.course.controllers;

import com.pm.course.repositories.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TeacherController {
    @Autowired
    private LessonRepository lessonRepository;

   // @GetMapping("/main")
//    public String getShowLessons(Model model){
//        model.addAttribute("lesson",lessonRepository.findAll());
//        return "student2";
//    }
}
