package org.alten.product_management.infrastructure.adapter.output.db.mysql.service;

import org.alten.product_management.domain.model.Product;
import org.alten.product_management.infrastructure.adapter.output.db.mysql.mapper.ProductMapper;
import org.alten.product_management.infrastructure.adapter.output.db.mysql.repository.ProductRepository;
import org.alten.product_management.infrastructure.adapter.output.db.service.AllProductsService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("AllProductsFromMySql")
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
