package org.alten.product_management.infrastructure.adapter.output.db.service;

import org.alten.product_management.domain.model.Product;

import java.util.List;

public interface AllProductsService {
    List<Product> allProducts();
}
