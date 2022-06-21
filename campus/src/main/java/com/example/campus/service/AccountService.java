package com.example.campus.service;

import org.apache.ibatis.annotations.Mapper;
import tutorial.Login;

@Mapper
public interface AccountService {

    Login.LoginResponse login(String account_num, String passwordHashStr);

    Login.LoginResponse signUp(String account_num, String password,String email);

    Login.LoginResponse deleteAccount(String account_num);

    Login.LoginResponse editPsw(String account_num, String password);
}
