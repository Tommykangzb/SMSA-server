package com.example.campus.bean;

import com.example.campus.protoModel.FriendsList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 康智波
 * 2022,04,21
 */
public class User implements Serializable {
    private String userId;
    private String userAvatarUrl;
    private String userName;
    private String userSchool;
    private String userGrade;
    private String selfDes;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserAvatarUrl() {
        return userAvatarUrl;
    }

    public void setUserAvatarUrl(String userAvatarUrl) {
        this.userAvatarUrl = userAvatarUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSchool() {
        return userSchool;
    }

    public void setUserSchool(String userSchool) {
        this.userSchool = userSchool;
    }

    public String getUserGrade() {
        return userGrade;
    }

    public void setUserGrade(String userGrade) {
        this.userGrade = userGrade;
    }

    public String getSelfDes() {
        return selfDes;
    }

    public void setSelfDes(String selfDes) {
        this.selfDes = selfDes;
    }

    public static List<FriendsList.AccessUserMsgModel> toUserModel(List<User> list){
        List<FriendsList.AccessUserMsgModel> modelList = new ArrayList<>();
        for (User user: list) {
            FriendsList.AccessUserMsgModel.Builder builder = FriendsList.AccessUserMsgModel.newBuilder();
            builder.setName(user.getUserName())
                    .setUid(user.getUserId())
                    .setUserAvatarUrl(user.getUserAvatarUrl())
                    .setUserGrade(user.getUserGrade())
                    .setUserSchool(user.getUserSchool())
                    .setUserSelfDes(user.getSelfDes());
            modelList.add(builder.build());
        }
        return modelList;
    }
}
