package com.sbnz.trud.io.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry
//                .addMapping("/api/v1/**")
//                .allowedOrigins("http://192.168.1.3:8080")
//                .allowedMethods("GET","POST","PUT","DELETE","PATCH", "OPTIONS")
//                .allowedHeaders("*")
//                .allowCredentials(true)
//                .maxAge(3600);
//    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry){
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/")
//                .setCachePeriod(3600);
//    }
	
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("HEAD","GET","POST","PUT","DELETE","PATCH").allowedOrigins("*");

    }
}