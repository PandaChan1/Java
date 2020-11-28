package org.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/sen")
public class SensitiveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        //敏感资源，使用false，如果没有返回null
        HttpSession session = req.getSession(false);
        if (session == null) {
            resp.setStatus(401);
            printWriter.println("没有登陆，不允许访问");
        }else {
            //伪代码
//            Person person = (Person) session.getAttribute("user");
//            if (person.允许访问的路径不包含当前资源路径){
//                resp.setStatus(403);
//                printWriter.println("没有权限，禁止访问");
//            }else
            printWriter.println("访问成功");
        }
    }
}
