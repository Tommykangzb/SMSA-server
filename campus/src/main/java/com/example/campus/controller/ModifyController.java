package com.example.campus.controller;

import com.example.campus.util.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.campus.service.ModifyService;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;

@RestController
@RequestMapping("/api")
public class ModifyController {

    @Autowired
    ModifyService modifyService;


    @RequestMapping("/deleteStudent")
    @ResponseBody
    public String delete(String student_id) {
        try{
            Boolean result = modifyService.delete(student_id);
            if (!result) {
                return JSON.toJSONString(Result.fail(null));
            } else {
                return JSON.toJSONString(Result.success(null));
            }
        }catch(Exception e){
            return JSON.toJSONString(Result.fail(null));
        }

    }

    @RequestMapping("/addStudent")
    @ResponseBody
    public String add(String student_id, String student_name, String student_tel, String class_id, String student_office, int student_age, Boolean student_gender, String student_introduction, String student_photo, int student_seat, String student_hometown, String student_politicalStatus, String student_birthday, String ID){
        try{
            Boolean result = modifyService.add(student_id,student_name,student_tel,class_id,student_office,student_age,student_gender,student_introduction,student_photo,student_seat,student_hometown,student_politicalStatus,strToDate(student_birthday),ID);
            if (!result) {
                return JSON.toJSONString(Result.fail(null));
            } else {
                return JSON.toJSONString(Result.success(null));
            }
        }catch(Exception e){
            return JSON.toJSONString(Result.fail(null));
        }
    }

    @RequestMapping("/modifyBasic")
    @ResponseBody
    public String modifyBasic(String student_id,String student_name,String student_tel,String class_id,String student_office,int student_age,Boolean student_gender,String student_introduction,String student_hometown,String student_politicalStatus,String student_birthday,String ID){
        try{
            Boolean result = modifyService.modifyBasic(student_id,student_name,student_tel,class_id,student_office,student_age,student_gender,student_introduction,student_hometown,student_politicalStatus,strToDate(student_birthday),ID);
            if (!result) {
                return JSON.toJSONString(Result.fail(null));
            } else {
                return JSON.toJSONString(Result.success(null));
            }
        }catch(Exception e){
            return JSON.toJSONString(Result.fail(null));
        }
    }

    @RequestMapping("/modifyPhoto")
    @ResponseBody
    public String modifyPhoto(String student_id,String student_photo){
        try{
            Boolean result = modifyService.modifyPhoto(student_id,student_photo);
            if (!result) {
                return JSON.toJSONString(Result.fail(null));
            } else {
                return JSON.toJSONString(Result.success(null));
            }
        }catch(Exception e){
            return JSON.toJSONString(Result.fail(null));
        }
    }

    @RequestMapping("/modifySeat")
    @ResponseBody
    public String modifySeat(String student_id,int student_seat){

        try{
            Boolean result = modifyService.modifySeat(student_id,student_seat);
            if (!result) {
                return JSON.toJSONString(Result.fail(null));
            } else {
                return JSON.toJSONString(Result.success(null));
            }
        }catch(Exception e){
            return JSON.toJSONString(Result.fail(null));
        }
    }
    public static java.sql.Date strToDate(String strDate) {
        String str = strDate;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date d = null;
        try {
            d = format.parse(str);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        java.sql.Date date = new java.sql.Date(d.getTime());
        return date;
    }
}
