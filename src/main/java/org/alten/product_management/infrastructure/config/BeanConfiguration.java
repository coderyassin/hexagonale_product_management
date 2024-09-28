package org.alten.product_management.infrastructure.config;

import org.alten.product_management.domain.port.input.CreateProductUseCase;
import org.alten.product_management.domain.port.output.CreateProductPort;
import org.alten.product_management.domain.services.CreateProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    /*@Bean
    public CreateProductPort createProductPort() {
        return null;
    }*/

    @Bean
    public CreateProductUseCase createProductUseCase(CreateProductPort createProductPort) {
        CreateProductService createProductService = new CreateProductService(createProductPort);
        return new CreateProductService(createProductPort);
    }
}
