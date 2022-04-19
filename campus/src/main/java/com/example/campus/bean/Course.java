package com.example.campus.bean;

import java.io.Serializable;

/**
 * @author 康智波
 * 2022,03,29
 */
public class Course implements Serializable {
    private static final long serialVersionUID = 1L;
    private long courseId;
    private String courseName;
    private String courseTeacher;
    private String courseType;
    private float courseGrades;
    private int watcherCount;
    private String backgroundURL;

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseTeacher() {
        return courseTeacher;
    }

    public void setCourseTeacher(String courseTeacher) {
        this.courseTeacher = courseTeacher;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public float getCourseGrades() {
        return courseGrades;
    }

    public void setCourseGrades(float courseGrades) {
        this.courseGrades = courseGrades;
    }

    public String getBackgroundURL() {
        return backgroundURL;
    }

    public void setBackgroundURL(String backgroundURL) {
        this.backgroundURL = backgroundURL;
    }

    public int getWatcherCount() {
        return watcherCount;
    }

    public void setWatcherCount(int watcherCount) {
        this.watcherCount = watcherCount;
    }
}
