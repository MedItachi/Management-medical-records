package org.java.demo.medical_record.config;

import org.java.demo.medical_record.security.AuthenticationFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;


@Configuration
public class WebConfig {
    @Bean
    public FilterRegistrationBean<AuthenticationFilter> authenticationFilter() {
        FilterRegistrationBean<AuthenticationFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new AuthenticationFilter());
        registrationBean.addUrlPatterns("/consultations/*", "/patients/*", "/dashbord"); // Adjust paths as necessary
        return registrationBean;
    }
}
