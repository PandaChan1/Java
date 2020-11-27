package org.example.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

class Person{
    public String name;
    public int age;
    public Person(String name,int age) {
        this.name = name;
        this.age = age;
    }
}
public class JSONUtilTest {
    @Test  //junit单元测试的注解，需要写在public void
    public void testSerilize() {
    Map<String,String> map = new HashMap<>();
    Person person = new Person("王五",12);
    map.put("username","张三");
    map.put("password","123");
        String serialze = JSONUtil.serialze(map);
        System.out.println(serialze);
        Assert.assertNotNull(serialze);
        String serialze1 = JSONUtil.serialze(person);
        System.out.println(serialze1);
        Assert.assertNotNull(serialze1);
    }
}
