package com.example.campus.controller;
import com.alibaba.fastjson.JSON;
import com.example.campus.util.Result;
import com.example.campus.bean.Account;
import com.example.campus.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api")
public class AccountController {
    @Autowired
    AccountService accountService;

    @RequestMapping("/login")
    @ResponseBody
    public String login(String account_num, String password) {
        try {
            Account account = accountService.getByAccount_numAndPassword(account_num, password);
            if (null == account) {
                return JSON.toJSONString(Result.success(account));
            } else {
                return JSON.toJSONString(Result.success(account));
            }
        } catch (Exception e) {
            return JSON.toJSONString(Result.success(null));
        }
    }
    @RequestMapping("/addAccount")
    @ResponseBody
    public String addAccount(String account_num, String password,String teacher_id,String teacher_name){
        try{Boolean result=accountService.addAccount(account_num,password,teacher_id,teacher_name);
            if (!result) {
                return JSON.toJSONString(Result.fail(null));
            } else {
                return JSON.toJSONString(Result.success(null));
            }
        }catch(Exception e){
            return JSON.toJSONString(Result.fail(null));
        }

    }

    @RequestMapping("/deleteAccount")
    @ResponseBody
    public  String deleteAccount(String account_num){
        try{
            Boolean result=accountService.deleteAccount(account_num);
            if (!result) {
                return JSON.toJSONString(Result.fail(null));
            } else {
                return JSON.toJSONString(Result.success(null));
            }
        }catch(Exception e){
            System.out.println(e);
            return JSON.toJSONString(Result.fail(null));
        }

    }
    @RequestMapping("/setTeacherClass")
    @ResponseBody
    public String setTeacherClass(String account_num,String class_id){
        try{
            Boolean result=accountService.setTeacherClass(account_num,class_id);
            if (!result) {
                return JSON.toJSONString(Result.fail(null));
            } else {
                return JSON.toJSONString(Result.success(null));
            }
        }catch(Exception e){
            return JSON.toJSONString(Result.fail(null));
        }

    }

    @RequestMapping("/setHeadTeacher")
    @ResponseBody
    public String setHeadTeacher(String account_num,String class_id){
        try{
            Boolean result=accountService.setHeadTeacher(account_num,class_id);
            if(!result){
                return JSON.toJSONString(Result.fail(null));
            }
            else {
                return JSON.toJSONString(Result.success(null));
            }
        }catch(Exception e){
            return JSON.toJSONString(Result.fail(null));
        }
    }

    @RequestMapping("/cancelTeacherClass")
    @ResponseBody
    public String cancelTeacherClass(String account_num,String class_id){
        try{
            Boolean result=accountService.cancelTeacherClass(account_num,class_id);
            if (!result) {
                return JSON.toJSONString(Result.fail(null));
            } else {
                return JSON.toJSONString(Result.success(null));
            }
        }catch(Exception e){
            return JSON.toJSONString(Result.fail(null));
        }
    }

    @RequestMapping("/cancelHeadTeacher")
    @ResponseBody
    public String cancelHeadTeacher(String account_num,String class_id){
        try{
            Boolean result=accountService.cancelHeadTeacher(account_num,class_id);
            if(!result){
                return JSON.toJSONString(Result.fail(null));
            }
            else {
                return JSON.toJSONString(Result.success(null));
            }
        }catch(Exception e){
            return JSON.toJSONString(Result.fail(null));
        }

    }

    @RequestMapping("/getAccountInfo")
    @ResponseBody
    public String getAccountInfo(String account_num){
        try{
            Account account = accountService.getAccountInfo(account_num);
            if (null == account) {
                return JSON.toJSONString(Result.fail(null));
            } else {
                return JSON.toJSONString(Result.success(account));
            }
        }catch(Exception e){
//            return JSON.toJSONString(Result.fail(null));
            throw new RuntimeException(e);
        }

    }

    @RequestMapping("/getAllAccount")
    @ResponseBody
    public String getAllAccount(){
        try{
            List<Account> accountList=accountService.getAllAccount();
            if(accountList == null){
                return JSON.toJSONString(Result.fail(null));
            }
            else {
                return JSON.toJSONString(Result.success(accountList));
            }
        }catch(Exception e){
            return JSON.toJSONString(Result.fail(null));
        }
    }

    @RequestMapping("/addClass")
    @ResponseBody
    public String addClass(String class_id,int grade){
        try{
            Boolean result = accountService.addClass(class_id,grade);
            if (!result) {
                return JSON.toJSONString(Result.fail(null));
            } else {
                return JSON.toJSONString(Result.success(null));
            }
        }catch(Exception e){
            return JSON.toJSONString(Result.fail(null));
        }
    }

    @RequestMapping("/deleteClass")
    @ResponseBody
    public String deleteClass(String class_id){
        try{
            Boolean result = accountService.deleteClass(class_id);
            if (!result) {
                return JSON.toJSONString(Result.fail(null));
            } else {
                return JSON.toJSONString(Result.success(null));
            }
        }catch(Exception e){
            return JSON.toJSONString(Result.fail(null));
        }

    }
}
