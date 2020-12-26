package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/home1")
    public String home1() {
        //转发：一次请求，url不改变，服务端把资源作为响应体返回
        return "forward:/home.html";
    }
    @RequestMapping("/home2")
    public String home2() {
        //重定向：2次请求，url会变，响应状态码3xx+location，浏览器自动跳转
        return "redirect:/home.html";
    }
}
