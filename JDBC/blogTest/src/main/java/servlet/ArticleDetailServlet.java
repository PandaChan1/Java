package servlet;

import DAO.ArticleDAO;
import model.Article;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/articleDetail")
public class ArticleDetailServlet extends BaseServlet{
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //获取要修改的文章id
        String id = req.getParameter("id");
        //查询文章详情
        Article article = ArticleDAO.query(Integer.parseInt(id));
        return article;
    }
}
