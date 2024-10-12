package org.alten.product_management.infrastructure.adapter.output.db.mysql.service;

import org.alten.product_management.domain.model.Product;
import org.alten.product_management.infrastructure.adapter.output.db.mysql.entity.ProductEntity;
import org.alten.product_management.infrastructure.adapter.output.db.mysql.mapper.ProductMapper;
import org.alten.product_management.infrastructure.adapter.output.db.mysql.repository.ProductRepository;
import org.alten.product_management.infrastructure.adapter.output.db.service.CreateProductService;
import org.springframework.stereotype.Component;

@Component("CreateProductFromMySql")
public class CreateProduct implements CreateProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public CreateProduct(ProductRepository productRepository,
                         ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public Product createProduct(Product product) {
        ProductEntity productEntity = productMapper.fromDomainToEntity(product);
        ProductEntity productEntitySaved = productRepository.save(productEntity);
        return productMapper.fromEntityToDomain(productEntitySaved);
    }
}
