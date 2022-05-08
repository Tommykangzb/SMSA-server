package com.example.campus.serviceImpl;

import com.example.campus.bean.Account;
import com.example.campus.bean.Course;
import com.example.campus.bean.CourseEvaluates;
import com.example.campus.bean.User;
import com.example.campus.dao.AccountDAO;
import com.example.campus.dao.CourseDAO;
import com.example.campus.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tutorial.CourseContain;
import tutorial.CourseDetail;
import tutorial.ResponseOuterClass;

import java.util.List;

/**
 * @author 康智波
 * 2022,04,20
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired(required = false)
    CourseDAO courseDAO;
    @Autowired(required = false)
    AccountDAO accountDAO;

    @Override
    public CourseContain.CategoryContainResponse getCourseContent(long id, int limit) {
        CourseContain.CategoryContainResponse.Builder builder = CourseContain.CategoryContainResponse.newBuilder();
        try {
            List<Course> list = courseDAO.getCourseContent(id, limit);
            if (list == null || list.size() == 0) {
                System.out.println("id： " + id);
                System.out.println("getCourseContent, list  is null");
                return null;
            }
            builder.setIsLoadAll(true)
                    .setCount(list.size())
                    .addAllResults(Course.toCourseContain(list))
                    .setStartIndex(0);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("捕获了异常，原 因" + e);
        }
        return builder.build();
    }
    @Transactional
    @Override
    public CourseDetail.CourseDetailResponse getCourseDetail(String courseId, int limit) {
        CourseDetail.CourseDetailResponse.Builder builder = CourseDetail.CourseDetailResponse.newBuilder();
        try {
            List<CourseEvaluates> list = courseDAO.getCourseDetail(courseId, limit);
            if (list == null || list.size() == 0) {
                System.out.println("courseId： " + courseId);
                System.out.println("list is null");
                return null;
            }
            builder.setWatchCount(-1)
                    .setBackgroundUrl("")
                    .addAllCourseDetailItems(CourseEvaluates.toCourseDetailResponse(list));
            return builder.build();
        } catch (Exception e) {
            throw new RuntimeException("捕获了异常，原因" + e);
        }

    }

    @Transactional
    @Override
    public ResponseOuterClass.Response insertCourseDetail(CourseEvaluates evaluates, String account_num) {
        try {
            ResponseOuterClass.Response.Builder builder = ResponseOuterClass.Response.newBuilder();
            builder.setErrorReason("")
                    .setTimeStamp(System.currentTimeMillis())
                    .setExtras("");
            User user = accountDAO.login(account_num);
            if (user == null) {
                builder.setResponseState(-3);
                return builder.build();
            }
            boolean isContain = courseDAO.isContainUser(String.valueOf(evaluates.getCourseId()), user.getUserId()) > 0;
            if (isContain) {
                builder.setResponseState(-5);
                return builder.build();
            }
            boolean succeed = courseDAO.insertCourseDetail(String.valueOf(evaluates.getCourseId()), evaluates.getAttendanceFrequency(),
                    evaluates.getAttendanceWay(), evaluates.getExamWay(), evaluates.getExamGivenGrades(),
                    evaluates.getCredit(), evaluates.getCourseScore(), evaluates.getLikeCount(),
                    evaluates.getCourseEvaluateWords(), evaluates.getDate(), user.getUserId()) > 0;
            if (succeed) {
                builder.setResponseState(1);
            } else {
                builder.setResponseState(-3);
            }
            return builder.build();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("捕获了异常，原 因" + e);
        }
    }
}
