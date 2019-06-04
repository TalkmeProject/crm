package com.hlebik.crm.config;

import com.hlebik.crm.storage.StorageProperties;
import com.hlebik.crm.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableConfigurationProperties(StorageProperties.class)
public class MvcConfig implements WebMvcConfigurer {

/*
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }
*/

    @Bean
    CommandLineRunner init(StorageService storageService) {
        return args -> storageService.init();
    }

}