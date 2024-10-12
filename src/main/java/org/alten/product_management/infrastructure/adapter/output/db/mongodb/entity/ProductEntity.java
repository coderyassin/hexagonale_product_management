package org.alten.product_management.infrastructure.adapter.output.db.mongodb.entity;

import lombok.*;
import org.alten.product_management.domain.enums.InventoryStatus;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Document(collection = "products")
public class ProductEntity extends AbstractEntity {

    private String code;
    private String name;
    private String description;
    private String image;
    private String category;
    private Double price;
    private Integer quantity;

    @Field("internal_reference")
    private String internalReference;

    @Field("shell_id")
    private Long shellId;

    @Field("inventory_status")
    private InventoryStatus inventoryStatus;

    private Double rating;
}
