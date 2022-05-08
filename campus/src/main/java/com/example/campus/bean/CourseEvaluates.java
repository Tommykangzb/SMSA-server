package com.example.campus.bean;

import tutorial.CourseDetail;
import tutorial.CourseDetailCreate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 康智波
 * 2022,03,29
 */
public class CourseEvaluates implements Serializable {
    private static final long serialVersionUID = 2L;
    private long courseId;
    private String avatarUrl;
    private String evaluatorName;
    private String attendanceFrequency;
    private String attendanceWay;
    private String examWay;
    private String examGivenGrades;
    private float credit;
    private int courseScore;
    private int likeCount;
    private String courseEvaluateWords;
    private String date;

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String getEvaluatorName() {
        return evaluatorName;
    }

    public void setEvaluatorName(String evaluatorName) {
        this.evaluatorName = evaluatorName;
    }

    public String getAttendanceFrequency() {
        return attendanceFrequency;
    }

    public void setAttendanceFrequency(String attendanceFrequency) {
        this.attendanceFrequency = attendanceFrequency;
    }

    public String getAttendanceWay() {
        return attendanceWay;
    }

    public void setAttendanceWay(String attendanceWay) {
        this.attendanceWay = attendanceWay;
    }

    public String getExamWay() {
        return examWay;
    }

    public void setExamWay(String examWay) {
        this.examWay = examWay;
    }

    public String getExamGivenGrades() {
        return examGivenGrades;
    }

    public void setExamGivenGrades(String examGivenGrades) {
        this.examGivenGrades = examGivenGrades;
    }

    public float getCredit() {
        return credit;
    }

    public void setCredit(float credit) {
        this.credit = credit;
    }

    public String getCourseEvaluateWords() {
        return courseEvaluateWords;
    }

    public void setCourseEvaluateWords(String courseEvaluateWords) {
        this.courseEvaluateWords = courseEvaluateWords;
    }

    public int getCourseScore() {
        return courseScore;
    }

    public void setCourseScore(int courseScore) {
        this.courseScore = courseScore;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public static List<CourseDetail.CourseDetailResponseItem> toCourseDetailResponse(List<CourseEvaluates> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        List<CourseDetail.CourseDetailResponseItem> resultList = new ArrayList<>();
        for (CourseEvaluates courseEvaluates : list) {
            CourseDetail.CourseDetailResponseItem.Builder builder = CourseDetail.CourseDetailResponseItem.newBuilder();
            builder.setCourseId(courseEvaluates.getCourseId())
                    .setEvaluatorName(courseEvaluates.getEvaluatorName())
                    .setAttendanceFrequency(courseEvaluates.getAttendanceFrequency())
                    .setAttendanceWay(courseEvaluates.getAttendanceWay())
                    .setExamWay(courseEvaluates.getExamWay())
                    .setExamGivenGrades(courseEvaluates.getExamGivenGrades())
                    .setCredit(courseEvaluates.getCredit())
                    .setCourseScore(courseEvaluates.getCourseScore())
                    .setLikeCount(courseEvaluates.getLikeCount())
                    .setCourseEvaluateWords(courseEvaluates.getCourseEvaluateWords())
                    .setDate(courseEvaluates.getDate())
                    .setAvatarUrl(courseEvaluates.getAvatarUrl());
            resultList.add(builder.build());
        }
        return resultList;
    }

    public static CourseEvaluates toCourseEvaluate(CourseDetailCreate.CourseDetailCreateRequest request) {
        CourseEvaluates courseEvaluates = new CourseEvaluates();
        courseEvaluates.setCourseId(request.getCourseId());
        courseEvaluates.setAttendanceFrequency(request.getAttendanceFrequency());
        courseEvaluates.setAttendanceWay(request.getAttendanceWay());
        courseEvaluates.setExamWay(request.getExamWay());
        courseEvaluates.setExamGivenGrades(request.getExamGivenGrades());
        courseEvaluates.setCredit(request.getCredit());
        courseEvaluates.setCourseScore(request.getCourseScore());
        courseEvaluates.setLikeCount(request.getLikeCount());
        courseEvaluates.setCourseEvaluateWords(request.getCourseEvaluateWords());
        courseEvaluates.setDate(request.getDate());
        courseEvaluates.setAvatarUrl("null");
        courseEvaluates.setEvaluatorName("null");
        return courseEvaluates;
    }
}
