package com.vedha.config;

import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class AppConfig {

    @Bean
    public WebTarget initWebTarget() {
        return ClientBuilder.newClient().target("https://api.restful-api.dev");
    }

    @Bean
    public RestClient initRestClient() {
        return RestClient.builder().baseUrl("https://api.restful-api.dev").build();
    }
}
