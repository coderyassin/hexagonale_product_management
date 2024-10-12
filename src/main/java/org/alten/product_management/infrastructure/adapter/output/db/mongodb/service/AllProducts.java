package org.alten.product_management.infrastructure.adapter.output.db.mongodb.service;

import org.alten.product_management.domain.model.Product;
import org.alten.product_management.infrastructure.adapter.output.db.mongodb.mapper.ProductMapper;
import org.alten.product_management.infrastructure.adapter.output.db.mongodb.repository.ProductRepository;
import org.alten.product_management.infrastructure.adapter.output.db.service.AllProductsService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("AllProductsFromMongoDB")
public class AllProducts implements AllProductsService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public AllProducts(ProductRepository productRepository,
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
