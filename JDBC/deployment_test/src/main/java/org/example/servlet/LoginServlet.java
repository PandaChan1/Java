package org.example.servlet;

import org.example.DAO.LoginDao;
import org.example.DAO.Person;
import org.example.util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//定义当前类为servlet（服务端java代码提供的http服务）
//服务路径必须以/开头，否则tomcat会报错
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        //设置响应头信息，告诉对端响应体的解析方式
        resp.setContentType("application/json");
        Person person = new Person();
        person.setUsername(req.getParameter("username"));
        person.setPassword(req.getParameter("password"));

        System.out.printf("username = %s   password = %s%n" ,person.getUsername(),person.getPassword());

        PrintWriter pw = resp.getWriter();

        LoginDao loginDao = new LoginDao();
        //数据库验证DAO类示例
        //作业,使用jdbc，返回格式要求json格式，使用工具类方法
        if (loginDao.query(person.getUsername(),person.getPassword())) {
            pw.println(JSONUtil.serialze(person));
        }else {
            pw.println("登陆失败");
        }

        pw.flush();
        pw.close();
    }
}
