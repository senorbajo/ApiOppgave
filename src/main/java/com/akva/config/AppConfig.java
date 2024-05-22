package com.akva.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate akvakulturApiClient() {
        return new RestTemplate();
    }

    @Bean
    public RestTemplate brandApiClient() {
        return new RestTemplate();
    }
}