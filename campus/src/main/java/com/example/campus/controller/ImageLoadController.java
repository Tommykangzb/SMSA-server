package com.example.campus.controller;

import com.example.campus.generalUtil.ImageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * @author 康智波
 * 2022,04,20
 */
@RestController
@RequestMapping("/imageLoad")
public class ImageLoadController {
    @RequestMapping("/read")
    @ResponseBody
    public byte[] getCourseDetail(@RequestParam String url) {
        System.out.println(url + ".webp");
        try {
            return ImageHelper.readFileByBytes(url + ".webp");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
