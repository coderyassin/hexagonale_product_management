package org.alten.product_management.infrastructure.adapter.output.db.business;

import org.alten.product_management.domain.model.Product;
import org.alten.product_management.domain.port.output.ProductByIdPort;
import org.alten.product_management.infrastructure.adapter.output.db.service.ProductByIdService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductByIdAdapter implements ProductByIdPort {
    private final ProductByIdService productByIdService;

    public ProductByIdAdapter(ProductByIdService productByIdService) {
        this.productByIdService = productByIdService;
    }

    @Override
    @Cacheable(value = "users", key = "#productId")
    public Optional<Product> findById(String productId) {
        return productByIdService.findById(productId);
    }
}
