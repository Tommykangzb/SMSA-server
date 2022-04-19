package com.example.campus.controller;


import com.alibaba.fastjson.JSON;
import com.example.campus.bean.Student;
import com.example.campus.service.QueryService;
import com.example.campus.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/api/info")
public class QueryController {
    @Autowired
    QueryService queryService;

    @RequestMapping(value = {"/detileInfo"})
    public String getBasicStuInfo( String student_id){
        try{
            Student s = queryService.selectStu(student_id);
            if (s == null){
                return JSON.toJSONString(Result.fail(null));
            }
            else{
                return JSON.toJSONString(Result.success(s));
            }
        }catch(Exception e){
            return JSON.toJSONString(Result.fail(null));
        }
    }

    @RequestMapping(value = {"/class_struct"})
    public String getClassStruct(String class_id){
        try{
            HashMap<String, String> class_struct = queryService.queryClassStruct(class_id);
            if (class_struct == null){
                return JSON.toJSONString(Result.fail(null));
            }
            else{
                return JSON.toJSONString(Result.success(class_struct));
            }
        }catch(Exception e){
            return JSON.toJSONString(Result.fail(null));
        }
    }

    @RequestMapping(value = {"/class_seat"})
    public String getSeat(String class_id){
        try{
            HashMap<Integer, String> class_seat = queryService.querySeat(class_id);
            if (class_seat == null){
                return JSON.toJSONString(Result.fail(null));
            }
            else{
                return JSON.toJSONString(Result.success(class_seat));
            }
        }catch(Exception e){
            return JSON.toJSONString(Result.fail(null));
        }
    }

    @RequestMapping(value = {"/class_list"})
    public String getClaStuList(String class_id){
        try{
            ArrayList<HashMap<String, String>> class_seat = queryService.queryStudentList(class_id);
            if (class_seat == null){
                return JSON.toJSONString(Result.fail(null));
            }
            else{
                return JSON.toJSONString(Result.success(class_seat));
            }
        }catch(Exception e){
            return JSON.toJSONString(Result.fail(null));
        }
    }

    @RequestMapping(value = {"/class_tel"})
    public String getClaTel(String class_id){
        try{
            ArrayList<HashMap<String, String>> class_seat = queryService.queryTelList(class_id);
            if (class_seat == null){
                return JSON.toJSONString(Result.fail(null));
            }
            else{
                return JSON.toJSONString(Result.success(class_seat));
            }
        }catch(Exception e){
            return JSON.toJSONString(Result.fail(null));
        }
    }

    @RequestMapping(value = {"/class_report"})
    public String getSummary(String class_id){
        try{
            HashMap<String, String> class_report = queryService.querySummary(class_id);
            if (class_report == null){
                return JSON.toJSONString(Result.fail(class_report));
            }
            else{
                return JSON.toJSONString(Result.success(class_report));
            }
        }catch(Exception e){
            return JSON.toJSONString(Result.fail(null));
        }
    }

    

}
