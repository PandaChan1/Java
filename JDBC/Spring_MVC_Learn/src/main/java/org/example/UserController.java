package org.example;

import org.example.model.JSONResponse;
import org.example.model.User;
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
        JSONResponse jsonResponse = new JSONResponse();
        System.out.println(user.getUsername());
        if ("abc".equals(user.getUsername())) {
            HttpSession session = req.getSession();  //无参默认自动创建session
            session.setAttribute("user",user);
            jsonResponse.setSuccess(true);
        }else {
            jsonResponse.setCode("USERLOG30026");
            jsonResponse.setMessage("用户名或密码错误");
        }
        return jsonResponse;
    }
}
