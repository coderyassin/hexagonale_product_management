package org.alten.product_management.infrastructure.adapter.output.db.mongodb.mapper;

import org.alten.product_management.domain.model.Product;
import org.alten.product_management.infrastructure.adapter.output.db.mongodb.entity.ProductEntity;

public interface ProductMapper {
    Product fromEntityToDomain(ProductEntity productEntity);
    ProductEntity fromDomainToEntity(Product product);
}
