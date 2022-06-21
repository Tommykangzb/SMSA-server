package com.example.campus.dao;

import com.example.campus.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessageDAO {
    List<User> getFriendsList(String account, int count);
    String getUid(String account);
}
