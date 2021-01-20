package org.example.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect  //定义切面
@Component
public class TestAop {

//定义切点：进行方法拦截
    @Pointcut("execution(* org.example.model.*.*(..))")
    public void loginPointcut() {  //切点

    }


    //通知：前置通知，需要传入切点方法
    @Before("loginPointcut()")
    public void beforeRequest() {
        System.out.println("开始执行请求映射方法");
    }

    //后置通知
    @After("loginPointcut()")
    public void afterRequest() {
        System.out.println("请求映射方法执行完毕");
    }

    //返回后的通知
    @AfterReturning("loginPointcut()")
    public void afterRequestReturn() {
        System.out.println("请求映射方法返回");
    }


}
