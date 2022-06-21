package com.example.campus.controller;

import com.example.campus.generalUtil.ResponseDefaultConstructor;
import com.example.campus.protoModel.FriendsList;
import com.example.campus.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * @author 康智波
 * 2022,05,27
 */
@RestController
@RequestMapping("/message")
@WebServlet
public class MessageController {
    @Autowired
    MessageService messageService;

    @RequestMapping("/userMsg")
    @ResponseBody
    public byte[] getUserMessage(HttpServletRequest httpServletRequest) {
        FriendsList.FriendsListResponse response;
        try {
            FriendsList.FriendsListRequest request = FriendsList.FriendsListRequest.
                    parseFrom(httpServletRequest.getInputStream());
            String account = request.getCurrAccount();
            int count = request.getCount();
            response = messageService.getFriendList(account, count);
            return response.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("catch an exception: " + e);
        }
        return ResponseDefaultConstructor.getUserMsgModel().toByteArray();
    }

    @RequestMapping("/accessFriendList")
    @ResponseBody
    public byte[] getFriendList(HttpServletRequest httpServletRequest) {
        try {
            FriendsList.FriendsListRequest request = FriendsList.FriendsListRequest.
                    parseFrom(httpServletRequest.getInputStream());
            FriendsList.FriendsListResponse response = messageService.getFriendList(request.getCurrAccount(), 10);
            return response.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("catch an exception: " + e);
        }
    }
}
