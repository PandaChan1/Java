package com.pandachen.model.servlet;

import com.pandachen.model.Beans.Message;
import com.pandachen.model.JSONUtils.SerializedUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/message-list-show")
public class MessageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    List<Message> list = getMessageList();
        String serilized = SerializedUtil.serialize(list);

        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        writer.println(serilized);
    }

    private static List<Message> getMessageList() {
        List<Message> list = new ArrayList<Message>();


        Message message = new Message();
        Message message1 = new Message();
        message.id = 1;
        message.who = "panda";
        message.when = "2020";
        message.what = "hello";

        message1.id = 2;
        message1.who = "panda2";
        message1.when = "2020-12";
        message1.what = "hello2";

        list.add(message);
        list.add(message1);

        return list;
    }
}
