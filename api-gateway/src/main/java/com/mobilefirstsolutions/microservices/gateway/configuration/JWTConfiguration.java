package com.mobilefirstsolutions.microservices.gateway.configuration;

import com.mobilefirstsolutions.microservices.gateway.controller.ApiController;
import com.mobilefirstsolutions.microservices.gateway.filter.JwtFilter;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by aharcsa on 2016. 05. 14..
 */

@Configuration
@SuppressWarnings("unused")
public class JWTConfiguration {

    @Bean
    public FilterRegistrationBean jwtFilter() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new JwtFilter());
        registrationBean.addUrlPatterns(ApiController.MAPPING + "/*");
        return registrationBean;
    }
}
