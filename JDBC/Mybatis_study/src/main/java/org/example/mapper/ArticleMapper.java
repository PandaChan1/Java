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
    List<Article> selectLike(@Param("username") String name,
                             @Param("sid") Integer sid,
                             @Param("eid") Integer eid);
}
