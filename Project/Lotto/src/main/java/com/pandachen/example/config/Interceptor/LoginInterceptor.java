package com.pandachen.example.config.Interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pandachen.example.base.JSONResponse;
import com.pandachen.example.model.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

public class LoginInterceptor implements HandlerInterceptor {
    private ObjectMapper objectMapper;
    public LoginInterceptor(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession(false);
        if (session != null) {  //获取登陆时设置的用户信息
            User user = (User) session.getAttribute("user");
            if (user != null) {   //登陆了，允许访问
                return true;
            }
        }

        String path = request.getServletPath();
        if (path.startsWith("/api/")) {   //访问的是后端资源,返回json数据
            JSONResponse json = new JSONResponse();
            json.setCode("USER003");
            json.setMessage("禁止访问后端资源");

            String string = objectMapper.writeValueAsString(json);
            response.setStatus(401);
            PrintWriter writer = response.getWriter();
            writer.println(string);
            writer.flush();
        }else {  //访问的是前端敏感资源
//            response.sendRedirect("/views/index.html")   不能直接用，要拼接绝对路径
            String scheme = request.getScheme();
            String serverName = request.getServerName();
            int serverPort = request.getServerPort();
            String contextPath = request.getContextPath();

            String basePath = scheme + "://" + serverName  + ":" + serverPort + contextPath;

            response.sendRedirect(basePath + "/index.html");
        }
        return false;
    }
}
