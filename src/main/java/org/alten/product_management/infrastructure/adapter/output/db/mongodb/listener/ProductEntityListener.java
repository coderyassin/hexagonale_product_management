package org.alten.product_management.infrastructure.adapter.output.db.mongodb.listener;

import lombok.extern.slf4j.Slf4j;
import org.alten.product_management.infrastructure.adapter.output.db.mongodb.entity.ProductEntity;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveEvent;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Component
@Slf4j
public class ProductEntityListener extends AbstractMongoEventListener<ProductEntity> {

    public void onBeforeConvert(BeforeConvertEvent<ProductEntity> event) {
        ProductEntity product = event.getSource();

        if (Objects.isNull(product.getId()) || product.getId().equals("0")) {
           product.setId(UUID.randomUUID().toString());
        }

        if (Objects.isNull(product.getCreatedAt())) {
            product.setCreatedAt(LocalDateTime.now());
        }
        product.setUpdatedAt(LocalDateTime.now());
    }

    public void onAfterSave(AfterSaveEvent<ProductEntity> event) {
        ProductEntity product = event.getSource();
        log.info("AfterSave - Product saved: {}", product);
    }

}
