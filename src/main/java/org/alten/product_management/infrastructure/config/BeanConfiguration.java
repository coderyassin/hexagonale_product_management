package org.alten.product_management.infrastructure.config;

import org.alten.product_management.domain.port.input.*;
import org.alten.product_management.domain.port.output.*;
import org.alten.product_management.domain.services.*;
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

    @Bean
    public ProductNotCreatedUseCase productNotCreatedUseCase() {
        return new ProductNotCreatedService();
    }

    @Bean
    public UpdateProductUseCase updateProductUseCase(UpdateProductPort updateProductPort) {
        return new UpdateProductService(updateProductPort);
    }

    @Bean DeleteProductUseCase deleteProductUseCase(DeleteProductPort deleteProductPort) {
        return new DeleteProductService(deleteProductPort);
    }

}
