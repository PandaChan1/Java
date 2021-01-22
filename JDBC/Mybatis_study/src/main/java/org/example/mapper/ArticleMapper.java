package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.model.Article;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ArticleMapper {
    Article selectByTitle(String title);
    List<Article> selectLike(@Param("username") String name,   //多参数查询
                             @Param("sid") Integer sid,
                             @Param("eid") Integer eid);
    int insertArticle(Article article);  //插入操作

    List<Article> selectWithId(Integer id);  //通过用户id查询文章
    int updateArticle(Article article);  //根据文章id更新文章
    int deleteArticle(String username);   //删除用户名为username的用户的所有文章
    List<Article> selectArticleOrderBy(@Param("title") String title,
                                       @Param("content") String content,
                                       @Param("By") String orderBy);
}
