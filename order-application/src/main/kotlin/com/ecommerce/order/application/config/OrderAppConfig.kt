package com.ecommerce.order.application.config

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackages = ["com.ecommerce.order.application.service"])
class OrderAppConfig {
}