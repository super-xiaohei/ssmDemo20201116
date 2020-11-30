package com.suncaper.demo.controller;

import com.suncaper.demo.entity.User;
import com.suncaper.demo.service.UserService;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author zyq
 * @date 2020/11/10 - 11:28
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/selectAll")
    @ResponseBody
    public List<User> list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return userService.selectAll();
    }

    @RequestMapping("/selectById")
    @ResponseBody
    public User selectById(Integer id){
        return userService.selectById(id);
    }

}
