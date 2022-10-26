package com.pm.course.controllers;

import com.pm.course.models.Lesson;
import com.pm.course.repositories.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class TeacherController {
    @Autowired
    private LessonRepository lessonRepository;

    @GetMapping("/book-class")
    public String bookClass(Model model){
        model.addAttribute("lesson", new Lesson());
        return "teacher/book_class";
    }

    @GetMapping("/book-class-get")
    public String toBooClass(@ModelAttribute Lesson lesson, @RequestParam("date")String date){

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Calendar cal = Calendar.getInstance();
            Date startDate = df.parse(date);
            cal.setTime(startDate);
            String week;
            if(cal.get(Calendar.WEEK_OF_MONTH) % 2 != 0){
                week = "Нечетная";
            }else{
                week = "Четная";
            }

            int numberDay = cal.get(Calendar.DAY_OF_WEEK);
            String day = "";
            switch (numberDay){
                case 1:
                    day = "Воскресенье";
                    break;
                case 2:
                    day = "Понедельник";
                    break;
                case 3:
                    day = "Вторник";
                    break;
                case 4:
                    day = "Среда";
                    break;
                case 5:
                    day = "Четверг";
                    break;
                case 6:
                    day = "Пятница";
                    break;
                case 7:
                    day = "Суббота";
                    break;
            }

            if(lessonRepository.checkFree(lesson.getPairnumber(), week, day, lesson.getClassroomnumber()).isEmpty()){
                return "teacher/sucess";
            }

        } catch (ParseException e) {
            return "error";
        }
        return "error";
    }
}
