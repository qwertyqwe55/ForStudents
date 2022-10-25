package com.pm.course.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "lessons")
public class Lesson implements Serializable {
    public void setId(Long id) {
        this.id = id;
    }

    private Long id;
    private String week;
    private String dayweek;
    private String pairnumber;
    private String timestart;
    private String timeend;
    private String classroomnumber;
    private String object;
    private String typeobject;
    private String educator;
    private String groups;

    public Lesson()
    {

    }
    public Lesson(Long id, String week, String dayweek, String pairnumber, String timestart, String timeend, String classroomnumber, String object, String typeobject, String educator, String groups)
    {
        this.id = id;
        this.week = week;
        this.dayweek = dayweek;
        this.pairnumber = pairnumber;
        this.timestart = timestart;
        this.timeend = timeend;
        this.classroomnumber = classroomnumber;
        this.object = object;
        this.typeobject = typeobject;
        this.educator = educator;
        this.groups = groups;
    }

    @Id
    public Long getId(){
        return id;
    }
    @Column(name = "week", nullable = false)
    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    @Column(name = "dayweek", nullable = false)
    public String getDayweek(){
        return dayweek;
    }

    public  void setDayweek(String dayweek)
    {
        this.dayweek = dayweek;
    }

    @Column(name ="pairnumber",nullable = false)
    public String getPairnumber() {
        return pairnumber;
    }

    public void setPairnumber(String pairnumber)
    {
        this.pairnumber = pairnumber;
    }

    @Column(name ="timestart", nullable = false)
    public String getTimestart(){
        return timestart;
    }

    public void setTimestart(String timestart){
        this.timestart = timestart;
    }

    @Column(name="timeend", nullable = false)
    public String getTimeend() {
        return timeend;
    }

    public void setTimeend(String timeend){
        this.timeend = timeend;
    }

    @Column(name = "classroomnumber", nullable = false)
    public String getClassroomnumber() {
        return classroomnumber;
    }
    public void setClassroomnumber(String classroomnumber) {
        this.classroomnumber = classroomnumber;
    }

    @Column(name = "object", nullable = false)
    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    @Column(name = "typeobject", nullable = false)
    public String getTypeobject(){
        return typeobject;
    }

    public void setTypeobject(String typeobject){
        this.typeobject =typeobject;
    }

    @Column(name = "educator", nullable = false)
    public String getEducator(){
        return educator;
    }

    public void setEducator(String educator){
        this.educator = educator;
    }

    @Column(name = "groups", nullable = false)
    public String getGroups(){
        return groups;
    }

    public void setGroups(String groups){
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "";
    }
}
