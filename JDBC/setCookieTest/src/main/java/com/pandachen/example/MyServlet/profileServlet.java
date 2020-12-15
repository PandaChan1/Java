package com.pandachen.example.MyServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/profile")
public class profileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null) {
            System.out.println("用户没有登录");
            return;
        }
        String 姓名 = (String)session.getAttribute("姓名");
        int  年龄 = (Integer)session.getAttribute("年龄");
        System.out.println(姓名 + 年龄);
    }
}
