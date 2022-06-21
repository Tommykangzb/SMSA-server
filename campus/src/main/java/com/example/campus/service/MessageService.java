package com.example.campus.service;

import com.example.campus.protoModel.FriendsList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 康智波
 * 2022,05,27
 */
@Mapper
public interface MessageService {
    FriendsList.FriendsListResponse getFriendList(String account, int count);
}
