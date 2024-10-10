package org.alten.product_management.infrastructure.adapter.output.db.mysql.business;

import org.alten.product_management.domain.model.Product;
import org.alten.product_management.domain.port.output.ProductByIdPort;
import org.alten.product_management.infrastructure.adapter.output.db.mysql.mapper.ProductMapper;
import org.alten.product_management.infrastructure.adapter.output.db.mysql.repository.ProductRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductByIdAdapter implements ProductByIdPort {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductByIdAdapter(ProductRepository productRepository,
                              ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    @Cacheable(value = "users", key = "#productId")
    public Optional<Product> findById(Long productId) {
        return productRepository.findById(productId)
                .map(productMapper::fromEntityToDomain);
    }
}
