package com.example.campus.service;

import com.example.campus.bean.Course;
import com.example.campus.bean.CourseEvaluates;
import org.apache.ibatis.annotations.Mapper;
import tutorial.CourseContain;
import tutorial.CourseDetail;
import tutorial.ResponseOuterClass;

@Mapper
public interface CourseService {
    CourseContain.CategoryContainResponse getCourseContent(long id, int limit);

    CourseDetail.CourseDetailResponse getCourseDetail(String courseId, int limit);

    ResponseOuterClass.Response insertCourseDetail(CourseEvaluates courseEvaluates,String account_num);
}
