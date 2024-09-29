package org.alten.product_management.domain.services;

import org.alten.product_management.domain.exception.ParameterNotFoundException;
import org.alten.product_management.domain.model.Product;
import org.alten.product_management.domain.port.input.AllProductsUseCase;
import org.alten.product_management.domain.port.output.AllProductsPort;
import org.springframework.util.StringUtils;

import java.util.List;

import static org.alten.product_management.domain.constant.ProductConstant.IS_NOT_PRESENT;
import static org.alten.product_management.domain.constant.ProductConstant.REQUIRED_PARAMETER;

public class AllProductsService implements AllProductsUseCase {
    private final AllProductsPort allProductsPort;

    public AllProductsService(AllProductsPort allProductsPort) {
        this.allProductsPort = allProductsPort;
    }


    @Override
    public List<Product> allProducts() {
        return allProductsPort.allProducts();
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
