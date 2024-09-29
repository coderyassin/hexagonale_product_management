package org.alten.product_management.domain.port.input;

import org.alten.product_management.domain.exception.ErrorMessage;
import org.alten.product_management.domain.exception.ResourceNotFoundException;

public interface ProductByIdNotFoundUseCase {
    ErrorMessage productByIdNotFound(ResourceNotFoundException ex, String description);
}
