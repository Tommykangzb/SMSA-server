package com.example.campus.controller;

import com.example.campus.generalUtil.ResponseDefaultConstructor;
import com.example.campus.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tutorial.Login;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/account")
@WebServlet
public class AccountController {
    @Autowired
    AccountService accountService;

    @RequestMapping("/login")
    @ResponseBody
    public byte[] login(HttpServletRequest httpServletRequest) {
        try {
            Login.LoginRequest request = Login.LoginRequest.parseFrom(httpServletRequest.getInputStream());
            String account_num = request.getAccount();
            String password = request.getPassword();
            System.out.println(account_num + ",   " + password);
            return accountService.login(account_num, password).toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseDefaultConstructor.getLoginResponseInstance(-3).build().toByteArray();
    }

    @RequestMapping("/signUp")
    @ResponseBody
    public byte[] signUp(HttpServletRequest httpServletRequest) {
        try {
            Login.LoginRequest request = Login.LoginRequest.parseFrom(httpServletRequest.getInputStream());
            String account_num = request.getAccount();
            String password = request.getPassword();
            return accountService.signUp(account_num, password, "未绑定").toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseDefaultConstructor.getLoginResponseInstance(-3).build().toByteArray();
    }

    @RequestMapping("/delete")
    @ResponseBody
    public byte[] deleteAccount(HttpServletRequest httpServletRequest) {
        try {
            Login.LoginRequest request = Login.LoginRequest.parseFrom(httpServletRequest.getInputStream());
            String account_num = request.getAccount();
            return accountService.deleteAccount(account_num).toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseDefaultConstructor.getLoginResponseInstance(-3).build().toByteArray();
    }

    @RequestMapping("/editPsw")
    @ResponseBody
    public byte[] editPsw(HttpServletRequest httpServletRequest){
        try {
            Login.LoginRequest request = Login.LoginRequest.parseFrom(httpServletRequest.getInputStream());
            String account_num = request.getAccount();
            String password = request.getPassword();
            return accountService.editPsw(account_num, password).toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseDefaultConstructor.getLoginResponseInstance(-3).build().toByteArray();
    }
}