package com.example.campus.dao;

import com.example.campus.bean.Account;
import com.example.campus.bean.Book;
import tutorial.BookDealHome;

import java.util.List;

/**
 * @author 康智波
 * 2022,04,17
 */
public interface BookDealDAO {
    List<Book> getHotBook(long id);

    List<Book> getBookDealHome(long id, int count);
    String getMsg(Long id);
    String getAccount(String account);
}
