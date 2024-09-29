package org.alten.product_management.domain.services;

import org.alten.product_management.domain.exception.ErrorMessage;
import org.alten.product_management.domain.exception.ResourceNotFoundException;
import org.alten.product_management.domain.port.input.ProductByIdNotFoundUseCase;

import java.time.LocalDateTime;

public class ProductByIdNotFoundService implements ProductByIdNotFoundUseCase {

    @Override
    public ErrorMessage productByIdNotFound(ResourceNotFoundException ex, String description) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setHttpStatusCode(404);
        errorMessage.setTimestamp(LocalDateTime.now());
        errorMessage.setMessage(ex.getMessage());
        errorMessage.setDescription(description);
        return errorMessage;
    }
}
