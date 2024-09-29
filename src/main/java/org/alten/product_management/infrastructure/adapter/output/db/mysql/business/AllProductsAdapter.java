package org.alten.product_management.infrastructure.adapter.output.db.mysql.business;

import org.alten.product_management.domain.model.Product;
import org.alten.product_management.domain.port.output.AllProductsPort;
import org.alten.product_management.infrastructure.adapter.output.db.mysql.mapper.ProductMapper;
import org.alten.product_management.infrastructure.adapter.output.db.mysql.repository.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AllProductsAdapter implements AllProductsPort {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public AllProductsAdapter(ProductRepository productRepository,
                              ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<Product> allProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::fromEntityToDomain)
                .toList();
    }
}
