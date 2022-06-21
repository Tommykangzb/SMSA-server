package com.example.campus.controller;

import com.example.campus.service.BookDealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tutorial.BookDealHome;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * @author 康智波
 * 2022,04,17
 */
@RestController
@RequestMapping("/bookDeal")
@WebServlet
public class BookDealController {

    @Autowired
    BookDealService bookDealHomeService;

    @RequestMapping("/homeBook")
    @ResponseBody
    public byte[] getHomeBookData(HttpServletRequest httpServletRequest) {
        try {
            BookDealHome.BookDealRequest request = BookDealHome.BookDealRequest.parseFrom(httpServletRequest.getInputStream());
            long id = request.getUserId();
            int count = request.getLimitCount();
            return bookDealHomeService.getBookDealHomeResponse(id, count).toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("catch an exception: " + e);
        }
    }

    //不包括热门图书
    @RequestMapping("/baseBook")
    @ResponseBody
    public byte[] getBaseBookData(HttpServletRequest httpServletRequest) {
        try {
            BookDealHome.BookDealRequest request = BookDealHome.BookDealRequest.parseFrom(httpServletRequest.getInputStream());
            long id = request.getUserId();
            int count = request.getLimitCount();
            return bookDealHomeService.getBaseBookResponse(id, count).toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("catch an exception: " + e);
        }
    }

    @RequestMapping("/test")
    @ResponseBody
    public String getMsg() {
        return bookDealHomeService.getAccount("12233445");
    }
}
