package org.example.controller;

import org.example.exception.APPexception;
import org.example.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {
    @PostMapping("/login")
    public Object login(User user, HttpServletRequest req) {
        //模拟数据库用户名，密码校验
        if ("abc".equals(user.getUsername())) {
            if ("123".equals(user.getPassword())){
                //登录成功:设置session
                HttpSession session = req.getSession();  //获取不到创建
                session.setAttribute("user",user);
                return null;
            }else {
                throw new APPexception("USERLOGERR001","用户名或密码错误");
            }
        }else {
            throw new APPexception("USERLOGERR002","用户不存在");
        }
    }

    @GetMapping("/logout")
    public Object logout(HttpSession session) {
        session.removeAttribute("user");
        return null;
    }
}
