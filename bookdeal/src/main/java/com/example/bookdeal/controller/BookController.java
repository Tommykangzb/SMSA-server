package com.example.bookdeal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 * @author 康智波
 * 2022,01,04
 */
@Controller
@RequestMapping("/bookDeal")
public class BookController {
    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "hello";
    }
}
