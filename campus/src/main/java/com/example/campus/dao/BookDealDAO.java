package com.example.campus.dao;

import com.example.campus.bean.Book;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * @author 康智波
 * 2022,04,17
 */
@Mapper
public interface BookDealDAO {
    //默认返回最热门的十本书
    List<Book> getHotBook(long id);

    List<Book> getBaseBook(long id, int count);
    List<String> getBookImage(long id);

    //String getMsg(Long id);
    String getAccount(String account);
}
