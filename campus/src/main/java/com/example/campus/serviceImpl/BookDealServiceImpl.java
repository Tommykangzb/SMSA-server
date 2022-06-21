package com.example.campus.serviceImpl;

import com.example.campus.bean.Account;
import com.example.campus.bean.Book;
import com.example.campus.dao.BookDealDAO;
import com.example.campus.service.BookDealService;
import com.example.campus.generalUtil.Constance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tutorial.BookDealHome;

import java.util.List;

/**
 * @author 康智波
 * 2022,04,17
 */
@Service
public class BookDealServiceImpl implements BookDealService {
    @Autowired(required = false)
    BookDealDAO bookDealDAO;

    @Transactional
    @Override
    public BookDealHome.BookDealResponse getBookDealHomeResponse(long id, int limitCount) {
        BookDealHome.BookDealResponse.Builder builder = BookDealHome.BookDealResponse.newBuilder();
        builder.setLoadAll(limitCount == bookDealDAO.getBaseBook(id, limitCount).size())
                .setHotBookCount3(Constance.curHotBookCount)
                .addAllHotBook1(Book.toMessage(bookDealDAO.getHotBook(id)))
                .setCommodityCount4(limitCount)
                .addAllCommodity2(Book.toMessage(bookDealDAO.getBaseBook(id, limitCount)));
        return builder.build();
    }

    @Override
    public BookDealHome.BookDealResponse getBaseBookResponse(long id, int limitCount) {
        BookDealHome.BookDealResponse.Builder builder = BookDealHome.BookDealResponse.newBuilder();
        builder.setLoadAll(limitCount == bookDealDAO.getBaseBook(id, limitCount).size())
                .setHotBookCount3(0)
                .addAllHotBook1(null)
                .setCommodityCount4(limitCount)
                .addAllCommodity2(Book.toMessage(bookDealDAO.getBaseBook(id, limitCount)));
        return builder.build();
    }

    @Override
    public String getMsg(long id) {
        return "bookDealDAO.getMsg(id)";
    }

    @Transactional
    @Override
    public String getAccount(String account) {
        return bookDealDAO.getAccount(account);
    }
}
