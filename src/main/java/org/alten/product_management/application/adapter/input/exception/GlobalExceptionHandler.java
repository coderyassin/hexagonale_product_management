package org.alten.product_management.application.adapter.input.exception;

import org.alten.product_management.domain.exception.ErrorMessage;
import org.alten.product_management.domain.exception.ParameterNotFoundException;
import org.alten.product_management.domain.exception.ResourceNotCreatedException;
import org.alten.product_management.domain.exception.ResourceNotFoundException;
import org.alten.product_management.domain.port.input.ProductByIdNotFoundUseCase;
import org.alten.product_management.domain.port.input.ProductNotCreatedUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private final ProductByIdNotFoundUseCase productByIdNotFoundUseCase;
    private final ProductNotCreatedUseCase productNotCreatedUseCase;

    public GlobalExceptionHandler(ProductByIdNotFoundUseCase productByIdNotFoundUseCase,
                                  ProductNotCreatedUseCase productNotCreatedUseCase) {
        this.productByIdNotFoundUseCase = productByIdNotFoundUseCase;
        this.productNotCreatedUseCase = productNotCreatedUseCase;
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        String description = request.getDescription(true);
        ErrorMessage errorMessage = productByIdNotFoundUseCase.productByIdNotFound(ex, description);
        return ResponseEntity.status(NOT_FOUND).body(errorMessage);
    }

    @ExceptionHandler(ResourceNotCreatedException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotCreatedException ex, WebRequest request) {
        String description = request.getDescription(true);
        ErrorMessage errorMessage = productNotCreatedUseCase.productNotCreated(ex, description);
        return ResponseEntity.status(NOT_FOUND).body(errorMessage);
    }

    @ExceptionHandler(ParameterNotFoundException.class)
    public ResponseEntity<?> handleParameterNotFoundException(ParameterNotFoundException ex, WebRequest request) {
        String description = request.getDescription(true);
        ErrorMessage errorMessage = productNotCreatedUseCase.productNotCreated(ex, description);
        return ResponseEntity.status(NOT_FOUND).body(errorMessage);
    }

}
