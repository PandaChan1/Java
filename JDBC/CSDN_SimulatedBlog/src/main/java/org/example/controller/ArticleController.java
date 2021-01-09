package org.example.controller;

import org.example.Datas.ArticleData;
import org.example.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {
    //显示所有文章信息，还需要用户信息告诉前端是否登录

    @GetMapping("/query")
    public Object query(HttpServletRequest req) {
        User user = null;
        //获取session对象，如果未登录，返回null
        HttpSession session = req.getSession(false);
        if(session != null) {  //已经登录
            User sessionUser = (User) session.getAttribute("user");
            if (sessionUser != null) {
             user = sessionUser;
            }
        }

        //返回的数据：user ，articles = List<Article>，如果登录了user = 用户信息
        Map<String,Object> map = new HashMap<>();
        map.put("user",user);
        map.put("articles", ArticleData.allArticles());
        return map;
    }
}
