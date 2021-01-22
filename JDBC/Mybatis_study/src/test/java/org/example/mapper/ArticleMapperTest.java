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

    @Test
    public void insertArticle(){
        Article article = new Article();
        article.setTitle("测试");
        article.setContent("测试内容");
        int n = articleMapper.insertArticle(article);
        System.out.println(article);
    }
    @Test
    public void selectWithId(){
        List<Article> articles = articleMapper.selectWithId(4);
        System.out.println(articles);
    }

    @Test
    public void updateArticle() {
        Article article = new Article();
        article.setContent("public static void main(String[] args){}");
        article.setId(2);
        int i = articleMapper.updateArticle(article);
        System.out.println(i);
    }

    @Test
    public void deleteArticle() {
        int b = articleMapper.deleteArticle("b");
        System.out.println(b);
    }

    @Test
    public void selectArticleOrderBy() {
        List<Article> articles = articleMapper.selectArticleOrderBy("%排序%", "%public%", "desc");
        articles.stream()
                .forEach(System.out::println);
    }
}
