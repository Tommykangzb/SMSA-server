package com.example.campus.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

@Mapper
public interface ModifyDAO {

    int delete(String student_id) ;
    int add(String student_id, String student_name, String student_tel, String class_id, String student_office, int student_age, int student_gender, String student_introduction, String student_photo, int student_seat, String student_hometown, String student_politicalStatus, Date student_birthday, String ID);
    int modifyBasic(String student_id,String student_name,String student_tel,String class_id,String student_office,int student_age,int student_gender,String student_introduction,String student_hometown,String student_politicalStatus,Date student_birthday,String ID);
    int modifyPhoto(String student_id,String student_photo);
    int modifySeat(String student_id,int student_seat);
    //判断这个职位是否已经被安排了
    int IsHasSet(@Param("student_id") String student_id,@Param("student_office") String student_office);
    //判断这个位置是否已经有人了
    int IsHasOne(@Param("student_id") String student_id,@Param("student_seat") int student_seat);
    //计算班级现在的人数
    int GetNumOfClass(String class_id);
    String GetOffice(@Param("class_id")String class_id,@Param("student_office")String student_office);
}
