package com.example.campus.service;

import com.example.campus.bean.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Mapper
public interface QueryService {
    Student selectStu(String student_id);

    List<Student> selectStuGroup(String class_id);

    HashMap<String, String> queryClassStruct(String class_id);

    ArrayList<HashMap<String, String>> queryStudentList(String class_id);

    HashMap<Integer, String> querySeat(String class_id);

    ArrayList<HashMap<String, String>> queryTelList(String class_id);

    HashMap<String, String> querySummary(String class_id);
}
