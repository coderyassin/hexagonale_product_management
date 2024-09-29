package org.alten.product_management.domain.services;

import org.alten.product_management.domain.exception.ErrorMessage;
import org.alten.product_management.domain.exception.ParameterNotFoundException;
import org.alten.product_management.domain.exception.ResourceNotCreatedException;
import org.alten.product_management.domain.port.input.ProductNotCreatedUseCase;

import java.time.LocalDateTime;

public class ProductNotCreatedService implements ProductNotCreatedUseCase {
    @Override
    public ErrorMessage productNotCreated(ResourceNotCreatedException ex, String description) {
        return buildErrorMessage(ex, description);
    }

    @Override
    public ErrorMessage productNotCreated(ParameterNotFoundException ex, String description) {
        return buildErrorMessage(ex, description);
    }

    private ErrorMessage buildErrorMessage(Exception ex, String description) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setHttpStatusCode(400);
        errorMessage.setTimestamp(LocalDateTime.now());
        errorMessage.setMessage(ex.getMessage());
        errorMessage.setDescription(description);
        return errorMessage;
    }
}
