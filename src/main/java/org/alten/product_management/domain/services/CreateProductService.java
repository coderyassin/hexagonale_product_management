package org.alten.product_management.domain.services;

import org.alten.product_management.domain.exception.ParameterNotFoundException;
import org.alten.product_management.domain.model.Product;
import org.alten.product_management.domain.port.input.CreateProductUseCase;
import org.alten.product_management.domain.port.output.CreateProductPort;
import org.springframework.util.StringUtils;

import static org.alten.product_management.domain.constant.ProductConstant.IS_NOT_PRESENT;
import static org.alten.product_management.domain.constant.ProductConstant.REQUIRED_PARAMETER;

public class CreateProductService implements CreateProductUseCase {
    private final CreateProductPort createProductPort;

    public CreateProductService(CreateProductPort createProductPort) {
        this.createProductPort = createProductPort;
    }


    @Override
    public Product createProduct(Product product) {
        checkProductValidity(product);
        return createProductPort.createProduct(product);
    }

    private void checkProductValidity(Product product) {
        if(!StringUtils.hasText(product.getName())) {
            getMessageParameterNotFoundException("name");
        }

        if(!StringUtils.hasText(product.getDescription())) {
            getMessageParameterNotFoundException("description");
        }

        if(!StringUtils.hasText(product.getCategory())) {
            getMessageParameterNotFoundException("category");
        }
    }

    private void getMessageParameterNotFoundException(String parameter) throws ParameterNotFoundException {
        throw new ParameterNotFoundException(REQUIRED_PARAMETER + "\"" + parameter + "\"" + IS_NOT_PRESENT);
    }
}
