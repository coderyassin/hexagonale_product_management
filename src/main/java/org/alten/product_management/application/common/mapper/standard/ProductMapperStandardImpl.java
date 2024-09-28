package org.alten.product_management.application.common.mapper.standard;

import org.alten.product_management.application.adapter.input.controller.request.CreateProductRequest;
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
}
