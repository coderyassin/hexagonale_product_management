package org.alten.product_management.infrastructure.adapter.output.db.mysql.mapper;

import org.alten.product_management.domain.model.Product;
import org.alten.product_management.infrastructure.adapter.output.db.mysql.entity.ProductEntity;

public interface ProductMapper {
    Product fromEntityToDomain(ProductEntity productEntity);
    ProductEntity fromDomainToEntity(Product product);
}
