package com.pandachen.myservlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class helloworld  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String actor = req.getParameter("actor");
        if (actor == null) {
            actor = " 陈";
        }

        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/plain");
        PrintWriter pw = resp.getWriter();

        pw.println("hello my name is" + actor);

        pw.flush();
        pw.close();
    }
}
