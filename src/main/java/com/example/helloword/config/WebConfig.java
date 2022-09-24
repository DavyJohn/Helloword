package com.example.helloword.config;

import com.example.helloword.inter.HelloInter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/*拦截器配置*/
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);
        /*
        * 不设置路径就拦截所有的请求
        *
        * */
//        registry.addInterceptor(new HelloInter()).addPathPatterns();
        registry.addInterceptor(new HelloInter()).addPathPatterns("/demo1/**");
    }
}
