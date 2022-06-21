package com.example.campus.bean;

import tutorial.CourseContain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

    public static List<CourseContain.CategoryResult> toCourseContain(List<Course> list){
        if (list == null || list.size() == 0){
            return null;
        }
        List<CourseContain.CategoryResult> resultList = new ArrayList<>();
        for (Course course : list) {
            CourseContain.CategoryResult.Builder builder = CourseContain.CategoryResult.newBuilder();
            builder.setCourseType(course.getCourseType())
                    .setCourseTeacher(course.getCourseTeacher())
                    .setCourseGrades(String.valueOf(course.getCourseGrades()))
                    .setCourseName(course.getCourseName())
                    .setCourseId(course.getCourseId())
                    .setWatcherCount(course.getWatcherCount())
                    .setBackgroundURL(course.getBackgroundURL());
            resultList.add(builder.build());
        }
        return resultList;
    }
}
