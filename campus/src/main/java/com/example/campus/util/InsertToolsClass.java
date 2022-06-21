package com.example.campus.util;

import com.example.campus.dao.ModifyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 康智波
 * 2020,11,25
 */
@Service
public class InsertToolsClass {

    @Autowired(required=false)
    private ModifyDAO modifyDAO;

    public String student_id;
    public String student_name;
    public String student_tel;
    public String student_office;
    public String student_photo;
    public Boolean student_gender;
    public int student_age;
    public int student_seat;
    public String student_introduction;
    public String student_hometown;
    public String student_politicalStatus;
    public Date student_birthday;
    public String ID;
    public String class_id;

    public String teacher_id;;
    public String teacher_name;

    public String crateStudentId(int value) {
        return "2018"+ (10000000 + value);
    }
    public String crateTeacherId(int value) {
        return "2018"+ (20000000 + value);
    }
    public String craetTeacherName(int val){
        return "GGNB"+val;
    }

    public String crateStudentName(int value){
        return "lbw"+ value;
    }
    public String crateTel(int value){
        return "135"+ (10000000 + value);
    }
    public String crateOffice(){
        return "student";
    }
    public String cratePhoto(){
        return "D:/img/testphoto";
    }
    public boolean crateGender(int value){
        if (value%2==0){
            return false;
        }
        return true;
    }
    public int crateAge(int value){
        if (value%3==0){
            return 18;
        }
        if (value%3==1){
            return 19;
        }
        return 20;
    }
    public int createSeat(int value){
        return value%50;
    }
    public String creatIntruction(){
        return "Hello everyone,I am qiu yu gang";
    }
    public String creatHometown(){
        return "GD";
    }
    public String createPoliticalStatus(){
        return "CCPer";
    }
    public Date createBirthday() throws ParseException {
         Date date=new SimpleDateFormat("yyyyMMdd").parse("2000-01-01");
         return date;
    }
    public String createID(int val){
        return "452245200012"+ (200000 + val);
    }
    public String createClassId(int val){
        if (val%10+1==10)
            return "2018"+ (val % 10 + 1);
        return "20180"+ (val % 10 + 1);
    }

    public void createStudent() throws ParseException {
        for (int i=0;i<500;i++){
            student_id=crateStudentId(i);
            student_name=crateStudentName(i);
            student_tel=crateTel(i);
            student_office=crateOffice();
            student_photo=cratePhoto();
            student_gender=crateGender(i);
            student_age=crateAge(i);
            student_seat=createSeat(i);
            student_introduction=creatIntruction();
            student_hometown=creatHometown();
            student_politicalStatus=createPoliticalStatus();
            ID=createID(i);
            student_birthday=createBirthday();
            class_id=createClassId(i);
            teacher_id=crateTeacherId(i);
            teacher_id=crateTeacherId(i);
            try{
                if(student_gender==true) {
                    modifyDAO.add(student_id, student_name, student_tel, class_id, student_office, student_age, 1, student_introduction, student_photo, student_seat, student_hometown, student_politicalStatus, student_birthday, ID) ;
                }
                else{
                    modifyDAO.add(student_id,student_name,student_tel,class_id,student_office,student_age,0,student_introduction,student_photo,student_seat,student_hometown,student_politicalStatus,student_birthday,ID);
                }
            }catch (Exception e){
                throw new RuntimeException("捕获了异常，原因"+e);}
        }
    }
}
