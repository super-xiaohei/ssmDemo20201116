package com.suncaper.demo.controller;

import com.suncaper.demo.entity.User;
import com.suncaper.demo.service.UserService;
import jdk.nashorn.internal.runtime.regexp.RegExp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.plugin2.util.ParameterNames;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zyq
 * @date 2020/11/12 - 17:19
 */

@Controller

public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String selectByUser(@RequestParam("username") String username,@RequestParam("password") String password,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        System.out.println(username + " " + password);
        String regExp = "/（^0{0,1}(13[0-9]|15[7-9]|153|156|18[7-9])[0-9]{8}$）|（^[a-z0-9!#$%&'*+\\/=?^_`{|}~.-]+@[a-z0-9]([a-z0-9-]*[a-z0-9])?(\\.[a-z0-9]([a-z0-9-]*[a-z0-9])?)*$）/i";
        Pattern p = Pattern.compile(regExp);
        Matcher matcher = p.matcher(username);
        boolean result = matcher.matches();
        if(result){
            User users = userService.selectByUser(new User(username,password));
            System.out.println(users);
            if(users != null){
                HttpSession session = request.getSession();
                users.setPassword(null);
                session.setAttribute("loginUser",users);
                session.setMaxInactiveInterval(60*60*10);
                //System.out.println("ok");
                return  "hello";
                //request.getRequestDispatcher("hello").forward(request,response);
            }else {
                //System.out.println("fail");
                request.setAttribute("errorMsg","用户名或者密码错误，请重新输入");
                return "loginfail";
            }
        }else {
            request.setAttribute("errorMsg","请输入正确的用户名");
            return "login";
        }
    }

}
