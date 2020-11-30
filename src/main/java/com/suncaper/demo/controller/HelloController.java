package com.suncaper.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;


/**
 * @author zyq
 * @date 2020/11/10 - 11:21
 */
@Controller
@RequestMapping(value = "/hello")
public class HelloController {

    @RequestMapping("/hh")
    @ResponseBody
    public String list(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        /*request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");*/
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Content-type", "text/html; charset=utf-8");
        return "郑义桥是大帅比";
    }
}
