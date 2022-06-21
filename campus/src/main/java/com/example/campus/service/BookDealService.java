package com.example.campus.service;


import org.apache.ibatis.annotations.Mapper;
import tutorial.BookDealHome;

@Mapper
public interface BookDealService {
    //初始化时的response,包括热门教材
    BookDealHome.BookDealResponse getBookDealHomeResponse(long id, int limitCount);

    //不包括热门教材
    BookDealHome.BookDealResponse getBaseBookResponse(long id, int limitCount);

    String getMsg(long id);

    String getAccount(String account);
}
