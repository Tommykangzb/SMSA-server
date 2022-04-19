package com.example.campus.bean;

import java.io.Serializable;
import java.util.List;

public class ClassGrade implements Serializable {
    private String class_id;
    private int grade;
    private int class_count;
    private String headTeacher_id;
    List<Teacher> teachers;

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getClass_count() {
        return class_count;
    }

    public void setClass_count(int class_count) {
        this.class_count = class_count;
    }

    public String getHeadTeacher_id() {
        return headTeacher_id;
    }

    public void setHeadTeacher_id(String headTeacher_id) {
        this.headTeacher_id = headTeacher_id;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
}
