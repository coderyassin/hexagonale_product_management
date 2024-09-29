package org.alten.product_management.application.common.mapper.standard;

import org.alten.product_management.application.adapter.input.controller.request.CreateProductRequest;
import org.alten.product_management.application.adapter.input.controller.response.CreateProductResponse;
import org.alten.product_management.application.adapter.input.controller.response.DeleteProductResponse;
import org.alten.product_management.application.common.mapper.ProductMapper;
import org.alten.product_management.domain.model.Product;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductMapperStandardImpl implements ProductMapper {
    private final ModelMapper modelMapper;

    public ProductMapperStandardImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public Product toModel(CreateProductRequest createProductRequest) {
        return modelMapper.map(createProductRequest, Product.class);
    }

    @Override
    public CreateProductResponse toCreateProductResponse(Product product) {
        return modelMapper.map(product, CreateProductResponse.class);
    }

    @Override
    public DeleteProductResponse toDeleteProductResponse(Product product) {
        return modelMapper.map(product, DeleteProductResponse.class);
    }
}
