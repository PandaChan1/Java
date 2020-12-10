package com.pandachen.model.servlet;

import com.pandachen.model.Beans.Message;
import com.pandachen.model.DBUtils.DBConnection;
import com.pandachen.model.JSONUtils.SerializedUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/message-list-show")
public class MessageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Message> list = null;
        try {
            list = getMessageList(DBConnection.getConnection());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String serilized = SerializedUtil.serialize(list);

        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        writer.println(serilized);
    }


    private static List<Message> getMessageList(Connection connection) {

        List<Message> list = new ArrayList<>();
        try {
            String sql = "select id,who,timewhen,what from message order by id desc";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            Message message = null;
            while (resultSet.next()) {
                message = new Message();
                message.id = resultSet.getInt(1);
                message.who = resultSet.getString(2);
                message.when = resultSet.getString(3);
                message.what = resultSet.getString(4);
                list.add(message);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
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
