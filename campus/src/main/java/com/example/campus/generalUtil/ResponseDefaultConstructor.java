package com.example.campus.generalUtil;

import com.example.campus.protoModel.FriendsList;
import tutorial.Login;

/**
 * @author 康智波
 * 2022,04,21
 */
public class ResponseDefaultConstructor {
    public static Login.LoginResponse.Builder getLoginResponseInstance(int resultCode) {
        Login.LoginResponse.Builder builder = Login.LoginResponse.newBuilder();
        builder.setLoginResult(resultCode)
                .setTimeStamp(System.currentTimeMillis())
                .setUserGrade("unKnown")
                .setUserSchool("unknown")
                .setUserName("unknown")
                .setUserId("unknown")
                .setUserImageUrl("default");
        return builder;
    }

    public static Login.LoginResponse.Builder getLoginResponseInstance(int resultCode, String uid) {
        Login.LoginResponse.Builder builder = Login.LoginResponse.newBuilder();
        builder.setLoginResult(resultCode)
                .setTimeStamp(System.currentTimeMillis())
                .setUserGrade("unKnown")
                .setUserSchool("unknown")
                .setUserName("unknown")
                .setUserId(uid)
                .setUserImageUrl("default");
        return builder;
    }

    public static FriendsList.FriendsListResponse getUserMsgModel() {
        FriendsList.AccessUserMsgModel.Builder model = FriendsList.AccessUserMsgModel.newBuilder();
        model.setName("")
                .setUid("")
                .setUserAvatarUrl("")
                .setUserGrade("")
                .setUserSchool("")
                .setUserSelfDes("");
        return FriendsList.FriendsListResponse.newBuilder().setFriends(0, model).build();
    }
}
