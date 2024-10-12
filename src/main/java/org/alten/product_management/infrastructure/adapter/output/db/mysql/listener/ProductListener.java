package org.alten.product_management.infrastructure.adapter.output.db.mysql.listener;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import org.alten.product_management.infrastructure.adapter.output.db.mysql.entity.ProductEntity;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class ProductListener {
    @PrePersist
    public void prePersist(ProductEntity entity) {
        if (entity.getId() == null || entity.getId().isEmpty()) {
            entity.setId(UUID.randomUUID().toString());
        }

        if(Objects.isNull(entity.getCreatedAt())) {
            entity.setCreatedAt(LocalDateTime.now());
        }
    }

    @PreUpdate
    public void preUpdate(ProductEntity entity) {
        if(Objects.isNull(entity.getUpdatedAt())) {
            entity.setUpdatedAt(LocalDateTime.now());
        }
    }
}
