package org.alten.product_management.infrastructure.config.db;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ConditionalOnProperty(name = "app.database", havingValue = "mysql")
@EnableJpaRepositories(basePackages = "org.alten.product_management.infrastructure.adapter.output.db.mysql.repository")
public class MySqlConfig {
}
