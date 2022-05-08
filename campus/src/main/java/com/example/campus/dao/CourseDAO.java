package com.example.campus.dao;

import com.example.campus.bean.Course;
import com.example.campus.bean.CourseEvaluates;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseDAO {
    List<Course> getCourseContent(long id, int limit);

    List<CourseEvaluates> getCourseDetail(String courseId, int limit);


    int insertCourseDetail(String courseId, String attendanceFrequency, String attendanceWay, String examWay,
                           String examGivenGrades, float credit, int courseScore, int likeCount,
                           String courseEvaluateWords, String date, String userId);

    int isContainUser(String courseId, String userId);
}
