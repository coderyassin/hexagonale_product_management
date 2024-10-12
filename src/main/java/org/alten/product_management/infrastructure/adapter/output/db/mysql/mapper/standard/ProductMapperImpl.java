package org.alten.product_management.infrastructure.adapter.output.db.mysql.mapper.standard;

import org.alten.product_management.domain.model.Product;
import org.alten.product_management.infrastructure.adapter.output.db.mysql.entity.ProductEntity;
import org.alten.product_management.infrastructure.adapter.output.db.mysql.mapper.ProductMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component("ProductMapperOfMySql")
public class ProductMapperImpl implements ProductMapper {
    private final ModelMapper modelMapper;

    public ProductMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public Product fromEntityToDomain(ProductEntity productEntity) {
        return modelMapper.map(productEntity, Product.class);
    }

    @Override
    public ProductEntity fromDomainToEntity(Product product) {
        return modelMapper.map(product, ProductEntity.class);
    }
}
