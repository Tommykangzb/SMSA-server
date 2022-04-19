package com.example.query;

import com.example.campus.controller.AccountController;
import com.example.campus.controller.ModifyController;
import com.example.campus.controller.QueryController;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest
class CampusApplicationTests {
    @Autowired
    AccountController accountController;
    @Autowired
    QueryController queryController;
    @Autowired
    ModifyController modifyController;
    @Test
    void contextLoads() {

    }

    @Test
    void loginTest() {
        System.out.println(accountController.login("12311111aaa", "451"));
    }

    @Test
    void addAccountTest() {
        System.out.println(accountController.addAccount("123", "456", "789", "bbb"));
    }

    @Test
    void deleteAccountTest() {
        System.out.println(accountController.deleteAccount(""));
    }

    @Test
    void setTeacherClassTest() {
        System.out.println(accountController.setTeacherClass("123", "124"));
    }

    @Test
    void setHeadTeacherTest() {
        System.out.println(accountController.setHeadTeacher("123", "123"));
    }

    @Test
    void cancelTeacherTest() {
        System.out.println(accountController.cancelTeacherClass("123", "123"));
    }

    @Test
    void cancelHeadTeacherTest() {
        System.out.println(accountController.cancelHeadTeacher("123", "123"));
    }

    @Test
    void getAccountInfoTest() {
        System.out.println(accountController.getAccountInfo("123"));
    }

    @Test
    void getAllAccountTest() {
        System.out.println(accountController.getAllAccount());
    }

    @Test
    void addClassTest() {
        System.out.println(accountController.addClass("124", 1));
    }

    @Test
    void deleteClassTest() {
        System.out.println(accountController.deleteClass("123"));
    }
    @Test
    void getBasicStuInfoTest() {
        System.out.println(queryController.getBasicStuInfo("123"));
    }
    @Test
    void getClassStructTest() {
        System.out.println(queryController.getClassStruct("124"));
    }
    @Test
    void getSeatTest() {
        System.out.println(queryController.getSeat("123"));
    }
    @Test
    void getClaTel() {
        System.out.println(queryController.getClaTel("123"));
    }
    @Test
    void getClaStuListTest() {
        System.out.println(queryController.getClaStuList("123"));
    }
    @Test
    void getSummaryTest() {
        System.out.println(queryController.getSummary("201801"));
    }
    @Test
    void addTest() {
        System.out.println(modifyController.add("125", "zzz","6","123","无",16,false,"none","url",2,"GZ","none","2004-01-01","6"));
    }
    @Test
    void deleteTest() {
        System.out.println(modifyController.delete("123"));
    }
    @Test
    void modifyBasicTest() {
        System.out.println(modifyController.modifyBasic("201830640211","kzb14","13535906959","124","wenyuweiyuan",18,false,"Hello everyone","GD","CCPer","2018-01-01","415369200002065038"));
    }
    @Test
    void modifySeatTest() {
        System.out.println(modifyController.modifySeat("124",3));
    }

}
