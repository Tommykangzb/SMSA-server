package com.example.campus.generalUtil;

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
                .setUserImageUrl("default");
        return builder;
    }
}
