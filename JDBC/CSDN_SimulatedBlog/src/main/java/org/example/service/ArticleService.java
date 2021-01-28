package org.example.service;

import org.example.mapper.ArticleMapper;
import org.example.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    public List<Article> queryAll() {
        return articleMapper.selectAll();
    }

    public List<Article> queryByUserId(Integer id) {
        return articleMapper.selectByUserId(id);
    }

    public Object queryByArticleId(Integer id) {
        return articleMapper.selectByPrimaryKey(id);
    }
}
