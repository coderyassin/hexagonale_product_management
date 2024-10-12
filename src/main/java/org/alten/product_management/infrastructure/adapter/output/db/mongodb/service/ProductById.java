package org.alten.product_management.infrastructure.adapter.output.db.mongodb.service;

import org.alten.product_management.domain.model.Product;
import org.alten.product_management.infrastructure.adapter.output.db.mongodb.mapper.ProductMapper;
import org.alten.product_management.infrastructure.adapter.output.db.mongodb.repository.ProductRepository;
import org.alten.product_management.infrastructure.adapter.output.db.service.ProductByIdService;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("ProductByIdFromMongoDB")
public class ProductById implements ProductByIdService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductById(ProductRepository productRepository,
                       ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public Optional<Product> findById(String productId) {
        return productRepository.findById(productId)
                .map(productMapper::fromEntityToDomain);
    }
}
