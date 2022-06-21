package com.example.campus.serviceImpl;

import com.example.campus.bean.User;
import com.example.campus.dao.AccountDAO;
import com.example.campus.dao.MessageDAO;
import com.example.campus.generalUtil.ResponseDefaultConstructor;
import com.example.campus.protoModel.FriendsList;
import com.example.campus.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * @author 康智波
 * 2022,05,27
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired(required = false)
    MessageDAO messageDAO;

    @Transactional
    @Override
    public FriendsList.FriendsListResponse getFriendList(String account, int count) {
        FriendsList.FriendsListResponse.Builder builder = FriendsList.FriendsListResponse.newBuilder();
        try {
            List<User> userList = messageDAO.getFriendsList(account, count);
            List<FriendsList.AccessUserMsgModel> list = User.toUserModel(userList);
            String uid = messageDAO.getUid(account);
            builder.addAllFriends(list)
                    .setCurrentUid(uid);
            return builder.build();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("catch an exception: " + e);
        }

    }
}
