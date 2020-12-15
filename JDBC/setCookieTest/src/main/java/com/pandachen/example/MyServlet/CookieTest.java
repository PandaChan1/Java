package com.pandachen.example.MyServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/set-cookie")
public class CookieTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setHeader("Set-Cookie","k1=v1");    //传统的设置Cookie方式

        //使用cookie对象直接创建
        Cookie cookie = new Cookie("k2","v2");
//        cookie.setDomain();
//        设置cookie作用的域名，即当访问某域名时自动携带cookie
        cookie.setDomain("pandachen.com");  //修改本地hosts文件，设置域名为pandachen.com
        cookie.setMaxAge(300);  //设置cookie过期时间，从现在算起300秒后
        //不设置cookie事件默认是会话级别，即浏览器关闭cookie就删除了
        resp.addCookie(cookie);
    }
}
