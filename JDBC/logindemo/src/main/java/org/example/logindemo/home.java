package org.example.logindemo;

import org.example.DAO.User;
import org.example.DAO.query;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/home")
public class home extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        User user = new User();

        HttpSession session = req.getSession(false);

        if (session == null) {
            resp.sendRedirect("errorpage.html");
            return;
        }
            String username = (String) session.getAttribute("user");
            String password = (String) session.getAttribute("password");
            user.setUsername(username);
            user.setPassword(password);
            query query = new query();

        if (query.queryUser(user)) {
            resp.sendRedirect("home.html");
        }

    }
}
