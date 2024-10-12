package org.alten.product_management.infrastructure.config.db;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@ConditionalOnProperty(name = "app.database", havingValue = "mongodb")
@EnableMongoRepositories(basePackages = "org.alten.product_management.infrastructure.adapter.output.db.mongodb.repository")
public class MongoDbConfig {
}
