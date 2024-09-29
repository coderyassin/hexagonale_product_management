package org.alten.product_management.infrastructure.config;

import org.alten.product_management.domain.port.input.AllProductsUseCase;
import org.alten.product_management.domain.port.input.CreateProductUseCase;
import org.alten.product_management.domain.port.input.ProductByIdNotFoundUseCase;
import org.alten.product_management.domain.port.input.ProductByIdUseCase;
import org.alten.product_management.domain.port.output.AllProductsPort;
import org.alten.product_management.domain.port.output.CreateProductPort;
import org.alten.product_management.domain.port.output.ProductByIdPort;
import org.alten.product_management.domain.services.AllProductService;
import org.alten.product_management.domain.services.CreateProductService;
import org.alten.product_management.domain.services.ProductByIdNotFoundService;
import org.alten.product_management.domain.services.ProductByIdService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public AllProductsUseCase allProductsUseCase(AllProductsPort allProductsPort) {
        return new AllProductService(allProductsPort);
    }

    @Bean
    public ProductByIdUseCase productByIdUseCase(ProductByIdPort productByIdPort) {
        return new ProductByIdService(productByIdPort);
    }

    @Bean
    public ProductByIdNotFoundUseCase productByIdNotFoundUseCase() {
        return new ProductByIdNotFoundService();
    }

    @Bean
    public CreateProductUseCase createProductUseCase(CreateProductPort createProductPort) {
        return new CreateProductService(createProductPort);
    }

}
