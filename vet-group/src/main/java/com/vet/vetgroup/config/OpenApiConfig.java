package com.vet.vetgroup.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("REST VET-API")
                        .version("v2")
                        .description("API for VET dashboard")
                        .termsOfService("https://github.com/eliseubrito7z")
                        .license(
                                new License()
                                .name("Apache 2.0")
                                .url("https://github.com/eliseubrito7z")));
    }
}
