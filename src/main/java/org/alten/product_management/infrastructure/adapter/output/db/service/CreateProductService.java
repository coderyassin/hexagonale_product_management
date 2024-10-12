package org.alten.product_management.infrastructure.adapter.output.db.service;

import org.alten.product_management.domain.model.Product;

public interface CreateProductService {
    Product createProduct(Product product);
}
