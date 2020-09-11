package com.company;

import java.util.List;
import java.util.Objects;

public class Listlearn {

    public static void main(String[] args) {
	// write your code here
        List<Person> list=List.of(new Person("xiao","ming",18),
                new Person("xiao","li",22),
                new Person("bob","smith",99));
        boolean exist=list.contains(new Person("bob","smith",99));
        System.out.println(exist ?"测试成功":"测试失败");
    }

}
class Person{
    String firstName;
    String lastName;
    int age;
    public Person(String firstName,String lastName,int age){
        this.firstName=firstName;
        this.lastName=lastName;
        this.age=age;
    }
//    public boolean equals(Object o){
//        if(o instanceof Person){
//            Person p= (Person) o;
//            return Objects.equals(this.firstName,p.firstName)&&Objects.equals(this.LastName,p.LastName)&& this.age==p.age ;
//        }
//
//        return false;
//    }
public boolean equals(Object o){
    if(o instanceof Person){
        Person p=(Person)o;
        return Objects.equals(this.firstName, p.firstName) && Objects.equals(this.lastName, p.lastName) && this.age == p.age;
    }
    return false;
}
}