package com.example.campus.controller;

import com.example.campus.bean.CourseEvaluates;
import com.example.campus.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tutorial.Category;
import tutorial.CourseContain;
import tutorial.CourseDetail;
import tutorial.CourseDetailCreate;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author 康智波
 * 2022,01,04
 */
@RestController
@RequestMapping("/courseMessage")
@WebServlet
public class CourseContentController {
    @Autowired
    CourseService courseService;

    @RequestMapping("/detail")
    @ResponseBody
    public byte[] getCourseDetail(HttpServletRequest httpServletRequest) {
        long courseId;
        int limitCount;
        try {
            CourseDetail.CourseDetailRequest request = CourseDetail.CourseDetailRequest.parseFrom(httpServletRequest.getInputStream());
            limitCount = request.getLimitCount();
            courseId = request.getCourseId();
            return courseService.getCourseDetail(String.valueOf(courseId), limitCount).toByteArray();
        } catch (IOException o) {
            o.printStackTrace();
            throw new RuntimeException("catch an exception: " + o);
        }
    }

    @RequestMapping("/index")
    @ResponseBody
    public byte[] getCourseIndex() {
        List<String> list = new ArrayList<>(Arrays.asList("热门", "人文", "社科", "计算机", "医学", "材料", "物理", "艺术"));
        Category.CategoryResponse.Builder categoryResponseBuilder = Category.CategoryResponse.newBuilder();
        categoryResponseBuilder.setCount(list.size());
        categoryResponseBuilder.setCurrentSchool("SCUT");
        for (int i = 0; i < 8; i++) {
            categoryResponseBuilder.addAllCategory(list);
        }
        return categoryResponseBuilder.build().toByteArray();
    }

    @RequestMapping("/courseContent")
    @ResponseBody
    public byte[] getCourseContain(HttpServletRequest httpServletRequest) {
        long id = -1L;
        int limitCount;
        try {
            CourseContain.CategoryContainRequest request = CourseContain.CategoryContainRequest.parseFrom(httpServletRequest.getInputStream());
            limitCount = request.getLimitCount();
            return courseService.getCourseContent(id, limitCount).toByteArray();
        } catch (IOException o) {
            o.printStackTrace();
            throw new RuntimeException("catch an exception: " + o);
        }
    }

    @RequestMapping("/publish")
    @ResponseBody
    public byte[] createCourseDetail(HttpServletRequest httpServletRequest) {
        try {
            CourseDetailCreate.CourseDetailCreateRequest request = CourseDetailCreate.CourseDetailCreateRequest.
                    parseFrom(httpServletRequest.getInputStream());
            String account = request.getUserId();
            return courseService.insertCourseDetail(CourseEvaluates.toCourseEvaluate(request),
                    account).toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("catch an exception: " + e);
        }
    }

}
