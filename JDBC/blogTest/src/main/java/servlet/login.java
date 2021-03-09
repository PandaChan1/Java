package servlet;

import DAO.loginDAO;
import exception.myexception;
import model.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class login extends BaseServlet{
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) {
        //解析请求数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //根据账号查询数据库
        User user = loginDAO.query(username);
        //校验账号及密码
        if (user == null)
            throw new myexception("LOG002","用户不存在");

            if (!user.getPassword().equals(password)) {
                throw new myexception("LOG003","账号或密码错误");
            }
            //校验成功，设置session
        HttpSession session = req.getSession();  //获取或创建session
        session.setAttribute("user",user);
        return null;
    }
}
