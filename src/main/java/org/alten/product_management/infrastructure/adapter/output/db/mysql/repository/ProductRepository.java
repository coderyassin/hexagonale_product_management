package org.alten.product_management.infrastructure.adapter.output.db.mysql.repository;

import org.alten.product_management.infrastructure.adapter.output.db.mysql.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {
}
