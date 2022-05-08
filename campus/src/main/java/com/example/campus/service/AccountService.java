package com.example.campus.service;

import com.example.campus.bean.Account;
import org.apache.ibatis.annotations.Mapper;
import tutorial.Login;

import java.util.List;
@Mapper
public interface AccountService {

    Login.LoginResponse login(String account_num, String passwordHashStr);

    Login.LoginResponse signUp(String account_num, String password,String email);

    Login.LoginResponse deleteAccount(String account_num);

    Login.LoginResponse editPsw(String account_num, String password);
}
