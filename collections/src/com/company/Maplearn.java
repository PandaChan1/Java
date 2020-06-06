package com.company;

import java.util.HashMap;
import java.util.Map;

public class Maplearn {
public static void main(String [] args){
    Student s=new Student("xiaoli",15);
    Map<String,Student> map=new HashMap<>();
    map.put("xiaoli",s);
    Student target=map.get("xiaoli");
    System.out.println(target==s);
    System.out.println(target.score);
    Student another=map.get("bob");
    System.out.println(another);
    Map<String,Integer> map1=new HashMap<>();
    map1.put("li",10);
    map1.put("lo",20);
    map1.put("oo",62);
    for (String key:map1.keySet()){
        Integer value=map1.get(key);
        System.out.println(key+" = " +value);
    }
}
}
class Student{
    public String name;
    public int score;
    public Student(String name,int score){
        this.name=name;
        this.score=score;
    }
}
