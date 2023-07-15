package com.example.config;

import com.example.interceptor.AuthorizeInterceptor;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Resource
    AuthorizeInterceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
                .addInterceptor(interceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/api/auth/**")
                ;
        // .excludePathPatterns("/uploadtodisk")
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/api/auth/upload/uploadtodisk/**","")
                .addResourceLocations("file:"+"C:\\Users\\wzt\\Desktop\\study-project-main\\study-project-backend\\src\\main\\resources\\static\\pic\\")
                .addResourceLocations("file:"+"C:\\Users\\wzt\\Desktop\\study-project-main\\study-project-backend\\src\\main\\resources\\static\\avatar\\")
        ;
    }
}
