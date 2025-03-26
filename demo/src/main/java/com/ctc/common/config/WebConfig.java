package com.ctc.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 将所有不匹配的URL转发到index.html
        // registry.addViewController("/{lmsscs0100:\\w+}")
        //         .setViewName("forward:/");
        // registry.addViewController("/{lmsscs0200:\\w+}")
        //         .setViewName("forward:/");
        // registry.addViewController("/{lmsscs0220:\\w+}/**{spring:?!(\\.js|\\.css)$}")
        //         .setViewName("forward:/");
    }
}
