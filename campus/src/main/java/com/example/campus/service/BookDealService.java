package com.example.campus.service;


import org.apache.ibatis.annotations.Mapper;
import tutorial.BookDealHome;

@Mapper
public interface BookDealService {
    BookDealHome.BookDealResponse getBookDealHomeResponse(long id, int limitCount);
    String getMsg(long id);
    String getAccount(String account);
}
