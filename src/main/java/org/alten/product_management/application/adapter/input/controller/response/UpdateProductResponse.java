package org.alten.product_management.application.adapter.input.controller.response;

import lombok.*;
import org.alten.product_management.domain.enums.InventoryStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UpdateProductResponse {
    private String code;

    private String name;

    private String description;

    private String image;

    private String category;

    private Double price;

    private Integer quantity;

    private String internalReference;

    private Long shellId;

    private InventoryStatus inventoryStatus;

    private Double rating;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
