package com.example.campus.serviceImpl;

import com.example.campus.bean.Account;
import com.example.campus.dao.BookDealDAO;
import com.example.campus.service.BookDealService;
import com.example.campus.generalUtil.Constance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tutorial.BookDealHome;

/**
 * @author 康智波
 * 2022,04,17
 */
@Service
public class BookDealServiceImpl implements BookDealService {
    @Autowired(required = false)
    BookDealDAO bookDealDAO;

    @Override
    public BookDealHome.BookDealResponse getBookDealHomeResponse(long id, int limitCount) {
        BookDealHome.BookDealResponse.Builder builder = BookDealHome.BookDealResponse.newBuilder();
        builder.setLoadAll(false)
                .setHotBookCount3(Constance.curHotBookCount);
                //.addAllHotBook1(bookDealDAO.getHotBook(id))
                //.addAllCommodity2(bookDealDAO.getBookDealHome(id, limitCount));
        return builder.build();
    }

    @Override
    public String getMsg(long id) {
        return bookDealDAO.getMsg(id);
    }

    @Override
    public String getAccount(String account) {
        return bookDealDAO.getAccount(account);
    }
}
