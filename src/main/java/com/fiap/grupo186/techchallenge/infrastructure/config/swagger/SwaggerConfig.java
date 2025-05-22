package com.fiap.grupo186.techchallenge.infrastructure.config.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Tech Challenge FIAP")
                        .version("1.0")
                        .description("This API provides a comprehensive solution for managing a cafeteria system." +
                                " It provides endpoints for registering products, " +
                                "creating orders and tracking orders.")
                );
    }
}
