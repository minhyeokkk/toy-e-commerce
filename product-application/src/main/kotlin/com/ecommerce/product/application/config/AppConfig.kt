package com.ecommerce.product.application.config

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackages = ["com.ecommerce.product.application.service"])
class AppConfig {
}