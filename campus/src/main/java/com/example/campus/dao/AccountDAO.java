package com.example.campus.dao;

import com.example.campus.bean.Account;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface AccountDAO {
    Account getByAccount_numAndPassword(String account_num, String password);
    int insertAccount(String account_num, String password,String teacher_id,String teacher_name);
    int deleteAccount(String account_num,String teacher_id);
    int setTeacherClass(String teacher_id,String class_id);
    int setHeadTeacher(String account_num,String class_id);
    int cancelTeacherClass(String teacher_id,String class_id);
    int cancelHeadTeacher(String account_num,String class_id);
    String getTeacher_idByAccount_num(String account_num);
    Account getAccountInfo(String account_num);
    List<Account> getAllAccount();
    int insertClass(String class_id,int grade);
    int deleteClass(String class_id);
}
