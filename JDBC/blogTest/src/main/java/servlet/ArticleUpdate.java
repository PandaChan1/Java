package servlet;

import DAO.ArticleDAO;
import model.Article;
import util.JSONUtil;

import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/articleUpdate")
public class ArticleUpdate extends BaseServlet{
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //获取数据流
        ServletInputStream inputStream = req.getInputStream();
        //数据流反序列化为Article对象
        Article article = JSONUtil.Deserilize(inputStream,Article.class);

        System.out.println(article);

        int num = ArticleDAO.update(article);
        return null;
    }
}
