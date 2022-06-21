package com.example.campus.bean;

import java.io.Serializable;

public class Student implements Serializable {
    private String student_id;
    private String student_name;
    private String student_tel;
    private String student_office;
    private String student_photo;
    private Boolean student_gender;
    private int student_age;
    private int student_seat;
    private String student_introduction;
    private String student_hometown;
    private String student_politicalStatus;
    private String student_birthday;
    private String ID;
    private ClassGrade classGrade;

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }
    public String getStudent_tel() {
        return student_tel;
    }
    public void setStudent_tel(String student_tel) {
        this.student_tel = student_tel;
    }

    public String getStudent_office() {
        return student_office;
    }

    public void setStudent_office(String student_office) {
        this.student_office = student_office;
    }

    public String getStudent_photo() {
        return student_photo;
    }

    public void setStudent_photo(String student_photo) {
        this.student_photo = student_photo;
    }

    public Boolean getStudent_gender() {
        return student_gender;
    }

    public void setStudent_gender(Boolean student_gender) {
        this.student_gender = student_gender;
    }

    public int getStudent_age() {
        return student_age;
    }

    public void setStudent_age(int student_age) {
        this.student_age = student_age;
    }

    public int getStudent_seat() {
        return student_seat;
    }

    public void setStudent_seat(int student_seat) {
        this.student_seat = student_seat;
    }

    public String getStudent_introduction() {
        return student_introduction;
    }

    public void setStudent_introduction(String student_introduction) {
        this.student_introduction = student_introduction;
    }

    public String getStudent_hometown() {
        return student_hometown;
    }

    public void setStudent_hometown(String student_hometown) {
        this.student_hometown = student_hometown;
    }
    public String getStudent_politicalStatus() {
        return student_politicalStatus;
    }
    public void setStudent_politicalStatus(String student_politicalStatus) {
        this.student_politicalStatus = student_politicalStatus;
    }

    public String getStudent_birthday() {
        return student_birthday;
    }

    public void setStudent_birthday(String student_birthday) {
        this.student_birthday = student_birthday;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public ClassGrade getClassGrade() {
        return classGrade;
    }

    public void setClassGrade(ClassGrade classGrade) {
        this.classGrade = classGrade;
    }

}
