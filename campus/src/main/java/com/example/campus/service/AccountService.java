package com.example.campus.service;

import com.example.campus.bean.Account;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface AccountService {
    //public boolean isExist(String account_num);

    //public Account getByName(String account_num);

    public Account getByAccount_numAndPassword(String account_num, String password);

    public Boolean addAccount(String account_num, String password,String teacher_id,String teacher_name);
    public Boolean deleteAccount(String account_num);
    public Boolean setTeacherClass(String account_num,String class_id);
    public Boolean setHeadTeacher(String account_num,String class_id);
    public Boolean cancelTeacherClass(String account_num,String class_id);
    public Boolean cancelHeadTeacher(String account_num,String class_id);
    public Account getAccountInfo(String account_num);
    public List<Account> getAllAccount();
    public Boolean addClass(String class_id,int grade);
    public Boolean deleteClass(String class_id);
}
