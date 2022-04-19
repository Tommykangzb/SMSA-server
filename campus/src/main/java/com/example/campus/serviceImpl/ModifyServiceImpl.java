package com.example.campus.serviceImpl;

import com.example.campus.dao.ModifyDAO;
import com.example.campus.service.ModifyService;
import com.example.campus.util.OfficeEnumPackage;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ModifyServiceImpl implements ModifyService {
    @Autowired(required=false)
    private ModifyDAO modifyDAO;

    @Transactional
    public Boolean delete(String student_id){
        try{
            return modifyDAO.delete(student_id) > 0;
        }catch (Exception e){
            throw new RuntimeException("捕获了异常，原因"+e);}
    }

    @Transactional
    public Boolean add(String student_id, String student_name, String student_tel, String class_id, String student_office, int student_age, Boolean student_gender, String student_introduction, String student_photo, int student_seat, String student_hometown, String student_politicalStatus, Date student_birthday, String ID){
        try{
            if(student_id.length()!=12||student_tel.length()!=11||ID.length()!=18)
                return false;
            if(student_seat>50||student_seat<=0||modifyDAO.GetNumOfClass(class_id)>=50||!OfficeEnumPackage.isInclude(student_office)||modifyDAO.IsHasOne(student_id,student_seat)==1){
                return false;
            }
            else{
                if(student_office.equals("无")){
                    if(student_gender==true)
                        return modifyDAO.add(student_id,student_name,student_tel,class_id,student_office,student_age,1,student_introduction,student_photo,student_seat,student_hometown,student_politicalStatus,student_birthday,ID) > 0;
                    else
                        return modifyDAO.add(student_id,student_name,student_tel,class_id,student_office,student_age,0,student_introduction,student_photo,student_seat,student_hometown,student_politicalStatus,student_birthday,ID) > 0;
                }
                else{
                    if(modifyDAO.IsHasSet(student_id,student_office)!=1){
                        if(student_gender==true)
                            return modifyDAO.add(student_id,student_name,student_tel,class_id,student_office,student_age,1,student_introduction,student_photo,student_seat,student_hometown,student_politicalStatus,student_birthday,ID) > 0;
                        else
                            return modifyDAO.add(student_id,student_name,student_tel,class_id,student_office,student_age,0,student_introduction,student_photo,student_seat,student_hometown,student_politicalStatus,student_birthday,ID) > 0;
                    }
                }
            }
            return false;

        }catch (Exception e){
            throw new RuntimeException("捕获了异常，原因"+e);}
    }

    @Transactional
    public Boolean modifyBasic(String student_id,String student_name,String student_tel,String class_id,String student_office,int student_age,Boolean student_gender,String student_introduction,String student_hometown,String student_politicalStatus,Date student_birthday,String ID){
        try{
            if(student_tel.length()!=11||ID.length()!=18)
                return false;
            if(!OfficeEnumPackage.isInclude(student_office)){
                return false;
            }
            else{
                if(student_office.equals("无")){
                    if(student_gender==true)
                        return modifyDAO.modifyBasic(student_id,student_name,student_tel,class_id,student_office,student_age,1,student_introduction,student_hometown,student_politicalStatus,student_birthday,ID) > 0;
                    else
                        return modifyDAO.modifyBasic(student_id,student_name,student_tel,class_id,student_office,student_age,0,student_introduction,student_hometown,student_politicalStatus,student_birthday,ID) > 0;
                }
                else{
                    if(modifyDAO.IsHasSet(student_id,student_office)!=1||modifyDAO.GetOffice(class_id,student_office).equals(student_id)){
                        if(student_gender==true)
                            return modifyDAO.modifyBasic(student_id,student_name,student_tel,class_id,student_office,student_age,1,student_introduction,student_hometown,student_politicalStatus,student_birthday,ID) > 0;
                        else
                            return modifyDAO.modifyBasic(student_id,student_name,student_tel,class_id,student_office,student_age,0,student_introduction,student_hometown,student_politicalStatus,student_birthday,ID) > 0;
                    }
                }
            }
            return false;


//            boolean flag=modifyDAO.IsHasSet(student_id,student_office)==1||!OfficeEnumPackage.isInclude(student_office);
//            if (flag){
//                return false;
//            }
//            //班级人数已经多于50
//            if(modifyDAO.GetNumOfClass(class_id)>50){
//                return false;
//            }
//            if(student_gender==true)
//                return modifyDAO.modifyBasic(student_id,student_name,student_tel,class_id,student_office,student_age,1,student_introduction,student_hometown,student_politicalStatus,student_birthday,ID) > 0;
//            else
//                return modifyDAO.modifyBasic(student_id,student_name,student_tel,class_id,student_office,student_age,0,student_introduction,student_hometown,student_politicalStatus,student_birthday,ID) > 0;

        }catch (Exception e){
            throw new RuntimeException("捕获了异常，原因"+e);}
    }

    @Transactional
    public Boolean modifyPhoto(String student_id,String student_photo){
        try{
            return modifyDAO.modifyPhoto(student_id,student_photo) > 0;
        }catch (Exception e){
            throw new RuntimeException("捕获了异常，原因"+e);}

    }

    @Transactional
    public Boolean modifySeat(String student_id,int student_seat){
        try{
            if (modifyDAO.IsHasOne(student_id,student_seat)==1||student_seat>50||student_seat<=0){
                return false;
            }
            return modifyDAO.modifySeat(student_id,student_seat) > 0;
        }catch (Exception e){
            throw new RuntimeException("捕获了异常，原因"+e);}

    }
}
