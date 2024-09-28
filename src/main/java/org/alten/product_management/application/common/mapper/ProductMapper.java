package org.alten.product_management.application.common.mapper;

import org.alten.product_management.application.adapter.input.controller.request.CreateProductRequest;
import org.alten.product_management.domain.model.Product;

public interface ProductMapper {
    Product toModel(CreateProductRequest createProductRequest);
}
