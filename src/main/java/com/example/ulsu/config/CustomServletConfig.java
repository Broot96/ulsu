package com.example.ulsu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CustomServletConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){

        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/assets/js/");
        registry.addResourceHandler("/fonts/**").addResourceLocations("classpath:/static/assets/fonts/");
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/assets/css/");
        registry.addResourceHandler("/img/**").addResourceLocations("classpath:/static/assets/img/");
        registry.addResourceHandler("/scss/**").addResourceLocations("classpath:/static/assets/scss/");
        registry.addResourceHandler("/uploadFile/**").addResourceLocations("classpath:/static/assets/uploadFile/");
        registry.addResourceHandler("/vendor/**").addResourceLocations("classpath:/static/assets/vendor/");
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/static/assets/");
    }
}
