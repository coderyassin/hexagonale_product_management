package org.alten.product_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(
		basePackages = "org.alten.product_management",
		excludeFilters = @ComponentScan.Filter(
				type = FilterType.REGEX, pattern = "org.alten.product_management.infrastructure.adapter.output.db.mysql.*"
		)
)
@EnableCaching
public class ProductManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductManagementApplication.class, args);
	}

}
