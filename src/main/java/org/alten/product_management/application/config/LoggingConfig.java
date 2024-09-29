package org.alten.product_management.application.config;

import org.alten.product_management.application.tracing.handler.LoggingHandler;
import org.alten.product_management.application.tracing.handler.impl.DefaultLoggingHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggingConfig {
    @Bean
    public LoggingHandler loggingHandler() {
        return new DefaultLoggingHandler();
    }
}
