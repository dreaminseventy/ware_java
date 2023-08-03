package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {

        //允许跨域访问资源定义
        registry.addMapping("/**")
                //(只允许本地的指定端口访问)允许所有
                .allowedOriginPatterns("http://localhost:8080")
                // 允许发送凭证: 前端如果配置改属性为true之后，则必须同步配置
                .allowCredentials(true)
                // 允许所有方法
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowedMethods("GET","HEAD","POST","PUT","DELETE","OPTIONS")
                .maxAge(3600)
        ;
    }

}