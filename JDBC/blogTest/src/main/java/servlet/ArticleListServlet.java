package servlet;

import DAO.ArticleDAO;
import exception.myexception;
import model.Article;
import model.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@WebServlet("/articleList")
public class ArticleListServlet extends BaseServlet {

    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //获取请求数据：用户id
//        String id = req.getParameter("id");
        //用户登录时直接使用session获取id，然后返回文章列表
        HttpSession session = req.getSession(false);
        if (session == null) {
            throw new myexception("ART002","没有登录，不允许访问");
        }
        User user = (User)session.getAttribute("user");
        if (user == null) {
            throw new myexception("ART002","没有登录，不允许访问");
        }
        //根据用户id查询文章列表
        List<Article> articles = ArticleDAO.queryByUserId(user.getId());
        return articles;
    }
}
