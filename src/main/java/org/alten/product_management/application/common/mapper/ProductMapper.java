package org.alten.product_management.application.common.mapper;

import org.alten.product_management.application.adapter.input.controller.request.CreateProductRequest;
import org.alten.product_management.application.adapter.input.controller.request.UpdateProductRequest;
import org.alten.product_management.application.adapter.input.controller.response.CreateProductResponse;
import org.alten.product_management.application.adapter.input.controller.response.DeleteProductResponse;
import org.alten.product_management.application.adapter.input.controller.response.UpdateProductResponse;
import org.alten.product_management.domain.model.Product;

public interface ProductMapper {
    Product toModel(CreateProductRequest createProductRequest);

    Product toModel(UpdateProductRequest updateProductRequest);

    CreateProductResponse toCreateProductResponse(Product product);

    UpdateProductResponse toUpdateProductResponse(Product product);

    DeleteProductResponse toDeleteProductResponse(Product product);
}
