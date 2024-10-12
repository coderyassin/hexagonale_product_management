package org.alten.product_management.infrastructure.adapter.output.db.business;

import org.alten.product_management.domain.model.Product;
import org.alten.product_management.domain.port.output.CreateProductPort;
import org.alten.product_management.infrastructure.adapter.output.db.service.CreateProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CreateProductAdapter implements CreateProductPort {
    private final CreateProductService createProductService;

    public CreateProductAdapter(@Qualifier("CreateProductFromMySql") CreateProductService createProductService) {
        this.createProductService = createProductService;
    }

    @Override
    public Product createProduct(Product product) {
        return createProductService.createProduct(product);
    }
}
