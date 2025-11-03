package com.ecommerce.product.client.config

import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Configuration

@Configuration
@EnableFeignClients(basePackages = ["com.ecommerce.product.client"])
class FeignConfig {
}