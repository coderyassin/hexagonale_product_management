package org.alten.product_management.infrastructure.adapter.output.db.mysql.repository;

import org.alten.product_management.infrastructure.adapter.output.db.mysql.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ProductRepositoryMySql")
public interface ProductRepository extends JpaRepository<ProductEntity, String> {
}
