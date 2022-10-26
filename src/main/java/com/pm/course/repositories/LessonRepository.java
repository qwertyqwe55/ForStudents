package com.pm.course.repositories;


import com.pm.course.models.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson,Long> {
    @Query("SELECT l FROM Lesson l WHERE l.pairnumber >= '4'")
    List<Lesson> findDistinctBy();

    @Query("SELECT l FROM Lesson l WHERE :#{#pair}=l.pairnumber AND " +
            ":#{#week}=l.week AND :#{#day}=l.dayweek AND :#{#room}=l.classroomnumber")
    List<Lesson> checkFree(@Param("pair") String pair,
                           @Param("week") String week,
                           @Param("day") String day,
                           @Param("room") String room);
}
