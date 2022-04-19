package com.example.campus.bean;

import java.io.Serializable;
import java.util.List;

public class Teacher implements Serializable {
    private String teacher_id;
    private String teacher_name;

    //private Account account;
    private List<ClassGrade> classGrades;
    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

//    public Account getAccount() {
//        return account;
//    }
//
//    public void setAccount(Account account) {
//        this.account = account;
//    }

    public List<ClassGrade> getClassGrades() {
        return classGrades;
    }
    public void setClassGrades(List<ClassGrade> classGrades) {
        this.classGrades = classGrades;
    }
}
