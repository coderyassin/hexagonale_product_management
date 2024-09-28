package org.alten.product_management.application.adapter.input.controller.request;

import lombok.*;
import org.alten.product_management.domain.enums.InventoryStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CreateProductRequest {
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
}
