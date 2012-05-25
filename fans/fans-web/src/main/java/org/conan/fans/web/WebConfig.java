package org.conan.fans.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;
import org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityViewResolver;

@Configuration
public class WebConfig {

    @Bean
    DefaultAnnotationHandlerMapping defaultAnnotationHandlerMapping() {
        DefaultAnnotationHandlerMapping mapping = new DefaultAnnotationHandlerMapping();
        return mapping;
    }

    @Bean
    AnnotationMethodHandlerAdapter AnnotationMethodHandlerAdapter() {
        AnnotationMethodHandlerAdapter adapter = new AnnotationMethodHandlerAdapter();
        return adapter;
    }

    @Bean
    VelocityConfigurer velocityConfig() {
        VelocityConfigurer conf = new VelocityConfigurer();
        conf.setResourceLoaderPath("/WEB-INF/velocity/");
        return conf;
    }

    @Bean
    ViewResolver viewResolver() {
        VelocityViewResolver resolver = new VelocityViewResolver();
        resolver.setCache(true);
        resolver.setPrefix("");
        resolver.setSuffix(".jsp");
        resolver.setContentType("text/html;charset=utf-8");
        resolver.setExposeSessionAttributes(true);
        resolver.setAllowSessionOverride(true);
        resolver.setAllowRequestOverride(true);
        return resolver;
    }

    // @Bean
    // SessionLocaleResolver localeResolver(){
    // SessionLocaleResolver resolver = new SessionLocaleResolver();
    // return resolver;
    // }

    /*
     * @Bean ViewResolver viewResolver() { InternalResourceViewResolver resolver = new InternalResourceViewResolver(); resolver.setPrefix("WEB-INF/view/"); resolver.setSuffix(".jsp"); return resolver;
     * }
     */

}
