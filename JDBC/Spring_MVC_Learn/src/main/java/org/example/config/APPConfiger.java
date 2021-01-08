package org.example.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.config.Interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//定义SpringMVC的启动配置类
//@Configuration
public class APPConfiger implements WebMvcConfigurer {

    @Autowired
    private ObjectMapper objectMapper;
    //配置Controller中请求映射方法路径匹配规则
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        //设置路径前缀的规则，即统一加上前缀/api
        //第二个参数c表示Controller类，true表示返回值，表示是否添加前缀
        configurer.addPathPrefix("api",c->true);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor(objectMapper))
                //*代表下一级，**代表子孙级
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/user/**")
                .addPathPatterns("/views/article.html")
                .addPathPatterns("/views/main.html");
    }
}
