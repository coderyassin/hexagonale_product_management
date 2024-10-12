package org.alten.product_management.infrastructure.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "org.alten.product_management",
        excludeFilters = @ComponentScan.Filter(
                type = FilterType.REGEX, pattern = "org.alten.product_management.infrastructure.adapter.output.db.mysql.*"
        )
)
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
