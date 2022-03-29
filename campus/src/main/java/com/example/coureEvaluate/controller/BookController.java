package com.example.coureEvaluate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tutorial.Category;
import tutorial.CourseContain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author 康智波
 * 2022,01,04
 */
@Controller
@RequestMapping("/bookDeal")
public class BookController {

    @RequestMapping("/index")
    @ResponseBody
    public byte[] index() {
        List<String> list = new ArrayList<>(Arrays.asList("热门", "人文", "社科", "计算机", "医学", "材料", "物理", "艺术"));
        Category.CategoryResponse.Builder categoryResponseBuilder = Category.CategoryResponse.newBuilder();
        categoryResponseBuilder.setCount(list.size());
        categoryResponseBuilder.setCurrentSchool("SCUT");
        for (int i = 0; i < 8; i++) {
            categoryResponseBuilder.addAllCategory(list);
        }
        return categoryResponseBuilder.build().toByteArray();
    }

    @RequestMapping("/courseContain")
    @ResponseBody
    public byte[] courseContain() {
        List<String> dataList = new ArrayList<>(Arrays.asList("酒文化鉴赏与啤酒的酿造工艺讲解", "现代小说选集", "水利工程概论", "计算机概论", "医学解剖", "材料力学基础", "天体物理"));
        List<String> dataListGrades = new ArrayList<>(Arrays.asList("95", "93", "92", "96", "90", "85", "86"));
        List<String> dataListTeacher = new ArrayList<>(Arrays.asList("刘墉", "方猪猪", "海盗狗", "海盗猪", "Aadsa", "Ddidae", "Mhala"));
        List<String> dataListCategory = new ArrayList<>(Arrays.asList("人文核心", "人文", "社科", "计算机", "材料", "医学", "物理"));
        List<CourseContain.CategoryResult> resultList = new ArrayList<>();
        for (int i = 0; i < dataList.size(); i++) {
            resultList.add(CourseContain.CategoryResult.newBuilder()
                    .setCourseName(dataList.get(i))
                    .setCourseGrades(dataListGrades.get(i))
                    .setCourseTeacher(dataListTeacher.get(i))
                    .setCourseType(dataListCategory.get(i))
                    .build());
        }
        CourseContain.CategoryContainResponse.Builder builder = CourseContain.CategoryContainResponse.newBuilder();
        builder.setCount(7)
                .setIsLoadAll(true)
                .setStartIndex(0)
                .addAllResults(resultList);
        return builder.build().toByteArray();
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(){
        return "hello";
    }


}
