package org.example;

import org.example.controller.LoginController;
import org.example.dao.LoginDAO;
import org.example.model.User;
import org.example.service.LoginService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        //根据Spring配置文件路径创建容器：应用上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        //获取注册的Bean对象：根据名称获取，或根据类型
        LoginController loginController = (LoginController)context.getBean("loginController");
        //获取Service，DAO的对象
        LoginService loginService = (LoginService) context.getBean("loginService");
        LoginService Servicebean = context.getBean(LoginService.class);
        LoginDAO loginDAO = (LoginDAO) context.getBean("loginDAO");
        LoginDAO DAObean = context.getBean(LoginDAO.class);

        System.out.println(loginController);
        System.out.println(loginService == Servicebean);
        System.out.println(loginDAO == DAObean);

        //获取User对象
        User user1 = (User) context.getBean("user1");
        User user2 = (User) context.getBean("user2");

        System.out.println(user1);
        System.out.println(user2);

        User factoryBeanTest = (User) context.getBean("factoryBeanTest");
        System.out.println(factoryBeanTest);

        //关闭容器
        ( (ClassPathXmlApplicationContext)context).close();

    }
}
