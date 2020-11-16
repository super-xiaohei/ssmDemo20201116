package com.suncaper.demo.controller;

import com.suncaper.demo.entity.User;
import com.suncaper.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zyq
 * @date 2020/11/13 - 10:07
 */
@Controller
public class RegistController {
    @Autowired
    private UserService userService;

    @RequestMapping("/regist")
    public String regist(){
        return "regist";
    }

    @RequestMapping("/insert")
    @ResponseBody
    public String insert(User user, HttpServletRequest request, HttpServletResponse response){
        String username = user.getUsername();
        System.out.println(username);
        String regExp1 = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?";
        String regExp2 = "0?(13|14|15|17|18|19)[0-9]{9}";
        Pattern p1 = Pattern.compile(regExp1);
        Pattern p2 = Pattern.compile(regExp2);
        Matcher matcher1 = p1.matcher(username);
        Matcher matcher2 = p2.matcher(username);
        boolean result1 = matcher1.matches();
        boolean result2 = matcher2.matches();
        System.out.println(result1);
        System.out.println(result2);
        boolean flag = false;
        if(result1 || result2) {
             flag = userService.insert(user);
        }else {

        }
        return flag + "";
    }
}
