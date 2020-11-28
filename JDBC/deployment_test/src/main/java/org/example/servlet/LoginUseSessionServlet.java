package org.example.servlet;

import org.example.DAO.LoginDao;
import org.example.DAO.Person;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

//定义当前类为servlet（服务端java代码提供的http服务）
//服务路径必须以/开头，否则tomcat会报错
@WebServlet("/loginUseSession")
public class LoginUseSessionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        //设置响应头信息，告诉对端响应体的解析方式
        resp.setContentType("text/html");
        Person person = new Person();
        person.setUsername(req.getParameter("username"));
        person.setPassword(req.getParameter("password"));

        System.out.printf("username = %s   password = %s%n" ,person.getUsername(),person.getPassword());

        PrintWriter pw = resp.getWriter();

        LoginDao loginDao = new LoginDao();
        //数据库验证DAO类示例
        //作业,使用jdbc，返回格式要求json格式，使用工具类方法
        if (loginDao.query(person)) {
            //获取session对象（从服务器端）
            // 如果方法参数为true，表示如果没有，就创建一个session；无参默认是true
            // 如果为false，没有就返回null
//            pw.println(JSONUtil.serialze(person));

            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("user",person);

            pw.println("登陆成功");
        }else {
            pw.println("登陆失败");
        }

        pw.flush();
        pw.close();
    }
}
