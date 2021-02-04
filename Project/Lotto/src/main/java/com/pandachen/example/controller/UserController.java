package com.pandachen.example.controller;

import com.pandachen.example.exception.APPexception;
import com.pandachen.example.model.User;
import com.pandachen.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Object register(User user, MultipartFile headFile) {
        //后端校验请求数据,前端也有自己的校验；这里省略后端校验
        //保存到本地
        if (headFile != null) {
            String remotePath = userService.saveHead(headFile);
            //将本地路径映射橙http路径
            //将http路径保存到数据库
            user.setHead(remotePath);
        }
        userService.register(user);
        return null;
    }

    @PostMapping("/login")
    //请求数据类型为json，需要使用@RequestBody
    public Object login(@RequestBody User user, HttpServletRequest req) {
        User userData = userService.queryByUserName(user.getUsername());
        //判断userData，正确-将信息保存到session
        if (userData == null) {
            throw new APPexception("LOG001","用户不存在");
        }
        //用户存在,校验密码
        if (!user.getPassword().equals(userData.getPassword())) {
            throw new APPexception("LOG002","账号或密码错误");
        }
        //校验通过，保存到session
        HttpSession session = req.getSession();
        session.setAttribute("user",userData);
        return null;
    }

    //注销就是删除session
    @GetMapping("/logout")
    public Object logout(HttpSession session) {
        session.removeAttribute("user");
        return null;
    }
}
