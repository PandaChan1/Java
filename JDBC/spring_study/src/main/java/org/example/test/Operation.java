package org.example.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Operation {
    public static void main(String[] args) {
        //根据Spring配置文件路径创建容器：应用上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //获取Bean的两种方式
        Login login = (Login) context.getBean("login");
        Login login2 = context.getBean(Login.class);
        System.out.println(login);
        System.out.println(login2);
        System.out.println(login == login2);


        Person person1 = (Person) context.getBean("person1");
        Person person2 = (Person) context.getBean("person2");

        System.out.println(person1);
        System.out.println(person2);


        Person useFactoryBean = (Person) context.getBean("useFactoryBean");
        System.out.println(useFactoryBean);

    }
}
