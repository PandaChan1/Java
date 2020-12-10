package com.pandachen.model.servlet;

import com.pandachen.model.DBUtils.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/post-message.api")
public class PostMessageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String who = req.getParameter("who");
        String what = req.getParameter("what");

        insertToDB(who,what);

        resp.sendRedirect("message-list.html");
    }

    private void insertToDB(String who, String what) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
       Date date = new Date();
        String format = dateFormat.format(date);
        System.out.println(format);

        try(Connection connection = DBConnection.getConnection()) {
            String sql = "insert into message(who,timewhen,what) values(?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,who);
            preparedStatement.setString(2,format);
            preparedStatement.setString(3,what);

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
