package org.example.mapper;

import org.example.Application;
import org.example.model.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class ArticleMapperTest {
    @Autowired
    private ArticleMapper articleMapper;

    @Test
    public void selectByTitle(){
        Article article = articleMapper.selectByTitle("快速排序");
        System.out.println(article);
    }
    @Test
    public void selectLike() {
        List<Article> articles = articleMapper.selectLike("%",2,4);
        System.out.println(articles);
    }
}
