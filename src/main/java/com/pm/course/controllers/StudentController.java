package com.pm.course.controllers;

import com.pm.course.models.Lesson;
import com.pm.course.repositories.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {


    @Autowired
    private LessonRepository lessonRepository;

    @GetMapping("/student")
    public String getShowLessons(Model model){
        model.addAttribute("lesson",new Lesson());
        model.addAttribute("lessons");
        return "/search/search_group";
    }

    @GetMapping("/student-get")
    public String get(@ModelAttribute Lesson lesson, Model model){
        model.addAttribute("lessons",lessonRepository.findDistinctBy());
        return "/search/search_group";
    }


    @PostMapping("/student/get")
    public String postLessons(@ModelAttribute Lesson lesson){
        lessonRepository.findById(lesson.getId());
        return "/search/search_group_get";
    }


}
