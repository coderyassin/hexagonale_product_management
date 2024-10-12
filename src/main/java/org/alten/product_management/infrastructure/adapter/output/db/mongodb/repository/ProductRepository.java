package org.alten.product_management.infrastructure.adapter.output.db.mongodb.repository;

import org.alten.product_management.infrastructure.adapter.output.db.mongodb.entity.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<ProductEntity, String> {
}
