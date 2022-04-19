package com.example.campus.service;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;
import java.sql.Date;

import org.springframework.web.util.HtmlUtils;

@Mapper
public interface ModifyService {
    Boolean delete(String student_id) ;
    Boolean add(String student_id,String student_name,String student_tel,String class_id,String student_office,int student_age,Boolean student_gender,String student_introduction,String student_photo,int student_seat,String student_hometown,String student_politicalStatus,Date student_birthday,String ID);
    Boolean modifyBasic(String student_id,String student_name,String student_tel,String class_id,String student_office,int student_age,Boolean student_gender,String student_introduction,String student_hometown,String student_politicalStatus,Date student_birthday,String ID);
    Boolean modifyPhoto(String student_id,String student_photo);
    Boolean modifySeat(String student_id,int student_seat);

}
