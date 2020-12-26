package org.example;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
@ToString
class json{
    private Boolean success;
    private String code;
    private String message;
    private User user;
}

@Getter
@Setter
@ToString
class User{
    private int id;
    private String name;
    private String sex;
    private int age;
}

@Controller
public class TestDemo2 {


    @RequestMapping("/test2")
    public String home() {
        return "forward:/home.html";
    }

    @RequestMapping("/test3")
    @ResponseBody
    public String test3() {
        return "redirect:/home.html";
    }

    @RequestMapping("/testmap")
    @ResponseBody
    public Object testmap() {
        Map<Integer,String> map = new HashMap<>();
                map.put(1,"a");
                map.put(2,"b");
                map.put(3,"c");
                return map;
    }

    @RequestMapping("/testjson")
    @ResponseBody
    public  Object testjson() {
        Map<Integer,Object> map = new HashMap<>();
        json json = new json();
        User user = new User();
        user.setAge(22);
        user.setId(2);
        user.setName("chen");
        user.setSex("male");
        json.setSuccess(true);
        json.setCode("200");
        json.setMessage("ok");
        json.setUser(user);
        map.put(1,json);
        return map;
    }

    @RequestMapping(value = "/testjson_1",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public  Object testjson_1() {
        json json = new json();
        User user = new User();
        user.setAge(22);
        user.setId(2);
        user.setName("chen");
        user.setSex("male");
        json.setSuccess(true);
        json.setCode("200");
        json.setMessage("ok");
        json.setUser(user);
        return json;
    }

}
