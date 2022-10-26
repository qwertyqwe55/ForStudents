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

    @GetMapping("/student-groups")
    public String getShowLessonsGroups(Model model){
        model.addAttribute("lesson",new Lesson());
        model.addAttribute("lessons");
        return "/search/search_group";
    }

    @GetMapping("/student-educator")
    public String getShowLessonsEducator(Model model){
        model.addAttribute("lesson",new Lesson());
        model.addAttribute("lessons");
        return "/search/search_educator";
    }

    @GetMapping("/student-groups-get")
    public String getLessonsGroup(@ModelAttribute Lesson lesson, Model model){
        model.addAttribute("lessons",lessonRepository.findDistinctBy());
        return "/search/search_group";
    }

    @GetMapping("/student-educator-get")
    public String getLessonsEducator(@ModelAttribute Lesson lesson, Model model){
        model.addAttribute("lessons",lessonRepository.findDistinctBy());
        return "/search/search_educator";
    }

}
