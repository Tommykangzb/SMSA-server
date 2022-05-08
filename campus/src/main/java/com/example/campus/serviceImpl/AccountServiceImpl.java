package com.example.campus.serviceImpl;

import com.example.campus.bean.User;
import com.example.campus.dao.AccountDAO;
import com.example.campus.generalUtil.EncryptHelper;
import com.example.campus.generalUtil.ResponseDefaultConstructor;
import com.example.campus.generalUtil.SnowFlake;
import com.example.campus.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tutorial.Login;


@Service
public class AccountServiceImpl implements AccountService {
    @Autowired(required = false)
    AccountDAO accountDAO;

    @Transactional
    @Override
    public Login.LoginResponse login(String account_num, String passwordHashStr) {
        try {
            if (account_num == null || passwordHashStr == null) {
                return null;
            }
            String psw = accountDAO.getLoginPsw(account_num);
            Login.LoginResponse.Builder builder = Login.LoginResponse.newBuilder();
            if (StringUtils.isEmpty(psw)) {
                builder = ResponseDefaultConstructor.getLoginResponseInstance(-1);
            } else {
                User user = accountDAO.login(account_num);
                String userId = user.getUserId();
                passwordHashStr = EncryptHelper.encryption(userId, passwordHashStr);
                System.out.println("psw is right? " + passwordHashStr.equals(psw));
                builder.setLoginResult(passwordHashStr.equals(psw) ? 1 : 0)
                        .setUserSchool(user.getUserSchool() == null ? "unknown" : user.getUserSchool())
                        .setUserName(user.getUserName() == null ? "unknown" : user.getUserName())
                        .setUserImageUrl(user.getUserAvatarUrl() == null ? "unknown" : user.getUserAvatarUrl())
                        .setUserGrade(user.getUserGrade() == null ? "unknown" : user.getUserGrade())
                        .setTimeStamp(System.currentTimeMillis());
            }
            return builder.build();
        } catch (Exception e) {
            throw new RuntimeException("捕获了异常，原因" + e);
        }
    }

    @Transactional
    @Override
    public Login.LoginResponse signUp(String account_num, String password, String email) {
        try {
            if (account_num == null || password == null){
                return null;
            }
            Login.LoginResponse.Builder builder;
            if (!StringUtils.isEmpty(accountDAO.getLoginPsw(account_num))) {
                builder = ResponseDefaultConstructor.getLoginResponseInstance(-2);
                return builder.build();
            }
            SnowFlake snowFlake = new SnowFlake(1, 1);
            String userId = String.valueOf(snowFlake.nextId());
            password = EncryptHelper.encryption(userId,password);
            boolean isSucceed = accountDAO.insertAccount(account_num, password, email, userId) > 0;
            if (isSucceed) {
                builder = ResponseDefaultConstructor.getLoginResponseInstance(2);
            } else {
                builder = ResponseDefaultConstructor.getLoginResponseInstance(-3);
            }
            return builder.build();
        } catch (Exception e) {
            throw new RuntimeException("捕获了异常，原因" + e);
        }
    }

    @Transactional
    @Override
    public Login.LoginResponse deleteAccount(String account_num) {
        try {
            Login.LoginResponse.Builder builder;
            if (account_num == null || StringUtils.isEmpty(accountDAO.getLoginPsw(account_num))) {
                builder = ResponseDefaultConstructor.getLoginResponseInstance(-1);
                return builder.build();
            }
            int resultCode = accountDAO.deleteAccount(account_num) > 0 ? 3 : -3;
            builder = ResponseDefaultConstructor.getLoginResponseInstance(resultCode);
            return builder.build();
        } catch (Exception e) {
            throw new RuntimeException("捕获了异常，原因" + e);
        }
    }

    @Transactional
    @Override
    public Login.LoginResponse editPsw(String account_num, String password){
        try {
            Login.LoginResponse.Builder builder;
            if (account_num == null || StringUtils.isEmpty(accountDAO.getLoginPsw(account_num))){
                builder = ResponseDefaultConstructor.getLoginResponseInstance(-1);
                return builder.build();
            }
            int resultCode = accountDAO.editPsw(account_num, password) > 0 ? 4 : -3;
            builder = ResponseDefaultConstructor.getLoginResponseInstance(resultCode);
            return builder.build();
        } catch (Exception e){
            throw new RuntimeException("捕获了异常，原因" + e);
        }
    }

}
