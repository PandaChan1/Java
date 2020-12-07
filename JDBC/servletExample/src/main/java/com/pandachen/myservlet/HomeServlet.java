package com.pandachen.myservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/count")
public class HomeServlet extends HttpServlet {
    private int count;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        count++;
        String name = req.getParameter("name");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        String templet = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "\t<title>个人名片</title>\n" +
                "\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\n" +
                "\t<meta charset=\"utf-8\">\n" +
                "</head>\n" +
                "<body>\n" +
                "<div>访问次数: :count:</div>"+
                "\t<div class=\"user_info\">\n" +
                "\t<h1>:name:</h1>\n" +
                "    <p id=\"area\">我的练习</p>\n" +
                "\t</div>\n" +
                "\n" +
                "<div class=\"hobby\">\n" +
                "<h2>我的爱好</h2>\n" +
                "<ul>\n" +
                "\t<li>写代码</li>\n" +
                "\t<li>上课</li>\n" +
                "\t<li>看动漫</li>\n" +
                "\t<li>打游戏</li>\n" +
                "</ul>\t\n" +
                "</div>\n" +
                "\n" +
                "<div>\n" +
                "<h2>我的教育经历</h2>\n" +
                "<ol>\n" +
                "\t<li><a href=\"https://www.qq.com\" target=\"_blank\">高中</a></li>\n" +
                "\t<li><a href=\"https://v.bitedu.vip\">大学</a></li>\n" +
                "\t<li>西京</li>\n" +
                "</ol>\n" +
                "\n" +
                "</div>\n" +
                "\n" +
                "\n" +
                "</body>\n" +
                "</html>";
         String ans = templet.replace(":name:",name).replace(":count:",String.valueOf(count));
        writer.write(ans);

        writer.flush();
        writer.close();
    }
}
