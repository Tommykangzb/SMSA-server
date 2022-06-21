package com.example.campus.bean;

import tutorial.BookDealHome;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 康智波
 * 2022,04,17
 */
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    private String bookImageUrl;
    private String bookName;
    private float price;
    private String sellerName;
    private String sellerAvatarUrl;
    private int likeCount;
    private String description;
    private List<String> bookMsgImage;
    private String sellMsg;
    private long sellerId;
    private long bookId;

    public String getBookImageUrl() {
        return bookImageUrl;
    }

    public void setBookImageUrl(String bookImageUrl) {
        this.bookImageUrl = bookImageUrl;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerAvatarUrl() {
        return sellerAvatarUrl;
    }

    public void setSellerAvatarUrl(String sellerAvatarUrl) {
        this.sellerAvatarUrl = sellerAvatarUrl;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getBookMsgImage() {
        return bookMsgImage;
    }

    public void setBookMsgImage(List<String> bookMsgImage) {
        this.bookMsgImage = bookMsgImage;
    }

    public String getSellMsg() {
        return sellMsg;
    }

    public void setSellMsg(String sellMsg) {
        this.sellMsg = sellMsg;
    }

    public long getSellerId() {
        return sellerId;
    }

    public void setSellerId(long sellerId) {
        this.sellerId = sellerId;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public static List<BookDealHome.BookMessage> toMessage(List<Book> list){
        if (list == null || list.size() == 0){
            return null;
        }
        List<BookDealHome.BookMessage> resultList = new ArrayList<>();
        for (Book book : list) {
            BookDealHome.BookMessage.Builder builder = BookDealHome.BookMessage.newBuilder();
            builder.setBookId(book.getBookId())
                    .setSellerId(book.getSellerId())
                    .setLikeCount(book.getLikeCount())
                    .setSellMsg(book.getSellMsg())
                    .setBookImageUrl(book.getBookImageUrl())
                    .addAllBookMsgImage(book.getBookMsgImage())
                    .setDescription(book.getDescription())
                    .setSellerAvatarUrl(book.getSellerAvatarUrl())
                    .setSellerName(book.getSellerName())
                    .setBookName(book.getBookName())
                    .setPrice(book.getPrice());
            resultList.add(builder.build());
        }
        return resultList;
    }
}
