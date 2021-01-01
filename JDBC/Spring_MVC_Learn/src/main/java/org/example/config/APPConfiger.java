package org.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//定义SpringMVC的启动配置类
@Configuration
public class APPConfiger implements WebMvcConfigurer {

    //配置Controller中请求映射方法路径匹配规则
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        //设置路径前缀的规则，即统一加上前缀/api
        //第二个参数c表示Controller类，true表示返回值，表示是否添加前缀
        configurer.addPathPrefix("api",c->true);
    }
}
