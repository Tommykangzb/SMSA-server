package com.example.campus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tutorial.Login;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author 康智波
 * 2022,03,30
 */
@Controller
@RequestMapping("/userCenter")
public class LoginController {
    @RequestMapping("/login")
    @ResponseBody
    public String login(HttpServletRequest httpServletRequest){
        try {
            Login.LoginRequest request = Login.LoginRequest.parseFrom(httpServletRequest.getInputStream());
            System.out.println(request.getAccount());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "hello";
    }
}
