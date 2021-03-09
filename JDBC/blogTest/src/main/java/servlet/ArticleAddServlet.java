package servlet;

import DAO.ArticleDAO;
import model.Article;
import model.User;
import util.JSONUtil;

import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/articleAdd")
public class ArticleAddServlet extends BaseServlet{
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //请求数据为Application/json，需要从输入流获取
        ServletInputStream inputStream = req.getInputStream();
        //请求体数据存在于输入流，json格式需要反序列化
        Article article = JSONUtil.Deserilize(inputStream,Article.class);
        //通过session获取用户id
        HttpSession session = req.getSession(false);
        User user = (User) session.getAttribute("user");
        //设置userid
        article.setUserId(user.getId());

        //文章表中插入数据
        int num = ArticleDAO.insert(article);
        return null;
    }
}
