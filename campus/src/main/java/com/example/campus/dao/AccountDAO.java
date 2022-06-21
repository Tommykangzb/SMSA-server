package com.example.campus.dao;

import com.example.campus.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountDAO {
    String getLoginPsw(String account_num);
    User login(String account_num);
    int insertAccount(String account_num, String passwordHashStr, String email, String userId);
    int deleteAccount(String account_num);
    int editPsw(String account_num,String password);
}
