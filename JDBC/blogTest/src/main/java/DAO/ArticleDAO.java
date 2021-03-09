package DAO;

import exception.myexception;
import model.Article;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAO {
    public static List<Article> queryByUserId(int userId) {
        List<Article> articles = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
           c  = DBUtil.getConnection();
           String sql = "select id, title, content, user_id, create_time, view_count from article where user_id = ?";
           ps = c.prepareStatement(sql);
           //设置占位符
            ps.setInt(1,userId);
            rs = ps.executeQuery();

            while(rs.next()) {
                Article article = new Article();
                article.setId(rs.getInt("id"));
                article.setTitle(rs.getString("title"));
                articles.add(article);
            }


            return articles;
        }catch (Exception e) {
            throw new myexception("查询文章列表出错",e,"ART001");
        }finally {
            DBUtil.close(c,ps,rs);
        }
    }

    public static int delete(String[] ids) {
        Connection c = null;
        PreparedStatement ps = null;
        try{
            c = DBUtil.getConnection();
            StringBuilder sql = new StringBuilder("delete from article where id in (");
            //动态拼接sql语句
            for (int i = 0; i < ids.length; i++) {
                if (i != 0)
                    sql.append(",");
                sql.append("?");
            }
            sql.append(")");


            ps = c.prepareStatement(sql.toString());
            //占位符
            //设置占位符
            for (int i = 0; i < ids.length; i++) {
                ps.setInt(i + 1,Integer.parseInt(ids[i]));
            }

             return   ps.executeUpdate();
        }catch (Exception e) {
            throw new myexception("删除文章出错",e,"ART004");
        }finally {
            DBUtil.close(c,ps,null);
        }
    }

    public static int insert(Article article) {
        Connection c = null;
        PreparedStatement ps = null;
        try{
            c = DBUtil.getConnection();
            String sql = "insert into article(title,content,user_id) values(?,?,?)";
            ps = c.prepareStatement(sql);
            //设置文章内容
            ps.setString(1,article.getTitle());
            ps.setString(2,article.getContent());
            ps.setInt(3,article.getUserId());
            //添加到文章表
            return ps.executeUpdate();
        }catch (Exception e) {
            throw new myexception("新增文章失败",e,"ART005");
        }finally {
            DBUtil.close(c,ps);
        }
    }

    public static Article query(int id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Article article = null;
        try{
            c = DBUtil.getConnection();
            String sql = "select title, content from article where id = ? ";
            ps = c.prepareStatement(sql);
            // 占位符设置
            ps.setInt(1,id);
            //获取结果集
            rs = ps.executeQuery();
            //处理结果集
            while (rs.next()) {
                article = new Article();
                article.setId(id);
                article.setTitle(rs.getString(1));
                article.setContent(rs.getString(2));
            }
            return article;
        }catch (Exception e) {
            throw  new myexception("查看文章详情失败",e,"ART006");
        }finally {
            DBUtil.close(c,ps,rs);
        }
    }

    public static int update(Article article) {
        Connection c = null;
        PreparedStatement ps = null;
        try{
            c = DBUtil.getConnection();
            String sql = "update article set title = ?,content = ? where id = ?";
            ps = c.prepareStatement(sql);
            //设置占位符
            ps.setString(1,article.getTitle());
            ps.setString(2,article.getContent());
            ps.setInt(3,article.getId());
            //返回更新的行数
            return  ps.executeUpdate();
        }catch (Exception e) {
            throw new myexception("更新文章错误",e,"ART007");
        }finally {
            DBUtil.close(c,ps);
        }
    }
}
