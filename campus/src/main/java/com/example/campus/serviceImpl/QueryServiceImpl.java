package com.example.campus.serviceImpl;

import com.example.campus.bean.Student;
import com.example.campus.dao.QueryDAO;
import com.example.campus.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Service
public class QueryServiceImpl implements QueryService {
    @Autowired(required=false)
    QueryDAO queryDAO;

    @Transactional
    public Student selectStu(String student_id) {
        try{
            return queryDAO.selectStu(student_id);
        } catch (Exception e) {
            //System.out.println("捕获了异常，原因"+e);
            throw new RuntimeException("捕获了异常，原因"+e);
        }
    }

    @Transactional
    public List<Student> selectStuGroup(String class_id) {
        try{
            return queryDAO.selectStuGroup(class_id);
        } catch (Exception e) {
            throw new RuntimeException("捕获了异常，原因"+e);
        }
    }

    public HashMap<String, String> queryClassStruct(String class_id) {
        try{
            HashMap<String, String> stringList = new HashMap<String, String>();
            ArrayList<Student> studentList = new ArrayList<Student>();
            studentList = queryDAO.selectStuGroup(class_id);
            for(Student s : studentList){
                if(s.getStudent_office().equals("无"))
                    continue;
                stringList.put(s.getStudent_office(), s.getStudent_name());
            }
            return stringList;
        } catch (Exception e) {
            throw new RuntimeException("捕获了异常，原因"+e);
        }
    }

    @Transactional
    public ArrayList<HashMap<String, String>> queryStudentList(String class_id) {
        try{
            ArrayList<HashMap<String, String>> stuList = new ArrayList<HashMap<String, String>>();
            ArrayList<Student> studentList = new ArrayList<Student>();
            studentList = queryDAO.selectStuGroup(class_id);
            for(Student s : studentList){
                HashMap<String, String> stuMap = new HashMap<String, String>();
                stuMap.put("student_name", s.getStudent_name());
                stuMap.put("student_id", s.getStudent_id());
                stuList.add(stuMap);
            }
            return stuList;
        } catch (Exception e) {
            throw new RuntimeException("捕获了异常，原因"+e);
        }

    }


    @Transactional
    public HashMap<Integer, String> querySeat(String class_id) {
        try{
            ArrayList<Student> studentList = new ArrayList<Student>();
            studentList = queryDAO.selectStuGroup(class_id);
            HashMap<Integer, String> seatList = new HashMap<Integer, String>();
            for(Student s : studentList){
                seatList.put(s.getStudent_seat(), s.getStudent_name());
            }
            ArrayList<Integer> seat = new ArrayList<Integer>(seatList.keySet());
            //TODO:Sort

            return seatList;
        } catch (Exception e) {
            throw new RuntimeException("捕获了异常，原因"+e);
        }

    }


    @Transactional
    public ArrayList<HashMap<String, String>> queryTelList(String class_id) {
        try{
            ArrayList<HashMap<String, String>> telList = new ArrayList<HashMap<String, String>>();
            ArrayList<Student> studentList = new ArrayList<Student>();
            studentList = queryDAO.selectStuGroup(class_id);
            for(Student s : studentList){
                HashMap<String, String> TelMap = new HashMap<String, String>();
                TelMap.put("student_name", s.getStudent_name());
                TelMap.put("student_tel", s.getStudent_tel());
                telList.add(TelMap);
            }
            return telList;
        } catch (Exception e) {
            throw new RuntimeException("捕获了异常，原因"+e);
        }

    }


    @Transactional
    public HashMap<String, String> querySummary(String class_id) {
        try{
            int num_man = queryDAO.calMen(class_id);
            int num_female = queryDAO.calWomen(class_id);
            HashMap<String, String> report = new HashMap<String, String>();
            report.put("Man", Integer.toString(num_man));
            report.put("Woman", Integer.toString(num_female));
            report.put("Total", Integer.toString(num_female+num_man));
            double m = num_man*1.0/(num_female+num_man);
            report.put("MRate", Double.toString(m));
            double w = num_female*1.0/(num_female+num_man);
            report.put("WRate", Double.toString(w));
            double avgAge = queryDAO.CalAvgAge(class_id);
            report.put("AvgAge", Double.toString(avgAge));
            return  report;
        } catch (Exception e) {
            throw new RuntimeException("捕获了异常，原因"+e);
        }

    }



}
