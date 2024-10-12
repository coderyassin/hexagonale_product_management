package org.alten.product_management.infrastructure.adapter.output.db.service;

import org.alten.product_management.domain.model.Product;

import java.util.Optional;

public interface ProductByIdService {
    Optional<Product> findById(String productId);
}
