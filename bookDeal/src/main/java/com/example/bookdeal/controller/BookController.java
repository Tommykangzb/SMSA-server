package com.example.bookdeal.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/bookDeal/book")
@RestController
public class BookController {
    @RequestMapping("/bookName")
    public String requestBookName(){
        return "hello";
    }
}
