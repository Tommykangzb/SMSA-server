package com.example.campus.dao;

import com.example.campus.bean.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
@Mapper
public interface QueryDAO {
    Student selectStu(String student_id);

    ArrayList<Student> selectStuGroup(String class_id);

    int calMen(String class_id);

    int calWomen(String class_id);
    double CalAvgAge(String class_id);
}
